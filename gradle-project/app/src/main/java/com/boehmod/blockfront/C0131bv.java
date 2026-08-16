package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import javax.annotation.Nullable;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bv.class */
public final class C0131bv extends Record {

    /* JADX INFO: renamed from: C */
    @NotNull
    private final Component f967C;

    /* JADX INFO: renamed from: D */
    @Nullable
    private final Component f968D;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Button.OnPress f969a;

    public C0131bv(@NotNull Component component, @Nullable Component component2, @NotNull Button.OnPress onPress) {
        this.f967C = component;
        this.f968D = component2;
        this.f969a = onPress;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0131bv.class), C0131bv.class, "text;toolTip;onPress", "FIELD:Lcom/boehmod/blockfront/bv;->C:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bv;->D:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bv;->a:Lnet/minecraft/client/gui/components/Button$OnPress;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0131bv.class), C0131bv.class, "text;toolTip;onPress", "FIELD:Lcom/boehmod/blockfront/bv;->C:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bv;->D:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bv;->a:Lnet/minecraft/client/gui/components/Button$OnPress;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0131bv.class, Object.class), C0131bv.class, "text;toolTip;onPress", "FIELD:Lcom/boehmod/blockfront/bv;->C:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bv;->D:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bv;->a:Lnet/minecraft/client/gui/components/Button$OnPress;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public Component m717d() {
        return this.f967C;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public Component m718e() {
        return this.f968D;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Button.OnPress m719a() {
        return this.f969a;
    }
}
