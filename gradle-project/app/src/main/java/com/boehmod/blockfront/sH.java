package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sH.class */
public class sH {
    public static final List<Supplier<sG>> bC = new ObjectArrayList();

    static {
        bC.add(sI::new);
        bC.add(sF::new);
        bC.add(sD::new);
        bC.add(sJ::new);
        bC.add(sE::new);
    }

    @NotNull
    public static sG a() {
        return bC.get(ThreadLocalRandom.current().nextInt(bC.size())).get();
    }
}
