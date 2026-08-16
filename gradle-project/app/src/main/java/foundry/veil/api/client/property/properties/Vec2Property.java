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
import org.joml.Vector2f;
import org.joml.Vector2fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/property/properties/Vec2Property.class */
public class Vec2Property extends Property<Vector2f> {
    @Override // foundry.veil.api.client.property.Property
    public /* bridge */ /* synthetic */ void modify(Vector2f vector2f, PropertyModifier.PropertyModifierMode propertyModifierMode, Optional optional) {
        modify2(vector2f, propertyModifierMode, (Optional<List<MolangExpression>>) optional);
    }

    public Vec2Property(Vector2fc value) {
        super(PropertyRegistry.VEC2.get(), new Vector2f(value));
    }

    @Override // foundry.veil.api.client.property.Property
    public void applyValue(String name, ShaderInstance shader) {
        Uniform uniform = shader.getUniform(name);
        if (uniform != null) {
            uniform.set(((Vector2f) this.overrideValue).x, ((Vector2f) this.overrideValue).y);
        }
    }

    @Override // foundry.veil.api.client.property.Property
    protected void setQueries(MolangRuntime.Builder builder) {
        super.setQueries(builder);
        Vector2f vector2f = (Vector2f) this.overrideValue;
        Objects.requireNonNull(vector2f);
        builder.setQuery("x", vector2f::x);
        Vector2f vector2f2 = (Vector2f) this.overrideValue;
        Objects.requireNonNull(vector2f2);
        builder.setQuery("y", vector2f2::y);
    }

    /* JADX INFO: renamed from: modify, reason: avoid collision after fix types in other method */
    public void modify2(Vector2f value, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang) {
        switch (mode) {
            case ADD:
                ((Vector2f) this.overrideValue).add(value);
                break;
            case SUBTRACT:
                ((Vector2f) this.overrideValue).sub(value);
                break;
            case MULTIPLY:
                ((Vector2f) this.overrideValue).mul(value);
                break;
            case REPLACE:
                ((Vector2f) this.overrideValue).set(value);
                break;
            case MOLANG:
                ((Vector2f) this.overrideValue).set(value);
                optionalMolang.ifPresent(molang -> {
                    MolangEnvironment environment = getEnvironment().get();
                    if (!molang.isEmpty()) {
                        ((Vector2f) this.overrideValue).x = environment.safeResolve((MolangExpression) molang.getFirst());
                    }
                    if (molang.size() > 1) {
                        ((Vector2f) this.overrideValue).y = environment.safeResolve((MolangExpression) molang.get(1));
                    }
                });
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // foundry.veil.api.client.property.Property
    public Vector2f cloneValue(Vector2f value) {
        return new Vector2f(value);
    }
}
