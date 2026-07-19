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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eJ.class */
public class eJ<T extends BlockEntity & GeoAnimatable> extends GeoModel<T> {

    @Nullable
    public ResourceLocation cw;

    @Nullable
    public ResourceLocation cx;
    private final Object b = new Object();

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getAnimationResource(T t) {
        if (this.cw != null) {
            return this.cw;
        }
        ResourceLocation resourceLocationD = C0265jv.d("animations/block/" + BuiltInRegistries.BLOCK.getKey(t.getBlockState().getBlock()).getPath() + ".animation.json");
        this.cw = resourceLocationD;
        return resourceLocationD;
    }

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getModelResource(T t) {
        if (this.cx != null) {
            return this.cx;
        }
        ResourceLocation resourceLocationD = C0265jv.d("geo/block/" + BuiltInRegistries.BLOCK.getKey(t.getBlockState().getBlock()).getPath() + ".geo.json");
        this.cx = resourceLocationD;
        return resourceLocationD;
    }

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureResource(T t) {
        return C0265jv.d("textures/block/entity/" + m369a((BlockEntity) t) + ".png");
    }

    @Nonnull
    public ResourceLocation a(@Nonnull T t) {
        return C0265jv.d("block/entity/" + m369a((BlockEntity) t));
    }

    @Nonnull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private String m369a(@Nonnull T t) {
        BlockState blockState = t.getBlockState();
        String path = BuiltInRegistries.BLOCK.getKey(blockState.getBlock()).getPath();
        if (blockState.hasProperty(lD.m)) {
            path = path + String.valueOf(blockState.getValue(lD.m));
        }
        return path;
    }

    @Override // software.bernie.geckolib.model.GeoModel
    public void applyMolangQueries(AnimationState<T> animationState, double d) {
    }

    @NotNull
    public Object a() {
        return this.b;
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
        synchronized (this.b) {
            if (bakedGeoModel != geoModelAccessor.getCurrentModel()) {
                getAnimationProcessor().setActiveModel(bakedGeoModel);
                geoModelAccessor.setCurrentModel(bakedGeoModel);
            }
        }
        return geoModelAccessor.getCurrentModel();
    }
}
