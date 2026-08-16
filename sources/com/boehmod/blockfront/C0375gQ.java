package com.boehmod.blockfront;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gQ.class */
public final class C0375gQ extends MobRenderer<C0701mY, C0266eN<C0701mY>> {
    public C0375gQ(EntityRendererProvider.Context context) {
        super(context, new C0266eN(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        addLayer(new HumanoidArmorLayer(this, new C0266eN(context.bakeLayer(ModelLayers.PLAYER)), new C0266eN(context.bakeLayer(ModelLayers.PLAYER)), context.getModelManager()));
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(C0701mY c0701mY) {
        return c0701mY.m3158s();
    }
}
