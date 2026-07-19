package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fB.class */
public class fB extends AbstractC0153fq {
    protected fB(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        a(new Vec3(d4, d5, d6));
        this.hasPhysics = true;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        setSize(0.01f, 0.01f);
        this.quadSize = 0.3f;
        this.alpha = 0.2f;
        this.lifetime = 400;
    }

    public void a(Vec3 vec3) {
        this.xd = vec3.x;
        this.yd = vec3.y;
        this.zd = vec3.z;
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.tick();
        this.age++;
        this.alpha = C0634xm.d(this.alpha, 0.0f, 0.005f);
        move(this.xd, this.yd, this.zd);
        if (this.alpha <= 0.0f) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        return fL.a;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fB$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet I;

        public a(SpriteSet spriteSet) {
            this.I = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            fB fBVar = new fB(clientLevel, d, d2, d3, d4, d5, d6, this.I);
            fBVar.a(new Vec3(d4, d5, d6));
            return fBVar;
        }
    }
}
