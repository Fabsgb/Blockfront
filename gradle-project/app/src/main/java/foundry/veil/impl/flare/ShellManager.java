package foundry.veil.impl.flare;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import foundry.veil.Veil;
import foundry.veil.api.flare.data.model.FlareShell;
import foundry.veil.api.flare.model.BakedShell;
import foundry.veil.api.flare.model.ShellBakery;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/flare/ShellManager.class */
@ApiStatus.Internal
public class ShellManager extends SimplePreparableReloadListener<Map<ResourceLocation, BakedShell>> implements NativeResource {
    private static final FileToIdConverter CONVERTER = FileToIdConverter.json("flare/shells");
    private Map<ResourceLocation, BakedShell> shells = Map.of();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* JADX INFO: renamed from: prepare, reason: merged with bridge method [inline-methods] */
    public Map<ResourceLocation, BakedShell> m2025prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profiler) {
        Reader reader;
        DataResult<FlareShell> result;
        Map<ResourceLocation, BakedShell> data = new HashMap<>();
        Map<ResourceLocation, Resource> resources = CONVERTER.listMatchingResources(resourceManager);
        for (Map.Entry<ResourceLocation, Resource> entry : resources.entrySet()) {
            ResourceLocation location = entry.getKey();
            ResourceLocation id = CONVERTER.fileToId(location);
            try {
                reader = entry.getValue().openAsReader();
                try {
                    JsonElement element = JsonParser.parseReader(reader);
                    result = FlareShell.CODEC.parse(JsonOps.INSTANCE, element);
                } finally {
                }
            } catch (Exception e) {
                Veil.LOGGER.error("Couldn't parse data file {} from {}", new Object[]{id, location, e});
            }
            if (result.error().isPresent()) {
                throw new JsonSyntaxException(((DataResult.Error) result.error().get()).message());
            }
            if (data.put(id, ((FlareShell) result.result().orElseThrow()).bake()) != null) {
                throw new IllegalStateException("Duplicate data file ignored with ID " + String.valueOf(id));
            }
            if (reader != null) {
                reader.close();
            }
        }
        return data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apply(@NotNull Map<ResourceLocation, BakedShell> map, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profiler) {
        free();
        this.shells = Collections.unmodifiableMap(map);
    }

    public BakedShell getBakedShell(ResourceLocation shellLocation) {
        return this.shells.getOrDefault(shellLocation, ShellBakery.MISSING_SHELL);
    }

    public void free() {
        for (BakedShell shell : this.shells.values()) {
            shell.free();
        }
        this.shells = Map.of();
    }
}
