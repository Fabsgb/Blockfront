package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vM.class */
public final class C1166vM extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: aD */
    @NotNull
    private final Vec3 f6163aD;

    /* JADX INFO: renamed from: P */
    @NotNull
    public static final CustomPacketPayload.Type<C1166vM> f6164P;

    /* JADX INFO: renamed from: Q */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1166vM> f6165Q;

    /* JADX INFO: renamed from: iN */
    static final /* synthetic */ boolean f6166iN;

    public C1166vM(@NotNull Vec3 vec3) {
        this.f6163aD = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1166vM.class), C1166vM.class, "position", "FIELD:Lcom/boehmod/blockfront/vM;->aD:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1166vM.class), C1166vM.class, "position", "FIELD:Lcom/boehmod/blockfront/vM;->aD:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1166vM.class, Object.class), C1166vM.class, "position", "FIELD:Lcom/boehmod/blockfront/vM;->aD:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m6535h() {
        return this.f6163aD;
    }

    static {
        f6166iN = !C1166vM.class.desiredAssertionStatus();
        f6164P = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_regular_ping_request"));
        f6165Q = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6533d(v1);
        }, C1166vM::new);
    }

    public C1166vM(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: d */
    public void m6533d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVec3(this.f6163aD);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6164P;
    }

    /* JADX INFO: renamed from: a */
    public static void m6534a(C1166vM c1166vM, @NotNull IPayloadContext iPayloadContext) {
        if (C0476iM.f2917de) {
            ServerPlayer serverPlayerPlayer = iPayloadContext.player();
            if (serverPlayerPlayer instanceof ServerPlayer) {
                ServerPlayer serverPlayer = serverPlayerPlayer;
                AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
                if (!f6166iN && abstractC0563juM168a == null) {
                    throw new AssertionError("Mod manager is null!");
                }
                Object objMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
                if (objMo2531a != null && (objMo2531a instanceof InterfaceC0968rb)) {
                    ((InterfaceC0968rb) objMo2531a).mo5172a(abstractC0563juM168a, serverPlayer, c1166vM.f6163aD);
                }
            }
        }
    }
}
