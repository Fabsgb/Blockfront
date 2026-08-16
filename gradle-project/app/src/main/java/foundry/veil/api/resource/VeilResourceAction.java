package foundry.veil.api.resource;

import foundry.veil.api.resource.VeilResource;
import java.util.OptionalInt;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/resource/VeilResourceAction.class */
public interface VeilResourceAction<T extends VeilResource<?>> {
    Component getName();

    Component getDescription();

    OptionalInt getIcon();

    void perform(VeilEditorEnvironment veilEditorEnvironment, T t);
}
