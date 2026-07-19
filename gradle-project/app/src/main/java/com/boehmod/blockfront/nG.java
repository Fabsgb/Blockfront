package com.boehmod.blockfront;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nG.class */
public class nG extends AbstractC0375nx<AbstractC0377nz> {
    public float jS = 0.0f;

    @Override // com.boehmod.blockfront.AbstractC0375nx
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull AbstractC0377nz abstractC0377nz) {
        if (!abstractC0377nz.level().isClientSide) {
            abstractC0377nz.setDeltaMovement(Vec3.ZERO);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    @NotNull
    public Vec2 a(@NotNull AbstractC0377nz abstractC0377nz) {
        return Vec2.ZERO;
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Vec2 mo737b(@NotNull AbstractC0377nz abstractC0377nz) {
        return Vec2.ZERO;
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    public void a(@NotNull AbstractC0377nz abstractC0377nz, boolean z) {
        float fMin = 1.0f - Math.min(abstractC0377nz.ay() / (abstractC0377nz.b().jI / 1.5f), 1.0f);
        if (!abstractC0377nz.isNoGravity()) {
            abstractC0377nz.setDeltaMovement(abstractC0377nz.getDeltaMovement().add(0.0d, -0.03d, 0.0d).multiply(0.5d, fMin, 0.5d));
            if (abstractC0377nz.getDeltaMovement().y > 0.0d) {
                abstractC0377nz.setDeltaMovement(abstractC0377nz.getDeltaMovement().multiply(1.0d, 0.0d, 1.0d));
            }
        }
        abstractC0377nz.move(MoverType.SELF, abstractC0377nz.getDeltaMovement());
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    public void a(@NotNull AbstractC0377nz abstractC0377nz, @NotNull LocalPlayer localPlayer) {
        nE nEVarB = abstractC0377nz.b();
        float f = this.jd / nEVarB.jI;
        if (this.fb) {
            this.jd += nEVarB.jD;
        } else if (this.fc) {
            this.jd -= nEVarB.jE;
        }
        if (this.jd > nEVarB.jI) {
            this.jd = nEVarB.jI;
        }
        nEVarB.jI = 1.0f;
        if (this.jd < 0.0f) {
            this.jd = 0.0f;
        }
        float f2 = 0.05f * f;
        float xRot = abstractC0377nz.getXRot();
        float yRot = abstractC0377nz.getYRot();
        float f3 = -localPlayer.getXRot();
        float yHeadRot = localPlayer.getYHeadRot();
        float fLerp = Mth.lerp(f2, xRot, f3);
        float fLerp2 = Mth.lerp(f2 / 4.0f, yRot, yHeadRot);
        abstractC0377nz.setXRot(fLerp);
        abstractC0377nz.setYRot(fLerp2);
        this.je = this.jS * this.jd;
        abstractC0377nz.move(MoverType.SELF, new Vec3(Mth.sin((-abstractC0377nz.getYRot()) * 0.017453292f) * this.jd, Mth.cos((-(abstractC0377nz.getXRot() - 90.0f)) * 0.017453292f) * this.jd, Mth.cos(abstractC0377nz.getYRot() * 0.017453292f) * this.jd));
    }

    @Override // com.boehmod.blockfront.AbstractC0375nx
    public float a(@NotNull nE<?> nEVar) {
        return this.je;
    }
}
