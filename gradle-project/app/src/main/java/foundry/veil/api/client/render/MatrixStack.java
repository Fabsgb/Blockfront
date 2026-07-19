package foundry.veil.api.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaterniondc;
import org.joml.Quaternionfc;
import org.joml.Vector3dc;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/MatrixStack.class */
public interface MatrixStack {
    void clear();

    void translate(float f, float f2, float f3);

    void rotate(Quaterniondc quaterniondc);

    void rotate(Quaternionfc quaternionfc);

    void rotate(float f, float f2, float f3, float f4);

    void rotateXYZ(float f, float f2, float f3);

    void rotateZYX(float f, float f2, float f3);

    void rotateAround(Quaterniondc quaterniondc, double d, double d2, double d3);

    void rotateAround(Quaternionfc quaternionfc, float f, float f2, float f3);

    void applyScale(float f, float f2, float f3);

    boolean isIdentity();

    boolean isEmpty();

    void matrixPush();

    void matrixPop();

    PoseStack.Pose pose();

    PoseStack toPoseStack();

    default void translate(Vector3dc offset) {
        translate(offset.x(), offset.y(), offset.z());
    }

    default void translate(Vector3fc offset) {
        translate(offset.x(), offset.y(), offset.z());
    }

    default void translate(double x, double y, double z) {
        translate((float) x, (float) y, (float) z);
    }

    default void rotate(double angle, double x, double y, double z) {
        rotate((float) angle, (float) x, (float) y, (float) z);
    }

    default void rotateXYZ(double x, double y, double z) {
        rotateXYZ((float) x, (float) y, (float) z);
    }

    default void rotateZYX(double z, double y, double x) {
        rotateZYX((float) z, (float) y, (float) x);
    }

    default void applyScale(Vector3dc scale) {
        applyScale(scale.x(), scale.y(), scale.z());
    }

    default void applyScale(Vector3fc scale) {
        applyScale(scale.x(), scale.y(), scale.z());
    }

    default void applyScale(double xyz) {
        applyScale((float) xyz, (float) xyz, (float) xyz);
    }

    default void applyScale(float xyz) {
        applyScale(xyz, xyz, xyz);
    }

    default void applyScale(double x, double y, double z) {
        applyScale((float) x, (float) y, (float) z);
    }

    default void copy(PoseStack other) {
        copy(other.last());
    }

    default void copy(MatrixStack other) {
        copy(other.pose());
    }

    default void copy(PoseStack.Pose other) {
        PoseStack.Pose pose = pose();
        pose.pose().set(other.pose());
        pose.normal().set(other.normal());
    }

    default void setIdentity() {
        PoseStack.Pose pose = pose();
        pose.pose().identity();
        pose.normal().identity();
    }

    default Matrix4f position() {
        return pose().pose();
    }

    default Matrix3f normal() {
        return pose().normal();
    }
}
