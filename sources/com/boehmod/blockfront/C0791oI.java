package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingExperienceDropEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oI.class */
public final class C0791oI {

    /* JADX INFO: renamed from: ge */
    static final /* synthetic */ boolean f4337ge;

    static {
        f4337ge = !C0791oI.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3677a(@NotNull LivingExperienceDropEvent livingExperienceDropEvent) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4337ge && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Player entity = livingExperienceDropEvent.getEntity();
        if ((entity instanceof Player) && abstractC0531jNM179a.mo2354a(entity.getUUID()) != null) {
            livingExperienceDropEvent.setCanceled(true);
        }
        if (livingExperienceDropEvent.getEntity() instanceof C0698mV) {
            livingExperienceDropEvent.setCanceled(true);
        }
        if (livingExperienceDropEvent.getEntity().getPersistentData().hasUUID(C0875pn.f4773bU)) {
            livingExperienceDropEvent.setCanceled(true);
        }
    }
}
