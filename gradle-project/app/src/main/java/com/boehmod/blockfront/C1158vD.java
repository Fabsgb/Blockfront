package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vD.class */
public final class C1158vD extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: uz */
    private final int f6323uz;

    /* JADX INFO: renamed from: oJ */
    private final float f6324oJ;

    /* JADX INFO: renamed from: oK */
    private final float f6325oK;

    /* JADX INFO: renamed from: oL */
    private final float f6326oL;

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final CustomPacketPayload.Type<C1158vD> f6327h = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_cinematic_effect_flash"));

    /* JADX INFO: renamed from: i */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1158vD> f6328i = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6601d(v1);
    }, C1158vD::new);

    public C1158vD(int i, float f, float f2, float f3) {
        this.f6323uz = i;
        this.f6324oJ = f;
        this.f6325oK = f2;
        this.f6326oL = f3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1158vD.class), C1158vD.class, "color;speed;speedFlipped;targetAlpha", "FIELD:Lcom/boehmod/blockfront/vD;->uz:I", "FIELD:Lcom/boehmod/blockfront/vD;->oJ:F", "FIELD:Lcom/boehmod/blockfront/vD;->oK:F", "FIELD:Lcom/boehmod/blockfront/vD;->oL:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1158vD.class), C1158vD.class, "color;speed;speedFlipped;targetAlpha", "FIELD:Lcom/boehmod/blockfront/vD;->uz:I", "FIELD:Lcom/boehmod/blockfront/vD;->oJ:F", "FIELD:Lcom/boehmod/blockfront/vD;->oK:F", "FIELD:Lcom/boehmod/blockfront/vD;->oL:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1158vD.class, Object.class), C1158vD.class, "color;speed;speedFlipped;targetAlpha", "FIELD:Lcom/boehmod/blockfront/vD;->uz:I", "FIELD:Lcom/boehmod/blockfront/vD;->oJ:F", "FIELD:Lcom/boehmod/blockfront/vD;->oK:F", "FIELD:Lcom/boehmod/blockfront/vD;->oL:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: u */
    public int m6603u() {
        return this.f6323uz;
    }

    /* JADX INFO: renamed from: bQ */
    public float m6604bQ() {
        return this.f6324oJ;
    }

    /* JADX INFO: renamed from: bR */
    public float m6605bR() {
        return this.f6325oK;
    }

    /* JADX INFO: renamed from: bS */
    public float m6606bS() {
        return this.f6326oL;
    }

    public C1158vD(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: d */
    public void m6601d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f6323uz);
        friendlyByteBuf.writeFloat(this.f6324oJ);
        friendlyByteBuf.writeFloat(this.f6325oK);
        friendlyByteBuf.writeFloat(this.f6326oL);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6327h;
    }

    /* JADX INFO: renamed from: b */
    public static void m6602b(C1158vD c1158vD, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2976a(c1158vD, iPayloadContext);
    }
}
