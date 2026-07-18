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

/* JADX INFO: renamed from: com.boehmod.blockfront.eJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eJ.class */
public class C0261eJ<T extends BlockEntity & GeoAnimatable> extends GeoModel<T> {

    /* JADX INFO: renamed from: cw */
    @Nullable
    public ResourceLocation f2068cw;

    /* JADX INFO: renamed from: cx */
    @Nullable
    public ResourceLocation f2069cx;

    /* JADX INFO: renamed from: b */
    private final Object f2070b = new Object();

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: d */
    public ResourceLocation getAnimationResource(T t) {
        if (this.f2068cw != null) {
            return this.f2068cw;
        }
        ResourceLocation resourceLocationM2555d = C0564jv.m2555d("animations/block/" + BuiltInRegistries.BLOCK.getKey(t.getBlockState().getBlock()).getPath() + ".animation.json");
        this.f2068cw = resourceLocationM2555d;
        return resourceLocationM2555d;
    }

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: c */
    public ResourceLocation getModelResource(T t) {
        if (this.f2069cx != null) {
            return this.f2069cx;
        }
        ResourceLocation resourceLocationM2555d = C0564jv.m2555d("geo/block/" + BuiltInRegistries.BLOCK.getKey(t.getBlockState().getBlock()).getPath() + ".geo.json");
        this.f2069cx = resourceLocationM2555d;
        return resourceLocationM2555d;
    }

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: b */
    public ResourceLocation getTextureResource(T t) {
        return C0564jv.m2555d("textures/block/entity/" + m1447a((BlockEntity) t) + ".png");
    }

    @Nonnull
    /* JADX INFO: renamed from: a */
    public ResourceLocation mo1442a(@Nonnull T t) {
        return C0564jv.m2555d("block/entity/" + m1447a((BlockEntity) t));
    }

    @Nonnull
    /* JADX INFO: renamed from: a */
    private String m1447a(@Nonnull T t) {
        BlockState blockState = t.getBlockState();
        String path = BuiltInRegistries.BLOCK.getKey(blockState.getBlock()).getPath();
        if (blockState.hasProperty(C0626lD.f3401m)) {
            path = path + String.valueOf(blockState.getValue(C0626lD.f3401m));
        }
        return path;
    }

    @Override // software.bernie.geckolib.model.GeoModel
    public void applyMolangQueries(AnimationState<T> animationState, double d) {
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Object m1448a() {
        return this.f2070b;
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
        synchronized (this.f2070b) {
            if (bakedGeoModel != geoModelAccessor.getCurrentModel()) {
                getAnimationProcessor().setActiveModel(bakedGeoModel);
                geoModelAccessor.setCurrentModel(bakedGeoModel);
            }
        }
        return geoModelAccessor.getCurrentModel();
    }
}
