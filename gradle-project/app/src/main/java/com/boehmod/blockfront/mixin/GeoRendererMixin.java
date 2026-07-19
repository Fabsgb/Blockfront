package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.fX;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import software.bernie.geckolib.renderer.GeoRenderer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/GeoRendererMixin.class */
@Mixin({GeoRenderer.class})
public interface GeoRendererMixin {
    @Redirect(method = {"renderCube"}, at = @At(value = "NEW", target = "(Lorg/joml/Matrix4fc;)Lorg/joml/Matrix4f;"))
    private default Matrix4f bf$reuseCubePose(Matrix4fc matrix4fc) {
        return fX.a(matrix4fc);
    }

    @Redirect(method = {"renderCube"}, at = @At(value = "NEW", target = "(Lorg/joml/Vector3fc;)Lorg/joml/Vector3f;"))
    private default Vector3f bf$reuseQuadNormal(Vector3fc vector3fc) {
        return fX.a(vector3fc);
    }

    @Redirect(method = {"createVerticesOfQuad"}, at = @At(value = "NEW", target = "(FFFF)Lorg/joml/Vector4f;"))
    private default Vector4f bf$reuseVertex(float f, float f2, float f3, float f4) {
        return fX.a(f, f2, f3, f4);
    }
}
