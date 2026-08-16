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

/* JADX INFO: renamed from: com.boehmod.blockfront.mp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mp.class */
public class C0718mp {

    /* JADX INFO: renamed from: a */
    public static final LiteralArgumentBuilder<CommandSourceStack> f4003a;

    /* JADX INFO: renamed from: et */
    static final /* synthetic */ boolean f4004et;

    static {
        f4004et = !C0718mp.class.desiredAssertionStatus();
        f4003a = Commands.literal("edit").then(m3276a().then(m3277b()));
    }

    /* JADX INFO: renamed from: a */
    public static void m3267a(CommandDispatcher<CommandSourceStack> commandDispatcher) {
        C0607kk c0607kkM2734c = C0607kk.m2734c();
        commandDispatcher.register(Commands.literal("assets").requires(commandSourceStack -> {
            return commandSourceStack.hasPermission(3);
        }).executes(commandContext -> {
            C0721ms.m3329b(((CommandSourceStack) commandContext.getSource()).source, Component.translatable("bf.message.command.game.manage.error.usage"));
            return 1;
        }).then(Commands.literal("list").then(m3276a().executes(commandContext2 -> {
            m3268a(((CommandSourceStack) commandContext2.getSource()).source, c0607kkM2734c, StringArgumentType.getString(commandContext2, "assetType"));
            return 1;
        }))).then(Commands.literal("remove").then(m3276a().then(m3277b().executes(commandContext3 -> {
            m3269a(((CommandSourceStack) commandContext3.getSource()).source, c0607kkM2734c, StringArgumentType.getString(commandContext3, "assetType"), StringArgumentType.getString(commandContext3, "assetName"));
            return 1;
        })))).then(Commands.literal("reload").executes(commandContext4 -> {
            m3270a(((CommandSourceStack) commandContext4.getSource()).source, c0607kkM2734c);
            return 1;
        })).then(Commands.literal("save-all").executes(commandContext5 -> {
            m3271b(((CommandSourceStack) commandContext5.getSource()).source, c0607kkM2734c);
            return 1;
        })).then(Commands.literal("test").executes(commandContext6 -> {
            m3272c(((CommandSourceStack) commandContext6.getSource()).source, c0607kkM2734c);
            return 1;
        })).then(Commands.literal("create").then(m3276a().then(Commands.argument("assetName", StringArgumentType.word()).then(Commands.argument("assetArg", StringArgumentType.greedyString()).suggests((commandContext7, suggestionsBuilder) -> {
            if (StringArgumentType.getString(commandContext7, "assetType").equals(C0606kj.f3513aX)) {
                return SharedSuggestionProvider.suggest(C1094tt.m6018h().stream().map((v0) -> {
                    return v0.m6025at();
                }), suggestionsBuilder);
            }
            return SharedSuggestionProvider.suggest(new String[0], suggestionsBuilder);
        }).executes(commandContext8 -> {
            m3273a(((CommandSourceStack) commandContext8.getSource()).source, c0607kkM2734c, StringArgumentType.getString(commandContext8, "assetType"), StringArgumentType.getString(commandContext8, "assetName"), StringArgumentType.getString(commandContext8, "assetArg"));
            return 1;
        }))))).then(f4003a.then(m3276a().then(m3277b().then(Commands.argument("args", StringArgumentType.greedyString()).suggests(C0718mp::m3275a).executes(commandContext9 -> {
            m3274a((CommandContext<CommandSourceStack>) commandContext9, c0607kkM2734c, StringArgumentType.getString(commandContext9, "assetType"), StringArgumentType.getString(commandContext9, "assetName"), StringArgumentType.getString(commandContext9, "args").split(" "));
            return 1;
        })).executes(commandContext10 -> {
            m3274a((CommandContext<CommandSourceStack>) commandContext10, c0607kkM2734c, StringArgumentType.getString(commandContext10, "assetType"), StringArgumentType.getString(commandContext10, "assetName"), new String[0]);
            return 1;
        })))));
    }

    /* JADX INFO: renamed from: a */
    private static void m3268a(@NotNull CommandSource commandSource, @NotNull C0607kk c0607kk, @NotNull String str) {
        C0530jM.log("[Command] Sending list of all assets...", new Object[0]);
        C0605ki c0605kiM2738a = c0607kk.m2738a(str);
        if (c0605kiM2738a == null) {
            C0721ms.m3328a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noregistry", new Object[]{str}));
            return;
        }
        Map mapM2720d = c0605kiM2738a.m2720d();
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.command.assets.list", new Object[]{Component.literal(String.valueOf(mapM2720d.size())).withStyle(C0533jP.f3188e), Component.literal(c0605kiM2738a.m2719E()).withStyle(C0533jP.f3188e)});
        C0721ms.m3329b(commandSource, Component.literal("----------------------------------"));
        C0721ms.m3329b(commandSource, mutableComponentTranslatable);
        C0721ms.m3329b(commandSource, Component.literal("----------------------------------"));
        Iterator it = mapM2720d.entrySet().iterator();
        while (it.hasNext()) {
            C0721ms.m3329b(commandSource, Component.literal(" - " + ((String) ((Map.Entry) it.next()).getKey())));
        }
        C0721ms.m3329b(commandSource, Component.literal("------------------------------"));
    }

    /* JADX INFO: renamed from: a */
    private static void m3269a(@NotNull CommandSource commandSource, @NotNull C0607kk c0607kk, @NotNull String str, @NotNull String str2) {
        C0530jM.log("[Command] Attempting to remove asset...", new Object[0]);
        C0605ki c0605kiM2738a = c0607kk.m2738a(str);
        if (c0605kiM2738a == null) {
            C0721ms.m3328a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noregistry", new Object[]{str}));
        } else if (c0605kiM2738a.m2707a(str2) == null) {
            C0721ms.m3328a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noasset", new Object[]{str2}));
        } else {
            c0605kiM2738a.m2721l(str2);
            C0721ms.m3329b(commandSource, Component.literal("Successfully unregistered asset '" + str2 + "'."));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3270a(@NotNull CommandSource commandSource, @NotNull C0607kk c0607kk) {
        C0530jM.log("[Command] Reloading all assets...", new Object[0]);
        C0721ms.m3329b(commandSource, Component.translatable("bf.message.command.assets.reload.reloading"));
        c0607kk.m2743by();
        C0721ms.m3329b(commandSource, Component.translatable("bf.message.command.assets.reload.complete", new Object[]{Component.literal(String.valueOf(c0607kk.m2741aC())).withStyle(C0533jP.f3188e), Component.literal(String.valueOf(c0607kk.m2742aD())).withStyle(C0533jP.f3188e)}));
    }

    /* JADX INFO: renamed from: b */
    private static void m3271b(@NotNull CommandSource commandSource, @NotNull C0607kk c0607kk) throws Exception {
        RunnableC0603kg runnableC0603kgM2735a = c0607kk.m2735a();
        C0530jM.log("[Command] Pausing file watcher for command execution.", new Object[0]);
        if (runnableC0603kgM2735a != null) {
            runnableC0603kgM2735a.m2691A(true);
        }
        C0530jM.log("[Command] Saving all assets...", new Object[0]);
        C0721ms.m3329b(commandSource, Component.translatable("bf.message.command.assets.saveall.saving"));
        c0607kk.m2740b(commandSource);
        C0721ms.m3329b(commandSource, Component.translatable("bf.message.command.assets.saveall.complete", new Object[]{Component.literal(String.valueOf(c0607kk.m2741aC())).withStyle(C0533jP.f3188e), Component.literal(String.valueOf(c0607kk.m2742aD())).withStyle(C0533jP.f3188e)}));
        C0530jM.log("[Command] Resuming file watcher for command execution.", new Object[0]);
        if (runnableC0603kgM2735a != null) {
            runnableC0603kgM2735a.m2691A(false);
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m3272c(@NotNull CommandSource commandSource, @NotNull C0607kk c0607kk) {
        C0530jM.log("[Command] Testing all assets...", new Object[0]);
        C0721ms.m3329b(commandSource, Component.translatable("bf.message.command.assets.test.testing"));
        c0607kk.m2739a(commandSource);
        C0721ms.m3329b(commandSource, Component.translatable("bf.message.command.assets.test.testing.success"));
    }

    /* JADX INFO: renamed from: a */
    private static void m3273a(@NotNull CommandSource commandSource, @NotNull C0607kk c0607kk, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        C0530jM.log("[Command] Attempting to create asset...", new Object[0]);
        MutableComponent mutableComponentWithStyle = Component.literal(str).withStyle(C0533jP.f3188e);
        C0605ki c0605kiM2738a = c0607kk.m2738a(str);
        if (c0605kiM2738a == null) {
            C0721ms.m3328a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noregistry", new Object[]{str}));
            return;
        }
        MutableComponent mutableComponentWithStyle2 = Component.literal(str2).withStyle(C0533jP.f3188e);
        if (c0605kiM2738a.m2707a(str2) != null) {
            C0721ms.m3328a(commandSource, (Component) Component.translatable("bf.message.command.assets.create.error.exists", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            return;
        }
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4004et && abstractC0531jNM179a == null) {
            throw new AssertionError("The mod manager instance is null!");
        }
        InterfaceC0613kq interfaceC0613kqMo2590a = c0605kiM2738a.m2722a().mo2590a(c0607kk.m2748ae(), abstractC0531jNM179a, str2, str3);
        if (interfaceC0613kqMo2590a != null) {
            c0605kiM2738a.m2706a(str2, interfaceC0613kqMo2590a);
            C0721ms.m3329b(commandSource, Component.translatable("bf.message.command.assets.create.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
        } else {
            C0721ms.m3328a(commandSource, (Component) Component.translatable("bf.message.command.assets.create.fail", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3274a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull C0607kk c0607kk, @NotNull String str, @NotNull String str2, @NotNull String[] strArr) {
        C0530jM.log("[Command] Attempting to edit asset...", new Object[0]);
        CommandSource commandSource = ((CommandSourceStack) commandContext.getSource()).source;
        C0605ki c0605kiM2738a = c0607kk.m2738a(str);
        if (c0605kiM2738a == null) {
            C0721ms.m3328a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noregistry", new Object[]{str}));
            return;
        }
        InterfaceC0613kq interfaceC0613kqM2707a = c0605kiM2738a.m2707a(str2);
        if (interfaceC0613kqM2707a == null) {
            C0721ms.m3328a(commandSource, (Component) Component.translatable("bf.message.command.assets.error.noasset", new Object[]{str2}));
        } else {
            interfaceC0613kqM2707a.mo2596a().m2837a(commandContext, strArr);
        }
    }

    /* JADX INFO: renamed from: a */
    private static CompletableFuture<Suggestions> m3275a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull SuggestionsBuilder suggestionsBuilder) {
        InterfaceC0613kq interfaceC0613kqM2707a;
        try {
            C0605ki c0605kiM2738a = C0607kk.m2734c().m2738a(StringArgumentType.getString(commandContext, "assetType"));
            if (c0605kiM2738a != null && (interfaceC0613kqM2707a = c0605kiM2738a.m2707a(StringArgumentType.getString(commandContext, "assetName"))) != null) {
                String remaining = suggestionsBuilder.getRemaining();
                int iLastIndexOf = remaining.lastIndexOf(32);
                return SharedSuggestionProvider.suggest(interfaceC0613kqM2707a.mo2596a().m2843a(commandContext, iLastIndexOf == -1 ? new String[0] : remaining.substring(0, iLastIndexOf).split(" ")), suggestionsBuilder.createOffset(suggestionsBuilder.getStart() + iLastIndexOf + 1));
            }
            return suggestionsBuilder.buildFuture();
        } catch (Exception e) {
            return suggestionsBuilder.buildFuture();
        }
    }

    /* JADX INFO: renamed from: a */
    private static RequiredArgumentBuilder<CommandSourceStack, String> m3276a() {
        return Commands.argument("assetType", StringArgumentType.word()).suggests((commandContext, suggestionsBuilder) -> {
            return SharedSuggestionProvider.suggest(C0607kk.m2734c().m2745d(), suggestionsBuilder);
        });
    }

    /* JADX INFO: renamed from: b */
    private static RequiredArgumentBuilder<CommandSourceStack, String> m3277b() {
        return Commands.argument("assetName", StringArgumentType.word()).suggests((commandContext, suggestionsBuilder) -> {
            try {
                C0605ki c0605kiM2738a = C0607kk.m2734c().m2738a(StringArgumentType.getString(commandContext, "assetType"));
                if (c0605kiM2738a != null) {
                    return SharedSuggestionProvider.suggest(c0605kiM2738a.m2720d().keySet(), suggestionsBuilder);
                }
                return SharedSuggestionProvider.suggest(new String[0], suggestionsBuilder);
            } catch (Exception e) {
                return SharedSuggestionProvider.suggest(new String[0], suggestionsBuilder);
            }
        });
    }
}
