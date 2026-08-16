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

/* JADX INFO: renamed from: com.boehmod.blockfront.wf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wf.class */
public final class C1239wf extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: P */
    @NotNull
    private final C0434hW f6705P;

    /* JADX INFO: renamed from: p */
    @NotNull
    private final Vector3f f6706p;

    /* JADX INFO: renamed from: oQ */
    private final float f6707oQ;

    /* JADX INFO: renamed from: I */
    @NotNull
    public static final CustomPacketPayload.Type<C1239wf> f6708I = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_positioned_shake_node"));

    /* JADX INFO: renamed from: J */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1239wf> f6709J = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7027d(v1);
    }, C1239wf::new);

    public C1239wf(@NotNull C0434hW c0434hW, @NotNull Vector3f vector3f, float f) {
        this.f6705P = c0434hW;
        this.f6706p = vector3f;
        this.f6707oQ = f;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1239wf.class), C1239wf.class, "data;position;radius", "FIELD:Lcom/boehmod/blockfront/wf;->P:Lcom/boehmod/blockfront/hW;", "FIELD:Lcom/boehmod/blockfront/wf;->p:Lorg/joml/Vector3f;", "FIELD:Lcom/boehmod/blockfront/wf;->oQ:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1239wf.class), C1239wf.class, "data;position;radius", "FIELD:Lcom/boehmod/blockfront/wf;->P:Lcom/boehmod/blockfront/hW;", "FIELD:Lcom/boehmod/blockfront/wf;->p:Lorg/joml/Vector3f;", "FIELD:Lcom/boehmod/blockfront/wf;->oQ:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1239wf.class, Object.class), C1239wf.class, "data;position;radius", "FIELD:Lcom/boehmod/blockfront/wf;->P:Lcom/boehmod/blockfront/hW;", "FIELD:Lcom/boehmod/blockfront/wf;->p:Lorg/joml/Vector3f;", "FIELD:Lcom/boehmod/blockfront/wf;->oQ:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C0434hW m7030c() {
        return this.f6705P;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Vector3f m7031b() {
        return this.f6706p;
    }

    /* JADX INFO: renamed from: bW */
    public float m7032bW() {
        return this.f6707oQ;
    }

    public C1239wf(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(C0434hW.m2007a(friendlyByteBuf), friendlyByteBuf.readVector3f(), friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m7027d(FriendlyByteBuf friendlyByteBuf) {
        this.f6705P.m2006b(friendlyByteBuf);
        friendlyByteBuf.writeVector3f(this.f6706p);
        friendlyByteBuf.writeFloat(this.f6707oQ);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6708I;
    }

    /* JADX INFO: renamed from: b */
    public static void m7028b(C1239wf c1239wf, @NotNull IPayloadContext iPayloadContext) {
        m7029c(c1239wf, iPayloadContext);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: c */
    public static void m7029c(C1239wf c1239wf, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2963a(c1239wf, iPayloadContext);
    }
}
