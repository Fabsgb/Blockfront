package com.boehmod.blockfront;

import java.util.EnumSet;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mH.class */
public abstract class AbstractC0683mH<T extends Entity> extends C0686mK {

    /* JADX INFO: renamed from: ld */
    private static final int f3688ld = 20;

    /* JADX INFO: renamed from: iG */
    public static final float f3689iG = 0.6f;

    /* JADX INFO: renamed from: le */
    private int f3690le;

    /* JADX INFO: renamed from: iH */
    protected final float f3691iH;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final PathNavigation f3692b;

    /* JADX INFO: renamed from: c */
    @Nullable
    protected T f3693c;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected Path f3694a;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final Predicate<T> f3695b;

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract Class<T> mo3091a();

    /* JADX INFO: renamed from: g */
    protected abstract boolean mo3092g(@NotNull T t);

    /* JADX INFO: renamed from: h */
    protected abstract boolean mo3093h(T t);

    public AbstractC0683mH(@NotNull C0680mE c0680mE, float f) {
        super(c0680mE);
        this.f3690le = 0;
        this.f3695b = entity -> {
            return mo3092g(entity) && entity.isAlive();
        };
        this.f3691iH = f;
        this.f3692b = c0680mE.getNavigation();
        setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override // com.boehmod.blockfront.C0686mK
    public boolean canUse() {
        Vec3 vec3Position;
        Vec3 posAway;
        Level level = this.f3696b.level();
        this.f3693c = null;
        double d = 0.0d;
        for (T t : level.getEntitiesOfClass(mo3091a(), AABB.unitCubeFromLowerCorner(this.f3696b.position()).inflate(this.f3691iH, this.f3691iH, this.f3691iH), this.f3695b)) {
            if (mo3093h(t)) {
                double dDistanceTo = t.distanceTo(this.f3696b);
                if (this.f3693c == null || dDistanceTo < d) {
                    this.f3693c = t;
                    d = dDistanceTo;
                }
            }
        }
        if (this.f3693c == null || (posAway = DefaultRandomPos.getPosAway(this.f3696b, 16, 7, (vec3Position = this.f3693c.position()))) == null || posAway.distanceTo(vec3Position) < this.f3693c.distanceTo(this.f3696b)) {
            return false;
        }
        this.f3694a = this.f3692b.createPath(posAway.x, posAway.y, posAway.z, 0);
        return this.f3694a != null;
    }

    public boolean canContinueToUse() {
        if (this.f3693c == null || this.f3693c.isRemoved() || this.f3696b.distanceTo(this.f3693c) > this.f3691iH) {
            return false;
        }
        int i = this.f3690le - 1;
        this.f3690le = i;
        if (i <= 0) {
            this.f3690le = 20;
            Vec3 posAway = DefaultRandomPos.getPosAway(this.f3696b, 16, 7, this.f3693c.position());
            if (posAway != null) {
                this.f3694a = this.f3692b.createPath(posAway.x, posAway.y, posAway.z, 0);
                if (this.f3694a != null) {
                    this.f3692b.moveTo(this.f3694a, 0.6000000238418579d);
                }
            }
        }
        return !this.f3692b.isDone();
    }

    public void start() {
        super.start();
        this.f3696b.m3069E(true);
        this.f3692b.moveTo(this.f3694a, 0.6000000238418579d);
    }

    public void stop() {
        super.stop();
        this.f3693c = null;
        this.f3696b.m3069E(false);
    }
}
