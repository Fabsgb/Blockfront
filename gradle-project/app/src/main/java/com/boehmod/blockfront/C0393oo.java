package com.boehmod.blockfront;

import com.boehmod.blockfront.oB;
import java.util.UUID;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oo.class */
public class C0393oo {
    static final /* synthetic */ boolean fM;

    static {
        fM = !C0393oo.class.desiredAssertionStatus();
    }

    public static void a(@NotNull oB.b bVar) {
        Player playerB = bVar.b();
        if (playerB instanceof Player) {
            Player player = playerB;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!fM && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            UUID uuid = player.getUUID();
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
            if (oFVarMo604a != null) {
                oFVarMo604a.b().e(uuid);
            }
        }
    }
}
