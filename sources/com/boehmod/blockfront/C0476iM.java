package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractFeatureFlagManager;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.iM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iM.class */
public class C0476iM extends AbstractFeatureFlagManager {

    /* JADX INFO: renamed from: aw */
    @Nullable
    public static String f2916aw = null;

    /* JADX INFO: renamed from: de */
    public static boolean f2917de = true;

    /* JADX INFO: renamed from: df */
    public static boolean f2918df = true;

    /* JADX INFO: renamed from: dg */
    public static boolean f2919dg = true;

    /* JADX INFO: renamed from: dh */
    public static boolean f2920dh = true;

    /* JADX INFO: renamed from: di */
    public static boolean f2921di = true;

    /* JADX INFO: renamed from: dj */
    public static boolean f2922dj = true;

    /* JADX INFO: renamed from: dk */
    public static boolean f2923dk = true;

    /* JADX INFO: renamed from: dl */
    public static boolean f2924dl = true;

    /* JADX INFO: renamed from: dm */
    public static boolean f2925dm = true;

    /* JADX INFO: renamed from: dn */
    public static boolean f2926dn = true;

    public C0476iM() {
        m2153aV();
    }

    /* JADX INFO: renamed from: aV */
    private void m2153aV() {
        f2916aw = null;
        if (isEnabled("event_halloween")) {
            f2916aw = "halloween";
        } else if (isEnabled("event_christmas")) {
            f2916aw = "christmas";
        }
        f2918df = isEnabled("server_shot_validation", true);
        f2919dg = isEnabled("server_shot_validation_spread", true);
        f2920dh = isEnabled("server_shot_validation_kick");
        f2921di = isEnabled("server_shot_validation_report");
        f2917de = isEnabled("server_match_feature_ping");
        f2922dj = isEnabled("server_grenade_cook_drop_on_death", true);
        f2923dk = isEnabled("client_fancy_bullet_effects");
        f2924dl = isEnabled("client_veil_fancy_gun_light");
        f2925dm = isEnabled("server_player_voice_sounds", true);
        f2926dn = isEnabled("server_chat_markdown", true);
    }

    @Override // com.boehmod.bflib.cloud.common.AbstractFeatureFlagManager
    protected void featureFlagsChanged() {
        m2153aV();
    }
}
