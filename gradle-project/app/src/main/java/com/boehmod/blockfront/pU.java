package com.boehmod.blockfront;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pU.class */
public class pU<T> extends pQ<T> {

    @NotNull
    public final Component iV;

    @NotNull
    public final Supplier<List<T>> e;

    @NotNull
    public final Function<T, String> h;

    @NotNull
    public final Function<T, Component> i;

    public pU(@NotNull Component component, @NotNull Supplier<T> supplier, @NotNull Consumer<T> consumer, @NotNull Component component2, @NotNull Supplier<List<T>> supplier2, @NotNull Function<T, String> function, @NotNull Function<T, Component> function2) {
        super(component, supplier, consumer);
        this.iV = component2;
        this.e = supplier2;
        this.h = function;
        this.i = function2;
    }
}
