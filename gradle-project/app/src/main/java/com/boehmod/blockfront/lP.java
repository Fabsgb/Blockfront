package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lP.class */
public class lP extends lQ {
    private static final int kn = 200;
    private static final float hz = 512.0f;
    private int dS;
    private int ko;

    @Nullable
    private oF<?, ?, ?> d;
    static final /* synthetic */ boolean dZ;

    static {
        dZ = !lP.class.desiredAssertionStatus();
    }

    public lP(String str, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super((BlockEntityType) wJ.as.get(str).get(), blockPos, blockState);
        this.dS = 0;
        this.ko = 0;
        this.d = null;
    }

    public static void a(@NotNull Level level, @NotNull lP lPVar) {
        if (level.isClientSide()) {
            return;
        }
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!dZ && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null");
        }
        int i = lPVar.ko;
        lPVar.ko = i - 1;
        if (i <= 0) {
            lPVar.ko = 200;
            lPVar.d = abstractC0264juM166a.a(lPVar.getBlockPos(), 512.0d);
        }
        Object obj = lPVar.d;
        if (obj instanceof qP) {
            qP qPVar = (qP) obj;
            int i2 = lPVar.dS;
            lPVar.dS = i2 - 1;
            if (i2 <= 0) {
                lPVar.dS = qPVar.mo921a((lQ) lPVar);
                qPVar.a((lQ) lPVar);
            }
        }
    }

    @Nullable
    public oF<?, ?, ?> b() {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (dZ || abstractC0264juM166a != null) {
            return abstractC0264juM166a.a(getBlockPos(), 512.0d);
        }
        throw new AssertionError("Mod manager is null");
    }
}
