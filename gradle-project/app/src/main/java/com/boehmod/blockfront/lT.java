package com.boehmod.blockfront;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lT.class */
public class lT {
    public static final LiteralArgumentBuilder<CommandSourceStack> a;
    static final /* synthetic */ boolean ea;

    static {
        ea = !lT.class.desiredAssertionStatus();
        a = Commands.literal("edit").then(a().then(b()));
    }

    public static void a(CommandDispatcher<CommandSourceStack> commandDispatcher) {
        jO jOVarC = jO.c();
        commandDispatcher.register(Commands.literal("assets").requires(commandSourceStack -> {
            return commandSourceStack.hasPermission(3);
        }).executes(commandContext -> {
            lW.b(((CommandSourceStack) commandContext.getSource()).source, Component.translatable("bf.message.command.game.manage.error.usage"));
            return 1;
        }).then(Commands.literal("list").then(a().executes(commandContext2 -> {
            a(((CommandSourceStack) commandContext2.getSource()).source, jOVarC, StringArgumentType.getString(commandContext2, "assetType"));
            return 1;
        }))).then(Commands.literal("remove").then(a().then(b().executes(commandContext3 -> {
            a(((CommandSourceStack) commandContext3.getSource()).source, jOVarC, StringArgumentType.getString(commandContext3, "assetType"), StringArgumentType.getString(commandContext3, "assetName"));
            return 1;
        })))).then(Commands.literal("reload").executes(commandContext4 -> {
            a(((CommandSourceStack) commandContext4.getSource()).source, jOVarC);
            return 1;
        })).then(Commands.literal("save-all").executes(commandContext5 -> {
            b(((CommandSourceStack) commandContext5.getSource()).source, jOVarC);
            return 1;
        })).then(Commands.literal("test").executes(commandContext6 -> {
            c(((CommandSourceStack) commandContext6.getSource()).source, jOVarC);
            return 1;
        })).then(Commands.literal("create").then(a().then(Commands.argument("assetName", StringArgumentType.word()).then(Commands.argument("assetArg", StringArgumentType.greedyString()).suggests((commandContext7, suggestionsBuilder) -> {
            if (StringArgumentType.getString(commandContext7, "assetType").equals(jN.aO)) {
                return SharedSuggestionProvider.suggest(sW.h().stream().map((v0) -> {
                    return v0.am();
                }), suggestionsBuilder);
            }
            return SharedSuggestionProvider.suggest(new String[0], suggestionsBuilder);
        }).executes(commandContext8 -> {
            a(((CommandSourceStack) commandContext8.getSource()).source, jOVarC, StringArgumentType.getString(commandContext8, "assetType"), StringArgumentType.getString(commandContext8, "assetName"), StringArgumentType.getString(commandContext8, "assetArg"));
            return 1;
        }))))).then(a.then(a().then(b().then(Commands.argument("args", StringArgumentType.greedyString()).suggests(lT::a).executes(commandContext9 -> {
            a((CommandContext<CommandSourceStack>) commandContext9, jOVarC, StringArgumentType.getString(commandContext9, "assetType"), StringArgumentType.getString(commandContext9, "assetName"), StringArgumentType.getString(commandContext9, "args").split(" "));
            return 1;
        })).executes(commandContext10 -> {
            a((CommandContext<CommandSourceStack>) commandContext10, jOVarC, StringArgumentType.getString(commandContext10, "assetType"), StringArgumentType.getString(commandContext10, "assetName"), new String[0]);
            return 1;
        })))));
    }

    private static void a(@NotNull CommandSource commandSource, @NotNull jO jOVar, @NotNull String str) {
        C0263jt.log("[Command] Sending list of all assets...", new Object[0]);
        jM jMVarA = jOVar.a(str);
        if (jMVarA == null) {
            lW.a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noregistry", new Object[]{str}));
            return;
        }
        Map mapD = jMVarA.d();
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.command.assets.list", new Object[]{Component.literal(String.valueOf(mapD.size())).withStyle(C0266jw.e), Component.literal(jMVarA.x()).withStyle(C0266jw.e)});
        lW.b(commandSource, Component.literal("----------------------------------"));
        lW.b(commandSource, mutableComponentTranslatable);
        lW.b(commandSource, Component.literal("----------------------------------"));
        Iterator it = mapD.entrySet().iterator();
        while (it.hasNext()) {
            lW.b(commandSource, Component.literal(" - " + ((String) ((Map.Entry) it.next()).getKey())));
        }
        lW.b(commandSource, Component.literal("------------------------------"));
    }

    private static void a(@NotNull CommandSource commandSource, @NotNull jO jOVar, @NotNull String str, @NotNull String str2) {
        C0263jt.log("[Command] Attempting to remove asset...", new Object[0]);
        jM jMVarA = jOVar.a(str);
        if (jMVarA == null) {
            lW.a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noregistry", new Object[]{str}));
        } else if (jMVarA.a(str2) == null) {
            lW.a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noasset", new Object[]{str2}));
        } else {
            jMVarA.l(str2);
            lW.b(commandSource, Component.literal("Successfully unregistered asset '" + str2 + "'."));
        }
    }

    private static void a(@NotNull CommandSource commandSource, @NotNull jO jOVar) {
        C0263jt.log("[Command] Reloading all assets...", new Object[0]);
        lW.b(commandSource, Component.translatable("bf.message.command.assets.reload.reloading"));
        jOVar.bn();
        lW.b(commandSource, Component.translatable("bf.message.command.assets.reload.complete", new Object[]{Component.literal(String.valueOf(jOVar.an())).withStyle(C0266jw.e), Component.literal(String.valueOf(jOVar.ao())).withStyle(C0266jw.e)}));
    }

    private static void b(@NotNull CommandSource commandSource, @NotNull jO jOVar) throws Exception {
        jK jKVarA = jOVar.a();
        C0263jt.log("[Command] Pausing file watcher for command execution.", new Object[0]);
        if (jKVarA != null) {
            jKVarA.A(true);
        }
        C0263jt.log("[Command] Saving all assets...", new Object[0]);
        lW.b(commandSource, Component.translatable("bf.message.command.assets.saveall.saving"));
        jOVar.b(commandSource);
        lW.b(commandSource, Component.translatable("bf.message.command.assets.saveall.complete", new Object[]{Component.literal(String.valueOf(jOVar.an())).withStyle(C0266jw.e), Component.literal(String.valueOf(jOVar.ao())).withStyle(C0266jw.e)}));
        C0263jt.log("[Command] Resuming file watcher for command execution.", new Object[0]);
        if (jKVarA != null) {
            jKVarA.A(false);
        }
    }

    private static void c(@NotNull CommandSource commandSource, @NotNull jO jOVar) {
        C0263jt.log("[Command] Testing all assets...", new Object[0]);
        lW.b(commandSource, Component.translatable("bf.message.command.assets.test.testing"));
        jOVar.a(commandSource);
        lW.b(commandSource, Component.translatable("bf.message.command.assets.test.testing.success"));
    }

    private static void a(@NotNull CommandSource commandSource, @NotNull jO jOVar, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        C0263jt.log("[Command] Attempting to create asset...", new Object[0]);
        MutableComponent mutableComponentWithStyle = Component.literal(str).withStyle(C0266jw.e);
        jM jMVarA = jOVar.a(str);
        if (jMVarA == null) {
            lW.a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noregistry", new Object[]{str}));
            return;
        }
        MutableComponent mutableComponentWithStyle2 = Component.literal(str2).withStyle(C0266jw.e);
        if (jMVarA.a(str2) != null) {
            lW.a(commandSource, (Component) Component.translatable("bf.message.command.assets.create.error.exists", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            return;
        }
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!ea && abstractC0264juM166a == null) {
            throw new AssertionError("The mod manager instance is null!");
        }
        jU jUVarA = jMVarA.a().a(jOVar.ab(), abstractC0264juM166a, str2, str3);
        if (jUVarA != null) {
            jMVarA.a(str2, jUVarA);
            lW.b(commandSource, Component.translatable("bf.message.command.assets.create.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
        } else {
            lW.a(commandSource, (Component) Component.translatable("bf.message.command.assets.create.fail", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
        }
    }

    private static void a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull jO jOVar, @NotNull String str, @NotNull String str2, @NotNull String[] strArr) {
        C0263jt.log("[Command] Attempting to edit asset...", new Object[0]);
        CommandSource commandSource = ((CommandSourceStack) commandContext.getSource()).source;
        jM jMVarA = jOVar.a(str);
        if (jMVarA == null) {
            lW.a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noregistry", new Object[]{str}));
            return;
        }
        jU jUVarA = jMVarA.a(str2);
        if (jUVarA == null) {
            lW.a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noasset", new Object[]{str2}));
        } else {
            jUVarA.mo565a().a(commandContext, strArr);
        }
    }

    private static CompletableFuture<Suggestions> a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull SuggestionsBuilder suggestionsBuilder) {
        jU jUVarA;
        try {
            jM jMVarA = jO.c().a(StringArgumentType.getString(commandContext, "assetType"));
            if (jMVarA != null && (jUVarA = jMVarA.a(StringArgumentType.getString(commandContext, "assetName"))) != null) {
                String remaining = suggestionsBuilder.getRemaining();
                int iLastIndexOf = remaining.lastIndexOf(32);
                return SharedSuggestionProvider.suggest(jUVarA.mo565a().m562a(commandContext, iLastIndexOf == -1 ? new String[0] : remaining.substring(0, iLastIndexOf).split(" ")), suggestionsBuilder.createOffset(suggestionsBuilder.getStart() + iLastIndexOf + 1));
            }
            return suggestionsBuilder.buildFuture();
        } catch (Exception e) {
            return suggestionsBuilder.buildFuture();
        }
    }

    private static RequiredArgumentBuilder<CommandSourceStack, String> a() {
        return Commands.argument("assetType", StringArgumentType.word()).suggests((commandContext, suggestionsBuilder) -> {
            return SharedSuggestionProvider.suggest(jO.c().d(), suggestionsBuilder);
        });
    }

    private static RequiredArgumentBuilder<CommandSourceStack, String> b() {
        return Commands.argument("assetName", StringArgumentType.word()).suggests((commandContext, suggestionsBuilder) -> {
            try {
                jM jMVarA = jO.c().a(StringArgumentType.getString(commandContext, "assetType"));
                if (jMVarA != null) {
                    return SharedSuggestionProvider.suggest(jMVarA.d().keySet(), suggestionsBuilder);
                }
                return SharedSuggestionProvider.suggest(new String[0], suggestionsBuilder);
            } catch (Exception e) {
                return SharedSuggestionProvider.suggest(new String[0], suggestionsBuilder);
            }
        });
    }
}
