package foundry.veil.api.client.property.properties;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.property.Property;
import foundry.veil.api.client.registry.PropertyRegistry;
import foundry.veil.api.flare.modifier.PropertyModifier;
import gg.moonflower.molangcompiler.api.MolangExpression;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/property/properties/Sampler2DProperty.class */
public class Sampler2DProperty extends Property<AbstractTexture> {
    private final ResourceLocation source;
    public static final MapCodec<Sampler2DProperty> CODEC = ResourceLocation.CODEC.fieldOf("value").xmap(Sampler2DProperty::new, property -> {
        return property.source;
    });

    @Override // foundry.veil.api.client.property.Property
    public /* bridge */ /* synthetic */ void modify(AbstractTexture abstractTexture, PropertyModifier.PropertyModifierMode propertyModifierMode, Optional optional) {
        modify2(abstractTexture, propertyModifierMode, (Optional<List<MolangExpression>>) optional);
    }

    public Sampler2DProperty(ResourceLocation value) {
        super(PropertyRegistry.SAMPLER2D.get(), null);
        this.source = value;
    }

    @Override // foundry.veil.api.client.property.Property
    public void applyValue(String name, ShaderInstance shader) {
        shader.setSampler(name, Integer.valueOf(Minecraft.getInstance().getTextureManager().getTexture(this.source).getId()));
        shader.apply();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: modify, reason: avoid collision after fix types in other method */
    public void modify2(AbstractTexture abstractTexture, PropertyModifier.PropertyModifierMode mode, Optional<List<MolangExpression>> optionalMolang) {
        this.overrideValue = abstractTexture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // foundry.veil.api.client.property.Property
    public AbstractTexture cloneValue(AbstractTexture value) {
        return value;
    }
}
