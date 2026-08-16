package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ml */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ml.class */
public class C0714ml extends C0715mm {

    /* JADX INFO: renamed from: mk */
    private static final int f3989mk = 200;

    /* JADX INFO: renamed from: ir */
    private static final float f3990ir = 512.0f;

    /* JADX INFO: renamed from: eS */
    private int f3991eS;

    /* JADX INFO: renamed from: ml */
    private int f3992ml;

    /* JADX INFO: renamed from: d */
    @Nullable
    private AbstractC0863pb<?, ?, ?> f3993d;

    /* JADX INFO: renamed from: es */
    static final /* synthetic */ boolean f3994es;

    static {
        f3994es = !C0714ml.class.desiredAssertionStatus();
    }

    public C0714ml(String str, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super((BlockEntityType) C1293xg.f6931as.get(str).get(), blockPos, blockState);
        this.f3991eS = 0;
        this.f3992ml = 0;
        this.f3993d = null;
    }

    /* JADX INFO: renamed from: a */
    public static void m3261a(@NotNull Level level, @NotNull C0714ml c0714ml) {
        if (level.isClientSide()) {
            return;
        }
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f3994es && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null");
        }
        int i = c0714ml.f3992ml;
        c0714ml.f3992ml = i - 1;
        if (i <= 0) {
            c0714ml.f3992ml = 200;
            c0714ml.f3993d = abstractC0531jNM179a.m2367a(c0714ml.getBlockPos(), 512.0d);
        }
        Object obj = c0714ml.f3993d;
        if (obj instanceof InterfaceC0980rm) {
            InterfaceC0980rm interfaceC0980rm = (InterfaceC0980rm) obj;
            int i2 = c0714ml.f3991eS;
            c0714ml.f3991eS = i2 - 1;
            if (i2 <= 0) {
                c0714ml.f3991eS = interfaceC0980rm.mo5342a((C0715mm) c0714ml);
                interfaceC0980rm.mo5341a((C0715mm) c0714ml);
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public AbstractC0863pb<?, ?, ?> m3262b() {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (f3994es || abstractC0531jNM179a != null) {
            return abstractC0531jNM179a.m2367a(getBlockPos(), 512.0d);
        }
        throw new AssertionError("Mod manager is null");
    }
}
