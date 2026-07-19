package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.PlayerDataCacheLoader;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fV.class */
public class fV extends com.boehmod.blockfront.common.player.c<fT> {

    @Nullable
    private static fT a;

    @Nullable
    private static iS g;

    public fV() {
        super(C0622xa.oi, C0622xa.oj);
    }

    private boolean a(@NotNull Minecraft minecraft, @NotNull UUID uuid) {
        return (minecraft.level == null || minecraft.level.getPlayerByUUID(uuid) == null) ? false : true;
    }

    @NotNull
    public fT a(@NotNull Minecraft minecraft) {
        if (a == null) {
            fT fTVarB = b(minecraft.getUser().getProfileId());
            a = fTVarB;
            return fTVarB;
        }
        return a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public iS m404a(@NotNull Minecraft minecraft) {
        if (g == null) {
            iS iSVarA = mo306a(minecraft.getUser().getProfileId());
            g = iSVarA;
            return iSVarA;
        }
        return g;
    }

    @Override // com.boehmod.blockfront.common.player.c
    protected boolean d(@NotNull UUID uuid) {
        Minecraft minecraft = Minecraft.getInstance();
        return a(minecraft, uuid) || uuid.equals(minecraft.getUser().getProfileId());
    }

    @Override // com.boehmod.blockfront.common.player.c
    @NotNull
    protected PlayerDataCacheLoader<fT, ?> a() {
        return new fU(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.common.player.c
    /* JADX INFO: renamed from: a */
    public fT mo306a(@NotNull UUID uuid) {
        return new fT(uuid);
    }
}
