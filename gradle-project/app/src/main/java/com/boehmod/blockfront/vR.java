package com.boehmod.blockfront;

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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vR.class */
public final class vR extends Record implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<vR> U;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vR> V;
    static final /* synthetic */ boolean iP;

    public vR() {
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vR.class), vR.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vR.class), vR.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vR.class, Object.class), vR.class, "").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    static {
        iP = !vR.class.desiredAssertionStatus();
        U = new CustomPacketPayload.Type<>(C0265jv.d("packet_sequence_finished"));
        V = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, vR::new);
    }

    public vR(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this();
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return U;
    }

    public static void a(vR vRVar, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!iP && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        com.boehmod.blockfront.common.player.c<?> cVarM531a = abstractC0264juM166a.m531a();
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        com.boehmod.blockfront.common.player.b bVarM305a = cVarM531a.m305a((Player) serverPlayerPlayer);
        if (bVarM305a instanceof xO) {
            ((xO) bVarM305a).a().c(serverPlayerPlayer, cVarM531a);
        }
    }
}
