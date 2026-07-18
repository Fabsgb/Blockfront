package com.boehmod.blockfront;

import javax.annotation.Nonnull;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.eZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eZ.class */
public class C0277eZ extends AbstractC0264eM implements InterfaceC0354fx {

    /* JADX INFO: renamed from: eE */
    private static final float f2107eE = 0.005f;

    /* JADX INFO: renamed from: eF */
    private static final float f2108eF = 0.0625f;

    /* JADX INFO: renamed from: eG */
    private static final float f2109eG = 4.0f;

    /* JADX INFO: renamed from: e */
    @Nonnull
    private final Vector3f f2110e;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Quaternionf f2111c;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final Vector3d f2112e;

    protected C0277eZ(@Nonnull ClientLevel clientLevel, double d, double d2, double d3, @Nonnull Direction direction, @Nonnull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, 0.0d, 0.0d, 0.0d, spriteSet);
        this.f2110e = new Vector3f();
        this.f2111c = new Quaternionf();
        this.f2112e = new Vector3d();
        this.quadSize = 1.0f;
        this.lifetime = (Minecraft.useFancyGraphics() ? 8 : 4) * 20;
        this.zd = 0.0d;
        this.yd = 0.0d;
        this.xd = 0.0d;
        this.hasPhysics = false;
        scale(f2108eF);
        float f = 0.0f;
        float f2 = 0.0f;
        switch (AnonymousClass1.f2113i[direction.ordinal()]) {
            case 1:
                this.f2110e.set(-0.005f, 0.0f, 0.0f);
                f2 = 90.0f;
                break;
            case 2:
                this.f2110e.set(f2107eE, 0.0f, 0.0f);
                f2 = -90.0f;
                break;
            case 3:
                this.f2110e.set(0.0f, 0.0f, -0.005f);
                break;
            case 4:
                this.f2110e.set(0.0f, 0.0f, f2107eE);
                f2 = 180.0f;
                break;
            case 5:
                this.f2110e.set(0.0f, f2107eE, 0.0f);
                f = 90.0f;
                break;
            case 6:
                this.f2110e.set(0.0f, -0.005f, 0.0f);
                f = -90.0f;
                break;
        }
        if (direction == Direction.UP || direction == Direction.DOWN) {
            this.x -= this.x % 0.0625d;
            this.z -= this.z % 0.0625d;
        } else {
            this.x -= this.x % 0.0625d;
            this.y -= this.y % 0.0625d;
            this.z -= this.z % 0.0625d;
        }
        this.f2110e.add(this.random.nextFloat() / 1000.0f, this.random.nextFloat() / 1000.0f, this.random.nextFloat() / 1000.0f);
        this.f2111c.rotateY((float) Math.toRadians(f2)).rotateX((float) Math.toRadians(f));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.eZ$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eZ$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: i */
        static final /* synthetic */ int[] f2113i = new int[Direction.values().length];

        static {
            try {
                f2113i[Direction.WEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2113i[Direction.EAST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2113i[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2113i[Direction.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2113i[Direction.UP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2113i[Direction.DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM
    public void tick() {
        super.m1455ax();
        this.alpha = Math.max(0.0f, 1.0f - (this.age / (this.lifetime - 4.0f)));
        if (this.age >= this.lifetime) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM, com.boehmod.blockfront.InterfaceC0345fo
    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3dc mo1458a(float f) {
        Vector3dc vector3dcMo1458a = super.mo1458a(f);
        return this.f2112e.set(vector3dcMo1458a.x() + ((double) this.f2110e.x), vector3dcMo1458a.y() + ((double) this.f2110e.y), vector3dcMo1458a.z() + ((double) this.f2110e.z));
    }

    @Override // com.boehmod.blockfront.InterfaceC0354fx
    @NotNull
    /* JADX INFO: renamed from: a */
    public Quaternionf mo1454a(float f) {
        return this.f2111c;
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM, com.boehmod.blockfront.InterfaceC0345fo, com.boehmod.blockfront.InterfaceC0318fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0316fL mo1452a() {
        return InterfaceC0316fL.f2338d;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.eZ$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eZ$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: l */
        @Nonnull
        private final SpriteSet f2114l;

        public a(@Nonnull SpriteSet spriteSet) {
            this.f2114l = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0277eZ(clientLevel, d, d2, d3, Direction.values()[(int) d4], this.f2114l);
        }
    }
}
