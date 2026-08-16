package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wr.class */
public final class C1251wr extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: U */
    @NotNull
    public static final CustomPacketPayload.Type<C1251wr> f6763U;

    /* JADX INFO: renamed from: V */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1251wr> f6764V;

    /* JADX INFO: renamed from: ji */
    static final /* synthetic */ boolean f6765ji;

    public C1251wr() {
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1251wr.class), C1251wr.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1251wr.class), C1251wr.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1251wr.class, Object.class), C1251wr.class, "").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    static {
        f6765ji = !C1251wr.class.desiredAssertionStatus();
        f6763U = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_sequence_finished"));
        f6764V = CustomPacketPayload.codec((v0, v1) -> {
            v0.m7083d(v1);
        }, C1251wr::new);
    }

    public C1251wr(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this();
    }

    /* JADX INFO: renamed from: d */
    public void m7083d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6763U;
    }

    /* JADX INFO: renamed from: a */
    public static void m7084a(C1251wr c1251wr, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f6765ji && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0184c<?> abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        AbstractC0183b abstractC0183bM1153a = abstractC0184cM2351a.m1153a((Player) serverPlayerPlayer);
        if (abstractC0183bM1153a instanceof C1326ym) {
            ((C1326ym) abstractC0183bM1153a).m8298a().m8286c(serverPlayerPlayer, abstractC0184cM2351a);
        }
    }
}
