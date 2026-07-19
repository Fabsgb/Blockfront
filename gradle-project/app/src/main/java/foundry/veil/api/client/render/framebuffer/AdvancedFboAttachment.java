package foundry.veil.api.client.render.framebuffer;

import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/framebuffer/AdvancedFboAttachment.class */
public interface AdvancedFboAttachment extends NativeResource, Cloneable {
    void create();

    void attach(AdvancedFbo advancedFbo, int i);

    void bindAttachment();

    void unbindAttachment();

    int getAttachmentType();

    int getFormat();

    int getLevels();

    boolean canSample();

    @Nullable
    String getName();

    /* JADX INFO: renamed from: clone */
    AdvancedFboAttachment mo1772clone();
}
