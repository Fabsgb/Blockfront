package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fE.class */
public abstract class fE extends AbstractC0153fq {
    @NotNull
    abstract DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> a();

    protected fE(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.gravity = 1.0f;
        this.quadSize = 0.02f;
        this.lifetime = 80;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        setSize(0.01f, 0.01f);
    }

    @Override // com.boehmod.blockfront.eM
    public void tick() {
        super.ax();
        if (!this.removed) {
            this.quadSize = Mth.lerp(0.5f, this.quadSize, 0.05f);
            if (this.onGround) {
                C0297l c0297lB = C0297l.b();
                if (c0297lB != null) {
                    iG.a(Minecraft.getInstance(), c0297lB, this.level, (SimpleParticleType) a().get(), this.x, this.y, this.z, 0.0d, 0.0d, 0.0d);
                }
                remove();
            }
        }
    }
}
