package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.nB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nB.class */
public class C0731nB extends AbstractC0699mW implements InterfaceC0695mS {

    /* JADX INFO: renamed from: nz */
    private static final int f4027nz = 20;

    /* JADX INFO: renamed from: nA */
    private static final int f4028nA = 60;

    /* JADX INFO: renamed from: jM */
    private static final float f4029jM = 0.1f;

    /* JADX INFO: renamed from: jN */
    private static final float f4030jN = 1.5f;

    /* JADX INFO: renamed from: jO */
    private static final float f4031jO = 1.0f;

    /* JADX INFO: renamed from: nB */
    public static final int f4032nB = 2;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final IntSet f4033c;

    /* JADX INFO: renamed from: nC */
    private int f4034nC;

    /* JADX INFO: renamed from: nD */
    private int f4035nD;

    /* JADX INFO: renamed from: fj */
    private boolean f4036fj;

    /* JADX INFO: renamed from: b */
    @Nullable
    private SoundEvent f4037b;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0474iJ<?> f4038a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0474iJ<?> f4039b;

    /* JADX INFO: renamed from: fk */
    static final /* synthetic */ boolean f4040fk;

    static {
        f4040fk = !C0731nB.class.desiredAssertionStatus();
    }

    public C0731nB(@NotNull EntityType<? extends C0731nB> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f4033c = new IntOpenHashSet();
        this.f4034nC = 20;
        this.f4035nD = 0;
        this.f4036fj = false;
        this.f4038a = null;
        this.f4039b = null;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public SoundEvent mo3349e() {
        return (SoundEvent) C1312xz.f8138sD.get();
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public SoundEvent mo3350f() {
        return (SoundEvent) C1312xz.f8134sz.get();
    }

    /* JADX INFO: renamed from: aW */
    protected boolean mo3351aW() {
        return true;
    }

    /* JADX INFO: renamed from: aU */
    public int mo3352aU() {
        return 60;
    }

    /* JADX INFO: renamed from: aX */
    protected boolean mo3353aX() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m3354a(@NotNull SoundEvent soundEvent) {
        this.f4037b = soundEvent;
    }

    @Override // com.boehmod.blockfront.InterfaceC0695mS
    /* JADX INFO: renamed from: a */
    public void mo3118a(@NotNull Player player, float f, @NotNull ItemStack itemStack, float f2, float f3) {
        this.f3861a = player;
        mo3122a(itemStack);
        float f4 = f;
        if (((int) (player.getDeltaMovement().x * 100.0d)) + 7 < 0) {
            f4 += 0.3f;
        }
        m3129a(player.getEyePosition(), player.getYRot(), player.getXRot(), f, f4);
    }

    @Override // com.boehmod.blockfront.InterfaceC0695mS
    /* JADX INFO: renamed from: a */
    public void mo3119a(@NotNull Vec3 vec3, float f, @NotNull ItemStack itemStack, float f2, float f3) {
        mo3122a(itemStack);
        m3129a(vec3, f2, f3, f, f);
    }

    /* JADX INFO: renamed from: a */
    public void m3355a(@NotNull Player player, @NotNull Vec3 vec3, @NotNull ItemStack itemStack, float f, float f2, float f3) {
        this.f3861a = player;
        mo3122a(itemStack);
        m3129a(vec3, f2, f3, f, f);
    }

    /* JADX INFO: renamed from: b */
    private void m3356b(@NotNull Level level, @NotNull Vec3 vec3) {
        if (this.f4037b == null) {
            return;
        }
        double d = 0.0d;
        for (int i = 0; i < 150; i++) {
            if (!level.canSeeSky(BlockPos.containing(vec3).offset(0, -i, 0))) {
                d = i;
                break;
            }
        }
        if (d <= (-((getY() - this.yOld) * 20.0d)) * 1.5d && !this.f4036fj) {
            this.f4036fj = true;
            level.playLocalSound(vec3.x, vec3.y, vec3.z, this.f4037b, SoundSource.BLOCKS, 20.0f, 1.0f, false);
        }
    }

    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo3357a(@NotNull ThreadLocalRandom threadLocalRandom, @NotNull Level level, @NotNull Vec3 vec3) {
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            C0623l c0623lM2852b = C0623l.m2852b();
            if (!f4040fk && c0623lM2852b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            Minecraft minecraft = Minecraft.getInstance();
            LocalPlayer localPlayer = minecraft.player;
            if (localPlayer != null && !localPlayer.equals(this.f3861a)) {
                SoundManager soundManager = minecraft.getSoundManager();
                mo3358a(minecraft, c0623lM2852b, clientLevel, vec3);
                if (this.f4038a == null || this.f4038a.isStopped()) {
                    this.f4038a = new C0474iJ<>(this, mo3350f(), SoundSource.NEUTRAL, 1.0f, 1.5f);
                    soundManager.play(this.f4038a);
                }
                if (this.tickCount > 5) {
                    m3359a(threadLocalRandom, localPlayer, soundManager);
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo3358a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3) {
        Vec3 vec4 = new Vec3(this.xOld, this.yOld, this.zOld);
        Vec3 vec3Subtract = vec3.subtract(vec4);
        double length = vec3Subtract.length();
        if (length > 0.1d) {
            int iMax = Math.max(3, (int) (length * 3.0d));
            for (int i = 0; i < iMax; i++) {
                double d = ((double) i) / ((double) iMax);
                C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7886nW.get(), vec4.x + (vec3Subtract.x * d), vec4.y + (vec3Subtract.y * d), vec4.z + (vec3Subtract.z * d), 0.0d, 0.0d, 0.0d);
            }
            return;
        }
        C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7886nW.get(), vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m3359a(@NotNull ThreadLocalRandom threadLocalRandom, @NotNull LocalPlayer localPlayer, @NotNull SoundManager soundManager) {
        SoundEvent soundEventMo3349e = mo3349e();
        if (soundEventMo3349e != null && distanceTo(localPlayer) <= 15.0f && this.f4039b == null) {
            this.f4039b = new C0474iJ<>(this, soundEventMo3349e, SoundSource.NEUTRAL, 0.9f + (0.2f * threadLocalRandom.nextFloat(0.2f)), 5.0f);
            soundManager.play(this.f4039b);
            C0432hU.m1986a(C0435hX.f2769s);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3360a(@NotNull ThreadLocalRandom threadLocalRandom) {
        float fNextInt = (-0.1f) + (0.01f * threadLocalRandom.nextInt(20));
        float fNextInt2 = (-0.05f) + (0.01f * threadLocalRandom.nextInt(10));
        setDeltaMovement(getDeltaMovement().add(fNextInt, fNextInt2, fNextInt2));
    }

    /* JADX INFO: renamed from: j */
    protected boolean m3361j(@NotNull Entity entity) {
        return !this.f4033c.contains(entity.getId()) && (entity instanceof AbstractC0750nU) && ((AbstractC0750nU) entity).m3436b().f4396fN;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    /* JADX INFO: renamed from: b */
    private void m3362b(@NotNull Level level) throws MatchException {
        Vec3 vec3;
        Vec3 vec3Position = position();
        playSound((SoundEvent) C1312xz.f8135sA.get(), 5.0f, (float) (0.8999999761581421d + (0.10000000149011612d * Math.random())));
        playSound((SoundEvent) C1312xz.f8136sB.get(), 5.0f, (float) (0.8999999761581421d + (0.10000000149011612d * Math.random())));
        level.addParticle((ParticleOptions) C1309xw.f7864nA.get(), true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
        level.addParticle((ParticleOptions) C1309xw.f7865nB.get(), true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
        Vec3 deltaMovement = getDeltaMovement();
        switch (AnonymousClass1.f4041n[getMotionDirection().getOpposite().ordinal()]) {
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

    /* JADX INFO: renamed from: com.boehmod.blockfront.nB$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nB$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: n */
        static final /* synthetic */ int[] f4041n = new int[Direction.values().length];

        static {
            try {
                f4041n[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4041n[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4041n[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4041n[Direction.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4041n[Direction.EAST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4041n[Direction.WEST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public boolean canCollideWith(@NotNull Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (f4040fk || abstractC0531jNM179a != null) {
                return !C0875pn.m4488a(player, (AbstractC0183b<?, ?, ?, ?>) abstractC0531jNM179a.m2351a().m1153a(player));
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
        mo3132bF();
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    public void tick() {
        super.tick();
        Level level = level();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Vec3 vec3Position = position();
        m3356b(level, vec3Position);
        int i = this.f4034nC;
        this.f4034nC = i - 1;
        if (i <= 0 && mo3351aW()) {
            m3360a(threadLocalRandomCurrent);
        }
        int i2 = this.f4035nD;
        this.f4035nD = i2 + 1;
        if (i2 >= mo3352aU()) {
            if (mo3353aX()) {
                mo3132bF();
            } else {
                discard();
            }
        }
        if (level.isClientSide()) {
            mo3357a(threadLocalRandomCurrent, level, vec3Position);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0699mW
    protected void onHit(@NotNull HitResult hitResult) throws MatchException {
        Level level = level();
        if (!level.isClientSide || C0490iZ.m2214a(this)) {
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4040fk && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
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
                    if (C0875pn.m4488a(player, (AbstractC0183b<?, ?, ?, ?>) abstractC0184cM2351a.m1153a(player))) {
                        return;
                    }
                }
                if (this.f4033c.contains(entity.getId())) {
                    return;
                }
                if (m3361j(entity) && Math.random() < 0.10000000149011612d) {
                    this.f4033c.add(entity.getId());
                    m3362b(level);
                    return;
                } else if (entity instanceof AbstractC0750nU) {
                    AbstractC0750nU abstractC0750nU = (AbstractC0750nU) entity;
                    if (!level.isClientSide) {
                        C1169vO.m6644b(new C1239wf(C0435hX.f2767q, position().toVector3f(), 32.0f));
                    }
                    abstractC0750nU.m3454a(getItem(), this.f3861a, mo3139ax());
                }
            }
            setDeltaMovement(0.0d, 0.0d, 0.0d);
            if (!this.f3862eQ) {
                mo3132bF();
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: aL */
    protected boolean mo3135aL() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: ax */
    public float mo3139ax() {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: ay */
    public float mo3140ay() {
        return 5.0f;
    }
}
