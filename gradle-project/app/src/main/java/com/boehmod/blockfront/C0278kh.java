package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.kh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kh.class */
public class C0278kh extends AbstractC0275ke<sX> {
    @Override // com.boehmod.blockfront.AbstractC0275ke
    @Nullable
    public /* bridge */ /* synthetic */ jU a(boolean z, @NotNull AbstractC0264ju abstractC0264ju, @NotNull String str, @NotNull String str2) {
        return a(z, (AbstractC0264ju<?, ?, ?>) abstractC0264ju, str, str2);
    }

    @Override // com.boehmod.blockfront.AbstractC0275ke
    @Nullable
    public sX a(boolean z, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull String str, @NotNull String str2) {
        return new sX(str, str2);
    }

    @Override // com.boehmod.blockfront.AbstractC0275ke
    @NotNull
    public Codec<sX> a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        jO jOVarM536b = abstractC0264ju.m536b();
        return sX.ab.xmap(sXVar -> {
            sXVar.a(jOVarM536b);
            return sXVar;
        }, sXVar2 -> {
            return sXVar2;
        });
    }
}
