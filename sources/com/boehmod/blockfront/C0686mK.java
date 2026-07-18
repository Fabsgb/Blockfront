package com.boehmod.blockfront;

import net.minecraft.world.entity.ai.goal.Goal;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mK.class */
public class C0686mK extends Goal {

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final C0680mE f3696b;

    public C0686mK(@NotNull C0680mE c0680mE) {
        this.f3696b = c0680mE;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final C0680mE m3100a() {
        return this.f3696b;
    }

    public boolean canUse() {
        return false;
    }
}
