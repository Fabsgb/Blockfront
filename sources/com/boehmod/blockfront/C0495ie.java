package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.NotificationType;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ie */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ie.class */
public class C0495ie {

    /* JADX INFO: renamed from: U */
    @NotNull
    public static final List<C0494id> f3013U = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final Object2IntMap<UUID> f3014a = new Object2IntOpenHashMap();

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final Object2IntMap<UUID> f3015b = new Object2IntOpenHashMap();

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final Object2IntMap<String> f3016c = new Object2IntOpenHashMap();

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final Object2ObjectMap<NotificationType, C0494id> f3017d = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    public static final C0436hY f3018a = new C0436hY("bf.settings.crosshair.name", "crosshair.name", C0010G.f158a.m32k(), C0496if.f3080e);

    /* JADX INFO: renamed from: b */
    public static final C0494id f3019b = new C0494id("bf.settings.crosshair.render", "crosshair.render", C0496if.f3080e, true);

    /* JADX INFO: renamed from: c */
    public static final C0494id f3020c = new C0494id("bf.settings.crosshair.render.aiming", "crosshair.render.aiming", C0496if.f3080e, false);

    /* JADX INFO: renamed from: d */
    public static final C0494id f3021d = new C0494id("bf.settings.crosshair.dot", "crosshair.dot", C0496if.f3080e, true);

    /* JADX INFO: renamed from: e */
    public static final C0494id f3022e = new C0494id("bf.settings.crosshair.lines", "crosshair.lines", C0496if.f3080e, true);

    /* JADX INFO: renamed from: f */
    public static final C0494id f3023f = new C0494id("bf.settings.crosshair.static", "crosshair.static", C0496if.f3080e, false);

    /* JADX INFO: renamed from: g */
    public static final C0494id f3024g = new C0494id("bf.settings.crosshair.hitmarker", "crosshair.hitmarker", C0496if.f3080e, true);

    /* JADX INFO: renamed from: a */
    public static final C0491ia f3025a = new C0491ia("bf.settings.crosshair.alpha", "crosshair.alpha", C0496if.f3080e, 1.0f);

    /* JADX INFO: renamed from: b */
    public static final C0491ia f3026b = new C0491ia("bf.settings.crosshair.aim.sens", "crosshair.aim.sens", C0496if.f3080e, 0.5f);

    /* JADX INFO: renamed from: c */
    public static final C0491ia f3027c = new C0491ia("bf.settings.crosshair.scope.sens", "crosshair.scope.sens", C0496if.f3080e, 0.5f);

    /* JADX INFO: renamed from: h */
    public static final C0494id f3028h = new C0494id("bf.settings.crosshair.dynamic", "crosshair.dynamic", C0496if.f3080e, false);

    /* JADX INFO: renamed from: i */
    public static final C0494id f3029i = new C0494id("bf.settings.crosshair.spreadfade", "crosshair.spreadfade", C0496if.f3080e, true);

    /* JADX INFO: renamed from: j */
    public static final C0494id f3030j = new C0494id("bf.settings.ui.render.hud", "ui.render.hud", C0496if.f3081f, true);

    /* JADX INFO: renamed from: k */
    public static final C0494id f3031k = new C0494id("bf.settings.ui.render.waypoints", "ui.render.waypoints", C0496if.f3081f, true);

    /* JADX INFO: renamed from: l */
    public static final C0494id f3032l = new C0494id("bf.settings.ui.constant.hotbar", "ui.constant.hotbar", C0496if.f3081f, false);

    /* JADX INFO: renamed from: m */
    public static final C0494id f3033m = new C0494id("bf.settings.ui.render.game.minimap", "ui.render.game.minimap", C0496if.f3081f, false);

    /* JADX INFO: renamed from: n */
    public static final C0494id f3034n = new C0494id("bf.settings.ui.render.killfeed", "ui.render.killfeed", C0496if.f3081f, true);

    /* JADX INFO: renamed from: o */
    public static final C0494id f3035o = new C0494id("bf.settings.ui.render.damageindicators", "ui.render.damageindicators", C0496if.f3081f, true);

    /* JADX INFO: renamed from: p */
    public static final C0494id f3036p = new C0494id("bf.settings.ui.render.spectatorindicator", "ui.render.spectatorindicator", C0496if.f3081f, true);

    /* JADX INFO: renamed from: q */
    public static final C0494id f3037q = new C0494id("bf.settings.ui.weapon.silhouette", "ui.render.weapon.silhouette.toggle", C0496if.f3081f, false);

    /* JADX INFO: renamed from: r */
    public static final C0494id f3038r = new C0494id("bf.settings.ui.tab.background", "ui.render.tab.background", C0496if.f3081f, true);

    /* JADX INFO: renamed from: s */
    public static final C0494id f3039s = new C0494id("bf.settings.ui.tab.blur", "ui.render.tab.blur", C0496if.f3081f, true);

    /* JADX INFO: renamed from: t */
    public static final C0494id f3040t = new C0494id("bf.settings.ui.tab.death.motion.sickness", "ui.render.tab.death.motion.sickness", C0496if.f3081f, false);

    /* JADX INFO: renamed from: u */
    public static final C0494id f3041u = new C0494id("bf.settings.ui.fps.display", "ui.render.fps.display", C0496if.f3081f, false);

    /* JADX INFO: renamed from: v */
    public static final C0494id f3042v = new C0494id("bf.settings.ui.vanilla.ammo", "ui.render.vanilla.ammo", C0496if.f3081f, true);

    /* JADX INFO: renamed from: w */
    public static final C0494id f3043w = new C0494id("bf.settings.ui.content.gore", "content.gore", C0496if.f3078c, true);

    /* JADX INFO: renamed from: x */
    public static final C0494id f3044x = m2232a(NotificationType.FRIEND_REQUESTS, new C0494id("bf.settings.notifications.friend.requests", "notifications.friends.requests", C0496if.f3077b, true));

    /* JADX INFO: renamed from: y */
    public static final C0494id f3045y = m2232a(NotificationType.FRIEND_LOGINS, new C0494id("bf.settings.notifications.friend.logins", "notifications.friends.logins", C0496if.f3077b, true));

    /* JADX INFO: renamed from: z */
    public static final C0494id f3046z = m2232a(NotificationType.FRIEND_RANK_UPS, new C0494id("bf.settings.notifications.friend.rank.ups", "notifications.friends.rank.ups", C0496if.f3077b, true));

    /* JADX INFO: renamed from: A */
    public static final C0494id f3047A = m2232a(NotificationType.FRIEND_PRESTIGE, new C0494id("bf.settings.notifications.friend.prestige", "notifications.friends.prestige", C0496if.f3077b, true));

    /* JADX INFO: renamed from: B */
    public static final C0494id f3048B = m2232a(NotificationType.RANK_UPS, new C0494id("bf.settings.notifications.rank.ups", "notifications.rank.ups", C0496if.f3077b, true));

    /* JADX INFO: renamed from: C */
    public static final C0494id f3049C = m2232a(NotificationType.ACHIEVEMENTS, new C0494id("bf.settings.notifications.achievements", "notifications.achievements", C0496if.f3077b, true));

    /* JADX INFO: renamed from: D */
    public static final C0494id f3050D = m2232a(NotificationType.DAILY_CHALLENGE, new C0494id("bf.settings.notifications.daily.challenges", "notifications.daily.challenges", C0496if.f3077b, true));

    /* JADX INFO: renamed from: E */
    public static final C0494id f3051E = m2232a(NotificationType.PARTY_INVITES, new C0494id("bf.settings.notifications.party.invites", "notifications.party.invites", C0496if.f3077b, true));

    /* JADX INFO: renamed from: F */
    public static final C0494id f3052F = new C0494id("bf.settings.audio.bots", "audio.bots", C0496if.f3079d, true);

    /* JADX INFO: renamed from: G */
    public static final C0494id f3053G = new C0494id("bf.settings.audio.capture.point.alarm", "audio.capture.point.alarm", C0496if.f3079d, false);

    /* JADX INFO: renamed from: H */
    public static final C0494id f3054H = new C0494id("bf.settings.experimental.bullet.holes", "experimental.bullet.holes", C0496if.f3082g, true);

    /* JADX INFO: renamed from: I */
    public static final C0494id f3055I = new C0494id("bf.settings.experimental.toggle.aim", "experimental.toggle.aim", C0496if.f3082g, true);

    /* JADX INFO: renamed from: J */
    public static final C0494id f3056J = new C0494id("bf.settings.experimental.toggle.bobbing", "experimental.toggle.bobbing", C0496if.f3082g, false);

    /* JADX INFO: renamed from: K */
    public static final C0494id f3057K = new C0494id("bf.settings.experimental.toggle.immersive.bobbing", "experimental.toggle.immersive.bobbing", C0496if.f3082g, false);

    /* JADX INFO: renamed from: d */
    public static final C0491ia f3058d = new C0491ia("bf.settings.experimental.immersive.bobbing.scale", "experimental.immersive.bobbing.scale", C0496if.f3082g, 0.5f);

    /* JADX INFO: renamed from: L */
    public static final C0494id f3059L = new C0494id("bf.settings.experimental.toggle.muzzleflash", "experimental.toggle.muzzleflash", C0496if.f3082g, true);

    /* JADX INFO: renamed from: M */
    public static final C0494id f3060M = new C0494id("bf.settings.experimental.toggle.nametags", "experimental.toggle.nametags", C0496if.f3082g, true);

    /* JADX INFO: renamed from: N */
    public static final C0494id f3061N = new C0494id("bf.settings.experimental.inspection.blur", "experimental.inspection.blur", C0496if.f3082g, true);

    /* JADX INFO: renamed from: O */
    public static final C0494id f3062O = new C0494id("bf.settings.experimental.bullet.eject.puff", "experimental.bullet.eject.puff", C0496if.f3082g, false);

    /* JADX INFO: renamed from: P */
    public static final C0494id f3063P = new C0494id("bf.settings.experimental.toggle.smoke.soft", "experimental.toggle.smoke.soft", C0496if.f3082g, true);

    /* JADX INFO: renamed from: Q */
    public static final C0494id f3064Q = new C0494id("bf.settings.debug.toggle.armory.uuid", "debug.toggle.armory.uuid", C0496if.f3083h, false);

    /* JADX INFO: renamed from: R */
    public static final C0494id f3065R = new C0494id("bf.settings.intro.epilepsy.warning", "intro.epilepsy.warning", C0496if.f3084i, false);

    /* JADX INFO: renamed from: S */
    public static final C0494id f3066S = new C0494id("bf.settings.intro.rules", "intro.rules", C0496if.f3084i, false);

    /* JADX INFO: renamed from: T */
    public static final C0494id f3067T = new C0494id("bf.settings.intro.content", "intro.content", C0496if.f3084i, false);

    /* JADX INFO: renamed from: U */
    public static final C0494id f3068U = new C0494id("bf.settings.intro.discord", "intro.discord", C0496if.f3084i, false);

    /* JADX INFO: renamed from: V */
    public static final C0494id f3069V = new C0494id("bf.settings.intro.patreon", "intro.patreon", C0496if.f3084i, false);

    /* JADX INFO: renamed from: a */
    public static final C0437hZ<C1133uf.a> f3070a = new C0437hZ<>("bf.settings.internal.editor.wand.grab.mode", "internal.editor.wand.grab.mode", C0496if.f3085j, C1133uf.a.NORMAL);

    /* JADX INFO: renamed from: b */
    public static final C0437hZ<C1131ud.a> f3071b = new C0437hZ<>("bf.settings.internal.creator.wand.mode", "internal.creator.wand.mode", C0496if.f3085j, C1131ud.a.CREATE_INDEPENDENT);

    /* JADX INFO: renamed from: a */
    public static final C0499ii f3072a = new C0499ii("bf.settings.internal.seen.match.tips", "internal.seen.match.tips", C0496if.f3085j);

    /* JADX INFO: renamed from: a */
    public static final C0493ic f3073a = new C0493ic("bf.settings.internal.seen.news.articles", "internal.seen.news.articles", C0496if.f3085j);

    /* JADX INFO: renamed from: k */
    public static long f3074k = Calendar.getInstance().getTime().getTime();

    /* JADX INFO: renamed from: cR */
    public static boolean f3075cR = false;

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0494id m2232a(@NotNull NotificationType notificationType, @NotNull C0494id c0494id) {
        f3017d.put(notificationType, c0494id);
        return c0494id;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2233a(@NotNull NotificationType notificationType) {
        if (!f3017d.containsKey(notificationType)) {
            return true;
        }
        return ((C0494id) f3017d.get(notificationType)).m2230U();
    }
}
