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

/* JADX INFO: renamed from: com.boehmod.blockfront.wl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wl.class */
public final class C1245wl extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: aE */
    @NotNull
    private final Vec3 f6736aE;

    /* JADX INFO: renamed from: O */
    @NotNull
    public static final CustomPacketPayload.Type<C1245wl> f6737O;

    /* JADX INFO: renamed from: P */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1245wl> f6738P;

    /* JADX INFO: renamed from: jg */
    static final /* synthetic */ boolean f6739jg;

    public C1245wl(@NotNull Vec3 vec3) {
        this.f6736aE = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1245wl.class), C1245wl.class, "position", "FIELD:Lcom/boehmod/blockfront/wl;->aE:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1245wl.class), C1245wl.class, "position", "FIELD:Lcom/boehmod/blockfront/wl;->aE:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1245wl.class, Object.class), C1245wl.class, "position", "FIELD:Lcom/boehmod/blockfront/wl;->aE:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m7058h() {
        return this.f6736aE;
    }

    static {
        f6739jg = !C1245wl.class.desiredAssertionStatus();
        f6737O = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_regular_ping_request"));
        f6738P = CustomPacketPayload.codec((v0, v1) -> {
            v0.m7056d(v1);
        }, C1245wl::new);
    }

    public C1245wl(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readVec3());
    }

    /* JADX INFO: renamed from: d */
    public void m7056d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVec3(this.f6736aE);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6737O;
    }

    /* JADX INFO: renamed from: a */
    public static void m7057a(C1245wl c1245wl, @NotNull IPayloadContext iPayloadContext) {
        if (C0549jf.f3266do) {
            ServerPlayer serverPlayerPlayer = iPayloadContext.player();
            if (serverPlayerPlayer instanceof ServerPlayer) {
                ServerPlayer serverPlayer = serverPlayerPlayer;
                AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
                if (!f6739jg && abstractC0531jNM179a == null) {
                    throw new AssertionError("Mod manager is null!");
                }
                Object objMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
                if (objMo2354a != null && (objMo2354a instanceof InterfaceC0992ry)) {
                    ((InterfaceC0992ry) objMo2354a).mo5355a(abstractC0531jNM179a, serverPlayer, c1245wl.f6736aE);
                }
            }
        }
    }
}
