package com.boehmod.blockfront;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qs.class */
public class C0933qs extends AbstractC0927qm<String> {

    /* JADX INFO: renamed from: pX */
    public static final int f5137pX = 256;

    /* JADX INFO: renamed from: pY */
    public final int f5138pY;

    public C0933qs(@NotNull Component component, @NotNull Supplier<String> supplier, @NotNull Consumer<String> consumer) {
        this(component, supplier, consumer, 256);
    }

    public C0933qs(@NotNull Component component, @NotNull Supplier<String> supplier, @NotNull Consumer<String> consumer, int i) {
        super(component, supplier, consumer);
        this.f5138pY = i;
    }
}
