package com.boehmod.blockfront;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pT.class */
public class pT extends pQ<Integer> {
    public final int nW;
    public final int nX;

    public pT(@NotNull Component component, @NotNull Supplier<Integer> supplier, @NotNull Consumer<Integer> consumer) {
        this(component, supplier, consumer, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public pT(@NotNull Component component, @NotNull Supplier<Integer> supplier, @NotNull Consumer<Integer> consumer, int i, int i2) {
        super(component, supplier, consumer);
        this.nW = i;
        this.nX = i2;
    }
}
