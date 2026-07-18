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

/* JADX INFO: renamed from: com.boehmod.blockfront.vL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vL.class */
public final class C1165vL extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: N */
    @NotNull
    private final UUID f6158N;

    /* JADX INFO: renamed from: O */
    @NotNull
    private final UUID f6159O;

    /* JADX INFO: renamed from: aC */
    @NotNull
    private final Vec3 f6160aC;

    /* JADX INFO: renamed from: O */
    @NotNull
    public static final CustomPacketPayload.Type<C1165vL> f6161O = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_regular_ping"));

    /* JADX INFO: renamed from: P */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1165vL> f6162P = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6528d(v1);
    }, C1165vL::new);

    public C1165vL(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        this.f6158N = uuid;
        this.f6159O = uuid2;
        this.f6160aC = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1165vL.class), C1165vL.class, "playerUuid;uuid;position", "FIELD:Lcom/boehmod/blockfront/vL;->N:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vL;->O:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vL;->aC:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1165vL.class), C1165vL.class, "playerUuid;uuid;position", "FIELD:Lcom/boehmod/blockfront/vL;->N:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vL;->O:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vL;->aC:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1165vL.class, Object.class), C1165vL.class, "playerUuid;uuid;position", "FIELD:Lcom/boehmod/blockfront/vL;->N:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vL;->O:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vL;->aC:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public UUID m6530o() {
        return this.f6158N;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public UUID m6531p() {
        return this.f6159O;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m6532h() {
        return this.f6160aC;
    }

    public C1165vL(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readUUID(), friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: d */
    public void m6528d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.f6158N);
        friendlyByteBuf.writeUUID(this.f6159O);
        friendlyByteBuf.writeVec3(this.f6160aC);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6161O;
    }

    /* JADX INFO: renamed from: b */
    public static void m6529b(C1165vL c1165vL, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2966a(c1165vL, iPayloadContext);
    }
}
