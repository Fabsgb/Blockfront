package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fX.class */
public final class fX {

    @NotNull
    private static final ThreadLocal<Matrix4f> b = ThreadLocal.withInitial(Matrix4f::new);

    @NotNull
    private static final ThreadLocal<Vector3f> c = ThreadLocal.withInitial(Vector3f::new);

    @NotNull
    private static final ThreadLocal<Vector4f> d = ThreadLocal.withInitial(Vector4f::new);

    @NotNull
    private static final ThreadLocal<Quaternionf> e = ThreadLocal.withInitial(Quaternionf::new);

    private fX() {
    }

    @NotNull
    public static Matrix4f a(@NotNull Matrix4fc matrix4fc) {
        return b.get().set(matrix4fc);
    }

    @NotNull
    public static Vector3f a(@NotNull Vector3fc vector3fc) {
        return c.get().set(vector3fc);
    }

    @NotNull
    public static Vector4f a(float f, float f2, float f3, float f4) {
        return d.get().set(f, f2, f3, f4);
    }

    @NotNull
    public static Quaternionf a() {
        return e.get();
    }
}
