package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fp.class */
@OnlyIn(Dist.CLIENT)
public class C0347fp extends AbstractC0312fG {

    /* JADX INFO: renamed from: n */
    private final SpriteSet f2467n;

    protected C0347fp(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, 0.0d, 0.0d, 0.0d, spriteSet);
        this.friction = 0.96f;
        this.f2467n = spriteSet;
        this.xd *= 0.10000000149011612d;
        this.yd *= 0.10000000149011612d;
        this.zd *= 0.10000000149011612d;
        this.xd += d4;
        this.yd += d5;
        this.zd += d6;
        float fRandom = 1.0f - ((float) (Math.random() * 0.30000001192092896d));
        this.rCol = fRandom;
        this.gCol = fRandom;
        this.bCol = fRandom;
        this.quadSize *= 1.875f;
        this.lifetime = (int) Math.max(((int) (8.0d / ((Math.random() * 0.8d) + 0.3d))) * 2.5f, 1.0f);
        this.hasPhysics = false;
        setSpriteFromAge(spriteSet);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public float getQuadSize(float f) {
        return this.quadSize * Mth.clamp(((this.age + f) / this.lifetime) * 32.0f, 0.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2530a;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.m1693aD();
        if (!this.removed) {
            setSpriteFromAge(this.f2467n);
            Player nearestPlayer = this.level.getNearestPlayer(this.x, this.y, this.z, 2.0d, false);
            if (nearestPlayer != null) {
                double y = nearestPlayer.getY();
                if (this.y > y) {
                    this.y += (y - this.y) * 0.2d;
                    this.yd += (nearestPlayer.getDeltaMovement().y - this.yd) * 0.2d;
                    setPos(this.x, this.y, this.z);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fp$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fp$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: o */
        private final SpriteSet f2468o;

        public a(SpriteSet spriteSet) {
            this.f2468o = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0347fp(clientLevel, d, d2, d3, d4, d5, d6, this.f2468o);
        }
    }
}
