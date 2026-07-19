package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wa.class */
public final class C0595wa extends Record implements CustomPacketPayload {
    private final boolean iV;
    private final boolean iW;
    private final boolean iX;
    private final boolean iY;
    private final boolean iZ;
    private final boolean ja;
    private final float ob;

    @NotNull
    public static final CustomPacketPayload.Type<C0595wa> ad = new CustomPacketPayload.Type<>(C0265jv.d("packet_vehicle_control"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0595wa> ae = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0595wa::new);

    public C0595wa(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, float f) {
        this.iV = z;
        this.iW = z2;
        this.iX = z3;
        this.iY = z4;
        this.iZ = z5;
        this.ja = z6;
        this.ob = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0595wa.class), C0595wa.class, "forward;back;left;right;sprint;space;throttle", "FIELD:Lcom/boehmod/blockfront/wa;->iV:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iW:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iX:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iY:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iZ:Z", "FIELD:Lcom/boehmod/blockfront/wa;->ja:Z", "FIELD:Lcom/boehmod/blockfront/wa;->ob:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0595wa.class), C0595wa.class, "forward;back;left;right;sprint;space;throttle", "FIELD:Lcom/boehmod/blockfront/wa;->iV:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iW:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iX:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iY:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iZ:Z", "FIELD:Lcom/boehmod/blockfront/wa;->ja:Z", "FIELD:Lcom/boehmod/blockfront/wa;->ob:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0595wa.class, Object.class), C0595wa.class, "forward;back;left;right;sprint;space;throttle", "FIELD:Lcom/boehmod/blockfront/wa;->iV:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iW:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iX:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iY:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iZ:Z", "FIELD:Lcom/boehmod/blockfront/wa;->ja:Z", "FIELD:Lcom/boehmod/blockfront/wa;->ob:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public boolean cX() {
        return this.iV;
    }

    public boolean cY() {
        return this.iW;
    }

    public boolean cZ() {
        return this.iX;
    }

    public boolean da() {
        return this.iY;
    }

    public boolean db() {
        return this.iZ;
    }

    public boolean dc() {
        return this.ja;
    }

    public float bU() {
        return this.ob;
    }

    public C0595wa(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readFloat());
    }

    public void d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.iV);
        friendlyByteBuf.writeBoolean(this.iW);
        friendlyByteBuf.writeBoolean(this.iX);
        friendlyByteBuf.writeBoolean(this.iY);
        friendlyByteBuf.writeBoolean(this.iZ);
        friendlyByteBuf.writeBoolean(this.ja);
        friendlyByteBuf.writeFloat(this.ob);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ad;
    }

    public static void a(C0595wa c0595wa, @NotNull IPayloadContext iPayloadContext) {
        Player player = iPayloadContext.player();
        Entity vehicle = player.getVehicle();
        if (vehicle instanceof AbstractC0376ny) {
            AbstractC0376ny abstractC0376ny = (AbstractC0376ny) vehicle;
            if (player.equals(abstractC0376ny.m743a())) {
                abstractC0376ny.H(c0595wa.iV);
                abstractC0376ny.I(c0595wa.iW);
                abstractC0376ny.J(c0595wa.iX);
                abstractC0376ny.K(c0595wa.iY);
                abstractC0376ny.L(c0595wa.iZ);
                abstractC0376ny.M(c0595wa.ja);
                abstractC0376ny.j(c0595wa.ob);
            }
        }
    }
}
