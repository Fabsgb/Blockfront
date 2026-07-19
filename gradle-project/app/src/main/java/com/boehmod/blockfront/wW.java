package com.boehmod.blockfront;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wW.class */
public class wW extends DoorBlock {
    private final boolean jB;

    public wW(@NotNull BlockSetType blockSetType, @NotNull BlockBehaviour.Properties properties, boolean z) {
        super(blockSetType, properties);
        this.jB = z;
    }

    public boolean dq() {
        return this.jB;
    }
}
