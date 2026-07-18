package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fD.class */
public class C0308fD extends AbstractC0347fq {
    public C0308fD(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM, com.boehmod.blockfront.InterfaceC0345fo, com.boehmod.blockfront.InterfaceC0318fN
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0316fL mo1452a() {
        if (C0424hN.f2762P.m1996T()) {
            return InterfaceC0316fL.f2339e;
        }
        return InterfaceC0316fL.f2336b;
    }

    @Override // com.boehmod.blockfront.AbstractC0264eM
    @NotNull
    public ParticleRenderType getRenderType() {
        if (C0424hN.f2762P.m1996T()) {
            return C0323fS.f2351a;
        }
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
