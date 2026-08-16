package com.boehmod.blockfront;

import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xO.class */
public class C1275xO {
    /* JADX INFO: renamed from: a */
    public static void m7247a(@NotNull C0030a c0030a, @NotNull FMLDedicatedServerSetupEvent fMLDedicatedServerSetupEvent) {
        C1280xT c1280xT = new C1280xT();
        c0030a.m180a(c1280xT);
        fMLDedicatedServerSetupEvent.enqueueWork(() -> {
            C0530jM.log("Setting up dedicated server...", new Object[0]);
            C1281xU.m7291d(c1280xT);
            C0520jC.m2312bm();
            C1279xS.m7270c(c1280xT);
            C0530jM.log("Finished setting up dedicated server...", new Object[0]);
        });
    }
}
