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

/* JADX INFO: renamed from: com.boehmod.blockfront.kx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kx.class */
public class C0620kx {

    /* JADX INFO: renamed from: af */
    @NotNull
    public final List<C0621ky> f3547af;

    /* JADX INFO: renamed from: F */
    @NotNull
    public final Map<String, C0620kx> f3548F;

    /* JADX INFO: renamed from: a */
    @Nullable
    public BiConsumer<CommandContext<CommandSourceStack>, String[]> f3549a;

    /* JADX INFO: renamed from: a */
    @Nullable
    public BiFunction<CommandContext<CommandSourceStack>, String[], Collection<String>> f3550a;

    public C0620kx() {
        this(null);
    }

    public C0620kx(@Nullable BiConsumer<CommandContext<CommandSourceStack>, String[]> biConsumer) {
        this.f3549a = biConsumer;
        this.f3548F = new Object2ObjectOpenHashMap();
        this.f3547af = new ObjectArrayList();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx m2835a(@NotNull C0620kx c0620kx) {
        this.f3548F.putAll(c0620kx.f3548F);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx m2836a(@NotNull C0621ky c0621ky) {
        this.f3547af.add(c0621ky);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m2837a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String[] strArr) {
        CommandSource commandSource = ((CommandSourceStack) commandContext.getSource()).source;
        for (C0621ky c0621ky : this.f3547af) {
            if (!c0621ky.m2846a().test(commandContext, strArr)) {
                C0721ms.m3328a(commandSource, (Component) Component.translatable("bf.message.command.assets.error", new Object[]{c0621ky.getMessage()}));
                return;
            }
        }
        m2844c(commandContext, strArr);
        m2838b(commandContext, strArr);
    }

    /* JADX INFO: renamed from: b */
    public void m2838b(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String[] strArr) {
        if (this.f3548F.isEmpty()) {
            return;
        }
        CommandSource commandSource = ((CommandSourceStack) commandContext.getSource()).source;
        if (strArr.length == 0) {
            C0721ms.m3329b(commandSource, Component.translatable("bf.message.command.assets.error.args", new Object[]{m2845c()}).withStyle(ChatFormatting.RED));
            return;
        }
        C0620kx c0620kx = this.f3548F.get(strArr[0]);
        if (c0620kx == null) {
            C0721ms.m3329b(commandSource, Component.translatable("bf.message.command.assets.error.usage", new Object[]{m2845c()}).withStyle(ChatFormatting.RED));
        } else {
            c0620kx.m2837a(commandContext, (String[]) Arrays.copyOfRange(strArr, 1, strArr.length));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx m2839a(@NotNull Map<String, C0620kx> map) {
        this.f3548F.putAll(map);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx m2840a(@NotNull String str, @NotNull C0620kx c0620kx) {
        this.f3548F.put(str, c0620kx);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx m2841a(@NotNull String[] strArr, @NotNull C0620kx c0620kx) {
        for (String str : strArr) {
            m2840a(str, c0620kx);
        }
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx m2842a(@NotNull BiFunction<CommandContext<CommandSourceStack>, String[], Collection<String>> biFunction) {
        this.f3550a = biFunction;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<String> m2843a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String[] strArr) {
        if (strArr.length > 0) {
            C0620kx c0620kx = this.f3548F.get(strArr[0]);
            if (c0620kx != null) {
                return c0620kx.m2843a(commandContext, (String[]) Arrays.copyOfRange(strArr, 1, strArr.length));
            }
            return this.f3550a != null ? this.f3550a.apply(commandContext, strArr) : List.of();
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(this.f3548F.keySet());
        if (this.f3550a != null) {
            objectArrayList.addAll(this.f3550a.apply(commandContext, strArr));
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: c */
    private void m2844c(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String[] strArr) {
        if (this.f3549a != null) {
            this.f3549a.accept(commandContext, strArr);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public MutableComponent m2845c() {
        MutableComponent mutableComponentEmpty = Component.empty();
        int size = this.f3548F.size();
        int i = 0;
        for (Map.Entry<String, C0620kx> entry : this.f3548F.entrySet()) {
            mutableComponentEmpty.append(Component.literal(entry.getKey()).withStyle(Style.EMPTY.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, entry.getValue().m2845c()))));
            if (i < size - 1) {
                mutableComponentEmpty.append(", ");
            }
            i++;
        }
        return mutableComponentEmpty.withStyle(ChatFormatting.GRAY);
    }
}
