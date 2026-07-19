package com.boehmod.blockfront;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pS.class */
public class pS extends pQ<Float> {
    public final float kG;
    public final float kH;

    public pS(@NotNull Component component, @NotNull Supplier<Float> supplier, @NotNull Consumer<Float> consumer) {
        this(component, supplier, consumer, -3.4028235E38f, Float.MAX_VALUE);
    }

    public pS(@NotNull Component component, @NotNull Supplier<Float> supplier, @NotNull Consumer<Float> consumer, float f, float f2) {
        super(component, supplier, consumer);
        this.kG = f;
        this.kH = f2;
    }
}
