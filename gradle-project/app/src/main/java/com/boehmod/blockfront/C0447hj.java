package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;

/* JADX INFO: renamed from: com.boehmod.blockfront.hj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hj.class */
public class C0447hj extends AbstractC0446hi<AbstractC0751nV> {
    @Override // com.boehmod.blockfront.AbstractC0446hi
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo2057a(AbstractC0750nU abstractC0750nU, C0809oa c0809oa, PoseStack poseStack) {
        m2059a((AbstractC0751nV) abstractC0750nU, (C0809oa<?>) c0809oa, poseStack);
    }

    public C0447hj(EntityRendererProvider.Context context) {
        super(context);
    }

    /* JADX INFO: renamed from: a */
    public void m2059a(AbstractC0751nV abstractC0751nV, C0809oa<?> c0809oa, PoseStack poseStack) {
        Entity entityA = abstractC0751nV.m3430a();
        if (entityA == null) {
            return;
        }
        poseStack.mulPose(Axis.ZP.rotationDegrees((abstractC0751nV.getYRot() - entityA.getYHeadRot()) * 0.35f * (abstractC0751nV.m3442aE() / abstractC0751nV.m3431b().f4385kB)));
    }
}
