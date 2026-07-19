package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kL.class */
public class kL extends C0295ky implements kF {
    public kL(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override // com.boehmod.blockfront.kF
    @NotNull
    public SoundEvent c() {
        return (SoundEvent) C0624xc.td.get();
    }
}
