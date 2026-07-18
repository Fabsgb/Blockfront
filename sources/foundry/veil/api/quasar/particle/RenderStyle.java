package foundry.veil.api.quasar.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.serialization.Codec;
import foundry.veil.api.client.render.MatrixStack;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.quasar.data.QuasarParticleData;
import foundry.veil.api.quasar.registry.RenderStyleRegistry;
import foundry.veil.api.util.CodecUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/particle/RenderStyle.class */
public interface RenderStyle {
    public static final Codec<RenderStyle> CODEC = CodecUtil.registryOrLegacyCodec(RenderStyleRegistry.REGISTRY);

    void render(MatrixStack matrixStack, QuasarParticle quasarParticle, RenderData renderData, Vector3fc vector3fc, VertexConsumer vertexConsumer, double d, float f);

    default boolean setup(int particleCount) {
        return true;
    }

    default void clear() {
    }

    default RenderType getRenderType(QuasarParticle particle, RenderData renderData) {
        boolean additive = renderData.isAdditive();
        TextureAtlasSprite atlasSprite = renderData.getAtlasSprite();
        if (atlasSprite != null) {
            return VeilRenderType.quasarParticle(atlasSprite.atlasLocation(), additive);
        }
        SpriteData spriteData = renderData.getSpriteData();
        if (spriteData != null) {
            return VeilRenderType.quasarParticle(spriteData.sprite(), additive);
        }
        return VeilRenderType.quasarParticle(RenderData.BLANK, additive);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/particle/RenderStyle$Cube.class */
    @ApiStatus.Internal
    public static final class Cube implements RenderStyle {
        private static final Vector3fc[] CUBE_POSITIONS = {new Vector3f(1.0f, 1.0f, -1.0f), new Vector3f(1.0f, 1.0f, 1.0f), new Vector3f(-1.0f, 1.0f, 1.0f), new Vector3f(-1.0f, 1.0f, -1.0f), new Vector3f(-1.0f, -1.0f, -1.0f), new Vector3f(-1.0f, -1.0f, 1.0f), new Vector3f(1.0f, -1.0f, 1.0f), new Vector3f(1.0f, -1.0f, -1.0f), new Vector3f(-1.0f, -1.0f, 1.0f), new Vector3f(-1.0f, 1.0f, 1.0f), new Vector3f(1.0f, 1.0f, 1.0f), new Vector3f(1.0f, -1.0f, 1.0f), new Vector3f(1.0f, -1.0f, -1.0f), new Vector3f(1.0f, 1.0f, -1.0f), new Vector3f(-1.0f, 1.0f, -1.0f), new Vector3f(-1.0f, -1.0f, -1.0f), new Vector3f(-1.0f, -1.0f, -1.0f), new Vector3f(-1.0f, 1.0f, -1.0f), new Vector3f(-1.0f, 1.0f, 1.0f), new Vector3f(-1.0f, -1.0f, 1.0f), new Vector3f(1.0f, -1.0f, 1.0f), new Vector3f(1.0f, 1.0f, 1.0f), new Vector3f(1.0f, 1.0f, -1.0f), new Vector3f(1.0f, -1.0f, -1.0f)};
        private static final float[] CUBE_UVS = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        private static final float[] CUBE_NORMALS = {0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
        private static final Vector3f POS = new Vector3f();

        @Override // foundry.veil.api.quasar.particle.RenderStyle
        public void render(MatrixStack matrixStack, QuasarParticle particle, RenderData renderData, Vector3fc renderOffset, VertexConsumer builder, double ageModifier, float partialTicks) {
            Matrix4f matrix4f = matrixStack.position();
            Vector3fc rotation = renderData.getRenderRotation();
            SpriteData spriteData = renderData.getSpriteData();
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    POS.set(CUBE_POSITIONS[(i * 4) + j]);
                    QuasarParticleData data = particle.getData();
                    if (POS.z < 0.0f && data.velocityStretchFactor() != 0.0f) {
                        POS.z *= 1.0f + data.velocityStretchFactor();
                    }
                    POS.rotateX(rotation.x()).rotateY(rotation.y()).rotateZ(rotation.z()).mul((float) (((double) renderData.getRenderRadius()) * ageModifier)).add(renderOffset);
                    float u = CUBE_UVS[j * 2];
                    float v = CUBE_UVS[(j * 2) + 1];
                    if (spriteData != null) {
                        u = spriteData.m7993u(renderData.getRenderAge(), renderData.getAgePercent(), u);
                        v = spriteData.m7994v(renderData.getRenderAge(), renderData.getAgePercent(), v);
                    }
                    builder.addVertex(matrix4f, POS.x, POS.y, POS.z);
                    builder.setUv(u, v);
                    builder.setColor(renderData.getRed(), renderData.getGreen(), renderData.getBlue(), renderData.getAlpha());
                    builder.setLight(renderData.getPackedLight());
                    builder.setNormal(CUBE_NORMALS[i * 3], CUBE_NORMALS[(i * 3) + 1], CUBE_NORMALS[(i * 3) + 2]);
                }
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/particle/RenderStyle$Billboard.class */
    @ApiStatus.Internal
    public static final class Billboard implements RenderStyle {
        private static final Vector3fc[] PLANE_POSITIONS = {new Vector3f(1.0f, -1.0f, 0.0f), new Vector3f(1.0f, 1.0f, 0.0f), new Vector3f(-1.0f, 1.0f, 0.0f), new Vector3f(-1.0f, -1.0f, 0.0f)};
        private static final float[] PLANE_UVS = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        private static final Vector3f POS = new Vector3f();
        private static final Vector3f NORMAL = new Vector3f();

        @Override // foundry.veil.api.quasar.particle.RenderStyle
        public void render(MatrixStack matrixStack, QuasarParticle particle, RenderData renderData, Vector3fc renderOffset, VertexConsumer builder, double ageModifier, float partialTicks) {
            Matrix4f matrix4f = matrixStack.position();
            Vector3fc rotation = renderData.getRenderRotation();
            Quaternionf faceCameraRotation = Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation();
            SpriteData spriteData = renderData.getSpriteData();
            int red = ((int) (renderData.getRed() * 255.0f)) & 255;
            int green = ((int) (renderData.getGreen() * 255.0f)) & 255;
            int blue = ((int) (renderData.getBlue() * 255.0f)) & 255;
            int alpha = ((int) (renderData.getAlpha() * 255.0f)) & 255;
            NORMAL.set(0.0f, 0.0f, -1.0f);
            if (particle.getData().faceVelocity()) {
                NORMAL.rotateX(rotation.x()).rotateY(rotation.y()).rotateZ(rotation.z());
            }
            for (int j = 0; j < 4; j++) {
                POS.set(PLANE_POSITIONS[j]);
                if (particle.getData().velocityStretchFactor() > 0.0f) {
                    POS.set(POS.x * (1.0f + particle.getData().velocityStretchFactor()), POS.y, POS.z);
                }
                if (particle.getData().faceVelocity()) {
                    POS.rotateX(rotation.x()).rotateY(rotation.y()).rotateZ(rotation.z());
                }
                faceCameraRotation.transform(POS).mul((float) (((double) renderData.getRenderRadius()) * ageModifier)).add(renderOffset);
                float u = PLANE_UVS[j * 2];
                float v = PLANE_UVS[(j * 2) + 1];
                if (spriteData != null) {
                    u = spriteData.m7993u(renderData.getRenderAge(), renderData.getAgePercent(), u);
                    v = spriteData.m7994v(renderData.getRenderAge(), renderData.getAgePercent(), v);
                }
                builder.addVertex(matrix4f, POS.x, POS.y, POS.z);
                builder.setUv(u, v);
                builder.setColor(red, green, blue, alpha);
                builder.setLight(renderData.getPackedLight());
                builder.setNormal(NORMAL.x, NORMAL.y, NORMAL.z);
            }
        }
    }
}
