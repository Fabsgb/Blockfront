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

/* JADX INFO: renamed from: com.boehmod.blockfront.uA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uA.class */
public final class C1102uA extends AbstractC1144uq implements InterfaceC1071tW, InterfaceC1073tY, InterfaceC1148uu {

    /* JADX INFO: renamed from: dt */
    @NotNull
    private static final String f6000dt = "radio_controller";

    /* JADX INFO: renamed from: bd */
    private static final double f6001bd = 128.0d;

    /* JADX INFO: renamed from: ao */
    @NotNull
    private static final Vec3 f6002ao;

    /* JADX INFO: renamed from: b */
    @NotNull
    public static EnumC0960rS f6003b;

    /* JADX INFO: renamed from: nK */
    public static float f6004nK;

    /* JADX INFO: renamed from: nL */
    public static float f6005nL;

    /* JADX INFO: renamed from: hZ */
    private boolean f6006hZ;

    /* JADX INFO: renamed from: ia */
    private boolean f6007ia;

    /* JADX INFO: renamed from: ib */
    static final /* synthetic */ boolean f6008ib;

    static {
        f6008ib = !C1102uA.class.desiredAssertionStatus();
        f6002ao = new Vec3(-10.0d, 5.0d, 0.0d);
        f6003b = EnumC0960rS.AIR_STRIKE;
        f6005nL = 0.0f;
    }

    public C1102uA(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, f6000dt, properties);
        this.f6006hZ = false;
        this.f6007ia = false;
    }

    /* JADX INFO: renamed from: a */
    private void m6192a(@NotNull Entity entity, @NotNull BlockPos blockPos) {
        m6578q("call");
        entity.playSound((SoundEvent) C1312xz.f8191tE.get(), 1.0f, 0.9f + (ThreadLocalRandom.current().nextFloat() * 0.2f));
        C1169vO.m6648c(new C1241wh(f6003b, blockPos));
    }

    /* JADX INFO: renamed from: dB */
    private void m6193dB() {
        if (f6003b.ordinal() >= EnumC0960rS.values().length) {
            f6003b = EnumC0960rS.values()[0];
        } else {
            f6003b = EnumC0960rS.values()[(f6003b.ordinal() + 1) % EnumC0960rS.values().length];
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC1140um
    @OnlyIn(Dist.CLIENT)
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) throws MatchException {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f6008ib && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (z) {
                player.swinging = false;
            }
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a == null) {
            return;
        }
        if (z) {
            BlockHitResult blockHitResultM6531a = C1138uk.m6531a(entity, f6001bd, 0.0f);
            if (blockHitResultM6531a.getType() == HitResult.Type.MISS) {
                return;
            }
            Minecraft minecraft = Minecraft.getInstance();
            BlockPos blockPos = null;
            Direction direction = null;
            if (blockHitResultM6531a instanceof BlockHitResult) {
                BlockHitResult blockHitResult = blockHitResultM6531a;
                blockPos = blockHitResult.getBlockPos();
                direction = blockHitResult.getDirection();
            }
            Vec3 location = blockHitResultM6531a.getLocation();
            if (direction != null && minecraft.level != null) {
                C0490iZ.m2220a(minecraft, c0623lM2852b, minecraft.level, location, direction, (ParticleOptions) C1309xw.f7886nW.get(), 0.15f, 0.25f);
            }
            if (minecraft.mouseHandler.isRightPressed()) {
                if (!this.f6006hZ) {
                    this.f6006hZ = true;
                    m6193dB();
                    minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) SoundEvents.UI_BUTTON_CLICK.value(), 1.5f, 1.0f));
                }
            } else {
                this.f6006hZ = false;
            }
            if (minecraft.mouseHandler.isLeftPressed()) {
                if (!this.f6007ia) {
                    this.f6007ia = true;
                    if (abstractC0863pbM2874a.m4023a() == EnumC0871pj.GAME) {
                        C0872pk c0872pkM4229a = abstractC0863pbM2874a.m4018b().m4229a(minecraft.player.getUUID());
                        int iM4303a = 0;
                        if (c0872pkM4229a != null) {
                            iM4303a = c0872pkM4229a.m4303a(f6003b.getCooldownStat(), 0);
                        }
                        if (blockPos != null && (!f6003b.hasCooldown() || iM4303a <= 0)) {
                            m6192a(entity, blockPos);
                        }
                    }
                }
            } else {
                this.f6007ia = false;
            }
        }
        super.inventoryTick(itemStack, level, entity, i, z);
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    /* JADX INFO: renamed from: cs */
    public boolean mo6194cs() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    @NotNull
    /* JADX INFO: renamed from: y */
    public Vec3 mo6195y() {
        return f6002ao;
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC1073tY
    /* JADX INFO: renamed from: a */
    public void mo5942a(@NotNull Minecraft minecraft, boolean z, @NotNull PlayerModel<?> playerModel, @NotNull C0394gj c0394gj, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2) {
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
