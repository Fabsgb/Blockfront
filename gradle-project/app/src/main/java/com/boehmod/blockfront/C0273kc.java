package com.boehmod.blockfront;

import com.mojang.brigadier.context.CommandContext;
import java.util.function.BiPredicate;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kc.class */
public class C0273kc {

    @NotNull
    private final BiPredicate<CommandContext<CommandSourceStack>, String[]> a;

    @NotNull
    private final Component id;

    public C0273kc(@NotNull BiPredicate<CommandContext<CommandSourceStack>, String[]> biPredicate, @NotNull Component component) {
        this.a = biPredicate;
        this.id = component;
    }

    @NotNull
    public BiPredicate<CommandContext<CommandSourceStack>, String[]> a() {
        return this.a;
    }

    @NotNull
    public Component getMessage() {
        return this.id;
    }
}
