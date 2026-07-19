package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lX.class */
public class lX {
    static final /* synthetic */ boolean ed;

    static {
        ed = !lX.class.desiredAssertionStatus();
    }

    public static void a(CommandDispatcher<CommandSourceStack> commandDispatcher) {
        commandDispatcher.register(Commands.literal("screenshot").requires(lW::b).then(Commands.argument("player", EntityArgument.players()).executes(commandContext -> {
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!ed && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
            EntityArgument.getPlayers(commandContext, "player").forEach(serverPlayer -> {
                a(abstractC0264juM166a, cVarM531a, commandContext, serverPlayer);
            });
            return 1;
        })).executes(commandContext2 -> {
            return 1;
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull CommandContext<CommandSourceStack> commandContext, @NotNull ServerPlayer serverPlayer) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = entity;
            if (abstractC0264ju instanceof xw) {
                xw xwVar = (xw) abstractC0264ju;
                iS iSVarA = cVar.a((Player) serverPlayer2);
                xB xBVarA = ((xA) xwVar.b()).a();
                if (serverPlayer.hasPermissions(3) || iSVarA.j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN)) {
                    xC xCVarA = xBVarA.a(serverPlayer);
                    if (xCVarA != null) {
                        xCVarA.l(serverPlayer2);
                        return;
                    }
                    return;
                }
                serverPlayer2.sendSystemMessage(Component.translatable("bf.message.command.game.admin.screenshot.error.permission", new Object[]{serverPlayer.getDisplayName()}).withStyle(ChatFormatting.RED));
            }
        }
    }
}
