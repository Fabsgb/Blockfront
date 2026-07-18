package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.kh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kh.class */
public class C0603kh extends AbstractC0600ke<C1017sX> {
    @Override // com.boehmod.blockfront.AbstractC0600ke
    @Nullable
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ InterfaceC0537jU mo2640a(boolean z, @NotNull AbstractC0563ju abstractC0563ju, @NotNull String str, @NotNull String str2) {
        return mo2640a(z, (AbstractC0563ju<?, ?, ?>) abstractC0563ju, str, str2);
    }

    @Override // com.boehmod.blockfront.AbstractC0600ke
    @Nullable
    /* JADX INFO: renamed from: a */
    public C1017sX mo2640a(boolean z, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull String str, @NotNull String str2) {
        return new C1017sX(str, str2);
    }

    @Override // com.boehmod.blockfront.AbstractC0600ke
    @NotNull
    /* JADX INFO: renamed from: a */
    public Codec<C1017sX> mo2641a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        C0531jO c0531jOM2549b = abstractC0563ju.m2549b();
        return C1017sX.f5368ab.xmap(c1017sX -> {
            c1017sX.m5547a(c0531jOM2549b);
            return c1017sX;
        }, c1017sX2 -> {
            return c1017sX2;
        });
    }
}
