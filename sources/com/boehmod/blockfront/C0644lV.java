package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.lV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lV.class */
public class C0644lV {

    /* JADX INFO: renamed from: ie */
    private static final Component f3531ie;

    /* JADX INFO: renamed from: if */
    private static final Component f3532if;

    /* JADX INFO: renamed from: ig */
    private static final Component f3533ig;

    /* JADX INFO: renamed from: ih */
    private static final Component f3534ih;

    /* JADX INFO: renamed from: ii */
    private static final Component f3535ii;

    /* JADX INFO: renamed from: bA */
    private static final String f3536bA = "bf.message.command.game.admin.toggle.suspicion.success";

    /* JADX INFO: renamed from: eb */
    static final /* synthetic */ boolean f3537eb;

    static {
        f3537eb = !C0644lV.class.desiredAssertionStatus();
        f3531ie = Component.translatable("bf.message.command.game.admin.changemap.error.nogamemap");
        f3532if = Component.translatable("bf.message.command.game.player.error.notingame");
        f3533ig = Component.translatable("bf.message.command.game.player.error.disabled");
        f3534ih = Component.translatable("bf.message.command.game.player.error.fail");
        f3535ii = Component.translatable("bf.message.command.game.player.error.ingame");
    }

    /* JADX INFO: renamed from: a */
    public static void m2864a(CommandDispatcher<CommandSourceStack> commandDispatcher, CommandBuildContext commandBuildContext) {
        LiteralArgumentBuilder literalArgumentBuilderLiteral = Commands.literal("bf");
        literalArgumentBuilderLiteral.then(Commands.literal("join").then(Commands.argument("game", StringArgumentType.word()).suggests((commandContext, suggestionsBuilder) -> {
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (f3537eb || abstractC0563juM168a != null) {
                return SharedSuggestionProvider.suggest(abstractC0563juM168a.m2542b().keySet(), suggestionsBuilder);
            }
            throw new AssertionError("Mod manager is null!");
        }).executes(commandContext2 -> {
            m2868a((CommandContext<CommandSourceStack>) commandContext2, StringArgumentType.getString(commandContext2, "game"));
            return 1;
        })));
        literalArgumentBuilderLiteral.then(Commands.literal("leave").executes(commandContext3 -> {
            m2869c((CommandContext<CommandSourceStack>) commandContext3);
            return 1;
        }));
        literalArgumentBuilderLiteral.then(Commands.literal("edit").requires(C0645lW::m2895b).executes(commandContext4 -> {
            m2870d((CommandContext<CommandSourceStack>) commandContext4);
            return 1;
        }));
        LiteralArgumentBuilder literalArgumentBuilderRequires = Commands.literal("admin").requires(C0645lW::m2895b);
        literalArgumentBuilderRequires.then(Commands.literal("vehicle").then(Commands.literal("spawn").then(Commands.argument("entity", ResourceArgument.resource(commandBuildContext, Registries.ENTITY_TYPE)).executes(commandContext5 -> {
            m2871a((CommandContext<CommandSourceStack>) commandContext5, (Holder.Reference<EntityType<?>>) ResourceArgument.getSummonableEntityType(commandContext5, "entity"));
            return 1;
        }))));
        literalArgumentBuilderRequires.then(Commands.literal("nextbot").executes(commandContext6 -> {
            m2875g((CommandContext<CommandSourceStack>) commandContext6);
            return 1;
        }));
        literalArgumentBuilderRequires.then(Commands.literal("toggle").then(Commands.literal("teamSizes").executes(commandContext7 -> {
            m2867b((CommandContext<CommandSourceStack>) commandContext7);
            return 1;
        })).then(Commands.literal("spectators").executes(commandContext8 -> {
            m2865a((CommandContext<CommandSourceStack>) commandContext8);
            return 1;
        })));
        literalArgumentBuilderRequires.then(Commands.literal("set").then(Commands.literal("maxSpectators").then(Commands.argument("count", IntegerArgumentType.integer(0)).executes(commandContext9 -> {
            m2866a((CommandContext<CommandSourceStack>) commandContext9, IntegerArgumentType.getInteger(commandContext9, "count"));
            return 1;
        }))));
        literalArgumentBuilderRequires.then(Commands.literal("toggleSuspicion").then(Commands.argument("player", EntityArgument.player()).executes(commandContext10 -> {
            m2873a((CommandContext<CommandSourceStack>) commandContext10, EntityArgument.getPlayer(commandContext10, "player"));
            return 1;
        })));
        literalArgumentBuilderRequires.then(Commands.literal("stage").then(Commands.literal("next").executes(commandContext11 -> {
            m2874f((CommandContext<CommandSourceStack>) commandContext11);
            return 1;
        })).then(Commands.literal("reset").executes(commandContext12 -> {
            m2872e((CommandContext<CommandSourceStack>) commandContext12);
            return 1;
        })));
        literalArgumentBuilderRequires.then(Commands.literal("pause").executes(commandContext13 -> {
            m2876h((CommandContext<CommandSourceStack>) commandContext13);
            return 1;
        }));
        literalArgumentBuilderRequires.then(Commands.literal("weather").then(Commands.literal("transition").executes(commandContext14 -> {
            m2877i((CommandContext<CommandSourceStack>) commandContext14);
            return 1;
        })));
        literalArgumentBuilderRequires.then(Commands.literal("map").then(Commands.literal("change").then(Commands.argument("game", StringArgumentType.word()).suggests((commandContext15, suggestionsBuilder2) -> {
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (f3537eb || abstractC0563juM168a != null) {
                return SharedSuggestionProvider.suggest((String[]) abstractC0563juM168a.m2542b().keySet().toArray(new String[0]), suggestionsBuilder2);
            }
            throw new AssertionError("Mod manager is null!");
        }).executes(commandContext16 -> {
            m2878b(commandContext16, StringArgumentType.getString(commandContext16, "game"));
            return 1;
        }))));
        literalArgumentBuilderLiteral.then(literalArgumentBuilderRequires);
        commandDispatcher.register(literalArgumentBuilderLiteral);
    }

    /* JADX INFO: renamed from: a */
    private static void m2865a(CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3537eb && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
            if (abstractC0787oFMo2531a != null) {
                MatchSettings matchSettingsM3652a = abstractC0787oFMo2531a.m3652a();
                matchSettingsM3652a.toggleAllowSpectators();
                C0799oR.m3983a(abstractC0787oFMo2531a, C0799oR.f4381iN, (Component) Component.translatable("bf.message.command.game.admin.toggle.spectators.success.all", new Object[]{serverPlayer.getScoreboardName(), Component.literal(matchSettingsM3652a.allowsSpectators() ? "enabled" : "disabled").withColor(ColorReferences.COLOR_WHITE)}));
                return;
            }
            C0645lW.m2896a(serverPlayer, f3532if);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2866a(CommandContext<CommandSourceStack> commandContext, int i) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3537eb && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
            if (abstractC0787oFMo2531a != null) {
                MatchSettings matchSettingsM3652a = abstractC0787oFMo2531a.m3652a();
                matchSettingsM3652a.setMaxSpectators(i);
                C0799oR.m3983a(abstractC0787oFMo2531a, C0799oR.f4381iN, (Component) Component.translatable("bf.message.command.game.admin.set.maxspectators.success.all", new Object[]{serverPlayer.getScoreboardName(), Component.literal(String.valueOf(matchSettingsM3652a.getMaxSpectators())).withColor(ColorReferences.COLOR_WHITE)}));
                return;
            }
            C0645lW.m2896a(serverPlayer, f3532if);
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m2867b(CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3537eb && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
            if (abstractC0787oFMo2531a != null) {
                MatchSettings matchSettingsM3652a = abstractC0787oFMo2531a.m3652a();
                matchSettingsM3652a.toggleTeamSizeLimit();
                C0799oR.m3983a(abstractC0787oFMo2531a, C0799oR.f4381iN, (Component) Component.translatable("bf.message.command.game.admin.toggle.team.size.limit.success.all", new Object[]{serverPlayer.getScoreboardName(), Component.literal(matchSettingsM3652a.hasTeamSizeLimit() ? "enabled" : "disabled").withColor(ColorReferences.COLOR_WHITE)}));
                return;
            }
            C0645lW.m2896a(serverPlayer, f3532if);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2868a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String str) {
        Player entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            Player player = (ServerPlayer) entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3537eb && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
            UUID uuid = player.getUUID();
            if (!(abstractC0183cM2528a.m1133a(player).m2189j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN) || ((CommandSourceStack) commandContext.getSource()).hasPermission(3)) && (abstractC0563juM168a instanceof C1300xw) && ((C1300xw) abstractC0563juM168a).mo2551f()) {
                C0645lW.m2896a((ServerPlayer) player, f3533ig);
                return;
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFM2537a = abstractC0563juM168a.m2537a(str);
            if (abstractC0787oFM2537a != null) {
                if (abstractC0563juM168a.m2535e(uuid)) {
                    C0645lW.m2896a((ServerPlayer) player, f3535ii);
                    return;
                } else if (!abstractC0563juM168a.m2525a(player.serverLevel(), (ServerPlayer) player, abstractC0787oFM2537a)) {
                    C0645lW.m2896a((ServerPlayer) player, f3534ih);
                    return;
                } else {
                    C0562jt.log("Player '%s' joined game '%s'", player.getScoreboardName(), str);
                    return;
                }
            }
            C0645lW.m2896a((ServerPlayer) player, (Component) Component.translatable("bf.message.command.game.player.error.nogame", new Object[]{str}));
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m2869c(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3537eb && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
            UUID uuid = serverPlayer.getUUID();
            if (!(abstractC0183cM2528a.m1133a((Player) serverPlayer).m2189j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN) || ((CommandSourceStack) commandContext.getSource()).hasPermission(3)) && (abstractC0563juM168a instanceof C1300xw) && ((C1300xw) abstractC0563juM168a).mo2551f()) {
                C0645lW.m2896a(serverPlayer, f3533ig);
                return;
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
            if (abstractC0787oFMo2531a != null) {
                abstractC0787oFMo2531a.m3582b().m3794a(abstractC0563juM168a, serverPlayer.serverLevel(), serverPlayer);
                C0562jt.log("Player '%s' left game '%s'", serverPlayer.getScoreboardName(), abstractC0787oFMo2531a.m3589L());
            } else {
                C0645lW.m2896a(serverPlayer, f3532if);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private static void m2870d(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3537eb && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
            if (abstractC0787oFMo2531a == null) {
                C0645lW.m2896a(serverPlayer, f3532if);
                return;
            }
            if (!abstractC0787oFMo2531a.m3626be()) {
                abstractC0787oFMo2531a.m3627A(true);
            }
            serverPlayer.setGameMode(GameType.CREATIVE);
            Inventory inventory = serverPlayer.getInventory();
            inventory.clearContent();
            inventory.add(new ItemStack((ItemLike) C1231wY.f7129z.get()));
            inventory.add(new ItemStack((ItemLike) C1231wY.f7130A.get()));
            inventory.add(new ItemStack((ItemLike) C1231wY.f7131B.get()));
            C0645lW.m2896a(serverPlayer, (Component) Component.translatable("bf.message.command.game.edit.success", new Object[]{abstractC0787oFMo2531a.m3589L()}));
            C0562jt.log("Player '%s' entered edit mode for game '%s'", serverPlayer.getScoreboardName(), abstractC0787oFMo2531a.m3589L());
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2871a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull Holder.Reference<EntityType<?>> reference) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3537eb && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
            Level level = serverPlayer.level();
            if (abstractC0787oFMo2531a != null) {
                Entity entityCreate = ((EntityType) reference.value()).create(level);
                if (entityCreate instanceof C0726my) {
                    ((C0726my) entityCreate).mo3282e(abstractC0787oFMo2531a);
                    level.addFreshEntity(entityCreate);
                    entityCreate.setPos(serverPlayer.position());
                }
                if (entityCreate != null) {
                    C0799oR.m3983a(abstractC0787oFMo2531a, C0799oR.f4381iN, (Component) Component.translatable("bf.message.command.game.admin.vehicle.spawn.success.all", new Object[]{serverPlayer.getScoreboardName(), entityCreate.getScoreboardName()}));
                    return;
                }
                return;
            }
            C0645lW.m2896a(serverPlayer, f3532if);
        }
    }

    /* JADX INFO: renamed from: e */
    private static void m2872e(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3537eb && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
            if (abstractC0787oFMo2531a != null) {
                abstractC0787oFMo2531a.m3651a().m5999bf();
                C0799oR.m3983a(abstractC0787oFMo2531a, C0799oR.f4381iN, (Component) Component.translatable("bf.message.command.game.admin.stage.reset.success.all", new Object[]{serverPlayer.getScoreboardName()}));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2873a(CommandContext<CommandSourceStack> commandContext, ServerPlayer serverPlayer) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3537eb && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (abstractC0563juM168a instanceof C1300xw) {
                C0525jI c0525jIM7784a = ((C1274xO) ((C1276xQ) ((C1300xw) abstractC0563juM168a).m7950a()).m1133a((Player) serverPlayer)).m7784a();
                c0525jIM7784a.m2324z(!c0525jIM7784a.m2323ah());
                boolean zM2323ah = c0525jIM7784a.m2323ah();
                C0645lW.m2896a(serverPlayer2, (Component) Component.translatable(f3536bA, new Object[]{Component.literal(zM2323ah ? "Enabled" : "Disabled").withStyle(zM2323ah ? ChatFormatting.GREEN : ChatFormatting.RED), Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.WHITE)}));
            }
        }
    }

    /* JADX INFO: renamed from: f */
    private static void m2874f(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3537eb && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
            if (abstractC0787oFMo2531a != null) {
                abstractC0787oFMo2531a.m3651a().m5998dh();
                C0799oR.m3983a(abstractC0787oFMo2531a, C0799oR.f4381iN, (Component) Component.translatable("bf.message.command.game.admin.stage.next.success.all", new Object[]{serverPlayer.getScoreboardName()}));
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private static void m2875g(@NotNull CommandContext<CommandSourceStack> commandContext) {
        C0699mX c0699mXCreate;
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3537eb && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
            Level level = serverPlayer.level();
            if (abstractC0787oFMo2531a == null || (c0699mXCreate = ((EntityType) C1230wX.f7036kG.get()).create(level)) == null) {
                return;
            }
            c0699mXCreate.mo3282e(abstractC0787oFMo2531a);
            level.addFreshEntity(c0699mXCreate);
            c0699mXCreate.setPos(serverPlayer.position());
            C0799oR.m3983a(abstractC0787oFMo2531a, C0799oR.f4381iN, (Component) Component.translatable("bf.message.command.game.admin.nextbot.success.all", new Object[]{serverPlayer.getScoreboardName()}));
        }
    }

    /* JADX INFO: renamed from: h */
    private static void m2876h(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3537eb && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
            if (abstractC0787oFMo2531a != null) {
                abstractC0787oFMo2531a.m3627A(!abstractC0787oFMo2531a.m3626be());
                C0799oR.m3983a(abstractC0787oFMo2531a, C0799oR.f4381iN, (Component) Component.translatable(String.format("bf.message.command.game.admin.%s.success.all", abstractC0787oFMo2531a.m3626be() ? "pause" : "unpause"), new Object[]{serverPlayer.getScoreboardName()}));
            } else {
                C0645lW.m2896a(serverPlayer, f3532if);
            }
        }
    }

    /* JADX INFO: renamed from: i */
    private static void m2877i(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3537eb && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
            if (abstractC0787oFMo2531a == null) {
                C0645lW.m2896a(serverPlayer, f3532if);
                return;
            }
            RandomSource random = serverPlayer.serverLevel().getRandom();
            int i = 0;
            for (AbstractC0835pA abstractC0835pA : abstractC0787oFMo2531a.m3653a().m5619ax()) {
                if ((abstractC0835pA instanceof C0892qE) && ((C0892qE) abstractC0835pA).m4494a(abstractC0787oFMo2531a, random)) {
                    i++;
                }
            }
            C0645lW.m2896a(serverPlayer, (Component) Component.literal("Triggered " + i + " weather transition(s)."));
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m2878b(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String str) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3537eb && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayer.getUUID());
            if (abstractC0787oFMo2531a == null) {
                C0645lW.m2896a(serverPlayer, f3532if);
            } else if (!abstractC0787oFMo2531a.m3571a(abstractC0563juM168a, serverPlayer.serverLevel(), str)) {
                C0645lW.m2896a(serverPlayer, f3531ie);
            } else {
                C0799oR.m3983a(abstractC0787oFMo2531a, C0799oR.f4381iN, (Component) Component.translatable("bf.message.command.game.admin.changemap.success.all", new Object[]{serverPlayer.getScoreboardName(), str}));
            }
        }
    }
}
