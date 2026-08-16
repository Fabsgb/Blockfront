package com.boehmod.blockfront;

import com.mojang.brigadier.context.CommandContext;
import java.util.function.BiPredicate;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ky */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ky.class */
public class C0621ky {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final BiPredicate<CommandContext<CommandSourceStack>, String[]> f3551a;

    /* JADX INFO: renamed from: io */
    @NotNull
    private final Component f3552io;

    public C0621ky(@NotNull BiPredicate<CommandContext<CommandSourceStack>, String[]> biPredicate, @NotNull Component component) {
        this.f3551a = biPredicate;
        this.f3552io = component;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public BiPredicate<CommandContext<CommandSourceStack>, String[]> m2846a() {
        return this.f3551a;
    }

    @NotNull
    public Component getMessage() {
        return this.f3552io;
    }
}
