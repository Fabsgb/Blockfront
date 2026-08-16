package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;

/* JADX INFO: renamed from: com.boehmod.blockfront.gn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gn.class */
public final class C0398gn {

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final ThreadLocal<Matrix4f> f2582b = ThreadLocal.withInitial(Matrix4f::new);

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final ThreadLocal<Vector3f> f2583c = ThreadLocal.withInitial(Vector3f::new);

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final ThreadLocal<Vector4f> f2584d = ThreadLocal.withInitial(Vector4f::new);

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final ThreadLocal<Quaternionf> f2585e = ThreadLocal.withInitial(Quaternionf::new);

    private C0398gn() {
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Matrix4f m1893a(@NotNull Matrix4fc matrix4fc) {
        return f2582b.get().set(matrix4fc);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vector3f m1894a(@NotNull Vector3fc vector3fc) {
        return f2583c.get().set(vector3fc);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vector4f m1895a(float f, float f2, float f3, float f4) {
        return f2584d.get().set(f, f2, f3, f4);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Quaternionf m1896a() {
        return f2585e.get();
    }
}
