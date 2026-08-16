package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.ChunkRenderTypeSet;
import net.neoforged.neoforge.client.event.AddSectionGeometryEvent;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2d;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.constant.dataticket.DataTicket;

/* JADX INFO: renamed from: com.boehmod.blockfront.gE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gE.class */
public class C0363gE {
    /* JADX INFO: renamed from: b */
    public static void m1751b(@NotNull AddSectionGeometryEvent addSectionGeometryEvent) {
        BlockPos sectionOrigin = addSectionGeometryEvent.getSectionOrigin();
        ObjectArrayList objectArrayList = null;
        for (Map.Entry entry : addSectionGeometryEvent.getLevel().getChunkAt(sectionOrigin).getBlockEntities().entrySet()) {
            BlockPos blockPos = (BlockPos) entry.getKey();
            if (blockPos.getY() >= sectionOrigin.getY() && blockPos.getY() < sectionOrigin.getY() + 16 && (((BlockEntity) entry.getValue()).getBlockState().getBlock() instanceof InterfaceC0596kZ)) {
                if (objectArrayList == null) {
                    objectArrayList = new ObjectArrayList();
                }
                objectArrayList.add(blockPos.immutable());
            }
        }
        if (objectArrayList == null) {
            return;
        }
        ObjectArrayList objectArrayList2 = objectArrayList;
        addSectionGeometryEvent.addRenderer(sectionRenderingContext -> {
            m1752a((List<BlockPos>) objectArrayList2, sectionRenderingContext);
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static void m1752a(@NotNull List<BlockPos> list, @NotNull AddSectionGeometryEvent.SectionRenderingContext sectionRenderingContext) {
        Iterator<BlockPos> it = list.iterator();
        while (it.hasNext()) {
            try {
                m1753a(it.next(), sectionRenderingContext);
            } catch (RuntimeException e) {
                C0530jM.m2338a("Failed to compile baked entity block", e, new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1753a(@NotNull BlockPos blockPos, @NotNull AddSectionGeometryEvent.SectionRenderingContext sectionRenderingContext) {
        BlockAndTintGetter region = sectionRenderingContext.getRegion();
        GeoAnimatable blockEntity = region.getBlockEntity(blockPos);
        if (blockEntity == null || blockEntity.isRemoved()) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) {
            return;
        }
        BlockEntityRenderer renderer = minecraft.getBlockEntityRenderDispatcher().getRenderer(blockEntity);
        if (renderer instanceof AbstractC0367gI) {
            AbstractC0367gI abstractC0367gI = (AbstractC0367gI) renderer;
            if (abstractC0367gI.mo1744a(blockEntity)) {
                C0275eW c0275eW = (C0275eW) abstractC0367gI.getGeoModel();
                GeoAnimatable geoAnimatable = (BlockEntity) blockEntity;
                TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite) minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(c0275eW.mo1521a(geoAnimatable));
                BlockState blockState = blockEntity.getBlockState();
                ChunkRenderTypeSet renderTypes = minecraft.getBlockRenderer().getBlockModel(blockState).getRenderTypes(blockState, RandomSource.create(blockState.getSeed(blockPos)), ModelData.EMPTY);
                VertexConsumer orCreateChunkBuffer = sectionRenderingContext.getOrCreateChunkBuffer(renderTypes.isEmpty() ? RenderType.cutout() : (RenderType) renderTypes.asList().getFirst());
                PoseStack poseStack = sectionRenderingContext.getPoseStack();
                poseStack.pushPose();
                poseStack.translate(SectionPos.sectionRelative(blockPos.getX()), SectionPos.sectionRelative(blockPos.getY()), SectionPos.sectionRelative(blockPos.getZ()));
                if (blockEntity instanceof C0712mj) {
                    float fMo3246al = ((C0712mj) blockEntity).mo3246al();
                    if (fMo3246al != 0.0f) {
                        poseStack.translate(0.5f, 0.5f, 0.5f);
                        poseStack.mulPose(Axis.YP.rotationDegrees(fMo3246al));
                        poseStack.translate(-0.5f, -0.5f, -0.5f);
                    }
                }
                Vector2d vector2d = new Vector2d(textureAtlasSprite.getU0(), textureAtlasSprite.getV0());
                Vector2d vector2d2 = new Vector2d(textureAtlasSprite.getU1(), textureAtlasSprite.getV1());
                long instanceId = abstractC0367gI.getInstanceId(blockEntity);
                C0370gL c0370gL = new C0370gL(minecraft.level, orCreateChunkBuffer, vector2d, vector2d2);
                int lightColor = LevelRenderer.getLightColor(region, blockPos.above());
                AnimationState animationState = new AnimationState(geoAnimatable, 0.0f, 0.0f, 1.0f, false);
                animationState.setData(DataTickets.TICK, Double.valueOf(geoAnimatable.getTick(geoAnimatable)));
                animationState.setData(DataTickets.BLOCK_ENTITY, geoAnimatable);
                try {
                    synchronized (c0275eW.m1527a()) {
                        try {
                            c0275eW.addAdditionalStateData(geoAnimatable, instanceId, (obj, obj2) -> {
                                animationState.setData((DataTicket) obj, obj2);
                            });
                            c0275eW.getBakedModel(c0275eW.getModelResource(geoAnimatable, abstractC0367gI));
                            c0275eW.handleAnimations(geoAnimatable, instanceId, animationState, 1.0f);
                            abstractC0367gI.defaultRender(poseStack, geoAnimatable, minecraft.renderBuffers().bufferSource(), null, c0370gL, 0.0f, 1.0f, lightColor);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    poseStack.popPose();
                } catch (Throwable th2) {
                    poseStack.popPose();
                    throw th2;
                }
            }
        }
    }
}
