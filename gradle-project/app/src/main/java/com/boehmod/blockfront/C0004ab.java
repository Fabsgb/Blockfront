package com.boehmod.blockfront;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ab, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ab.class */
public class C0004ab {

    @NotNull
    private static final Map<EnumC0419pn, Supplier<AbstractC0003aa>> d = new EnumMap(EnumC0419pn.class);

    static {
        a(EnumC0419pn.SNOW, C0011ai::new);
        a(EnumC0419pn.LIGHT_SNOW, C0007ae::new);
        a(EnumC0419pn.HEAVY_SNOW, C0006ad::new);
        a(EnumC0419pn.FALLING_LEAVES, C0005ac::new);
        a(EnumC0419pn.RAINSTORM, C0008af::new);
        a(EnumC0419pn.SANDSTORM, C0009ag::new);
        a(EnumC0419pn.SANDY_FLOOR, C0010ah::new);
        a(EnumC0419pn.SNOWY_FLOOR, C0012aj::new);
    }

    private static void a(@NotNull EnumC0419pn enumC0419pn, @NotNull Supplier<AbstractC0003aa> supplier) {
        d.put(enumC0419pn, supplier);
    }

    @Nullable
    public static AbstractC0003aa a(@NotNull EnumC0419pn enumC0419pn) {
        Supplier<AbstractC0003aa> supplier = d.get(enumC0419pn);
        if (supplier == null) {
            return null;
        }
        return supplier.get();
    }
}
