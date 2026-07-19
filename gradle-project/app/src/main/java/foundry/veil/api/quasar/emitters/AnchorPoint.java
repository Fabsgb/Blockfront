package foundry.veil.api.quasar.emitters;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.List;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;
import org.joml.Vector4f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/emitters/AnchorPoint.class */
public class AnchorPoint {
    public static AnchorPoint TEST_POINT = new AnchorPoint(ResourceLocation.fromNamespaceAndPath("quasar", "test_point"));
    private final ResourceLocation id;
    public Vector3f localOffset = new Vector3f(0.0f, 0.0f, 0.0f);
    public Vector3f worldOffset = new Vector3f(0.0f, 0.0f, 0.0f);
    public List<ModelPart> modelParts = null;
    public Vector3f origin = new Vector3f(0.0f, 0.0f, 0.0f);
    public Vector4f transformMatrix = new Vector4f();

    public AnchorPoint(ResourceLocation id) {
        this.id = id;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public Vector3f getLocalOffset() {
        return this.localOffset;
    }

    public Vec3 getWorldOffset(Entity entity) {
        if (entity == null) {
            return Vec3.ZERO;
        }
        Vec3 pos = entity.position();
        return pos.add(this.transformMatrix.x(), this.transformMatrix.y(), this.transformMatrix.z());
    }

    public void updatePosition(Entity entity) {
        if (this.modelParts == null) {
            return;
        }
        PoseStack stack = new PoseStack();
        stack.scale(1.0f, -1.0f, -1.0f);
        stack.translate(0.0f, -1.501f, 0.0f);
        for (ModelPart modelPart : this.modelParts) {
            modelPart.translateAndRotate(stack);
        }
        Vector4f offset = new Vector4f(this.localOffset.x(), this.localOffset.y(), this.localOffset.z(), 1.0f);
        this.transformMatrix = stack.last().pose().transform(offset);
    }

    public void render(PoseStack stack, MultiBufferSource source, float scalar) {
        stack.pushPose();
        stack.translate(this.transformMatrix.x(), this.transformMatrix.y(), this.transformMatrix.z());
        VertexConsumer consumer = source.getBuffer(RenderType.lines());
        stack.scale(0.0625f, 0.0625f, 0.0625f);
        LevelRenderer.renderLineBox(stack, consumer, new AABB(-0.5d, -0.5d, -0.5d, 0.5d, 0.5d, 0.5d), 1.0f, 1.0f, 1.0f, 1.0f);
        stack.popPose();
    }
}
