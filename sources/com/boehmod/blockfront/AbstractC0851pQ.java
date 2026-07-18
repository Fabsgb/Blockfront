package com.boehmod.blockfront;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pQ.class */
public abstract class AbstractC0851pQ<T> {

    /* JADX INFO: renamed from: nU */
    public static final int f4482nU = 28;

    /* JADX INFO: renamed from: t */
    public static final int[] f4483t = {-10766081, -10748022, -9893, -30117, -2139137, -42102, -10747928, -42149};

    /* JADX INFO: renamed from: iU */
    @NotNull
    public final Component f4484iU;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Supplier<T> f4485d;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Consumer<T> f4486d;

    /* JADX INFO: renamed from: nV */
    public int f4487nV = -1;

    protected AbstractC0851pQ(@NotNull Component component, @NotNull Supplier<T> supplier, @NotNull Consumer<T> consumer) {
        this.f4484iU = component;
        this.f4485d = supplier;
        this.f4486d = consumer;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0851pQ<T> m4282a(int i) {
        this.f4487nV = i;
        return this;
    }

    /* JADX INFO: renamed from: bn */
    public int m4283bn() {
        return 28;
    }
}
