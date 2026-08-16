package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uQ.class */
public final class C1118uQ extends Record {

    /* JADX INFO: renamed from: iI */
    private final boolean f6129iI;

    /* JADX INFO: renamed from: jU */
    private final Component f6130jU;

    /* JADX INFO: renamed from: um */
    private final int f6131um;

    /* JADX INFO: renamed from: un */
    private final int f6132un;

    /* JADX INFO: renamed from: dz */
    @NotNull
    public static final String f6133dz = "default";

    /* JADX INFO: renamed from: jV */
    @NotNull
    public static final Component f6134jV = Component.translatable("bf.item.gun.mag.type.default");

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C1118uQ f6135a = new C1118uQ(true, f6134jV, 1, 1);

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1118uQ.class), C1118uQ.class, "isDefault;displayName;capacity;maxAmmo", "FIELD:Lcom/boehmod/blockfront/uQ;->iI:Z", "FIELD:Lcom/boehmod/blockfront/uQ;->jU:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/uQ;->um:I", "FIELD:Lcom/boehmod/blockfront/uQ;->un:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1118uQ.class), C1118uQ.class, "isDefault;displayName;capacity;maxAmmo", "FIELD:Lcom/boehmod/blockfront/uQ;->iI:Z", "FIELD:Lcom/boehmod/blockfront/uQ;->jU:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/uQ;->um:I", "FIELD:Lcom/boehmod/blockfront/uQ;->un:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1118uQ.class, Object.class), C1118uQ.class, "isDefault;displayName;capacity;maxAmmo", "FIELD:Lcom/boehmod/blockfront/uQ;->iI:Z", "FIELD:Lcom/boehmod/blockfront/uQ;->jU:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/uQ;->um:I", "FIELD:Lcom/boehmod/blockfront/uQ;->un:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: bP */
    public boolean m6400bP() {
        return this.f6129iI;
    }

    /* JADX INFO: renamed from: m */
    public Component m6401m() {
        return this.f6130jU;
    }

    /* JADX INFO: renamed from: cq */
    public int m6402cq() {
        return this.f6131um;
    }

    /* JADX INFO: renamed from: cr */
    public int m6403cr() {
        return this.f6132un;
    }

    public C1118uQ(@NotNull Component component, int i, int i2) {
        this(false, component, i, i2);
    }

    public C1118uQ(boolean z, @NotNull Component component, int i, int i2) {
        this.f6129iI = z;
        this.f6130jU = component;
        this.f6131um = i;
        this.f6132un = i2;
    }
}
