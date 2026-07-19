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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vC.class */
public final class vC extends Record implements CustomPacketPayload {

    @NotNull
    private final UUID L;
    private final byte[] j;

    @NotNull
    public static final CustomPacketPayload.Type<vC> F = new CustomPacketPayload.Type<>(C0265jv.d("packet_map_effect_sync"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vC> G = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vC::new);

    public vC(@NotNull UUID uuid, byte[] bArr) {
        this.L = uuid;
        this.j = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vC.class), vC.class, "mapEffectId;data", "FIELD:Lcom/boehmod/blockfront/vC;->L:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vC;->j:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vC.class), vC.class, "mapEffectId;data", "FIELD:Lcom/boehmod/blockfront/vC;->L:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vC;->j:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vC.class, Object.class), vC.class, "mapEffectId;data", "FIELD:Lcom/boehmod/blockfront/vC;->L:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vC;->j:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public UUID n() {
        return this.L;
    }

    public byte[] e() {
        return this.j;
    }

    public vC(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readByteArray());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.L);
        friendlyByteBuf.writeByteArray(this.j);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return F;
    }

    public static void b(@NotNull vC vCVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vCVar, iPayloadContext);
    }
}
