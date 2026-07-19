package com.boehmod.blockfront;

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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mL.class */
public class mL extends mK {
    private static final float iI = 30.0f;
    private static final float iJ = 0.5f;
    private final double an;
    private final double ao;
    private final float iK;
    private boolean eG;
    private boolean eH;
    private int lf;
    private int lg;
    private int lh;

    @NotNull
    private final uB<uE<?>> b;

    @Nullable
    private uI a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    private uI f243b;
    static final /* synthetic */ boolean eI;

    static {
        eI = !mL.class.desiredAssertionStatus();
    }

    public mL(@NotNull mE mEVar, float f, float f2, float f3) {
        super(mEVar);
        this.lf = -1;
        this.lg = 5;
        this.lh = 0;
        this.b = new uB<>();
        this.iK = f;
        this.an = f2;
        this.ao = f3;
        setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override // com.boehmod.blockfront.mK
    public boolean canUse() {
        if (this.b.aI()) {
            return false;
        }
        ItemStack mainHandItem = this.b.getMainHandItem();
        return (mainHandItem.getItem() instanceof C0558ur) && C0558ur.a(mainHandItem) > 0 && this.b.aE();
    }

    public boolean canContinueToUse() {
        return canUse();
    }

    public void start() {
        super.start();
        Pair<Vec3, Double> pairM670a = this.b.m670a();
        this.b.e(pairM670a != null ? (Vec3) pairM670a.first() : null);
    }

    public void tick() {
        super.tick();
        RandomSource randomSource = this.b.level().random;
        Pair<Vec3, Double> pairM670a = this.b.m670a();
        if (pairM670a != null) {
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eI && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            com.boehmod.blockfront.common.player.c<?> cVarM531a = abstractC0264juM166a.m531a();
            Vec3 vec3 = (Vec3) pairM670a.first();
            double dDoubleValue = ((Double) pairM670a.second()).doubleValue();
            LivingEntity target = this.b.getTarget();
            if (target != null) {
                this.b.b(target.getOnPos());
            }
            this.b.getLookControl().setLookAt(vec3.x, dDoubleValue, vec3.z, iI, iI);
            this.b.a(vec3, dDoubleValue, iI, iI);
            if (this.lf <= 0 && randomSource.nextFloat() < 0.1f) {
                if (randomSource.nextFloat() < 0.3f) {
                    this.eG = !this.eG;
                }
                if (randomSource.nextFloat() < 0.3f) {
                    this.eH = !this.eH;
                }
                this.lf = 5;
            }
            if (this.lh > 0) {
                this.lh--;
                return;
            }
            if (this.lg > 0) {
                this.lg--;
                return;
            }
            this.lf--;
            float fDistanceToSqr = (float) this.b.position().distanceToSqr(vec3);
            if (this.lf <= 0) {
                boolean z = false;
                if (fDistanceToSqr > this.an) {
                    z = true;
                    this.eH = false;
                } else if (fDistanceToSqr < this.ao) {
                    z = true;
                    this.eH = true;
                }
                this.b.getMoveControl().strafe(z ? this.eH ? -this.iK : this.iK : 0.0f, this.eG ? this.iK : -this.iK);
                if (randomSource.nextFloat() < 0.2f) {
                    this.lf = 10;
                }
            }
            ItemStack mainHandItem = this.b.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (item instanceof C0558ur) {
                C0558ur c0558ur = (C0558ur) item;
                if (C0558ur.a(mainHandItem) > 0) {
                    a(abstractC0264juM166a, cVarM531a, mainHandItem, c0558ur);
                    return;
                }
                return;
            }
            return;
        }
        this.lh = 15;
        this.lg = 5;
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ItemStack itemStack, @NotNull C0558ur c0558ur) {
        ServerLevel serverLevelLevel = this.b.level();
        if (serverLevelLevel instanceof ServerLevel) {
            ServerLevel serverLevel = serverLevelLevel;
            uR uRVarM1221a = c0558ur.m1221a(itemStack);
            RandomSource randomSource = serverLevel.random;
            uS uSVarM1210a = c0558ur.m1210a();
            this.lg = uSVarM1210a.cg() / 2;
            if (uRVarM1221a.O() != null) {
                this.lg = ((double) randomSource.nextFloat()) < 0.2d ? 50 : 30;
            }
            if (c0558ur.m1214a(itemStack, (Level) serverLevel, (LivingEntity) this.b)) {
                this.b.p(2);
                int iCh = uSVarM1210a.ch();
                for (int i = 0; i < iCh; i++) {
                    int gameTime = (int) serverLevel.getGameTime();
                    long jNextLong = serverLevel.random.nextLong();
                    uI uIVarM1216a = c0558ur.m1216a();
                    if (uIVarM1216a != this.a) {
                        this.a = uIVarM1216a;
                        this.f243b = uIVarM1216a.a(0.5f);
                    }
                    if (!eI && this.f243b == null) {
                        throw new AssertionError();
                    }
                    ((uE) this.b.a(this.f243b, uIVar -> {
                        return new uE(cVar, uIVar);
                    })).a((AbstractC0264ju) abstractC0264ju, serverLevel, randomSource, (Random) ThreadLocalRandom.current(), (LivingEntity) this.b, c0558ur, gameTime, jNextLong, i);
                }
                if (randomSource.nextFloat() < 0.05d) {
                    this.lh = ThreadLocalRandom.current().nextInt(20);
                }
                this.b.r(this.lg + this.lh + 20);
            }
        }
    }
}
