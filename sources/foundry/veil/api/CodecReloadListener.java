package foundry.veil.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import foundry.veil.Veil;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/CodecReloadListener.class */
public abstract class CodecReloadListener<T> extends SimplePreparableReloadListener<Map<ResourceLocation, T>> {
    protected final Codec<T> codec;
    protected final FileToIdConverter converter;
    private final HolderLookup.Provider registries;

    public CodecReloadListener(Codec<T> codec, FileToIdConverter converter) {
        this(codec, converter, null);
    }

    public CodecReloadListener(Codec<T> codec, FileToIdConverter converter, @Nullable HolderLookup.Provider registries) {
        this.codec = codec;
        this.converter = converter;
        this.registries = registries;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // 
    @NotNull
    /* JADX INFO: renamed from: prepare, reason: merged with bridge method [inline-methods] */
    public Map<ResourceLocation, T> mo9291prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        HashMap map = new HashMap();
        RegistryOps registryOpsCreate = this.registries != null ? RegistryOps.create(JsonOps.INSTANCE, this.registries) : JsonOps.INSTANCE;
        Map<ResourceLocation, Resource> resources = this.converter.listMatchingResources(resourceManager);
        for (Map.Entry<ResourceLocation, Resource> entry : resources.entrySet()) {
            ResourceLocation location = entry.getKey();
            ResourceLocation id = this.converter.fileToId(location);
            try {
                Reader reader = entry.getValue().openAsReader();
                try {
                    JsonElement element = JsonParser.parseReader(reader);
                    DataResult<T> result = this.codec.parse(registryOpsCreate, element);
                    if (result.error().isPresent()) {
                        throw new JsonSyntaxException(((DataResult.Error) result.error().get()).message());
                    }
                    if (map.put(id, result.result().orElseThrow()) != null) {
                        throw new IllegalStateException("Duplicate data file ignored with ID " + String.valueOf(id));
                    }
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
            } catch (Exception e) {
                Veil.LOGGER.error("Couldn't parse data file {} from {}", new Object[]{id, location, e});
            }
        }
        return map;
    }
}
