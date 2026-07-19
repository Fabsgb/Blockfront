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

/* JADX INFO: renamed from: com.boehmod.blockfront.hr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hr.class */
public final class C0208hr extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    @NotNull
    private static final Map<String, ResourceLocation> l;

    @NotNull
    public final PlayerModel<AbstractClientPlayer> a;

    @NotNull
    public final C0134ey<AbstractClientPlayer> b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public final eE<AbstractClientPlayer> f167a;
    static final /* synthetic */ boolean cD;

    static {
        cD = !C0208hr.class.desiredAssertionStatus();
        l = new Object2ObjectOpenHashMap();
    }

    public C0208hr(@NotNull EntityRendererProvider.Context context, @NotNull RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderLayerParent, @NotNull eE<AbstractClientPlayer> eEVar, boolean z) {
        super(renderLayerParent);
        this.a = new eE(context.bakeLayer(z ? ModelLayers.PLAYER_SLIM : ModelLayers.PLAYER), z);
        this.b = new C0134ey<>(context.bakeLayer(C0203hm.d));
        this.f167a = eEVar;
    }

    @NotNull
    public PlayerModel<AbstractClientPlayer> a() {
        return this.a;
    }

    @NotNull
    public static ResourceLocation c(@NotNull String str) {
        return l.computeIfAbsent(str, C0265jv::d);
    }

    private void a(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull EntityModel<AbstractClientPlayer> entityModel, @NotNull ResourceLocation resourceLocation) {
        entityModel.renderToBuffer(poseStack, multiBufferSource.getBuffer(this.f167a.renderType(resourceLocation)), i, OverlayTexture.NO_OVERLAY, ColorReferences.COLOR_WHITE_SOLID);
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3, float f4, float f5, float f6) {
        if ((abstractClientPlayer instanceof bQ) && ((bQ) abstractClientPlayer).r()) {
            return;
        }
        C0297l c0297lB = C0297l.b();
        if (!cD && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        fT fTVar = (fT) ((fV) c0297lB.a()).a((Player) abstractClientPlayer);
        if (!abstractClientPlayer.isAlive() || fTVar.dk()) {
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
        parentModel.copyPropertiesTo(this.a);
        this.a.prepareMobModel(abstractClientPlayer, f, f2, f3);
        this.a.setupAnim(abstractClientPlayer, f, f2, f4, f5, f6);
        C0133ex.a(this.a, parentModel);
        ModelPart modelPart13 = this.a.leftSleeve;
        ModelPart modelPart14 = this.a.leftSleeve;
        this.a.leftSleeve.zScale = 1.0f;
        modelPart14.yScale = 1.0f;
        modelPart13.xScale = 1.0f;
        ModelPart modelPart15 = this.a.rightSleeve;
        ModelPart modelPart16 = this.a.rightSleeve;
        this.a.rightSleeve.zScale = 1.0f;
        modelPart16.yScale = 1.0f;
        modelPart15.xScale = 1.0f;
        ModelPart modelPart17 = this.a.leftPants;
        ModelPart modelPart18 = this.a.leftPants;
        this.a.leftPants.zScale = 1.0f;
        modelPart18.yScale = 1.0f;
        modelPart17.xScale = 1.0f;
        ModelPart modelPart19 = this.a.rightPants;
        ModelPart modelPart20 = this.a.rightPants;
        this.a.rightPants.zScale = 1.0f;
        modelPart20.yScale = 1.0f;
        modelPart19.xScale = 1.0f;
        ModelPart modelPart21 = this.a.jacket;
        ModelPart modelPart22 = this.a.jacket;
        this.a.jacket.zScale = 1.0f;
        modelPart22.yScale = 1.0f;
        modelPart21.xScale = 1.0f;
        this.a.jacket.visible = true;
        ModelPart modelPart23 = this.a.head;
        ModelPart modelPart24 = this.a.head;
        this.a.head.zScale = 1.05f;
        modelPart24.yScale = 1.05f;
        modelPart23.xScale = 1.05f;
        ModelPart modelPart25 = this.a.hat;
        ModelPart modelPart26 = this.a.hat;
        this.a.hat.zScale = 1.03f;
        modelPart26.yScale = 1.03f;
        modelPart25.xScale = 1.03f;
        this.b.cf = this.a.crouching;
        this.b.setupAnim(abstractClientPlayer, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        parentModel.leftSleeve.visible = false;
        parentModel.rightSleeve.visible = false;
        parentModel.jacket.visible = false;
        parentModel.leftPants.visible = false;
        parentModel.rightPants.visible = false;
        ResourceLocation resourceLocationK = fTVar.k();
        if (resourceLocationK != null) {
            a(poseStack, multiBufferSource, i, this.a, resourceLocationK);
        }
        boolean z = true;
        oG<?, ?> oGVarM593a = c0297lB.m593a();
        if (oGVarM593a != null && !oGVarM593a.a(abstractClientPlayer)) {
            z = false;
        }
        if (!abstractClientPlayer.getItemBySlot(EquipmentSlot.CHEST).isEmpty()) {
            z = false;
        }
        ResourceLocation resourceLocationL = fTVar.l();
        if (z && resourceLocationL != null) {
            a(poseStack, multiBufferSource, i, this.b, resourceLocationL);
        }
    }
}
