package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractFeatureFlagManager;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iM.class */
public class iM extends AbstractFeatureFlagManager {

    @Nullable
    public static String aw = null;

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    public static boolean f417de = true;
    public static boolean df = true;
    public static boolean dg = true;
    public static boolean dh = true;
    public static boolean di = true;
    public static boolean dj = true;
    public static boolean dk = true;
    public static boolean dl = true;
    public static boolean dm = true;
    public static boolean dn = true;

    public iM() {
        aV();
    }

    private void aV() {
        aw = null;
        if (isEnabled("event_halloween")) {
            aw = "halloween";
        } else if (isEnabled("event_christmas")) {
            aw = "christmas";
        }
        df = isEnabled("server_shot_validation", true);
        dg = isEnabled("server_shot_validation_spread", true);
        dh = isEnabled("server_shot_validation_kick");
        di = isEnabled("server_shot_validation_report");
        f417de = isEnabled("server_match_feature_ping");
        dj = isEnabled("server_grenade_cook_drop_on_death", true);
        dk = isEnabled("client_fancy_bullet_effects");
        dl = isEnabled("client_veil_fancy_gun_light");
        dm = isEnabled("server_player_voice_sounds", true);
        dn = isEnabled("server_chat_markdown", true);
    }

    @Override // com.boehmod.bflib.cloud.common.AbstractFeatureFlagManager
    protected void featureFlagsChanged() {
        aV();
    }
}
