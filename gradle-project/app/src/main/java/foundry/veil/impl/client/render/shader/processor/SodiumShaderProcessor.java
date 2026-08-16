package foundry.veil.impl.client.render.shader.processor;

import foundry.veil.VeilClient;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.api.client.render.shader.processor.ShaderImporter;
import foundry.veil.api.client.render.shader.processor.ShaderInjectProcessor;
import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import foundry.veil.impl.client.render.dynamicbuffer.DynamicBufferProcessor;
import foundry.veil.impl.compat.sodium.SodiumShaderPreProcessor;
import io.github.ocelot.glslprocessor.api.GlslParser;
import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GLCapabilities;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor.class */
@ApiStatus.Internal
public class SodiumShaderProcessor {
    private static final ThreadLocal<ShaderProcessorList> PROCESSOR = new ThreadLocal<>();
    private static final ThreadLocal<Map<String, Object>> CUSTOM_PROGRAM_DATA = new ThreadLocal<>();
    private static final ThreadLocal<Integer> SHADER_TYPE = new ThreadLocal<>();
    private static final ThreadLocal<ResourceLocation> SHADER_NAME = new ThreadLocal<>();
    private static final ThreadLocal<GLCapabilities> GL_CAPABILITIES = new ThreadLocal<>();

    public static void setShaderType(int type, ResourceLocation shaderName, GLCapabilities glCapabilities) {
        SHADER_TYPE.set(Integer.valueOf(type));
        SHADER_NAME.set(shaderName);
        GL_CAPABILITIES.set(glCapabilities);
    }

    public static void setup(ResourceProvider provider) {
        ShaderProcessorList list = new ShaderProcessorList(provider);
        list.addPreprocessor(new ShaderInjectProcessor(), false);
        list.addPreprocessor(new DynamicBufferProcessor(), false);
        list.addPreprocessor(new SodiumShaderPreProcessor());
        VeilClient.clientPlatform().onRegisterShaderPreProcessors(provider, list);
        PROCESSOR.set(list);
        CUSTOM_PROGRAM_DATA.set(new HashMap());
    }

    public static void free() {
        PROCESSOR.remove();
        CUSTOM_PROGRAM_DATA.remove();
        SHADER_TYPE.remove();
        SHADER_NAME.remove();
        GL_CAPABILITIES.remove();
    }

    public static String modify(int activeBuffers, String source) throws GlslSyntaxException, IOException, LexerException {
        ResourceLocation shaderName = SHADER_NAME.get();
        if (shaderName == null) {
            return source;
        }
        ShaderProcessorList processor = PROCESSOR.get();
        if (processor == null) {
            throw new NullPointerException("Processor not initialized");
        }
        processor.getShaderImporter().reset();
        Map<String, String> macros = new HashMap<>();
        DynamicBufferType.addMacros(activeBuffers, macros);
        VeilRenderSystem.renderer().getShaderManager().addMacros(macros);
        GlslTree tree = GlslParser.preprocessParse(source, macros);
        processor.getProcessor().modify(new Context(CUSTOM_PROGRAM_DATA.get(), processor, shaderName.withPrefix("shaders/"), activeBuffers, SHADER_TYPE.get().intValue(), GL_CAPABILITIES.get(), macros, true), tree);
        GlslTree.stripGLMacros(macros);
        tree.getMacros().putAll(macros);
        return tree.toSourceString();
    }

    @Nullable
    public static ResourceLocation getActiveShaderName() {
        return SHADER_NAME.get();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context.class */
    private static final class Context extends Record implements ShaderPreProcessor.SodiumContext {
        private final Map<String, Object> customProgramData;
        private final ShaderProcessorList processor;

        @Nullable
        private final ResourceLocation name;
        private final int activeBuffers;
        private final int type;
        private final GLCapabilities glCapabilities;
        private final Map<String, String> macros;
        private final boolean sourceFile;

        private Context(Map<String, Object> customProgramData, ShaderProcessorList processor, @Nullable ResourceLocation name, int activeBuffers, int type, GLCapabilities glCapabilities, Map<String, String> macros, boolean sourceFile) {
            this.customProgramData = customProgramData;
            this.processor = processor;
            this.name = name;
            this.activeBuffers = activeBuffers;
            this.type = type;
            this.glCapabilities = glCapabilities;
            this.macros = macros;
            this.sourceFile = sourceFile;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Context.class), Context.class, "customProgramData;processor;name;activeBuffers;type;glCapabilities;macros;sourceFile", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->customProgramData:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->processor:Lfoundry/veil/impl/client/render/shader/processor/ShaderProcessorList;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->activeBuffers:I", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->type:I", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->glCapabilities:Lorg/lwjgl/opengl/GLCapabilities;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->macros:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->sourceFile:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Context.class), Context.class, "customProgramData;processor;name;activeBuffers;type;glCapabilities;macros;sourceFile", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->customProgramData:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->processor:Lfoundry/veil/impl/client/render/shader/processor/ShaderProcessorList;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->activeBuffers:I", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->type:I", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->glCapabilities:Lorg/lwjgl/opengl/GLCapabilities;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->macros:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->sourceFile:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Context.class, Object.class), Context.class, "customProgramData;processor;name;activeBuffers;type;glCapabilities;macros;sourceFile", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->customProgramData:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->processor:Lfoundry/veil/impl/client/render/shader/processor/ShaderProcessorList;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->activeBuffers:I", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->type:I", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->glCapabilities:Lorg/lwjgl/opengl/GLCapabilities;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->macros:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/SodiumShaderProcessor$Context;->sourceFile:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public Map<String, Object> customProgramData() {
            return this.customProgramData;
        }

        public ShaderProcessorList processor() {
            return this.processor;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        @Nullable
        public ResourceLocation name() {
            return this.name;
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

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public Map<String, String> macros() {
            return this.macros;
        }

        public boolean sourceFile() {
            return this.sourceFile;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public GlslTree modifyInclude(@Nullable ResourceLocation name, String source) throws GlslSyntaxException, IOException, LexerException {
            GlslTree tree = GlslParser.preprocessParse(source, this.macros);
            this.processor.getImportProcessor().modify(new Context(this.customProgramData, this.processor, name, this.activeBuffers, this.type, this.glCapabilities, this.macros, false), tree);
            return tree;
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
