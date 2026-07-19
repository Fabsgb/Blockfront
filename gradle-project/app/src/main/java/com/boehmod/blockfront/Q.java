package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4d;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/Q.class */
public interface Q {
    @NotNull
    Vector3dc d();

    @NotNull
    /* JADX INFO: renamed from: a */
    Quaterniondc mo158a();

    @NotNull
    /* JADX INFO: renamed from: c */
    Vector3dc mo157c();

    @NotNull
    /* JADX INFO: renamed from: b */
    Vector3dc mo156b();

    @NotNull
    default Vector3dc a(@NotNull Vector3dc vector3dc, @NotNull Vector3d vector3d) {
        return mo158a().transform(vector3dc.sub(mo157c(), vector3d).mul(mo156b())).add(d());
    }

    @NotNull
    default Vector3dc b(@NotNull Vector3dc vector3dc, @NotNull Vector3d vector3d) {
        Vector3dc vector3dcMo156b = mo156b();
        return mo158a().transformInverse(vector3dc.sub(d(), vector3d)).mul(1.0d / vector3dcMo156b.x(), 1.0d / vector3dcMo156b.y(), 1.0d / vector3dcMo156b.z()).add(mo157c());
    }

    @NotNull
    default Vector3dc c(@NotNull Vector3dc vector3dc, @NotNull Vector3d vector3d) {
        return mo158a().transform(vector3dc.mul(mo156b(), vector3d));
    }

    @NotNull
    default Vector3dc d(@NotNull Vector3dc vector3dc, @NotNull Vector3d vector3d) {
        Vector3dc vector3dcMo156b = mo156b();
        return mo158a().transformInverse(vector3dc, vector3d).mul(1.0d / vector3dcMo156b.x(), 1.0d / vector3dcMo156b.y(), 1.0d / vector3dcMo156b.z());
    }

    @NotNull
    default Matrix4d a(@NotNull Matrix4d matrix4d) {
        return matrix4d.identity().translate(d()).rotate(mo158a()).scale(mo156b()).translate(-mo157c().x(), -mo157c().y(), -mo157c().z());
    }

    default boolean a(@NotNull P p, double d, double d2) {
        return d().distanceSquared(p.d()) <= d * d && mo158a().div(p.mo158a(), new Quaterniond()).angle() <= d2;
    }
}
