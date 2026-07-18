package com.boehmod.blockfront;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Leashable;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.os */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/os.class */
public final class C0826os {

    /* JADX INFO: renamed from: fQ */
    static final /* synthetic */ boolean f4452fQ;

    static {
        f4452fQ = !C0826os.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m4195a(@NotNull EntityTickEvent.Post post) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4452fQ && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Leashable entity = post.getEntity();
        CompoundTag persistentData = entity.getPersistentData();
        if (persistentData.hasUUID(C0799oR.f4377bK)) {
            AbstractC0787oF<?, ?, ?> abstractC0787oFM2538b = abstractC0563juM168a.m2538b(persistentData.getUUID(C0799oR.f4377bK));
            if (abstractC0787oFM2538b == null || abstractC0787oFM2538b.m3587a() == EnumC0795oN.POST_GAME || abstractC0787oFM2538b.m3587a() == EnumC0795oN.IDLE) {
                if (entity instanceof Leashable) {
                    entity.setLeashData((Leashable.LeashData) null);
                }
                C0562jt.logError("Failed to load match for entity '" + entity.getId() + "'. Discarding.", new Object[0]);
                entity.discard();
            }
        }
    }
}
