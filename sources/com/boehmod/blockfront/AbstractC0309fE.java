package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fE.class */
public abstract class AbstractC0309fE extends AbstractC0347fq {
    @NotNull
    /* JADX INFO: renamed from: a */
    abstract DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> mo1466a();

    protected AbstractC0309fE(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.gravity = 1.0f;
        this.quadSize = 0.02f;
        this.lifetime = 80;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        setSize(0.01f, 0.01f);
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM
    public void tick() {
        super.m1455ax();
        if (!this.removed) {
            this.quadSize = Mth.lerp(0.5f, this.quadSize, 0.05f);
            if (this.onGround) {
                C0622l c0622lM2667b = C0622l.m2667b();
                if (c0622lM2667b != null) {
                    C0470iG.m2126a(Minecraft.getInstance(), c0622lM2667b, this.level, (SimpleParticleType) mo1466a().get(), this.x, this.y, this.z, 0.0d, 0.0d, 0.0d);
                }
                remove();
            }
        }
    }
}
