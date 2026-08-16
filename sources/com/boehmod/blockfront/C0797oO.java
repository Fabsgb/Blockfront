package com.boehmod.blockfront;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Leashable;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oO.class */
public final class C0797oO {

    /* JADX INFO: renamed from: gk */
    static final /* synthetic */ boolean f4343gk;

    static {
        f4343gk = !C0797oO.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3683a(@NotNull EntityTickEvent.Post post) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4343gk && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Leashable entity = post.getEntity();
        CompoundTag persistentData = entity.getPersistentData();
        if (persistentData.hasUUID(C0875pn.f4773bU)) {
            AbstractC0863pb<?, ?, ?> abstractC0863pbM2361b = abstractC0531jNM179a.m2361b(persistentData.getUUID(C0875pn.f4773bU));
            if (abstractC0863pbM2361b == null || abstractC0863pbM2361b.m4023a() == EnumC0871pj.POST_GAME || abstractC0863pbM2361b.m4023a() == EnumC0871pj.IDLE) {
                if (entity instanceof Leashable) {
                    entity.setLeashData((Leashable.LeashData) null);
                }
                C0530jM.logError("Failed to load match for entity '" + entity.getId() + "'. Discarding.", new Object[0]);
                entity.discard();
            }
        }
    }
}
