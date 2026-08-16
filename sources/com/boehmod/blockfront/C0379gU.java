package com.boehmod.blockfront;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gU.class */
public final class C0379gU extends HumanoidMobRenderer<C0776nu, C0269eQ> {
    public C0379gU(EntityRendererProvider.Context context) {
        super(context, new C0269eQ(context.bakeLayer(ModelLayers.PLAYER), false), 0.5f);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(C0776nu c0776nu) {
        return c0776nu.m3654w();
    }
}
