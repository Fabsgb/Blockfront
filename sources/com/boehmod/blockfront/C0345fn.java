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

/* JADX INFO: renamed from: com.boehmod.blockfront.fn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fn.class */
public class C0345fn extends AbstractC0332fa implements InterfaceC0319fN {

    /* JADX INFO: renamed from: eH */
    private static final float f2458eH = 0.005f;

    /* JADX INFO: renamed from: eI */
    private static final float f2459eI = 0.0625f;

    /* JADX INFO: renamed from: eJ */
    private static final float f2460eJ = 4.0f;

    /* JADX INFO: renamed from: e */
    @Nonnull
    private final Vector3f f2461e;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Quaternionf f2462c;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final Vector3d f2463e;

    protected C0345fn(@Nonnull ClientLevel clientLevel, double d, double d2, double d3, @Nonnull Direction direction, @Nonnull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, 0.0d, 0.0d, 0.0d, spriteSet);
        this.f2461e = new Vector3f();
        this.f2462c = new Quaternionf();
        this.f2463e = new Vector3d();
        this.quadSize = 1.0f;
        this.lifetime = (Minecraft.useFancyGraphics() ? 8 : 4) * 20;
        this.zd = 0.0d;
        this.yd = 0.0d;
        this.xd = 0.0d;
        this.hasPhysics = false;
        scale(f2459eI);
        float f = 0.0f;
        float f2 = 0.0f;
        switch (AnonymousClass1.f2464k[direction.ordinal()]) {
            case 1:
                this.f2461e.set(-0.005f, 0.0f, 0.0f);
                f2 = 90.0f;
                break;
            case 2:
                this.f2461e.set(f2458eH, 0.0f, 0.0f);
                f2 = -90.0f;
                break;
            case 3:
                this.f2461e.set(0.0f, 0.0f, -0.005f);
                break;
            case 4:
                this.f2461e.set(0.0f, 0.0f, f2458eH);
                f2 = 180.0f;
                break;
            case 5:
                this.f2461e.set(0.0f, f2458eH, 0.0f);
                f = 90.0f;
                break;
            case 6:
                this.f2461e.set(0.0f, -0.005f, 0.0f);
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
        this.f2461e.add(this.random.nextFloat() / 1000.0f, this.random.nextFloat() / 1000.0f, this.random.nextFloat() / 1000.0f);
        this.f2462c.rotateY((float) Math.toRadians(f2)).rotateX((float) Math.toRadians(f));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fn$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fn$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: k */
        static final /* synthetic */ int[] f2464k = new int[Direction.values().length];

        static {
            try {
                f2464k[Direction.WEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2464k[Direction.EAST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2464k[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2464k[Direction.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2464k[Direction.UP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2464k[Direction.DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.m1693aD();
        this.alpha = Math.max(0.0f, 1.0f - (this.age / (this.lifetime - 4.0f)));
        if (this.age >= this.lifetime) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE
    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3dc mo1657a(float f) {
        Vector3dc vector3dcMo1657a = super.mo1657a(f);
        return this.f2463e.set(vector3dcMo1657a.x() + ((double) this.f2461e.x), vector3dcMo1657a.y() + ((double) this.f2461e.y), vector3dcMo1657a.z() + ((double) this.f2461e.z));
    }

    @Override // com.boehmod.blockfront.InterfaceC0319fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public Quaternionf mo1547a(float f) {
        return this.f2462c;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2533d;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fn$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fn$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: l */
        @Nonnull
        private final SpriteSet f2465l;

        public a(@Nonnull SpriteSet spriteSet) {
            this.f2465l = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0345fn(clientLevel, d, d2, d3, Direction.values()[(int) d4], this.f2465l);
        }
    }
}
