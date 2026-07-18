package foundry.veil.impl.client.render.shader.program;

import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.api.client.render.shader.ShaderManager;
import foundry.veil.api.client.render.shader.ShaderPreDefinitions;
import foundry.veil.api.client.render.shader.ShaderSourceSet;
import foundry.veil.api.client.render.shader.compiler.ShaderCompiler;
import foundry.veil.api.client.render.shader.compiler.ShaderException;
import foundry.veil.api.client.render.shader.compiler.VeilShaderSource;
import foundry.veil.api.client.render.shader.processor.ShaderImporter;
import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import foundry.veil.api.client.render.shader.program.ProgramDefinition;
import foundry.veil.impl.client.render.shader.processor.ShaderProcessorList;
import foundry.veil.impl.client.render.shader.program.ShaderProgramImpl;
import io.github.ocelot.glslprocessor.api.GlslParser;
import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GLCapabilities;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl.class */
@ApiStatus.Internal
public class DynamicShaderProgramImpl extends ShaderProgramImpl {
    private final Runnable onFree;
    private final Int2ObjectMap<String> shaderSources;
    private final Int2ObjectMap<VeilShaderSource> processedShaderSources;
    private ShaderProgramImpl oldShader;

    public DynamicShaderProgramImpl(ResourceLocation id, Runnable onFree) {
        super(id);
        this.onFree = onFree;
        this.shaderSources = new Int2ObjectArrayMap();
        this.processedShaderSources = new Int2ObjectArrayMap();
        this.oldShader = null;
    }

    @Override // foundry.veil.impl.client.render.shader.program.ShaderProgramImpl
    protected void attachShaders(ShaderProgramImpl.CompiledProgram compiledProgram, ShaderSourceSet sourceSet, ShaderCompiler compiler) throws ShaderException {
        ObjectIterator it = this.processedShaderSources.int2ObjectEntrySet().iterator();
        while (it.hasNext()) {
            Int2ObjectMap.Entry<VeilShaderSource> entry = (Int2ObjectMap.Entry) it.next();
            int glType = entry.getIntKey();
            VeilShaderSource source = (VeilShaderSource) entry.getValue();
            compiledProgram.attachShader(glType, compiler.compile(glType, source));
        }
        if (Minecraft.ON_OSX && !this.processedShaderSources.containsKey(37305) && !this.processedShaderSources.containsKey(35632)) {
            compiledProgram.attachShader(35632, compiler.compile(35632, DUMMY_FRAGMENT_SHADER));
        }
    }

    public void setShaderSources(Int2ObjectMap<String> shaderSources) {
        this.shaderSources.clear();
        this.shaderSources.putAll(shaderSources);
    }

    public void processShaderSources(ShaderProcessorList processorList, ShaderPreDefinitions definitions, int activeBuffers, GLCapabilities glCapabilities) {
        this.processedShaderSources.clear();
        ShaderPreProcessor processor = processorList.getProcessor();
        ShaderPreProcessor importProcessor = processorList.getImportProcessor();
        Map<String, Object> customProgramData = new HashMap<>();
        try {
            ObjectIterator it = this.shaderSources.int2ObjectEntrySet().iterator();
            while (it.hasNext()) {
                Int2ObjectMap.Entry<String> shader = (Int2ObjectMap.Entry) it.next();
                int type = shader.getIntKey();
                try {
                    String source = (String) shader.getValue();
                    processor.prepare();
                    importProcessor.prepare();
                    Set<String> dependencies = new HashSet<>();
                    Map<String, String> macros = new HashMap<>(definitions.getStaticDefinitions());
                    DynamicBufferType.addMacros(activeBuffers, macros);
                    VeilRenderSystem.renderer().getShaderManager().addMacros(macros);
                    GlslTree tree = GlslParser.preprocessParse(source, macros);
                    Object2IntArrayMap object2IntArrayMap = new Object2IntArrayMap();
                    PreProcessorContext preProcessorContext = new PreProcessorContext(customProgramData, processorList, activeBuffers, type, glCapabilities, object2IntArrayMap, macros, dependencies, getName(), true);
                    processor.modify(preProcessorContext, tree);
                    GlslTree.stripGLMacros(macros);
                    Map<String, String> treeMacros = tree.getMacros();
                    treeMacros.putAll(macros);
                    for (String dependency : dependencies) {
                        String value = definitions.getDefinition(dependency);
                        if (value != null) {
                            treeMacros.putIfAbsent(dependency, value);
                        }
                    }
                    this.processedShaderSources.put(type, new VeilShaderSource(null, tree.toSourceString(), object2IntArrayMap, dependencies, new HashSet(processorList.getShaderImporter().addedImports())));
                } catch (Throwable t) {
                    throw new IOException("Failed to process " + ShaderManager.getTypeName(type) + " shader", t);
                }
            }
        } catch (IOException e) {
            this.processedShaderSources.clear();
            Veil.LOGGER.error("Couldn't parse dynamic shader: {}", getName(), e);
        }
    }

    @Override // foundry.veil.impl.client.render.shader.program.ShaderProgramImpl
    public void free() {
        super.free();
        this.onFree.run();
    }

    @Nullable
    public ShaderProgramImpl getOldShader() {
        return this.oldShader;
    }

    public void setOldShader(@Nullable ShaderProgramImpl program) {
        this.oldShader = program;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext.class */
    private static final class PreProcessorContext extends Record implements ShaderPreProcessor.VeilContext {
        private final Map<String, Object> customProgramData;
        private final ShaderProcessorList processor;
        private final int activeBuffers;
        private final int type;
        private final GLCapabilities glCapabilities;
        private final Object2IntMap<String> uniformBindings;
        private final Map<String, String> macros;
        private final Set<String> definitionDependencies;
        private final ResourceLocation name;
        private final boolean sourceFile;

        private PreProcessorContext(Map<String, Object> customProgramData, ShaderProcessorList processor, int activeBuffers, int type, GLCapabilities glCapabilities, Object2IntMap<String> uniformBindings, Map<String, String> macros, Set<String> definitionDependencies, ResourceLocation name, boolean sourceFile) {
            this.customProgramData = customProgramData;
            this.processor = processor;
            this.activeBuffers = activeBuffers;
            this.type = type;
            this.glCapabilities = glCapabilities;
            this.uniformBindings = uniformBindings;
            this.macros = macros;
            this.definitionDependencies = definitionDependencies;
            this.name = name;
            this.sourceFile = sourceFile;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PreProcessorContext.class), PreProcessorContext.class, "customProgramData;processor;activeBuffers;type;glCapabilities;uniformBindings;macros;definitionDependencies;name;sourceFile", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->customProgramData:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->processor:Lfoundry/veil/impl/client/render/shader/processor/ShaderProcessorList;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->activeBuffers:I", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->type:I", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->glCapabilities:Lorg/lwjgl/opengl/GLCapabilities;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->uniformBindings:Lit/unimi/dsi/fastutil/objects/Object2IntMap;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->macros:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->sourceFile:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PreProcessorContext.class), PreProcessorContext.class, "customProgramData;processor;activeBuffers;type;glCapabilities;uniformBindings;macros;definitionDependencies;name;sourceFile", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->customProgramData:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->processor:Lfoundry/veil/impl/client/render/shader/processor/ShaderProcessorList;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->activeBuffers:I", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->type:I", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->glCapabilities:Lorg/lwjgl/opengl/GLCapabilities;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->uniformBindings:Lit/unimi/dsi/fastutil/objects/Object2IntMap;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->macros:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->sourceFile:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PreProcessorContext.class, Object.class), PreProcessorContext.class, "customProgramData;processor;activeBuffers;type;glCapabilities;uniformBindings;macros;definitionDependencies;name;sourceFile", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->customProgramData:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->processor:Lfoundry/veil/impl/client/render/shader/processor/ShaderProcessorList;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->activeBuffers:I", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->type:I", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->glCapabilities:Lorg/lwjgl/opengl/GLCapabilities;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->uniformBindings:Lit/unimi/dsi/fastutil/objects/Object2IntMap;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->macros:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/DynamicShaderProgramImpl$PreProcessorContext;->sourceFile:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public Map<String, Object> customProgramData() {
            return this.customProgramData;
        }

        public ShaderProcessorList processor() {
            return this.processor;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public int activeBuffers() {
            return this.activeBuffers;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public int type() {
            return this.type;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public GLCapabilities glCapabilities() {
            return this.glCapabilities;
        }

        public Object2IntMap<String> uniformBindings() {
            return this.uniformBindings;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public Map<String, String> macros() {
            return this.macros;
        }

        public Set<String> definitionDependencies() {
            return this.definitionDependencies;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public ResourceLocation name() {
            return this.name;
        }

        public boolean sourceFile() {
            return this.sourceFile;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public GlslTree modifyInclude(@Nullable ResourceLocation name, String source) throws GlslSyntaxException, IOException, LexerException {
            GlslTree tree = GlslParser.preprocessParse(source, this.macros);
            PreProcessorContext context = new PreProcessorContext(this.customProgramData, this.processor, this.activeBuffers, this.type, this.glCapabilities, this.uniformBindings, this.macros, this.definitionDependencies, name, false);
            this.processor.getImportProcessor().modify(context, tree);
            return tree;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.VeilContext
        public void addUniformBinding(String name, int binding) {
            this.uniformBindings.put(name, binding);
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.VeilContext
        public void addDefinitionDependency(String name) {
            this.definitionDependencies.add(name);
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.VeilContext
        public boolean isDynamic() {
            return true;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.VeilContext
        @Nullable
        public ProgramDefinition definition() {
            return null;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public boolean isSourceFile() {
            return this.sourceFile;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public ShaderImporter shaderImporter() {
            return this.processor.getShaderImporter();
        }
    }
}
