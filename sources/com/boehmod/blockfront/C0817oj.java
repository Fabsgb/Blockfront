package com.boehmod.blockfront;

import net.neoforged.neoforge.event.entity.living.MobDespawnEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oj.class */
public class C0817oj {
    /* JADX INFO: renamed from: a */
    public static void m4186a(@NotNull MobDespawnEvent mobDespawnEvent) {
        if (mobDespawnEvent.getEntity().getPersistentData().hasUUID(C0799oR.f4377bK)) {
            mobDespawnEvent.setResult(MobDespawnEvent.Result.DENY);
        }
    }
}
