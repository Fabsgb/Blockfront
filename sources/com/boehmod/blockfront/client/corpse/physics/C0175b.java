package com.boehmod.blockfront.client.corpse.physics;

import com.boehmod.blockfront.InterfaceC0671lw;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.client.corpse.physics.b */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/client/corpse/physics/b.class */
public class C0175b {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Logger f1446a = LogManager.getLogger("BlockPhysicsDataBakery");

    @NotNull
    private final ClientLevel level;

    /* JADX INFO: renamed from: a */
    @Nullable
    private final Function<BlockState, C0174a> f1447a = Util.memoize(this::m1044a);

    public C0175b(@NotNull ClientLevel clientLevel) {
        this.level = clientLevel;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Level m1043a() {
        return this.level;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private C0174a m1044a(@NotNull BlockState blockState) {
        VoxelShape collisionShape = blockState.getCollisionShape(this.level, BlockPos.ZERO);
        if (collisionShape.isEmpty() || (blockState.getBlock() instanceof InterfaceC0671lw)) {
            return null;
        }
        C0174a c0174aM1040a = RustCorpsePhysics.m1040a();
        collisionShape.forAllBoxes((d, d2, d3, d4, d5, d6) -> {
            c0174aM1040a.m1041a(new Vector3d(d, d2, d3), new Vector3d(d4, d5, d6));
        });
        return c0174aM1040a;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C0174a m1045b(@Nullable BlockState blockState) {
        if (blockState == null || this.f1447a == null) {
            return null;
        }
        try {
            return this.f1447a.apply(blockState);
        } catch (Exception e) {
            f1446a.error("Exception building physics data for block", e);
            return null;
        }
    }
}
