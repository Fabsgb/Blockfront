package foundry.veil.api.client.render.shader.program;

import com.google.common.collect.Iterables;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import foundry.veil.api.client.render.shader.ShaderFeature;
import foundry.veil.api.client.render.shader.ShaderPreDefinitions;
import foundry.veil.api.client.render.shader.texture.ShaderTextureSource;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Type;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/program/ProgramDefinition.class */
public final class ProgramDefinition extends Record {

    @Nullable
    private final ResourceLocation vertex;

    @Nullable
    private final ResourceLocation tesselationControl;

    @Nullable
    private final ResourceLocation tesselationEvaluation;

    @Nullable
    private final ResourceLocation geometry;

    @Nullable
    private final ResourceLocation fragment;

    @Nullable
    private final ResourceLocation compute;
    private final String[] definitions;
    private final Map<String, String> definitionDefaults;
    private final Map<String, ShaderTextureSource> samplers;
    private final Int2ObjectMap<ResourceLocation> shaders;
    private final ShaderFeature[] requiredFeatures;

    @Nullable
    private final ShaderBlendMode blendMode;

    public ProgramDefinition(@Nullable ResourceLocation vertex, @Nullable ResourceLocation tesselationControl, @Nullable ResourceLocation tesselationEvaluation, @Nullable ResourceLocation geometry, @Nullable ResourceLocation fragment, @Nullable ResourceLocation compute, String[] definitions, Map<String, String> definitionDefaults, Map<String, ShaderTextureSource> samplers, Int2ObjectMap<ResourceLocation> shaders, ShaderFeature[] requiredFeatures, @Nullable ShaderBlendMode blendMode) {
        this.vertex = vertex;
        this.tesselationControl = tesselationControl;
        this.tesselationEvaluation = tesselationEvaluation;
        this.geometry = geometry;
        this.fragment = fragment;
        this.compute = compute;
        this.definitions = definitions;
        this.definitionDefaults = definitionDefaults;
        this.samplers = samplers;
        this.shaders = shaders;
        this.requiredFeatures = requiredFeatures;
        this.blendMode = blendMode;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ProgramDefinition.class), ProgramDefinition.class, "vertex;tesselationControl;tesselationEvaluation;geometry;fragment;compute;definitions;definitionDefaults;samplers;shaders;requiredFeatures;blendMode", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->vertex:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->tesselationControl:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->tesselationEvaluation:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->geometry:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->fragment:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->compute:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->definitions:[Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->definitionDefaults:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->samplers:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->shaders:Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->requiredFeatures:[Lfoundry/veil/api/client/render/shader/ShaderFeature;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->blendMode:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ProgramDefinition.class), ProgramDefinition.class, "vertex;tesselationControl;tesselationEvaluation;geometry;fragment;compute;definitions;definitionDefaults;samplers;shaders;requiredFeatures;blendMode", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->vertex:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->tesselationControl:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->tesselationEvaluation:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->geometry:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->fragment:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->compute:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->definitions:[Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->definitionDefaults:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->samplers:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->shaders:Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->requiredFeatures:[Lfoundry/veil/api/client/render/shader/ShaderFeature;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->blendMode:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ProgramDefinition.class, Object.class), ProgramDefinition.class, "vertex;tesselationControl;tesselationEvaluation;geometry;fragment;compute;definitions;definitionDefaults;samplers;shaders;requiredFeatures;blendMode", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->vertex:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->tesselationControl:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->tesselationEvaluation:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->geometry:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->fragment:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->compute:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->definitions:[Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->definitionDefaults:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->samplers:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->shaders:Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->requiredFeatures:[Lfoundry/veil/api/client/render/shader/ShaderFeature;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ProgramDefinition;->blendMode:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    public ResourceLocation vertex() {
        return this.vertex;
    }

    @Nullable
    public ResourceLocation tesselationControl() {
        return this.tesselationControl;
    }

    @Nullable
    public ResourceLocation tesselationEvaluation() {
        return this.tesselationEvaluation;
    }

    @Nullable
    public ResourceLocation geometry() {
        return this.geometry;
    }

    @Nullable
    public ResourceLocation fragment() {
        return this.fragment;
    }

    @Nullable
    public ResourceLocation compute() {
        return this.compute;
    }

    public String[] definitions() {
        return this.definitions;
    }

    public Map<String, String> definitionDefaults() {
        return this.definitionDefaults;
    }

    public Map<String, ShaderTextureSource> samplers() {
        return this.samplers;
    }

    public Int2ObjectMap<ResourceLocation> shaders() {
        return this.shaders;
    }

    public ShaderFeature[] requiredFeatures() {
        return this.requiredFeatures;
    }

    @Nullable
    public ShaderBlendMode blendMode() {
        return this.blendMode;
    }

    public Map<String, String> getMacros(Set<String> dependencies, ShaderPreDefinitions definitions) {
        Map<String, String> macros = new HashMap<>(definitions.getStaticDefinitions());
        for (String name : this.definitions) {
            String definition = definitions.getDefinition(name);
            if (definition != null) {
                macros.put(name.toUpperCase(Locale.ROOT), definition);
            } else {
                String definitionDefault = this.definitionDefaults.get(name);
                if (definitionDefault != null) {
                    macros.put(name.toUpperCase(Locale.ROOT), definitionDefault);
                }
            }
            dependencies.add(name);
        }
        return macros;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/program/ProgramDefinition$Deserializer.class */
    public static class Deserializer implements JsonDeserializer<ProgramDefinition> {
        @Nullable
        private static ResourceLocation deserializeSource(JsonObject json, String name, JsonDeserializationContext context) {
            JsonElement element = json.get(name);
            if (element == null) {
                return null;
            }
            return (ResourceLocation) context.deserialize(element, ResourceLocation.class);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonSyntaxException */
        private String[] deserializeDefinitions(JsonArray json, Map<String, String> defaults) throws JsonParseException, JsonSyntaxException {
            List<String> definitions = new ArrayList<>(json.size());
            for (int i = 0; i < json.size(); i++) {
                JsonElement element = json.get(i);
                if (element.isJsonPrimitive()) {
                    definitions.add(element.getAsJsonPrimitive().getAsString());
                } else if (element.isJsonObject()) {
                    JsonObject definitionJson = element.getAsJsonObject();
                    Set<Map.Entry<String, JsonElement>> entrySet = definitionJson.entrySet();
                    if (entrySet.size() != 1) {
                        throw new JsonSyntaxException("Expected definitions[" + i + "] to have one element, had " + entrySet.size());
                    }
                    Map.Entry<String, JsonElement> entry = (Map.Entry) Iterables.getOnlyElement(entrySet);
                    definitions.add(entry.getKey());
                    defaults.put(entry.getKey(), GsonHelper.convertToString(entry.getValue(), "definitions[" + i + "]"));
                } else {
                    throw new JsonSyntaxException("Expected definitions[" + i + "] to be a JsonPrimitive or Object, was " + GsonHelper.getType(element));
                }
            }
            return (String[]) definitions.toArray(x$0 -> {
                return new String[x$0];
            });
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonSyntaxException */
        private Map<String, ShaderTextureSource> deserializeTextures(JsonObject json) throws JsonParseException, JsonSyntaxException {
            Map<String, ShaderTextureSource> textures = new HashMap<>();
            for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
                String name = entry.getKey();
                DataResult<ShaderTextureSource> texture = ShaderTextureSource.CODEC.parse(JsonOps.INSTANCE, entry.getValue());
                if (texture.error().isPresent()) {
                    throw new JsonSyntaxException("Failed to deserialize texture: " + name + ". " + ((DataResult.Error) texture.error().get()).message());
                }
                textures.put(name, (ShaderTextureSource) texture.result().orElseThrow());
            }
            ShaderTextureSource.CODEC.parse(JsonOps.INSTANCE, json);
            return Collections.unmodifiableMap(textures);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
        /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonSyntaxException */
        /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
        public ProgramDefinition m9007deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException, JsonSyntaxException {
            String[] definitions;
            Map<String, String> definitionDefaults;
            ShaderBlendMode blendMode;
            Set<ShaderFeature> requiredFeatures;
            JsonObject json = element.getAsJsonObject();
            ResourceLocation vertex = deserializeSource(json, "vertex", context);
            ResourceLocation tesselationControl = deserializeSource(json, "tesselation_control", context);
            ResourceLocation tesselationEvaluation = deserializeSource(json, "tesselation_evaluation", context);
            ResourceLocation geometry = deserializeSource(json, "geometry", context);
            ResourceLocation fragment = deserializeSource(json, "fragment", context);
            ResourceLocation compute = deserializeSource(json, "compute", context);
            if (json.has("definitions")) {
                Map<String, String> defaults = new HashMap<>();
                definitions = deserializeDefinitions(json.getAsJsonArray("definitions"), defaults);
                definitionDefaults = Collections.unmodifiableMap(defaults);
            } else {
                definitions = new String[0];
                definitionDefaults = Collections.emptyMap();
            }
            Map<String, ShaderTextureSource> textures = json.has("textures") ? deserializeTextures(json.getAsJsonObject("textures")) : Collections.emptyMap();
            if (json.has("blend")) {
                DataResult<ShaderBlendMode> result = ShaderBlendMode.CODEC.parse(JsonOps.INSTANCE, json.get("blend"));
                if (result.isError()) {
                    throw new JsonSyntaxException(((DataResult.Error) result.error().orElseThrow()).message());
                }
                blendMode = (ShaderBlendMode) result.result().orElseThrow();
            } else {
                blendMode = null;
            }
            if (json.has("required_features")) {
                Set<ShaderFeature> features = new HashSet<>();
                JsonElement requiredFeaturesElement = json.get("required_features");
                if (!requiredFeaturesElement.isJsonArray()) {
                    throw new JsonSyntaxException("Expected required_features to be a JsonArray, was " + GsonHelper.getType(requiredFeaturesElement));
                }
                for (JsonElement featureElement : requiredFeaturesElement.getAsJsonArray()) {
                    DataResult<ShaderFeature> result2 = ShaderFeature.CODEC.parse(JsonOps.INSTANCE, featureElement);
                    if (result2.isSuccess()) {
                        features.add((ShaderFeature) result2.getOrThrow());
                    } else {
                        throw new JsonSyntaxException("Failed to parse shader feature: " + String.valueOf(featureElement) + ". " + ((DataResult.Error) result2.error().orElseThrow()).message());
                    }
                }
                requiredFeatures = features;
            } else {
                requiredFeatures = new HashSet<>();
            }
            Int2ObjectArrayMap int2ObjectArrayMap = new Int2ObjectArrayMap();
            if (vertex != null) {
                int2ObjectArrayMap.put(35633, vertex);
            }
            if (tesselationControl != null) {
                int2ObjectArrayMap.put(36488, tesselationControl);
                requiredFeatures.add(ShaderFeature.TESSELLATION);
            }
            if (tesselationEvaluation != null) {
                int2ObjectArrayMap.put(36487, tesselationEvaluation);
                requiredFeatures.add(ShaderFeature.TESSELLATION);
            }
            if (geometry != null) {
                int2ObjectArrayMap.put(36313, geometry);
            }
            if (fragment != null) {
                int2ObjectArrayMap.put(35632, fragment);
            }
            if (compute != null) {
                int2ObjectArrayMap.put(37305, compute);
                requiredFeatures.add(ShaderFeature.COMPUTE);
            }
            return new ProgramDefinition(vertex, tesselationControl, tesselationEvaluation, geometry, fragment, compute, definitions, definitionDefaults, textures, Int2ObjectMaps.unmodifiable(int2ObjectArrayMap), (ShaderFeature[]) requiredFeatures.toArray(x$0 -> {
                return new ShaderFeature[x$0];
            }), blendMode);
        }
    }
}
