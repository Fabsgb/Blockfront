package com.boehmod.blockfront;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gC.class */
public class C0360gC extends HumanoidMobRenderer<C0692mQ, C0254eC> {
    public C0360gC(EntityRendererProvider.Context context) {
        super(context, new C0254eC(context.bakeLayer(ModelLayers.PLAYER), false), 0.5f);
        addLayer(new C0450hn(this, context));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final ResourceLocation getTextureLocation(C0692mQ c0692mQ) {
        return c0692mQ.mo3117t();
    }
}
