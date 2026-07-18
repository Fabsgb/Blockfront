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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/property/properties/BoolProperty.class */
public class BoolProperty extends Property<Boolean> {
    @Override // foundry.veil.api.client.property.Property
    public /* bridge */ /* synthetic */ void modify(Boolean bool, PropertyModifier.PropertyModifierMode propertyModifierMode, Optional optional) {
        modify2(bool, propertyModifierMode, (Optional<List<MolangExpression>>) optional);
    }

    public BoolProperty(boolean value) {
        super(PropertyRegistry.BOOL.get(), Boolean.valueOf(value));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // foundry.veil.api.client.property.Property
    public void applyValue(String name, ShaderInstance shader) {
        Uniform uniform = shader.getUniform(name);
        if (uniform != null) {
            uniform.set(((Boolean) this.overrideValue).booleanValue() ? 1 : 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: modify, reason: avoid collision after fix types in other method */
    public void modify2(Boolean bool, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang) {
        this.overrideValue = bool;
        if (mode == PropertyModifier.PropertyModifierMode.MOLANG) {
            optionalMolang.ifPresent(molang -> {
                try {
                    this.overrideValue = Boolean.valueOf(getEnvironment().get().resolve((MolangExpression) molang.getFirst()) >= 0.0f);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    @Override // foundry.veil.api.client.property.Property
    protected void setQueries(MolangRuntime.Builder builder) {
        super.setQueries(builder);
        builder.setQuery("v", () -> {
            return Float.valueOf(((Boolean) this.overrideValue).booleanValue() ? 1.0f : -1.0f);
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // foundry.veil.api.client.property.Property
    public Boolean cloneValue(Boolean value) {
        return value;
    }
}
