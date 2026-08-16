package software.bernie.geckolib.cache.texture;

import com.mojang.blaze3d.pipeline.RenderCall;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Function;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.metadata.texture.TextureMetadataSection;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.resource.GeoGlowingTextureMeta;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/cache/texture/AutoGlowingTexture.class */
public class AutoGlowingTexture extends GeoAbstractTexture {
    private static final String APPENDIX = "_glowmask";
    protected final ResourceLocation textureBase;
    protected final ResourceLocation glowLayer;
    private static final RenderStateShard.ShaderStateShard SHADER_STATE = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityTranslucentEmissiveShader);
    private static final RenderStateShard.TransparencyStateShard TRANSPARENCY_STATE = new RenderStateShard.TransparencyStateShard("translucent_transparency", () -> {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
    }, () -> {
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    });
    private static final RenderStateShard.WriteMaskStateShard WRITE_MASK = new RenderStateShard.WriteMaskStateShard(true, true);
    private static final BiFunction<ResourceLocation, Boolean, RenderType> GLOWING_RENDER_TYPE = Util.memoize((texture, isGlowing) -> {
        RenderStateShard.TextureStateShard textureState = new RenderStateShard.TextureStateShard(texture, false, false);
        return RenderType.create("geo_glowing_layer", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, false, true, RenderType.CompositeState.builder().setShaderState(SHADER_STATE).setTextureState(textureState).setTransparencyState(TRANSPARENCY_STATE).setOverlayState(new RenderStateShard.OverlayStateShard(true)).setWriteMaskState(WRITE_MASK).createCompositeState(isGlowing.booleanValue()));
    });

    @Deprecated(forRemoval = true)
    private static final Function<ResourceLocation, RenderType> RENDER_TYPE_FUNCTION = Util.memoize(texture -> {
        return GLOWING_RENDER_TYPE.apply(texture, false);
    });
    public static boolean PRINT_DEBUG_IMAGES = false;

    public AutoGlowingTexture(ResourceLocation originalLocation, ResourceLocation location) {
        this.textureBase = originalLocation;
        this.glowLayer = location;
    }

    public static ResourceLocation getEmissiveResource(ResourceLocation baseResource) {
        ResourceLocation path = appendToPath(baseResource, APPENDIX);
        generateTexture(path, textureManager -> {
            textureManager.register(path, new AutoGlowingTexture(baseResource, path));
        });
        return path;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x01b7  */
    @Override // software.bernie.geckolib.cache.texture.GeoAbstractTexture
    @Nullable
    protected RenderCall loadTexture(ResourceManager resourceManager, Minecraft mc) throws IOException {
        NativeImage pixels;
        boolean z;
        try {
            DynamicTexture dynamicTexture = (AbstractTexture) mc.submit(() -> {
                return mc.getTextureManager().getTexture(this.textureBase);
            }).get();
            Resource textureBaseResource = (Resource) resourceManager.getResource(this.textureBase).get();
            if (dynamicTexture instanceof DynamicTexture) {
                DynamicTexture dynamicTexture2 = dynamicTexture;
                pixels = dynamicTexture2.getPixels();
            } else {
                pixels = NativeImage.read(textureBaseResource.open());
            }
            NativeImage baseImage = pixels;
            NativeImage glowImage = null;
            Optional<TextureMetadataSection> textureBaseMeta = textureBaseResource.metadata().getSection(TextureMetadataSection.SERIALIZER);
            boolean blur = textureBaseMeta.isPresent() && textureBaseMeta.get().isBlur();
            boolean clamp = textureBaseMeta.isPresent() && textureBaseMeta.get().isClamp();
            try {
                Optional<Resource> glowLayerResource = resourceManager.getResource(this.glowLayer);
                GeoGlowingTextureMeta glowLayerMeta = null;
                if (glowLayerResource.isPresent()) {
                    glowImage = NativeImage.read(glowLayerResource.get().open());
                    glowLayerMeta = GeoGlowingTextureMeta.fromExistingImage(glowImage);
                    if (baseImage != null && (glowImage.getWidth() != baseImage.getWidth() || glowImage.getHeight() != baseImage.getHeight())) {
                        throw new IllegalStateException(String.format("Glowmask texture dimensions do not match base texture dimensions! Mask: %s, Base: %s", this.glowLayer, this.textureBase));
                    }
                } else {
                    Optional<GeoGlowingTextureMeta> meta = textureBaseResource.metadata().getSection(GeoGlowingTextureMeta.DESERIALIZER);
                    if (meta.isPresent()) {
                        glowLayerMeta = meta.get();
                        glowImage = new NativeImage(baseImage.getWidth(), baseImage.getHeight(), true);
                    }
                }
                if (glowLayerMeta != null) {
                    glowLayerMeta.createImageMask(baseImage, glowImage);
                    if (PRINT_DEBUG_IMAGES && GeckoLibServices.PLATFORM.isDevelopmentEnvironment()) {
                        printDebugImageToDisk(this.textureBase, baseImage);
                        printDebugImageToDisk(this.glowLayer, glowImage);
                    }
                }
            } catch (IOException e) {
                GeckoLibConstants.LOGGER.warn("Resource failed to open for glowlayer meta: {}", this.glowLayer, e);
            }
            NativeImage mask = glowImage;
            if (mask == null) {
                return null;
            }
            if (dynamicTexture instanceof AnimatableTexture) {
                AnimatableTexture animatableTexture = (AnimatableTexture) dynamicTexture;
                if (animatableTexture.isAnimated()) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            boolean animated = z;
            if (animated) {
                ((AnimatableTexture) dynamicTexture).animationContents.animatedTexture.setGlowMaskTexture(this, baseImage, mask);
            }
            return () -> {
                if (!animated) {
                    uploadSimple(getId(), mask, blur, clamp);
                }
                if (dynamicTexture instanceof DynamicTexture) {
                    DynamicTexture dynamicTexture3 = (DynamicTexture) dynamicTexture;
                    dynamicTexture3.upload();
                } else {
                    uploadSimple(dynamicTexture.getId(), baseImage, blur, clamp);
                }
            };
        } catch (InterruptedException | ExecutionException e2) {
            throw new IOException("Failed to load original texture: " + String.valueOf(this.textureBase), e2);
        }
    }

    public static RenderType getRenderType(ResourceLocation texture) {
        return GLOWING_RENDER_TYPE.apply(getEmissiveResource(texture), false);
    }

    public static RenderType getOutlineRenderType(ResourceLocation texture) {
        return GLOWING_RENDER_TYPE.apply(getEmissiveResource(texture), true);
    }
}
