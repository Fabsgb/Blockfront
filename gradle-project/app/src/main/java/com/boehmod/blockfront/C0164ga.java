package com.boehmod.blockfront;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.data.LightData;
import foundry.veil.api.client.render.light.renderer.LightRenderHandle;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ga, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ga.class */
public class C0164ga {

    @NotNull
    private static final List<a> I = new ObjectArrayList();

    public static void a(@NotNull LightData lightData, int i) {
        I.add(new a(VeilRenderSystem.renderer().getLightRenderer().addLight(lightData), i));
    }

    public static void aK() {
        Iterator<a> it = I.iterator();
        while (it.hasNext()) {
            a next = it.next();
            int i = next.iM;
            next.iM = i - 1;
            if (i <= 0) {
                next.a.free();
                it.remove();
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ga$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ga$a.class */
    private static class a {
        private final LightRenderHandle<?> a;
        private int iM;

        public a(@NotNull LightRenderHandle<?> lightRenderHandle, int i) {
            this.a = lightRenderHandle;
            this.iM = i;
        }
    }
}
