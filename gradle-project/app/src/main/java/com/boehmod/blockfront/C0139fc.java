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

/* JADX INFO: renamed from: com.boehmod.blockfront.fc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fc.class */
public class C0139fc extends fD {
    private static final float eH = 8.0f;
    private float eI;

    protected C0139fc(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.eI = 0.0f;
        setSize(0.1f, 0.1f);
        this.quadSize = 3.0f + (2.0f * clientLevel.random.nextFloat());
        this.eA = this.quadSize;
        this.alpha = 0.0f;
        float fNextFloat = 0.5f + (0.5f * clientLevel.random.nextFloat());
        this.bCol = fNextFloat;
        this.gCol = fNextFloat;
        this.rCol = fNextFloat;
        this.lifetime = 400;
        this.xd = d4;
        this.zd = d6;
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.tick();
        float fClamp = Mth.clamp(Mth.sqrt((float) Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().distanceToSqr(this.x, this.y, this.z)) / 8.0f, 0.0f, 1.0f);
        this.x -= this.xd;
        this.z -= this.zd;
        this.eI = C0634xm.d(this.eI, this.age >= this.lifetime / 2 ? 0.0f : 0.2f, 0.005f);
        if (this.eI <= 0.0f) {
            remove();
        }
        this.alpha = this.eI * fClamp;
    }

    @Override // com.boehmod.blockfront.fD, com.boehmod.blockfront.eM
    @NotNull
    public ParticleRenderType getRenderType() {
        return super.getRenderType();
    }

    @Override // com.boehmod.blockfront.eM
    public int getLightColor(float f) {
        return 15728880;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fc$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fc$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet p;

        public a(SpriteSet spriteSet) {
            this.p = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0139fc(clientLevel, d, d2, d3, 0.025f * clientLevel.random.nextFloat(), 0.0d, 0.025f * clientLevel.random.nextFloat(), this.p);
        }
    }
}
