package com.boehmod.blockfront;

import com.boehmod.blockfront.vW;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gN.class */
public final class gN extends PlayerRenderer implements S<AbstractClientPlayer> {
    public static final ResourceLocation cM;

    @NotNull
    private final C0208hr a;
    static final /* synthetic */ boolean cu;

    static {
        cu = !gN.class.desiredAssertionStatus();
        cM = C0265jv.d("textures/models/entities/corpse/burned.png");
    }

    public gN(@NotNull EntityRendererProvider.Context context, boolean z) {
        super(context, z);
        eE eEVar = new eE(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM : ModelLayers.PLAYER), z);
        this.model = eEVar;
        this.layers.clear();
        addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM_INNER_ARMOR : ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM_OUTER_ARMOR : ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
        addLayer(new C0207hq(this, context.getItemInHandRenderer()));
        addLayer(new C0206hp(this));
        addLayer(new HumanoidArmorLayer(this, new HumanoidArmorModel(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM_INNER_ARMOR : ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidArmorModel(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM_OUTER_ARMOR : ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
        C0208hr c0208hr = new C0208hr(context, this, eEVar, z);
        this.a = c0208hr;
        addLayer(c0208hr);
    }

    @Nullable
    public static ResourceLocation a(@NotNull UUID uuid, @Nullable oG<?, ?> oGVar, @NotNull String str, @NotNull Set<UUID> set) {
        if (oGVar == null) {
            return null;
        }
        return oGVar.a(uuid, str, set);
    }

    private static void a(@NotNull ModelPart modelPart, @NotNull ModelPart modelPart2) {
        modelPart.xRot = 0.0f;
        modelPart.yRot = 0.0f;
        modelPart.zRot = 0.0f;
        modelPart2.xRot = 0.0f;
        modelPart2.yRot = 0.0f;
        modelPart2.zRot = 0.0f;
        modelPart.y = 0.0f;
        modelPart.x = 0.0f;
        modelPart.z = 0.0f;
        modelPart2.y = 0.0f;
        modelPart2.x = 0.0f;
        modelPart2.z = 0.0f;
    }

    public void a(@Nullable oF<?, ?, ?> oFVar, @Nullable oG<?, ?> oGVar, @NotNull AbstractClientPlayer abstractClientPlayer, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, boolean z) {
        ModelPart modelPart = z ? this.model.leftArm : this.model.rightArm;
        ModelPart modelPart2 = z ? this.model.leftSleeve : this.model.rightSleeve;
        eE model = getModel();
        model.setAllVisible(true);
        if (oFVar != null) {
            this.model.jacket.visible = false;
            this.model.rightPants.visible = false;
            this.model.leftPants.visible = false;
            this.model.rightSleeve.visible = false;
            this.model.leftSleeve.visible = false;
        }
        model.crouching = false;
        model.attackTime = 0.0f;
        model.swimAmount = 0.0f;
        this.model.copyPropertiesTo(this.a.a);
        this.model.copyPropertiesTo(this.a.f167a);
        a(modelPart, modelPart2);
        VertexConsumer buffer = multiBufferSource.getBuffer(RenderType.entityTranslucent(getTextureLocation(abstractClientPlayer)));
        poseStack.pushPose();
        modelPart.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY);
        modelPart2.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY);
        if (oFVar != null && oGVar != null) {
            a(poseStack, multiBufferSource, i, modelPart, modelPart2, oFVar, oGVar, abstractClientPlayer);
        }
        poseStack.popPose();
        this.model.jacket.visible = true;
        this.model.rightPants.visible = true;
        this.model.leftPants.visible = true;
        this.model.rightSleeve.visible = true;
        this.model.leftSleeve.visible = true;
    }

    private void a(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull ModelPart modelPart, @NotNull ModelPart modelPart2, @NotNull oF<?, ?, ?> oFVar, @NotNull oG<?, ?> oGVar, @NotNull AbstractClientPlayer abstractClientPlayer) {
        UUID uuid = abstractClientPlayer.getUUID();
        int iA = oFVar.a(uuid).a(C0529tp.i.getKey(), -1);
        if (iA == -1) {
            return;
        }
        boolean z = modelPart.visible;
        boolean z2 = modelPart2.visible;
        modelPart.visible = true;
        modelPart2.visible = true;
        ResourceLocation resourceLocationA = a(uuid, oGVar, sV.a(iA).getKey(), oFVar.b().h());
        if (resourceLocationA == null) {
            return;
        }
        VertexConsumer buffer = multiBufferSource.getBuffer(RenderType.entityTranslucent(resourceLocationA));
        modelPart.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY);
        modelPart2.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY);
        modelPart.visible = z;
        modelPart2.visible = z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public float getShadowRadius(@NotNull AbstractClientPlayer abstractClientPlayer) {
        C0297l c0297lB = C0297l.b();
        if (!cu && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (((fT) ((fV) c0297lB.a()).a((Player) abstractClientPlayer)).ag() > 0) {
            return 0.0f;
        }
        return super.getShadowRadius(abstractClientPlayer);
    }

    public void render(@NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        C0297l c0297lB = C0297l.b();
        if (!cu && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (((fT) ((fV) c0297lB.a()).a((Player) abstractClientPlayer)).ag() > 0 || c0297lB.a(abstractClientPlayer.getUUID())) {
            return;
        }
        Pose pose = abstractClientPlayer.getPose();
        this.model.jacket.visible = false;
        this.model.rightPants.visible = false;
        this.model.leftPants.visible = false;
        this.model.rightSleeve.visible = false;
        this.model.leftSleeve.visible = false;
        super.render(abstractClientPlayer, f, f2, poseStack, multiBufferSource, i);
        if (!this.layers.contains(this.a)) {
            addLayer(this.a);
        }
        abstractClientPlayer.setPose(pose);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull AbstractClientPlayer abstractClientPlayer) {
        if (abstractClientPlayer instanceof bQ) {
            bQ bQVar = (bQ) abstractClientPlayer;
            Minecraft minecraft = Minecraft.getInstance();
            C0297l c0297lB = C0297l.b();
            if (cu || c0297lB != null) {
                return C0040bk.a(minecraft, c0297lB, bQVar.getGameProfile());
            }
            throw new AssertionError("Client mod manager is null!");
        }
        return super.getTextureLocation(abstractClientPlayer);
    }

    @Override // com.boehmod.blockfront.S
    @NotNull
    public Collection<G> a(@NotNull F f, vW.a aVar, @NotNull AbstractClientPlayer abstractClientPlayer, @NotNull R r) {
        C0297l c0297lB = C0297l.b();
        if (!cu && c0297lB == null) {
            throw new AssertionError("Mod manager is null!");
        }
        fT fTVar = (fT) ((fV) c0297lB.a()).a((Player) abstractClientPlayer);
        ResourceLocation resourceLocationA = aVar.cU() ? cM : a(abstractClientPlayer);
        ResourceLocation resourceLocationK = fTVar.k();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        G gA = a(I.BODY, r, resourceLocationA, resourceLocationK, playerModel -> {
            return playerModel.body;
        }, playerModel2 -> {
            return playerModel2.jacket;
        }, 1.0d);
        objectArrayList.add(gA);
        G gA2 = a(I.HEAD, r, resourceLocationA, resourceLocationK, playerModel3 -> {
            return playerModel3.head;
        }, playerModel4 -> {
            return playerModel4.hat;
        }, 0.4d);
        objectArrayList.add(gA2);
        G gA3 = a(I.ARM, r, resourceLocationA, resourceLocationK, playerModel5 -> {
            return playerModel5.leftArm;
        }, playerModel6 -> {
            return playerModel6.leftSleeve;
        }, 1.0d);
        objectArrayList.add(gA3);
        G gA4 = a(I.ARM, r, resourceLocationA, resourceLocationK, playerModel7 -> {
            return playerModel7.rightArm;
        }, playerModel8 -> {
            return playerModel8.rightSleeve;
        }, 1.0d);
        objectArrayList.add(gA4);
        G gA5 = a(I.LEG, r, resourceLocationA, resourceLocationK, playerModel9 -> {
            return playerModel9.leftLeg;
        }, playerModel10 -> {
            return playerModel10.leftPants;
        }, 1.0d);
        objectArrayList.add(gA5);
        G gA6 = a(I.LEG, r, resourceLocationA, resourceLocationK, playerModel11 -> {
            return playerModel11.rightLeg;
        }, playerModel12 -> {
            return playerModel12.rightPants;
        }, 1.0d);
        objectArrayList.add(gA6);
        Vector3dc vector3dc = G.a;
        Vector3dc vector3dc2 = G.b;
        boolean zCV = aVar.cV();
        gA2.a(gA, G.c, (Quaterniondc) new Quaterniond());
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (!zCV || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            gA6.a(gA, vector3dc, (Quaterniondc) new Quaterniond().rotateZ(-0.39269908169872414d));
        } else {
            gA6.a(new J(100, 20, 2, (SimpleParticleType) wZ.np.get()));
        }
        if (!zCV || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            gA5.a(gA, vector3dc, (Quaterniondc) new Quaterniond().rotateZ(0.39269908169872414d));
        } else {
            gA5.a(new J(100, 20, 2, (SimpleParticleType) wZ.np.get()));
        }
        if (!zCV || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            gA4.a(gA, vector3dc2, (Quaterniondc) new Quaterniond().rotateZ(-1.5707963705062866d));
        } else {
            gA4.a(new J(100, 20, 2, (SimpleParticleType) wZ.np.get()));
        }
        if (!zCV || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            gA3.a(gA, vector3dc2, (Quaterniondc) new Quaterniond().rotateZ(1.5707963705062866d));
        } else {
            gA3.a(new J(100, 20, 2, (SimpleParticleType) wZ.np.get()));
        }
        gA.a(new J(100, 20, 2, (SimpleParticleType) wZ.np.get()));
        ResourceLocation resourceLocationL = fTVar.l();
        if (resourceLocationL != null) {
            G gA7 = F.a(r, I.BACKPACK, 1.0d, C0134ey.a(this.model.body.storePose(), this.model.crouching), H.a(resourceLocationL, this.a.b.c, C.BASIC), H.a(resourceLocationL, this.a.b.d, C.COSMETIC), H.a(resourceLocationL, this.a.b.a, C.COSMETIC), H.a(resourceLocationL, this.a.b.b, C.COSMETIC));
            if (!zCV || Math.random() < 0.800000011920929d) {
                gA7.a(gA, (Vector3dc) new Vector3d(), (Quaterniondc) new Quaterniond().rotateZ(0.0d));
            }
            objectArrayList.add(gA7);
        }
        return Collections.unmodifiableCollection(objectArrayList);
    }

    private G a(@NotNull I i, @NotNull R r, @NotNull ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, @NotNull Function<PlayerModel<AbstractClientPlayer>, ModelPart> function, @NotNull Function<PlayerModel<AbstractClientPlayer>, ModelPart> function2, double d) {
        ModelPart modelPartApply = function.apply((PlayerModel) this.model);
        if (resourceLocation2 != null) {
            PlayerModel<AbstractClientPlayer> playerModelA = this.a.a();
            return F.a(r, i, d, modelPartApply.storePose(), H.a(resourceLocation, modelPartApply, C.BASIC), H.a(resourceLocation2, function.apply(playerModelA), C.COSMETIC), H.a(resourceLocation2, function2.apply(playerModelA), C.COSMETIC));
        }
        return F.a(r, i, d, modelPartApply.storePose(), H.a(resourceLocation, modelPartApply, C.BASIC), H.a(resourceLocation, function2.apply((PlayerModel) this.model), C.COSMETIC));
    }

    @Override // com.boehmod.blockfront.S
    @NotNull
    public ResourceLocation a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return abstractClientPlayer.getSkin().texture();
    }
}
