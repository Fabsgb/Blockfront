package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wb.class */
public final class C1235wb extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: M */
    @NotNull
    private final UUID f6691M;

    /* JADX INFO: renamed from: j */
    private final byte[] f6692j;

    /* JADX INFO: renamed from: E */
    @NotNull
    public static final CustomPacketPayload.Type<C1235wb> f6693E = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_map_effect_sync"));

    /* JADX INFO: renamed from: F */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1235wb> f6694F = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7013d(v1);
    }, C1235wb::new);

    public C1235wb(@NotNull UUID uuid, byte[] bArr) {
        this.f6691M = uuid;
        this.f6692j = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1235wb.class), C1235wb.class, "mapEffectId;data", "FIELD:Lcom/boehmod/blockfront/wb;->M:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wb;->j:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1235wb.class), C1235wb.class, "mapEffectId;data", "FIELD:Lcom/boehmod/blockfront/wb;->M:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wb;->j:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1235wb.class, Object.class), C1235wb.class, "mapEffectId;data", "FIELD:Lcom/boehmod/blockfront/wb;->M:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wb;->j:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public UUID m7015n() {
        return this.f6691M;
    }

    /* JADX INFO: renamed from: e */
    public byte[] m7016e() {
        return this.f6692j;
    }

    public C1235wb(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m7013d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.f6691M);
        friendlyByteBuf.writeByteArray(this.f6692j);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6693E;
    }

    /* JADX INFO: renamed from: b */
    public static void m7014b(@NotNull C1235wb c1235wb, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2980a(c1235wb, iPayloadContext);
    }
}
