package com.boehmod.blockfront;

import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lH.class */
public class lH {
    public final lF a;
    public final lF b;
    public final lF c;
    public final lF d;
    public final lF e;
    public final lF f;
    public final lF g;
    public final lF h;
    public final lF i;
    public final lF j;
    public final lF k;
    public final lF l;
    public final lF m;
    public final lF n;
    public final lF o;
    public final lF p;
    public final lF q;
    public final lF r;

    public lH(@NotNull String str, @NotNull BlockBehaviour.Properties properties) {
        this.a = lF.a(str + "_big_bricks", properties, false);
        this.b = lF.a(str + "_brick", properties, false);
        this.c = lF.a(str + "_bricks", properties, false);
        this.d = lF.a(str + "_cobbled", properties, false);
        this.e = lF.a(str + "_cobbled_tiles", properties, false);
        this.f = lF.a(str + "_cracked_brick", properties, false);
        this.g = lF.a(str + "_polished", properties, false);
        this.h = lF.a(str + "_polished_brick", properties, false);
        this.i = lF.a(str + "_polished_smooth_brick", properties, false);
        this.j = lF.a(str + "_powder", properties, true);
        this.k = lF.a(str + "_rough", properties, false);
        this.l = lF.a(str + "_smooth", properties, false);
        this.m = lF.a(str + "_smooth_brick", properties, false);
        this.n = lF.a(str + "_smooth_cracked_brick", properties, false);
        this.o = lF.a(str + "_smooth_windswept", properties, false);
        this.p = lF.a(str + "_stone", properties, false);
        this.q = lF.a(str + "_tiles", properties, false);
        this.r = lF.a(str + "_windswept", properties, false);
    }
}
