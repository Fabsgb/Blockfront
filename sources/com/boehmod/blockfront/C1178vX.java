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

/* JADX INFO: renamed from: com.boehmod.blockfront.vX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vX.class */
public final class C1178vX implements CustomPacketPayload {

    /* JADX INFO: renamed from: A */
    @NotNull
    public static final CustomPacketPayload.Type<C1178vX> f6412A;

    /* JADX INFO: renamed from: B */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1178vX> f6413B;

    /* JADX INFO: renamed from: jZ */
    public static final Component f6414jZ;

    /* JADX INFO: renamed from: ka */
    public static final Component f6415ka;

    /* JADX INFO: renamed from: jc */
    static final /* synthetic */ boolean f6416jc;

    static {
        f6416jc = !C1178vX.class.desiredAssertionStatus();
        f6412A = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_switch_team"));
        f6413B = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6701d(v1);
        }, C1178vX::new);
        f6414jZ = Component.translatable("bf.message.gamemode.switchteams.error.disabled").withStyle(ChatFormatting.RED);
        f6415ka = Component.translatable("bf.message.gamemode.switchteams.error.time").withStyle(ChatFormatting.RED);
    }

    public C1178vX() {
    }

    public C1178vX(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m6701d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6412A;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m6702a(C1178vX c1178vX, @NotNull IPayloadContext iPayloadContext) {
        ServerPlayer serverPlayerPlayer = iPayloadContext.player();
        if (serverPlayerPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer = serverPlayerPlayer;
            UUID uuid = serverPlayer.getUUID();
            ServerLevel serverLevel = serverPlayer.serverLevel();
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f6416jc && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
            if (!(abstractC0863pbMo2354a instanceof InterfaceC0943rB)) {
                C0875pn.m4406c(serverPlayer, f6414jZ);
                return;
            }
            InterfaceC0943rB interfaceC0943rB = (InterfaceC0943rB) abstractC0863pbMo2354a;
            AbstractC0866pe abstractC0866peM4018b = abstractC0863pbMo2354a.m4018b();
            if (C0875pn.m4445a(abstractC0863pbMo2354a, uuid, C1062tN.f5761y) > 0 && !serverPlayerPlayer.isCreative()) {
                C0875pn.m4406c(serverPlayer, f6415ka);
                return;
            }
            Component componentMo5178a = interfaceC0943rB.mo5178a(serverPlayer);
            if (componentMo5178a != null && !serverPlayerPlayer.isCreative()) {
                C0875pn.m4406c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.switchteams.error.condition", new Object[]{componentMo5178a}).withStyle(ChatFormatting.RED));
                return;
            }
            interfaceC0943rB.mo5179b(abstractC0531jNM179a, serverLevel, serverPlayer, uuid);
            C0875pn.m4447a(abstractC0863pbMo2354a, uuid, C1062tN.f5761y, interfaceC0943rB.mo5180bM());
            C0875pn.m4357a(serverLevel, abstractC0863pbMo2354a, (AbstractC0866pe<?>) abstractC0866peM4018b, serverPlayer);
        }
    }
}
