package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fR.class */
public class C0323fR extends AbstractC0312fG {
    protected C0323fR(ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        m1673a(new Vec3(d4, d5, d6));
        this.hasPhysics = true;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        setSize(0.01f, 0.01f);
        this.quadSize = 0.3f;
        this.alpha = 0.2f;
        this.lifetime = 400;
    }

    /* JADX INFO: renamed from: a */
    public void m1673a(Vec3 vec3) {
        this.xd = vec3.x;
        this.yd = vec3.y;
        this.zd = vec3.z;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.tick();
        this.age++;
        this.alpha = C1270xJ.m7161d(this.alpha, 0.0f, 0.005f);
        move(this.xd, this.yd, this.zd);
        if (this.alpha <= 0.0f) {
            remove();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        return InterfaceC0386gb.f2530a;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fR$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fR$a.class */
    public static class a implements ParticleProvider<SimpleParticleType> {

        /* JADX INFO: renamed from: M */
        private final SpriteSet f2413M;

        public a(SpriteSet spriteSet) {
            this.f2413M = spriteSet;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6) {
            C0323fR c0323fR = new C0323fR(clientLevel, d, d2, d3, d4, d5, d6, this.f2413M);
            c0323fR.m1673a(new Vec3(d4, d5, d6));
            return c0323fR;
        }
    }
}
