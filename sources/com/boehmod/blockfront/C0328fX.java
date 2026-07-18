package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;

/* JADX INFO: renamed from: com.boehmod.blockfront.fX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fX.class */
public final class C0328fX {

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final ThreadLocal<Matrix4f> f2387b = ThreadLocal.withInitial(Matrix4f::new);

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final ThreadLocal<Vector3f> f2388c = ThreadLocal.withInitial(Vector3f::new);

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final ThreadLocal<Vector4f> f2389d = ThreadLocal.withInitial(Vector4f::new);

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final ThreadLocal<Quaternionf> f2390e = ThreadLocal.withInitial(Quaternionf::new);

    private C0328fX() {
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Matrix4f m1683a(@NotNull Matrix4fc matrix4fc) {
        return f2387b.get().set(matrix4fc);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vector3f m1684a(@NotNull Vector3fc vector3fc) {
        return f2388c.get().set(vector3fc);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Vector4f m1685a(float f, float f2, float f3, float f4) {
        return f2389d.get().set(f, f2, f3, f4);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Quaternionf m1686a() {
        return f2390e.get();
    }
}
