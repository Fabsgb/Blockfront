package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0750nU;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.phys.Vec2;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nT.class */
public abstract class AbstractC0749nT<V extends AbstractC0750nU> {

    /* JADX INFO: renamed from: fv */
    public boolean f4105fv;

    /* JADX INFO: renamed from: fw */
    public boolean f4106fw;

    /* JADX INFO: renamed from: fx */
    public boolean f4107fx;

    /* JADX INFO: renamed from: fy */
    public boolean f4108fy;

    /* JADX INFO: renamed from: fz */
    public boolean f4109fz;

    /* JADX INFO: renamed from: fA */
    public boolean f4110fA;

    /* JADX INFO: renamed from: jY */
    private float f4111jY;

    /* JADX INFO: renamed from: ka */
    private float f4113ka;

    /* JADX INFO: renamed from: kc */
    private float f4115kc;

    /* JADX INFO: renamed from: ke */
    private float f4117ke;

    /* JADX INFO: renamed from: nW */
    public int f4102nW = 0;

    /* JADX INFO: renamed from: jW */
    public float f4103jW = 0.0f;

    /* JADX INFO: renamed from: jX */
    public float f4104jX = 0.0f;

    /* JADX INFO: renamed from: jZ */
    private float f4112jZ = 0.0f;

    /* JADX INFO: renamed from: kb */
    private float f4114kb = 0.0f;

    /* JADX INFO: renamed from: kd */
    private float f4116kd = 0.0f;

    /* JADX INFO: renamed from: kf */
    private float f4118kf = 0.0f;

    /* JADX INFO: renamed from: c */
    public abstract void mo3418c(@NotNull V v);

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract Vec2 mo3420a(@NotNull V v);

    @NotNull
    /* JADX INFO: renamed from: b */
    public abstract Vec2 mo3421b(@NotNull V v);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract void mo3423a(@NotNull V v, boolean z);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract void mo3424a(@NotNull V v, @NotNull LocalPlayer localPlayer);

    /* JADX INFO: renamed from: a */
    public abstract float mo3425a(@NotNull C0809oa<?> c0809oa);

    /* JADX INFO: renamed from: u */
    public float m3413u(float f) {
        return C1270xJ.m7170f(this.f4115kc, this.f4116kd, f);
    }

    /* JADX INFO: renamed from: v */
    public float m3414v(float f) {
        return C1270xJ.m7170f(this.f4117ke, this.f4118kf, f);
    }

    /* JADX INFO: renamed from: w */
    public float m3415w(float f) {
        return C1270xJ.m7170f(this.f4111jY, this.f4112jZ, f);
    }

    /* JADX INFO: renamed from: x */
    public float m3416x(float f) {
        return C1270xJ.m7170f(this.f4113ka, this.f4114kb, f);
    }

    /* JADX INFO: renamed from: b */
    public void m3417b(@NotNull V v) {
        if (v.level().isClientSide()) {
            Vec2 vec2Mo3421b = mo3421b((AbstractC0750nU) v);
            this.f4116kd = this.f4115kc;
            this.f4118kf = this.f4117ke;
            this.f4115kc -= vec2Mo3421b.x;
            this.f4117ke += vec2Mo3421b.y;
            Vec2 vec2Mo3420a = mo3420a(v);
            this.f4112jZ = this.f4111jY;
            this.f4114kb = this.f4113ka;
            this.f4111jY = vec2Mo3420a.x;
            this.f4113ka = vec2Mo3420a.y;
        }
        mo3418c(v);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m3419a(@NotNull LocalPlayer localPlayer, @NotNull V v, boolean z) {
        if (z) {
            m3422k(localPlayer);
            mo3424a(v, localPlayer);
        }
        mo3423a(v, z);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: k */
    public void m3422k(@NotNull LocalPlayer localPlayer) {
        Input input = localPlayer.input;
        Minecraft minecraft = Minecraft.getInstance();
        this.f4107fx = input.left;
        this.f4108fy = input.right;
        this.f4105fv = input.up;
        this.f4106fw = input.down;
        this.f4109fz = minecraft.options.keySprint.isDown();
        this.f4110fA = input.jumping;
        int i = this.f4102nW;
        this.f4102nW = i + 1;
        if (i >= 5) {
            this.f4102nW = 0;
            C1169vO.m6648c(new C1208wA(this.f4105fv, this.f4106fw, this.f4107fx, this.f4108fy, this.f4109fz, this.f4110fA, this.f4103jW));
        }
    }
}
