package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.nZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nZ.class */
public class C0755nZ {

    /* JADX INFO: renamed from: dv */
    public static final ResourceLocation f4173dv = C0532jO.m2378d("textures/gui/vehicle/icon_gunner.png");

    /* JADX INFO: renamed from: dw */
    public static final ResourceLocation f4174dw = C0532jO.m2378d("textures/gui/vehicle/icon_driver.png");

    /* JADX INFO: renamed from: dx */
    public static final ResourceLocation f4175dx = C0532jO.m2378d("textures/gui/vehicle/icon_commander.png");

    /* JADX INFO: renamed from: dy */
    public static final ResourceLocation f4176dy = C0532jO.m2378d("textures/gui/vehicle/icon_passenger.png");

    /* JADX INFO: renamed from: fI */
    public boolean f4177fI = false;

    /* JADX INFO: renamed from: kq */
    public float f4178kq = 0.0f;

    @NotNull
    private ResourceLocation icon = f4174dw;

    /* JADX INFO: renamed from: e */
    @NotNull
    public Vector3f f4179e = new Vector3f(0.0f, 0.0f, 0.0f);

    /* JADX INFO: renamed from: m */
    @NotNull
    public Vector3f f4180m = new Vector3f(0.0f, 0.0f, 0.0f);

    /* JADX INFO: renamed from: ap */
    @NotNull
    private final List<AbstractC0818oj<?>> f4181ap = new ObjectArrayList();

    /* JADX INFO: renamed from: kr */
    public float f4182kr = 75.0f;

    /* JADX INFO: renamed from: ks */
    public float f4183ks = 105.0f;

    /* JADX INFO: renamed from: fJ */
    public boolean f4184fJ = false;

    /* JADX INFO: renamed from: fK */
    public boolean f4185fK = false;

    /* JADX INFO: renamed from: fL */
    public boolean f4186fL = false;

    /* JADX INFO: renamed from: fM */
    public boolean f4187fM = false;

    /* JADX INFO: renamed from: bK */
    public String f4188bK = "";

    /* JADX INFO: renamed from: kt */
    public float f4189kt = 0.0f;

    /* JADX INFO: renamed from: a */
    public C0755nZ m3500a(@NotNull ResourceLocation resourceLocation) {
        this.icon = resourceLocation;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0755nZ m3501a(@NotNull AbstractC0818oj<?> abstractC0818oj) {
        this.f4181ap.add(abstractC0818oj);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0755nZ m3502a() {
        this.f4187fM = true;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0755nZ m3503b() {
        this.f4186fL = true;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C0755nZ m3504c() {
        this.f4177fI = true;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public C0755nZ m3505d() {
        this.f4184fJ = true;
        return this;
    }

    /* JADX INFO: renamed from: e */
    public C0755nZ m3506e() {
        this.f4185fK = true;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0755nZ m3507a(float f, float f2) {
        this.f4182kr = f;
        this.f4183ks = f2;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0755nZ m3508a(float f) {
        this.f4178kq = f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0755nZ m3509a(Vector3f vector3f) {
        this.f4179e = vector3f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0755nZ m3510b(Vector3f vector3f) {
        this.f4180m = vector3f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0755nZ m3511b(float f) {
        this.f4189kt = f;
        return this;
    }

    /* JADX INFO: renamed from: R */
    public String m3512R() {
        return this.f4188bK;
    }

    /* JADX INFO: renamed from: a */
    public C0755nZ m3513a(String str) {
        this.f4188bK = str;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public List<AbstractC0818oj<?>> m3514c() {
        return this.f4181ap;
    }

    /* JADX INFO: renamed from: aI */
    public float m3515aI() {
        return this.f4189kt;
    }

    @NotNull
    public ResourceLocation getIcon() {
        return this.icon;
    }
}
