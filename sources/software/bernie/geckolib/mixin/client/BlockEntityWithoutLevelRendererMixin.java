package software.bernie.geckolib.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/mixin/client/BlockEntityWithoutLevelRendererMixin.class */
@Mixin({BlockEntityWithoutLevelRenderer.class})
public class BlockEntityWithoutLevelRendererMixin {
    @Inject(method = {"renderByItem"}, at = {@At("HEAD")}, cancellable = true)
    public void geckolib$renderGeckolibItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, CallbackInfo ci) {
        BlockEntityWithoutLevelRenderer geckolibRenderer = GeoRenderProvider.m8006of(stack).getGeoItemRenderer();
        if (geckolibRenderer != null) {
            geckolibRenderer.renderByItem(stack, displayContext, poseStack, bufferSource, packedLight, packedOverlay);
            ci.cancel();
        }
    }
}
