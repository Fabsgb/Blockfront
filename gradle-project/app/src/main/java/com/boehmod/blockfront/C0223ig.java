package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ig, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ig.class */
public class C0223ig extends C0229im {

    @NotNull
    private final C0558ur b;

    public C0223ig(@NotNull SoundEvent soundEvent, @NotNull C0558ur c0558ur) {
        super(soundEvent);
        this.b = c0558ur;
    }

    @Override // com.boehmod.blockfront.C0229im
    public void tick() {
        super.tick();
    }

    public C0558ur a() {
        return this.b;
    }
}
