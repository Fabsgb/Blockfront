package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0536jS;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.F */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/F.class */
public interface InterfaceC0009F<M extends AbstractC0536jS<?, ?>> {
    @Nullable
    /* JADX INFO: renamed from: a */
    String mo14a(@NotNull Minecraft minecraft, @NotNull M m);

    /* JADX INFO: renamed from: g */
    int mo12g();

    @NotNull
    /* JADX INFO: renamed from: a */
    C0994s.a mo11a();

    @NotNull
    /* JADX INFO: renamed from: a */
    default C0994s.b mo13a() {
        return C0994s.b.LOUD;
    }
}
