package foundry.veil.ext.iris;

import foundry.veil.api.client.render.framebuffer.FramebufferAttachmentDefinition;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/ext/iris/IrisRenderTargetExtension.class */
public interface IrisRenderTargetExtension {
    String veil$getName();

    int veil$getMainTexture();

    int veil$getAltTexture();

    int veil$getWidth();

    int veil$getHeight();

    FramebufferAttachmentDefinition.Format veil$getFormat();
}
