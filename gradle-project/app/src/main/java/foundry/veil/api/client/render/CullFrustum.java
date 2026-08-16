package foundry.veil.api.client.render;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.SectionPos;
import net.minecraft.world.phys.AABB;
import org.joml.Matrix4fc;
import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.joml.Vector3ic;
import org.joml.Vector4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/CullFrustum.class */
public interface CullFrustum {
    boolean testPoint(double d, double d2, double d3);

    boolean testSphere(double d, double d2, double d3, float f);

    boolean testAab(AABB aabb);

    boolean testAab(double d, double d2, double d3, double d4, double d5, double d6);

    boolean testPlaneXY(double d, double d2, double d3, double d4);

    boolean testPlaneXZ(double d, double d2, double d3, double d4);

    boolean testLineSegment(double d, double d2, double d3, double d4, double d5, double d6);

    Vector4fc[] getPlanes();

    Matrix4fc getModelViewProjectionMatrix();

    Vector3fc getViewVector();

    Vector3dc getPosition();

    Frustum toFrustum();

    default boolean testBlock(BlockPos pos) {
        return testAab(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1);
    }

    default boolean testSection(SectionPos pos) {
        return testAab(pos.getX() << 4, pos.getY() << 4, pos.getZ() << 4, (pos.getX() + 1) << 4, (pos.getY() + 1) << 4, (pos.getZ() + 1) << 4);
    }

    default boolean testPoint(Position point) {
        return testPoint(point.x(), point.y(), point.z());
    }

    default boolean testPoint(Vector3ic point) {
        return testPoint(point.x(), point.y(), point.z());
    }

    default boolean testPoint(Vector3fc point) {
        return testPoint(point.x(), point.y(), point.z());
    }

    default boolean testPoint(Vector3dc point) {
        return testPoint(point.x(), point.y(), point.z());
    }

    default boolean testSphere(Vector3dc center, float radius) {
        return testSphere(center.x(), center.y(), center.z(), radius);
    }

    default boolean testSphere(Vector3fc center, float radius) {
        return testSphere(center.x(), center.y(), center.z(), radius);
    }

    default boolean testAab(Vector3dc min, Vector3dc max) {
        return testAab(min.x(), min.y(), min.z(), max.x(), max.y(), max.z());
    }

    default boolean testAab(Vector3fc min, Vector3fc max) {
        return testAab(min.x(), min.y(), min.z(), max.x(), max.y(), max.z());
    }

    default boolean testPlaneXY(Vector2dc min, Vector2dc max) {
        return testPlaneXY(min.x(), min.y(), max.x(), max.y());
    }

    default boolean testPlaneXY(Vector2fc min, Vector2fc max) {
        return testPlaneXY(min.x(), min.y(), max.x(), max.y());
    }

    default boolean testPlaneXZ(Vector2dc min, Vector2dc max) {
        return testPlaneXZ(min.x(), min.y(), max.x(), max.y());
    }

    default boolean testPlaneXZ(Vector2fc min, Vector2fc max) {
        return testPlaneXZ(min.x(), min.y(), max.x(), max.y());
    }

    default boolean testLineSegment(Vector3dc a, Vector3dc b) {
        return testLineSegment(a.x(), a.y(), a.z(), b.x(), b.y(), b.z());
    }

    default boolean testLineSegment(Vector3fc a, Vector3fc b) {
        return testLineSegment(a.x(), a.y(), a.z(), b.x(), b.y(), b.z());
    }
}
