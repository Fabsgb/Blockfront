package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0712mj;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.client.ClientHooks;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mixin/ClientHooksMixin.class */
@Debug(export = true)
@Mixin({ClientHooks.class})
public class ClientHooksMixin {
    @Inject(method = {"isBlockEntityRendererVisible"}, at = {@At("HEAD")}, cancellable = true)
    private static void bf$preIsBlockEntityRendererVisible(BlockEntityRenderDispatcher blockEntityRenderDispatcher, BlockEntity blockEntity, Frustum frustum, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        BlockEntityRenderer renderer;
        if ((blockEntity instanceof C0712mj) && !((C0712mj) blockEntity).mo3235aw()) {
            callbackInfoReturnable.setReturnValue(false);
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.getEntityRenderDispatcher().shouldRenderHitBoxes() && (renderer = blockEntityRenderDispatcher.getRenderer(blockEntity)) != null) {
            LevelRenderer.renderLineBox(new PoseStack(), minecraft.renderBuffers().bufferSource().getBuffer(RenderType.lines()), renderer.getRenderBoundingBox(blockEntity).move(minecraft.gameRenderer.getMainCamera().getPosition().scale(-1.0d)), 1.0f, 1.0f, 1.0f, 1.0f);
        }
    }
}
