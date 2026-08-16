package software.bernie.geckolib.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.texture.AutoGlowingTexture;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.util.ClientUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/renderer/layer/AutoGlowingGeoLayer.class */
public class AutoGlowingGeoLayer<T extends GeoAnimatable> extends GeoRenderLayer<T> {
    public AutoGlowingGeoLayer(GeoRenderer<T> renderer) {
        super(renderer);
    }

    @Deprecated(forRemoval = true)
    protected RenderType getRenderType(T animatable) {
        return getRenderType(animatable, null);
    }

    @Nullable
    protected RenderType getRenderType(T animatable, @Nullable MultiBufferSource bufferSource) {
        if (!(animatable instanceof Entity)) {
            return AutoGlowingTexture.getRenderType(getTextureResource(animatable));
        }
        Entity entity = (Entity) animatable;
        boolean invisible = entity.isInvisible();
        ResourceLocation texture = AutoGlowingTexture.getEmissiveResource(getTextureResource(animatable));
        if (invisible && !entity.isInvisibleTo(ClientUtil.getClientPlayer())) {
            return RenderType.itemEntityTranslucentCull(texture);
        }
        if (Minecraft.getInstance().shouldEntityAppearGlowing(entity)) {
            if (invisible) {
                return RenderType.outline(texture);
            }
            return AutoGlowingTexture.getOutlineRenderType(getTextureResource(animatable));
        }
        if (invisible) {
            return null;
        }
        return AutoGlowingTexture.getRenderType(getTextureResource(animatable));
    }

    @Override // software.bernie.geckolib.renderer.layer.GeoRenderLayer
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType renderType2 = getRenderType(animatable);
        if (renderType2 != null) {
            getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, renderType2, bufferSource.getBuffer(renderType2), partialTick, 15728640, packedOverlay, getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
        }
    }
}
