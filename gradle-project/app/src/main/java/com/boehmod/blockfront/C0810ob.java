package com.boehmod.blockfront;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ob */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ob.class */
public class C0810ob extends AbstractC0749nT<AbstractC0750nU> {

    /* JADX INFO: renamed from: kK */
    public static final float f4398kK = 3.0f;

    @Override // com.boehmod.blockfront.AbstractC0749nT
    /* JADX INFO: renamed from: c */
    public void mo3418c(@NotNull AbstractC0750nU abstractC0750nU) {
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec2 mo3420a(@NotNull AbstractC0750nU abstractC0750nU) {
        return new Vec2(this.f4104jX, this.f4104jX);
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    @NotNull
    /* JADX INFO: renamed from: b */
    public Vec2 mo3421b(@NotNull AbstractC0750nU abstractC0750nU) {
        return new Vec2(abstractC0750nU.m3442aE(), abstractC0750nU.m3442aE()).scale(3.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    /* JADX INFO: renamed from: a */
    public void mo3423a(@NotNull AbstractC0750nU abstractC0750nU, boolean z) {
        if (!abstractC0750nU.isNoGravity()) {
            abstractC0750nU.setDeltaMovement(abstractC0750nU.getDeltaMovement().add(0.0d, -0.03d, 0.0d).multiply(0.5d, 1.0d, 0.5d));
            if (abstractC0750nU.getDeltaMovement().y > 0.0d) {
                abstractC0750nU.setDeltaMovement(abstractC0750nU.getDeltaMovement().multiply(1.0d, 0.0d, 1.0d));
            }
        }
        abstractC0750nU.move(MoverType.SELF, abstractC0750nU.getDeltaMovement());
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    /* JADX INFO: renamed from: a */
    public void mo3424a(@NotNull AbstractC0750nU abstractC0750nU, @NotNull LocalPlayer localPlayer) {
        C0809oa<AbstractC0750nU> c0809oaM3436b = abstractC0750nU.m3436b();
        if (this.f4107fx) {
            this.f4104jX -= c0809oaM3436b.f4387kD;
        } else if (this.f4108fy) {
            this.f4104jX += c0809oaM3436b.f4388kE;
        } else {
            this.f4104jX *= c0809oaM3436b.f4390kG;
        }
        this.f4104jX = Mth.clamp(this.f4104jX, -c0809oaM3436b.f4391kH, c0809oaM3436b.f4392kI);
        abstractC0750nU.setYRot(abstractC0750nU.getYRot() + mo3425a(c0809oaM3436b));
        float f = c0809oaM3436b.f4385kB;
        float f2 = -c0809oaM3436b.f4386kC;
        if (this.f4107fx || this.f4108fy) {
            f *= c0809oaM3436b.f4389kF;
            f2 *= c0809oaM3436b.f4389kF;
        }
        if (this.f4109fz) {
            f *= c0809oaM3436b.f4382ky;
            f2 *= c0809oaM3436b.f4382ky;
        }
        if (this.f4105fv) {
            this.f4103jW = C1270xJ.m7161d(this.f4103jW, f, c0809oaM3436b.f4380kw);
        } else if (this.f4106fw) {
            this.f4103jW = C1270xJ.m7161d(this.f4103jW, f2, c0809oaM3436b.f4381kx);
        } else {
            this.f4103jW *= c0809oaM3436b.f4383kz;
        }
        if (this.f4103jW > f) {
            this.f4103jW = f;
        } else if (this.f4103jW < f2) {
            this.f4103jW = f2;
        }
        abstractC0750nU.move(MoverType.SELF, new Vec3(Mth.sin((-abstractC0750nU.getYRot()) * 0.017453292f) * this.f4103jW, 0.0d, Mth.cos(abstractC0750nU.getYRot() * 0.017453292f) * this.f4103jW));
    }

    @Override // com.boehmod.blockfront.AbstractC0749nT
    /* JADX INFO: renamed from: a */
    public float mo3425a(@NotNull C0809oa<?> c0809oa) {
        return this.f4104jX * (this.f4103jW / (this.f4106fw ? c0809oa.f4386kC : c0809oa.f4385kB));
    }
}
