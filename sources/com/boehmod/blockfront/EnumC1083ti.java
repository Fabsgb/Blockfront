package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ti */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ti.class */
public enum EnumC1083ti {
    NEUTRAL("Neutrals", ColorReferences.COLOR_WHITE, C1312xz.f8003pY),
    GOOD("Innocents", ColorReferences.COLOR_THEME_TTT_INNOCENT, C1312xz.f8003pY),
    BAD("Traitors", ColorReferences.COLOR_THEME_TTT_TRAITOR, C1312xz.f8004pZ);


    @NotNull
    private final String name;
    private final int color;

    @NotNull
    private final DeferredHolder<SoundEvent, SoundEvent> winSound;

    EnumC1083ti(@NotNull String str, int i, DeferredHolder deferredHolder) {
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
