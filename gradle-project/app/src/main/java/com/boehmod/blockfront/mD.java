package com.boehmod.blockfront;

import com.boehmod.blockfront.C0410pe;
import java.util.List;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mD.class */
public final class mD extends Goal {
    private final mC a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final PathNavigation f237a;
    private boolean ez = false;
    private int kP;

    public mD(@NotNull mC mCVar) {
        this.a = mCVar;
        this.f237a = mCVar.getNavigation();
    }

    public void start() {
        this.kP = 0;
    }

    public boolean canUse() {
        return !this.a.t().isEmpty();
    }

    public void tick() {
        super.tick();
        List<C0410pe.a> listT = this.a.t();
        int size = listT.size();
        if (this.a.kO < 0) {
            this.ez = false;
            this.a.kO = 0;
        }
        if (this.a.kO >= size) {
            this.ez = true;
            this.a.kO = size - 1;
        }
        C0410pe.a aVar = listT.get(this.a.kO);
        if (aVar != null) {
            if (this.a.distanceToSqr(aVar.o.x, aVar.o.y, aVar.o.z) <= 4.0d) {
                this.a.kO += this.ez ? -1 : 1;
                return;
            }
            int i = this.kP - 1;
            this.kP = i;
            if (i <= 0) {
                this.kP = 10;
                this.f237a.moveTo(aVar.o.x, aVar.o.y, aVar.o.z, 0.45d);
            }
        }
    }

    public boolean canContinueToUse() {
        return !this.f237a.isDone();
    }

    public void stop() {
        super.stop();
        this.f237a.stop();
    }
}
