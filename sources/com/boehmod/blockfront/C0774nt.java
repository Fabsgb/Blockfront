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

/* JADX INFO: renamed from: com.boehmod.blockfront.nt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nt.class */
public class C0774nt extends AbstractC0676mA {

    /* JADX INFO: renamed from: w */
    private static final EntityDataAccessor<Integer> f4133w = SynchedEntityData.defineId(C0774nt.class, EntityDataSerializers.INT);

    /* JADX INFO: renamed from: x */
    private static final EntityDataAccessor<Integer> f4134x = SynchedEntityData.defineId(C0774nt.class, EntityDataSerializers.INT);

    /* JADX INFO: renamed from: lN */
    protected int f4135lN;

    /* JADX INFO: renamed from: eZ */
    private boolean f4136eZ;

    /* JADX INFO: renamed from: js */
    private int f4137js;

    public C0774nt(@NotNull EntityType<? extends C0774nt> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f4135lN = 0;
        this.f4136eZ = true;
        this.f4137js = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: a */
    public AbstractC0676mA mo2971a(@NotNull ItemStack itemStack) {
        return super.mo2971a(itemStack.getItem() instanceof C1136uj ? C1136uj.m6251a(itemStack) : itemStack);
    }

    /* JADX INFO: renamed from: aw */
    private float m3479aw() {
        return 0.25f;
    }

    /* JADX INFO: renamed from: a */
    protected void m3480a(@NotNull BlockHitResult blockHitResult) {
        Level level = level();
        BlockPos blockPos = blockHitResult.getBlockPos();
        SoundType soundType = level.getBlockState(blockPos).getSoundType(level, blockPos, this);
        Vec3 deltaMovement = getDeltaMovement();
        if (blockHitResult.getDirection() == Direction.UP) {
            setXRot(0.0f);
        }
        if (deltaMovement.y > -0.15000000596046448d) {
            level.playSound((Player) null, getX(), getY(), getZ(), (SoundEvent) mo3443a(soundType).get(), SoundSource.BLOCKS, 1.0f, (float) (0.8999999761581421d + (0.10000000149011612d * Math.random())));
        }
    }

    /* JADX INFO: renamed from: a */
    protected DeferredHolder<SoundEvent, SoundEvent> mo3443a(@NotNull SoundType soundType) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = C1280xc.f7786tJ;
        if (soundType.equals(SoundType.METAL)) {
            deferredHolder = C1280xc.f7784tH;
        } else if (soundType.equals(SoundType.WOOD)) {
            deferredHolder = C1280xc.f7785tI;
        }
        return deferredHolder;
    }

    /* JADX INFO: renamed from: ce */
    protected void m3481ce() {
    }

    /* JADX INFO: renamed from: bT */
    protected void mo3449bT() {
    }

    /* JADX INFO: renamed from: bS */
    public void mo3448bS() {
        level().addParticle(ParticleTypes.SMOKE, true, getX(), getY() + ((double) getEyeHeight()), getZ(), 0.0d, 0.0d, 0.0d);
    }

    /* JADX INFO: renamed from: aK */
    public int m3482aK() {
        this.entityData.set(f4133w, Integer.valueOf(mo2991at() + 1));
        return ((Integer) this.entityData.get(f4133w)).intValue();
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: at */
    public int mo2991at() {
        return ((Integer) this.entityData.get(f4133w)).intValue();
    }

    /* JADX INFO: renamed from: o */
    public void m3483o(int i) {
        this.entityData.set(f4133w, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: aL */
    public int m3484aL() {
        return ((Integer) this.entityData.get(f4134x)).intValue();
    }

    /* JADX INFO: renamed from: y */
    public void m3485y(int i) {
        this.entityData.set(f4134x, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: aI */
    public int mo3459aI() {
        Item item = getItem().getItem();
        if (item instanceof C1136uj) {
            return ((C1136uj) item).mo6250ab();
        }
        return 80;
    }

    /* JADX INFO: renamed from: aH */
    public int mo3445aH() {
        return 4;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: aA */
    protected boolean mo2984aA() {
        ItemStack item = getItem();
        if (item.isEmpty()) {
            return false;
        }
        Item item2 = item.getItem();
        if (item2 instanceof C1136uj) {
            return ((C1136uj) item2).m6252cm();
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: ar */
    public float mo2988ar() {
        ItemStack item = getItem();
        if (item.isEmpty()) {
            return 0.0f;
        }
        Item item2 = item.getItem();
        if (item2 instanceof C1136uj) {
            return ((C1136uj) item2).m6254ar();
        }
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: as */
    public float mo2989as() {
        ItemStack item = getItem();
        if (item.isEmpty()) {
            return 0.0f;
        }
        Item item2 = item.getItem();
        if (item2 instanceof C1136uj) {
            return ((C1136uj) item2).m6256as();
        }
        return 0.0f;
    }

    protected void updateRotation() {
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(f4133w, 0).define(f4134x, 28);
    }

    @OnlyIn(Dist.CLIENT)
    public void lerpMotion(double d, double d2, double d3) {
        setDeltaMovement(d, d2, d3);
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    public void tick() {
        super.tick();
        if (level().isClientSide()) {
            mo3448bS();
        } else {
            boolean zOnGround = onGround();
            Vec3 deltaMovement = getDeltaMovement();
            if (zOnGround && deltaMovement.x == 0.0d && deltaMovement.y == 0.0d && deltaMovement.z == 0.0d) {
                mo3449bT();
            }
            setDeltaMovement(deltaMovement.scale(0.98d).scale(zOnGround ? 0.7d : 1.0d));
            if (this.f4137js > 0) {
                this.f4137js--;
            }
        }
        if (m3484aL() != -1 && m3482aK() >= m3484aL()) {
            mo2981bu();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: at */
    protected float mo2991at() {
        return 4.5f;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    protected void onHit(@NotNull HitResult hitResult) {
        if (hitResult instanceof BlockHitResult) {
            BlockHitResult blockHitResult = (BlockHitResult) hitResult;
            if (hitResult.getType().equals(HitResult.Type.BLOCK)) {
                Direction direction = blockHitResult.getDirection();
                if (this.f4136eZ) {
                    m3481ce();
                }
                if (this.f4135lN >= mo3445aH()) {
                    setDeltaMovement(0.0d, 0.0d, 0.0d);
                    if (this.f4136eZ) {
                        m3480a(blockHitResult);
                    }
                } else {
                    float fM3479aw = m3479aw();
                    Vec3 deltaMovement = getDeltaMovement();
                    switch (AnonymousClass1.f4138n[direction.ordinal()]) {
                        case 1:
                            setDeltaMovement(deltaMovement.x, ((double) (-fM3479aw)) * deltaMovement.y, deltaMovement.z);
                            this.f4135lN++;
                            break;
                        case 2:
                            setDeltaMovement(deltaMovement.x, ((double) (-fM3479aw)) * deltaMovement.y, deltaMovement.z);
                            break;
                        case 3:
                            setDeltaMovement(deltaMovement.x, deltaMovement.y, ((double) (-fM3479aw)) * deltaMovement.z);
                            break;
                        case 4:
                            setDeltaMovement(((double) (-fM3479aw)) * deltaMovement.x, deltaMovement.y, deltaMovement.z);
                            break;
                        case 5:
                            setDeltaMovement(deltaMovement.x, deltaMovement.y, ((double) (-fM3479aw)) * deltaMovement.z);
                            break;
                        case 6:
                            setDeltaMovement(((double) (-fM3479aw)) * deltaMovement.x, deltaMovement.y, deltaMovement.z);
                            break;
                    }
                    m3480a(blockHitResult);
                }
                this.f4136eZ = false;
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.nt$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nt$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: n */
        static final /* synthetic */ int[] f4138n = new int[Direction.values().length];

        static {
            try {
                f4138n[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4138n[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4138n[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4138n[Direction.EAST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4138n[Direction.SOUTH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4138n[Direction.WEST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("fuse", mo2991at());
        compoundTag.putInt("bounceCount", this.f4135lN);
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        m3483o(compoundTag.getInt("fuse"));
        this.f4135lN = compoundTag.getInt("bounceCount");
    }

    public boolean canCollideWith(@NotNull Entity entity) {
        return false;
    }
}
