package com.boehmod.blockfront;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wW.class */
public class C1229wW extends DoorBlock {

    /* JADX INFO: renamed from: jB */
    private final boolean f6981jB;

    public C1229wW(@NotNull BlockSetType blockSetType, @NotNull BlockBehaviour.Properties properties, boolean z) {
        super(blockSetType, properties);
        this.f6981jB = z;
    }

    /* JADX INFO: renamed from: dq */
    public boolean m7362dq() {
        return this.f6981jB;
    }
}
