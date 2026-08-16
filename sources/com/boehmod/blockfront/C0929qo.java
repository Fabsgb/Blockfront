package com.boehmod.blockfront;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qo.class */
public class C0929qo extends AbstractC0927qm<Float> {

    /* JADX INFO: renamed from: lB */
    public final float f5129lB;

    /* JADX INFO: renamed from: lC */
    public final float f5130lC;

    public C0929qo(@NotNull Component component, @NotNull Supplier<Float> supplier, @NotNull Consumer<Float> consumer) {
        this(component, supplier, consumer, -3.4028235E38f, Float.MAX_VALUE);
    }

    public C0929qo(@NotNull Component component, @NotNull Supplier<Float> supplier, @NotNull Consumer<Float> consumer, float f, float f2) {
        super(component, supplier, consumer);
        this.f5129lB = f;
        this.f5130lC = f2;
    }
}
