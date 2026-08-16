package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.lang.reflect.InvocationTargetException;
import net.minecraft.server.level.ServerLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.kB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kB.class */
public class C0572kB extends AbstractC0571kA<C0868pg> {
    @Override // com.boehmod.blockfront.AbstractC0571kA
    @Nullable
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ InterfaceC0613kq mo2590a(boolean z, @NotNull AbstractC0531jN abstractC0531jN, @NotNull String str, @NotNull String str2) {
        return mo2590a(z, (AbstractC0531jN<?, ?, ?>) abstractC0531jN, str, str2);
    }

    @Override // com.boehmod.blockfront.AbstractC0571kA
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0868pg mo2590a(boolean z, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull String str, @NotNull String str2) {
        C1094tt c1094ttM6019a = C1094tt.m6019a(str2);
        if (c1094ttM6019a == null) {
            return null;
        }
        Class<? extends AbstractC0863pb<?, ?, ?>> clsM6021b = c1094ttM6019a.m6021b();
        try {
            AbstractC0863pb<?, ?, ?> abstractC0863pbNewInstance = clsM6021b.getDeclaredConstructor(AbstractC0531jN.class).newInstance(abstractC0531jN);
            abstractC0863pbNewInstance.m4026v(str);
            abstractC0863pbNewInstance.m4039d((ServerLevel) null);
            return new C0868pg(abstractC0863pbNewInstance, abstractC0531jN);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            C0530jM.m2338a("Failed to create new game asset from game type %s for game %s (Class type: %s)", e, str2, str, clsM6021b.getName());
            throw new RuntimeException(e);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0571kA
    @NotNull
    /* JADX INFO: renamed from: a */
    public Codec<C0868pg> mo2591a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        return C0949rH.f5251S.xmap(c0949rH -> {
            return C0868pg.m4275a(c0949rH, abstractC0531jN);
        }, (v0) -> {
            return v0.m4274a();
        });
    }
}
