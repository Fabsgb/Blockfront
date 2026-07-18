package foundry.veil.impl.client.render.rendertype;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import foundry.veil.Veil;
import foundry.veil.api.client.render.rendertype.layer.CompositeRenderTypeData;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/rendertype/DynamicRenderTypeManager.class */
@ApiStatus.Internal
public class DynamicRenderTypeManager extends SimplePreparableReloadListener<Map<ResourceLocation, byte[]>> {
    private static final FileToIdConverter CONVERTER = FileToIdConverter.json("pinwheel/rendertypes");
    private final Map<ResourceLocation, RenderTypeCache> renderTypes = new Object2ObjectArrayMap();

    @Contract(pure = true)
    @Nullable
    public RenderType get(ResourceLocation id, Object... params) {
        RenderTypeCache cache = this.renderTypes.get(id);
        if (cache == null) {
            return null;
        }
        return cache.get(params);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* JADX INFO: renamed from: prepare, reason: merged with bridge method [inline-methods] */
    public Map<ResourceLocation, byte[]> m9174prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        Map<ResourceLocation, byte[]> data = new HashMap<>();
        Map<ResourceLocation, Resource> resources = CONVERTER.listMatchingResources(resourceManager);
        for (Map.Entry<ResourceLocation, Resource> entry : resources.entrySet()) {
            ResourceLocation location = entry.getKey();
            ResourceLocation id = CONVERTER.fileToId(location);
            try {
                InputStream stream = entry.getValue().open();
                try {
                    data.put(id, stream.readAllBytes());
                    if (stream != null) {
                        stream.close();
                    }
                } catch (Throwable th) {
                    if (stream != null) {
                        try {
                            stream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e) {
                Veil.LOGGER.error("Couldn't read data file {} from {}", new Object[]{id, location, e});
            }
        }
        return data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apply(Map<ResourceLocation, byte[]> fileData, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        Reader reader;
        DataResult<CompositeRenderTypeData> result;
        Map<ResourceLocation, RenderTypeCache> renderTypes = new HashMap<>();
        for (Map.Entry<ResourceLocation, byte[]> entry : fileData.entrySet()) {
            ResourceLocation id = entry.getKey();
            try {
                reader = new InputStreamReader(new ByteArrayInputStream(entry.getValue()));
                try {
                    JsonElement element = JsonParser.parseReader(reader);
                    result = CompositeRenderTypeData.CODEC.parse(JsonOps.INSTANCE, element);
                } finally {
                }
            } catch (Exception e) {
                Veil.LOGGER.error("Couldn't parse data file {} from {}", new Object[]{id, CONVERTER.idToFile(id), e});
            }
            if (result.error().isPresent()) {
                throw new JsonSyntaxException(((DataResult.Error) result.error().get()).message());
            }
            CompositeRenderTypeData data = (CompositeRenderTypeData) result.result().orElseThrow();
            if (renderTypes.put(id, new RenderTypeCache(id.toString(), data)) != null) {
                throw new IllegalStateException("Duplicate data file ignored with ID " + String.valueOf(id));
            }
            reader.close();
        }
        this.renderTypes.clear();
        this.renderTypes.putAll(renderTypes);
        Veil.LOGGER.info("Loaded {} render types", Integer.valueOf(renderTypes.size()));
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/rendertype/DynamicRenderTypeManager$RenderTypeCache.class */
    private static class RenderTypeCache {
        private final String name;
        private final CompositeRenderTypeData data;
        private final Cache<Integer, RenderType> objectCache = CacheBuilder.newBuilder().initialCapacity(4).maximumSize(64).expireAfterAccess(Duration.of(1000, ChronoUnit.SECONDS)).build();
        private RenderType defaultCache = null;
        private boolean defaultError;

        public RenderTypeCache(String name, CompositeRenderTypeData data) {
            this.name = name;
            this.data = data;
        }

        @Nullable
        public RenderType get(Object... params) {
            if (params.length == 0) {
                if (this.defaultError) {
                    return null;
                }
                if (this.defaultCache == null) {
                    try {
                        this.defaultCache = this.data.createRenderType(this.name, new Object[0]);
                    } catch (Exception e) {
                        Veil.LOGGER.error("Failed to create rendertype {} with no parameters", this.name, e);
                        this.defaultError = true;
                    }
                }
                return this.defaultCache;
            }
            try {
                return (RenderType) this.objectCache.get(Integer.valueOf(Arrays.hashCode(params)), () -> {
                    return this.data.createRenderType(this.name, params);
                });
            } catch (ExecutionException e2) {
                Veil.LOGGER.error("Failed to create rendertype {} with parameters: [{}]", new Object[]{this.name, Arrays.stream(params).map(Objects::toString).collect(Collectors.joining(", ")), e2});
                return null;
            }
        }
    }
}
