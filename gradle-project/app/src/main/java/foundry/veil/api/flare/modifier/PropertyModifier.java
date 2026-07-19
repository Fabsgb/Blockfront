package foundry.veil.api.flare.modifier;

import com.mojang.datafixers.util.Function6;
import com.mojang.datafixers.util.Function7;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.Veil;
import foundry.veil.api.client.property.ImmutableProperty;
import foundry.veil.api.client.property.Property;
import foundry.veil.api.client.registry.PropertyModifierRegistry;
import foundry.veil.api.flare.EffectHost;
import foundry.veil.api.flare.FlareEffectManager;
import foundry.veil.api.molang.MolangExpressionCodec;
import gg.moonflower.molangcompiler.api.MolangExpression;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/modifier/PropertyModifier.class */
public abstract class PropertyModifier<T> {
    private final PropertyModifierRegistry.PropertyModifierType<T, ?> type;
    private final String name;
    private final String clazz;
    private final String inputControllerName;
    private final PropertyModifierMode mode;
    private final String outputPropertyName;
    private final Optional<List<MolangExpression>> optionalMolang;

    public abstract T get(Controller controller);

    public PropertyModifier(PropertyModifierRegistry.PropertyModifierType<T, ?> type, String name, @Nullable String clazz, String inputControllerName, String outputPropertyName, PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang) {
        this.type = type;
        this.name = name;
        this.clazz = clazz;
        this.inputControllerName = inputControllerName;
        this.mode = mode;
        this.outputPropertyName = outputPropertyName;
        this.optionalMolang = optionalMolang;
    }

    public <A> void apply(@NotNull EffectHost host, Property<A> property) {
        ControllerManager controllerManager = FlareEffectManager.getInstance().getControllerManager();
        Controller controller = controllerManager.getOrCreateController(this.inputControllerName, host);
        try {
            property.modify(get(controller), this.mode, this.optionalMolang);
        } catch (Exception e) {
            Veil.LOGGER.error("Could not modify property {} for controller {}", this.outputPropertyName, this.inputControllerName);
        }
    }

    public String name() {
        return this.name;
    }

    @Nullable
    public String clazz() {
        return this.clazz;
    }

    public Optional<String> optionalClazz() {
        return Optional.ofNullable(this.clazz);
    }

    public String inputControllerName() {
        return this.inputControllerName;
    }

    public PropertyModifierMode mode() {
        return this.mode;
    }

    @ApiStatus.Experimental
    public Optional<List<MolangExpression>> molangExpressions() {
        return this.optionalMolang;
    }

    public String outputPropertyName() {
        return this.outputPropertyName;
    }

    public PropertyModifierRegistry.PropertyModifierType<T, ?> type() {
        return this.type;
    }

    public Pair<Optional<List<MolangExpression>>, PropertyModifierMode> getPair() {
        return Pair.of(this.optionalMolang, this.mode);
    }

    private static PropertyModifierMode modeFromPair(Pair<Optional<List<MolangExpression>>, PropertyModifierMode> expression) {
        if (((Optional) expression.getFirst()).isPresent() && !((List) ((Optional) expression.getFirst()).get()).isEmpty()) {
            return PropertyModifierMode.MOLANG;
        }
        return (PropertyModifierMode) expression.getSecond();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MapCodec<? extends Pair<Optional<List<MolangExpression>>, PropertyModifierMode>> pairCodecFromMode(PropertyModifierMode mode, int size) {
        if (mode == PropertyModifierMode.MOLANG) {
            return Codec.mapPair(MolangExpressionCodec.CODEC.listOf(size, size).optionalFieldOf("molang"), MapCodec.unit(mode));
        }
        return MapCodec.unit(Pair.of(Optional.empty(), mode));
    }

    public static void modifyProperty(EffectHost host, @Nullable String clazz, Property<?> property, @Nullable Iterable<PropertyModifier<?>> modifiers) {
        if (modifiers == null || property.getClass().getAnnotation(ImmutableProperty.class) != null) {
            return;
        }
        for (PropertyModifier<?> modifier : modifiers) {
            if (clazz == null || ((PropertyModifier) modifier).clazz == null || ((PropertyModifier) modifier).clazz.equals(clazz)) {
                modifier.apply(host, property);
            }
        }
    }

    public static <A, T extends PropertyModifier<A>> MapCodec<T> createCodec(Function6<String, String, String, String, PropertyModifierMode, Optional<List<MolangExpression>>, T> factory, int molangSize) {
        return RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
                return v0.name();
            }), Codec.STRING.optionalFieldOf("class").forGetter((v0) -> {
                return v0.optionalClazz();
            }), Codec.STRING.fieldOf("controller").forGetter((v0) -> {
                return v0.inputControllerName();
            }), Codec.STRING.fieldOf("property").forGetter((v0) -> {
                return v0.outputPropertyName();
            }), StringRepresentable.fromValues(PropertyModifierMode::values).dispatchMap("mode", PropertyModifier::modeFromPair, mode -> {
                return pairCodecFromMode(mode, molangSize);
            }).forGetter((v0) -> {
                return v0.getPair();
            })).apply(instance, (name, clazz, controller, property, pair) -> {
                return (PropertyModifier) factory.apply(name, (String) clazz.orElse(null), controller, property, (PropertyModifierMode) pair.getSecond(), (Optional) pair.getFirst());
            });
        });
    }

    public static <A, T extends PropertyModifier<A>, O> MapCodec<T> createCodec(Function7<String, String, String, String, PropertyModifierMode, Optional<List<MolangExpression>>, O, T> factory, Function<T, O> supplier, MapCodec<O> additionalCodec, int molangSize) {
        return RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
                return v0.name();
            }), Codec.STRING.optionalFieldOf("class").forGetter((v0) -> {
                return v0.optionalClazz();
            }), Codec.STRING.fieldOf("controller").forGetter((v0) -> {
                return v0.inputControllerName();
            }), Codec.STRING.fieldOf("property").forGetter((v0) -> {
                return v0.outputPropertyName();
            }), StringRepresentable.fromValues(PropertyModifierMode::values).dispatchMap("mode", PropertyModifier::modeFromPair, mode -> {
                return pairCodecFromMode(mode, molangSize);
            }).forGetter((v0) -> {
                return v0.getPair();
            }), additionalCodec.forGetter(supplier)).apply(instance, (name, clazz, controller, property, pair, additionalInformation) -> {
                return (PropertyModifier) factory.apply(name, (String) clazz.orElse(null), controller, property, (PropertyModifierMode) pair.getSecond(), (Optional) pair.getFirst(), additionalInformation);
            });
        });
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/modifier/PropertyModifier$PropertyModifierMode.class */
    public enum PropertyModifierMode implements StringRepresentable {
        REPLACE("replace"),
        ADD("add"),
        SUBTRACT("subtract"),
        MULTIPLY("multiply"),
        MOLANG("molang");

        private final String name;

        PropertyModifierMode(String name) {
            this.name = name;
        }

        @NotNull
        public String getSerializedName() {
            return this.name;
        }
    }
}
