package foundry.veil.impl.client.render.shader.injection.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Type;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition.class */
@ApiStatus.Internal
public final class ShaderInjectionDefinition extends Record {

    /* JADX INFO: renamed from: id */
    @Nullable
    private final ResourceLocation f9161id;
    private final List<ResourceLocation> targets;
    private final List<ResourceLocation> redirects;
    private final int priority;

    @Nullable
    private final ResourceLocation replace;
    private final boolean debug;
    public static final int DEFAULT_PRIORITY = 1000;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ShaderInjectionDefinition.class), ShaderInjectionDefinition.class, "id;targets;redirects;priority;replace;debug", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->id:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->targets:Ljava/util/List;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->redirects:Ljava/util/List;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->priority:I", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->replace:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->debug:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ShaderInjectionDefinition.class), ShaderInjectionDefinition.class, "id;targets;redirects;priority;replace;debug", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->id:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->targets:Ljava/util/List;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->redirects:Ljava/util/List;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->priority:I", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->replace:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->debug:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ShaderInjectionDefinition.class, Object.class), ShaderInjectionDefinition.class, "id;targets;redirects;priority;replace;debug", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->id:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->targets:Ljava/util/List;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->redirects:Ljava/util/List;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->priority:I", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->replace:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;->debug:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    /* JADX INFO: renamed from: id */
    public ResourceLocation m8348id() {
        return this.f9161id;
    }

    public List<ResourceLocation> targets() {
        return this.targets;
    }

    public List<ResourceLocation> redirects() {
        return this.redirects;
    }

    public int priority() {
        return this.priority;
    }

    @Nullable
    public ResourceLocation replace() {
        return this.replace;
    }

    public boolean debug() {
        return this.debug;
    }

    public ShaderInjectionDefinition(@Nullable ResourceLocation id, List<ResourceLocation> targets, List<ResourceLocation> redirects, int priority, @Nullable ResourceLocation replace, boolean debug) {
        priority = priority == 0 ? 1000 : priority;
        List<ResourceLocation> targets2 = List.copyOf(targets);
        List<ResourceLocation> redirects2 = List.copyOf(redirects);
        this.f9161id = id;
        this.targets = targets2;
        this.redirects = redirects2;
        this.priority = priority;
        this.replace = replace;
        this.debug = debug;
    }

    public static Gson createGson() {
        return new GsonBuilder().registerTypeAdapter(ResourceLocation.class, (json, type, context) -> {
            return ResourceLocation.parse(json.getAsString());
        }).registerTypeAdapter(ResourceLocation.class, (location, type2, context2) -> {
            return context2.serialize(location.toString());
        }).registerTypeAdapter(ShaderInjectionDefinition.class, new Deserializer()).create();
    }

    public ShaderInjectionDefinition withDefaultId(ResourceLocation defaultId) {
        return new ShaderInjectionDefinition(this.f9161id != null ? this.f9161id : defaultId, this.targets, this.redirects, this.priority, this.replace, this.debug);
    }

    @Nullable
    public ResourceLocation target() {
        if (this.targets.isEmpty()) {
            return null;
        }
        return (ResourceLocation) this.targets.getFirst();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition$Deserializer.class */
    private static class Deserializer implements JsonDeserializer<ShaderInjectionDefinition> {
        private Deserializer() {
        }

        /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
        public ShaderInjectionDefinition m9567deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();
            List<ResourceLocation> targets = ShaderInjectionDefinition.parseResourceLocations(obj, "target");
            List<ResourceLocation> redirects = ShaderInjectionDefinition.parseResourceLocations(obj, "redirect");
            int priority = obj.has("priority") ? obj.get("priority").getAsInt() : ShaderInjectionDefinition.DEFAULT_PRIORITY;
            ResourceLocation replace = obj.has("replace") ? (ResourceLocation) context.deserialize(obj.get("replace"), ResourceLocation.class) : null;
            boolean debug = obj.has("debug") && obj.get("debug").getAsBoolean();
            return new ShaderInjectionDefinition(null, targets, redirects, priority, replace, debug);
        }
    }

    private static List<ResourceLocation> parseResourceLocations(JsonObject obj, String field) {
        if (!obj.has(field) || (obj.get(field) instanceof JsonNull)) {
            return List.of();
        }
        JsonArray jsonArray = obj.get(field);
        if (jsonArray instanceof JsonArray) {
            JsonArray<JsonElement> array = jsonArray;
            List<ResourceLocation> result = new ArrayList<>();
            for (JsonElement el : array) {
                result.add(ResourceLocation.parse(el.getAsString()));
            }
            return result;
        }
        return List.of(ResourceLocation.parse(jsonArray.getAsString()));
    }
}
