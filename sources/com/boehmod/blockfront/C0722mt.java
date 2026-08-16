package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.mt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mt.class */
public class C0722mt {

    /* JADX INFO: renamed from: ew */
    static final /* synthetic */ boolean f4013ew;

    static {
        f4013ew = !C0722mt.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3330a(CommandDispatcher<CommandSourceStack> commandDispatcher) {
        commandDispatcher.register(Commands.literal("screenshot").requires(C0721ms::m3326b).then(Commands.argument("player", EntityArgument.players()).executes(commandContext -> {
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4013ew && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
            EntityArgument.getPlayers(commandContext, "player").forEach(serverPlayer -> {
                m3331a(abstractC0531jNM179a, abstractC0184cM2351a, commandContext, serverPlayer);
            });
            return 1;
        })).executes(commandContext2 -> {
            return 1;
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static void m3331a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull CommandContext<CommandSourceStack> commandContext, @NotNull ServerPlayer serverPlayer) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = entity;
            if (abstractC0531jN instanceof C1280xT) {
                C1280xT c1280xT = (C1280xT) abstractC0531jN;
                C0555jl c0555jlM1150a = abstractC0184c.m1150a((Player) serverPlayer2);
                C1285xY c1285xYA = ((C1284xX) c1280xT.m7289b()).m2407a();
                if (serverPlayer.hasPermissions(3) || c0555jlM1150a.m2516l(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN)) {
                    C1286xZ c1286xZM7303a = c1285xYA.m7303a(serverPlayer);
                    if (c1286xZM7303a != null) {
                        c1286xZM7303a.m7307l(serverPlayer2);
                        return;
                    }
                    return;
                }
                serverPlayer2.sendSystemMessage(Component.translatable("bf.message.command.game.admin.screenshot.error.permission", new Object[]{serverPlayer.getDisplayName()}).withStyle(ChatFormatting.RED));
            }
        }
    }
}
