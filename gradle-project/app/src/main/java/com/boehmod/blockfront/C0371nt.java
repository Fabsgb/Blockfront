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

/* JADX INFO: renamed from: com.boehmod.blockfront.nt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nt.class */
public class C0371nt extends mA {
    private static final EntityDataAccessor<Integer> w = SynchedEntityData.defineId(C0371nt.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> x = SynchedEntityData.defineId(C0371nt.class, EntityDataSerializers.INT);
    protected int lN;
    private boolean eZ;
    private int js;

    public C0371nt(@NotNull EntityType<? extends C0371nt> entityType, @NotNull Level level) {
        super(entityType, level);
        this.lN = 0;
        this.eZ = true;
        this.js = 0;
    }

    @Override // com.boehmod.blockfront.mA
    public mA a(@NotNull ItemStack itemStack) {
        return super.a(itemStack.getItem() instanceof C0550uj ? C0550uj.a(itemStack) : itemStack);
    }

    private float aw() {
        return 0.25f;
    }

    protected void a(@NotNull BlockHitResult blockHitResult) {
        Level level = level();
        BlockPos blockPos = blockHitResult.getBlockPos();
        SoundType soundType = level.getBlockState(blockPos).getSoundType(level, blockPos, this);
        Vec3 deltaMovement = getDeltaMovement();
        if (blockHitResult.getDirection() == Direction.UP) {
            setXRot(0.0f);
        }
        if (deltaMovement.y > -0.15000000596046448d) {
            level.playSound((Player) null, getX(), getY(), getZ(), (SoundEvent) a(soundType).get(), SoundSource.BLOCKS, 1.0f, (float) (0.8999999761581421d + (0.10000000149011612d * Math.random())));
        }
    }

    protected DeferredHolder<SoundEvent, SoundEvent> a(@NotNull SoundType soundType) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = C0624xc.tJ;
        if (soundType.equals(SoundType.METAL)) {
            deferredHolder = C0624xc.tH;
        } else if (soundType.equals(SoundType.WOOD)) {
            deferredHolder = C0624xc.tI;
        }
        return deferredHolder;
    }

    protected void ce() {
    }

    protected void bT() {
    }

    public void bS() {
        level().addParticle(ParticleTypes.SMOKE, true, getX(), getY() + ((double) getEyeHeight()), getZ(), 0.0d, 0.0d, 0.0d);
    }

    public int aK() {
        this.entityData.set(w, Integer.valueOf(at() + 1));
        return ((Integer) this.entityData.get(w)).intValue();
    }

    @Override // com.boehmod.blockfront.mA
    public int at() {
        return ((Integer) this.entityData.get(w)).intValue();
    }

    public void o(int i) {
        this.entityData.set(w, Integer.valueOf(i));
    }

    public int aL() {
        return ((Integer) this.entityData.get(x)).intValue();
    }

    public void y(int i) {
        this.entityData.set(x, Integer.valueOf(i));
    }

    public int aI() {
        Item item = getItem().getItem();
        if (item instanceof C0550uj) {
            return ((C0550uj) item).ab();
        }
        return 80;
    }

    public int aH() {
        return 4;
    }

    @Override // com.boehmod.blockfront.mA
    protected boolean aA() {
        ItemStack item = getItem();
        if (item.isEmpty()) {
            return false;
        }
        Item item2 = item.getItem();
        if (item2 instanceof C0550uj) {
            return ((C0550uj) item2).cm();
        }
        return false;
    }

    @Override // com.boehmod.blockfront.mA
    public float ar() {
        ItemStack item = getItem();
        if (item.isEmpty()) {
            return 0.0f;
        }
        Item item2 = item.getItem();
        if (item2 instanceof C0550uj) {
            return ((C0550uj) item2).ar();
        }
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.mA
    public float as() {
        ItemStack item = getItem();
        if (item.isEmpty()) {
            return 0.0f;
        }
        Item item2 = item.getItem();
        if (item2 instanceof C0550uj) {
            return ((C0550uj) item2).as();
        }
        return 0.0f;
    }

    protected void updateRotation() {
    }

    @Override // com.boehmod.blockfront.mA
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(w, 0).define(x, 28);
    }

    @OnlyIn(Dist.CLIENT)
    public void lerpMotion(double d, double d2, double d3) {
        setDeltaMovement(d, d2, d3);
    }

    @Override // com.boehmod.blockfront.mA
    public void tick() {
        super.tick();
        if (level().isClientSide()) {
            bS();
        } else {
            boolean zOnGround = onGround();
            Vec3 deltaMovement = getDeltaMovement();
            if (zOnGround && deltaMovement.x == 0.0d && deltaMovement.y == 0.0d && deltaMovement.z == 0.0d) {
                bT();
            }
            setDeltaMovement(deltaMovement.scale(0.98d).scale(zOnGround ? 0.7d : 1.0d));
            if (this.js > 0) {
                this.js--;
            }
        }
        if (aL() != -1 && aK() >= aL()) {
            bu();
        }
    }

    @Override // com.boehmod.blockfront.mA
    protected float at() {
        return 4.5f;
    }

    @Override // com.boehmod.blockfront.mA
    protected void onHit(@NotNull HitResult hitResult) {
        if (hitResult instanceof BlockHitResult) {
            BlockHitResult blockHitResult = (BlockHitResult) hitResult;
            if (hitResult.getType().equals(HitResult.Type.BLOCK)) {
                Direction direction = blockHitResult.getDirection();
                if (this.eZ) {
                    ce();
                }
                if (this.lN >= aH()) {
                    setDeltaMovement(0.0d, 0.0d, 0.0d);
                    if (this.eZ) {
                        a(blockHitResult);
                    }
                } else {
                    float fAw = aw();
                    Vec3 deltaMovement = getDeltaMovement();
                    switch (AnonymousClass1.n[direction.ordinal()]) {
                        case 1:
                            setDeltaMovement(deltaMovement.x, ((double) (-fAw)) * deltaMovement.y, deltaMovement.z);
                            this.lN++;
                            break;
                        case 2:
                            setDeltaMovement(deltaMovement.x, ((double) (-fAw)) * deltaMovement.y, deltaMovement.z);
                            break;
                        case 3:
                            setDeltaMovement(deltaMovement.x, deltaMovement.y, ((double) (-fAw)) * deltaMovement.z);
                            break;
                        case 4:
                            setDeltaMovement(((double) (-fAw)) * deltaMovement.x, deltaMovement.y, deltaMovement.z);
                            break;
                        case 5:
                            setDeltaMovement(deltaMovement.x, deltaMovement.y, ((double) (-fAw)) * deltaMovement.z);
                            break;
                        case 6:
                            setDeltaMovement(((double) (-fAw)) * deltaMovement.x, deltaMovement.y, deltaMovement.z);
                            break;
                    }
                    a(blockHitResult);
                }
                this.eZ = false;
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.nt$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nt$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] n = new int[Direction.values().length];

        static {
            try {
                n[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                n[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                n[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                n[Direction.EAST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                n[Direction.SOUTH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                n[Direction.WEST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Override // com.boehmod.blockfront.mA
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("fuse", at());
        compoundTag.putInt("bounceCount", this.lN);
    }

    @Override // com.boehmod.blockfront.mA
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        o(compoundTag.getInt("fuse"));
        this.lN = compoundTag.getInt("bounceCount");
    }

    public boolean canCollideWith(@NotNull Entity entity) {
        return false;
    }
}
