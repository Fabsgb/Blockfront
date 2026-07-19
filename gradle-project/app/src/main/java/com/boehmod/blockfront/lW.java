package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.common.ColorReferences;
import java.util.Locale;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lW.class */
public class lW {
    static final /* synthetic */ boolean ec;

    static {
        ec = !lW.class.desiredAssertionStatus();
    }

    public static boolean b(@NotNull CommandSourceStack commandSourceStack) {
        Player entity = commandSourceStack.getEntity();
        if (!(entity instanceof ServerPlayer)) {
            return false;
        }
        Player player = (ServerPlayer) entity;
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (ec || abstractC0264juM166a != null) {
            return abstractC0264juM166a.m531a().a(player).j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN) || commandSourceStack.hasPermission(3);
        }
        throw new AssertionError("Mod manager is null!");
    }

    public static void a(@NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        oR.a(serverPlayer, (Component) Component.literal("bf".toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.BOLD).append(" "), component);
    }

    public static void a(@NotNull CommandSource commandSource, @NotNull Component component) {
        commandSource.sendSystemMessage(Component.empty().append(Component.literal("[BFA Warn]:").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED)).append(" ").append(component.copy().withColor(ColorReferences.COLOR_WHITE)));
    }

    public static void b(@NotNull CommandSource commandSource, @NotNull Component component) {
        commandSource.sendSystemMessage(Component.empty().append(Component.literal("[BFA]:").withStyle(ChatFormatting.BOLD).withStyle(C0266jw.d)).append(" ").append(component.copy().withColor(ColorReferences.COLOR_WHITE)));
    }
}
