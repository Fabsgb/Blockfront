package foundry.veil.impl.client.render.dynamicbuffer;

import com.google.common.base.Stopwatch;
import com.mojang.blaze3d.preprocessor.GlslPreprocessor;
import com.mojang.blaze3d.vertex.VertexFormat;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.ext.ShaderInstanceExtension;
import foundry.veil.impl.ThreadTaskScheduler;
import foundry.veil.impl.client.render.shader.processor.VanillaShaderProcessor;
import foundry.veil.impl.client.render.shader.program.ShaderProgramImpl;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import net.minecraft.FileUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/dynamicbuffer/VanillaShaderCompiler.class */
public class VanillaShaderCompiler {
    private static final Set<String> LAST_FRAME_SHADERS = ConcurrentHashMap.newKeySet();
    private ThreadTaskScheduler scheduler;

    private void compileShader(ShaderInstance shader, int activeBuffers, GLCapabilities glCapabilities) {
        ShaderInstanceExtension extension = (ShaderInstanceExtension) shader;
        Collection<ResourceLocation> shaderSources = extension.veil$getShaderSources();
        VertexFormat vertexFormat = shader.getVertexFormat();
        Map<String, Object> customProgramData = new HashMap<>();
        final ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();
        VanillaShaderProcessor.setup(resourceManager);
        for (final ResourceLocation path : shaderSources) {
            try {
                Reader reader = resourceManager.openAsReader(path);
                try {
                    String source = IOUtils.toString(reader);
                    GlslPreprocessor preprocessor = new GlslPreprocessor(this) { // from class: foundry.veil.impl.client.render.dynamicbuffer.VanillaShaderCompiler.1
                        private final Set<ResourceLocation> importedPaths = new HashSet();

                        public String applyImport(boolean useFullPath, @NotNull String directory) {
                            ResourceLocation loc = ResourceLocation.parse(directory);
                            String normalised = FileUtil.normalizeResourcePath(String.valueOf(useFullPath ? path : "shaders/include/") + loc.getPath());
                            ResourceLocation resourcelocation = ResourceLocation.fromNamespaceAndPath(loc.getNamespace(), normalised);
                            if (!this.importedPaths.add(resourcelocation)) {
                                return null;
                            }
                            try {
                                Reader reader2 = resourceManager.openAsReader(resourcelocation);
                                try {
                                    String string = IOUtils.toString(reader2);
                                    if (reader2 != null) {
                                        reader2.close();
                                    }
                                    return string;
                                } catch (Throwable th) {
                                    if (reader2 != null) {
                                        try {
                                            reader2.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException e) {
                                throw new RuntimeException("Could not open GLSL import " + String.valueOf(resourcelocation), e);
                            }
                        }
                    };
                    String source2 = String.join("", preprocessor.process(source));
                    boolean vertex = path.getPath().endsWith(".vsh");
                    String processed = VanillaShaderProcessor.modify(customProgramData, shader.getName(), path, vertexFormat, activeBuffers, vertex ? 35633 : 35632, source2, glCapabilities);
                    Minecraft.getInstance().execute(() -> {
                        extension.veil$recompile(vertex, processed, activeBuffers);
                        VeilRenderSystem.renderer().getDynamicBufferManger().markRecompiled(shader);
                    });
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
                Veil.LOGGER.error("Couldn't load vanilla shader from {}, skipping", path, t);
            }
        }
        VanillaShaderProcessor.free();
    }

    public CompletableFuture<?> reload(Collection<ShaderInstance> shaders) {
        if (this.scheduler != null) {
            this.scheduler.cancel();
        }
        int shaderCount = shaders.size();
        Map<String, ShaderInstance> shaderMap = new ConcurrentHashMap<>(shaderCount);
        for (ShaderInstance shader : shaders) {
            if (!(shader instanceof ShaderProgramImpl.Wrapper)) {
                shaderMap.put(shader.getName(), shader);
            }
        }
        int activeBuffers = VeilRenderSystem.renderer().getDynamicBufferManger().getActiveBuffers();
        GLCapabilities capabilities = GL.getCapabilities();
        Stopwatch stopwatch = Stopwatch.createStarted();
        ThreadTaskScheduler scheduler = new ThreadTaskScheduler("VeilVanillaShaderCompile", Math.max(1, Runtime.getRuntime().availableProcessors() / 6), () -> {
            for (String lastFrameShader : LAST_FRAME_SHADERS) {
                ShaderInstance shader2 = (ShaderInstance) shaderMap.remove(lastFrameShader);
                if (shader2 != null) {
                    return () -> {
                        compileShader(shader2, activeBuffers, capabilities);
                    };
                }
            }
            Iterator<ShaderInstance> iterator = shaderMap.values().iterator();
            if (iterator.hasNext()) {
                ShaderInstance shader3 = iterator.next();
                iterator.remove();
                return () -> {
                    compileShader(shader3, activeBuffers, capabilities);
                };
            }
            return null;
        });
        this.scheduler = scheduler;
        CompletableFuture<?> future = scheduler.getCompletedFuture();
        future.thenRunAsync(() -> {
            if (!scheduler.isCancelled()) {
                Veil.LOGGER.info("Compiled {} vanilla shaders in {}", Integer.valueOf(shaderCount), stopwatch.stop());
            }
        }, (Executor) Minecraft.getInstance());
        return future.isDone() ? CompletableFuture.completedFuture(null) : future;
    }

    public boolean isCompilingShaders() {
        return (this.scheduler == null || this.scheduler.getCompletedFuture().isDone()) ? false : true;
    }

    public static int getActiveDynamicBuffers(ShaderInstance shaderInstance) {
        if (shaderInstance instanceof ShaderProgramImpl.Wrapper) {
            ShaderProgramImpl.Wrapper wrapper = (ShaderProgramImpl.Wrapper) shaderInstance;
            return wrapper.program().getActiveDynamicBuffers();
        }
        return ((ShaderInstanceExtension) shaderInstance).veil$getActiveBuffers();
    }

    @ApiStatus.Internal
    public static void markRendered(String shaderInstace) {
        if (VeilRenderSystem.renderer().getVanillaShaderCompiler().isCompilingShaders()) {
            LAST_FRAME_SHADERS.add(shaderInstace);
        }
    }

    @ApiStatus.Internal
    public static void clear() {
        LAST_FRAME_SHADERS.clear();
    }
}
