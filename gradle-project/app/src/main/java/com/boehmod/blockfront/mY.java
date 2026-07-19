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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mY.class */
public class mY extends C0350mz {
    private int kS;
    private int kY;
    private float iQ;
    private float iR;
    static final /* synthetic */ boolean eN;

    static {
        eN = !mY.class.desiredAssertionStatus();
    }

    public mY(EntityType<? extends mY> entityType, Level level) {
        super(entityType, level);
        this.kS = 0;
        this.kY = 4;
        this.iR = 0.0f;
    }

    public static AttributeSupplier.Builder a() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.0d).add(Attributes.MAX_HEALTH, Double.MAX_VALUE);
    }

    private void bR() {
        this.kY = 3;
        this.kS = ThreadLocalRandom.current().nextInt(3);
    }

    public int au() {
        return this.kS;
    }

    public int av() {
        return this.kY;
    }

    public float q(float f) {
        return C0634xm.e(this.iQ, this.iR, f);
    }

    @NotNull
    public final ResourceLocation v() {
        return C0265jv.d("textures/models/entities/vendor/skin" + (av() > 0 ? "_blink" : String.valueOf(au())) + ".png");
    }

    public boolean isPushable() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0350mz
    public void baseTick() {
        super.baseTick();
        if (level().isClientSide()) {
            this.iR = this.iQ;
            if (Math.random() < 0.03d) {
                bR();
            }
            if (this.kY > 0) {
                this.kY--;
            }
            float f = 0.0f;
            if (this.kS > 0) {
                f = this.kS == 1 ? 0.4f : -0.4f;
            }
            this.iQ = Mth.lerp(0.3f, this.iQ, f);
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
        C0297l c0297lB = C0297l.b();
        if (!eN && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        if (oFVarM591a instanceof rV) {
            rV rVVar = (rV) oFVarM591a;
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.sO.get(), 1.0f, 1.0f));
            minecraft.setScreen(new cQ(minecraft.screen, rVVar.br, rVVar));
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
