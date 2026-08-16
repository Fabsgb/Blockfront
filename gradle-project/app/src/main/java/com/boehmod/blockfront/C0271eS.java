package com.boehmod.blockfront;

import com.boehmod.blockfront.C1068tT;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

/* JADX INFO: renamed from: com.boehmod.blockfront.eS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eS.class */
public class C0271eS<T extends C1068tT> extends GeoModel<T> {
    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getModelResource(T t) {
        return t.m5929R();
    }

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureResource(T t) {
        return t.m5927P();
    }

    @Override // software.bernie.geckolib.model.GeoModel
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getAnimationResource(T t) {
        return t.m5928Q();
    }

    @Override // software.bernie.geckolib.model.GeoModel
    public void applyMolangQueries(AnimationState<T> animationState, double d) {
    }
}
