package foundry.veil.api.client.necromancer.render;

import foundry.veil.api.client.necromancer.Skeleton;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.joml.Matrix4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/render/NecromancerRenderer.class */
public interface NecromancerRenderer extends MultiBufferSource {
    void setUv1(int i, int i2);

    void setUv2(int i, int i2);

    void setColor(float f, float f2, float f3, float f4);

    void setColor(int i);

    void setTransform(Matrix4fc matrix4fc);

    void reset();

    void draw(RenderType renderType, Skeleton skeleton, Skin skin, float f);

    default void setLight(int packedLight) {
        setUv2((packedLight >> 4) & 65535, (packedLight >> 20) & 65535);
    }

    default void setOverlay(int packedOverlay) {
        setUv1((packedOverlay >> 4) & 65535, (packedOverlay >> 20) & 65535);
    }
}
