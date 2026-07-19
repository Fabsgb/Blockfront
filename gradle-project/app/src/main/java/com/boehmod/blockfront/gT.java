package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gT.class */
public class gT extends gS<AbstractC0377nz> {
    @Override // com.boehmod.blockfront.gS
    public /* bridge */ /* synthetic */ void a(AbstractC0376ny abstractC0376ny, nE nEVar, PoseStack poseStack) {
        a((AbstractC0377nz) abstractC0376ny, (nE<?>) nEVar, poseStack);
    }

    public gT(EntityRendererProvider.Context context) {
        super(context);
    }

    public void a(AbstractC0377nz abstractC0377nz, nE<?> nEVar, PoseStack poseStack) {
        Entity entityA = abstractC0377nz.a();
        if (entityA == null) {
            return;
        }
        poseStack.mulPose(Axis.ZP.rotationDegrees((abstractC0377nz.getYRot() - entityA.getYHeadRot()) * 0.35f * (abstractC0377nz.ay() / abstractC0377nz.b().jI)));
    }
}
