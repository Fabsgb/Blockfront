package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kS.class */
public class C0588kS extends C0620ky implements InterfaceC0575kF {
    public C0588kS(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override // com.boehmod.blockfront.InterfaceC0575kF
    @NotNull
    /* JADX INFO: renamed from: c */
    public SoundEvent mo2604c() {
        return (SoundEvent) C1280xc.f7755te.get();
    }
}
