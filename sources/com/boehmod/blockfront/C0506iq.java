package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iq.class */
public class C0506iq extends C0508is<C0762nh> {

    /* JADX INFO: renamed from: jF */
    private static final int f3022jF = 160;
    private int ticks;

    public C0506iq(@NotNull C0762nh c0762nh, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        super(c0762nh, soundEvent, soundSource, f, f2);
        this.ticks = 0;
    }

    @Override // com.boehmod.blockfront.C0508is
    /* JADX INFO: renamed from: W */
    protected boolean mo2248W() {
        int i = this.ticks;
        this.ticks = i + 1;
        return i >= f3022jF || this.f3024b.isRemoved();
    }
}
