package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.GeckoLibCache;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

/* JADX INFO: renamed from: com.boehmod.blockfront.gI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gI.class */
public abstract class AbstractC0367gI<T extends BlockEntity & GeoAnimatable> extends GeoBlockRenderer<T> {

    /* JADX INFO: renamed from: a */
    private static final ObjectOpenHashSet<ResourceLocation> f2507a = new ObjectOpenHashSet<>();

    /* JADX INFO: renamed from: a */
    public abstract boolean mo1744a(@NotNull T t);

    public AbstractC0367gI(@NotNull GeoModel<T> geoModel) {
        super(geoModel);
    }

    public AbstractC0367gI() {
        this(new C0275eW());
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer
    public void render(T t, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i2) {
        if ((t.getBlockState().getBlock() instanceof InterfaceC0596kZ) && mo1744a(t)) {
            return;
        }
        ResourceLocation modelResource = getGeoModel().getModelResource(t, this);
        if (!GeckoLibCache.getBakedModels().containsKey(modelResource)) {
            if (f2507a.add(modelResource)) {
                C0530jM.m2337a("Skipping block entity render, missing geo model: %s", modelResource);
                return;
            }
            return;
        }
        GeoModel<T> geoModel = getGeoModel();
        if (geoModel instanceof C0275eW) {
            synchronized (((C0275eW) geoModel).m1527a()) {
                super.render(t, f, poseStack, multiBufferSource, i, i2);
            }
            return;
        }
        super.render(t, f, poseStack, multiBufferSource, i, i2);
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    public void updateAnimatedTextureFrame(T t) {
        if ((t instanceof C0712mj) && !((C0712mj) t).mo3235aw()) {
            return;
        }
        super.updateAnimatedTextureFrame((BlockEntity) t);
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel bakedGeoModel, @NotNull MultiBufferSource multiBufferSource, float f, int i) {
        return true;
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull T t) {
        ResourceLocation resourceLocationM3247o;
        if ((t instanceof C0712mj) && (resourceLocationM3247o = ((C0712mj) t).m3247o()) != null) {
            return resourceLocationM3247o;
        }
        return super.getTextureLocation(t);
    }
}
