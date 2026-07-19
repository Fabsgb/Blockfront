package com.boehmod.blockfront;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lD.class */
public class lD {
    public static final int kk = 8;

    @NotNull
    public static final IntegerProperty k = IntegerProperty.create("body_rotation", 0, 7);

    @NotNull
    public static final IntegerProperty l = IntegerProperty.create("head_rotation", 0, 7);

    @NotNull
    public static final IntegerProperty m = IntegerProperty.create("texture_index", 0, 8);

    @NotNull
    public static final BooleanProperty D = BooleanProperty.create("sparking");
}
