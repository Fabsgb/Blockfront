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
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/property/properties/Mat4Property.class */
public class Mat4Property extends InvertibleProperty<Matrix4f> {
    @Override // foundry.veil.api.client.property.InvertibleProperty
    public /* bridge */ /* synthetic */ void modifyPreInvert(Matrix4f matrix4f, PropertyModifier.PropertyModifierMode propertyModifierMode, Optional optional) {
        modifyPreInvert2(matrix4f, propertyModifierMode, (Optional<List<MolangExpression>>) optional);
    }

    public Mat4Property(Matrix4fc value) {
        super(PropertyRegistry.MAT4.get(), new Matrix4f(value));
    }

    @Override // foundry.veil.api.client.property.Property
    public void applyValue(String name, ShaderInstance shader) {
        Uniform uniform = shader.getUniform(name);
        if (uniform != null) {
            uniform.set((Matrix4f) this.overrideValue);
        }
    }

    @Override // foundry.veil.api.client.property.Property
    protected void setQueries(MolangRuntime.Builder builder) {
        super.setQueries(builder);
    }

    /* JADX INFO: renamed from: modifyPreInvert, reason: avoid collision after fix types in other method */
    public void modifyPreInvert2(Matrix4f value, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang) {
        switch (mode) {
            case ADD:
                ((Matrix4f) this.overrideValue).add(value);
                break;
            case SUBTRACT:
                ((Matrix4f) this.overrideValue).sub(value);
                break;
            case MULTIPLY:
                ((Matrix4f) this.overrideValue).mul(value);
                break;
            case REPLACE:
            case MOLANG:
                ((Matrix4f) this.overrideValue).set(value);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // foundry.veil.api.client.property.Property
    public Matrix4f cloneValue(Matrix4f value) {
        return new Matrix4f(value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // foundry.veil.api.client.property.InvertibleProperty
    @Contract(mutates = "param")
    public Matrix4f invertAndMutate(Matrix4f value) {
        return value.invert();
    }
}
