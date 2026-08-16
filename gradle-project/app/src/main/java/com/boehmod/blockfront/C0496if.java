package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.if */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/if.class */
public class C0496if {

    /* JADX INFO: renamed from: V */
    @NotNull
    public static final List<C0497ig> f3076V = new ObjectArrayList();

    /* JADX INFO: renamed from: b */
    public static final C0497ig f3077b = m2234a(new C0497ig("bf.settings.category.notifications"));

    /* JADX INFO: renamed from: c */
    public static final C0497ig f3078c = m2234a(new C0497ig("bf.settings.category.content"));

    /* JADX INFO: renamed from: d */
    public static final C0497ig f3079d = m2234a(new C0497ig("bf.settings.category.audio"));

    /* JADX INFO: renamed from: e */
    public static final C0497ig f3080e = m2234a(new C0497ig("bf.settings.category.crosshair"));

    /* JADX INFO: renamed from: f */
    public static final C0497ig f3081f = m2234a(new C0497ig("bf.settings.category.ui"));

    /* JADX INFO: renamed from: g */
    public static final C0497ig f3082g = m2234a(new C0497ig("bf.settings.category.experimental"));

    /* JADX INFO: renamed from: h */
    public static final C0497ig f3083h = m2234a(new C0497ig("bf.settings.category.debug"));

    /* JADX INFO: renamed from: i */
    public static final C0497ig f3084i = m2234a(new C0497ig("bf.settings.category.rules", false));

    /* JADX INFO: renamed from: j */
    public static final C0497ig f3085j = m2234a(new C0497ig("bf.settings.category.internal", false));

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0497ig m2234a(@NotNull C0497ig c0497ig) {
        f3076V.add(c0497ig);
        return c0497ig;
    }
}
