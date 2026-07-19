package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.VertexBuffer;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Iterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.gu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gu.class */
public class C0184gu {
    private static final int jc = 20;

    @NotNull
    private final Map<C0181gr, C0180gq> g = new Object2ObjectOpenHashMap();
    private long e;

    public void tick() {
        long j = this.e;
        this.e = j + 1;
        Iterator<C0180gq> it = this.g.values().iterator();
        while (it.hasNext()) {
            C0180gq next = it.next();
            if (j - next.b() > 20) {
                next.aF();
                it.remove();
            }
        }
    }

    @Nullable
    public C0180gq a(@NotNull C0181gr c0181gr) {
        C0180gq c0180gq = this.g.get(c0181gr);
        if (c0180gq != null) {
            c0180gq.b(this.e);
        }
        return c0180gq;
    }

    public void a(@NotNull C0181gr c0181gr, @NotNull VertexBuffer vertexBuffer) {
        this.g.put(c0181gr, new C0180gq(vertexBuffer, this.e));
    }

    public void e() {
        this.g.values().forEach((v0) -> {
            v0.aF();
        });
        this.g.clear();
    }
}
