package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kS.class */
public class kS extends C0295ky implements kF {
    public kS(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override // com.boehmod.blockfront.kF
    @NotNull
    public SoundEvent c() {
        return (SoundEvent) C0624xc.te.get();
    }
}
