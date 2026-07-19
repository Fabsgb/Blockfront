package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.VertexBuffer;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.system.NativeResource;

/* JADX INFO: renamed from: com.boehmod.blockfront.gq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gq.class */
public final class C0180gq implements NativeResource {

    @NotNull
    private final VertexBuffer c;
    private long d;

    public C0180gq(@NotNull VertexBuffer vertexBuffer, long j) {
        this.c = vertexBuffer;
        this.d = j;
    }

    public void aF() {
        this.c.close();
    }

    @NotNull
    public VertexBuffer a() {
        return this.c;
    }

    public long b() {
        return this.d;
    }

    public void b(long j) {
        this.d = j;
    }
}
