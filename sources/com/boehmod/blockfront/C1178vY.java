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

/* JADX INFO: renamed from: com.boehmod.blockfront.vY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vY.class */
public final class C1178vY extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: k */
    private final byte[] f6222k;

    /* JADX INFO: renamed from: ab */
    @NotNull
    public static final CustomPacketPayload.Type<C1178vY> f6223ab = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_sync_templates"));

    /* JADX INFO: renamed from: ac */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1178vY> f6224ac = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6589d(v1);
    }, C1178vY::new);

    public C1178vY(byte[] bArr) {
        this.f6222k = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1178vY.class), C1178vY.class, "data", "FIELD:Lcom/boehmod/blockfront/vY;->k:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1178vY.class), C1178vY.class, "data", "FIELD:Lcom/boehmod/blockfront/vY;->k:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1178vY.class, Object.class), C1178vY.class, "data", "FIELD:Lcom/boehmod/blockfront/vY;->k:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: e */
    public byte[] m6592e() {
        return this.f6222k;
    }

    public C1178vY(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m6589d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeByteArray(this.f6222k);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6223ab;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1178vY m6590a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(Unpooled.buffer());
        C0529jM c0529jMM2375a = C0531jO.m2372c().m2375a(C0604ki.class);
        Map mapM2358d = c0529jMM2375a != null ? c0529jMM2375a.m2358d() : Map.of();
        friendlyByteBuf.writeInt(mapM2358d.size());
        for (Map.Entry entry : mapM2358d.entrySet()) {
            friendlyByteBuf.writeUtf((String) entry.getKey());
            FriendlyByteBuf friendlyByteBuf2 = new FriendlyByteBuf(Unpooled.buffer());
            C0836pB.f4477d.encode(friendlyByteBuf2, ((C0604ki) entry.getValue()).m2645a());
            byte[] bArr = new byte[friendlyByteBuf2.readableBytes()];
            friendlyByteBuf2.readBytes(bArr);
            friendlyByteBuf2.release();
            friendlyByteBuf.writeByteArray(bArr);
        }
        Map<UUID, C0605kj> mapM5617p = abstractC0787oF.m3653a().m5617p();
        friendlyByteBuf.writeInt(mapM5617p.size());
        for (Map.Entry<UUID, C0605kj> entry2 : mapM5617p.entrySet()) {
            UUID key = entry2.getKey();
            friendlyByteBuf.writeLong(key.getMostSignificantBits());
            friendlyByteBuf.writeLong(key.getLeastSignificantBits());
            friendlyByteBuf.writeUtf(entry2.getValue().m2651A());
        }
        byte[] bArr2 = new byte[friendlyByteBuf.readableBytes()];
        friendlyByteBuf.readBytes(bArr2);
        friendlyByteBuf.release();
        return new C1178vY(bArr2);
    }

    /* JADX INFO: renamed from: b */
    public static void m6591b(@NotNull C1178vY c1178vY, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2970a(c1178vY, iPayloadContext);
    }
}
