package com.boehmod.blockfront;

import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xr.class */
public class C1295xr {
    /* JADX INFO: renamed from: a */
    public static void m7920a(@NotNull C0029a c0029a, @NotNull FMLDedicatedServerSetupEvent fMLDedicatedServerSetupEvent) {
        C1300xw c1300xw = new C1300xw();
        c0029a.m169a(c1300xw);
        fMLDedicatedServerSetupEvent.enqueueWork(() -> {
            C0562jt.log("Setting up dedicated server...", new Object[0]);
            C1301xx.m7963d(c1300xw);
            C0552jj.m2492ba();
            C1299xv.m7943c(c1300xw);
            C0562jt.log("Finished setting up dedicated server...", new Object[0]);
        });
    }
}
