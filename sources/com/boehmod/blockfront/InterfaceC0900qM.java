package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0787oF;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qM.class */
public interface InterfaceC0900qM<G extends AbstractC0787oF<?, ?, ?>> {
    /* JADX INFO: renamed from: a */
    void mo4664a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull EnumC0807oZ enumC0807oZ);

    /* JADX INFO: renamed from: a */
    default void m4665a(@NotNull G g, @NotNull UUID uuid, @NotNull EnumC0807oZ enumC0807oZ) {
        C0796oO c0796oOM3793a;
        AbstractC0790oI abstractC0790oIM3582b = g.m3582b();
        if (enumC0807oZ.getWaypoint() == null || (c0796oOM3793a = abstractC0790oIM3582b.m3793a(uuid)) == null) {
            return;
        }
        Iterator<UUID> it = c0796oOM3793a.m3872h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(it.next());
            if (serverPlayerM3963a != null) {
                C1194vo.m6648a(new C1180va(enumC0807oZ, uuid), serverPlayerM3963a);
            }
        }
    }
}
