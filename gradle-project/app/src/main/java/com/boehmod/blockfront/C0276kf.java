package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.lang.reflect.InvocationTargetException;
import net.minecraft.server.level.ServerLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.kf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kf.class */
public class C0276kf extends AbstractC0275ke<oK> {
    @Override // com.boehmod.blockfront.AbstractC0275ke
    @Nullable
    public /* bridge */ /* synthetic */ jU a(boolean z, @NotNull AbstractC0264ju abstractC0264ju, @NotNull String str, @NotNull String str2) {
        return a(z, (AbstractC0264ju<?, ?, ?>) abstractC0264ju, str, str2);
    }

    @Override // com.boehmod.blockfront.AbstractC0275ke
    @Nullable
    public oK a(boolean z, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull String str, @NotNull String str2) {
        sW sWVarA = sW.a(str2);
        if (sWVarA == null) {
            return null;
        }
        Class<? extends oF<?, ?, ?>> clsB = sWVarA.b();
        try {
            oF<?, ?, ?> oFVarNewInstance = clsB.getDeclaredConstructor(AbstractC0264ju.class).newInstance(abstractC0264ju);
            oFVarNewInstance.v(str);
            oFVarNewInstance.d((ServerLevel) null);
            return new oK(oFVarNewInstance, abstractC0264ju);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            C0263jt.a("Failed to create new game asset from game type %s for game %s (Class type: %s)", e, str2, str, clsB.getName());
            throw new RuntimeException(e);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0275ke
    @NotNull
    public Codec<oK> a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        return C0470rk.S.xmap(c0470rk -> {
            return oK.a(c0470rk, abstractC0264ju);
        }, (v0) -> {
            return v0.m786a();
        });
    }
}
