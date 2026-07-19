package foundry.veil.api.client.property.model;

import foundry.veil.api.client.property.InapplicableProperty;
import foundry.veil.api.client.property.ModelProperty;
import foundry.veil.api.client.property.properties.Vec3Property;
import net.minecraft.client.renderer.ShaderInstance;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/property/model/Vec3ModelProperty.class */
@ModelProperty
@InapplicableProperty
public class Vec3ModelProperty extends Vec3Property {
    public Vec3ModelProperty(Vector3f value) {
        super(value);
    }

    public Vector3fc getValue() {
        return (Vector3fc) this.overrideValue;
    }

    @Override // foundry.veil.api.client.property.properties.Vec3Property, foundry.veil.api.client.property.Property
    public void applyValue(String name, ShaderInstance shader) {
        throw new UnsupportedOperationException();
    }
}
