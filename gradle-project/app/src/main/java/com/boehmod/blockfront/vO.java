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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vO.class */
public final class vO extends Record implements CustomPacketPayload {

    @NotNull
    private final UUID R;

    @NotNull
    private final Vec3 aF;

    /* JADX INFO: renamed from: R, reason: collision with other field name */
    @NotNull
    public static final CustomPacketPayload.Type<vO> f322R;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vO> S;
    static final /* synthetic */ boolean iO;

    public vO(@NotNull UUID uuid, @NotNull Vec3 vec3) {
        this.R = uuid;
        this.aF = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vO.class), vO.class, "uuid;position", "FIELD:Lcom/boehmod/blockfront/vO;->R:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vO;->aF:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vO.class), vO.class, "uuid;position", "FIELD:Lcom/boehmod/blockfront/vO;->R:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vO;->aF:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vO.class, Object.class), vO.class, "uuid;position", "FIELD:Lcom/boehmod/blockfront/vO;->R:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/vO;->aF:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public UUID p() {
        return this.R;
    }

    @NotNull
    public Vec3 h() {
        return this.aF;
    }

    static {
        iO = !vO.class.desiredAssertionStatus();
        f322R = new CustomPacketPayload.Type<>(C0265jv.d("packet_regular_ping_trigger_request"));
        S = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, vO::new);
    }

    public vO(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readVec3());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.R);
        friendlyByteBuf.writeVec3(this.aF);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f322R;
    }

    public static void a(vO vOVar, @NotNull IPayloadContext iPayloadContext) {
        if (iM.f417de) {
            ServerPlayer serverPlayerPlayer = iPayloadContext.player();
            if (serverPlayerPlayer instanceof ServerPlayer) {
                ServerPlayer serverPlayer = serverPlayerPlayer;
                AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
                if (!iO && abstractC0264juM166a == null) {
                    throw new AssertionError("Mod manager is null!");
                }
                Object objMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
                if (objMo604a != null && (objMo604a instanceof InterfaceC0461rb)) {
                    ((InterfaceC0461rb) objMo604a).a(abstractC0264juM166a, serverPlayer, vOVar.R, vOVar.aF);
                }
            }
        }
    }
}
