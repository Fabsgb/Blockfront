package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.us */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/us.class */
public final class C1145us extends Record {

    /* JADX INFO: renamed from: io */
    private final boolean f6063io;

    /* JADX INFO: renamed from: jH */
    private final Component f6064jH;

    /* JADX INFO: renamed from: sh */
    private final int f6065sh;

    /* JADX INFO: renamed from: si */
    private final int f6066si;

    /* JADX INFO: renamed from: do */
    @NotNull
    public static final String f6067do = "default";

    /* JADX INFO: renamed from: jI */
    @NotNull
    public static final Component f6068jI = Component.translatable("bf.item.gun.mag.type.default");

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C1145us f6069a = new C1145us(true, f6068jI, 1, 1);

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1145us.class), C1145us.class, "isDefault;displayName;capacity;maxAmmo", "FIELD:Lcom/boehmod/blockfront/us;->io:Z", "FIELD:Lcom/boehmod/blockfront/us;->jH:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/us;->sh:I", "FIELD:Lcom/boehmod/blockfront/us;->si:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1145us.class), C1145us.class, "isDefault;displayName;capacity;maxAmmo", "FIELD:Lcom/boehmod/blockfront/us;->io:Z", "FIELD:Lcom/boehmod/blockfront/us;->jH:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/us;->sh:I", "FIELD:Lcom/boehmod/blockfront/us;->si:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1145us.class, Object.class), C1145us.class, "isDefault;displayName;capacity;maxAmmo", "FIELD:Lcom/boehmod/blockfront/us;->io:Z", "FIELD:Lcom/boehmod/blockfront/us;->jH:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/us;->sh:I", "FIELD:Lcom/boehmod/blockfront/us;->si:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: bF */
    public boolean m6422bF() {
        return this.f6063io;
    }

    /* JADX INFO: renamed from: m */
    public Component m6423m() {
        return this.f6064jH;
    }

    /* JADX INFO: renamed from: cb */
    public int m6424cb() {
        return this.f6065sh;
    }

    /* JADX INFO: renamed from: cc */
    public int m6425cc() {
        return this.f6066si;
    }

    public C1145us(@NotNull Component component, int i, int i2) {
        this(false, component, i, i2);
    }

    public C1145us(boolean z, @NotNull Component component, int i, int i2) {
        this.f6063io = z;
        this.f6064jH = component;
        this.f6065sh = i;
        this.f6066si = i2;
    }
}
