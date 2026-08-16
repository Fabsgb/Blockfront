package com.boehmod.blockfront;

import net.minecraft.world.entity.ai.goal.Goal;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ng */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ng.class */
public class C0762ng extends Goal {

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final C0756na f4259b;

    public C0762ng(@NotNull C0756na c0756na) {
        this.f4259b = c0756na;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final C0756na m3607a() {
        return this.f4259b;
    }

    public boolean canUse() {
        return false;
    }
}
