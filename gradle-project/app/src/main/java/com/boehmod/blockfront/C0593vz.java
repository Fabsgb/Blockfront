package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vz.class */
public final class C0593vz implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<C0593vz> C;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0593vz> D;
    static final /* synthetic */ boolean iK;

    static {
        iK = !C0593vz.class.desiredAssertionStatus();
        C = new CustomPacketPayload.Type<>(C0265jv.d("packet_war_cry"));
        D = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, C0593vz::new);
    }

    public C0593vz() {
    }

    public C0593vz(FriendlyByteBuf friendlyByteBuf) {
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return C;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(C0593vz c0593vz, @NotNull IPayloadContext iPayloadContext) {
        oO oOVarA;
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            UUID uuid = serverPlayer.getUUID();
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!iK && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
            if (oFVarMo604a instanceof InterfaceC0466rg) {
                InterfaceC0466rg interfaceC0466rg = (InterfaceC0466rg) oFVarMo604a;
                com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
                Level level = serverPlayer.level();
                if (InterfaceC0466rg.a(cVarM531a, serverPlayer) && interfaceC0466rg.a(level, serverPlayer, uuid) && (oOVarA = oFVarMo604a.b().a(uuid)) != null) {
                    interfaceC0466rg.mo1024a(level, serverPlayer, uuid);
                    InterfaceC0466rg.a(oFVarMo604a, oOVarA.a(oFVarMo604a), serverPlayer, uuid);
                }
            }
        }
    }
}
