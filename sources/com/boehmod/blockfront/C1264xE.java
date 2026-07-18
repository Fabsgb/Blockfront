package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.CommandEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xE.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public final class C1264xE {

    /* JADX INFO: renamed from: kg */
    private static final Component f7455kg;

    /* JADX INFO: renamed from: jJ */
    static final /* synthetic */ boolean f7456jJ;

    static {
        f7456jJ = !C1264xE.class.desiredAssertionStatus();
        f7455kg = Component.translatable("bf.message.gamemode.command.fail").withStyle(ChatFormatting.RED);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m7752a(@NotNull CommandEvent commandEvent) {
        Player player = ((CommandSourceStack) commandEvent.getParseResults().getContext().getSource()).getPlayer();
        if (player == null) {
            return;
        }
        UUID uuid = player.getUUID();
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f7456jJ && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        C0482iS c0482iSM1133a = abstractC0563juM168a.m2528a().m1133a(player);
        if (abstractC0563juM168a.mo2531a(uuid) != null && !player.hasPermissions(3) && !c0482iSM1133a.m2189j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN)) {
            commandEvent.setCanceled(true);
            C0799oR.m3970c((ServerPlayer) player, f7455kg);
        }
    }
}
