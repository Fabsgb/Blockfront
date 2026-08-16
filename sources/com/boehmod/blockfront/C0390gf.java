package com.boehmod.blockfront;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.nio.ByteBuffer;
import net.minecraft.client.Camera;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.lwjgl.opengl.GL20C;

/* JADX INFO: renamed from: com.boehmod.blockfront.gf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gf.class */
public class C0390gf extends AbstractC0330fY<InterfaceC0319fN> {

    /* JADX INFO: renamed from: jW */
    static final int f2542jW = 52;

    public C0390gf() {
        super(new InterfaceC0331fZ.b());
    }

    @Override // com.boehmod.blockfront.AbstractC0330fY
    /* JADX INFO: renamed from: aJ */
    protected void mo1679aJ() {
        BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, f2419a);
        bufferBuilderBegin.addVertex(-1.0f, -1.0f, 0.0f).setUv(0.0f, 1.0f);
        bufferBuilderBegin.addVertex(1.0f, -1.0f, 0.0f).setUv(1.0f, 1.0f);
        bufferBuilderBegin.addVertex(1.0f, 1.0f, 0.0f).setUv(1.0f, 0.0f);
        bufferBuilderBegin.addVertex(-1.0f, 1.0f, 0.0f).setUv(0.0f, 0.0f);
        this.f2425a.bind();
        this.f2425a.upload(bufferBuilderBegin.buildOrThrow());
    }

    @Override // com.boehmod.blockfront.AbstractC0330fY
    /* JADX INFO: renamed from: ao */
    protected int mo1680ao() {
        return 7;
    }

    @Override // com.boehmod.blockfront.AbstractC0330fY
    /* JADX INFO: renamed from: k */
    protected void mo1681k(int i) {
        super.mo1681k(i);
        GL20C.glVertexAttribPointer(7, 4, 5126, false, i, 36L);
    }

    @Override // com.boehmod.blockfront.AbstractC0330fY
    /* JADX INFO: renamed from: a */
    protected void mo1685a(@NotNull Camera camera) {
        this.f2425a.bind();
    }

    @Override // com.boehmod.blockfront.AbstractC0330fY
    /* JADX INFO: renamed from: ap */
    protected int mo1683ap() {
        return f2542jW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0330fY
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo1686a(@NotNull InterfaceC0319fN interfaceC0319fN, @NotNull ByteBuffer byteBuffer, float f) {
        super.mo1686a(interfaceC0319fN, byteBuffer, f);
        Quaternionf quaternionfMo1547a = interfaceC0319fN.mo1547a(f);
        byteBuffer.putFloat(quaternionfMo1547a.x());
        byteBuffer.putFloat(quaternionfMo1547a.y());
        byteBuffer.putFloat(quaternionfMo1547a.z());
        byteBuffer.putFloat(quaternionfMo1547a.w());
    }
}
