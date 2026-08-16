package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.VertexBuffer;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.system.NativeResource;

/* JADX INFO: renamed from: com.boehmod.blockfront.gG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gG.class */
public final class C0365gG implements NativeResource {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final VertexBuffer f2503c;

    /* JADX INFO: renamed from: i */
    private long f2504i;

    public C0365gG(@NotNull VertexBuffer vertexBuffer, long j) {
        this.f2503c = vertexBuffer;
        this.f2504i = j;
    }

    /* JADX INFO: renamed from: aL */
    public void m1756aL() {
        this.f2503c.close();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public VertexBuffer m1757a() {
        return this.f2503c;
    }

    /* JADX INFO: renamed from: c */
    public long m1758c() {
        return this.f2504i;
    }

    /* JADX INFO: renamed from: c */
    public void m1759c(long j) {
        this.f2504i = j;
    }
}
