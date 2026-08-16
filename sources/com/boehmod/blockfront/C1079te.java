package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.te */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/te.class */
public class C1079te {

    /* JADX INFO: renamed from: bJ */
    public static final List<Supplier<AbstractC1078td>> f5841bJ = new ObjectArrayList();

    static {
        f5841bJ.add(C1080tf::new);
        f5841bJ.add(C1077tc::new);
        f5841bJ.add(C1075ta::new);
        f5841bJ.add(C1081tg::new);
        f5841bJ.add(C1076tb::new);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static AbstractC1078td m5955a() {
        return f5841bJ.get(ThreadLocalRandom.current().nextInt(f5841bJ.size())).get();
    }
}
