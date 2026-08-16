package foundry.veil.api.flare.modifier.modifiers;

import foundry.veil.api.client.registry.PropertyModifierRegistry;
import foundry.veil.api.flare.data.FloatCurve;
import foundry.veil.api.flare.modifier.Controller;
import foundry.veil.api.flare.modifier.PropertyModifier;
import gg.moonflower.molangcompiler.api.MolangExpression;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.jetbrains.annotations.Contract;
import org.joml.Vector2f;
import org.joml.Vector2fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/flare/modifier/modifiers/Vec2PropertyModifier.class */
public class Vec2PropertyModifier extends PropertyModifier<Vector2fc> {
    protected final List<FloatCurve> curveList;
    protected final Vector2f dummy;
    public final FloatCurve curveX;
    public final FloatCurve curveY;

    public Vec2PropertyModifier(String name, String clazz, String inputControllerName, String outputPropertyName, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang, List<FloatCurve> curveList) {
        super(PropertyModifierRegistry.VEC2.get(), name, clazz, inputControllerName, outputPropertyName, mode, optionalMolang);
        this.dummy = new Vector2f();
        this.curveList = curveList;
        this.curveX = !curveList.isEmpty() ? curveList.get(0) : FloatCurve.ZERO;
        this.curveY = curveList.size() > 1 ? curveList.get(1) : FloatCurve.ZERO;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // foundry.veil.api.flare.modifier.PropertyModifier
    public Vector2fc get(Controller controller) {
        float value = controller.getValue();
        this.dummy.x = this.curveX.evaluate(value);
        this.dummy.y = this.curveY.evaluate(value);
        return this.dummy;
    }

    @Contract(value = "->new", pure = true)
    public List<FloatCurve> getCurves() {
        return new ArrayList(this.curveList);
    }
}
