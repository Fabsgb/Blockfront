package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hV.class */
public class hV {
    private int ticks;

    @NotNull
    private final SoundInstance c;

    public hV(int i, @NotNull SoundInstance soundInstance) {
        this.ticks = i;
        this.c = soundInstance;
    }

    public boolean a(@NotNull SoundManager soundManager) {
        int i = this.ticks;
        this.ticks = i - 1;
        if (i <= 0) {
            soundManager.stop(this.c);
            return true;
        }
        return false;
    }
}
