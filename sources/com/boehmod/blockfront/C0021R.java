package com.boehmod.blockfront;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.R */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/R.class */
public class C0021R implements InterfaceC0022S {

    /* JADX INFO: renamed from: v */
    public double f238v;

    /* JADX INFO: renamed from: w */
    public double f239w;

    /* JADX INFO: renamed from: x */
    public double f240x;

    /* JADX INFO: renamed from: y */
    public double f241y;

    /* JADX INFO: renamed from: z */
    public double f242z;

    /* JADX INFO: renamed from: A */
    public double f243A;

    public C0021R(double d, double d2, double d3, double d4, double d5, double d6) {
        m98a(d, d2, d3, d4, d5, d6);
    }

    public C0021R(@NotNull InterfaceC0022S interfaceC0022S) {
        m97a(interfaceC0022S);
    }

    public C0021R(@NotNull AABB aabb) {
        m98a(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
    }

    public C0021R(@NotNull Vec3 vec3, @NotNull Vec3 vec4) {
        m98a(vec3.x, vec3.y, vec3.z, vec4.x, vec4.y, vec4.z);
    }

    /* JADX INFO: renamed from: a */
    public void m97a(@NotNull InterfaceC0022S interfaceC0022S) {
        m98a(interfaceC0022S.mo101d(), interfaceC0022S.mo102e(), interfaceC0022S.mo103f(), interfaceC0022S.mo104g(), interfaceC0022S.mo105h(), interfaceC0022S.mo106i());
    }

    /* JADX INFO: renamed from: a */
    public void m98a(double d, double d2, double d3, double d4, double d5, double d6) {
        this.f238v = Math.min(d, d4);
        this.f239w = Math.min(d2, d5);
        this.f240x = Math.min(d3, d6);
        this.f241y = Math.max(d, d4);
        this.f242z = Math.max(d2, d5);
        this.f243A = Math.max(d3, d6);
    }

    /* JADX INFO: renamed from: b */
    public void m99b(double d, double d2, double d3, double d4, double d5, double d6) {
        this.f238v = d;
        this.f239w = d2;
        this.f240x = d3;
        this.f241y = d4;
        this.f242z = d5;
        this.f243A = d6;
    }

    /* JADX INFO: renamed from: b */
    public void m100b(@NotNull InterfaceC0022S interfaceC0022S) {
        this.f238v = interfaceC0022S.mo101d();
        this.f239w = interfaceC0022S.mo102e();
        this.f240x = interfaceC0022S.mo103f();
        this.f241y = interfaceC0022S.mo104g();
        this.f242z = interfaceC0022S.mo105h();
        this.f243A = interfaceC0022S.mo106i();
    }

    @Override // com.boehmod.blockfront.InterfaceC0022S
    /* JADX INFO: renamed from: d */
    public double mo101d() {
        return this.f238v;
    }

    @Override // com.boehmod.blockfront.InterfaceC0022S
    /* JADX INFO: renamed from: e */
    public double mo102e() {
        return this.f239w;
    }

    @Override // com.boehmod.blockfront.InterfaceC0022S
    /* JADX INFO: renamed from: f */
    public double mo103f() {
        return this.f240x;
    }

    @Override // com.boehmod.blockfront.InterfaceC0022S
    /* JADX INFO: renamed from: g */
    public double mo104g() {
        return this.f241y;
    }

    @Override // com.boehmod.blockfront.InterfaceC0022S
    /* JADX INFO: renamed from: h */
    public double mo105h() {
        return this.f242z;
    }

    @Override // com.boehmod.blockfront.InterfaceC0022S
    /* JADX INFO: renamed from: i */
    public double mo106i() {
        return this.f243A;
    }
}
