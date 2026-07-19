package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oC.class */
public class oC {

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aI;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aJ;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aK;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aL;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aM;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aN;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aO;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aP;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aQ;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aR;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aS;

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> aT;

    @NotNull
    public oC a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder3, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder4) {
        this.aI = deferredHolder;
        this.aJ = deferredHolder2;
        this.aM = deferredHolder3;
        this.aN = deferredHolder4;
        return this;
    }

    @NotNull
    public oC a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder2, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder3, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder4, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder5) {
        this.aO = deferredHolder;
        this.aP = deferredHolder2;
        this.aQ = deferredHolder3;
        this.aR = deferredHolder4;
        this.aS = deferredHolder5;
        return this;
    }

    @NotNull
    public oC a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder2) {
        this.aK = deferredHolder;
        this.aL = deferredHolder2;
        return this;
    }

    @NotNull
    public oC a(@NotNull DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.aT = deferredHolder;
        return this;
    }
}
