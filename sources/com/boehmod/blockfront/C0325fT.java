package com.boehmod.blockfront;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fT.class */
public class C0325fT extends AbstractC0312fG {
    public C0325fT(@NotNull ClientLevel clientLevel, double d, double d2, double d3, double d4, double d5, double d6, @NotNull SpriteSet spriteSet) {
        super(clientLevel, d, d2, d3, d4, d5, d6, spriteSet);
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa, com.boehmod.blockfront.InterfaceC0310fE, com.boehmod.blockfront.InterfaceC0388gd
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0386gb mo1545a() {
        if (C0495ie.f3063P.m2230U()) {
            return InterfaceC0386gb.f2534e;
        }
        return InterfaceC0386gb.f2531b;
    }

    @Override // com.boehmod.blockfront.AbstractC0332fa
    @NotNull
    public ParticleRenderType getRenderType() {
        if (C0495ie.f3063P.m2230U()) {
            return C0393gi.f2546a;
        }
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
