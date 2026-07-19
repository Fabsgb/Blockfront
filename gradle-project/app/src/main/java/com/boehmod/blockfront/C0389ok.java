package com.boehmod.blockfront;

import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ok, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ok.class */
public class C0389ok {
    public static void a(@NotNull EntityAttributeCreationEvent entityAttributeCreationEvent) {
        entityAttributeCreationEvent.put((EntityType) wX.lb.get(), mC.a().build());
        entityAttributeCreationEvent.put((EntityType) wX.kF.get(), mE.a().build());
        entityAttributeCreationEvent.put((EntityType) wX.lc.get(), mQ.a().build());
        entityAttributeCreationEvent.put((EntityType) wX.kD.get(), mY.a().build());
        entityAttributeCreationEvent.put((EntityType) wX.ld.get(), mR.a().build());
        entityAttributeCreationEvent.put((EntityType) wX.le.get(), mS.a().build());
        entityAttributeCreationEvent.put((EntityType) wX.lf.get(), mT.a().build());
        entityAttributeCreationEvent.put((EntityType) wX.kG.get(), mW.a().build());
        entityAttributeCreationEvent.put((EntityType) wX.kH.get(), mW.a().build());
        entityAttributeCreationEvent.put((EntityType) wX.kI.get(), mU.a().build());
    }
}
