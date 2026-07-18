package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.uj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uj.class */
public class C1136uj extends C1058tK implements InterfaceC1048tA, InterfaceC1049tB, InterfaceC1070tW, InterfaceC1098ty {

    /* JADX INFO: renamed from: mO */
    private static final float f5949mO = 1.4f;

    /* JADX INFO: renamed from: mP */
    private static final float f5950mP = 0.6f;

    /* JADX INFO: renamed from: rR */
    public static final int f5951rR = 80;

    /* JADX INFO: renamed from: dj */
    public static final String f5952dj = "bf_primed";

    /* JADX INFO: renamed from: aR */
    public static final double f5953aR = 0.8d;

    /* JADX INFO: renamed from: hK */
    private boolean f5954hK;

    /* JADX INFO: renamed from: mQ */
    private float f5955mQ;

    /* JADX INFO: renamed from: mR */
    private float f5956mR;

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

    public C1136uj(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
        this.f5954hK = true;
        this.f5955mQ = 0.5f;
        this.f5956mR = 5.0f;
        if (C0561js.m2512ab()) {
            ItemProperties.register(this, C0564jv.m2555d("primed"), (itemStack, clientLevel, livingEntity, i) -> {
                CustomData customData = (CustomData) itemStack.get(DataComponents.CUSTOM_DATA);
                if (customData != null && customData.contains(f5952dj)) {
                    return 1.0f;
                }
                if (livingEntity instanceof LocalPlayer) {
                    LocalPlayer localPlayer = (LocalPlayer) livingEntity;
                    if (C0300ew.m1583J() && localPlayer.getMainHandItem() == itemStack) {
                        return 1.0f;
                    }
                    return 0.0f;
                }
                return 0.0f;
            });
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ItemStack m6251a(@NotNull ItemStack itemStack) {
        ItemStack itemStackCopy = itemStack.copy();
        CustomData.update(DataComponents.CUSTOM_DATA, itemStackCopy, compoundTag -> {
            compoundTag.putBoolean(f5952dj, true);
        });
        return itemStackCopy;
    }

    /* JADX INFO: renamed from: cm */
    public boolean m6252cm() {
        return this.f5954hK;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1136uj m6253a(boolean z) {
        this.f5954hK = z;
        return this;
    }

    /* JADX INFO: renamed from: ar */
    public float m6254ar() {
        return this.f5955mQ;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1136uj m6255a(float f) {
        this.f5955mQ = f;
        return this;
    }

    /* JADX INFO: renamed from: as */
    public float m6256as() {
        return this.f5956mR;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1136uj m6257b(float f) {
        this.f5956mR = f;
        return this;
    }

    @Override // com.boehmod.blockfront.InterfaceC1049tB
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public boolean mo5829a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return m6258a(minecraft, localPlayer, false);
    }

    @Override // com.boehmod.blockfront.InterfaceC1049tB
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: c */
    public boolean mo5831c(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return m6258a(minecraft, localPlayer, true);
    }

    @Override // com.boehmod.blockfront.InterfaceC1049tB
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    public boolean mo5830b(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return m6259a(localPlayer, false);
    }

    @Override // com.boehmod.blockfront.InterfaceC1049tB
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: d */
    public boolean mo5832d(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return m6259a(localPlayer, true);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private boolean m6258a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, boolean z) {
        if (!mo5957ck()) {
            return m6260b(minecraft, localPlayer, z);
        }
        if (C0300ew.m1583J()) {
            return false;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b != null) {
            C0324fT c0324fT = (C0324fT) ((C0326fV) c0622lM2667b.m2670a()).m1133a((Player) localPlayer);
            if (C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) c0324fT) || c0324fT.m1093dm()) {
                return false;
            }
        }
        if (C1144ur.f6002rY > 0) {
            return false;
        }
        C0300ew.m1587a(this, z);
        C1194vo.m6653c(new C1256wx(z));
        return true;
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        if (C0300ew.m1583J()) {
            return true;
        }
        return super.shouldCauseReequipAnimation(itemStack, itemStack2, z);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private boolean m6259a(@NotNull LocalPlayer localPlayer, boolean z) {
        if (!C0300ew.m1583J() || C0300ew.m1584K() != z) {
            return false;
        }
        localPlayer.swing(InteractionHand.MAIN_HAND);
        C1144ur.f6002rY = 10;
        C1194vo.m6653c(new C1258wz(m6261a(localPlayer, z)));
        C0300ew.m1588av();
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    private boolean m6260b(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, boolean z) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b != null) {
            C0324fT c0324fT = (C0324fT) ((C0326fV) c0622lM2667b.m2670a()).m1133a((Player) localPlayer);
            if (C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) c0324fT) || c0324fT.m1093dm()) {
                return false;
            }
        }
        if (C1144ur.f6002rY > 0) {
            return false;
        }
        if (minecraft.hitResult != null && minecraft.hitResult.getLocation().distanceTo(localPlayer.getEyePosition()) <= 0.8d) {
            return false;
        }
        localPlayer.swing(InteractionHand.MAIN_HAND);
        C1144ur.f6002rY = 10;
        C1194vo.m6653c(new C1258wz(m6261a(localPlayer, z)));
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private float m6261a(@NotNull LocalPlayer localPlayer, boolean z) {
        float fRound = (z ? 0.6f : f5949mO) + (Math.round(localPlayer.zza) * 0.13f);
        if (localPlayer.isSprinting()) {
            fRound += 0.13f;
        }
        return fRound;
    }

    /* JADX INFO: renamed from: a */
    public void m6262a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull ItemStack itemStack, @NotNull Level level, @NotNull ServerPlayer serverPlayer, float f) {
        m6263a(abstractC0183c, itemStack, level, serverPlayer, f, 0);
    }

    /* JADX INFO: renamed from: a */
    public void m6263a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull ItemStack itemStack, @NotNull Level level, @NotNull ServerPlayer serverPlayer, float f, int i) {
        AbstractC0182b abstractC0182bM1136a = abstractC0183c.m1136a((Player) serverPlayer);
        if (abstractC0182bM1136a.m1093dm() || C0799oR.m4052a((Player) serverPlayer, (AbstractC0182b<?, ?, ?, ?>) abstractC0182bM1136a)) {
            return;
        }
        Vec3 vec3Position = serverPlayer.position();
        level.playSound((Player) null, vec3Position.x, vec3Position.y, vec3Position.z, mo5966y(), SoundSource.PLAYERS, 1.0f, (float) (0.8999999761581421d + (0.20000000298023224d * Math.random())));
        if (!serverPlayer.isCreative()) {
            itemStack.shrink(1);
        }
        m6267a(level, i, abstractC0676mA -> {
            abstractC0676mA.mo2972a(serverPlayer, f, new ItemStack(this));
        });
    }

    @NotNull
    /* JADX INFO: renamed from: y */
    public SoundEvent mo5966y() {
        return (SoundEvent) C1280xc.f7782tF.get();
    }

    @NotNull
    /* JADX INFO: renamed from: z */
    public SoundEvent mo6264z() {
        return (SoundEvent) C1280xc.f7781tE.get();
    }

    @NotNull
    /* JADX INFO: renamed from: A */
    public SoundEvent m6265A() {
        return (SoundEvent) C1280xc.f7783tG.get();
    }

    /* JADX INFO: renamed from: ck */
    public boolean mo5957ck() {
        return true;
    }

    /* JADX INFO: renamed from: ab */
    public int mo6250ab() {
        return 80;
    }

    /* JADX INFO: renamed from: a */
    public void m6266a(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull ServerPlayer serverPlayer, int i) {
        if (!serverPlayer.isCreative()) {
            itemStack.shrink(1);
        }
        m6267a(level, i, abstractC0676mA -> {
            abstractC0676mA.m2977c((Player) serverPlayer);
            abstractC0676mA.setPos(serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ());
        });
    }

    /* JADX INFO: renamed from: a */
    private void m6267a(@NotNull Level level, int i, @NotNull Consumer<AbstractC0676mA> consumer) {
        AbstractC0676mA abstractC0676mAMo5958a = mo5958a(level);
        if (abstractC0676mAMo5958a == null) {
            return;
        }
        abstractC0676mAMo5958a.mo2971a(new ItemStack(this));
        consumer.accept(abstractC0676mAMo5958a);
        if (abstractC0676mAMo5958a instanceof C0774nt) {
            C0774nt c0774nt = (C0774nt) abstractC0676mAMo5958a;
            c0774nt.m3485y(c0774nt.mo3459aI());
            if (i > 0) {
                c0774nt.m3483o(Mth.clamp(i, 0, c0774nt.m3484aL()));
            }
        }
        level.addFreshEntity(abstractC0676mAMo5958a);
    }

    /* JADX INFO: renamed from: a */
    public void m6268a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull ItemStack itemStack, @NotNull Level level, @NotNull ServerPlayer serverPlayer, boolean z, int i) {
        float f = z ? 0.6f : f5949mO;
        if (serverPlayer.isSprinting()) {
            f += 0.13f;
        }
        m6263a(abstractC0183c, itemStack, level, serverPlayer, f, i);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    protected AbstractC0676mA mo5958a(@NotNull Level level) {
        return ((EntityType) C1230wX.f7040kJ.get()).create(level);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public a mo5959a() {
        return a.FRAG;
    }

    /* JADX INFO: renamed from: cl */
    public boolean mo5960cl() {
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

    /* JADX INFO: renamed from: a */
    public void mo5828a(@NotNull Minecraft minecraft, boolean z, @NotNull PlayerModel<?> playerModel, @NotNull C0324fT c0324fT, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2) {
        if (mo5960cl()) {
            playerModel.leftArm.xRot = (-1.6f) + playerModel.head.xRot;
            playerModel.leftArm.yRot = playerModel.head.yRot;
            playerModel.rightArm.xRot += (-1.6f) + playerModel.head.xRot;
            playerModel.rightArm.yRot = playerModel.head.yRot;
            playerModel.rightArm.zRot = -0.2f;
        }
    }
}
