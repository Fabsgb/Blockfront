package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.kD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kD.class */
public class C0574kD extends AbstractC0571kA<C1095tu> {
    @Override // com.boehmod.blockfront.AbstractC0571kA
    @Nullable
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ InterfaceC0613kq mo2590a(boolean z, @NotNull AbstractC0531jN abstractC0531jN, @NotNull String str, @NotNull String str2) {
        return mo2590a(z, (AbstractC0531jN<?, ?, ?>) abstractC0531jN, str, str2);
    }

    @Override // com.boehmod.blockfront.AbstractC0571kA
    @Nullable
    /* JADX INFO: renamed from: a */
    public C1095tu mo2590a(boolean z, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull String str, @NotNull String str2) {
        return new C1095tu(str, str2);
    }

    @Override // com.boehmod.blockfront.AbstractC0571kA
    @NotNull
    /* JADX INFO: renamed from: a */
    public Codec<C1095tu> mo2591a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        C0607kk c0607kkM2372b = abstractC0531jN.m2372b();
        return C1095tu.f5932ab.xmap(c1095tu -> {
            c1095tu.m6035a(c0607kkM2372b);
            return c1095tu;
        }, c1095tu2 -> {
            return c1095tu2;
        });
    }
}
