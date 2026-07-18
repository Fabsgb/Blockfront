package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
import com.boehmod.blockfront.common.player.PlayerDataCacheLoader;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.fV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fV.class */
public class C0326fV extends AbstractC0183c<C0324fT> {

    /* JADX INFO: renamed from: a */
    @Nullable
    private static C0324fT f2375a;

    /* JADX INFO: renamed from: g */
    @Nullable
    private static C0482iS f2376g;

    public C0326fV() {
        super(C1278xa.f7492oi, C1278xa.f7493oj);
    }

    /* JADX INFO: renamed from: a */
    private boolean m1674a(@NotNull Minecraft minecraft, @NotNull UUID uuid) {
        return (minecraft.level == null || minecraft.level.getPlayerByUUID(uuid) == null) ? false : true;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0324fT m1675a(@NotNull Minecraft minecraft) {
        if (f2375a == null) {
            C0324fT c0324fTB = m1135b(minecraft.getUser().getProfileId());
            f2375a = c0324fTB;
            return c0324fTB;
        }
        return f2375a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0482iS m1676a(@NotNull Minecraft minecraft) {
        if (f2376g == null) {
            C0482iS c0482iSA = mo1137a(minecraft.getUser().getProfileId());
            f2376g = c0482iSA;
            return c0482iSA;
        }
        return f2376g;
    }

    @Override // com.boehmod.blockfront.common.player.AbstractC0183c
    /* JADX INFO: renamed from: d */
    protected boolean mo1124d(@NotNull UUID uuid) {
        Minecraft minecraft = Minecraft.getInstance();
        return m1674a(minecraft, uuid) || uuid.equals(minecraft.getUser().getProfileId());
    }

    @Override // com.boehmod.blockfront.common.player.AbstractC0183c
    @NotNull
    /* JADX INFO: renamed from: a */
    protected PlayerDataCacheLoader<C0324fT, ?> mo1125a() {
        return new C0325fU(this);
    }

    @Override // com.boehmod.blockfront.common.player.AbstractC0183c
    /* JADX INFO: renamed from: a */
    public C0324fT mo1137a(@NotNull UUID uuid) {
        return new C0324fT(uuid);
    }
}
