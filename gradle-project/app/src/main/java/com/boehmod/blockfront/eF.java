package com.boehmod.blockfront;

import com.boehmod.blockfront.C0535tv;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eF.class */
public class eF<T extends C0535tv> extends GeoModel<T> {
    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getModelResource(T t) {
        return t.Q();
    }

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureResource(T t) {
        return t.O();
    }

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getAnimationResource(T t) {
        return t.P();
    }

    @Override // software.bernie.geckolib.model.GeoModel
    public void applyMolangQueries(AnimationState<T> animationState, double d) {
    }
}
