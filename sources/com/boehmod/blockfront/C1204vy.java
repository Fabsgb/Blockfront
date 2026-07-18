package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vy.class */
public final class C1204vy implements CustomPacketPayload {

    /* JADX INFO: renamed from: B */
    @NotNull
    public static final CustomPacketPayload.Type<C1204vy> f6331B;

    /* JADX INFO: renamed from: C */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1204vy> f6332C;

    /* JADX INFO: renamed from: jM */
    public static final Component f6333jM;

    /* JADX INFO: renamed from: jN */
    public static final Component f6334jN;

    /* JADX INFO: renamed from: iJ */
    static final /* synthetic */ boolean f6335iJ;

    static {
        f6335iJ = !C1204vy.class.desiredAssertionStatus();
        f6331B = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_switch_team"));
        f6332C = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6708d(v1);
        }, C1204vy::new);
        f6333jM = Component.translatable("bf.message.gamemode.switchteams.error.disabled").withStyle(ChatFormatting.RED);
        f6334jN = Component.translatable("bf.message.gamemode.switchteams.error.time").withStyle(ChatFormatting.RED);
    }

    public C1204vy() {
    }

    public C1204vy(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m6708d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6331B;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m6709a(C1204vy c1204vy, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            UUID uuid = serverPlayer.getUUID();
            ServerLevel serverLevel = serverPlayer.serverLevel();
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f6335iJ && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
            if (!(abstractC0787oFMo2531a instanceof InterfaceC0971re)) {
                C0799oR.m3970c(serverPlayer, f6333jM);
                return;
            }
            InterfaceC0971re interfaceC0971re = (InterfaceC0971re) abstractC0787oFMo2531a;
            AbstractC0790oI abstractC0790oIM3582b = abstractC0787oFMo2531a.m3582b();
            if (C0799oR.m4009a(abstractC0787oFMo2531a, uuid, C1089tp.f5708y) > 0 && !serverPlayerPlayer.isCreative()) {
                C0799oR.m3970c(serverPlayer, f6334jN);
                return;
            }
            Component componentMo5161a = interfaceC0971re.mo5161a(serverPlayer);
            if (componentMo5161a != null && !serverPlayerPlayer.isCreative()) {
                C0799oR.m3970c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.switchteams.error.condition", new Object[]{componentMo5161a}).withStyle(ChatFormatting.RED));
                return;
            }
            interfaceC0971re.mo5162b(abstractC0563juM168a, serverLevel, serverPlayer, uuid);
            C0799oR.m4011a(abstractC0787oFMo2531a, uuid, C1089tp.f5708y, interfaceC0971re.mo5163bx());
            C0799oR.m3921a(serverLevel, abstractC0787oFMo2531a, (AbstractC0790oI<?>) abstractC0790oIM3582b, serverPlayer);
        }
    }
}
