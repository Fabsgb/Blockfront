package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wB.class */
public final class C1209wB extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: uM */
    private final int f6585uM;

    /* JADX INFO: renamed from: dN */
    private final String f6586dN;

    /* JADX INFO: renamed from: ae */
    @NotNull
    public static final CustomPacketPayload.Type<C1209wB> f6587ae = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_vehicle_fire_effect"));

    /* JADX INFO: renamed from: af */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1209wB> f6588af = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6912d(v1);
    }, C1209wB::new);

    public C1209wB(int i, String str) {
        this.f6585uM = i;
        this.f6586dN = str;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1209wB.class), C1209wB.class, "entityId;partName", "FIELD:Lcom/boehmod/blockfront/wB;->uM:I", "FIELD:Lcom/boehmod/blockfront/wB;->dN:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1209wB.class), C1209wB.class, "entityId;partName", "FIELD:Lcom/boehmod/blockfront/wB;->uM:I", "FIELD:Lcom/boehmod/blockfront/wB;->dN:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1209wB.class, Object.class), C1209wB.class, "entityId;partName", "FIELD:Lcom/boehmod/blockfront/wB;->uM:I", "FIELD:Lcom/boehmod/blockfront/wB;->dN:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: aB */
    public int m6914aB() {
        return this.f6585uM;
    }

    /* JADX INFO: renamed from: aH */
    public String m6915aH() {
        return this.f6586dN;
    }

    public C1209wB(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), friendlyByteBuf.readUtf(32767));
    }

    /* JADX INFO: renamed from: d */
    public void m6912d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f6585uM);
        friendlyByteBuf.writeUtf(this.f6586dN);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6587ae;
    }

    /* JADX INFO: renamed from: b */
    public static void m6913b(C1209wB c1209wB, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2964a(c1209wB, iPayloadContext);
    }
}
