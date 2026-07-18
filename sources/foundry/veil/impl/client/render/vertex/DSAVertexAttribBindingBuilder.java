package foundry.veil.impl.client.render.vertex;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.vertex.VertexArray;
import foundry.veil.api.client.render.vertex.VertexArrayBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.ARBDirectStateAccess;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/vertex/DSAVertexAttribBindingBuilder.class */
@ApiStatus.Internal
public final class DSAVertexAttribBindingBuilder extends Record implements VertexArrayBuilder {
    private final VertexArray vertexArray;
    private final int vao;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, DSAVertexAttribBindingBuilder.class), DSAVertexAttribBindingBuilder.class, "vertexArray;vao", "FIELD:Lfoundry/veil/impl/client/render/vertex/DSAVertexAttribBindingBuilder;->vertexArray:Lfoundry/veil/api/client/render/vertex/VertexArray;", "FIELD:Lfoundry/veil/impl/client/render/vertex/DSAVertexAttribBindingBuilder;->vao:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, DSAVertexAttribBindingBuilder.class), DSAVertexAttribBindingBuilder.class, "vertexArray;vao", "FIELD:Lfoundry/veil/impl/client/render/vertex/DSAVertexAttribBindingBuilder;->vertexArray:Lfoundry/veil/api/client/render/vertex/VertexArray;", "FIELD:Lfoundry/veil/impl/client/render/vertex/DSAVertexAttribBindingBuilder;->vao:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, DSAVertexAttribBindingBuilder.class, Object.class), DSAVertexAttribBindingBuilder.class, "vertexArray;vao", "FIELD:Lfoundry/veil/impl/client/render/vertex/DSAVertexAttribBindingBuilder;->vertexArray:Lfoundry/veil/api/client/render/vertex/VertexArray;", "FIELD:Lfoundry/veil/impl/client/render/vertex/DSAVertexAttribBindingBuilder;->vao:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArray vertexArray() {
        return this.vertexArray;
    }

    public int vao() {
        return this.vao;
    }

    public DSAVertexAttribBindingBuilder(VertexArray vertexArray, int vao) {
        this.vertexArray = vertexArray;
        this.vao = vao;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder defineVertexBuffer(int index, int buffer, int offset, int stride, int divisor) {
        ARBDirectStateAccess.glVertexArrayVertexBuffer(this.vao, index, buffer, offset, stride);
        ARBDirectStateAccess.glVertexArrayBindingDivisor(this.vao, index, divisor);
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder setVertexAttribute(int index, int bufferIndex, int size, VertexArrayBuilder.DataType type, boolean normalized, int relativeOffset) {
        VertexArrayBuilder.validateFloatType(type, size);
        VertexArrayBuilder.validateRelativeOffset(relativeOffset);
        ARBDirectStateAccess.glEnableVertexArrayAttrib(this.vao, index);
        ARBDirectStateAccess.glVertexArrayAttribFormat(this.vao, index, size, type.getGlType(), normalized, relativeOffset);
        ARBDirectStateAccess.glVertexArrayAttribBinding(this.vao, index, bufferIndex);
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder setVertexIAttribute(int index, int bufferIndex, int size, VertexArrayBuilder.DataType type, int relativeOffset) {
        VertexArrayBuilder.validateIntType(type);
        VertexArrayBuilder.validateRelativeOffset(relativeOffset);
        ARBDirectStateAccess.glEnableVertexArrayAttrib(this.vao, index);
        ARBDirectStateAccess.glVertexArrayAttribIFormat(this.vao, index, size, type.getGlType(), relativeOffset);
        ARBDirectStateAccess.glVertexArrayAttribBinding(this.vao, index, bufferIndex);
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder setVertexLAttribute(int index, int bufferIndex, int size, VertexArrayBuilder.DataType type, int relativeOffset) {
        VertexArrayBuilder.validateLongType(type);
        VertexArrayBuilder.validateRelativeOffset(relativeOffset);
        ARBDirectStateAccess.glEnableVertexArrayAttrib(this.vao, index);
        ARBDirectStateAccess.glVertexArrayAttribLFormat(this.vao, index, size, type.getGlType(), relativeOffset);
        ARBDirectStateAccess.glVertexArrayAttribBinding(this.vao, index, bufferIndex);
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder removeVertexBuffer(int index) {
        ARBDirectStateAccess.glVertexArrayVertexBuffer(this.vao, index, 0, 0L, 0);
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder removeAttribute(int index) {
        ARBDirectStateAccess.glDisableVertexArrayAttrib(this.vao, index);
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder clearVertexBuffers() {
        for (int i = 0; i < VeilRenderSystem.maxVertexAttributes(); i++) {
            ARBDirectStateAccess.glVertexArrayVertexBuffer(this.vao, i, 0, 0L, 0);
        }
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder clearVertexAttributes() {
        for (int i = 0; i < VeilRenderSystem.maxVertexAttributes(); i++) {
            ARBDirectStateAccess.glDisableVertexArrayAttrib(this.vao, i);
        }
        return this;
    }
}
