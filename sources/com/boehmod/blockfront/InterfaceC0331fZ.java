package com.boehmod.blockfront;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;

/* JADX INFO: renamed from: com.boehmod.blockfront.fZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fZ.class */
public interface InterfaceC0331fZ {
    /* JADX INFO: renamed from: a */
    boolean mo1692a(@NotNull Camera camera, @NotNull Matrix4f matrix4f);

    /* JADX INFO: renamed from: com.boehmod.blockfront.fZ$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fZ$a.class */
    public static class a implements InterfaceC0331fZ {

        /* JADX INFO: renamed from: c */
        private final Matrix4f f2433c = new Matrix4f();

        /* JADX INFO: renamed from: cv */
        private boolean f2434cv = true;

        @Override // com.boehmod.blockfront.InterfaceC0331fZ
        /* JADX INFO: renamed from: a */
        public boolean mo1692a(@NotNull Camera camera, @NotNull Matrix4f matrix4f) {
            Matrix4fStack modelViewStack = RenderSystem.getModelViewStack();
            if (!modelViewStack.equals(this.f2433c)) {
                this.f2434cv = true;
                this.f2433c.set(modelViewStack);
            }
            if (this.f2434cv) {
                modelViewStack.invert(matrix4f);
                this.f2434cv = false;
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fZ$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fZ$b.class */
    public static class b implements InterfaceC0331fZ {
        @Override // com.boehmod.blockfront.InterfaceC0331fZ
        /* JADX INFO: renamed from: a */
        public boolean mo1692a(@NotNull Camera camera, @NotNull Matrix4f matrix4f) {
            return false;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.fZ$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fZ$c.class */
    public static class c implements InterfaceC0331fZ {

        /* JADX INFO: renamed from: fa */
        private float f2435fa = 0.0f;

        /* JADX INFO: renamed from: cv */
        private boolean f2436cv = true;

        @Override // com.boehmod.blockfront.InterfaceC0331fZ
        /* JADX INFO: renamed from: a */
        public boolean mo1692a(@NotNull Camera camera, @NotNull Matrix4f matrix4f) {
            float yRot = camera.getYRot();
            if (Math.abs(yRot - this.f2435fa) > 0.1f) {
                this.f2436cv = true;
                this.f2435fa = yRot;
            }
            if (this.f2436cv) {
                matrix4f.identity();
                matrix4f.rotateY((float) Math.toRadians(-yRot));
                this.f2436cv = false;
                return true;
            }
            return false;
        }
    }
}
