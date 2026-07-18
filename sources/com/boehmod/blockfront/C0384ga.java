package com.boehmod.blockfront;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.data.LightData;
import foundry.veil.api.client.render.light.renderer.LightRenderHandle;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ga */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ga.class */
public class C0384ga {

    /* JADX INFO: renamed from: I */
    @NotNull
    private static final List<a> f2539I = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    public static void m1842a(@NotNull LightData lightData, int i) {
        f2539I.add(new a(VeilRenderSystem.renderer().getLightRenderer().addLight(lightData), i));
    }

    /* JADX INFO: renamed from: aK */
    public static void m1843aK() {
        Iterator<a> it = f2539I.iterator();
        while (it.hasNext()) {
            a next = it.next();
            int i = next.f2541iM;
            next.f2541iM = i - 1;
            if (i <= 0) {
                next.f2540a.free();
                it.remove();
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ga$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ga$a.class */
    private static class a {

        /* JADX INFO: renamed from: a */
        private final LightRenderHandle<?> f2540a;

        /* JADX INFO: renamed from: iM */
        private int f2541iM;

        public a(@NotNull LightRenderHandle<?> lightRenderHandle, int i) {
            this.f2540a = lightRenderHandle;
            this.f2541iM = i;
        }
    }
}
