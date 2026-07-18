package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vz.class */
public final class C1205vz implements CustomPacketPayload {

    /* JADX INFO: renamed from: C */
    @NotNull
    public static final CustomPacketPayload.Type<C1205vz> f6336C;

    /* JADX INFO: renamed from: D */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1205vz> f6337D;

    /* JADX INFO: renamed from: iK */
    static final /* synthetic */ boolean f6338iK;

    static {
        f6338iK = !C1205vz.class.desiredAssertionStatus();
        f6336C = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_war_cry"));
        f6337D = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6710d(v1);
        }, C1205vz::new);
    }

    public C1205vz() {
    }

    public C1205vz(FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m6710d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6336C;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m6711a(C1205vz c1205vz, @NotNull IPayloadContext iPayloadContext) {
        C0796oO c0796oOM3793a;
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            UUID uuid = serverPlayer.getUUID();
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f6338iK && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
            if (abstractC0787oFMo2531a instanceof InterfaceC0973rg) {
                InterfaceC0973rg interfaceC0973rg = (InterfaceC0973rg) abstractC0787oFMo2531a;
                AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
                Level level = serverPlayer.level();
                if (InterfaceC0973rg.m5309a(abstractC0183cM2528a, serverPlayer) && interfaceC0973rg.mo5169a(level, serverPlayer, uuid) && (c0796oOM3793a = abstractC0787oFMo2531a.m3582b().m3793a(uuid)) != null) {
                    interfaceC0973rg.mo5170a(level, serverPlayer, uuid);
                    InterfaceC0973rg.m5310a(abstractC0787oFMo2531a, c0796oOM3793a.m3860a(abstractC0787oFMo2531a), serverPlayer, uuid);
                }
            }
        }
    }
}
