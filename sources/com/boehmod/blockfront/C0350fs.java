package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fs.class */
public class C0350fs extends C0325fT {

    /* JADX INFO: renamed from: eK */
    private static final float f2473eK = 8.0f;

    /* JADX INFO: renamed from: eL */
    private float f2474eL;

    protected C0350fs(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.f2474eL = 0.0f;
        setSize(0.1f, 0.1f);
        this.quadSize = 3.0f + (2.0f * clientLevel.random.nextFloat());
        this.f2440eD = this.quadSize;
        this.alpha = 0.0f;
        float fNextFloat = 0.5f + (0.5f * clientLevel.random.nextFloat());
        this.bCol = fNextFloat;
        this.gCol = fNextFloat;
        this.rCol = fNextFloat;
        this.lifetime = 400;
        this.xd = d4;
        this.zd = d6;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.tick();
        float fClamp = Mth.clamp(Mth.sqrt((float) Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().distanceToSqr(this.x, this.y, this.z)) / 8.0f, 0.0f, 1.0f);
        this.x -= this.xd;
        this.z -= this.zd;
        this.f2474eL = C1270xJ.m7161d(this.f2474eL, this.age >= this.lifetime / 2 ? 0.0f : 0.2f, 0.005f);
        if (this.f2474eL <= 0.0f) {
            remove();
        }
        this.alpha = this.f2474eL * fClamp;
    }

    @Override // com.boehmod.blockfront.C0325fT, com.boehmod.blockfront.AbstractC0332fa
    @NotNull
    public ParticleRenderType getRenderType() {
        return super.getRenderType();
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public int getLightColor(float f) {
        return 15728880;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fs$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fs$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: t */
        private final SpriteSet f2475t;

        public a(SpriteSet spriteSet) {
            this.f2475t = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0350fs(clientLevel, d, d2, d3, 0.025f * clientLevel.random.nextFloat(), 0.0d, 0.025f * clientLevel.random.nextFloat(), this.f2475t);
        }
    }
}
