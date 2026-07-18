package foundry.veil.api.flare.modifier.modifiers;

import foundry.veil.api.client.registry.PropertyModifierRegistry;
import foundry.veil.api.flare.data.FloatCurve;
import foundry.veil.api.flare.modifier.Controller;
import foundry.veil.api.flare.modifier.PropertyModifier;
import gg.moonflower.molangcompiler.api.MolangExpression;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/modifier/modifiers/FloatPropertyModifier.class */
public class FloatPropertyModifier extends PropertyModifier<Float> {
    public final FloatCurve curve;

    public FloatPropertyModifier(String name, String clazz, String inputControllerName, String outputPropertyName, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang, FloatCurve curve) {
        super(PropertyModifierRegistry.FLOAT.get(), name, clazz, inputControllerName, outputPropertyName, mode, optionalMolang);
        this.curve = curve;
    }

    public FloatCurve getCurve() {
        return this.curve;
    }

    @Override // foundry.veil.api.flare.modifier.PropertyModifier
    public Float get(Controller controller) {
        return Float.valueOf(this.curve.evaluate(controller.getValue()));
    }
}
