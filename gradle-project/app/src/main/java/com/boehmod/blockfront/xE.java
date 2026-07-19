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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xE.class */
@EventBusSubscriber(modid = "bf", value = {Dist.DEDICATED_SERVER})
public final class xE {
    private static final Component kg;
    static final /* synthetic */ boolean jJ;

    static {
        jJ = !xE.class.desiredAssertionStatus();
        kg = Component.translatable("bf.message.gamemode.command.fail").withStyle(ChatFormatting.RED);
    }

    @SubscribeEvent
    public static void a(@NotNull CommandEvent commandEvent) {
        Player player = ((CommandSourceStack) commandEvent.getParseResults().getContext().getSource()).getPlayer();
        if (player == null) {
            return;
        }
        UUID uuid = player.getUUID();
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!jJ && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        iS iSVarA = abstractC0264juM166a.m531a().a(player);
        if (abstractC0264juM166a.mo604a(uuid) != null && !player.hasPermissions(3) && !iSVarA.j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN)) {
            commandEvent.setCanceled(true);
            oR.c((ServerPlayer) player, kg);
        }
    }
}
