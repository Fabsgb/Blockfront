package com.boehmod.blockfront;

import com.boehmod.blockfront.C0783oB;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.am */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/am.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0068am {

    /* JADX INFO: renamed from: P */
    static final /* synthetic */ boolean f446P;

    static {
        f446P = !C0068am.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m233a(@NotNull C0783oB.a aVar) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f446P && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        if (abstractC0787oFM2688a == null) {
            return;
        }
        int iM3586aU = abstractC0787oFM2688a.m3586aU();
        if (aVar.m3550aR() < iM3586aU) {
            aVar.m3551z(iM3586aU);
        }
        aVar.m3551z((int) (aVar.m3550aR() * abstractC0787oFM2688a.mo3585aG()));
    }
}
