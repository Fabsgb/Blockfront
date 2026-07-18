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

/* JADX INFO: renamed from: com.boehmod.blockfront.fb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fb.class */
@OnlyIn(Dist.CLIENT)
public class C0332fb extends AbstractC0347fq {

    /* JADX INFO: renamed from: n */
    private final SpriteSet f2400n;

    protected C0332fb(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, 0.0d, 0.0d, 0.0d, spriteSet);
        this.friction = 0.96f;
        this.f2400n = spriteSet;
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

    @Override // com.boehmod.blockfront.AbstractC0264eM
    public float getQuadSize(float f) {
        return this.quadSize * Mth.clamp(((this.age + f) / this.lifetime) * 32.0f, 0.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM, com.boehmod.blockfront.InterfaceC0345fo, com.boehmod.blockfront.InterfaceC0318fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0316fL mo1452a() {
        return InterfaceC0316fL.f2335a;
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM
    public void tick() {
        super.m1455ax();
        if (!this.removed) {
            setSpriteFromAge(this.f2400n);
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

    /* JADX INFO: renamed from: com.boehmod.blockfront.fb$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fb$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: o */
        private final SpriteSet f2401o;

        public a(SpriteSet spriteSet) {
            this.f2401o = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            return new C0332fb(clientLevel, d, d2, d3, d4, d5, d6, this.f2401o);
        }
    }
}
