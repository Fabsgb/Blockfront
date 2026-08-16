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

/* JADX INFO: renamed from: com.boehmod.blockfront.nd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nd.class */
public abstract class AbstractC0759nd<T extends Entity> extends C0762ng {

    /* JADX INFO: renamed from: nb */
    private static final int f4251nb = 20;

    /* JADX INFO: renamed from: jz */
    public static final float f4252jz = 0.6f;

    /* JADX INFO: renamed from: nc */
    private int f4253nc;

    /* JADX INFO: renamed from: jA */
    protected final float f4254jA;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final PathNavigation f4255b;

    /* JADX INFO: renamed from: c */
    @Nullable
    protected T f4256c;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected Path f4257a;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final Predicate<T> f4258b;

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract Class<T> mo3598a();

    /* JADX INFO: renamed from: g */
    protected abstract boolean mo3599g(@NotNull T t);

    /* JADX INFO: renamed from: h */
    protected abstract boolean mo3600h(T t);

    public AbstractC0759nd(@NotNull C0756na c0756na, float f) {
        super(c0756na);
        this.f4253nc = 0;
        this.f4258b = entity -> {
            return mo3599g(entity) && entity.isAlive();
        };
        this.f4254jA = f;
        this.f4255b = c0756na.getNavigation();
        setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override // com.boehmod.blockfront.C0762ng
    public boolean canUse() {
        Vec3 vec3Position;
        Vec3 posAway;
        Level level = this.f4259b.level();
        this.f4256c = null;
        double d = 0.0d;
        for (T t : level.getEntitiesOfClass(mo3598a(), AABB.unitCubeFromLowerCorner(this.f4259b.position()).inflate(this.f4254jA, this.f4254jA, this.f4254jA), this.f4258b)) {
            if (mo3600h(t)) {
                double dDistanceTo = t.distanceTo(this.f4259b);
                if (this.f4256c == null || dDistanceTo < d) {
                    this.f4256c = t;
                    d = dDistanceTo;
                }
            }
        }
        if (this.f4256c == null || (posAway = DefaultRandomPos.getPosAway(this.f4259b, 16, 7, (vec3Position = this.f4256c.position()))) == null || posAway.distanceTo(vec3Position) < this.f4256c.distanceTo(this.f4259b)) {
            return false;
        }
        this.f4257a = this.f4255b.createPath(posAway.x, posAway.y, posAway.z, 0);
        return this.f4257a != null;
    }

    public boolean canContinueToUse() {
        if (this.f4256c == null || this.f4256c.isRemoved() || this.f4259b.distanceTo(this.f4256c) > this.f4254jA) {
            return false;
        }
        int i = this.f4253nc - 1;
        this.f4253nc = i;
        if (i <= 0) {
            this.f4253nc = 20;
            Vec3 posAway = DefaultRandomPos.getPosAway(this.f4259b, 16, 7, this.f4256c.position());
            if (posAway != null) {
                this.f4257a = this.f4255b.createPath(posAway.x, posAway.y, posAway.z, 0);
                if (this.f4257a != null) {
                    this.f4255b.moveTo(this.f4257a, 0.6000000238418579d);
                }
            }
        }
        return !this.f4255b.isDone();
    }

    public void start() {
        super.start();
        this.f4259b.m3576E(true);
        this.f4255b.moveTo(this.f4257a, 0.6000000238418579d);
    }

    public void stop() {
        super.stop();
        this.f4256c = null;
        this.f4259b.m3576E(false);
    }
}
