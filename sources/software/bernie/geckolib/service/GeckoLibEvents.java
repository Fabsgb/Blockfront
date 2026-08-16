package software.bernie.geckolib.service;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.GeoObjectRenderer;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/service/GeckoLibEvents.class */
public interface GeckoLibEvents {
    void fireCompileBlockRenderLayers(GeoBlockRenderer<?> geoBlockRenderer);

    boolean fireBlockPreRender(GeoBlockRenderer<?> geoBlockRenderer, PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i);

    void fireBlockPostRender(GeoBlockRenderer<?> geoBlockRenderer, PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i);

    void fireCompileArmorRenderLayers(GeoArmorRenderer<?> geoArmorRenderer);

    boolean fireArmorPreRender(GeoArmorRenderer<?> geoArmorRenderer, PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i);

    void fireArmorPostRender(GeoArmorRenderer<?> geoArmorRenderer, PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i);

    void fireCompileEntityRenderLayers(GeoEntityRenderer<?> geoEntityRenderer);

    boolean fireEntityPreRender(GeoEntityRenderer<?> geoEntityRenderer, PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i);

    void fireEntityPostRender(GeoEntityRenderer<?> geoEntityRenderer, PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i);

    void fireCompileReplacedEntityRenderLayers(GeoReplacedEntityRenderer<?, ?> geoReplacedEntityRenderer);

    boolean fireReplacedEntityPreRender(GeoReplacedEntityRenderer<?, ?> geoReplacedEntityRenderer, PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i);

    void fireReplacedEntityPostRender(GeoReplacedEntityRenderer<?, ?> geoReplacedEntityRenderer, PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i);

    void fireCompileItemRenderLayers(GeoItemRenderer<?> geoItemRenderer);

    boolean fireItemPreRender(GeoItemRenderer<?> geoItemRenderer, PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i);

    void fireItemPostRender(GeoItemRenderer<?> geoItemRenderer, PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i);

    void fireCompileObjectRenderLayers(GeoObjectRenderer<?> geoObjectRenderer);

    boolean fireObjectPreRender(GeoObjectRenderer<?> geoObjectRenderer, PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i);

    void fireObjectPostRender(GeoObjectRenderer<?> geoObjectRenderer, PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i);
}
