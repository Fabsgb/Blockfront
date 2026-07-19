package com.boehmod.blockfront;

import com.boehmod.blockfront.jU;
import com.mojang.serialization.Codec;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ke, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ke.class */
public abstract class AbstractC0275ke<A extends jU> {
    public abstract A a(boolean z, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull String str, @NotNull String str2);

    @NotNull
    public abstract Codec<A> a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju);
}
