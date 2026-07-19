package com.boehmod.blockfront;

import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xr.class */
public class C0639xr {
    public static void a(@NotNull C0002a c0002a, @NotNull FMLDedicatedServerSetupEvent fMLDedicatedServerSetupEvent) {
        xw xwVar = new xw();
        c0002a.a(xwVar);
        fMLDedicatedServerSetupEvent.enqueueWork(() -> {
            C0263jt.log("Setting up dedicated server...", new Object[0]);
            xx.d(xwVar);
            C0253jj.ba();
            xv.c(xwVar);
            C0263jt.log("Finished setting up dedicated server...", new Object[0]);
        });
    }
}
