package com.boehmod.blockfront;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pQ.class */
public abstract class pQ<T> {
    public static final int nU = 28;
    public static final int[] t = {-10766081, -10748022, -9893, -30117, -2139137, -42102, -10747928, -42149};

    @NotNull
    public final Component iU;

    @NotNull
    public final Supplier<T> d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NotNull
    public final Consumer<T> f278d;
    public int nV = -1;

    protected pQ(@NotNull Component component, @NotNull Supplier<T> supplier, @NotNull Consumer<T> consumer) {
        this.iU = component;
        this.d = supplier;
        this.f278d = consumer;
    }

    @NotNull
    public pQ<T> a(int i) {
        this.nV = i;
        return this;
    }

    public int bn() {
        return 28;
    }
}
