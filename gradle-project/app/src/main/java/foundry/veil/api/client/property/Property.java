package foundry.veil.api.client.property;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.PropertyRegistry;
import foundry.veil.api.flare.modifier.PropertyModifier;
import gg.moonflower.molangcompiler.api.MolangEnvironment;
import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.MolangRuntime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.client.renderer.ShaderInstance;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/property/Property.class */
public abstract class Property<T> {
    protected T overrideValue;
    protected final T value;
    private final PropertyRegistry.PropertyType<T, ? extends Property<T>> type;
    private final Supplier<MolangEnvironment> environment = Suppliers.memoize(() -> {
        MolangRuntime.Builder builder = MolangRuntime.runtime();
        setQueries(builder);
        return builder.create();
    });

    public abstract void applyValue(String str, ShaderInstance shaderInstance);

    public abstract void modify(T t, PropertyModifier.PropertyModifierMode propertyModifierMode, Optional<List<MolangExpression>> optional);

    protected abstract T cloneValue(T t);

    public Property(PropertyRegistry.PropertyType<T, ? extends Property<T>> type, T value) {
        this.type = type;
        this.value = value;
        this.overrideValue = cloneValue(value);
    }

    protected void setQueries(MolangRuntime.Builder builder) {
    }

    public void resetOverrideValue() {
        modify(this.value, PropertyModifier.PropertyModifierMode.REPLACE, Optional.empty());
    }

    public PropertyRegistry.PropertyType<T, ? extends Property<T>> getType() {
        return this.type;
    }

    public static <T, M extends Property<T>> MapCodec<M> codec(PropertyRegistry.PropertyType<T, M> type) {
        return type.codec();
    }

    public static <T, M extends Property<T>> MapCodec<M> createCodec(Function<T, M> factory, Codec<T> typeCodec) {
        return typeCodec.fieldOf("value").xmap(factory, property -> {
            return property.value;
        });
    }

    public Supplier<MolangEnvironment> getEnvironment() {
        return this.environment;
    }
}
