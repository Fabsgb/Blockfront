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

/* JADX INFO: renamed from: com.boehmod.blockfront.wm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wm.class */
public final class C1246wm extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: Q */
    @NotNull
    private final UUID f6740Q;

    /* JADX INFO: renamed from: R */
    @NotNull
    private final UUID f6741R;

    /* JADX INFO: renamed from: aF */
    @NotNull
    private final Vec3 f6742aF;

    /* JADX INFO: renamed from: P */
    @NotNull
    public static final CustomPacketPayload.Type<C1246wm> f6743P = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_regular_ping_trigger"));

    /* JADX INFO: renamed from: Q */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1246wm> f6744Q = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7059d(v1);
    }, C1246wm::new);

    public C1246wm(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        this.f6740Q = uuid;
        this.f6741R = uuid2;
        this.f6742aF = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1246wm.class), C1246wm.class, "playerUUID;uuid;position", "FIELD:Lcom/boehmod/blockfront/wm;->Q:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wm;->R:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wm;->aF:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1246wm.class), C1246wm.class, "playerUUID;uuid;position", "FIELD:Lcom/boehmod/blockfront/wm;->Q:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wm;->R:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wm;->aF:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1246wm.class, Object.class), C1246wm.class, "playerUUID;uuid;position", "FIELD:Lcom/boehmod/blockfront/wm;->Q:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wm;->R:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wm;->aF:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public UUID m7061b() {
        return this.f6740Q;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public UUID m7062p() {
        return this.f6741R;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m7063h() {
        return this.f6742aF;
    }

    public C1246wm(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readUUID(), friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: d */
    public void m7059d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.f6740Q);
        friendlyByteBuf.writeUUID(this.f6741R);
        friendlyByteBuf.writeVec3(this.f6742aF);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6743P;
    }

    /* JADX INFO: renamed from: b */
    public static void m7060b(C1246wm c1246wm, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2978a(c1246wm, iPayloadContext);
    }
}
