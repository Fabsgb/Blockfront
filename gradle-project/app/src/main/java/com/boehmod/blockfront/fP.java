package com.boehmod.blockfront;

import com.boehmod.blockfront.fJ;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.nio.ByteBuffer;
import net.minecraft.client.Camera;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.lwjgl.opengl.GL20C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fP.class */
public class fP extends fI<InterfaceC0160fx> {
    static final int iB = 52;

    public fP() {
        super(new fJ.b());
    }

    @Override // com.boehmod.blockfront.fI
    protected void aD() {
        BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, a);
        bufferBuilderBegin.addVertex(-1.0f, -1.0f, 0.0f).setUv(0.0f, 1.0f);
        bufferBuilderBegin.addVertex(1.0f, -1.0f, 0.0f).setUv(1.0f, 1.0f);
        bufferBuilderBegin.addVertex(1.0f, 1.0f, 0.0f).setUv(1.0f, 0.0f);
        bufferBuilderBegin.addVertex(-1.0f, 1.0f, 0.0f).setUv(0.0f, 0.0f);
        this.f121a.bind();
        this.f121a.upload(bufferBuilderBegin.buildOrThrow());
    }

    @Override // com.boehmod.blockfront.fI
    protected int ac() {
        return 7;
    }

    @Override // com.boehmod.blockfront.fI
    protected void k(int i) {
        super.k(i);
        GL20C.glVertexAttribPointer(7, 4, 5126, false, i, 36L);
    }

    @Override // com.boehmod.blockfront.fI
    protected void a(@NotNull Camera camera) {
        this.f121a.bind();
    }

    @Override // com.boehmod.blockfront.fI
    protected int ad() {
        return iB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.fI
    public void a(@NotNull InterfaceC0160fx interfaceC0160fx, @NotNull ByteBuffer byteBuffer, float f) {
        super.a(interfaceC0160fx, byteBuffer, f);
        Quaternionf quaternionfMo373a = interfaceC0160fx.mo373a(f);
        byteBuffer.putFloat(quaternionfMo373a.x());
        byteBuffer.putFloat(quaternionfMo373a.y());
        byteBuffer.putFloat(quaternionfMo373a.z());
        byteBuffer.putFloat(quaternionfMo373a.w());
    }
}
