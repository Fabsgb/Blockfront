package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.io */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/io.class */
@OnlyIn(Dist.CLIENT)
public class C0504io extends SimpleSoundInstance implements InterfaceC0464iA {
    public C0504io(@NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2, @NotNull RandomSource randomSource, double d, double d2, double d3) {
        super(soundEvent, soundSource, f, f2, randomSource, d, d2, d3);
    }

    @Override // com.boehmod.blockfront.InterfaceC0464iA
    /* JADX INFO: renamed from: V */
    public boolean mo2096V() {
        return true;
    }
}
