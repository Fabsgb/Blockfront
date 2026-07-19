package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderStateShard;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/rendertype/layer/TexturingLayer.class */
public final class TexturingLayer extends Record implements RenderTypeLayer {
    private final float scale;
    public static final MapCodec<TexturingLayer> CODEC = Codec.FLOAT.fieldOf("scale").xmap((v1) -> {
        return new TexturingLayer(v1);
    }, (v0) -> {
        return v0.scale();
    });
    private static final Matrix4f MATRIX = new Matrix4f();

    public TexturingLayer(float scale) {
        this.scale = scale;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, TexturingLayer.class), TexturingLayer.class, "scale", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TexturingLayer;->scale:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, TexturingLayer.class), TexturingLayer.class, "scale", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TexturingLayer;->scale:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, TexturingLayer.class, Object.class), TexturingLayer.class, "scale", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TexturingLayer;->scale:F").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public float scale() {
        return this.scale;
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) {
        if (this.scale != 1.0f) {
            builder.texturingState(new RenderStateShard.TexturingStateShard("veil:glint_texturing", () -> {
                long time = (long) (Util.getMillis() * ((Double) Minecraft.getInstance().options.glintSpeed().get()).doubleValue() * 8.0d);
                float x = (time % 110000) / 110000.0f;
                float y = (time % 30000) / 30000.0f;
                MATRIX.setTranslation(-x, y, 0.0f);
                MATRIX.rotateZ(0.17453292f).scale(this.scale);
                RenderSystem.setTextureMatrix(MATRIX);
            }, RenderSystem::resetTextureMatrix));
        }
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.TEXTURING.get();
    }
}
