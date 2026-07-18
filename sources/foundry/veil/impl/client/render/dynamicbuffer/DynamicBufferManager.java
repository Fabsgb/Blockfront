package foundry.veil.impl.client.render.dynamicbuffer;

import com.boehmod.blockfront.InterfaceC1294xq;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import foundry.veil.Veil;
import foundry.veil.VeilClient;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.VeilRenderer;
import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.api.client.render.dynamicbuffer.DynamicBuffersChange;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.FramebufferManager;
import foundry.veil.ext.ShaderInstanceExtension;
import foundry.veil.mixin.dynamicbuffer.accessor.DynamicBufferGameRendererAccessor;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL12C;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/dynamicbuffer/DynamicBufferManager.class */
@ApiStatus.Internal
public class DynamicBufferManager implements NativeResource {
    public static final ResourceLocation MAIN_WRAPPER = Veil.veilPath("dynamic_main");
    private static final DynamicBufferType[] BUFFERS = DynamicBufferType.values();
    private static final long MAX_SHADER_COMPILE_TIME_NS = 2000000;
    private int activeBuffers = 0;
    private final Object2IntMap<ResourceLocation> activeBufferLayers = new Object2IntArrayMap();
    private boolean enabled = false;
    private final int[] clearBuffers = Arrays.stream(DynamicBufferType.values()).mapToInt(type -> {
        return 36065 + type.ordinal();
    }).toArray();
    private final Map<ResourceLocation, AdvancedFbo> framebuffers = new HashMap();
    private final List<AdvancedFbo> dynamicFramebuffers = new ArrayList();
    private final EnumMap<DynamicBufferType, DynamicBuffer> dynamicBuffers = new EnumMap<>(DynamicBufferType.class);
    private final Set<ShaderInstance> swapShaders = new HashSet();
    private int dynamicFboPointer;

    public DynamicBufferManager(int width, int height) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            IntBuffer textures = stack.mallocInt(DynamicBufferType.values().length);
            GL12C.glGenTextures(textures);
            for (DynamicBufferType value : DynamicBufferType.values()) {
                DynamicBuffer buffer = new DynamicBuffer(value, textures.get(value.ordinal()));
                buffer.init(width, height);
                this.dynamicBuffers.put(value, buffer);
            }
            if (stack != null) {
                stack.close();
            }
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

    private void deleteFramebuffers() {
        FramebufferManager framebufferManager = VeilRenderSystem.renderer().getFramebufferManager();
        for (Map.Entry<ResourceLocation, AdvancedFbo> entry : this.framebuffers.entrySet()) {
            entry.getValue().free();
            framebufferManager.removeFramebuffer(entry.getKey());
        }
        this.framebuffers.clear();
        for (AdvancedFbo fbo : this.dynamicFramebuffers) {
            fbo.free();
        }
        this.dynamicFramebuffers.clear();
        this.dynamicFboPointer = 0;
    }

    public int getActiveBuffers(ResourceLocation name) {
        return this.activeBufferLayers.getOrDefault(name, 0);
    }

    public int getActiveBuffers() {
        return this.activeBuffers;
    }

    public int getBufferTexture(DynamicBufferType buffer) {
        if ((this.activeBuffers & buffer.getMask()) != 0) {
            int index = 1 + Integer.bitCount(this.activeBuffers & (buffer.getMask() - 1));
            int texture = Minecraft.getInstance().getMainRenderTarget().veil$getTexture(index);
            if (texture != 0) {
                return texture;
            }
            return this.dynamicBuffers.get(buffer).textureId;
        }
        return MissingTextureAtlasSprite.getTexture().getId();
    }

    public boolean setActiveBuffers(ResourceLocation name, int activeBuffers) {
        if (Veil.IRIS) {
            return false;
        }
        int buffers = this.activeBufferLayers.getOrDefault(name, 0);
        if (buffers == activeBuffers) {
            return false;
        }
        if (activeBuffers == 0) {
            this.activeBufferLayers.removeInt(name);
        } else {
            this.activeBufferLayers.put(name, activeBuffers);
        }
        int flags = 0;
        IntIterator it = this.activeBufferLayers.values().iterator();
        while (it.hasNext()) {
            int value = ((Integer) it.next()).intValue();
            flags |= value;
        }
        if (flags == this.activeBuffers) {
            return false;
        }
        int oldActiveBuffers = this.activeBuffers;
        this.activeBuffers = flags;
        deleteFramebuffers();
        VeilRenderer renderer = VeilRenderSystem.renderer();
        this.swapShaders.clear();
        DynamicBufferGameRendererAccessor accessor = Minecraft.getInstance().gameRenderer;
        for (ShaderInstance shader : accessor.getShaders().values()) {
            if (((ShaderInstanceExtension) shader).veil$swapBuffers(this.activeBuffers)) {
                this.swapShaders.add(shader);
            }
        }
        if (!this.swapShaders.isEmpty()) {
            renderer.getVanillaShaderCompiler().reload(this.swapShaders);
        }
        try {
            renderer.getShaderManager().setActiveBuffers(activeBuffers);
            VeilClient.clientPlatform().onVeilDynamicBuffersChanged(new DynamicBuffersChange(oldActiveBuffers, this.activeBuffers));
            return true;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean isEnabled() {
        return this.activeBuffers != 0 && this.enabled;
    }

    public void setEnabled(boolean enabled) {
        if (!Veil.IRIS) {
            this.enabled = enabled;
        }
    }

    public void free() {
        deleteFramebuffers();
        MemoryStack stack = MemoryStack.stackPush();
        try {
            IntBuffer textures = stack.mallocInt(this.dynamicBuffers.size());
            for (DynamicBuffer buffer : this.dynamicBuffers.values()) {
                textures.put(buffer.textureId);
            }
            textures.rewind();
            GL12C.glDeleteTextures(textures);
            if (stack != null) {
                stack.close();
            }
            this.dynamicBuffers.clear();
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

    public void setupRenderState(ResourceLocation name, @Nullable RenderTarget renderTarget, boolean setViewport) {
        if (!isEnabled()) {
            return;
        }
        if (renderTarget == null) {
            VeilRenderSystem.renderer().getFramebufferManager().removeFramebuffer(name);
            AdvancedFbo fbo = this.framebuffers.remove(name);
            if (fbo != null) {
                fbo.free();
            }
            setupRenderState(MAIN_WRAPPER, (RenderTarget) Objects.requireNonNull(Minecraft.getInstance().getMainRenderTarget()), setViewport);
            return;
        }
        AdvancedFbo fbo2 = this.framebuffers.get(name);
        if (fbo2 == null) {
            AdvancedFbo.Builder builder = AdvancedFbo.withSize(renderTarget.width, renderTarget.height);
            builder.addColorTextureWrapper(renderTarget.getColorTextureId());
            Iterator it = this.dynamicBuffers.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<DynamicBufferType, DynamicBuffer> entry = (Map.Entry) it.next();
                DynamicBufferType type = entry.getKey();
                if ((this.activeBuffers & type.getMask()) != 0) {
                    builder.setName(type.getSourceName()).addColorTextureWrapper(entry.getValue().textureId);
                }
            }
            builder.setDepthTextureWrapper(renderTarget.getDepthTextureId());
            builder.setDebugLabel(name.toString());
            fbo2 = builder.build(true);
            this.framebuffers.put(name, fbo2);
        }
        VeilRenderSystem.renderer().getFramebufferManager().setFramebuffer(name, fbo2);
        fbo2.bind(setViewport);
    }

    public AdvancedFbo getDynamicFbo(AdvancedFbo framebuffer) {
        if (!isEnabled()) {
            return framebuffer;
        }
        if (!framebuffer.isColorTextureAttachment(0)) {
            return framebuffer;
        }
        int colorTexture = framebuffer.getColorTextureAttachment(0).getId();
        if (this.dynamicFboPointer < this.dynamicFramebuffers.size()) {
            AdvancedFbo fbo = this.dynamicFramebuffers.get(this.dynamicFboPointer);
            if (fbo.getWidth() == framebuffer.getWidth() && fbo.getHeight() == framebuffer.getHeight()) {
                this.dynamicFboPointer++;
                fbo.setColorAttachmentTexture(0, colorTexture);
                if (framebuffer.isDepthTextureAttachment()) {
                    fbo.setDepthAttachmentTexture(framebuffer.getDepthTextureAttachment().getId());
                }
                fbo.clear(InterfaceC1294xq.f8660tV, this.clearBuffers);
                return fbo;
            }
            this.dynamicFramebuffers.remove(this.dynamicFboPointer);
            fbo.free();
        }
        AdvancedFbo.Builder builder = AdvancedFbo.withSize(framebuffer.getWidth(), framebuffer.getHeight());
        builder.addColorTextureWrapper(colorTexture);
        Iterator it = this.dynamicBuffers.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<DynamicBufferType, DynamicBuffer> entry = (Map.Entry) it.next();
            DynamicBufferType type = entry.getKey();
            if ((this.activeBuffers & type.getMask()) != 0) {
                builder.setName(type.getSourceName()).setFormat(type.getTexelFormat(), type.getInternalFormat()).addColorTextureBuffer();
            }
        }
        if (framebuffer.isDepthTextureAttachment()) {
            builder.setDepthTextureWrapper(framebuffer.getDepthTextureAttachment().getId());
        } else {
            builder.setDepthTextureBuffer();
        }
        builder.setDebugLabel(framebuffer.getDebugLabel());
        AdvancedFbo fbo2 = builder.build(true);
        this.dynamicFramebuffers.add(this.dynamicFboPointer, fbo2);
        this.dynamicFboPointer++;
        return fbo2;
    }

    public int[] getClearBuffers() {
        return this.clearBuffers;
    }

    public void endFrame() {
        for (AdvancedFbo framebuffer : this.framebuffers.values()) {
            framebuffer.clear(0.0f, 0.0f, 0.0f, 0.0f, InterfaceC1294xq.f8660tV, this.clearBuffers);
        }
        ListIterator<AdvancedFbo> iterator = this.dynamicFramebuffers.listIterator(this.dynamicFboPointer);
        while (iterator.hasNext()) {
            iterator.next().free();
            iterator.remove();
        }
        this.dynamicFboPointer = 0;
        if (this.swapShaders.isEmpty()) {
            return;
        }
        long startTime = System.nanoTime();
        Iterator<ShaderInstance> shaderIterator = this.swapShaders.iterator();
        while (shaderIterator.hasNext() && System.nanoTime() - startTime < MAX_SHADER_COMPILE_TIME_NS) {
            ShaderInstanceExtension shader = shaderIterator.next();
            if (shader.veil$isRecompileReady(this.activeBuffers)) {
                boolean success = shader.veil$applyCompile();
                shaderIterator.remove();
                if (success) {
                    break;
                }
            }
        }
        if (!shaderIterator.hasNext()) {
            Veil.LOGGER.info("Finished uploading vanilla shaders");
        }
    }

    public void markRecompiled(ShaderInstance shaderInstance) {
        this.swapShaders.add(shaderInstance);
    }

    public void resizeFramebuffers(int width, int height) {
        deleteFramebuffers();
        for (DynamicBuffer buffer : this.dynamicBuffers.values()) {
            buffer.resize(width, height);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/dynamicbuffer/DynamicBufferManager$DynamicBuffer.class */
    private static final class DynamicBuffer extends Record {
        private final DynamicBufferType type;
        private final int textureId;

        private DynamicBuffer(DynamicBufferType type, int textureId) {
            this.type = type;
            this.textureId = textureId;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, DynamicBuffer.class), DynamicBuffer.class, "type;textureId", "FIELD:Lfoundry/veil/impl/client/render/dynamicbuffer/DynamicBufferManager$DynamicBuffer;->type:Lfoundry/veil/api/client/render/dynamicbuffer/DynamicBufferType;", "FIELD:Lfoundry/veil/impl/client/render/dynamicbuffer/DynamicBufferManager$DynamicBuffer;->textureId:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, DynamicBuffer.class), DynamicBuffer.class, "type;textureId", "FIELD:Lfoundry/veil/impl/client/render/dynamicbuffer/DynamicBufferManager$DynamicBuffer;->type:Lfoundry/veil/api/client/render/dynamicbuffer/DynamicBufferType;", "FIELD:Lfoundry/veil/impl/client/render/dynamicbuffer/DynamicBufferManager$DynamicBuffer;->textureId:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, DynamicBuffer.class, Object.class), DynamicBuffer.class, "type;textureId", "FIELD:Lfoundry/veil/impl/client/render/dynamicbuffer/DynamicBufferManager$DynamicBuffer;->type:Lfoundry/veil/api/client/render/dynamicbuffer/DynamicBufferType;", "FIELD:Lfoundry/veil/impl/client/render/dynamicbuffer/DynamicBufferManager$DynamicBuffer;->textureId:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public DynamicBufferType type() {
            return this.type;
        }

        public int textureId() {
            return this.textureId;
        }

        public void init(int width, int height) {
            GlStateManager._bindTexture(this.textureId);
            GlStateManager._texParameter(3553, 10241, 9728);
            GlStateManager._texParameter(3553, 10240, 9728);
            GlStateManager._texParameter(3553, 33085, 0);
            GlStateManager._texParameter(3553, 33082, 0);
            GlStateManager._texParameter(3553, 33083, 0);
            GlStateManager._texParameter(3553, 34049, 0.0f);
            GlStateManager._texParameter(3553, 10242, 33071);
            GlStateManager._texParameter(3553, 10243, 33071);
            GlStateManager._texImage2D(3553, 0, this.type.getInternalFormat(), width, height, 0, this.type.getTexelFormat(), 5125, (IntBuffer) null);
        }

        public void resize(int width, int height) {
            GlStateManager._bindTexture(this.textureId);
            GlStateManager._texImage2D(3553, 0, this.type.getInternalFormat(), width, height, 0, this.type.getTexelFormat(), 5125, (IntBuffer) null);
        }
    }
}
