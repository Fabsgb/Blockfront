package foundry.veil.impl.client.render.shader.processor;

import com.mojang.blaze3d.vertex.VertexFormat;
import foundry.veil.VeilClient;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.api.client.render.shader.processor.ShaderImporter;
import foundry.veil.api.client.render.shader.processor.ShaderInjectProcessor;
import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import foundry.veil.impl.client.render.dynamicbuffer.DynamicBufferProcessor;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor.class */
@ApiStatus.Internal
public class VanillaShaderProcessor {
    private static final ThreadLocal<ShaderProcessorList> PROCESSOR = new ThreadLocal<>();

    public static void setup(ResourceProvider provider) {
        ShaderProcessorList list = new ShaderProcessorList(provider);
        list.addPreprocessor(new ShaderInjectProcessor(), false);
        list.addPreprocessor(new DynamicBufferProcessor(), false);
        VeilClient.clientPlatform().onRegisterShaderPreProcessors(provider, list);
        PROCESSOR.set(list);
    }

    public static void free() {
        PROCESSOR.remove();
    }

    public static String modify(Map<String, Object> customProgramData, @Nullable String shaderInstance, @Nullable ResourceLocation name, @Nullable VertexFormat vertexFormat, int activeBuffers, int type, String source, GLCapabilities glCapabilities) throws GlslSyntaxException, IOException, LexerException {
        ShaderProcessorList processor = PROCESSOR.get();
        if (processor == null) {
            throw new NullPointerException("Processor not initialized");
        }
        processor.getShaderImporter().reset();
        Map<String, String> macros = new HashMap<>();
        DynamicBufferType.addMacros(activeBuffers, macros);
        VeilRenderSystem.renderer().getShaderManager().addMacros(macros);
        GlslTree tree = GlslParser.preprocessParse(source, macros);
        processor.getProcessor().modify(new Context(customProgramData, processor, shaderInstance, name, activeBuffers, type, glCapabilities, vertexFormat, macros), tree);
        GlslTree.stripGLMacros(macros);
        tree.getMacros().putAll(macros);
        return tree.toSourceString();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context.class */
    private static final class Context extends Record implements ShaderPreProcessor.MinecraftContext {
        private final Map<String, Object> customProgramData;
        private final ShaderProcessorList processor;
        private final String shaderInstance;
        private final ResourceLocation name;
        private final int activeBuffers;
        private final int type;
        private final GLCapabilities glCapabilities;
        private final VertexFormat vertexFormat;
        private final Map<String, String> macros;

        private Context(Map<String, Object> customProgramData, ShaderProcessorList processor, String shaderInstance, ResourceLocation name, int activeBuffers, int type, GLCapabilities glCapabilities, VertexFormat vertexFormat, Map<String, String> macros) {
            this.customProgramData = customProgramData;
            this.processor = processor;
            this.shaderInstance = shaderInstance;
            this.name = name;
            this.activeBuffers = activeBuffers;
            this.type = type;
            this.glCapabilities = glCapabilities;
            this.vertexFormat = vertexFormat;
            this.macros = macros;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Context.class), Context.class, "customProgramData;processor;shaderInstance;name;activeBuffers;type;glCapabilities;vertexFormat;macros", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->customProgramData:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->processor:Lfoundry/veil/impl/client/render/shader/processor/ShaderProcessorList;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->shaderInstance:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->activeBuffers:I", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->type:I", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->glCapabilities:Lorg/lwjgl/opengl/GLCapabilities;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->vertexFormat:Lcom/mojang/blaze3d/vertex/VertexFormat;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->macros:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Context.class), Context.class, "customProgramData;processor;shaderInstance;name;activeBuffers;type;glCapabilities;vertexFormat;macros", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->customProgramData:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->processor:Lfoundry/veil/impl/client/render/shader/processor/ShaderProcessorList;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->shaderInstance:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->activeBuffers:I", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->type:I", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->glCapabilities:Lorg/lwjgl/opengl/GLCapabilities;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->vertexFormat:Lcom/mojang/blaze3d/vertex/VertexFormat;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->macros:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Context.class, Object.class), Context.class, "customProgramData;processor;shaderInstance;name;activeBuffers;type;glCapabilities;vertexFormat;macros", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->customProgramData:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->processor:Lfoundry/veil/impl/client/render/shader/processor/ShaderProcessorList;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->shaderInstance:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->activeBuffers:I", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->type:I", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->glCapabilities:Lorg/lwjgl/opengl/GLCapabilities;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->vertexFormat:Lcom/mojang/blaze3d/vertex/VertexFormat;", "FIELD:Lfoundry/veil/impl/client/render/shader/processor/VanillaShaderProcessor$Context;->macros:Ljava/util/Map;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public Map<String, Object> customProgramData() {
            return this.customProgramData;
        }

        public ShaderProcessorList processor() {
            return this.processor;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.MinecraftContext
        public String shaderInstance() {
            return this.shaderInstance;
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

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.MinecraftContext
        public VertexFormat vertexFormat() {
            return this.vertexFormat;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public Map<String, String> macros() {
            return this.macros;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public GlslTree modifyInclude(@Nullable ResourceLocation name, String source) throws GlslSyntaxException, IOException, LexerException {
            GlslTree tree = GlslParser.preprocessParse(source, this.macros);
            this.processor.getImportProcessor().modify(new Context(this.customProgramData, this.processor, this.shaderInstance, name, this.activeBuffers, this.type, this.glCapabilities, this.vertexFormat, this.macros), tree);
            return tree;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        @Nullable
        public ResourceLocation name() {
            return this.name;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public boolean isSourceFile() {
            return true;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public ShaderImporter shaderImporter() {
            return this.processor.getShaderImporter();
        }
    }
}
