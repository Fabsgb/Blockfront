package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vh.class */
public class C1188vh {

    /* JADX INFO: renamed from: a */
    public static final C1188vh f6453a = new C1188vh();

    /* JADX INFO: renamed from: om */
    public static final float f6454om = 0.3f;

    /* JADX INFO: renamed from: on */
    public static final float f6455on = 0.25f;

    /* JADX INFO: renamed from: oo */
    public static final float f6456oo = 0.4f;

    /* JADX INFO: renamed from: op */
    public static final float f6457op = 0.1f;

    /* JADX INFO: renamed from: iS */
    public final boolean f6458iS;

    /* JADX INFO: renamed from: oq */
    public final float f6459oq;

    /* JADX INFO: renamed from: or */
    public final float f6460or;

    /* JADX INFO: renamed from: iT */
    public final boolean f6461iT;

    /* JADX INFO: renamed from: go */
    @Nullable
    public ResourceLocation f6462go;

    /* JADX INFO: renamed from: os */
    public float f6463os;

    /* JADX INFO: renamed from: com.boehmod.blockfront.vh$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vh$a.class */
    public enum a {
        DEFAULT,
        SCOPE
    }

    public C1188vh() {
        this(true, 0.3f, 0.25f, null, true);
    }

    public C1188vh(float f) {
        this(true, f, 0.25f, null, true);
    }

    public C1188vh(float f, float f2) {
        this(true, f, f2, null, true);
    }

    public C1188vh(boolean z, float f, float f2) {
        this(z, f, f2, null, true);
    }

    public C1188vh(boolean z, float f, float f2, boolean z2) {
        this(z, f, f2, null, z2);
    }

    public C1188vh(boolean z, String str, boolean z2) {
        this(z, 0.3f, 0.25f, str, z2);
    }

    public C1188vh(boolean z, float f, String str, boolean z2) {
        this(z, f, 0.25f, str, z2);
    }

    public C1188vh(boolean z, float f, float f2, String str, boolean z2) {
        this.f6463os = 1.0f;
        this.f6458iS = z;
        this.f6459oq = f;
        this.f6460or = f2;
        this.f6461iT = z2;
        this.f6462go = str != null ? C0532jO.m2378d("textures/misc/sights/" + str + ".png") : null;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1188vh m6763a(float f) {
        this.f6463os = f;
        return this;
    }
}
