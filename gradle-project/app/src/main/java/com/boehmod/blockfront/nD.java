package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nD.class */
public class nD {
    public static final ResourceLocation dx = C0265jv.d("textures/gui/vehicle/icon_gunner.png");
    public static final ResourceLocation dy = C0265jv.d("textures/gui/vehicle/icon_driver.png");
    public static final ResourceLocation dz = C0265jv.d("textures/gui/vehicle/icon_commander.png");
    public static final ResourceLocation dA = C0265jv.d("textures/gui/vehicle/icon_passenger.png");
    public boolean fo = false;
    public float jx = 0.0f;

    @NotNull
    private ResourceLocation icon = dy;

    @NotNull
    public Vector3f e = new Vector3f(0.0f, 0.0f, 0.0f);

    @NotNull
    public Vector3f k = new Vector3f(0.0f, 0.0f, 0.0f);

    @NotNull
    private final List<nN<?>> ai = new ObjectArrayList();
    public float jy = 75.0f;
    public float jz = 105.0f;
    public boolean fp = false;
    public boolean fq = false;
    public boolean fr = false;
    public boolean fs = false;
    public String bB = "";
    public float jA = 0.0f;

    public nD a(@NotNull ResourceLocation resourceLocation) {
        this.icon = resourceLocation;
        return this;
    }

    public nD a(@NotNull nN<?> nNVar) {
        this.ai.add(nNVar);
        return this;
    }

    public nD a() {
        this.fs = true;
        return this;
    }

    public nD b() {
        this.fr = true;
        return this;
    }

    public nD c() {
        this.fo = true;
        return this;
    }

    public nD d() {
        this.fp = true;
        return this;
    }

    public nD e() {
        this.fq = true;
        return this;
    }

    public nD a(float f, float f2) {
        this.jy = f;
        this.jz = f2;
        return this;
    }

    public nD a(float f) {
        this.jx = f;
        return this;
    }

    public nD a(Vector3f vector3f) {
        this.e = vector3f;
        return this;
    }

    public nD b(Vector3f vector3f) {
        this.k = vector3f;
        return this;
    }

    public nD b(float f) {
        this.jA = f;
        return this;
    }

    public String K() {
        return this.bB;
    }

    public nD a(String str) {
        this.bB = str;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public List<nN<?>> m715b() {
        return this.ai;
    }

    public float aC() {
        return this.jA;
    }

    @NotNull
    public ResourceLocation getIcon() {
        return this.icon;
    }
}
