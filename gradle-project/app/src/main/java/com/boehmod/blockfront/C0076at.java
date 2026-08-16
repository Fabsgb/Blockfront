package com.boehmod.blockfront;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.at */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/at.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0076at {

    /* JADX INFO: renamed from: U */
    static final /* synthetic */ boolean f489U;

    static {
        f489U = !C0076at.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m287a(@NotNull C0806oX.a aVar) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f489U && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a == null) {
            return;
        }
        int iM4022bj = abstractC0863pbM2874a.m4022bj();
        if (aVar.m3698bg() < iM4022bj) {
            aVar.m3699A(iM4022bj);
        }
        aVar.m3699A((int) (aVar.m3698bg() * abstractC0863pbM2874a.mo4021aM()));
    }
}
