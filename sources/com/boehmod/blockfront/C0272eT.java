package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC1140um;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

/* JADX INFO: renamed from: com.boehmod.blockfront.eT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eT.class */
public class C0272eT<T extends AbstractC1140um<T>> extends GeoModel<T> {
    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getModelResource(T t) {
        return t.m6573R();
    }

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureResource(T t) {
        return t.m6571P();
    }

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getAnimationResource(T t) {
        return t.m6572Q();
    }

    @Override // software.bernie.geckolib.model.GeoModel
    public void applyMolangQueries(AnimationState<T> animationState, double d) {
    }
}
