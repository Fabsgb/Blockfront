package foundry.veil.impl.client.render.vertex;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.vertex.VertexArray;
import foundry.veil.api.client.render.vertex.VertexArrayBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.ARBVertexAttribBinding;
import org.lwjgl.opengl.GL20C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/vertex/ARBVertexAttribBindingBuilder.class */
@ApiStatus.Internal
public final class ARBVertexAttribBindingBuilder extends Record implements VertexArrayBuilder {
    private final VertexArray vertexArray;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ARBVertexAttribBindingBuilder.class), ARBVertexAttribBindingBuilder.class, "vertexArray", "FIELD:Lfoundry/veil/impl/client/render/vertex/ARBVertexAttribBindingBuilder;->vertexArray:Lfoundry/veil/api/client/render/vertex/VertexArray;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ARBVertexAttribBindingBuilder.class), ARBVertexAttribBindingBuilder.class, "vertexArray", "FIELD:Lfoundry/veil/impl/client/render/vertex/ARBVertexAttribBindingBuilder;->vertexArray:Lfoundry/veil/api/client/render/vertex/VertexArray;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ARBVertexAttribBindingBuilder.class, Object.class), ARBVertexAttribBindingBuilder.class, "vertexArray", "FIELD:Lfoundry/veil/impl/client/render/vertex/ARBVertexAttribBindingBuilder;->vertexArray:Lfoundry/veil/api/client/render/vertex/VertexArray;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArray vertexArray() {
        return this.vertexArray;
    }

    public ARBVertexAttribBindingBuilder(VertexArray vertexArray) {
        this.vertexArray = vertexArray;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder defineVertexBuffer(int index, int buffer, int offset, int stride, int divisor) {
        ARBVertexAttribBinding.glBindVertexBuffer(index, buffer, offset, stride);
        ARBVertexAttribBinding.glVertexBindingDivisor(index, divisor);
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder setVertexAttribute(int index, int bufferIndex, int size, VertexArrayBuilder.DataType type, boolean normalized, int relativeOffset) {
        VertexArrayBuilder.validateFloatType(type, size);
        VertexArrayBuilder.validateRelativeOffset(relativeOffset);
        GL20C.glEnableVertexAttribArray(index);
        ARBVertexAttribBinding.glVertexAttribFormat(index, size, type.getGlType(), normalized, relativeOffset);
        ARBVertexAttribBinding.glVertexAttribBinding(index, bufferIndex);
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder setVertexIAttribute(int index, int bufferIndex, int size, VertexArrayBuilder.DataType type, int relativeOffset) {
        VertexArrayBuilder.validateIntType(type);
        VertexArrayBuilder.validateRelativeOffset(relativeOffset);
        GL20C.glEnableVertexAttribArray(index);
        ARBVertexAttribBinding.glVertexAttribIFormat(index, size, type.getGlType(), relativeOffset);
        ARBVertexAttribBinding.glVertexAttribBinding(index, bufferIndex);
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder setVertexLAttribute(int index, int bufferIndex, int size, VertexArrayBuilder.DataType type, int relativeOffset) {
        VertexArrayBuilder.validateLongType(type);
        VertexArrayBuilder.validateRelativeOffset(relativeOffset);
        GL20C.glEnableVertexAttribArray(index);
        ARBVertexAttribBinding.glVertexAttribLFormat(index, size, type.getGlType(), relativeOffset);
        ARBVertexAttribBinding.glVertexAttribBinding(index, bufferIndex);
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder removeVertexBuffer(int index) {
        ARBVertexAttribBinding.glBindVertexBuffer(index, 0, 0L, 0);
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder removeAttribute(int index) {
        GL20C.glDisableVertexAttribArray(index);
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder clearVertexBuffers() {
        for (int i = 0; i < VeilRenderSystem.maxVertexAttributes(); i++) {
            ARBVertexAttribBinding.glBindVertexBuffer(i, 0, 0L, 0);
        }
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder clearVertexAttributes() {
        for (int i = 0; i < VeilRenderSystem.maxVertexAttributes(); i++) {
            GL20C.glDisableVertexAttribArray(i);
        }
        return this;
    }
}
