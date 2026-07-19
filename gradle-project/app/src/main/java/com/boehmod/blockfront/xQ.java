package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.PlayerDataCacheLoader;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xQ.class */
public class xQ extends com.boehmod.blockfront.common.player.c<xO> {
    static final /* synthetic */ boolean jO;

    static {
        jO = !xQ.class.desiredAssertionStatus();
    }

    public xQ() {
        super(C0622xa.oh, C0622xa.oj);
    }

    @Override // com.boehmod.blockfront.common.player.c
    protected boolean d(@NotNull UUID uuid) {
        MinecraftServer minecraftServerA = C0262js.a();
        if (jO || minecraftServerA != null) {
            return minecraftServerA.getPlayerList().getPlayer(uuid) != null;
        }
        throw new AssertionError("Minecraft Server instance is null!");
    }

    @Override // com.boehmod.blockfront.common.player.c
    @NotNull
    protected PlayerDataCacheLoader<xO, ?> a() {
        return new xP(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.common.player.c
    /* JADX INFO: renamed from: a */
    public xO mo306a(@NotNull UUID uuid) {
        return new xO(uuid);
    }
}
