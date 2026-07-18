package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingExperienceDropEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.om */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/om.class */
public final class C0820om {

    /* JADX INFO: renamed from: fK */
    static final /* synthetic */ boolean f4446fK;

    static {
        f4446fK = !C0820om.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m4189a(@NotNull LivingExperienceDropEvent livingExperienceDropEvent) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4446fK && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Player entity = livingExperienceDropEvent.getEntity();
        if ((entity instanceof Player) && abstractC0563juM168a.mo2531a(entity.getUUID()) != null) {
            livingExperienceDropEvent.setCanceled(true);
        }
        if (livingExperienceDropEvent.getEntity() instanceof C0727mz) {
            livingExperienceDropEvent.setCanceled(true);
        }
        if (livingExperienceDropEvent.getEntity().getPersistentData().hasUUID(C0799oR.f4377bK)) {
            livingExperienceDropEvent.setCanceled(true);
        }
    }
}
