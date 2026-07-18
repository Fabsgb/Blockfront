package com.boehmod.blockfront;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gD.class */
public class C0361gD extends HumanoidMobRenderer<C0696mU, HumanoidModel<C0696mU>> {

    /* JADX INFO: renamed from: cJ */
    private static final ResourceLocation f2450cJ = C0564jv.m2555d("textures/models/entities/panzerknacker/panzerknacker.png");

    public C0361gD(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM)), 0.5f);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ResourceLocation getTextureLocation(@NotNull C0696mU c0696mU) {
        return f2450cJ;
    }
}
