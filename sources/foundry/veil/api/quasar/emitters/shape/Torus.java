package foundry.veil.api.quasar.emitters.shape;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.util.RandomSource;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/emitters/shape/Torus.class */
public class Torus implements EmitterShape {
    @Override // foundry.veil.api.quasar.emitters.shape.EmitterShape
    public Vector3d getPoint(RandomSource randomSource, Vector3fc dimensions, Vector3fc rotation, Vector3dc position, boolean fromSurface) {
        double theta = randomSource.nextDouble() * 2.0d * 3.141592653589793d;
        double phi = randomSource.nextDouble() * 2.0d * 3.141592653589793d;
        double x = Math.cos(theta) * (1.0d + (0.5d * Math.cos(phi)));
        double y = Math.sin(theta) * (1.0d + (0.5d * Math.cos(phi)));
        double z = ((double) dimensions.z()) * Math.sin(phi);
        Vector3d normal = new Vector3d(x, y, z).normalize();
        Vector3fc dim = dimensions;
        if (!fromSurface) {
            normal.mul(randomSource.nextDouble()).normalize();
            dim = dimensions.mul(randomSource.nextFloat(), randomSource.nextFloat(), randomSource.nextFloat(), new Vector3f());
        }
        Vector3d pos = normal.mul(dim);
        return pos.rotateX((float) Math.toRadians(rotation.x())).rotateY((float) Math.toRadians(rotation.y())).rotateZ((float) Math.toRadians(rotation.z())).add(position);
    }

    @Override // foundry.veil.api.quasar.emitters.shape.EmitterShape
    public void renderShape(PoseStack stack, VertexConsumer consumer, Vector3fc dimensions, Vector3fc rotation) {
        float radius = dimensions.x();
        dimensions.y();
        float angle = 0.0f;
        for (int i = 0; i < 32; i++) {
            float x1 = (float) (((double) 0.0f) + (Math.cos(Math.toRadians(angle)) * ((double) radius)));
            float z1 = (float) (((double) 0.0f) + (Math.sin(Math.toRadians(angle)) * ((double) radius)));
            float x2 = (float) (((double) 0.0f) + (Math.cos(Math.toRadians(angle + 11.25f)) * ((double) radius)));
            float z2 = (float) (((double) 0.0f) + (Math.sin(Math.toRadians(angle + 11.25f)) * ((double) radius)));
            consumer.addVertex(stack.last().pose(), x1, 0.0f, z1).setColor(0.15f, 0.15f, 1.0f, 1.0f).setNormal(0.0f, 1.0f, 0.0f);
            consumer.addVertex(stack.last().pose(), x2, 0.0f, z2).setColor(0.15f, 0.15f, 1.0f, 1.0f).setNormal(0.0f, 1.0f, 0.0f);
            angle += 11.25f;
        }
    }
}
