package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hH.class */
public final class C0419hH extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final Map<String, ResourceLocation> f2687l;

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PlayerModel<AbstractClientPlayer> f2688a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C0264eL<AbstractClientPlayer> f2689b;

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C0270eR<AbstractClientPlayer> f2690a;

    /* JADX INFO: renamed from: cM */
    static final /* synthetic */ boolean f2691cM;

    static {
        f2691cM = !C0419hH.class.desiredAssertionStatus();
        f2687l = new Object2ObjectOpenHashMap();
    }

    public C0419hH(@NotNull EntityRendererProvider.Context context, @NotNull RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderLayerParent, @NotNull C0270eR<AbstractClientPlayer> c0270eR, boolean z) {
        super(renderLayerParent);
        this.f2688a = new C0270eR(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM : ModelLayers.PLAYER), z);
        this.f2689b = new C0264eL<>(context.bakeLayer(C0414hC.f2669d));
        this.f2690a = c0270eR;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public PlayerModel<AbstractClientPlayer> m1967a() {
        return this.f2688a;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public static ResourceLocation m1968c(@NotNull String str) {
        return f2687l.computeIfAbsent(str, C0532jO::m2378d);
    }

    /* JADX INFO: renamed from: a */
    private void m1969a(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull EntityModel<AbstractClientPlayer> entityModel, @NotNull ResourceLocation resourceLocation) {
        entityModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(this.f2690a.renderType(resourceLocation)), i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3, float f4, float f5, float f6) {
        if ((abstractClientPlayer instanceof C0109bZ) && ((C0109bZ) abstractClientPlayer).m414s()) {
            return;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2691cM && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0394gj c0394gj = (C0394gj) ((C0396gl) c0623lM2852b.m2855a()).m1150a((Player) abstractClientPlayer);
        if (!abstractClientPlayer.isAlive() || c0394gj.m1104dt()) {
            return;
        }
        PlayerModel parentModel = getParentModel();
        ModelPart modelPart = parentModel.leftSleeve;
        ModelPart modelPart2 = parentModel.leftSleeve;
        parentModel.leftSleeve.zScale = 1.0f;
        modelPart2.yScale = 1.0f;
        modelPart.xScale = 1.0f;
        ModelPart modelPart3 = parentModel.rightSleeve;
        ModelPart modelPart4 = parentModel.rightSleeve;
        parentModel.rightSleeve.zScale = 1.0f;
        modelPart4.yScale = 1.0f;
        modelPart3.xScale = 1.0f;
        ModelPart modelPart5 = parentModel.leftPants;
        ModelPart modelPart6 = parentModel.leftPants;
        parentModel.leftPants.zScale = 1.0f;
        modelPart6.yScale = 1.0f;
        modelPart5.xScale = 1.0f;
        ModelPart modelPart7 = parentModel.rightPants;
        ModelPart modelPart8 = parentModel.rightPants;
        parentModel.rightPants.zScale = 1.0f;
        modelPart8.yScale = 1.0f;
        modelPart7.xScale = 1.0f;
        ModelPart modelPart9 = parentModel.jacket;
        ModelPart modelPart10 = parentModel.jacket;
        parentModel.jacket.zScale = 1.0f;
        modelPart10.yScale = 1.0f;
        modelPart9.xScale = 1.0f;
        ModelPart modelPart11 = parentModel.hat;
        ModelPart modelPart12 = parentModel.hat;
        parentModel.hat.zScale = 1.0f;
        modelPart12.yScale = 1.0f;
        modelPart11.xScale = 1.0f;
        parentModel.copyPropertiesTo(this.f2688a);
        this.f2688a.prepareMobModel(abstractClientPlayer, f, f2, f3);
        this.f2688a.setupAnim(abstractClientPlayer, f, f2, f4, f5, f6);
        C0263eK.m1495a(this.f2688a, parentModel);
        ModelPart modelPart13 = this.f2688a.leftSleeve;
        ModelPart modelPart14 = this.f2688a.leftSleeve;
        this.f2688a.leftSleeve.zScale = 1.0f;
        modelPart14.yScale = 1.0f;
        modelPart13.xScale = 1.0f;
        ModelPart modelPart15 = this.f2688a.rightSleeve;
        ModelPart modelPart16 = this.f2688a.rightSleeve;
        this.f2688a.rightSleeve.zScale = 1.0f;
        modelPart16.yScale = 1.0f;
        modelPart15.xScale = 1.0f;
        ModelPart modelPart17 = this.f2688a.leftPants;
        ModelPart modelPart18 = this.f2688a.leftPants;
        this.f2688a.leftPants.zScale = 1.0f;
        modelPart18.yScale = 1.0f;
        modelPart17.xScale = 1.0f;
        ModelPart modelPart19 = this.f2688a.rightPants;
        ModelPart modelPart20 = this.f2688a.rightPants;
        this.f2688a.rightPants.zScale = 1.0f;
        modelPart20.yScale = 1.0f;
        modelPart19.xScale = 1.0f;
        ModelPart modelPart21 = this.f2688a.jacket;
        ModelPart modelPart22 = this.f2688a.jacket;
        this.f2688a.jacket.zScale = 1.0f;
        modelPart22.yScale = 1.0f;
        modelPart21.xScale = 1.0f;
        this.f2688a.jacket.visible = true;
        ModelPart modelPart23 = this.f2688a.head;
        ModelPart modelPart24 = this.f2688a.head;
        this.f2688a.head.zScale = 1.05f;
        modelPart24.yScale = 1.05f;
        modelPart23.xScale = 1.05f;
        ModelPart modelPart25 = this.f2688a.hat;
        ModelPart modelPart26 = this.f2688a.hat;
        this.f2688a.hat.zScale = 1.03f;
        modelPart26.yScale = 1.03f;
        modelPart25.xScale = 1.03f;
        this.f2689b.f2163cn = this.f2688a.crouching;
        this.f2689b.setupAnim(abstractClientPlayer, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        parentModel.leftSleeve.visible = false;
        parentModel.rightSleeve.visible = false;
        parentModel.jacket.visible = false;
        parentModel.leftPants.visible = false;
        parentModel.rightPants.visible = false;
        ResourceLocation resourceLocationM1872l = c0394gj.m1872l();
        if (resourceLocationM1872l != null) {
            m1969a(poseStack, multiBufferSource, i, this.f2688a, resourceLocationM1872l);
        }
        boolean z = true;
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623lM2852b.m2878a();
        if (abstractC0864pcM2878a != null && !abstractC0864pcM2878a.mo4112a(abstractClientPlayer)) {
            z = false;
        }
        if (!abstractClientPlayer.getItemBySlot(EquipmentSlot.CHEST).isEmpty()) {
            z = false;
        }
        ResourceLocation resourceLocationM1873m = c0394gj.m1873m();
        if (z && resourceLocationM1873m != null) {
            m1969a(poseStack, multiBufferSource, i, this.f2689b, resourceLocationM1873m);
        }
    }
}
