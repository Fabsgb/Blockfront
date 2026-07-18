package com.boehmod.blockfront;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;

/* JADX INFO: renamed from: com.boehmod.blockfront.fJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fJ.class */
public interface InterfaceC0314fJ {
    /* JADX INFO: renamed from: a */
    boolean mo1622a(@NotNull Camera camera, @NotNull Matrix4f matrix4f);

    /* JADX INFO: renamed from: com.boehmod.blockfront.fJ$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fJ$a.class */
    public static class a implements InterfaceC0314fJ {

        /* JADX INFO: renamed from: b */
        private final Matrix4f f2331b = new Matrix4f();

        /* JADX INFO: renamed from: cm */
        private boolean f2332cm = true;

        @Override // com.boehmod.blockfront.InterfaceC0314fJ
        /* JADX INFO: renamed from: a */
        public boolean mo1622a(@NotNull Camera camera, @NotNull Matrix4f matrix4f) {
            Matrix4fStack modelViewStack = RenderSystem.getModelViewStack();
            if (!modelViewStack.equals(this.f2331b)) {
                this.f2332cm = true;
                this.f2331b.set(modelViewStack);
            }
            if (this.f2332cm) {
                modelViewStack.invert(matrix4f);
                this.f2332cm = false;
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fJ$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fJ$b.class */
    public static class b implements InterfaceC0314fJ {
        @Override // com.boehmod.blockfront.InterfaceC0314fJ
        /* JADX INFO: renamed from: a */
        public boolean mo1622a(@NotNull Camera camera, @NotNull Matrix4f matrix4f) {
            return false;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fJ$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fJ$c.class */
    public static class c implements InterfaceC0314fJ {

        /* JADX INFO: renamed from: eU */
        private float f2333eU = 0.0f;

        /* JADX INFO: renamed from: cm */
        private boolean f2334cm = true;

        @Override // com.boehmod.blockfront.InterfaceC0314fJ
        /* JADX INFO: renamed from: a */
        public boolean mo1622a(@NotNull Camera camera, @NotNull Matrix4f matrix4f) {
            float yRot = camera.getYRot();
            if (Math.abs(yRot - this.f2333eU) > 0.1f) {
                this.f2334cm = true;
                this.f2333eU = yRot;
            }
            if (this.f2334cm) {
                matrix4f.identity();
                matrix4f.rotateY((float) Math.toRadians(-yRot));
                this.f2334cm = false;
                return true;
            }
            return false;
        }
    }
}
