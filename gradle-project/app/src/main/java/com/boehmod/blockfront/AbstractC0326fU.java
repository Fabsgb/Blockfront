package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fU.class */
public abstract class AbstractC0326fU extends AbstractC0312fG {
    @NotNull
    /* JADX INFO: renamed from: a */
    abstract DeferredHolder<ParticleType<?>, ? extends SimpleParticleType> mo1676a();

    protected AbstractC0326fU(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
        this.gravity = 1.0f;
        this.quadSize = 0.02f;
        this.lifetime = 80;
        this.bCol = 0.9f;
        this.gCol = 0.9f;
        this.rCol = 0.9f;
        setSize(0.01f, 0.01f);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    public void tick() {
        super.m1693aD();
        if (!this.removed) {
            this.quadSize = Mth.lerp(0.5f, this.quadSize, 0.05f);
            if (this.onGround) {
                C0623l c0623lM2852b = C0623l.m2852b();
                if (c0623lM2852b != null) {
                    C0490iZ.m2218a(Minecraft.getInstance(), c0623lM2852b, this.level, (SimpleParticleType) mo1676a().get(), this.x, this.y, this.z, 0.0d, 0.0d, 0.0d);
                }
                remove();
            }
        }
    }
}
