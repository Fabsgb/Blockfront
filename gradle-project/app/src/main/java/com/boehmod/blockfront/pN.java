package com.boehmod.blockfront;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pN.class */
public class pN extends pQ<BlockPos> {
    public pN(@NotNull Component component, @NotNull Supplier<BlockPos> supplier, @NotNull Consumer<BlockPos> consumer) {
        super(component, supplier, consumer);
    }
}
