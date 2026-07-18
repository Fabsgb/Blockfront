package foundry.veil.api.client.property.properties;

import com.mojang.blaze3d.shaders.Uniform;
import foundry.veil.api.client.property.InvertibleProperty;
import foundry.veil.api.client.registry.PropertyRegistry;
import foundry.veil.api.flare.modifier.PropertyModifier;
import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.MolangRuntime;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.renderer.ShaderInstance;
import org.jetbrains.annotations.Contract;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/property/properties/Mat3Property.class */
public class Mat3Property extends InvertibleProperty<Matrix3f> {
    @Override // foundry.veil.api.client.property.InvertibleProperty
    public /* bridge */ /* synthetic */ void modifyPreInvert(Matrix3f matrix3f, PropertyModifier.PropertyModifierMode propertyModifierMode, Optional optional) {
        modifyPreInvert2(matrix3f, propertyModifierMode, (Optional<List<MolangExpression>>) optional);
    }

    public Mat3Property(Matrix3fc value) {
        super(PropertyRegistry.MAT3.get(), new Matrix3f(value));
    }

    @Override // foundry.veil.api.client.property.Property
    public void applyValue(String name, ShaderInstance shader) {
        Uniform uniform = shader.getUniform(name);
        if (uniform != null) {
            uniform.set((Matrix3f) this.overrideValue);
        }
    }

    @Override // foundry.veil.api.client.property.Property
    protected void setQueries(MolangRuntime.Builder builder) {
        super.setQueries(builder);
    }

    /* JADX INFO: renamed from: modifyPreInvert, reason: avoid collision after fix types in other method */
    public void modifyPreInvert2(Matrix3f value, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang) {
        switch (mode) {
            case ADD:
                ((Matrix3f) this.overrideValue).add(value);
                break;
            case SUBTRACT:
                ((Matrix3f) this.overrideValue).sub(value);
                break;
            case MULTIPLY:
                ((Matrix3f) this.overrideValue).mul(value);
                break;
            case REPLACE:
            case MOLANG:
                ((Matrix3f) this.overrideValue).set(value);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // foundry.veil.api.client.property.Property
    public Matrix3f cloneValue(Matrix3f value) {
        return new Matrix3f(value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // foundry.veil.api.client.property.InvertibleProperty
    @Contract(mutates = "param")
    public Matrix3f invertAndMutate(Matrix3f value) {
        return value.invert();
    }
}
