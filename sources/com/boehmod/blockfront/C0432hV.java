package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hV.class */
public class C0432hV {
    private int ticks;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final SoundInstance f2803c;

    public C0432hV(int i, @NotNull SoundInstance soundInstance) {
        this.ticks = i;
        this.f2803c = soundInstance;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2029a(@NotNull SoundManager soundManager) {
        int i = this.ticks;
        this.ticks = i - 1;
        if (i <= 0) {
            soundManager.stop(this.f2803c);
            return true;
        }
        return false;
    }
}
