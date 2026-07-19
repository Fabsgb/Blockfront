package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.us, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/us.class */
public final class C0559us extends Record {

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    private final boolean f422io;
    private final Component jH;
    private final int sh;
    private final int si;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    @NotNull
    public static final String f318do = "default";

    @NotNull
    public static final Component jI = Component.translatable("bf.item.gun.mag.type.default");

    @NotNull
    public static final C0559us a = new C0559us(true, jI, 1, 1);

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0559us.class), C0559us.class, "isDefault;displayName;capacity;maxAmmo", "FIELD:Lcom/boehmod/blockfront/us;->io:Z", "FIELD:Lcom/boehmod/blockfront/us;->jH:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/us;->sh:I", "FIELD:Lcom/boehmod/blockfront/us;->si:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0559us.class), C0559us.class, "isDefault;displayName;capacity;maxAmmo", "FIELD:Lcom/boehmod/blockfront/us;->io:Z", "FIELD:Lcom/boehmod/blockfront/us;->jH:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/us;->sh:I", "FIELD:Lcom/boehmod/blockfront/us;->si:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0559us.class, Object.class), C0559us.class, "isDefault;displayName;capacity;maxAmmo", "FIELD:Lcom/boehmod/blockfront/us;->io:Z", "FIELD:Lcom/boehmod/blockfront/us;->jH:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/us;->sh:I", "FIELD:Lcom/boehmod/blockfront/us;->si:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public boolean bF() {
        return this.f422io;
    }

    public Component m() {
        return this.jH;
    }

    public int cb() {
        return this.sh;
    }

    public int cc() {
        return this.si;
    }

    public C0559us(@NotNull Component component, int i, int i2) {
        this(false, component, i, i2);
    }

    public C0559us(boolean z, @NotNull Component component, int i, int i2) {
        this.f422io = z;
        this.jH = component;
        this.sh = i;
        this.si = i2;
    }
}
