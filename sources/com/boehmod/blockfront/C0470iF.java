package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iF.class */
@OnlyIn(Dist.CLIENT)
public class C0470iF extends SimpleSoundInstance implements InterfaceC0482iR {
    public C0470iF(@NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2, @NotNull RandomSource randomSource, double d, double d2, double d3) {
        super(soundEvent, soundSource, f, f2, randomSource, d, d2, d3);
    }

    @Override // com.boehmod.blockfront.InterfaceC0482iR
    /* JADX INFO: renamed from: W */
    public boolean mo2136W() {
        return true;
    }
}
