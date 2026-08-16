package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
import com.boehmod.blockfront.common.player.PlayerDataCacheLoader;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.gl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gl.class */
public class C0396gl extends AbstractC0184c<C0394gj> {

    /* JADX INFO: renamed from: a */
    @Nullable
    private static C0394gj f2570a;

    /* JADX INFO: renamed from: g */
    @Nullable
    private static C0555jl f2571g;

    public C0396gl() {
        super(C1310xx.f7904ok, C1310xx.f7905ol);
    }

    /* JADX INFO: renamed from: a */
    private boolean m1884a(@NotNull Minecraft minecraft, @NotNull UUID uuid) {
        return (minecraft.level == null || minecraft.level.getPlayerByUUID(uuid) == null) ? false : true;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0394gj m1885a(@NotNull Minecraft minecraft) {
        if (f2570a == null) {
            C0394gj c0394gjB = m1152b(minecraft.getUser().getProfileId());
            f2570a = c0394gjB;
            return c0394gjB;
        }
        return f2570a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0555jl m1886a(@NotNull Minecraft minecraft) {
        if (f2571g == null) {
            C0555jl c0555jlA = mo1154a(minecraft.getUser().getProfileId());
            f2571g = c0555jlA;
            return c0555jlA;
        }
        return f2571g;
    }

    @Override // com.boehmod.blockfront.common.player.AbstractC0184c
    /* JADX INFO: renamed from: d */
    protected boolean mo1141d(@NotNull UUID uuid) {
        Minecraft minecraft = Minecraft.getInstance();
        return m1884a(minecraft, uuid) || uuid.equals(minecraft.getUser().getProfileId());
    }

    @Override // com.boehmod.blockfront.common.player.AbstractC0184c
    @NotNull
    /* JADX INFO: renamed from: a */
    protected PlayerDataCacheLoader<C0394gj, ?> mo1142a() {
        return new C0395gk(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.common.player.AbstractC0184c
    /* JADX INFO: renamed from: a */
    public C0394gj mo1154a(@NotNull UUID uuid) {
        return new C0394gj(uuid);
    }
}
