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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bO.class */
public class bO extends ClientLevel {
    public static final DimensionType a = new DimensionType(OptionalLong.empty(), true, false, false, true, 1.0d, true, false, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 0.0f, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0));

    public bO(@NotNull Minecraft minecraft) {
        super(new bP(minecraft), a(), Level.OVERWORLD, new bN(), 16, 16, () -> {
            return InactiveProfiler.INSTANCE;
        }, minecraft.levelRenderer, false, 1L);
    }

    @NotNull
    public static ClientLevel.ClientLevelData a() {
        return new ClientLevel.ClientLevelData(Difficulty.PEACEFUL, false, true);
    }
}
