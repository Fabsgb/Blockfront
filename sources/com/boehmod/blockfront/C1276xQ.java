package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
import com.boehmod.blockfront.common.player.PlayerDataCacheLoader;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xQ.class */
public class C1276xQ extends AbstractC0183c<C1274xO> {

    /* JADX INFO: renamed from: jO */
    static final /* synthetic */ boolean f7485jO;

    static {
        f7485jO = !C1276xQ.class.desiredAssertionStatus();
    }

    public C1276xQ() {
        super(C1278xa.f7491oh, C1278xa.f7493oj);
    }

    @Override // com.boehmod.blockfront.common.player.AbstractC0183c
    /* JADX INFO: renamed from: d */
    protected boolean mo1124d(@NotNull UUID uuid) {
        MinecraftServer minecraftServerM2514a = C0561js.m2514a();
        if (f7485jO || minecraftServerM2514a != null) {
            return minecraftServerM2514a.getPlayerList().getPlayer(uuid) != null;
        }
        throw new AssertionError("Minecraft Server instance is null!");
    }

    @Override // com.boehmod.blockfront.common.player.AbstractC0183c
    @NotNull
    /* JADX INFO: renamed from: a */
    protected PlayerDataCacheLoader<C1274xO, ?> mo1125a() {
        return new C1275xP(this);
    }

    @Override // com.boehmod.blockfront.common.player.AbstractC0183c
    /* JADX INFO: renamed from: a */
    public C1274xO mo1137a(@NotNull UUID uuid) {
        return new C1274xO(uuid);
    }
}
