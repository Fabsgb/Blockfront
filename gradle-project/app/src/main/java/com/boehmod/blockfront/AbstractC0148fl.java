package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.fl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fl.class */
public abstract class AbstractC0148fl extends eM implements InterfaceC0160fx {

    @NotNull
    private static final Quaternionf d = new Quaternionf().rotateX((float) Math.toRadians(90.0d));
    private static final float eO = 5.0E-5f;
    private static final float eP = 0.0035f;
    private static final float eQ = 0.002f;
    private static final float eR = 0.5f;
    private static final float eS = 0.6f;

    @NotNull
    private final Vector3d f;

    protected AbstractC0148fl(@NotNull ClientLevel clientLevel, double d2, double d3, double d4, double d5, double d6, double d7, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d2, d3, d4, d5, d6, d7, spriteSet);
        this.f = new Vector3d();
        this.bCol = 1.0f;
        this.gCol = 1.0f;
        this.rCol = 1.0f;
        this.quadSize = 0.01f;
        this.lifetime = 1200;
        this.gravity = 1.0f;
        setSize(0.8f, 0.01f);
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.ax();
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
        this.alpha = C0634xm.d(this.alpha, 0.0f, Minecraft.useFancyGraphics() ? eQ : eP);
        if (this.alpha <= 0.0f) {
            remove();
        } else if (!this.removed) {
            this.quadSize = Mth.lerp(0.6f, this.quadSize, 0.5f);
        }
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo
    @NotNull
    public Vector3dc a(float f) {
        Vector3dc vector3dcA = super.a(f);
        return this.f.set(vector3dcA.x(), vector3dcA.y() + ((double) (eO * this.age)), vector3dcA.z());
    }

    @Override // com.boehmod.blockfront.InterfaceC0160fx
    @NotNull
    /* JADX INFO: renamed from: a */
    public Quaternionf mo373a(float f) {
        return d;
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        return fL.d;
    }
}
