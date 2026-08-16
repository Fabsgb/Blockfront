package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0863pb;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rj.class */
public interface InterfaceC0977rj<G extends AbstractC0863pb<?, ?, ?>> {
    /* JADX INFO: renamed from: a */
    void mo5350a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull EnumC0883pv enumC0883pv);

    /* JADX INFO: renamed from: a */
    default void m5551a(@NotNull G g, @NotNull UUID uuid, @NotNull EnumC0883pv enumC0883pv) {
        C0872pk c0872pkM4229a;
        AbstractC0866pe abstractC0866peM4018b = g.m4018b();
        if (enumC0883pv.getWaypoint() == null || (c0872pkM4229a = abstractC0866peM4018b.m4229a(uuid)) == null) {
            return;
        }
        Iterator<UUID> it = c0872pkM4229a.m4308h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(it.next());
            if (serverPlayerM4399a != null) {
                C1169vO.m6643a(new C1155vA(enumC0883pv, uuid), serverPlayerM4399a);
            }
        }
    }
}
