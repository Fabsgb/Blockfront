package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hO.class */
public class C0425hO {

    /* JADX INFO: renamed from: S */
    @NotNull
    public static final List<C0426hP> f2774S = new ObjectArrayList();

    /* JADX INFO: renamed from: b */
    public static final C0426hP f2775b = m2000a(new C0426hP("bf.settings.category.notifications"));

    /* JADX INFO: renamed from: c */
    public static final C0426hP f2776c = m2000a(new C0426hP("bf.settings.category.content"));

    /* JADX INFO: renamed from: d */
    public static final C0426hP f2777d = m2000a(new C0426hP("bf.settings.category.audio"));

    /* JADX INFO: renamed from: e */
    public static final C0426hP f2778e = m2000a(new C0426hP("bf.settings.category.crosshair"));

    /* JADX INFO: renamed from: f */
    public static final C0426hP f2779f = m2000a(new C0426hP("bf.settings.category.ui"));

    /* JADX INFO: renamed from: g */
    public static final C0426hP f2780g = m2000a(new C0426hP("bf.settings.category.experimental"));

    /* JADX INFO: renamed from: h */
    public static final C0426hP f2781h = m2000a(new C0426hP("bf.settings.category.debug"));

    /* JADX INFO: renamed from: i */
    public static final C0426hP f2782i = m2000a(new C0426hP("bf.settings.category.rules", false));

    /* JADX INFO: renamed from: j */
    public static final C0426hP f2783j = m2000a(new C0426hP("bf.settings.category.internal", false));

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0426hP m2000a(@NotNull C0426hP c0426hP) {
        f2774S.add(c0426hP);
        return c0426hP;
    }
}
