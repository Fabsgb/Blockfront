package com.boehmod.blockfront;

import com.boehmod.blockfront.C1176vW;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.gN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gN.class */
public final class C0371gN extends PlayerRenderer implements InterfaceC0021S<AbstractClientPlayer> {

    /* JADX INFO: renamed from: cM */
    public static final ResourceLocation f2457cM;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0454hr f2458a;

    /* JADX INFO: renamed from: cu */
    static final /* synthetic */ boolean f2459cu;

    static {
        f2459cu = !C0371gN.class.desiredAssertionStatus();
        f2457cM = C0564jv.m2555d("textures/models/entities/corpse/burned.png");
    }

    public C0371gN(@NotNull EntityRendererProvider.Context context, boolean z) {
        super(context, z);
        C0256eE c0256eE = new C0256eE(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM : ModelLayers.PLAYER), z);
        this.model = c0256eE;
        this.layers.clear();
        addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM_INNER_ARMOR : ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM_OUTER_ARMOR : ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
        addLayer(new C0453hq(this, context.getItemInHandRenderer()));
        addLayer(new C0452hp(this));
        addLayer(new HumanoidArmorLayer(this, new HumanoidArmorModel(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM_INNER_ARMOR : ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidArmorModel(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM_OUTER_ARMOR : ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
        C0454hr c0454hr = new C0454hr(context, this, c0256eE, z);
        this.f2458a = c0454hr;
        addLayer(c0454hr);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static ResourceLocation m1771a(@NotNull UUID uuid, @Nullable AbstractC0788oG<?, ?> abstractC0788oG, @NotNull String str, @NotNull Set<UUID> set) {
        if (abstractC0788oG == null) {
            return null;
        }
        return abstractC0788oG.mo3732a(uuid, str, set);
    }

    /* JADX INFO: renamed from: a */
    private static void m1772a(@NotNull ModelPart modelPart, @NotNull ModelPart modelPart2) {
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

    /* JADX INFO: renamed from: a */
    public void m1773a(@Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, @Nullable AbstractC0788oG<?, ?> abstractC0788oG, @NotNull AbstractClientPlayer abstractClientPlayer, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, boolean z) {
        ModelPart modelPart = z ? this.model.leftArm : this.model.rightArm;
        ModelPart modelPart2 = z ? this.model.leftSleeve : this.model.rightSleeve;
        C0256eE model = getModel();
        model.setAllVisible(true);
        if (abstractC0787oF != null) {
            this.model.jacket.visible = false;
            this.model.rightPants.visible = false;
            this.model.leftPants.visible = false;
            this.model.rightSleeve.visible = false;
            this.model.leftSleeve.visible = false;
        }
        model.crouching = false;
        model.attackTime = 0.0f;
        model.swimAmount = 0.0f;
        this.model.copyPropertiesTo(this.f2458a.f2858a);
        this.model.copyPropertiesTo(this.f2458a.f2860a);
        m1772a(modelPart, modelPart2);
        VertexConsumer buffer = multiBufferSource.getBuffer(RenderType.entityTranslucent(getTextureLocation(abstractClientPlayer)));
        poseStack.pushPose();
        modelPart.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY);
        modelPart2.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY);
        if (abstractC0787oF != null && abstractC0788oG != null) {
            m1774a(poseStack, multiBufferSource, i, modelPart, modelPart2, abstractC0787oF, abstractC0788oG, abstractClientPlayer);
        }
        poseStack.popPose();
        this.model.jacket.visible = true;
        this.model.rightPants.visible = true;
        this.model.leftPants.visible = true;
        this.model.rightSleeve.visible = true;
        this.model.leftSleeve.visible = true;
    }

    /* JADX INFO: renamed from: a */
    private void m1774a(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull ModelPart modelPart, @NotNull ModelPart modelPart2, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0788oG<?, ?> abstractC0788oG, @NotNull AbstractClientPlayer abstractClientPlayer) {
        UUID uuid = abstractClientPlayer.getUUID();
        int iM3854a = abstractC0787oF.m3598a(uuid).m3854a(C1089tp.f5692i.getKey(), -1);
        if (iM3854a == -1) {
            return;
        }
        boolean z = modelPart.visible;
        boolean z2 = modelPart2.visible;
        modelPart.visible = true;
        modelPart2.visible = true;
        ResourceLocation resourceLocationM1771a = m1771a(uuid, abstractC0788oG, C1015sV.m5528a(iM3854a).getKey(), abstractC0787oF.m3582b().m3809h());
        if (resourceLocationM1771a == null) {
            return;
        }
        VertexConsumer buffer = multiBufferSource.getBuffer(RenderType.entityTranslucent(resourceLocationM1771a));
        modelPart.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY);
        modelPart2.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY);
        modelPart.visible = z;
        modelPart2.visible = z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public float getShadowRadius(@NotNull AbstractClientPlayer abstractClientPlayer) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2459cu && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (((C0324fT) ((C0326fV) c0622lM2667b.m2670a()).m1133a((Player) abstractClientPlayer)).m1652ag() > 0) {
            return 0.0f;
        }
        return super.getShadowRadius(abstractClientPlayer);
    }

    public void render(@NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2459cu && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (((C0324fT) ((C0326fV) c0622lM2667b.m2670a()).m1133a((Player) abstractClientPlayer)).m1652ag() > 0 || c0622lM2667b.m2691a(abstractClientPlayer.getUUID())) {
            return;
        }
        Pose pose = abstractClientPlayer.getPose();
        this.model.jacket.visible = false;
        this.model.rightPants.visible = false;
        this.model.leftPants.visible = false;
        this.model.rightSleeve.visible = false;
        this.model.leftSleeve.visible = false;
        super.render(abstractClientPlayer, f, f2, poseStack, multiBufferSource, i);
        if (!this.layers.contains(this.f2458a)) {
            addLayer(this.f2458a);
        }
        abstractClientPlayer.setPose(pose);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull AbstractClientPlayer abstractClientPlayer) {
        if (abstractClientPlayer instanceof C0099bQ) {
            C0099bQ c0099bQ = (C0099bQ) abstractClientPlayer;
            Minecraft minecraft = Minecraft.getInstance();
            C0622l c0622lM2667b = C0622l.m2667b();
            if (f2459cu || c0622lM2667b != null) {
                return C0119bk.m528a(minecraft, c0622lM2667b, c0099bQ.getGameProfile());
            }
            throw new AssertionError("Client mod manager is null!");
        }
        return super.getTextureLocation(abstractClientPlayer);
    }

    @Override // com.boehmod.blockfront.InterfaceC0021S
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Collection<C0009G> mo134a(@NotNull C0008F c0008f, C1176vW.a aVar, @NotNull AbstractClientPlayer abstractClientPlayer, @NotNull C0020R c0020r) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2459cu && c0622lM2667b == null) {
            throw new AssertionError("Mod manager is null!");
        }
        C0324fT c0324fT = (C0324fT) ((C0326fV) c0622lM2667b.m2670a()).m1133a((Player) abstractClientPlayer);
        ResourceLocation resourceLocationMo135a = aVar.m6583cU() ? f2457cM : mo135a(abstractClientPlayer);
        ResourceLocation resourceLocationM1662k = c0324fT.m1662k();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        C0009G c0009gM1777a = m1777a(EnumC0011I.BODY, c0020r, resourceLocationMo135a, resourceLocationM1662k, playerModel -> {
            return playerModel.body;
        }, playerModel2 -> {
            return playerModel2.jacket;
        }, 1.0d);
        objectArrayList.add(c0009gM1777a);
        C0009G c0009gM1777a2 = m1777a(EnumC0011I.HEAD, c0020r, resourceLocationMo135a, resourceLocationM1662k, playerModel3 -> {
            return playerModel3.head;
        }, playerModel4 -> {
            return playerModel4.hat;
        }, 0.4d);
        objectArrayList.add(c0009gM1777a2);
        C0009G c0009gM1777a3 = m1777a(EnumC0011I.ARM, c0020r, resourceLocationMo135a, resourceLocationM1662k, playerModel5 -> {
            return playerModel5.leftArm;
        }, playerModel6 -> {
            return playerModel6.leftSleeve;
        }, 1.0d);
        objectArrayList.add(c0009gM1777a3);
        C0009G c0009gM1777a4 = m1777a(EnumC0011I.ARM, c0020r, resourceLocationMo135a, resourceLocationM1662k, playerModel7 -> {
            return playerModel7.rightArm;
        }, playerModel8 -> {
            return playerModel8.rightSleeve;
        }, 1.0d);
        objectArrayList.add(c0009gM1777a4);
        C0009G c0009gM1777a5 = m1777a(EnumC0011I.LEG, c0020r, resourceLocationMo135a, resourceLocationM1662k, playerModel9 -> {
            return playerModel9.leftLeg;
        }, playerModel10 -> {
            return playerModel10.leftPants;
        }, 1.0d);
        objectArrayList.add(c0009gM1777a5);
        C0009G c0009gM1777a6 = m1777a(EnumC0011I.LEG, c0020r, resourceLocationMo135a, resourceLocationM1662k, playerModel11 -> {
            return playerModel11.rightLeg;
        }, playerModel12 -> {
            return playerModel12.rightPants;
        }, 1.0d);
        objectArrayList.add(c0009gM1777a6);
        Vector3dc vector3dc = C0009G.f166a;
        Vector3dc vector3dc2 = C0009G.f167b;
        boolean zM6584cV = aVar.m6584cV();
        c0009gM1777a2.m44a(c0009gM1777a, C0009G.f168c, (Quaterniondc) new Quaterniond());
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (!zM6584cV || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0009gM1777a6.m44a(c0009gM1777a, vector3dc, (Quaterniondc) new Quaterniond().rotateZ(-0.39269908169872414d));
        } else {
            c0009gM1777a6.m55a(new C0012J(100, 20, 2, (SimpleParticleType) C1232wZ.f7288np.get()));
        }
        if (!zM6584cV || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0009gM1777a5.m44a(c0009gM1777a, vector3dc, (Quaterniondc) new Quaterniond().rotateZ(0.39269908169872414d));
        } else {
            c0009gM1777a5.m55a(new C0012J(100, 20, 2, (SimpleParticleType) C1232wZ.f7288np.get()));
        }
        if (!zM6584cV || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0009gM1777a4.m44a(c0009gM1777a, vector3dc2, (Quaterniondc) new Quaterniond().rotateZ(-1.5707963705062866d));
        } else {
            c0009gM1777a4.m55a(new C0012J(100, 20, 2, (SimpleParticleType) C1232wZ.f7288np.get()));
        }
        if (!zM6584cV || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0009gM1777a3.m44a(c0009gM1777a, vector3dc2, (Quaterniondc) new Quaterniond().rotateZ(1.5707963705062866d));
        } else {
            c0009gM1777a3.m55a(new C0012J(100, 20, 2, (SimpleParticleType) C1232wZ.f7288np.get()));
        }
        c0009gM1777a.m55a(new C0012J(100, 20, 2, (SimpleParticleType) C1232wZ.f7288np.get()));
        ResourceLocation resourceLocationM1663l = c0324fT.m1663l();
        if (resourceLocationM1663l != null) {
            C0009G c0009gM27a = C0008F.m27a(c0020r, EnumC0011I.BACKPACK, 1.0d, C0302ey.m1593a(this.model.body.storePose(), this.model.crouching), C0010H.m58a(resourceLocationM1663l, this.f2458a.f2859b.f2291c, EnumC0005C.BASIC), C0010H.m58a(resourceLocationM1663l, this.f2458a.f2859b.f2292d, EnumC0005C.COSMETIC), C0010H.m58a(resourceLocationM1663l, this.f2458a.f2859b.f2289a, EnumC0005C.COSMETIC), C0010H.m58a(resourceLocationM1663l, this.f2458a.f2859b.f2290b, EnumC0005C.COSMETIC));
            if (!zM6584cV || Math.random() < 0.800000011920929d) {
                c0009gM27a.m44a(c0009gM1777a, (Vector3dc) new Vector3d(), (Quaterniondc) new Quaterniond().rotateZ(0.0d));
            }
            objectArrayList.add(c0009gM27a);
        }
        return Collections.unmodifiableCollection(objectArrayList);
    }

    /* JADX INFO: renamed from: a */
    private C0009G m1777a(@NotNull EnumC0011I enumC0011I, @NotNull C0020R c0020r, @NotNull ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, @NotNull Function<PlayerModel<AbstractClientPlayer>, ModelPart> function, @NotNull Function<PlayerModel<AbstractClientPlayer>, ModelPart> function2, double d) {
        ModelPart modelPartApply = function.apply((PlayerModel) this.model);
        if (resourceLocation2 != null) {
            PlayerModel<AbstractClientPlayer> playerModelM2065a = this.f2458a.m2065a();
            return C0008F.m27a(c0020r, enumC0011I, d, modelPartApply.storePose(), C0010H.m58a(resourceLocation, modelPartApply, EnumC0005C.BASIC), C0010H.m58a(resourceLocation2, function.apply(playerModelM2065a), EnumC0005C.COSMETIC), C0010H.m58a(resourceLocation2, function2.apply(playerModelM2065a), EnumC0005C.COSMETIC));
        }
        return C0008F.m27a(c0020r, enumC0011I, d, modelPartApply.storePose(), C0010H.m58a(resourceLocation, modelPartApply, EnumC0005C.BASIC), C0010H.m58a(resourceLocation, function2.apply((PlayerModel) this.model), EnumC0005C.COSMETIC));
    }

    @Override // com.boehmod.blockfront.InterfaceC0021S
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation mo135a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return abstractClientPlayer.getSkin().texture();
    }
}
