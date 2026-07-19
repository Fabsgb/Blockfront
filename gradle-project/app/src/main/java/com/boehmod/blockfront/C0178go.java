package com.boehmod.blockfront;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2d;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.constant.dataticket.DataTicket;

/* JADX INFO: renamed from: com.boehmod.blockfront.go, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/go.class */
public class C0178go {
    public static boolean a(@NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull BlockState blockState, @NotNull BlockPos blockPos, @NotNull BlockAndTintGetter blockAndTintGetter, @NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, boolean z, @NotNull RandomSource randomSource, @NotNull ModelData modelData, @NotNull RenderType renderType, @NotNull Operation<Void> operation) {
        GeoAnimatable blockEntity = blockAndTintGetter.getBlockEntity(blockPos);
        if (blockEntity == null || blockEntity.isRemoved()) {
            operation.call(new Object[]{blockRenderDispatcher, blockState, blockPos, blockAndTintGetter, poseStack, vertexConsumer, Boolean.valueOf(z), randomSource, modelData, renderType});
            return false;
        }
        Minecraft minecraft = Minecraft.getInstance();
        BlockEntityRenderer renderer = minecraft.getBlockEntityRenderDispatcher().getRenderer(blockEntity);
        if (!(renderer instanceof AbstractC0182gs)) {
            operation.call(new Object[]{blockRenderDispatcher, blockState, blockPos, blockAndTintGetter, poseStack, vertexConsumer, Boolean.valueOf(z), randomSource, modelData, renderType});
            return false;
        }
        AbstractC0182gs abstractC0182gs = (AbstractC0182gs) renderer;
        if (!abstractC0182gs.a(blockEntity)) {
            if (abstractC0182gs.R()) {
                operation.call(new Object[]{blockRenderDispatcher, blockState, blockPos, blockAndTintGetter, poseStack, vertexConsumer, Boolean.valueOf(z), randomSource, modelData, renderType});
                return false;
            }
            return false;
        }
        if (minecraft.level == null) {
            return false;
        }
        eJ eJVar = (eJ) abstractC0182gs.getGeoModel();
        GeoAnimatable geoAnimatable = (BlockEntity) blockEntity;
        TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite) minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(eJVar.a(geoAnimatable));
        PoseStack poseStack2 = new PoseStack();
        poseStack2.translate(SectionPos.sectionRelative(blockPos.getX()), SectionPos.sectionRelative(blockPos.getY()), SectionPos.sectionRelative(blockPos.getZ()));
        if (blockEntity instanceof lN) {
            float fAf = ((lN) blockEntity).af();
            if (fAf != 0.0f) {
                poseStack2.translate(0.5f, 0.5f, 0.5f);
                poseStack2.mulPose(Axis.YP.rotationDegrees(fAf));
                poseStack2.translate(-0.5f, -0.5f, -0.5f);
            }
        }
        Vector2d vector2d = new Vector2d(textureAtlasSprite.getU0(), textureAtlasSprite.getV0());
        Vector2d vector2d2 = new Vector2d(textureAtlasSprite.getU1(), textureAtlasSprite.getV1());
        long instanceId = abstractC0182gs.getInstanceId(blockEntity);
        C0185gv c0185gv = new C0185gv(minecraft.level, vertexConsumer, vector2d, vector2d2);
        int lightColor = LevelRenderer.getLightColor(blockAndTintGetter, blockPos.above());
        AnimationState animationState = new AnimationState(geoAnimatable, 0.0f, 0.0f, 1.0f, false);
        animationState.setData(DataTickets.TICK, Double.valueOf(geoAnimatable.getTick(geoAnimatable)));
        animationState.setData(DataTickets.BLOCK_ENTITY, geoAnimatable);
        try {
            synchronized (eJVar.a()) {
                eJVar.addAdditionalStateData(geoAnimatable, instanceId, (obj, obj2) -> {
                    animationState.setData((DataTicket) obj, obj2);
                });
                eJVar.getBakedModel(eJVar.getModelResource(geoAnimatable, abstractC0182gs));
                eJVar.handleAnimations(geoAnimatable, instanceId, animationState, 1.0f);
                abstractC0182gs.defaultRender(poseStack2, geoAnimatable, minecraft.renderBuffers().bufferSource(), null, c0185gv, 0.0f, 1.0f, lightColor);
            }
            if (minecraft.player != null && minecraft.player.isCreative()) {
                operation.call(new Object[]{blockRenderDispatcher, blockState, blockPos, blockAndTintGetter, poseStack, vertexConsumer, Boolean.valueOf(z), randomSource, modelData, renderType});
                return true;
            }
            return true;
        } catch (RuntimeException e) {
            C0263jt.a("Failed to compile baked entity block", e, new Object[0]);
            return false;
        }
    }
}
