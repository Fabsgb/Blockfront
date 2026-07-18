package com.boehmod.blockfront;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pT.class */
public class C0854pT extends AbstractC0851pQ<Integer> {

    /* JADX INFO: renamed from: nW */
    public final int f4492nW;

    /* JADX INFO: renamed from: nX */
    public final int f4493nX;

    public C0854pT(@NotNull Component component, @NotNull Supplier<Integer> supplier, @NotNull Consumer<Integer> consumer) {
        this(component, supplier, consumer, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public C0854pT(@NotNull Component component, @NotNull Supplier<Integer> supplier, @NotNull Consumer<Integer> consumer, int i, int i2) {
        super(component, supplier, consumer);
        this.f4492nW = i;
        this.f4493nX = i2;
    }
}
