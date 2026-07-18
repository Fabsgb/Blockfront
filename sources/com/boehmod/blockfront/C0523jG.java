package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.jG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jG.class */
public class C0523jG {

    /* JADX INFO: renamed from: o */
    private final long f3073o;

    /* JADX INFO: renamed from: ka */
    private final int f3074ka;

    /* JADX INFO: renamed from: w */
    @NotNull
    private final Vec3 f3075w;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final AABB f3076d;

    /* JADX INFO: renamed from: x */
    @NotNull
    private final Vec3 f3077x;

    /* JADX INFO: renamed from: hl */
    private final float f3078hl;

    /* JADX INFO: renamed from: hm */
    private final float f3079hm;

    /* JADX INFO: renamed from: hn */
    private final float f3080hn;

    /* JADX INFO: renamed from: ho */
    private final float f3081ho;

    /* JADX INFO: renamed from: dx */
    private final boolean f3082dx;

    /* JADX INFO: renamed from: dy */
    private final boolean f3083dy;

    /* JADX INFO: renamed from: dz */
    private final boolean f3084dz;

    /* JADX INFO: renamed from: dA */
    private final boolean f3085dA;

    /* JADX INFO: renamed from: e */
    @Nullable
    private AABB f3086e;

    /* JADX INFO: renamed from: f */
    @Nullable
    private AABB f3087f;

    /* JADX INFO: renamed from: y */
    @NotNull
    public static final Vec3 f3088y = new Vec3(0.0d, 0.05000000074505806d, 0.0d);

    /* JADX INFO: renamed from: z */
    @NotNull
    public static final Vec3 f3089z = new Vec3(0.0d, -0.5d, 0.0d);

    /* JADX INFO: renamed from: A */
    @NotNull
    public static final Vec3 f3090A = new Vec3(-0.45d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: B */
    @NotNull
    public static final Vec3 f3091B = new Vec3(0.31d, 0.31d, 0.31d);

    /* JADX INFO: renamed from: C */
    @NotNull
    public static final Vec3 f3092C = new Vec3(0.31d, 0.31d, 0.31d);

    public C0523jG(long j, int i, @NotNull Vec3 vec3, @NotNull AABB aabb, @NotNull Vec3 vec32, float f, float f2, float f3, float f4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f3073o = j;
        this.f3074ka = i;
        this.f3075w = vec3;
        this.f3076d = aabb;
        this.f3077x = vec32;
        this.f3078hl = f;
        this.f3079hm = f2;
        this.f3080hn = f3;
        this.f3081ho = f4;
        this.f3082dx = z;
        this.f3083dy = z2;
        this.f3084dz = z3;
        this.f3085dA = z4;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public AABB m2295e() {
        if (this.f3086e == null && this.f3084dz) {
            Vec3 vec3Add = m2297g().add(f3088y);
            this.f3086e = new AABB(vec3Add.subtract(f3091B), vec3Add.add(f3091B));
        }
        return this.f3086e;
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public AABB m2296f() {
        if (this.f3087f == null && this.f3085dA) {
            Vec3 vec3Add = m2297g().add(f3089z).add(f3090A.yRot(((-this.f3080hn) * 0.017453292f) - 1.5707964f));
            this.f3087f = new AABB(vec3Add.subtract(f3092C), vec3Add.add(f3092C));
        }
        return this.f3087f;
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    private Vec3 m2297g() {
        return this.f3075w.add(0.0d, this.f3081ho, 0.0d);
    }

    /* JADX INFO: renamed from: e */
    public long m2298e() {
        return this.f3073o;
    }

    /* JADX INFO: renamed from: al */
    public int m2299al() {
        return this.f3074ka;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m2300h() {
        return this.f3075w;
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public AABB m2301g() {
        return this.f3076d;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public Vec3 m2302i() {
        return this.f3077x;
    }

    /* JADX INFO: renamed from: ab */
    public float m2303ab() {
        return this.f3078hl;
    }

    /* JADX INFO: renamed from: ac */
    public float m2304ac() {
        return this.f3079hm;
    }

    /* JADX INFO: renamed from: af */
    public boolean m2305af() {
        return this.f3082dx;
    }

    /* JADX INFO: renamed from: ag */
    public boolean m2306ag() {
        return this.f3083dy;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0523jG m2307a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, long j, @NotNull Entity entity, @Nullable LivingEntity livingEntity) {
        boolean zM4051a = true;
        boolean z = true;
        float yRot = entity.getYRot();
        if (entity instanceof LivingEntity) {
            C0680mE c0680mE = (LivingEntity) entity;
            yRot = ((LivingEntity) c0680mE).yBodyRot;
            if (livingEntity != null) {
                zM4051a = C0799oR.m4051a(abstractC0563ju, (AbstractC0183c<?>) abstractC0563ju.m2528a(), livingEntity, (LivingEntity) c0680mE);
                if (livingEntity instanceof Player) {
                    Player player = (Player) livingEntity;
                    if (c0680mE instanceof C0680mE) {
                        C0680mE c0680mE2 = c0680mE;
                        if (!c0680mE2.isAlive() || c0680mE2.isDeadOrDying() || c0680mE2.m3047d(player)) {
                            zM4051a = false;
                        }
                    }
                }
            }
            if ((c0680mE instanceof C0680mE) && c0680mE.m3066aH()) {
                z = false;
            }
            if (c0680mE instanceof Player) {
                Player player2 = (Player) c0680mE;
                if (C0799oR.m4052a(player2, (AbstractC0182b<?, ?, ?, ?>) abstractC0563ju.m2528a().m1136a(player2)) || C0799oR.m4053a(abstractC0563ju, livingEntity, player2.getUUID())) {
                    zM4051a = false;
                }
                ItemStack mainHandItem = player2.getMainHandItem();
                if ((mainHandItem.getItem() instanceof C1144ur) && C1144ur.m6311f(mainHandItem)) {
                    z = false;
                }
            }
        }
        return new C0523jG(j, entity.getId(), entity.position(), entity.getBoundingBox(), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), yRot, entity.getEyeHeight(), zM4051a, z, m2309b(entity), m2310c(entity));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0523jG m2308a(@NotNull C0523jG c0523jG, float f) {
        if (this.f3074ka != c0523jG.f3074ka) {
            throw new IllegalArgumentException("Cannot interpolate between different entities");
        }
        return new C0523jG(f > 0.5f ? c0523jG.f3073o : this.f3073o, this.f3074ka, this.f3075w.lerp(c0523jG.f3075w, f), new AABB(this.f3076d.minX + ((c0523jG.f3076d.minX - this.f3076d.minX) * ((double) f)), this.f3076d.minY + ((c0523jG.f3076d.minY - this.f3076d.minY) * ((double) f)), this.f3076d.minZ + ((c0523jG.f3076d.minZ - this.f3076d.minZ) * ((double) f)), this.f3076d.maxX + ((c0523jG.f3076d.maxX - this.f3076d.maxX) * ((double) f)), this.f3076d.maxY + ((c0523jG.f3076d.maxY - this.f3076d.maxY) * ((double) f)), this.f3076d.maxZ + ((c0523jG.f3076d.maxZ - this.f3076d.maxZ) * ((double) f))), this.f3077x.lerp(c0523jG.f3077x, f), this.f3078hl + ((c0523jG.f3078hl - this.f3078hl) * f), this.f3079hm + ((c0523jG.f3079hm - this.f3079hm) * f), this.f3080hn + ((c0523jG.f3080hn - this.f3080hn) * f), this.f3081ho + ((c0523jG.f3081ho - this.f3081ho) * f), this.f3082dx && c0523jG.f3082dx, this.f3083dy && c0523jG.f3083dy, this.f3084dz && c0523jG.f3084dz, this.f3085dA && c0523jG.f3085dA);
    }

    /* JADX INFO: renamed from: b */
    private static boolean m2309b(@NotNull Entity entity) {
        return (entity instanceof Player) || (entity instanceof C0680mE) || (entity instanceof C0692mQ);
    }

    /* JADX INFO: renamed from: c */
    private static boolean m2310c(@NotNull Entity entity) {
        return (entity instanceof Player) || (entity instanceof C0680mE);
    }
}
