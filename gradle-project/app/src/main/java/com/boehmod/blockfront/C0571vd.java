package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vd.class */
public final class C0571vd extends Record implements CustomPacketPayload {
    private final int sv;
    private final float nL;
    private final float nM;
    private final float nN;

    @NotNull
    public static final CustomPacketPayload.Type<C0571vd> h = new CustomPacketPayload.Type<>(C0265jv.d("packet_cinematic_effect_flash"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0571vd> i = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0571vd::new);

    public C0571vd(int i2, float f, float f2, float f3) {
        this.sv = i2;
        this.nL = f;
        this.nM = f2;
        this.nN = f3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0571vd.class), C0571vd.class, "color;speed;speedFlipped;targetAlpha", "FIELD:Lcom/boehmod/blockfront/vd;->sv:I", "FIELD:Lcom/boehmod/blockfront/vd;->nL:F", "FIELD:Lcom/boehmod/blockfront/vd;->nM:F", "FIELD:Lcom/boehmod/blockfront/vd;->nN:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0571vd.class), C0571vd.class, "color;speed;speedFlipped;targetAlpha", "FIELD:Lcom/boehmod/blockfront/vd;->sv:I", "FIELD:Lcom/boehmod/blockfront/vd;->nL:F", "FIELD:Lcom/boehmod/blockfront/vd;->nM:F", "FIELD:Lcom/boehmod/blockfront/vd;->nN:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0571vd.class, Object.class), C0571vd.class, "color;speed;speedFlipped;targetAlpha", "FIELD:Lcom/boehmod/blockfront/vd;->sv:I", "FIELD:Lcom/boehmod/blockfront/vd;->nL:F", "FIELD:Lcom/boehmod/blockfront/vd;->nM:F", "FIELD:Lcom/boehmod/blockfront/vd;->nN:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int q() {
        return this.sv;
    }

    public float bK() {
        return this.nL;
    }

    public float bL() {
        return this.nM;
    }

    public float bM() {
        return this.nN;
    }

    public C0571vd(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.sv);
        friendlyByteBuf.writeFloat(this.nL);
        friendlyByteBuf.writeFloat(this.nM);
        friendlyByteBuf.writeFloat(this.nN);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return h;
    }

    public static void b(C0571vd c0571vd, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0571vd, iPayloadContext);
    }
}
