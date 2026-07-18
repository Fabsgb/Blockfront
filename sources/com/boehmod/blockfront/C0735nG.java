package com.boehmod.blockfront;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nG.class */
public class C0735nG extends AbstractC0778nx<AbstractC0780nz> {

    /* JADX INFO: renamed from: jS */
    public float f3971jS = 0.0f;

    @Override // com.boehmod.blockfront.AbstractC0778nx
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3356c(@NotNull AbstractC0780nz abstractC0780nz) {
        if (!abstractC0780nz.level().isClientSide) {
            abstractC0780nz.setDeltaMovement(Vec3.ZERO);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Vec2 mo3357a(@NotNull AbstractC0780nz abstractC0780nz) {
        return Vec2.ZERO;
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Vec2 mo3358b(@NotNull AbstractC0780nz abstractC0780nz) {
        return Vec2.ZERO;
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3359a(@NotNull AbstractC0780nz abstractC0780nz, boolean z) {
        float fMin = 1.0f - Math.min(abstractC0780nz.m3505ay() / (abstractC0780nz.m3498b().f3957jI / 1.5f), 1.0f);
        if (!abstractC0780nz.isNoGravity()) {
            abstractC0780nz.setDeltaMovement(abstractC0780nz.getDeltaMovement().add(0.0d, -0.03d, 0.0d).multiply(0.5d, fMin, 0.5d));
            if (abstractC0780nz.getDeltaMovement().y > 0.0d) {
                abstractC0780nz.setDeltaMovement(abstractC0780nz.getDeltaMovement().multiply(1.0d, 0.0d, 1.0d));
            }
        }
        abstractC0780nz.move(MoverType.SELF, abstractC0780nz.getDeltaMovement());
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3360a(@NotNull AbstractC0780nz abstractC0780nz, @NotNull LocalPlayer localPlayer) {
        C0733nE c0733nEB = abstractC0780nz.m3498b();
        float f = this.f4146jd / c0733nEB.f3957jI;
        if (this.f4148fb) {
            this.f4146jd += c0733nEB.f3952jD;
        } else if (this.f4149fc) {
            this.f4146jd -= c0733nEB.f3953jE;
        }
        if (this.f4146jd > c0733nEB.f3957jI) {
            this.f4146jd = c0733nEB.f3957jI;
        }
        c0733nEB.f3957jI = 1.0f;
        if (this.f4146jd < 0.0f) {
            this.f4146jd = 0.0f;
        }
        float f2 = 0.05f * f;
        float xRot = abstractC0780nz.getXRot();
        float yRot = abstractC0780nz.getYRot();
        float f3 = -localPlayer.getXRot();
        float yHeadRot = localPlayer.getYHeadRot();
        float fLerp = Mth.lerp(f2, xRot, f3);
        float fLerp2 = Mth.lerp(f2 / 4.0f, yRot, yHeadRot);
        abstractC0780nz.setXRot(fLerp);
        abstractC0780nz.setYRot(fLerp2);
        this.f4147je = this.f3971jS * this.f4146jd;
        abstractC0780nz.move(MoverType.SELF, new Vec3(Mth.sin((-abstractC0780nz.getYRot()) * 0.017453292f) * this.f4146jd, Mth.cos((-(abstractC0780nz.getXRot() - 90.0f)) * 0.017453292f) * this.f4146jd, Mth.cos(abstractC0780nz.getYRot() * 0.017453292f) * this.f4146jd));
    }

    @Override // com.boehmod.blockfront.AbstractC0778nx
    /* JADX INFO: renamed from: a */
    public float mo3361a(@NotNull C0733nE<?> c0733nE) {
        return this.f4147je;
    }
}
