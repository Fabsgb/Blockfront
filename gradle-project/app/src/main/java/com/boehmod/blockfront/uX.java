package com.boehmod.blockfront;

import java.util.EnumMap;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uX.class */
public final class uX {

    @NotNull
    private final EnumMap<uW, SoundEvent> d = new EnumMap<>(uW.class);

    @NotNull
    public uX a(@NotNull uW uWVar, @NotNull SoundEvent soundEvent) {
        this.d.put(uWVar, soundEvent);
        return this;
    }

    @Nullable
    public SoundEvent a(@NotNull uW uWVar) {
        return this.d.get(uWVar);
    }
}
