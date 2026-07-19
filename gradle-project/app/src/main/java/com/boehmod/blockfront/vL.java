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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vL.class */
public final class vL extends Record implements CustomPacketPayload {

    @NotNull
    private final UUID N;

    @NotNull
    private final UUID O;

    @NotNull
    private final Vec3 aC;

    /* JADX INFO: renamed from: O, reason: collision with other field name */
    @NotNull
    public static final CustomPacketPayload.Type<vL> f320O = new CustomPacketPayload.Type<>(C0265jv.d("packet_regular_ping"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vL> P = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vL::new);

    public vL(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        this.N = uuid;
        this.O = uuid2;
        this.aC = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vL.class), vL.class, "playerUuid;uuid;position", "FIELD:Lcom/boehmod/blockfront/vL;->N:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vL;->O:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vL;->aC:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vL.class), vL.class, "playerUuid;uuid;position", "FIELD:Lcom/boehmod/blockfront/vL;->N:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vL;->O:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vL;->aC:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vL.class, Object.class), vL.class, "playerUuid;uuid;position", "FIELD:Lcom/boehmod/blockfront/vL;->N:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vL;->O:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vL;->aC:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public UUID o() {
        return this.N;
    }

    @NotNull
    public UUID p() {
        return this.O;
    }

    @NotNull
    public Vec3 h() {
        return this.aC;
    }

    public vL(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readUUID(), friendlyByteBuf.readVec3());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.N);
        friendlyByteBuf.writeUUID(this.O);
        friendlyByteBuf.writeVec3(this.aC);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f320O;
    }

    public static void b(vL vLVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vLVar, iPayloadContext);
    }
}
