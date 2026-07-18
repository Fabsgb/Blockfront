package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.NotificationType;
import com.boehmod.blockfront.C1053tF;
import com.boehmod.blockfront.C1055tH;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hN.class */
public class C0424hN {

    /* JADX INFO: renamed from: R */
    @NotNull
    public static final List<C0423hM> f2712R = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final Object2IntMap<UUID> f2713a = new Object2IntOpenHashMap();

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final Object2IntMap<UUID> f2714b = new Object2IntOpenHashMap();

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final Object2IntMap<String> f2715c = new Object2IntOpenHashMap();

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final Object2ObjectMap<NotificationType, C0423hM> f2716d = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    public static final C0419hI f2717a = new C0419hI("bf.settings.crosshair.name", "crosshair.name", C0003A.f120a.m0g(), C0425hO.f2778e);

    /* JADX INFO: renamed from: b */
    public static final C0423hM f2718b = new C0423hM("bf.settings.crosshair.render", "crosshair.render", C0425hO.f2778e, true);

    /* JADX INFO: renamed from: c */
    public static final C0423hM f2719c = new C0423hM("bf.settings.crosshair.render.aiming", "crosshair.render.aiming", C0425hO.f2778e, false);

    /* JADX INFO: renamed from: d */
    public static final C0423hM f2720d = new C0423hM("bf.settings.crosshair.dot", "crosshair.dot", C0425hO.f2778e, true);

    /* JADX INFO: renamed from: e */
    public static final C0423hM f2721e = new C0423hM("bf.settings.crosshair.lines", "crosshair.lines", C0425hO.f2778e, true);

    /* JADX INFO: renamed from: f */
    public static final C0423hM f2722f = new C0423hM("bf.settings.crosshair.static", "crosshair.static", C0425hO.f2778e, false);

    /* JADX INFO: renamed from: g */
    public static final C0423hM f2723g = new C0423hM("bf.settings.crosshair.hitmarker", "crosshair.hitmarker", C0425hO.f2778e, true);

    /* JADX INFO: renamed from: a */
    public static final C0421hK f2724a = new C0421hK("bf.settings.crosshair.alpha", "crosshair.alpha", C0425hO.f2778e, 1.0f);

    /* JADX INFO: renamed from: b */
    public static final C0421hK f2725b = new C0421hK("bf.settings.crosshair.aim.sens", "crosshair.aim.sens", C0425hO.f2778e, 0.5f);

    /* JADX INFO: renamed from: c */
    public static final C0421hK f2726c = new C0421hK("bf.settings.crosshair.scope.sens", "crosshair.scope.sens", C0425hO.f2778e, 0.5f);

    /* JADX INFO: renamed from: h */
    public static final C0423hM f2727h = new C0423hM("bf.settings.crosshair.dynamic", "crosshair.dynamic", C0425hO.f2778e, false);

    /* JADX INFO: renamed from: i */
    public static final C0423hM f2728i = new C0423hM("bf.settings.crosshair.spreadfade", "crosshair.spreadfade", C0425hO.f2778e, true);

    /* JADX INFO: renamed from: j */
    public static final C0423hM f2729j = new C0423hM("bf.settings.ui.render.hud", "ui.render.hud", C0425hO.f2779f, true);

    /* JADX INFO: renamed from: k */
    public static final C0423hM f2730k = new C0423hM("bf.settings.ui.render.waypoints", "ui.render.waypoints", C0425hO.f2779f, true);

    /* JADX INFO: renamed from: l */
    public static final C0423hM f2731l = new C0423hM("bf.settings.ui.constant.hotbar", "ui.constant.hotbar", C0425hO.f2779f, false);

    /* JADX INFO: renamed from: m */
    public static final C0423hM f2732m = new C0423hM("bf.settings.ui.render.game.minimap", "ui.render.game.minimap", C0425hO.f2779f, false);

    /* JADX INFO: renamed from: n */
    public static final C0423hM f2733n = new C0423hM("bf.settings.ui.render.killfeed", "ui.render.killfeed", C0425hO.f2779f, true);

    /* JADX INFO: renamed from: o */
    public static final C0423hM f2734o = new C0423hM("bf.settings.ui.render.damageindicators", "ui.render.damageindicators", C0425hO.f2779f, true);

    /* JADX INFO: renamed from: p */
    public static final C0423hM f2735p = new C0423hM("bf.settings.ui.render.spectatorindicator", "ui.render.spectatorindicator", C0425hO.f2779f, true);

    /* JADX INFO: renamed from: q */
    public static final C0423hM f2736q = new C0423hM("bf.settings.ui.weapon.silhouette", "ui.render.weapon.silhouette.toggle", C0425hO.f2779f, false);

    /* JADX INFO: renamed from: r */
    public static final C0423hM f2737r = new C0423hM("bf.settings.ui.tab.background", "ui.render.tab.background", C0425hO.f2779f, true);

    /* JADX INFO: renamed from: s */
    public static final C0423hM f2738s = new C0423hM("bf.settings.ui.tab.blur", "ui.render.tab.blur", C0425hO.f2779f, true);

    /* JADX INFO: renamed from: t */
    public static final C0423hM f2739t = new C0423hM("bf.settings.ui.tab.death.motion.sickness", "ui.render.tab.death.motion.sickness", C0425hO.f2779f, false);

    /* JADX INFO: renamed from: u */
    public static final C0423hM f2740u = new C0423hM("bf.settings.ui.fps.display", "ui.render.fps.display", C0425hO.f2779f, false);

    /* JADX INFO: renamed from: v */
    public static final C0423hM f2741v = new C0423hM("bf.settings.ui.vanilla.ammo", "ui.render.vanilla.ammo", C0425hO.f2779f, true);

    /* JADX INFO: renamed from: w */
    public static final C0423hM f2742w = new C0423hM("bf.settings.ui.content.gore", "content.gore", C0425hO.f2776c, true);

    /* JADX INFO: renamed from: x */
    public static final C0423hM f2743x = m1998a(NotificationType.FRIEND_REQUESTS, new C0423hM("bf.settings.notifications.friend.requests", "notifications.friends.requests", C0425hO.f2775b, true));

    /* JADX INFO: renamed from: y */
    public static final C0423hM f2744y = m1998a(NotificationType.FRIEND_LOGINS, new C0423hM("bf.settings.notifications.friend.logins", "notifications.friends.logins", C0425hO.f2775b, true));

    /* JADX INFO: renamed from: z */
    public static final C0423hM f2745z = m1998a(NotificationType.FRIEND_RANK_UPS, new C0423hM("bf.settings.notifications.friend.rank.ups", "notifications.friends.rank.ups", C0425hO.f2775b, true));

    /* JADX INFO: renamed from: A */
    public static final C0423hM f2746A = m1998a(NotificationType.FRIEND_PRESTIGE, new C0423hM("bf.settings.notifications.friend.prestige", "notifications.friends.prestige", C0425hO.f2775b, true));

    /* JADX INFO: renamed from: B */
    public static final C0423hM f2747B = m1998a(NotificationType.RANK_UPS, new C0423hM("bf.settings.notifications.rank.ups", "notifications.rank.ups", C0425hO.f2775b, true));

    /* JADX INFO: renamed from: C */
    public static final C0423hM f2748C = m1998a(NotificationType.ACHIEVEMENTS, new C0423hM("bf.settings.notifications.achievements", "notifications.achievements", C0425hO.f2775b, true));

    /* JADX INFO: renamed from: D */
    public static final C0423hM f2749D = m1998a(NotificationType.DAILY_CHALLENGE, new C0423hM("bf.settings.notifications.daily.challenges", "notifications.daily.challenges", C0425hO.f2775b, true));

    /* JADX INFO: renamed from: E */
    public static final C0423hM f2750E = m1998a(NotificationType.PARTY_INVITES, new C0423hM("bf.settings.notifications.party.invites", "notifications.party.invites", C0425hO.f2775b, true));

    /* JADX INFO: renamed from: F */
    public static final C0423hM f2751F = new C0423hM("bf.settings.audio.bots", "audio.bots", C0425hO.f2777d, true);

    /* JADX INFO: renamed from: G */
    public static final C0423hM f2752G = new C0423hM("bf.settings.audio.capture.point.alarm", "audio.capture.point.alarm", C0425hO.f2777d, false);

    /* JADX INFO: renamed from: H */
    public static final C0423hM f2753H = new C0423hM("bf.settings.experimental.bullet.holes", "experimental.bullet.holes", C0425hO.f2780g, true);

    /* JADX INFO: renamed from: I */
    public static final C0423hM f2754I = new C0423hM("bf.settings.experimental.toggle.aim", "experimental.toggle.aim", C0425hO.f2780g, true);

    /* JADX INFO: renamed from: J */
    public static final C0423hM f2755J = new C0423hM("bf.settings.experimental.toggle.bobbing", "experimental.toggle.bobbing", C0425hO.f2780g, false);

    /* JADX INFO: renamed from: K */
    public static final C0423hM f2756K = new C0423hM("bf.settings.experimental.toggle.immersive.bobbing", "experimental.toggle.immersive.bobbing", C0425hO.f2780g, false);

    /* JADX INFO: renamed from: d */
    public static final C0421hK f2757d = new C0421hK("bf.settings.experimental.immersive.bobbing.scale", "experimental.immersive.bobbing.scale", C0425hO.f2780g, 0.5f);

    /* JADX INFO: renamed from: L */
    public static final C0423hM f2758L = new C0423hM("bf.settings.experimental.toggle.muzzleflash", "experimental.toggle.muzzleflash", C0425hO.f2780g, true);

    /* JADX INFO: renamed from: M */
    public static final C0423hM f2759M = new C0423hM("bf.settings.experimental.toggle.nametags", "experimental.toggle.nametags", C0425hO.f2780g, true);

    /* JADX INFO: renamed from: N */
    public static final C0423hM f2760N = new C0423hM("bf.settings.experimental.inspection.blur", "experimental.inspection.blur", C0425hO.f2780g, true);

    /* JADX INFO: renamed from: O */
    public static final C0423hM f2761O = new C0423hM("bf.settings.experimental.bullet.eject.puff", "experimental.bullet.eject.puff", C0425hO.f2780g, false);

    /* JADX INFO: renamed from: P */
    public static final C0423hM f2762P = new C0423hM("bf.settings.experimental.toggle.smoke.soft", "experimental.toggle.smoke.soft", C0425hO.f2780g, true);

    /* JADX INFO: renamed from: Q */
    public static final C0423hM f2763Q = new C0423hM("bf.settings.debug.toggle.armory.uuid", "debug.toggle.armory.uuid", C0425hO.f2781h, false);

    /* JADX INFO: renamed from: R */
    public static final C0423hM f2764R = new C0423hM("bf.settings.intro.epilepsy.warning", "intro.epilepsy.warning", C0425hO.f2782i, false);

    /* JADX INFO: renamed from: S */
    public static final C0423hM f2765S = new C0423hM("bf.settings.intro.rules", "intro.rules", C0425hO.f2782i, false);

    /* JADX INFO: renamed from: T */
    public static final C0423hM f2766T = new C0423hM("bf.settings.intro.content", "intro.content", C0425hO.f2782i, false);

    /* JADX INFO: renamed from: U */
    public static final C0423hM f2767U = new C0423hM("bf.settings.intro.discord", "intro.discord", C0425hO.f2782i, false);

    /* JADX INFO: renamed from: V */
    public static final C0423hM f2768V = new C0423hM("bf.settings.intro.patreon", "intro.patreon", C0425hO.f2782i, false);

    /* JADX INFO: renamed from: a */
    public static final C0420hJ<C1055tH.a> f2769a = new C0420hJ<>("bf.settings.internal.editor.wand.grab.mode", "internal.editor.wand.grab.mode", C0425hO.f2783j, C1055tH.a.NORMAL);

    /* JADX INFO: renamed from: b */
    public static final C0420hJ<C1053tF.a> f2770b = new C0420hJ<>("bf.settings.internal.creator.wand.mode", "internal.creator.wand.mode", C0425hO.f2783j, C1053tF.a.CREATE_INDEPENDENT);

    /* JADX INFO: renamed from: a */
    public static final C0428hR f2771a = new C0428hR("bf.settings.internal.seen.match.tips", "internal.seen.match.tips", C0425hO.f2783j);

    /* JADX INFO: renamed from: f */
    public static long f2772f = Calendar.getInstance().getTime().getTime();

    /* JADX INFO: renamed from: cI */
    public static boolean f2773cI = false;

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0423hM m1998a(@NotNull NotificationType notificationType, @NotNull C0423hM c0423hM) {
        f2716d.put(notificationType, c0423hM);
        return c0423hM;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1999a(@NotNull NotificationType notificationType) {
        if (!f2716d.containsKey(notificationType)) {
            return true;
        }
        return ((C0423hM) f2716d.get(notificationType)).m1996T();
    }
}
