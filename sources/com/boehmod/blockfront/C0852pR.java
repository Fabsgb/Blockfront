package com.boehmod.blockfront;

import java.lang.Enum;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pR.class */
public class C0852pR<E extends Enum<E>> extends AbstractC0851pQ<E> {

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Class<E> f4488b;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final Function<E, Component> f4489g;

    public C0852pR(@NotNull Component component, @NotNull Class<E> cls, @NotNull Supplier<E> supplier, @NotNull Consumer<E> consumer) {
        this(component, cls, supplier, consumer, r2 -> {
            return Component.literal(r2.name());
        });
    }

    public C0852pR(@NotNull Component component, @NotNull Class<E> cls, @NotNull Supplier<E> supplier, @NotNull Consumer<E> consumer, @NotNull Function<E, Component> function) {
        super(component, supplier, consumer);
        this.f4488b = cls;
        this.f4489g = function;
    }
}
