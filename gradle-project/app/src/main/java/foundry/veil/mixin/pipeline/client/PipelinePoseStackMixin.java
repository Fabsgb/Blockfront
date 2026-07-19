package foundry.veil.mixin.pipeline.client;

import com.mojang.blaze3d.vertex.PoseStack;
import foundry.veil.api.client.render.MatrixStack;
import java.util.Deque;
import org.joml.Matrix3f;
import org.joml.Quaterniondc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/pipeline/client/PipelinePoseStackMixin.class */
@Mixin({PoseStack.class})
public abstract class PipelinePoseStackMixin implements MatrixStack {

    @Unique
    private static final Matrix3f veil$IDENTITY_NORMAL = new Matrix3f();

    @Shadow
    @Final
    private Deque<PoseStack.Pose> poseStack;

    @Unique
    private final Quaternionf veil$castQuat = new Quaternionf();

    @Shadow
    public abstract void shadow$scale(float f, float f2, float f3);

    @Shadow
    public abstract void shadow$mulPose(Quaternionf quaternionf);

    @Shadow
    public abstract void shadow$rotateAround(Quaternionf quaternionf, float f, float f2, float f3);

    @Shadow
    public abstract void shadow$pushPose();

    @Shadow
    public abstract void shadow$popPose();

    @Shadow
    public abstract PoseStack.Pose last();

    @Override // foundry.veil.api.client.render.MatrixStack
    public void clear() {
        while (this.poseStack.size() > 1) {
            shadow$popPose();
        }
        setIdentity();
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public void translate(float x, float y, float z) {
        pose().pose().translate(x, y, z);
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public void rotate(Quaterniondc rotation) {
        shadow$mulPose(this.veil$castQuat.set(rotation));
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public void rotate(Quaternionfc rotation) {
        shadow$mulPose(this.veil$castQuat.set(rotation));
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public void rotate(float angle, float x, float y, float z) {
        shadow$mulPose(this.veil$castQuat.identity().rotateAxis(angle, x, y, z));
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public void rotateXYZ(float x, float y, float z) {
        shadow$mulPose(this.veil$castQuat.identity().rotateXYZ(x, y, z));
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public void rotateZYX(float z, float y, float x) {
        shadow$mulPose(this.veil$castQuat.identity().rotateZYX(z, y, x));
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public void rotateAround(Quaterniondc rotation, double x, double y, double z) {
        shadow$rotateAround(this.veil$castQuat.set(rotation), (float) x, (float) y, (float) z);
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public void rotateAround(Quaternionfc rotation, float x, float y, float z) {
        shadow$rotateAround(this.veil$castQuat.set(rotation), x, y, z);
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public void applyScale(float x, float y, float z) {
        shadow$scale(x, y, z);
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public boolean isIdentity() {
        PoseStack.Pose pose = pose();
        return (pose.pose().properties() & 4) != 0 && pose.normal().equals(veil$IDENTITY_NORMAL);
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public boolean isEmpty() {
        return this.poseStack.size() == 1;
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public void matrixPush() {
        shadow$pushPose();
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public void matrixPop() {
        shadow$popPose();
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public PoseStack.Pose pose() {
        return this.poseStack.getLast();
    }

    @Override // foundry.veil.api.client.render.MatrixStack
    public PoseStack toPoseStack() {
        return (PoseStack) this;
    }
}
