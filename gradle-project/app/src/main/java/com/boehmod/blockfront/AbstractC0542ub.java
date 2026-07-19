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

/* JADX INFO: renamed from: com.boehmod.blockfront.ub, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ub.class */
public abstract class AbstractC0542ub extends tK implements tC, tW {
    public static int rO;
    static final /* synthetic */ boolean hE;

    @OnlyIn(Dist.CLIENT)
    public abstract boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull Level level, @NotNull Player player, @NotNull AbstractC0542ub abstractC0542ub, @NotNull ItemStack itemStack);

    public abstract int bW();

    @NotNull
    public abstract SoundEvent x();

    public abstract int bU();

    @NotNull
    public abstract String as();

    public abstract int getColor();

    @NotNull
    public abstract ResourceLocation getIcon();

    static {
        hE = !AbstractC0542ub.class.desiredAssertionStatus();
        rO = 0;
    }

    public AbstractC0542ub(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull Player player, @NotNull AbstractC0542ub abstractC0542ub, @NotNull ItemStack itemStack) {
        Object objMo604a = abstractC0264ju.mo604a(player.getUUID());
        if (objMo604a instanceof qX) {
            qX qXVar = (qX) objMo604a;
            if (qXVar.a((Level) serverLevel, player, abstractC0542ub, itemStack)) {
                qXVar.a(serverLevel, player, abstractC0542ub, itemStack);
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
                C0297l c0297lB = C0297l.b();
                if (!hE && c0297lB == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                fV fVVar = (fV) c0297lB.a();
                oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
                fT fTVar = (fT) fVVar.a(player);
                boolean z2 = oFVarM591a == 0 || a(c0297lB, oFVarM591a, level, player, this, itemStack);
                if (oR.a(player, fTVar)) {
                    z2 = false;
                }
                if ((oFVarM591a instanceof qX) && !((qX) oFVarM591a).a(level, player, this, itemStack)) {
                    z2 = false;
                }
                if (!z2) {
                    rO = 0;
                    return;
                }
                if (Minecraft.getInstance().mouseHandler.isRightPressed()) {
                    entity.setDeltaMovement(0.0d, deltaMovement.y, 0.0d);
                    entity.setPos(entity.xOld, entity.yOld, entity.zOld);
                    if (rO == 4) {
                        level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, SoundEvents.ENDER_DRAGON_FLAP, SoundSource.BLOCKS, 1.0f, 1.5f, false);
                    }
                    if (rO % bW() == 0 && rO != 0) {
                        level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, x(), SoundSource.BLOCKS, 1.0f, (float) (0.800000011920929d + (0.4000000059604645d * Math.random())), false);
                    }
                    int i2 = rO;
                    rO = i2 + 1;
                    if (i2 >= bU()) {
                        level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, SoundEvents.ENDER_DRAGON_FLAP, SoundSource.BLOCKS, 1.0f, 1.2f, false);
                        C0582vo.c(new vZ());
                        rO = -10;
                        return;
                    }
                    return;
                }
                rO = 0;
            }
        }
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        return rO <= 0 || rO % bW() == 0;
    }

    @Override // com.boehmod.blockfront.tC
    public int bj() {
        return rO;
    }
}
