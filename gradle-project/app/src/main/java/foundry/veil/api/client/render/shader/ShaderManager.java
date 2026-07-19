package foundry.veil.api.client.render.shader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import foundry.veil.Veil;
import foundry.veil.VeilClient;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.api.client.render.shader.compiler.ShaderCompiler;
import foundry.veil.api.client.render.shader.compiler.ShaderException;
import foundry.veil.api.client.render.shader.compiler.VeilShaderSource;
import foundry.veil.api.client.render.shader.processor.ShaderBindingProcessor;
import foundry.veil.api.client.render.shader.processor.ShaderBufferProcessor;
import foundry.veil.api.client.render.shader.processor.ShaderFeatureProcessor;
import foundry.veil.api.client.render.shader.processor.ShaderImportProcessor;
import foundry.veil.api.client.render.shader.processor.ShaderImporter;
import foundry.veil.api.client.render.shader.processor.ShaderInjectProcessor;
import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import foundry.veil.api.client.render.shader.processor.ShaderVersionProcessor;
import foundry.veil.api.client.render.shader.program.ProgramDefinition;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.impl.ThreadTaskScheduler;
import foundry.veil.impl.client.render.dynamicbuffer.DynamicBufferManager;
import foundry.veil.impl.client.render.dynamicbuffer.DynamicBufferProcessor;
import foundry.veil.impl.client.render.shader.ShaderImporterImpl;
import foundry.veil.impl.client.render.shader.processor.ShaderProcessorList;
import foundry.veil.impl.client.render.shader.program.DynamicShaderProgramImpl;
import foundry.veil.impl.client.render.shader.program.ShaderProgramImpl;
import io.github.ocelot.glslprocessor.api.GlslParser;
import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectArrayMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Async;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/ShaderManager.class */
public class ShaderManager implements PreparableReloadListener, Closeable {
    private static final Gson GSON = new GsonBuilder().registerTypeAdapter(ResourceLocation.class, new ResourceLocation.Serializer()).registerTypeAdapter(ProgramDefinition.class, new ProgramDefinition.Deserializer()).create();
    public static final FileToIdConverter INCLUDE_LISTER = new FileToIdConverter("pinwheel/shaders/include", ".glsl");
    public static final ShaderSourceSet PROGRAM_SET = new ShaderSourceSet("pinwheel/shaders/program");
    private static final Map<Integer, String> TYPES = Map.of(35633, "vertex", 36488, "tesselation_control", 36487, "tesselation_evaluation", 36313, "geometry", 35632, "fragment", 37305, "compute");
    private final DynamicBufferManager dynamicBufferManager;
    private final ShaderSourceSet sourceSet;
    private final ShaderPreDefinitions definitions;
    private final Map<ResourceLocation, ShaderProgramImpl> shaders;
    private final Map<ResourceLocation, ShaderProgram> shadersView;
    private final Set<ResourceLocation> dirtyShaders;
    private final long supportedFeatures;
    private CompletableFuture<Void> recompileFuture;
    private CompletableFuture<Void> updateBuffersFuture;

    public ShaderManager(ShaderSourceSet sourceSet, ShaderPreDefinitions shaderPreDefinitions, DynamicBufferManager dynamicBufferManager) {
        this.dynamicBufferManager = dynamicBufferManager;
        this.sourceSet = sourceSet;
        this.definitions = shaderPreDefinitions;
        this.definitions.addListener(this::onDefinitionChanged);
        this.shaders = new HashMap();
        this.shadersView = Collections.unmodifiableMap(this.shaders);
        this.dirtyShaders = new HashSet();
        long supportedFeatures = 0;
        for (ShaderFeature feature : ShaderFeature.FEATURES) {
            if (feature.isSupported()) {
                supportedFeatures |= (long) (1 << feature.ordinal());
            }
        }
        this.supportedFeatures = supportedFeatures;
        this.recompileFuture = CompletableFuture.completedFuture(null);
        this.updateBuffersFuture = CompletableFuture.completedFuture(null);
    }

    private void onDefinitionChanged(String definition) {
        this.shaders.values().forEach(shader -> {
            if (shader.getDefinitionDependencies().contains(definition)) {
                Veil.LOGGER.debug("{} changed, recompiling {}", definition, shader.getName());
                scheduleRecompile(shader.getName());
            }
        });
    }

    private void addProcessors(ShaderProcessorList processorList, ResourceProvider provider) {
        processorList.addPreprocessor(new ShaderImportProcessor());
        processorList.addPreprocessor(new ShaderBufferProcessor());
        processorList.addPreprocessor(new ShaderBindingProcessor());
        processorList.addPreprocessor(new ShaderVersionProcessor(), false);
        processorList.addPreprocessor(new ShaderInjectProcessor(), false);
        processorList.addPreprocessor(new DynamicBufferProcessor(), false);
        processorList.addPreprocessor(new ShaderFeatureProcessor(), false);
        VeilClient.clientPlatform().onRegisterShaderPreProcessors(provider, processorList);
    }

    private ProgramDefinition parseDefinition(ResourceLocation id, ResourceProvider provider) throws IOException {
        try {
            Reader reader = provider.openAsReader(this.sourceSet.getShaderDefinitionLister().idToFile(id));
            try {
                ProgramDefinition definition = (ProgramDefinition) GsonHelper.fromJson(GSON, reader, ProgramDefinition.class);
                if (definition.vertex() == null && definition.tesselationControl() == null && definition.tesselationEvaluation() == null && definition.geometry() == null && definition.fragment() == null && definition.compute() == null) {
                    throw new JsonSyntaxException("Shader programs must define at least 1 shader type");
                }
                if (reader != null) {
                    reader.close();
                }
                return definition;
            } catch (Throwable th) {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (JsonParseException e) {
            throw new IOException((Throwable) e);
        }
        throw new IOException((Throwable) e);
    }

    private void readShader(ShaderProcessorList processorList, ResourceProvider resourceProvider, Map<ResourceLocation, ProgramSource> definitions, ResourceLocation definitionId, int activeBuffers, GLCapabilities caps) {
        if (definitions.containsKey(definitionId)) {
            throw new IllegalStateException("Duplicate shader ignored with ID " + String.valueOf(definitionId));
        }
        Set<ResourceLocation> checkedSources = new HashSet<>();
        ShaderPreProcessor processor = processorList.getProcessor();
        ShaderPreProcessor importProcessor = processorList.getImportProcessor();
        try {
            ProgramDefinition definition = parseDefinition(definitionId, resourceProvider);
            Object2ObjectArrayMap object2ObjectArrayMap = new Object2ObjectArrayMap(2);
            Map<String, Object> customProgramData = new HashMap<>();
            ObjectIterator it = definition.shaders().int2ObjectEntrySet().iterator();
            while (it.hasNext()) {
                Int2ObjectMap.Entry<ResourceLocation> shader = (Int2ObjectMap.Entry) it.next();
                int type = shader.getIntKey();
                ResourceLocation shaderId = (ResourceLocation) shader.getValue();
                FileToIdConverter typeConverter = this.sourceSet.getTypeConverter(type);
                ResourceLocation location = typeConverter.idToFile(shaderId);
                if (checkedSources.add(location)) {
                    Resource resource = resourceProvider.getResourceOrThrow(location);
                    try {
                        Reader reader = resource.openAsReader();
                        try {
                            String source = IOUtils.toString(reader);
                            processor.prepare();
                            importProcessor.prepare();
                            Set<String> dependencies = new HashSet<>();
                            Map<String, String> macros = definition.getMacros(dependencies, this.definitions);
                            DynamicBufferType.addMacros(activeBuffers, macros);
                            VeilRenderSystem.renderer().getShaderManager().addMacros(macros);
                            GlslTree tree = GlslParser.preprocessParse(source, macros);
                            Object2IntArrayMap object2IntArrayMap = new Object2IntArrayMap();
                            PreProcessorContext preProcessorContext = new PreProcessorContext(customProgramData, importProcessor, definition, this.definitions, processorList.getShaderImporter(), activeBuffers, type, caps, object2IntArrayMap, dependencies, macros, shaderId, true);
                            processor.modify(preProcessorContext, tree);
                            GlslTree.stripGLMacros(macros);
                            Map<String, String> treeMacros = tree.getMacros();
                            treeMacros.putAll(macros);
                            for (String dependency : dependencies) {
                                String value = this.definitions.getDefinition(dependency);
                                if (value != null) {
                                    treeMacros.putIfAbsent(dependency, value);
                                }
                            }
                            object2ObjectArrayMap.put(location, new VeilShaderSource(shaderId, tree.toSourceString(), object2IntArrayMap, dependencies, new HashSet(processorList.getShaderImporter().addedImports())));
                            if (reader != null) {
                                reader.close();
                            }
                        } catch (Throwable th) {
                            if (reader != null) {
                                try {
                                    reader.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable t) {
                        throw new IOException("Failed to load " + getTypeName(type) + " shader", t);
                    }
                }
            }
            definitions.put(definitionId, new ProgramSource(definition, Map.copyOf(object2ObjectArrayMap)));
        } catch (IOException | IllegalArgumentException | JsonParseException e) {
            Veil.LOGGER.error("Couldn't parse shader {} from {}", new Object[]{definitionId, this.sourceSet.getShaderDefinitionLister().idToFile(definitionId), e});
        }
    }

    private boolean isInvalid(ResourceLocation id, ProgramDefinition definition) {
        if (!hasFeatures(definition.requiredFeatures())) {
            List<String> requiredFeatures = new ArrayList<>();
            for (ShaderFeature feature : definition.requiredFeatures()) {
                if (!hasFeatures(feature)) {
                    requiredFeatures.add(feature.name().toLowerCase(Locale.ROOT));
                }
            }
            Veil.LOGGER.info("Skipping shader '{}' (missing required features: {})", id, String.join(", ", requiredFeatures));
            return true;
        }
        return false;
    }

    private void compile(ShaderProgramImpl program, @Nullable ProgramDefinition definition, ShaderCompiler compiler) {
        ResourceLocation id = program.getName();
        try {
            program.compile(this.dynamicBufferManager.getActiveBuffers(), this.sourceSet, definition, compiler);
        } catch (ShaderException e) {
            Veil.LOGGER.error("Failed to create shader {}: {}", id, e.getMessage());
            String error = e.getGlError();
            if (error != null) {
                Veil.LOGGER.warn(error);
            }
        } catch (Exception e2) {
            Veil.LOGGER.error("Failed to create shader: {}", id, e2);
        }
    }

    public CompletableFuture<ShaderProgram> createDynamicProgram(ResourceLocation id, Int2ObjectMap<String> shaderSources) {
        DynamicShaderProgramImpl compileProgram;
        ShaderProgramImpl program = this.shaders.get(id);
        if (!(program instanceof DynamicShaderProgramImpl)) {
            if (program != null) {
                Veil.LOGGER.warn("Dynamic shader {} will overwrite the shader file until it is deleted!", id);
            }
            compileProgram = new DynamicShaderProgramImpl(id, () -> {
                if (program != null) {
                    this.shaders.put(id, program);
                } else {
                    this.shaders.remove(id);
                }
            });
            compileProgram.setOldShader(program);
            this.shaders.put(id, compileProgram);
        } else {
            DynamicShaderProgramImpl dynamicShaderProgram = (DynamicShaderProgramImpl) program;
            compileProgram = dynamicShaderProgram;
        }
        compileProgram.setShaderSources(shaderSources);
        int activeBuffers = VeilRenderSystem.renderer().getDynamicBufferManger().getActiveBuffers();
        DynamicShaderProgramImpl dynamicShaderProgramImpl = compileProgram;
        CompletableFuture completableFutureThenCompose = CompletableFuture.supplyAsync(GL::getCapabilities, VeilRenderSystem.renderThreadExecutor()).thenCompose(caps -> {
            return CompletableFuture.runAsync(() -> {
                ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();
                ShaderProcessorList list = new ShaderProcessorList(resourceManager);
                addProcessors(list, resourceManager);
                dynamicShaderProgramImpl.processShaderSources(list, this.definitions, activeBuffers, caps);
            }, Util.backgroundExecutor());
        });
        DynamicShaderProgramImpl dynamicShaderProgramImpl2 = compileProgram;
        return completableFutureThenCompose.thenApplyAsync(unused -> {
            ShaderCompiler compiler = ShaderCompiler.direct(null);
            try {
                compile(dynamicShaderProgramImpl2, null, compiler);
                if (compiler != null) {
                    compiler.close();
                }
                return dynamicShaderProgramImpl2;
            } catch (Throwable th) {
                if (compiler != null) {
                    try {
                        compiler.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }, VeilRenderSystem.renderThreadExecutor());
    }

    public void setGlobal(Consumer<ShaderProgram> setter) {
        this.shaders.values().forEach(setter);
    }

    public boolean hasFeatures(ShaderFeature... features) {
        int mask = 0;
        for (ShaderFeature feature : features) {
            mask |= 1 << feature.ordinal();
        }
        return (this.supportedFeatures & ((long) mask)) == ((long) mask);
    }

    @Nullable
    public ShaderProgram getShader(ResourceLocation id) {
        return this.shaders.get(id);
    }

    public Map<ResourceLocation, ShaderProgram> getShaders() {
        return this.shadersView;
    }

    public ShaderSourceSet getSourceSet() {
        return this.sourceSet;
    }

    private CompletableFuture<Map<ResourceLocation, ProgramSource>> prepare(ResourceManager resourceManager, Collection<DynamicShaderProgramImpl> dynamicShaders, Collection<ResourceLocation> shaders, int activeBuffers, Executor executor) {
        Map<ResourceLocation, ProgramSource> definitions = new ConcurrentHashMap<>();
        Long2ObjectMap<ShaderProcessorList> processorList = Long2ObjectMaps.synchronize(new Long2ObjectArrayMap());
        Deque<ResourceLocation> shaderQueue = new ConcurrentLinkedDeque<>(shaders);
        return CompletableFuture.supplyAsync(GL::getCapabilities, VeilRenderSystem.renderThreadExecutor()).thenCompose(caps -> {
            ThreadTaskScheduler scheduler = new ThreadTaskScheduler("VeilShaderCompiler", Math.max(1, Runtime.getRuntime().availableProcessors() / 4), () -> {
                ResourceLocation key = (ResourceLocation) shaderQueue.poll();
                if (key == null) {
                    return null;
                }
                return () -> {
                    ShaderProcessorList shaderProcessor = (ShaderProcessorList) processorList.computeIfAbsent(Thread.currentThread().threadId(), id -> {
                        ShaderProcessorList list = new ShaderProcessorList(resourceManager);
                        addProcessors(list, resourceManager);
                        return list;
                    });
                    shaderProcessor.getShaderImporter().reset();
                    readShader(shaderProcessor, resourceManager, definitions, key, activeBuffers, caps);
                };
            });
            return CompletableFuture.allOf(scheduler.getCompletedFuture(), CompletableFuture.runAsync(() -> {
                ShaderProcessorList list = new ShaderProcessorList(resourceManager);
                addProcessors(list, resourceManager);
                ShaderImporterImpl shaderImporter = list.getShaderImporter();
                Iterator it = dynamicShaders.iterator();
                while (it.hasNext()) {
                    DynamicShaderProgramImpl shader = (DynamicShaderProgramImpl) it.next();
                    shaderImporter.reset();
                    shader.processShaderSources(list, this.definitions, activeBuffers, caps);
                }
            }, executor));
        }).thenApply(unused -> {
            return definitions;
        });
    }

    private void apply(Map<ResourceLocation, ProgramSource> sources) {
        Iterator<ShaderProgramImpl> iterator = this.shaders.values().iterator();
        while (iterator.hasNext()) {
            ShaderProgramImpl program = iterator.next();
            if (program instanceof DynamicShaderProgramImpl) {
                DynamicShaderProgramImpl dynamicShaderProgram = (DynamicShaderProgramImpl) program;
                ShaderProgramImpl old = dynamicShaderProgram.getOldShader();
                if (old != null) {
                    old.free();
                }
            } else {
                program.free();
                iterator.remove();
            }
        }
        for (Map.Entry<ResourceLocation, ProgramSource> entry : sources.entrySet()) {
            ProgramSource source = entry.getValue();
            ProgramDefinition definition = source.definition;
            if (!isInvalid(entry.getKey(), definition)) {
                ShaderCompiler compiler = source.createCompiler();
                try {
                    ResourceLocation id = entry.getKey();
                    ShaderProgramImpl program2 = new ShaderProgramImpl(id);
                    compile(program2, definition, compiler);
                    DynamicShaderProgramImpl old2 = (DynamicShaderProgramImpl) this.shaders.put(id, program2);
                    if (old2 != null) {
                        old2.setOldShader(program2);
                    }
                    if (compiler != null) {
                        compiler.close();
                    }
                } catch (Throwable th) {
                    if (compiler != null) {
                        try {
                            compiler.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }
        VeilClient.clientPlatform().onVeilCompileShaders(this, Collections.unmodifiableMap(this.shaders));
        Veil.LOGGER.info("Loaded {} shaders from: {}", Integer.valueOf(this.shaders.size()), this.sourceSet.getFolder());
    }

    private void applyRecompile(Map<ResourceLocation, ProgramSource> sources, Map<ResourceLocation, ShaderProgram> updatedShaders) {
        for (Map.Entry<ResourceLocation, ProgramSource> entry : sources.entrySet()) {
            ResourceLocation id = entry.getKey();
            ShaderProgramImpl program = this.shaders.get(id);
            if (program == null) {
                Veil.LOGGER.warn("Failed to recompile unknown shader: {}", id);
            } else {
                ProgramSource source = entry.getValue();
                ProgramDefinition definition = source.definition;
                if (isInvalid(id, definition)) {
                    continue;
                } else {
                    ShaderCompiler compiler = source.createCompiler();
                    try {
                        compile(program, definition, compiler);
                        if (compiler != null) {
                            compiler.close();
                        }
                    } catch (Throwable th) {
                        if (compiler != null) {
                            try {
                                compiler.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
            }
        }
        VeilClient.clientPlatform().onVeilCompileShaders(this, updatedShaders);
        Veil.LOGGER.info("Recompiled {} shaders from: {}", Integer.valueOf(updatedShaders.size()), this.sourceSet.getFolder());
    }

    private void scheduleRecompile(int attempt) {
        Minecraft client = Minecraft.getInstance();
        client.tell(() -> {
            Set<ResourceLocation> shaders;
            if (!this.recompileFuture.isDone()) {
                return;
            }
            synchronized (this.dirtyShaders) {
                shaders = new HashSet<>(this.dirtyShaders);
                this.dirtyShaders.clear();
            }
            Map<ResourceLocation, ShaderProgram> updatedShaders = new HashMap<>(shaders.size());
            for (ResourceLocation id : shaders) {
                ShaderProgram shader = getShader(id);
                if (shader != null) {
                    updatedShaders.put(id, shader);
                }
            }
            Set<DynamicShaderProgramImpl> dynamicShaderPrograms = new HashSet<>();
            Iterator<ResourceLocation> iterator = shaders.iterator();
            while (iterator.hasNext()) {
                ShaderProgramImpl program = this.shaders.get(iterator.next());
                if (program instanceof DynamicShaderProgramImpl) {
                    DynamicShaderProgramImpl dynamicShaderProgram = (DynamicShaderProgramImpl) program;
                    iterator.remove();
                    dynamicShaderPrograms.add(dynamicShaderProgram);
                }
            }
            int activeBuffers = this.dynamicBufferManager.getActiveBuffers();
            this.recompileFuture = prepare(client.getResourceManager(), dynamicShaderPrograms, shaders, activeBuffers, Util.backgroundExecutor()).thenAcceptAsync(state -> {
                applyRecompile(state, Collections.unmodifiableMap(updatedShaders));
            }, (Executor) client).handle((value, e) -> {
                if (e != null) {
                    Veil.LOGGER.error("Error recompiling shaders", e);
                }
                synchronized (this.dirtyShaders) {
                    if (this.dirtyShaders.isEmpty()) {
                        return value;
                    }
                    if (attempt >= 3) {
                        Veil.LOGGER.error("Failed to recompile shaders after {} attempts", Integer.valueOf(attempt));
                        return value;
                    }
                    scheduleRecompile(attempt + 1);
                    return value;
                }
            });
        });
    }

    @Async.Schedule
    public void scheduleRecompile(ResourceLocation shader) {
        synchronized (this.dirtyShaders) {
            this.dirtyShaders.add(shader);
        }
        if (!this.recompileFuture.isDone()) {
            return;
        }
        scheduleRecompile(0);
    }

    @ApiStatus.Internal
    public void setActiveBuffers(int activeBuffers) {
        ShaderProgram active = null;
        try {
            Set<DynamicShaderProgramImpl> dynamicShaders = new HashSet<>();
            Set<ResourceLocation> shaders = new HashSet<>(this.shaders.size());
            Map<ResourceLocation, ShaderProgram> updatedShaders = new HashMap<>();
            for (ShaderProgram program : this.shaders.values()) {
                active = program;
                if (program instanceof ShaderProgramImpl) {
                    ShaderProgramImpl impl = (ShaderProgramImpl) program;
                    if (impl.setActiveBuffers(activeBuffers)) {
                        if (program instanceof DynamicShaderProgramImpl) {
                            DynamicShaderProgramImpl dynamicShaderProgram = (DynamicShaderProgramImpl) program;
                            dynamicShaders.add(dynamicShaderProgram);
                        } else {
                            shaders.add(program.getName());
                        }
                        updatedShaders.put(program.getName(), program);
                    }
                }
            }
            if (!shaders.isEmpty()) {
                this.updateBuffersFuture = this.updateBuffersFuture.thenCompose(unused -> {
                    return prepare(Minecraft.getInstance().getResourceManager(), dynamicShaders, shaders, activeBuffers, Util.backgroundExecutor());
                }).thenAcceptAsync((Consumer<? super U>) sources -> {
                    for (Map.Entry<ResourceLocation, ProgramSource> entry : sources.entrySet()) {
                        ResourceLocation id = entry.getKey();
                        ShaderProgram program2 = getShader(id);
                        if (!(program2 instanceof ShaderProgramImpl)) {
                            Veil.LOGGER.warn("Failed to set shader active buffers: {}", id);
                        } else {
                            ShaderProgramImpl impl2 = (ShaderProgramImpl) program2;
                            try {
                                ShaderCompiler compiler = entry.getValue().createCompiler();
                                try {
                                    impl2.recompile(activeBuffers, this.sourceSet, compiler);
                                    if (compiler != null) {
                                        compiler.close();
                                    }
                                } catch (Throwable th) {
                                    if (compiler != null) {
                                        try {
                                            compiler.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (ShaderException e) {
                                Veil.LOGGER.error("Failed to update shader active buffers: {}. {}", id, e.getMessage());
                                String error = e.getGlError();
                                if (error != null) {
                                    Veil.LOGGER.warn(error);
                                }
                            } catch (Exception e2) {
                                Veil.LOGGER.error("Failed to update shader active buffers: {}", id, e2);
                            }
                        }
                    }
                    VeilClient.clientPlatform().onVeilCompileShaders(this, Collections.unmodifiableMap(updatedShaders));
                    Veil.LOGGER.info("Compiled {} shaders from: {}", Integer.valueOf(updatedShaders.size()), this.sourceSet.getFolder());
                }, (Executor) Minecraft.getInstance());
            }
        } catch (Exception e) {
            Veil.LOGGER.error("Failed to set shader active buffers {}: {}", ((ShaderProgram) Objects.requireNonNull(active)).getName(), e.getMessage());
        }
    }

    public CompletableFuture<Void> reload(PreparableReloadListener.PreparationBarrier preparationBarrier, ResourceManager resourceManager, ProfilerFiller preparationsProfiler, ProfilerFiller reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
        Set<ResourceLocation> dynamicShaders = new HashSet<>();
        for (ShaderProgramImpl program : this.shaders.values()) {
            if (program instanceof DynamicShaderProgramImpl) {
                dynamicShaders.add(program.getName());
            }
        }
        int activeBuffers = this.dynamicBufferManager.getActiveBuffers();
        return CompletableFuture.allOf(this.recompileFuture, this.updateBuffersFuture).thenComposeAsync(unused -> {
            FileToIdConverter lister = this.sourceSet.getShaderDefinitionLister();
            Stream stream = lister.listMatchingResources(resourceManager).keySet().stream();
            Objects.requireNonNull(lister);
            Set<ResourceLocation> shaderIds = (Set) stream.map(lister::fileToId).filter(id -> {
                return !dynamicShaders.contains(id);
            }).collect(Collectors.toSet());
            CompletableFuture<Map<ResourceLocation, ProgramSource>> completableFuturePrepare = prepare(resourceManager, Collections.emptySet(), shaderIds, activeBuffers, backgroundExecutor);
            Objects.requireNonNull(preparationBarrier);
            return completableFuturePrepare.thenCompose((v1) -> {
                return r1.wait(v1);
            }).thenAcceptAsync((Consumer<? super U>) this::apply, gameExecutor);
        }, backgroundExecutor);
    }

    public String getName() {
        return getClass().getSimpleName() + " " + getSourceSet().getFolder();
    }

    public CompletableFuture<Void> getRecompileFuture() {
        return this.recompileFuture;
    }

    public CompletableFuture<Void> getUpdateBuffersFuture() {
        return this.updateBuffersFuture;
    }

    public static String getTypeName(int type) {
        String value = TYPES.get(Integer.valueOf(type));
        return value != null ? value : "0x" + Integer.toHexString(type);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.shaders.values().forEach((v0) -> {
            v0.freeInternal();
        });
        this.shaders.clear();
    }

    @ApiStatus.Internal
    public void addMacros(Map<String, String> macros) {
        long j = this.supportedFeatures;
        while (true) {
            long mask = j;
            if (mask != 0) {
                int ordinal = Long.numberOfTrailingZeros(mask);
                macros.put(ShaderFeature.FEATURES[ordinal].getDefinitionName(), "1");
                j = mask & ((1 << ordinal) ^ (-1));
            } else {
                return;
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext.class */
    private static final class PreProcessorContext extends Record implements ShaderPreProcessor.VeilContext {
        private final Map<String, Object> customProgramData;
        private final ShaderPreProcessor preProcessor;

        @Nullable
        private final ProgramDefinition definition;
        private final ShaderPreDefinitions preDefinitions;
        private final ShaderImporter shaderImporter;
        private final int activeBuffers;
        private final int type;
        private final GLCapabilities glCapabilities;
        private final Object2IntMap<String> uniformBindings;
        private final Set<String> definitionDependencies;
        private final Map<String, String> macros;

        @Nullable
        private final ResourceLocation name;
        private final boolean sourceFile;

        private PreProcessorContext(Map<String, Object> customProgramData, ShaderPreProcessor preProcessor, @Nullable ProgramDefinition definition, ShaderPreDefinitions preDefinitions, ShaderImporter shaderImporter, int activeBuffers, int type, GLCapabilities glCapabilities, Object2IntMap<String> uniformBindings, Set<String> definitionDependencies, Map<String, String> macros, @Nullable ResourceLocation name, boolean sourceFile) {
            this.customProgramData = customProgramData;
            this.preProcessor = preProcessor;
            this.definition = definition;
            this.preDefinitions = preDefinitions;
            this.shaderImporter = shaderImporter;
            this.activeBuffers = activeBuffers;
            this.type = type;
            this.glCapabilities = glCapabilities;
            this.uniformBindings = uniformBindings;
            this.definitionDependencies = definitionDependencies;
            this.macros = macros;
            this.name = name;
            this.sourceFile = sourceFile;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PreProcessorContext.class), PreProcessorContext.class, "customProgramData;preProcessor;definition;preDefinitions;shaderImporter;activeBuffers;type;glCapabilities;uniformBindings;definitionDependencies;macros;name;sourceFile", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->customProgramData:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->preProcessor:Lfoundry/veil/api/client/render/shader/processor/ShaderPreProcessor;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->definition:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->preDefinitions:Lfoundry/veil/api/client/render/shader/ShaderPreDefinitions;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->shaderImporter:Lfoundry/veil/api/client/render/shader/processor/ShaderImporter;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->activeBuffers:I", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->type:I", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->glCapabilities:Lorg/lwjgl/opengl/GLCapabilities;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->uniformBindings:Lit/unimi/dsi/fastutil/objects/Object2IntMap;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->macros:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->sourceFile:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PreProcessorContext.class), PreProcessorContext.class, "customProgramData;preProcessor;definition;preDefinitions;shaderImporter;activeBuffers;type;glCapabilities;uniformBindings;definitionDependencies;macros;name;sourceFile", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->customProgramData:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->preProcessor:Lfoundry/veil/api/client/render/shader/processor/ShaderPreProcessor;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->definition:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->preDefinitions:Lfoundry/veil/api/client/render/shader/ShaderPreDefinitions;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->shaderImporter:Lfoundry/veil/api/client/render/shader/processor/ShaderImporter;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->activeBuffers:I", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->type:I", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->glCapabilities:Lorg/lwjgl/opengl/GLCapabilities;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->uniformBindings:Lit/unimi/dsi/fastutil/objects/Object2IntMap;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->macros:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->sourceFile:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PreProcessorContext.class, Object.class), PreProcessorContext.class, "customProgramData;preProcessor;definition;preDefinitions;shaderImporter;activeBuffers;type;glCapabilities;uniformBindings;definitionDependencies;macros;name;sourceFile", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->customProgramData:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->preProcessor:Lfoundry/veil/api/client/render/shader/processor/ShaderPreProcessor;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->definition:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->preDefinitions:Lfoundry/veil/api/client/render/shader/ShaderPreDefinitions;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->shaderImporter:Lfoundry/veil/api/client/render/shader/processor/ShaderImporter;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->activeBuffers:I", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->type:I", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->glCapabilities:Lorg/lwjgl/opengl/GLCapabilities;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->uniformBindings:Lit/unimi/dsi/fastutil/objects/Object2IntMap;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->macros:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$PreProcessorContext;->sourceFile:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public Map<String, Object> customProgramData() {
            return this.customProgramData;
        }

        public ShaderPreProcessor preProcessor() {
            return this.preProcessor;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.VeilContext
        @Nullable
        public ProgramDefinition definition() {
            return this.definition;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public ShaderPreDefinitions preDefinitions() {
            return this.preDefinitions;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public ShaderImporter shaderImporter() {
            return this.shaderImporter;
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

        public Set<String> definitionDependencies() {
            return this.definitionDependencies;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public Map<String, String> macros() {
            return this.macros;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        @Nullable
        public ResourceLocation name() {
            return this.name;
        }

        public boolean sourceFile() {
            return this.sourceFile;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public GlslTree modifyInclude(@Nullable ResourceLocation name, String source) throws GlslSyntaxException, IOException, LexerException {
            GlslTree tree = GlslParser.preprocessParse(source, this.macros);
            PreProcessorContext context = new PreProcessorContext(this.customProgramData, this.preProcessor, this.definition, this.preDefinitions, this.shaderImporter, this.activeBuffers, this.type, this.glCapabilities, this.uniformBindings, this.definitionDependencies, this.macros, name, false);
            this.preProcessor.modify(context, tree);
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
            return false;
        }

        @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context
        public boolean isSourceFile() {
            return this.sourceFile;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/ShaderManager$ProgramSource.class */
    private static final class ProgramSource extends Record {
        private final ProgramDefinition definition;
        private final Map<ResourceLocation, VeilShaderSource> sources;

        private ProgramSource(ProgramDefinition definition, Map<ResourceLocation, VeilShaderSource> sources) {
            this.definition = definition;
            this.sources = sources;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ProgramSource.class), ProgramSource.class, "definition;sources", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$ProgramSource;->definition:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$ProgramSource;->sources:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ProgramSource.class), ProgramSource.class, "definition;sources", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$ProgramSource;->definition:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$ProgramSource;->sources:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ProgramSource.class, Object.class), ProgramSource.class, "definition;sources", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$ProgramSource;->definition:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;", "FIELD:Lfoundry/veil/api/client/render/shader/ShaderManager$ProgramSource;->sources:Ljava/util/Map;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public ProgramDefinition definition() {
            return this.definition;
        }

        public Map<ResourceLocation, VeilShaderSource> sources() {
            return this.sources;
        }

        public ShaderCompiler createCompiler() {
            return ShaderCompiler.direct(name -> {
                VeilShaderSource source = this.sources.get(name);
                if (source == null) {
                    throw new FileNotFoundException("Unknown shader source: " + String.valueOf(name));
                }
                return source;
            });
        }
    }
}
