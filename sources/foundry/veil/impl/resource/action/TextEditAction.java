package foundry.veil.impl.resource.action;

import foundry.veil.api.client.registry.VeilResourceEditorRegistry;
import foundry.veil.api.resource.VeilEditorEnvironment;
import foundry.veil.api.resource.VeilResourceAction;
import foundry.veil.api.resource.editor.ResourceFileEditor;
import foundry.veil.api.resource.type.VeilTextResource;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.OptionalInt;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/resource/action/TextEditAction.class */
public final class TextEditAction<T extends VeilTextResource<?>> extends Record implements VeilResourceAction<T> {
    private static final Component NAME = Component.translatable("resource.veil.action.text_edit");
    private static final Component DESC = Component.translatable("resource.veil.action.text_edit.desc");

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, TextEditAction.class), TextEditAction.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, TextEditAction.class), TextEditAction.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, TextEditAction.class, Object.class), TextEditAction.class, "").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

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
        return OptionalInt.of(60635);
    }

    @Override // foundry.veil.api.resource.VeilResourceAction
    public void perform(VeilEditorEnvironment environment, T resource) {
        environment.open(resource, (ResourceFileEditor.Factory<T>) VeilResourceEditorRegistry.TEXT.get());
    }
}
