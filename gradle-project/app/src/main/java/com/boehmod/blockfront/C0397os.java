package com.boehmod.blockfront;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Leashable;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.os, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/os.class */
public final class C0397os {
    static final /* synthetic */ boolean fQ;

    static {
        fQ = !C0397os.class.desiredAssertionStatus();
    }

    public static void a(@NotNull EntityTickEvent.Post post) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fQ && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Leashable entity = post.getEntity();
        CompoundTag persistentData = entity.getPersistentData();
        if (persistentData.hasUUID(oR.bK)) {
            oF<?, ?, ?> oFVarB = abstractC0264juM166a.b(persistentData.getUUID(oR.bK));
            if (oFVarB == null || oFVarB.m750a() == oN.POST_GAME || oFVarB.m750a() == oN.IDLE) {
                if (entity instanceof Leashable) {
                    entity.setLeashData((Leashable.LeashData) null);
                }
                C0263jt.logError("Failed to load match for entity '" + entity.getId() + "'. Discarding.", new Object[0]);
                entity.discard();
            }
        }
    }
}
