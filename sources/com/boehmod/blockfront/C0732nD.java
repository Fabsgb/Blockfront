package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.nD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nD.class */
public class C0732nD {

    /* JADX INFO: renamed from: dx */
    public static final ResourceLocation f3925dx = C0564jv.m2555d("textures/gui/vehicle/icon_gunner.png");

    /* JADX INFO: renamed from: dy */
    public static final ResourceLocation f3926dy = C0564jv.m2555d("textures/gui/vehicle/icon_driver.png");

    /* JADX INFO: renamed from: dz */
    public static final ResourceLocation f3927dz = C0564jv.m2555d("textures/gui/vehicle/icon_commander.png");

    /* JADX INFO: renamed from: dA */
    public static final ResourceLocation f3928dA = C0564jv.m2555d("textures/gui/vehicle/icon_passenger.png");

    /* JADX INFO: renamed from: fo */
    public boolean f3929fo = false;

    /* JADX INFO: renamed from: jx */
    public float f3930jx = 0.0f;

    @NotNull
    private ResourceLocation icon = f3926dy;

    /* JADX INFO: renamed from: e */
    @NotNull
    public Vector3f f3931e = new Vector3f(0.0f, 0.0f, 0.0f);

    /* JADX INFO: renamed from: k */
    @NotNull
    public Vector3f f3932k = new Vector3f(0.0f, 0.0f, 0.0f);

    /* JADX INFO: renamed from: ai */
    @NotNull
    private final List<AbstractC0742nN<?>> f3933ai = new ObjectArrayList();

    /* JADX INFO: renamed from: jy */
    public float f3934jy = 75.0f;

    /* JADX INFO: renamed from: jz */
    public float f3935jz = 105.0f;

    /* JADX INFO: renamed from: fp */
    public boolean f3936fp = false;

    /* JADX INFO: renamed from: fq */
    public boolean f3937fq = false;

    /* JADX INFO: renamed from: fr */
    public boolean f3938fr = false;

    /* JADX INFO: renamed from: fs */
    public boolean f3939fs = false;

    /* JADX INFO: renamed from: bB */
    public String f3940bB = "";

    /* JADX INFO: renamed from: jA */
    public float f3941jA = 0.0f;

    /* JADX INFO: renamed from: a */
    public C0732nD m3313a(@NotNull ResourceLocation resourceLocation) {
        this.icon = resourceLocation;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0732nD m3314a(@NotNull AbstractC0742nN<?> abstractC0742nN) {
        this.f3933ai.add(abstractC0742nN);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0732nD m3315a() {
        this.f3939fs = true;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0732nD m3316b() {
        this.f3938fr = true;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C0732nD m3317c() {
        this.f3929fo = true;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public C0732nD m3318d() {
        this.f3936fp = true;
        return this;
    }

    /* JADX INFO: renamed from: e */
    public C0732nD m3319e() {
        this.f3937fq = true;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0732nD m3320a(float f, float f2) {
        this.f3934jy = f;
        this.f3935jz = f2;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0732nD m3321a(float f) {
        this.f3930jx = f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0732nD m3322a(Vector3f vector3f) {
        this.f3931e = vector3f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0732nD m3323b(Vector3f vector3f) {
        this.f3932k = vector3f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0732nD m3324b(float f) {
        this.f3941jA = f;
        return this;
    }

    /* JADX INFO: renamed from: K */
    public String m3325K() {
        return this.f3940bB;
    }

    /* JADX INFO: renamed from: a */
    public C0732nD m3326a(String str) {
        this.f3940bB = str;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public List<AbstractC0742nN<?>> m3327b() {
        return this.f3933ai;
    }

    /* JADX INFO: renamed from: aC */
    public float m3328aC() {
        return this.f3941jA;
    }

    @NotNull
    public ResourceLocation getIcon() {
        return this.icon;
    }
}
