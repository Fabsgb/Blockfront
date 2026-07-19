package foundry.veil.api.client.property.properties;

import com.mojang.blaze3d.shaders.Uniform;
import foundry.veil.api.client.property.ImmutableProperty;
import foundry.veil.api.client.property.Property;
import foundry.veil.api.client.registry.PropertyRegistry;
import foundry.veil.api.flare.modifier.PropertyModifier;
import gg.moonflower.molangcompiler.api.MolangExpression;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.util.RandomSource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/property/properties/RandomFloatProperty.class */
@ImmutableProperty
public class RandomFloatProperty extends Property<Float> {
    private final RandomSource randomSource;
    public static final RandomFloatProperty INSTANCE = new RandomFloatProperty();

    @Override // foundry.veil.api.client.property.Property
    public /* bridge */ /* synthetic */ void modify(Float f, PropertyModifier.PropertyModifierMode propertyModifierMode, Optional optional) {
        modify2(f, propertyModifierMode, (Optional<List<MolangExpression>>) optional);
    }

    private RandomFloatProperty() {
        super(PropertyRegistry.FLOAT.get(), Float.valueOf(0.0f));
        this.randomSource = RandomSource.create(10841L);
    }

    @Override // foundry.veil.api.client.property.Property
    public void applyValue(String name, ShaderInstance shader) {
        Uniform uniform = shader.getUniform(name);
        if (uniform != null) {
            uniform.set(this.randomSource.nextFloat());
        }
    }

    /* JADX INFO: renamed from: modify, reason: avoid collision after fix types in other method */
    public void modify2(Float value, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // foundry.veil.api.client.property.Property
    public Float cloneValue(Float value) {
        return value;
    }
}
