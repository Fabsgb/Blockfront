package com.boehmod.blockfront;

import net.minecraft.world.entity.ai.goal.Goal;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mK.class */
public class mK extends Goal {

    @NotNull
    protected final mE b;

    public mK(@NotNull mE mEVar) {
        this.b = mEVar;
    }

    @NotNull
    public final mE a() {
        return this.b;
    }

    public boolean canUse() {
        return false;
    }
}
