package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.fl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fl.class */
public abstract class AbstractC0342fl extends AbstractC0264eM implements InterfaceC0354fx {

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final Quaternionf f2419d = new Quaternionf().rotateX((float) Math.toRadians(90.0d));

    /* JADX INFO: renamed from: eO */
    private static final float f2420eO = 5.0E-5f;

    /* JADX INFO: renamed from: eP */
    private static final float f2421eP = 0.0035f;

    /* JADX INFO: renamed from: eQ */
    private static final float f2422eQ = 0.002f;

    /* JADX INFO: renamed from: eR */
    private static final float f2423eR = 0.5f;

    /* JADX INFO: renamed from: eS */
    private static final float f2424eS = 0.6f;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final Vector3d f2425f;

    protected AbstractC0342fl(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.f2425f = new Vector3d();
        this.bCol = 1.0f;
        this.gCol = 1.0f;
        this.rCol = 1.0f;
        this.quadSize = 0.01f;
        this.lifetime = 1200;
        this.gravity = 1.0f;
        setSize(0.8f, 0.01f);
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM
    public void tick() {
        super.m1455ax();
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
        this.alpha = C1290xm.m7835d(this.alpha, 0.0f, Minecraft.useFancyGraphics() ? f2422eQ : f2421eP);
        if (this.alpha <= 0.0f) {
            remove();
        } else if (!this.removed) {
            this.quadSize = Mth.lerp(0.6f, this.quadSize, 0.5f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM, com.boehmod.blockfront.InterfaceC0345fo
    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3dc mo1458a(float f) {
        Vector3dc vector3dcMo1458a = super.mo1458a(f);
        return this.f2425f.set(vector3dcMo1458a.x(), vector3dcMo1458a.y() + ((double) (f2420eO * this.age)), vector3dcMo1458a.z());
    }

    @Override // com.boehmod.blockfront.InterfaceC0354fx
    @NotNull
    /* JADX INFO: renamed from: a */
    public Quaternionf mo1454a(float f) {
        return f2419d;
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM, com.boehmod.blockfront.InterfaceC0345fo, com.boehmod.blockfront.InterfaceC0318fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0316fL mo1452a() {
        return InterfaceC0316fL.f2338d;
    }
}
