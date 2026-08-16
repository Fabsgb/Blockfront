package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nP.class */
public class C0745nP extends AbstractC0699mW {

    /* JADX INFO: renamed from: w */
    private static final EntityDataAccessor<Integer> f4088w = SynchedEntityData.defineId(C0745nP.class, EntityDataSerializers.INT);

    /* JADX INFO: renamed from: x */
    private static final EntityDataAccessor<Integer> f4089x = SynchedEntityData.defineId(C0745nP.class, EntityDataSerializers.INT);

    /* JADX INFO: renamed from: nL */
    protected int f4090nL;

    /* JADX INFO: renamed from: ft */
    private boolean f4091ft;

    /* JADX INFO: renamed from: kN */
    private int f4092kN;

    /* JADX INFO: renamed from: N */
    private long f4093N;

    /* JADX INFO: renamed from: eB */
    private boolean f4094eB;

    public C0745nP(@NotNull EntityType<? extends C0745nP> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f4090nL = 0;
        this.f4091ft = true;
        this.f4092kN = 0;
        this.f4093N = -1L;
        this.f4094eB = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: a */
    public AbstractC0699mW mo3122a(@NotNull ItemStack itemStack) {
        return super.mo3122a(itemStack.getItem() instanceof C1109uH ? C1109uH.m6212b(itemStack) : itemStack);
    }

    /* JADX INFO: renamed from: aC */
    private float m3402aC() {
        return 0.25f;
    }

    /* JADX INFO: renamed from: a */
    protected void m3403a(@NotNull BlockHitResult blockHitResult) {
        Level level = level();
        BlockPos blockPos = blockHitResult.getBlockPos();
        SoundType soundType = level.getBlockState(blockPos).getSoundType(level, blockPos, this);
        Vec3 deltaMovement = getDeltaMovement();
        if (blockHitResult.getDirection() == Direction.UP) {
            setXRot(0.0f);
        }
        if (deltaMovement.y > -0.15000000596046448d) {
            level.playSound((Player) null, getX(), getY(), getZ(), (SoundEvent) mo3366a(soundType).get(), SoundSource.BLOCKS, 1.0f, (float) (0.8999999761581421d + (0.10000000149011612d * Math.random())));
        }
    }

    /* JADX INFO: renamed from: a */
    protected DeferredHolder<SoundEvent, SoundEvent> mo3366a(@NotNull SoundType soundType) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = C1312xz.f8197tK;
        if (soundType.equals(SoundType.METAL)) {
            deferredHolder = C1312xz.f8195tI;
        } else if (soundType.equals(SoundType.WOOD)) {
            deferredHolder = C1312xz.f8196tJ;
        }
        return deferredHolder;
    }

    /* JADX INFO: renamed from: cp */
    protected void m3404cp() {
    }

    /* JADX INFO: renamed from: ce */
    protected void mo3372ce() {
    }

    /* JADX INFO: renamed from: cd */
    public void mo3371cd() {
        level().addParticle(ParticleTypes.SMOKE, true, getX(), getY() + ((double) getEyeHeight()), getZ(), 0.0d, 0.0d, 0.0d);
    }

    /* JADX INFO: renamed from: aD */
    public boolean m3405aD() {
        return this.f4094eB;
    }

    /* JADX INFO: renamed from: G */
    public void m3406G(boolean z) {
        this.f4094eB = z;
    }

    /* JADX INFO: renamed from: cq */
    public void m3407cq() {
        if (this.f4093N == -1) {
            this.f4093N = level().getGameTime() + 1;
        }
    }

    /* JADX INFO: renamed from: aZ */
    public int m3408aZ() {
        this.entityData.set(f4088w, Integer.valueOf(m3409aI() + 1));
        return ((Integer) this.entityData.get(f4088w)).intValue();
    }

    /* JADX INFO: renamed from: aI */
    public int m3409aI() {
        return ((Integer) this.entityData.get(f4088w)).intValue();
    }

    /* JADX INFO: renamed from: p */
    public void m3410p(int i) {
        this.entityData.set(f4088w, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: ba */
    public int m3411ba() {
        return ((Integer) this.entityData.get(f4089x)).intValue();
    }

    /* JADX INFO: renamed from: z */
    public void m3412z(int i) {
        this.entityData.set(f4089x, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: aX */
    public int mo3382aX() {
        Item item = getItem().getItem();
        if (item instanceof C1109uH) {
            return ((C1109uH) item).mo6210al();
        }
        return 80;
    }

    /* JADX INFO: renamed from: aW */
    public int mo3368aW() {
        return 4;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: aL */
    protected boolean mo3135aL() {
        ItemStack item = getItem();
        if (item.isEmpty()) {
            return false;
        }
        Item item2 = item.getItem();
        if (item2 instanceof C1109uH) {
            return ((C1109uH) item2).m6213cw();
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: ax */
    public float mo3139ax() {
        ItemStack item = getItem();
        if (item.isEmpty()) {
            return 0.0f;
        }
        Item item2 = item.getItem();
        if (item2 instanceof C1109uH) {
            return ((C1109uH) item2).m6215ax();
        }
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: ay */
    public float mo3140ay() {
        ItemStack item = getItem();
        if (item.isEmpty()) {
            return 0.0f;
        }
        Item item2 = item.getItem();
        if (item2 instanceof C1109uH) {
            return ((C1109uH) item2).m6217ay();
        }
        return 0.0f;
    }

    protected void updateRotation() {
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(f4088w, 0).define(f4089x, 28);
    }

    @OnlyIn(Dist.CLIENT)
    public void lerpMotion(double d, double d2, double d3) {
        setDeltaMovement(d, d2, d3);
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    public void tick() {
        super.tick();
        if (level().isClientSide()) {
            mo3371cd();
        } else {
            boolean zOnGround = onGround();
            Vec3 deltaMovement = getDeltaMovement();
            if (zOnGround && deltaMovement.x == 0.0d && deltaMovement.y == 0.0d && deltaMovement.z == 0.0d) {
                mo3372ce();
            }
            setDeltaMovement(deltaMovement.scale(0.98d).scale(zOnGround ? 0.7d : 1.0d));
            if (this.f4092kN > 0) {
                this.f4092kN--;
            }
        }
        if (!level().isClientSide() && this.f4093N != -1 && level().getGameTime() >= this.f4093N) {
            mo3132bF();
        } else if (m3411ba() != -1 && m3408aZ() >= m3411ba()) {
            mo3132bF();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: az */
    protected float mo3142az() {
        return 4.5f;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    protected void onHit(@NotNull HitResult hitResult) {
        if (hitResult instanceof BlockHitResult) {
            BlockHitResult blockHitResult = (BlockHitResult) hitResult;
            if (hitResult.getType().equals(HitResult.Type.BLOCK)) {
                Direction direction = blockHitResult.getDirection();
                if (this.f4091ft) {
                    m3404cp();
                }
                if (this.f4090nL >= mo3368aW()) {
                    setDeltaMovement(0.0d, 0.0d, 0.0d);
                    if (this.f4091ft) {
                        m3403a(blockHitResult);
                    }
                } else {
                    float fM3402aC = m3402aC();
                    Vec3 deltaMovement = getDeltaMovement();
                    switch (AnonymousClass1.f4095p[direction.ordinal()]) {
                        case 1:
                            setDeltaMovement(deltaMovement.x, ((double) (-fM3402aC)) * deltaMovement.y, deltaMovement.z);
                            this.f4090nL++;
                            break;
                        case 2:
                            setDeltaMovement(deltaMovement.x, ((double) (-fM3402aC)) * deltaMovement.y, deltaMovement.z);
                            break;
                        case 3:
                            setDeltaMovement(deltaMovement.x, deltaMovement.y, ((double) (-fM3402aC)) * deltaMovement.z);
                            break;
                        case 4:
                            setDeltaMovement(((double) (-fM3402aC)) * deltaMovement.x, deltaMovement.y, deltaMovement.z);
                            break;
                        case 5:
                            setDeltaMovement(deltaMovement.x, deltaMovement.y, ((double) (-fM3402aC)) * deltaMovement.z);
                            break;
                        case 6:
                            setDeltaMovement(((double) (-fM3402aC)) * deltaMovement.x, deltaMovement.y, deltaMovement.z);
                            break;
                    }
                    m3403a(blockHitResult);
                }
                this.f4091ft = false;
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.nP$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nP$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: p */
        static final /* synthetic */ int[] f4095p = new int[Direction.values().length];

        static {
            try {
                f4095p[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4095p[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4095p[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4095p[Direction.EAST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4095p[Direction.SOUTH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4095p[Direction.WEST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("fuse", m3409aI());
        compoundTag.putInt("bounceCount", this.f4090nL);
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        m3410p(compoundTag.getInt("fuse"));
        this.f4090nL = compoundTag.getInt("bounceCount");
    }

    public boolean canCollideWith(@NotNull Entity entity) {
        return false;
    }
}
