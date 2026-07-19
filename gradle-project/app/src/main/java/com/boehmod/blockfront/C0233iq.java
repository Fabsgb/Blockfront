package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iq.class */
public class C0233iq extends C0235is<C0359nh> {
    private static final int jF = 160;
    private int ticks;

    public C0233iq(@NotNull C0359nh c0359nh, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        super(c0359nh, soundEvent, soundSource, f, f2);
        this.ticks = 0;
    }

    @Override // com.boehmod.blockfront.C0235is
    protected boolean W() {
        int i = this.ticks;
        this.ticks = i + 1;
        return i >= jF || this.b.isRemoved();
    }
}
