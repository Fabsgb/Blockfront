package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vO.class */
public final class C1168vO extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: R */
    @NotNull
    private final UUID f6172R;

    /* JADX INFO: renamed from: aF */
    @NotNull
    private final Vec3 f6173aF;

    /* JADX INFO: renamed from: R */
    @NotNull
    public static final CustomPacketPayload.Type<C1168vO> f6174R;

    /* JADX INFO: renamed from: S */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1168vO> f6175S;

    /* JADX INFO: renamed from: iO */
    static final /* synthetic */ boolean f6176iO;

    public C1168vO(@NotNull UUID uuid, @NotNull Vec3 vec3) {
        this.f6172R = uuid;
        this.f6173aF = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1168vO.class), C1168vO.class, "uuid;position", "FIELD:Lcom/boehmod/blockfront/vO;->R:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vO;->aF:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1168vO.class), C1168vO.class, "uuid;position", "FIELD:Lcom/boehmod/blockfront/vO;->R:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vO;->aF:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1168vO.class, Object.class), C1168vO.class, "uuid;position", "FIELD:Lcom/boehmod/blockfront/vO;->R:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vO;->aF:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public UUID m6543p() {
        return this.f6172R;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m6544h() {
        return this.f6173aF;
    }

    static {
        f6176iO = !C1168vO.class.desiredAssertionStatus();
        f6174R = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_regular_ping_trigger_request"));
        f6175S = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6541d(v1);
        }, C1168vO::new);
    }

    public C1168vO(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: d */
    public void m6541d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.f6172R);
        friendlyByteBuf.writeVec3(this.f6173aF);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6174R;
    }

    /* JADX INFO: renamed from: a */
    public static void m6542a(C1168vO c1168vO, @NotNull IPayloadContext iPayloadContext) {
        if (C0476iM.f2917de) {
            ServerPlayer serverPlayerPlayer = iPayloadContext.player();
            if (serverPlayerPlayer instanceof ServerPlayer) {
                ServerPlayer serverPlayer = serverPlayerPlayer;
                AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
                if (!f6176iO && abstractC0563juM168a == null) {
                    throw new AssertionError("Mod manager is null!");
                }
                Object objMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
                if (objMo2531a != null && (objMo2531a instanceof InterfaceC0968rb)) {
                    ((InterfaceC0968rb) objMo2531a).mo5173a(abstractC0563juM168a, serverPlayer, c1168vO.f6172R, c1168vO.f6173aF);
                }
            }
        }
    }
}
