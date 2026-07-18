package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.nf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nf.class */
public class C0760nf extends AbstractC0676mA implements InterfaceC0724mw {

    /* JADX INFO: renamed from: lB */
    private static final int f4072lB = 20;

    /* JADX INFO: renamed from: lC */
    private static final int f4073lC = 60;

    /* JADX INFO: renamed from: iT */
    private static final float f4074iT = 0.1f;

    /* JADX INFO: renamed from: iU */
    private static final float f4075iU = 1.5f;

    /* JADX INFO: renamed from: iV */
    private static final float f4076iV = 1.0f;

    /* JADX INFO: renamed from: lD */
    public static final int f4077lD = 2;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final IntSet f4078a;

    /* JADX INFO: renamed from: lE */
    private int f4079lE;

    /* JADX INFO: renamed from: lF */
    private int f4080lF;

    /* JADX INFO: renamed from: eP */
    private boolean f4081eP;

    /* JADX INFO: renamed from: b */
    @Nullable
    private SoundEvent f4082b;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0508is<?> f4083a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0508is<?> f4084b;

    /* JADX INFO: renamed from: eQ */
    static final /* synthetic */ boolean f4085eQ;

    static {
        f4085eQ = !C0760nf.class.desiredAssertionStatus();
    }

    public C0760nf(@NotNull EntityType<? extends C0760nf> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f4078a = new IntOpenHashSet();
        this.f4079lE = 20;
        this.f4080lF = 0;
        this.f4081eP = false;
        this.f4083a = null;
        this.f4084b = null;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public SoundEvent mo3428e() {
        return (SoundEvent) C1280xc.f7727sC.get();
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public SoundEvent mo3429f() {
        return (SoundEvent) C1280xc.f7723sy.get();
    }

    /* JADX INFO: renamed from: aM */
    protected boolean mo3426aM() {
        return true;
    }

    /* JADX INFO: renamed from: aF */
    public int mo3425aF() {
        return 60;
    }

    /* JADX INFO: renamed from: aN */
    protected boolean mo3430aN() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m3431a(@NotNull SoundEvent soundEvent) {
        this.f4082b = soundEvent;
    }

    @Override // com.boehmod.blockfront.InterfaceC0724mw
    /* JADX INFO: renamed from: a */
    public void mo3283a(@NotNull Player player, float f, @NotNull ItemStack itemStack, float f2, float f3) {
        this.f3611a = player;
        mo2971a(itemStack);
        float f4 = f;
        if (((int) (player.getDeltaMovement().x * 100.0d)) + 7 < 0) {
            f4 += 0.3f;
        }
        m2978a(player.getEyePosition(), player.getYRot(), player.getXRot(), f, f4);
    }

    @Override // com.boehmod.blockfront.InterfaceC0724mw
    /* JADX INFO: renamed from: a */
    public void mo3284a(@NotNull Vec3 vec3, float f, @NotNull ItemStack itemStack, float f2, float f3) {
        mo2971a(itemStack);
        m2978a(vec3, f2, f3, f, f);
    }

    /* JADX INFO: renamed from: a */
    public void m3432a(@NotNull Player player, @NotNull Vec3 vec3, @NotNull ItemStack itemStack, float f, float f2, float f3) {
        this.f3611a = player;
        mo2971a(itemStack);
        m2978a(vec3, f2, f3, f, f);
    }

    /* JADX INFO: renamed from: b */
    private void m3433b(@NotNull Level level, @NotNull Vec3 vec3) {
        if (this.f4082b == null) {
            return;
        }
        double d = 0.0d;
        int i = 0;
        while (true) {
            if (i >= 150) {
                break;
            }
            if (level.canSeeSky(BlockPos.containing(vec3).offset(0, -i, 0))) {
                i++;
            } else {
                d = i;
                break;
            }
        }
        if (d <= (-((getY() - this.yOld) * 20.0d)) * 1.5d && !this.f4081eP) {
            this.f4081eP = true;
            level.playLocalSound(vec3.x, vec3.y, vec3.z, this.f4082b, SoundSource.BLOCKS, 20.0f, 1.0f, false);
        }
    }

    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo3434a(@NotNull ThreadLocalRandom threadLocalRandom, @NotNull Level level, @NotNull Vec3 vec3) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            C0622l c0622lM2667b = C0622l.m2667b();
            if (!f4085eQ && c0622lM2667b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            Minecraft minecraft = Minecraft.getInstance();
            LocalPlayer localPlayer = minecraft.player;
            if (localPlayer != null && !localPlayer.equals(this.f3611a)) {
                SoundManager soundManager = minecraft.getSoundManager();
                mo3435a(minecraft, c0622lM2667b, clientLevel, vec3);
                if (this.f4083a == null || this.f4083a.isStopped()) {
                    this.f4083a = new C0508is<>(this, mo3429f(), SoundSource.NEUTRAL, 1.0f, 1.5f);
                    soundManager.play(this.f4083a);
                }
                if (this.tickCount > 5) {
                    m3436a(threadLocalRandom, localPlayer, soundManager);
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo3435a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3) {
        Vec3 vec32 = new Vec3(this.xOld, this.yOld, this.zOld);
        Vec3 vec3Subtract = vec3.subtract(vec32);
        double length = vec3Subtract.length();
        if (length > 0.1d) {
            int iMax = Math.max(3, (int) (length * 3.0d));
            for (int i = 0; i < iMax; i++) {
                double d = ((double) i) / ((double) iMax);
                C0470iG.m2126a(minecraft, c0622l, clientLevel, (SimpleParticleType) C1232wZ.f7321nW.get(), vec32.x + (vec3Subtract.x * d), vec32.y + (vec3Subtract.y * d), vec32.z + (vec3Subtract.z * d), 0.0d, 0.0d, 0.0d);
            }
            return;
        }
        C0470iG.m2126a(minecraft, c0622l, clientLevel, (SimpleParticleType) C1232wZ.f7321nW.get(), vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m3436a(@NotNull ThreadLocalRandom threadLocalRandom, @NotNull LocalPlayer localPlayer, @NotNull SoundManager soundManager) {
        SoundEvent soundEventMo3428e = mo3428e();
        if (soundEventMo3428e != null && distanceTo(localPlayer) <= 15.0f && this.f4084b == null) {
            this.f4084b = new C0508is<>(this, soundEventMo3428e, SoundSource.NEUTRAL, 0.9f + (0.2f * threadLocalRandom.nextFloat(0.2f)), 5.0f);
            soundManager.play(this.f4084b);
            C0415hE.m1960a(C0418hH.f2676s);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3437a(@NotNull ThreadLocalRandom threadLocalRandom) {
        float fNextInt = (-0.05f) + (0.01f * threadLocalRandom.nextInt(10));
        setDeltaMovement(getDeltaMovement().add((-0.1f) + (0.01f * threadLocalRandom.nextInt(20)), fNextInt, fNextInt));
    }

    /* JADX INFO: renamed from: j */
    protected boolean m3438j(@NotNull Entity entity) {
        return !this.f4078a.contains(entity.getId()) && (entity instanceof AbstractC0779ny) && ((AbstractC0779ny) entity).m3499b().f3968ft;
    }

    /* JADX INFO: renamed from: b */
    private void m3439b(@NotNull Level level) throws MatchException {
        Vec3 vec3;
        Vec3 vec3Position = position();
        playSound((SoundEvent) C1280xc.f7724sz.get(), 5.0f, (float) (0.8999999761581421d + (0.10000000149011612d * Math.random())));
        playSound((SoundEvent) C1280xc.f7725sA.get(), 5.0f, (float) (0.8999999761581421d + (0.10000000149011612d * Math.random())));
        level.addParticle((ParticleOptions) C1232wZ.f7299nA.get(), true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
        level.addParticle((ParticleOptions) C1232wZ.f7300nB.get(), true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
        Vec3 deltaMovement = getDeltaMovement();
        switch (AnonymousClass1.f4086l[getMotionDirection().getOpposite().ordinal()]) {
            case 1:
            case 2:
                vec3 = new Vec3(deltaMovement.x, (-0.10000000149011612d) * deltaMovement.y, deltaMovement.z);
                break;
            case 3:
            case 4:
                vec3 = new Vec3(deltaMovement.x, deltaMovement.y, (-0.10000000149011612d) * deltaMovement.z);
                break;
            case 5:
            case 6:
                vec3 = new Vec3((-0.10000000149011612d) * deltaMovement.x, deltaMovement.y, deltaMovement.z);
                break;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
        setDeltaMovement(vec3.add(0.0d, Math.max(1.0d, Math.abs(deltaMovement.y) * 2.0d), 0.0d));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.nf$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nf$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: l */
        static final /* synthetic */ int[] f4086l = new int[Direction.values().length];

        static {
            try {
                f4086l[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4086l[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4086l[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4086l[Direction.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4086l[Direction.EAST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4086l[Direction.WEST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public boolean canCollideWith(@NotNull Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (f4085eQ || abstractC0563juM168a != null) {
                return !C0799oR.m4052a(player, (AbstractC0182b<?, ?, ?, ?>) abstractC0563juM168a.m2528a().m1136a(player));
            }
            throw new AssertionError("Mod manager is null!");
        }
        return true;
    }

    protected void onHitEntity(@NotNull EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (entityHitResult.getEntity().isRemoved()) {
            return;
        }
        mo2981bu();
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    public void tick() {
        super.tick();
        Level level = level();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Vec3 vec3Position = position();
        m3433b(level, vec3Position);
        int i = this.f4079lE;
        this.f4079lE = i - 1;
        if (i <= 0 && mo3426aM()) {
            m3437a(threadLocalRandomCurrent);
        }
        int i2 = this.f4080lF;
        this.f4080lF = i2 + 1;
        if (i2 >= mo3425aF()) {
            if (mo3430aN()) {
                mo2981bu();
            } else {
                discard();
            }
        }
        if (level.isClientSide()) {
            mo3434a(threadLocalRandomCurrent, level, vec3Position);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    protected void onHit(@NotNull HitResult hitResult) throws MatchException {
        Level level = level();
        if (!level.isClientSide || C0470iG.m2122a(this)) {
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f4085eQ && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
            if (hitResult instanceof EntityHitResult) {
                EntityHitResult entityHitResult = (EntityHitResult) hitResult;
                if (this.tickCount <= 2) {
                    return;
                }
                LivingEntity entity = entityHitResult.getEntity();
                if (entity.isRemoved()) {
                    return;
                }
                if ((entity instanceof LivingEntity) && entity.isDeadOrDying()) {
                    return;
                }
                if (entity instanceof Player) {
                    Player player = (Player) entity;
                    if (C0799oR.m4052a(player, (AbstractC0182b<?, ?, ?, ?>) abstractC0183cM2528a.m1136a(player))) {
                        return;
                    }
                }
                if (this.f4078a.contains(entity.getId())) {
                    return;
                }
                if (m3438j(entity) && Math.random() < 0.10000000149011612d) {
                    this.f4078a.add(entity.getId());
                    m3439b(level);
                    return;
                } else if (entity instanceof AbstractC0779ny) {
                    AbstractC0779ny abstractC0779ny = (AbstractC0779ny) entity;
                    if (!level.isClientSide) {
                        C1194vo.m6649b(new C1160vG(C0418hH.f2674q, position().toVector3f(), 32.0f));
                    }
                    abstractC0779ny.m3517a(getItem(), this.f3611a, mo2988ar());
                }
            }
            setDeltaMovement(0.0d, 0.0d, 0.0d);
            if (!this.f3612ew) {
                mo2981bu();
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: aA */
    protected boolean mo2984aA() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: ar */
    public float mo2988ar() {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: as */
    public float mo2989as() {
        return 5.0f;
    }
}
