package foundry.veil.api.flare.modifier.modifiers;

import foundry.veil.api.client.registry.PropertyModifierRegistry;
import foundry.veil.api.flare.data.FloatCurve;
import foundry.veil.api.flare.modifier.Controller;
import foundry.veil.api.flare.modifier.PropertyModifier;
import gg.moonflower.molangcompiler.api.MolangExpression;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.joml.Vector4f;
import org.joml.Vector4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/modifier/modifiers/Vec4PropertyModifier.class */
public class Vec4PropertyModifier extends PropertyModifier<Vector4fc> {
    protected final List<FloatCurve> curveList;
    protected final Vector4f dummy;
    public final FloatCurve curveX;
    public final FloatCurve curveY;
    public final FloatCurve curveZ;
    public final FloatCurve curveW;

    public Vec4PropertyModifier(String name, String clazz, String inputControllerName, String outputPropertyName, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang, List<FloatCurve> curveList) {
        super(PropertyModifierRegistry.VEC4.get(), name, clazz, inputControllerName, outputPropertyName, mode, optionalMolang);
        this.dummy = new Vector4f();
        this.curveList = curveList;
        this.curveX = !curveList.isEmpty() ? curveList.get(0) : FloatCurve.ZERO;
        this.curveY = curveList.size() > 1 ? curveList.get(1) : FloatCurve.ZERO;
        this.curveZ = curveList.size() > 2 ? curveList.get(2) : FloatCurve.ZERO;
        this.curveW = curveList.size() > 3 ? curveList.get(3) : FloatCurve.ZERO;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // foundry.veil.api.flare.modifier.PropertyModifier
    public Vector4fc get(Controller controller) {
        float value = controller.getValue();
        this.dummy.x = this.curveX.evaluate(value);
        this.dummy.y = this.curveY.evaluate(value);
        this.dummy.z = this.curveZ.evaluate(value);
        this.dummy.w = this.curveW.evaluate(value);
        return this.dummy;
    }

    public List<FloatCurve> getCurves() {
        return new ArrayList(this.curveList);
    }
}
