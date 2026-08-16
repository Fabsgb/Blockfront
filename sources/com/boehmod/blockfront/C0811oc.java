package com.boehmod.blockfront;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oc.class */
public class C0811oc extends AbstractC0749nT<AbstractC0751nV> {

    /* JADX INFO: renamed from: kL */
    public float f4399kL = 0.0f;

    @Override // com.boehmod.blockfront.AbstractC0749nT
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3418c(@NotNull AbstractC0751nV abstractC0751nV) {
        if (!abstractC0751nV.level().isClientSide) {
            abstractC0751nV.setDeltaMovement(Vec3.ZERO);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Vec2 mo3420a(@NotNull AbstractC0751nV abstractC0751nV) {
        return Vec2.ZERO;
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Vec2 mo3421b(@NotNull AbstractC0751nV abstractC0751nV) {
        return Vec2.ZERO;
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3423a(@NotNull AbstractC0751nV abstractC0751nV, boolean z) {
        float fMin = 1.0f - Math.min(abstractC0751nV.m3442aE() / (abstractC0751nV.m3431b().f4385kB / 1.5f), 1.0f);
        if (!abstractC0751nV.isNoGravity()) {
            abstractC0751nV.setDeltaMovement(abstractC0751nV.getDeltaMovement().add(0.0d, -0.03d, 0.0d).multiply(0.5d, fMin, 0.5d));
            if (abstractC0751nV.getDeltaMovement().y > 0.0d) {
                abstractC0751nV.setDeltaMovement(abstractC0751nV.getDeltaMovement().multiply(1.0d, 0.0d, 1.0d));
            }
        }
        abstractC0751nV.move(MoverType.SELF, abstractC0751nV.getDeltaMovement());
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3424a(@NotNull AbstractC0751nV abstractC0751nV, @NotNull LocalPlayer localPlayer) {
        C0809oa c0809oaB = abstractC0751nV.m3431b();
        float f = this.f4103jW / c0809oaB.f4385kB;
        if (this.f4105fv) {
            this.f4103jW += c0809oaB.f4380kw;
        } else if (this.f4106fw) {
            this.f4103jW -= c0809oaB.f4381kx;
        }
        if (this.f4103jW > c0809oaB.f4385kB) {
            this.f4103jW = c0809oaB.f4385kB;
        }
        c0809oaB.f4385kB = 1.0f;
        if (this.f4103jW < 0.0f) {
            this.f4103jW = 0.0f;
        }
        float f2 = 0.05f * f;
        float xRot = abstractC0751nV.getXRot();
        float yRot = abstractC0751nV.getYRot();
        float f3 = -localPlayer.getXRot();
        float yHeadRot = localPlayer.getYHeadRot();
        float fLerp = Mth.lerp(f2, xRot, f3);
        float fLerp2 = Mth.lerp(f2 / 4.0f, yRot, yHeadRot);
        abstractC0751nV.setXRot(fLerp);
        abstractC0751nV.setYRot(fLerp2);
        this.f4104jX = this.f4399kL * this.f4103jW;
        abstractC0751nV.move(MoverType.SELF, new Vec3(Mth.sin((-abstractC0751nV.getYRot()) * 0.017453292f) * this.f4103jW, Mth.cos((-(abstractC0751nV.getXRot() - 90.0f)) * 0.017453292f) * this.f4103jW, Mth.cos(abstractC0751nV.getYRot() * 0.017453292f) * this.f4103jW));
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    /* JADX INFO: renamed from: a */
    public float mo3425a(@NotNull C0809oa<?> c0809oa) {
        return this.f4104jX;
    }
}
