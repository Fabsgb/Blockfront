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

/* JADX INFO: renamed from: com.boehmod.blockfront.mM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mM.class */
public class C0688mM extends C0686mK {

    /* JADX INFO: renamed from: li */
    private static final int f3711li = 40;

    /* JADX INFO: renamed from: ap */
    public static final double f3712ap = 1.5d;

    /* JADX INFO: renamed from: iL */
    public static final float f3713iL = 2.0f;

    /* JADX INFO: renamed from: iM */
    public static final float f3714iM = 5.0f;

    /* JADX INFO: renamed from: lj */
    public static final int f3715lj = 60;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected LivingEntity f3716a;

    /* JADX INFO: renamed from: lk */
    private int f3717lk;

    /* JADX INFO: renamed from: ll */
    private int f3718ll;

    public C0688mM(@NotNull C0680mE c0680mE) {
        super(c0680mE);
        this.f3718ll = 40;
        setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override // com.boehmod.blockfront.C0686mK
    public boolean canUse() {
        AbstractC0787oF abstractC0787oFA;
        if (this.f3696b.getTarget() != null || (abstractC0787oFA = this.f3696b.m3008a()) == null || !this.f3696b.m3072b().m5520bT()) {
            return false;
        }
        if (this.f3717lk > 0) {
            this.f3717lk--;
            return false;
        }
        AbstractC0790oI abstractC0790oIM3582b = abstractC0787oFA.m3582b();
        BlockPos onPos = this.f3696b.getOnPos();
        this.f3716a = this.f3696b.level().getNearestPlayer(onPos.getX(), onPos.getY(), onPos.getZ(), 5.0d, entity -> {
            C0796oO c0796oOM3793a;
            if (entity instanceof Player) {
                Player player = (Player) entity;
                UUID uuid = player.getUUID();
                return abstractC0790oIM3582b.m3809h().contains(uuid) && (c0796oOM3793a = abstractC0790oIM3582b.m3793a(uuid)) != null && c0796oOM3793a.equals(this.f3696b.m3046a()) && player.getHealth() < player.getMaxHealth();
            }
            if (entity instanceof C0680mE) {
                return ((C0680mE) entity).m3053E().equals(this.f3696b.m3053E());
            }
            return false;
        });
        return this.f3716a != null;
    }

    public void stop() {
        super.stop();
        this.f3716a = null;
        this.f3717lk = 60;
    }

    public void tick() {
        super.tick();
        float fDistanceTo = this.f3696b.distanceTo(this.f3716a);
        this.f3696b.getLookControl().setLookAt(this.f3716a, this.f3696b.getMaxHeadYRot() + 20, this.f3696b.getMaxHeadXRot());
        if (fDistanceTo < 1.5d) {
            this.f3696b.getNavigation().stop();
        } else {
            this.f3696b.getNavigation().moveTo(this.f3716a, 0.550000011920929d);
        }
        if (fDistanceTo <= 2.0f) {
            int i = this.f3718ll;
            this.f3718ll = i - 1;
            if (i <= 0) {
                this.f3718ll = 40;
                m3103bJ();
            }
        }
    }

    /* JADX INFO: renamed from: bJ */
    public void m3103bJ() {
        if (this.f3716a == null) {
            return;
        }
        this.f3716a.heal(4.0f);
        this.f3696b.m3036a((Holder<SoundEvent>) C1280xc.f7797tU, SoundSource.PLAYERS, 1.0f, 1.0f);
        C0799oR.m4043a(this.f3716a, (ParticleOptions) C1232wZ.f7314nP.get(), this.f3716a.getRandom(), 0.0f, 0.0f, 0.0f, 5);
        ServerPlayer serverPlayer = this.f3716a;
        if (serverPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = serverPlayer;
            MutableComponent mutableComponentLiteral = Component.literal(this.f3696b.m3055F());
            C0796oO c0796oOM3046a = this.f3696b.m3046a();
            if (c0796oOM3046a != null) {
                mutableComponentLiteral = mutableComponentLiteral.copy().withStyle(c0796oOM3046a.m3876a());
            }
            C0799oR.m3970c(serverPlayer2, (Component) Component.translatable("bf.message.gamemode.medicalsyringe.heal", new Object[]{mutableComponentLiteral}).withStyle(ChatFormatting.GRAY));
        }
    }
}
