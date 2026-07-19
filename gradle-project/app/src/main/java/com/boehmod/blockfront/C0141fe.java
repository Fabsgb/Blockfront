package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.FastColor;
import net.minecraft.world.level.biome.Biome;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fe.class */
public class C0141fe extends AbstractC0153fq {
    protected C0141fe(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.xd = 0.0d;
        this.yd = 0.0d;
        this.zd = 0.0d;
        this.quadSize = 0.1f;
        this.lifetime = 160;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        setSize(0.01f, 0.01f);
        int foliageColor = ((Biome) clientLevel.getBiome(BlockPos.containing(d, d2, d3)).value()).getFoliageColor();
        this.rCol = FastColor.ARGB32.blue(foliageColor) / 255.0f;
        this.gCol = FastColor.ARGB32.green(foliageColor) / 255.0f;
        this.bCol = FastColor.ARGB32.red(foliageColor) / 255.0f;
        this.hasPhysics = false;
        this.alpha = 0.0f;
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        this.xd = -0.03999999910593033d;
        this.yd = -0.07999999821186066d;
        this.zd = -0.03999999910593033d;
        super.ax();
        this.alpha = C0634xm.d(this.alpha, this.age >= this.lifetime / 2 ? 0.0f : 1.0f, 0.025f);
        if (this.age >= this.lifetime && this.alpha <= 0.0f) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        return fL.b;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fe$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fe$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet r;

        public a(SpriteSet spriteSet) {
            this.r = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0141fe(clientLevel, d, d2, d3, d4, d5, d6, this.r);
        }
    }
}
