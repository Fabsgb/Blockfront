package com.boehmod.blockfront;

import com.boehmod.blockfront.C0865pe;
import java.util.List;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mD.class */
public final class C0679mD extends Goal {

    /* JADX INFO: renamed from: a */
    private final C0678mC f3623a;

    /* JADX INFO: renamed from: a */
    private final PathNavigation f3624a;

    /* JADX INFO: renamed from: ez */
    private boolean f3625ez = false;

    /* JADX INFO: renamed from: kP */
    private int f3626kP;

    public C0679mD(@NotNull C0678mC c0678mC) {
        this.f3623a = c0678mC;
        this.f3624a = c0678mC.getNavigation();
    }

    public void start() {
        this.f3626kP = 0;
    }

    public boolean canUse() {
        return !this.f3623a.m3005t().isEmpty();
    }

    public void tick() {
        super.tick();
        List<C0865pe.a> listM3005t = this.f3623a.m3005t();
        int size = listM3005t.size();
        if (this.f3623a.f3621kO < 0) {
            this.f3625ez = false;
            this.f3623a.f3621kO = 0;
        }
        if (this.f3623a.f3621kO >= size) {
            this.f3625ez = true;
            this.f3623a.f3621kO = size - 1;
        }
        C0865pe.a aVar = listM3005t.get(this.f3623a.f3621kO);
        if (aVar != null) {
            if (this.f3623a.distanceToSqr(aVar.f4538o.x, aVar.f4538o.y, aVar.f4538o.z) <= 4.0d) {
                this.f3623a.f3621kO += this.f3625ez ? -1 : 1;
                return;
            }
            int i = this.f3626kP - 1;
            this.f3626kP = i;
            if (i <= 0) {
                this.f3626kP = 10;
                this.f3624a.moveTo(aVar.f4538o.x, aVar.f4538o.y, aVar.f4538o.z, 0.45d);
            }
        }
    }

    public boolean canContinueToUse() {
        return !this.f3624a.isDone();
    }

    public void stop() {
        super.stop();
        this.f3624a.stop();
    }
}
