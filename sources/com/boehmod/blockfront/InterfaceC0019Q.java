package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4d;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.Q */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/Q.class */
public interface InterfaceC0019Q {
    @NotNull
    /* JADX INFO: renamed from: d */
    Vector3dc mo124d();

    @NotNull
    /* JADX INFO: renamed from: a */
    Quaterniondc mo123a();

    @NotNull
    /* JADX INFO: renamed from: c */
    Vector3dc mo122c();

    @NotNull
    /* JADX INFO: renamed from: b */
    Vector3dc mo121b();

    @NotNull
    /* JADX INFO: renamed from: a */
    default Vector3dc m125a(@NotNull Vector3dc vector3dc, @NotNull Vector3d vector3d) {
        return mo123a().transform(vector3dc.sub(mo122c(), vector3d).mul(mo121b())).add(mo124d());
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    default Vector3dc m126b(@NotNull Vector3dc vector3dc, @NotNull Vector3d vector3d) {
        Vector3dc vector3dcMo121b = mo121b();
        return mo123a().transformInverse(vector3dc.sub(mo124d(), vector3d)).mul(1.0d / vector3dcMo121b.x(), 1.0d / vector3dcMo121b.y(), 1.0d / vector3dcMo121b.z()).add(mo122c());
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    default Vector3dc m127c(@NotNull Vector3dc vector3dc, @NotNull Vector3d vector3d) {
        return mo123a().transform(vector3dc.mul(mo121b(), vector3d));
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    default Vector3dc m128d(@NotNull Vector3dc vector3dc, @NotNull Vector3d vector3d) {
        Vector3dc vector3dcMo121b = mo121b();
        return mo123a().transformInverse(vector3dc, vector3d).mul(1.0d / vector3dcMo121b.x(), 1.0d / vector3dcMo121b.y(), 1.0d / vector3dcMo121b.z());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    default Matrix4d m129a(@NotNull Matrix4d matrix4d) {
        return matrix4d.identity().translate(mo124d()).rotate(mo123a()).scale(mo121b()).translate(-mo122c().x(), -mo122c().y(), -mo122c().z());
    }

    /* JADX INFO: renamed from: a */
    default boolean m130a(@NotNull C0018P c0018p, double d, double d2) {
        return mo124d().distanceSquared(c0018p.mo124d()) <= d * d && mo123a().div(c0018p.mo123a(), new Quaterniond()).angle() <= d2;
    }
}
