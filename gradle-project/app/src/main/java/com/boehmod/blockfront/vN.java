package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vN.class */
public final class vN extends Record implements CustomPacketPayload {

    @NotNull
    private final UUID P;

    @NotNull
    private final UUID Q;

    @NotNull
    private final Vec3 aE;

    /* JADX INFO: renamed from: Q, reason: collision with other field name */
    @NotNull
    public static final CustomPacketPayload.Type<vN> f321Q = new CustomPacketPayload.Type<>(C0265jv.d("packet_regular_ping_trigger"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vN> R = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vN::new);

    public vN(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        this.P = uuid;
        this.Q = uuid2;
        this.aE = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vN.class), vN.class, "playerUUID;uuid;position", "FIELD:Lcom/boehmod/blockfront/vN;->P:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vN;->Q:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vN;->aE:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vN.class), vN.class, "playerUUID;uuid;position", "FIELD:Lcom/boehmod/blockfront/vN;->P:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vN;->Q:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vN;->aE:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vN.class, Object.class), vN.class, "playerUUID;uuid;position", "FIELD:Lcom/boehmod/blockfront/vN;->P:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vN;->Q:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vN;->aE:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public UUID b() {
        return this.P;
    }

    @NotNull
    public UUID p() {
        return this.Q;
    }

    @NotNull
    public Vec3 h() {
        return this.aE;
    }

    public vN(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readUUID(), friendlyByteBuf.readVec3());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.P);
        friendlyByteBuf.writeUUID(this.Q);
        friendlyByteBuf.writeVec3(this.aE);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f321Q;
    }

    public static void b(vN vNVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vNVar, iPayloadContext);
    }
}
