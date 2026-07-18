package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import javax.annotation.Nullable;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bm.class */
public final class C0121bm extends Record {

    /* JADX INFO: renamed from: C */
    @NotNull
    private final Component f832C;

    /* JADX INFO: renamed from: D */
    @Nullable
    private final Component f833D;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Button.OnPress f834a;

    public C0121bm(@NotNull Component component, @Nullable Component component2, @NotNull Button.OnPress onPress) {
        this.f832C = component;
        this.f833D = component2;
        this.f834a = onPress;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0121bm.class), C0121bm.class, "text;toolTip;onPress", "FIELD:Lcom/boehmod/blockfront/bm;->C:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bm;->D:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bm;->a:Lnet/minecraft/client/gui/components/Button$OnPress;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0121bm.class), C0121bm.class, "text;toolTip;onPress", "FIELD:Lcom/boehmod/blockfront/bm;->C:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bm;->D:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bm;->a:Lnet/minecraft/client/gui/components/Button$OnPress;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0121bm.class, Object.class), C0121bm.class, "text;toolTip;onPress", "FIELD:Lcom/boehmod/blockfront/bm;->C:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bm;->D:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bm;->a:Lnet/minecraft/client/gui/components/Button$OnPress;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public Component m612d() {
        return this.f832C;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public Component m613e() {
        return this.f833D;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Button.OnPress m614a() {
        return this.f834a;
    }
}
