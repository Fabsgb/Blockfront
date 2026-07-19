package com.boehmod.blockfront;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pW.class */
public class pW extends pQ<String> {
    public static final int nY = 256;
    public final int nZ;

    public pW(@NotNull Component component, @NotNull Supplier<String> supplier, @NotNull Consumer<String> consumer) {
        this(component, supplier, consumer, 256);
    }

    public pW(@NotNull Component component, @NotNull Supplier<String> supplier, @NotNull Consumer<String> consumer, int i) {
        super(component, supplier, consumer);
        this.nZ = i;
    }
}
