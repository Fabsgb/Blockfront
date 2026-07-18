package foundry.veil.api.flare.data.effect;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.property.InapplicableProperty;
import foundry.veil.api.client.property.InvertibleProperty;
import foundry.veil.api.client.property.ModelProperty;
import foundry.veil.api.client.property.Property;
import foundry.veil.api.client.property.properties.FloatProperty;
import foundry.veil.api.client.property.properties.RandomFloatProperty;
import foundry.veil.api.client.registry.PropertyRegistry;
import foundry.veil.api.flare.EffectHost;
import foundry.veil.api.flare.modifier.PropertyModifier;
import foundry.veil.api.util.CodecUtil;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/data/effect/FlareMaterial.class */
public final class FlareMaterial {
    public static Codec<FlareMaterial> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("class").forGetter((v0) -> {
            return v0.clazz();
        }), ResourceLocation.CODEC.fieldOf("renderType").forGetter((v0) -> {
            return v0.renderTypeLocation();
        }), Codec.BOOL.optionalFieldOf("randomizeSeed", false).forGetter((v0) -> {
            return v0.randomizeSeed();
        }), Codec.unboundedMap(Codec.STRING, CodecUtil.registryOrLegacyCodec(PropertyRegistry.REGISTRY).dispatchMap((v0) -> {
            return v0.getType();
        }, Property::codec).codec()).optionalFieldOf("properties", Map.of()).forGetter((v0) -> {
            return v0.properties();
        })).apply(instance, (clazz, renderType, randomizeSeed, properties) -> {
            return new FlareMaterial(clazz, renderType, randomizeSeed.booleanValue(), new Object2ObjectArrayMap(properties));
        });
    });
    private final String clazz;
    private final ResourceLocation renderTypeLocation;
    private final boolean randomizeSeed;
    private final Object2ObjectArrayMap<String, Property<?>> properties;

    public FlareMaterial(String clazz, ResourceLocation renderTypeLocation, boolean randomizeSeed, Map<String, Property<?>> properties) {
        properties.put("_ClipBrightness", new FloatProperty(1.0f));
        if (randomizeSeed) {
            properties.put("_Seed", RandomFloatProperty.INSTANCE);
        }
        this.clazz = clazz;
        this.renderTypeLocation = renderTypeLocation;
        this.randomizeSeed = randomizeSeed;
        this.properties = new Object2ObjectArrayMap<>(properties);
    }

    public void applyProperties(EffectHost host, @Nullable ShaderInstance shader, Map<String, List<PropertyModifier<?>>> modifiers) {
        if (shader == null || this.properties.isEmpty()) {
            return;
        }
        ObjectIterator it = this.properties.object2ObjectEntrySet().iterator();
        while (it.hasNext()) {
            Object2ObjectMap.Entry<String, Property<?>> entry = (Object2ObjectMap.Entry) it.next();
            Property<?> property = (Property) entry.getValue();
            Class<?> propertyClass = property.getClass();
            if (propertyClass.getAnnotation(InapplicableProperty.class) == null) {
                String name = (String) entry.getKey();
                if (propertyClass.getAnnotation(ModelProperty.class) == null) {
                    PropertyModifier.modifyProperty(host, this.clazz, property, modifiers.get(name));
                }
                property.applyValue(name, shader);
                if (property instanceof InvertibleProperty) {
                    InvertibleProperty<?> invertibleProperty = (InvertibleProperty) property;
                    invertibleProperty.applyInverseValue(name, shader);
                }
            }
        }
    }

    public void resetProperties(EffectHost host, @Nullable ShaderInstance shader) {
        if (shader == null) {
            return;
        }
        ObjectIterator it = this.properties.object2ObjectEntrySet().iterator();
        while (it.hasNext()) {
            Object2ObjectMap.Entry<String, Property<?>> entry = (Object2ObjectMap.Entry) it.next();
            Property<?> property = (Property) entry.getValue();
            if (property.getClass().getAnnotation(ModelProperty.class) == null) {
                property.resetOverrideValue();
            }
        }
    }

    public String clazz() {
        return this.clazz;
    }

    public ResourceLocation renderTypeLocation() {
        return this.renderTypeLocation;
    }

    public boolean randomizeSeed() {
        return this.randomizeSeed;
    }

    public Map<String, Property<?>> properties() {
        return this.properties;
    }
}
