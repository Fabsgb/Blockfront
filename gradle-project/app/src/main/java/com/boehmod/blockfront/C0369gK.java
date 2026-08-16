package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.VertexBuffer;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Iterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.gK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gK.class */
public class C0369gK {

    /* JADX INFO: renamed from: kx */
    private static final int f2513kx = 20;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final Map<C0366gH, C0365gG> f2514g = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: j */
    private long f2515j;

    public void tick() {
        long j = this.f2515j;
        this.f2515j = j + 1;
        Iterator<C0365gG> it = this.f2514g.values().iterator();
        while (it.hasNext()) {
            C0365gG next = it.next();
            if (j - next.m1758c() > 20) {
                next.m1756aL();
                it.remove();
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0365gG m1779a(@NotNull C0366gH c0366gH) {
        C0365gG c0365gG = this.f2514g.get(c0366gH);
        if (c0365gG != null) {
            c0365gG.m1759c(this.f2515j);
        }
        return c0365gG;
    }

    /* JADX INFO: renamed from: a */
    public void m1780a(@NotNull C0366gH c0366gH, @NotNull VertexBuffer vertexBuffer) {
        this.f2514g.put(c0366gH, new C0365gG(vertexBuffer, this.f2515j));
    }

    /* JADX INFO: renamed from: e */
    public void m1781e() {
        this.f2514g.values().forEach((v0) -> {
            v0.m1756aL();
        });
        this.f2514g.clear();
    }
}
