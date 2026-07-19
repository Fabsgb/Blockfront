package com.boehmod.blockfront;

import io.netty.buffer.Unpooled;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vY.class */
public final class vY extends Record implements CustomPacketPayload {
    private final byte[] k;

    @NotNull
    public static final CustomPacketPayload.Type<vY> ab = new CustomPacketPayload.Type<>(C0265jv.d("packet_sync_templates"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vY> ac = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vY::new);

    public vY(byte[] bArr) {
        this.k = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vY.class), vY.class, "data", "FIELD:Lcom/boehmod/blockfront/vY;->k:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vY.class), vY.class, "data", "FIELD:Lcom/boehmod/blockfront/vY;->k:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vY.class, Object.class), vY.class, "data", "FIELD:Lcom/boehmod/blockfront/vY;->k:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public byte[] e() {
        return this.k;
    }

    public vY(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readByteArray());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeByteArray(this.k);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ab;
    }

    @NotNull
    public static vY a(@NotNull oF<?, ?, ?> oFVar) {
        FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(Unpooled.buffer());
        jM jMVarA = jO.c().a(C0279ki.class);
        Map mapD = jMVarA != null ? jMVarA.d() : Map.of();
        friendlyByteBuf.writeInt(mapD.size());
        for (Map.Entry entry : mapD.entrySet()) {
            friendlyByteBuf.writeUtf((String) entry.getKey());
            FriendlyByteBuf friendlyByteBuf2 = new FriendlyByteBuf(Unpooled.buffer());
            pB.d.encode(friendlyByteBuf2, ((C0279ki) entry.getValue()).a());
            byte[] bArr = new byte[friendlyByteBuf2.readableBytes()];
            friendlyByteBuf2.readBytes(bArr);
            friendlyByteBuf2.release();
            friendlyByteBuf.writeByteArray(bArr);
        }
        Map<UUID, C0280kj> mapP = oFVar.m767a().p();
        friendlyByteBuf.writeInt(mapP.size());
        for (Map.Entry<UUID, C0280kj> entry2 : mapP.entrySet()) {
            UUID key = entry2.getKey();
            friendlyByteBuf.writeLong(key.getMostSignificantBits());
            friendlyByteBuf.writeLong(key.getLeastSignificantBits());
            friendlyByteBuf.writeUtf(entry2.getValue().A());
        }
        byte[] bArr2 = new byte[friendlyByteBuf.readableBytes()];
        friendlyByteBuf.readBytes(bArr2);
        friendlyByteBuf.release();
        return new vY(bArr2);
    }

    public static void b(@NotNull vY vYVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vYVar, iPayloadContext);
    }
}
