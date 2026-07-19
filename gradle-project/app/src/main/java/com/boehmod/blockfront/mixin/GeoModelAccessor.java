package com.boehmod.blockfront.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/GeoModelAccessor.class */
@Mixin({GeoModel.class})
public interface GeoModelAccessor {
    @Accessor("currentModel")
    void setCurrentModel(BakedGeoModel bakedGeoModel);

    @Accessor("currentModel")
    @Nullable
    BakedGeoModel getCurrentModel();
}
