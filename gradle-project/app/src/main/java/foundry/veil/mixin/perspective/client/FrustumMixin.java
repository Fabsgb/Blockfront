package foundry.veil.mixin.perspective.client;

import foundry.veil.ext.FrustumExtension;
import net.minecraft.client.renderer.culling.Frustum;
import org.joml.FrustumIntersection;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/perspective/client/FrustumMixin.class */
@Mixin({Frustum.class})
public class FrustumMixin implements FrustumExtension {

    @Shadow
    @Final
    private Matrix4f matrix;

    @Shadow
    @Final
    private FrustumIntersection intersection;

    @Shadow
    private Vector4f viewVector;

    @Override // foundry.veil.ext.FrustumExtension
    public void veil$setupFrustum(Matrix4fc frustum, Matrix4fc projection) {
        projection.mul(frustum, this.matrix);
        this.intersection.set(this.matrix);
        this.matrix.transformTranspose(this.viewVector.set(0.0f, 0.0f, 1.0f, 0.0f));
    }
}
