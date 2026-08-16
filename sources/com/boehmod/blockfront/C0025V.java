package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.V */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/V.class */
public class C0025V implements InterfaceC0026W {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Vector3d f251a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Quaterniond f252a;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Vector3d f253b;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Vector3d f254c;

    public C0025V(@NotNull Vector3d vector3d, @NotNull Quaterniond quaterniond, @NotNull Vector3d vector3d2, @NotNull Vector3d vector3d3) {
        this.f251a = vector3d;
        this.f252a = quaterniond;
        this.f253b = vector3d2;
        this.f254c = vector3d3;
    }

    public C0025V() {
        this.f251a = new Vector3d();
        this.f252a = new Quaterniond();
        this.f253b = new Vector3d();
        this.f254c = new Vector3d(1.0d);
    }

    public C0025V(@NotNull InterfaceC0026W interfaceC0026W) {
        this.f251a = new Vector3d(interfaceC0026W.mo157d());
        this.f252a = new Quaterniond(interfaceC0026W.mo156a());
        this.f253b = new Vector3d(interfaceC0026W.mo155c());
        this.f254c = new Vector3d(interfaceC0026W.mo154b());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0025V m144a(@NotNull InterfaceC0026W interfaceC0026W) {
        this.f251a.set(interfaceC0026W.mo157d());
        this.f252a.set(interfaceC0026W.mo156a());
        this.f253b.set(interfaceC0026W.mo155c());
        this.f254c.set(interfaceC0026W.mo154b());
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0025V m145a(@NotNull InterfaceC0026W interfaceC0026W, double d) {
        this.f251a.lerp(interfaceC0026W.mo157d(), d);
        this.f252a.slerp(interfaceC0026W.mo156a(), d);
        this.f253b.lerp(interfaceC0026W.mo155c(), d);
        this.f254c.lerp(interfaceC0026W.mo154b(), d);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3dc m146a(@NotNull Vector3d vector3d) {
        return m158a((Vector3dc) vector3d, vector3d);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Vector3dc m147b(@NotNull Vector3d vector3d) {
        return m159b(vector3d, vector3d);
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Vector3dc m148c(@NotNull Vector3d vector3d) {
        return m160c(vector3d, vector3d);
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public Vector3dc m149d(@NotNull Vector3d vector3d) {
        return m161d(vector3d, vector3d);
    }

    @Override // com.boehmod.blockfront.InterfaceC0026W
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Vector3d mo157d() {
        return this.f251a;
    }

    @Override // com.boehmod.blockfront.InterfaceC0026W
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Quaterniond mo156a() {
        return this.f252a;
    }

    @Override // com.boehmod.blockfront.InterfaceC0026W
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Vector3d mo155c() {
        return this.f253b;
    }

    @Override // com.boehmod.blockfront.InterfaceC0026W
    @NotNull
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Vector3d mo154b() {
        return this.f254c;
    }
}
