package foundry.veil.api.quasar.emitters.shape;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.util.RandomSource;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/emitters/shape/Disc.class */
public class Disc implements EmitterShape {
    @Override // foundry.veil.api.quasar.emitters.shape.EmitterShape
    public Vector3d getPoint(RandomSource randomSource, Vector3fc dimensions, Vector3fc rotation, Vector3dc position, boolean fromSurface) {
        double x = (randomSource.nextDouble() * 2.0d) - 1.0d;
        double z = (randomSource.nextDouble() * 2.0d) - 1.0d;
        Vector3d normal = new Vector3d(x, 0.0d, z).normalize();
        Vector3fc dim = dimensions;
        if (!fromSurface) {
            normal.mul(randomSource.nextDouble()).normalize();
            dim = dimensions.mul(randomSource.nextFloat(), randomSource.nextFloat(), randomSource.nextFloat(), new Vector3f());
        }
        Vector3d pos = normal.mul(dim).mul(0.5d);
        return pos.rotate(new Quaterniond().rotationXYZ((float) Math.toRadians(rotation.x()), (float) Math.toRadians(rotation.y()), (float) Math.toRadians(rotation.z()))).add(position);
    }

    @Override // foundry.veil.api.quasar.emitters.shape.EmitterShape
    public void renderShape(PoseStack stack, VertexConsumer consumer, Vector3fc dimensions, Vector3fc rotation) {
        stack.pushPose();
        stack.mulPose(new Quaternionf().rotationXYZ((float) Math.toRadians(rotation.x()), (float) Math.toRadians(rotation.y()), (float) Math.toRadians(rotation.z())));
        stack.scale(dimensions.x(), dimensions.y(), dimensions.z());
        float angle = 0.0f;
        for (int i = 0; i < 32; i++) {
            float x1 = (float) (((double) 0.0f) + (Math.cos(Math.toRadians(angle)) * ((double) 0.5f)));
            float z1 = (float) (((double) 0.0f) + (Math.sin(Math.toRadians(angle)) * ((double) 0.5f)));
            consumer.addVertex(stack.last().pose(), x1, 0.0f, z1).setColor(0.15f, 0.15f, 1.0f, 1.0f).setNormal(0.0f, 1.0f, 0.0f);
            angle += 11.25f;
        }
        stack.popPose();
    }
}
