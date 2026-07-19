package foundry.veil.api.client.property.properties;

import com.mojang.blaze3d.shaders.Uniform;
import foundry.veil.api.client.property.Property;
import foundry.veil.api.client.registry.PropertyRegistry;
import foundry.veil.api.flare.modifier.PropertyModifier;
import gg.moonflower.molangcompiler.api.MolangEnvironment;
import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.MolangRuntime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.client.renderer.ShaderInstance;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/property/properties/Vec3Property.class */
public class Vec3Property extends Property<Vector3f> {
    @Override // foundry.veil.api.client.property.Property
    public /* bridge */ /* synthetic */ void modify(Vector3f vector3f, PropertyModifier.PropertyModifierMode propertyModifierMode, Optional optional) {
        modify(vector3f, propertyModifierMode, (Optional<List<MolangExpression>>) optional);
    }

    public Vec3Property(Vector3fc value) {
        super(PropertyRegistry.VEC3.get(), new Vector3f(value));
    }

    @Override // foundry.veil.api.client.property.Property
    public void applyValue(String name, ShaderInstance shader) {
        Uniform uniform = shader.getUniform(name);
        if (uniform != null) {
            uniform.set(((Vector3f) this.overrideValue).x, ((Vector3f) this.overrideValue).y, ((Vector3f) this.overrideValue).z);
        }
    }

    @Override // foundry.veil.api.client.property.Property
    protected void setQueries(MolangRuntime.Builder builder) {
        super.setQueries(builder);
        Vector3f vector3f = (Vector3f) this.overrideValue;
        Objects.requireNonNull(vector3f);
        builder.setQuery("x", vector3f::x);
        Vector3f vector3f2 = (Vector3f) this.overrideValue;
        Objects.requireNonNull(vector3f2);
        builder.setQuery("y", vector3f2::y);
        Vector3f vector3f3 = (Vector3f) this.overrideValue;
        Objects.requireNonNull(vector3f3);
        builder.setQuery("z", vector3f3::z);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    public void modify(Vector3f value, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang) {
        switch (mode) {
            case ADD:
                ((Vector3f) this.overrideValue).add(value);
                break;
            case SUBTRACT:
                ((Vector3f) this.overrideValue).sub(value);
                break;
            case MULTIPLY:
                ((Vector3f) this.overrideValue).mul(value);
                break;
            case REPLACE:
                ((Vector3f) this.overrideValue).set(value);
                break;
            case MOLANG:
                ((Vector3f) this.overrideValue).set(value);
                optionalMolang.ifPresent(molang -> {
                    MolangEnvironment environment = getEnvironment().get();
                    if (!molang.isEmpty()) {
                        ((Vector3f) this.overrideValue).x = environment.safeResolve((MolangExpression) molang.getFirst());
                    }
                    if (molang.size() > 1) {
                        ((Vector3f) this.overrideValue).y = environment.safeResolve((MolangExpression) molang.get(1));
                    }
                    if (molang.size() > 2) {
                        ((Vector3f) this.overrideValue).z = environment.safeResolve((MolangExpression) molang.get(2));
                    }
                });
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // foundry.veil.api.client.property.Property
    public Vector3f cloneValue(Vector3f value) {
        return new Vector3f(value);
    }
}
