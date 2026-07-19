package com.boehmod.blockfront;

import java.util.EnumSet;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mM.class */
public class mM extends mK {
    private static final int li = 40;
    public static final double ap = 1.5d;
    public static final float iL = 2.0f;
    public static final float iM = 5.0f;
    public static final int lj = 60;

    @Nullable
    protected LivingEntity a;
    private int lk;
    private int ll;

    public mM(@NotNull mE mEVar) {
        super(mEVar);
        this.ll = 40;
        setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override // com.boehmod.blockfront.mK
    public boolean canUse() {
        oF oFVarA;
        if (this.b.getTarget() != null || (oFVarA = this.b.a()) == null || !this.b.m673b().bT()) {
            return false;
        }
        if (this.lk > 0) {
            this.lk--;
            return false;
        }
        oI oIVarB = oFVarA.b();
        BlockPos onPos = this.b.getOnPos();
        this.a = this.b.level().getNearestPlayer(onPos.getX(), onPos.getY(), onPos.getZ(), 5.0d, entity -> {
            oO oOVarA;
            if (entity instanceof Player) {
                Player player = (Player) entity;
                UUID uuid = player.getUUID();
                return oIVarB.h().contains(uuid) && (oOVarA = oIVarB.a(uuid)) != null && oOVarA.equals(this.b.m671a()) && player.getHealth() < player.getMaxHealth();
            }
            if (entity instanceof mE) {
                return ((mE) entity).E().equals(this.b.E());
            }
            return false;
        });
        return this.a != null;
    }

    public void stop() {
        super.stop();
        this.a = null;
        this.lk = 60;
    }

    public void tick() {
        super.tick();
        float fDistanceTo = this.b.distanceTo(this.a);
        this.b.getLookControl().setLookAt(this.a, this.b.getMaxHeadYRot() + 20, this.b.getMaxHeadXRot());
        if (fDistanceTo < 1.5d) {
            this.b.getNavigation().stop();
        } else {
            this.b.getNavigation().moveTo(this.a, 0.550000011920929d);
        }
        if (fDistanceTo <= 2.0f) {
            int i = this.ll;
            this.ll = i - 1;
            if (i <= 0) {
                this.ll = 40;
                bJ();
            }
        }
    }

    public void bJ() {
        if (this.a == null) {
            return;
        }
        this.a.heal(4.0f);
        this.b.a((Holder<SoundEvent>) C0624xc.tU, SoundSource.PLAYERS, 1.0f, 1.0f);
        oR.a(this.a, (ParticleOptions) wZ.nP.get(), this.a.getRandom(), 0.0f, 0.0f, 0.0f, 5);
        ServerPlayer serverPlayer = this.a;
        if (serverPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = serverPlayer;
            MutableComponent mutableComponentLiteral = Component.literal(this.b.F());
            oO oOVarM671a = this.b.m671a();
            if (oOVarM671a != null) {
                mutableComponentLiteral = mutableComponentLiteral.copy().withStyle(oOVarM671a.a());
            }
            oR.c(serverPlayer2, (Component) Component.translatable("bf.message.gamemode.medicalsyringe.heal", new Object[]{mutableComponentLiteral}).withStyle(ChatFormatting.GRAY));
        }
    }
}
