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

/* JADX INFO: renamed from: com.boehmod.blockfront.wy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wy.class */
public final class C1258wy extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: k */
    private final byte[] f6798k;

    /* JADX INFO: renamed from: ab */
    @NotNull
    public static final CustomPacketPayload.Type<C1258wy> f6799ab = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_sync_templates"));

    /* JADX INFO: renamed from: ac */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1258wy> f6800ac = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7115d(v1);
    }, C1258wy::new);

    public C1258wy(byte[] bArr) {
        this.f6798k = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1258wy.class), C1258wy.class, "data", "FIELD:Lcom/boehmod/blockfront/wy;->k:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1258wy.class), C1258wy.class, "data", "FIELD:Lcom/boehmod/blockfront/wy;->k:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1258wy.class, Object.class), C1258wy.class, "data", "FIELD:Lcom/boehmod/blockfront/wy;->k:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: e */
    public byte[] m7118e() {
        return this.f6798k;
    }

    public C1258wy(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m7115d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeByteArray(this.f6798k);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6799ab;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1258wy m7116a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(Unpooled.buffer());
        C0605ki c0605kiM2737a = C0607kk.m2734c().m2737a(C0575kE.class);
        Map mapM2720d = c0605kiM2737a != null ? c0605kiM2737a.m2720d() : Map.of();
        friendlyByteBuf.writeInt(mapM2720d.size());
        for (Map.Entry entry : mapM2720d.entrySet()) {
            friendlyByteBuf.writeUtf((String) entry.getKey());
            FriendlyByteBuf friendlyByteBuf2 = new FriendlyByteBuf(Unpooled.buffer());
            C0859pX.f4606d.encode(friendlyByteBuf2, ((C0575kE) entry.getValue()).m2595a());
            byte[] bArr = new byte[friendlyByteBuf2.readableBytes()];
            friendlyByteBuf2.readBytes(bArr);
            friendlyByteBuf2.release();
            friendlyByteBuf.writeByteArray(bArr);
        }
        Map<UUID, C0576kF> mapM6105p = abstractC0863pb.m4089a().m6105p();
        friendlyByteBuf.writeInt(mapM6105p.size());
        for (Map.Entry<UUID, C0576kF> entry2 : mapM6105p.entrySet()) {
            UUID key = entry2.getKey();
            friendlyByteBuf.writeLong(key.getMostSignificantBits());
            friendlyByteBuf.writeLong(key.getLeastSignificantBits());
            friendlyByteBuf.writeUtf(entry2.getValue().m2604H());
        }
        byte[] bArr2 = new byte[friendlyByteBuf.readableBytes()];
        friendlyByteBuf.readBytes(bArr2);
        friendlyByteBuf.release();
        return new C1258wy(bArr2);
    }

    /* JADX INFO: renamed from: b */
    public static void m7117b(@NotNull C1258wy c1258wy, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2981a(c1258wy, iPayloadContext);
    }
}
