package software.bernie.geckolib.event;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.neoforged.neoforge.common.NeoForge;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.event.GeoRenderEvent;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.GeoObjectRenderer;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;
import software.bernie.geckolib.service.GeckoLibEvents;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/event/GeckoLibEventsNeoForge.class */
public class GeckoLibEventsNeoForge implements GeckoLibEvents {
    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public void fireCompileBlockRenderLayers(GeoBlockRenderer<?> renderer) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.Block.CompileRenderLayers(renderer));
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public boolean fireBlockPreRender(GeoBlockRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return !((GeoRenderEvent.Block.Pre) NeoForge.EVENT_BUS.post(new GeoRenderEvent.Block.Pre(renderer, poseStack, model, bufferSource, partialTick, packedLight))).isCanceled();
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public void fireBlockPostRender(GeoBlockRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.Block.Post(renderer, poseStack, model, bufferSource, partialTick, packedLight));
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public void fireCompileArmorRenderLayers(GeoArmorRenderer<?> renderer) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.Armor.CompileRenderLayers(renderer));
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public boolean fireArmorPreRender(GeoArmorRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return !((GeoRenderEvent.Armor.Pre) NeoForge.EVENT_BUS.post(new GeoRenderEvent.Armor.Pre(renderer, poseStack, model, bufferSource, partialTick, packedLight))).isCanceled();
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public void fireArmorPostRender(GeoArmorRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.Armor.Post(renderer, poseStack, model, bufferSource, partialTick, packedLight));
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public void fireCompileEntityRenderLayers(GeoEntityRenderer<?> renderer) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.Entity.CompileRenderLayers(renderer));
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public boolean fireEntityPreRender(GeoEntityRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return !((GeoRenderEvent.Entity.Pre) NeoForge.EVENT_BUS.post(new GeoRenderEvent.Entity.Pre(renderer, poseStack, model, bufferSource, partialTick, packedLight))).isCanceled();
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public void fireEntityPostRender(GeoEntityRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.Entity.Post(renderer, poseStack, model, bufferSource, partialTick, packedLight));
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public void fireCompileReplacedEntityRenderLayers(GeoReplacedEntityRenderer<?, ?> renderer) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.ReplacedEntity.CompileRenderLayers(renderer));
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public boolean fireReplacedEntityPreRender(GeoReplacedEntityRenderer<?, ?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return !((GeoRenderEvent.ReplacedEntity.Pre) NeoForge.EVENT_BUS.post(new GeoRenderEvent.ReplacedEntity.Pre(renderer, poseStack, model, bufferSource, partialTick, packedLight))).isCanceled();
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public void fireReplacedEntityPostRender(GeoReplacedEntityRenderer<?, ?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.ReplacedEntity.Post(renderer, poseStack, model, bufferSource, partialTick, packedLight));
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public void fireCompileItemRenderLayers(GeoItemRenderer<?> renderer) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.Item.CompileRenderLayers(renderer));
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public boolean fireItemPreRender(GeoItemRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return !((GeoRenderEvent.Item.Pre) NeoForge.EVENT_BUS.post(new GeoRenderEvent.Item.Pre(renderer, poseStack, model, bufferSource, partialTick, packedLight))).isCanceled();
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public void fireItemPostRender(GeoItemRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.Item.Post(renderer, poseStack, model, bufferSource, partialTick, packedLight));
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public void fireCompileObjectRenderLayers(GeoObjectRenderer<?> renderer) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.Object.CompileRenderLayers(renderer));
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public boolean fireObjectPreRender(GeoObjectRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return !((GeoRenderEvent.Object.Pre) NeoForge.EVENT_BUS.post(new GeoRenderEvent.Object.Pre(renderer, poseStack, model, bufferSource, partialTick, packedLight))).isCanceled();
    }

    @Override // software.bernie.geckolib.service.GeckoLibEvents
    public void fireObjectPostRender(GeoObjectRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.Object.Post(renderer, poseStack, model, bufferSource, partialTick, packedLight));
    }
}
