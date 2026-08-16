package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.jZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jZ.class */
public class C0543jZ {

    /* JADX INFO: renamed from: w */
    private final long f3237w;

    /* JADX INFO: renamed from: lI */
    private final int f3238lI;

    /* JADX INFO: renamed from: w */
    @NotNull
    private final Vec3 f3239w;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final AABB f3240d;

    /* JADX INFO: renamed from: x */
    @NotNull
    private final Vec3 f3241x;

    /* JADX INFO: renamed from: hI */
    private final float f3242hI;

    /* JADX INFO: renamed from: hJ */
    private final float f3243hJ;

    /* JADX INFO: renamed from: hK */
    private final float f3244hK;

    /* JADX INFO: renamed from: hL */
    private final float f3245hL;

    /* JADX INFO: renamed from: dI */
    private final boolean f3246dI;

    /* JADX INFO: renamed from: dJ */
    private final boolean f3247dJ;

    /* JADX INFO: renamed from: dK */
    private final boolean f3248dK;

    /* JADX INFO: renamed from: dL */
    private final boolean f3249dL;

    /* JADX INFO: renamed from: e */
    @Nullable
    private AABB f3250e;

    /* JADX INFO: renamed from: f */
    @Nullable
    private AABB f3251f;

    /* JADX INFO: renamed from: y */
    @NotNull
    public static final Vec3 f3252y = new Vec3(0.0d, 0.05000000074505806d, 0.0d);

    /* JADX INFO: renamed from: z */
    @NotNull
    public static final Vec3 f3253z = new Vec3(0.0d, -0.5d, 0.0d);

    /* JADX INFO: renamed from: A */
    @NotNull
    public static final Vec3 f3254A = new Vec3(-0.45d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: B */
    @NotNull
    public static final Vec3 f3255B = new Vec3(0.31d, 0.31d, 0.31d);

    /* JADX INFO: renamed from: C */
    @NotNull
    public static final Vec3 f3256C = new Vec3(0.31d, 0.31d, 0.31d);

    public C0543jZ(long j, int i, @NotNull Vec3 vec3, @NotNull AABB aabb, @NotNull Vec3 vec4, float f, float f2, float f3, float f4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f3237w = j;
        this.f3238lI = i;
        this.f3239w = vec3;
        this.f3240d = aabb;
        this.f3241x = vec4;
        this.f3242hI = f;
        this.f3243hJ = f2;
        this.f3244hK = f3;
        this.f3245hL = f4;
        this.f3246dI = z;
        this.f3247dJ = z2;
        this.f3248dK = z3;
        this.f3249dL = z4;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public AABB m2441e() {
        if (this.f3250e == null && this.f3248dK) {
            Vec3 vec3Add = m2443g().add(f3252y);
            this.f3250e = new AABB(vec3Add.subtract(f3255B), vec3Add.add(f3255B));
        }
        return this.f3250e;
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public AABB m2442f() {
        if (this.f3251f == null && this.f3249dL) {
            Vec3 vec3Add = m2443g().add(f3253z).add(f3254A.yRot(((-this.f3244hK) * 0.017453292f) - 1.5707964f));
            this.f3251f = new AABB(vec3Add.subtract(f3256C), vec3Add.add(f3256C));
        }
        return this.f3251f;
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public Vec3 m2443g() {
        return this.f3239w.add(0.0d, this.f3245hL, 0.0d);
    }

    /* JADX INFO: renamed from: f */
    public long m2444f() {
        return this.f3237w;
    }

    /* JADX INFO: renamed from: aB */
    public int m2445aB() {
        return this.f3238lI;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m2446h() {
        return this.f3239w;
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public AABB m2447g() {
        return this.f3240d;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public Vec3 m2448i() {
        return this.f3241x;
    }

    /* JADX INFO: renamed from: ac */
    public float m2449ac() {
        return this.f3242hI;
    }

    /* JADX INFO: renamed from: ad */
    public float m2450ad() {
        return this.f3243hJ;
    }

    /* JADX INFO: renamed from: aj */
    public boolean m2451aj() {
        return this.f3246dI;
    }

    /* JADX INFO: renamed from: ak */
    public boolean m2452ak() {
        return this.f3247dJ;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0543jZ m2453a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, long j, @NotNull Entity entity, @Nullable LivingEntity livingEntity) {
        boolean zM4487a = true;
        boolean z = true;
        float yRot = entity.getYRot();
        if (entity instanceof LivingEntity) {
            C0756na c0756na = (LivingEntity) entity;
            yRot = ((LivingEntity) c0756na).yBodyRot;
            if (livingEntity != null) {
                zM4487a = C0875pn.m4487a(abstractC0531jN, (AbstractC0184c<?>) abstractC0531jN.m2351a(), livingEntity, (LivingEntity) c0756na);
                if (livingEntity instanceof Player) {
                    Player player = (Player) livingEntity;
                    if (c0756na instanceof C0756na) {
                        C0756na c0756na2 = c0756na;
                        if (!c0756na2.isAlive() || c0756na2.isDeadOrDying() || c0756na2.m3554d(player)) {
                            zM4487a = false;
                        }
                    }
                }
            }
            if ((c0756na instanceof C0756na) && c0756na.m3573aa()) {
                z = false;
            }
            if (c0756na instanceof Player) {
                Player player2 = (Player) c0756na;
                if (C0875pn.m4488a(player2, (AbstractC0183b<?, ?, ?, ?>) abstractC0531jN.m2351a().m1153a(player2)) || C0875pn.m4489a(abstractC0531jN, livingEntity, player2.getUUID())) {
                    zM4487a = false;
                }
                ItemStack mainHandItem = player2.getMainHandItem();
                if ((mainHandItem.getItem() instanceof C1117uP) && C1117uP.m6277a(mainHandItem, player2.level()) > 5) {
                    z = false;
                }
            }
        }
        return new C0543jZ(j, entity.getId(), entity.position(), entity.getBoundingBox(), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), yRot, entity.getEyeHeight(), zM4487a, z, m2455b(entity), m2456c(entity));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0543jZ m2454a(@NotNull C0543jZ c0543jZ, float f) {
        if (this.f3238lI != c0543jZ.f3238lI) {
            throw new IllegalArgumentException("Cannot interpolate between different entities");
        }
        return new C0543jZ(f > 0.5f ? c0543jZ.f3237w : this.f3237w, this.f3238lI, this.f3239w.lerp(c0543jZ.f3239w, f), new AABB(this.f3240d.minX + ((c0543jZ.f3240d.minX - this.f3240d.minX) * ((double) f)), this.f3240d.minY + ((c0543jZ.f3240d.minY - this.f3240d.minY) * ((double) f)), this.f3240d.minZ + ((c0543jZ.f3240d.minZ - this.f3240d.minZ) * ((double) f)), this.f3240d.maxX + ((c0543jZ.f3240d.maxX - this.f3240d.maxX) * ((double) f)), this.f3240d.maxY + ((c0543jZ.f3240d.maxY - this.f3240d.maxY) * ((double) f)), this.f3240d.maxZ + ((c0543jZ.f3240d.maxZ - this.f3240d.maxZ) * ((double) f))), this.f3241x.lerp(c0543jZ.f3241x, f), this.f3242hI + ((c0543jZ.f3242hI - this.f3242hI) * f), this.f3243hJ + ((c0543jZ.f3243hJ - this.f3243hJ) * f), this.f3244hK + ((c0543jZ.f3244hK - this.f3244hK) * f), this.f3245hL + ((c0543jZ.f3245hL - this.f3245hL) * f), this.f3246dI && c0543jZ.f3246dI, this.f3247dJ && c0543jZ.f3247dJ, this.f3248dK && c0543jZ.f3248dK, this.f3249dL && c0543jZ.f3249dL);
    }

    /* JADX INFO: renamed from: b */
    private static boolean m2455b(@NotNull Entity entity) {
        return (entity instanceof Player) || (entity instanceof C0756na) || (entity instanceof C0768nm);
    }

    /* JADX INFO: renamed from: c */
    private static boolean m2456c(@NotNull Entity entity) {
        return (entity instanceof Player) || (entity instanceof C0756na);
    }
}
