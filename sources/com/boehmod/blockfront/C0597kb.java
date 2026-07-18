package com.boehmod.blockfront;

import com.mojang.brigadier.context.CommandContext;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kb.class */
public class C0597kb {

    /* JADX INFO: renamed from: Y */
    @NotNull
    public final List<C0598kc> f3300Y;

    /* JADX INFO: renamed from: F */
    @NotNull
    public final Map<String, C0597kb> f3301F;

    /* JADX INFO: renamed from: a */
    @Nullable
    public BiConsumer<CommandContext<CommandSourceStack>, String[]> f3302a;

    /* JADX INFO: renamed from: a */
    @Nullable
    public BiFunction<CommandContext<CommandSourceStack>, String[], Collection<String>> f3303a;

    public C0597kb() {
        this(null);
    }

    public C0597kb(@Nullable BiConsumer<CommandContext<CommandSourceStack>, String[]> biConsumer) {
        this.f3302a = biConsumer;
        this.f3301F = new Object2ObjectOpenHashMap();
        this.f3300Y = new ObjectArrayList();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb m2623a(@NotNull C0597kb c0597kb) {
        this.f3301F.putAll(c0597kb.f3301F);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb m2624a(@NotNull C0598kc c0598kc) {
        this.f3300Y.add(c0598kc);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m2625a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String[] strArr) {
        CommandSource commandSource = ((CommandSourceStack) commandContext.getSource()).source;
        for (C0598kc c0598kc : this.f3300Y) {
            if (!c0598kc.m2634a().test(commandContext, strArr)) {
                C0645lW.m2897a(commandSource, (Component) Component.translatable("bf.message.command.assets.error", new Object[]{c0598kc.getMessage()}));
                return;
            }
        }
        m2632c(commandContext, strArr);
        m2626b(commandContext, strArr);
    }

    /* JADX INFO: renamed from: b */
    public void m2626b(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String[] strArr) {
        if (this.f3301F.isEmpty()) {
            return;
        }
        CommandSource commandSource = ((CommandSourceStack) commandContext.getSource()).source;
        if (strArr.length == 0) {
            C0645lW.m2898b(commandSource, Component.translatable("bf.message.command.assets.error.args", new Object[]{m2633c()}).withStyle(ChatFormatting.RED));
            return;
        }
        C0597kb c0597kb = this.f3301F.get(strArr[0]);
        if (c0597kb == null) {
            C0645lW.m2898b(commandSource, Component.translatable("bf.message.command.assets.error.usage", new Object[]{m2633c()}).withStyle(ChatFormatting.RED));
        } else {
            c0597kb.m2625a(commandContext, (String[]) Arrays.copyOfRange(strArr, 1, strArr.length));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb m2627a(@NotNull Map<String, C0597kb> map) {
        this.f3301F.putAll(map);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb m2628a(@NotNull String str, @NotNull C0597kb c0597kb) {
        this.f3301F.put(str, c0597kb);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb m2629a(@NotNull String[] strArr, @NotNull C0597kb c0597kb) {
        for (String str : strArr) {
            m2628a(str, c0597kb);
        }
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb m2630a(@NotNull BiFunction<CommandContext<CommandSourceStack>, String[], Collection<String>> biFunction) {
        this.f3303a = biFunction;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<String> m2631a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String[] strArr) {
        if (strArr.length > 0) {
            C0597kb c0597kb = this.f3301F.get(strArr[0]);
            if (c0597kb != null) {
                return c0597kb.m2631a(commandContext, (String[]) Arrays.copyOfRange(strArr, 1, strArr.length));
            }
            return this.f3303a != null ? this.f3303a.apply(commandContext, strArr) : List.of();
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(this.f3301F.keySet());
        if (this.f3303a != null) {
            objectArrayList.addAll(this.f3303a.apply(commandContext, strArr));
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: c */
    private void m2632c(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String[] strArr) {
        if (this.f3302a != null) {
            this.f3302a.accept(commandContext, strArr);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public MutableComponent m2633c() {
        MutableComponent mutableComponentEmpty = Component.empty();
        int size = this.f3301F.size();
        int i = 0;
        for (Map.Entry<String, C0597kb> entry : this.f3301F.entrySet()) {
            mutableComponentEmpty.append(Component.literal(entry.getKey()).withStyle(Style.EMPTY.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, entry.getValue().m2633c()))));
            if (i < size - 1) {
                mutableComponentEmpty.append(", ");
            }
            i++;
        }
        return mutableComponentEmpty.withStyle(ChatFormatting.GRAY);
    }
}
