package foundry.veil.impl.client.render.light;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.VertexFormat;
import foundry.veil.Veil;
import foundry.veil.api.client.render.light.data.SpotLightData;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/light/SpotLightRenderer.class */
@ApiStatus.Internal
public class SpotLightRenderer extends InstancedLightRenderer<SpotLightData> implements DDALightRenderer<SpotLightData> {
    private static final ResourceLocation RENDER_TYPE = Veil.veilPath("light/spot");
    private static final ResourceLocation INSCATTERING_RENDER_TYPE = Veil.veilPath("light/inscattering/spot");

    public SpotLightRenderer() {
        super(96);
    }

    @Override // foundry.veil.api.client.render.light.renderer.InstancedLightRenderer
    protected MeshData createMesh() {
        BufferBuilder builder = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION);
        LightTypeRenderer.createInvertedCube(builder);
        return builder.buildOrThrow();
    }

    @Override // foundry.veil.api.client.render.light.renderer.InstancedLightRenderer
    protected void setupBufferState(VertexArrayBuilder builder) {
        builder.setVertexAttribute(1, 2, 4, VertexArrayBuilder.DataType.FLOAT, false, 0);
        builder.setVertexAttribute(2, 2, 4, VertexArrayBuilder.DataType.FLOAT, false, 16);
        builder.setVertexAttribute(3, 2, 4, VertexArrayBuilder.DataType.FLOAT, false, 32);
        builder.setVertexAttribute(4, 2, 4, VertexArrayBuilder.DataType.FLOAT, false, 48);
        builder.setVertexAttribute(5, 2, 3, VertexArrayBuilder.DataType.FLOAT, false, 64);
        builder.setVertexAttribute(6, 2, 1, VertexArrayBuilder.DataType.FLOAT, false, 76);
        builder.setVertexAttribute(7, 2, 1, VertexArrayBuilder.DataType.UNSIGNED_SHORT, true, 80);
        builder.setVertexAttribute(8, 2, 3, VertexArrayBuilder.DataType.FLOAT, false, 84);
    }

    @Override // foundry.veil.api.client.render.light.renderer.InstancedLightRenderer
    @Nullable
    protected RenderType getRenderType(List<? extends LightRenderHandle<SpotLightData>> lights) {
        return VeilRenderType.get(RENDER_TYPE, new Object[0]);
    }

    @Override // foundry.veil.api.client.render.light.renderer.InstancedLightRenderer
    @Nullable
    protected RenderType getInscatteringRenderType(List<? extends LightRenderHandle<SpotLightData>> lights) {
        return VeilRenderType.get(INSCATTERING_RENDER_TYPE, new Object[0]);
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
