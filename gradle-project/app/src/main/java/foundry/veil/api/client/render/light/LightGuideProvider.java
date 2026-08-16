package foundry.veil.api.client.render.light;

import com.mojang.blaze3d.vertex.VertexConsumer;
import foundry.veil.api.client.render.MatrixStack;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/light/LightGuideProvider.class */
public interface LightGuideProvider {
    void renderLightGuide(MatrixStack matrixStack, VertexConsumer vertexConsumer);
}
