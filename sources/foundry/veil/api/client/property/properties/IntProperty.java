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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/property/properties/IntProperty.class */
public class IntProperty extends Property<Integer> {
    @Override // foundry.veil.api.client.property.Property
    public /* bridge */ /* synthetic */ void modify(Integer num, PropertyModifier.PropertyModifierMode propertyModifierMode, Optional optional) {
        modify2(num, propertyModifierMode, (Optional<List<MolangExpression>>) optional);
    }

    public IntProperty(int value) {
        super(PropertyRegistry.INT.get(), Integer.valueOf(value));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // foundry.veil.api.client.property.Property
    public void applyValue(String name, ShaderInstance shader) {
        Uniform uniform = shader.getUniform(name);
        if (uniform != null) {
            uniform.set(((Integer) this.overrideValue).intValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v17, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v23, types: [T, java.lang.Integer] */
    /* JADX INFO: renamed from: modify, reason: avoid collision after fix types in other method */
    public void modify2(Integer num, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang) {
        switch (mode) {
            case ADD:
                this.overrideValue = Integer.valueOf(((Integer) this.overrideValue).intValue() + num.intValue());
                break;
            case SUBTRACT:
                this.overrideValue = Integer.valueOf(((Integer) this.overrideValue).intValue() - num.intValue());
                break;
            case MULTIPLY:
                this.overrideValue = Integer.valueOf(((Integer) this.overrideValue).intValue() * num.intValue());
                break;
            case REPLACE:
                this.overrideValue = num;
                break;
            case MOLANG:
                this.overrideValue = num;
                optionalMolang.ifPresent(molang -> {
                    try {
                        this.overrideValue = Integer.valueOf((int) getEnvironment().get().resolve((MolangExpression) molang.getFirst()));
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
            return Float.valueOf(((Integer) this.overrideValue).intValue());
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // foundry.veil.api.client.property.Property
    public Integer cloneValue(Integer value) {
        return value;
    }
}
