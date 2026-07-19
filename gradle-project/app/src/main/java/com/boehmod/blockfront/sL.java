package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sL.class */
public enum sL {
    NEUTRAL("Neutrals", ColorReferences.COLOR_WHITE, C0624xc.pW),
    GOOD("Innocents", ColorReferences.COLOR_THEME_TTT_INNOCENT, C0624xc.pW),
    BAD("Traitors", ColorReferences.COLOR_THEME_TTT_TRAITOR, C0624xc.pX);


    @NotNull
    private final String name;
    private final int color;

    @NotNull
    private final DeferredHolder<SoundEvent, SoundEvent> winSound;

    sL(@NotNull String str, int i, @NotNull DeferredHolder deferredHolder) {
        this.name = str;
        this.color = i;
        this.winSound = deferredHolder;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public int getColor() {
        return this.color;
    }

    @NotNull
    public DeferredHolder<SoundEvent, SoundEvent> getWinSound() {
        return this.winSound;
    }
}
