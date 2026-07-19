package com.boehmod.blockfront;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nH.class */
public class nH extends AbstractC0375nx<nA> {
    private static final float jT = 0.05f;
    public static final float jU = 2.8f;

    @Override // com.boehmod.blockfront.AbstractC0375nx
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull nA nAVar) {
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    @NotNull
    public Vec2 a(@NotNull nA nAVar) {
        return Vec2.ZERO;
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Vec2 mo737b(@NotNull nA nAVar) {
        float fAy = nAVar.ay() * 2.8f;
        float fAy2 = nAVar.ay() * 2.8f;
        float f = 0.0f;
        if (nAVar.aU()) {
            f = 0.05f;
        } else if (nAVar.aV()) {
            f = -0.05f;
        }
        return new Vec2(fAy2 - f, fAy + f);
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    public void a(@NotNull nA nAVar, boolean z) {
        if (!nAVar.isNoGravity()) {
            nAVar.setDeltaMovement(nAVar.getDeltaMovement().add(0.0d, -0.03d, 0.0d).multiply(0.5d, 1.0d, 0.5d));
            if (nAVar.getDeltaMovement().y > 0.0d) {
                nAVar.setDeltaMovement(nAVar.getDeltaMovement().multiply(1.0d, 0.0d, 1.0d));
            }
        }
        nAVar.move(MoverType.SELF, nAVar.getDeltaMovement());
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    public void a(@NotNull nA nAVar, @NotNull LocalPlayer localPlayer) {
        nE<?> nEVarB = nAVar.b();
        if (this.fd) {
            this.je -= nEVarB.jK;
        } else if (this.fe) {
            this.je += nEVarB.jL;
        } else {
            this.je *= nEVarB.jN;
        }
        this.je = Mth.clamp(this.je, -1.0f, 1.0f);
        if (this.fb) {
            this.jd += nEVarB.jD;
        } else if (this.fc) {
            this.jd -= nEVarB.jE;
        } else {
            this.jd *= nEVarB.jG;
        }
        nAVar.setYRot(nAVar.getYRot() + Mth.clamp(a(nEVarB), -nEVarB.jP, nEVarB.jO));
        float f = nEVarB.jI;
        float f2 = -nEVarB.jJ;
        if (this.fd || this.fe) {
            f *= nEVarB.jM;
            f2 *= nEVarB.jM;
        }
        if (this.ff) {
            f *= nEVarB.jF;
            f2 *= nEVarB.jF;
        }
        if (this.jd > f) {
            this.jd = f;
        } else if (this.jd < f2) {
            this.jd = f2;
        }
        nAVar.move(MoverType.SELF, new Vec3(Mth.sin((-nAVar.getYRot()) * 0.017453292f) * this.jd, 0.0d, Mth.cos(nAVar.getYRot() * 0.017453292f) * this.jd));
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    public float a(@NotNull nE<?> nEVar) {
        return this.je;
    }
}
