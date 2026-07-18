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

/* JADX INFO: renamed from: com.boehmod.blockfront.vN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vN.class */
public final class C1167vN extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: P */
    @NotNull
    private final UUID f6167P;

    /* JADX INFO: renamed from: Q */
    @NotNull
    private final UUID f6168Q;

    /* JADX INFO: renamed from: aE */
    @NotNull
    private final Vec3 f6169aE;

    /* JADX INFO: renamed from: Q */
    @NotNull
    public static final CustomPacketPayload.Type<C1167vN> f6170Q = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_regular_ping_trigger"));

    /* JADX INFO: renamed from: R */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1167vN> f6171R = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6536d(v1);
    }, C1167vN::new);

    public C1167vN(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        this.f6167P = uuid;
        this.f6168Q = uuid2;
        this.f6169aE = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1167vN.class), C1167vN.class, "playerUUID;uuid;position", "FIELD:Lcom/boehmod/blockfront/vN;->P:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vN;->Q:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vN;->aE:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1167vN.class), C1167vN.class, "playerUUID;uuid;position", "FIELD:Lcom/boehmod/blockfront/vN;->P:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vN;->Q:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vN;->aE:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1167vN.class, Object.class), C1167vN.class, "playerUUID;uuid;position", "FIELD:Lcom/boehmod/blockfront/vN;->P:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vN;->Q:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vN;->aE:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public UUID m6538b() {
        return this.f6167P;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public UUID m6539p() {
        return this.f6168Q;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m6540h() {
        return this.f6169aE;
    }

    public C1167vN(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readUUID(), friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: d */
    public void m6536d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.f6167P);
        friendlyByteBuf.writeUUID(this.f6168Q);
        friendlyByteBuf.writeVec3(this.f6169aE);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6170Q;
    }

    /* JADX INFO: renamed from: b */
    public static void m6537b(C1167vN c1167vN, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2967a(c1167vN, iPayloadContext);
    }
}
