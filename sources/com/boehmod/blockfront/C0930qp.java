package com.boehmod.blockfront;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qp.class */
public class C0930qp extends AbstractC0927qm<Integer> {

    /* JADX INFO: renamed from: pV */
    public final int f5131pV;

    /* JADX INFO: renamed from: pW */
    public final int f5132pW;

    public C0930qp(@NotNull Component component, @NotNull Supplier<Integer> supplier, @NotNull Consumer<Integer> consumer) {
        this(component, supplier, consumer, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public C0930qp(@NotNull Component component, @NotNull Supplier<Integer> supplier, @NotNull Consumer<Integer> consumer, int i, int i2) {
        super(component, supplier, consumer);
        this.f5131pV = i;
        this.f5132pW = i2;
    }
}
