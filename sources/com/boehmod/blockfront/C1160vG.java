package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.vG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vG.class */
public final class C1160vG extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: O */
    @NotNull
    private final C0417hG f6132O;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final Vector3f f6133n;

    /* JADX INFO: renamed from: nS */
    private final float f6134nS;

    /* JADX INFO: renamed from: J */
    @NotNull
    public static final CustomPacketPayload.Type<C1160vG> f6135J = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_positioned_shake_node"));

    /* JADX INFO: renamed from: K */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1160vG> f6136K = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6504d(v1);
    }, C1160vG::new);

    public C1160vG(@NotNull C0417hG c0417hG, @NotNull Vector3f vector3f, float f) {
        this.f6132O = c0417hG;
        this.f6133n = vector3f;
        this.f6134nS = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1160vG.class), C1160vG.class, "data;position;radius", "FIELD:Lcom/boehmod/blockfront/vG;->O:Lcom/boehmod/blockfront/hG;", "FIELD:Lcom/boehmod/blockfront/vG;->n:Lorg/joml/Vector3f;", "FIELD:Lcom/boehmod/blockfront/vG;->nS:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1160vG.class), C1160vG.class, "data;position;radius", "FIELD:Lcom/boehmod/blockfront/vG;->O:Lcom/boehmod/blockfront/hG;", "FIELD:Lcom/boehmod/blockfront/vG;->n:Lorg/joml/Vector3f;", "FIELD:Lcom/boehmod/blockfront/vG;->nS:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1160vG.class, Object.class), C1160vG.class, "data;position;radius", "FIELD:Lcom/boehmod/blockfront/vG;->O:Lcom/boehmod/blockfront/hG;", "FIELD:Lcom/boehmod/blockfront/vG;->n:Lorg/joml/Vector3f;", "FIELD:Lcom/boehmod/blockfront/vG;->nS:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0417hG m6507b() {
        return this.f6132O;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public Vector3f m6508d() {
        return this.f6133n;
    }

    /* JADX INFO: renamed from: bQ */
    public float m6509bQ() {
        return this.f6134nS;
    }

    public C1160vG(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(C0417hG.m1976a(friendlyByteBuf), friendlyByteBuf.readVector3f(), friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m6504d(FriendlyByteBuf friendlyByteBuf) {
        this.f6132O.m1975b(friendlyByteBuf);
        friendlyByteBuf.writeVector3f(this.f6133n);
        friendlyByteBuf.writeFloat(this.f6134nS);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6135J;
    }

    /* JADX INFO: renamed from: b */
    public static void m6505b(C1160vG c1160vG, @NotNull IPayloadContext iPayloadContext) {
        m6506c(c1160vG, iPayloadContext);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: c */
    public static void m6506c(C1160vG c1160vG, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2952a(c1160vG, iPayloadContext);
    }
}
