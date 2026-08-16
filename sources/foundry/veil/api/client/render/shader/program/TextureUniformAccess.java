package foundry.veil.api.client.render.shader.program;

import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment;
import foundry.veil.api.client.render.shader.texture.ShaderTextureSource;
import foundry.veil.ext.AbstractTextureExtension;
import foundry.veil.impl.client.render.shader.program.ShaderProgramImpl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/program/TextureUniformAccess.class */
@ApiStatus.NonExtendable
public interface TextureUniformAccess {
    void setTexture(CharSequence charSequence, int i, int i2, int i3);

    void removeTexture(CharSequence charSequence);

    void bindSamplers(@Nullable ShaderTextureSource.Context context, int i);

    void clearSamplers();

    default void setFramebufferSamplers(AdvancedFbo framebuffer) {
        boolean setDiffuseSampler = false;
        for (int i = 0; i < framebuffer.getColorAttachments(); i++) {
            if (framebuffer.isColorTextureAttachment(i)) {
                AdvancedFboTextureAttachment attachment = framebuffer.getColorTextureAttachment(i);
                setTexture("DiffuseSampler" + i, 3553, attachment.getId());
                if (attachment.getName() != null) {
                    setTexture(attachment.getName(), 3553, attachment.getId());
                }
                if (!setDiffuseSampler) {
                    setTexture("DiffuseSampler", 3553, attachment.getId());
                    setDiffuseSampler = true;
                }
            }
        }
        if (framebuffer.isDepthTextureAttachment()) {
            AdvancedFboTextureAttachment attachment2 = framebuffer.getDepthTextureAttachment();
            setTexture("DiffuseDepthSampler", 3553, attachment2.getId());
            if (attachment2.getName() != null) {
                setTexture(attachment2.getName(), 3553, attachment2.getId());
            }
        }
    }

    default void setTexture(CharSequence name, ResourceLocation location) {
        setTexture(name, Minecraft.getInstance().getTextureManager().getTexture(location));
    }

    default void setTexture(CharSequence name, ResourceLocation location, int samplerId) {
        setTexture(name, Minecraft.getInstance().getTextureManager().getTexture(location), samplerId);
    }

    default void setTexture(CharSequence name, AbstractTexture texture) {
        setTexture(name, ((AbstractTextureExtension) texture).getTextureTarget(), texture.getId(), 0);
    }

    default void setTexture(CharSequence name, AbstractTexture texture, int samplerId) {
        setTexture(name, ((AbstractTextureExtension) texture).getTextureTarget(), texture.getId(), samplerId);
    }

    default void setTexture(CharSequence name, int target, int textureId) {
        setTexture(name, target, textureId, 0);
    }

    default void bindSamplers(int samplerStart) {
        bindSamplers(ShaderTextureSource.GLOBAL_CONTEXT, samplerStart);
    }

    static void setFramebufferSamplers(ShaderInstance instance, AdvancedFbo framebuffer) {
        if (instance instanceof ShaderProgramImpl.Wrapper) {
            ShaderProgramImpl.Wrapper wrapper = (ShaderProgramImpl.Wrapper) instance;
            wrapper.program().setFramebufferSamplers(framebuffer);
            return;
        }
        boolean setDiffuseSampler = false;
        for (int i = 0; i < framebuffer.getColorAttachments(); i++) {
            if (framebuffer.isColorTextureAttachment(i)) {
                AdvancedFboTextureAttachment attachment = framebuffer.getColorTextureAttachment(i);
                instance.setSampler("DiffuseSampler" + i, attachment);
                if (attachment.getName() != null) {
                    instance.setSampler(attachment.getName(), attachment);
                }
                if (!setDiffuseSampler) {
                    instance.setSampler("DiffuseSampler", attachment);
                    setDiffuseSampler = true;
                }
            }
        }
        if (framebuffer.isDepthTextureAttachment()) {
            AdvancedFboTextureAttachment attachment2 = framebuffer.getDepthTextureAttachment();
            instance.setSampler("DiffuseDepthSampler", attachment2);
            if (attachment2.getName() != null) {
                instance.setSampler(attachment2.getName(), attachment2);
            }
        }
    }
}
