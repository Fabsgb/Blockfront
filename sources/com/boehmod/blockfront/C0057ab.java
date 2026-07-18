package com.boehmod.blockfront;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ab */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ab.class */
public class C0057ab {

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final Map<EnumC0874pn, Supplier<AbstractC0056aa>> f387d = new EnumMap(EnumC0874pn.class);

    static {
        m228a(EnumC0874pn.SNOW, C0064ai::new);
        m228a(EnumC0874pn.LIGHT_SNOW, C0060ae::new);
        m228a(EnumC0874pn.HEAVY_SNOW, C0059ad::new);
        m228a(EnumC0874pn.FALLING_LEAVES, C0058ac::new);
        m228a(EnumC0874pn.RAINSTORM, C0061af::new);
        m228a(EnumC0874pn.SANDSTORM, C0062ag::new);
        m228a(EnumC0874pn.SANDY_FLOOR, C0063ah::new);
        m228a(EnumC0874pn.SNOWY_FLOOR, C0065aj::new);
    }

    /* JADX INFO: renamed from: a */
    private static void m228a(@NotNull EnumC0874pn enumC0874pn, @NotNull Supplier<AbstractC0056aa> supplier) {
        f387d.put(enumC0874pn, supplier);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static AbstractC0056aa m229a(@NotNull EnumC0874pn enumC0874pn) {
        Supplier<AbstractC0056aa> supplier = f387d.get(enumC0874pn);
        if (supplier == null) {
            return null;
        }
        return supplier.get();
    }
}
