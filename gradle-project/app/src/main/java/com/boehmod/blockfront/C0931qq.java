package com.boehmod.blockfront;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qq.class */
public class C0931qq<T> extends AbstractC0927qm<T> {

    /* JADX INFO: renamed from: ji */
    @NotNull
    public final Component f5133ji;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final Supplier<List<T>> f5134e;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final Function<T, String> f5135h;

    /* JADX INFO: renamed from: i */
    @NotNull
    public final Function<T, Component> f5136i;

    public C0931qq(@NotNull Component component, @NotNull Supplier<T> supplier, @NotNull Consumer<T> consumer, @NotNull Component component2, @NotNull Supplier<List<T>> supplier2, @NotNull Function<T, String> function, @NotNull Function<T, Component> function2) {
        super(component, supplier, consumer);
        this.f5133ji = component2;
        this.f5134e = supplier2;
        this.f5135h = function;
        this.f5136i = function2;
    }
}
