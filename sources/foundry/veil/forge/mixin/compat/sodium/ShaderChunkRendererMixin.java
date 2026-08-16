package foundry.veil.forge.mixin.compat.sodium;

import com.google.common.base.Stopwatch;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.datafixers.util.Pair;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.ext.sodium.ChunkShaderOptionsExtension;
import foundry.veil.forge.ext.ShaderChunkRendererExtension;
import foundry.veil.impl.ThreadTaskScheduler;
import foundry.veil.impl.client.render.shader.processor.SodiumShaderProcessor;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import net.caffeinemc.mods.sodium.client.gl.shader.GlProgram;
import net.caffeinemc.mods.sodium.client.gl.shader.GlShader;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderConstants;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderLoader;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderParser;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderType;
import net.caffeinemc.mods.sodium.client.render.chunk.ShaderChunkRenderer;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderInterface;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderOptions;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/compat/sodium/ShaderChunkRendererMixin.class */
@Mixin({ShaderChunkRenderer.class})
public abstract class ShaderChunkRendererMixin implements ShaderChunkRendererExtension {

    @Shadow(remap = false)
    @Final
    private Map<ChunkShaderOptions, GlProgram<ChunkShaderInterface>> programs;

    @Unique
    private ThreadTaskScheduler veil$scheduler;

    @Unique
    private Map<ShaderType, ShaderParser.ParsedShader> veil$shaderSource;

    @Unique
    private int veil$activeBuffers;

    @Unique
    private static final Map<ShaderType, ResourceLocation> SHADERS = Map.of(ShaderType.VERTEX, ResourceLocation.fromNamespaceAndPath("sodium", "blocks/block_layer_opaque.vsh"), ShaderType.FRAGMENT, ResourceLocation.fromNamespaceAndPath("sodium", "blocks/block_layer_opaque.fsh"));

    @Shadow(remap = false)
    protected abstract GlProgram<ChunkShaderInterface> createShader(String str, ChunkShaderOptions chunkShaderOptions);

    @Shadow
    private static ShaderConstants createShaderConstants(ChunkShaderOptions options) {
        throw new UnsupportedOperationException("Implemented via mixin");
    }

    @Inject(method = {"delete"}, at = {@At("HEAD")}, remap = false)
    public void delete(CallbackInfo ci) {
        if (this.veil$scheduler != null) {
            this.veil$scheduler.cancel();
        }
        this.veil$activeBuffers = 0;
    }

    @Inject(method = {"compileProgram"}, at = {@At("HEAD")}, remap = false)
    public void updateActiveProgram(ChunkShaderOptions options, CallbackInfoReturnable<GlProgram<ChunkShaderInterface>> cir) {
        ((ChunkShaderOptionsExtension) options).veil$setActiveBuffers(this.veil$activeBuffers);
    }

    @WrapOperation(method = {"createShader"}, at = {@At(value = "INVOKE", target = "Lnet/caffeinemc/mods/sodium/client/gl/shader/ShaderLoader;loadShader(Lnet/caffeinemc/mods/sodium/client/gl/shader/ShaderType;Lnet/minecraft/resources/ResourceLocation;Lnet/caffeinemc/mods/sodium/client/gl/shader/ShaderConstants;)Lnet/caffeinemc/mods/sodium/client/gl/shader/GlShader;", remap = true)}, require = 2, remap = false)
    private GlShader createShader(ShaderType type, ResourceLocation name, ShaderConstants constants, Operation<GlShader> original) {
        ShaderParser.ParsedShader source;
        if (this.veil$shaderSource != null && (source = this.veil$shaderSource.get(type)) != null) {
            return new GlShader(type, name, source);
        }
        return (GlShader) original.call(new Object[]{type, name, constants});
    }

    @Unique
    private void recompile(Queue<Pair<ChunkShaderOptions, ShaderConstants>> keys, int activeBuffers) {
        if (this.veil$scheduler != null) {
            this.veil$scheduler.cancel();
        }
        int shaderCount = keys.size();
        Stopwatch stopwatch = Stopwatch.createStarted();
        GLCapabilities glCapabilities = GL.getCapabilities();
        this.veil$scheduler = new ThreadTaskScheduler("VeilSodiumShaderCompile", 1, () -> {
            Pair<ChunkShaderOptions, ShaderConstants> pair = (Pair) keys.poll();
            if (pair == null) {
                return null;
            }
            return () -> {
                Object2ObjectArrayMap object2ObjectArrayMap = new Object2ObjectArrayMap();
                for (Map.Entry<ShaderType, ResourceLocation> entry : SHADERS.entrySet()) {
                    ShaderType type = entry.getKey();
                    SodiumShaderProcessor.setShaderType(type.id, entry.getValue(), glCapabilities);
                    ShaderParser.ParsedShader src = ShaderParser.parseShader(ShaderLoader.getShaderSource(entry.getValue()), (ShaderConstants) pair.getSecond());
                    object2ObjectArrayMap.put(type, src);
                }
                Minecraft.getInstance().execute(() -> {
                    this.veil$shaderSource = object2ObjectArrayMap;
                    GlProgram<ChunkShaderInterface> old = this.programs.put((ChunkShaderOptions) pair.getFirst(), createShader("blocks/block_layer_opaque", (ChunkShaderOptions) pair.getFirst()));
                    if (old != null) {
                        old.delete();
                    }
                    this.veil$shaderSource = null;
                });
            };
        });
        this.veil$scheduler.getCompletedFuture().thenRunAsync(() -> {
            this.veil$shaderSource = null;
            this.veil$activeBuffers = activeBuffers;
            if (!this.veil$scheduler.isCancelled()) {
                Veil.LOGGER.info("Compiled {} Sodium Shaders in {}", Integer.valueOf(shaderCount), stopwatch.stop());
            }
        }, VeilRenderSystem.renderThreadExecutor());
    }

    @Unique
    private Queue<Pair<ChunkShaderOptions, ShaderConstants>> getActiveKeys(int activeBuffers) {
        Queue<Pair<ChunkShaderOptions, ShaderConstants>> keys = new ConcurrentLinkedDeque<>();
        for (ChunkShaderOptions key : this.programs.keySet()) {
            boolean unique = true;
            for (Pair<ChunkShaderOptions, ShaderConstants> pair : keys) {
                ChunkShaderOptions options = (ChunkShaderOptions) pair.getFirst();
                if (options.fog() == key.fog() && options.pass() == key.pass() && options.vertexType() == key.vertexType()) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                ChunkShaderOptionsExtension chunkShaderOptions = new ChunkShaderOptions(key.fog(), key.pass(), key.vertexType());
                chunkShaderOptions.veil$setActiveBuffers(activeBuffers);
                keys.add(Pair.of(chunkShaderOptions, createShaderConstants(chunkShaderOptions)));
            }
        }
        return keys;
    }

    @Override // foundry.veil.forge.ext.ShaderChunkRendererExtension
    public void veil$recompile() {
        recompile(getActiveKeys(this.veil$activeBuffers), this.veil$activeBuffers);
    }

    @Override // foundry.veil.forge.ext.ShaderChunkRendererExtension
    public void veil$setActiveBuffers(int activeBuffers) {
        if (this.veil$activeBuffers == activeBuffers) {
            return;
        }
        if (this.veil$scheduler != null) {
            this.veil$scheduler.cancel();
        }
        Queue<Pair<ChunkShaderOptions, ShaderConstants>> keys = getActiveKeys(activeBuffers);
        keys.removeIf(pair -> {
            return this.programs.containsKey(pair.getFirst());
        });
        if (keys.isEmpty()) {
            return;
        }
        recompile(keys, activeBuffers);
    }

    @Override // foundry.veil.forge.ext.ShaderChunkRendererExtension
    public Map<ChunkShaderOptions, GlProgram<ChunkShaderInterface>> veil$getPrograms() {
        return this.programs;
    }
}
