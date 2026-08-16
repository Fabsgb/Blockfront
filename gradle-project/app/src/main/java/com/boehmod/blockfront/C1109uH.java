package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.uH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uH.class */
public class C1109uH extends C1136ui implements InterfaceC1071tW, InterfaceC1073tY, InterfaceC1074tZ, InterfaceC1148uu {

    /* JADX INFO: renamed from: nN */
    private static final float f6015nN = 1.4f;

    /* JADX INFO: renamed from: nO */
    private static final float f6016nO = 0.6f;

    /* JADX INFO: renamed from: tU */
    public static final int f6017tU = 80;

    /* JADX INFO: renamed from: du */
    public static final String f6018du = "bf_primed";

    /* JADX INFO: renamed from: be */
    public static final double f6019be = 0.8d;

    /* JADX INFO: renamed from: ie */
    private boolean f6020ie;

    /* JADX INFO: renamed from: nP */
    private float f6021nP;

    /* JADX INFO: renamed from: nQ */
    private float f6022nQ;

    /* JADX INFO: renamed from: com.boehmod.blockfront.uH$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uH$a.class */
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

    public C1109uH(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
        this.f6020ie = true;
        this.f6021nP = 0.5f;
        this.f6022nQ = 5.0f;
        if (C0529jL.m2332ae()) {
            ItemProperties.register(this, C0532jO.m2378d("primed"), (itemStack, clientLevel, livingEntity, i) -> {
                CustomData customData = (CustomData) itemStack.get(DataComponents.CUSTOM_DATA);
                if (customData != null && customData.contains(f6018du)) {
                    return 1.0f;
                }
                if (livingEntity instanceof LocalPlayer) {
                    LocalPlayer localPlayer = (LocalPlayer) livingEntity;
                    if (C0262eJ.m1487K() && localPlayer.getMainHandItem() == itemStack) {
                        return 1.0f;
                    }
                    return 0.0f;
                }
                return 0.0f;
            });
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static ItemStack m6212b(@NotNull ItemStack itemStack) {
        ItemStack itemStackCopy = itemStack.copy();
        CustomData.update(DataComponents.CUSTOM_DATA, itemStackCopy, compoundTag -> {
            compoundTag.putBoolean(f6018du, true);
        });
        return itemStackCopy;
    }

    /* JADX INFO: renamed from: cw */
    public boolean m6213cw() {
        return this.f6020ie;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1109uH m6214a(boolean z) {
        this.f6020ie = z;
        return this;
    }

    /* JADX INFO: renamed from: ax */
    public float m6215ax() {
        return this.f6021nP;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1109uH m6216a(float f) {
        this.f6021nP = f;
        return this;
    }

    /* JADX INFO: renamed from: ay */
    public float m6217ay() {
        return this.f6022nQ;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1109uH m6218b(float f) {
        this.f6022nQ = f;
        return this;
    }

    @Override // com.boehmod.blockfront.InterfaceC1074tZ
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public boolean mo5943a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return m6219a(minecraft, localPlayer, false);
    }

    @Override // com.boehmod.blockfront.InterfaceC1074tZ
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: c */
    public boolean mo5945c(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return m6219a(minecraft, localPlayer, true);
    }

    @Override // com.boehmod.blockfront.InterfaceC1074tZ
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    public boolean mo5944b(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return m6220a(localPlayer, false);
    }

    @Override // com.boehmod.blockfront.InterfaceC1074tZ
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: d */
    public boolean mo5946d(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return m6220a(localPlayer, true);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private boolean m6219a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, boolean z) {
        if (!mo6228cu()) {
            return m6221b(minecraft, localPlayer, z);
        }
        if (C0262eJ.m1487K()) {
            return false;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b != null) {
            C0394gj c0394gj = (C0394gj) ((C0396gl) c0623lM2852b.m2855a()).m1150a((Player) localPlayer);
            if (C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) c0394gj) || c0394gj.m1110dv()) {
                return false;
            }
        }
        if (C1117uP.f6071ue > 0) {
            return false;
        }
        C0262eJ.m1491a(this, z);
        C1169vO.m6648c(new C1229wV(z));
        return true;
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        if (C0262eJ.m1487K()) {
            return true;
        }
        return super.shouldCauseReequipAnimation(itemStack, itemStack2, z);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private boolean m6220a(@NotNull LocalPlayer localPlayer, boolean z) {
        if (!C0262eJ.m1487K() || C0262eJ.m1488L() != z) {
            return false;
        }
        localPlayer.swing(InteractionHand.MAIN_HAND);
        C1117uP.f6071ue = 10;
        C1169vO.m6648c(new C1231wX(m6222a(localPlayer, z)));
        C0262eJ.m1492aA();
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    private boolean m6221b(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, boolean z) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b != null) {
            C0394gj c0394gj = (C0394gj) ((C0396gl) c0623lM2852b.m2855a()).m1150a((Player) localPlayer);
            if (C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) c0394gj) || c0394gj.m1110dv()) {
                return false;
            }
        }
        if (C1117uP.f6071ue > 0) {
            return false;
        }
        if (minecraft.hitResult != null && minecraft.hitResult.getLocation().distanceTo(localPlayer.getEyePosition()) <= 0.8d) {
            return false;
        }
        localPlayer.swing(InteractionHand.MAIN_HAND);
        C1117uP.f6071ue = 10;
        C1169vO.m6648c(new C1231wX(m6222a(localPlayer, z)));
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private float m6222a(@NotNull LocalPlayer localPlayer, boolean z) {
        float fRound = (z ? 0.6f : f6015nN) + (Math.round(localPlayer.zza) * 0.13f);
        if (localPlayer.isSprinting()) {
            fRound += 0.13f;
        }
        return fRound;
    }

    /* JADX INFO: renamed from: a */
    public void m6223a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull ItemStack itemStack, @NotNull Level level, @NotNull ServerPlayer serverPlayer, float f) {
        m6224a(abstractC0184c, itemStack, level, serverPlayer, f, 0);
    }

    /* JADX INFO: renamed from: a */
    public void m6224a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull ItemStack itemStack, @NotNull Level level, @NotNull ServerPlayer serverPlayer, float f, int i) {
        AbstractC0183b abstractC0183bM1153a = abstractC0184c.m1153a((Player) serverPlayer);
        if (abstractC0183bM1153a.m1110dv() || C0875pn.m4488a((Player) serverPlayer, (AbstractC0183b<?, ?, ?, ?>) abstractC0183bM1153a)) {
            return;
        }
        Vec3 vec3Position = serverPlayer.position();
        level.playSound((Player) null, vec3Position.x, vec3Position.y, vec3Position.z, mo6225y(), SoundSource.PLAYERS, 1.0f, (float) (0.8999999761581421d + (0.20000000298023224d * Math.random())));
        if (!serverPlayer.isCreative()) {
            itemStack.shrink(1);
        }
        m6230a(level, i, abstractC0699mW -> {
            abstractC0699mW.mo3123a(serverPlayer, f, new ItemStack(this));
        });
    }

    @NotNull
    /* JADX INFO: renamed from: y */
    public SoundEvent mo6225y() {
        return (SoundEvent) C1312xz.f8193tG.get();
    }

    @NotNull
    /* JADX INFO: renamed from: z */
    public SoundEvent mo6226z() {
        return (SoundEvent) C1312xz.f8192tF.get();
    }

    @NotNull
    /* JADX INFO: renamed from: A */
    public SoundEvent m6227A() {
        return (SoundEvent) C1312xz.f8194tH.get();
    }

    /* JADX INFO: renamed from: cu */
    public boolean mo6228cu() {
        return true;
    }

    /* JADX INFO: renamed from: al */
    public int mo6210al() {
        return 80;
    }

    /* JADX INFO: renamed from: a */
    public void m6229a(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull ServerPlayer serverPlayer, int i) {
        if (!serverPlayer.isCreative()) {
            itemStack.shrink(1);
        }
        m6230a(level, i, abstractC0699mW -> {
            abstractC0699mW.m3128c((Player) serverPlayer);
            abstractC0699mW.setPos(serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ());
        });
    }

    /* JADX INFO: renamed from: a */
    private void m6230a(@NotNull Level level, int i, @NotNull Consumer<AbstractC0699mW> consumer) {
        AbstractC0699mW abstractC0699mWMo6209a = mo6209a(level);
        if (abstractC0699mWMo6209a == null) {
            return;
        }
        abstractC0699mWMo6209a.mo3122a(new ItemStack(this));
        consumer.accept(abstractC0699mWMo6209a);
        if (abstractC0699mWMo6209a instanceof C0745nP) {
            C0745nP c0745nP = (C0745nP) abstractC0699mWMo6209a;
            c0745nP.m3412z(c0745nP.mo3382aX());
            if (i > 0) {
                c0745nP.m3410p(Mth.clamp(i, 0, c0745nP.m3411ba()));
                c0745nP.m3406G(i >= c0745nP.m3411ba());
            }
        }
        level.addFreshEntity(abstractC0699mWMo6209a);
    }

    /* JADX INFO: renamed from: a */
    public void m6231a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull ItemStack itemStack, @NotNull Level level, @NotNull ServerPlayer serverPlayer, boolean z, int i) {
        float f = z ? 0.6f : f6015nN;
        if (serverPlayer.isSprinting()) {
            f += 0.13f;
        }
        m6224a(abstractC0184c, itemStack, level, serverPlayer, f, i);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    protected AbstractC0699mW mo6209a(@NotNull Level level) {
        return ((EntityType) C1307xu.f7605kJ.get()).create(level);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public a mo6211a() {
        return a.FRAG;
    }

    /* JADX INFO: renamed from: cv */
    public boolean mo6232cv() {
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

    @Override // com.boehmod.blockfront.InterfaceC1073tY
    /* JADX INFO: renamed from: a */
    public void mo5942a(@NotNull Minecraft minecraft, boolean z, @NotNull PlayerModel<?> playerModel, @NotNull C0394gj c0394gj, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2) {
        if (mo6232cv()) {
            playerModel.leftArm.xRot = (-1.6f) + playerModel.head.xRot;
            playerModel.leftArm.yRot = playerModel.head.yRot;
            playerModel.rightArm.xRot += (-1.6f) + playerModel.head.xRot;
            playerModel.rightArm.yRot = playerModel.head.yRot;
            playerModel.rightArm.zRot = -0.2f;
        }
    }
}
