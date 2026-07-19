package com.boehmod.blockfront.client.corpse.physics;

import com.boehmod.blockfront.InterfaceC0320lw;
import java.util.function.Function;
import javax.annotation.Nullable;
import net.minecraft.Util;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/client/corpse/physics/b.class */
public class b {

    @NotNull
    private static final Logger a = LogManager.getLogger("BlockPhysicsDataBakery");

    @NotNull
    private final ClientLevel level;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private final Function<BlockState, a> f101a = Util.memoize(this::a);

    public b(@NotNull ClientLevel clientLevel) {
        this.level = clientLevel;
    }

    @NotNull
    public Level a() {
        return this.level;
    }

    @Nullable
    private a a(@NotNull BlockState blockState) {
        VoxelShape collisionShape = blockState.getCollisionShape(this.level, BlockPos.ZERO);
        if (collisionShape.isEmpty() || (blockState.getBlock() instanceof InterfaceC0320lw)) {
            return null;
        }
        a aVarA = RustCorpsePhysics.a();
        collisionShape.forAllBoxes((d, d2, d3, d4, d5, d6) -> {
            aVarA.a(new Vector3d(d, d2, d3), new Vector3d(d4, d5, d6));
        });
        return aVarA;
    }

    @Nullable
    public a b(@Nullable BlockState blockState) {
        if (blockState == null || this.f101a == null) {
            return null;
        }
        try {
            return this.f101a.apply(blockState);
        } catch (Exception e) {
            a.error("Exception building physics data for block", e);
            return null;
        }
    }
}
