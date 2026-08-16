package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.fB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fB.class */
public abstract class AbstractC0307fB extends AbstractC0332fa implements InterfaceC0319fN {

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final Quaternionf f2389d = new Quaternionf().rotateX((float) Math.toRadians(90.0d));

    /* JADX INFO: renamed from: eR */
    private static final float f2390eR = 5.0E-5f;

    /* JADX INFO: renamed from: eS */
    private static final float f2391eS = 0.0035f;

    /* JADX INFO: renamed from: eT */
    private static final float f2392eT = 0.002f;

    /* JADX INFO: renamed from: eU */
    private static final float f2393eU = 0.5f;

    /* JADX INFO: renamed from: eV */
    private static final float f2394eV = 0.6f;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final Vector3d f2395f;

    protected AbstractC0307fB(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.f2395f = new Vector3d();
        this.bCol = 1.0f;
        this.gCol = 1.0f;
        this.rCol = 1.0f;
        this.quadSize = 0.01f;
        this.lifetime = 1200;
        this.gravity = 1.0f;
        setSize(0.8f, 0.01f);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.m1693aD();
        if (this.hasPhysics) {
            if (this.onGround) {
                this.hasPhysics = false;
                this.gravity = 0.0f;
                this.zd = 0.0d;
                this.yd = 0.0d;
                this.xd = 0.0d;
            } else {
                if (this.yd > 0.0d) {
                    this.yd = 0.0d;
                }
                this.xd = 0.0d;
                this.zd = 0.0d;
            }
        }
        this.alpha = C1270xJ.m7161d(this.alpha, 0.0f, Minecraft.useFancyGraphics() ? f2392eT : f2391eS);
        if (this.alpha <= 0.0f) {
            remove();
        } else if (!this.removed) {
            this.quadSize = Mth.lerp(0.6f, this.quadSize, 0.5f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE
    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3dc mo1657a(float f) {
        Vector3dc vector3dcMo1657a = super.mo1657a(f);
        return this.f2395f.set(vector3dcMo1657a.x(), vector3dcMo1657a.y() + ((double) (f2390eR * this.age)), vector3dcMo1657a.z());
    }

    @Override // com.boehmod.blockfront.InterfaceC0319fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public Quaternionf mo1547a(float f) {
        return f2389d;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2533d;
    }
}
