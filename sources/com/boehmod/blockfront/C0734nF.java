package com.boehmod.blockfront;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nF.class */
public class C0734nF extends AbstractC0778nx<AbstractC0779ny> {

    /* JADX INFO: renamed from: jR */
    public static final float f3970jR = 3.0f;

    @Override // com.boehmod.blockfront.AbstractC0778nx
    /* JADX INFO: renamed from: c */
    public void mo3356c(@NotNull AbstractC0779ny abstractC0779ny) {
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec2 mo3357a(@NotNull AbstractC0779ny abstractC0779ny) {
        return new Vec2(this.f4147je, this.f4147je);
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    @NotNull
    /* JADX INFO: renamed from: b */
    public Vec2 mo3358b(@NotNull AbstractC0779ny abstractC0779ny) {
        return new Vec2(abstractC0779ny.m3505ay(), abstractC0779ny.m3505ay()).scale(3.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    /* JADX INFO: renamed from: a */
    public void mo3359a(@NotNull AbstractC0779ny abstractC0779ny, boolean z) {
        if (!abstractC0779ny.isNoGravity()) {
            abstractC0779ny.setDeltaMovement(abstractC0779ny.getDeltaMovement().add(0.0d, -0.03d, 0.0d).multiply(0.5d, 1.0d, 0.5d));
            if (abstractC0779ny.getDeltaMovement().y > 0.0d) {
                abstractC0779ny.setDeltaMovement(abstractC0779ny.getDeltaMovement().multiply(1.0d, 0.0d, 1.0d));
            }
        }
        abstractC0779ny.move(MoverType.SELF, abstractC0779ny.getDeltaMovement());
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    /* JADX INFO: renamed from: a */
    public void mo3360a(@NotNull AbstractC0779ny abstractC0779ny, @NotNull LocalPlayer localPlayer) {
        C0733nE<AbstractC0779ny> c0733nEM3499b = abstractC0779ny.m3499b();
        if (this.f4150fd) {
            this.f4147je -= c0733nEM3499b.f3959jK;
        } else if (this.f4151fe) {
            this.f4147je += c0733nEM3499b.f3960jL;
        } else {
            this.f4147je *= c0733nEM3499b.f3962jN;
        }
        this.f4147je = Mth.clamp(this.f4147je, -c0733nEM3499b.f3963jO, c0733nEM3499b.f3964jP);
        abstractC0779ny.setYRot(abstractC0779ny.getYRot() + mo3361a(c0733nEM3499b));
        float f = c0733nEM3499b.f3957jI;
        float f2 = -c0733nEM3499b.f3958jJ;
        if (this.f4150fd || this.f4151fe) {
            f *= c0733nEM3499b.f3961jM;
            f2 *= c0733nEM3499b.f3961jM;
        }
        if (this.f4152ff) {
            f *= c0733nEM3499b.f3954jF;
            f2 *= c0733nEM3499b.f3954jF;
        }
        if (this.f4148fb) {
            this.f4146jd = C1290xm.m7835d(this.f4146jd, f, c0733nEM3499b.f3952jD);
        } else if (this.f4149fc) {
            this.f4146jd = C1290xm.m7835d(this.f4146jd, f2, c0733nEM3499b.f3953jE);
        } else {
            this.f4146jd *= c0733nEM3499b.f3955jG;
        }
        if (this.f4146jd > f) {
            this.f4146jd = f;
        } else if (this.f4146jd < f2) {
            this.f4146jd = f2;
        }
        abstractC0779ny.move(MoverType.SELF, new Vec3(Mth.sin((-abstractC0779ny.getYRot()) * 0.017453292f) * this.f4146jd, 0.0d, Mth.cos(abstractC0779ny.getYRot() * 0.017453292f) * this.f4146jd));
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    /* JADX INFO: renamed from: a */
    public float mo3361a(@NotNull C0733nE<?> c0733nE) {
        return this.f4147je * (this.f4146jd / (this.f4149fc ? c0733nE.f3958jJ : c0733nE.f3957jI));
    }
}
