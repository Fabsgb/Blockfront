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

/* JADX INFO: renamed from: com.boehmod.blockfront.ni */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ni.class */
public class C0764ni extends C0762ng {

    /* JADX INFO: renamed from: ng */
    private static final int f4274ng = 40;

    /* JADX INFO: renamed from: aC */
    public static final double f4275aC = 1.5d;

    /* JADX INFO: renamed from: jE */
    public static final float f4276jE = 2.0f;

    /* JADX INFO: renamed from: jF */
    public static final float f4277jF = 5.0f;

    /* JADX INFO: renamed from: nh */
    public static final int f4278nh = 60;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected LivingEntity f4279a;

    /* JADX INFO: renamed from: ni */
    private int f4280ni;

    /* JADX INFO: renamed from: nj */
    private int f4281nj;

    public C0764ni(@NotNull C0756na c0756na) {
        super(c0756na);
        this.f4281nj = 40;
        setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override // com.boehmod.blockfront.C0762ng
    public boolean canUse() {
        AbstractC0863pb abstractC0863pbA;
        if (this.f4259b.getTarget() != null || (abstractC0863pbA = this.f4259b.m3516a()) == null || !this.f4259b.m3579b().m6008cd()) {
            return false;
        }
        if (this.f4280ni > 0) {
            this.f4280ni--;
            return false;
        }
        AbstractC0866pe abstractC0866peM4018b = abstractC0863pbA.m4018b();
        BlockPos onPos = this.f4259b.getOnPos();
        this.f4279a = this.f4259b.level().getNearestPlayer(onPos.getX(), onPos.getY(), onPos.getZ(), 5.0d, entity -> {
            C0872pk c0872pkM4229a;
            if (entity instanceof Player) {
                Player player = (Player) entity;
                UUID uuid = player.getUUID();
                return abstractC0866peM4018b.m4245h().contains(uuid) && (c0872pkM4229a = abstractC0866peM4018b.m4229a(uuid)) != null && c0872pkM4229a.equals(this.f4259b.m3553a()) && player.getHealth() < player.getMaxHealth();
            }
            if (entity instanceof C0756na) {
                return ((C0756na) entity).m3560L().equals(this.f4259b.m3560L());
            }
            return false;
        });
        return this.f4279a != null;
    }

    public void stop() {
        super.stop();
        this.f4279a = null;
        this.f4280ni = 60;
    }

    public void tick() {
        super.tick();
        float fDistanceTo = this.f4259b.distanceTo(this.f4279a);
        this.f4259b.getLookControl().setLookAt(this.f4279a, this.f4259b.getMaxHeadYRot() + 20, this.f4259b.getMaxHeadXRot());
        if (fDistanceTo < 1.5d) {
            this.f4259b.getNavigation().stop();
        } else {
            this.f4259b.getNavigation().moveTo(this.f4279a, 0.550000011920929d);
        }
        if (fDistanceTo <= 2.0f) {
            int i = this.f4281nj;
            this.f4281nj = i - 1;
            if (i <= 0) {
                this.f4281nj = 40;
                m3610bU();
            }
        }
    }

    /* JADX INFO: renamed from: bU */
    public void m3610bU() {
        if (this.f4279a == null) {
            return;
        }
        this.f4279a.heal(4.0f);
        this.f4259b.m3544a((Holder<SoundEvent>) C1312xz.f8208tV, SoundSource.PLAYERS, 1.0f, 1.0f);
        C0875pn.m4479a(this.f4279a, (ParticleOptions) C1309xw.f7879nP.get(), this.f4279a.getRandom(), 0.0f, 0.0f, 0.0f, 5);
        ServerPlayer serverPlayer = this.f4279a;
        if (serverPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = serverPlayer;
            MutableComponent mutableComponentLiteral = Component.literal(this.f4259b.m3562M());
            C0872pk c0872pkM3553a = this.f4259b.m3553a();
            if (c0872pkM3553a != null) {
                mutableComponentLiteral = mutableComponentLiteral.copy().withStyle(c0872pkM3553a.m4312a());
            }
            C0875pn.m4406c(serverPlayer2, (Component) Component.translatable("bf.message.gamemode.medicalsyringe.heal", new Object[]{mutableComponentLiteral}).withStyle(ChatFormatting.GRAY));
        }
    }
}
