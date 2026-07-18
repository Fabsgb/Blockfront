package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0398go;
import com.boehmod.blockfront.InterfaceC0573kD;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.chunk.SectionCompiler;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/SectionCompilerMixin.class */
@Mixin({SectionCompiler.class})
public class SectionCompilerMixin {
    @WrapOperation(method = {"compile(Lnet/minecraft/core/SectionPos;Lnet/minecraft/client/renderer/chunk/RenderChunkRegion;Lcom/mojang/blaze3d/vertex/VertexSorting;Lnet/minecraft/client/renderer/SectionBufferBuilderPack;Ljava/util/List;)Lnet/minecraft/client/renderer/chunk/SectionCompiler$Results;"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/block/BlockRenderDispatcher;renderBatched(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/BlockAndTintGetter;Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;ZLnet/minecraft/util/RandomSource;Lnet/neoforged/neoforge/client/model/data/ModelData;Lnet/minecraft/client/renderer/RenderType;)V")})
    private void bf$compileModdedBlocks(BlockRenderDispatcher blockRenderDispatcher, BlockState blockState, BlockPos blockPos, BlockAndTintGetter blockAndTintGetter, PoseStack poseStack, VertexConsumer vertexConsumer, boolean z, RandomSource randomSource, ModelData modelData, RenderType renderType, Operation<Void> operation) {
        if (blockState.getBlock() instanceof InterfaceC0573kD) {
            C0398go.m1897a(blockRenderDispatcher, blockState, blockPos, blockAndTintGetter, poseStack, vertexConsumer, z, randomSource, modelData, renderType, operation);
        } else {
            operation.call(new Object[]{blockRenderDispatcher, blockState, blockPos, blockAndTintGetter, poseStack, vertexConsumer, Boolean.valueOf(z), randomSource, modelData, renderType});
        }
    }
}
