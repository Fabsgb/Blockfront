package foundry.veil.api.client.render.framebuffer;

import com.boehmod.blockfront.InterfaceC0638xq;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.FramebufferAttachmentDefinition;
import foundry.veil.api.client.render.texture.TextureFilter;
import foundry.veil.impl.client.render.framebuffer.AdvancedFboImpl;
import foundry.veil.impl.client.render.framebuffer.AdvancedFboMutableTextureAttachment;
import foundry.veil.impl.client.render.framebuffer.DSAAdvancedFboImpl;
import foundry.veil.impl.client.render.framebuffer.LegacyAdvancedFboImpl;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/framebuffer/AdvancedFbo.class */
public interface AdvancedFbo extends NativeResource {
    void create();

    void clear(float f, float f2, float f3, float f4, float f5, int i, int... iArr);

    void resetDrawBuffers();

    void drawBuffers(int... iArr);

    void bind(boolean z);

    void bindDraw(boolean z);

    void resolveToFbo(int i, int i2, int i3, int i4, int i5);

    void resolveToAdvancedFbo(AdvancedFbo advancedFbo, int i, int i2);

    void resolveToRenderTarget(RenderTarget renderTarget, int i, int i2);

    @Contract(pure = true)
    int getId();

    @Contract(pure = true)
    int getWidth();

    @Contract(pure = true)
    int getHeight();

    @Contract(pure = true)
    int getColorAttachments();

    @Contract(pure = true)
    int getClearMask();

    @Contract(pure = true)
    int[] getDrawBuffers();

    @Contract(pure = true)
    boolean hasColorAttachment(int i);

    @Contract(pure = true)
    boolean hasDepthAttachment();

    boolean hasStencilAttachment();

    @Contract(pure = true)
    AdvancedFboAttachment getColorAttachment(int i);

    @Contract(pure = true)
    AdvancedFboAttachment getDepthAttachment();

    @Contract(pure = true)
    @Nullable
    String getDebugLabel();

    /* JADX INFO: renamed from: toRenderTarget */
    RenderTarget mo1982toRenderTarget();

    default void clear() {
        clear(0.0f, 0.0f, 0.0f, 0.0f, 1.0f, getClearMask(), getDrawBuffers());
    }

    default void clear(int clearMask) {
        clear(0.0f, 0.0f, 0.0f, 0.0f, 1.0f, clearMask, getDrawBuffers());
    }

    default void clear(int clearMask, int... clearBuffers) {
        clear(0.0f, 0.0f, 0.0f, 0.0f, 1.0f, clearMask, clearBuffers);
    }

    default void clear(float red, float green, float blue, float alpha, int clearMask) {
        clear(red, green, blue, alpha, 1.0f, clearMask, getDrawBuffers());
    }

    default void clear(float red, float green, float blue, float alpha, int clearMask, int... clearBuffers) {
        clear(red, green, blue, alpha, 1.0f, clearMask, clearBuffers);
    }

    default void clear(float red, float green, float blue, float alpha, float depth, int clearMask) {
        clear(red, green, blue, alpha, depth, clearMask, getDrawBuffers());
    }

    default void bindRead() {
        RenderSystem.assertOnRenderThreadOrInit();
        GlStateManager._glBindFramebuffer(36008, getId());
    }

    static AdvancedFbo getMainFramebuffer() {
        return AdvancedFboImpl.MAIN_WRAPPER.get();
    }

    static void unbind() {
        RenderTarget mainTarget = Minecraft.getInstance().getMainRenderTarget();
        if (mainTarget != null) {
            mainTarget.bindWrite(true);
        } else {
            VeilRenderSystem.renderThreadExecutor().execute(() -> {
                GlStateManager._glBindFramebuffer(36160, 0);
            });
        }
    }

    static void unbindRead() {
        VeilRenderSystem.renderThreadExecutor().execute(() -> {
            GlStateManager._glBindFramebuffer(36008, getMainFramebuffer().getId());
        });
    }

    static void unbindDraw() {
        VeilRenderSystem.renderThreadExecutor().execute(() -> {
            GlStateManager._glBindFramebuffer(36009, getMainFramebuffer().getId());
        });
    }

    default void resolveToAdvancedFbo(AdvancedFbo target) {
        resolveToAdvancedFbo(target, 16640, 9728);
    }

    default void resolveToRenderTarget(RenderTarget target) {
        resolveToRenderTarget(target, 16640, 9728);
    }

    default void resolveToScreen() {
        resolveToAdvancedFbo(getMainFramebuffer(), InterfaceC0638xq.tV, 9728);
    }

    default void resolveToScreen(int mask, int filtering) {
        resolveToAdvancedFbo(getMainFramebuffer(), mask, filtering);
    }

    @Contract(pure = true)
    default boolean isColorTextureAttachment(int attachment) {
        return hasColorAttachment(attachment) && (getColorAttachment(attachment) instanceof AdvancedFboTextureAttachment);
    }

    @Contract(pure = true)
    default boolean isMutableColorTextureAttachment(int attachment) {
        return hasColorAttachment(attachment) && (getColorAttachment(attachment) instanceof AdvancedFboMutableTextureAttachment);
    }

    @Contract(pure = true)
    default boolean isColorRenderAttachment(int attachment) {
        return hasColorAttachment(attachment) && (getColorAttachment(attachment) instanceof AdvancedFboRenderAttachment);
    }

    @Contract(pure = true)
    default AdvancedFboTextureAttachment getColorTextureAttachment(int attachment) {
        AdvancedFboAttachment advancedFboAttachment = getColorAttachment(attachment);
        Validate.isTrue(isColorTextureAttachment(attachment), "Color attachment " + attachment + " must be a texture attachment to get texture information.", new Object[0]);
        return (AdvancedFboTextureAttachment) advancedFboAttachment;
    }

    default void setColorAttachmentTexture(int attachment, int textureId) {
        setColorAttachmentTexture(attachment, textureId, -1);
    }

    default void setColorAttachmentTexture(int attachment, int textureId, int layer) {
        AdvancedFboAttachment advancedFboAttachment = getColorAttachment(attachment);
        Validate.isTrue(isMutableColorTextureAttachment(attachment), "Color attachment " + attachment + " must be a mutable texture attachment to modify texture information.", new Object[0]);
        AdvancedFboMutableTextureAttachment mutableTextureAttachment = (AdvancedFboMutableTextureAttachment) advancedFboAttachment;
        mutableTextureAttachment.setTexture(textureId, layer);
        mutableTextureAttachment.attach(this, attachment);
    }

    @Contract(pure = true)
    default AdvancedFboRenderAttachment getColorRenderAttachment(int attachment) {
        AdvancedFboAttachment advancedFboAttachment = getColorAttachment(attachment);
        Validate.isTrue(isColorRenderAttachment(attachment), "Color attachment " + attachment + " must be a render attachment to get render information.", new Object[0]);
        return (AdvancedFboRenderAttachment) advancedFboAttachment;
    }

    @Contract(pure = true)
    default boolean isDepthTextureAttachment() {
        return hasDepthAttachment() && (getDepthAttachment() instanceof AdvancedFboTextureAttachment);
    }

    @Contract(pure = true)
    default boolean isDepthMutableTextureAttachment() {
        return hasDepthAttachment() && (getDepthAttachment() instanceof AdvancedFboMutableTextureAttachment);
    }

    @Contract(pure = true)
    default boolean isDepthRenderAttachment() {
        return hasDepthAttachment() && (getDepthAttachment() instanceof AdvancedFboRenderAttachment);
    }

    @Contract(pure = true)
    default AdvancedFboTextureAttachment getDepthTextureAttachment() {
        AdvancedFboAttachment advancedFboAttachment = getDepthAttachment();
        Validate.isTrue(isDepthTextureAttachment(), "Depth attachment must be a texture attachment to get texture information.", new Object[0]);
        return (AdvancedFboTextureAttachment) advancedFboAttachment;
    }

    default void setDepthAttachmentTexture(int textureId) {
        setDepthAttachmentTexture(textureId, -1);
    }

    default void setDepthAttachmentTexture(int textureId, int layer) {
        AdvancedFboAttachment advancedFboAttachment = getDepthAttachment();
        Validate.isTrue(isDepthMutableTextureAttachment(), "Depth attachment must be a mutable texture attachment to modify texture information.", new Object[0]);
        AdvancedFboMutableTextureAttachment mutableTextureAttachment = (AdvancedFboMutableTextureAttachment) advancedFboAttachment;
        mutableTextureAttachment.setTexture(textureId, layer);
        mutableTextureAttachment.attach(this, 0);
    }

    @Contract(pure = true)
    default AdvancedFboRenderAttachment getDepthRenderAttachment() {
        AdvancedFboAttachment advancedFboAttachment = getDepthAttachment();
        Validate.isTrue(isDepthRenderAttachment(), "Depth attachment must be a render attachment to get render information.", new Object[0]);
        return (AdvancedFboRenderAttachment) advancedFboAttachment;
    }

    static Builder withSize(int width, int height) {
        return new Builder(width, height);
    }

    static Builder copy(AdvancedFbo parent) {
        return new Builder(parent.getWidth(), parent.getHeight()).addAttachments(parent);
    }

    static Builder copy(RenderTarget parent) {
        return AdvancedFboImpl.copy(parent);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/framebuffer/AdvancedFbo$Builder.class */
    public static class Builder {
        private final int width;
        private final int height;
        private final List<AdvancedFboAttachment> colorAttachments = new LinkedList();
        private AdvancedFboAttachment depthAttachment = null;
        private String debugLabel = null;
        private int levels;
        private int format;
        private int internalFormat;
        private boolean blur;
        private boolean mipmap;
        private float anisotropy;
        private TextureFilter.CompareFunction compareFunction;
        private TextureFilter.Wrap wrapS;
        private TextureFilter.Wrap wrapT;
        private int borderColor;
        private String name;

        public Builder(int width, int height) {
            this.width = width;
            this.height = height;
            reset();
        }

        private void setDefaultFormat(FramebufferAttachmentDefinition.Format format) {
            if (this.format == 0 && this.internalFormat == 0) {
                setFormat(format);
            }
        }

        private void reset() {
            this.levels = 1;
            this.format = 0;
            this.internalFormat = 0;
            this.blur = false;
            this.mipmap = false;
            this.anisotropy = 1.0f;
            this.compareFunction = null;
            this.wrapS = TextureFilter.Wrap.CLAMP_TO_EDGE;
            this.wrapT = TextureFilter.Wrap.CLAMP_TO_EDGE;
            this.borderColor = -16777216;
            this.name = null;
        }

        private void validateColorSize() {
            Validate.inclusiveBetween(0L, VeilRenderSystem.maxColorAttachments(), this.colorAttachments.size());
        }

        private void validateSamples() {
            int samples = -1;
            for (AdvancedFboAttachment attachment : this.colorAttachments) {
                if (attachment instanceof AdvancedFboRenderAttachment) {
                    if (samples == -1) {
                        samples = attachment.getLevels();
                    } else if (attachment.getLevels() != samples) {
                        throw new IllegalArgumentException("Framebuffer attachments need to have the same number of samples to be complete.");
                    }
                }
            }
            if (samples != -1 && (this.depthAttachment instanceof AdvancedFboRenderAttachment) && this.depthAttachment.getLevels() != samples) {
                throw new IllegalArgumentException("Framebuffer attachments need to have the same number of samples to be complete.");
            }
        }

        private TextureFilter.EdgeType getEdgeType() {
            if (this.format == 36244 || this.format == 33320 || this.format == 36248 || this.format == 36249) {
                return TextureFilter.EdgeType.INT;
            }
            if (this.format == 34041) {
                return TextureFilter.EdgeType.UINT;
            }
            return TextureFilter.EdgeType.FLOAT;
        }

        public Builder addAttachments(AdvancedFbo parent) {
            for (int i = 0; i < parent.getColorAttachments(); i++) {
                this.colorAttachments.add(parent.getColorAttachment(i).mo1772clone());
            }
            validateColorSize();
            if (parent.hasDepthAttachment()) {
                Validate.isTrue(this.depthAttachment == null, "Only one depth attachment can be applied to an FBO.", new Object[0]);
                this.depthAttachment = parent.getDepthAttachment().mo1772clone();
            }
            return this;
        }

        public Builder addAttachments(RenderTarget parent) {
            reset();
            addColorTextureBuffer(parent.width, parent.height);
            if (parent.useDepth) {
                Validate.isTrue(this.depthAttachment == null, "Only one depth attachment can be applied to an FBO.", new Object[0]);
                setDepthRenderBuffer(parent.width, parent.height);
            }
            return this;
        }

        public Builder setLevels(int levels) {
            this.levels = levels;
            return this;
        }

        public Builder setFormat(FramebufferAttachmentDefinition.Format format) {
            return setFormat(format.getFormat(), format.getInternalFormat());
        }

        public Builder setFormat(int format, int internalFormat) {
            this.format = format;
            this.internalFormat = internalFormat;
            return this;
        }

        public Builder setFilter(boolean blur, boolean mipmap) {
            this.blur = blur;
            this.mipmap = mipmap;
            return this;
        }

        public Builder setAnisotropy(float anisotropy) {
            this.anisotropy = anisotropy;
            return this;
        }

        public Builder setCompareFunction(@Nullable TextureFilter.CompareFunction compareFunction) {
            this.compareFunction = compareFunction;
            return this;
        }

        public Builder setWrapS(TextureFilter.Wrap wrapS) {
            this.wrapS = wrapS;
            return this;
        }

        public Builder setWrapS(int wrapS) {
            this.wrapS = (TextureFilter.Wrap) TextureFilter.Wrap.BY_GL_ID.getOrDefault(wrapS, TextureFilter.Wrap.CLAMP_TO_EDGE);
            return this;
        }

        public Builder setWrapT(TextureFilter.Wrap wrapT) {
            this.wrapT = wrapT;
            return this;
        }

        public Builder setWrapT(int wrapT) {
            this.wrapT = (TextureFilter.Wrap) TextureFilter.Wrap.BY_GL_ID.getOrDefault(wrapT, TextureFilter.Wrap.CLAMP_TO_EDGE);
            return this;
        }

        public Builder setWrap(TextureFilter.Wrap wrapS, TextureFilter.Wrap wrapT) {
            this.wrapS = wrapS;
            this.wrapT = wrapT;
            return this;
        }

        public Builder setWrap(int wrapS, int wrapT) {
            this.wrapS = (TextureFilter.Wrap) TextureFilter.Wrap.BY_GL_ID.getOrDefault(wrapS, TextureFilter.Wrap.CLAMP_TO_EDGE);
            this.wrapT = (TextureFilter.Wrap) TextureFilter.Wrap.BY_GL_ID.getOrDefault(wrapT, TextureFilter.Wrap.CLAMP_TO_EDGE);
            return this;
        }

        public Builder setBorderColor(int borderColor) {
            this.borderColor = borderColor;
            return this;
        }

        public Builder setFilter(TextureFilter filter) {
            setFilter(filter.blur(), filter.mipmap());
            setAnisotropy(filter.anisotropy());
            setCompareFunction(filter.compareFunction());
            setWrap(filter.wrapX(), filter.wrapY());
            setBorderColor(filter.borderColor());
            return this;
        }

        public Builder setName(@Nullable String name) {
            this.name = name;
            return this;
        }

        public Builder addColorBuffer(AdvancedFboAttachment attachment) {
            this.colorAttachments.add(attachment);
            reset();
            validateColorSize();
            return this;
        }

        public Builder addColorTextureWrapper(int textureId) {
            return addColorTextureWrapper(textureId, -1);
        }

        public Builder addColorTextureWrapper(int textureId, int layer) {
            return addColorBuffer(new AdvancedFboMutableTextureAttachment(36064, textureId, layer, this.name));
        }

        public Builder addColorTextureBuffer() {
            return addColorTextureBuffer(this.width, this.height);
        }

        public Builder addColorTextureBuffer(int width, int height) {
            setDefaultFormat(FramebufferAttachmentDefinition.Format.RGBA8);
            Validate.isTrue((this.format == 6402 || this.format == 34041) ? false : true, "A color renderable format must be specified for color attachments", new Object[0]);
            return addColorBuffer(new AdvancedFboTextureAttachment(36064, this.internalFormat, this.format, width, height, this.levels, new TextureFilter(this.blur, this.mipmap, this.anisotropy, this.compareFunction, this.wrapS, this.wrapT, TextureFilter.Wrap.CLAMP_TO_EDGE, this.borderColor, getEdgeType(), false), this.name));
        }

        public Builder addColorRenderBuffer() {
            return addColorRenderBuffer(this.width, this.height);
        }

        public Builder addColorRenderBuffer(int width, int height) {
            setDefaultFormat(FramebufferAttachmentDefinition.Format.RGBA8);
            Validate.isTrue((this.format == 6402 || this.format == 34041) ? false : true, "A color renderable format must be specified for color attachments", new Object[0]);
            return addColorBuffer(new AdvancedFboRenderAttachment(36064, this.internalFormat, width, height, this.levels));
        }

        public Builder setDepthBuffer(@Nullable AdvancedFboAttachment attachment) {
            this.depthAttachment = attachment;
            reset();
            return this;
        }

        public Builder setDepthTextureWrapper(int textureId) {
            return setDepthTextureWrapper(textureId, -1);
        }

        public Builder setDepthTextureWrapper(int textureId, int layer) {
            return setDepthBuffer(new AdvancedFboMutableTextureAttachment(36096, textureId, layer, this.name));
        }

        public Builder setDepthTextureBuffer() {
            setDefaultFormat(FramebufferAttachmentDefinition.Format.DEPTH_COMPONENT);
            return setDepthTextureBuffer(this.width, this.height);
        }

        public Builder setDepthTextureBuffer(int width, int height) {
            setDefaultFormat(FramebufferAttachmentDefinition.Format.DEPTH_COMPONENT);
            Validate.isTrue(this.format == 6402 || this.format == 34041, "A depth or depth stencil format must be specified for depth attachments", new Object[0]);
            return setDepthBuffer(new AdvancedFboTextureAttachment(this.format == 34041 ? 33306 : 36096, this.internalFormat, 6402, width, height, this.levels, new TextureFilter(this.blur, this.mipmap, this.anisotropy, this.compareFunction, this.wrapS, this.wrapT, TextureFilter.Wrap.CLAMP_TO_EDGE, this.borderColor, getEdgeType(), false), this.name));
        }

        public Builder setDepthRenderBuffer() {
            return setDepthRenderBuffer(this.width, this.height);
        }

        public Builder setDepthRenderBuffer(int width, int height) {
            setDefaultFormat(FramebufferAttachmentDefinition.Format.DEPTH_COMPONENT);
            Validate.isTrue(this.format == 6402 || this.format == 34041, "A depth or depth stencil format must be specified for depth attachments", new Object[0]);
            return setDepthBuffer(new AdvancedFboRenderAttachment(this.format == 34041 ? 33306 : 36096, this.internalFormat, width, height, this.levels));
        }

        public Builder setDebugLabel(@Nullable String debugLabel) {
            this.debugLabel = debugLabel;
            return this;
        }

        public AdvancedFbo build(boolean create) {
            AdvancedFbo legacyAdvancedFboImpl;
            if (this.colorAttachments.isEmpty()) {
                throw new IllegalArgumentException("Framebuffer needs at least one color attachment to be complete.");
            }
            if (this.width <= 0 || this.height <= 0) {
                throw new IllegalArgumentException("Framebuffer needs a positive area to be complete. (Was " + this.width + "x" + this.height + ")");
            }
            validateSamples();
            if (VeilRenderSystem.directStateAccessSupported()) {
                legacyAdvancedFboImpl = new DSAAdvancedFboImpl(this.width, this.height, (AdvancedFboAttachment[]) this.colorAttachments.toArray(x$0 -> {
                    return new AdvancedFboAttachment[x$0];
                }), this.depthAttachment, this.debugLabel);
            } else {
                legacyAdvancedFboImpl = new LegacyAdvancedFboImpl(this.width, this.height, (AdvancedFboAttachment[]) this.colorAttachments.toArray(x$02 -> {
                    return new AdvancedFboAttachment[x$02];
                }), this.depthAttachment, this.debugLabel);
            }
            AdvancedFbo framebuffer = legacyAdvancedFboImpl;
            if (create) {
                framebuffer.create();
            }
            return framebuffer;
        }
    }
}
