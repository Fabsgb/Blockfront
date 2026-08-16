package com.boehmod.blockfront;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gT.class */
public class C0378gT extends HumanoidMobRenderer<C0772nq, HumanoidModel<C0772nq>> {

    /* JADX INFO: renamed from: cJ */
    private static final ResourceLocation f2526cJ = C0532jO.m2378d("textures/models/entities/panzerknacker/panzerknacker.png");

    public C0378gT(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM)), 0.5f);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ResourceLocation getTextureLocation(@NotNull C0772nq c0772nq) {
        return f2526cJ;
    }
}
