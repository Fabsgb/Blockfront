package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vR.class */
public final class C1171vR extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: U */
    @NotNull
    public static final CustomPacketPayload.Type<C1171vR> f6187U;

    /* JADX INFO: renamed from: V */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1171vR> f6188V;

    /* JADX INFO: renamed from: iP */
    static final /* synthetic */ boolean f6189iP;

    public C1171vR() {
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1171vR.class), C1171vR.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1171vR.class), C1171vR.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1171vR.class, Object.class), C1171vR.class, "").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    static {
        f6189iP = !C1171vR.class.desiredAssertionStatus();
        f6187U = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_sequence_finished"));
        f6188V = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6557d(v1);
        }, C1171vR::new);
    }

    public C1171vR(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this();
    }

    /* JADX INFO: renamed from: d */
    public void m6557d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6187U;
    }

    /* JADX INFO: renamed from: a */
    public static void m6558a(C1171vR c1171vR, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f6189iP && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0183c<?> abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        AbstractC0182b abstractC0182bM1136a = abstractC0183cM2528a.m1136a((Player) serverPlayerPlayer);
        if (abstractC0182bM1136a instanceof C1274xO) {
            ((C1274xO) abstractC0182bM1136a).m7782a().m7770c(serverPlayerPlayer, abstractC0183cM2528a);
        }
    }
}
