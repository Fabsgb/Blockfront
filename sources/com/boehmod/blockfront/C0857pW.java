package com.boehmod.blockfront;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pW.class */
public class C0857pW extends AbstractC0851pQ<String> {

    /* JADX INFO: renamed from: nY */
    public static final int f4498nY = 256;

    /* JADX INFO: renamed from: nZ */
    public final int f4499nZ;

    public C0857pW(@NotNull Component component, @NotNull Supplier<String> supplier, @NotNull Consumer<String> consumer) {
        this(component, supplier, consumer, 256);
    }

    public C0857pW(@NotNull Component component, @NotNull Supplier<String> supplier, @NotNull Consumer<String> consumer, int i) {
        super(component, supplier, consumer);
        this.f4499nZ = i;
    }
}
