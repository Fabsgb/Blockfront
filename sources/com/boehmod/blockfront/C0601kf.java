package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.lang.reflect.InvocationTargetException;
import net.minecraft.server.level.ServerLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.kf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kf.class */
public class C0601kf extends AbstractC0600ke<C0792oK> {
    @Override // com.boehmod.blockfront.AbstractC0600ke
    @Nullable
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ InterfaceC0537jU mo2640a(boolean z, @NotNull AbstractC0563ju abstractC0563ju, @NotNull String str, @NotNull String str2) {
        return mo2640a(z, (AbstractC0563ju<?, ?, ?>) abstractC0563ju, str, str2);
    }

    @Override // com.boehmod.blockfront.AbstractC0600ke
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0792oK mo2640a(boolean z, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull String str, @NotNull String str2) {
        C1016sW c1016sWM5531a = C1016sW.m5531a(str2);
        if (c1016sWM5531a == null) {
            return null;
        }
        Class<? extends AbstractC0787oF<?, ?, ?>> clsM5533b = c1016sWM5531a.m5533b();
        try {
            AbstractC0787oF<?, ?, ?> abstractC0787oFNewInstance = clsM5533b.getDeclaredConstructor(AbstractC0563ju.class).newInstance(abstractC0563ju);
            abstractC0787oFNewInstance.m3590v(str);
            abstractC0787oFNewInstance.m3603d((ServerLevel) null);
            return new C0792oK(abstractC0787oFNewInstance, abstractC0563ju);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            C0562jt.m2516a("Failed to create new game asset from game type %s for game %s (Class type: %s)", e, str2, str, clsM5533b.getName());
            throw new RuntimeException(e);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0600ke
    @NotNull
    /* JADX INFO: renamed from: a */
    public Codec<C0792oK> mo2641a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        return C0977rk.f5147S.xmap(c0977rk -> {
            return C0792oK.m3839a(c0977rk, abstractC0563ju);
        }, (v0) -> {
            return v0.m3838a();
        });
    }
}
