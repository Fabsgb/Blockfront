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

/* JADX INFO: renamed from: com.boehmod.blockfront.lW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lW.class */
public class C0645lW {

    /* JADX INFO: renamed from: ec */
    static final /* synthetic */ boolean f3538ec;

    static {
        f3538ec = !C0645lW.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m2895b(@NotNull CommandSourceStack commandSourceStack) {
        Player entity = commandSourceStack.getEntity();
        if (!(entity instanceof ServerPlayer)) {
            return false;
        }
        Player player = (ServerPlayer) entity;
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (f3538ec || abstractC0563juM168a != null) {
            return abstractC0563juM168a.m2528a().m1133a(player).m2189j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN) || commandSourceStack.hasPermission(3);
        }
        throw new AssertionError("Mod manager is null!");
    }

    /* JADX INFO: renamed from: a */
    public static void m2896a(@NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        C0799oR.m3973a(serverPlayer, (Component) Component.literal("bf".toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.BOLD).append(" "), component);
    }

    /* JADX INFO: renamed from: a */
    public static void m2897a(@NotNull CommandSource commandSource, @NotNull Component component) {
        commandSource.sendSystemMessage(Component.empty().append(Component.literal("[BFA Warn]:").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED)).append(" ").append(component.copy().withColor(ColorReferences.COLOR_WHITE)));
    }

    /* JADX INFO: renamed from: b */
    public static void m2898b(@NotNull CommandSource commandSource, @NotNull Component component) {
        commandSource.sendSystemMessage(Component.empty().append(Component.literal("[BFA]:").withStyle(ChatFormatting.BOLD).withStyle(C0565jw.f3203d)).append(" ").append(component.copy().withColor(ColorReferences.COLOR_WHITE)));
    }
}
