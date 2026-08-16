package com.boehmod.blockfront;

import java.util.function.Predicate;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nl.class */
public class C0767nl<E extends LivingEntity> extends NearestAttackableTargetGoal<E> {

    /* JADX INFO: renamed from: nq */
    public static final int f4297nq = 2;

    /* JADX INFO: renamed from: nr */
    private static final int f4298nr = 1;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0756na f4299c;

    public C0767nl(@NotNull C0756na c0756na, @NotNull Class<E> cls, boolean z) {
        super(c0756na, cls, 10, z, false, (Predicate) null);
        this.f4299c = c0756na;
    }

    @NotNull
    protected AABB getTargetSearchArea(double d) {
        return this.mob.getBoundingBox().inflate(d, 16.0d, d);
    }

    protected void findTarget() {
        for (LivingEntity livingEntity : this.mob.level().getEntitiesOfClass(this.targetType, getTargetSearchArea(getFollowDistance()), livingEntity2 -> {
            return this.mob.canAttack(livingEntity2) && this.mob.hasLineOfSight(livingEntity2);
        })) {
            if (!this.f4299c.f4214I.containsKey(livingEntity)) {
                this.f4299c.f4214I.put(livingEntity, new a(livingEntity));
            }
        }
    }

    public boolean canUse() {
        if (super.canUse()) {
            this.target = null;
            for (a aVar : this.f4299c.f4214I.values()) {
                if (aVar.m3617aP() >= 2) {
                    this.target = aVar.m3616a();
                    break;
                }
            }
            return this.target != null;
        }
        return false;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.nl$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nl$a.class */
    public static class a {

        /* JADX INFO: renamed from: b */
        @NotNull
        private final LivingEntity f4300b;

        /* JADX INFO: renamed from: ns */
        private int f4301ns = 0;

        /* JADX INFO: renamed from: nt */
        private int f4302nt = 1;

        public a(@NotNull LivingEntity livingEntity) {
            this.f4300b = livingEntity;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public LivingEntity m3616a() {
            return this.f4300b;
        }

        /* JADX INFO: renamed from: aP */
        public int m3617aP() {
            return this.f4301ns;
        }

        /* JADX INFO: renamed from: bW */
        public void m3618bW() {
            this.f4301ns++;
        }

        /* JADX INFO: renamed from: bX */
        public void m3619bX() {
            this.f4302nt--;
        }

        /* JADX INFO: renamed from: bY */
        public void m3620bY() {
            this.f4302nt = 1;
        }

        /* JADX INFO: renamed from: aU */
        public boolean m3621aU() {
            return this.f4302nt <= 0;
        }
    }
}
