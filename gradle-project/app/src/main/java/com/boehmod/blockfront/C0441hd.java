package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.hd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hd.class */
public final class C0441hd extends PlayerRenderer implements InterfaceC0028Y<AbstractClientPlayer> {

    /* JADX INFO: renamed from: cM */
    public static final ResourceLocation f2795cM;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0419hH f2796a;

    /* JADX INFO: renamed from: cD */
    static final /* synthetic */ boolean f2797cD;

    static {
        f2797cD = !C0441hd.class.desiredAssertionStatus();
        f2795cM = C0532jO.m2378d("textures/models/entities/corpse/burned.png");
    }

    public C0441hd(@NotNull EntityRendererProvider.Context context, boolean z) {
        super(context, z);
        C0270eR c0270eR = new C0270eR(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM : ModelLayers.PLAYER), z);
        this.model = c0270eR;
        this.layers.clear();
        addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM_INNER_ARMOR : ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM_OUTER_ARMOR : ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
        addLayer(new C0418hG(this, context.getItemInHandRenderer()));
        addLayer(new C0417hF(this));
        addLayer(new HumanoidArmorLayer(this, new HumanoidArmorModel(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM_INNER_ARMOR : ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidArmorModel(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM_OUTER_ARMOR : ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
        C0419hH c0419hH = new C0419hH(context, this, c0270eR, z);
        this.f2796a = c0419hH;
        addLayer(c0419hH);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static ResourceLocation m2027a(@NotNull UUID uuid, @Nullable AbstractC0864pc<?, ?> abstractC0864pc, @NotNull String str, @NotNull Set<UUID> set) {
        if (abstractC0864pc == null) {
            return null;
        }
        return abstractC0864pc.mo4168a(uuid, str, set);
    }

    /* JADX INFO: renamed from: a */
    private static void m2028a(@NotNull ModelPart modelPart, @NotNull ModelPart modelPart2) {
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
    public void m2029a(@Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, @Nullable AbstractC0864pc<?, ?> abstractC0864pc, @NotNull AbstractClientPlayer abstractClientPlayer, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, boolean z) {
        ModelPart modelPart = z ? this.model.leftArm : this.model.rightArm;
        ModelPart modelPart2 = z ? this.model.leftSleeve : this.model.rightSleeve;
        C0270eR model = getModel();
        model.setAllVisible(true);
        if (abstractC0863pb != null) {
            this.model.jacket.visible = false;
            this.model.rightPants.visible = false;
            this.model.leftPants.visible = false;
            this.model.rightSleeve.visible = false;
            this.model.leftSleeve.visible = false;
        }
        model.crouching = false;
        model.attackTime = 0.0f;
        model.swimAmount = 0.0f;
        this.model.copyPropertiesTo(this.f2796a.f2688a);
        this.model.copyPropertiesTo(this.f2796a.f2690a);
        m2028a(modelPart, modelPart2);
        VertexConsumer buffer = multiBufferSource.getBuffer(RenderType.entityTranslucent(getTextureLocation(abstractClientPlayer)));
        poseStack.pushPose();
        modelPart.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY);
        modelPart2.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY);
        if (abstractC0863pb != null && abstractC0864pc != null) {
            m2030a(poseStack, multiBufferSource, i, modelPart, modelPart2, abstractC0863pb, abstractC0864pc, abstractClientPlayer);
        }
        poseStack.popPose();
        this.model.jacket.visible = true;
        this.model.rightPants.visible = true;
        this.model.leftPants.visible = true;
        this.model.rightSleeve.visible = true;
        this.model.leftSleeve.visible = true;
    }

    /* JADX INFO: renamed from: a */
    private void m2030a(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull ModelPart modelPart, @NotNull ModelPart modelPart2, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0864pc<?, ?> abstractC0864pc, @NotNull AbstractClientPlayer abstractClientPlayer) {
        UUID uuid = abstractClientPlayer.getUUID();
        int iM4290a = abstractC0863pb.m4034a(uuid).m4290a(C1062tN.f5745i.getKey(), -1);
        if (iM4290a == -1) {
            return;
        }
        boolean z = modelPart.visible;
        boolean z2 = modelPart2.visible;
        modelPart.visible = true;
        modelPart2.visible = true;
        ResourceLocation resourceLocationM2027a = m2027a(uuid, abstractC0864pc, C1093ts.m6016a(iM4290a).getKey(), abstractC0863pb.m4018b().m4245h());
        if (resourceLocationM2027a == null) {
            return;
        }
        VertexConsumer buffer = multiBufferSource.getBuffer(RenderType.entityTranslucent(resourceLocationM2027a));
        modelPart.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY);
        modelPart2.render(poseStack, buffer, i, OverlayTexture.NO_OVERLAY);
        modelPart.visible = z;
        modelPart2.visible = z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public float getShadowRadius(@NotNull AbstractClientPlayer abstractClientPlayer) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2797cD && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (((C0394gj) ((C0396gl) c0623lM2852b.m2855a()).m1150a((Player) abstractClientPlayer)).m1862as() > 0) {
            return 0.0f;
        }
        return super.getShadowRadius(abstractClientPlayer);
    }

    public void render(@NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2797cD && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (((C0394gj) ((C0396gl) c0623lM2852b.m2855a()).m1150a((Player) abstractClientPlayer)).m1862as() > 0 || c0623lM2852b.m2877a(abstractClientPlayer.getUUID())) {
            return;
        }
        Pose pose = abstractClientPlayer.getPose();
        this.model.jacket.visible = false;
        this.model.rightPants.visible = false;
        this.model.leftPants.visible = false;
        this.model.rightSleeve.visible = false;
        this.model.leftSleeve.visible = false;
        super.render(abstractClientPlayer, f, f2, poseStack, multiBufferSource, i);
        if (!this.layers.contains(this.f2796a)) {
            addLayer(this.f2796a);
        }
        abstractClientPlayer.setPose(pose);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull AbstractClientPlayer abstractClientPlayer) {
        if (abstractClientPlayer instanceof C0109bZ) {
            C0109bZ c0109bZ = (C0109bZ) abstractClientPlayer;
            Minecraft minecraft = Minecraft.getInstance();
            C0623l c0623lM2852b = C0623l.m2852b();
            if (f2797cD || c0623lM2852b != null) {
                return C0129bt.m630a(minecraft, c0623lM2852b, c0109bZ.getGameProfile());
            }
            throw new AssertionError("Client mod manager is null!");
        }
        return super.getTextureLocation(abstractClientPlayer);
    }

    @Override // com.boehmod.blockfront.InterfaceC0028Y
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Collection<C0016M> mo167a(@NotNull C0015L c0015l, C1256ww.a aVar, @NotNull AbstractClientPlayer abstractClientPlayer, @NotNull C0027X c0027x) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2797cD && c0623lM2852b == null) {
            throw new AssertionError("Mod manager is null!");
        }
        C0394gj c0394gj = (C0394gj) ((C0396gl) c0623lM2852b.m2855a()).m1150a((Player) abstractClientPlayer);
        ResourceLocation resourceLocationMo168a = aVar.m7109dd() ? f2795cM : mo168a(abstractClientPlayer);
        ResourceLocation resourceLocationM1872l = c0394gj.m1872l();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        C0016M c0016mM2033a = m2033a(EnumC0018O.BODY, c0027x, resourceLocationMo168a, resourceLocationM1872l, playerModel -> {
            return playerModel.body;
        }, playerModel2 -> {
            return playerModel2.jacket;
        }, 1.0d);
        objectArrayList.add(c0016mM2033a);
        C0016M c0016mM2033a2 = m2033a(EnumC0018O.HEAD, c0027x, resourceLocationMo168a, resourceLocationM1872l, playerModel3 -> {
            return playerModel3.head;
        }, playerModel4 -> {
            return playerModel4.hat;
        }, 0.4d);
        objectArrayList.add(c0016mM2033a2);
        C0016M c0016mM2033a3 = m2033a(EnumC0018O.ARM, c0027x, resourceLocationMo168a, resourceLocationM1872l, playerModel5 -> {
            return playerModel5.leftArm;
        }, playerModel6 -> {
            return playerModel6.leftSleeve;
        }, 1.0d);
        objectArrayList.add(c0016mM2033a3);
        C0016M c0016mM2033a4 = m2033a(EnumC0018O.ARM, c0027x, resourceLocationMo168a, resourceLocationM1872l, playerModel7 -> {
            return playerModel7.rightArm;
        }, playerModel8 -> {
            return playerModel8.rightSleeve;
        }, 1.0d);
        objectArrayList.add(c0016mM2033a4);
        C0016M c0016mM2033a5 = m2033a(EnumC0018O.LEG, c0027x, resourceLocationMo168a, resourceLocationM1872l, playerModel9 -> {
            return playerModel9.leftLeg;
        }, playerModel10 -> {
            return playerModel10.leftPants;
        }, 1.0d);
        objectArrayList.add(c0016mM2033a5);
        C0016M c0016mM2033a6 = m2033a(EnumC0018O.LEG, c0027x, resourceLocationMo168a, resourceLocationM1872l, playerModel11 -> {
            return playerModel11.rightLeg;
        }, playerModel12 -> {
            return playerModel12.rightPants;
        }, 1.0d);
        objectArrayList.add(c0016mM2033a6);
        Vector3dc vector3dc = C0016M.f206a;
        Vector3dc vector3dc2 = C0016M.f207b;
        boolean zM7110de = aVar.m7110de();
        c0016mM2033a2.m77a(c0016mM2033a, C0016M.f208c, (Quaterniondc) new Quaterniond());
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (!zM7110de || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0016mM2033a6.m77a(c0016mM2033a, vector3dc, (Quaterniondc) new Quaterniond().rotateZ(-0.39269908169872414d));
        } else {
            c0016mM2033a6.m88a(new C0019P(100, 20, 2, (SimpleParticleType) C1309xw.f7853np.get()));
        }
        if (!zM7110de || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0016mM2033a5.m77a(c0016mM2033a, vector3dc, (Quaterniondc) new Quaterniond().rotateZ(0.39269908169872414d));
        } else {
            c0016mM2033a5.m88a(new C0019P(100, 20, 2, (SimpleParticleType) C1309xw.f7853np.get()));
        }
        if (!zM7110de || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0016mM2033a4.m77a(c0016mM2033a, vector3dc2, (Quaterniondc) new Quaterniond().rotateZ(-1.5707963705062866d));
        } else {
            c0016mM2033a4.m88a(new C0019P(100, 20, 2, (SimpleParticleType) C1309xw.f7853np.get()));
        }
        if (!zM7110de || threadLocalRandomCurrent.nextFloat() < 0.8f) {
            c0016mM2033a3.m77a(c0016mM2033a, vector3dc2, (Quaterniondc) new Quaterniond().rotateZ(1.5707963705062866d));
        } else {
            c0016mM2033a3.m88a(new C0019P(100, 20, 2, (SimpleParticleType) C1309xw.f7853np.get()));
        }
        c0016mM2033a.m88a(new C0019P(100, 20, 2, (SimpleParticleType) C1309xw.f7853np.get()));
        ResourceLocation resourceLocationM1873m = c0394gj.m1873m();
        if (resourceLocationM1873m != null) {
            C0016M c0016mM59a = C0015L.m59a(c0027x, EnumC0018O.BACKPACK, 1.0d, C0264eL.m1497a(this.model.body.storePose(), this.model.crouching), C0017N.m91a(resourceLocationM1873m, this.f2796a.f2689b.f2161c, EnumC0012I.BASIC), C0017N.m91a(resourceLocationM1873m, this.f2796a.f2689b.f2162d, EnumC0012I.COSMETIC), C0017N.m91a(resourceLocationM1873m, this.f2796a.f2689b.f2159a, EnumC0012I.COSMETIC), C0017N.m91a(resourceLocationM1873m, this.f2796a.f2689b.f2160b, EnumC0012I.COSMETIC));
            if (!zM7110de || Math.random() < 0.800000011920929d) {
                c0016mM59a.m77a(c0016mM2033a, (Vector3dc) new Vector3d(), (Quaterniondc) new Quaterniond().rotateZ(0.0d));
            }
            objectArrayList.add(c0016mM59a);
        }
        return Collections.unmodifiableCollection(objectArrayList);
    }

    /* JADX INFO: renamed from: a */
    private C0016M m2033a(@NotNull EnumC0018O enumC0018O, @NotNull C0027X c0027x, @NotNull ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, @NotNull Function<PlayerModel<AbstractClientPlayer>, ModelPart> function, @NotNull Function<PlayerModel<AbstractClientPlayer>, ModelPart> function2, double d) {
        ModelPart modelPartApply = function.apply((PlayerModel) this.model);
        if (resourceLocation2 != null) {
            PlayerModel<AbstractClientPlayer> playerModelM1967a = this.f2796a.m1967a();
            return C0015L.m59a(c0027x, enumC0018O, d, modelPartApply.storePose(), C0017N.m91a(resourceLocation, modelPartApply, EnumC0012I.BASIC), C0017N.m91a(resourceLocation2, function.apply(playerModelM1967a), EnumC0012I.COSMETIC), C0017N.m91a(resourceLocation2, function2.apply(playerModelM1967a), EnumC0012I.COSMETIC));
        }
        return C0015L.m59a(c0027x, enumC0018O, d, modelPartApply.storePose(), C0017N.m91a(resourceLocation, modelPartApply, EnumC0012I.BASIC), C0017N.m91a(resourceLocation, function2.apply((PlayerModel) this.model), EnumC0012I.COSMETIC));
    }

    @Override // com.boehmod.blockfront.InterfaceC0028Y
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation mo168a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return abstractClientPlayer.getSkin().texture();
    }
}
