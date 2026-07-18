package com.boehmod.blockfront;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pU.class */
public class C0855pU<T> extends AbstractC0851pQ<T> {

    /* JADX INFO: renamed from: iV */
    @NotNull
    public final Component f4494iV;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final Supplier<List<T>> f4495e;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final Function<T, String> f4496h;

    /* JADX INFO: renamed from: i */
    @NotNull
    public final Function<T, Component> f4497i;

    public C0855pU(@NotNull Component component, @NotNull Supplier<T> supplier, @NotNull Consumer<T> consumer, @NotNull Component component2, @NotNull Supplier<List<T>> supplier2, @NotNull Function<T, String> function, @NotNull Function<T, Component> function2) {
        super(component, supplier, consumer);
        this.f4494iV = component2;
        this.f4495e = supplier2;
        this.f4496h = function;
        this.f4497i = function2;
    }
}
