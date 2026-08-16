package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gH.class */
public final class C0366gH extends Record {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final BlockState f2505a;

    /* JADX INFO: renamed from: kt */
    private final int f2506kt;

    public C0366gH(@NotNull BlockState blockState, int i) {
        this.f2505a = blockState;
        this.f2506kt = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0366gH.class), C0366gH.class, "blockState;packedLight", "FIELD:Lcom/boehmod/blockfront/gH;->a:Lnet/minecraft/world/level/block/state/BlockState;", "FIELD:Lcom/boehmod/blockfront/gH;->kt:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0366gH.class), C0366gH.class, "blockState;packedLight", "FIELD:Lcom/boehmod/blockfront/gH;->a:Lnet/minecraft/world/level/block/state/BlockState;", "FIELD:Lcom/boehmod/blockfront/gH;->kt:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0366gH.class, Object.class), C0366gH.class, "blockState;packedLight", "FIELD:Lcom/boehmod/blockfront/gH;->a:Lnet/minecraft/world/level/block/state/BlockState;", "FIELD:Lcom/boehmod/blockfront/gH;->kt:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public BlockState m1760a() {
        return this.f2505a;
    }

    /* JADX INFO: renamed from: au */
    public int m1761au() {
        return this.f2506kt;
    }
}
