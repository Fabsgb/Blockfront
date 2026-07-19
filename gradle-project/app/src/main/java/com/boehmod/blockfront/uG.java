package com.boehmod.blockfront;

import java.util.Map;
import net.minecraft.world.level.block.SoundType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uG.class */
public final class uG {

    @NotNull
    private static final Map<String, SoundType> ao = Map.ofEntries(Map.entry("metal", SoundType.METAL), Map.entry("copper", SoundType.COPPER), Map.entry("copper_grate", SoundType.COPPER_GRATE), Map.entry("stone", SoundType.STONE), Map.entry("gravel", SoundType.GRAVEL), Map.entry("grass", SoundType.GRASS), Map.entry("sand", SoundType.SAND), Map.entry("soul_sand", SoundType.SOUL_SAND), Map.entry("suspicious_sand", SoundType.SUSPICIOUS_SAND), Map.entry("glass", SoundType.GLASS), Map.entry("stem", SoundType.STEM), Map.entry("wood", SoundType.WOOD), Map.entry("bamboo_wood", SoundType.BAMBOO_WOOD), Map.entry("nether_wood", SoundType.NETHER_WOOD), Map.entry("wool", SoundType.WOOL), Map.entry("netherrack", SoundType.NETHERRACK));

    private uG() {
    }

    @Nullable
    public static SoundType a(@NotNull String str) {
        return ao.get(str);
    }
}
