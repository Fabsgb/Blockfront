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

/* JADX INFO: renamed from: com.boehmod.blockfront.wn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wn.class */
public final class C1247wn extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: S */
    @NotNull
    private final UUID f6745S;

    /* JADX INFO: renamed from: aG */
    @NotNull
    private final Vec3 f6746aG;

    /* JADX INFO: renamed from: Q */
    @NotNull
    public static final CustomPacketPayload.Type<C1247wn> f6747Q;

    /* JADX INFO: renamed from: R */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1247wn> f6748R;

    /* JADX INFO: renamed from: jh */
    static final /* synthetic */ boolean f6749jh;

    public C1247wn(@NotNull UUID uuid, @NotNull Vec3 vec3) {
        this.f6745S = uuid;
        this.f6746aG = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1247wn.class), C1247wn.class, "uuid;position", "FIELD:Lcom/boehmod/blockfront/wn;->S:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wn;->aG:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1247wn.class), C1247wn.class, "uuid;position", "FIELD:Lcom/boehmod/blockfront/wn;->S:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wn;->aG:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1247wn.class, Object.class), C1247wn.class, "uuid;position", "FIELD:Lcom/boehmod/blockfront/wn;->S:Ljava/util/UUID;", "FIELD:Lcom/boehmod/blockfront/wn;->aG:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public UUID m7066p() {
        return this.f6745S;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m7067h() {
        return this.f6746aG;
    }

    static {
        f6749jh = !C1247wn.class.desiredAssertionStatus();
        f6747Q = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_regular_ping_trigger_request"));
        f6748R = CustomPacketPayload.codec((v0, v1) -> {
            v0.m7064d(v1);
        }, C1247wn::new);
    }

    public C1247wn(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUUID(), friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: d */
    public void m7064d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUUID(this.f6745S);
        friendlyByteBuf.writeVec3(this.f6746aG);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6747Q;
    }

    /* JADX INFO: renamed from: a */
    public static void m7065a(C1247wn c1247wn, @NotNull IPayloadContext iPayloadContext) {
        if (C0549jf.f3266do) {
            ServerPlayer serverPlayerPlayer = iPayloadContext.player();
            if (serverPlayerPlayer instanceof ServerPlayer) {
                ServerPlayer serverPlayer = serverPlayerPlayer;
                AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
                if (!f6749jh && abstractC0531jNM179a == null) {
                    throw new AssertionError("Mod manager is null!");
                }
                Object objMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
                if (objMo2354a != null && (objMo2354a instanceof InterfaceC0992ry)) {
                    ((InterfaceC0992ry) objMo2354a).mo5356a(abstractC0531jNM179a, serverPlayer, c1247wn.f6745S, c1247wn.f6746aG);
                }
            }
        }
    }
}
