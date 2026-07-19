package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wc.class */
public final class C0597wc extends Record implements CustomPacketPayload {
    private final int sI;
    private final String dC;

    @NotNull
    public static final CustomPacketPayload.Type<C0597wc> af = new CustomPacketPayload.Type<>(C0265jv.d("packet_vehicle_fire_effect"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0597wc> ag = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0597wc::new);

    public C0597wc(int i, String str) {
        this.sI = i;
        this.dC = str;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0597wc.class), C0597wc.class, "entityId;partName", "FIELD:Lcom/boehmod/blockfront/wc;->sI:I", "FIELD:Lcom/boehmod/blockfront/wc;->dC:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0597wc.class), C0597wc.class, "entityId;partName", "FIELD:Lcom/boehmod/blockfront/wc;->sI:I", "FIELD:Lcom/boehmod/blockfront/wc;->dC:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0597wc.class, Object.class), C0597wc.class, "entityId;partName", "FIELD:Lcom/boehmod/blockfront/wc;->sI:I", "FIELD:Lcom/boehmod/blockfront/wc;->dC:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int al() {
        return this.sI;
    }

    public String aA() {
        return this.dC;
    }

    public C0597wc(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), friendlyByteBuf.readUtf(32767));
    }

    public void d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.sI);
        friendlyByteBuf.writeUtf(this.dC);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return af;
    }

    public static void b(C0597wc c0597wc, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0597wc, iPayloadContext);
    }
}
