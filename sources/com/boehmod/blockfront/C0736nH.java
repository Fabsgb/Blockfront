package com.boehmod.blockfront;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nH.class */
public class C0736nH extends AbstractC0778nx<AbstractC0729nA> {

    /* JADX INFO: renamed from: jT */
    private static final float f3972jT = 0.05f;

    /* JADX INFO: renamed from: jU */
    public static final float f3973jU = 2.8f;

    @Override // com.boehmod.blockfront.AbstractC0778nx
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3356c(@NotNull AbstractC0729nA abstractC0729nA) {
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Vec2 mo3357a(@NotNull AbstractC0729nA abstractC0729nA) {
        return Vec2.ZERO;
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Vec2 mo3358b(@NotNull AbstractC0729nA abstractC0729nA) {
        float fAy = abstractC0729nA.m3505ay() * 2.8f;
        float fAy2 = abstractC0729nA.m3505ay() * 2.8f;
        float f = 0.0f;
        if (abstractC0729nA.m3525aU()) {
            f = 0.05f;
        } else if (abstractC0729nA.m3527aV()) {
            f = -0.05f;
        }
        return new Vec2(fAy2 - f, fAy + f);
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3359a(@NotNull AbstractC0729nA abstractC0729nA, boolean z) {
        if (!abstractC0729nA.isNoGravity()) {
            abstractC0729nA.setDeltaMovement(abstractC0729nA.getDeltaMovement().add(0.0d, -0.03d, 0.0d).multiply(0.5d, 1.0d, 0.5d));
            if (abstractC0729nA.getDeltaMovement().y > 0.0d) {
                abstractC0729nA.setDeltaMovement(abstractC0729nA.getDeltaMovement().multiply(1.0d, 0.0d, 1.0d));
            }
        }
        abstractC0729nA.move(MoverType.SELF, abstractC0729nA.getDeltaMovement());
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3360a(@NotNull AbstractC0729nA abstractC0729nA, @NotNull LocalPlayer localPlayer) {
        C0733nE<?> c0733nEB = abstractC0729nA.m3498b();
        if (this.f4150fd) {
            this.f4147je -= c0733nEB.f3959jK;
        } else if (this.f4151fe) {
            this.f4147je += c0733nEB.f3960jL;
        } else {
            this.f4147je *= c0733nEB.f3962jN;
        }
        this.f4147je = Mth.clamp(this.f4147je, -1.0f, 1.0f);
        if (this.f4148fb) {
            this.f4146jd += c0733nEB.f3952jD;
        } else if (this.f4149fc) {
            this.f4146jd -= c0733nEB.f3953jE;
        } else {
            this.f4146jd *= c0733nEB.f3955jG;
        }
        abstractC0729nA.setYRot(abstractC0729nA.getYRot() + Mth.clamp(mo3361a(c0733nEB), -c0733nEB.f3964jP, c0733nEB.f3963jO));
        float f = c0733nEB.f3957jI;
        float f2 = -c0733nEB.f3958jJ;
        if (this.f4150fd || this.f4151fe) {
            f *= c0733nEB.f3961jM;
            f2 *= c0733nEB.f3961jM;
        }
        if (this.f4152ff) {
            f *= c0733nEB.f3954jF;
            f2 *= c0733nEB.f3954jF;
        }
        if (this.f4146jd > f) {
            this.f4146jd = f;
        } else if (this.f4146jd < f2) {
            this.f4146jd = f2;
        }
        abstractC0729nA.move(MoverType.SELF, new Vec3(Mth.sin((-abstractC0729nA.getYRot()) * 0.017453292f) * this.f4146jd, 0.0d, Mth.cos(abstractC0729nA.getYRot() * 0.017453292f) * this.f4146jd));
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    /* JADX INFO: renamed from: a */
    public float mo3361a(@NotNull C0733nE<?> c0733nE) {
        return this.f4147je;
    }
}
