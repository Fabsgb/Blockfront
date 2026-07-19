package com.boehmod.blockfront;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jG.class */
public class jG {
    private final long o;
    private final int ka;

    @NotNull
    private final Vec3 w;

    @NotNull
    private final AABB d;

    @NotNull
    private final Vec3 x;
    private final float hl;
    private final float hm;
    private final float hn;
    private final float ho;
    private final boolean dx;
    private final boolean dy;
    private final boolean dz;
    private final boolean dA;

    @Nullable
    private AABB e;

    @Nullable
    private AABB f;

    @NotNull
    public static final Vec3 y = new Vec3(0.0d, 0.05000000074505806d, 0.0d);

    @NotNull
    public static final Vec3 z = new Vec3(0.0d, -0.5d, 0.0d);

    @NotNull
    public static final Vec3 A = new Vec3(-0.45d, 0.0d, 0.0d);

    @NotNull
    public static final Vec3 B = new Vec3(0.31d, 0.31d, 0.31d);

    @NotNull
    public static final Vec3 C = new Vec3(0.31d, 0.31d, 0.31d);

    public jG(long j, int i, @NotNull Vec3 vec3, @NotNull AABB aabb, @NotNull Vec3 vec32, float f, float f2, float f3, float f4, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.o = j;
        this.ka = i;
        this.w = vec3;
        this.d = aabb;
        this.x = vec32;
        this.hl = f;
        this.hm = f2;
        this.hn = f3;
        this.ho = f4;
        this.dx = z2;
        this.dy = z3;
        this.dz = z4;
        this.dA = z5;
    }

    @Nullable
    public AABB e() {
        if (this.e == null && this.dz) {
            Vec3 vec3Add = g().add(y);
            this.e = new AABB(vec3Add.subtract(B), vec3Add.add(B));
        }
        return this.e;
    }

    @Nullable
    public AABB f() {
        if (this.f == null && this.dA) {
            Vec3 vec3Add = g().add(z).add(A.yRot(((-this.hn) * 0.017453292f) - 1.5707964f));
            this.f = new AABB(vec3Add.subtract(C), vec3Add.add(C));
        }
        return this.f;
    }

    @NotNull
    private Vec3 g() {
        return this.w.add(0.0d, this.ho, 0.0d);
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public long m512e() {
        return this.o;
    }

    public int al() {
        return this.ka;
    }

    @NotNull
    public Vec3 h() {
        return this.w;
    }

    @NotNull
    /* JADX INFO: renamed from: g, reason: collision with other method in class */
    public AABB m513g() {
        return this.d;
    }

    @NotNull
    public Vec3 i() {
        return this.x;
    }

    public float ab() {
        return this.hl;
    }

    public float ac() {
        return this.hm;
    }

    public boolean af() {
        return this.dx;
    }

    public boolean ag() {
        return this.dy;
    }

    @NotNull
    public static jG a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, long j, @NotNull Entity entity, @Nullable LivingEntity livingEntity) {
        boolean zA = true;
        boolean z2 = true;
        float yRot = entity.getYRot();
        if (entity instanceof LivingEntity) {
            mE mEVar = (LivingEntity) entity;
            yRot = ((LivingEntity) mEVar).yBodyRot;
            if (livingEntity != null) {
                zA = oR.a(abstractC0264ju, (com.boehmod.blockfront.common.player.c<?>) abstractC0264ju.m531a(), livingEntity, (LivingEntity) mEVar);
                if (livingEntity instanceof Player) {
                    Player player = (Player) livingEntity;
                    if (mEVar instanceof mE) {
                        mE mEVar2 = mEVar;
                        if (!mEVar2.isAlive() || mEVar2.isDeadOrDying() || mEVar2.d(player)) {
                            zA = false;
                        }
                    }
                }
            }
            if ((mEVar instanceof mE) && mEVar.aH()) {
                z2 = false;
            }
            if (mEVar instanceof Player) {
                Player player2 = (Player) mEVar;
                if (oR.a(player2, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) abstractC0264ju.m531a().m305a(player2)) || oR.a(abstractC0264ju, livingEntity, player2.getUUID())) {
                    zA = false;
                }
                ItemStack mainHandItem = player2.getMainHandItem();
                if ((mainHandItem.getItem() instanceof C0558ur) && C0558ur.m1202f(mainHandItem)) {
                    z2 = false;
                }
            }
        }
        return new jG(j, entity.getId(), entity.position(), entity.getBoundingBox(), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), yRot, entity.getEyeHeight(), zA, z2, b(entity), c(entity));
    }

    @NotNull
    public jG a(@NotNull jG jGVar, float f) {
        if (this.ka != jGVar.ka) {
            throw new IllegalArgumentException("Cannot interpolate between different entities");
        }
        return new jG(f > 0.5f ? jGVar.o : this.o, this.ka, this.w.lerp(jGVar.w, f), new AABB(this.d.minX + ((jGVar.d.minX - this.d.minX) * ((double) f)), this.d.minY + ((jGVar.d.minY - this.d.minY) * ((double) f)), this.d.minZ + ((jGVar.d.minZ - this.d.minZ) * ((double) f)), this.d.maxX + ((jGVar.d.maxX - this.d.maxX) * ((double) f)), this.d.maxY + ((jGVar.d.maxY - this.d.maxY) * ((double) f)), this.d.maxZ + ((jGVar.d.maxZ - this.d.maxZ) * ((double) f))), this.x.lerp(jGVar.x, f), this.hl + ((jGVar.hl - this.hl) * f), this.hm + ((jGVar.hm - this.hm) * f), this.hn + ((jGVar.hn - this.hn) * f), this.ho + ((jGVar.ho - this.ho) * f), this.dx && jGVar.dx, this.dy && jGVar.dy, this.dz && jGVar.dz, this.dA && jGVar.dA);
    }

    private static boolean b(@NotNull Entity entity) {
        return (entity instanceof Player) || (entity instanceof mE) || (entity instanceof mQ);
    }

    private static boolean c(@NotNull Entity entity) {
        return (entity instanceof Player) || (entity instanceof mE);
    }
}
