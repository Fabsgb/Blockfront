package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.im */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/im.class */
public class C0503im {
    private int ticks;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final SoundInstance f3105c;

    public C0503im(int i, @NotNull SoundInstance soundInstance) {
        this.ticks = i;
        this.f3105c = soundInstance;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2263a(@NotNull SoundManager soundManager) {
        int i = this.ticks;
        this.ticks = i - 1;
        if (i <= 0) {
            soundManager.stop(this.f3105c);
            return true;
        }
        return false;
    }
}
