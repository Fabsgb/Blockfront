package com.boehmod.blockfront;

import com.boehmod.blockfront.C0783oB;
import java.util.UUID;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oo.class */
public class C0822oo {

    /* JADX INFO: renamed from: fM */
    static final /* synthetic */ boolean f4448fM;

    static {
        f4448fM = !C0822oo.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m4191a(@NotNull C0783oB.b bVar) {
        Player playerM3554b = bVar.m3554b();
        if (playerM3554b instanceof Player) {
            Player player = playerM3554b;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f4448fM && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            UUID uuid = player.getUUID();
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
            if (abstractC0787oFMo2531a != null) {
                abstractC0787oFMo2531a.m3582b().m3815e(uuid);
            }
        }
    }
}
