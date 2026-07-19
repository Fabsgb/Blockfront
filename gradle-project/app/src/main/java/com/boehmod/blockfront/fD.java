package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fD.class */
public class fD extends AbstractC0153fq {
    public fD(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
    }

    @Override // com.boehmod.blockfront.eM, com.boehmod.blockfront.InterfaceC0151fo, com.boehmod.blockfront.fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public fL mo372a() {
        if (hN.P.T()) {
            return fL.e;
        }
        return fL.b;
    }

    @Override // com.boehmod.blockfront.eM
    @NotNull
    public ParticleRenderType getRenderType() {
        if (hN.P.T()) {
            return fS.a;
        }
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
