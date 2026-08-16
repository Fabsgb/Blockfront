package foundry.veil.api.quasar.emitters.shape;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.AABB;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/emitters/shape/Plane.class */
public class Plane implements EmitterShape {
    @Override // foundry.veil.api.quasar.emitters.shape.EmitterShape
    public Vector3d getPoint(RandomSource randomSource, Vector3fc dimensions, Vector3fc rotation, Vector3dc position, boolean fromSurface) {
        double x = randomSource.nextDouble() - 0.5d;
        double z = randomSource.nextDouble() - 0.5d;
        if (fromSurface) {
            if (randomSource.nextBoolean()) {
                x = ((double) randomSource.nextInt(2)) - 0.5d;
            } else {
                z = ((double) randomSource.nextInt(2)) - 0.5d;
            }
        }
        Vector3d normal = new Vector3d(x, 0.0d, z);
        Vector3d pos = normal.mul(dimensions);
        return pos.rotate(new Quaterniond().rotationXYZ((float) Math.toRadians(rotation.x()), (float) Math.toRadians(rotation.y()), (float) Math.toRadians(rotation.z()))).add(position);
    }

    @Override // foundry.veil.api.quasar.emitters.shape.EmitterShape
    public void renderShape(PoseStack stack, VertexConsumer consumer, Vector3fc dimensions, Vector3fc rotation) {
        stack.pushPose();
        stack.mulPose(new Quaternionf().rotationXYZ((float) Math.toRadians(rotation.x()), (float) Math.toRadians(rotation.y()), (float) Math.toRadians(rotation.z())));
        float x = dimensions.x() * 0.5f;
        float z = dimensions.z() * 0.5f;
        LevelRenderer.renderLineBox(stack, consumer, new AABB(-x, 0.0d, -z, x, 0.0d, z), 0.15f, 0.15f, 1.0f, 1.0f);
        stack.popPose();
    }
}
