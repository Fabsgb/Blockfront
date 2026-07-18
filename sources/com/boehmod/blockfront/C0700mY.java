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

/* JADX INFO: renamed from: com.boehmod.blockfront.mY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mY.class */
public class C0700mY extends C0727mz {

    /* JADX INFO: renamed from: kS */
    private int f3754kS;

    /* JADX INFO: renamed from: kY */
    private int f3755kY;

    /* JADX INFO: renamed from: iQ */
    private float f3756iQ;

    /* JADX INFO: renamed from: iR */
    private float f3757iR;

    /* JADX INFO: renamed from: eN */
    static final /* synthetic */ boolean f3758eN;

    static {
        f3758eN = !C0700mY.class.desiredAssertionStatus();
    }

    public C0700mY(EntityType<? extends C0700mY> entityType, Level level) {
        super(entityType, level);
        this.f3754kS = 0;
        this.f3755kY = 4;
        this.f3757iR = 0.0f;
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3142a() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.0d).add(Attributes.MAX_HEALTH, Double.MAX_VALUE);
    }

    /* JADX INFO: renamed from: bR */
    private void m3143bR() {
        this.f3755kY = 3;
        this.f3754kS = ThreadLocalRandom.current().nextInt(3);
    }

    /* JADX INFO: renamed from: au */
    public int m3144au() {
        return this.f3754kS;
    }

    /* JADX INFO: renamed from: av */
    public int m3145av() {
        return this.f3755kY;
    }

    /* JADX INFO: renamed from: q */
    public float m3146q(float f) {
        return C1290xm.m7843e(this.f3756iQ, this.f3757iR, f);
    }

    @NotNull
    /* JADX INFO: renamed from: v */
    public final ResourceLocation m3147v() {
        return C0564jv.m2555d("textures/models/entities/vendor/skin" + (m3145av() > 0 ? "_blink" : String.valueOf(m3144au())) + ".png");
    }

    public boolean isPushable() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0727mz
    public void baseTick() {
        super.baseTick();
        if (level().isClientSide()) {
            this.f3757iR = this.f3756iQ;
            if (Math.random() < 0.03d) {
                m3143bR();
            }
            if (this.f3755kY > 0) {
                this.f3755kY--;
            }
            float f = 0.0f;
            if (this.f3754kS > 0) {
                f = this.f3754kS == 1 ? 0.4f : -0.4f;
            }
            this.f3756iQ = Mth.lerp(0.3f, this.f3756iQ, f);
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
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3758eN && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        if (abstractC0787oFM2688a instanceof C0962rV) {
            C0962rV c0962rV = (C0962rV) abstractC0787oFM2688a;
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7739sO.get(), 1.0f, 1.0f));
            minecraft.setScreen(new C0152cQ(minecraft.screen, c0962rV.f5084br, c0962rV));
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
