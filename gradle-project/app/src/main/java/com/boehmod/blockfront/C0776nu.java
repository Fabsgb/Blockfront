package com.boehmod.blockfront;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nu.class */
public class C0776nu extends C0698mV {

    /* JADX INFO: renamed from: mQ */
    private int f4317mQ;

    /* JADX INFO: renamed from: mW */
    private int f4318mW;

    /* JADX INFO: renamed from: jJ */
    private float f4319jJ;

    /* JADX INFO: renamed from: jK */
    private float f4320jK;

    /* JADX INFO: renamed from: fh */
    static final /* synthetic */ boolean f4321fh;

    static {
        f4321fh = !C0776nu.class.desiredAssertionStatus();
    }

    public C0776nu(EntityType<? extends C0776nu> entityType, Level level) {
        super(entityType, level);
        this.f4317mQ = 0;
        this.f4318mW = 4;
        this.f4320jK = 0.0f;
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3649a() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.0d).add(Attributes.MAX_HEALTH, Double.MAX_VALUE);
    }

    /* JADX INFO: renamed from: cc */
    private void m3650cc() {
        this.f4318mW = 3;
        this.f4317mQ = ThreadLocalRandom.current().nextInt(3);
    }

    /* JADX INFO: renamed from: aJ */
    public int m3651aJ() {
        return this.f4317mQ;
    }

    /* JADX INFO: renamed from: aK */
    public int m3652aK() {
        return this.f4318mW;
    }

    /* JADX INFO: renamed from: t */
    public float m3653t(float f) {
        return C1270xJ.m7170f(this.f4319jJ, this.f4320jK, f);
    }

    @NotNull
    /* JADX INFO: renamed from: w */
    public final ResourceLocation m3654w() {
        return C0532jO.m2378d("textures/models/entities/vendor/skin" + (m3652aK() > 0 ? "_blink" : String.valueOf(m3651aJ())) + ".png");
    }

    public boolean isPushable() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0698mV
    public void baseTick() {
        super.baseTick();
        if (level().isClientSide()) {
            this.f4320jK = this.f4319jJ;
            if (Math.random() < 0.03d) {
                m3650cc();
            }
            if (this.f4318mW > 0) {
                this.f4318mW--;
            }
            float f = 0.0f;
            if (this.f4317mQ > 0) {
                f = this.f4317mQ == 1 ? 0.4f : -0.4f;
            }
            this.f4319jJ = Mth.lerp(0.3f, this.f4319jJ, f);
        }
    }

    public boolean isAttackable() {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public InteractionResult interactAt(Player player, @NotNull Vec3 vec3, @NotNull InteractionHand interactionHand) {
        if (!player.level().isClientSide()) {
            return super.interactAt(player, vec3, interactionHand);
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f4321fh && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a instanceof C1040ss) {
            C1040ss c1040ss = (C1040ss) abstractC0863pbM2874a;
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f8150sP.get(), 1.0f, 1.0f));
            minecraft.setScreen(new C0162cZ(minecraft.screen, c1040ss.f5661by, c1040ss));
        }
        return super.interactAt(player, vec3, interactionHand);
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
    }

    @NotNull
    public String getScoreboardName() {
        return String.valueOf(ChatFormatting.RED) + "Infected";
    }

    public void knockback(double d, double d2, double d3) {
    }
}
