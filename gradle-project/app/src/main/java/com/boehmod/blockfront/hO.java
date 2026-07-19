package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hO.class */
public class hO {

    @NotNull
    public static final List<hP> S = new ObjectArrayList();
    public static final hP b = a(new hP("bf.settings.category.notifications"));
    public static final hP c = a(new hP("bf.settings.category.content"));
    public static final hP d = a(new hP("bf.settings.category.audio"));
    public static final hP e = a(new hP("bf.settings.category.crosshair"));
    public static final hP f = a(new hP("bf.settings.category.ui"));
    public static final hP g = a(new hP("bf.settings.category.experimental"));
    public static final hP h = a(new hP("bf.settings.category.debug"));
    public static final hP i = a(new hP("bf.settings.category.rules", false));
    public static final hP j = a(new hP("bf.settings.category.internal", false));

    @NotNull
    public static hP a(@NotNull hP hPVar) {
        S.add(hPVar);
        return hPVar;
    }
}
