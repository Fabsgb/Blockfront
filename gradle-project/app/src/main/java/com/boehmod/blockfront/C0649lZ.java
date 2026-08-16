package com.boehmod.blockfront;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lZ.class */
public class C0649lZ {

    /* JADX INFO: renamed from: mh */
    public static final int f3652mh = 8;

    /* JADX INFO: renamed from: k */
    @NotNull
    public static final IntegerProperty f3653k = IntegerProperty.create("body_rotation", 0, 7);

    /* JADX INFO: renamed from: l */
    @NotNull
    public static final IntegerProperty f3654l = IntegerProperty.create("head_rotation", 0, 7);

    /* JADX INFO: renamed from: m */
    @NotNull
    public static final IntegerProperty f3655m = IntegerProperty.create("texture_index", 0, 8);

    /* JADX INFO: renamed from: D */
    @NotNull
    public static final BooleanProperty f3656D = BooleanProperty.create("sparking");
}
