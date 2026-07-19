package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.nf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nf.class */
public class C0357nf extends mA implements InterfaceC0347mw {
    private static final int lB = 20;
    private static final int lC = 60;
    private static final float iT = 0.1f;
    private static final float iU = 1.5f;
    private static final float iV = 1.0f;
    public static final int lD = 2;

    @NotNull
    private final IntSet a;
    private int lE;
    private int lF;
    private boolean eP;

    @Nullable
    private SoundEvent b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private C0235is<?> f256a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    private C0235is<?> f257b;
    static final /* synthetic */ boolean eQ;

    static {
        eQ = !C0357nf.class.desiredAssertionStatus();
    }

    public C0357nf(@NotNull EntityType<? extends C0357nf> entityType, @NotNull Level level) {
        super(entityType, level);
        this.a = new IntOpenHashSet();
        this.lE = 20;
        this.lF = 0;
        this.eP = false;
        this.f256a = null;
        this.f257b = null;
    }

    @Nullable
    public SoundEvent e() {
        return (SoundEvent) C0624xc.sC.get();
    }

    @NotNull
    public SoundEvent f() {
        return (SoundEvent) C0624xc.sy.get();
    }

    protected boolean aM() {
        return true;
    }

    public int aF() {
        return 60;
    }

    protected boolean aN() {
        return true;
    }

    public void a(@NotNull SoundEvent soundEvent) {
        this.b = soundEvent;
    }

    @Override // com.boehmod.blockfront.InterfaceC0347mw
    public void a(@NotNull Player player, float f, @NotNull ItemStack itemStack, float f2, float f3) {
        this.f236a = player;
        a(itemStack);
        float f4 = f;
        if (((int) (player.getDeltaMovement().x * 100.0d)) + 7 < 0) {
            f4 += 0.3f;
        }
        a(player.getEyePosition(), player.getYRot(), player.getXRot(), f, f4);
    }

    @Override // com.boehmod.blockfront.InterfaceC0347mw
    public void a(@NotNull Vec3 vec3, float f, @NotNull ItemStack itemStack, float f2, float f3) {
        a(itemStack);
        a(vec3, f2, f3, f, f);
    }

    public void a(@NotNull Player player, @NotNull Vec3 vec3, @NotNull ItemStack itemStack, float f, float f2, float f3) {
        this.f236a = player;
        a(itemStack);
        a(vec3, f2, f3, f, f);
    }

    private void b(@NotNull Level level, @NotNull Vec3 vec3) {
        if (this.b == null) {
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
        if (d <= (-((getY() - this.yOld) * 20.0d)) * 1.5d && !this.eP) {
            this.eP = true;
            level.playLocalSound(vec3.x, vec3.y, vec3.z, this.b, SoundSource.BLOCKS, 20.0f, 1.0f, false);
        }
    }

    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    protected void a(@NotNull ThreadLocalRandom threadLocalRandom, @NotNull Level level, @NotNull Vec3 vec3) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            C0297l c0297lB = C0297l.b();
            if (!eQ && c0297lB == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            Minecraft minecraft = Minecraft.getInstance();
            LocalPlayer localPlayer = minecraft.player;
            if (localPlayer != null && !localPlayer.equals(this.f236a)) {
                SoundManager soundManager = minecraft.getSoundManager();
                a(minecraft, c0297lB, clientLevel, vec3);
                if (this.f256a == null || this.f256a.isStopped()) {
                    this.f256a = new C0235is<>(this, f(), SoundSource.NEUTRAL, 1.0f, 1.5f);
                    soundManager.play(this.f256a);
                }
                if (this.tickCount > 5) {
                    a(threadLocalRandom, localPlayer, soundManager);
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    protected void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3) {
        Vec3 vec32 = new Vec3(this.xOld, this.yOld, this.zOld);
        Vec3 vec3Subtract = vec3.subtract(vec32);
        double length = vec3Subtract.length();
        if (length > 0.1d) {
            int iMax = Math.max(3, (int) (length * 3.0d));
            for (int i = 0; i < iMax; i++) {
                double d = ((double) i) / ((double) iMax);
                iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) wZ.nW.get(), vec32.x + (vec3Subtract.x * d), vec32.y + (vec3Subtract.y * d), vec32.z + (vec3Subtract.z * d), 0.0d, 0.0d, 0.0d);
            }
            return;
        }
        iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) wZ.nW.get(), vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull ThreadLocalRandom threadLocalRandom, @NotNull LocalPlayer localPlayer, @NotNull SoundManager soundManager) {
        SoundEvent soundEventE = e();
        if (soundEventE != null && distanceTo(localPlayer) <= 15.0f && this.f257b == null) {
            this.f257b = new C0235is<>(this, soundEventE, SoundSource.NEUTRAL, 0.9f + (0.2f * threadLocalRandom.nextFloat(0.2f)), 5.0f);
            soundManager.play(this.f257b);
            hE.a(hH.s);
        }
    }

    private void a(@NotNull ThreadLocalRandom threadLocalRandom) {
        float fNextInt = (-0.05f) + (0.01f * threadLocalRandom.nextInt(10));
        setDeltaMovement(getDeltaMovement().add((-0.1f) + (0.01f * threadLocalRandom.nextInt(20)), fNextInt, fNextInt));
    }

    protected boolean j(@NotNull Entity entity) {
        return !this.a.contains(entity.getId()) && (entity instanceof AbstractC0376ny) && ((AbstractC0376ny) entity).m741b().ft;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    private void b(@NotNull Level level) throws MatchException {
        Vec3 vec3;
        Vec3 vec3Position = position();
        playSound((SoundEvent) C0624xc.sz.get(), 5.0f, (float) (0.8999999761581421d + (0.10000000149011612d * Math.random())));
        playSound((SoundEvent) C0624xc.sA.get(), 5.0f, (float) (0.8999999761581421d + (0.10000000149011612d * Math.random())));
        level.addParticle((ParticleOptions) wZ.nA.get(), true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
        level.addParticle((ParticleOptions) wZ.nB.get(), true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
        Vec3 deltaMovement = getDeltaMovement();
        switch (AnonymousClass1.l[getMotionDirection().getOpposite().ordinal()]) {
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

    /* JADX INFO: renamed from: com.boehmod.blockfront.nf$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nf$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] l = new int[Direction.values().length];

        static {
            try {
                l[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                l[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                l[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                l[Direction.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                l[Direction.EAST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                l[Direction.WEST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public boolean canCollideWith(@NotNull Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (eQ || abstractC0264juM166a != null) {
                return !oR.a(player, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) abstractC0264juM166a.m531a().m305a(player));
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
        bu();
    }

    @Override // com.boehmod.blockfront.mA
    public void tick() {
        super.tick();
        Level level = level();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Vec3 vec3Position = position();
        b(level, vec3Position);
        int i = this.lE;
        this.lE = i - 1;
        if (i <= 0 && aM()) {
            a(threadLocalRandomCurrent);
        }
        int i2 = this.lF;
        this.lF = i2 + 1;
        if (i2 >= aF()) {
            if (aN()) {
                bu();
            } else {
                discard();
            }
        }
        if (level.isClientSide()) {
            a(threadLocalRandomCurrent, level, vec3Position);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.mA
    protected void onHit(@NotNull HitResult hitResult) throws MatchException {
        Level level = level();
        if (!level.isClientSide || iG.a(this)) {
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eQ && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
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
                    if (oR.a(player, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) cVarM531a.m305a(player))) {
                        return;
                    }
                }
                if (this.a.contains(entity.getId())) {
                    return;
                }
                if (j(entity) && Math.random() < 0.10000000149011612d) {
                    this.a.add(entity.getId());
                    b(level);
                    return;
                } else if (entity instanceof AbstractC0376ny) {
                    AbstractC0376ny abstractC0376ny = (AbstractC0376ny) entity;
                    if (!level.isClientSide) {
                        C0582vo.b(new vG(hH.q, position().toVector3f(), 32.0f));
                    }
                    abstractC0376ny.a(getItem(), this.f236a, ar());
                }
            }
            setDeltaMovement(0.0d, 0.0d, 0.0d);
            if (!this.ew) {
                bu();
            }
        }
    }

    @Override // com.boehmod.blockfront.mA
    protected boolean aA() {
        return true;
    }

    @Override // com.boehmod.blockfront.mA
    public float ar() {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.mA
    public float as() {
        return 5.0f;
    }
}
