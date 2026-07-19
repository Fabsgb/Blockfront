package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fC.class */
@OnlyIn(Dist.CLIENT)
public class fC extends AbstractC0153fq {
    private static final int iw = 60;
    private static final int ix = 3;

    @NotNull
    private final BlockPos.MutableBlockPos b;

    public fC(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.b = new BlockPos.MutableBlockPos();
        this.lifetime = 60;
        this.bCol = 1.0f;
        this.gCol = 1.0f;
        this.rCol = 1.0f;
        this.alpha = 1.0f;
        setSize(0.8f, 0.8f);
        this.quadSize = 1.0f + (this.random.nextFloat() * 0.5f);
        this.xd = d4;
        this.yd = d5;
        this.zd = d6;
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.tick();
        this.x += this.xd;
        this.y += this.yd;
        this.z += this.zd;
        this.xd *= 0.8999999761581421d;
        this.yd = 0.004000000189989805d;
        this.zd *= 0.8999999761581421d;
        if (this.age >= this.lifetime) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.eM
    protected int getLightColor(float f) {
        ClientLevel clientLevel = this.level;
        BlockPos.MutableBlockPos mutableBlockPos = this.b.set(Mth.floor(this.x), Mth.floor(this.y), Mth.floor(this.z));
        for (int i = 0; i < 3 && clientLevel.getBlockState(mutableBlockPos).isCollisionShapeFullBlock(clientLevel, mutableBlockPos); i++) {
            mutableBlockPos.move(Direction.UP);
        }
        if (clientLevel.hasChunkAt(mutableBlockPos)) {
            return LevelRenderer.getLightColor(clientLevel, mutableBlockPos);
        }
        return 0;
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        return fL.a;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fC$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet J;

        public a(@NotNull SpriteSet spriteSet) {
            this.J = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new fC(clientLevel, d, d2, d3, d4, d5, d6, this.J);
        }
    }
}
