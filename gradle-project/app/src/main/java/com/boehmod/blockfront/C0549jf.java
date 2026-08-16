package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractFeatureFlagManager;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.ints.IntSets;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.jf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jf.class */
public class C0549jf extends AbstractFeatureFlagManager {

    /* JADX INFO: renamed from: aC */
    @Nullable
    public static String f3265aC = null;

    /* JADX INFO: renamed from: do */
    public static boolean f3266do = true;

    /* JADX INFO: renamed from: dp */
    public static boolean f3267dp = true;

    /* JADX INFO: renamed from: dq */
    public static boolean f3268dq = true;

    /* JADX INFO: renamed from: dr */
    public static boolean f3269dr = true;

    /* JADX INFO: renamed from: ds */
    public static boolean f3270ds = true;

    /* JADX INFO: renamed from: dt */
    public static boolean f3271dt = false;

    /* JADX INFO: renamed from: du */
    public static boolean f3272du = true;

    /* JADX INFO: renamed from: dv */
    public static boolean f3273dv = true;

    /* JADX INFO: renamed from: dw */
    public static boolean f3274dw = true;

    /* JADX INFO: renamed from: dx */
    public static boolean f3275dx = true;

    /* JADX INFO: renamed from: dy */
    public static boolean f3276dy = true;

    /* JADX INFO: renamed from: b */
    @Nonnull
    public static volatile IntSet f3277b = IntSets.EMPTY_SET;

    public C0549jf() {
        m2480bh();
    }

    /* JADX INFO: renamed from: bh */
    private void m2480bh() {
        f3265aC = null;
        if (isEnabled("event_halloween")) {
            f3265aC = "halloween";
        } else if (isEnabled("event_christmas")) {
            f3265aC = "christmas";
        }
        f3267dp = isEnabled("server_shot_validation", true);
        f3268dq = isEnabled("server_shot_validation_spread", true);
        f3269dr = isEnabled("server_shot_validation_kick");
        f3270ds = isEnabled("server_shot_validation_report");
        f3271dt = isEnabled("server_shot_validation_aim");
        f3266do = isEnabled("server_match_feature_ping");
        f3272du = isEnabled("server_grenade_cook_drop_on_death", true);
        f3273dv = isEnabled("client_fancy_bullet_effects");
        f3274dw = isEnabled("client_veil_fancy_gun_light");
        f3275dx = isEnabled("server_player_voice_sounds", true);
        f3276dy = isEnabled("server_chat_markdown", true);
        IntOpenHashSet intOpenHashSet = new IntOpenHashSet();
        for (int i = 1; i <= 11; i++) {
            if (!isEnabled("client_ac_layer_" + i, true)) {
                intOpenHashSet.add(i);
            }
        }
        f3277b = intOpenHashSet;
        C0530jM.log("Feature flags resolved: validation=%s, spread=%s, kick=%s, report=%s, aim=%s", Boolean.valueOf(f3267dp), Boolean.valueOf(f3268dq), Boolean.valueOf(f3269dr), Boolean.valueOf(f3270ds), Boolean.valueOf(f3271dt));
    }

    @Override // com.boehmod.bflib.cloud.common.AbstractFeatureFlagManager
    protected void featureFlagsChanged() {
        m2480bh();
    }
}
