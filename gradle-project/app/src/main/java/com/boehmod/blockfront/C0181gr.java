package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gr.class */
public final class C0181gr extends Record {

    @NotNull
    private final BlockState a;
    private final int iY;

    public C0181gr(@NotNull BlockState blockState, int i) {
        this.a = blockState;
        this.iY = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0181gr.class), C0181gr.class, "blockState;packedLight", "FIELD:Lcom/boehmod/blockfront/gr;->a:Lnet/minecraft/world/level/block/state/BlockState;", "FIELD:Lcom/boehmod/blockfront/gr;->iY:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0181gr.class), C0181gr.class, "blockState;packedLight", "FIELD:Lcom/boehmod/blockfront/gr;->a:Lnet/minecraft/world/level/block/state/BlockState;", "FIELD:Lcom/boehmod/blockfront/gr;->iY:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0181gr.class, Object.class), C0181gr.class, "blockState;packedLight", "FIELD:Lcom/boehmod/blockfront/gr;->a:Lnet/minecraft/world/level/block/state/BlockState;", "FIELD:Lcom/boehmod/blockfront/gr;->iY:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public BlockState a() {
        return this.a;
    }

    public int ai() {
        return this.iY;
    }
}
