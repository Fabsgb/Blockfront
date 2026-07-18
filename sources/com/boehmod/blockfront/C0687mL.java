package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
import it.unimi.dsi.fastutil.Pair;
import java.util.EnumSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.mL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mL.class */
public class C0687mL extends C0686mK {

    /* JADX INFO: renamed from: iI */
    private static final float f3697iI = 30.0f;

    /* JADX INFO: renamed from: iJ */
    private static final float f3698iJ = 0.5f;

    /* JADX INFO: renamed from: an */
    private final double f3699an;

    /* JADX INFO: renamed from: ao */
    private final double f3700ao;

    /* JADX INFO: renamed from: iK */
    private final float f3701iK;

    /* JADX INFO: renamed from: eG */
    private boolean f3702eG;

    /* JADX INFO: renamed from: eH */
    private boolean f3703eH;

    /* JADX INFO: renamed from: lf */
    private int f3704lf;

    /* JADX INFO: renamed from: lg */
    private int f3705lg;

    /* JADX INFO: renamed from: lh */
    private int f3706lh;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C1102uB<C1105uE<?>> f3707b;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C1109uI f3708a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C1109uI f3709b;

    /* JADX INFO: renamed from: eI */
    static final /* synthetic */ boolean f3710eI;

    static {
        f3710eI = !C0687mL.class.desiredAssertionStatus();
    }

    public C0687mL(@NotNull C0680mE c0680mE, float f, float f2, float f3) {
        super(c0680mE);
        this.f3704lf = -1;
        this.f3705lg = 5;
        this.f3706lh = 0;
        this.f3707b = new C1102uB<>();
        this.f3701iK = f;
        this.f3699an = f2;
        this.f3700ao = f3;
        setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override // com.boehmod.blockfront.C0686mK
    public boolean canUse() {
        if (this.f3696b.m3068aI()) {
            return false;
        }
        ItemStack mainHandItem = this.f3696b.getMainHandItem();
        return (mainHandItem.getItem() instanceof C1144ur) && C1144ur.m6301a(mainHandItem) > 0 && this.f3696b.m3016aE();
    }

    public boolean canContinueToUse() {
        return canUse();
    }

    public void start() {
        super.start();
        Pair<Vec3, Double> pairM3017a = this.f3696b.m3017a();
        this.f3696b.m3030e(pairM3017a != null ? (Vec3) pairM3017a.first() : null);
    }

    public void tick() {
        super.tick();
        RandomSource randomSource = this.f3696b.level().random;
        Pair<Vec3, Double> pairM3017a = this.f3696b.m3017a();
        if (pairM3017a != null) {
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f3710eI && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0183c<?> abstractC0183cM2528a = abstractC0563juM168a.m2528a();
            Vec3 vec3 = (Vec3) pairM3017a.first();
            double dDoubleValue = ((Double) pairM3017a.second()).doubleValue();
            LivingEntity target = this.f3696b.getTarget();
            if (target != null) {
                this.f3696b.m3075b(target.getOnPos());
            }
            this.f3696b.getLookControl().setLookAt(vec3.x, dDoubleValue, vec3.z, f3697iI, f3697iI);
            this.f3696b.m3018a(vec3, dDoubleValue, f3697iI, f3697iI);
            if (this.f3704lf <= 0 && randomSource.nextFloat() < 0.1f) {
                if (randomSource.nextFloat() < 0.3f) {
                    this.f3702eG = !this.f3702eG;
                }
                if (randomSource.nextFloat() < 0.3f) {
                    this.f3703eH = !this.f3703eH;
                }
                this.f3704lf = 5;
            }
            if (this.f3706lh > 0) {
                this.f3706lh--;
                return;
            }
            if (this.f3705lg > 0) {
                this.f3705lg--;
                return;
            }
            this.f3704lf--;
            float fDistanceToSqr = (float) this.f3696b.position().distanceToSqr(vec3);
            if (this.f3704lf <= 0) {
                boolean z = false;
                if (fDistanceToSqr > this.f3699an) {
                    z = true;
                    this.f3703eH = false;
                } else if (fDistanceToSqr < this.f3700ao) {
                    z = true;
                    this.f3703eH = true;
                }
                this.f3696b.getMoveControl().strafe(z ? this.f3703eH ? -this.f3701iK : this.f3701iK : 0.0f, this.f3702eG ? this.f3701iK : -this.f3701iK);
                if (randomSource.nextFloat() < 0.2f) {
                    this.f3704lf = 10;
                }
            }
            ItemStack mainHandItem = this.f3696b.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (item instanceof C1144ur) {
                C1144ur c1144ur = (C1144ur) item;
                if (C1144ur.m6301a(mainHandItem) > 0) {
                    m3101a(abstractC0563juM168a, abstractC0183cM2528a, mainHandItem, c1144ur);
                    return;
                }
                return;
            }
            return;
        }
        this.f3706lh = 15;
        this.f3705lg = 5;
    }

    /* JADX INFO: renamed from: a */
    private void m3101a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ItemStack itemStack, @NotNull C1144ur c1144ur) {
        ServerLevel serverLevelLevel = this.f3696b.level();
        if (serverLevelLevel instanceof ServerLevel) {
            ServerLevel serverLevel = serverLevelLevel;
            C1118uR c1118uRM6408a = c1144ur.m6408a(itemStack);
            RandomSource randomSource = serverLevel.random;
            C1119uS c1119uSM6347a = c1144ur.m6347a();
            this.f3705lg = c1119uSM6347a.m6222cg() / 2;
            if (c1118uRM6408a.m6195O() != null) {
                this.f3705lg = ((double) randomSource.nextFloat()) < 0.2d ? 50 : 30;
            }
            if (c1144ur.m6386a(itemStack, (Level) serverLevel, (LivingEntity) this.f3696b)) {
                this.f3696b.m3058p(2);
                int iM6225ch = c1119uSM6347a.m6225ch();
                for (int i = 0; i < iM6225ch; i++) {
                    int gameTime = (int) serverLevel.getGameTime();
                    long jNextLong = serverLevel.random.nextLong();
                    C1109uI c1109uIM6394a = c1144ur.m6394a();
                    if (c1109uIM6394a != this.f3708a) {
                        this.f3708a = c1109uIM6394a;
                        this.f3709b = c1109uIM6394a.m6116a(0.5f);
                    }
                    if (!f3710eI && this.f3709b == null) {
                        throw new AssertionError();
                    }
                    ((C1105uE) this.f3707b.m6087a(this.f3709b, c1109uI -> {
                        return new C1105uE(abstractC0183c, c1109uI);
                    })).mo6062a((AbstractC0563ju) abstractC0563ju, serverLevel, randomSource, (Random) ThreadLocalRandom.current(), (LivingEntity) this.f3696b, c1144ur, gameTime, jNextLong, i);
                }
                if (randomSource.nextFloat() < 0.05d) {
                    this.f3706lh = ThreadLocalRandom.current().nextInt(20);
                }
                this.f3696b.m3062r(this.f3705lg + this.f3706lh + 20);
            }
        }
    }
}
