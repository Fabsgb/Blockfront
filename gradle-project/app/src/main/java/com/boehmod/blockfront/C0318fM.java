package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.Heightmap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fM.class */
public class C0318fM extends AbstractC0329fX {

    /* JADX INFO: renamed from: eX */
    private static final float f2404eX = 1.5f;

    /* JADX INFO: renamed from: eY */
    private static final float f2405eY = 0.01f;

    /* JADX INFO: renamed from: eZ */
    private static final float f2406eZ = 0.35f;

    /* JADX INFO: renamed from: jP */
    private static final int f2407jP = 80;

    /* JADX INFO: renamed from: jQ */
    private final int f2408jQ;

    protected C0318fM(@NotNull ClientLevel clientLevel, double d, double d2, double d3, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, 0.0d, 0.0d, 0.0d, spriteSet);
        this.gravity = 1.5f;
        this.yd = -this.gravity;
        this.quadSize = 0.35f;
        this.lifetime = 80;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        this.alpha = 0.0f;
        setSize(f2405eY, f2405eY);
        this.hasPhysics = false;
        this.f2408jQ = clientLevel.getHeight(Heightmap.Types.MOTION_BLOCKING, Mth.floor(d), Mth.floor(d3));
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.m1693aD();
        this.alpha = C1270xJ.m7161d(this.alpha, 0.3f, 0.25f);
        if (this.y <= this.f2408jQ) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2531b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fM$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fM$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: I */
        private final SpriteSet f2409I;

        public a(SpriteSet spriteSet) {
            this.f2409I = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0318fM(clientLevel, d, d2, d3, this.f2409I);
        }
    }
}
