package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Map;
import java.util.Optional;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.xc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xc.class */
public final class C1280xc {

    /* JADX INFO: renamed from: i */
    @NotNull
    public static final DeferredRegister<SoundEvent> f7497i = DeferredRegister.create(Registries.SOUND_EVENT, "bf");

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final Object2ObjectMap<String, DeferredHolder<SoundEvent, SoundEvent>> f7498g = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final Object2ObjectMap<String, DeferredHolder<SoundEvent, SoundEvent>> f7499h = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: ac */
    @NotNull
    public static final ObjectList<DeferredHolder<SoundEvent, SoundEvent>> f7500ac = new ObjectArrayList();

    /* JADX INFO: renamed from: ok */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7501ok = m7798a("music.menu");

    /* JADX INFO: renamed from: ol */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7502ol = m7798a("music.menu.searching");

    /* JADX INFO: renamed from: om */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7503om = m7798a("music.bootcamp");

    /* JADX INFO: renamed from: on */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7504on = m7798a("music.sets.europe.conclude");

    /* JADX INFO: renamed from: oo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7505oo = m7798a("music.sets.europe.conclude.generic");

    /* JADX INFO: renamed from: op */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7506op = m7798a("music.sets.europe.suspense.one");

    /* JADX INFO: renamed from: oq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7507oq = m7798a("music.sets.europe.suspense.two");

    /* JADX INFO: renamed from: or */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7508or = m7798a("music.sets.europe.suspense.three");

    /* JADX INFO: renamed from: os */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7509os = m7798a("music.sets.europe.start");

    /* JADX INFO: renamed from: ot */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7510ot = m7798a("music.sets.europe.start.generic");

    /* JADX INFO: renamed from: ou */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7511ou = m7798a("music.sets.europe.warmup");

    /* JADX INFO: renamed from: ov */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7512ov = m7798a("music.sets.europe.offensive.point.taken");

    /* JADX INFO: renamed from: ow */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7513ow = m7798a("music.sets.europe.offensive.reinforcements.hint");

    /* JADX INFO: renamed from: ox */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7514ox = m7798a("music.sets.europe.offensive.reinforcements.arrive");

    /* JADX INFO: renamed from: oy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7515oy = m7798a("misc.hitmarker");

    /* JADX INFO: renamed from: oz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7516oz = m7798a("misc.morsecode");

    /* JADX INFO: renamed from: oA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7517oA = m7798a("misc.radio.transmission");

    /* JADX INFO: renamed from: oB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7518oB = m7798a("misc.heartbeat");

    /* JADX INFO: renamed from: oC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7519oC = m7798a("misc.rank.up");

    /* JADX INFO: renamed from: oD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7520oD = m7798a("misc.gore");

    /* JADX INFO: renamed from: oE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7521oE = m7798a("misc.gore.nose");

    /* JADX INFO: renamed from: oF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7522oF = m7798a("misc.vc.start");

    /* JADX INFO: renamed from: oG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7523oG = m7798a("misc.vc.stop");

    /* JADX INFO: renamed from: oH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7524oH = m7798a("misc.patreon.link");

    /* JADX INFO: renamed from: oI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7525oI = m7798a("particle.surrenderpaper.fall");

    /* JADX INFO: renamed from: oJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7526oJ = m7798a("gui.update.complete");

    /* JADX INFO: renamed from: oK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7527oK = m7798a("gui.update.loop");

    /* JADX INFO: renamed from: oL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7528oL = m7798a("gui.update.start");

    /* JADX INFO: renamed from: oM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7529oM = m7798a("gui.prestige.prompt");

    /* JADX INFO: renamed from: oN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7530oN = m7798a("gui.game.summary.intro.map.vote");

    /* JADX INFO: renamed from: oO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7531oO = m7798a("gui.game.summary.intro.map.vote.conclude");

    /* JADX INFO: renamed from: oP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7532oP = m7798a("gui.game.summary.intro.progress");

    /* JADX INFO: renamed from: oQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7533oQ = m7798a("gui.game.summary.intro.top.players");

    /* JADX INFO: renamed from: oR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7534oR = m7798a("gui.game.summary.top.players.entry");

    /* JADX INFO: renamed from: oS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7535oS = m7798a("gui.game.summary.top.players.entry.final");

    /* JADX INFO: renamed from: oT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7536oT = m7798a("gui.game.summary.promoted");

    /* JADX INFO: renamed from: oU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7537oU = m7798a("gui.game.vote.error");

    /* JADX INFO: renamed from: oV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7538oV = m7798a("gui.game.vote.vote");

    /* JADX INFO: renamed from: oW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7539oW = m7798a("gui.game.vote.vote.self");

    /* JADX INFO: renamed from: oX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7540oX = m7798a("gui.game.vote.rate");

    /* JADX INFO: renamed from: oY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7541oY = m7798a("gui.armory.default.shared");

    /* JADX INFO: renamed from: oZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7542oZ = m7798a("gui.armory.default.gun");

    /* JADX INFO: renamed from: pa */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7543pa = m7798a("gui.armory.default.melee");

    /* JADX INFO: renamed from: pb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7544pb = m7798a("gui.armory.default.card");

    /* JADX INFO: renamed from: pc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7545pc = m7798a("gui.bootcamp.complete");

    /* JADX INFO: renamed from: pd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7546pd = m7798a("gui.dailyreward.open");

    /* JADX INFO: renamed from: pe */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7547pe = m7798a("gui.dailychallenge.complete");

    /* JADX INFO: renamed from: pf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7548pf = m7798a("gui.dailychallenge.complete.all");

    /* JADX INFO: renamed from: pg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7549pg = m7798a("gui.dailychallenge.reminder");

    /* JADX INFO: renamed from: ph */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7550ph = m7798a("gui.lobby.search");

    /* JADX INFO: renamed from: pi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7551pi = m7798a("gui.lobby.cancel");

    /* JADX INFO: renamed from: pj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7552pj = m7798a("gui.lobby.join");

    /* JADX INFO: renamed from: pk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7553pk = m7798a("gui.sidemenu.open");

    /* JADX INFO: renamed from: pl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7554pl = m7798a("gui.sidemenu.close");

    /* JADX INFO: renamed from: pm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7555pm = m7798a("gui.openurl");

    /* JADX INFO: renamed from: pn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7556pn = m7798a("gui.newmessage");

    /* JADX INFO: renamed from: po */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7557po = m7798a("gui.typewriter");

    /* JADX INFO: renamed from: pp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7558pp = m7798a("gui.button.press");

    /* JADX INFO: renamed from: pq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7559pq = m7798a("gui.button.hover");

    /* JADX INFO: renamed from: pr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7560pr = m7798a("gui.button.back");

    /* JADX INFO: renamed from: ps */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7561ps = m7798a("gui.button.forward");

    /* JADX INFO: renamed from: pt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7562pt = m7798a("gui.events.hover");

    /* JADX INFO: renamed from: pu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7563pu = m7798a("gui.inventory.crate.open");

    /* JADX INFO: renamed from: pv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7564pv = m7798a("gui.inventory.item.inspect");

    /* JADX INFO: renamed from: pw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7565pw = m7798a("gui.inventory.item.trophy");

    /* JADX INFO: renamed from: px */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7566px = m7798a("gui.intro.content");

    /* JADX INFO: renamed from: py */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7567py = m7798a("gui.intro.rules");

    /* JADX INFO: renamed from: pz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7568pz = m7798a("gui.intro.refer");

    /* JADX INFO: renamed from: pA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7569pA = m7798a("gui.intro.discord");

    /* JADX INFO: renamed from: pB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7570pB = m7798a("gui.intro.patreon");

    /* JADX INFO: renamed from: pC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7571pC = m7798a("match.commander.radio");

    /* JADX INFO: renamed from: pD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7572pD = m7798a("match.commander.radio.error.time");

    /* JADX INFO: renamed from: pE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7573pE = m7798a("match.commander.radio.all");

    /* JADX INFO: renamed from: pF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7574pF = m7798a("match.commander.radio.local");

    /* JADX INFO: renamed from: pG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7575pG = m7798a("match.ping.regular");

    /* JADX INFO: renamed from: pH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7576pH = m7798a("match.ping.regular.warning");

    /* JADX INFO: renamed from: pI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7577pI = m7798a("match.tip");

    /* JADX INFO: renamed from: pJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7578pJ = m7798a("match.respawn");

    /* JADX INFO: renamed from: pK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7579pK = m7798a("match.boundary.enter");

    /* JADX INFO: renamed from: pL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7580pL = m7798a("match.boundary.leave");

    /* JADX INFO: renamed from: pM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7581pM = m7798a("match.tock");

    /* JADX INFO: renamed from: pN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7582pN = m7798a("match.tick");

    /* JADX INFO: renamed from: pO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7583pO = m7798a("match.capturepoint.siren");

    /* JADX INFO: renamed from: pP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7584pP = m7798a("match.capturepoint.tick");

    /* JADX INFO: renamed from: pQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7585pQ = m7798a("match.capturepoint.captured");

    /* JADX INFO: renamed from: pR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7586pR = m7798a("match.popup.kills");

    /* JADX INFO: renamed from: pS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7587pS = m7798a("match.ammopoint.refill");

    /* JADX INFO: renamed from: pT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7588pT = m7798a("match.classes.change");

    /* JADX INFO: renamed from: pU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7589pU = m7798a("match.dominating");

    /* JADX INFO: renamed from: pV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7590pV = m7798a("match.revenge");

    /* JADX INFO: renamed from: pW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7591pW = m7798a("match.gamemode.ttt.win.innocent");

    /* JADX INFO: renamed from: pX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7592pX = m7798a("match.gamemode.ttt.win.traitor");

    /* JADX INFO: renamed from: pY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7593pY = m7798a("match.gamemode.ttt.role.detective");

    /* JADX INFO: renamed from: pZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7594pZ = m7798a("match.gamemode.ttt.role.innocent");

    /* JADX INFO: renamed from: qa */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7595qa = m7798a("match.gamemode.ttt.role.traitor");

    /* JADX INFO: renamed from: qb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7596qb = m7798a("match.gamemode.ttt.role.reveal");

    /* JADX INFO: renamed from: qc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7597qc = m7798a("match.gamemode.ttt.randomat.fart");

    /* JADX INFO: renamed from: qd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7598qd = m7798a("match.gamemode.ttt.death.traitor");

    /* JADX INFO: renamed from: qe */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7599qe = m7798a("match.gamemode.sg.cannon");

    /* JADX INFO: renamed from: qf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7600qf = m7798a("match.gamemode.sg.cannon.stereo");

    /* JADX INFO: renamed from: qg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7601qg = m7798a("match.gamemode.sg.music.start");

    /* JADX INFO: renamed from: qh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7602qh = m7798a("match.gamemode.sg.music.end");

    /* JADX INFO: renamed from: qi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7603qi = m7798a("match.gamemode.inf.newround");

    /* JADX INFO: renamed from: qj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7604qj = m7798a("match.gamemode.inf.endround");

    /* JADX INFO: renamed from: qk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7605qk = m7798a("match.gamemode.inf.gameover");

    /* JADX INFO: renamed from: ql */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7606ql = m7798a("match.gamemode.inf.doground");

    /* JADX INFO: renamed from: qm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7607qm = m7798a("match.gamemode.inf.doground.end");

    /* JADX INFO: renamed from: qn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7608qn = m7798a("match.gamemode.inf.hoard");

    /* JADX INFO: renamed from: qo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7609qo = m7798a("match.gamemode.tdm.streak.end");

    /* JADX INFO: renamed from: qp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7610qp = m7798a("match.gamemode.tdm.announcer.firstblood");

    /* JADX INFO: renamed from: qq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7611qq = m7798a("match.gamemode.tdm.streak.5");

    /* JADX INFO: renamed from: qr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7612qr = m7798a("match.gamemode.tdm.streak.10");

    /* JADX INFO: renamed from: qs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7613qs = m7798a("match.gamemode.tdm.streak.15");

    /* JADX INFO: renamed from: qt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7614qt = m7798a("match.gamemode.tdm.streak.20");

    /* JADX INFO: renamed from: qu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7615qu = m7798a("match.gamemode.tdm.streak.25");

    /* JADX INFO: renamed from: qv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7616qv = m7798a("match.gamemode.tdm.streak.30");

    /* JADX INFO: renamed from: qw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7617qw = m7798a("match.gamemode.tdm.streak.max");

    /* JADX INFO: renamed from: qx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7618qx = m7798a("match.gamemode.dom.point.captured");

    /* JADX INFO: renamed from: qy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7619qy = m7798a("match.gamemode.dom.point.lost");

    /* JADX INFO: renamed from: qz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7620qz = m7798a("match.gamemode.boot.horn");

    /* JADX INFO: renamed from: qA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7621qA = m7798a("match.gamemode.boot.jazz");

    /* JADX INFO: renamed from: qB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7622qB = m7798a("match.gamemode.boot.usa");

    /* JADX INFO: renamed from: qC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7623qC = m7798a("match.gamemode.boot.usradio");

    /* JADX INFO: renamed from: qD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7624qD = m7798a("match.gamemode.boot.instructor.congratulations");

    /* JADX INFO: renamed from: qE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7625qE = m7798a("match.gamemode.boot.instructor.fulldayahead");

    /* JADX INFO: renamed from: qF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7626qF = m7798a("match.gamemode.boot.instructor.gogogo");

    /* JADX INFO: renamed from: qG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7627qG = m7798a("match.gamemode.boot.instructor.grenade");

    /* JADX INFO: renamed from: qH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7628qH = m7798a("match.gamemode.boot.instructor.notend");

    /* JADX INFO: renamed from: qI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7629qI = m7798a("match.gamemode.boot.instructor.obstacle");

    /* JADX INFO: renamed from: qJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7630qJ = m7798a("match.gamemode.boot.instructor.pickupweapon");

    /* JADX INFO: renamed from: qK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7631qK = m7798a("match.gamemode.boot.instructor.swim");

    /* JADX INFO: renamed from: qL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7632qL = m7798a("match.gamemode.boot.instructor.target.bad");

    /* JADX INFO: renamed from: qM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7633qM = m7798a("match.gamemode.boot.instructor.target.good");

    /* JADX INFO: renamed from: qN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7634qN = m7798a("match.gamemode.boot.instructor.target.ok");

    /* JADX INFO: renamed from: qO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7635qO = m7798a("match.gamemode.boot.instructor.target.best");

    /* JADX INFO: renamed from: qP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7636qP = m7798a("match.gamemode.boot.instructor.friendlyfire");

    /* JADX INFO: renamed from: qQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7637qQ = m7798a("match.mapeffect.plane.flyby");

    /* JADX INFO: renamed from: qR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7638qR = m7798a("match.mapeffect.plane.flyby.low");

    /* JADX INFO: renamed from: qS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7639qS = m7798a("match.mapeffect.tbtsk.fire");

    /* JADX INFO: renamed from: qT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7640qT = m7798a("match.mapeffect.tbtsk.fire.stereo");

    /* JADX INFO: renamed from: qU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7641qU = m7798a("match.mapeffect.tbtsk.fire.commander");

    /* JADX INFO: renamed from: qV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7642qV = m7798a("match.event.flak");

    /* JADX INFO: renamed from: qW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7643qW = m7798a("match.event.flak.distant");

    /* JADX INFO: renamed from: qX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7644qX = m7798a("match.event.flak.distant.stereo");

    /* JADX INFO: renamed from: qY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7645qY = m7798a("match.event.flak.plane");

    /* JADX INFO: renamed from: qZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7646qZ = m7798a("match.event.flak.plane.stereo");

    /* JADX INFO: renamed from: ra */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7647ra = m7798a("match.event.flak.plane.hit");

    /* JADX INFO: renamed from: rb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7648rb = m7798a("match.event.avalanche.rumble");

    /* JADX INFO: renamed from: rc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7649rc = m7798a("match.event.avalanche.rocks");

    /* JADX INFO: renamed from: rd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7650rd = m7798a("match.event.airstrike.fire");

    /* JADX INFO: renamed from: re */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7651re = m7798a("match.event.airstrike.corebass");

    /* JADX INFO: renamed from: rf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7652rf = m7798a("entity.vehicle.explode");

    /* JADX INFO: renamed from: rg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7653rg = m7798a("entity.vehicle.zoom.in");

    /* JADX INFO: renamed from: rh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7654rh = m7798a("entity.vehicle.zoom.out");

    /* JADX INFO: renamed from: ri */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7655ri = m7798a("entity.vehicle.alarm");

    /* JADX INFO: renamed from: rj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7656rj = m7798a("entity.vehicle.alarm.internal");

    /* JADX INFO: renamed from: rk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7657rk = m7798a("entity.vehicle.hatch");

    /* JADX INFO: renamed from: rl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7658rl = m7798a("entity.vehicle.door");

    /* JADX INFO: renamed from: rm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7659rm = m7798a("entity.vehicle.destroyed.fire");

    /* JADX INFO: renamed from: rn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7660rn = m7798a("entity.vehicle.damage");

    /* JADX INFO: renamed from: ro */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7661ro = m7798a("entity.vehicle.damage.distant");

    /* JADX INFO: renamed from: rp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7662rp = m7798a("entity.vehicle.damage.internal");

    /* JADX INFO: renamed from: rq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7663rq = m7798a("entity.vehicle.turret.fire.internal");

    /* JADX INFO: renamed from: rr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7664rr = m7798a("entity.vehicle.sherman.engine.forward.distant");

    /* JADX INFO: renamed from: rs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7665rs = m7798a("entity.vehicle.sherman.engine.forward.start.distant");

    /* JADX INFO: renamed from: rt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7666rt = m7798a("entity.vehicle.sherman.engine.forward.stop.distant");

    /* JADX INFO: renamed from: ru */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7667ru = m7798a("entity.vehicle.sherman.engine.idle.distant");

    /* JADX INFO: renamed from: rv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7668rv = m7798a("entity.vehicle.sherman.engine.start.distant");

    /* JADX INFO: renamed from: rw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7669rw = m7798a("entity.vehicle.sherman.engine.stop.distant");

    /* JADX INFO: renamed from: rx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7670rx = m7798a("entity.vehicle.sherman.engine.forward");

    /* JADX INFO: renamed from: ry */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7671ry = m7798a("entity.vehicle.sherman.engine.forward.start");

    /* JADX INFO: renamed from: rz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7672rz = m7798a("entity.vehicle.sherman.engine.forward.stop");

    /* JADX INFO: renamed from: rA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7673rA = m7798a("entity.vehicle.sherman.engine.idle");

    /* JADX INFO: renamed from: rB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7674rB = m7798a("entity.vehicle.sherman.engine.start");

    /* JADX INFO: renamed from: rC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7675rC = m7798a("entity.vehicle.sherman.engine.stop");

    /* JADX INFO: renamed from: rD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7676rD = m7798a("entity.vehicle.sherman.tracks");

    /* JADX INFO: renamed from: rE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7677rE = m7798a("entity.vehicle.sherman.tracks.turn");

    /* JADX INFO: renamed from: rF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7678rF = m7798a("entity.vehicle.sherman.turret.move");

    /* JADX INFO: renamed from: rG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7679rG = m7798a("entity.vehicle.sherman.turret.move.start");

    /* JADX INFO: renamed from: rH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7680rH = m7798a("entity.vehicle.sherman.turret.move.stop");

    /* JADX INFO: renamed from: rI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7681rI = m7798a("entity.vehicle.sherman.turret.reload");

    /* JADX INFO: renamed from: rJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7682rJ = m7798a("entity.vehicle.sherman.turret.fire");

    /* JADX INFO: renamed from: rK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7683rK = m7798a("entity.vehicle.sherman.turret.fire.add");

    /* JADX INFO: renamed from: rL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7684rL = m7798a("entity.vehicle.sherman.turret.fire.distant");

    /* JADX INFO: renamed from: rM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7685rM = m7798a("entity.vehicle.sherman.turret.fire.hifi");

    /* JADX INFO: renamed from: rN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7686rN = m7798a("entity.vehicle.chiha.engine.forward");

    /* JADX INFO: renamed from: rO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7687rO = m7798a("entity.vehicle.chiha.engine.forward.start");

    /* JADX INFO: renamed from: rP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7688rP = m7798a("entity.vehicle.chiha.engine.forward.stop");

    /* JADX INFO: renamed from: rQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7689rQ = m7798a("entity.vehicle.chiha.engine.idle");

    /* JADX INFO: renamed from: rR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7690rR = m7798a("entity.vehicle.chiha.engine.start");

    /* JADX INFO: renamed from: rS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7691rS = m7798a("entity.vehicle.chiha.engine.stop");

    /* JADX INFO: renamed from: rT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7692rT = m7798a("entity.vehicle.chiha.tracks");

    /* JADX INFO: renamed from: rU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7693rU = m7798a("entity.vehicle.willys.jeep.horn");

    /* JADX INFO: renamed from: rV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7694rV = m7798a("entity.vehicle.willys.jeep.horn.distant");

    /* JADX INFO: renamed from: rW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7695rW = m7798a("entity.vehicle.lancia_1zm.engine.forward");

    /* JADX INFO: renamed from: rX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7696rX = m7798a("entity.vehicle.lancia_1zm.engine.forward.distant");

    /* JADX INFO: renamed from: rY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7697rY = m7798a("entity.vehicle.lancia_1zm.engine.forward.start");

    /* JADX INFO: renamed from: rZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7698rZ = m7798a("entity.vehicle.lancia_1zm.engine.forward.start.distant");

    /* JADX INFO: renamed from: sa */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7699sa = m7798a("entity.vehicle.lancia_1zm.engine.forward.stop");

    /* JADX INFO: renamed from: sb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7700sb = m7798a("entity.vehicle.lancia_1zm.engine.forward.stop.distant");

    /* JADX INFO: renamed from: sc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7701sc = m7798a("entity.vehicle.lancia_1zm.engine.idle");

    /* JADX INFO: renamed from: sd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7702sd = m7798a("entity.vehicle.lancia_1zm.engine.idle.distant");

    /* JADX INFO: renamed from: se */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7703se = m7798a("entity.vehicle.lancia_1zm.engine.start");

    /* JADX INFO: renamed from: sf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7704sf = m7798a("entity.vehicle.lancia_1zm.engine.start.distant");

    /* JADX INFO: renamed from: sg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7705sg = m7798a("entity.vehicle.lancia_1zm.engine.stop");

    /* JADX INFO: renamed from: sh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7706sh = m7798a("entity.vehicle.lancia_1zm.engine.stop.distant");

    /* JADX INFO: renamed from: si */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7707si = m7798a("entity.vehicle.lancia_1zm.turret.turn");

    /* JADX INFO: renamed from: sj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7708sj = m7798a("entity.vehicle.lancia_1zm.wheels");

    /* JADX INFO: renamed from: sk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7709sk = m7798a("entity.vehicle.lancia_1zm.wheels.turn");

    /* JADX INFO: renamed from: sl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7710sl = m7798a("entity.vehicle.flak88.turret.move");

    /* JADX INFO: renamed from: sm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7711sm = m7798a("entity.vehicle.flak88.turret.move.start");

    /* JADX INFO: renamed from: sn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7712sn = m7798a("entity.vehicle.flak88.turret.move.stop");

    /* JADX INFO: renamed from: so */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7713so = m7798a("entity.vehicle.flak88.turret.reload");

    /* JADX INFO: renamed from: sp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7714sp = m7798a("entity.vehicle.flak88.turret.fire");

    /* JADX INFO: renamed from: sq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7715sq = m7798a("entity.vehicle.flak88.turret.fire.hifi");

    /* JADX INFO: renamed from: sr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7716sr = m7798a("entity.vehicle.tilt");

    /* JADX INFO: renamed from: ss */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7717ss = m7798a("entity.corpse.fly");

    /* JADX INFO: renamed from: st */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7718st = m7798a("entity.obunga.idle");

    /* JADX INFO: renamed from: su */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7719su = m7798a("entity.panzerknacker.idle");

    /* JADX INFO: renamed from: sv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7720sv = m7798a("entity.player.foley.arm");

    /* JADX INFO: renamed from: sw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7721sw = m7798a("entity.player.foley.land");

    /* JADX INFO: renamed from: sx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7722sx = m7798a("entity.player.foley.rain_coat");

    /* JADX INFO: renamed from: sy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7723sy = m7798a("entity.rocket.loop");

    /* JADX INFO: renamed from: sz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7724sz = m7798a("entity.rocket.bounce");

    /* JADX INFO: renamed from: sA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7725sA = m7798a("entity.rocket.ricochet");

    /* JADX INFO: renamed from: sB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7726sB = m7798a("entity.rocket.fall");

    /* JADX INFO: renamed from: sC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7727sC = m7798a("entity.rocket.flyby");

    /* JADX INFO: renamed from: sD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7728sD = m7798a("entity.rocket.tank.flyby");

    /* JADX INFO: renamed from: sE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7729sE = m7798a("entity.rocket.tank.fire");

    /* JADX INFO: renamed from: sF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7730sF = m7798a("entity.infected.hurt");

    /* JADX INFO: renamed from: sG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7731sG = m7798a("entity.infected.death");

    /* JADX INFO: renamed from: sH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7732sH = m7798a("entity.infected.dog.bark");

    /* JADX INFO: renamed from: sI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7733sI = m7798a("entity.infected.dog.howl");

    /* JADX INFO: renamed from: sJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7734sJ = m7798a("entity.infected.spitter.spit");

    /* JADX INFO: renamed from: sK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7735sK = m7798a("entity.acidball.splat");

    /* JADX INFO: renamed from: sL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7736sL = m7798a("entity.gundealer.sale");

    /* JADX INFO: renamed from: sM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7737sM = m7798a("entity.gundealer.relocate");

    /* JADX INFO: renamed from: sN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7738sN = m7798a("entity.gundealer.resupply");

    /* JADX INFO: renamed from: sO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7739sO = m7798a("entity.gundealer.open");

    /* JADX INFO: renamed from: sP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7740sP = m7798a("entity.flame.ignite");

    /* JADX INFO: renamed from: sQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7741sQ = m7798a("block.field.crate.use");

    /* JADX INFO: renamed from: sR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7742sR = m7798a("block.barrel.spill");

    /* JADX INFO: renamed from: sS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7743sS = m7798a("block.radio.static");

    /* JADX INFO: renamed from: sT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7744sT = m7798a("block.radio.morse");

    /* JADX INFO: renamed from: sU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7745sU = m7798a("block.jeep.engine");

    /* JADX INFO: renamed from: sV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7746sV = m7798a("block.tank.engine");

    /* JADX INFO: renamed from: sW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7747sW = m7798a("block.piano.hit");

    /* JADX INFO: renamed from: sX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7748sX = m7798a("block.hedgehog.hit");

    /* JADX INFO: renamed from: sY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7749sY = m7798a("block.powerline.zap");

    /* JADX INFO: renamed from: sZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7750sZ = m7798a("block.powerline.explode");

    /* JADX INFO: renamed from: ta */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7751ta = m7798a("block.powerline.electric");

    /* JADX INFO: renamed from: tb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7752tb = m7798a("block.radio.chatter.german");

    /* JADX INFO: renamed from: tc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7753tc = m7798a("block.radio.chatter.american");

    /* JADX INFO: renamed from: td */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7754td = m7798a("block.plank.step");

    /* JADX INFO: renamed from: te */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7755te = m7798a("block.rubble.step");

    /* JADX INFO: renamed from: tf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7756tf = m7798a("block.target.hit");

    /* JADX INFO: renamed from: tg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7757tg = m7798a("block.target.hit.distant");

    /* JADX INFO: renamed from: th */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7758th = m7798a("block.door.bunker.open");

    /* JADX INFO: renamed from: ti */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7759ti = m7798a("block.door.bunker.close");

    /* JADX INFO: renamed from: tj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7760tj = m7798a("block.button.press");

    /* JADX INFO: renamed from: tk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7761tk = m7798a("block.button.release");

    /* JADX INFO: renamed from: tl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7762tl = m7798a("block.bell.bell");

    /* JADX INFO: renamed from: tm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7763tm = m7798a("block.bell.bell.far");

    /* JADX INFO: renamed from: tn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7764tn = m7798a("block.shisa.whisper");

    /* JADX INFO: renamed from: to */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7765to = m7798a("block.swinging.log.creak");

    /* JADX INFO: renamed from: tp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7766tp = m7798a("block.wind_chime.chime");

    /* JADX INFO: renamed from: tq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7767tq = m7798a("block.telephone.impact");

    /* JADX INFO: renamed from: tr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7768tr = m7798a("block.typewriter.impact");

    /* JADX INFO: renamed from: ts */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7769ts = m7798a("block.typewriter.type");

    /* JADX INFO: renamed from: tt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7770tt = m7798a("block.typewriter.ping");

    /* JADX INFO: renamed from: tu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7771tu = m7798a("block.alarm.on");

    /* JADX INFO: renamed from: tv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7772tv = m7798a("item.syringe.equip");

    /* JADX INFO: renamed from: tw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7773tw = m7798a("item.syringe.use");

    /* JADX INFO: renamed from: tx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7774tx = m7798a("item.binoculars.equip");

    /* JADX INFO: renamed from: ty */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7775ty = m7798a("item.binoculars.use");

    /* JADX INFO: renamed from: tz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7776tz = m7798a("item.binoculars.stop_using");

    /* JADX INFO: renamed from: tA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7777tA = m7798a("item.flamethrower.move");

    /* JADX INFO: renamed from: tB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7778tB = m7798a("item.radio.equip");

    /* JADX INFO: renamed from: tC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7779tC = m7798a("item.radio.equipped");

    /* JADX INFO: renamed from: tD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7780tD = m7798a("item.radio.call");

    /* JADX INFO: renamed from: tE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7781tE = m7798a("item.grenade.equip");

    /* JADX INFO: renamed from: tF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7782tF = m7798a("item.grenade.throw");

    /* JADX INFO: renamed from: tG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7783tG = m7798a("item.grenade.pin");

    /* JADX INFO: renamed from: tH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7784tH = m7798a("item.grenade.bounce.metal");

    /* JADX INFO: renamed from: tI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7785tI = m7798a("item.grenade.bounce.wood");

    /* JADX INFO: renamed from: tJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7786tJ = m7798a("item.grenade.bounce.dirt");

    /* JADX INFO: renamed from: tK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7787tK = m7798a("item.grenade.flash.explode");

    /* JADX INFO: renamed from: tL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7788tL = m7798a("item.grenade.flash.blind");

    /* JADX INFO: renamed from: tM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7789tM = m7798a("item.grenade.smoke.explode");

    /* JADX INFO: renamed from: tN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7790tN = m7798a("item.grenade.smoke.burn");

    /* JADX INFO: renamed from: tO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7791tO = m7798a("item.grenade.fire.explode");

    /* JADX INFO: renamed from: tP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7792tP = m7798a("item.grenade.molotov.explode");

    /* JADX INFO: renamed from: tQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7793tQ = m7798a("item.grenade.molotov.equip");

    /* JADX INFO: renamed from: tR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7794tR = m7798a("item.grenade.molotov.throw");

    /* JADX INFO: renamed from: tS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7795tS = m7798a("item.grenade.holyhandgrenade");

    /* JADX INFO: renamed from: tT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7796tT = m7798a("item.medicalbag.bounce");

    /* JADX INFO: renamed from: tU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7797tU = m7798a("item.medicalbag.heal");

    /* JADX INFO: renamed from: tV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7798tV = m7798a("item.landmine.deploy");

    /* JADX INFO: renamed from: tW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7799tW = m7798a("item.landmine.bounce");

    /* JADX INFO: renamed from: tX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7800tX = m7798a("item.ammo.box.bounce");

    /* JADX INFO: renamed from: tY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7801tY = m7798a("item.ammo.box.heal");

    /* JADX INFO: renamed from: tZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7802tZ = m7798a("item.bomb.beep");

    /* JADX INFO: renamed from: ua */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7803ua = m7798a("item.bomb.ignite");

    /* JADX INFO: renamed from: ub */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7804ub = m7798a("item.bomb.explode");

    /* JADX INFO: renamed from: uc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7805uc = m7798a("item.bomb.plant");

    /* JADX INFO: renamed from: ud */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7806ud = m7798a("item.bomb.planting");

    /* JADX INFO: renamed from: ue */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7807ue = m7798a("item.bomb.button");

    /* JADX INFO: renamed from: uf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7808uf = m7798a("item.bomb.defusing");

    /* JADX INFO: renamed from: ug */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7809ug = m7798a("item.bomb.defuse");

    /* JADX INFO: renamed from: uh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7810uh = m7798a("item.randomat.activate");

    /* JADX INFO: renamed from: ui */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7811ui = m7798a("item.randomat.activate.all");

    /* JADX INFO: renamed from: uj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7812uj = m7798a("item.gun.bullet.impact");

    /* JADX INFO: renamed from: uk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7813uk = m7798a("item.gun.bullet.impact.nose");

    /* JADX INFO: renamed from: ul */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7814ul = m7798a("item.gun.bullet.impact.nose.stereo");

    /* JADX INFO: renamed from: um */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7815um = m7798a("item.gun.bullet.impact.mg42");

    /* JADX INFO: renamed from: un */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7816un = m7798a("item.gun.bullet.impact.mg42.stereo");

    /* JADX INFO: renamed from: uo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7817uo = m7798a("item.gun.bullet.impact.glass");

    /* JADX INFO: renamed from: up */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7818up = m7798a("item.gun.bullet.impact.glass.debris");

    /* JADX INFO: renamed from: uq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7819uq = m7798a("item.gun.bullet.impact.metal");

    /* JADX INFO: renamed from: ur */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7820ur = m7798a("item.gun.bullet.impact.metal.debris");

    /* JADX INFO: renamed from: us */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7821us = m7798a("item.gun.bullet.impact.stone");

    /* JADX INFO: renamed from: ut */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7822ut = m7798a("item.gun.bullet.impact.stone.debris");

    /* JADX INFO: renamed from: uu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7823uu = m7798a("item.gun.bullet.impact.dirt");

    /* JADX INFO: renamed from: uv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7824uv = m7798a("item.gun.bullet.impact.dirt.debris");

    /* JADX INFO: renamed from: uw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7825uw = m7798a("item.gun.bullet.impact.wood");

    /* JADX INFO: renamed from: ux */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7826ux = m7798a("item.gun.bullet.impact.wood.debris");

    /* JADX INFO: renamed from: uy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7827uy = m7798a("item.gun.bullet.impact.flesh");

    /* JADX INFO: renamed from: uz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7828uz = m7798a("item.gun.bullet.impact.flesh.head");

    /* JADX INFO: renamed from: uA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7829uA = m7798a("item.gun.bullet.impact.flesh.local");

    /* JADX INFO: renamed from: uB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7830uB = m7798a("item.gun.bullet.impact.flesh.head.helmet");

    /* JADX INFO: renamed from: uC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7831uC = m7798a("item.gun.bullet.impact.flesh.stereo");

    /* JADX INFO: renamed from: uD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7832uD = m7798a("item.gun.bullet.impact.flesh.nose");

    /* JADX INFO: renamed from: uE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7833uE = m7798a("item.gun.bullet.impact.water");

    /* JADX INFO: renamed from: uF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7834uF = m7798a("item.gun.bullet.pass");

    /* JADX INFO: renamed from: uG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7835uG = m7798a("item.gun.bullet.pass.at");

    /* JADX INFO: renamed from: uH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7836uH = m7798a("item.gun.bullet.snap.0");

    /* JADX INFO: renamed from: uI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7837uI = m7798a("item.gun.bullet.snap.1");

    /* JADX INFO: renamed from: uJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7838uJ = m7798a("item.gun.bullet.snap.2");

    /* JADX INFO: renamed from: uK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7839uK = m7798a("item.gun.bullet.snap.3");

    /* JADX INFO: renamed from: uL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7840uL = m7798a("item.gun.bullet.snap.4");

    /* JADX INFO: renamed from: uM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7841uM = m7798a("item.gun.bullet.snap.5");

    /* JADX INFO: renamed from: uN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7842uN = m7798a("item.gun.bullet.snap.stereo.indoors");

    /* JADX INFO: renamed from: uO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7843uO = m7798a("item.gun.bullet.snap.stereo.outdoors");

    /* JADX INFO: renamed from: uP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7844uP = m7798a("item.gun.bullet.ricochet");

    /* JADX INFO: renamed from: uQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7845uQ = m7798a("item.gun.bullet.ricochet.impact");

    /* JADX INFO: renamed from: uR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7846uR = m7798a("item.gun.shared.firemode");

    /* JADX INFO: renamed from: uS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7847uS = m7798a("item.gun.shared.corebass.close.lmg");

    /* JADX INFO: renamed from: uT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7848uT = m7798a("item.gun.shared.corebass.close.mg");

    /* JADX INFO: renamed from: uU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7849uU = m7798a("item.gun.shared.corebass.close.mg34");

    /* JADX INFO: renamed from: uV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7850uV = m7798a("item.gun.shared.corebass.close.mg42");

    /* JADX INFO: renamed from: uW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7851uW = m7798a("item.gun.shared.corebass.close.mp40");

    /* JADX INFO: renamed from: uX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7852uX = m7798a("item.gun.shared.corebass.close.pistol");

    /* JADX INFO: renamed from: uY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7853uY = m7798a("item.gun.shared.corebass.close.rifle");

    /* JADX INFO: renamed from: uZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7854uZ = m7798a("item.gun.shared.corebass.close.stg44");

    /* JADX INFO: renamed from: va */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7855va = m7798a("item.gun.shared.corebass.close.smg");

    /* JADX INFO: renamed from: vb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7856vb = m7798a("item.gun.shared.corebass.close.m1garand");

    /* JADX INFO: renamed from: vc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7857vc = m7798a("item.gun.shared.corebass.lmg.distant");

    /* JADX INFO: renamed from: vd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7858vd = m7798a("item.gun.shared.corebass.pistol.distant");

    /* JADX INFO: renamed from: ve */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7859ve = m7798a("item.gun.shared.corebass.rifle.distant");

    /* JADX INFO: renamed from: vf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7860vf = m7798a("item.gun.shared.corebass.smg.distant");

    /* JADX INFO: renamed from: vg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7861vg = m7798a("item.gun.shared.corebass.rocket.distant");

    /* JADX INFO: renamed from: vh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7862vh = m7798a("item.gun.shared.corebass.mg.distant");

    /* JADX INFO: renamed from: vi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7863vi = m7798a("item.gun.shared.nose");

    /* JADX INFO: renamed from: vj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7864vj = m7798a("item.gun.shared.nose.stereo");

    /* JADX INFO: renamed from: vk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7865vk = m7798a("item.gun.shared.earlysnap.mp40");

    /* JADX INFO: renamed from: vl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7866vl = m7798a("item.gun.shared.earlysnap.stg44");

    /* JADX INFO: renamed from: vm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7867vm = m7798a("item.gun.shared.earlysnap.bren");

    /* JADX INFO: renamed from: vn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7868vn = m7798a("item.gun.shared.earlysnap.m1carbine");

    /* JADX INFO: renamed from: vo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7869vo = m7798a("item.gun.shared.earlysnap.m1garand");

    /* JADX INFO: renamed from: vp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7870vp = m7798a("item.gun.shared.earlysnap.mosin");

    /* JADX INFO: renamed from: vq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7871vq = m7798a("item.gun.shared.rattle.mg");

    /* JADX INFO: renamed from: vr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7872vr = m7798a("item.gun.shared.rattle.smg");

    /* JADX INFO: renamed from: vs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7873vs = m7798a("item.gun.shared.rattle.lmg");

    /* JADX INFO: renamed from: vt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7874vt = m7798a("item.gun.shared.rattle.mg42");

    /* JADX INFO: renamed from: vu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7875vu = m7798a("item.gun.shared.towards.mg");

    /* JADX INFO: renamed from: vv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7876vv = m7798a("item.gun.shared.towards.pistol");

    /* JADX INFO: renamed from: vw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7877vw = m7798a("item.gun.shared.towards.rifle");

    /* JADX INFO: renamed from: vx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7878vx = m7798a("item.gun.shared.towards.smg");

    /* JADX INFO: renamed from: vy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7879vy = m7798a("item.gun.shared.add.pistol");

    /* JADX INFO: renamed from: vz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7880vz = m7798a("item.gun.shared.add.rifle");

    /* JADX INFO: renamed from: vA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7881vA = m7798a("item.gun.shared.add.rifle.semi");

    /* JADX INFO: renamed from: vB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7882vB = m7798a("item.gun.shared.add.smg");

    /* JADX INFO: renamed from: vC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7883vC = m7798a("item.gun.shared.dryfire.pistol");

    /* JADX INFO: renamed from: vD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7884vD = m7798a("item.gun.shared.dryfire.revolver");

    /* JADX INFO: renamed from: vE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7885vE = m7798a("item.gun.shared.dryfire.smg");

    /* JADX INFO: renamed from: vF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7886vF = m7798a("item.gun.shared.dryfire.rifle");

    /* JADX INFO: renamed from: vG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7887vG = m7798a("item.gun.shared.dryfire.carbine");

    /* JADX INFO: renamed from: vH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7888vH = m7798a("item.gun.shared.dryfire.shotgun");

    /* JADX INFO: renamed from: vI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7889vI = m7798a("item.gun.shared.dryfire.mg");

    /* JADX INFO: renamed from: vJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7890vJ = m7798a("item.gun.shared.dryfire.lmg");

    /* JADX INFO: renamed from: vK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7891vK = m7798a("item.gun.shared.dryfire.at");

    /* JADX INFO: renamed from: vL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7892vL = m7798a("item.gun.shared.echo.close");

    /* JADX INFO: renamed from: vM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7893vM = m7798a("item.gun.shared.echo.close.self");

    /* JADX INFO: renamed from: vN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7894vN = m7798a("item.gun.shared.echo.close.indoors");

    /* JADX INFO: renamed from: vO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7895vO = m7798a("item.gun.shared.echo.close.indoors.mg");

    /* JADX INFO: renamed from: vP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7896vP = m7798a("item.gun.shared.echo.close.indoors.pistol");

    /* JADX INFO: renamed from: vQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7897vQ = m7798a("item.gun.shared.echo.close.indoors.rifle");

    /* JADX INFO: renamed from: vR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7898vR = m7798a("item.gun.shared.echo.close.indoors.smg");

    /* JADX INFO: renamed from: vS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7899vS = m7798a("item.gun.shared.echo.close.indoors.self");

    /* JADX INFO: renamed from: vT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7900vT = m7798a("item.gun.shared.echo.close.indoors.self.open");

    /* JADX INFO: renamed from: vU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7901vU = m7798a("item.gun.shared.echo.close.indoors.self.mg");

    /* JADX INFO: renamed from: vV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7902vV = m7798a("item.gun.shared.echo.close.indoors.self.mg.open");

    /* JADX INFO: renamed from: vW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7903vW = m7798a("item.gun.shared.echo.close.indoors.self.pistol");

    /* JADX INFO: renamed from: vX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7904vX = m7798a("item.gun.shared.echo.close.indoors.self.pistol.open");

    /* JADX INFO: renamed from: vY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7905vY = m7798a("item.gun.shared.echo.close.indoors.self.rifle");

    /* JADX INFO: renamed from: vZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7906vZ = m7798a("item.gun.shared.echo.close.indoors.self.rifle.open");

    /* JADX INFO: renamed from: wa */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7907wa = m7798a("item.gun.shared.echo.close.indoors.self.smg");

    /* JADX INFO: renamed from: wb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7908wb = m7798a("item.gun.shared.echo.close.suppressor");

    /* JADX INFO: renamed from: wc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7909wc = m7798a("item.gun.shared.echo.close.suppressor.self");

    /* JADX INFO: renamed from: wd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7910wd = m7798a("item.gun.shared.echo.distant.m3");

    /* JADX INFO: renamed from: we */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7911we = m7798a("item.gun.shared.echo.distant.m3.stereo");

    /* JADX INFO: renamed from: wf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7912wf = m7798a("item.gun.shared.echo.distant.stenmk2");

    /* JADX INFO: renamed from: wg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7913wg = m7798a("item.gun.shared.echo.distant.stenmk2.stereo");

    /* JADX INFO: renamed from: wh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7914wh = m7798a("item.gun.shared.echo.distant.pps43");

    /* JADX INFO: renamed from: wi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7915wi = m7798a("item.gun.shared.echo.distant.pps43.stereo");

    /* JADX INFO: renamed from: wj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7916wj = m7798a("item.gun.shared.echo.distant.mg42");

    /* JADX INFO: renamed from: wk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7917wk = m7798a("item.gun.shared.echo.distant.mg42.stereo");

    /* JADX INFO: renamed from: wl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7918wl = m7798a("item.gun.shared.echo.distant.smg");

    /* JADX INFO: renamed from: wm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7919wm = m7798a("item.gun.shared.echo.distant.smg.stereo");

    /* JADX INFO: renamed from: wn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7920wn = m7798a("item.gun.shared.echo.distant.shotgun");

    /* JADX INFO: renamed from: wo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7921wo = m7798a("item.gun.shared.echo.distant.shotgun.stereo");

    /* JADX INFO: renamed from: wp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7922wp = m7798a("item.gun.shared.echo.distant.rifle");

    /* JADX INFO: renamed from: wq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7923wq = m7798a("item.gun.shared.echo.distant.rifle.stereo");

    /* JADX INFO: renamed from: wr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7924wr = m7798a("item.gun.shared.echo.distant.at");

    /* JADX INFO: renamed from: ws */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7925ws = m7798a("item.gun.shared.echo.distant.at.stereo");

    /* JADX INFO: renamed from: wt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7926wt = m7798a("item.gun.shared.echo.distant.meloncannon");

    /* JADX INFO: renamed from: wu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7927wu = m7798a("item.gun.shared.echo.distant.meloncannon.stereo");

    /* JADX INFO: renamed from: wv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7928wv = m7798a("item.gun.shared.echo.distant.rifle.semi");

    /* JADX INFO: renamed from: ww */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7929ww = m7798a("item.gun.shared.echo.distant.rifle.semi.stereo");

    /* JADX INFO: renamed from: wx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7930wx = m7798a("item.gun.shared.echo.distant.mg");

    /* JADX INFO: renamed from: wy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7931wy = m7798a("item.gun.shared.echo.distant.mg.stereo");

    /* JADX INFO: renamed from: wz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7932wz = m7798a("item.gun.shared.echo.distant.lmg");

    /* JADX INFO: renamed from: wA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7933wA = m7798a("item.gun.shared.echo.distant.lmg.stereo");

    /* JADX INFO: renamed from: wB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7934wB = m7798a("item.gun.shared.echo.distant.rocket");

    /* JADX INFO: renamed from: wC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7935wC = m7798a("item.gun.shared.echo.distant.rocket.stereo");

    /* JADX INFO: renamed from: wD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7936wD = m7798a("item.gun.shared.echo.distant.pistol");

    /* JADX INFO: renamed from: wE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7937wE = m7798a("item.gun.shared.echo.distant.pistol.stereo");

    /* JADX INFO: renamed from: wF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7938wF = m7798a("item.gun.shared.echo.distant.musket");

    /* JADX INFO: renamed from: wG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7939wG = m7798a("item.gun.shared.echo.distant.musket.stereo");

    /* JADX INFO: renamed from: wH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7940wH = m7798a("item.gun.shared.echo.distant.indoors");

    /* JADX INFO: renamed from: wI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7941wI = m7798a("item.gun.shared.echo.distant.indoors.mg");

    /* JADX INFO: renamed from: wJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7942wJ = m7798a("item.gun.shared.echo.distant.indoors.pistol");

    /* JADX INFO: renamed from: wK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7943wK = m7798a("item.gun.shared.echo.distant.indoors.rifle");

    /* JADX INFO: renamed from: wL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7944wL = m7798a("item.gun.shared.echo.distant.indoors.smg");

    /* JADX INFO: renamed from: wM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7945wM = m7798a("item.gun.shared.echo.distant.revolver");

    /* JADX INFO: renamed from: wN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7946wN = m7798a("item.gun.shared.echo.distant.revolver.stereo");

    /* JADX INFO: renamed from: wO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7947wO = m7798a("item.gun.shared.echo.distant.leeenfield");

    /* JADX INFO: renamed from: wP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7948wP = m7798a("item.gun.shared.echo.distant.leeenfield.stereo");

    /* JADX INFO: renamed from: wQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7949wQ = m7798a("item.gun.shared.echo.distant.springfield");

    /* JADX INFO: renamed from: wR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7950wR = m7798a("item.gun.shared.echo.distant.springfield.stereo");

    /* JADX INFO: renamed from: wS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7951wS = m7798a("item.gun.shared.echo.distant.lewisgun");

    /* JADX INFO: renamed from: wT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7952wT = m7798a("item.gun.shared.echo.distant.lewisgun.stereo");

    /* JADX INFO: renamed from: wU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7953wU = m7798a("item.gun.shared.echo.distant.mp40");

    /* JADX INFO: renamed from: wV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7954wV = m7798a("item.gun.shared.echo.distant.mp40.stereo");

    /* JADX INFO: renamed from: wW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7955wW = m7798a("item.gun.shared.echo.distant.m1carbine");

    /* JADX INFO: renamed from: wX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7956wX = m7798a("item.gun.shared.echo.distant.m1carbine.stereo");

    /* JADX INFO: renamed from: wY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7957wY = m7798a("item.gun.shared.echo.distant.m1garand");

    /* JADX INFO: renamed from: wZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7958wZ = m7798a("item.gun.shared.echo.distant.m1garand.stereo");

    /* JADX INFO: renamed from: xa */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7959xa = m7798a("item.gun.shared.echo.distant.kar98k");

    /* JADX INFO: renamed from: xb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7960xb = m7798a("item.gun.shared.echo.distant.kar98k.stereo");

    /* JADX INFO: renamed from: xc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7961xc = m7798a("item.gun.shared.echo.distant.mosin");

    /* JADX INFO: renamed from: xd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7962xd = m7798a("item.gun.shared.echo.distant.mosin.stereo");

    /* JADX INFO: renamed from: xe */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7963xe = m7798a("item.gun.shared.bullet.lmg");

    /* JADX INFO: renamed from: xf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7964xf = m7798a("item.gun.shared.bullet.lmg.dirt");

    /* JADX INFO: renamed from: xg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7965xg = m7798a("item.gun.shared.bullet.lmg.wood");

    /* JADX INFO: renamed from: xh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7966xh = m7798a("item.gun.shared.bullet.lmg.metal");

    /* JADX INFO: renamed from: xi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7967xi = m7798a("item.gun.shared.bullet.lmg.water");

    /* JADX INFO: renamed from: xj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7968xj = m7798a("item.gun.shared.bullet.shotgun");

    /* JADX INFO: renamed from: xk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7969xk = m7798a("item.gun.shared.bullet.vehicle");

    /* JADX INFO: renamed from: xl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7970xl = m7798a("item.gun.shared.lfe.lmg");

    /* JADX INFO: renamed from: xm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7971xm = m7798a("item.gun.shared.lfe.pistol");

    /* JADX INFO: renamed from: xn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7972xn = m7798a("item.gun.shared.lfe.rifle");

    /* JADX INFO: renamed from: xo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7973xo = m7798a("item.gun.shared.lfe.rpg");

    /* JADX INFO: renamed from: xp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7974xp = m7798a("item.gun.shared.overheat");

    /* JADX INFO: renamed from: xq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7975xq = m7798a("item.gun.shared.reload.bolt");

    /* JADX INFO: renamed from: xr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7976xr = m7798a("item.gun.shared.reload.shell");

    /* JADX INFO: renamed from: xs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7977xs = m7798a("item.gun.shared.reload.bullet.rifle");

    /* JADX INFO: renamed from: xt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7978xt = m7798a("item.gun.shared.reload.pump");

    /* JADX INFO: renamed from: xu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7979xu = m7798a("item.gun.shared.reload.pump.back");

    /* JADX INFO: renamed from: xv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7980xv = m7798a("item.gun.shared.reload.pump.forward");

    /* JADX INFO: renamed from: xw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7981xw = m7798a("item.gun.shared.reload.bolt.back");

    /* JADX INFO: renamed from: xx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7982xx = m7798a("item.gun.shared.reload.bolt.forward");

    /* JADX INFO: renamed from: xy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7983xy = m7798a("item.gun.shared.reload.winchester.lever");

    /* JADX INFO: renamed from: xz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7984xz = m7798a("item.gun.shared.foley.arm.lmg");

    /* JADX INFO: renamed from: xA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7985xA = m7798a("item.gun.shared.foley.arm.pistol");

    /* JADX INFO: renamed from: xB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7986xB = m7798a("item.gun.shared.foley.arm.rifle");

    /* JADX INFO: renamed from: xC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7987xC = m7798a("item.gun.shared.foley.arm.smg");

    /* JADX INFO: renamed from: xD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7988xD = m7798a("item.gun.shared.foley.equip.pistol");

    /* JADX INFO: renamed from: xE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7989xE = m7798a("item.gun.shared.foley.equip.rifle");

    /* JADX INFO: renamed from: xF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7990xF = m7798a("item.gun.shared.foley.equip.rocket");

    /* JADX INFO: renamed from: xG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7991xG = m7798a("item.gun.shared.foley.equip.smg");

    /* JADX INFO: renamed from: xH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7992xH = m7798a("item.gun.shared.foley.equip.revolver");

    /* JADX INFO: renamed from: xI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7993xI = m7798a("item.gun.shared.deploy");

    /* JADX INFO: renamed from: xJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7994xJ = m7798a("item.gun.shared.undeploy");

    /* JADX INFO: renamed from: xK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7995xK = m7798a("item.gun.colt.fire");

    /* JADX INFO: renamed from: xL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7996xL = m7798a("item.gun.colt.reload");

    /* JADX INFO: renamed from: xM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7997xM = m7798a("item.gun.colt.reload.empty");

    /* JADX INFO: renamed from: xN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7998xN = m7798a("item.gun.berettam1934.fire");

    /* JADX INFO: renamed from: xO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7999xO = m7798a("item.gun.berettam1934.reload");

    /* JADX INFO: renamed from: xP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8000xP = m7798a("item.gun.berettam1934.reload.empty");

    /* JADX INFO: renamed from: xQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8001xQ = m7798a("item.gun.fnmodel1910.fire");

    /* JADX INFO: renamed from: xR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8002xR = m7798a("item.gun.fnmodel1910.reload");

    /* JADX INFO: renamed from: xS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8003xS = m7798a("item.gun.fnmodel1910.reload.empty");

    /* JADX INFO: renamed from: xT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8004xT = m7798a("item.gun.m1garand.fire");

    /* JADX INFO: renamed from: xU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8005xU = m7798a("item.gun.m1garand.reload");

    /* JADX INFO: renamed from: xV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8006xV = m7798a("item.gun.m1garand.reload.empty");

    /* JADX INFO: renamed from: xW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8007xW = m7798a("item.gun.m1garand.ping");

    /* JADX INFO: renamed from: xX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8008xX = m7798a("item.gun.m1garand.pre");

    /* JADX INFO: renamed from: xY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8009xY = m7798a("item.gun.piat.fire");

    /* JADX INFO: renamed from: xZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8010xZ = m7798a("item.gun.piat.pre");

    /* JADX INFO: renamed from: ya */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8011ya = m7798a("item.gun.thompson.fire");

    /* JADX INFO: renamed from: yb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8012yb = m7798a("item.gun.thompson.reload");

    /* JADX INFO: renamed from: yc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8013yc = m7798a("item.gun.thompson.reload.empty");

    /* JADX INFO: renamed from: yd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8014yd = m7798a("item.gun.thompson.pre");

    /* JADX INFO: renamed from: ye */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8015ye = m7798a("item.gun.greasegun.fire");

    /* JADX INFO: renamed from: yf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8016yf = m7798a("item.gun.greasegun.fire.suppressor");

    /* JADX INFO: renamed from: yg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8017yg = m7798a("item.gun.greasegun.reload");

    /* JADX INFO: renamed from: yh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8018yh = m7798a("item.gun.greasegun.pre.suppressor");

    /* JADX INFO: renamed from: yi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8019yi = m7798a("item.gun.bar.fire");

    /* JADX INFO: renamed from: yj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8020yj = m7798a("item.gun.bar.reload");

    /* JADX INFO: renamed from: yk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8021yk = m7798a("item.gun.bar.reload.empty");

    /* JADX INFO: renamed from: yl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8022yl = m7798a("item.gun.bar.pre");

    /* JADX INFO: renamed from: ym */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8023ym = m7798a("item.gun.springfield.fire");

    /* JADX INFO: renamed from: yn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8024yn = m7798a("item.gun.browning30.fire");

    /* JADX INFO: renamed from: yo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8025yo = m7798a("item.gun.browning30.reload");

    /* JADX INFO: renamed from: yp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8026yp = m7798a("item.gun.m1carbine.fire");

    /* JADX INFO: renamed from: yq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8027yq = m7798a("item.gun.m1carbine.reload");

    /* JADX INFO: renamed from: yr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8028yr = m7798a("item.gun.m1carbine.pre");

    /* JADX INFO: renamed from: ys */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8029ys = m7798a("item.gun.m2carbine.fire");

    /* JADX INFO: renamed from: yt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8030yt = m7798a("item.gun.m2carbine.reload");

    /* JADX INFO: renamed from: yu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8031yu = m7798a("item.gun.bazooka.fire");

    /* JADX INFO: renamed from: yv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8032yv = m7798a("item.gun.meloncannon.reload");

    /* JADX INFO: renamed from: yw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8033yw = m7798a("item.gun.meloncannon.fire");

    /* JADX INFO: renamed from: yx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8034yx = m7798a("item.gun.p38.fire");

    /* JADX INFO: renamed from: yy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8035yy = m7798a("item.gun.p38.reload");

    /* JADX INFO: renamed from: yz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8036yz = m7798a("item.gun.p38.reload.empty");

    /* JADX INFO: renamed from: yA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8037yA = m7798a("item.gun.luger.fire");

    /* JADX INFO: renamed from: yB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8038yB = m7798a("item.gun.luger.reload");

    /* JADX INFO: renamed from: yC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8039yC = m7798a("item.gun.luger.reload.empty");

    /* JADX INFO: renamed from: yD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8040yD = m7798a("item.gun.mauser_c96.fire");

    /* JADX INFO: renamed from: yE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8041yE = m7798a("item.gun.mauser_c96.reload");

    /* JADX INFO: renamed from: yF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8042yF = m7798a("item.gun.mauser_c96.reload.empty");

    /* JADX INFO: renamed from: yG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8043yG = m7798a("item.gun.m712.fire");

    /* JADX INFO: renamed from: yH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8044yH = m7798a("item.gun.m712.pre");

    /* JADX INFO: renamed from: yI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8045yI = m7798a("item.gun.m712.reload");

    /* JADX INFO: renamed from: yJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8046yJ = m7798a("item.gun.m712.reload.empty");

    /* JADX INFO: renamed from: yK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8047yK = m7798a("item.gun.kar98k.fire");

    /* JADX INFO: renamed from: yL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8048yL = m7798a("item.gun.kar98k.reload");

    /* JADX INFO: renamed from: yM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8049yM = m7798a("item.gun.kar98k.pre");

    /* JADX INFO: renamed from: yN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8050yN = m7798a("item.gun.trenchgun.fire");

    /* JADX INFO: renamed from: yO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8051yO = m7798a("item.gun.trenchgun.pre");

    /* JADX INFO: renamed from: yP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8052yP = m7798a("item.gun.browninga5.fire");

    /* JADX INFO: renamed from: yQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8053yQ = m7798a("item.gun.browninga5.pre");

    /* JADX INFO: renamed from: yR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8054yR = m7798a("item.gun.mp40.fire");

    /* JADX INFO: renamed from: yS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8055yS = m7798a("item.gun.mp40.reload");

    /* JADX INFO: renamed from: yT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8056yT = m7798a("item.gun.mp40.reload.empty");

    /* JADX INFO: renamed from: yU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8057yU = m7798a("item.gun.mp40.pre");

    /* JADX INFO: renamed from: yV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8058yV = m7798a("item.gun.mp40.equip");

    /* JADX INFO: renamed from: yW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8059yW = m7798a("item.gun.mp41.fire");

    /* JADX INFO: renamed from: yX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8060yX = m7798a("item.gun.stg44.fire");

    /* JADX INFO: renamed from: yY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8061yY = m7798a("item.gun.stg44.reload");

    /* JADX INFO: renamed from: yZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8062yZ = m7798a("item.gun.stg44.reload.empty");

    /* JADX INFO: renamed from: za */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8063za = m7798a("item.gun.stg44.equip");

    /* JADX INFO: renamed from: zb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8064zb = m7798a("item.gun.fg42.fire");

    /* JADX INFO: renamed from: zc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8065zc = m7798a("item.gun.fg42.reload");

    /* JADX INFO: renamed from: zd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8066zd = m7798a("item.gun.mg42.fire");

    /* JADX INFO: renamed from: ze */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8067ze = m7798a("item.gun.mg42.reload");

    /* JADX INFO: renamed from: zf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8068zf = m7798a("item.gun.mg42.pre");

    /* JADX INFO: renamed from: zg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8069zg = m7798a("item.gun.panzerschreck.fire");

    /* JADX INFO: renamed from: zh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8070zh = m7798a("item.gun.gewehr43.fire");

    /* JADX INFO: renamed from: zi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8071zi = m7798a("item.gun.gewehr43.reload");

    /* JADX INFO: renamed from: zj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8072zj = m7798a("item.gun.gewehr43.reload.empty");

    /* JADX INFO: renamed from: zk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8073zk = m7798a("item.gun.tokarevtt33.fire");

    /* JADX INFO: renamed from: zl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8074zl = m7798a("item.gun.tokarevtt33.reload");

    /* JADX INFO: renamed from: zm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8075zm = m7798a("item.gun.tokarevtt33.reload.empty");

    /* JADX INFO: renamed from: zn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8076zn = m7798a("item.gun.blyskawica.fire");

    /* JADX INFO: renamed from: zo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8077zo = m7798a("item.gun.blyskawica.reload");

    /* JADX INFO: renamed from: zp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8078zp = m7798a("item.gun.blyskawica.reload.empty");

    /* JADX INFO: renamed from: zq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8079zq = m7798a("item.gun.dp28.fire");

    /* JADX INFO: renamed from: zr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8080zr = m7798a("item.gun.dp28.reload");

    /* JADX INFO: renamed from: zs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8081zs = m7798a("item.gun.kbkwz29.fire");

    /* JADX INFO: renamed from: zt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8082zt = m7798a("item.gun.kbkwz29.reload");

    /* JADX INFO: renamed from: zu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8083zu = m7798a("item.gun.koppal.fire");

    /* JADX INFO: renamed from: zv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8084zv = m7798a("item.gun.koppal.reload");

    /* JADX INFO: renamed from: zw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8085zw = m7798a("item.gun.m1944.fire");

    /* JADX INFO: renamed from: zx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8086zx = m7798a("item.gun.m1944.reload");

    /* JADX INFO: renamed from: zy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8087zy = m7798a("item.gun.mg34.fire");

    /* JADX INFO: renamed from: zz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8088zz = m7798a("item.gun.mg34.reload");

    /* JADX INFO: renamed from: zA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8089zA = m7798a("item.gun.mg34.pre");

    /* JADX INFO: renamed from: zB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8090zB = m7798a("item.gun.mg34.equip");

    /* JADX INFO: renamed from: zC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8091zC = m7798a("item.gun.mosinnagant.fire");

    /* JADX INFO: renamed from: zD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8092zD = m7798a("item.gun.mosinnagant.pre");

    /* JADX INFO: renamed from: zE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8093zE = m7798a("item.gun.panzerfaust.fire");

    /* JADX INFO: renamed from: zF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8094zF = m7798a("item.gun.panzerfaust.reload");

    /* JADX INFO: renamed from: zG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8095zG = m7798a("item.gun.pps43.fire");

    /* JADX INFO: renamed from: zH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8096zH = m7798a("item.gun.pps43.reload");

    /* JADX INFO: renamed from: zI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8097zI = m7798a("item.gun.pps43.equip");

    /* JADX INFO: renamed from: zJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8098zJ = m7798a("item.gun.ppsh.fire");

    /* JADX INFO: renamed from: zK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8099zK = m7798a("item.gun.ppsh.reload");

    /* JADX INFO: renamed from: zL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8100zL = m7798a("item.gun.ppsh.equip");

    /* JADX INFO: renamed from: zM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8101zM = m7798a("item.gun.ptrs.fire");

    /* JADX INFO: renamed from: zN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8102zN = m7798a("item.gun.ptrs.reload");

    /* JADX INFO: renamed from: zO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8103zO = m7798a("item.gun.tokarevavt40.fire");

    /* JADX INFO: renamed from: zP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8104zP = m7798a("item.gun.tokarevavt40.reload");

    /* JADX INFO: renamed from: zQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8105zQ = m7798a("item.gun.fbvis.fire");

    /* JADX INFO: renamed from: zR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8106zR = m7798a("item.gun.fbvis.reload");

    /* JADX INFO: renamed from: zS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8107zS = m7798a("item.gun.fbvis.reload.empty");

    /* JADX INFO: renamed from: zT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8108zT = m7798a("item.gun.zb26.fire");

    /* JADX INFO: renamed from: zU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8109zU = m7798a("item.gun.zb26.reload");

    /* JADX INFO: renamed from: zV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8110zV = m7798a("item.gun.type14.fire");

    /* JADX INFO: renamed from: zW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8111zW = m7798a("item.gun.type14.reload");

    /* JADX INFO: renamed from: zX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8112zX = m7798a("item.gun.type14.reload.empty");

    /* JADX INFO: renamed from: zY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8113zY = m7798a("item.gun.type94.fire");

    /* JADX INFO: renamed from: zZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8114zZ = m7798a("item.gun.type94.reload");

    /* JADX INFO: renamed from: Aa */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8115Aa = m7798a("item.gun.type94.reload.empty");

    /* JADX INFO: renamed from: Ab */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8116Ab = m7798a("item.gun.type26.fire");

    /* JADX INFO: renamed from: Ac */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8117Ac = m7798a("item.gun.type26.reload");

    /* JADX INFO: renamed from: Ad */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8118Ad = m7798a("item.gun.type38.fire");

    /* JADX INFO: renamed from: Ae */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8119Ae = m7798a("item.gun.type38.pre");

    /* JADX INFO: renamed from: Af */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8120Af = m7798a("item.gun.type99.fire");

    /* JADX INFO: renamed from: Ag */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8121Ag = m7798a("item.gun.type99.reload");

    /* JADX INFO: renamed from: Ah */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8122Ah = m7798a("item.gun.type4.fire");

    /* JADX INFO: renamed from: Ai */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8123Ai = m7798a("item.gun.type4.reload");

    /* JADX INFO: renamed from: Aj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8124Aj = m7798a("item.gun.type92.fire");

    /* JADX INFO: renamed from: Ak */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8125Ak = m7798a("item.gun.type92.reload");

    /* JADX INFO: renamed from: Al */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8126Al = m7798a("item.gun.type92.equip");

    /* JADX INFO: renamed from: Am */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8127Am = m7798a("item.gun.type11.fire");

    /* JADX INFO: renamed from: An */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8128An = m7798a("item.gun.type11.reload");

    /* JADX INFO: renamed from: Ao */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8129Ao = m7798a("item.gun.type100.fire");

    /* JADX INFO: renamed from: Ap */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8130Ap = m7798a("item.gun.type100.reload");

    /* JADX INFO: renamed from: Aq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8131Aq = m7798a("item.gun.type100.reload.empty");

    /* JADX INFO: renamed from: Ar */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8132Ar = m7798a("item.gun.bren.mk2.fire");

    /* JADX INFO: renamed from: As */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8133As = m7798a("item.gun.bren.mk2.pre");

    /* JADX INFO: renamed from: At */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8134At = m7798a("item.gun.bren.mk2.reload");

    /* JADX INFO: renamed from: Au */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8135Au = m7798a("item.gun.type96.fire");

    /* JADX INFO: renamed from: Av */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8136Av = m7798a("item.gun.type96.pre");

    /* JADX INFO: renamed from: Aw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8137Aw = m7798a("item.gun.type96.reload");

    /* JADX INFO: renamed from: Ax */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8138Ax = m7798a("item.gun.type96.equip");

    /* JADX INFO: renamed from: Ay */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8139Ay = m7798a("item.gun.type98.fire");

    /* JADX INFO: renamed from: Az */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8140Az = m7798a("item.gun.type98.reload");

    /* JADX INFO: renamed from: AA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8141AA = m7798a("item.gun.leeenfieldmk1.fire");

    /* JADX INFO: renamed from: AB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8142AB = m7798a("item.gun.leeenfieldmk1.pre");

    /* JADX INFO: renamed from: AC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8143AC = m7798a("item.gun.webley.mk6.fire");

    /* JADX INFO: renamed from: AD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8144AD = m7798a("item.gun.webley.mk6.pre");

    /* JADX INFO: renamed from: AE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8145AE = m7798a("item.gun.webley.mk6.reload");

    /* JADX INFO: renamed from: AF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8146AF = m7798a("item.gun.nagant_m1895.fire");

    /* JADX INFO: renamed from: AG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8147AG = m7798a("item.gun.nagant_m1895.pre");

    /* JADX INFO: renamed from: AH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8148AH = m7798a("item.gun.nagant_m1895.reload");

    /* JADX INFO: renamed from: AI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8149AI = m7798a("item.gun.stenmk2.fire");

    /* JADX INFO: renamed from: AJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8150AJ = m7798a("item.gun.stenmk2.reload");

    /* JADX INFO: renamed from: AK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8151AK = m7798a("item.gun.stenmk2.pre");

    /* JADX INFO: renamed from: AL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8152AL = m7798a("item.gun.stenmk2.reload.empty");

    /* JADX INFO: renamed from: AM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8153AM = m7798a("item.gun.stenmk2.fire.suppressor");

    /* JADX INFO: renamed from: AN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8154AN = m7798a("item.gun.stenmk2.pre.suppressor");

    /* JADX INFO: renamed from: AO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8155AO = m7798a("item.gun.delislecarbine.fire");

    /* JADX INFO: renamed from: AP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8156AP = m7798a("item.gun.delislecarbine.pre");

    /* JADX INFO: renamed from: AQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8157AQ = m7798a("item.gun.delislecarbine.reload");

    /* JADX INFO: renamed from: AR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8158AR = m7798a("item.gun.vickersk.fire");

    /* JADX INFO: renamed from: AS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8159AS = m7798a("item.gun.vickersk.reload");

    /* JADX INFO: renamed from: AT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8160AT = m7798a("item.gun.carcano.fire");

    /* JADX INFO: renamed from: AU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8161AU = m7798a("item.gun.model1935.fire");

    /* JADX INFO: renamed from: AV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8162AV = m7798a("item.gun.model1935.reload");

    /* JADX INFO: renamed from: AW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8163AW = m7798a("item.gun.model38.fire");

    /* JADX INFO: renamed from: AX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8164AX = m7798a("item.gun.model38.pre");

    /* JADX INFO: renamed from: AY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8165AY = m7798a("item.gun.model38.reload");

    /* JADX INFO: renamed from: AZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8166AZ = m7798a("item.gun.model38.equip");

    /* JADX INFO: renamed from: Ba */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8167Ba = m7798a("item.gun.model1930.fire");

    /* JADX INFO: renamed from: Bb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8168Bb = m7798a("item.gun.model1930.reload");

    /* JADX INFO: renamed from: Bc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8169Bc = m7798a("item.gun.model1930.reload.empty");

    /* JADX INFO: renamed from: Bd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8170Bd = m7798a("item.gun.fiatrevelli.fire");

    /* JADX INFO: renamed from: Be */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8171Be = m7798a("item.gun.tromboncino.fire");

    /* JADX INFO: renamed from: Bf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8172Bf = m7798a("item.gun.glisenti.model.1910.fire");

    /* JADX INFO: renamed from: Bg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8173Bg = m7798a("item.gun.glisenti.model.1910.reload");

    /* JADX INFO: renamed from: Bh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8174Bh = m7798a("item.gun.glisenti.model.1910.reload.empty");

    /* JADX INFO: renamed from: Bi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8175Bi = m7798a("item.gun.lebel1886.fire");

    /* JADX INFO: renamed from: Bj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8176Bj = m7798a("item.gun.pistolet_automatique_modele_1935a.fire");

    /* JADX INFO: renamed from: Bk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8177Bk = m7798a("item.gun.pistolet_automatique_modele_1935a.reload");

    /* JADX INFO: renamed from: Bl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8178Bl = m7798a("item.gun.pistolet_automatique_modele_1935a.reload.empty");

    /* JADX INFO: renamed from: Bm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8179Bm = m7798a("item.gun.macmle1931.fire");

    /* JADX INFO: renamed from: Bn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8180Bn = m7798a("item.gun.macmle1931.reload");

    /* JADX INFO: renamed from: Bo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8181Bo = m7798a("item.gun.macmle1931.pre");

    /* JADX INFO: renamed from: Bp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8182Bp = m7798a("item.gun.fusil1917.fire");

    /* JADX INFO: renamed from: Bq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8183Bq = m7798a("item.gun.fusil1917.reload");

    /* JADX INFO: renamed from: Br */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8184Br = m7798a("item.gun.mas38.fire");

    /* JADX INFO: renamed from: Bs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8185Bs = m7798a("item.gun.mas38.reload");

    /* JADX INFO: renamed from: Bt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8186Bt = m7798a("item.gun.mas38.pre");

    /* JADX INFO: renamed from: Bu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8187Bu = m7798a("item.gun.batr.fire");

    /* JADX INFO: renamed from: Bv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8188Bv = m7798a("item.gun.batr.reload");

    /* JADX INFO: renamed from: Bw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8189Bw = m7798a("item.gun.batr.pre");

    /* JADX INFO: renamed from: Bx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8190Bx = m7798a("item.gun.panzerbuchse39.fire");

    /* JADX INFO: renamed from: By */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8191By = m7798a("item.gun.panzerbuchse39.reload");

    /* JADX INFO: renamed from: Bz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8192Bz = m7798a("item.gun.panzerbuchse39.pre");

    /* JADX INFO: renamed from: BA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8193BA = m7798a("item.gun.panzerbuchse39.equip");

    /* JADX INFO: renamed from: BB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8194BB = m7798a("item.gun.modele_1892_revolver.fire");

    /* JADX INFO: renamed from: BC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8195BC = m7798a("item.gun.modele_1892_revolver.pre");

    /* JADX INFO: renamed from: BD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8196BD = m7798a("item.gun.modele_1892_revolver.reload");

    /* JADX INFO: renamed from: BE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8197BE = m7798a("item.gun.m2flamethrower.fire");

    /* JADX INFO: renamed from: BF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8198BF = m7798a("item.gun.m2flamethrower.reload");

    /* JADX INFO: renamed from: BG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8199BG = m7798a("item.gun.m2flamethrower.pre");

    /* JADX INFO: renamed from: BH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8200BH = m7798a("item.gun.m2flamethrower.post");

    /* JADX INFO: renamed from: BI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8201BI = m7798a("item.gun.m2flamethrower.last");

    /* JADX INFO: renamed from: BJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8202BJ = m7798a("item.gun.m2flamethrower.ignite.start");

    /* JADX INFO: renamed from: BK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8203BK = m7798a("item.gun.m2flamethrower.ignite");

    /* JADX INFO: renamed from: BL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8204BL = m7798a("item.gun.m30.fire");

    /* JADX INFO: renamed from: BM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8205BM = m7798a("item.gun.m30.reload");

    /* JADX INFO: renamed from: BN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8206BN = m7798a("item.gun.ak74.fire");

    /* JADX INFO: renamed from: BO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8207BO = m7798a("item.gun.ak74.pre");

    /* JADX INFO: renamed from: BP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8208BP = m7798a("item.gun.ak74.reload");

    /* JADX INFO: renamed from: BQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8209BQ = m7798a("item.gun.ak74.reload.empty");

    /* JADX INFO: renamed from: BR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8210BR = m7798a("item.gun.m4a4.fire");

    /* JADX INFO: renamed from: BS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8211BS = m7798a("item.gun.m4a4.reload");

    /* JADX INFO: renamed from: BT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8212BT = m7798a("item.gun.m4a4.pre");

    /* JADX INFO: renamed from: BU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8213BU = m7798a("item.gun.lewisgun.fire");

    /* JADX INFO: renamed from: BV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8214BV = m7798a("item.gun.lewisgun.reload");

    /* JADX INFO: renamed from: BW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8215BW = m7798a("item.gun.welrod.fire");

    /* JADX INFO: renamed from: BX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8216BX = m7798a("item.gun.welrod.pre");

    /* JADX INFO: renamed from: BY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8217BY = m7798a("item.gun.welrod.reload");

    /* JADX INFO: renamed from: BZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8218BZ = m7798a("item.gun.welrod.equip");

    /* JADX INFO: renamed from: Ca */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8219Ca = m7798a("item.gun.browninghipower.fire");

    /* JADX INFO: renamed from: Cb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8220Cb = m7798a("item.gun.browninghipower.reload");

    /* JADX INFO: renamed from: Cc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8221Cc = m7798a("item.gun.browninghipower.reload.empty");

    /* JADX INFO: renamed from: Cd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8222Cd = m7798a("item.gun.brownbess.fire");

    /* JADX INFO: renamed from: Ce */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8223Ce = m7798a("item.gun.brownbess.pre");

    /* JADX INFO: renamed from: Cf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8224Cf = m7798a("item.gun.howell.fire");

    /* JADX INFO: renamed from: Cg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8225Cg = m7798a("item.gun.howell.reload");

    /* JADX INFO: renamed from: Ch */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8226Ch = m7798a("item.gun.howell.pre");

    /* JADX INFO: renamed from: Ci */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8227Ci = m7798a("item.gun.kis.fire");

    /* JADX INFO: renamed from: Cj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8228Cj = m7798a("item.gun.kis.reload");

    /* JADX INFO: renamed from: Ck */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8229Ck = m7798a("item.gun.kis.reload.empty");

    /* JADX INFO: renamed from: Cl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8230Cl = m7798a("item.gun.mp.3008.fire");

    /* JADX INFO: renamed from: Cm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8231Cm = m7798a("item.gun.mp.3008.reload");

    /* JADX INFO: renamed from: Cn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8232Cn = m7798a("item.gun.mp.3008.reload.empty");

    /* JADX INFO: renamed from: Co */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8233Co = m7798a("item.gun.winchester.1895.fire");

    /* JADX INFO: renamed from: Cp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8234Cp = m7798a("item.gun.winchester.1895.reload");

    /* JADX INFO: renamed from: Cq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8235Cq = m7798a("item.gun.wz35.fire");

    /* JADX INFO: renamed from: Cr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8236Cr = m7798a("item.gun.wz35.reload");

    /* JADX INFO: renamed from: Cs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8237Cs = m7798a("item.gun.wz35.pre");

    /* JADX INFO: renamed from: Ct */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8238Ct = m7798a("item.gun.flak38.fire");

    /* JADX INFO: renamed from: Cu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8239Cu = m7798a("item.gun.flak38.pre");

    /* JADX INFO: renamed from: Cv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8240Cv = m7798a("item.knife.equip");

    /* JADX INFO: renamed from: Cw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8241Cw = m7798a("item.knife.swing");

    /* JADX INFO: renamed from: Cx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8242Cx = m7798a("item.knife.trick.0");

    /* JADX INFO: renamed from: Cy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8243Cy = m7798a("item.shovel.swing");

    /* JADX INFO: renamed from: Cz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8244Cz = m7798a("item.sword.swing");

    /* JADX INFO: renamed from: CA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8245CA = m7798a("item.wrench.swing");

    /* JADX INFO: renamed from: CB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8246CB = m7798a("item.gun.shared.zoom.pistol.in");

    /* JADX INFO: renamed from: CC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8247CC = m7798a("item.gun.shared.zoom.pistol.out");

    /* JADX INFO: renamed from: CD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8248CD = m7798a("item.gun.shared.zoom.mg.in");

    /* JADX INFO: renamed from: CE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8249CE = m7798a("item.gun.shared.zoom.mg.out");

    /* JADX INFO: renamed from: CF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8250CF = m7798a("item.gun.shared.zoom.rifle.in");

    /* JADX INFO: renamed from: CG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8251CG = m7798a("item.gun.shared.zoom.rifle.out");

    /* JADX INFO: renamed from: CH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8252CH = m7798a("item.gun.shared.zoom.smg.in");

    /* JADX INFO: renamed from: CI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8253CI = m7798a("item.gun.shared.zoom.smg.out");

    /* JADX INFO: renamed from: CJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8254CJ = m7798a("item.gun.shared.lastround.smg");

    /* JADX INFO: renamed from: CK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8255CK = m7798a("item.gun.shared.lastround.lmg");

    /* JADX INFO: renamed from: CL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8256CL = m7798a("item.gun.shared.lastround.mg");

    /* JADX INFO: renamed from: CM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8257CM = m7798a("item.gun.shared.lastround.pistol");

    /* JADX INFO: renamed from: CN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8258CN = m7798a("item.gun.shared.lastround.shotgun");

    /* JADX INFO: renamed from: CO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8259CO = m7798a("ambient.wildlife.birds.chirp");

    /* JADX INFO: renamed from: CP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8260CP = m7798a("ambient.wildlife.birds.crow.calls");

    /* JADX INFO: renamed from: CQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8261CQ = m7798a("ambient.wildlife.cockerel.call");

    /* JADX INFO: renamed from: CR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8262CR = m7798a("ambient.wildlife.dog.bark.distant");

    /* JADX INFO: renamed from: CS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8263CS = m7798a("ambient.wildlife.birds.robin.cry");

    /* JADX INFO: renamed from: CT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8264CT = m7798a("ambient.wildlife.birds.raven.cry");

    /* JADX INFO: renamed from: CU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8265CU = m7798a("ambient.wildlife.birds.dove.call");

    /* JADX INFO: renamed from: CV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8266CV = m7798a("ambient.wildlife.birds.crow.calls.near");

    /* JADX INFO: renamed from: CW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8267CW = m7798a("ambient.wildlife.birds.woodpecker");

    /* JADX INFO: renamed from: CX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8268CX = m7798a("ambient.wildlife.birds.bluejay");

    /* JADX INFO: renamed from: CY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8269CY = m7798a("ambient.wildlife.owl.call");

    /* JADX INFO: renamed from: CZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8270CZ = m7798a("ambient.wildlife.owl.call.distant");

    /* JADX INFO: renamed from: Da */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8271Da = m7798a("ambient.wildlife.owl.screech.distant");

    /* JADX INFO: renamed from: Db */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8272Db = m7798a("ambient.war.artillery.distant");

    /* JADX INFO: renamed from: Dc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8273Dc = m7798a("ambient.war.artillery.far");

    /* JADX INFO: renamed from: Dd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8274Dd = m7798a("ambient.war.artillery.close");

    /* JADX INFO: renamed from: De */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8275De = m7798a("ambient.war.artillery.katyusha");

    /* JADX INFO: renamed from: Df */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8276Df = m7798a("ambient.war.distant.tank.shot");

    /* JADX INFO: renamed from: Dg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8277Dg = m7798a("ambient.war.distant.tank");

    /* JADX INFO: renamed from: Dh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8278Dh = m7798a("ambient.war.distant.gunfight");

    /* JADX INFO: renamed from: Di */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8279Di = m7798a("ambient.war.distant.gun");

    /* JADX INFO: renamed from: Dj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8280Dj = m7798a("ambient.war.distant.flak");

    /* JADX INFO: renamed from: Dk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8281Dk = m7798a("ambient.war.distant.artillery");

    /* JADX INFO: renamed from: Dl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8282Dl = m7798a("ambient.war.distant.explosion");

    /* JADX INFO: renamed from: Dm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8283Dm = m7798a("ambient.weather.lightning.nose");

    /* JADX INFO: renamed from: Dn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8284Dn = m7798a("ambient.weather.lightning.stereo");

    /* JADX INFO: renamed from: Do */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8285Do = m7798a("ambient.weather.lightning");

    /* JADX INFO: renamed from: Dp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8286Dp = m7798a("ambient.lsp.mosque.call");

    /* JADX INFO: renamed from: Dq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8287Dq = m7798a("ambient.lsp.blade.creak");

    /* JADX INFO: renamed from: Dr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8288Dr = m7798a("ambient.lsp.alarm.0");

    /* JADX INFO: renamed from: Ds */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8289Ds = m7798a("ambient.lsp.alarm.1");

    /* JADX INFO: renamed from: Dt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8290Dt = m7798a("ambient.lsp.alarm.2");

    /* JADX INFO: renamed from: Du */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8291Du = m7798a("ambient.lsp.alarm.3");

    /* JADX INFO: renamed from: Dv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8292Dv = m7798a("ambient.lsp.alarm.4");

    /* JADX INFO: renamed from: Dw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8293Dw = m7798a("ambient.lsp.alarm.5");

    /* JADX INFO: renamed from: Dx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8294Dx = m7798a("ambient.lsp.alarm.6");

    /* JADX INFO: renamed from: Dy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8295Dy = m7798a("ambient.lsp.alarm.7");

    /* JADX INFO: renamed from: Dz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8296Dz = m7798a("ambient.lsp.alarm.8");

    /* JADX INFO: renamed from: DA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8297DA = m7798a("ambient.lsp.alarm.9");

    /* JADX INFO: renamed from: DB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8298DB = m7798a("ambient.lsp.beach.wave");

    /* JADX INFO: renamed from: DC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8299DC = m7798a("ambient.lsp.radio.german");

    /* JADX INFO: renamed from: DD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8300DD = m7798a("ambient.lsp.radio.japan");

    /* JADX INFO: renamed from: DE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8301DE = m7798a("ambient.lsp.radio.music.jazz.0");

    /* JADX INFO: renamed from: DF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8302DF = m7798a("ambient.lsp.radio.music.jazz.1");

    /* JADX INFO: renamed from: DG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8303DG = m7798a("ambient.lsp.radio.music.church.0");

    /* JADX INFO: renamed from: DH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8304DH = m7798a("ambient.lsp.radio.music.polish.0");

    /* JADX INFO: renamed from: DI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8305DI = m7798a("ambient.lsp.radio.music.polish.1");

    /* JADX INFO: renamed from: DJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8306DJ = m7798a("ambient.lsp.radio.music.polish.2");

    /* JADX INFO: renamed from: DK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8307DK = m7798a("ambient.lsp.radio.music.arabic.0");

    /* JADX INFO: renamed from: DL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8308DL = m7798a("ambient.lsp.radio.music.arabic.1");

    /* JADX INFO: renamed from: DM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8309DM = m7798a("ambient.lsp.radio.music.french.0");

    /* JADX INFO: renamed from: DN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8310DN = m7798a("ambient.lsp.radio.music.french.1");

    /* JADX INFO: renamed from: DO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8311DO = m7798a("ambient.lsp.radio.music.french.2");

    /* JADX INFO: renamed from: DP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8312DP = m7798a("ambient.lsp.radio.music.african.0");

    /* JADX INFO: renamed from: DQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8313DQ = m7798a("ambient.lsp.radio.music.african.1");

    /* JADX INFO: renamed from: DR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8314DR = m7798a("ambient.lsp.radio.music.greek.0");

    /* JADX INFO: renamed from: DS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8315DS = m7798a("ambient.lsp.radio.music.greek.1");

    /* JADX INFO: renamed from: DT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8316DT = m7798a("ambient.lsp.radio.music.japanese.0");

    /* JADX INFO: renamed from: DU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8317DU = m7798a("ambient.lsp.radio.music.japanese.1");

    /* JADX INFO: renamed from: DV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8318DV = m7798a("ambient.lsp.radio.music.japanese.2");

    /* JADX INFO: renamed from: DW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8319DW = m7798a("ambient.lsp.radio.music.italian.0");

    /* JADX INFO: renamed from: DX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8320DX = m7798a("ambient.lsp.radio.music.italian.1");

    /* JADX INFO: renamed from: DY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8321DY = m7798a("ambient.lsp.radio.music.italian.2");

    /* JADX INFO: renamed from: DZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8322DZ = m7798a("ambient.lsp.radio.music.italian.3");

    /* JADX INFO: renamed from: Ea */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8323Ea = m7798a("ambient.lsp.machinery.0");

    /* JADX INFO: renamed from: Eb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8324Eb = m7798a("ambient.lsp.machinery.1");

    /* JADX INFO: renamed from: Ec */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8325Ec = m7798a("ambient.lsp.machinery.2");

    /* JADX INFO: renamed from: Ed */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8326Ed = m7798a("ambient.lsp.machinery.3");

    /* JADX INFO: renamed from: Ee */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8327Ee = m7798a("ambient.lsp.machinery.4");

    /* JADX INFO: renamed from: Ef */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8328Ef = m7798a("ambient.lsp.machinery.function.0");

    /* JADX INFO: renamed from: Eg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8329Eg = m7798a("ambient.lsp.machinery.function.1");

    /* JADX INFO: renamed from: Eh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8330Eh = m7798a("ambient.lsp.machinery.function.2");

    /* JADX INFO: renamed from: Ei */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8331Ei = m7798a("ambient.lsp.machinery.function.3");

    /* JADX INFO: renamed from: Ej */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8332Ej = m7798a("ambient.lsp.machinery.function.4");

    /* JADX INFO: renamed from: Ek */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8333Ek = m7798a("ambient.lsp.machinery.function.5");

    /* JADX INFO: renamed from: El */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8334El = m7798a("ambient.lsp.machinery.function.6");

    /* JADX INFO: renamed from: Em */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8335Em = m7798a("ambient.lsp.vehicle.tank.engine.idle");

    /* JADX INFO: renamed from: En */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8336En = m7798a("ambient.lsp.vehicle.plane.engine.idle.distant");

    /* JADX INFO: renamed from: Eo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8337Eo = m7798a("ambient.lsp.vehicle.truck.engine.idle");

    /* JADX INFO: renamed from: Ep */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8338Ep = m7798a("ambient.lsp.vehicle.boat.engine.idle");

    /* JADX INFO: renamed from: Eq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8339Eq = m7798a("ambient.lsp.vehicle.uboat.engine.idle");

    /* JADX INFO: renamed from: Er */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8340Er = m7798a("ambient.lsp.vehicle.plane.crash.crete");

    /* JADX INFO: renamed from: Es */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8341Es = m7798a("ambient.lsp.human.whistle");

    /* JADX INFO: renamed from: Et */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8342Et = m7798a("ambient.lsp.phone.ring");

    /* JADX INFO: renamed from: Eu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8343Eu = m7798a("ambient.lsp.music.reichstag");

    /* JADX INFO: renamed from: Ev */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8344Ev = m7798a("ambient.lsp.church.bell0");

    /* JADX INFO: renamed from: Ew */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8345Ew = m7798a("ambient.lsp.church.bell0.far");

    /* JADX INFO: renamed from: Ex */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8346Ex = m7798a("ambient.lsp.church.bell1");

    /* JADX INFO: renamed from: Ey */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8347Ey = m7798a("ambient.lsp.church.bell1.far");

    /* JADX INFO: renamed from: Ez */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8348Ez = m7798a("ambient.lsp.church.bell2");

    /* JADX INFO: renamed from: EA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8349EA = m7798a("ambient.lsp.church.bell2.far");

    /* JADX INFO: renamed from: EB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8350EB = m7798a("ambient.lsp.docks.shipbell");

    /* JADX INFO: renamed from: EC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8351EC = m7798a("ambient.lsp.docks.horn");

    /* JADX INFO: renamed from: ED */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8352ED = m7798a("ambient.lsp.thunder");

    /* JADX INFO: renamed from: EE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8353EE = m7798a("ambient.lsp.water.drip.heavy.0");

    /* JADX INFO: renamed from: EF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8354EF = m7798a("ambient.lsp.water.drip.heavy.1");

    /* JADX INFO: renamed from: EG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8355EG = m7798a("ambient.lsp.water.drip.metal.0");

    /* JADX INFO: renamed from: EH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8356EH = m7798a("ambient.lsp.water.drip.metal.1");

    /* JADX INFO: renamed from: EI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8357EI = m7798a("ambient.lsp.industrial.metal.clanking");

    /* JADX INFO: renamed from: EJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8358EJ = m7798a("ambient.lsp.industrial.metal.stress");

    /* JADX INFO: renamed from: EK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8359EK = m7798a("ambient.lsp.fire.small");

    /* JADX INFO: renamed from: EL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8360EL = m7798a("ambient.lsp.fire.large");

    /* JADX INFO: renamed from: EM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8361EM = m7798a("ambient.lsp.fire.metal");

    /* JADX INFO: renamed from: EN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8362EN = m7798a("ambient.lsp.siren");

    /* JADX INFO: renamed from: EO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8363EO = m7798a("ambient.lsp.siren.double");

    /* JADX INFO: renamed from: EP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8364EP = m7798a("ambient.lsp.rubble");

    /* JADX INFO: renamed from: EQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8365EQ = m7798a("ambient.loop.crickets");

    /* JADX INFO: renamed from: ER */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8366ER = m7798a("ambient.loop.crickets.desert");

    /* JADX INFO: renamed from: ES */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8367ES = m7798a("ambient.loop.forest");

    /* JADX INFO: renamed from: ET */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8368ET = m7798a("ambient.loop.interior.house");

    /* JADX INFO: renamed from: EU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8369EU = m7798a("ambient.loop.interior.bunker");

    /* JADX INFO: renamed from: EV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8370EV = m7798a("ambient.loop.interior.wind.howl");

    /* JADX INFO: renamed from: EW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8371EW = m7798a("ambient.loop.rainstorm");

    /* JADX INFO: renamed from: EX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8372EX = m7798a("ambient.loop.rainstorm.urban");

    /* JADX INFO: renamed from: EY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8373EY = m7798a("ambient.loop.interior.rainstorm.urban");

    /* JADX INFO: renamed from: EZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8374EZ = m7798a("ambient.loop.war");

    /* JADX INFO: renamed from: Fa */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8375Fa = m7798a("ambient.loop.wind");

    /* JADX INFO: renamed from: Fb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8376Fb = m7798a("ambient.loop.wind.scary");

    /* JADX INFO: renamed from: Fc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8377Fc = m7798a("ambient.loop.wind.blizzard");

    /* JADX INFO: renamed from: Fd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8378Fd = m7798a("ambient.loop.wind.blizzard.strong");

    /* JADX INFO: renamed from: Fe */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8379Fe = m7798a("ambient.loop.wind.sandstorm");

    /* JADX INFO: renamed from: Ff */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8380Ff = m7798a("ambient.loop.wind.sandstorm.foliage");

    /* JADX INFO: renamed from: Fg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8381Fg = m7798a("ambient.loop.wind.strong");

    /* JADX INFO: renamed from: Fh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8382Fh = m7798a("ambient.loop.urban");

    /* JADX INFO: renamed from: Fi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8383Fi = m7798a("ambient.explosion.grenade.nose");

    /* JADX INFO: renamed from: Fj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8384Fj = m7798a("ambient.explosion.grenade.nose.distant");

    /* JADX INFO: renamed from: Fk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8385Fk = m7798a("ambient.explosion.grenade.ambience");

    /* JADX INFO: renamed from: Fl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8386Fl = m7798a("ambient.explosion.grenade.ambience.distant");

    /* JADX INFO: renamed from: Fm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8387Fm = m7798a("ambient.explosion.grenade.ambience.indoors");

    /* JADX INFO: renamed from: Fn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8388Fn = m7798a("ambient.explosion.grenade.ambience.indoors.distant");

    /* JADX INFO: renamed from: Fo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8389Fo = m7798a("ambient.explosion.grenade.explode.close");

    /* JADX INFO: renamed from: Fp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8390Fp = m7798a("ambient.explosion.grenade.explode.close.indoors");

    /* JADX INFO: renamed from: Fq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8391Fq = m7798a("ambient.explosion.grenade.explode.close.stereo");

    /* JADX INFO: renamed from: Fr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8392Fr = m7798a("ambient.explosion.grenade.explode.bass");

    /* JADX INFO: renamed from: Fs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8393Fs = m7798a("ambient.explosion.grenade.explode.distant");

    /* JADX INFO: renamed from: Ft */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8394Ft = m7798a("ambient.explosion.grenade.explode.distant.indoors");

    /* JADX INFO: renamed from: Fu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8395Fu = m7798a("ambient.explosion.artillery.ambience");

    /* JADX INFO: renamed from: Fv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8396Fv = m7798a("ambient.explosion.artillery.ambience.distant");

    /* JADX INFO: renamed from: Fw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8397Fw = m7798a("ambient.explosion.debris");

    /* JADX INFO: renamed from: Fx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8398Fx = m7798a("ambient.explosion.debris.indoors");

    /* JADX INFO: renamed from: Fy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8399Fy = m7798a("ambient.explosion.debris.brick");

    /* JADX INFO: renamed from: Fz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8400Fz = m7798a("ambient.explosion.debris.rock");

    /* JADX INFO: renamed from: FA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8401FA = m7798a("ambient.explosion.debris.metal");

    /* JADX INFO: renamed from: FB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8402FB = m7798a("ambient.explosion.debris.glass");

    /* JADX INFO: renamed from: FC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8403FC = m7798a("ambient.explosion.debris.sandbag");

    /* JADX INFO: renamed from: FD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8404FD = m7798a("ambient.explosion.debris.wood");

    /* JADX INFO: renamed from: FE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8405FE = m7798a("ambient.explosion.debris.vehicle");

    /* JADX INFO: renamed from: FF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8406FF = m7798a("team.us.bot.intro");

    /* JADX INFO: renamed from: FG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8407FG = m7798a("team.us.bot.go");

    /* JADX INFO: renamed from: FH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8408FH = m7798a("team.us.bot.grenade");

    /* JADX INFO: renamed from: FI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8409FI = m7798a("team.us.bot.hurt");

    /* JADX INFO: renamed from: FJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8410FJ = m7798a("team.us.bot.reloading");

    /* JADX INFO: renamed from: FK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8411FK = m7798a("team.us.bot.spotted");

    /* JADX INFO: renamed from: FL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8412FL = m7798a("team.us.bot.taunt");

    /* JADX INFO: renamed from: FM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8413FM = m7798a("team.ger.bot.intro");

    /* JADX INFO: renamed from: FN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8414FN = m7798a("team.ger.bot.go");

    /* JADX INFO: renamed from: FO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8415FO = m7798a("team.ger.bot.grenade");

    /* JADX INFO: renamed from: FP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8416FP = m7798a("team.ger.bot.hurt");

    /* JADX INFO: renamed from: FQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8417FQ = m7798a("team.ger.bot.reloading");

    /* JADX INFO: renamed from: FR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8418FR = m7798a("team.ger.bot.spotted");

    /* JADX INFO: renamed from: FS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8419FS = m7798a("team.ger.bot.taunt");

    /* JADX INFO: renamed from: FT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8420FT = m7798a("team.jpn.bot.intro");

    /* JADX INFO: renamed from: FU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8421FU = m7798a("team.jpn.bot.go");

    /* JADX INFO: renamed from: FV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8422FV = m7798a("team.jpn.bot.grenade");

    /* JADX INFO: renamed from: FW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8423FW = m7798a("team.jpn.bot.hurt");

    /* JADX INFO: renamed from: FX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8424FX = m7798a("team.jpn.bot.reloading");

    /* JADX INFO: renamed from: FY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8425FY = m7798a("team.jpn.bot.spotted");

    /* JADX INFO: renamed from: FZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8426FZ = m7798a("team.jpn.bot.taunt");

    /* JADX INFO: renamed from: Ga */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8427Ga = m7798a("team.jpn.banzai");

    /* JADX INFO: renamed from: Gb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8428Gb = m7798a("team.jpn.banzai.distant");

    /* JADX INFO: renamed from: Gc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8429Gc = m7798a("team.jpn.banzai.commander");

    /* JADX INFO: renamed from: Gd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8430Gd = m7798a("team.fr.bot.intro");

    /* JADX INFO: renamed from: Ge */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8431Ge = m7798a("team.fr.bot.go");

    /* JADX INFO: renamed from: Gf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8432Gf = m7798a("team.fr.bot.grenade");

    /* JADX INFO: renamed from: Gg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8433Gg = m7798a("team.fr.bot.hurt");

    /* JADX INFO: renamed from: Gh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8434Gh = m7798a("team.fr.bot.reloading");

    /* JADX INFO: renamed from: Gi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8435Gi = m7798a("team.fr.bot.spotted");

    /* JADX INFO: renamed from: Gj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8436Gj = m7798a("team.fr.bot.taunt");

    /* JADX INFO: renamed from: Gk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8437Gk = m7798a("team.gb.bot.intro");

    /* JADX INFO: renamed from: Gl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8438Gl = m7798a("team.gb.bot.go");

    /* JADX INFO: renamed from: Gm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8439Gm = m7798a("team.gb.bot.grenade");

    /* JADX INFO: renamed from: Gn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8440Gn = m7798a("team.gb.bot.hurt");

    /* JADX INFO: renamed from: Go */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8441Go = m7798a("team.gb.bot.reloading");

    /* JADX INFO: renamed from: Gp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8442Gp = m7798a("team.gb.bot.spotted");

    /* JADX INFO: renamed from: Gq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8443Gq = m7798a("team.gb.bot.taunt");

    /* JADX INFO: renamed from: Gr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8444Gr = m7798a("team.gb.scot.bot.intro");

    /* JADX INFO: renamed from: Gs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8445Gs = m7798a("team.gb.scot.bot.go");

    /* JADX INFO: renamed from: Gt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8446Gt = m7798a("team.gb.scot.bot.grenade");

    /* JADX INFO: renamed from: Gu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8447Gu = m7798a("team.gb.scot.bot.hurt");

    /* JADX INFO: renamed from: Gv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8448Gv = m7798a("team.gb.scot.bot.reloading");

    /* JADX INFO: renamed from: Gw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8449Gw = m7798a("team.gb.scot.bot.spotted");

    /* JADX INFO: renamed from: Gx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8450Gx = m7798a("team.gb.scot.bot.taunt");

    /* JADX INFO: renamed from: Gy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8451Gy = m7798a("team.rus.bot.intro");

    /* JADX INFO: renamed from: Gz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8452Gz = m7798a("team.rus.bot.go");

    /* JADX INFO: renamed from: GA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8453GA = m7798a("team.rus.bot.grenade");

    /* JADX INFO: renamed from: GB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8454GB = m7798a("team.rus.bot.hurt");

    /* JADX INFO: renamed from: GC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8455GC = m7798a("team.rus.bot.reloading");

    /* JADX INFO: renamed from: GD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8456GD = m7798a("team.rus.bot.spotted");

    /* JADX INFO: renamed from: GE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8457GE = m7798a("team.rus.bot.taunt");

    /* JADX INFO: renamed from: GF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8458GF = m7798a("team.shared.scream");

    /* JADX INFO: renamed from: GG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8459GG = m7798a("team.shared.scream.explosion");

    /* JADX INFO: renamed from: GH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8460GH = m7798a("team.shared.scream.wilhelm");

    /* JADX INFO: renamed from: GI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8461GI = m7798a("team.shared.warcry");

    /* JADX INFO: renamed from: GJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8462GJ = m7798a("team.shared.warcry.distant");

    /* JADX INFO: renamed from: GK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8463GK = m7798a("team.shared.warcry.crowd");

    /* JADX INFO: renamed from: GL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8464GL = m7798a("team.shared.whistle");

    /* JADX INFO: renamed from: GM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8465GM = m7798a("team.shared.ignite");

    /* JADX INFO: renamed from: GN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8466GN = m7798a("team.shared.cough");

    /* JADX INFO: renamed from: GO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8467GO = m7798a("team.shared.gasp");

    /* JADX INFO: renamed from: GP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8468GP = m7798a("team.shared.hurt");

    /* JADX INFO: renamed from: GQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8469GQ = m7798a("team.shared.panic");

    /* JADX INFO: renamed from: GR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8470GR = m7798a("team.it.bot.intro");

    /* JADX INFO: renamed from: GS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8471GS = m7798a("team.it.bot.go");

    /* JADX INFO: renamed from: GT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8472GT = m7798a("team.it.bot.grenade");

    /* JADX INFO: renamed from: GU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8473GU = m7798a("team.it.bot.hurt");

    /* JADX INFO: renamed from: GV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8474GV = m7798a("team.it.bot.reloading");

    /* JADX INFO: renamed from: GW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8475GW = m7798a("team.it.bot.spotted");

    /* JADX INFO: renamed from: GX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8476GX = m7798a("team.it.bot.taunt");

    /* JADX INFO: renamed from: GY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8477GY = m7798a("team.pol.bot.intro");

    /* JADX INFO: renamed from: GZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8478GZ = m7798a("team.pol.bot.go");

    /* JADX INFO: renamed from: Ha */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8479Ha = m7798a("team.pol.bot.grenade");

    /* JADX INFO: renamed from: Hb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8480Hb = m7798a("team.pol.bot.hurt");

    /* JADX INFO: renamed from: Hc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8481Hc = m7798a("team.pol.bot.reloading");

    /* JADX INFO: renamed from: Hd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8482Hd = m7798a("team.pol.bot.spotted");

    /* JADX INFO: renamed from: He */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8483He = m7798a("team.pol.bot.taunt");

    /* JADX INFO: renamed from: Hf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8484Hf = m7798a("match.memes.cheese");

    /* JADX INFO: renamed from: Hg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8485Hg = m7798a("match.memes.stefan");

    /* JADX INFO: renamed from: Hh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8486Hh = m7798a("match.memes.danke");

    /* JADX INFO: renamed from: Hi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8487Hi = m7798a("match.memes.sucka");

    /* JADX INFO: renamed from: Hj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8488Hj = m7798a("match.memes.everything");

    /* JADX INFO: renamed from: Hk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8489Hk = m7798a("match.memes.who");

    /* JADX INFO: renamed from: Hl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8490Hl = m7798a("match.memes.howdareyou");

    /* JADX INFO: renamed from: Hm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8491Hm = m7798a("match.memes.whoru");

    /* JADX INFO: renamed from: Hn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8492Hn = m7798a("match.memes.hush");

    /* JADX INFO: renamed from: Ho */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8493Ho = m7798a("match.memes.notalent");

    /* JADX INFO: renamed from: Hp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8494Hp = m7798a("match.memes.norespect");

    /* JADX INFO: renamed from: Hq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8495Hq = m7798a("match.memes.skillissue");

    /* JADX INFO: renamed from: Hr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8496Hr = m7798a("match.memes.monke");

    /* JADX INFO: renamed from: Hs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8497Hs = m7798a("match.memes.puff");

    /* JADX INFO: renamed from: Ht */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8498Ht = m7798a("match.memes.badum");

    /* JADX INFO: renamed from: Hu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8499Hu = m7798a("match.memes.befehl");

    /* JADX INFO: renamed from: Hv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8500Hv = m7798a("match.memes.blade");

    /* JADX INFO: renamed from: Hw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8501Hw = m7798a("match.memes.bruh");

    /* JADX INFO: renamed from: Hx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8502Hx = m7798a("match.memes.chicken");

    /* JADX INFO: renamed from: Hy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8503Hy = m7798a("match.memes.chocolatecake");

    /* JADX INFO: renamed from: Hz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8504Hz = m7798a("match.memes.ciao");

    /* JADX INFO: renamed from: HA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8505HA = m7798a("match.memes.crickets");

    /* JADX INFO: renamed from: HB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8506HB = m7798a("match.memes.cupboard");

    /* JADX INFO: renamed from: HC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8507HC = m7798a("match.memes.damn");

    /* JADX INFO: renamed from: HD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8508HD = m7798a("match.memes.debile");

    /* JADX INFO: renamed from: HE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8509HE = m7798a("match.memes.depp");

    /* JADX INFO: renamed from: HF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8510HF = m7798a("match.memes.eli");

    /* JADX INFO: renamed from: HG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8511HG = m7798a("match.memes.fart");

    /* JADX INFO: renamed from: HH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8512HH = m7798a("match.memes.fast");

    /* JADX INFO: renamed from: HI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8513HI = m7798a("match.memes.forknife");

    /* JADX INFO: renamed from: HJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8514HJ = m7798a("match.memes.funny");

    /* JADX INFO: renamed from: HK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8515HK = m7798a("match.memes.gnome");

    /* JADX INFO: renamed from: HL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8516HL = m7798a("match.memes.haha");

    /* JADX INFO: renamed from: HM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8517HM = m7798a("match.memes.hamster");

    /* JADX INFO: renamed from: HN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8518HN = m7798a("match.memes.hb");

    /* JADX INFO: renamed from: HO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8519HO = m7798a("match.memes.headshot");

    /* JADX INFO: renamed from: HP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8520HP = m7798a("match.memes.hia");

    /* JADX INFO: renamed from: HQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8521HQ = m7798a("match.memes.hoho");

    /* JADX INFO: renamed from: HR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8522HR = m7798a("match.memes.honk");

    /* JADX INFO: renamed from: HS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8523HS = m7798a("match.memes.inception");

    /* JADX INFO: renamed from: HT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8524HT = m7798a("match.memes.jeopardy");

    /* JADX INFO: renamed from: HU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8525HU = m7798a("match.memes.kill");

    /* JADX INFO: renamed from: HV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8526HV = m7798a("match.memes.lala");

    /* JADX INFO: renamed from: HW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8527HW = m7798a("match.memes.leeroy");

    /* JADX INFO: renamed from: HX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8528HX = m7798a("match.memes.lol");

    /* JADX INFO: renamed from: HY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8529HY = m7798a("match.memes.lvlup");

    /* JADX INFO: renamed from: HZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8530HZ = m7798a("match.memes.meeting");

    /* JADX INFO: renamed from: Ia */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8531Ia = m7798a("match.memes.mew");

    /* JADX INFO: renamed from: Ib */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8532Ib = m7798a("match.memes.nein");

    /* JADX INFO: renamed from: Ic */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8533Ic = m7798a("match.memes.noice");

    /* JADX INFO: renamed from: Id */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8534Id = m7798a("match.memes.ppp");

    /* JADX INFO: renamed from: Ie */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8535Ie = m7798a("match.memes.quack");

    /* JADX INFO: renamed from: If */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8536If = m7798a("match.memes.raw");

    /* JADX INFO: renamed from: Ig */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8537Ig = m7798a("match.memes.sheee");

    /* JADX INFO: renamed from: Ih */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8538Ih = m7798a("match.memes.smooch");

    /* JADX INFO: renamed from: Ii */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8539Ii = m7798a("match.memes.splodged");

    /* JADX INFO: renamed from: Ij */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8540Ij = m7798a("match.memes.spongebub");

    /* JADX INFO: renamed from: Ik */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8541Ik = m7798a("match.memes.squeak");

    /* JADX INFO: renamed from: Il */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8542Il = m7798a("match.memes.sus");

    /* JADX INFO: renamed from: Im */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8543Im = m7798a("match.memes.suspense");

    /* JADX INFO: renamed from: In */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8544In = m7798a("match.memes.weed");

    /* JADX INFO: renamed from: Io */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8545Io = m7798a("match.memes.woaw");

    /* JADX INFO: renamed from: Ip */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8546Ip = m7798a("match.memes.wow");

    /* JADX INFO: renamed from: Iq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8547Iq = m7798a("match.memes.wrong");

    /* JADX INFO: renamed from: Ir */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8548Ir = m7798a("match.memes.yay");

    /* JADX INFO: renamed from: Is */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8549Is = m7798a("match.memes.yeehaw");

    /* JADX INFO: renamed from: It */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8550It = m7798a("match.memes.zonk");

    /* JADX INFO: renamed from: Iu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8551Iu = m7798a("match.memes.ayo");

    /* JADX INFO: renamed from: Iv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8552Iv = m7798a("match.memes.spoon");

    /* JADX INFO: renamed from: Iw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8553Iw = m7798a("match.memes.slap");

    /* JADX INFO: renamed from: Ix */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8554Ix = m7798a("match.memes.no");

    /* JADX INFO: renamed from: Iy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8555Iy = m7798a("match.memes.pizza");

    /* JADX INFO: renamed from: Iz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8556Iz = m7798a("match.memes.crackbone");

    /* JADX INFO: renamed from: IA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8557IA = m7798a("match.memes.himom");

    /* JADX INFO: renamed from: IB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8558IB = m7798a("match.memes.angry");

    /* JADX INFO: renamed from: IC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8559IC = m7798a("match.memes.cs4kids");

    /* JADX INFO: renamed from: ID */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8560ID = m7798a("match.memes.lopez");

    /* JADX INFO: renamed from: IE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8561IE = m7798a("match.memes.gman");

    /* JADX INFO: renamed from: IF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8562IF = m7798a("match.memes.missed");

    /* JADX INFO: renamed from: IG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8563IG = m7798a("match.memes.fuc");

    /* JADX INFO: renamed from: IH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8564IH = m7798a("match.memes.delicious");

    /* JADX INFO: renamed from: II */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8565II = m7798a("match.memes.fatass");

    /* JADX INFO: renamed from: IJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8566IJ = m7798a("match.memes.guy");

    /* JADX INFO: renamed from: IK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8567IK = m7798a("match.memes.obamna");

    /* JADX INFO: renamed from: IL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8568IL = m7798a("match.memes.wassup");

    /* JADX INFO: renamed from: IM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8569IM = m7798a("match.memes.quandale");

    /* JADX INFO: renamed from: IN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8570IN = m7798a("match.memes.canny");

    /* JADX INFO: renamed from: IO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8571IO = m7798a("match.memes.drink");

    /* JADX INFO: renamed from: IP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8572IP = m7798a("match.memes.legitness");

    /* JADX INFO: renamed from: IQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8573IQ = m7798a("match.memes.milk");

    /* JADX INFO: renamed from: IR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8574IR = m7798a("match.memes.mojo");

    /* JADX INFO: renamed from: IS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8575IS = m7798a("match.memes.overthere");

    /* JADX INFO: renamed from: IT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8576IT = m7798a("match.memes.scared");

    /* JADX INFO: renamed from: IU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8577IU = m7798a("match.memes.scott");

    /* JADX INFO: renamed from: IV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8578IV = m7798a("match.memes.sheet");

    /* JADX INFO: renamed from: IW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8579IW = m7798a("match.memes.ball");

    /* JADX INFO: renamed from: IX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8580IX = m7798a("match.memes.comeagain");

    /* JADX INFO: renamed from: IY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8581IY = m7798a("match.memes.onball");

    /* JADX INFO: renamed from: IZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8582IZ = m7798a("match.memes.shamwow");

    /* JADX INFO: renamed from: Ja */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8583Ja = m7798a("match.memes.snooping");

    /* JADX INFO: renamed from: Jb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8584Jb = m7798a("match.memes.whatiswrong");

    /* JADX INFO: renamed from: Jc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8585Jc = m7798a("match.memes.wololo");

    /* JADX INFO: renamed from: Jd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8586Jd = m7798a("match.memes.woohoo");

    /* JADX INFO: renamed from: Je */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8587Je = m7798a("match.memes.merkel");

    /* JADX INFO: renamed from: Jf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8588Jf = m7798a("match.memes.balegdah");

    /* JADX INFO: renamed from: Jg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8589Jg = m7798a("match.memes.whoasked");

    /* JADX INFO: renamed from: Jh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8590Jh = m7798a("match.memes.survival");

    /* JADX INFO: renamed from: Ji */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8591Ji = m7798a("match.memes.toothpaste");

    /* JADX INFO: renamed from: Jj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8592Jj = m7798a("match.memes.huh");

    /* JADX INFO: renamed from: Jk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8593Jk = m7798a("match.memes.howto");

    /* JADX INFO: renamed from: Jl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8594Jl = m7798a("match.memes.eyebrows");

    /* JADX INFO: renamed from: Jm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8595Jm = m7798a("match.memes.squeaky");

    /* JADX INFO: renamed from: Jn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8596Jn = m7798a("match.memes.wyd");

    /* JADX INFO: renamed from: Jo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8597Jo = m7798a("match.memes.what");

    /* JADX INFO: renamed from: Jp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8598Jp = m7798a("match.memes.gaben");

    /* JADX INFO: renamed from: Jq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8599Jq = m7798a("match.memes.salami");

    /* JADX INFO: renamed from: Jr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8600Jr = m7798a("match.memes.dayum");

    /* JADX INFO: renamed from: Js */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8601Js = m7798a("match.memes.wam");

    /* JADX INFO: renamed from: Jt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8602Jt = m7798a("match.memes.eua");

    /* JADX INFO: renamed from: Ju */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8603Ju = m7798a("match.memes.augh");

    /* JADX INFO: renamed from: Jv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8604Jv = m7798a("match.memes.kekeke");

    /* JADX INFO: renamed from: Jw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8605Jw = m7798a("match.memes.wth");

    /* JADX INFO: renamed from: Jx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8606Jx = m7798a("match.memes.omg");

    /* JADX INFO: renamed from: Jy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8607Jy = m7798a("match.memes.seasamecake");

    /* JADX INFO: renamed from: Jz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8608Jz = m7798a("match.memes.iaint");

    /* JADX INFO: renamed from: JA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8609JA = m7798a("match.memes.dammit");

    /* JADX INFO: renamed from: JB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8610JB = m7798a("match.memes.jockey");

    /* JADX INFO: renamed from: JC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8611JC = m7798a("match.memes.nether");

    /* JADX INFO: renamed from: JD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8612JD = m7798a("match.memes.rules");

    /* JADX INFO: renamed from: JE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8613JE = m7798a("match.memes.ned");

    /* JADX INFO: renamed from: JF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8614JF = m7798a("match.memes.mirrors");

    /* JADX INFO: renamed from: JG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8615JG = m7798a("match.memes.v8motor");

    static {
        f7500ac.add(f7836uH);
        f7500ac.add(f7837uI);
        f7500ac.add(f7838uJ);
        f7500ac.add(f7839uK);
        f7500ac.add(f7840uL);
        f7500ac.add(f7841uM);
        f7498g.put("cheese", f8484Hf);
        f7498g.put("iaint", f8608Jz);
        f7498g.put("seasamecake", f8607Jy);
        f7498g.put("omg", f8606Jx);
        f7498g.put("wth", f8605Jw);
        f7498g.put("kekeke", f8604Jv);
        f7498g.put("augh", f8603Ju);
        f7498g.put("eua", f8602Jt);
        f7498g.put("stefan", f8485Hg);
        f7498g.put("danke", f8486Hh);
        f7498g.put("sucka", f8487Hi);
        f7498g.put("everything", f8488Hj);
        f7498g.put("who", f8489Hk);
        f7498g.put("howdareyou", f8490Hl);
        f7498g.put("whoru", f8491Hm);
        f7498g.put("hush", f8492Hn);
        f7498g.put("notalent", f8493Ho);
        f7498g.put("norespect", f8494Hp);
        f7498g.put("skillissue", f8495Hq);
        f7498g.put("monke", f8496Hr);
        f7498g.put("salami", f8599Jq);
        f7498g.put("dayum", f8600Jr);
        f7498g.put("wam", f8601Js);
        f7498g.put("gaben", f8598Jp);
        f7498g.put("what", f8597Jo);
        f7498g.put("survival", f8590Jh);
        f7498g.put("toothpaste", f8591Ji);
        f7498g.put("huh", f8592Jj);
        f7498g.put("howto", f8593Jk);
        f7498g.put("eyebrows", f8594Jl);
        f7498g.put("squeaky", f8595Jm);
        f7498g.put("wyd", f8596Jn);
        f7498g.put("whoasked", f8589Jg);
        f7498g.put("balegdah", f8588Jf);
        f7498g.put("ball", f8579IW);
        f7498g.put("comeagain", f8580IX);
        f7498g.put("onball", f8581IY);
        f7498g.put("shamwow", f8582IZ);
        f7498g.put("snooping", f8583Ja);
        f7498g.put("whatiswrong", f8584Jb);
        f7498g.put("wololo", f8585Jc);
        f7498g.put("woohoo", f8586Jd);
        f7498g.put("drink", f8571IO);
        f7498g.put("legitness", f8572IP);
        f7498g.put("milk", f8573IQ);
        f7498g.put("mojo", f8574IR);
        f7498g.put("overthere", f8575IS);
        f7498g.put("scared", f8576IT);
        f7498g.put("scott", f8577IU);
        f7498g.put("sheet", f8578IV);
        f7498g.put("badum", f8498Ht);
        f7498g.put("puff", f8497Hs);
        f7498g.put("befehl", f8499Hu);
        f7498g.put("blade", f8500Hv);
        f7498g.put("bruh", f8501Hw);
        f7498g.put("chicken", f8502Hx);
        f7498g.put("chocolatecake", f8503Hy);
        f7498g.put("ciao", f8504Hz);
        f7498g.put("crickets", f8505HA);
        f7498g.put("cupboard", f8506HB);
        f7498g.put("damn", f8507HC);
        f7498g.put("debile", f8508HD);
        f7498g.put("depp", f8509HE);
        f7498g.put("eli", f8510HF);
        f7498g.put("fart", f8511HG);
        f7498g.put("fast", f8512HH);
        f7498g.put("forknife", f8513HI);
        f7498g.put("funny", f8514HJ);
        f7498g.put("gnome", f8515HK);
        f7498g.put("haha", f8516HL);
        f7498g.put("hamster", f8517HM);
        f7498g.put("hb", f8518HN);
        f7498g.put("headshot", f8519HO);
        f7498g.put("hia", f8520HP);
        f7498g.put("hoho", f8521HQ);
        f7498g.put("honk", f8522HR);
        f7498g.put("inception", f8523HS);
        f7498g.put("jeopardy", f8524HT);
        f7498g.put("kill", f8525HU);
        f7498g.put("lala", f8526HV);
        f7498g.put("leeroy", f8527HW);
        f7498g.put("lol", f8528HX);
        f7498g.put("lvlup", f8529HY);
        f7498g.put("meeting", f8530HZ);
        f7498g.put("mew", f8531Ia);
        f7498g.put("nein", f8532Ib);
        f7498g.put("noice", f8533Ic);
        f7498g.put("ppp", f8534Id);
        f7498g.put("quack", f8535Ie);
        f7498g.put("raw", f8536If);
        f7498g.put("sheee", f8537Ig);
        f7498g.put("smooch", f8538Ih);
        f7498g.put("splodged", f8539Ii);
        f7498g.put("spongebob", f8540Ij);
        f7498g.put("squeak", f8541Ik);
        f7498g.put("sus", f8542Il);
        f7498g.put("suspense", f8543Im);
        f7498g.put("weed", f8544In);
        f7498g.put("woaw", f8545Io);
        f7498g.put("wow", f8546Ip);
        f7498g.put("wrong", f8547Iq);
        f7498g.put("yay", f8548Ir);
        f7498g.put("yeehaw", f8549Is);
        f7498g.put("zonk", f8550It);
        f7498g.put("ayo", f8551Iu);
        f7498g.put("spoon", f8552Iv);
        f7498g.put("slap", f8553Iw);
        f7498g.put("no", f8554Ix);
        f7498g.put("pizza", f8555Iy);
        f7498g.put("crackbone", f8556Iz);
        f7498g.put("himom", f8557IA);
        f7498g.put("angry", f8558IB);
        f7498g.put("cs4kids", f8559IC);
        f7498g.put("lopez", f8560ID);
        f7498g.put("gman", f8561IE);
        f7498g.put("missed", f8562IF);
        f7498g.put("fuc", f8563IG);
        f7498g.put("delicious", f8564IH);
        f7498g.put("fatass", f8565II);
        f7498g.put("guy", f8566IJ);
        f7498g.put("obamna", f8567IK);
        f7498g.put("wassup", f8568IL);
        f7498g.put("quandale", f8569IM);
        f7498g.put("canny", f8570IN);
        f7498g.put("merkel", f8587Je);
        f7498g.put("dammit", f8609JA);
        f7498g.put("jockey", f8610JB);
        f7498g.put("nether", f8611JC);
        f7498g.put("rules", f8612JD);
        f7498g.put("ned", f8613JE);
        f7498g.put("mirrors", f8614JF);
        f7498g.put("v8motor", f8615JG);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static DeferredHolder<SoundEvent, SoundEvent> m7798a(@NotNull String str) {
        ResourceLocation resourceLocationM2555d = C0564jv.m2555d(str);
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderRegister = f7497i.register(resourceLocationM2555d.getPath(), () -> {
            return SoundEvent.createVariableRangeEvent(resourceLocationM2555d);
        });
        f7499h.put(resourceLocationM2555d.toString(), deferredHolderRegister);
        return deferredHolderRegister;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static SoundEvent m7799a(@NotNull String str) {
        ObjectIterator it = f7499h.values().iterator();
        while (it.hasNext()) {
            DeferredHolder deferredHolder = (DeferredHolder) it.next();
            ResourceLocation key = BuiltInRegistries.SOUND_EVENT.getKey((SoundEvent) deferredHolder.get());
            if (key != null) {
                String string = key.toString();
                if (string.equals(str) || string.equals("bf:" + str)) {
                    return (SoundEvent) Optional.of(deferredHolder).map((v0) -> {
                        return v0.get();
                    }).orElse(null);
                }
            }
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public static String m7800e(@NotNull SoundEvent soundEvent) {
        ObjectIterator it = f7499h.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (((DeferredHolder) entry.getValue()).get() == soundEvent) {
                return (String) Optional.of(entry).map((v0) -> {
                    return v0.getKey();
                }).orElse(null);
            }
        }
        return null;
    }
}
