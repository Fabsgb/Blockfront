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

/* JADX INFO: renamed from: com.boehmod.blockfront.vy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vy.class */
public final class C0592vy implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<C0592vy> B;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0592vy> C;
    public static final Component jM;
    public static final Component jN;
    static final /* synthetic */ boolean iJ;

    static {
        iJ = !C0592vy.class.desiredAssertionStatus();
        B = new CustomPacketPayload.Type<>(C0265jv.d("packet_switch_team"));
        C = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, C0592vy::new);
        jM = Component.translatable("bf.message.gamemode.switchteams.error.disabled").withStyle(ChatFormatting.RED);
        jN = Component.translatable("bf.message.gamemode.switchteams.error.time").withStyle(ChatFormatting.RED);
    }

    public C0592vy() {
    }

    public C0592vy(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return B;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(C0592vy c0592vy, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            UUID uuid = serverPlayer.getUUID();
            ServerLevel serverLevel = serverPlayer.serverLevel();
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!iJ && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
            if (!(oFVarMo604a instanceof InterfaceC0464re)) {
                oR.c(serverPlayer, jM);
                return;
            }
            InterfaceC0464re interfaceC0464re = (InterfaceC0464re) oFVarMo604a;
            oI oIVarB = oFVarMo604a.b();
            if (oR.a(oFVarMo604a, uuid, C0529tp.y) > 0 && !serverPlayerPlayer.isCreative()) {
                oR.c(serverPlayer, jN);
                return;
            }
            Component componentA = interfaceC0464re.a(serverPlayer);
            if (componentA != null && !serverPlayerPlayer.isCreative()) {
                oR.c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.switchteams.error.condition", new Object[]{componentA}).withStyle(ChatFormatting.RED));
                return;
            }
            interfaceC0464re.b(abstractC0264juM166a, serverLevel, serverPlayer, uuid);
            oR.m792a(oFVarMo604a, uuid, C0529tp.y, interfaceC0464re.bx());
            oR.a(serverLevel, oFVarMo604a, (oI<?>) oIVarB, serverPlayer);
        }
    }
}
