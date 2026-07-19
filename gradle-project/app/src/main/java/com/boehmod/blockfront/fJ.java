package com.boehmod.blockfront;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fJ.class */
public interface fJ {
    boolean a(@NotNull Camera camera, @NotNull Matrix4f matrix4f);

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fJ$a.class */
    public static class a implements fJ {
        private final Matrix4f b = new Matrix4f();
        private boolean cm = true;

        @Override // com.boehmod.blockfront.fJ
        public boolean a(@NotNull Camera camera, @NotNull Matrix4f matrix4f) {
            Matrix4fStack modelViewStack = RenderSystem.getModelViewStack();
            if (!modelViewStack.equals(this.b)) {
                this.cm = true;
                this.b.set(modelViewStack);
            }
            if (this.cm) {
                modelViewStack.invert(matrix4f);
                this.cm = false;
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fJ$b.class */
    public static class b implements fJ {
        @Override // com.boehmod.blockfront.fJ
        public boolean a(@NotNull Camera camera, @NotNull Matrix4f matrix4f) {
            return false;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fJ$c.class */
    public static class c implements fJ {
        private float eU = 0.0f;
        private boolean cm = true;

        @Override // com.boehmod.blockfront.fJ
        public boolean a(@NotNull Camera camera, @NotNull Matrix4f matrix4f) {
            float yRot = camera.getYRot();
            if (Math.abs(yRot - this.eU) > 0.1f) {
                this.cm = true;
                this.eU = yRot;
            }
            if (this.cm) {
                matrix4f.identity();
                matrix4f.rotateY((float) Math.toRadians(-yRot));
                this.cm = false;
                return true;
            }
            return false;
        }
    }
}
