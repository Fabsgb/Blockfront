package foundry.veil.mixin.shader.client;

import com.mojang.blaze3d.shaders.Program;
import com.mojang.blaze3d.shaders.Shader;
import com.mojang.blaze3d.shaders.Uniform;
import foundry.veil.Veil;
import foundry.veil.api.client.render.shader.program.ShaderUniformCache;
import foundry.veil.impl.client.render.shader.processor.VanillaShaderProcessor;
import foundry.veil.impl.client.render.shader.program.ShaderProgramImpl;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.List;
import java.util.Map;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.lwjgl.opengl.GL20C;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/shader/client/ShaderInstanceMixin.class */
@Mixin(value = {ShaderInstance.class}, priority = 800)
public abstract class ShaderInstanceMixin implements Shader {

    @Shadow
    @Final
    private int programId;

    @Shadow
    @Final
    private List<Integer> uniformLocations;

    @Shadow
    @Final
    public Map<String, Uniform> uniformMap;

    @Shadow
    @Final
    private String name;

    @Shadow
    @Final
    private List<String> samplerNames;

    @Shadow
    @Final
    private List<Integer> samplerLocations;

    @Unique
    private final Map<String, Uniform> veil$uniforms = new Object2ObjectArrayMap();

    @Inject(method = {"getOrCreate"}, at = {@At("HEAD")}, cancellable = true)
    private static void veil$cancelDummyProgram(ResourceProvider provider, Program.Type type, String name, CallbackInfoReturnable<Program> cir) {
        if (ShaderProgramImpl.Wrapper.constructingProgram != null) {
            cir.setReturnValue(new ShaderProgramImpl.ShaderWrapper(type, ShaderProgramImpl.Wrapper.constructingProgram));
        }
    }

    @Inject(method = {"getOrCreate"}, at = {@At("HEAD")})
    private static void veil$setupFallbackProcessor(ResourceProvider provider, Program.Type type, String name, CallbackInfoReturnable<Program> cir) {
        if (Veil.platform().hasErrors()) {
            return;
        }
        VanillaShaderProcessor.setup(provider);
    }

    @Inject(method = {"getOrCreate"}, at = {@At("RETURN")})
    private static void veil$clearFallbackProcessor(CallbackInfoReturnable<Program> cir) {
        if (Veil.platform().hasErrors()) {
            return;
        }
        VanillaShaderProcessor.free();
    }

    @Inject(method = {"close"}, at = {@At("HEAD")})
    public void close(CallbackInfo ci) {
        if (this.veil$uniforms.isEmpty()) {
            return;
        }
        for (Uniform uniform : this.veil$uniforms.values()) {
            uniform.close();
        }
    }

    @Inject(method = {"apply"}, at = {@At("TAIL")})
    public void apply(CallbackInfo ci) {
        if (this.veil$uniforms.isEmpty()) {
            return;
        }
        for (Uniform uniform : this.veil$uniforms.values()) {
            uniform.upload();
        }
    }

    @Inject(method = {"updateLocations"}, at = {@At("HEAD")})
    public void clearSamplerLocations(CallbackInfo ci) {
        this.samplerLocations.clear();
    }

    @Inject(method = {"updateLocations"}, at = {@At("TAIL")})
    public void updateLocations(CallbackInfo ci) {
        int minecraftType;
        int minecraftCount;
        Uniform uniform;
        if (this instanceof ShaderProgramImpl.Wrapper) {
            return;
        }
        for (Uniform uniform2 : this.veil$uniforms.values()) {
            uniform2.setLocation(-1);
        }
        int uniformCount = GL20C.glGetProgrami(this.programId, 35718);
        int maxUniformLength = GL20C.glGetProgrami(this.programId, 35719);
        MemoryStack stack = MemoryStack.stackPush();
        try {
            IntBuffer size = stack.mallocInt(1);
            IntBuffer type = stack.mallocInt(1);
            for (int i = 0; i < uniformCount; i++) {
                String name = GL20C.glGetActiveUniform(this.programId, i, maxUniformLength, size, type);
                int length = size.get(0);
                if (length > 1) {
                    name = name.substring(0, name.length() - 3);
                }
                if (!this.uniformMap.containsKey(name) && !this.samplerNames.contains(name)) {
                    int dataType = type.get(0);
                    String typeName = ShaderUniformCache.getName(dataType);
                    if (ShaderUniformCache.isSampler(dataType)) {
                        for (int j = 0; j < length; j++) {
                            String samplerName = length > 1 ? name + "[" + j + "]" : name;
                            Veil.LOGGER.debug("Shader {} detected sampler: {}", this.name, typeName + " " + samplerName);
                            this.samplerNames.add(samplerName);
                            this.samplerLocations.add(Integer.valueOf(Uniform.glGetUniformLocation(this.programId, samplerName)));
                        }
                    } else {
                        switch (dataType) {
                            case 5124:
                                minecraftType = 0;
                                minecraftCount = 1;
                                break;
                            case 5126:
                                minecraftType = 4;
                                minecraftCount = 1;
                                break;
                            case 35664:
                                minecraftType = 5;
                                minecraftCount = 2;
                                break;
                            case 35665:
                                minecraftType = 6;
                                minecraftCount = 3;
                                break;
                            case 35666:
                                minecraftType = 7;
                                minecraftCount = 4;
                                break;
                            case 35667:
                                minecraftType = 1;
                                minecraftCount = 2;
                                break;
                            case 35668:
                                minecraftType = 2;
                                minecraftCount = 3;
                                break;
                            case 35669:
                                minecraftType = 3;
                                minecraftCount = 4;
                                break;
                            case 35674:
                                minecraftType = 8;
                                minecraftCount = 4;
                                break;
                            case 35675:
                                minecraftType = 9;
                                minecraftCount = 9;
                                break;
                            case 35676:
                                minecraftType = 10;
                                minecraftCount = 16;
                                break;
                            default:
                                Veil.LOGGER.error("Unsupported Uniform Type: {}", typeName);
                                continue;
                        }
                        for (int j2 = 0; j2 < length; j2++) {
                            String uniformName = length > 1 ? name + "[" + j2 + "]" : name;
                            int location = Uniform.glGetUniformLocation(this.programId, uniformName);
                            if (location == -1) {
                                if (length == 1) {
                                    Veil.LOGGER.warn("Shader {} could not find uniform named {} in the specified shader program.", this.name, uniformName);
                                }
                                Uniform old = this.veil$uniforms.remove(uniformName);
                                if (old != null) {
                                    old.close();
                                }
                            } else {
                                Veil.LOGGER.debug("Shader {} detected uniform: {}", this.name, typeName + " " + uniformName);
                                Uniform old2 = this.veil$uniforms.get(uniformName);
                                if (old2 != null) {
                                    if (old2.getType() != minecraftType) {
                                        old2.close();
                                        Map<String, Uniform> map = this.veil$uniforms;
                                        Uniform uniform3 = new Uniform(uniformName, minecraftType, minecraftCount, this);
                                        uniform = uniform3;
                                        map.put(uniformName, uniform3);
                                    } else {
                                        uniform = old2;
                                    }
                                } else {
                                    Map<String, Uniform> map2 = this.veil$uniforms;
                                    Uniform uniform4 = new Uniform(uniformName, minecraftType, minecraftCount, this);
                                    uniform = uniform4;
                                    map2.put(uniformName, uniform4);
                                }
                                IntBuffer intBuffer = uniform.getIntBuffer();
                                if (intBuffer != null) {
                                    MemoryUtil.memSet(intBuffer, 0);
                                }
                                FloatBuffer floatBuffer = uniform.getFloatBuffer();
                                if (floatBuffer != null) {
                                    MemoryUtil.memSet(floatBuffer, Float.floatToIntBits(0.0f));
                                }
                                this.uniformLocations.add(Integer.valueOf(location));
                                uniform.setLocation(location);
                                this.uniformMap.put(uniformName, uniform);
                            }
                        }
                    }
                }
            }
            if (stack != null) {
                stack.close();
            }
            this.veil$uniforms.values().removeIf(uniform5 -> {
                return uniform5.getLocation() == -1;
            });
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
