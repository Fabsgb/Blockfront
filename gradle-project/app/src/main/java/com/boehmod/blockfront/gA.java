package com.boehmod.blockfront;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gA.class */
public final class gA extends MobRenderer<mC, eA<mC>> {
    public gA(EntityRendererProvider.Context context) {
        super(context, new eA(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        addLayer(new HumanoidArmorLayer(this, new eA(context.bakeLayer(ModelLayers.PLAYER)), new eA(context.bakeLayer(ModelLayers.PLAYER)), context.getModelManager()));
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(mC mCVar) {
        return mCVar.r();
    }
}
