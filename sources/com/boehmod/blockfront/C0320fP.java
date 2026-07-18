package com.boehmod.blockfront;

import com.boehmod.blockfront.InterfaceC0314fJ;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.nio.ByteBuffer;
import net.minecraft.client.Camera;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.lwjgl.opengl.GL20C;

/* JADX INFO: renamed from: com.boehmod.blockfront.fP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fP.class */
public class C0320fP extends AbstractC0313fI<InterfaceC0354fx> {

    /* JADX INFO: renamed from: iB */
    static final int f2347iB = 52;

    public C0320fP() {
        super(new InterfaceC0314fJ.b());
    }

    @Override // com.boehmod.blockfront.AbstractC0313fI
    /* JADX INFO: renamed from: aD */
    protected void mo1609aD() {
        BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, f2317a);
        bufferBuilderBegin.addVertex(-1.0f, -1.0f, 0.0f).setUv(0.0f, 1.0f);
        bufferBuilderBegin.addVertex(1.0f, -1.0f, 0.0f).setUv(1.0f, 1.0f);
        bufferBuilderBegin.addVertex(1.0f, 1.0f, 0.0f).setUv(1.0f, 0.0f);
        bufferBuilderBegin.addVertex(-1.0f, 1.0f, 0.0f).setUv(0.0f, 0.0f);
        this.f2323a.bind();
        this.f2323a.upload(bufferBuilderBegin.buildOrThrow());
    }

    @Override // com.boehmod.blockfront.AbstractC0313fI
    /* JADX INFO: renamed from: ac */
    protected int mo1610ac() {
        return 7;
    }

    @Override // com.boehmod.blockfront.AbstractC0313fI
    /* JADX INFO: renamed from: k */
    protected void mo1611k(int i) {
        super.mo1611k(i);
        GL20C.glVertexAttribPointer(7, 4, 5126, false, i, 36L);
    }

    @Override // com.boehmod.blockfront.AbstractC0313fI
    /* JADX INFO: renamed from: a */
    protected void mo1615a(@NotNull Camera camera) {
        this.f2323a.bind();
    }

    @Override // com.boehmod.blockfront.AbstractC0313fI
    /* JADX INFO: renamed from: ad */
    protected int mo1613ad() {
        return f2347iB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0313fI
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo1616a(@NotNull InterfaceC0354fx interfaceC0354fx, @NotNull ByteBuffer byteBuffer, float f) {
        super.mo1616a(interfaceC0354fx, byteBuffer, f);
        Quaternionf quaternionfMo1454a = interfaceC0354fx.mo1454a(f);
        byteBuffer.putFloat(quaternionfMo1454a.x());
        byteBuffer.putFloat(quaternionfMo1454a.y());
        byteBuffer.putFloat(quaternionfMo1454a.z());
        byteBuffer.putFloat(quaternionfMo1454a.w());
    }
}
