package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ub */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ub.class */
public abstract class AbstractC1128ub extends C1058tK implements InterfaceC1050tC, InterfaceC1070tW {

    /* JADX INFO: renamed from: rO */
    public static int f5932rO;

    /* JADX INFO: renamed from: hE */
    static final /* synthetic */ boolean f5933hE;

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract boolean mo5963a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Level level, @NotNull Player player, @NotNull AbstractC1128ub abstractC1128ub, @NotNull ItemStack itemStack);

    /* JADX INFO: renamed from: bW */
    public abstract int mo5964bW();

    @NotNull
    /* JADX INFO: renamed from: x */
    public abstract SoundEvent mo5965x();

    /* JADX INFO: renamed from: bU */
    public abstract int mo5834bU();

    @NotNull
    /* JADX INFO: renamed from: as */
    public abstract String mo5835as();

    public abstract int getColor();

    @NotNull
    public abstract ResourceLocation getIcon();

    static {
        f5933hE = !AbstractC1128ub.class.desiredAssertionStatus();
        f5932rO = 0;
    }

    public AbstractC1128ub(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
    }

    /* JADX INFO: renamed from: a */
    public void mo5962a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull Player player, @NotNull AbstractC1128ub abstractC1128ub, @NotNull ItemStack itemStack) {
        Object objMo2531a = abstractC0563ju.mo2531a(player.getUUID());
        if (objMo2531a instanceof InterfaceC0911qX) {
            InterfaceC0911qX interfaceC0911qX = (InterfaceC0911qX) objMo2531a;
            if (interfaceC0911qX.mo4695a((Level) serverLevel, player, abstractC1128ub, itemStack)) {
                interfaceC0911qX.mo4696a(serverLevel, player, abstractC1128ub, itemStack);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnlyIn(Dist.CLIENT)
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        super.inventoryTick(itemStack, level, entity, i, z);
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (level.isClientSide() && z) {
                Vec3 deltaMovement = player.getDeltaMovement();
                Vec3 vec3Position = player.position();
                C0622l c0622lM2667b = C0622l.m2667b();
                if (!f5933hE && c0622lM2667b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
                AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
                C0324fT c0324fT = (C0324fT) c0326fV.m1133a(player);
                boolean z2 = abstractC0787oFM2688a == 0 || mo5963a(c0622lM2667b, abstractC0787oFM2688a, level, player, this, itemStack);
                if (C0799oR.m4052a(player, c0324fT)) {
                    z2 = false;
                }
                if ((abstractC0787oFM2688a instanceof InterfaceC0911qX) && !((InterfaceC0911qX) abstractC0787oFM2688a).mo4695a(level, player, this, itemStack)) {
                    z2 = false;
                }
                if (!z2) {
                    f5932rO = 0;
                    return;
                }
                if (Minecraft.getInstance().mouseHandler.isRightPressed()) {
                    entity.setDeltaMovement(0.0d, deltaMovement.y, 0.0d);
                    entity.setPos(entity.xOld, entity.yOld, entity.zOld);
                    if (f5932rO == 4) {
                        level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, SoundEvents.ENDER_DRAGON_FLAP, SoundSource.BLOCKS, 1.0f, 1.5f, false);
                    }
                    if (f5932rO % mo5964bW() == 0 && f5932rO != 0) {
                        level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, mo5965x(), SoundSource.BLOCKS, 1.0f, (float) (0.800000011920929d + (0.4000000059604645d * Math.random())), false);
                    }
                    int i2 = f5932rO;
                    f5932rO = i2 + 1;
                    if (i2 >= mo5834bU()) {
                        level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, SoundEvents.ENDER_DRAGON_FLAP, SoundSource.BLOCKS, 1.0f, 1.2f, false);
                        C1194vo.m6653c(new C1179vZ());
                        f5932rO = -10;
                        return;
                    }
                    return;
                }
                f5932rO = 0;
            }
        }
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        return f5932rO <= 0 || f5932rO % mo5964bW() == 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC1050tC
    /* JADX INFO: renamed from: bj */
    public int mo5833bj() {
        return f5932rO;
    }
}
