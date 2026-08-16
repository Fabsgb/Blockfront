package foundry.veil.impl.client.render.vertex;

import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.vertex.VertexArray;
import foundry.veil.api.client.render.vertex.VertexArrayBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.ARBVertexAttrib64Bit;
import org.lwjgl.opengl.GL33C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder.class */
@ApiStatus.Internal
public class LegacyVertexAttribBindingBuilder implements VertexArrayBuilder {
    private final VertexArray vertexArray;
    private int boundIndex = -1;
    private final VertexBufferRegion[] vertexBuffers = new VertexBufferRegion[VeilRenderSystem.maxVertexAttributes()];
    private final VertexAttribute[] vertexAttributes = new VertexAttribute[VeilRenderSystem.maxVertexAttributes()];

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$VertexAttribute.class */
    private interface VertexAttribute {
        int bufferIndex();

        void apply(int i, VertexBufferRegion vertexBufferRegion);
    }

    public LegacyVertexAttribBindingBuilder(VertexArray vertexArray) {
        this.vertexArray = vertexArray;
    }

    private void bindIndex(int index) {
        if (index < 0 || index >= this.vertexBuffers.length) {
            throw new IllegalArgumentException("Invalid vertex attribute index. Must be between 0 and " + (this.vertexBuffers.length - 1) + ": " + index);
        }
        if (this.boundIndex != index) {
            if (this.vertexBuffers[index] == null) {
                throw new IllegalArgumentException("No vertex buffer defined for index: " + index);
            }
            RenderSystem.glBindBuffer(34962, this.vertexBuffers[index].buffer);
            this.boundIndex = index;
        }
    }

    private void setAttribute(int index, VertexAttribute attribute) {
        this.vertexAttributes[index] = attribute;
        VertexBufferRegion buffer = this.vertexBuffers[attribute.bufferIndex()];
        if (buffer != null) {
            bindIndex(attribute.bufferIndex());
            attribute.apply(index, buffer);
        }
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArray vertexArray() {
        return this.vertexArray;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder defineVertexBuffer(int index, int buffer, int offset, int stride, int divisor) {
        if (index < 0 || index >= this.vertexBuffers.length) {
            throw new IllegalArgumentException("Invalid vertex attribute index. Must be between 0 and " + (this.vertexBuffers.length - 1) + ": " + index);
        }
        this.vertexBuffers[index] = new VertexBufferRegion(buffer, offset, stride, divisor);
        bindIndex(index);
        for (VertexAttribute attribute : this.vertexAttributes) {
            if (attribute != null && attribute.bufferIndex() == index) {
                attribute.apply(index, this.vertexBuffers[index]);
            }
        }
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder setVertexAttribute(int index, int bufferIndex, int size, VertexArrayBuilder.DataType type, boolean normalized, int relativeOffset) {
        VertexArrayBuilder.validateFloatType(type, size);
        VertexArrayBuilder.validateRelativeOffset(relativeOffset);
        GL33C.glEnableVertexAttribArray(index);
        setAttribute(index, new FloatAttribute(bufferIndex, size, type, normalized, relativeOffset));
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder setVertexIAttribute(int index, int bufferIndex, int size, VertexArrayBuilder.DataType type, int relativeOffset) {
        VertexArrayBuilder.validateIntType(type);
        VertexArrayBuilder.validateRelativeOffset(relativeOffset);
        GL33C.glEnableVertexAttribArray(index);
        setAttribute(index, new IntAttribute(bufferIndex, size, type, relativeOffset));
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder setVertexLAttribute(int index, int bufferIndex, int size, VertexArrayBuilder.DataType type, int relativeOffset) {
        VertexArrayBuilder.validateLongType(type);
        VertexArrayBuilder.validateRelativeOffset(relativeOffset);
        GL33C.glEnableVertexAttribArray(index);
        setAttribute(index, new LongAttribute(bufferIndex, size, type, relativeOffset));
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder removeVertexBuffer(int index) {
        if (index < 0 || index >= this.vertexBuffers.length) {
            throw new IllegalArgumentException("Invalid vertex attribute index. Must be between 0 and " + (this.vertexBuffers.length - 1) + ": " + index);
        }
        this.vertexBuffers[index] = null;
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder removeAttribute(int index) {
        GL33C.glDisableVertexAttribArray(index);
        this.vertexAttributes[index] = null;
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder clearVertexBuffers() {
        Arrays.fill(this.vertexBuffers, (Object) null);
        return this;
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArrayBuilder
    public VertexArrayBuilder clearVertexAttributes() {
        for (int i = 0; i < this.vertexAttributes.length; i++) {
            GL33C.glDisableVertexAttribArray(i);
        }
        Arrays.fill(this.vertexAttributes, (Object) null);
        return this;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute.class */
    private static final class FloatAttribute extends Record implements VertexAttribute {
        private final int bufferIndex;
        private final int size;
        private final VertexArrayBuilder.DataType type;
        private final boolean normalized;
        private final int relativeOffset;

        private FloatAttribute(int bufferIndex, int size, VertexArrayBuilder.DataType type, boolean normalized, int relativeOffset) {
            this.bufferIndex = bufferIndex;
            this.size = size;
            this.type = type;
            this.normalized = normalized;
            this.relativeOffset = relativeOffset;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FloatAttribute.class), FloatAttribute.class, "bufferIndex;size;type;normalized;relativeOffset", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->bufferIndex:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->size:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->type:Lfoundry/veil/api/client/render/vertex/VertexArrayBuilder$DataType;", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->normalized:Z", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->relativeOffset:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FloatAttribute.class), FloatAttribute.class, "bufferIndex;size;type;normalized;relativeOffset", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->bufferIndex:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->size:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->type:Lfoundry/veil/api/client/render/vertex/VertexArrayBuilder$DataType;", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->normalized:Z", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->relativeOffset:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FloatAttribute.class, Object.class), FloatAttribute.class, "bufferIndex;size;type;normalized;relativeOffset", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->bufferIndex:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->size:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->type:Lfoundry/veil/api/client/render/vertex/VertexArrayBuilder$DataType;", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->normalized:Z", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$FloatAttribute;->relativeOffset:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        @Override // foundry.veil.impl.client.render.vertex.LegacyVertexAttribBindingBuilder.VertexAttribute
        public int bufferIndex() {
            return this.bufferIndex;
        }

        public int size() {
            return this.size;
        }

        public VertexArrayBuilder.DataType type() {
            return this.type;
        }

        public boolean normalized() {
            return this.normalized;
        }

        public int relativeOffset() {
            return this.relativeOffset;
        }

        @Override // foundry.veil.impl.client.render.vertex.LegacyVertexAttribBindingBuilder.VertexAttribute
        public void apply(int index, VertexBufferRegion region) {
            GL33C.glVertexAttribPointer(index, this.size, this.type.getGlType(), this.normalized, region.stride, region.offset + this.relativeOffset);
            GL33C.glVertexAttribDivisor(index, region.divisor);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$IntAttribute.class */
    private static final class IntAttribute extends Record implements VertexAttribute {
        private final int bufferIndex;
        private final int size;
        private final VertexArrayBuilder.DataType type;
        private final int relativeOffset;

        private IntAttribute(int bufferIndex, int size, VertexArrayBuilder.DataType type, int relativeOffset) {
            this.bufferIndex = bufferIndex;
            this.size = size;
            this.type = type;
            this.relativeOffset = relativeOffset;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, IntAttribute.class), IntAttribute.class, "bufferIndex;size;type;relativeOffset", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$IntAttribute;->bufferIndex:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$IntAttribute;->size:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$IntAttribute;->type:Lfoundry/veil/api/client/render/vertex/VertexArrayBuilder$DataType;", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$IntAttribute;->relativeOffset:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, IntAttribute.class), IntAttribute.class, "bufferIndex;size;type;relativeOffset", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$IntAttribute;->bufferIndex:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$IntAttribute;->size:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$IntAttribute;->type:Lfoundry/veil/api/client/render/vertex/VertexArrayBuilder$DataType;", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$IntAttribute;->relativeOffset:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, IntAttribute.class, Object.class), IntAttribute.class, "bufferIndex;size;type;relativeOffset", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$IntAttribute;->bufferIndex:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$IntAttribute;->size:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$IntAttribute;->type:Lfoundry/veil/api/client/render/vertex/VertexArrayBuilder$DataType;", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$IntAttribute;->relativeOffset:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        @Override // foundry.veil.impl.client.render.vertex.LegacyVertexAttribBindingBuilder.VertexAttribute
        public int bufferIndex() {
            return this.bufferIndex;
        }

        public int size() {
            return this.size;
        }

        public VertexArrayBuilder.DataType type() {
            return this.type;
        }

        public int relativeOffset() {
            return this.relativeOffset;
        }

        @Override // foundry.veil.impl.client.render.vertex.LegacyVertexAttribBindingBuilder.VertexAttribute
        public void apply(int index, VertexBufferRegion region) {
            GL33C.glVertexAttribIPointer(index, this.size, this.type.getGlType(), region.stride, region.offset + this.relativeOffset);
            GL33C.glVertexAttribDivisor(index, region.divisor);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$LongAttribute.class */
    private static final class LongAttribute extends Record implements VertexAttribute {
        private final int bufferIndex;
        private final int size;
        private final VertexArrayBuilder.DataType type;
        private final int relativeOffset;

        private LongAttribute(int bufferIndex, int size, VertexArrayBuilder.DataType type, int relativeOffset) {
            this.bufferIndex = bufferIndex;
            this.size = size;
            this.type = type;
            this.relativeOffset = relativeOffset;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, LongAttribute.class), LongAttribute.class, "bufferIndex;size;type;relativeOffset", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$LongAttribute;->bufferIndex:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$LongAttribute;->size:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$LongAttribute;->type:Lfoundry/veil/api/client/render/vertex/VertexArrayBuilder$DataType;", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$LongAttribute;->relativeOffset:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, LongAttribute.class), LongAttribute.class, "bufferIndex;size;type;relativeOffset", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$LongAttribute;->bufferIndex:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$LongAttribute;->size:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$LongAttribute;->type:Lfoundry/veil/api/client/render/vertex/VertexArrayBuilder$DataType;", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$LongAttribute;->relativeOffset:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, LongAttribute.class, Object.class), LongAttribute.class, "bufferIndex;size;type;relativeOffset", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$LongAttribute;->bufferIndex:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$LongAttribute;->size:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$LongAttribute;->type:Lfoundry/veil/api/client/render/vertex/VertexArrayBuilder$DataType;", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$LongAttribute;->relativeOffset:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        @Override // foundry.veil.impl.client.render.vertex.LegacyVertexAttribBindingBuilder.VertexAttribute
        public int bufferIndex() {
            return this.bufferIndex;
        }

        public int size() {
            return this.size;
        }

        public VertexArrayBuilder.DataType type() {
            return this.type;
        }

        public int relativeOffset() {
            return this.relativeOffset;
        }

        @Override // foundry.veil.impl.client.render.vertex.LegacyVertexAttribBindingBuilder.VertexAttribute
        public void apply(int index, VertexBufferRegion region) {
            ARBVertexAttrib64Bit.glVertexAttribLPointer(index, this.size, this.type.getGlType(), region.stride, region.offset + this.relativeOffset);
            GL33C.glVertexAttribDivisor(index, region.divisor);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$VertexBufferRegion.class */
    private static final class VertexBufferRegion extends Record {
        private final int buffer;
        private final int offset;
        private final int stride;
        private final int divisor;

        private VertexBufferRegion(int buffer, int offset, int stride, int divisor) {
            this.buffer = buffer;
            this.offset = offset;
            this.stride = stride;
            this.divisor = divisor;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, VertexBufferRegion.class), VertexBufferRegion.class, "buffer;offset;stride;divisor", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$VertexBufferRegion;->buffer:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$VertexBufferRegion;->offset:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$VertexBufferRegion;->stride:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$VertexBufferRegion;->divisor:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, VertexBufferRegion.class), VertexBufferRegion.class, "buffer;offset;stride;divisor", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$VertexBufferRegion;->buffer:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$VertexBufferRegion;->offset:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$VertexBufferRegion;->stride:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$VertexBufferRegion;->divisor:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, VertexBufferRegion.class, Object.class), VertexBufferRegion.class, "buffer;offset;stride;divisor", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$VertexBufferRegion;->buffer:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$VertexBufferRegion;->offset:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$VertexBufferRegion;->stride:I", "FIELD:Lfoundry/veil/impl/client/render/vertex/LegacyVertexAttribBindingBuilder$VertexBufferRegion;->divisor:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public int buffer() {
            return this.buffer;
        }

        public int offset() {
            return this.offset;
        }

        public int stride() {
            return this.stride;
        }

        public int divisor() {
            return this.divisor;
        }
    }
}
