package com.boehmod.blockfront;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gE.class */
public final class C0362gE extends HumanoidMobRenderer<C0700mY, C0255eD> {
    public C0362gE(EntityRendererProvider.Context context) {
        super(context, new C0255eD(context.bakeLayer(ModelLayers.PLAYER), false), 0.5f);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(C0700mY c0700mY) {
        return c0700mY.m3147v();
    }
}
