package foundry.veil.mixin.dynamicbuffer.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.shaders.Program;
import com.mojang.blaze3d.shaders.Shader;
import com.mojang.blaze3d.shaders.Uniform;
import com.mojang.blaze3d.vertex.VertexFormat;
import foundry.veil.Veil;
import foundry.veil.api.client.render.ext.VeilDebug;
import foundry.veil.ext.ShaderInstanceExtension;
import foundry.veil.impl.client.render.dynamicbuffer.VanillaShaderCompiler;
import foundry.veil.impl.client.render.shader.program.ShaderProgramImpl;
import foundry.veil.mixin.dynamicbuffer.accessor.DynamicBufferProgramAccessor;
import it.unimi.dsi.fastutil.ints.Int2IntArrayMap;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.IntIterator;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.opengl.GL20C;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/dynamicbuffer/client/DynamicBufferShaderInstanceMixin.class */
@Mixin({ShaderInstance.class})
public abstract class DynamicBufferShaderInstanceMixin implements Shader, ShaderInstanceExtension {

    @Mutable
    @Shadow
    @Final
    private Program vertexProgram;

    @Mutable
    @Shadow
    @Final
    private Program fragmentProgram;

    @Mutable
    @Shadow
    @Final
    private int programId;

    @Shadow
    @Final
    private VertexFormat vertexFormat;

    @Shadow
    @Final
    public Map<String, Uniform> uniformMap;

    @Shadow
    @Final
    private List<Integer> uniformLocations;

    @Shadow
    @Final
    private List<Integer> samplerLocations;

    @Shadow
    @Final
    private String name;

    @Shadow
    @Final
    private List<Uniform> uniforms;

    @Unique
    private String veil$vertexSource;

    @Unique
    private String veil$fragmentSource;

    @Unique
    private int veil$activeBuffers;

    @Unique
    private final Int2IntMap veil$programCache = new Int2IntArrayMap(1);

    @Shadow
    protected abstract void updateLocations();

    @Shadow
    public abstract void attachToProgram();

    @Inject(method = {"<init>"}, at = {@At("TAIL")})
    public void init(CallbackInfo ci) {
        this.veil$programCache.put(0, this.programId);
        if (this instanceof ShaderProgramImpl.Wrapper) {
            return;
        }
        VeilDebug debug = VeilDebug.get();
        debug.objectLabel(33506, this.programId, "Vanilla Shader Program " + this.name + ":default");
        debug.objectLabel(33505, this.vertexProgram.getId(), "Vanilla vertex Shader " + this.vertexProgram.getName() + ":default");
        debug.objectLabel(33505, this.fragmentProgram.getId(), "Vanilla fragment Shader " + this.fragmentProgram.getName() + ":default");
    }

    @Inject(method = {"apply"}, at = {@At("HEAD")})
    public void apply(CallbackInfo ci) {
        if (Veil.platform().hasErrors()) {
            return;
        }
        VanillaShaderCompiler.markRendered(this.name);
        veil$applyCompile();
    }

    @Inject(method = {"close"}, at = {@At("HEAD")})
    public void close(CallbackInfo ci) {
        if (this.veil$programCache.isEmpty()) {
            return;
        }
        this.programId = this.veil$programCache.remove(0);
        IntIterator it = this.veil$programCache.values().iterator();
        while (it.hasNext()) {
            int program = ((Integer) it.next()).intValue();
            GL20C.glDeleteProgram(program);
        }
        this.veil$programCache.clear();
    }

    @Override // foundry.veil.ext.ShaderInstanceExtension
    public boolean veil$isRecompileReady(int activeBuffers) {
        return !(this.veil$vertexSource == null || this.veil$fragmentSource == null) || this.veil$activeBuffers == activeBuffers;
    }

    @Override // foundry.veil.ext.ShaderInstanceExtension
    public boolean veil$applyCompile() {
        if (this.veil$vertexSource == null || this.veil$fragmentSource == null) {
            return false;
        }
        int oldProgram = this.programId;
        this.programId = GL20C.glCreateProgram();
        int vertexShader = GL20C.glCreateShader(35633);
        int fragmentShader = GL20C.glCreateShader(35632);
        try {
            try {
                GlStateManager.glShaderSource(vertexShader, List.of(this.veil$vertexSource));
                GL20C.glCompileShader(vertexShader);
            } catch (Throwable t) {
                this.veil$programCache.remove(this.veil$activeBuffers);
                GL20C.glDeleteProgram(this.programId);
                this.programId = oldProgram;
                Veil.LOGGER.error("Failed to recompile vanilla shader: {}", this.name, t);
                GL20C.glDeleteShader(vertexShader);
                GL20C.glDeleteShader(fragmentShader);
            }
            if (GL20C.glGetShaderi(vertexShader, 35713) != 1) {
                String error = GL20C.glGetShaderInfoLog(vertexShader).trim();
                throw new IOException("Couldn't compile dynamic vertex program (" + this.vertexProgram.getName() + ", " + this.name + ") : " + error);
            }
            GlStateManager.glShaderSource(fragmentShader, List.of(this.veil$fragmentSource));
            GL20C.glCompileShader(fragmentShader);
            if (GL20C.glGetShaderi(fragmentShader, 35713) != 1) {
                String error2 = GL20C.glGetShaderInfoLog(fragmentShader).trim();
                throw new IOException("Couldn't compile dynamic fragment program (" + this.fragmentProgram.getName() + ", " + this.name + ") : " + error2);
            }
            int index = 0;
            for (String name : this.vertexFormat.getElementAttributeNames()) {
                GL20C.glBindAttribLocation(this.programId, index, name);
                index++;
            }
            DynamicBufferProgramAccessor vertexAccessor = this.vertexProgram;
            DynamicBufferProgramAccessor fragmentAccessor = this.fragmentProgram;
            int oldVertex = vertexAccessor.getId();
            int oldFragment = fragmentAccessor.getId();
            vertexAccessor.setId(vertexShader);
            fragmentAccessor.setId(fragmentShader);
            attachToProgram();
            vertexAccessor.setId(oldVertex);
            fragmentAccessor.setId(oldFragment);
            GL20C.glLinkProgram(this.programId);
            if (GL20C.glGetProgrami(this.programId, 35714) != 1) {
                String error3 = GL20C.glGetProgramInfoLog(this.programId).trim();
                throw new IOException("Couldn't link shader (" + this.name + ") : " + error3);
            }
            veil$invalidate();
            int old = this.veil$programCache.put(this.veil$activeBuffers, this.programId);
            if (old != 0) {
                GL20C.glDeleteProgram(old);
            }
            String type = this.veil$activeBuffers == 0 ? "default" : Integer.toString(this.veil$activeBuffers);
            VeilDebug debug = VeilDebug.get();
            debug.objectLabel(33506, this.programId, "Vanilla Shader Program " + this.name + ":" + type);
            debug.objectLabel(33505, vertexShader, "Vanilla vertex Shader " + this.vertexProgram.getName() + ":" + type);
            debug.objectLabel(33505, fragmentShader, "Vanilla fragment Shader " + this.fragmentProgram.getName() + ":" + type);
            GL20C.glDeleteShader(vertexShader);
            GL20C.glDeleteShader(fragmentShader);
            this.veil$vertexSource = null;
            this.veil$fragmentSource = null;
            return true;
        } catch (Throwable th) {
            GL20C.glDeleteShader(vertexShader);
            GL20C.glDeleteShader(fragmentShader);
            throw th;
        }
    }

    @Unique
    private void veil$invalidate() {
        this.samplerLocations.clear();
        this.uniformLocations.clear();
        this.uniformMap.clear();
        for (Uniform uniform : this.uniforms) {
            uniform.setLocation(-1);
        }
        updateLocations();
        markDirty();
    }

    @Override // foundry.veil.ext.ShaderInstanceExtension
    public Collection<ResourceLocation> veil$getShaderSources() {
        ResourceLocation vertexProgramName = ResourceLocation.parse(this.vertexProgram.getName());
        ResourceLocation fragmentProgramName = ResourceLocation.parse(this.fragmentProgram.getName());
        ResourceLocation vertexPath = ResourceLocation.fromNamespaceAndPath(vertexProgramName.getNamespace(), "shaders/core/" + vertexProgramName.getPath() + Program.Type.VERTEX.getExtension());
        ResourceLocation fragmentPath = ResourceLocation.fromNamespaceAndPath(fragmentProgramName.getNamespace(), "shaders/core/" + fragmentProgramName.getPath() + Program.Type.FRAGMENT.getExtension());
        return List.of(vertexPath, fragmentPath);
    }

    @Override // foundry.veil.ext.ShaderInstanceExtension
    public boolean veil$swapBuffers(int activeBuffers) {
        if (this.veil$activeBuffers == activeBuffers) {
            return false;
        }
        veil$applyCompile();
        this.veil$vertexSource = null;
        this.veil$fragmentSource = null;
        int programId = this.veil$programCache.get(activeBuffers);
        if (programId != 0) {
            this.veil$activeBuffers = activeBuffers;
            this.programId = programId;
            veil$invalidate();
            return false;
        }
        return true;
    }

    @Override // foundry.veil.ext.ShaderInstanceExtension
    public void veil$recompile(boolean vertex, String source, int activeBuffers) {
        if (this.veil$activeBuffers != activeBuffers) {
            this.veil$vertexSource = null;
            this.veil$fragmentSource = null;
        }
        this.veil$activeBuffers = activeBuffers;
        if (vertex) {
            this.veil$vertexSource = source;
        } else {
            this.veil$fragmentSource = source;
        }
    }

    @Override // foundry.veil.ext.ShaderInstanceExtension
    public int veil$getActiveBuffers() {
        return this.veil$activeBuffers;
    }
}
