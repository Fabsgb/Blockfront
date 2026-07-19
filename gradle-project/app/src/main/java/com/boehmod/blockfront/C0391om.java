package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingExperienceDropEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.om, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/om.class */
public final class C0391om {
    static final /* synthetic */ boolean fK;

    static {
        fK = !C0391om.class.desiredAssertionStatus();
    }

    public static void a(@NotNull LivingExperienceDropEvent livingExperienceDropEvent) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fK && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Player entity = livingExperienceDropEvent.getEntity();
        if ((entity instanceof Player) && abstractC0264juM166a.mo604a(entity.getUUID()) != null) {
            livingExperienceDropEvent.setCanceled(true);
        }
        if (livingExperienceDropEvent.getEntity() instanceof C0350mz) {
            livingExperienceDropEvent.setCanceled(true);
        }
        if (livingExperienceDropEvent.getEntity().getPersistentData().hasUUID(oR.bK)) {
            livingExperienceDropEvent.setCanceled(true);
        }
    }
}
