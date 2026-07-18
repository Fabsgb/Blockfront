package com.boehmod.blockfront;

import java.util.EnumMap;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.uX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uX.class */
public final class C1124uX {

    /* JADX INFO: renamed from: d */
    @NotNull
    private final EnumMap<EnumC1123uW, SoundEvent> f5925d = new EnumMap<>(EnumC1123uW.class);

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1124uX m6240a(@NotNull EnumC1123uW enumC1123uW, @NotNull SoundEvent soundEvent) {
        this.f5925d.put(enumC1123uW, soundEvent);
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public SoundEvent m6241a(@NotNull EnumC1123uW enumC1123uW) {
        return this.f5925d.get(enumC1123uW);
    }
}
