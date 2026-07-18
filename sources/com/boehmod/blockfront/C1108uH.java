package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uH.class */
public class C1108uH {

    /* JADX INFO: renamed from: a */
    public static final C1108uH f5814a = new C1108uH();

    /* JADX INFO: renamed from: no */
    public static final float f5815no = 0.3f;

    /* JADX INFO: renamed from: np */
    public static final float f5816np = 0.25f;

    /* JADX INFO: renamed from: nq */
    public static final float f5817nq = 0.4f;

    /* JADX INFO: renamed from: nr */
    public static final float f5818nr = 0.1f;

    /* JADX INFO: renamed from: iy */
    public final boolean f5819iy;

    /* JADX INFO: renamed from: ns */
    public final float f5820ns;

    /* JADX INFO: renamed from: nt */
    public final float f5821nt;

    /* JADX INFO: renamed from: iz */
    public final boolean f5822iz;

    /* JADX INFO: renamed from: go */
    @Nullable
    public ResourceLocation f5823go;

    /* JADX INFO: renamed from: nu */
    public float f5824nu;

    /* JADX INFO: renamed from: com.boehmod.blockfront.uH$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uH$a.class */
    public enum a {
        DEFAULT,
        SCOPE
    }

    public C1108uH() {
        this(true, 0.3f, 0.25f, null, true);
    }

    public C1108uH(float f) {
        this(true, f, 0.25f, null, true);
    }

    public C1108uH(float f, float f2) {
        this(true, f, f2, null, true);
    }

    public C1108uH(boolean z, float f, float f2) {
        this(z, f, f2, null, true);
    }

    public C1108uH(boolean z, float f, float f2, boolean z2) {
        this(z, f, f2, null, z2);
    }

    public C1108uH(boolean z, String str, boolean z2) {
        this(z, 0.3f, 0.25f, str, z2);
    }

    public C1108uH(boolean z, float f, String str, boolean z2) {
        this(z, f, 0.25f, str, z2);
    }

    public C1108uH(boolean z, float f, float f2, String str, boolean z2) {
        this.f5824nu = 1.0f;
        this.f5819iy = z;
        this.f5820ns = f;
        this.f5821nt = f2;
        this.f5822iz = z2;
        this.f5823go = str != null ? C0564jv.m2555d("textures/misc/sights/" + str + ".png") : null;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1108uH m6110a(float f) {
        this.f5824nu = f;
        return this;
    }
}
