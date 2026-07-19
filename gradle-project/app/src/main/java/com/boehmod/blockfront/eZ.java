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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eZ.class */
public class eZ extends eM implements InterfaceC0160fx {
    private static final float eE = 0.005f;
    private static final float eF = 0.0625f;
    private static final float eG = 4.0f;

    @Nonnull
    private final Vector3f e;

    @NotNull
    private final Quaternionf c;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NotNull
    private final Vector3d f117e;

    protected eZ(@Nonnull ClientLevel clientLevel, double d, double d2, double d3, @Nonnull Direction direction, @Nonnull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, 0.0d, 0.0d, 0.0d, spriteSet);
        this.e = new Vector3f();
        this.c = new Quaternionf();
        this.f117e = new Vector3d();
        this.quadSize = 1.0f;
        this.lifetime = (Minecraft.useFancyGraphics() ? 8 : 4) * 20;
        this.zd = 0.0d;
        this.yd = 0.0d;
        this.xd = 0.0d;
        this.hasPhysics = false;
        scale(eF);
        float f = 0.0f;
        float f2 = 0.0f;
        switch (AnonymousClass1.i[direction.ordinal()]) {
            case 1:
                this.e.set(-0.005f, 0.0f, 0.0f);
                f2 = 90.0f;
                break;
            case 2:
                this.e.set(eE, 0.0f, 0.0f);
                f2 = -90.0f;
                break;
            case 3:
                this.e.set(0.0f, 0.0f, -0.005f);
                break;
            case 4:
                this.e.set(0.0f, 0.0f, eE);
                f2 = 180.0f;
                break;
            case 5:
                this.e.set(0.0f, eE, 0.0f);
                f = 90.0f;
                break;
            case 6:
                this.e.set(0.0f, -0.005f, 0.0f);
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
        this.e.add(this.random.nextFloat() / 1000.0f, this.random.nextFloat() / 1000.0f, this.random.nextFloat() / 1000.0f);
        this.c.rotateY((float) Math.toRadians(f2)).rotateX((float) Math.toRadians(f));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.eZ$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eZ$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] i = new int[Direction.values().length];

        static {
            try {
                i[Direction.WEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                i[Direction.EAST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                i[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                i[Direction.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                i[Direction.UP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                i[Direction.DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.ax();
        this.alpha = Math.max(0.0f, 1.0f - (this.age / (this.lifetime - 4.0f)));
        if (this.age >= this.lifetime) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo
    @NotNull
    public Vector3dc a(float f) {
        Vector3dc vector3dcA = super.a(f);
        return this.f117e.set(vector3dcA.x() + ((double) this.e.x), vector3dcA.y() + ((double) this.e.y), vector3dcA.z() + ((double) this.e.z));
    }

    @Override // com.boehmod.blockfront.InterfaceC0160fx
    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Quaternionf mo373a(float f) {
        return this.c;
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        return fL.d;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eZ$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        @Nonnull
        private final SpriteSet l;

        public a(@Nonnull SpriteSet spriteSet) {
            this.l = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new eZ(clientLevel, d, d2, d3, Direction.values()[(int) d4], this.l);
        }
    }
}
