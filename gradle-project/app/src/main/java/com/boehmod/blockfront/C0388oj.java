package com.boehmod.blockfront;

import net.neoforged.neoforge.event.entity.living.MobDespawnEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oj.class */
public class C0388oj {
    public static void a(@NotNull MobDespawnEvent mobDespawnEvent) {
        if (mobDespawnEvent.getEntity().getPersistentData().hasUUID(oR.bK)) {
            mobDespawnEvent.setResult(MobDespawnEvent.Result.DENY);
        }
    }
}
