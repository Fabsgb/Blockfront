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

/* JADX INFO: renamed from: com.boehmod.blockfront.ms */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ms.class */
public class C0721ms {

    /* JADX INFO: renamed from: ev */
    static final /* synthetic */ boolean f4012ev;

    static {
        f4012ev = !C0721ms.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m3326b(@NotNull CommandSourceStack commandSourceStack) {
        Player entity = commandSourceStack.getEntity();
        if (!(entity instanceof ServerPlayer)) {
            return false;
        }
        Player player = (ServerPlayer) entity;
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (f4012ev || abstractC0531jNM179a != null) {
            return abstractC0531jNM179a.m2351a().m1150a(player).m2516l(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN) || commandSourceStack.hasPermission(3);
        }
        throw new AssertionError("Mod manager is null!");
    }

    /* JADX INFO: renamed from: a */
    public static void m3327a(@NotNull ServerPlayer serverPlayer, @NotNull Component component) {
        C0875pn.m4409a(serverPlayer, (Component) Component.literal("bf".toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.BOLD).append(" "), component);
    }

    /* JADX INFO: renamed from: a */
    public static void m3328a(@NotNull CommandSource commandSource, @NotNull Component component) {
        commandSource.sendSystemMessage(Component.empty().append(Component.literal("[BFA Warn]:").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED)).append(" ").append(component.copy().withColor(ColorReferences.COLOR_WHITE)));
    }

    /* JADX INFO: renamed from: b */
    public static void m3329b(@NotNull CommandSource commandSource, @NotNull Component component) {
        commandSource.sendSystemMessage(Component.empty().append(Component.literal("[BFA]:").withStyle(ChatFormatting.BOLD).withStyle(C0533jP.f3187d)).append(" ").append(component.copy().withColor(ColorReferences.COLOR_WHITE)));
    }
}
