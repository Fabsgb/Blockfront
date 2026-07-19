package com.boehmod.blockfront;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nF.class */
public class nF extends AbstractC0375nx<AbstractC0376ny> {
    public static final float jR = 3.0f;

    @Override // com.boehmod.blockfront.AbstractC0375nx
    public void c(@NotNull AbstractC0376ny abstractC0376ny) {
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    @NotNull
    public Vec2 a(@NotNull AbstractC0376ny abstractC0376ny) {
        return new Vec2(this.je, this.je);
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    @NotNull
    /* JADX INFO: renamed from: b */
    public Vec2 mo737b(@NotNull AbstractC0376ny abstractC0376ny) {
        return new Vec2(abstractC0376ny.ay(), abstractC0376ny.ay()).scale(3.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    public void a(@NotNull AbstractC0376ny abstractC0376ny, boolean z) {
        if (!abstractC0376ny.isNoGravity()) {
            abstractC0376ny.setDeltaMovement(abstractC0376ny.getDeltaMovement().add(0.0d, -0.03d, 0.0d).multiply(0.5d, 1.0d, 0.5d));
            if (abstractC0376ny.getDeltaMovement().y > 0.0d) {
                abstractC0376ny.setDeltaMovement(abstractC0376ny.getDeltaMovement().multiply(1.0d, 0.0d, 1.0d));
            }
        }
        abstractC0376ny.move(MoverType.SELF, abstractC0376ny.getDeltaMovement());
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    public void a(@NotNull AbstractC0376ny abstractC0376ny, @NotNull LocalPlayer localPlayer) {
        nE<AbstractC0376ny> nEVarM741b = abstractC0376ny.m741b();
        if (this.fd) {
            this.je -= nEVarM741b.jK;
        } else if (this.fe) {
            this.je += nEVarM741b.jL;
        } else {
            this.je *= nEVarM741b.jN;
        }
        this.je = Mth.clamp(this.je, -nEVarM741b.jO, nEVarM741b.jP);
        abstractC0376ny.setYRot(abstractC0376ny.getYRot() + a(nEVarM741b));
        float f = nEVarM741b.jI;
        float f2 = -nEVarM741b.jJ;
        if (this.fd || this.fe) {
            f *= nEVarM741b.jM;
            f2 *= nEVarM741b.jM;
        }
        if (this.ff) {
            f *= nEVarM741b.jF;
            f2 *= nEVarM741b.jF;
        }
        if (this.fb) {
            this.jd = C0634xm.d(this.jd, f, nEVarM741b.jD);
        } else if (this.fc) {
            this.jd = C0634xm.d(this.jd, f2, nEVarM741b.jE);
        } else {
            this.jd *= nEVarM741b.jG;
        }
        if (this.jd > f) {
            this.jd = f;
        } else if (this.jd < f2) {
            this.jd = f2;
        }
        abstractC0376ny.move(MoverType.SELF, new Vec3(Mth.sin((-abstractC0376ny.getYRot()) * 0.017453292f) * this.jd, 0.0d, Mth.cos(abstractC0376ny.getYRot() * 0.017453292f) * this.jd));
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    public float a(@NotNull nE<?> nEVar) {
        return this.je * (this.jd / (this.fc ? nEVar.jJ : nEVar.jI));
    }
}
