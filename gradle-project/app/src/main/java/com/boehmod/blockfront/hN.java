package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.NotificationType;
import com.boehmod.blockfront.tF;
import com.boehmod.blockfront.tH;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hN.class */
public class hN {

    @NotNull
    public static final List<hM> R = new ObjectArrayList();

    @NotNull
    public static final Object2IntMap<UUID> a = new Object2IntOpenHashMap();

    @NotNull
    public static final Object2IntMap<UUID> b = new Object2IntOpenHashMap();

    @NotNull
    public static final Object2IntMap<String> c = new Object2IntOpenHashMap();

    @NotNull
    public static final Object2ObjectMap<NotificationType, hM> d = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final hI f149a = new hI("bf.settings.crosshair.name", "crosshair.name", A.f1a.g(), hO.e);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final hM f150b = new hM("bf.settings.crosshair.render", "crosshair.render", hO.e, true);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final hM f151c = new hM("bf.settings.crosshair.render.aiming", "crosshair.render.aiming", hO.e, false);

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final hM f152d = new hM("bf.settings.crosshair.dot", "crosshair.dot", hO.e, true);
    public static final hM e = new hM("bf.settings.crosshair.lines", "crosshair.lines", hO.e, true);
    public static final hM f = new hM("bf.settings.crosshair.static", "crosshair.static", hO.e, false);
    public static final hM g = new hM("bf.settings.crosshair.hitmarker", "crosshair.hitmarker", hO.e, true);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final hK f153a = new hK("bf.settings.crosshair.alpha", "crosshair.alpha", hO.e, 1.0f);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final hK f154b = new hK("bf.settings.crosshair.aim.sens", "crosshair.aim.sens", hO.e, 0.5f);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final hK f155c = new hK("bf.settings.crosshair.scope.sens", "crosshair.scope.sens", hO.e, 0.5f);
    public static final hM h = new hM("bf.settings.crosshair.dynamic", "crosshair.dynamic", hO.e, false);
    public static final hM i = new hM("bf.settings.crosshair.spreadfade", "crosshair.spreadfade", hO.e, true);
    public static final hM j = new hM("bf.settings.ui.render.hud", "ui.render.hud", hO.f, true);
    public static final hM k = new hM("bf.settings.ui.render.waypoints", "ui.render.waypoints", hO.f, true);
    public static final hM l = new hM("bf.settings.ui.constant.hotbar", "ui.constant.hotbar", hO.f, false);
    public static final hM m = new hM("bf.settings.ui.render.game.minimap", "ui.render.game.minimap", hO.f, false);
    public static final hM n = new hM("bf.settings.ui.render.killfeed", "ui.render.killfeed", hO.f, true);
    public static final hM o = new hM("bf.settings.ui.render.damageindicators", "ui.render.damageindicators", hO.f, true);
    public static final hM p = new hM("bf.settings.ui.render.spectatorindicator", "ui.render.spectatorindicator", hO.f, true);
    public static final hM q = new hM("bf.settings.ui.weapon.silhouette", "ui.render.weapon.silhouette.toggle", hO.f, false);
    public static final hM r = new hM("bf.settings.ui.tab.background", "ui.render.tab.background", hO.f, true);
    public static final hM s = new hM("bf.settings.ui.tab.blur", "ui.render.tab.blur", hO.f, true);
    public static final hM t = new hM("bf.settings.ui.tab.death.motion.sickness", "ui.render.tab.death.motion.sickness", hO.f, false);
    public static final hM u = new hM("bf.settings.ui.fps.display", "ui.render.fps.display", hO.f, false);
    public static final hM v = new hM("bf.settings.ui.vanilla.ammo", "ui.render.vanilla.ammo", hO.f, true);
    public static final hM w = new hM("bf.settings.ui.content.gore", "content.gore", hO.c, true);
    public static final hM x = a(NotificationType.FRIEND_REQUESTS, new hM("bf.settings.notifications.friend.requests", "notifications.friends.requests", hO.b, true));
    public static final hM y = a(NotificationType.FRIEND_LOGINS, new hM("bf.settings.notifications.friend.logins", "notifications.friends.logins", hO.b, true));
    public static final hM z = a(NotificationType.FRIEND_RANK_UPS, new hM("bf.settings.notifications.friend.rank.ups", "notifications.friends.rank.ups", hO.b, true));
    public static final hM A = a(NotificationType.FRIEND_PRESTIGE, new hM("bf.settings.notifications.friend.prestige", "notifications.friends.prestige", hO.b, true));
    public static final hM B = a(NotificationType.RANK_UPS, new hM("bf.settings.notifications.rank.ups", "notifications.rank.ups", hO.b, true));
    public static final hM C = a(NotificationType.ACHIEVEMENTS, new hM("bf.settings.notifications.achievements", "notifications.achievements", hO.b, true));
    public static final hM D = a(NotificationType.DAILY_CHALLENGE, new hM("bf.settings.notifications.daily.challenges", "notifications.daily.challenges", hO.b, true));
    public static final hM E = a(NotificationType.PARTY_INVITES, new hM("bf.settings.notifications.party.invites", "notifications.party.invites", hO.b, true));
    public static final hM F = new hM("bf.settings.audio.bots", "audio.bots", hO.d, true);
    public static final hM G = new hM("bf.settings.audio.capture.point.alarm", "audio.capture.point.alarm", hO.d, false);
    public static final hM H = new hM("bf.settings.experimental.bullet.holes", "experimental.bullet.holes", hO.g, true);
    public static final hM I = new hM("bf.settings.experimental.toggle.aim", "experimental.toggle.aim", hO.g, true);
    public static final hM J = new hM("bf.settings.experimental.toggle.bobbing", "experimental.toggle.bobbing", hO.g, false);
    public static final hM K = new hM("bf.settings.experimental.toggle.immersive.bobbing", "experimental.toggle.immersive.bobbing", hO.g, false);

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final hK f156d = new hK("bf.settings.experimental.immersive.bobbing.scale", "experimental.immersive.bobbing.scale", hO.g, 0.5f);
    public static final hM L = new hM("bf.settings.experimental.toggle.muzzleflash", "experimental.toggle.muzzleflash", hO.g, true);
    public static final hM M = new hM("bf.settings.experimental.toggle.nametags", "experimental.toggle.nametags", hO.g, true);
    public static final hM N = new hM("bf.settings.experimental.inspection.blur", "experimental.inspection.blur", hO.g, true);
    public static final hM O = new hM("bf.settings.experimental.bullet.eject.puff", "experimental.bullet.eject.puff", hO.g, false);
    public static final hM P = new hM("bf.settings.experimental.toggle.smoke.soft", "experimental.toggle.smoke.soft", hO.g, true);
    public static final hM Q = new hM("bf.settings.debug.toggle.armory.uuid", "debug.toggle.armory.uuid", hO.h, false);

    /* JADX INFO: renamed from: R, reason: collision with other field name */
    public static final hM f157R = new hM("bf.settings.intro.epilepsy.warning", "intro.epilepsy.warning", hO.i, false);
    public static final hM S = new hM("bf.settings.intro.rules", "intro.rules", hO.i, false);
    public static final hM T = new hM("bf.settings.intro.content", "intro.content", hO.i, false);
    public static final hM U = new hM("bf.settings.intro.discord", "intro.discord", hO.i, false);
    public static final hM V = new hM("bf.settings.intro.patreon", "intro.patreon", hO.i, false);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final hJ<tH.a> f158a = new hJ<>("bf.settings.internal.editor.wand.grab.mode", "internal.editor.wand.grab.mode", hO.j, tH.a.NORMAL);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final hJ<tF.a> f159b = new hJ<>("bf.settings.internal.creator.wand.mode", "internal.creator.wand.mode", hO.j, tF.a.CREATE_INDEPENDENT);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final hR f160a = new hR("bf.settings.internal.seen.match.tips", "internal.seen.match.tips", hO.j);

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static long f161f = Calendar.getInstance().getTime().getTime();
    public static boolean cI = false;

    @NotNull
    public static hM a(@NotNull NotificationType notificationType, @NotNull hM hMVar) {
        d.put(notificationType, hMVar);
        return hMVar;
    }

    public static boolean a(@NotNull NotificationType notificationType) {
        if (!d.containsKey(notificationType)) {
            return true;
        }
        return ((hM) d.get(notificationType)).T();
    }
}
