package com.boehmod.blockfront;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ah */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ah.class */
public class C0064ah {

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final Map<EnumC0845pJ, Supplier<AbstractC0063ag>> f430d = new EnumMap(EnumC0845pJ.class);

    static {
        m281a(EnumC0845pJ.SNOW, C0071ao::new);
        m281a(EnumC0845pJ.LIGHT_SNOW, C0067ak::new);
        m281a(EnumC0845pJ.HEAVY_SNOW, C0066aj::new);
        m281a(EnumC0845pJ.FALLING_LEAVES, C0065ai::new);
        m281a(EnumC0845pJ.RAINSTORM, C0068al::new);
        m281a(EnumC0845pJ.SANDSTORM, C0069am::new);
        m281a(EnumC0845pJ.SANDY_FLOOR, C0070an::new);
        m281a(EnumC0845pJ.SNOWY_FLOOR, C0072ap::new);
    }

    /* JADX INFO: renamed from: a */
    private static void m281a(@NotNull EnumC0845pJ enumC0845pJ, @NotNull Supplier<AbstractC0063ag> supplier) {
        f430d.put(enumC0845pJ, supplier);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static AbstractC0063ag m282a(@NotNull EnumC0845pJ enumC0845pJ) {
        Supplier<AbstractC0063ag> supplier = f430d.get(enumC0845pJ);
        if (supplier == null) {
            return null;
        }
        return supplier.get();
    }
}
