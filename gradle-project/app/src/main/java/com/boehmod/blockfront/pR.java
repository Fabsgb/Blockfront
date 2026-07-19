package com.boehmod.blockfront;

import java.lang.Enum;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pR.class */
public class pR<E extends Enum<E>> extends pQ<E> {

    @NotNull
    public final Class<E> b;

    @NotNull
    public final Function<E, Component> g;

    public pR(@NotNull Component component, @NotNull Class<E> cls, @NotNull Supplier<E> supplier, @NotNull Consumer<E> consumer) {
        this(component, cls, supplier, consumer, r2 -> {
            return Component.literal(r2.name());
        });
    }

    public pR(@NotNull Component component, @NotNull Class<E> cls, @NotNull Supplier<E> supplier, @NotNull Consumer<E> consumer, @NotNull Function<E, Component> function) {
        super(component, supplier, consumer);
        this.b = cls;
        this.g = function;
    }
}
