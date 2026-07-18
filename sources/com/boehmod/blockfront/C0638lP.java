package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lP.class */
public class C0638lP extends C0639lQ {

    /* JADX INFO: renamed from: kn */
    private static final int f3515kn = 200;

    /* JADX INFO: renamed from: hz */
    private static final float f3516hz = 512.0f;

    /* JADX INFO: renamed from: dS */
    private int f3517dS;

    /* JADX INFO: renamed from: ko */
    private int f3518ko;

    /* JADX INFO: renamed from: d */
    @Nullable
    private AbstractC0787oF<?, ?, ?> f3519d;

    /* JADX INFO: renamed from: dZ */
    static final /* synthetic */ boolean f3520dZ;

    static {
        f3520dZ = !C0638lP.class.desiredAssertionStatus();
    }

    public C0638lP(String str, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super((BlockEntityType) C1216wJ.f6368as.get(str).get(), blockPos, blockState);
        this.f3517dS = 0;
        this.f3518ko = 0;
        this.f3519d = null;
    }

    /* JADX INFO: renamed from: a */
    public static void m2830a(@NotNull Level level, @NotNull C0638lP c0638lP) {
        if (level.isClientSide()) {
            return;
        }
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f3520dZ && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null");
        }
        int i = c0638lP.f3518ko;
        c0638lP.f3518ko = i - 1;
        if (i <= 0) {
            c0638lP.f3518ko = 200;
            c0638lP.f3519d = abstractC0563juM168a.m2544a(c0638lP.getBlockPos(), 512.0d);
        }
        Object obj = c0638lP.f3519d;
        if (obj instanceof InterfaceC0903qP) {
            InterfaceC0903qP interfaceC0903qP = (InterfaceC0903qP) obj;
            int i2 = c0638lP.f3517dS;
            c0638lP.f3517dS = i2 - 1;
            if (i2 <= 0) {
                c0638lP.f3517dS = interfaceC0903qP.mo4676a((C0639lQ) c0638lP);
                interfaceC0903qP.mo4675a((C0639lQ) c0638lP);
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public AbstractC0787oF<?, ?, ?> m2831b() {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (f3520dZ || abstractC0563juM168a != null) {
            return abstractC0563juM168a.m2544a(getBlockPos(), 512.0d);
        }
        throw new AssertionError("Mod manager is null");
    }
}
