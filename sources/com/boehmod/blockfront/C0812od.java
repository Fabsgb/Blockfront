package com.boehmod.blockfront;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.od */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/od.class */
public class C0812od extends AbstractC0749nT<AbstractC0752nW> {

    /* JADX INFO: renamed from: kM */
    private static final float f4400kM = 0.05f;

    /* JADX INFO: renamed from: kN */
    public static final float f4401kN = 2.8f;

    @Override // com.boehmod.blockfront.AbstractC0749nT
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3418c(@NotNull AbstractC0752nW abstractC0752nW) {
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Vec2 mo3420a(@NotNull AbstractC0752nW abstractC0752nW) {
        return Vec2.ZERO;
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Vec2 mo3421b(@NotNull AbstractC0752nW abstractC0752nW) {
        float fAE = abstractC0752nW.m3442aE() * 2.8f;
        float fAE2 = abstractC0752nW.m3442aE() * 2.8f;
        float f = 0.0f;
        if (abstractC0752nW.m3462be()) {
            f = 0.05f;
        } else if (abstractC0752nW.m3464bf()) {
            f = -0.05f;
        }
        return new Vec2(fAE2 - f, fAE + f);
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3423a(@NotNull AbstractC0752nW abstractC0752nW, boolean z) {
        if (!abstractC0752nW.isNoGravity()) {
            abstractC0752nW.setDeltaMovement(abstractC0752nW.getDeltaMovement().add(0.0d, -0.03d, 0.0d).multiply(0.5d, 1.0d, 0.5d));
            if (abstractC0752nW.getDeltaMovement().y > 0.0d) {
                abstractC0752nW.setDeltaMovement(abstractC0752nW.getDeltaMovement().multiply(1.0d, 0.0d, 1.0d));
            }
        }
        abstractC0752nW.move(MoverType.SELF, abstractC0752nW.getDeltaMovement());
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3424a(@NotNull AbstractC0752nW abstractC0752nW, @NotNull LocalPlayer localPlayer) {
        C0809oa<?> c0809oaB = abstractC0752nW.m3431b();
        if (this.f4107fx) {
            this.f4104jX -= c0809oaB.f4387kD;
        } else if (this.f4108fy) {
            this.f4104jX += c0809oaB.f4388kE;
        } else {
            this.f4104jX *= c0809oaB.f4390kG;
        }
        this.f4104jX = Mth.clamp(this.f4104jX, -1.0f, 1.0f);
        if (this.f4105fv) {
            this.f4103jW += c0809oaB.f4380kw;
        } else if (this.f4106fw) {
            this.f4103jW -= c0809oaB.f4381kx;
        } else {
            this.f4103jW *= c0809oaB.f4383kz;
        }
        abstractC0752nW.setYRot(abstractC0752nW.getYRot() + Mth.clamp(mo3425a(c0809oaB), -c0809oaB.f4392kI, c0809oaB.f4391kH));
        float f = c0809oaB.f4385kB;
        float f2 = -c0809oaB.f4386kC;
        if (this.f4107fx || this.f4108fy) {
            f *= c0809oaB.f4389kF;
            f2 *= c0809oaB.f4389kF;
        }
        if (this.f4109fz) {
            f *= c0809oaB.f4382ky;
            f2 *= c0809oaB.f4382ky;
        }
        if (this.f4103jW > f) {
            this.f4103jW = f;
        } else if (this.f4103jW < f2) {
            this.f4103jW = f2;
        }
        abstractC0752nW.move(MoverType.SELF, new Vec3(Mth.sin((-abstractC0752nW.getYRot()) * 0.017453292f) * this.f4103jW, 0.0d, Mth.cos(abstractC0752nW.getYRot() * 0.017453292f) * this.f4103jW));
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    /* JADX INFO: renamed from: a */
    public float mo3425a(@NotNull C0809oa<?> c0809oa) {
        return this.f4104jX;
    }
}
