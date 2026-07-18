package foundry.veil.api.client.render.shader.processor;

import com.mojang.blaze3d.vertex.VertexFormat;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.ShaderFeature;
import foundry.veil.api.client.render.shader.ShaderManager;
import foundry.veil.api.client.render.shader.ShaderPreDefinitions;
import foundry.veil.api.client.render.shader.program.ProgramDefinition;
import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslRootNode;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.api.node.function.GlslFunctionNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslNewFieldNode;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GLCapabilities;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/processor/ShaderPreProcessor.class */
public interface ShaderPreProcessor {
    public static final ShaderPreProcessor NOOP = (ctx, source) -> {
    };

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/processor/ShaderPreProcessor$IncludeOverloadStrategy.class */
    public enum IncludeOverloadStrategy {
        FAIL,
        SOURCE,
        INCLUDE
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/processor/ShaderPreProcessor$MinecraftContext.class */
    public interface MinecraftContext extends Context {
        String shaderInstance();

        VertexFormat vertexFormat();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/processor/ShaderPreProcessor$SodiumContext.class */
    public interface SodiumContext extends Context {
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/processor/ShaderPreProcessor$VeilContext.class */
    public interface VeilContext extends Context {
        void addUniformBinding(String str, int i);

        void addDefinitionDependency(String str);

        boolean isDynamic();

        @Nullable
        ProgramDefinition definition();
    }

    void modify(Context context, GlslTree glslTree) throws IOException, GlslSyntaxException, LexerException;

    default void prepare() {
    }

    static ShaderPreProcessor allOf(ShaderPreProcessor... processors) {
        return allOf(Arrays.asList(processors));
    }

    static ShaderPreProcessor allOf(Collection<ShaderPreProcessor> processors) throws MatchException {
        List<ShaderPreProcessor> list = new ArrayList<>(processors.size());
        for (ShaderPreProcessor processor : processors) {
            if (processor instanceof ShaderMultiProcessor) {
                try {
                    ShaderPreProcessor[] values = ((ShaderMultiProcessor) processor).processors();
                    list.addAll(Arrays.asList(values));
                } catch (Throwable th) {
                    throw new MatchException(th.toString(), th);
                }
            } else if (processor != NOOP) {
                list.add(processor);
            }
        }
        if (list.isEmpty()) {
            return NOOP;
        }
        if (list.size() == 1) {
            return (ShaderPreProcessor) list.getFirst();
        }
        return new ShaderMultiProcessor((ShaderPreProcessor[]) list.toArray(x$0 -> {
            return new ShaderPreProcessor[x$0];
        }));
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/processor/ShaderPreProcessor$Context.class */
    public interface Context {
        GlslTree modifyInclude(@Nullable ResourceLocation resourceLocation, String str) throws IOException, GlslSyntaxException, LexerException;

        Map<String, Object> customProgramData();

        @Nullable
        ResourceLocation name();

        boolean isSourceFile();

        int activeBuffers();

        int type();

        GLCapabilities glCapabilities();

        ShaderImporter shaderImporter();

        Map<String, String> macros();

        default String typeName() {
            return ShaderManager.getTypeName(type());
        }

        default boolean isVertex() {
            return type() == 35633;
        }

        default boolean isFragment() {
            return type() == 35632;
        }

        default boolean isGeometry() {
            return type() == 36313;
        }

        default boolean isTessellationControl() {
            return type() == 36488;
        }

        default boolean isTessellationEvaluation() {
            return type() == 36487;
        }

        default boolean hasFeatures(ShaderFeature... features) {
            return VeilRenderSystem.renderer().getShaderManager().hasFeatures(features);
        }

        default void include(GlslTree tree, ResourceLocation name, IncludeOverloadStrategy strategy) throws IOException, GlslSyntaxException, LexerException {
            include(tree, name.toString(), shaderImporter().loadImport(this, name, false), strategy);
        }

        default void include(GlslTree tree, String name, GlslTree loadedImport, IncludeOverloadStrategy strategy) throws IOException, GlslSyntaxException, LexerException {
            tree.getDirectives().addAll(loadedImport.getDirectives());
            Set<String> fieldNames = (Set) loadedImport.fields().map((v0) -> {
                return v0.getName();
            }).filter((v0) -> {
                return Objects.nonNull(v0);
            }).collect(Collectors.toUnmodifiableSet());
            Set<String> functionNames = (Set) loadedImport.functions().filter(function -> {
                return function.getBody() != null;
            }).map((v0) -> {
                return v0.getName();
            }).collect(Collectors.toUnmodifiableSet());
            switch (strategy) {
                case FAIL:
                    for (GlslNode sourceNode : tree.getBody()) {
                        if (sourceNode instanceof GlslRootNode) {
                            GlslRootNode rootNode = (GlslRootNode) sourceNode;
                            if (rootNode.isField()) {
                                GlslNewFieldNode field = rootNode.asField();
                                String fieldName = field.getName();
                                if (fieldName != null && fieldNames.contains(fieldName)) {
                                    throw new IOException("Field is part of include '" + name + "': " + fieldName);
                                }
                            } else if (rootNode.isFunction()) {
                                String functionName = rootNode.asFunction().getName();
                                if (functionNames.contains(functionName)) {
                                    throw new IOException("Function is part of include '" + name + "': " + functionName);
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    break;
                case SOURCE:
                    for (GlslNode sourceNode2 : tree.getBody()) {
                        if (sourceNode2 instanceof GlslRootNode) {
                            GlslRootNode rootNode2 = (GlslRootNode) sourceNode2;
                            if (rootNode2.isField()) {
                                GlslNewFieldNode field2 = rootNode2.asField();
                                String fieldName2 = field2.getName();
                                if (fieldName2 != null && fieldNames.contains(fieldName2)) {
                                    Set<GlslNewFieldNode> remove = (Set) loadedImport.fields().filter(node -> {
                                        return fieldName2.equals(node.getName());
                                    }).collect(Collectors.toUnmodifiableSet());
                                    loadedImport.getBody().removeAll(remove);
                                }
                            } else if (rootNode2.isFunction()) {
                                GlslFunctionNode function2 = rootNode2.asFunction();
                                String functionName2 = function2.getName();
                                if (functionNames.contains(functionName2)) {
                                    Set<GlslFunctionNode> remove2 = (Set) loadedImport.functions().filter(node2 -> {
                                        return node2.getName().equals(functionName2) && node2.getBody() != null && node2.getHeader().equals(function2.getHeader());
                                    }).collect(Collectors.toUnmodifiableSet());
                                    loadedImport.getBody().removeAll(remove2);
                                }
                            }
                        }
                    }
                    break;
                case INCLUDE:
                    Iterator<GlslNode> iterator = tree.getBody().iterator();
                    while (iterator.hasNext()) {
                        GlslNode sourceNode3 = iterator.next();
                        if (sourceNode3 instanceof GlslRootNode) {
                            GlslRootNode rootNode3 = (GlslRootNode) sourceNode3;
                            if (rootNode3.isField()) {
                                GlslNewFieldNode field3 = rootNode3.asField();
                                if (fieldNames.contains(field3.getName())) {
                                    iterator.remove();
                                }
                            } else if (rootNode3.isFunction()) {
                                GlslFunctionNode function3 = rootNode3.asFunction();
                                String functionName3 = function3.getName();
                                if (functionNames.contains(functionName3) && loadedImport.functions().anyMatch(node3 -> {
                                    return node3.getName().equals(functionName3) && node3.getBody() != null && node3.getHeader().equals(function3.getHeader());
                                })) {
                                    iterator.remove();
                                }
                            }
                        }
                    }
                    break;
            }
            tree.getBody().addAll(0, loadedImport.getBody());
        }

        default ShaderPreDefinitions preDefinitions() {
            return VeilRenderSystem.renderer().getShaderDefinitions();
        }
    }
}
