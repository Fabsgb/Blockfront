package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;

/* JADX INFO: renamed from: com.boehmod.blockfront.gT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gT.class */
public class C0377gT extends AbstractC0376gS<AbstractC0780nz> {
    @Override // com.boehmod.blockfront.AbstractC0376gS
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1801a(AbstractC0779ny abstractC0779ny, C0733nE c0733nE, PoseStack poseStack) {
        m1803a((AbstractC0780nz) abstractC0779ny, (C0733nE<?>) c0733nE, poseStack);
    }

    public C0377gT(EntityRendererProvider.Context context) {
        super(context);
    }

    /* JADX INFO: renamed from: a */
    public void m1803a(AbstractC0780nz abstractC0780nz, C0733nE<?> c0733nE, PoseStack poseStack) {
        Entity entityA = abstractC0780nz.m3497a();
        if (entityA == null) {
            return;
        }
        poseStack.mulPose(Axis.ZP.rotationDegrees((abstractC0780nz.getYRot() - entityA.getYHeadRot()) * 0.35f * (abstractC0780nz.m3505ay() / abstractC0780nz.m3498b().f3957jI)));
    }
}
