package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.mr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mr.class */
public class C0720mr {

    /* JADX INFO: renamed from: ip */
    private static final Component f4005ip;

    /* JADX INFO: renamed from: iq */
    private static final Component f4006iq;

    /* JADX INFO: renamed from: ir */
    private static final Component f4007ir;

    /* JADX INFO: renamed from: is */
    private static final Component f4008is;

    /* JADX INFO: renamed from: it */
    private static final Component f4009it;

    /* JADX INFO: renamed from: bJ */
    private static final String f4010bJ = "bf.message.command.game.admin.toggle.suspicion.success";

    /* JADX INFO: renamed from: eu */
    static final /* synthetic */ boolean f4011eu;

    static {
        f4011eu = !C0720mr.class.desiredAssertionStatus();
        f4005ip = Component.translatable("bf.message.command.game.admin.changemap.error.nogamemap");
        f4006iq = Component.translatable("bf.message.command.game.player.error.notingame");
        f4007ir = Component.translatable("bf.message.command.game.player.error.disabled");
        f4008is = Component.translatable("bf.message.command.game.player.error.fail");
        f4009it = Component.translatable("bf.message.command.game.player.error.ingame");
    }

    /* JADX INFO: renamed from: a */
    public static void m3295a(CommandDispatcher<CommandSourceStack> commandDispatcher, CommandBuildContext commandBuildContext) {
        LiteralArgumentBuilder literalArgumentBuilderLiteral = Commands.literal("bf");
        literalArgumentBuilderLiteral.then(Commands.literal("join").then(Commands.argument("game", StringArgumentType.word()).suggests((commandContext, suggestionsBuilder) -> {
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (f4011eu || abstractC0531jNM179a != null) {
                return SharedSuggestionProvider.suggest(abstractC0531jNM179a.m2365b().keySet(), suggestionsBuilder);
            }
            throw new AssertionError("Mod manager is null!");
        }).executes(commandContext2 -> {
            m3299a((CommandContext<CommandSourceStack>) commandContext2, StringArgumentType.getString(commandContext2, "game"));
            return 1;
        })));
        literalArgumentBuilderLiteral.then(Commands.literal("leave").executes(commandContext3 -> {
            m3300c((CommandContext<CommandSourceStack>) commandContext3);
            return 1;
        }));
        literalArgumentBuilderLiteral.then(Commands.literal("edit").requires(C0721ms::m3326b).executes(commandContext4 -> {
            m3301d((CommandContext<CommandSourceStack>) commandContext4);
            return 1;
        }));
        LiteralArgumentBuilder literalArgumentBuilderRequires = Commands.literal("admin").requires(C0721ms::m3326b);
        literalArgumentBuilderRequires.then(Commands.literal("vehicle").then(Commands.literal("spawn").then(Commands.argument("entity", ResourceArgument.resource(commandBuildContext, Registries.ENTITY_TYPE)).executes(commandContext5 -> {
            m3302a((CommandContext<CommandSourceStack>) commandContext5, (Holder.Reference<EntityType<?>>) ResourceArgument.getSummonableEntityType(commandContext5, "entity"));
            return 1;
        }))));
        literalArgumentBuilderRequires.then(Commands.literal("nextbot").executes(commandContext6 -> {
            m3306g((CommandContext<CommandSourceStack>) commandContext6);
            return 1;
        }));
        literalArgumentBuilderRequires.then(Commands.literal("toggle").then(Commands.literal("teamSizes").executes(commandContext7 -> {
            m3298b((CommandContext<CommandSourceStack>) commandContext7);
            return 1;
        })).then(Commands.literal("spectators").executes(commandContext8 -> {
            m3296a((CommandContext<CommandSourceStack>) commandContext8);
            return 1;
        })));
        literalArgumentBuilderRequires.then(Commands.literal("set").then(Commands.literal("maxSpectators").then(Commands.argument("count", IntegerArgumentType.integer(0)).executes(commandContext9 -> {
            m3297a((CommandContext<CommandSourceStack>) commandContext9, IntegerArgumentType.getInteger(commandContext9, "count"));
            return 1;
        }))));
        literalArgumentBuilderRequires.then(Commands.literal("toggleSuspicion").then(Commands.argument("player", EntityArgument.player()).executes(commandContext10 -> {
            m3304a((CommandContext<CommandSourceStack>) commandContext10, EntityArgument.getPlayer(commandContext10, "player"));
            return 1;
        })));
        literalArgumentBuilderRequires.then(Commands.literal("stage").then(Commands.literal("next").executes(commandContext11 -> {
            m3305f((CommandContext<CommandSourceStack>) commandContext11);
            return 1;
        })).then(Commands.literal("reset").executes(commandContext12 -> {
            m3303e((CommandContext<CommandSourceStack>) commandContext12);
            return 1;
        })));
        literalArgumentBuilderRequires.then(Commands.literal("pause").executes(commandContext13 -> {
            m3307h((CommandContext<CommandSourceStack>) commandContext13);
            return 1;
        }));
        literalArgumentBuilderRequires.then(Commands.literal("weather").then(Commands.literal("transition").executes(commandContext14 -> {
            m3308i((CommandContext<CommandSourceStack>) commandContext14);
            return 1;
        })));
        literalArgumentBuilderRequires.then(Commands.literal("map").then(Commands.literal("change").then(Commands.argument("game", StringArgumentType.word()).suggests((commandContext15, suggestionsBuilder2) -> {
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (f4011eu || abstractC0531jNM179a != null) {
                return SharedSuggestionProvider.suggest((String[]) abstractC0531jNM179a.m2365b().keySet().toArray(new String[0]), suggestionsBuilder2);
            }
            throw new AssertionError("Mod manager is null!");
        }).executes(commandContext16 -> {
            m3309b(commandContext16, StringArgumentType.getString(commandContext16, "game"));
            return 1;
        }))));
        literalArgumentBuilderLiteral.then(literalArgumentBuilderRequires);
        commandDispatcher.register(literalArgumentBuilderLiteral);
    }

    /* JADX INFO: renamed from: a */
    private static void m3296a(CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4011eu && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
            if (abstractC0863pbMo2354a != null) {
                MatchSettings matchSettingsM4088a = abstractC0863pbMo2354a.m4088a();
                matchSettingsM4088a.toggleAllowSpectators();
                C0875pn.m4419a(abstractC0863pbMo2354a, C0875pn.f4777iZ, (Component) Component.translatable("bf.message.command.game.admin.toggle.spectators.success.all", new Object[]{serverPlayer.getScoreboardName(), Component.literal(matchSettingsM4088a.allowsSpectators() ? "enabled" : "disabled").withColor(ColorReferences.COLOR_WHITE)}));
                return;
            }
            C0721ms.m3327a(serverPlayer, f4006iq);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3297a(CommandContext<CommandSourceStack> commandContext, int i) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4011eu && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
            if (abstractC0863pbMo2354a != null) {
                MatchSettings matchSettingsM4088a = abstractC0863pbMo2354a.m4088a();
                matchSettingsM4088a.setMaxSpectators(i);
                C0875pn.m4419a(abstractC0863pbMo2354a, C0875pn.f4777iZ, (Component) Component.translatable("bf.message.command.game.admin.set.maxspectators.success.all", new Object[]{serverPlayer.getScoreboardName(), Component.literal(String.valueOf(matchSettingsM4088a.getMaxSpectators())).withColor(ColorReferences.COLOR_WHITE)}));
                return;
            }
            C0721ms.m3327a(serverPlayer, f4006iq);
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m3298b(CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4011eu && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
            if (abstractC0863pbMo2354a != null) {
                MatchSettings matchSettingsM4088a = abstractC0863pbMo2354a.m4088a();
                matchSettingsM4088a.toggleTeamSizeLimit();
                C0875pn.m4419a(abstractC0863pbMo2354a, C0875pn.f4777iZ, (Component) Component.translatable("bf.message.command.game.admin.toggle.team.size.limit.success.all", new Object[]{serverPlayer.getScoreboardName(), Component.literal(matchSettingsM4088a.hasTeamSizeLimit() ? "enabled" : "disabled").withColor(ColorReferences.COLOR_WHITE)}));
                return;
            }
            C0721ms.m3327a(serverPlayer, f4006iq);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3299a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String str) {
        Player entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            Player player = (ServerPlayer) entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4011eu && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
            UUID uuid = player.getUUID();
            if (!(abstractC0184cM2351a.m1150a(player).m2516l(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN) || ((CommandSourceStack) commandContext.getSource()).hasPermission(3)) && (abstractC0531jNM179a instanceof C1280xT) && ((C1280xT) abstractC0531jNM179a).mo2374f()) {
                C0721ms.m3327a((ServerPlayer) player, f4007ir);
                return;
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbM2360a = abstractC0531jNM179a.m2360a(str);
            if (abstractC0863pbM2360a != null) {
                if (abstractC0531jNM179a.m2358e(uuid)) {
                    C0721ms.m3327a((ServerPlayer) player, f4009it);
                    return;
                } else if (!abstractC0531jNM179a.m2348a(player.serverLevel(), (ServerPlayer) player, abstractC0863pbM2360a)) {
                    C0721ms.m3327a((ServerPlayer) player, f4008is);
                    return;
                } else {
                    C0530jM.log("Player '%s' joined game '%s'", player.getScoreboardName(), str);
                    return;
                }
            }
            C0721ms.m3327a((ServerPlayer) player, (Component) Component.translatable("bf.message.command.game.player.error.nogame", new Object[]{str}));
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m3300c(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4011eu && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
            UUID uuid = serverPlayer.getUUID();
            if (!(abstractC0184cM2351a.m1150a((Player) serverPlayer).m2516l(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN) || ((CommandSourceStack) commandContext.getSource()).hasPermission(3)) && (abstractC0531jNM179a instanceof C1280xT) && ((C1280xT) abstractC0531jNM179a).mo2374f()) {
                C0721ms.m3327a(serverPlayer, f4007ir);
                return;
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
            if (abstractC0863pbMo2354a != null) {
                abstractC0863pbMo2354a.m4018b().m4230a(abstractC0531jNM179a, serverPlayer.serverLevel(), serverPlayer);
                C0530jM.log("Player '%s' left game '%s'", serverPlayer.getScoreboardName(), abstractC0863pbMo2354a.m4025S());
            } else {
                C0721ms.m3327a(serverPlayer, f4006iq);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private static void m3301d(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4011eu && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
            if (abstractC0863pbMo2354a == null) {
                C0721ms.m3327a(serverPlayer, f4006iq);
                return;
            }
            if (!abstractC0863pbMo2354a.m4062bo()) {
                abstractC0863pbMo2354a.m4063A(true);
            }
            serverPlayer.setGameMode(GameType.CREATIVE);
            Inventory inventory = serverPlayer.getInventory();
            inventory.clearContent();
            inventory.add(new ItemStack((ItemLike) C1308xv.f7694z.get()));
            inventory.add(new ItemStack((ItemLike) C1308xv.f7695A.get()));
            inventory.add(new ItemStack((ItemLike) C1308xv.f7696B.get()));
            C0721ms.m3327a(serverPlayer, (Component) Component.translatable("bf.message.command.game.edit.success", new Object[]{abstractC0863pbMo2354a.m4025S()}));
            C0530jM.log("Player '%s' entered edit mode for game '%s'", serverPlayer.getScoreboardName(), abstractC0863pbMo2354a.m4025S());
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3302a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull Holder.Reference<EntityType<?>> reference) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4011eu && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
            Level level = serverPlayer.level();
            if (abstractC0863pbMo2354a != null) {
                Entity entityCreate = ((EntityType) reference.value()).create(level);
                if (entityCreate instanceof C0697mU) {
                    ((C0697mU) entityCreate).mo3117e(abstractC0863pbMo2354a);
                    level.addFreshEntity(entityCreate);
                    entityCreate.setPos(serverPlayer.position());
                }
                if (entityCreate != null) {
                    C0875pn.m4419a(abstractC0863pbMo2354a, C0875pn.f4777iZ, (Component) Component.translatable("bf.message.command.game.admin.vehicle.spawn.success.all", new Object[]{serverPlayer.getScoreboardName(), entityCreate.getScoreboardName()}));
                    return;
                }
                return;
            }
            C0721ms.m3327a(serverPlayer, f4006iq);
        }
    }

    /* JADX INFO: renamed from: e */
    private static void m3303e(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4011eu && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
            if (abstractC0863pbMo2354a != null) {
                abstractC0863pbMo2354a.m4087a().m5879bd();
                C0875pn.m4419a(abstractC0863pbMo2354a, C0875pn.f4777iZ, (Component) Component.translatable("bf.message.command.game.admin.stage.reset.success.all", new Object[]{serverPlayer.getScoreboardName()}));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3304a(CommandContext<CommandSourceStack> commandContext, ServerPlayer serverPlayer) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4011eu && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (abstractC0531jNM179a instanceof C1280xT) {
                C0599kc c0599kcM8300a = ((C1326ym) ((C1328yo) ((C1280xT) abstractC0531jNM179a).m7277a()).m1150a((Player) serverPlayer)).m8300a();
                c0599kcM8300a.m2653z(!c0599kcM8300a.m2652am());
                boolean zM2652am = c0599kcM8300a.m2652am();
                C0721ms.m3327a(serverPlayer2, (Component) Component.translatable(f4010bJ, new Object[]{Component.literal(zM2652am ? "Enabled" : "Disabled").withStyle(zM2652am ? ChatFormatting.GREEN : ChatFormatting.RED), Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.WHITE)}));
                if (!zM2652am) {
                    C0721ms.m3327a(serverPlayer2, c0599kcM8300a.m2646b(serverPlayer.getScoreboardName()));
                }
            }
        }
    }

    /* JADX INFO: renamed from: f */
    private static void m3305f(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4011eu && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
            if (abstractC0863pbMo2354a != null) {
                abstractC0863pbMo2354a.m4087a().m5878dt();
                C0875pn.m4419a(abstractC0863pbMo2354a, C0875pn.f4777iZ, (Component) Component.translatable("bf.message.command.game.admin.stage.next.success.all", new Object[]{serverPlayer.getScoreboardName()}));
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private static void m3306g(@NotNull CommandContext<CommandSourceStack> commandContext) {
        C0775nt c0775ntCreate;
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4011eu && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
            Level level = serverPlayer.level();
            if (abstractC0863pbMo2354a == null || (c0775ntCreate = ((EntityType) C1307xu.f7601kG.get()).create(level)) == null) {
                return;
            }
            c0775ntCreate.mo3117e(abstractC0863pbMo2354a);
            level.addFreshEntity(c0775ntCreate);
            c0775ntCreate.setPos(serverPlayer.position());
            C0875pn.m4419a(abstractC0863pbMo2354a, C0875pn.f4777iZ, (Component) Component.translatable("bf.message.command.game.admin.nextbot.success.all", new Object[]{serverPlayer.getScoreboardName()}));
        }
    }

    /* JADX INFO: renamed from: h */
    private static void m3307h(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4011eu && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
            if (abstractC0863pbMo2354a != null) {
                abstractC0863pbMo2354a.m4063A(!abstractC0863pbMo2354a.m4062bo());
                C0875pn.m4419a(abstractC0863pbMo2354a, C0875pn.f4777iZ, (Component) Component.translatable(String.format("bf.message.command.game.admin.%s.success.all", abstractC0863pbMo2354a.m4062bo() ? "pause" : "unpause"), new Object[]{serverPlayer.getScoreboardName()}));
            } else {
                C0721ms.m3327a(serverPlayer, f4006iq);
            }
        }
    }

    /* JADX INFO: renamed from: i */
    private static void m3308i(@NotNull CommandContext<CommandSourceStack> commandContext) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4011eu && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
            if (abstractC0863pbMo2354a == null) {
                C0721ms.m3327a(serverPlayer, f4006iq);
                return;
            }
            RandomSource random = serverPlayer.serverLevel().getRandom();
            int i = 0;
            for (AbstractC0858pW abstractC0858pW : abstractC0863pbMo2354a.m4089a().m6107az()) {
                if ((abstractC0858pW instanceof C0969rb) && ((C0969rb) abstractC0858pW).m5389a(abstractC0863pbMo2354a, random)) {
                    i++;
                }
            }
            C0721ms.m3327a(serverPlayer, (Component) Component.literal("Triggered " + i + " weather transition(s)."));
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m3309b(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String str) {
        ServerPlayer entity = ((CommandSourceStack) commandContext.getSource()).getEntity();
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4011eu && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer.getUUID());
            if (abstractC0863pbMo2354a == null) {
                C0721ms.m3327a(serverPlayer, f4006iq);
            } else if (!abstractC0863pbMo2354a.m4007a(abstractC0531jNM179a, serverPlayer.serverLevel(), str)) {
                C0721ms.m3327a(serverPlayer, f4005ip);
            } else {
                C0875pn.m4419a(abstractC0863pbMo2354a, C0875pn.f4777iZ, (Component) Component.translatable("bf.message.command.game.admin.changemap.success.all", new Object[]{serverPlayer.getScoreboardName(), str}));
            }
        }
    }
}
