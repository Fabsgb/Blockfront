package foundry.veil.api.client.property.properties;

import com.mojang.blaze3d.shaders.Uniform;
import foundry.veil.api.client.property.ImmutableProperty;
import foundry.veil.api.client.property.Property;
import foundry.veil.api.client.registry.PropertyRegistry;
import foundry.veil.api.flare.modifier.PropertyModifier;
import gg.moonflower.molangcompiler.api.MolangExpression;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.util.Mth;
import org.joml.Vector4f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/property/properties/TimeProperty.class */
@ImmutableProperty
public class TimeProperty extends Property<Vector4f> {
    public static final TimeProperty INSTANCE = new TimeProperty();

    @Override // foundry.veil.api.client.property.Property
    public /* bridge */ /* synthetic */ void modify(Vector4f vector4f, PropertyModifier.PropertyModifierMode propertyModifierMode, Optional optional) {
        modify2(vector4f, propertyModifierMode, (Optional<List<MolangExpression>>) optional);
    }

    private TimeProperty() {
        super(PropertyRegistry.VEC4.get(), new Vector4f());
    }

    @Override // foundry.veil.api.client.property.Property
    public void applyValue(String name, ShaderInstance shader) {
        Uniform uniform = shader.getUniform(name);
        if (uniform != null) {
            float time = System.nanoTime() * 1.0E-9f;
            uniform.set(((Vector4f) this.value).set(time / 20.0f, time, 2.0f * time, Mth.sin(time % 6.2831855f)));
        }
    }

    /* JADX INFO: renamed from: modify, reason: avoid collision after fix types in other method */
    public void modify2(Vector4f value, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // foundry.veil.api.client.property.Property
    public Vector4f cloneValue(Vector4f value) {
        return new Vector4f(value);
    }
}
