package com.boehmod.blockfront;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xt.class */
public class C1306xt extends DoorBlock {

    /* JADX INFO: renamed from: jR */
    private final boolean f7546jR;

    public C1306xt(@NotNull BlockSetType blockSetType, @NotNull BlockBehaviour.Properties properties, boolean z) {
        super(blockSetType, properties);
        this.f7546jR = z;
    }

    /* JADX INFO: renamed from: dz */
    public boolean m7953dz() {
        return this.f7546jR;
    }
}
