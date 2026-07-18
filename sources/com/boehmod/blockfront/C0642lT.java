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

/* JADX INFO: renamed from: com.boehmod.blockfront.lT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lT.class */
public class C0642lT {

    /* JADX INFO: renamed from: a */
    public static final LiteralArgumentBuilder<CommandSourceStack> f3529a;

    /* JADX INFO: renamed from: ea */
    static final /* synthetic */ boolean f3530ea;

    static {
        f3530ea = !C0642lT.class.desiredAssertionStatus();
        f3529a = Commands.literal("edit").then(m2845a().then(m2846b()));
    }

    /* JADX INFO: renamed from: a */
    public static void m2836a(CommandDispatcher<CommandSourceStack> commandDispatcher) {
        C0531jO c0531jOM2372c = C0531jO.m2372c();
        commandDispatcher.register(Commands.literal("assets").requires(commandSourceStack -> {
            return commandSourceStack.hasPermission(3);
        }).executes(commandContext -> {
            C0645lW.m2898b(((CommandSourceStack) commandContext.getSource()).source, Component.translatable("bf.message.command.game.manage.error.usage"));
            return 1;
        }).then(Commands.literal("list").then(m2845a().executes(commandContext2 -> {
            m2837a(((CommandSourceStack) commandContext2.getSource()).source, c0531jOM2372c, StringArgumentType.getString(commandContext2, "assetType"));
            return 1;
        }))).then(Commands.literal("remove").then(m2845a().then(m2846b().executes(commandContext3 -> {
            m2838a(((CommandSourceStack) commandContext3.getSource()).source, c0531jOM2372c, StringArgumentType.getString(commandContext3, "assetType"), StringArgumentType.getString(commandContext3, "assetName"));
            return 1;
        })))).then(Commands.literal("reload").executes(commandContext4 -> {
            m2839a(((CommandSourceStack) commandContext4.getSource()).source, c0531jOM2372c);
            return 1;
        })).then(Commands.literal("save-all").executes(commandContext5 -> {
            m2840b(((CommandSourceStack) commandContext5.getSource()).source, c0531jOM2372c);
            return 1;
        })).then(Commands.literal("test").executes(commandContext6 -> {
            m2841c(((CommandSourceStack) commandContext6.getSource()).source, c0531jOM2372c);
            return 1;
        })).then(Commands.literal("create").then(m2845a().then(Commands.argument("assetName", StringArgumentType.word()).then(Commands.argument("assetArg", StringArgumentType.greedyString()).suggests((commandContext7, suggestionsBuilder) -> {
            if (StringArgumentType.getString(commandContext7, "assetType").equals(C0530jN.f3135aO)) {
                return SharedSuggestionProvider.suggest(C1016sW.m5530h().stream().map((v0) -> {
                    return v0.m5537am();
                }), suggestionsBuilder);
            }
            return SharedSuggestionProvider.suggest(new String[0], suggestionsBuilder);
        }).executes(commandContext8 -> {
            m2842a(((CommandSourceStack) commandContext8.getSource()).source, c0531jOM2372c, StringArgumentType.getString(commandContext8, "assetType"), StringArgumentType.getString(commandContext8, "assetName"), StringArgumentType.getString(commandContext8, "assetArg"));
            return 1;
        }))))).then(f3529a.then(m2845a().then(m2846b().then(Commands.argument("args", StringArgumentType.greedyString()).suggests(C0642lT::m2844a).executes(commandContext9 -> {
            m2843a((CommandContext<CommandSourceStack>) commandContext9, c0531jOM2372c, StringArgumentType.getString(commandContext9, "assetType"), StringArgumentType.getString(commandContext9, "assetName"), StringArgumentType.getString(commandContext9, "args").split(" "));
            return 1;
        })).executes(commandContext10 -> {
            m2843a((CommandContext<CommandSourceStack>) commandContext10, c0531jOM2372c, StringArgumentType.getString(commandContext10, "assetType"), StringArgumentType.getString(commandContext10, "assetName"), new String[0]);
            return 1;
        })))));
    }

    /* JADX INFO: renamed from: a */
    private static void m2837a(@NotNull CommandSource commandSource, @NotNull C0531jO c0531jO, @NotNull String str) {
        C0562jt.log("[Command] Sending list of all assets...", new Object[0]);
        C0529jM c0529jMM2376a = c0531jO.m2376a(str);
        if (c0529jMM2376a == null) {
            C0645lW.m2897a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noregistry", new Object[]{str}));
            return;
        }
        Map mapM2358d = c0529jMM2376a.m2358d();
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.command.assets.list", new Object[]{Component.literal(String.valueOf(mapM2358d.size())).withStyle(C0565jw.f3204e), Component.literal(c0529jMM2376a.m2357x()).withStyle(C0565jw.f3204e)});
        C0645lW.m2898b(commandSource, Component.literal("----------------------------------"));
        C0645lW.m2898b(commandSource, mutableComponentTranslatable);
        C0645lW.m2898b(commandSource, Component.literal("----------------------------------"));
        Iterator it = mapM2358d.entrySet().iterator();
        while (it.hasNext()) {
            C0645lW.m2898b(commandSource, Component.literal(" - " + ((String) ((Map.Entry) it.next()).getKey())));
        }
        C0645lW.m2898b(commandSource, Component.literal("------------------------------"));
    }

    /* JADX INFO: renamed from: a */
    private static void m2838a(@NotNull CommandSource commandSource, @NotNull C0531jO c0531jO, @NotNull String str, @NotNull String str2) {
        C0562jt.log("[Command] Attempting to remove asset...", new Object[0]);
        C0529jM c0529jMM2376a = c0531jO.m2376a(str);
        if (c0529jMM2376a == null) {
            C0645lW.m2897a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noregistry", new Object[]{str}));
        } else if (c0529jMM2376a.m2347a(str2) == null) {
            C0645lW.m2897a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noasset", new Object[]{str2}));
        } else {
            c0529jMM2376a.m2359l(str2);
            C0645lW.m2898b(commandSource, Component.literal("Successfully unregistered asset '" + str2 + "'."));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2839a(@NotNull CommandSource commandSource, @NotNull C0531jO c0531jO) {
        C0562jt.log("[Command] Reloading all assets...", new Object[0]);
        C0645lW.m2898b(commandSource, Component.translatable("bf.message.command.assets.reload.reloading"));
        c0531jO.m2381bn();
        C0645lW.m2898b(commandSource, Component.translatable("bf.message.command.assets.reload.complete", new Object[]{Component.literal(String.valueOf(c0531jO.m2379an())).withStyle(C0565jw.f3204e), Component.literal(String.valueOf(c0531jO.m2380ao())).withStyle(C0565jw.f3204e)}));
    }

    /* JADX INFO: renamed from: b */
    private static void m2840b(@NotNull CommandSource commandSource, @NotNull C0531jO c0531jO) throws Exception {
        RunnableC0527jK runnableC0527jKM2373a = c0531jO.m2373a();
        C0562jt.log("[Command] Pausing file watcher for command execution.", new Object[0]);
        if (runnableC0527jKM2373a != null) {
            runnableC0527jKM2373a.m2331A(true);
        }
        C0562jt.log("[Command] Saving all assets...", new Object[0]);
        C0645lW.m2898b(commandSource, Component.translatable("bf.message.command.assets.saveall.saving"));
        c0531jO.m2378b(commandSource);
        C0645lW.m2898b(commandSource, Component.translatable("bf.message.command.assets.saveall.complete", new Object[]{Component.literal(String.valueOf(c0531jO.m2379an())).withStyle(C0565jw.f3204e), Component.literal(String.valueOf(c0531jO.m2380ao())).withStyle(C0565jw.f3204e)}));
        C0562jt.log("[Command] Resuming file watcher for command execution.", new Object[0]);
        if (runnableC0527jKM2373a != null) {
            runnableC0527jKM2373a.m2331A(false);
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m2841c(@NotNull CommandSource commandSource, @NotNull C0531jO c0531jO) {
        C0562jt.log("[Command] Testing all assets...", new Object[0]);
        C0645lW.m2898b(commandSource, Component.translatable("bf.message.command.assets.test.testing"));
        c0531jO.m2377a(commandSource);
        C0645lW.m2898b(commandSource, Component.translatable("bf.message.command.assets.test.testing.success"));
    }

    /* JADX INFO: renamed from: a */
    private static void m2842a(@NotNull CommandSource commandSource, @NotNull C0531jO c0531jO, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        C0562jt.log("[Command] Attempting to create asset...", new Object[0]);
        MutableComponent mutableComponentWithStyle = Component.literal(str).withStyle(C0565jw.f3204e);
        C0529jM c0529jMM2376a = c0531jO.m2376a(str);
        if (c0529jMM2376a == null) {
            C0645lW.m2897a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noregistry", new Object[]{str}));
            return;
        }
        MutableComponent mutableComponentWithStyle2 = Component.literal(str2).withStyle(C0565jw.f3204e);
        if (c0529jMM2376a.m2347a(str2) != null) {
            C0645lW.m2897a(commandSource, (Component) Component.translatable("bf.message.command.assets.create.error.exists", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            return;
        }
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f3530ea && abstractC0563juM168a == null) {
            throw new AssertionError("The mod manager instance is null!");
        }
        InterfaceC0537jU interfaceC0537jUMo2640a = c0529jMM2376a.m2360a().mo2640a(c0531jO.m2386ab(), abstractC0563juM168a, str2, str3);
        if (interfaceC0537jUMo2640a != null) {
            c0529jMM2376a.m2346a(str2, interfaceC0537jUMo2640a);
            C0645lW.m2898b(commandSource, Component.translatable("bf.message.command.assets.create.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
        } else {
            C0645lW.m2897a(commandSource, (Component) Component.translatable("bf.message.command.assets.create.fail", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2843a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull C0531jO c0531jO, @NotNull String str, @NotNull String str2, @NotNull String[] strArr) {
        C0562jt.log("[Command] Attempting to edit asset...", new Object[0]);
        CommandSource commandSource = ((CommandSourceStack) commandContext.getSource()).source;
        C0529jM c0529jMM2376a = c0531jO.m2376a(str);
        if (c0529jMM2376a == null) {
            C0645lW.m2897a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noregistry", new Object[]{str}));
            return;
        }
        InterfaceC0537jU interfaceC0537jUM2347a = c0529jMM2376a.m2347a(str2);
        if (interfaceC0537jUM2347a == null) {
            C0645lW.m2897a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noasset", new Object[]{str2}));
        } else {
            interfaceC0537jUM2347a.mo2429a().m2625a(commandContext, strArr);
        }
    }

    /* JADX INFO: renamed from: a */
    private static CompletableFuture<Suggestions> m2844a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull SuggestionsBuilder suggestionsBuilder) {
        InterfaceC0537jU interfaceC0537jUM2347a;
        try {
            C0529jM c0529jMM2376a = C0531jO.m2372c().m2376a(StringArgumentType.getString(commandContext, "assetType"));
            if (c0529jMM2376a != null && (interfaceC0537jUM2347a = c0529jMM2376a.m2347a(StringArgumentType.getString(commandContext, "assetName"))) != null) {
                String remaining = suggestionsBuilder.getRemaining();
                int iLastIndexOf = remaining.lastIndexOf(32);
                return SharedSuggestionProvider.suggest(interfaceC0537jUM2347a.mo2429a().m2631a(commandContext, iLastIndexOf == -1 ? new String[0] : remaining.substring(0, iLastIndexOf).split(" ")), suggestionsBuilder.createOffset(suggestionsBuilder.getStart() + iLastIndexOf + 1));
            }
            return suggestionsBuilder.buildFuture();
        } catch (Exception e) {
            return suggestionsBuilder.buildFuture();
        }
    }

    /* JADX INFO: renamed from: a */
    private static RequiredArgumentBuilder<CommandSourceStack, String> m2845a() {
        return Commands.argument("assetType", StringArgumentType.word()).suggests((commandContext, suggestionsBuilder) -> {
            return SharedSuggestionProvider.suggest(C0531jO.m2372c().m2383d(), suggestionsBuilder);
        });
    }

    /* JADX INFO: renamed from: b */
    private static RequiredArgumentBuilder<CommandSourceStack, String> m2846b() {
        return Commands.argument("assetName", StringArgumentType.word()).suggests((commandContext, suggestionsBuilder) -> {
            try {
                C0529jM c0529jMM2376a = C0531jO.m2372c().m2376a(StringArgumentType.getString(commandContext, "assetType"));
                if (c0529jMM2376a != null) {
                    return SharedSuggestionProvider.suggest(c0529jMM2376a.m2358d().keySet(), suggestionsBuilder);
                }
                return SharedSuggestionProvider.suggest(new String[0], suggestionsBuilder);
            } catch (Exception e) {
                return SharedSuggestionProvider.suggest(new String[0], suggestionsBuilder);
            }
        });
    }
}
