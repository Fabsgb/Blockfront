package com.boehmod.blockfront;

import java.util.OptionalLong;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.profiling.InactiveProfiler;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bX.class */
public class C0107bX extends ClientLevel {

    /* JADX INFO: renamed from: a */
    public static final DimensionType f703a = new DimensionType(OptionalLong.empty(), true, false, false, true, 1.0d, true, false, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 0.0f, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0));

    public C0107bX(@NotNull Minecraft minecraft) {
        super(new C0108bY(minecraft), m408a(), Level.OVERWORLD, new C0106bW(), 16, 16, () -> {
            return InactiveProfiler.INSTANCE;
        }, minecraft.levelRenderer, false, 1L);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ClientLevel.ClientLevelData m408a() {
        return new ClientLevel.ClientLevelData(Difficulty.PEACEFUL, false, true);
    }
}
