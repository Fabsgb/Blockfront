package com.boehmod.blockfront;

import net.neoforged.neoforge.event.entity.living.MobDespawnEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oF.class */
public class C0788oF {
    /* JADX INFO: renamed from: a */
    public static void m3674a(@NotNull MobDespawnEvent mobDespawnEvent) {
        if (mobDespawnEvent.getEntity().getPersistentData().hasUUID(C0875pn.f4773bU)) {
            mobDespawnEvent.setResult(MobDespawnEvent.Result.DENY);
        }
    }
}
