package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.lX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lX.class */
public class C0646lX {

    /* JADX INFO: renamed from: ed */
    static final /* synthetic */ boolean f3539ed;

    static {
        f3539ed = !C0646lX.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m2899a(CommandDispatcher<CommandSourceStack> commandDispatcher) {
        commandDispatcher.register(Commands.literal("screenshot").requires(C0645lW::m2895b).then(Commands.argument("player", EntityArgument.players()).executes(commandContext -> {
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3539ed && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
            EntityArgument.getPlayers(commandContext, "player").forEach(serverPlayer -> {
                m2900a(abstractC0563juM168a, abstractC0183cM2528a, commandContext, serverPlayer);
            });
            return 1;
        })).executes(commandContext2 -> {
            return 1;
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static void m2900a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull CommandContext<CommandSourceStack> commandContext, @NotNull ServerPlayer serverPlayer) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = entity;
            if (abstractC0563ju instanceof C1300xw) {
                C1300xw c1300xw = (C1300xw) abstractC0563ju;
                C0482iS c0482iSM1133a = abstractC0183c.m1133a((Player) serverPlayer2);
                C1261xB c1261xBA = ((C1260xA) c1300xw.m7961b()).m2582a();
                if (serverPlayer.hasPermissions(3) || c0482iSM1133a.m2189j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN)) {
                    C1262xC c1262xCM7745a = c1261xBA.m7745a(serverPlayer);
                    if (c1262xCM7745a != null) {
                        c1262xCM7745a.m7749l(serverPlayer2);
                        return;
                    }
                    return;
                }
                serverPlayer2.sendSystemMessage(Component.translatable("bf.message.command.game.admin.screenshot.error.permission", new Object[]{serverPlayer.getDisplayName()}).withStyle(ChatFormatting.RED));
            }
        }
    }
}
