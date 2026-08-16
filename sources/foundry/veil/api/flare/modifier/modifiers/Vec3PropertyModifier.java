package foundry.veil.api.flare.modifier.modifiers;

import foundry.veil.api.client.registry.PropertyModifierRegistry;
import foundry.veil.api.flare.data.FloatCurve;
import foundry.veil.api.flare.modifier.Controller;
import foundry.veil.api.flare.modifier.PropertyModifier;
import gg.moonflower.molangcompiler.api.MolangExpression;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/flare/modifier/modifiers/Vec3PropertyModifier.class */
public class Vec3PropertyModifier extends PropertyModifier<Vector3fc> {
    protected final List<FloatCurve> curveList;
    protected final Vector3f dummy;
    public final FloatCurve curveX;
    public final FloatCurve curveY;
    public final FloatCurve curveZ;

    public Vec3PropertyModifier(String name, String clazz, String inputControllerName, String outputPropertyName, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang, List<FloatCurve> curveList) {
        super(PropertyModifierRegistry.VEC3.get(), name, clazz, inputControllerName, outputPropertyName, mode, optionalMolang);
        this.dummy = new Vector3f();
        this.curveList = curveList;
        this.curveX = !curveList.isEmpty() ? curveList.get(0) : FloatCurve.ZERO;
        this.curveY = curveList.size() > 1 ? curveList.get(1) : FloatCurve.ZERO;
        this.curveZ = curveList.size() > 2 ? curveList.get(2) : FloatCurve.ZERO;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // foundry.veil.api.flare.modifier.PropertyModifier
    public Vector3fc get(Controller controller) {
        float value = controller.getValue();
        this.dummy.x = this.curveX.evaluate(value);
        this.dummy.y = this.curveY.evaluate(value);
        this.dummy.z = this.curveZ.evaluate(value);
        return this.dummy;
    }

    public List<FloatCurve> getCurves() {
        return new ArrayList(this.curveList);
    }
}
