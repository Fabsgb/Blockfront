package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.VertexBuffer;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Iterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.gu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gu.class */
public class C0404gu {

    /* JADX INFO: renamed from: jc */
    private static final int f2612jc = 20;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final Map<C0401gr, C0400gq> f2613g = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: e */
    private long f2614e;

    public void tick() {
        long j = this.f2614e;
        this.f2614e = j + 1;
        Iterator<C0400gq> it = this.f2613g.values().iterator();
        while (it.hasNext()) {
            C0400gq next = it.next();
            if (j - next.m1901b() > 20) {
                next.m1899aF();
                it.remove();
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0400gq m1922a(@NotNull C0401gr c0401gr) {
        C0400gq c0400gq = this.f2613g.get(c0401gr);
        if (c0400gq != null) {
            c0400gq.m1902b(this.f2614e);
        }
        return c0400gq;
    }

    /* JADX INFO: renamed from: a */
    public void m1923a(@NotNull C0401gr c0401gr, @NotNull VertexBuffer vertexBuffer) {
        this.f2613g.put(c0401gr, new C0400gq(vertexBuffer, this.f2614e));
    }

    /* JADX INFO: renamed from: e */
    public void m1924e() {
        this.f2613g.values().forEach((v0) -> {
            v0.m1899aF();
        });
        this.f2613g.clear();
    }
}
