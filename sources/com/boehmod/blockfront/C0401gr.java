package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gr.class */
public final class C0401gr extends Record {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final BlockState f2605a;

    /* JADX INFO: renamed from: iY */
    private final int f2606iY;

    public C0401gr(@NotNull BlockState blockState, int i) {
        this.f2605a = blockState;
        this.f2606iY = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0401gr.class), C0401gr.class, "blockState;packedLight", "FIELD:Lcom/boehmod/blockfront/gr;->a:Lnet/minecraft/world/level/block/state/BlockState;", "FIELD:Lcom/boehmod/blockfront/gr;->iY:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0401gr.class), C0401gr.class, "blockState;packedLight", "FIELD:Lcom/boehmod/blockfront/gr;->a:Lnet/minecraft/world/level/block/state/BlockState;", "FIELD:Lcom/boehmod/blockfront/gr;->iY:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0401gr.class, Object.class), C0401gr.class, "blockState;packedLight", "FIELD:Lcom/boehmod/blockfront/gr;->a:Lnet/minecraft/world/level/block/state/BlockState;", "FIELD:Lcom/boehmod/blockfront/gr;->iY:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public BlockState m1903a() {
        return this.f2605a;
    }

    /* JADX INFO: renamed from: ai */
    public int m1904ai() {
        return this.f2606iY;
    }
}
