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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vM.class */
public final class vM extends Record implements CustomPacketPayload {

    @NotNull
    private final Vec3 aD;

    @NotNull
    public static final CustomPacketPayload.Type<vM> P;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vM> Q;
    static final /* synthetic */ boolean iN;

    public vM(@NotNull Vec3 vec3) {
        this.aD = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vM.class), vM.class, "position", "FIELD:Lcom/boehmod/blockfront/vM;->aD:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vM.class), vM.class, "position", "FIELD:Lcom/boehmod/blockfront/vM;->aD:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vM.class, Object.class), vM.class, "position", "FIELD:Lcom/boehmod/blockfront/vM;->aD:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public Vec3 h() {
        return this.aD;
    }

    static {
        iN = !vM.class.desiredAssertionStatus();
        P = new CustomPacketPayload.Type<>(C0265jv.d("packet_regular_ping_request"));
        Q = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, vM::new);
    }

    public vM(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readVec3());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVec3(this.aD);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return P;
    }

    public static void a(vM vMVar, @NotNull IPayloadContext iPayloadContext) {
        if (iM.f417de) {
            ServerPlayer serverPlayerPlayer = iPayloadContext.player();
            if (serverPlayerPlayer instanceof ServerPlayer) {
                ServerPlayer serverPlayer = serverPlayerPlayer;
                AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
                if (!iN && abstractC0264juM166a == null) {
                    throw new AssertionError("Mod manager is null!");
                }
                Object objMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
                if (objMo604a != null && (objMo604a instanceof InterfaceC0461rb)) {
                    ((InterfaceC0461rb) objMo604a).a(abstractC0264juM166a, serverPlayer, vMVar.aD);
                }
            }
        }
    }
}
