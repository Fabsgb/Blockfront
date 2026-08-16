package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
import it.unimi.dsi.fastutil.Pair;
import java.util.EnumSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.nh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nh.class */
public class C0763nh extends C0762ng {

    /* JADX INFO: renamed from: jB */
    private static final float f4260jB = 30.0f;

    /* JADX INFO: renamed from: jC */
    private static final float f4261jC = 0.5f;

    /* JADX INFO: renamed from: aA */
    private final double f4262aA;

    /* JADX INFO: renamed from: aB */
    private final double f4263aB;

    /* JADX INFO: renamed from: jD */
    private final float f4264jD;

    /* JADX INFO: renamed from: fa */
    private boolean f4265fa;

    /* JADX INFO: renamed from: fb */
    private boolean f4266fb;

    /* JADX INFO: renamed from: nd */
    private int f4267nd;

    /* JADX INFO: renamed from: ne */
    private int f4268ne;

    /* JADX INFO: renamed from: nf */
    private int f4269nf;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C1182vb<C1185ve<?>> f4270b;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C1189vi f4271a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C1189vi f4272b;

    /* JADX INFO: renamed from: fc */
    static final /* synthetic */ boolean f4273fc;

    static {
        f4273fc = !C0763nh.class.desiredAssertionStatus();
    }

    public C0763nh(@NotNull C0756na c0756na, float f, float f2, float f3) {
        super(c0756na);
        this.f4267nd = -1;
        this.f4268ne = 5;
        this.f4269nf = 0;
        this.f4270b = new C1182vb<>();
        this.f4264jD = f;
        this.f4262aA = f2;
        this.f4263aB = f3;
        setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override // com.boehmod.blockfront.C0762ng
    public boolean canUse() {
        if (this.f4259b.m3575aS()) {
            return false;
        }
        ItemStack mainHandItem = this.f4259b.getMainHandItem();
        return (mainHandItem.getItem() instanceof C1117uP) && C1117uP.m6265c(mainHandItem) > 0 && this.f4259b.m3524aP();
    }

    public boolean canContinueToUse() {
        return canUse();
    }

    public void start() {
        super.start();
        Pair<Vec3, Double> pairM3525a = this.f4259b.m3525a();
        this.f4259b.m3538e(pairM3525a != null ? (Vec3) pairM3525a.first() : null);
    }

    public void tick() {
        float f;
        super.tick();
        RandomSource randomSource = this.f4259b.level().random;
        Pair<Vec3, Double> pairM3525a = this.f4259b.m3525a();
        if (pairM3525a != null) {
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4273fc && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0184c<?> abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
            Vec3 vec3 = (Vec3) pairM3525a.first();
            double dDoubleValue = ((Double) pairM3525a.second()).doubleValue();
            LivingEntity target = this.f4259b.getTarget();
            if (target != null) {
                this.f4259b.m3582b(target.getOnPos());
            }
            this.f4259b.getLookControl().setLookAt(vec3.x, dDoubleValue, vec3.z, f4260jB, f4260jB);
            this.f4259b.m3526a(vec3, dDoubleValue, f4260jB, f4260jB);
            if (this.f4267nd <= 0 && randomSource.nextFloat() < 0.1f) {
                if (randomSource.nextFloat() < 0.3f) {
                    this.f4265fa = !this.f4265fa;
                }
                if (randomSource.nextFloat() < 0.3f) {
                    this.f4266fb = !this.f4266fb;
                }
                this.f4267nd = 5;
            }
            if (this.f4269nf > 0) {
                this.f4269nf--;
                return;
            }
            if (this.f4268ne > 0) {
                this.f4268ne--;
                return;
            }
            this.f4267nd--;
            float fDistanceToSqr = (float) this.f4259b.position().distanceToSqr(vec3);
            if (this.f4267nd <= 0) {
                boolean z = false;
                if (fDistanceToSqr > this.f4262aA) {
                    z = true;
                    this.f4266fb = false;
                } else if (fDistanceToSqr < this.f4263aB) {
                    z = true;
                    this.f4266fb = true;
                }
                MoveControl moveControl = this.f4259b.getMoveControl();
                if (z) {
                    f = this.f4266fb ? -this.f4264jD : this.f4264jD;
                } else {
                    f = 0.0f;
                }
                moveControl.strafe(f, this.f4265fa ? this.f4264jD : -this.f4264jD);
                if (randomSource.nextFloat() < 0.2f) {
                    this.f4267nd = 10;
                }
            }
            ItemStack mainHandItem = this.f4259b.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (item instanceof C1117uP) {
                C1117uP c1117uP = (C1117uP) item;
                if (C1117uP.m6265c(mainHandItem) > 0) {
                    m3608a(abstractC0531jNM179a, abstractC0184cM2351a, mainHandItem, c1117uP);
                    return;
                }
                return;
            }
            return;
        }
        this.f4269nf = 15;
        this.f4268ne = 5;
    }

    /* JADX INFO: renamed from: a */
    private void m3608a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ItemStack itemStack, @NotNull C1117uP c1117uP) {
        ServerLevel serverLevelLevel = this.f4259b.level();
        if (serverLevelLevel instanceof ServerLevel) {
            ServerLevel serverLevel = serverLevelLevel;
            C1198vr c1198vrM6384a = c1117uP.m6384a(itemStack);
            RandomSource randomSource = serverLevel.random;
            C1199vs c1199vsM6315a = c1117uP.m6315a(itemStack);
            this.f4268ne = c1199vsM6315a.m6875cw() / 2;
            if (c1198vrM6384a.m6848O() != null) {
                this.f4268ne = ((double) randomSource.nextFloat()) < 0.2d ? 50 : 30;
            }
            if (c1117uP.m6361a(itemStack, (Level) serverLevel, (LivingEntity) this.f4259b)) {
                this.f4259b.m3565q(2);
                int iM6878cx = c1199vsM6315a.m6878cx();
                for (int i = 0; i < iM6878cx; i++) {
                    int gameTime = (int) serverLevel.getGameTime();
                    long jNextLong = serverLevel.random.nextLong();
                    C1189vi c1189viM6369a = c1117uP.m6369a();
                    if (c1189viM6369a != this.f4271a) {
                        this.f4271a = c1189viM6369a;
                        this.f4272b = c1189viM6369a.m6769a(0.5f);
                    }
                    if (!f4273fc && this.f4272b == null) {
                        throw new AssertionError();
                    }
                    ((C1185ve) this.f4270b.m6739a(this.f4272b, c1189vi -> {
                        return new C1185ve(abstractC0184c, c1189vi);
                    })).mo6713a((AbstractC0531jN) abstractC0531jN, serverLevel, randomSource, (Random) ThreadLocalRandom.current(), (LivingEntity) this.f4259b, c1117uP, c1199vsM6315a, gameTime, jNextLong, i);
                }
                if (randomSource.nextFloat() < 0.05d) {
                    this.f4269nf = ThreadLocalRandom.current().nextInt(20);
                }
                this.f4259b.m3569s(this.f4268ne + this.f4269nf + 20);
            }
        }
    }
}
