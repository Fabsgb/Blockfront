package com.boehmod.blockfront;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gA.class */
public final class C0358gA extends MobRenderer<C0678mC, C0252eA<C0678mC>> {
    public C0358gA(EntityRendererProvider.Context context) {
        super(context, new C0252eA(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        addLayer(new HumanoidArmorLayer(this, new C0252eA(context.bakeLayer(ModelLayers.PLAYER)), new C0252eA(context.bakeLayer(ModelLayers.PLAYER)), context.getModelManager()));
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(C0678mC c0678mC) {
        return c0678mC.m3007r();
    }
}
