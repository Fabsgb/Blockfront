package com.boehmod.blockfront;

import com.mojang.brigadier.context.CommandContext;
import java.util.function.BiPredicate;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kc.class */
public class C0598kc {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final BiPredicate<CommandContext<CommandSourceStack>, String[]> f3304a;

    /* JADX INFO: renamed from: id */
    @NotNull
    private final Component f3305id;

    public C0598kc(@NotNull BiPredicate<CommandContext<CommandSourceStack>, String[]> biPredicate, @NotNull Component component) {
        this.f3304a = biPredicate;
        this.f3305id = component;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public BiPredicate<CommandContext<CommandSourceStack>, String[]> m2634a() {
        return this.f3304a;
    }

    @NotNull
    public Component getMessage() {
        return this.f3305id;
    }
}
