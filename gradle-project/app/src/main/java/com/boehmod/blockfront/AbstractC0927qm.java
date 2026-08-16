package com.boehmod.blockfront;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qm.class */
public abstract class AbstractC0927qm<T> {

    /* JADX INFO: renamed from: pT */
    public static final int f5121pT = 28;

    /* JADX INFO: renamed from: v */
    public static final int[] f5122v = {-10766081, -10748022, -9893, -30117, -2139137, -42102, -10747928, -42149};

    /* JADX INFO: renamed from: jh */
    @NotNull
    public final Component f5123jh;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Supplier<T> f5124d;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Consumer<T> f5125d;

    /* JADX INFO: renamed from: pU */
    public int f5126pU = -1;

    protected AbstractC0927qm(@NotNull Component component, @NotNull Supplier<T> supplier, @NotNull Consumer<T> consumer) {
        this.f5123jh = component;
        this.f5124d = supplier;
        this.f5125d = consumer;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0927qm<T> m5076a(int i) {
        this.f5126pU = i;
        return this;
    }

    /* JADX INFO: renamed from: bC */
    public int m5077bC() {
        return 28;
    }
}
