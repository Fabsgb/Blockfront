package foundry.veil.api.quasar.emitters.shape;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.serialization.Codec;
import foundry.veil.api.quasar.registry.EmitterShapeRegistry;
import foundry.veil.api.util.CodecUtil;
import net.minecraft.util.RandomSource;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/emitters/shape/EmitterShape.class */
public interface EmitterShape {
    public static final Codec<EmitterShape> CODEC = CodecUtil.registryOrLegacyCodec(EmitterShapeRegistry.REGISTRY);

    Vector3d getPoint(RandomSource randomSource, Vector3fc vector3fc, Vector3fc vector3fc2, Vector3dc vector3dc, boolean z);

    void renderShape(PoseStack poseStack, VertexConsumer vertexConsumer, Vector3fc vector3fc, Vector3fc vector3fc2);
}
