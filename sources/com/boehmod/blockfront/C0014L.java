package com.boehmod.blockfront;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.L */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/L.class */
public class C0014L implements InterfaceC0015M {

    /* JADX INFO: renamed from: o */
    public double f195o;

    /* JADX INFO: renamed from: p */
    public double f196p;

    /* JADX INFO: renamed from: q */
    public double f197q;

    /* JADX INFO: renamed from: r */
    public double f198r;

    /* JADX INFO: renamed from: s */
    public double f199s;

    /* JADX INFO: renamed from: t */
    public double f200t;

    public C0014L(double d, double d2, double d3, double d4, double d5, double d6) {
        m65a(d, d2, d3, d4, d5, d6);
    }

    public C0014L(@NotNull InterfaceC0015M interfaceC0015M) {
        m64a(interfaceC0015M);
    }

    public C0014L(@NotNull AABB aabb) {
        m65a(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
    }

    public C0014L(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        m65a(vec3.x, vec3.y, vec3.z, vec32.x, vec32.y, vec32.z);
    }

    /* JADX INFO: renamed from: a */
    public void m64a(@NotNull InterfaceC0015M interfaceC0015M) {
        m65a(interfaceC0015M.mo68b(), interfaceC0015M.mo69c(), interfaceC0015M.mo70d(), interfaceC0015M.mo71e(), interfaceC0015M.mo72f(), interfaceC0015M.mo73g());
    }

    /* JADX INFO: renamed from: a */
    public void m65a(double d, double d2, double d3, double d4, double d5, double d6) {
        this.f195o = Math.min(d, d4);
        this.f196p = Math.min(d2, d5);
        this.f197q = Math.min(d3, d6);
        this.f198r = Math.max(d, d4);
        this.f199s = Math.max(d2, d5);
        this.f200t = Math.max(d3, d6);
    }

    /* JADX INFO: renamed from: b */
    public void m66b(double d, double d2, double d3, double d4, double d5, double d6) {
        this.f195o = d;
        this.f196p = d2;
        this.f197q = d3;
        this.f198r = d4;
        this.f199s = d5;
        this.f200t = d6;
    }

    /* JADX INFO: renamed from: b */
    public void m67b(@NotNull InterfaceC0015M interfaceC0015M) {
        this.f195o = interfaceC0015M.mo68b();
        this.f196p = interfaceC0015M.mo69c();
        this.f197q = interfaceC0015M.mo70d();
        this.f198r = interfaceC0015M.mo71e();
        this.f199s = interfaceC0015M.mo72f();
        this.f200t = interfaceC0015M.mo73g();
    }

    @Override // com.boehmod.blockfront.InterfaceC0015M
    /* JADX INFO: renamed from: b */
    public double mo68b() {
        return this.f195o;
    }

    @Override // com.boehmod.blockfront.InterfaceC0015M
    /* JADX INFO: renamed from: c */
    public double mo69c() {
        return this.f196p;
    }

    @Override // com.boehmod.blockfront.InterfaceC0015M
    /* JADX INFO: renamed from: d */
    public double mo70d() {
        return this.f197q;
    }

    @Override // com.boehmod.blockfront.InterfaceC0015M
    /* JADX INFO: renamed from: e */
    public double mo71e() {
        return this.f198r;
    }

    @Override // com.boehmod.blockfront.InterfaceC0015M
    /* JADX INFO: renamed from: f */
    public double mo72f() {
        return this.f199s;
    }

    @Override // com.boehmod.blockfront.InterfaceC0015M
    /* JADX INFO: renamed from: g */
    public double mo73g() {
        return this.f200t;
    }
}
