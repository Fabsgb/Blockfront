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

/* JADX INFO: renamed from: com.boehmod.blockfront.kb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kb.class */
public class C0272kb {

    @NotNull
    public final List<C0273kc> Y;

    @NotNull
    public final Map<String, C0272kb> F;

    @Nullable
    public BiConsumer<CommandContext<CommandSourceStack>, String[]> a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public BiFunction<CommandContext<CommandSourceStack>, String[], Collection<String>> f197a;

    public C0272kb() {
        this(null);
    }

    public C0272kb(@Nullable BiConsumer<CommandContext<CommandSourceStack>, String[]> biConsumer) {
        this.a = biConsumer;
        this.F = new Object2ObjectOpenHashMap();
        this.Y = new ObjectArrayList();
    }

    @NotNull
    public C0272kb a(@NotNull C0272kb c0272kb) {
        this.F.putAll(c0272kb.F);
        return this;
    }

    @NotNull
    public C0272kb a(@NotNull C0273kc c0273kc) {
        this.Y.add(c0273kc);
        return this;
    }

    public void a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String[] strArr) {
        CommandSource commandSource = ((CommandSourceStack) commandContext.getSource()).source;
        for (C0273kc c0273kc : this.Y) {
            if (!c0273kc.a().test(commandContext, strArr)) {
                lW.a(commandSource, (Component) Component.translatable("bf.message.command.assets.error", new Object[]{c0273kc.getMessage()}));
                return;
            }
        }
        c(commandContext, strArr);
        b(commandContext, strArr);
    }

    public void b(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String[] strArr) {
        if (this.F.isEmpty()) {
            return;
        }
        CommandSource commandSource = ((CommandSourceStack) commandContext.getSource()).source;
        if (strArr.length == 0) {
            lW.b(commandSource, Component.translatable("bf.message.command.assets.error.args", new Object[]{c()}).withStyle(ChatFormatting.RED));
            return;
        }
        C0272kb c0272kb = this.F.get(strArr[0]);
        if (c0272kb == null) {
            lW.b(commandSource, Component.translatable("bf.message.command.assets.error.usage", new Object[]{c()}).withStyle(ChatFormatting.RED));
        } else {
            c0272kb.a(commandContext, (String[]) Arrays.copyOfRange(strArr, 1, strArr.length));
        }
    }

    @NotNull
    public C0272kb a(@NotNull Map<String, C0272kb> map) {
        this.F.putAll(map);
        return this;
    }

    @NotNull
    public C0272kb a(@NotNull String str, @NotNull C0272kb c0272kb) {
        this.F.put(str, c0272kb);
        return this;
    }

    @NotNull
    public C0272kb a(@NotNull String[] strArr, @NotNull C0272kb c0272kb) {
        for (String str : strArr) {
            a(str, c0272kb);
        }
        return this;
    }

    @NotNull
    public C0272kb a(@NotNull BiFunction<CommandContext<CommandSourceStack>, String[], Collection<String>> biFunction) {
        this.f197a = biFunction;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Collection<String> m562a(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String[] strArr) {
        if (strArr.length > 0) {
            C0272kb c0272kb = this.F.get(strArr[0]);
            if (c0272kb != null) {
                return c0272kb.m562a(commandContext, (String[]) Arrays.copyOfRange(strArr, 1, strArr.length));
            }
            return this.f197a != null ? this.f197a.apply(commandContext, strArr) : List.of();
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(this.F.keySet());
        if (this.f197a != null) {
            objectArrayList.addAll(this.f197a.apply(commandContext, strArr));
        }
        return objectArrayList;
    }

    private void c(@NotNull CommandContext<CommandSourceStack> commandContext, @NotNull String[] strArr) {
        if (this.a != null) {
            this.a.accept(commandContext, strArr);
        }
    }

    @NotNull
    public MutableComponent c() {
        MutableComponent mutableComponentEmpty = Component.empty();
        int size = this.F.size();
        int i = 0;
        for (Map.Entry<String, C0272kb> entry : this.F.entrySet()) {
            mutableComponentEmpty.append(Component.literal(entry.getKey()).withStyle(Style.EMPTY.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, entry.getValue().c()))));
            if (i < size - 1) {
                mutableComponentEmpty.append(", ");
            }
            i++;
        }
        return mutableComponentEmpty.withStyle(ChatFormatting.GRAY);
    }
}
