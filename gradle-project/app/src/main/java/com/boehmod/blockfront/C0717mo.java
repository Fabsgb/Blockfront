package com.boehmod.blockfront;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mo.class */
public class C0717mo {

    /* JADX INFO: renamed from: H */
    @NotNull
    private final Map<Direction, VoxelShape> f4002H = Maps.newEnumMap(Direction.class);

    public C0717mo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f4002H.put(Direction.NORTH, Block.box(f, f2, f3, f4, f5, f6));
        this.f4002H.put(Direction.SOUTH, Block.box(16.0f - f4, f2, 16.0f - f6, 16.0f - f, f5, 16.0f - f3));
        this.f4002H.put(Direction.EAST, Block.box(16.0f - f6, f2, f, 16.0f - f3, f5, f4));
        this.f4002H.put(Direction.WEST, Block.box(f3, f2, 16.0f - f4, f6, f5, 16.0f - f));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public VoxelShape m3266a(@NotNull Direction direction) {
        return this.f4002H.get(direction);
    }
}
