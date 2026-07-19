package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import javax.annotation.Nullable;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bm.class */
public final class C0042bm extends Record {

    @NotNull
    private final Component C;

    @Nullable
    private final Component D;

    @NotNull
    private final Button.OnPress a;

    public C0042bm(@NotNull Component component, @Nullable Component component2, @NotNull Button.OnPress onPress) {
        this.C = component;
        this.D = component2;
        this.a = onPress;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0042bm.class), C0042bm.class, "text;toolTip;onPress", "FIELD:Lcom/boehmod/blockfront/bm;->C:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bm;->D:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bm;->a:Lnet/minecraft/client/gui/components/Button$OnPress;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0042bm.class), C0042bm.class, "text;toolTip;onPress", "FIELD:Lcom/boehmod/blockfront/bm;->C:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bm;->D:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bm;->a:Lnet/minecraft/client/gui/components/Button$OnPress;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0042bm.class, Object.class), C0042bm.class, "text;toolTip;onPress", "FIELD:Lcom/boehmod/blockfront/bm;->C:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bm;->D:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bm;->a:Lnet/minecraft/client/gui/components/Button$OnPress;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public Component d() {
        return this.C;
    }

    @Nullable
    public Component e() {
        return this.D;
    }

    @NotNull
    public Button.OnPress a() {
        return this.a;
    }
}
