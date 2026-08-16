package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oK.class */
public class C0793oK {

    /* JADX INFO: renamed from: gg */
    static final /* synthetic */ boolean f4339gg;

    static {
        f4339gg = !C0793oK.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3679a(@NotNull C0806oX.b bVar) {
        Player playerM3702b = bVar.m3702b();
        if (playerM3702b instanceof Player) {
            Player player = playerM3702b;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4339gg && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            UUID uuid = player.getUUID();
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
            if (abstractC0863pbMo2354a != null) {
                abstractC0863pbMo2354a.m4018b().m4251e(uuid);
            }
        }
    }
}
