package com.boehmod.blockfront;

import java.lang.Enum;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qn.class */
public class C0928qn<E extends Enum<E>> extends AbstractC0927qm<E> {

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Class<E> f5127b;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final Function<E, Component> f5128g;

    public C0928qn(@NotNull Component component, @NotNull Class<E> cls, @NotNull Supplier<E> supplier, @NotNull Consumer<E> consumer) {
        this(component, cls, supplier, consumer, r2 -> {
            return Component.literal(r2.name());
        });
    }

    public C0928qn(@NotNull Component component, @NotNull Class<E> cls, @NotNull Supplier<E> supplier, @NotNull Consumer<E> consumer, @NotNull Function<E, Component> function) {
        super(component, supplier, consumer);
        this.f5127b = cls;
        this.f5128g = function;
    }
}
