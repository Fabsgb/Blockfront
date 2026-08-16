package com.boehmod.blockfront;

import com.boehmod.blockfront.mixin.GeoModelAccessor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.GeckoLibCache;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;

/* JADX INFO: renamed from: com.boehmod.blockfront.eW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eW.class */
public class C0275eW<T extends BlockEntity & GeoAnimatable> extends GeoModel<T> {

    /* JADX INFO: renamed from: cv */
    @Nullable
    public ResourceLocation f2187cv;

    /* JADX INFO: renamed from: cw */
    @Nullable
    public ResourceLocation f2188cw;

    /* JADX INFO: renamed from: c */
    private final Object f2189c = new Object();

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getAnimationResource(T t) {
        if (this.f2187cv != null) {
            return this.f2187cv;
        }
        ResourceLocation resourceLocationM2378d = C0532jO.m2378d("animations/block/" + BuiltInRegistries.BLOCK.getKey(t.getBlockState().getBlock()).getPath() + ".animation.json");
        this.f2187cv = resourceLocationM2378d;
        return resourceLocationM2378d;
    }

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getModelResource(T t) {
        if (this.f2188cw != null) {
            return this.f2188cw;
        }
        ResourceLocation resourceLocationM2378d = C0532jO.m2378d("geo/block/" + BuiltInRegistries.BLOCK.getKey(t.getBlockState().getBlock()).getPath() + ".geo.json");
        this.f2188cw = resourceLocationM2378d;
        return resourceLocationM2378d;
    }

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureResource(T t) {
        return C0532jO.m2378d("textures/block/entity/" + m1526a((BlockEntity) t) + ".png");
    }

    @Nonnull
    /* JADX INFO: renamed from: a */
    public ResourceLocation mo1521a(@Nonnull T t) {
        return C0532jO.m2378d("block/entity/" + m1526a((BlockEntity) t));
    }

    @Nonnull
    /* JADX INFO: renamed from: a */
    private String m1526a(@Nonnull T t) {
        BlockState blockState = t.getBlockState();
        String path = BuiltInRegistries.BLOCK.getKey(blockState.getBlock()).getPath();
        if (blockState.hasProperty(C0649lZ.f3655m)) {
            path = path + String.valueOf(blockState.getValue(C0649lZ.f3655m));
        }
        return path;
    }

    @Override // software.bernie.geckolib.model.GeoModel
    public void applyMolangQueries(AnimationState<T> animationState, double d) {
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Object m1527a() {
        return this.f2189c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // software.bernie.geckolib.model.GeoModel
    public BakedGeoModel getBakedModel(@NotNull ResourceLocation resourceLocation) {
        BakedGeoModel bakedGeoModel = GeckoLibCache.getBakedModels().get(resourceLocation);
        if (bakedGeoModel == null) {
            if (!resourceLocation.getPath().contains("geo/")) {
                throw GeckoLibConstants.exception(resourceLocation, "Invalid model resource path provided - GeckoLib models must be placed in assets/<modid>/geo/");
            }
            throw GeckoLibConstants.exception(resourceLocation, "Unable to find model");
        }
        GeoModelAccessor geoModelAccessor = (GeoModelAccessor) this;
        synchronized (this.f2189c) {
            if (bakedGeoModel != geoModelAccessor.getCurrentModel()) {
                getAnimationProcessor().setActiveModel(bakedGeoModel);
                geoModelAccessor.setCurrentModel(bakedGeoModel);
            }
        }
        return geoModelAccessor.getCurrentModel();
    }
}
