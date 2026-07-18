package foundry.veil.api.client.property.properties;

import com.mojang.blaze3d.shaders.Uniform;
import foundry.veil.api.client.property.Property;
import foundry.veil.api.client.registry.PropertyRegistry;
import foundry.veil.api.flare.modifier.PropertyModifier;
import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.MolangRuntime;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.renderer.ShaderInstance;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/property/properties/FloatProperty.class */
public class FloatProperty extends Property<Float> {
    @Override // foundry.veil.api.client.property.Property
    public /* bridge */ /* synthetic */ void modify(Float f, PropertyModifier.PropertyModifierMode propertyModifierMode, Optional optional) {
        modify2(f, propertyModifierMode, (Optional<List<MolangExpression>>) optional);
    }

    public FloatProperty(float value) {
        super(PropertyRegistry.FLOAT.get(), Float.valueOf(value));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // foundry.veil.api.client.property.Property
    public void applyValue(String name, ShaderInstance shader) {
        Uniform uniform = shader.getUniform(name);
        if (uniform != null) {
            uniform.set(((Float) this.overrideValue).floatValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [T, java.lang.Float] */
    /* JADX WARN: Type inference failed for: r1v17, types: [T, java.lang.Float] */
    /* JADX WARN: Type inference failed for: r1v23, types: [T, java.lang.Float] */
    /* JADX INFO: renamed from: modify, reason: avoid collision after fix types in other method */
    public void modify2(Float f, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang) {
        switch (mode) {
            case ADD:
                this.overrideValue = Float.valueOf(((Float) this.overrideValue).floatValue() + f.floatValue());
                break;
            case SUBTRACT:
                this.overrideValue = Float.valueOf(((Float) this.overrideValue).floatValue() - f.floatValue());
                break;
            case MULTIPLY:
                this.overrideValue = Float.valueOf(((Float) this.overrideValue).floatValue() * f.floatValue());
                break;
            case REPLACE:
                this.overrideValue = f;
                break;
            case MOLANG:
                this.overrideValue = f;
                optionalMolang.ifPresent(molang -> {
                    try {
                        this.overrideValue = Float.valueOf(getEnvironment().get().resolve((MolangExpression) molang.getFirst()));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
                break;
        }
    }

    @Override // foundry.veil.api.client.property.Property
    protected void setQueries(MolangRuntime.Builder builder) {
        super.setQueries(builder);
        builder.setQuery("v", () -> {
            return (Float) this.overrideValue;
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // foundry.veil.api.client.property.Property
    public Float cloneValue(Float value) {
        return value;
    }
}
