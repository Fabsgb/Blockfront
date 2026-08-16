package com.boehmod.blockfront;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gS.class */
public class C0377gS extends HumanoidMobRenderer<C0768nm, C0268eP> {
    public C0377gS(EntityRendererProvider.Context context) {
        super(context, new C0268eP(context.bakeLayer(ModelLayers.PLAYER), false), 0.5f);
        addLayer(new C0415hD(this, context));
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ResourceLocation getTextureLocation(C0768nm c0768nm) {
        return c0768nm.mo3624u();
    }
}
