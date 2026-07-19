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
import org.joml.Vector4f;
import org.joml.Vector4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/property/properties/Vec4Property.class */
public class Vec4Property extends Property<Vector4f> {
    @Override // foundry.veil.api.client.property.Property
    public /* bridge */ /* synthetic */ void modify(Vector4f vector4f, PropertyModifier.PropertyModifierMode propertyModifierMode, Optional optional) {
        modify2(vector4f, propertyModifierMode, (Optional<List<MolangExpression>>) optional);
    }

    public Vec4Property(Vector4fc value) {
        super(PropertyRegistry.VEC4.get(), new Vector4f(value));
    }

    @Override // foundry.veil.api.client.property.Property
    public void applyValue(String name, ShaderInstance shader) {
        Uniform uniform = shader.getUniform(name);
        if (uniform != null) {
            uniform.set((Vector4f) this.overrideValue);
        }
    }

    @Override // foundry.veil.api.client.property.Property
    protected void setQueries(MolangRuntime.Builder builder) {
        super.setQueries(builder);
        Vector4f vector4f = (Vector4f) this.overrideValue;
        Objects.requireNonNull(vector4f);
        builder.setQuery("x", vector4f::x);
        Vector4f vector4f2 = (Vector4f) this.overrideValue;
        Objects.requireNonNull(vector4f2);
        builder.setQuery("y", vector4f2::y);
        Vector4f vector4f3 = (Vector4f) this.overrideValue;
        Objects.requireNonNull(vector4f3);
        builder.setQuery("z", vector4f3::z);
        Vector4f vector4f4 = (Vector4f) this.overrideValue;
        Objects.requireNonNull(vector4f4);
        builder.setQuery("w", vector4f4::w);
    }

    /* JADX INFO: renamed from: modify, reason: avoid collision after fix types in other method */
    public void modify2(Vector4f value, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang) {
        switch (mode) {
            case ADD:
                ((Vector4f) this.overrideValue).add(value);
                break;
            case SUBTRACT:
                ((Vector4f) this.overrideValue).sub(value);
                break;
            case MULTIPLY:
                ((Vector4f) this.overrideValue).mul(value);
                break;
            case REPLACE:
                ((Vector4f) this.overrideValue).set(value);
                break;
            case MOLANG:
                ((Vector4f) this.overrideValue).set(value);
                optionalMolang.ifPresent(molang -> {
                    MolangEnvironment environment = getEnvironment().get();
                    if (!molang.isEmpty()) {
                        ((Vector4f) this.overrideValue).x = environment.safeResolve((MolangExpression) molang.getFirst());
                    }
                    if (molang.size() > 1) {
                        ((Vector4f) this.overrideValue).y = environment.safeResolve((MolangExpression) molang.get(1));
                    }
                    if (molang.size() > 2) {
                        ((Vector4f) this.overrideValue).z = environment.safeResolve((MolangExpression) molang.get(2));
                    }
                    if (molang.size() > 2) {
                        ((Vector4f) this.overrideValue).z = environment.safeResolve((MolangExpression) molang.get(2));
                    }
                    if (molang.size() > 3) {
                        ((Vector4f) this.overrideValue).w = environment.safeResolve((MolangExpression) molang.get(3));
                    }
                });
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // foundry.veil.api.client.property.Property
    public Vector4f cloneValue(Vector4f value) {
        return new Vector4f(value);
    }
}
