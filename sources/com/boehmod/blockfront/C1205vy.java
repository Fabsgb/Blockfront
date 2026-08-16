package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vy.class */
public class C1205vy {

    /* JADX INFO: renamed from: ar */
    @NotNull
    public static final Map<String, C1204vx> f6565ar = new Object2ObjectOpenHashMap();

    static {
        f6565ar.put("europe", new C1204vx().m6893a(EnumC1203vw.CONCLUDE, (SoundEvent) C1312xz.f7916op.get()).m6893a(EnumC1203vw.CONCLUDE_GENERIC, (SoundEvent) C1312xz.f7917oq.get()).m6893a(EnumC1203vw.START, (SoundEvent) C1312xz.f7921ou.get()).m6893a(EnumC1203vw.START_GENERIC, (SoundEvent) C1312xz.f7922ov.get()).m6893a(EnumC1203vw.SUSPENSE_ONE, (SoundEvent) C1312xz.f7918or.get()).m6893a(EnumC1203vw.SUSPENSE_TWO, (SoundEvent) C1312xz.f7919os.get()).m6893a(EnumC1203vw.SUSPENSE_THREE, (SoundEvent) C1312xz.f7920ot.get()).m6893a(EnumC1203vw.WARMUP, (SoundEvent) C1312xz.f7923ow.get()).m6893a(EnumC1203vw.OFFENSIVE_POINT_TAKEN, (SoundEvent) C1312xz.f7924ox.get()).m6893a(EnumC1203vw.OFFENSIVE_REINFORCEMENTS_HINT, (SoundEvent) C1312xz.f7925oy.get()).m6893a(EnumC1203vw.OFFENSIVE_REINFORCEMENTS_ARRIVE, (SoundEvent) C1312xz.f7926oz.get()));
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static String[] m6895b() {
        return (String[]) f6565ar.keySet().toArray(new String[0]);
    }
}
