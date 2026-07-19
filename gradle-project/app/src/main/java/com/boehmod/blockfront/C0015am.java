package com.boehmod.blockfront;

import com.boehmod.blockfront.oB;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.am, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/am.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0015am {
    static final /* synthetic */ boolean P;

    static {
        P = !C0015am.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    public static void a(@NotNull oB.a aVar) {
        C0297l c0297lB = C0297l.b();
        if (!P && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        if (oFVarM591a == null) {
            return;
        }
        int iAU = oFVarM591a.aU();
        if (aVar.aR() < iAU) {
            aVar.z(iAU);
        }
        aVar.z((int) (aVar.aR() * oFVarM591a.aG()));
    }
}
