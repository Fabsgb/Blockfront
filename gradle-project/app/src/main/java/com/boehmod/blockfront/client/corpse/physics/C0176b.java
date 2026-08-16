package com.boehmod.blockfront.client.corpse.physics;

import com.boehmod.blockfront.InterfaceC0642lS;
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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/client/corpse/physics/b.class */
public class C0176b {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Logger f1365a = LogManager.getLogger("BlockPhysicsDataBakery");

    @NotNull
    private final ClientLevel level;

    /* JADX INFO: renamed from: a */
    @Nullable
    private final Function<BlockState, C0175a> f1366a = Util.memoize(this::m1068a);

    public C0176b(@NotNull ClientLevel clientLevel) {
        this.level = clientLevel;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Level m1067a() {
        return this.level;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private C0175a m1068a(@NotNull BlockState blockState) {
        VoxelShape collisionShape = blockState.getCollisionShape(this.level, BlockPos.ZERO);
        if (collisionShape.isEmpty() || (blockState.getBlock() instanceof InterfaceC0642lS)) {
            return null;
        }
        C0175a c0175aM1064a = RustCorpsePhysics.m1064a();
        collisionShape.forAllBoxes((d, d2, d3, d4, d5, d6) -> {
            c0175aM1064a.m1065a(new Vector3d(d, d2, d3), new Vector3d(d4, d5, d6));
        });
        return c0175aM1064a;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C0175a m1069b(@Nullable BlockState blockState) {
        if (blockState == null || this.f1366a == null) {
            return null;
        }
        try {
            return this.f1366a.apply(blockState);
        } catch (Exception e) {
            f1365a.error("Exception building physics data for block", e);
            return null;
        }
    }
}
