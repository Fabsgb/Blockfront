package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wc.class */
public final class C1235wc extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: sI */
    private final int f7343sI;

    /* JADX INFO: renamed from: dC */
    private final String f7344dC;

    /* JADX INFO: renamed from: af */
    @NotNull
    public static final CustomPacketPayload.Type<C1235wc> f7345af = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_vehicle_fire_effect"));

    /* JADX INFO: renamed from: ag */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1235wc> f7346ag = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7640d(v1);
    }, C1235wc::new);

    public C1235wc(int i, String str) {
        this.f7343sI = i;
        this.f7344dC = str;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1235wc.class), C1235wc.class, "entityId;partName", "FIELD:Lcom/boehmod/blockfront/wc;->sI:I", "FIELD:Lcom/boehmod/blockfront/wc;->dC:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1235wc.class), C1235wc.class, "entityId;partName", "FIELD:Lcom/boehmod/blockfront/wc;->sI:I", "FIELD:Lcom/boehmod/blockfront/wc;->dC:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1235wc.class, Object.class), C1235wc.class, "entityId;partName", "FIELD:Lcom/boehmod/blockfront/wc;->sI:I", "FIELD:Lcom/boehmod/blockfront/wc;->dC:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: al */
    public int m7642al() {
        return this.f7343sI;
    }

    /* JADX INFO: renamed from: aA */
    public String m7643aA() {
        return this.f7344dC;
    }

    public C1235wc(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), friendlyByteBuf.readUtf(32767));
    }

    /* JADX INFO: renamed from: d */
    public void m7640d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f7343sI);
        friendlyByteBuf.writeUtf(this.f7344dC);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7345af;
    }

    /* JADX INFO: renamed from: b */
    public static void m7641b(C1235wc c1235wc, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2953a(c1235wc, iPayloadContext);
    }
}
