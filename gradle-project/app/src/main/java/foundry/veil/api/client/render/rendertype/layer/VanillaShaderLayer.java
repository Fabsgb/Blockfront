package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.ResourceLocationException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderStateShard;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/rendertype/layer/VanillaShaderLayer.class */
public final class VanillaShaderLayer extends Record implements RenderTypeLayer {
    private final LayerTemplateValue<String> shaderName;
    public static final MapCodec<VanillaShaderLayer> CODEC = LayerTemplateValue.STRING_CODEC.fieldOf("name").xmap(VanillaShaderLayer::new, (v0) -> {
        return v0.shaderName();
    });

    public VanillaShaderLayer(LayerTemplateValue<String> shaderName) {
        this.shaderName = shaderName;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, VanillaShaderLayer.class), VanillaShaderLayer.class, "shaderName", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/VanillaShaderLayer;->shaderName:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, VanillaShaderLayer.class), VanillaShaderLayer.class, "shaderName", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/VanillaShaderLayer;->shaderName:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, VanillaShaderLayer.class, Object.class), VanillaShaderLayer.class, "shaderName", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/VanillaShaderLayer;->shaderName:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public LayerTemplateValue<String> shaderName() {
        return this.shaderName;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: net.minecraft.ResourceLocationException */
    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) throws ResourceLocationException {
        String shaderId = this.shaderName.parse(params);
        builder.shaderState(new RenderStateShard.ShaderStateShard(() -> {
            return Minecraft.getInstance().gameRenderer.getShader(shaderId);
        }));
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.VANILLA_SHADER.get();
    }
}
