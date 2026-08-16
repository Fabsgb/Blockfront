package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iH.class */
public class C0472iH extends C0474iJ<C0733nD> {

    /* JADX INFO: renamed from: la */
    private static final int f2918la = 160;
    private int ticks;

    public C0472iH(@NotNull C0733nD c0733nD, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        super(c0733nD, soundEvent, soundSource, f, f2);
        this.ticks = 0;
    }

    @Override // com.boehmod.blockfront.C0474iJ
    /* JADX INFO: renamed from: X */
    protected boolean mo2137X() {
        int i = this.ticks;
        this.ticks = i + 1;
        return i >= f2918la || this.f2920b.isRemoved();
    }
}
