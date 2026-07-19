package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/P.class */
public class P implements Q {

    @NotNull
    private final Vector3d a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final Quaterniond f24a;

    @NotNull
    private final Vector3d b;

    @NotNull
    private final Vector3d c;

    public P(@NotNull Vector3d vector3d, @NotNull Quaterniond quaterniond, @NotNull Vector3d vector3d2, @NotNull Vector3d vector3d3) {
        this.a = vector3d;
        this.f24a = quaterniond;
        this.b = vector3d2;
        this.c = vector3d3;
    }

    public P() {
        this.a = new Vector3d();
        this.f24a = new Quaterniond();
        this.b = new Vector3d();
        this.c = new Vector3d(1.0d);
    }

    public P(@NotNull Q q) {
        this.a = new Vector3d(q.d());
        this.f24a = new Quaterniond(q.mo158a());
        this.b = new Vector3d(q.mo157c());
        this.c = new Vector3d(q.mo156b());
    }

    @NotNull
    public P a(@NotNull Q q) {
        this.a.set(q.d());
        this.f24a.set(q.mo158a());
        this.b.set(q.mo157c());
        this.c.set(q.mo156b());
        return this;
    }

    @NotNull
    public P a(@NotNull Q q, double d) {
        this.a.lerp(q.d(), d);
        this.f24a.slerp(q.mo158a(), d);
        this.b.lerp(q.mo157c(), d);
        this.c.lerp(q.mo156b(), d);
        return this;
    }

    @NotNull
    public Vector3dc a(@NotNull Vector3d vector3d) {
        return a((Vector3dc) vector3d, vector3d);
    }

    @NotNull
    public Vector3dc b(@NotNull Vector3d vector3d) {
        return b(vector3d, vector3d);
    }

    @NotNull
    public Vector3dc c(@NotNull Vector3d vector3d) {
        return c(vector3d, vector3d);
    }

    @NotNull
    public Vector3dc d(@NotNull Vector3d vector3d) {
        return d(vector3d, vector3d);
    }

    @Override // com.boehmod.blockfront.Q
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Vector3d d() {
        return this.a;
    }

    @Override // com.boehmod.blockfront.Q
    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public Quaterniond mo158a() {
        return this.f24a;
    }

    @Override // com.boehmod.blockfront.Q
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Vector3d mo157c() {
        return this.b;
    }

    @Override // com.boehmod.blockfront.Q
    @NotNull
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Vector3d mo156b() {
        return this.c;
    }
}
