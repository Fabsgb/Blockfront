package com.boehmod.blockfront;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.data.LightData;
import foundry.veil.api.client.render.light.renderer.LightRenderHandle;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gq.class */
public class C0401gq {

    /* JADX INFO: renamed from: L */
    @NotNull
    private static final List<a> f2594L = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    public static void m1906a(@NotNull LightData lightData, int i) {
        f2594L.add(new a(VeilRenderSystem.renderer().getLightRenderer().addLight(lightData), i));
    }

    /* JADX INFO: renamed from: aQ */
    public static void m1907aQ() {
        Iterator<a> it = f2594L.iterator();
        while (it.hasNext()) {
            a next = it.next();
            int i = next.f2596kh;
            next.f2596kh = i - 1;
            if (i <= 0) {
                next.f2595a.free();
                it.remove();
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.gq$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gq$a.class */
    private static class a {

        /* JADX INFO: renamed from: a */
        private final LightRenderHandle<?> f2595a;

        /* JADX INFO: renamed from: kh */
        private int f2596kh;

        public a(@NotNull LightRenderHandle<?> lightRenderHandle, int i) {
            this.f2595a = lightRenderHandle;
            this.f2596kh = i;
        }
    }
}
