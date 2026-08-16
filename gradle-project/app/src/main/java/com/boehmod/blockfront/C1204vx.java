package com.boehmod.blockfront;

import java.util.EnumMap;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.vx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vx.class */
public final class C1204vx {

    /* JADX INFO: renamed from: d */
    @NotNull
    private final EnumMap<EnumC1203vw, SoundEvent> f6564d = new EnumMap<>(EnumC1203vw.class);

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1204vx m6893a(@NotNull EnumC1203vw enumC1203vw, @NotNull SoundEvent soundEvent) {
        this.f6564d.put(enumC1203vw, soundEvent);
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public SoundEvent m6894a(@NotNull EnumC1203vw enumC1203vw) {
        return this.f6564d.get(enumC1203vw);
    }
}
