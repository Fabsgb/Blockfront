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

/* JADX INFO: renamed from: com.boehmod.blockfront.vC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vC.class */
public final class C1156vC extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: L */
    @NotNull
    private final UUID f6118L;

    /* JADX INFO: renamed from: j */
    private final byte[] f6119j;

    /* JADX INFO: renamed from: F */
    @NotNull
    public static final CustomPacketPayload.Type<C1156vC> f6120F = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_map_effect_sync"));

    /* JADX INFO: renamed from: G */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1156vC> f6121G = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6490d(v1);
    }, C1156vC::new);

    public C1156vC(@NotNull UUID uuid, byte[] bArr) {
        this.f6118L = uuid;
        this.f6119j = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1156vC.class), C1156vC.class, "mapEffectId;data", "FIELD:Lcom/boehmod/blockfront/vC;->L:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vC;->j:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1156vC.class), C1156vC.class, "mapEffectId;data", "FIELD:Lcom/boehmod/blockfront/vC;->L:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vC;->j:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1156vC.class, Object.class), C1156vC.class, "mapEffectId;data", "FIELD:Lcom/boehmod/blockfront/vC;->L:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vC;->j:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public UUID m6492n() {
        return this.f6118L;
    }

    /* JADX INFO: renamed from: e */
    public byte[] m6493e() {
        return this.f6119j;
    }

    public C1156vC(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m6490d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.f6118L);
        friendlyByteBuf.writeByteArray(this.f6119j);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6120F;
    }

    /* JADX INFO: renamed from: b */
    public static void m6491b(@NotNull C1156vC c1156vC, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2969a(c1156vC, iPayloadContext);
    }
}
