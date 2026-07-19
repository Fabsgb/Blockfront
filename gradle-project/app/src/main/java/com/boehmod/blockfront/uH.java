package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uH.class */
public class uH {
    public static final uH a = new uH();
    public static final float no = 0.3f;
    public static final float np = 0.25f;
    public static final float nq = 0.4f;
    public static final float nr = 0.1f;
    public final boolean iy;
    public final float ns;
    public final float nt;
    public final boolean iz;

    @Nullable
    public ResourceLocation go;
    public float nu;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uH$a.class */
    public enum a {
        DEFAULT,
        SCOPE
    }

    public uH() {
        this(true, 0.3f, 0.25f, null, true);
    }

    public uH(float f) {
        this(true, f, 0.25f, null, true);
    }

    public uH(float f, float f2) {
        this(true, f, f2, null, true);
    }

    public uH(boolean z, float f, float f2) {
        this(z, f, f2, null, true);
    }

    public uH(boolean z, float f, float f2, boolean z2) {
        this(z, f, f2, null, z2);
    }

    public uH(boolean z, String str, boolean z2) {
        this(z, 0.3f, 0.25f, str, z2);
    }

    public uH(boolean z, float f, String str, boolean z2) {
        this(z, f, 0.25f, str, z2);
    }

    public uH(boolean z, float f, float f2, String str, boolean z2) {
        this.nu = 1.0f;
        this.iy = z;
        this.ns = f;
        this.nt = f2;
        this.iz = z2;
        this.go = str != null ? C0265jv.d("textures/misc/sights/" + str + ".png") : null;
    }

    @NotNull
    public uH a(float f) {
        this.nu = f;
        return this;
    }
}
