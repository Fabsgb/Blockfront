package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.function.Predicate;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mP.class */
public class C0691mP<E extends LivingEntity> extends NearestAttackableTargetGoal<E> {

    /* JADX INFO: renamed from: ls */
    public static final int f3734ls = 2;

    /* JADX INFO: renamed from: lt */
    private static final int f3735lt = 1;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0680mE f3736c;

    public C0691mP(@NotNull C0680mE c0680mE, @NotNull Class<E> cls, boolean z) {
        super(c0680mE, cls, 10, z, false, (Predicate) null);
        this.f3736c = c0680mE;
    }

    @NotNull
    protected AABB getTargetSearchArea(double d) {
        return this.mob.getBoundingBox().inflate(d, 16.0d, d);
    }

    protected void findTarget() {
        for (LivingEntity livingEntity : this.mob.level().getEntitiesOfClass(this.targetType, getTargetSearchArea(getFollowDistance()), livingEntity2 -> {
            return this.mob.canAttack(livingEntity2) && this.mob.hasLineOfSight(livingEntity2);
        })) {
            if (!this.f3736c.f3651I.containsKey(livingEntity)) {
                this.f3736c.f3651I.put(livingEntity, new a(livingEntity));
            }
        }
    }

    public boolean canUse() {
        if (super.canUse()) {
            this.target = null;
            Iterator<a> it = this.f3736c.f3651I.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next.m3110aA() >= 2) {
                    this.target = next.m3109a();
                    break;
                }
            }
            return this.target != null;
        }
        return false;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.mP$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mP$a.class */
    public static class a {

        /* JADX INFO: renamed from: b */
        @NotNull
        private final LivingEntity f3737b;

        /* JADX INFO: renamed from: lu */
        private int f3738lu = 0;

        /* JADX INFO: renamed from: lv */
        private int f3739lv = 1;

        public a(@NotNull LivingEntity livingEntity) {
            this.f3737b = livingEntity;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public LivingEntity m3109a() {
            return this.f3737b;
        }

        /* JADX INFO: renamed from: aA */
        public int m3110aA() {
            return this.f3738lu;
        }

        /* JADX INFO: renamed from: bL */
        public void m3111bL() {
            this.f3738lu++;
        }

        /* JADX INFO: renamed from: bM */
        public void m3112bM() {
            this.f3739lv--;
        }

        /* JADX INFO: renamed from: bN */
        public void m3113bN() {
            this.f3739lv = 1;
        }

        /* JADX INFO: renamed from: aK */
        public boolean m3114aK() {
            return this.f3739lv <= 0;
        }
    }
}
