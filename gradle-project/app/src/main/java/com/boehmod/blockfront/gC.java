package com.boehmod.blockfront;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gC.class */
public class gC extends HumanoidMobRenderer<mQ, eC> {
    public gC(EntityRendererProvider.Context context) {
        super(context, new eC(context.bakeLayer(ModelLayers.PLAYER), false), 0.5f);
        addLayer(new C0204hn(this, context));
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ResourceLocation getTextureLocation(mQ mQVar) {
        return mQVar.t();
    }
}
