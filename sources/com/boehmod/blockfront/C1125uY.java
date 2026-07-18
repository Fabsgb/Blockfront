package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uY.class */
public class C1125uY {

    /* JADX INFO: renamed from: ar */
    @NotNull
    public static final Map<String, C1124uX> f5926ar = new Object2ObjectOpenHashMap();

    static {
        f5926ar.put("europe", new C1124uX().m6240a(EnumC1123uW.CONCLUDE, (SoundEvent) C1280xc.f7504on.get()).m6240a(EnumC1123uW.CONCLUDE_GENERIC, (SoundEvent) C1280xc.f7505oo.get()).m6240a(EnumC1123uW.START, (SoundEvent) C1280xc.f7509os.get()).m6240a(EnumC1123uW.START_GENERIC, (SoundEvent) C1280xc.f7510ot.get()).m6240a(EnumC1123uW.SUSPENSE_ONE, (SoundEvent) C1280xc.f7506op.get()).m6240a(EnumC1123uW.SUSPENSE_TWO, (SoundEvent) C1280xc.f7507oq.get()).m6240a(EnumC1123uW.SUSPENSE_THREE, (SoundEvent) C1280xc.f7508or.get()).m6240a(EnumC1123uW.WARMUP, (SoundEvent) C1280xc.f7511ou.get()).m6240a(EnumC1123uW.OFFENSIVE_POINT_TAKEN, (SoundEvent) C1280xc.f7512ov.get()).m6240a(EnumC1123uW.OFFENSIVE_REINFORCEMENTS_HINT, (SoundEvent) C1280xc.f7513ow.get()).m6240a(EnumC1123uW.OFFENSIVE_REINFORCEMENTS_ARRIVE, (SoundEvent) C1280xc.f7514ox.get()));
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static String[] m6242b() {
        return (String[]) f5926ar.keySet().toArray(new String[0]);
    }
}
