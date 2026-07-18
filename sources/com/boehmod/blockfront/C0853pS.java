package com.boehmod.blockfront;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pS.class */
public class C0853pS extends AbstractC0851pQ<Float> {

    /* JADX INFO: renamed from: kG */
    public final float f4490kG;

    /* JADX INFO: renamed from: kH */
    public final float f4491kH;

    public C0853pS(@NotNull Component component, @NotNull Supplier<Float> supplier, @NotNull Consumer<Float> consumer) {
        this(component, supplier, consumer, -3.4028235E38f, Float.MAX_VALUE);
    }

    public C0853pS(@NotNull Component component, @NotNull Supplier<Float> supplier, @NotNull Consumer<Float> consumer, float f, float f2) {
        super(component, supplier, consumer);
        this.f4490kG = f;
        this.f4491kH = f2;
    }
}
