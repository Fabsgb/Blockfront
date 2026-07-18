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

/* JADX INFO: renamed from: com.boehmod.blockfront.wa */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wa.class */
public final class C1233wa extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: iV */
    private final boolean f7332iV;

    /* JADX INFO: renamed from: iW */
    private final boolean f7333iW;

    /* JADX INFO: renamed from: iX */
    private final boolean f7334iX;

    /* JADX INFO: renamed from: iY */
    private final boolean f7335iY;

    /* JADX INFO: renamed from: iZ */
    private final boolean f7336iZ;

    /* JADX INFO: renamed from: ja */
    private final boolean f7337ja;

    /* JADX INFO: renamed from: ob */
    private final float f7338ob;

    /* JADX INFO: renamed from: ad */
    @NotNull
    public static final CustomPacketPayload.Type<C1233wa> f7339ad = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_vehicle_control"));

    /* JADX INFO: renamed from: ae */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1233wa> f7340ae = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7629d(v1);
    }, C1233wa::new);

    public C1233wa(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, float f) {
        this.f7332iV = z;
        this.f7333iW = z2;
        this.f7334iX = z3;
        this.f7335iY = z4;
        this.f7336iZ = z5;
        this.f7337ja = z6;
        this.f7338ob = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1233wa.class), C1233wa.class, "forward;back;left;right;sprint;space;throttle", "FIELD:Lcom/boehmod/blockfront/wa;->iV:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iW:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iX:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iY:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iZ:Z", "FIELD:Lcom/boehmod/blockfront/wa;->ja:Z", "FIELD:Lcom/boehmod/blockfront/wa;->ob:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1233wa.class), C1233wa.class, "forward;back;left;right;sprint;space;throttle", "FIELD:Lcom/boehmod/blockfront/wa;->iV:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iW:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iX:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iY:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iZ:Z", "FIELD:Lcom/boehmod/blockfront/wa;->ja:Z", "FIELD:Lcom/boehmod/blockfront/wa;->ob:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1233wa.class, Object.class), C1233wa.class, "forward;back;left;right;sprint;space;throttle", "FIELD:Lcom/boehmod/blockfront/wa;->iV:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iW:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iX:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iY:Z", "FIELD:Lcom/boehmod/blockfront/wa;->iZ:Z", "FIELD:Lcom/boehmod/blockfront/wa;->ja:Z", "FIELD:Lcom/boehmod/blockfront/wa;->ob:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: cX */
    public boolean m7631cX() {
        return this.f7332iV;
    }

    /* JADX INFO: renamed from: cY */
    public boolean m7632cY() {
        return this.f7333iW;
    }

    /* JADX INFO: renamed from: cZ */
    public boolean m7633cZ() {
        return this.f7334iX;
    }

    /* JADX INFO: renamed from: da */
    public boolean m7634da() {
        return this.f7335iY;
    }

    /* JADX INFO: renamed from: db */
    public boolean m7635db() {
        return this.f7336iZ;
    }

    /* JADX INFO: renamed from: dc */
    public boolean m7636dc() {
        return this.f7337ja;
    }

    /* JADX INFO: renamed from: bU */
    public float m7637bU() {
        return this.f7338ob;
    }

    public C1233wa(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m7629d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f7332iV);
        friendlyByteBuf.writeBoolean(this.f7333iW);
        friendlyByteBuf.writeBoolean(this.f7334iX);
        friendlyByteBuf.writeBoolean(this.f7335iY);
        friendlyByteBuf.writeBoolean(this.f7336iZ);
        friendlyByteBuf.writeBoolean(this.f7337ja);
        friendlyByteBuf.writeFloat(this.f7338ob);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7339ad;
    }

    /* JADX INFO: renamed from: a */
    public static void m7630a(C1233wa c1233wa, @NotNull IPayloadContext iPayloadContext) {
        Player player = iPayloadContext.player();
        Entity vehicle = player.getVehicle();
        if (vehicle instanceof AbstractC0779ny) {
            AbstractC0779ny abstractC0779ny = (AbstractC0779ny) vehicle;
            if (player.equals(abstractC0779ny.m3515a())) {
                abstractC0779ny.m3522H(c1233wa.f7332iV);
                abstractC0779ny.m3524I(c1233wa.f7333iW);
                abstractC0779ny.m3526J(c1233wa.f7334iX);
                abstractC0779ny.m3528K(c1233wa.f7335iY);
                abstractC0779ny.m3530L(c1233wa.f7336iZ);
                abstractC0779ny.m3532M(c1233wa.f7337ja);
                abstractC0779ny.m3506j(c1233wa.f7338ob);
            }
        }
    }
}
