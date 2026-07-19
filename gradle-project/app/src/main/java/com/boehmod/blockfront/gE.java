package com.boehmod.blockfront;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gE.class */
public final class gE extends HumanoidMobRenderer<mY, eD> {
    public gE(EntityRendererProvider.Context context) {
        super(context, new eD(context.bakeLayer(ModelLayers.PLAYER), false), 0.5f);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(mY mYVar) {
        return mYVar.v();
    }
}
