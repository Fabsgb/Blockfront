package foundry.veil.api.flare.data.effect;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.property.Property;
import foundry.veil.api.client.property.properties.TimeProperty;
import foundry.veil.api.client.registry.PropertyModifierRegistry;
import foundry.veil.api.client.render.MatrixStack;
import foundry.veil.api.flare.EffectHost;
import foundry.veil.api.flare.FlareEffectManager;
import foundry.veil.api.flare.model.BakedShell;
import foundry.veil.api.flare.modifier.ControllerManager;
import foundry.veil.api.flare.modifier.PropertyModifier;
import foundry.veil.api.util.CodecUtil;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/data/effect/FlareEffectLayer.class */
public final class FlareEffectLayer {
    public static final Codec<FlareEffectLayer> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.getName();
        }), Codec.BOOL.optionalFieldOf("disabled", false).forGetter((v0) -> {
            return v0.isDisabled();
        }), FlareModel.CODEC.fieldOf("model").forGetter((v0) -> {
            return v0.getModel();
        }), CodecUtil.registryOrLegacyCodec(PropertyModifierRegistry.REGISTRY).dispatch((v0) -> {
            return v0.type();
        }, (v0) -> {
            return v0.codec();
        }).listOf().optionalFieldOf("modifiers", List.of()).forGetter(layer -> {
            return List.of((Object[]) layer.originalModifiers);
        })).apply(instance, (v1, v2, v3, v4) -> {
            return new FlareEffectLayer(v1, v2, v3, v4);
        });
    });
    private final String name;
    private final boolean disabled;
    private final FlareModel model;
    private final Map<String, List<PropertyModifier<?>>> modifiers;
    private final PropertyModifier<?>[] originalModifiers;
    private final List<PropertyModifier<?>> positionModifier;
    private final List<PropertyModifier<?>> rotationModifier;
    private final List<PropertyModifier<?>> scaleModifier;

    public FlareEffectLayer(String name, boolean disabled, FlareModel model, List<PropertyModifier<?>> modifiers) {
        this.name = name;
        this.disabled = disabled;
        this.model = model;
        this.originalModifiers = (PropertyModifier[]) modifiers.toArray(x$0 -> {
            return new PropertyModifier[x$0];
        });
        Map<String, List<PropertyModifier<?>>> modifierMap = new HashMap<>();
        for (FlareMaterial material : model.getMaterials()) {
            putModelProperties(material.properties());
        }
        for (PropertyModifier<?> modifier : modifiers) {
            List<PropertyModifier<?>> modifierList = modifierMap.computeIfAbsent(modifier.outputPropertyName(), unused -> {
                return new ObjectArrayList();
            });
            modifierList.add(modifier);
        }
        modifierMap.replaceAll((key, value) -> {
            return Collections.unmodifiableList(value);
        });
        this.modifiers = Collections.unmodifiableMap(new Object2ObjectArrayMap(modifierMap));
        this.positionModifier = modifierMap.get(FlareModel.POSITION_PROPERTY_NAME);
        this.rotationModifier = modifierMap.get(FlareModel.ROTATION_PROPERTY_NAME);
        this.scaleModifier = modifierMap.get(FlareModel.SCALE_PROPERTY_NAME);
    }

    public void putModelProperties(Map<String, Property<?>> materialProperties) {
        materialProperties.put(FlareModel.POSITION_PROPERTY_NAME, this.model.positionOffset);
        materialProperties.put(FlareModel.ROTATION_PROPERTY_NAME, this.model.rotationOffset);
        materialProperties.put(FlareModel.SCALE_PROPERTY_NAME, this.model.scaleOffset);
        materialProperties.put("ModelToWorld", this.model.modelToWorld);
        materialProperties.put("_Time", TimeProperty.INSTANCE);
    }

    public void render(EffectHost host, MatrixStack matrixStack, float partialTick, @Nullable Map<ResourceLocation, BakedShell> shellOverrides) {
        ControllerManager controllerManager = FlareEffectManager.getInstance().getControllerManager();
        for (PropertyModifier<?> modifier : this.originalModifiers) {
            controllerManager.getOrCreateController(modifier.inputControllerName(), host).update(partialTick);
        }
        PropertyModifier.modifyProperty(host, null, this.model.positionOffset, this.positionModifier);
        PropertyModifier.modifyProperty(host, null, this.model.rotationOffset, this.rotationModifier);
        PropertyModifier.modifyProperty(host, null, this.model.scaleOffset, this.scaleModifier);
        this.model.render(host, matrixStack, this.modifiers, shellOverrides);
        this.model.positionOffset.resetOverrideValue();
        this.model.rotationOffset.resetOverrideValue();
        this.model.scaleOffset.resetOverrideValue();
        this.model.modelToWorld.resetOverrideValue();
    }

    public String getName() {
        return this.name;
    }

    public FlareModel getModel() {
        return this.model;
    }

    public Map<String, List<PropertyModifier<?>>> getModifiers() {
        return this.modifiers;
    }

    public PropertyModifier<?>[] getOriginalModifiers() {
        return this.originalModifiers;
    }

    public boolean isDisabled() {
        return this.disabled;
    }
}
