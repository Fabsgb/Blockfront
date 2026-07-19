package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.kg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kg.class */
public class C0277kg extends AbstractC0275ke<C0279ki> {
    @Override // com.boehmod.blockfront.AbstractC0275ke
    @Nullable
    public /* bridge */ /* synthetic */ jU a(boolean z, @NotNull AbstractC0264ju abstractC0264ju, @NotNull String str, @NotNull String str2) {
        return a(z, (AbstractC0264ju<?, ?, ?>) abstractC0264ju, str, str2);
    }

    @Override // com.boehmod.blockfront.AbstractC0275ke
    @Nullable
    public C0279ki a(boolean z, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull String str, @NotNull String str2) {
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0275ke
    @NotNull
    public Codec<C0279ki> a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        return C0279ki.l;
    }
}
