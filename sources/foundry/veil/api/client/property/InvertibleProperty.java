package foundry.veil.api.client.property;

import foundry.veil.api.client.registry.PropertyRegistry;
import foundry.veil.api.flare.modifier.PropertyModifier;
import gg.moonflower.molangcompiler.api.MolangExpression;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.renderer.ShaderInstance;
import org.jetbrains.annotations.Contract;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/property/InvertibleProperty.class */
public abstract class InvertibleProperty<T> extends Property<T> {
    protected T overrideInverseValue;
    private final T inverseValue;

    @Contract(mutates = "param")
    protected abstract T invertAndMutate(T t);

    public abstract void modifyPreInvert(T t, PropertyModifier.PropertyModifierMode propertyModifierMode, Optional<List<MolangExpression>> optional);

    public InvertibleProperty(PropertyRegistry.PropertyType<T, ?> propertyType, T t) {
        super(propertyType, t);
        this.inverseValue = invertAndMutate(cloneValue(t));
        this.overrideInverseValue = cloneValue(this.inverseValue);
    }

    @Override // foundry.veil.api.client.property.Property
    public final void modify(T value, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang) {
        modifyPreInvert(value, mode, optionalMolang);
        T originalOverrideValue = this.overrideValue;
        this.overrideValue = this.overrideInverseValue;
        modifyPreInvert(originalOverrideValue, PropertyModifier.PropertyModifierMode.REPLACE, Optional.empty());
        this.overrideValue = originalOverrideValue;
        invertAndMutate(this.overrideInverseValue);
    }

    public void applyInverseValue(String name, ShaderInstance shader) {
        T originalOverrideValue = this.overrideValue;
        this.overrideValue = this.overrideInverseValue;
        applyValue("I" + name, shader);
        this.overrideValue = originalOverrideValue;
    }

    @Override // foundry.veil.api.client.property.Property
    public void resetOverrideValue() {
        modifyPreInvert(this.value, PropertyModifier.PropertyModifierMode.REPLACE, Optional.empty());
        T originalOverrideValue = this.overrideValue;
        this.overrideValue = this.overrideInverseValue;
        modifyPreInvert(this.inverseValue, PropertyModifier.PropertyModifierMode.REPLACE, Optional.empty());
        this.overrideValue = originalOverrideValue;
    }
}
