package com.boehmod.blockfront;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/L.class */
public class L implements M {
    public double o;
    public double p;
    public double q;
    public double r;
    public double s;
    public double t;

    public L(double d, double d2, double d3, double d4, double d5, double d6) {
        a(d, d2, d3, d4, d5, d6);
    }

    public L(@NotNull M m) {
        a(m);
    }

    public L(@NotNull AABB aabb) {
        a(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
    }

    public L(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        a(vec3.x, vec3.y, vec3.z, vec32.x, vec32.y, vec32.z);
    }

    public void a(@NotNull M m) {
        a(m.b(), m.c(), m.d(), m.e(), m.f(), m.g());
    }

    public void a(double d, double d2, double d3, double d4, double d5, double d6) {
        this.o = Math.min(d, d4);
        this.p = Math.min(d2, d5);
        this.q = Math.min(d3, d6);
        this.r = Math.max(d, d4);
        this.s = Math.max(d2, d5);
        this.t = Math.max(d3, d6);
    }

    public void b(double d, double d2, double d3, double d4, double d5, double d6) {
        this.o = d;
        this.p = d2;
        this.q = d3;
        this.r = d4;
        this.s = d5;
        this.t = d6;
    }

    public void b(@NotNull M m) {
        this.o = m.b();
        this.p = m.c();
        this.q = m.d();
        this.r = m.e();
        this.s = m.f();
        this.t = m.g();
    }

    @Override // com.boehmod.blockfront.M
    public double b() {
        return this.o;
    }

    @Override // com.boehmod.blockfront.M
    public double c() {
        return this.p;
    }

    @Override // com.boehmod.blockfront.M
    public double d() {
        return this.q;
    }

    @Override // com.boehmod.blockfront.M
    public double e() {
        return this.r;
    }

    @Override // com.boehmod.blockfront.M
    public double f() {
        return this.s;
    }

    @Override // com.boehmod.blockfront.M
    public double g() {
        return this.t;
    }
}
