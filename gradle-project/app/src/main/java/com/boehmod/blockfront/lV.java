package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.ResourceArgument;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lV.class */
public class lV {
    private static final Component ie;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    private static final Component f233if;
    private static final Component ig;
    private static final Component ih;
    private static final Component ii;
    private static final String bA = "bf.message.command.game.admin.toggle.suspicion.success";
    static final /* synthetic */ boolean eb;

    static {
        eb = !lV.class.desiredAssertionStatus();
        ie = Component.translatable("bf.message.command.game.admin.changemap.error.nogamemap");
        f233if = Component.translatable("bf.message.command.game.player.error.notingame");
        ig = Component.translatable("bf.message.command.game.player.error.disabled");
        ih = Component.translatable("bf.message.command.game.player.error.fail");
        ii = Component.translatable("bf.message.command.game.player.error.ingame");
    }

    public static void a(CommandDispatcher<CommandSourceStack> commandDispatcher, CommandBuildContext commandBuildContext) {
        LiteralArgumentBuilder literalArgumentBuilderLiteral = Commands.literal("bf");
        literalArgumentBuilderLiteral.then(Commands.literal("join").then(Commands.argument("game", StringArgumentType.word()).suggests((commandContext, suggestionsBuilder) -> {
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (eb || abstractC0264juM166a != null) {
                return SharedSuggestionProvider.suggest(abstractC0264juM166a.m534b().keySet(), suggestionsBuilder);
            }
            throw new AssertionError("Mod manager is null!");
        }).executes(commandContext2 -> {
            a((CommandContext<CommandSourceStack>) commandContext2, StringArgumentType.getString(commandContext2, "game"));
            return 1;
        })));
        literalArgumentBuilderLiteral.then(Commands.literal("leave").executes(commandContext3 -> {
            c((CommandContext<CommandSourceStack>) commandContext3);
            return 1;
        }));
        literalArgumentBuilderLiteral.then(Commands.literal("edit").requires(lW::b).executes(commandContext4 -> {
            d((CommandContext<CommandSourceStack>) commandContext4);
            return 1;
        }));
        LiteralArgumentBuilder literalArgumentBuilderRequires = Commands.literal("admin").requires(lW::b);
        literalArgumentBuilderRequires.then(Commands.literal("vehicle").then(Commands.literal("spawn").then(Commands.argument("entity", ResourceArgument.resource(commandBuildContext, Registries.ENTITY_TYPE)).executes(commandContext5 -> {
            a((CommandContext<CommandSourceStack>) commandContext5, (Holder.Reference<EntityType<?>>) ResourceArgument.getSummonableEntityType(commandContext5, "entity"));
            return 1;
        }))));
        literalArgumentBuilderRequires.then(Commands.literal("nextbot").executes(commandContext6 -> {
            g((CommandContext<CommandSourceStack>) commandContext6);
            return 1;
        }));
        literalArgumentBuilderRequires.then(Commands.literal("toggle").then(Commands.literal("teamSizes").executes(commandContext7 -> {
            b((CommandContext<CommandSourceStack>) commandContext7);
            return 1;
        })).then(Commands.literal("spectators").executes(commandContext8 -> {
            a((CommandContext<CommandSourceStack>) commandContext8);
            return 1;
        })));
        literalArgumentBuilderRequires.then(Commands.literal("set").then(Commands.literal("maxSpectators").then(Commands.argument("count", IntegerArgumentType.integer(0)).executes(commandContext9 -> {
            a((CommandContext<CommandSourceStack>) commandContext9, IntegerArgumentType.getInteger(commandContext9, "count"));
            return 1;
        }))));
        literalArgumentBuilderRequires.then(Commands.literal("toggleSuspicion").then(Commands.argument("player", EntityArgument.player()).executes(commandContext10 -> {
            a((CommandContext<CommandSourceStack>) commandContext10, EntityArgument.getPlayer(commandContext10, "player"));
            return 1;
        })));
        literalArgumentBuilderRequires.then(Commands.literal("stage").then(Commands.literal("next").executes(commandContext11 -> {
            f((CommandContext<CommandSourceStack>) commandContext11);
            return 1;
        })).then(Commands.literal("reset").executes(commandContext12 -> {
            e((CommandContext<CommandSourceStack>) commandContext12);
            return 1;
        })));
        literalArgumentBuilderRequires.then(Commands.literal("pause").executes(commandContext13 -> {
            h((CommandContext<CommandSourceStack>) commandContext13);
            return 1;
        }));
        literalArgumentBuilderRequires.then(Commands.literal("weather").then(Commands.literal("transition").executes(commandContext14 -> {
            i((CommandContext<CommandSourceStack>) commandContext14);
            return 1;
        })));
        literalArgumentBuilderRequires.then(Commands.literal("map").then(Commands.literal("change").then(Commands.argument("game", StringArgumentType.word()).suggests((commandContext15, suggestionsBuilder2) -> {
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (eb || abstractC0264juM166a != null) {
                return SharedSuggestionProvider.suggest((String[]) abstractC0264juM166a.m534b().keySet().toArray(new String[0]), suggestionsBuilder2);
            }
            throw new AssertionError("Mod manager is null!");
        }).executes(commandContext16 -> {
            b(commandContext16, StringArgumentType.getString(commandContext16, "game"));
            return 1;
        }))));
        literalArgumentBuilderLiteral.then(literalArgumentBuilderRequires);
        commandDispatcher.register(literalArgumentBuilderLiteral);
    }

    private static void a(CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eb && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
            if (oFVarMo604a != null) {
                MatchSettings matchSettingsM766a = oFVarMo604a.m766a();
                matchSettingsM766a.toggleAllowSpectators();
                oR.a(oFVarMo604a, oR.iN, (Component) Component.translatable("bf.message.command.game.admin.toggle.spectators.success.all", new Object[]{serverPlayer.getScoreboardName(), Component.literal(matchSettingsM766a.allowsSpectators() ? "enabled" : "disabled").withColor(ColorReferences.COLOR_WHITE)}));
                return;
            }
            lW.a(serverPlayer, f233if);
        }
    }

    private static void a(CommandContext<CommandSourceStack> commandContext, int i) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eb && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
            if (oFVarMo604a != null) {
                MatchSettings matchSettingsM766a = oFVarMo604a.m766a();
                matchSettingsM766a.setMaxSpectators(i);
                oR.a(oFVarMo604a, oR.iN, (Component) Component.translatable("bf.message.command.game.admin.set.maxspectators.success.all", new Object[]{serverPlayer.getScoreboardName(), Component.literal(String.valueOf(matchSettingsM766a.getMaxSpectators())).withColor(ColorReferences.COLOR_WHITE)}));
                return;
            }
            lW.a(serverPlayer, f233if);
        }
    }

    private static void b(CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eb && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
            if (oFVarMo604a != null) {
                MatchSettings matchSettingsM766a = oFVarMo604a.m766a();
                matchSettingsM766a.toggleTeamSizeLimit();
                oR.a(oFVarMo604a, oR.iN, (Component) Component.translatable("bf.message.command.game.admin.toggle.team.size.limit.success.all", new Object[]{serverPlayer.getScoreboardName(), Component.literal(matchSettingsM766a.hasTeamSizeLimit() ? "enabled" : "disabled").withColor(ColorReferences.COLOR_WHITE)}));
                return;
            }
            lW.a(serverPlayer, f233if);
        }
    }

    private static void a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String str) {
        Player entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            Player player = (ServerPlayer) entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eb && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
            UUID uuid = player.getUUID();
            if (!(cVarM531a.a(player).j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN) || ((CommandSourceStack) commandContext.getSource()).hasPermission(3)) && (abstractC0264juM166a instanceof xw) && ((xw) abstractC0264juM166a).f()) {
                lW.a((ServerPlayer) player, ig);
                return;
            }
            oF<?, ?, ?> oFVarA = abstractC0264juM166a.a(str);
            if (oFVarA != null) {
                if (abstractC0264juM166a.e(uuid)) {
                    lW.a((ServerPlayer) player, ii);
                    return;
                } else if (!abstractC0264juM166a.a(player.serverLevel(), (ServerPlayer) player, oFVarA)) {
                    lW.a((ServerPlayer) player, ih);
                    return;
                } else {
                    C0263jt.log("Player '%s' joined game '%s'", player.getScoreboardName(), str);
                    return;
                }
            }
            lW.a((ServerPlayer) player, (Component) Component.translatable("bf.message.command.game.player.error.nogame", new Object[]{str}));
        }
    }

    private static void c(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eb && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
            UUID uuid = serverPlayer.getUUID();
            if (!(cVarM531a.a((Player) serverPlayer).j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN) || ((CommandSourceStack) commandContext.getSource()).hasPermission(3)) && (abstractC0264juM166a instanceof xw) && ((xw) abstractC0264juM166a).f()) {
                lW.a(serverPlayer, ig);
                return;
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
            if (oFVarMo604a != null) {
                oFVarMo604a.b().a(abstractC0264juM166a, serverPlayer.serverLevel(), serverPlayer);
                C0263jt.log("Player '%s' left game '%s'", serverPlayer.getScoreboardName(), oFVarMo604a.L());
            } else {
                lW.a(serverPlayer, f233if);
            }
        }
    }

    private static void d(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eb && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
            if (oFVarMo604a == null) {
                lW.a(serverPlayer, f233if);
                return;
            }
            if (!oFVarMo604a.be()) {
                oFVarMo604a.A(true);
            }
            serverPlayer.setGameMode(GameType.CREATIVE);
            Inventory inventory = serverPlayer.getInventory();
            inventory.clearContent();
            inventory.add(new ItemStack((ItemLike) wY.z.get()));
            inventory.add(new ItemStack((ItemLike) wY.A.get()));
            inventory.add(new ItemStack((ItemLike) wY.B.get()));
            lW.a(serverPlayer, (Component) Component.translatable("bf.message.command.game.edit.success", new Object[]{oFVarMo604a.L()}));
            C0263jt.log("Player '%s' entered edit mode for game '%s'", serverPlayer.getScoreboardName(), oFVarMo604a.L());
        }
    }

    private static void a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull Holder.Reference<EntityType<?>> reference) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eb && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
            Level level = serverPlayer.level();
            if (oFVarMo604a != null) {
                Entity entityCreate = ((EntityType) reference.value()).create(level);
                if (entityCreate instanceof C0349my) {
                    ((C0349my) entityCreate).e(oFVarMo604a);
                    level.addFreshEntity(entityCreate);
                    entityCreate.setPos(serverPlayer.position());
                }
                if (entityCreate != null) {
                    oR.a(oFVarMo604a, oR.iN, (Component) Component.translatable("bf.message.command.game.admin.vehicle.spawn.success.all", new Object[]{serverPlayer.getScoreboardName(), entityCreate.getScoreboardName()}));
                    return;
                }
                return;
            }
            lW.a(serverPlayer, f233if);
        }
    }

    private static void e(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eb && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
            if (oFVarMo604a != null) {
                oFVarMo604a.m765a().bf();
                oR.a(oFVarMo604a, oR.iN, (Component) Component.translatable("bf.message.command.game.admin.stage.reset.success.all", new Object[]{serverPlayer.getScoreboardName()}));
            }
        }
    }

    private static void a(CommandContext<CommandSourceStack> commandContext, ServerPlayer serverPlayer) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eb && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (abstractC0264juM166a instanceof xw) {
                jI jIVarM1675a = ((xO) ((xQ) ((xw) abstractC0264juM166a).a()).a((Player) serverPlayer)).m1675a();
                jIVarM1675a.z(!jIVarM1675a.ah());
                boolean zAh = jIVarM1675a.ah();
                lW.a(serverPlayer2, (Component) Component.translatable(bA, new Object[]{Component.literal(zAh ? "Enabled" : "Disabled").withStyle(zAh ? ChatFormatting.GREEN : ChatFormatting.RED), Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.WHITE)}));
            }
        }
    }

    private static void f(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eb && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
            if (oFVarMo604a != null) {
                oFVarMo604a.m765a().dh();
                oR.a(oFVarMo604a, oR.iN, (Component) Component.translatable("bf.message.command.game.admin.stage.next.success.all", new Object[]{serverPlayer.getScoreboardName()}));
            }
        }
    }

    private static void g(@NotNull CommandContext<CommandSourceStack> commandContext) {
        mX mXVarCreate;
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eb && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
            Level level = serverPlayer.level();
            if (oFVarMo604a == null || (mXVarCreate = ((EntityType) wX.kG.get()).create(level)) == null) {
                return;
            }
            mXVarCreate.e(oFVarMo604a);
            level.addFreshEntity(mXVarCreate);
            mXVarCreate.setPos(serverPlayer.position());
            oR.a(oFVarMo604a, oR.iN, (Component) Component.translatable("bf.message.command.game.admin.nextbot.success.all", new Object[]{serverPlayer.getScoreboardName()}));
        }
    }

    private static void h(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eb && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
            if (oFVarMo604a != null) {
                oFVarMo604a.A(!oFVarMo604a.be());
                oR.a(oFVarMo604a, oR.iN, (Component) Component.translatable(String.format("bf.message.command.game.admin.%s.success.all", oFVarMo604a.be() ? "pause" : "unpause"), new Object[]{serverPlayer.getScoreboardName()}));
            } else {
                lW.a(serverPlayer, f233if);
            }
        }
    }

    private static void i(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eb && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
            if (oFVarMo604a == null) {
                lW.a(serverPlayer, f233if);
                return;
            }
            RandomSource random = serverPlayer.serverLevel().getRandom();
            int i = 0;
            for (pA pAVar : oFVarMo604a.m767a().ax()) {
                if ((pAVar instanceof qE) && ((qE) pAVar).a(oFVarMo604a, random)) {
                    i++;
                }
            }
            lW.a(serverPlayer, (Component) Component.literal("Triggered " + i + " weather transition(s)."));
        }
    }

    private static void b(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String str) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eb && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayer.getUUID());
            if (oFVarMo604a == null) {
                lW.a(serverPlayer, f233if);
            } else if (!oFVarMo604a.a(abstractC0264juM166a, serverPlayer.serverLevel(), str)) {
                lW.a(serverPlayer, ie);
            } else {
                oR.a(oFVarMo604a, oR.iN, (Component) Component.translatable("bf.message.command.game.admin.changemap.success.all", new Object[]{serverPlayer.getScoreboardName(), str}));
            }
        }
    }
}
