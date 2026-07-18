package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sH.class */
public class C1001sH {

    /* JADX INFO: renamed from: bC */
    public static final List<Supplier<AbstractC1000sG>> f5277bC = new ObjectArrayList();

    static {
        f5277bC.add(C1002sI::new);
        f5277bC.add(C0999sF::new);
        f5277bC.add(C0997sD::new);
        f5277bC.add(C1003sJ::new);
        f5277bC.add(C0998sE::new);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static AbstractC1000sG m5467a() {
        return f5277bC.get(ThreadLocalRandom.current().nextInt(f5277bC.size())).get();
    }
}
