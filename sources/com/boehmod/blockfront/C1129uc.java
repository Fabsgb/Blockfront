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

/* JADX INFO: renamed from: com.boehmod.blockfront.uc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uc.class */
public final class C1129uc extends AbstractC1066tS implements InterfaceC1048tA, InterfaceC1070tW, InterfaceC1098ty {

    /* JADX INFO: renamed from: di */
    @NotNull
    private static final String f5934di = "radio_controller";

    /* JADX INFO: renamed from: aQ */
    private static final double f5935aQ = 128.0d;

    /* JADX INFO: renamed from: an */
    @NotNull
    private static final Vec3 f5936an;

    /* JADX INFO: renamed from: b */
    @NotNull
    public static EnumC0988rv f5937b;

    /* JADX INFO: renamed from: mL */
    public static float f5938mL;

    /* JADX INFO: renamed from: mM */
    public static float f5939mM;

    /* JADX INFO: renamed from: hF */
    private boolean f5940hF;

    /* JADX INFO: renamed from: hG */
    private boolean f5941hG;

    /* JADX INFO: renamed from: hH */
    static final /* synthetic */ boolean f5942hH;

    static {
        f5942hH = !C1129uc.class.desiredAssertionStatus();
        f5936an = new Vec3(-10.0d, 5.0d, 0.0d);
        f5937b = EnumC0988rv.AIR_STRIKE;
        f5939mM = 0.0f;
    }

    public C1129uc(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, f5934di, properties);
        this.f5940hF = false;
        this.f5941hG = false;
    }

    /* JADX INFO: renamed from: a */
    private void m6246a(@NotNull Entity entity, @NotNull BlockPos blockPos) {
        m5961q("call");
        entity.playSound((SoundEvent) C1280xc.f7780tD.get(), 1.0f, 0.9f + (ThreadLocalRandom.current().nextFloat() * 0.2f));
        C1194vo.m6653c(new C1162vI(f5937b, blockPos));
    }

    /* JADX INFO: renamed from: dp */
    private void m6247dp() {
        if (f5937b.ordinal() >= EnumC0988rv.values().length) {
            f5937b = EnumC0988rv.values()[0];
        } else {
            f5937b = EnumC0988rv.values()[(f5937b.ordinal() + 1) % EnumC0988rv.values().length];
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    @OnlyIn(Dist.CLIENT)
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) throws MatchException {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f5942hH && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (z) {
                player.swinging = false;
            }
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        if (abstractC0787oFM2688a == null) {
            return;
        }
        if (z) {
            BlockHitResult blockHitResultM5896a = C1060tM.m5896a(entity, f5935aQ, 0.0f);
            if (blockHitResultM5896a.getType() == HitResult.Type.MISS) {
                return;
            }
            Minecraft minecraft = Minecraft.getInstance();
            BlockPos blockPos = null;
            Direction direction = null;
            if (blockHitResultM5896a instanceof BlockHitResult) {
                BlockHitResult blockHitResult = blockHitResultM5896a;
                blockPos = blockHitResult.getBlockPos();
                direction = blockHitResult.getDirection();
            }
            Vec3 location = blockHitResultM5896a.getLocation();
            if (direction != null && minecraft.level != null) {
                C0470iG.m2128a(minecraft, c0622lM2667b, minecraft.level, location, direction, (ParticleOptions) C1232wZ.f7321nW.get(), 0.15f, 0.25f);
            }
            if (minecraft.mouseHandler.isRightPressed()) {
                if (!this.f5940hF) {
                    this.f5940hF = true;
                    m6247dp();
                    minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) SoundEvents.UI_BUTTON_CLICK.value(), 1.5f, 1.0f));
                }
            } else {
                this.f5940hF = false;
            }
            if (minecraft.mouseHandler.isLeftPressed()) {
                if (!this.f5941hG) {
                    this.f5941hG = true;
                    if (abstractC0787oFM2688a.m3587a() == EnumC0795oN.GAME) {
                        C0796oO c0796oOM3793a = abstractC0787oFM2688a.m3582b().m3793a(minecraft.player.getUUID());
                        int iM3867a = 0;
                        if (c0796oOM3793a != null) {
                            iM3867a = c0796oOM3793a.m3867a(f5937b.getCooldownStat(), 0);
                        }
                        if (blockPos != null && (!f5937b.hasCooldown() || iM3867a <= 0)) {
                            m6246a(entity, blockPos);
                        }
                    }
                }
            } else {
                this.f5941hG = false;
            }
        }
        super.inventoryTick(itemStack, level, entity, i, z);
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    /* JADX INFO: renamed from: ci */
    public boolean mo5927ci() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    @NotNull
    /* JADX INFO: renamed from: x */
    public Vec3 mo5893x() {
        return f5936an;
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC1048tA
    /* JADX INFO: renamed from: a */
    public void mo5828a(@NotNull Minecraft minecraft, boolean z, @NotNull PlayerModel<?> playerModel, @NotNull C0324fT c0324fT, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2) {
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
