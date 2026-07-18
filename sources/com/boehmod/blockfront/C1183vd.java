package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vd.class */
public final class C1183vd extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: sv */
    private final int f6239sv;

    /* JADX INFO: renamed from: nL */
    private final float f6240nL;

    /* JADX INFO: renamed from: nM */
    private final float f6241nM;

    /* JADX INFO: renamed from: nN */
    private final float f6242nN;

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final CustomPacketPayload.Type<C1183vd> f6243h = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_cinematic_effect_flash"));

    /* JADX INFO: renamed from: i */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1183vd> f6244i = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6606d(v1);
    }, C1183vd::new);

    public C1183vd(int i, float f, float f2, float f3) {
        this.f6239sv = i;
        this.f6240nL = f;
        this.f6241nM = f2;
        this.f6242nN = f3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1183vd.class), C1183vd.class, "color;speed;speedFlipped;targetAlpha", "FIELD:Lcom/boehmod/blockfront/vd;->sv:I", "FIELD:Lcom/boehmod/blockfront/vd;->nL:F", "FIELD:Lcom/boehmod/blockfront/vd;->nM:F", "FIELD:Lcom/boehmod/blockfront/vd;->nN:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1183vd.class), C1183vd.class, "color;speed;speedFlipped;targetAlpha", "FIELD:Lcom/boehmod/blockfront/vd;->sv:I", "FIELD:Lcom/boehmod/blockfront/vd;->nL:F", "FIELD:Lcom/boehmod/blockfront/vd;->nM:F", "FIELD:Lcom/boehmod/blockfront/vd;->nN:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1183vd.class, Object.class), C1183vd.class, "color;speed;speedFlipped;targetAlpha", "FIELD:Lcom/boehmod/blockfront/vd;->sv:I", "FIELD:Lcom/boehmod/blockfront/vd;->nL:F", "FIELD:Lcom/boehmod/blockfront/vd;->nM:F", "FIELD:Lcom/boehmod/blockfront/vd;->nN:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: q */
    public int m6608q() {
        return this.f6239sv;
    }

    /* JADX INFO: renamed from: bK */
    public float m6609bK() {
        return this.f6240nL;
    }

    /* JADX INFO: renamed from: bL */
    public float m6610bL() {
        return this.f6241nM;
    }

    /* JADX INFO: renamed from: bM */
    public float m6611bM() {
        return this.f6242nN;
    }

    public C1183vd(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m6606d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f6239sv);
        friendlyByteBuf.writeFloat(this.f6240nL);
        friendlyByteBuf.writeFloat(this.f6241nM);
        friendlyByteBuf.writeFloat(this.f6242nN);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6243h;
    }

    /* JADX INFO: renamed from: b */
    public static void m6607b(C1183vd c1183vd, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2965a(c1183vd, iPayloadContext);
    }
}
