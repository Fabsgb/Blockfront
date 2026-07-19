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

/* JADX INFO: renamed from: com.boehmod.blockfront.fw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fw.class */
public class C0159fw extends fH {
    private final int iv;

    protected C0159fw(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
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
        this.iv = clientLevel.getHeight(Heightmap.Types.MOTION_BLOCKING, Mth.floor(d), Mth.floor(d3));
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.ax();
        this.xd = 0.0d;
        this.yd = -this.gravity;
        this.zd = 0.0d;
        this.alpha = C0634xm.d(this.alpha, 0.3f, 0.25f);
        if (this.y <= this.iv) {
            this.level.addParticle(ParticleTypes.RAIN, this.x, this.iv, this.z, 0.0d, 0.0d, 0.0d);
            remove();
        }
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        return fL.b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fw$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fw$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet E;

        public a(SpriteSet spriteSet) {
            this.E = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0159fw(clientLevel, d, d2, d3, d4, d5, d6, this.E);
        }
    }
}
