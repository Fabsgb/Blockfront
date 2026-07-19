package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.function.Predicate;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mP.class */
public class mP<E extends LivingEntity> extends NearestAttackableTargetGoal<E> {
    public static final int ls = 2;
    private static final int lt = 1;

    @NotNull
    private final mE c;

    public mP(@NotNull mE mEVar, @NotNull Class<E> cls, boolean z) {
        super(mEVar, cls, 10, z, false, (Predicate) null);
        this.c = mEVar;
    }

    @NotNull
    protected AABB getTargetSearchArea(double d) {
        return this.mob.getBoundingBox().inflate(d, 16.0d, d);
    }

    protected void findTarget() {
        for (LivingEntity livingEntity : this.mob.level().getEntitiesOfClass(this.targetType, getTargetSearchArea(getFollowDistance()), livingEntity2 -> {
            return this.mob.canAttack(livingEntity2) && this.mob.hasLineOfSight(livingEntity2);
        })) {
            if (!this.c.I.containsKey(livingEntity)) {
                this.c.I.put(livingEntity, new a(livingEntity));
            }
        }
    }

    public boolean canUse() {
        if (super.canUse()) {
            this.target = null;
            Iterator<a> it = this.c.I.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next.aA() >= 2) {
                    this.target = next.a();
                    break;
                }
            }
            return this.target != null;
        }
        return false;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mP$a.class */
    public static class a {

        @NotNull
        private final LivingEntity b;
        private int lu = 0;
        private int lv = 1;

        public a(@NotNull LivingEntity livingEntity) {
            this.b = livingEntity;
        }

        @NotNull
        public LivingEntity a() {
            return this.b;
        }

        public int aA() {
            return this.lu;
        }

        public void bL() {
            this.lu++;
        }

        public void bM() {
            this.lv--;
        }

        public void bN() {
            this.lv = 1;
        }

        public boolean aK() {
            return this.lv <= 0;
        }
    }
}
