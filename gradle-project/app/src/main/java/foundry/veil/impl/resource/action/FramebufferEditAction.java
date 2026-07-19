package foundry.veil.impl.resource.action;

import foundry.veil.api.client.registry.VeilResourceEditorRegistry;
import foundry.veil.api.resource.VeilEditorEnvironment;
import foundry.veil.api.resource.VeilResourceAction;
import foundry.veil.api.resource.type.FramebufferResource;
import java.util.OptionalInt;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/resource/action/FramebufferEditAction.class */
public enum FramebufferEditAction implements VeilResourceAction<FramebufferResource> {
    INSTANCE;

    private static final Component NAME = Component.translatable("resource.veil.action.framebuffer_edit");
    private static final Component DESC = Component.translatable("resource.veil.action.framebuffer_edit.desc");

    @Override // foundry.veil.api.resource.VeilResourceAction
    public Component getName() {
        return NAME;
    }

    @Override // foundry.veil.api.resource.VeilResourceAction
    public Component getDescription() {
        return DESC;
    }

    @Override // foundry.veil.api.resource.VeilResourceAction
    public OptionalInt getIcon() {
        return OptionalInt.of(60362);
    }

    @Override // foundry.veil.api.resource.VeilResourceAction
    public void perform(VeilEditorEnvironment environment, FramebufferResource resource) {
        environment.open(resource, VeilResourceEditorRegistry.FRAMEBUFFER.get());
    }
}
