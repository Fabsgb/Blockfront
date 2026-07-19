package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uY.class */
public class uY {

    @NotNull
    public static final Map<String, uX> ar = new Object2ObjectOpenHashMap();

    static {
        ar.put("europe", new uX().a(uW.CONCLUDE, (SoundEvent) C0624xc.on.get()).a(uW.CONCLUDE_GENERIC, (SoundEvent) C0624xc.oo.get()).a(uW.START, (SoundEvent) C0624xc.os.get()).a(uW.START_GENERIC, (SoundEvent) C0624xc.ot.get()).a(uW.SUSPENSE_ONE, (SoundEvent) C0624xc.op.get()).a(uW.SUSPENSE_TWO, (SoundEvent) C0624xc.oq.get()).a(uW.SUSPENSE_THREE, (SoundEvent) C0624xc.or.get()).a(uW.WARMUP, (SoundEvent) C0624xc.ou.get()).a(uW.OFFENSIVE_POINT_TAKEN, (SoundEvent) C0624xc.ov.get()).a(uW.OFFENSIVE_REINFORCEMENTS_HINT, (SoundEvent) C0624xc.ow.get()).a(uW.OFFENSIVE_REINFORCEMENTS_ARRIVE, (SoundEvent) C0624xc.ox.get()));
    }

    @NotNull
    public static String[] b() {
        return (String[]) ar.keySet().toArray(new String[0]);
    }
}
