package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
import com.boehmod.blockfront.common.player.PlayerDataCacheLoader;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.yo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/yo.class */
public class C1328yo extends AbstractC0184c<C1326ym> {

    /* JADX INFO: renamed from: ke */
    static final /* synthetic */ boolean f9069ke;

    static {
        f9069ke = !C1328yo.class.desiredAssertionStatus();
    }

    public C1328yo() {
        super(C1310xx.f7903oj, C1310xx.f7905ol);
    }

    @Override // com.boehmod.blockfront.common.player.AbstractC0184c
    /* JADX INFO: renamed from: d */
    protected boolean mo1141d(@NotNull UUID uuid) {
        MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
        if (f9069ke || minecraftServerM2335a != null) {
            return minecraftServerM2335a.getPlayerList().getPlayer(uuid) != null;
        }
        throw new AssertionError("Minecraft Server instance is null!");
    }

    @Override // com.boehmod.blockfront.common.player.AbstractC0184c
    @NotNull
    /* JADX INFO: renamed from: a */
    protected PlayerDataCacheLoader<C1326ym, ?> mo1142a() {
        return new C1327yn(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.common.player.AbstractC0184c
    /* JADX INFO: renamed from: a */
    public C1326ym mo1154a(@NotNull UUID uuid) {
        return new C1326ym(uuid);
    }
}
