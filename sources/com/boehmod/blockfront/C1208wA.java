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

/* JADX INFO: renamed from: com.boehmod.blockfront.wA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wA.class */
public final class C1208wA extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: jo */
    private final boolean f6576jo;

    /* JADX INFO: renamed from: jp */
    private final boolean f6577jp;

    /* JADX INFO: renamed from: jq */
    private final boolean f6578jq;

    /* JADX INFO: renamed from: jr */
    private final boolean f6579jr;

    /* JADX INFO: renamed from: js */
    private final boolean f6580js;

    /* JADX INFO: renamed from: jt */
    private final boolean f6581jt;

    /* JADX INFO: renamed from: oZ */
    private final float f6582oZ;

    /* JADX INFO: renamed from: ad */
    @NotNull
    public static final CustomPacketPayload.Type<C1208wA> f6583ad = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_vehicle_control"));

    /* JADX INFO: renamed from: ae */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1208wA> f6584ae = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6903d(v1);
    }, C1208wA::new);

    public C1208wA(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, float f) {
        this.f6576jo = z;
        this.f6577jp = z2;
        this.f6578jq = z3;
        this.f6579jr = z4;
        this.f6580js = z5;
        this.f6581jt = z6;
        this.f6582oZ = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1208wA.class), C1208wA.class, "forward;back;left;right;sprint;space;throttle", "FIELD:Lcom/boehmod/blockfront/wA;->jo:Z", "FIELD:Lcom/boehmod/blockfront/wA;->jp:Z", "FIELD:Lcom/boehmod/blockfront/wA;->jq:Z", "FIELD:Lcom/boehmod/blockfront/wA;->jr:Z", "FIELD:Lcom/boehmod/blockfront/wA;->js:Z", "FIELD:Lcom/boehmod/blockfront/wA;->jt:Z", "FIELD:Lcom/boehmod/blockfront/wA;->oZ:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1208wA.class), C1208wA.class, "forward;back;left;right;sprint;space;throttle", "FIELD:Lcom/boehmod/blockfront/wA;->jo:Z", "FIELD:Lcom/boehmod/blockfront/wA;->jp:Z", "FIELD:Lcom/boehmod/blockfront/wA;->jq:Z", "FIELD:Lcom/boehmod/blockfront/wA;->jr:Z", "FIELD:Lcom/boehmod/blockfront/wA;->js:Z", "FIELD:Lcom/boehmod/blockfront/wA;->jt:Z", "FIELD:Lcom/boehmod/blockfront/wA;->oZ:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1208wA.class, Object.class), C1208wA.class, "forward;back;left;right;sprint;space;throttle", "FIELD:Lcom/boehmod/blockfront/wA;->jo:Z", "FIELD:Lcom/boehmod/blockfront/wA;->jp:Z", "FIELD:Lcom/boehmod/blockfront/wA;->jq:Z", "FIELD:Lcom/boehmod/blockfront/wA;->jr:Z", "FIELD:Lcom/boehmod/blockfront/wA;->js:Z", "FIELD:Lcom/boehmod/blockfront/wA;->jt:Z", "FIELD:Lcom/boehmod/blockfront/wA;->oZ:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: dg */
    public boolean m6905dg() {
        return this.f6576jo;
    }

    /* JADX INFO: renamed from: dh */
    public boolean m6906dh() {
        return this.f6577jp;
    }

    /* JADX INFO: renamed from: di */
    public boolean m6907di() {
        return this.f6578jq;
    }

    /* JADX INFO: renamed from: dj */
    public boolean m6908dj() {
        return this.f6579jr;
    }

    /* JADX INFO: renamed from: dk */
    public boolean m6909dk() {
        return this.f6580js;
    }

    /* JADX INFO: renamed from: dl */
    public boolean m6910dl() {
        return this.f6581jt;
    }

    /* JADX INFO: renamed from: ca */
    public float m6911ca() {
        return this.f6582oZ;
    }

    public C1208wA(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m6903d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f6576jo);
        friendlyByteBuf.writeBoolean(this.f6577jp);
        friendlyByteBuf.writeBoolean(this.f6578jq);
        friendlyByteBuf.writeBoolean(this.f6579jr);
        friendlyByteBuf.writeBoolean(this.f6580js);
        friendlyByteBuf.writeBoolean(this.f6581jt);
        friendlyByteBuf.writeFloat(this.f6582oZ);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6583ad;
    }

    /* JADX INFO: renamed from: a */
    public static void m6904a(C1208wA c1208wA, @NotNull IPayloadContext iPayloadContext) {
        Player player = iPayloadContext.player();
        Entity vehicle = player.getVehicle();
        if (vehicle instanceof AbstractC0750nU) {
            AbstractC0750nU abstractC0750nU = (AbstractC0750nU) vehicle;
            if (player.equals(abstractC0750nU.m3452a())) {
                abstractC0750nU.m3459I(c1208wA.f6576jo);
                abstractC0750nU.m3461J(c1208wA.f6577jp);
                abstractC0750nU.m3463K(c1208wA.f6578jq);
                abstractC0750nU.m3465L(c1208wA.f6579jr);
                abstractC0750nU.m3467M(c1208wA.f6580js);
                abstractC0750nU.m3469N(c1208wA.f6581jt);
                abstractC0750nU.m3443i(c1208wA.f6582oZ);
            }
        }
    }
}
