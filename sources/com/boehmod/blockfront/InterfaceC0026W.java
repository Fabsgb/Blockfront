package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4d;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.W */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/W.class */
public interface InterfaceC0026W {
    @NotNull
    /* JADX INFO: renamed from: d */
    Vector3dc mo157d();

    @NotNull
    /* JADX INFO: renamed from: a */
    Quaterniondc mo156a();

    @NotNull
    /* JADX INFO: renamed from: c */
    Vector3dc mo155c();

    @NotNull
    /* JADX INFO: renamed from: b */
    Vector3dc mo154b();

    @NotNull
    /* JADX INFO: renamed from: a */
    default Vector3dc m158a(@NotNull Vector3dc vector3dc, @NotNull Vector3d vector3d) {
        return mo156a().transform(vector3dc.sub(mo155c(), vector3d).mul(mo154b())).add(mo157d());
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    default Vector3dc m159b(@NotNull Vector3dc vector3dc, @NotNull Vector3d vector3d) {
        Vector3dc vector3dcMo154b = mo154b();
        return mo156a().transformInverse(vector3dc.sub(mo157d(), vector3d)).mul(1.0d / vector3dcMo154b.x(), 1.0d / vector3dcMo154b.y(), 1.0d / vector3dcMo154b.z()).add(mo155c());
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    default Vector3dc m160c(@NotNull Vector3dc vector3dc, @NotNull Vector3d vector3d) {
        return mo156a().transform(vector3dc.mul(mo154b(), vector3d));
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    default Vector3dc m161d(@NotNull Vector3dc vector3dc, @NotNull Vector3d vector3d) {
        Vector3dc vector3dcMo154b = mo154b();
        return mo156a().transformInverse(vector3dc, vector3d).mul(1.0d / vector3dcMo154b.x(), 1.0d / vector3dcMo154b.y(), 1.0d / vector3dcMo154b.z());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    default Matrix4d m162a(@NotNull Matrix4d matrix4d) {
        return matrix4d.identity().translate(mo157d()).rotate(mo156a()).scale(mo154b()).translate(-mo155c().x(), -mo155c().y(), -mo155c().z());
    }

    /* JADX INFO: renamed from: a */
    default boolean m163a(@NotNull C0025V c0025v, double d, double d2) {
        return mo157d().distanceSquared(c0025v.mo157d()) <= d * d && mo156a().div(c0025v.mo156a(), new Quaterniond()).angle() <= d2;
    }
}
