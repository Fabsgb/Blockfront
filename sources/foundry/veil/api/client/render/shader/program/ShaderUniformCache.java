package foundry.veil.api.client.render.shader.program;

import foundry.veil.api.client.render.VeilRenderSystem;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.ARBProgramInterfaceQuery;
import org.lwjgl.opengl.GL42C;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/program/ShaderUniformCache.class */
public class ShaderUniformCache {
    private static final IntSet SAMPLERS = IntSet.of(new int[]{35677, 35678, 35679, 35680, 35681, 35682, 36288, 36289, 36291, 36292, 37128, 37131, 36293, 36290, 35683, 35684, 36297, 36298, 36299, 36300, 36302, 36303, 37129, 37132, 36304, 36301, 36305, 36306, 36307, 36308, 36310, 36311, 37130, 37133, 36312, 36309, 36940, 36941, 36942, 36943, 36944, 36945, 36946, 36947, 36949, 36950, 36951, 36952, 36953, 36954, 36955, 36956, 36957, 36958, 36960, 36961, 36962, 36963, 36964, 36965, 36966, 36967, 36968, 36969, 36971, 36972});
    private static final Int2ObjectMap<String> NAMES;
    private final IntSupplier shader;
    private final Object2ObjectMap<String, Uniform> samplers = new Object2ObjectOpenHashMap();
    private final Object2ObjectMap<String, Uniform> uniforms = new Object2ObjectOpenHashMap();
    private final Object2ObjectMap<String, UniformBlock> uniformBlocks = new Object2ObjectOpenHashMap();
    private final Object2ObjectMap<String, StorageBlock> storageBlocks = new Object2ObjectOpenHashMap();
    private final Object2ObjectMap<String, Uniform> samplersView = Object2ObjectMaps.unmodifiable(this.samplers);
    private final Object2ObjectMap<String, Uniform> uniformsView = Object2ObjectMaps.unmodifiable(this.uniforms);
    private final Object2ObjectMap<String, UniformBlock> uniformBlocksView = Object2ObjectMaps.unmodifiable(this.uniformBlocks);
    private final Object2ObjectMap<String, StorageBlock> storageBlocksView = Object2ObjectMaps.unmodifiable(this.storageBlocks);
    private boolean requested = false;

    static {
        Int2ObjectArrayMap int2ObjectArrayMap = new Int2ObjectArrayMap(105);
        int2ObjectArrayMap.put(5126, "float");
        int2ObjectArrayMap.put(35664, "vec2");
        int2ObjectArrayMap.put(35665, "vec3");
        int2ObjectArrayMap.put(35666, "vec4");
        int2ObjectArrayMap.put(5130, "double");
        int2ObjectArrayMap.put(36860, "dvec2");
        int2ObjectArrayMap.put(36861, "dvec3");
        int2ObjectArrayMap.put(36862, "dvec4");
        int2ObjectArrayMap.put(5124, "int");
        int2ObjectArrayMap.put(35667, "ivec2");
        int2ObjectArrayMap.put(35668, "ivec3");
        int2ObjectArrayMap.put(35669, "ivec4");
        int2ObjectArrayMap.put(5125, "unsigned int");
        int2ObjectArrayMap.put(36294, "uvec2");
        int2ObjectArrayMap.put(36295, "uvec3");
        int2ObjectArrayMap.put(36296, "uvec4");
        int2ObjectArrayMap.put(35670, "bool");
        int2ObjectArrayMap.put(35671, "bvec2");
        int2ObjectArrayMap.put(35672, "bvec3");
        int2ObjectArrayMap.put(35673, "bvec4");
        int2ObjectArrayMap.put(35674, "mat2");
        int2ObjectArrayMap.put(35675, "mat3");
        int2ObjectArrayMap.put(35676, "mat4");
        int2ObjectArrayMap.put(35685, "mat2x3");
        int2ObjectArrayMap.put(35686, "mat2x4");
        int2ObjectArrayMap.put(35687, "mat3x2");
        int2ObjectArrayMap.put(35688, "mat3x4");
        int2ObjectArrayMap.put(35689, "mat4x2");
        int2ObjectArrayMap.put(35690, "mat4x3");
        int2ObjectArrayMap.put(36678, "dmat2");
        int2ObjectArrayMap.put(36679, "dmat3");
        int2ObjectArrayMap.put(36680, "dmat4");
        int2ObjectArrayMap.put(36681, "dmat2x3");
        int2ObjectArrayMap.put(36682, "dmat2x4");
        int2ObjectArrayMap.put(36683, "dmat3x2");
        int2ObjectArrayMap.put(36684, "dmat3x4");
        int2ObjectArrayMap.put(36685, "dmat4x2");
        int2ObjectArrayMap.put(36686, "dmat4x3");
        int2ObjectArrayMap.put(35677, "sampler1D");
        int2ObjectArrayMap.put(35678, "sampler2D");
        int2ObjectArrayMap.put(35679, "sampler3D");
        int2ObjectArrayMap.put(35680, "samplerCube");
        int2ObjectArrayMap.put(35681, "sampler1DShadow");
        int2ObjectArrayMap.put(35682, "sampler2DShadow");
        int2ObjectArrayMap.put(36288, "sampler1DArray");
        int2ObjectArrayMap.put(36289, "sampler2DArray");
        int2ObjectArrayMap.put(36291, "sampler1DArrayShadow");
        int2ObjectArrayMap.put(36292, "sampler2DArrayShadow");
        int2ObjectArrayMap.put(37128, "sampler2DMS");
        int2ObjectArrayMap.put(37131, "sampler2DMSArray");
        int2ObjectArrayMap.put(36293, "samplerCubeShadow");
        int2ObjectArrayMap.put(36290, "samplerBuffer");
        int2ObjectArrayMap.put(35683, "sampler2DRect");
        int2ObjectArrayMap.put(35684, "sampler2DRectShadow");
        int2ObjectArrayMap.put(36297, "isampler1D");
        int2ObjectArrayMap.put(36298, "isampler2D");
        int2ObjectArrayMap.put(36299, "isampler3D");
        int2ObjectArrayMap.put(36300, "isamplerCube");
        int2ObjectArrayMap.put(36302, "isampler1DArray");
        int2ObjectArrayMap.put(36303, "isampler2DArray");
        int2ObjectArrayMap.put(37129, "isampler2DMS");
        int2ObjectArrayMap.put(37132, "isampler2DMSArray");
        int2ObjectArrayMap.put(36304, "isamplerBuffer");
        int2ObjectArrayMap.put(36301, "isampler2DRect");
        int2ObjectArrayMap.put(36305, "usampler1D");
        int2ObjectArrayMap.put(36306, "usampler2D");
        int2ObjectArrayMap.put(36307, "usampler3D");
        int2ObjectArrayMap.put(36308, "usamplerCube");
        int2ObjectArrayMap.put(36310, "usampler2DArray");
        int2ObjectArrayMap.put(36311, "usampler2DArray");
        int2ObjectArrayMap.put(37130, "usampler2DMS");
        int2ObjectArrayMap.put(37133, "usampler2DMSArray");
        int2ObjectArrayMap.put(36312, "usamplerBuffer");
        int2ObjectArrayMap.put(36309, "usampler2DRect");
        int2ObjectArrayMap.put(36940, "image1D");
        int2ObjectArrayMap.put(36941, "image2D");
        int2ObjectArrayMap.put(36942, "image3D");
        int2ObjectArrayMap.put(36943, "image2DRect");
        int2ObjectArrayMap.put(36944, "imageCube");
        int2ObjectArrayMap.put(36945, "imageBuffer");
        int2ObjectArrayMap.put(36946, "image1DArray");
        int2ObjectArrayMap.put(36947, "image2DArray");
        int2ObjectArrayMap.put(36949, "image2DMS");
        int2ObjectArrayMap.put(36950, "image2DMSArray");
        int2ObjectArrayMap.put(36951, "iimage1D");
        int2ObjectArrayMap.put(36952, "iimage2D");
        int2ObjectArrayMap.put(36953, "iimage3D");
        int2ObjectArrayMap.put(36954, "iimage2DRect");
        int2ObjectArrayMap.put(36955, "iimageCube");
        int2ObjectArrayMap.put(36956, "iimageBuffer");
        int2ObjectArrayMap.put(36957, "iimage1DArray");
        int2ObjectArrayMap.put(36958, "iimage2DArray");
        int2ObjectArrayMap.put(36960, "iimage2DMS");
        int2ObjectArrayMap.put(36961, "iimage2DMSArray");
        int2ObjectArrayMap.put(36962, "uimage1D");
        int2ObjectArrayMap.put(36963, "uimage2D");
        int2ObjectArrayMap.put(36964, "uimage3D");
        int2ObjectArrayMap.put(36965, "uimage2DRect");
        int2ObjectArrayMap.put(36966, "uimageCube");
        int2ObjectArrayMap.put(36967, "uimageBuffer");
        int2ObjectArrayMap.put(36968, "uimage1DArray");
        int2ObjectArrayMap.put(36969, "uimage2DArray");
        int2ObjectArrayMap.put(36971, "uimage2DMS");
        int2ObjectArrayMap.put(36972, "uimage2DMSArray");
        int2ObjectArrayMap.put(37595, "atomic_uint");
        NAMES = Int2ObjectMaps.unmodifiable(int2ObjectArrayMap);
    }

    public ShaderUniformCache(IntSupplier shader) {
        this.shader = shader;
    }

    public void clear() {
        this.samplers.clear();
        this.uniforms.clear();
        this.uniformBlocks.clear();
        this.storageBlocks.clear();
        this.requested = false;
    }

    private void updateUniforms() {
        this.requested = true;
        int program = this.shader.getAsInt();
        if (VeilRenderSystem.programInterfaceQuerySupported()) {
            int uniformCount = ARBProgramInterfaceQuery.glGetProgramInterfacei(program, 37601, 37621);
            int uniformBlockCount = ARBProgramInterfaceQuery.glGetProgramInterfacei(program, 37602, 37621);
            int storageBlockCount = ARBProgramInterfaceQuery.glGetProgramInterfacei(program, 37606, 37621);
            MemoryStack stack = MemoryStack.stackPush();
            try {
                IntBuffer uniformProperties = stack.ints(new int[]{37629, 37627, 37625, 37646, 37626});
                IntBuffer uniformBlockProperties = stack.ints(37625, 37635, 37636);
                IntBuffer uniformBlockFieldProperties = stack.ints(new int[]{37625, 37627, 37630, 37628, 37626, 37633});
                IntBuffer uniformBufferFieldProperties = stack.ints(new int[]{37625, 37627, 37630, 37628, 37626});
                IntBuffer activeVariables = stack.ints(37637);
                IntBuffer values = stack.mallocInt(6);
                for (int i = 0; i < uniformCount; i++) {
                    ARBProgramInterfaceQuery.glGetProgramResourceiv(program, 37601, i, uniformProperties, (IntBuffer) null, values);
                    int blockIndex = values.get(0);
                    if (blockIndex == -1) {
                        int length = values.get(1);
                        int type = values.get(4);
                        String resourceName = ARBProgramInterfaceQuery.glGetProgramResourceName(program, 37601, i, values.get(2));
                        String baseName = resourceName.contains("[") ? resourceName.substring(0, resourceName.indexOf(91)) : resourceName;
                        for (int j = 0; j < length; j++) {
                            String name = length > 1 ? baseName + "[" + j + "]" : baseName;
                            int location = values.get(3) + j;
                            Uniform uniform = new Uniform(name, location, 0, type, 1);
                            this.uniforms.put(name, uniform);
                            if (isSampler(type)) {
                                this.samplers.put(name, uniform);
                            }
                        }
                        if (length > 1) {
                            Uniform uniform2 = new Uniform(baseName, values.get(3), 0, type, length);
                            this.uniforms.put(baseName, uniform2);
                            if (isSampler(type)) {
                                this.samplers.put(baseName, uniform2);
                            }
                        }
                    }
                }
                for (int i2 = 0; i2 < uniformBlockCount; i2++) {
                    ARBProgramInterfaceQuery.glGetProgramResourceiv(program, 37602, i2, uniformBlockProperties, (IntBuffer) null, values);
                    String blockName = ARBProgramInterfaceQuery.glGetProgramResourceName(program, 37602, i2, values.get(0));
                    int size = values.get(1);
                    int fieldCount = values.get(2);
                    List<Uniform> fields = new ArrayList<>(fieldCount);
                    IntBuffer fieldIndices = MemoryUtil.memAllocInt(fieldCount);
                    ARBProgramInterfaceQuery.glGetProgramResourceiv(program, 37602, i2, activeVariables, (IntBuffer) null, fieldIndices);
                    for (int j2 = 0; j2 < fieldCount; j2++) {
                        try {
                            ARBProgramInterfaceQuery.glGetProgramResourceiv(program, 37601, fieldIndices.get(j2), uniformBlockFieldProperties, (IntBuffer) null, values);
                            if (values.get(5) == -1) {
                                String name2 = ARBProgramInterfaceQuery.glGetProgramResourceName(program, 37601, fieldIndices.get(j2), values.get(0));
                                int arrayLength = values.get(1);
                                int offset = values.get(3);
                                int type2 = values.get(4);
                                if (arrayLength > 0) {
                                    int stride = values.get(2);
                                    String nameBase = name2.endsWith("]") ? name2.substring(0, name2.length() - 3) : name2;
                                    for (int k = 0; k < arrayLength; k++) {
                                        fields.add(new Uniform(nameBase + "[" + k + "]", -1, offset + (stride * k), type2, 1));
                                    }
                                } else {
                                    fields.add(new Uniform(name2, -1, offset, type2, 1));
                                }
                            }
                        } catch (Throwable th) {
                            MemoryUtil.memFree(fieldIndices);
                            throw th;
                        }
                    }
                    this.uniformBlocks.put(blockName, new UniformBlock(blockName, i2, size, (Uniform[]) fields.toArray(x$0 -> {
                        return new Uniform[x$0];
                    })));
                    MemoryUtil.memFree(fieldIndices);
                }
                for (int i3 = 0; i3 < storageBlockCount; i3++) {
                    ARBProgramInterfaceQuery.glGetProgramResourceiv(program, 37606, i3, uniformBlockProperties, (IntBuffer) null, values);
                    String blockName2 = ARBProgramInterfaceQuery.glGetProgramResourceName(program, 37606, i3, values.get(0));
                    int size2 = values.get(1);
                    int fieldCount2 = values.get(2);
                    List<Uniform> fields2 = new ArrayList<>(fieldCount2);
                    IntBuffer fieldIndices2 = MemoryUtil.memAllocInt(fieldCount2);
                    ARBProgramInterfaceQuery.glGetProgramResourceiv(program, 37606, i3, activeVariables, (IntBuffer) null, fieldIndices2);
                    for (int j3 = 0; j3 < fieldCount2; j3++) {
                        try {
                            ARBProgramInterfaceQuery.glGetProgramResourceiv(program, 37605, fieldIndices2.get(j3), uniformBufferFieldProperties, (IntBuffer) null, values);
                            String name3 = ARBProgramInterfaceQuery.glGetProgramResourceName(program, 37605, fieldIndices2.get(j3), values.get(0));
                            int arrayLength2 = values.get(1);
                            int offset2 = values.get(3);
                            int type3 = values.get(4);
                            if (arrayLength2 > 1) {
                                int stride2 = values.get(2);
                                String nameBase2 = name3.substring(0, name3.length() - 3);
                                for (int k2 = 0; k2 < arrayLength2; k2++) {
                                    fields2.add(new Uniform(nameBase2 + "[" + k2 + "]", -1, offset2 + (stride2 * k2), type3, 1));
                                }
                            } else {
                                fields2.add(new Uniform(name3, -1, offset2, type3, 1));
                            }
                        } catch (Throwable th2) {
                            MemoryUtil.memFree(fieldIndices2);
                            throw th2;
                        }
                    }
                    MemoryUtil.memFree(fieldIndices2);
                    Uniform last = (Uniform) fields2.getLast();
                    boolean array = last.name.endsWith("[0]");
                    if (array) {
                        fields2.set(fields2.size() - 1, new Uniform(last.name.substring(0, last.name.length() - 3), last.location, last.offset, last.type, 1));
                    }
                    this.storageBlocks.put(blockName2, new StorageBlock(blockName2, i3, size2, values.get(2), (Uniform[]) fields2.toArray(x$1 -> {
                        return new Uniform[x$1];
                    })));
                }
                if (stack != null) {
                    stack.close();
                    return;
                }
                return;
            } catch (Throwable th3) {
                if (stack != null) {
                    try {
                        stack.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        }
        int uniformCount2 = GL42C.glGetProgrami(program, 35718);
        int maxUniformLength = GL42C.glGetProgrami(program, 35719);
        int uniformBlockCount2 = GL42C.glGetProgrami(program, 35382);
        int maxUniformBlockLength = GL42C.glGetProgrami(program, 35381);
        MemoryStack stack2 = MemoryStack.stackPush();
        try {
            IntBuffer size3 = stack2.mallocInt(1);
            IntBuffer type4 = stack2.mallocInt(1);
            for (int i4 = 0; i4 < uniformCount2; i4++) {
                String baseName2 = GL42C.glGetActiveUniform(program, i4, maxUniformLength, size3, type4);
                if (!baseName2.contains(".")) {
                    int length2 = size3.get(0);
                    if (baseName2.contains("[")) {
                        baseName2 = baseName2.substring(0, baseName2.indexOf(91));
                    }
                    for (int j4 = 0; j4 < length2; j4++) {
                        String name4 = length2 > 1 ? baseName2 + "[" + j4 + "]" : baseName2;
                        Uniform uniform3 = new Uniform(name4, GL42C.glGetUniformLocation(program, name4), 0, type4.get(0), 1);
                        this.uniforms.put(name4, uniform3);
                        if (isSampler(type4.get(0))) {
                            this.samplers.put(name4, uniform3);
                        }
                    }
                    if (length2 > 1) {
                        Uniform uniform4 = new Uniform(baseName2, GL42C.glGetUniformLocation(program, baseName2), 0, type4.get(0), length2);
                        this.uniforms.put(baseName2, uniform4);
                        if (isSampler(type4.get(0))) {
                            this.samplers.put(baseName2, uniform4);
                        }
                    }
                }
            }
            for (int i5 = 0; i5 < uniformBlockCount2; i5++) {
                String blockName3 = GL42C.glGetActiveUniformBlockName(program, i5, maxUniformBlockLength);
                int bufferSize = GL42C.glGetActiveUniformBlocki(program, i5, 35392);
                Uniform[] fields3 = new Uniform[GL42C.glGetActiveUniformBlocki(program, i5, 35394)];
                IntBuffer fieldIndices3 = MemoryUtil.memAllocInt(fields3.length);
                GL42C.glGetActiveUniformBlockiv(program, i5, 35395, fieldIndices3);
                for (int j5 = 0; j5 < fields3.length; j5++) {
                    try {
                        int index = fieldIndices3.get(j5);
                        String name5 = GL42C.glGetActiveUniform(program, index, maxUniformLength, size3, type4);
                        fields3[j5] = new Uniform(name5, GL42C.glGetUniformLocation(program, name5), GL42C.glGetActiveUniformsi(program, index, 35387), type4.get(0), 1);
                    } catch (Throwable th5) {
                        MemoryUtil.memFree(fieldIndices3);
                        throw th5;
                    }
                }
                this.uniformBlocks.put(blockName3, new UniformBlock(blockName3, i5, bufferSize, fields3));
                MemoryUtil.memFree(fieldIndices3);
            }
            if (stack2 != null) {
                stack2.close();
            }
        } catch (Throwable th6) {
            if (stack2 != null) {
                try {
                    stack2.close();
                } catch (Throwable th7) {
                    th6.addSuppressed(th7);
                }
            }
            throw th6;
        }
    }

    @Nullable
    public Uniform getUniform(CharSequence name) {
        if (!this.requested) {
            updateUniforms();
        }
        return (Uniform) this.uniforms.get(name);
    }

    public boolean hasUniform(String name) {
        if (!this.requested) {
            updateUniforms();
        }
        return this.uniforms.containsKey(name);
    }

    @Nullable
    public UniformBlock getUniformBlock(String name) {
        if (!this.requested) {
            updateUniforms();
        }
        return (UniformBlock) this.uniformBlocks.get(name);
    }

    public boolean hasUniformBlock(String name) {
        if (!this.requested) {
            updateUniforms();
        }
        return this.uniformBlocks.containsKey(name);
    }

    @Nullable
    public StorageBlock getStorageBlock(String name) {
        if (!this.requested) {
            updateUniforms();
        }
        return (StorageBlock) this.storageBlocks.get(name);
    }

    public boolean hasStorageBlock(String name) {
        if (!this.requested) {
            updateUniforms();
        }
        return this.storageBlocks.containsKey(name);
    }

    public boolean hasSampler(String name) {
        if (!this.requested) {
            updateUniforms();
        }
        return this.samplers.containsKey(name);
    }

    public Map<String, Uniform> getSamplers() {
        if (!this.requested) {
            updateUniforms();
        }
        return this.samplersView;
    }

    public Map<String, Uniform> getUniforms() {
        if (!this.requested) {
            updateUniforms();
        }
        return this.uniformsView;
    }

    public Map<String, UniformBlock> getUniformBlocks() {
        if (!this.requested) {
            updateUniforms();
        }
        return this.uniformBlocksView;
    }

    public Map<String, StorageBlock> getStorageBlocks() {
        if (!this.requested) {
            updateUniforms();
        }
        return this.storageBlocksView;
    }

    public static boolean isSampler(int type) {
        return SAMPLERS.contains(type);
    }

    public static String getName(int type) {
        return (String) NAMES.getOrDefault(type, "0x%04X".formatted(Integer.valueOf(type)));
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform.class */
    public static final class Uniform extends Record {
        private final String name;
        private final int location;
        private final int offset;
        private final int type;
        private final int arrayLength;

        public Uniform(String name, int location, int offset, int type, int arrayLength) {
            this.name = name;
            this.location = location;
            this.offset = offset;
            this.type = type;
            this.arrayLength = arrayLength;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Uniform.class), Uniform.class, "name;location;offset;type;arrayLength", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->location:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->offset:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->type:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->arrayLength:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Uniform.class), Uniform.class, "name;location;offset;type;arrayLength", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->location:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->offset:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->type:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->arrayLength:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Uniform.class, Object.class), Uniform.class, "name;location;offset;type;arrayLength", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->location:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->offset:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->type:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;->arrayLength:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public String name() {
            return this.name;
        }

        public int location() {
            return this.location;
        }

        public int offset() {
            return this.offset;
        }

        public int type() {
            return this.type;
        }

        public int arrayLength() {
            return this.arrayLength;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/program/ShaderUniformCache$UniformBlock.class */
    public static final class UniformBlock extends Record {
        private final String name;
        private final int index;
        private final int size;
        private final Uniform[] fields;

        public UniformBlock(String name, int index, int size, Uniform[] fields) {
            this.name = name;
            this.index = index;
            this.size = size;
            this.fields = fields;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, UniformBlock.class), UniformBlock.class, "name;index;size;fields", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$UniformBlock;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$UniformBlock;->index:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$UniformBlock;->size:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$UniformBlock;->fields:[Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, UniformBlock.class), UniformBlock.class, "name;index;size;fields", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$UniformBlock;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$UniformBlock;->index:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$UniformBlock;->size:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$UniformBlock;->fields:[Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, UniformBlock.class, Object.class), UniformBlock.class, "name;index;size;fields", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$UniformBlock;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$UniformBlock;->index:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$UniformBlock;->size:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$UniformBlock;->fields:[Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public String name() {
            return this.name;
        }

        public int index() {
            return this.index;
        }

        public int size() {
            return this.size;
        }

        public Uniform[] fields() {
            return this.fields;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock.class */
    public static final class StorageBlock extends Record {
        private final String name;
        private final int index;
        private final int size;
        private final int arrayStride;
        private final Uniform[] fields;

        public StorageBlock(String name, int index, int size, int arrayStride, Uniform[] fields) {
            this.name = name;
            this.index = index;
            this.size = size;
            this.arrayStride = arrayStride;
            this.fields = fields;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, StorageBlock.class), StorageBlock.class, "name;index;size;arrayStride;fields", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->index:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->size:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->arrayStride:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->fields:[Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, StorageBlock.class), StorageBlock.class, "name;index;size;arrayStride;fields", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->index:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->size:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->arrayStride:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->fields:[Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, StorageBlock.class, Object.class), StorageBlock.class, "name;index;size;arrayStride;fields", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->index:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->size:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->arrayStride:I", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$StorageBlock;->fields:[Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache$Uniform;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public String name() {
            return this.name;
        }

        public int index() {
            return this.index;
        }

        public int size() {
            return this.size;
        }

        public int arrayStride() {
            return this.arrayStride;
        }

        public Uniform[] fields() {
            return this.fields;
        }

        public boolean array() {
            return this.arrayStride > 0;
        }
    }
}
