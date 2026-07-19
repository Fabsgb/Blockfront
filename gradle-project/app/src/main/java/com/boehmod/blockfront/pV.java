package com.boehmod.blockfront;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pV.class */
public class pV extends pQ<SoundEvent> {
    public pV(@NotNull Component component, @NotNull Supplier<SoundEvent> supplier, @NotNull Consumer<SoundEvent> consumer) {
        super(component, supplier, consumer);
    }
}
