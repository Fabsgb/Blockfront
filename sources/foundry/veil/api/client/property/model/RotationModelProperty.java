package foundry.veil.api.client.property.model;

import foundry.veil.api.client.property.InapplicableProperty;
import foundry.veil.api.client.property.ModelProperty;
import foundry.veil.api.flare.modifier.PropertyModifier;
import gg.moonflower.molangcompiler.api.MolangExpression;
import java.util.List;
import java.util.Optional;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/property/model/RotationModelProperty.class */
@ModelProperty
@InapplicableProperty
public class RotationModelProperty extends Vec3ModelProperty {
    private final Quaternionfc rotation;
    private final Quaternionf overrideRotation;

    @Override // foundry.veil.api.client.property.properties.Vec3Property, foundry.veil.api.client.property.Property
    public /* bridge */ /* synthetic */ void modify(Vector3f vector3f, PropertyModifier.PropertyModifierMode propertyModifierMode, Optional optional) {
        modify(vector3f, propertyModifierMode, (Optional<List<MolangExpression>>) optional);
    }

    public RotationModelProperty(Vector3f value) {
        super(value);
        this.rotation = new Quaternionf().rotationXYZ(value.x() * 0.017453292f, value.y() * 0.017453292f, value.z() * 0.017453292f);
        this.overrideRotation = new Quaternionf(this.rotation);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // foundry.veil.api.client.property.properties.Vec3Property
    public void modify(Vector3f value, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang) {
        super.modify(value, mode, optionalMolang);
        this.overrideRotation.rotationXYZ(((Vector3f) this.overrideValue).x() * 0.017453292f, ((Vector3f) this.overrideValue).y() * 0.017453292f, ((Vector3f) this.overrideValue).z() * 0.017453292f);
    }

    public Quaternionfc getRotation() {
        return this.overrideRotation;
    }

    @Override // foundry.veil.api.client.property.Property
    public void resetOverrideValue() {
        super.resetOverrideValue();
        this.overrideRotation.set(this.rotation);
    }
}
