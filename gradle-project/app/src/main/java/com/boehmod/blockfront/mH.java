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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mH.class */
public abstract class mH<T extends Entity> extends mK {
    private static final int ld = 20;
    public static final float iG = 0.6f;
    private int le;
    protected final float iH;

    @NotNull
    protected final PathNavigation b;

    @Nullable
    protected T c;

    @Nullable
    protected Path a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    protected final Predicate<T> f242b;

    @NotNull
    protected abstract Class<T> a();

    protected abstract boolean g(@NotNull T t);

    protected abstract boolean h(T t);

    public mH(@NotNull mE mEVar, float f) {
        super(mEVar);
        this.le = 0;
        this.f242b = entity -> {
            return g(entity) && entity.isAlive();
        };
        this.iH = f;
        this.b = mEVar.getNavigation();
        setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override // com.boehmod.blockfront.mK
    public boolean canUse() {
        Vec3 vec3Position;
        Vec3 posAway;
        Level level = this.b.level();
        this.c = null;
        double d = 0.0d;
        for (T t : level.getEntitiesOfClass(a(), AABB.unitCubeFromLowerCorner(this.b.position()).inflate(this.iH, this.iH, this.iH), this.f242b)) {
            if (h(t)) {
                double dDistanceTo = t.distanceTo(this.b);
                if (this.c == null || dDistanceTo < d) {
                    this.c = t;
                    d = dDistanceTo;
                }
            }
        }
        if (this.c == null || (posAway = DefaultRandomPos.getPosAway(this.b, 16, 7, (vec3Position = this.c.position()))) == null || posAway.distanceTo(vec3Position) < this.c.distanceTo(this.b)) {
            return false;
        }
        this.a = this.b.createPath(posAway.x, posAway.y, posAway.z, 0);
        return this.a != null;
    }

    public boolean canContinueToUse() {
        if (this.c == null || this.c.isRemoved() || this.b.distanceTo(this.c) > this.iH) {
            return false;
        }
        int i = this.le - 1;
        this.le = i;
        if (i <= 0) {
            this.le = 20;
            Vec3 posAway = DefaultRandomPos.getPosAway(this.b, 16, 7, this.c.position());
            if (posAway != null) {
                this.a = this.b.createPath(posAway.x, posAway.y, posAway.z, 0);
                if (this.a != null) {
                    this.b.moveTo(this.a, 0.6000000238418579d);
                }
            }
        }
        return !this.b.isDone();
    }

    public void start() {
        super.start();
        this.b.E(true);
        this.b.moveTo(this.a, 0.6000000238418579d);
    }

    public void stop() {
        super.stop();
        this.c = null;
        this.b.E(false);
    }
}
