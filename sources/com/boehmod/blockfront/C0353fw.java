package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.Heightmap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fw.class */
public class C0353fw extends AbstractC0312fH {

    /* JADX INFO: renamed from: iv */
    private final int f2434iv;

    protected C0353fw(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.gravity = 1.5f;
        this.quadSize = 0.35f;
        this.lifetime = 80;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        this.alpha = 0.0f;
        setSize(0.01f, 0.01f);
        this.hasPhysics = false;
        this.f2434iv = clientLevel.getHeight(Heightmap.Types.MOTION_BLOCKING, Mth.floor(d), Mth.floor(d3));
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM
    public void tick() {
        super.m1455ax();
        this.xd = 0.0d;
        this.yd = -this.gravity;
        this.zd = 0.0d;
        this.alpha = C1290xm.m7835d(this.alpha, 0.3f, 0.25f);
        if (this.y <= this.f2434iv) {
            this.level.addParticle(ParticleTypes.RAIN, this.x, this.f2434iv, this.z, 0.0d, 0.0d, 0.0d);
            remove();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM, com.boehmod.blockfront.InterfaceC0345fo, com.boehmod.blockfront.InterfaceC0318fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0316fL mo1452a() {
        return InterfaceC0316fL.f2336b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fw$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fw$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: E */
        private final SpriteSet f2435E;

        public a(SpriteSet spriteSet) {
            this.f2435E = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0353fw(clientLevel, d, d2, d3, d4, d5, d6, this.f2435E);
        }
    }
}
