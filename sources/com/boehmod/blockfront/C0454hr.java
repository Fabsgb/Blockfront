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

/* JADX INFO: renamed from: com.boehmod.blockfront.hr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hr.class */
public final class C0454hr extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final Map<String, ResourceLocation> f2857l;

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PlayerModel<AbstractClientPlayer> f2858a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C0302ey<AbstractClientPlayer> f2859b;

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C0256eE<AbstractClientPlayer> f2860a;

    /* JADX INFO: renamed from: cD */
    static final /* synthetic */ boolean f2861cD;

    static {
        f2861cD = !C0454hr.class.desiredAssertionStatus();
        f2857l = new Object2ObjectOpenHashMap();
    }

    public C0454hr(@NotNull EntityRendererProvider.Context context, @NotNull RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderLayerParent, @NotNull C0256eE<AbstractClientPlayer> c0256eE, boolean z) {
        super(renderLayerParent);
        this.f2858a = new C0256eE(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM : ModelLayers.PLAYER), z);
        this.f2859b = new C0302ey<>(context.bakeLayer(C0449hm.f2840d));
        this.f2860a = c0256eE;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public PlayerModel<AbstractClientPlayer> m2065a() {
        return this.f2858a;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public static ResourceLocation m2066c(@NotNull String str) {
        return f2857l.computeIfAbsent(str, C0564jv::m2555d);
    }

    /* JADX INFO: renamed from: a */
    private void m2067a(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull EntityModel<AbstractClientPlayer> entityModel, @NotNull ResourceLocation resourceLocation) {
        entityModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(this.f2860a.renderType(resourceLocation)), i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3, float f4, float f5, float f6) {
        if ((abstractClientPlayer instanceof C0099bQ) && ((C0099bQ) abstractClientPlayer).m309r()) {
            return;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2861cD && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0324fT c0324fT = (C0324fT) ((C0326fV) c0622lM2667b.m2670a()).m1133a((Player) abstractClientPlayer);
        if (!abstractClientPlayer.isAlive() || c0324fT.m1087dk()) {
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
        parentModel.copyPropertiesTo(this.f2858a);
        this.f2858a.prepareMobModel(abstractClientPlayer, f, f2, f3);
        this.f2858a.setupAnim(abstractClientPlayer, f, f2, f4, f5, f6);
        C0301ex.m1591a(this.f2858a, parentModel);
        ModelPart modelPart13 = this.f2858a.leftSleeve;
        ModelPart modelPart14 = this.f2858a.leftSleeve;
        this.f2858a.leftSleeve.zScale = 1.0f;
        modelPart14.yScale = 1.0f;
        modelPart13.xScale = 1.0f;
        ModelPart modelPart15 = this.f2858a.rightSleeve;
        ModelPart modelPart16 = this.f2858a.rightSleeve;
        this.f2858a.rightSleeve.zScale = 1.0f;
        modelPart16.yScale = 1.0f;
        modelPart15.xScale = 1.0f;
        ModelPart modelPart17 = this.f2858a.leftPants;
        ModelPart modelPart18 = this.f2858a.leftPants;
        this.f2858a.leftPants.zScale = 1.0f;
        modelPart18.yScale = 1.0f;
        modelPart17.xScale = 1.0f;
        ModelPart modelPart19 = this.f2858a.rightPants;
        ModelPart modelPart20 = this.f2858a.rightPants;
        this.f2858a.rightPants.zScale = 1.0f;
        modelPart20.yScale = 1.0f;
        modelPart19.xScale = 1.0f;
        ModelPart modelPart21 = this.f2858a.jacket;
        ModelPart modelPart22 = this.f2858a.jacket;
        this.f2858a.jacket.zScale = 1.0f;
        modelPart22.yScale = 1.0f;
        modelPart21.xScale = 1.0f;
        this.f2858a.jacket.visible = true;
        ModelPart modelPart23 = this.f2858a.head;
        ModelPart modelPart24 = this.f2858a.head;
        this.f2858a.head.zScale = 1.05f;
        modelPart24.yScale = 1.05f;
        modelPart23.xScale = 1.05f;
        ModelPart modelPart25 = this.f2858a.hat;
        ModelPart modelPart26 = this.f2858a.hat;
        this.f2858a.hat.zScale = 1.03f;
        modelPart26.yScale = 1.03f;
        modelPart25.xScale = 1.03f;
        this.f2859b.f2293cf = this.f2858a.crouching;
        this.f2859b.setupAnim(abstractClientPlayer, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        parentModel.leftSleeve.visible = false;
        parentModel.rightSleeve.visible = false;
        parentModel.jacket.visible = false;
        parentModel.leftPants.visible = false;
        parentModel.rightPants.visible = false;
        ResourceLocation resourceLocationM1662k = c0324fT.m1662k();
        if (resourceLocationM1662k != null) {
            m2067a(poseStack, multiBufferSource, i, this.f2858a, resourceLocationM1662k);
        }
        boolean z = true;
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622lM2667b.m2692a();
        if (abstractC0788oGM2692a != null && !abstractC0788oGM2692a.mo3676a(abstractClientPlayer)) {
            z = false;
        }
        if (!abstractClientPlayer.getItemBySlot(EquipmentSlot.CHEST).isEmpty()) {
            z = false;
        }
        ResourceLocation resourceLocationM1663l = c0324fT.m1663l();
        if (z && resourceLocationM1663l != null) {
            m2067a(poseStack, multiBufferSource, i, this.f2859b, resourceLocationM1663l);
        }
    }
}
