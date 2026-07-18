package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.P */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/P.class */
public class C0018P implements InterfaceC0019Q {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Vector3d f208a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Quaterniond f209a;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Vector3d f210b;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Vector3d f211c;

    public C0018P(@NotNull Vector3d vector3d, @NotNull Quaterniond quaterniond, @NotNull Vector3d vector3d2, @NotNull Vector3d vector3d3) {
        this.f208a = vector3d;
        this.f209a = quaterniond;
        this.f210b = vector3d2;
        this.f211c = vector3d3;
    }

    public C0018P() {
        this.f208a = new Vector3d();
        this.f209a = new Quaterniond();
        this.f210b = new Vector3d();
        this.f211c = new Vector3d(1.0d);
    }

    public C0018P(@NotNull InterfaceC0019Q interfaceC0019Q) {
        this.f208a = new Vector3d(interfaceC0019Q.mo124d());
        this.f209a = new Quaterniond(interfaceC0019Q.mo123a());
        this.f210b = new Vector3d(interfaceC0019Q.mo122c());
        this.f211c = new Vector3d(interfaceC0019Q.mo121b());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0018P m111a(@NotNull InterfaceC0019Q interfaceC0019Q) {
        this.f208a.set(interfaceC0019Q.mo124d());
        this.f209a.set(interfaceC0019Q.mo123a());
        this.f210b.set(interfaceC0019Q.mo122c());
        this.f211c.set(interfaceC0019Q.mo121b());
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0018P m112a(@NotNull InterfaceC0019Q interfaceC0019Q, double d) {
        this.f208a.lerp(interfaceC0019Q.mo124d(), d);
        this.f209a.slerp(interfaceC0019Q.mo123a(), d);
        this.f210b.lerp(interfaceC0019Q.mo122c(), d);
        this.f211c.lerp(interfaceC0019Q.mo121b(), d);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3dc m113a(@NotNull Vector3d vector3d) {
        return m125a((Vector3dc) vector3d, vector3d);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Vector3dc m114b(@NotNull Vector3d vector3d) {
        return m126b(vector3d, vector3d);
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Vector3dc m115c(@NotNull Vector3d vector3d) {
        return m127c(vector3d, vector3d);
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public Vector3dc m116d(@NotNull Vector3d vector3d) {
        return m128d(vector3d, vector3d);
    }

    @Override // com.boehmod.blockfront.InterfaceC0019Q
    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3d mo124d() {
        return this.f208a;
    }

    @Override // com.boehmod.blockfront.InterfaceC0019Q
    @NotNull
    /* JADX INFO: renamed from: a */
    public Quaterniond mo123a() {
        return this.f209a;
    }

    @Override // com.boehmod.blockfront.InterfaceC0019Q
    @NotNull
    /* JADX INFO: renamed from: b */
    public Vector3d mo122c() {
        return this.f210b;
    }

    @Override // com.boehmod.blockfront.InterfaceC0019Q
    @NotNull
    /* JADX INFO: renamed from: c */
    public Vector3d mo121b() {
        return this.f211c;
    }
}
