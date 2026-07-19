package com.boehmod.blockfront;

import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.uj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uj.class */
public class C0550uj extends tK implements tA, tB, tW, InterfaceC0538ty {
    private static final float mO = 1.4f;
    private static final float mP = 0.6f;
    public static final int rR = 80;
    public static final String dj = "bf_primed";
    public static final double aR = 0.8d;
    private boolean hK;
    private float mQ;
    private float mR;

    /* JADX INFO: renamed from: com.boehmod.blockfront.uj$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uj$a.class */
    public enum a {
        FRAG,
        SMOKE,
        FIRE,
        DECOY,
        FLASH,
        MEDICAL_BAG,
        AMMO_BOX,
        LANDMINE
    }

    public C0550uj(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
        this.hK = true;
        this.mQ = 0.5f;
        this.mR = 5.0f;
        if (C0262js.ab()) {
            ItemProperties.register(this, C0265jv.d("primed"), (itemStack, clientLevel, livingEntity, i) -> {
                CustomData customData = (CustomData) itemStack.get(DataComponents.CUSTOM_DATA);
                if (customData != null && customData.contains(dj)) {
                    return 1.0f;
                }
                if (livingEntity instanceof LocalPlayer) {
                    LocalPlayer localPlayer = (LocalPlayer) livingEntity;
                    if (C0132ew.J() && localPlayer.getMainHandItem() == itemStack) {
                        return 1.0f;
                    }
                    return 0.0f;
                }
                return 0.0f;
            });
        }
    }

    @NotNull
    public static ItemStack a(@NotNull ItemStack itemStack) {
        ItemStack itemStackCopy = itemStack.copy();
        CustomData.update(DataComponents.CUSTOM_DATA, itemStackCopy, compoundTag -> {
            compoundTag.putBoolean(dj, true);
        });
        return itemStackCopy;
    }

    public boolean cm() {
        return this.hK;
    }

    @NotNull
    public C0550uj a(boolean z) {
        this.hK = z;
        return this;
    }

    public float ar() {
        return this.mQ;
    }

    @NotNull
    public C0550uj a(float f) {
        this.mQ = f;
        return this;
    }

    public float as() {
        return this.mR;
    }

    @NotNull
    public C0550uj b(float f) {
        this.mR = f;
        return this;
    }

    @Override // com.boehmod.blockfront.tB
    @OnlyIn(Dist.CLIENT)
    public boolean a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return a(minecraft, localPlayer, false);
    }

    @Override // com.boehmod.blockfront.tB
    @OnlyIn(Dist.CLIENT)
    public boolean c(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return a(minecraft, localPlayer, true);
    }

    @Override // com.boehmod.blockfront.tB
    @OnlyIn(Dist.CLIENT)
    public boolean b(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return a(localPlayer, false);
    }

    @Override // com.boehmod.blockfront.tB
    @OnlyIn(Dist.CLIENT)
    public boolean d(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return a(localPlayer, true);
    }

    @OnlyIn(Dist.CLIENT)
    private boolean a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, boolean z) {
        if (!ck()) {
            return b(minecraft, localPlayer, z);
        }
        if (C0132ew.J()) {
            return false;
        }
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null) {
            fT fTVar = (fT) ((fV) c0297lB.a()).a((Player) localPlayer);
            if (oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) fTVar) || fTVar.dm()) {
                return false;
            }
        }
        if (C0558ur.rY > 0) {
            return false;
        }
        C0132ew.a(this, z);
        C0582vo.c(new C0618wx(z));
        return true;
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        if (C0132ew.J()) {
            return true;
        }
        return super.shouldCauseReequipAnimation(itemStack, itemStack2, z);
    }

    @OnlyIn(Dist.CLIENT)
    private boolean a(@NotNull LocalPlayer localPlayer, boolean z) {
        if (!C0132ew.J() || C0132ew.K() != z) {
            return false;
        }
        localPlayer.swing(InteractionHand.MAIN_HAND);
        C0558ur.rY = 10;
        C0582vo.c(new C0620wz(m1191a(localPlayer, z)));
        C0132ew.av();
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    private boolean b(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, boolean z) {
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null) {
            fT fTVar = (fT) ((fV) c0297lB.a()).a((Player) localPlayer);
            if (oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) fTVar) || fTVar.dm()) {
                return false;
            }
        }
        if (C0558ur.rY > 0) {
            return false;
        }
        if (minecraft.hitResult != null && minecraft.hitResult.getLocation().distanceTo(localPlayer.getEyePosition()) <= 0.8d) {
            return false;
        }
        localPlayer.swing(InteractionHand.MAIN_HAND);
        C0558ur.rY = 10;
        C0582vo.c(new C0620wz(m1191a(localPlayer, z)));
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private float m1191a(@NotNull LocalPlayer localPlayer, boolean z) {
        float fRound = (z ? 0.6f : mO) + (Math.round(localPlayer.zza) * 0.13f);
        if (localPlayer.isSprinting()) {
            fRound += 0.13f;
        }
        return fRound;
    }

    public void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ItemStack itemStack, @NotNull Level level, @NotNull ServerPlayer serverPlayer, float f) {
        a(cVar, itemStack, level, serverPlayer, f, 0);
    }

    public void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ItemStack itemStack, @NotNull Level level, @NotNull ServerPlayer serverPlayer, float f, int i) {
        com.boehmod.blockfront.common.player.b bVarM305a = cVar.m305a((Player) serverPlayer);
        if (bVarM305a.dm() || oR.a((Player) serverPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) bVarM305a)) {
            return;
        }
        Vec3 vec3Position = serverPlayer.position();
        level.playSound((Player) null, vec3Position.x, vec3Position.y, vec3Position.z, y(), SoundSource.PLAYERS, 1.0f, (float) (0.8999999761581421d + (0.20000000298023224d * Math.random())));
        if (!serverPlayer.isCreative()) {
            itemStack.shrink(1);
        }
        a(level, i, mAVar -> {
            mAVar.a(serverPlayer, f, new ItemStack(this));
        });
    }

    @NotNull
    public SoundEvent y() {
        return (SoundEvent) C0624xc.tF.get();
    }

    @NotNull
    public SoundEvent z() {
        return (SoundEvent) C0624xc.tE.get();
    }

    @NotNull
    public SoundEvent A() {
        return (SoundEvent) C0624xc.tG.get();
    }

    public boolean ck() {
        return true;
    }

    public int ab() {
        return 80;
    }

    public void a(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull ServerPlayer serverPlayer, int i) {
        if (!serverPlayer.isCreative()) {
            itemStack.shrink(1);
        }
        a(level, i, mAVar -> {
            mAVar.c((Player) serverPlayer);
            mAVar.setPos(serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ());
        });
    }

    private void a(@NotNull Level level, int i, @NotNull Consumer<mA> consumer) {
        mA mAVarA = a(level);
        if (mAVarA == null) {
            return;
        }
        mAVarA.a(new ItemStack(this));
        consumer.accept(mAVarA);
        if (mAVarA instanceof C0371nt) {
            C0371nt c0371nt = (C0371nt) mAVarA;
            c0371nt.y(c0371nt.aI());
            if (i > 0) {
                c0371nt.o(Mth.clamp(i, 0, c0371nt.aL()));
            }
        }
        level.addFreshEntity(mAVarA);
    }

    public void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ItemStack itemStack, @NotNull Level level, @NotNull ServerPlayer serverPlayer, boolean z, int i) {
        float f = z ? 0.6f : mO;
        if (serverPlayer.isSprinting()) {
            f += 0.13f;
        }
        a(cVar, itemStack, level, serverPlayer, f, i);
    }

    @Nullable
    protected mA a(@NotNull Level level) {
        return ((EntityType) wX.kJ.get()).create(level);
    }

    @NotNull
    public a a() {
        return a.FRAG;
    }

    public boolean cl() {
        return true;
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        return new InteractionResultHolder<>(InteractionResult.FAIL, player.getItemInHand(interactionHand));
    }

    public boolean hurtEnemy(@NotNull ItemStack itemStack, @NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2) {
        return false;
    }

    public boolean onLeftClickEntity(@NotNull ItemStack itemStack, @NotNull Player player, @NotNull Entity entity) {
        return false;
    }

    public boolean canAttackBlock(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player) {
        return false;
    }

    public void a(@NotNull Minecraft minecraft, boolean z, @NotNull PlayerModel<?> playerModel, @NotNull fT fTVar, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2) {
        if (cl()) {
            playerModel.leftArm.xRot = (-1.6f) + playerModel.head.xRot;
            playerModel.leftArm.yRot = playerModel.head.yRot;
            playerModel.rightArm.xRot += (-1.6f) + playerModel.head.xRot;
            playerModel.rightArm.yRot = playerModel.head.yRot;
            playerModel.rightArm.zRot = -0.2f;
        }
    }
}
