package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.VertexBuffer;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.system.NativeResource;

/* JADX INFO: renamed from: com.boehmod.blockfront.gq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gq.class */
public final class C0400gq implements NativeResource {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final VertexBuffer f2603c;

    /* JADX INFO: renamed from: d */
    private long f2604d;

    public C0400gq(@NotNull VertexBuffer vertexBuffer, long j) {
        this.f2603c = vertexBuffer;
        this.f2604d = j;
    }

    /* JADX INFO: renamed from: aF */
    public void m1899aF() {
        this.f2603c.close();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public VertexBuffer m1900a() {
        return this.f2603c;
    }

    /* JADX INFO: renamed from: b */
    public long m1901b() {
        return this.f2604d;
    }

    /* JADX INFO: renamed from: b */
    public void m1902b(long j) {
        this.f2604d = j;
    }
}
