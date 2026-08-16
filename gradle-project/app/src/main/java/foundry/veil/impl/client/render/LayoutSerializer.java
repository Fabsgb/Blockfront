package foundry.veil.impl.client.render;

import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.VeilShaderBufferLayout;
import foundry.veil.api.client.render.shader.block.ShaderBlock;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.impl.client.render.shader.block.LayoutShaderBlockImpl;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.ARBProgramInterfaceQuery;
import org.lwjgl.opengl.GL31C;
import org.lwjgl.system.MemoryStack;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/LayoutSerializer.class */
@ApiStatus.Internal
public final class LayoutSerializer<T> extends Record implements BiConsumer<T, ByteBuffer> {
    private final Field<T>[] fields;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, LayoutSerializer.class), LayoutSerializer.class, "fields", "FIELD:Lfoundry/veil/impl/client/render/LayoutSerializer;->fields:[Lfoundry/veil/impl/client/render/LayoutSerializer$Field;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, LayoutSerializer.class), LayoutSerializer.class, "fields", "FIELD:Lfoundry/veil/impl/client/render/LayoutSerializer;->fields:[Lfoundry/veil/impl/client/render/LayoutSerializer$Field;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, LayoutSerializer.class, Object.class), LayoutSerializer.class, "fields", "FIELD:Lfoundry/veil/impl/client/render/LayoutSerializer;->fields:[Lfoundry/veil/impl/client/render/LayoutSerializer$Field;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Field<T>[] fields() {
        return this.fields;
    }

    public LayoutSerializer(Field<T>[] fields) {
        this.fields = fields;
    }

    public static <T> LayoutShaderBlockImpl<T> create(VeilShaderBufferLayout<T> layout, ShaderProgram shader, String name, int blockIndex) {
        int program = shader.getProgram();
        ShaderBlock.BufferBinding binding = layout.binding();
        if (VeilRenderSystem.programInterfaceQuerySupported()) {
            int bufferInterface = binding == ShaderBlock.BufferBinding.UNIFORM ? 37602 : 37606;
            int fieldInterface = binding == ShaderBlock.BufferBinding.UNIFORM ? 37601 : 37605;
            MemoryStack stack = MemoryStack.stackPush();
            try {
                IntBuffer fieldProperties = stack.ints(37628);
                IntBuffer values = stack.mallocInt(1);
                ARBProgramInterfaceQuery.glGetProgramResourceiv(program, bufferInterface, blockIndex, stack.ints(37635), (IntBuffer) null, values);
                int size = values.get(0);
                List<Field<T>> layoutFields = new ArrayList<>();
                for (Map.Entry<String, VeilShaderBufferLayout.FieldSerializer<T>> entry : layout.fields().entrySet()) {
                    String fieldName = name + "." + entry.getKey();
                    int index = ARBProgramInterfaceQuery.glGetProgramResourceIndex(program, fieldInterface, fieldName);
                    if (index == -1) {
                        Veil.LOGGER.warn("Failed to find buffer field '{}' in shader: {}", fieldName, shader.getName());
                    } else {
                        ARBProgramInterfaceQuery.glGetProgramResourceiv(program, fieldInterface, index, fieldProperties, (IntBuffer) null, values);
                        layoutFields.add(new Field<>(values.get(0), entry.getValue()));
                    }
                }
                layoutFields.sort(Comparator.comparingInt((v0) -> {
                    return v0.offset();
                }));
                LayoutSerializer<T> serializer = new LayoutSerializer<>((Field[]) layoutFields.toArray(x$0 -> {
                    return new Field[x$0];
                }));
                LayoutShaderBlockImpl<T> layoutShaderBlockImpl = new LayoutShaderBlockImpl<>(binding, size, serializer);
                if (stack != null) {
                    stack.close();
                }
                return layoutShaderBlockImpl;
            } catch (Throwable th) {
                if (stack != null) {
                    try {
                        stack.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        List<Field<T>> layoutFields2 = new ArrayList<>();
        for (Map.Entry<String, VeilShaderBufferLayout.FieldSerializer<T>> entry2 : layout.fields().entrySet()) {
            String fieldName2 = name + "." + entry2.getKey();
            int index2 = GL31C.glGetUniformIndices(program, fieldName2);
            if (index2 == -1) {
                Veil.LOGGER.warn("Failed to find buffer field '{}' in shader: {}", fieldName2, shader.getName());
            } else {
                int offset = GL31C.glGetActiveUniformsi(program, index2, 35387);
                if (offset == -1) {
                    Veil.LOGGER.warn("Buffer field '{}' in shader '{}' it not in a uniform block", fieldName2, shader.getName());
                } else {
                    layoutFields2.add(new Field<>(offset, entry2.getValue()));
                }
            }
        }
        int size2 = GL31C.glGetActiveUniformBlocki(program, blockIndex, 35392);
        layoutFields2.sort(Comparator.comparingInt((v0) -> {
            return v0.offset();
        }));
        LayoutSerializer<T> serializer2 = new LayoutSerializer<>((Field[]) layoutFields2.toArray(x$1 -> {
            return new Field[x$1];
        }));
        return new LayoutShaderBlockImpl<>(binding, size2, serializer2);
    }

    @Override // java.util.function.BiConsumer
    public void accept(T value, ByteBuffer buffer) {
        for (Field<T> field : this.fields) {
            ((Field) field).serializer.write(value, ((Field) field).offset, buffer);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/LayoutSerializer$Field.class */
    private static final class Field<T> extends Record {
        private final int offset;
        private final VeilShaderBufferLayout.FieldSerializer<T> serializer;

        private Field(int offset, VeilShaderBufferLayout.FieldSerializer<T> serializer) {
            this.offset = offset;
            this.serializer = serializer;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Field.class), Field.class, "offset;serializer", "FIELD:Lfoundry/veil/impl/client/render/LayoutSerializer$Field;->offset:I", "FIELD:Lfoundry/veil/impl/client/render/LayoutSerializer$Field;->serializer:Lfoundry/veil/api/client/render/VeilShaderBufferLayout$FieldSerializer;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Field.class), Field.class, "offset;serializer", "FIELD:Lfoundry/veil/impl/client/render/LayoutSerializer$Field;->offset:I", "FIELD:Lfoundry/veil/impl/client/render/LayoutSerializer$Field;->serializer:Lfoundry/veil/api/client/render/VeilShaderBufferLayout$FieldSerializer;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Field.class, Object.class), Field.class, "offset;serializer", "FIELD:Lfoundry/veil/impl/client/render/LayoutSerializer$Field;->offset:I", "FIELD:Lfoundry/veil/impl/client/render/LayoutSerializer$Field;->serializer:Lfoundry/veil/api/client/render/VeilShaderBufferLayout$FieldSerializer;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public int offset() {
            return this.offset;
        }

        public VeilShaderBufferLayout.FieldSerializer<T> serializer() {
            return this.serializer;
        }
    }
}
