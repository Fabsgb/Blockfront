package foundry.veil.impl.client.render.light;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.VertexFormat;
import foundry.veil.Veil;
import foundry.veil.api.client.render.light.data.PointLightData;
import foundry.veil.api.client.render.light.renderer.DDALightRenderer;
import foundry.veil.api.client.render.light.renderer.InstancedLightRenderer;
import foundry.veil.api.client.render.light.renderer.LightRenderHandle;
import foundry.veil.api.client.render.light.renderer.LightTypeRenderer;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.vertex.VertexArrayBuilder;
import java.util.List;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/light/InstancedPointLightRenderer.class */
@ApiStatus.Internal
public class InstancedPointLightRenderer extends InstancedLightRenderer<PointLightData> implements DDALightRenderer<PointLightData> {
    private static final ResourceLocation RENDER_TYPE = Veil.veilPath("light/point");

    public InstancedPointLightRenderer() {
        super(32);
    }

    @Override // foundry.veil.api.client.render.light.renderer.InstancedLightRenderer
    protected MeshData createMesh() {
        BufferBuilder builder = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION);
        LightTypeRenderer.createInvertedCube(builder);
        return builder.buildOrThrow();
    }

    @Override // foundry.veil.api.client.render.light.renderer.InstancedLightRenderer
    protected void setupBufferState(VertexArrayBuilder builder) {
        builder.setVertexAttribute(1, 2, 3, VertexArrayBuilder.DataType.FLOAT, false, 0);
        builder.setVertexAttribute(2, 2, 3, VertexArrayBuilder.DataType.FLOAT, false, 12);
        builder.setVertexAttribute(3, 2, 1, VertexArrayBuilder.DataType.FLOAT, false, 24);
        builder.setVertexAttribute(4, 2, 1, VertexArrayBuilder.DataType.FLOAT, false, 28);
    }

    @Override // foundry.veil.api.client.render.light.renderer.InstancedLightRenderer
    @Nullable
    protected RenderType getRenderType(List<? extends LightRenderHandle<PointLightData>> lights) {
        return VeilRenderType.get(RENDER_TYPE, new Object[0]);
    }

    @Override // foundry.veil.api.client.render.light.renderer.DDALightRenderer
    public void uploadVoxelGridUniforms(int voxelGridTexture, Vector3fc voxelGridOrigin) {
        ResourceLocation veilShaderId;
        RenderType renderType = VeilRenderType.get(RENDER_TYPE, new Object[0]);
        if (renderType != null && (veilShaderId = VeilRenderType.getShards(renderType).veilShaderId()) != null) {
            DDALightRenderer.uploadVoxelGridUniforms(veilShaderId, voxelGridTexture, voxelGridOrigin);
        }
    }
}
