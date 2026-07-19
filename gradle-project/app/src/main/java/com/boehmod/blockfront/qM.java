package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qM.class */
public interface qM<G extends oF<?, ?, ?>> {
    void a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull oZ oZVar);

    default void a(@NotNull G g, @NotNull UUID uuid, @NotNull oZ oZVar) {
        oO oOVarA;
        oI oIVarB = g.b();
        if (oZVar.getWaypoint() == null || (oOVarA = oIVarB.a(uuid)) == null) {
            return;
        }
        Iterator<UUID> it = oOVarA.h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerA = oR.a(it.next());
            if (serverPlayerA != null) {
                C0582vo.a(new C0568va(oZVar, uuid), serverPlayerA);
            }
        }
    }
}
