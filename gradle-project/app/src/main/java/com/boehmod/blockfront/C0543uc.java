package com.boehmod.blockfront;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uc.class */
public final class C0543uc extends tS implements tA, tW, InterfaceC0538ty {

    @NotNull
    private static final String di = "radio_controller";
    private static final double aQ = 128.0d;

    @NotNull
    private static final Vec3 an;

    @NotNull
    public static EnumC0481rv b;
    public static float mL;
    public static float mM;
    private boolean hF;
    private boolean hG;
    static final /* synthetic */ boolean hH;

    static {
        hH = !C0543uc.class.desiredAssertionStatus();
        an = new Vec3(-10.0d, 5.0d, 0.0d);
        b = EnumC0481rv.AIR_STRIKE;
        mM = 0.0f;
    }

    public C0543uc(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, di, properties);
        this.hF = false;
        this.hG = false;
    }

    private void a(@NotNull Entity entity, @NotNull BlockPos blockPos) {
        q("call");
        entity.playSound((SoundEvent) C0624xc.tD.get(), 1.0f, 0.9f + (ThreadLocalRandom.current().nextFloat() * 0.2f));
        C0582vo.c(new vI(b, blockPos));
    }

    private void dp() {
        if (b.ordinal() >= EnumC0481rv.values().length) {
            b = EnumC0481rv.values()[0];
        } else {
            b = EnumC0481rv.values()[(b.ordinal() + 1) % EnumC0481rv.values().length];
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.tO
    @OnlyIn(Dist.CLIENT)
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) throws MatchException {
        C0297l c0297lB = C0297l.b();
        if (!hH && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (z) {
                player.swinging = false;
            }
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        if (oFVarM591a == null) {
            return;
        }
        if (z) {
            BlockHitResult blockHitResultA = tM.a(entity, aQ, 0.0f);
            if (blockHitResultA.getType() == HitResult.Type.MISS) {
                return;
            }
            Minecraft minecraft = Minecraft.getInstance();
            BlockPos blockPos = null;
            Direction direction = null;
            if (blockHitResultA instanceof BlockHitResult) {
                BlockHitResult blockHitResult = blockHitResultA;
                blockPos = blockHitResult.getBlockPos();
                direction = blockHitResult.getDirection();
            }
            Vec3 location = blockHitResultA.getLocation();
            if (direction != null && minecraft.level != null) {
                iG.a(minecraft, c0297lB, minecraft.level, location, direction, (ParticleOptions) wZ.nW.get(), 0.15f, 0.25f);
            }
            if (minecraft.mouseHandler.isRightPressed()) {
                if (!this.hF) {
                    this.hF = true;
                    dp();
                    minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) SoundEvents.UI_BUTTON_CLICK.value(), 1.5f, 1.0f));
                }
            } else {
                this.hF = false;
            }
            if (minecraft.mouseHandler.isLeftPressed()) {
                if (!this.hG) {
                    this.hG = true;
                    if (oFVarM591a.m750a() == oN.GAME) {
                        oO oOVarA = oFVarM591a.b().a(minecraft.player.getUUID());
                        int iM790a = 0;
                        if (oOVarA != null) {
                            iM790a = oOVarA.m790a(b.getCooldownStat(), 0);
                        }
                        if (blockPos != null && (!b.hasCooldown() || iM790a <= 0)) {
                            a(entity, blockPos);
                        }
                    }
                }
            } else {
                this.hG = false;
            }
        }
        super.inventoryTick(itemStack, level, entity, i, z);
    }

    @Override // com.boehmod.blockfront.tO
    public boolean ci() {
        return false;
    }

    @Override // com.boehmod.blockfront.tO
    @NotNull
    public Vec3 x() {
        return an;
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        return true;
    }

    @Override // com.boehmod.blockfront.tA
    public void a(@NotNull Minecraft minecraft, boolean z, @NotNull PlayerModel<?> playerModel, @NotNull fT fTVar, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2) {
        ModelPart modelPart = playerModel.leftArm;
        ModelPart modelPart2 = playerModel.leftSleeve;
        float f3 = (-1.5f) + playerModel.head.xRot;
        modelPart2.xRot = f3;
        modelPart.xRot = f3;
        ModelPart modelPart3 = playerModel.leftArm;
        ModelPart modelPart4 = playerModel.leftSleeve;
        float f4 = playerModel.head.yRot;
        modelPart4.yRot = f4;
        modelPart3.yRot = f4;
        ModelPart modelPart5 = playerModel.rightArm;
        ModelPart modelPart6 = playerModel.rightSleeve;
        float f5 = playerModel.head.xRot - 1.0f;
        modelPart6.xRot = f5;
        modelPart5.xRot = f5;
        ModelPart modelPart7 = playerModel.rightArm;
        playerModel.rightSleeve.yRot = -0.3f;
        modelPart7.yRot = -0.3f;
        ModelPart modelPart8 = playerModel.rightArm;
        playerModel.rightSleeve.zRot = 0.2f;
        modelPart8.zRot = 0.2f;
    }
}
