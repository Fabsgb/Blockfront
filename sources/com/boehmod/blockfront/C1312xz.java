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

/* JADX INFO: renamed from: com.boehmod.blockfront.xz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xz.class */
public final class C1312xz {

    /* JADX INFO: renamed from: i */
    @NotNull
    public static final DeferredRegister<SoundEvent> f7909i = DeferredRegister.create(Registries.SOUND_EVENT, "bf");

    /* JADX INFO: renamed from: g */
    @NotNull
    public static final Object2ObjectMap<String, DeferredHolder<SoundEvent, SoundEvent>> f7910g = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final Object2ObjectMap<String, DeferredHolder<SoundEvent, SoundEvent>> f7911h = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: al */
    @NotNull
    public static final ObjectList<DeferredHolder<SoundEvent, SoundEvent>> f7912al = new ObjectArrayList();

    /* JADX INFO: renamed from: om */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7913om = m8230a("music.menu");

    /* JADX INFO: renamed from: on */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7914on = m8230a("music.menu.searching");

    /* JADX INFO: renamed from: oo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7915oo = m8230a("music.bootcamp");

    /* JADX INFO: renamed from: op */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7916op = m8230a("music.sets.europe.conclude");

    /* JADX INFO: renamed from: oq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7917oq = m8230a("music.sets.europe.conclude.generic");

    /* JADX INFO: renamed from: or */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7918or = m8230a("music.sets.europe.suspense.one");

    /* JADX INFO: renamed from: os */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7919os = m8230a("music.sets.europe.suspense.two");

    /* JADX INFO: renamed from: ot */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7920ot = m8230a("music.sets.europe.suspense.three");

    /* JADX INFO: renamed from: ou */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7921ou = m8230a("music.sets.europe.start");

    /* JADX INFO: renamed from: ov */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7922ov = m8230a("music.sets.europe.start.generic");

    /* JADX INFO: renamed from: ow */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7923ow = m8230a("music.sets.europe.warmup");

    /* JADX INFO: renamed from: ox */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7924ox = m8230a("music.sets.europe.offensive.point.taken");

    /* JADX INFO: renamed from: oy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7925oy = m8230a("music.sets.europe.offensive.reinforcements.hint");

    /* JADX INFO: renamed from: oz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7926oz = m8230a("music.sets.europe.offensive.reinforcements.arrive");

    /* JADX INFO: renamed from: oA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7927oA = m8230a("misc.hitmarker");

    /* JADX INFO: renamed from: oB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7928oB = m8230a("misc.morsecode");

    /* JADX INFO: renamed from: oC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7929oC = m8230a("misc.radio.transmission");

    /* JADX INFO: renamed from: oD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7930oD = m8230a("misc.heartbeat");

    /* JADX INFO: renamed from: oE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7931oE = m8230a("misc.rank.up");

    /* JADX INFO: renamed from: oF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7932oF = m8230a("misc.gore");

    /* JADX INFO: renamed from: oG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7933oG = m8230a("misc.gore.nose");

    /* JADX INFO: renamed from: oH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7934oH = m8230a("misc.vc.start");

    /* JADX INFO: renamed from: oI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7935oI = m8230a("misc.vc.stop");

    /* JADX INFO: renamed from: oJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7936oJ = m8230a("misc.patreon.link");

    /* JADX INFO: renamed from: oK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7937oK = m8230a("particle.surrenderpaper.fall");

    /* JADX INFO: renamed from: oL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7938oL = m8230a("gui.update.complete");

    /* JADX INFO: renamed from: oM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7939oM = m8230a("gui.update.loop");

    /* JADX INFO: renamed from: oN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7940oN = m8230a("gui.update.start");

    /* JADX INFO: renamed from: oO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7941oO = m8230a("gui.prestige.prompt");

    /* JADX INFO: renamed from: oP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7942oP = m8230a("gui.game.summary.intro.map.vote");

    /* JADX INFO: renamed from: oQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7943oQ = m8230a("gui.game.summary.intro.map.vote.conclude");

    /* JADX INFO: renamed from: oR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7944oR = m8230a("gui.game.summary.intro.progress");

    /* JADX INFO: renamed from: oS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7945oS = m8230a("gui.game.summary.intro.top.players");

    /* JADX INFO: renamed from: oT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7946oT = m8230a("gui.game.summary.top.players.entry");

    /* JADX INFO: renamed from: oU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7947oU = m8230a("gui.game.summary.top.players.entry.final");

    /* JADX INFO: renamed from: oV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7948oV = m8230a("gui.game.summary.promoted");

    /* JADX INFO: renamed from: oW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7949oW = m8230a("gui.game.vote.error");

    /* JADX INFO: renamed from: oX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7950oX = m8230a("gui.game.vote.vote");

    /* JADX INFO: renamed from: oY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7951oY = m8230a("gui.game.vote.vote.self");

    /* JADX INFO: renamed from: oZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7952oZ = m8230a("gui.game.vote.rate");

    /* JADX INFO: renamed from: pa */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7953pa = m8230a("gui.armory.default.shared");

    /* JADX INFO: renamed from: pb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7954pb = m8230a("gui.armory.default.gun");

    /* JADX INFO: renamed from: pc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7955pc = m8230a("gui.armory.default.melee");

    /* JADX INFO: renamed from: pd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7956pd = m8230a("gui.armory.default.card");

    /* JADX INFO: renamed from: pe */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7957pe = m8230a("gui.bootcamp.complete");

    /* JADX INFO: renamed from: pf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7958pf = m8230a("gui.dailyreward.open");

    /* JADX INFO: renamed from: pg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7959pg = m8230a("gui.dailychallenge.complete");

    /* JADX INFO: renamed from: ph */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7960ph = m8230a("gui.dailychallenge.complete.all");

    /* JADX INFO: renamed from: pi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7961pi = m8230a("gui.dailychallenge.reminder");

    /* JADX INFO: renamed from: pj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7962pj = m8230a("gui.lobby.search");

    /* JADX INFO: renamed from: pk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7963pk = m8230a("gui.lobby.cancel");

    /* JADX INFO: renamed from: pl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7964pl = m8230a("gui.lobby.join");

    /* JADX INFO: renamed from: pm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7965pm = m8230a("gui.sidemenu.open");

    /* JADX INFO: renamed from: pn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7966pn = m8230a("gui.sidemenu.close");

    /* JADX INFO: renamed from: po */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7967po = m8230a("gui.openurl");

    /* JADX INFO: renamed from: pp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7968pp = m8230a("gui.newmessage");

    /* JADX INFO: renamed from: pq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7969pq = m8230a("gui.typewriter");

    /* JADX INFO: renamed from: pr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7970pr = m8230a("gui.button.press");

    /* JADX INFO: renamed from: ps */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7971ps = m8230a("gui.button.hover");

    /* JADX INFO: renamed from: pt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7972pt = m8230a("gui.button.back");

    /* JADX INFO: renamed from: pu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7973pu = m8230a("gui.button.forward");

    /* JADX INFO: renamed from: pv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7974pv = m8230a("gui.events.hover");

    /* JADX INFO: renamed from: pw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7975pw = m8230a("gui.inventory.crate.open");

    /* JADX INFO: renamed from: px */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7976px = m8230a("gui.inventory.item.inspect");

    /* JADX INFO: renamed from: py */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7977py = m8230a("gui.inventory.item.trophy");

    /* JADX INFO: renamed from: pz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7978pz = m8230a("gui.intro.content");

    /* JADX INFO: renamed from: pA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7979pA = m8230a("gui.intro.rules");

    /* JADX INFO: renamed from: pB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7980pB = m8230a("gui.intro.refer");

    /* JADX INFO: renamed from: pC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7981pC = m8230a("gui.intro.discord");

    /* JADX INFO: renamed from: pD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7982pD = m8230a("gui.intro.patreon");

    /* JADX INFO: renamed from: pE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7983pE = m8230a("match.commander.radio");

    /* JADX INFO: renamed from: pF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7984pF = m8230a("match.commander.radio.error.time");

    /* JADX INFO: renamed from: pG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7985pG = m8230a("match.commander.radio.all");

    /* JADX INFO: renamed from: pH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7986pH = m8230a("match.commander.radio.local");

    /* JADX INFO: renamed from: pI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7987pI = m8230a("match.ping.regular");

    /* JADX INFO: renamed from: pJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7988pJ = m8230a("match.ping.regular.warning");

    /* JADX INFO: renamed from: pK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7989pK = m8230a("match.tip");

    /* JADX INFO: renamed from: pL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7990pL = m8230a("match.respawn");

    /* JADX INFO: renamed from: pM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7991pM = m8230a("match.boundary.enter");

    /* JADX INFO: renamed from: pN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7992pN = m8230a("match.boundary.leave");

    /* JADX INFO: renamed from: pO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7993pO = m8230a("match.tock");

    /* JADX INFO: renamed from: pP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7994pP = m8230a("match.tick");

    /* JADX INFO: renamed from: pQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7995pQ = m8230a("match.capturepoint.siren");

    /* JADX INFO: renamed from: pR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7996pR = m8230a("match.capturepoint.tick");

    /* JADX INFO: renamed from: pS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7997pS = m8230a("match.capturepoint.captured");

    /* JADX INFO: renamed from: pT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7998pT = m8230a("match.popup.kills");

    /* JADX INFO: renamed from: pU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f7999pU = m8230a("match.ammopoint.refill");

    /* JADX INFO: renamed from: pV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8000pV = m8230a("match.classes.change");

    /* JADX INFO: renamed from: pW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8001pW = m8230a("match.dominating");

    /* JADX INFO: renamed from: pX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8002pX = m8230a("match.revenge");

    /* JADX INFO: renamed from: pY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8003pY = m8230a("match.gamemode.ttt.win.innocent");

    /* JADX INFO: renamed from: pZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8004pZ = m8230a("match.gamemode.ttt.win.traitor");

    /* JADX INFO: renamed from: qa */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8005qa = m8230a("match.gamemode.ttt.role.detective");

    /* JADX INFO: renamed from: qb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8006qb = m8230a("match.gamemode.ttt.role.innocent");

    /* JADX INFO: renamed from: qc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8007qc = m8230a("match.gamemode.ttt.role.traitor");

    /* JADX INFO: renamed from: qd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8008qd = m8230a("match.gamemode.ttt.role.reveal");

    /* JADX INFO: renamed from: qe */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8009qe = m8230a("match.gamemode.ttt.randomat.fart");

    /* JADX INFO: renamed from: qf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8010qf = m8230a("match.gamemode.ttt.death.traitor");

    /* JADX INFO: renamed from: qg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8011qg = m8230a("match.gamemode.sg.cannon");

    /* JADX INFO: renamed from: qh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8012qh = m8230a("match.gamemode.sg.cannon.stereo");

    /* JADX INFO: renamed from: qi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8013qi = m8230a("match.gamemode.sg.music.start");

    /* JADX INFO: renamed from: qj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8014qj = m8230a("match.gamemode.sg.music.end");

    /* JADX INFO: renamed from: qk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8015qk = m8230a("match.gamemode.inf.newround");

    /* JADX INFO: renamed from: ql */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8016ql = m8230a("match.gamemode.inf.endround");

    /* JADX INFO: renamed from: qm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8017qm = m8230a("match.gamemode.inf.gameover");

    /* JADX INFO: renamed from: qn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8018qn = m8230a("match.gamemode.inf.doground");

    /* JADX INFO: renamed from: qo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8019qo = m8230a("match.gamemode.inf.doground.end");

    /* JADX INFO: renamed from: qp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8020qp = m8230a("match.gamemode.inf.hoard");

    /* JADX INFO: renamed from: qq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8021qq = m8230a("match.gamemode.tdm.streak.end");

    /* JADX INFO: renamed from: qr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8022qr = m8230a("match.gamemode.tdm.announcer.firstblood");

    /* JADX INFO: renamed from: qs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8023qs = m8230a("match.gamemode.tdm.streak.5");

    /* JADX INFO: renamed from: qt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8024qt = m8230a("match.gamemode.tdm.streak.10");

    /* JADX INFO: renamed from: qu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8025qu = m8230a("match.gamemode.tdm.streak.15");

    /* JADX INFO: renamed from: qv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8026qv = m8230a("match.gamemode.tdm.streak.20");

    /* JADX INFO: renamed from: qw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8027qw = m8230a("match.gamemode.tdm.streak.25");

    /* JADX INFO: renamed from: qx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8028qx = m8230a("match.gamemode.tdm.streak.30");

    /* JADX INFO: renamed from: qy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8029qy = m8230a("match.gamemode.tdm.streak.max");

    /* JADX INFO: renamed from: qz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8030qz = m8230a("match.gamemode.dom.point.captured");

    /* JADX INFO: renamed from: qA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8031qA = m8230a("match.gamemode.dom.point.lost");

    /* JADX INFO: renamed from: qB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8032qB = m8230a("match.gamemode.boot.horn");

    /* JADX INFO: renamed from: qC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8033qC = m8230a("match.gamemode.boot.jazz");

    /* JADX INFO: renamed from: qD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8034qD = m8230a("match.gamemode.boot.usa");

    /* JADX INFO: renamed from: qE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8035qE = m8230a("match.gamemode.boot.usradio");

    /* JADX INFO: renamed from: qF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8036qF = m8230a("match.gamemode.boot.instructor.congratulations");

    /* JADX INFO: renamed from: qG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8037qG = m8230a("match.gamemode.boot.instructor.fulldayahead");

    /* JADX INFO: renamed from: qH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8038qH = m8230a("match.gamemode.boot.instructor.gogogo");

    /* JADX INFO: renamed from: qI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8039qI = m8230a("match.gamemode.boot.instructor.grenade");

    /* JADX INFO: renamed from: qJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8040qJ = m8230a("match.gamemode.boot.instructor.notend");

    /* JADX INFO: renamed from: qK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8041qK = m8230a("match.gamemode.boot.instructor.obstacle");

    /* JADX INFO: renamed from: qL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8042qL = m8230a("match.gamemode.boot.instructor.pickupweapon");

    /* JADX INFO: renamed from: qM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8043qM = m8230a("match.gamemode.boot.instructor.swim");

    /* JADX INFO: renamed from: qN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8044qN = m8230a("match.gamemode.boot.instructor.target.bad");

    /* JADX INFO: renamed from: qO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8045qO = m8230a("match.gamemode.boot.instructor.target.good");

    /* JADX INFO: renamed from: qP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8046qP = m8230a("match.gamemode.boot.instructor.target.ok");

    /* JADX INFO: renamed from: qQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8047qQ = m8230a("match.gamemode.boot.instructor.target.best");

    /* JADX INFO: renamed from: qR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8048qR = m8230a("match.gamemode.boot.instructor.friendlyfire");

    /* JADX INFO: renamed from: qS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8049qS = m8230a("match.mapeffect.plane.flyby");

    /* JADX INFO: renamed from: qT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8050qT = m8230a("match.mapeffect.plane.flyby.low");

    /* JADX INFO: renamed from: qU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8051qU = m8230a("match.mapeffect.tbtsk.fire");

    /* JADX INFO: renamed from: qV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8052qV = m8230a("match.mapeffect.tbtsk.fire.stereo");

    /* JADX INFO: renamed from: qW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8053qW = m8230a("match.mapeffect.tbtsk.fire.commander");

    /* JADX INFO: renamed from: qX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8054qX = m8230a("match.event.flak");

    /* JADX INFO: renamed from: qY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8055qY = m8230a("match.event.flak.distant");

    /* JADX INFO: renamed from: qZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8056qZ = m8230a("match.event.flak.distant.stereo");

    /* JADX INFO: renamed from: ra */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8057ra = m8230a("match.event.flak.plane");

    /* JADX INFO: renamed from: rb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8058rb = m8230a("match.event.flak.plane.stereo");

    /* JADX INFO: renamed from: rc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8059rc = m8230a("match.event.flak.plane.hit");

    /* JADX INFO: renamed from: rd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8060rd = m8230a("match.event.avalanche.rumble");

    /* JADX INFO: renamed from: re */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8061re = m8230a("match.event.avalanche.rocks");

    /* JADX INFO: renamed from: rf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8062rf = m8230a("match.event.airstrike.fire");

    /* JADX INFO: renamed from: rg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8063rg = m8230a("entity.vehicle.explode");

    /* JADX INFO: renamed from: rh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8064rh = m8230a("entity.vehicle.zoom.in");

    /* JADX INFO: renamed from: ri */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8065ri = m8230a("entity.vehicle.zoom.out");

    /* JADX INFO: renamed from: rj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8066rj = m8230a("entity.vehicle.alarm");

    /* JADX INFO: renamed from: rk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8067rk = m8230a("entity.vehicle.alarm.internal");

    /* JADX INFO: renamed from: rl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8068rl = m8230a("entity.vehicle.hatch");

    /* JADX INFO: renamed from: rm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8069rm = m8230a("entity.vehicle.door");

    /* JADX INFO: renamed from: rn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8070rn = m8230a("entity.vehicle.destroyed.fire");

    /* JADX INFO: renamed from: ro */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8071ro = m8230a("entity.vehicle.damage");

    /* JADX INFO: renamed from: rp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8072rp = m8230a("entity.vehicle.damage.distant");

    /* JADX INFO: renamed from: rq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8073rq = m8230a("entity.vehicle.damage.internal");

    /* JADX INFO: renamed from: rr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8074rr = m8230a("entity.vehicle.turret.fire.internal");

    /* JADX INFO: renamed from: rs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8075rs = m8230a("entity.vehicle.sherman.engine.forward.distant");

    /* JADX INFO: renamed from: rt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8076rt = m8230a("entity.vehicle.sherman.engine.forward.start.distant");

    /* JADX INFO: renamed from: ru */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8077ru = m8230a("entity.vehicle.sherman.engine.forward.stop.distant");

    /* JADX INFO: renamed from: rv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8078rv = m8230a("entity.vehicle.sherman.engine.idle.distant");

    /* JADX INFO: renamed from: rw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8079rw = m8230a("entity.vehicle.sherman.engine.start.distant");

    /* JADX INFO: renamed from: rx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8080rx = m8230a("entity.vehicle.sherman.engine.stop.distant");

    /* JADX INFO: renamed from: ry */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8081ry = m8230a("entity.vehicle.sherman.engine.forward");

    /* JADX INFO: renamed from: rz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8082rz = m8230a("entity.vehicle.sherman.engine.forward.start");

    /* JADX INFO: renamed from: rA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8083rA = m8230a("entity.vehicle.sherman.engine.forward.stop");

    /* JADX INFO: renamed from: rB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8084rB = m8230a("entity.vehicle.sherman.engine.idle");

    /* JADX INFO: renamed from: rC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8085rC = m8230a("entity.vehicle.sherman.engine.start");

    /* JADX INFO: renamed from: rD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8086rD = m8230a("entity.vehicle.sherman.engine.stop");

    /* JADX INFO: renamed from: rE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8087rE = m8230a("entity.vehicle.sherman.tracks");

    /* JADX INFO: renamed from: rF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8088rF = m8230a("entity.vehicle.sherman.tracks.turn");

    /* JADX INFO: renamed from: rG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8089rG = m8230a("entity.vehicle.sherman.turret.move");

    /* JADX INFO: renamed from: rH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8090rH = m8230a("entity.vehicle.sherman.turret.move.start");

    /* JADX INFO: renamed from: rI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8091rI = m8230a("entity.vehicle.sherman.turret.move.stop");

    /* JADX INFO: renamed from: rJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8092rJ = m8230a("entity.vehicle.sherman.turret.reload");

    /* JADX INFO: renamed from: rK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8093rK = m8230a("entity.vehicle.sherman.turret.fire");

    /* JADX INFO: renamed from: rL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8094rL = m8230a("entity.vehicle.sherman.turret.fire.add");

    /* JADX INFO: renamed from: rM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8095rM = m8230a("entity.vehicle.sherman.turret.fire.distant");

    /* JADX INFO: renamed from: rN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8096rN = m8230a("entity.vehicle.sherman.turret.fire.hifi");

    /* JADX INFO: renamed from: rO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8097rO = m8230a("entity.vehicle.chiha.engine.forward");

    /* JADX INFO: renamed from: rP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8098rP = m8230a("entity.vehicle.chiha.engine.forward.start");

    /* JADX INFO: renamed from: rQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8099rQ = m8230a("entity.vehicle.chiha.engine.forward.stop");

    /* JADX INFO: renamed from: rR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8100rR = m8230a("entity.vehicle.chiha.engine.idle");

    /* JADX INFO: renamed from: rS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8101rS = m8230a("entity.vehicle.chiha.engine.start");

    /* JADX INFO: renamed from: rT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8102rT = m8230a("entity.vehicle.chiha.engine.stop");

    /* JADX INFO: renamed from: rU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8103rU = m8230a("entity.vehicle.chiha.tracks");

    /* JADX INFO: renamed from: rV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8104rV = m8230a("entity.vehicle.willys.jeep.horn");

    /* JADX INFO: renamed from: rW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8105rW = m8230a("entity.vehicle.willys.jeep.horn.distant");

    /* JADX INFO: renamed from: rX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8106rX = m8230a("entity.vehicle.lancia_1zm.engine.forward");

    /* JADX INFO: renamed from: rY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8107rY = m8230a("entity.vehicle.lancia_1zm.engine.forward.distant");

    /* JADX INFO: renamed from: rZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8108rZ = m8230a("entity.vehicle.lancia_1zm.engine.forward.start");

    /* JADX INFO: renamed from: sa */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8109sa = m8230a("entity.vehicle.lancia_1zm.engine.forward.start.distant");

    /* JADX INFO: renamed from: sb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8110sb = m8230a("entity.vehicle.lancia_1zm.engine.forward.stop");

    /* JADX INFO: renamed from: sc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8111sc = m8230a("entity.vehicle.lancia_1zm.engine.forward.stop.distant");

    /* JADX INFO: renamed from: sd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8112sd = m8230a("entity.vehicle.lancia_1zm.engine.idle");

    /* JADX INFO: renamed from: se */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8113se = m8230a("entity.vehicle.lancia_1zm.engine.idle.distant");

    /* JADX INFO: renamed from: sf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8114sf = m8230a("entity.vehicle.lancia_1zm.engine.start");

    /* JADX INFO: renamed from: sg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8115sg = m8230a("entity.vehicle.lancia_1zm.engine.start.distant");

    /* JADX INFO: renamed from: sh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8116sh = m8230a("entity.vehicle.lancia_1zm.engine.stop");

    /* JADX INFO: renamed from: si */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8117si = m8230a("entity.vehicle.lancia_1zm.engine.stop.distant");

    /* JADX INFO: renamed from: sj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8118sj = m8230a("entity.vehicle.lancia_1zm.turret.turn");

    /* JADX INFO: renamed from: sk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8119sk = m8230a("entity.vehicle.lancia_1zm.wheels");

    /* JADX INFO: renamed from: sl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8120sl = m8230a("entity.vehicle.lancia_1zm.wheels.turn");

    /* JADX INFO: renamed from: sm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8121sm = m8230a("entity.vehicle.flak88.turret.move");

    /* JADX INFO: renamed from: sn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8122sn = m8230a("entity.vehicle.flak88.turret.move.start");

    /* JADX INFO: renamed from: so */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8123so = m8230a("entity.vehicle.flak88.turret.move.stop");

    /* JADX INFO: renamed from: sp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8124sp = m8230a("entity.vehicle.flak88.turret.reload");

    /* JADX INFO: renamed from: sq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8125sq = m8230a("entity.vehicle.flak88.turret.fire");

    /* JADX INFO: renamed from: sr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8126sr = m8230a("entity.vehicle.flak88.turret.fire.hifi");

    /* JADX INFO: renamed from: ss */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8127ss = m8230a("entity.vehicle.tilt");

    /* JADX INFO: renamed from: st */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8128st = m8230a("entity.corpse.fly");

    /* JADX INFO: renamed from: su */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8129su = m8230a("entity.obunga.idle");

    /* JADX INFO: renamed from: sv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8130sv = m8230a("entity.panzerknacker.idle");

    /* JADX INFO: renamed from: sw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8131sw = m8230a("entity.player.foley.arm");

    /* JADX INFO: renamed from: sx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8132sx = m8230a("entity.player.foley.land");

    /* JADX INFO: renamed from: sy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8133sy = m8230a("entity.player.foley.rain_coat");

    /* JADX INFO: renamed from: sz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8134sz = m8230a("entity.rocket.loop");

    /* JADX INFO: renamed from: sA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8135sA = m8230a("entity.rocket.bounce");

    /* JADX INFO: renamed from: sB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8136sB = m8230a("entity.rocket.ricochet");

    /* JADX INFO: renamed from: sC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8137sC = m8230a("entity.rocket.fall");

    /* JADX INFO: renamed from: sD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8138sD = m8230a("entity.rocket.flyby");

    /* JADX INFO: renamed from: sE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8139sE = m8230a("entity.rocket.tank.flyby");

    /* JADX INFO: renamed from: sF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8140sF = m8230a("entity.rocket.tank.fire");

    /* JADX INFO: renamed from: sG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8141sG = m8230a("entity.infected.hurt");

    /* JADX INFO: renamed from: sH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8142sH = m8230a("entity.infected.death");

    /* JADX INFO: renamed from: sI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8143sI = m8230a("entity.infected.dog.bark");

    /* JADX INFO: renamed from: sJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8144sJ = m8230a("entity.infected.dog.howl");

    /* JADX INFO: renamed from: sK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8145sK = m8230a("entity.infected.spitter.spit");

    /* JADX INFO: renamed from: sL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8146sL = m8230a("entity.acidball.splat");

    /* JADX INFO: renamed from: sM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8147sM = m8230a("entity.gundealer.sale");

    /* JADX INFO: renamed from: sN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8148sN = m8230a("entity.gundealer.relocate");

    /* JADX INFO: renamed from: sO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8149sO = m8230a("entity.gundealer.resupply");

    /* JADX INFO: renamed from: sP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8150sP = m8230a("entity.gundealer.open");

    /* JADX INFO: renamed from: sQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8151sQ = m8230a("entity.flame.ignite");

    /* JADX INFO: renamed from: sR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8152sR = m8230a("block.field.crate.use");

    /* JADX INFO: renamed from: sS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8153sS = m8230a("block.barrel.spill");

    /* JADX INFO: renamed from: sT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8154sT = m8230a("block.radio.static");

    /* JADX INFO: renamed from: sU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8155sU = m8230a("block.radio.morse");

    /* JADX INFO: renamed from: sV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8156sV = m8230a("block.jeep.engine");

    /* JADX INFO: renamed from: sW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8157sW = m8230a("block.tank.engine");

    /* JADX INFO: renamed from: sX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8158sX = m8230a("block.piano.hit");

    /* JADX INFO: renamed from: sY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8159sY = m8230a("block.hedgehog.hit");

    /* JADX INFO: renamed from: sZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8160sZ = m8230a("block.powerline.zap");

    /* JADX INFO: renamed from: ta */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8161ta = m8230a("block.powerline.explode");

    /* JADX INFO: renamed from: tb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8162tb = m8230a("block.powerline.electric");

    /* JADX INFO: renamed from: tc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8163tc = m8230a("block.radio.chatter.german");

    /* JADX INFO: renamed from: td */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8164td = m8230a("block.radio.chatter.american");

    /* JADX INFO: renamed from: te */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8165te = m8230a("block.plank.step");

    /* JADX INFO: renamed from: tf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8166tf = m8230a("block.rubble.step");

    /* JADX INFO: renamed from: tg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8167tg = m8230a("block.target.hit");

    /* JADX INFO: renamed from: th */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8168th = m8230a("block.target.hit.distant");

    /* JADX INFO: renamed from: ti */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8169ti = m8230a("block.door.bunker.open");

    /* JADX INFO: renamed from: tj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8170tj = m8230a("block.door.bunker.close");

    /* JADX INFO: renamed from: tk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8171tk = m8230a("block.button.press");

    /* JADX INFO: renamed from: tl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8172tl = m8230a("block.button.release");

    /* JADX INFO: renamed from: tm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8173tm = m8230a("block.bell.bell");

    /* JADX INFO: renamed from: tn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8174tn = m8230a("block.bell.bell.far");

    /* JADX INFO: renamed from: to */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8175to = m8230a("block.shisa.whisper");

    /* JADX INFO: renamed from: tp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8176tp = m8230a("block.swinging.log.creak");

    /* JADX INFO: renamed from: tq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8177tq = m8230a("block.wind_chime.chime");

    /* JADX INFO: renamed from: tr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8178tr = m8230a("block.telephone.impact");

    /* JADX INFO: renamed from: ts */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8179ts = m8230a("block.typewriter.impact");

    /* JADX INFO: renamed from: tt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8180tt = m8230a("block.typewriter.type");

    /* JADX INFO: renamed from: tu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8181tu = m8230a("block.typewriter.ping");

    /* JADX INFO: renamed from: tv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8182tv = m8230a("block.alarm.on");

    /* JADX INFO: renamed from: tw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8183tw = m8230a("item.syringe.equip");

    /* JADX INFO: renamed from: tx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8184tx = m8230a("item.syringe.use");

    /* JADX INFO: renamed from: ty */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8185ty = m8230a("item.binoculars.equip");

    /* JADX INFO: renamed from: tz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8186tz = m8230a("item.binoculars.use");

    /* JADX INFO: renamed from: tA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8187tA = m8230a("item.binoculars.stop_using");

    /* JADX INFO: renamed from: tB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8188tB = m8230a("item.flamethrower.move");

    /* JADX INFO: renamed from: tC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8189tC = m8230a("item.radio.equip");

    /* JADX INFO: renamed from: tD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8190tD = m8230a("item.radio.equipped");

    /* JADX INFO: renamed from: tE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8191tE = m8230a("item.radio.call");

    /* JADX INFO: renamed from: tF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8192tF = m8230a("item.grenade.equip");

    /* JADX INFO: renamed from: tG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8193tG = m8230a("item.grenade.throw");

    /* JADX INFO: renamed from: tH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8194tH = m8230a("item.grenade.pin");

    /* JADX INFO: renamed from: tI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8195tI = m8230a("item.grenade.bounce.metal");

    /* JADX INFO: renamed from: tJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8196tJ = m8230a("item.grenade.bounce.wood");

    /* JADX INFO: renamed from: tK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8197tK = m8230a("item.grenade.bounce.dirt");

    /* JADX INFO: renamed from: tL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8198tL = m8230a("item.grenade.flash.explode");

    /* JADX INFO: renamed from: tM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8199tM = m8230a("item.grenade.flash.blind");

    /* JADX INFO: renamed from: tN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8200tN = m8230a("item.grenade.smoke.explode");

    /* JADX INFO: renamed from: tO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8201tO = m8230a("item.grenade.smoke.burn");

    /* JADX INFO: renamed from: tP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8202tP = m8230a("item.grenade.fire.explode");

    /* JADX INFO: renamed from: tQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8203tQ = m8230a("item.grenade.molotov.explode");

    /* JADX INFO: renamed from: tR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8204tR = m8230a("item.grenade.molotov.equip");

    /* JADX INFO: renamed from: tS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8205tS = m8230a("item.grenade.molotov.throw");

    /* JADX INFO: renamed from: tT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8206tT = m8230a("item.grenade.holyhandgrenade");

    /* JADX INFO: renamed from: tU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8207tU = m8230a("item.medicalbag.bounce");

    /* JADX INFO: renamed from: tV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8208tV = m8230a("item.medicalbag.heal");

    /* JADX INFO: renamed from: tW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8209tW = m8230a("item.landmine.deploy");

    /* JADX INFO: renamed from: tX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8210tX = m8230a("item.landmine.bounce");

    /* JADX INFO: renamed from: tY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8211tY = m8230a("item.ammo.box.bounce");

    /* JADX INFO: renamed from: tZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8212tZ = m8230a("item.ammo.box.heal");

    /* JADX INFO: renamed from: ua */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8213ua = m8230a("item.bomb.beep");

    /* JADX INFO: renamed from: ub */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8214ub = m8230a("item.bomb.ignite");

    /* JADX INFO: renamed from: uc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8215uc = m8230a("item.bomb.explode");

    /* JADX INFO: renamed from: ud */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8216ud = m8230a("item.bomb.plant");

    /* JADX INFO: renamed from: ue */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8217ue = m8230a("item.bomb.planting");

    /* JADX INFO: renamed from: uf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8218uf = m8230a("item.bomb.button");

    /* JADX INFO: renamed from: ug */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8219ug = m8230a("item.bomb.defusing");

    /* JADX INFO: renamed from: uh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8220uh = m8230a("item.bomb.defuse");

    /* JADX INFO: renamed from: ui */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8221ui = m8230a("item.randomat.activate");

    /* JADX INFO: renamed from: uj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8222uj = m8230a("item.randomat.activate.all");

    /* JADX INFO: renamed from: uk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8223uk = m8230a("item.gun.bullet.impact");

    /* JADX INFO: renamed from: ul */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8224ul = m8230a("item.gun.bullet.impact.nose");

    /* JADX INFO: renamed from: um */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8225um = m8230a("item.gun.bullet.impact.nose.stereo");

    /* JADX INFO: renamed from: un */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8226un = m8230a("item.gun.bullet.impact.mg42");

    /* JADX INFO: renamed from: uo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8227uo = m8230a("item.gun.bullet.impact.mg42.stereo");

    /* JADX INFO: renamed from: up */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8228up = m8230a("item.gun.bullet.impact.glass");

    /* JADX INFO: renamed from: uq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8229uq = m8230a("item.gun.bullet.impact.glass.debris");

    /* JADX INFO: renamed from: ur */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8230ur = m8230a("item.gun.bullet.impact.glass.debris.late");

    /* JADX INFO: renamed from: us */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8231us = m8230a("item.gun.bullet.impact.barrel");

    /* JADX INFO: renamed from: ut */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8232ut = m8230a("item.gun.bullet.impact.metal");

    /* JADX INFO: renamed from: uu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8233uu = m8230a("item.gun.bullet.impact.metal.debris");

    /* JADX INFO: renamed from: uv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8234uv = m8230a("item.gun.bullet.impact.stone");

    /* JADX INFO: renamed from: uw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8235uw = m8230a("item.gun.bullet.impact.stone.debris");

    /* JADX INFO: renamed from: ux */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8236ux = m8230a("item.gun.bullet.impact.dirt");

    /* JADX INFO: renamed from: uy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8237uy = m8230a("item.gun.bullet.impact.dirt.debris");

    /* JADX INFO: renamed from: uz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8238uz = m8230a("item.gun.bullet.impact.wood");

    /* JADX INFO: renamed from: uA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8239uA = m8230a("item.gun.bullet.impact.wood.debris");

    /* JADX INFO: renamed from: uB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8240uB = m8230a("item.gun.bullet.impact.flesh");

    /* JADX INFO: renamed from: uC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8241uC = m8230a("item.gun.bullet.impact.flesh.head");

    /* JADX INFO: renamed from: uD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8242uD = m8230a("item.gun.bullet.impact.flesh.local");

    /* JADX INFO: renamed from: uE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8243uE = m8230a("item.gun.bullet.impact.flesh.head.helmet");

    /* JADX INFO: renamed from: uF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8244uF = m8230a("item.gun.bullet.impact.flesh.stereo");

    /* JADX INFO: renamed from: uG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8245uG = m8230a("item.gun.bullet.impact.flesh.nose");

    /* JADX INFO: renamed from: uH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8246uH = m8230a("item.gun.bullet.impact.water");

    /* JADX INFO: renamed from: uI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8247uI = m8230a("item.gun.bullet.pass");

    /* JADX INFO: renamed from: uJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8248uJ = m8230a("item.gun.bullet.pass.at");

    /* JADX INFO: renamed from: uK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8249uK = m8230a("item.gun.bullet.snap.0");

    /* JADX INFO: renamed from: uL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8250uL = m8230a("item.gun.bullet.snap.1");

    /* JADX INFO: renamed from: uM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8251uM = m8230a("item.gun.bullet.snap.2");

    /* JADX INFO: renamed from: uN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8252uN = m8230a("item.gun.bullet.snap.3");

    /* JADX INFO: renamed from: uO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8253uO = m8230a("item.gun.bullet.snap.4");

    /* JADX INFO: renamed from: uP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8254uP = m8230a("item.gun.bullet.snap.5");

    /* JADX INFO: renamed from: uQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8255uQ = m8230a("item.gun.bullet.snap.stereo.indoors");

    /* JADX INFO: renamed from: uR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8256uR = m8230a("item.gun.bullet.snap.stereo.outdoors");

    /* JADX INFO: renamed from: uS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8257uS = m8230a("item.gun.bullet.ricochet");

    /* JADX INFO: renamed from: uT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8258uT = m8230a("item.gun.bullet.ricochet.impact");

    /* JADX INFO: renamed from: uU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8259uU = m8230a("item.gun.shared.firemode");

    /* JADX INFO: renamed from: uV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8260uV = m8230a("item.gun.shared.corebass.close.lmg");

    /* JADX INFO: renamed from: uW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8261uW = m8230a("item.gun.shared.corebass.close.mg");

    /* JADX INFO: renamed from: uX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8262uX = m8230a("item.gun.shared.corebass.close.mg34");

    /* JADX INFO: renamed from: uY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8263uY = m8230a("item.gun.shared.corebass.close.mg42");

    /* JADX INFO: renamed from: uZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8264uZ = m8230a("item.gun.shared.corebass.close.mp40");

    /* JADX INFO: renamed from: va */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8265va = m8230a("item.gun.shared.corebass.close.pistol");

    /* JADX INFO: renamed from: vb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8266vb = m8230a("item.gun.shared.corebass.close.rifle");

    /* JADX INFO: renamed from: vc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8267vc = m8230a("item.gun.shared.corebass.close.stg44");

    /* JADX INFO: renamed from: vd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8268vd = m8230a("item.gun.shared.corebass.close.smg");

    /* JADX INFO: renamed from: ve */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8269ve = m8230a("item.gun.shared.corebass.close.m1garand");

    /* JADX INFO: renamed from: vf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8270vf = m8230a("item.gun.shared.corebass.lmg.distant");

    /* JADX INFO: renamed from: vg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8271vg = m8230a("item.gun.shared.corebass.pistol.distant");

    /* JADX INFO: renamed from: vh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8272vh = m8230a("item.gun.shared.corebass.rifle.distant");

    /* JADX INFO: renamed from: vi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8273vi = m8230a("item.gun.shared.corebass.smg.distant");

    /* JADX INFO: renamed from: vj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8274vj = m8230a("item.gun.shared.corebass.rocket.distant");

    /* JADX INFO: renamed from: vk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8275vk = m8230a("item.gun.shared.corebass.mg.distant");

    /* JADX INFO: renamed from: vl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8276vl = m8230a("item.gun.shared.nose");

    /* JADX INFO: renamed from: vm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8277vm = m8230a("item.gun.shared.nose.stereo");

    /* JADX INFO: renamed from: vn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8278vn = m8230a("item.gun.shared.earlysnap.mp40");

    /* JADX INFO: renamed from: vo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8279vo = m8230a("item.gun.shared.earlysnap.stg44");

    /* JADX INFO: renamed from: vp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8280vp = m8230a("item.gun.shared.earlysnap.bren");

    /* JADX INFO: renamed from: vq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8281vq = m8230a("item.gun.shared.earlysnap.m1carbine");

    /* JADX INFO: renamed from: vr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8282vr = m8230a("item.gun.shared.earlysnap.m1garand");

    /* JADX INFO: renamed from: vs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8283vs = m8230a("item.gun.shared.earlysnap.mosin");

    /* JADX INFO: renamed from: vt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8284vt = m8230a("item.gun.shared.rattle.mg");

    /* JADX INFO: renamed from: vu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8285vu = m8230a("item.gun.shared.rattle.smg");

    /* JADX INFO: renamed from: vv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8286vv = m8230a("item.gun.shared.rattle.lmg");

    /* JADX INFO: renamed from: vw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8287vw = m8230a("item.gun.shared.rattle.mg42");

    /* JADX INFO: renamed from: vx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8288vx = m8230a("item.gun.shared.towards.mg");

    /* JADX INFO: renamed from: vy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8289vy = m8230a("item.gun.shared.towards.pistol");

    /* JADX INFO: renamed from: vz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8290vz = m8230a("item.gun.shared.towards.rifle");

    /* JADX INFO: renamed from: vA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8291vA = m8230a("item.gun.shared.towards.smg");

    /* JADX INFO: renamed from: vB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8292vB = m8230a("item.gun.shared.add.pistol");

    /* JADX INFO: renamed from: vC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8293vC = m8230a("item.gun.shared.add.rifle");

    /* JADX INFO: renamed from: vD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8294vD = m8230a("item.gun.shared.add.rifle.semi");

    /* JADX INFO: renamed from: vE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8295vE = m8230a("item.gun.shared.add.smg");

    /* JADX INFO: renamed from: vF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8296vF = m8230a("item.gun.shared.dryfire.pistol");

    /* JADX INFO: renamed from: vG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8297vG = m8230a("item.gun.shared.dryfire.revolver");

    /* JADX INFO: renamed from: vH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8298vH = m8230a("item.gun.shared.dryfire.smg");

    /* JADX INFO: renamed from: vI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8299vI = m8230a("item.gun.shared.dryfire.rifle");

    /* JADX INFO: renamed from: vJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8300vJ = m8230a("item.gun.shared.dryfire.carbine");

    /* JADX INFO: renamed from: vK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8301vK = m8230a("item.gun.shared.dryfire.shotgun");

    /* JADX INFO: renamed from: vL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8302vL = m8230a("item.gun.shared.dryfire.mg");

    /* JADX INFO: renamed from: vM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8303vM = m8230a("item.gun.shared.dryfire.lmg");

    /* JADX INFO: renamed from: vN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8304vN = m8230a("item.gun.shared.dryfire.at");

    /* JADX INFO: renamed from: vO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8305vO = m8230a("item.gun.shared.echo.close");

    /* JADX INFO: renamed from: vP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8306vP = m8230a("item.gun.shared.echo.close.self");

    /* JADX INFO: renamed from: vQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8307vQ = m8230a("item.gun.shared.echo.close.indoors");

    /* JADX INFO: renamed from: vR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8308vR = m8230a("item.gun.shared.echo.close.indoors.mg");

    /* JADX INFO: renamed from: vS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8309vS = m8230a("item.gun.shared.echo.close.indoors.pistol");

    /* JADX INFO: renamed from: vT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8310vT = m8230a("item.gun.shared.echo.close.indoors.rifle");

    /* JADX INFO: renamed from: vU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8311vU = m8230a("item.gun.shared.echo.close.indoors.smg");

    /* JADX INFO: renamed from: vV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8312vV = m8230a("item.gun.shared.echo.close.indoors.self");

    /* JADX INFO: renamed from: vW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8313vW = m8230a("item.gun.shared.echo.close.indoors.self.open");

    /* JADX INFO: renamed from: vX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8314vX = m8230a("item.gun.shared.echo.close.indoors.self.mg");

    /* JADX INFO: renamed from: vY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8315vY = m8230a("item.gun.shared.echo.close.indoors.self.mg.open");

    /* JADX INFO: renamed from: vZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8316vZ = m8230a("item.gun.shared.echo.close.indoors.self.pistol");

    /* JADX INFO: renamed from: wa */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8317wa = m8230a("item.gun.shared.echo.close.indoors.self.pistol.open");

    /* JADX INFO: renamed from: wb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8318wb = m8230a("item.gun.shared.echo.close.indoors.self.rifle");

    /* JADX INFO: renamed from: wc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8319wc = m8230a("item.gun.shared.echo.close.indoors.self.rifle.open");

    /* JADX INFO: renamed from: wd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8320wd = m8230a("item.gun.shared.echo.close.indoors.self.smg");

    /* JADX INFO: renamed from: we */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8321we = m8230a("item.gun.shared.echo.close.suppressor");

    /* JADX INFO: renamed from: wf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8322wf = m8230a("item.gun.shared.echo.close.suppressor.self");

    /* JADX INFO: renamed from: wg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8323wg = m8230a("item.gun.shared.echo.distant.m3");

    /* JADX INFO: renamed from: wh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8324wh = m8230a("item.gun.shared.echo.distant.m3.stereo");

    /* JADX INFO: renamed from: wi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8325wi = m8230a("item.gun.shared.echo.distant.stenmk2");

    /* JADX INFO: renamed from: wj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8326wj = m8230a("item.gun.shared.echo.distant.stenmk2.stereo");

    /* JADX INFO: renamed from: wk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8327wk = m8230a("item.gun.shared.echo.distant.pps43");

    /* JADX INFO: renamed from: wl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8328wl = m8230a("item.gun.shared.echo.distant.pps43.stereo");

    /* JADX INFO: renamed from: wm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8329wm = m8230a("item.gun.shared.echo.distant.mg42");

    /* JADX INFO: renamed from: wn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8330wn = m8230a("item.gun.shared.echo.distant.mg42.stereo");

    /* JADX INFO: renamed from: wo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8331wo = m8230a("item.gun.shared.echo.distant.smg");

    /* JADX INFO: renamed from: wp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8332wp = m8230a("item.gun.shared.echo.distant.smg.stereo");

    /* JADX INFO: renamed from: wq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8333wq = m8230a("item.gun.shared.echo.distant.shotgun");

    /* JADX INFO: renamed from: wr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8334wr = m8230a("item.gun.shared.echo.distant.shotgun.stereo");

    /* JADX INFO: renamed from: ws */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8335ws = m8230a("item.gun.shared.echo.distant.rifle");

    /* JADX INFO: renamed from: wt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8336wt = m8230a("item.gun.shared.echo.distant.rifle.stereo");

    /* JADX INFO: renamed from: wu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8337wu = m8230a("item.gun.shared.echo.distant.at");

    /* JADX INFO: renamed from: wv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8338wv = m8230a("item.gun.shared.echo.distant.at.stereo");

    /* JADX INFO: renamed from: ww */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8339ww = m8230a("item.gun.shared.echo.distant.meloncannon");

    /* JADX INFO: renamed from: wx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8340wx = m8230a("item.gun.shared.echo.distant.meloncannon.stereo");

    /* JADX INFO: renamed from: wy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8341wy = m8230a("item.gun.shared.echo.distant.rifle.semi");

    /* JADX INFO: renamed from: wz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8342wz = m8230a("item.gun.shared.echo.distant.rifle.semi.stereo");

    /* JADX INFO: renamed from: wA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8343wA = m8230a("item.gun.shared.echo.distant.mg");

    /* JADX INFO: renamed from: wB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8344wB = m8230a("item.gun.shared.echo.distant.mg.stereo");

    /* JADX INFO: renamed from: wC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8345wC = m8230a("item.gun.shared.echo.distant.lmg");

    /* JADX INFO: renamed from: wD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8346wD = m8230a("item.gun.shared.echo.distant.lmg.stereo");

    /* JADX INFO: renamed from: wE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8347wE = m8230a("item.gun.shared.echo.distant.rocket");

    /* JADX INFO: renamed from: wF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8348wF = m8230a("item.gun.shared.echo.distant.rocket.stereo");

    /* JADX INFO: renamed from: wG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8349wG = m8230a("item.gun.shared.echo.distant.pistol");

    /* JADX INFO: renamed from: wH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8350wH = m8230a("item.gun.shared.echo.distant.pistol.stereo");

    /* JADX INFO: renamed from: wI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8351wI = m8230a("item.gun.shared.echo.distant.musket");

    /* JADX INFO: renamed from: wJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8352wJ = m8230a("item.gun.shared.echo.distant.musket.stereo");

    /* JADX INFO: renamed from: wK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8353wK = m8230a("item.gun.shared.echo.distant.indoors");

    /* JADX INFO: renamed from: wL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8354wL = m8230a("item.gun.shared.echo.distant.indoors.mg");

    /* JADX INFO: renamed from: wM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8355wM = m8230a("item.gun.shared.echo.distant.indoors.pistol");

    /* JADX INFO: renamed from: wN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8356wN = m8230a("item.gun.shared.echo.distant.indoors.rifle");

    /* JADX INFO: renamed from: wO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8357wO = m8230a("item.gun.shared.echo.distant.indoors.smg");

    /* JADX INFO: renamed from: wP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8358wP = m8230a("item.gun.shared.echo.distant.revolver");

    /* JADX INFO: renamed from: wQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8359wQ = m8230a("item.gun.shared.echo.distant.revolver.stereo");

    /* JADX INFO: renamed from: wR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8360wR = m8230a("item.gun.shared.echo.distant.leeenfield");

    /* JADX INFO: renamed from: wS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8361wS = m8230a("item.gun.shared.echo.distant.leeenfield.stereo");

    /* JADX INFO: renamed from: wT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8362wT = m8230a("item.gun.shared.echo.distant.springfield");

    /* JADX INFO: renamed from: wU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8363wU = m8230a("item.gun.shared.echo.distant.springfield.stereo");

    /* JADX INFO: renamed from: wV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8364wV = m8230a("item.gun.shared.echo.distant.lewisgun");

    /* JADX INFO: renamed from: wW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8365wW = m8230a("item.gun.shared.echo.distant.lewisgun.stereo");

    /* JADX INFO: renamed from: wX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8366wX = m8230a("item.gun.shared.echo.distant.mp40");

    /* JADX INFO: renamed from: wY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8367wY = m8230a("item.gun.shared.echo.distant.mp40.stereo");

    /* JADX INFO: renamed from: wZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8368wZ = m8230a("item.gun.shared.echo.distant.m1carbine");

    /* JADX INFO: renamed from: xa */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8369xa = m8230a("item.gun.shared.echo.distant.m1carbine.stereo");

    /* JADX INFO: renamed from: xb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8370xb = m8230a("item.gun.shared.echo.distant.m1garand");

    /* JADX INFO: renamed from: xc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8371xc = m8230a("item.gun.shared.echo.distant.m1garand.stereo");

    /* JADX INFO: renamed from: xd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8372xd = m8230a("item.gun.shared.echo.distant.kar98k");

    /* JADX INFO: renamed from: xe */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8373xe = m8230a("item.gun.shared.echo.distant.kar98k.stereo");

    /* JADX INFO: renamed from: xf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8374xf = m8230a("item.gun.shared.echo.distant.mosin");

    /* JADX INFO: renamed from: xg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8375xg = m8230a("item.gun.shared.echo.distant.mosin.stereo");

    /* JADX INFO: renamed from: xh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8376xh = m8230a("item.gun.shared.bullet.lmg");

    /* JADX INFO: renamed from: xi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8377xi = m8230a("item.gun.shared.bullet.lmg.dirt");

    /* JADX INFO: renamed from: xj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8378xj = m8230a("item.gun.shared.bullet.lmg.wood");

    /* JADX INFO: renamed from: xk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8379xk = m8230a("item.gun.shared.bullet.lmg.metal");

    /* JADX INFO: renamed from: xl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8380xl = m8230a("item.gun.shared.bullet.lmg.water");

    /* JADX INFO: renamed from: xm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8381xm = m8230a("item.gun.shared.bullet.shotgun");

    /* JADX INFO: renamed from: xn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8382xn = m8230a("item.gun.shared.bullet.vehicle");

    /* JADX INFO: renamed from: xo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8383xo = m8230a("item.gun.shared.lfe.lmg");

    /* JADX INFO: renamed from: xp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8384xp = m8230a("item.gun.shared.lfe.pistol");

    /* JADX INFO: renamed from: xq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8385xq = m8230a("item.gun.shared.lfe.rifle");

    /* JADX INFO: renamed from: xr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8386xr = m8230a("item.gun.shared.lfe.rpg");

    /* JADX INFO: renamed from: xs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8387xs = m8230a("item.gun.shared.overheat");

    /* JADX INFO: renamed from: xt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8388xt = m8230a("item.gun.shared.reload.bolt");

    /* JADX INFO: renamed from: xu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8389xu = m8230a("item.gun.shared.reload.shell");

    /* JADX INFO: renamed from: xv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8390xv = m8230a("item.gun.shared.reload.bullet.rifle");

    /* JADX INFO: renamed from: xw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8391xw = m8230a("item.gun.shared.reload.pump");

    /* JADX INFO: renamed from: xx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8392xx = m8230a("item.gun.shared.reload.pump.back");

    /* JADX INFO: renamed from: xy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8393xy = m8230a("item.gun.shared.reload.pump.forward");

    /* JADX INFO: renamed from: xz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8394xz = m8230a("item.gun.shared.reload.bolt.back");

    /* JADX INFO: renamed from: xA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8395xA = m8230a("item.gun.shared.reload.bolt.forward");

    /* JADX INFO: renamed from: xB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8396xB = m8230a("item.gun.shared.reload.winchester.lever");

    /* JADX INFO: renamed from: xC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8397xC = m8230a("item.gun.shared.foley.arm.lmg");

    /* JADX INFO: renamed from: xD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8398xD = m8230a("item.gun.shared.foley.arm.pistol");

    /* JADX INFO: renamed from: xE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8399xE = m8230a("item.gun.shared.foley.arm.rifle");

    /* JADX INFO: renamed from: xF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8400xF = m8230a("item.gun.shared.foley.arm.smg");

    /* JADX INFO: renamed from: xG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8401xG = m8230a("item.gun.shared.foley.equip.pistol");

    /* JADX INFO: renamed from: xH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8402xH = m8230a("item.gun.shared.foley.equip.rifle");

    /* JADX INFO: renamed from: xI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8403xI = m8230a("item.gun.shared.foley.equip.rocket");

    /* JADX INFO: renamed from: xJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8404xJ = m8230a("item.gun.shared.foley.equip.smg");

    /* JADX INFO: renamed from: xK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8405xK = m8230a("item.gun.shared.foley.equip.revolver");

    /* JADX INFO: renamed from: xL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8406xL = m8230a("item.gun.shared.deploy");

    /* JADX INFO: renamed from: xM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8407xM = m8230a("item.gun.shared.undeploy");

    /* JADX INFO: renamed from: xN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8408xN = m8230a("item.gun.colt.fire");

    /* JADX INFO: renamed from: xO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8409xO = m8230a("item.gun.colt.reload");

    /* JADX INFO: renamed from: xP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8410xP = m8230a("item.gun.colt.reload.empty");

    /* JADX INFO: renamed from: xQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8411xQ = m8230a("item.gun.berettam1934.fire");

    /* JADX INFO: renamed from: xR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8412xR = m8230a("item.gun.berettam1934.reload");

    /* JADX INFO: renamed from: xS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8413xS = m8230a("item.gun.berettam1934.reload.empty");

    /* JADX INFO: renamed from: xT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8414xT = m8230a("item.gun.fnmodel1910.fire");

    /* JADX INFO: renamed from: xU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8415xU = m8230a("item.gun.fnmodel1910.reload");

    /* JADX INFO: renamed from: xV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8416xV = m8230a("item.gun.fnmodel1910.reload.empty");

    /* JADX INFO: renamed from: xW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8417xW = m8230a("item.gun.m1garand.fire");

    /* JADX INFO: renamed from: xX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8418xX = m8230a("item.gun.m1garand.reload");

    /* JADX INFO: renamed from: xY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8419xY = m8230a("item.gun.m1garand.reload.empty");

    /* JADX INFO: renamed from: xZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8420xZ = m8230a("item.gun.m1garand.ping");

    /* JADX INFO: renamed from: ya */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8421ya = m8230a("item.gun.m1garand.pre");

    /* JADX INFO: renamed from: yb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8422yb = m8230a("item.gun.piat.fire");

    /* JADX INFO: renamed from: yc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8423yc = m8230a("item.gun.piat.pre");

    /* JADX INFO: renamed from: yd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8424yd = m8230a("item.gun.thompson.fire");

    /* JADX INFO: renamed from: ye */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8425ye = m8230a("item.gun.thompson.reload");

    /* JADX INFO: renamed from: yf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8426yf = m8230a("item.gun.thompson.reload.empty");

    /* JADX INFO: renamed from: yg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8427yg = m8230a("item.gun.thompson.pre");

    /* JADX INFO: renamed from: yh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8428yh = m8230a("item.gun.greasegun.fire");

    /* JADX INFO: renamed from: yi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8429yi = m8230a("item.gun.greasegun.fire.suppressor");

    /* JADX INFO: renamed from: yj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8430yj = m8230a("item.gun.greasegun.reload");

    /* JADX INFO: renamed from: yk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8431yk = m8230a("item.gun.greasegun.pre.suppressor");

    /* JADX INFO: renamed from: yl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8432yl = m8230a("item.gun.bar.fire");

    /* JADX INFO: renamed from: ym */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8433ym = m8230a("item.gun.bar.reload");

    /* JADX INFO: renamed from: yn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8434yn = m8230a("item.gun.bar.reload.empty");

    /* JADX INFO: renamed from: yo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8435yo = m8230a("item.gun.bar.pre");

    /* JADX INFO: renamed from: yp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8436yp = m8230a("item.gun.springfield.fire");

    /* JADX INFO: renamed from: yq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8437yq = m8230a("item.gun.browning30.fire");

    /* JADX INFO: renamed from: yr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8438yr = m8230a("item.gun.browning30.reload");

    /* JADX INFO: renamed from: ys */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8439ys = m8230a("item.gun.m1carbine.fire");

    /* JADX INFO: renamed from: yt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8440yt = m8230a("item.gun.m1carbine.reload");

    /* JADX INFO: renamed from: yu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8441yu = m8230a("item.gun.m1carbine.pre");

    /* JADX INFO: renamed from: yv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8442yv = m8230a("item.gun.m2carbine.fire");

    /* JADX INFO: renamed from: yw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8443yw = m8230a("item.gun.m2carbine.reload");

    /* JADX INFO: renamed from: yx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8444yx = m8230a("item.gun.bazooka.fire");

    /* JADX INFO: renamed from: yy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8445yy = m8230a("item.gun.meloncannon.reload");

    /* JADX INFO: renamed from: yz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8446yz = m8230a("item.gun.meloncannon.fire");

    /* JADX INFO: renamed from: yA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8447yA = m8230a("item.gun.p38.fire");

    /* JADX INFO: renamed from: yB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8448yB = m8230a("item.gun.p38.reload");

    /* JADX INFO: renamed from: yC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8449yC = m8230a("item.gun.p38.reload.empty");

    /* JADX INFO: renamed from: yD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8450yD = m8230a("item.gun.luger.fire");

    /* JADX INFO: renamed from: yE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8451yE = m8230a("item.gun.luger.reload");

    /* JADX INFO: renamed from: yF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8452yF = m8230a("item.gun.luger.reload.empty");

    /* JADX INFO: renamed from: yG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8453yG = m8230a("item.gun.mauser_c96.fire");

    /* JADX INFO: renamed from: yH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8454yH = m8230a("item.gun.mauser_c96.reload");

    /* JADX INFO: renamed from: yI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8455yI = m8230a("item.gun.mauser_c96.reload.empty");

    /* JADX INFO: renamed from: yJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8456yJ = m8230a("item.gun.m712.fire");

    /* JADX INFO: renamed from: yK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8457yK = m8230a("item.gun.m712.pre");

    /* JADX INFO: renamed from: yL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8458yL = m8230a("item.gun.m712.reload");

    /* JADX INFO: renamed from: yM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8459yM = m8230a("item.gun.m712.reload.empty");

    /* JADX INFO: renamed from: yN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8460yN = m8230a("item.gun.kar98k.fire");

    /* JADX INFO: renamed from: yO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8461yO = m8230a("item.gun.kar98k.reload");

    /* JADX INFO: renamed from: yP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8462yP = m8230a("item.gun.kar98k.pre");

    /* JADX INFO: renamed from: yQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8463yQ = m8230a("item.gun.trenchgun.fire");

    /* JADX INFO: renamed from: yR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8464yR = m8230a("item.gun.trenchgun.pre");

    /* JADX INFO: renamed from: yS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8465yS = m8230a("item.gun.browninga5.fire");

    /* JADX INFO: renamed from: yT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8466yT = m8230a("item.gun.browninga5.pre");

    /* JADX INFO: renamed from: yU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8467yU = m8230a("item.gun.mp40.fire");

    /* JADX INFO: renamed from: yV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8468yV = m8230a("item.gun.mp40.reload");

    /* JADX INFO: renamed from: yW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8469yW = m8230a("item.gun.mp40.reload.empty");

    /* JADX INFO: renamed from: yX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8470yX = m8230a("item.gun.mp40.pre");

    /* JADX INFO: renamed from: yY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8471yY = m8230a("item.gun.mp40.equip");

    /* JADX INFO: renamed from: yZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8472yZ = m8230a("item.gun.mp41.fire");

    /* JADX INFO: renamed from: za */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8473za = m8230a("item.gun.stg44.fire");

    /* JADX INFO: renamed from: zb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8474zb = m8230a("item.gun.stg44.reload");

    /* JADX INFO: renamed from: zc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8475zc = m8230a("item.gun.stg44.reload.empty");

    /* JADX INFO: renamed from: zd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8476zd = m8230a("item.gun.stg44.equip");

    /* JADX INFO: renamed from: ze */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8477ze = m8230a("item.gun.fg42.fire");

    /* JADX INFO: renamed from: zf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8478zf = m8230a("item.gun.fg42.reload");

    /* JADX INFO: renamed from: zg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8479zg = m8230a("item.gun.mg42.fire");

    /* JADX INFO: renamed from: zh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8480zh = m8230a("item.gun.mg42.reload");

    /* JADX INFO: renamed from: zi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8481zi = m8230a("item.gun.mg42.pre");

    /* JADX INFO: renamed from: zj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8482zj = m8230a("item.gun.panzerschreck.fire");

    /* JADX INFO: renamed from: zk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8483zk = m8230a("item.gun.gewehr43.fire");

    /* JADX INFO: renamed from: zl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8484zl = m8230a("item.gun.gewehr43.reload");

    /* JADX INFO: renamed from: zm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8485zm = m8230a("item.gun.gewehr43.reload.empty");

    /* JADX INFO: renamed from: zn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8486zn = m8230a("item.gun.tokarevtt33.fire");

    /* JADX INFO: renamed from: zo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8487zo = m8230a("item.gun.tokarevtt33.reload");

    /* JADX INFO: renamed from: zp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8488zp = m8230a("item.gun.tokarevtt33.reload.empty");

    /* JADX INFO: renamed from: zq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8489zq = m8230a("item.gun.blyskawica.fire");

    /* JADX INFO: renamed from: zr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8490zr = m8230a("item.gun.blyskawica.reload");

    /* JADX INFO: renamed from: zs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8491zs = m8230a("item.gun.blyskawica.reload.empty");

    /* JADX INFO: renamed from: zt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8492zt = m8230a("item.gun.dp28.fire");

    /* JADX INFO: renamed from: zu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8493zu = m8230a("item.gun.dp28.reload");

    /* JADX INFO: renamed from: zv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8494zv = m8230a("item.gun.kbkwz29.fire");

    /* JADX INFO: renamed from: zw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8495zw = m8230a("item.gun.kbkwz29.reload");

    /* JADX INFO: renamed from: zx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8496zx = m8230a("item.gun.koppal.fire");

    /* JADX INFO: renamed from: zy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8497zy = m8230a("item.gun.koppal.reload");

    /* JADX INFO: renamed from: zz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8498zz = m8230a("item.gun.m1944.fire");

    /* JADX INFO: renamed from: zA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8499zA = m8230a("item.gun.m1944.reload");

    /* JADX INFO: renamed from: zB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8500zB = m8230a("item.gun.mg34.fire");

    /* JADX INFO: renamed from: zC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8501zC = m8230a("item.gun.mg34.reload");

    /* JADX INFO: renamed from: zD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8502zD = m8230a("item.gun.mg34.pre");

    /* JADX INFO: renamed from: zE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8503zE = m8230a("item.gun.mg34.equip");

    /* JADX INFO: renamed from: zF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8504zF = m8230a("item.gun.mosinnagant.fire");

    /* JADX INFO: renamed from: zG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8505zG = m8230a("item.gun.mosinnagant.pre");

    /* JADX INFO: renamed from: zH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8506zH = m8230a("item.gun.panzerfaust.fire");

    /* JADX INFO: renamed from: zI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8507zI = m8230a("item.gun.panzerfaust.reload");

    /* JADX INFO: renamed from: zJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8508zJ = m8230a("item.gun.pps43.fire");

    /* JADX INFO: renamed from: zK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8509zK = m8230a("item.gun.pps43.reload");

    /* JADX INFO: renamed from: zL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8510zL = m8230a("item.gun.pps43.equip");

    /* JADX INFO: renamed from: zM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8511zM = m8230a("item.gun.ppsh.fire");

    /* JADX INFO: renamed from: zN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8512zN = m8230a("item.gun.ppsh.reload");

    /* JADX INFO: renamed from: zO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8513zO = m8230a("item.gun.ppsh.equip");

    /* JADX INFO: renamed from: zP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8514zP = m8230a("item.gun.ptrs.fire");

    /* JADX INFO: renamed from: zQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8515zQ = m8230a("item.gun.ptrs.reload");

    /* JADX INFO: renamed from: zR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8516zR = m8230a("item.gun.tokarevavt40.fire");

    /* JADX INFO: renamed from: zS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8517zS = m8230a("item.gun.tokarevavt40.reload");

    /* JADX INFO: renamed from: zT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8518zT = m8230a("item.gun.fbvis.fire");

    /* JADX INFO: renamed from: zU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8519zU = m8230a("item.gun.fbvis.reload");

    /* JADX INFO: renamed from: zV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8520zV = m8230a("item.gun.fbvis.reload.empty");

    /* JADX INFO: renamed from: zW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8521zW = m8230a("item.gun.zb26.fire");

    /* JADX INFO: renamed from: zX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8522zX = m8230a("item.gun.zb26.reload");

    /* JADX INFO: renamed from: zY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8523zY = m8230a("item.gun.type14.fire");

    /* JADX INFO: renamed from: zZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8524zZ = m8230a("item.gun.type14.reload");

    /* JADX INFO: renamed from: Aa */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8525Aa = m8230a("item.gun.type14.reload.empty");

    /* JADX INFO: renamed from: Ab */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8526Ab = m8230a("item.gun.type94.fire");

    /* JADX INFO: renamed from: Ac */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8527Ac = m8230a("item.gun.type94.reload");

    /* JADX INFO: renamed from: Ad */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8528Ad = m8230a("item.gun.type94.reload.empty");

    /* JADX INFO: renamed from: Ae */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8529Ae = m8230a("item.gun.type26.fire");

    /* JADX INFO: renamed from: Af */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8530Af = m8230a("item.gun.type26.reload");

    /* JADX INFO: renamed from: Ag */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8531Ag = m8230a("item.gun.type38.fire");

    /* JADX INFO: renamed from: Ah */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8532Ah = m8230a("item.gun.type38.pre");

    /* JADX INFO: renamed from: Ai */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8533Ai = m8230a("item.gun.type99.fire");

    /* JADX INFO: renamed from: Aj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8534Aj = m8230a("item.gun.type99.reload");

    /* JADX INFO: renamed from: Ak */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8535Ak = m8230a("item.gun.type4.fire");

    /* JADX INFO: renamed from: Al */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8536Al = m8230a("item.gun.type4.reload");

    /* JADX INFO: renamed from: Am */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8537Am = m8230a("item.gun.type92.fire");

    /* JADX INFO: renamed from: An */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8538An = m8230a("item.gun.type92.reload");

    /* JADX INFO: renamed from: Ao */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8539Ao = m8230a("item.gun.type92.equip");

    /* JADX INFO: renamed from: Ap */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8540Ap = m8230a("item.gun.type11.fire");

    /* JADX INFO: renamed from: Aq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8541Aq = m8230a("item.gun.type11.reload");

    /* JADX INFO: renamed from: Ar */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8542Ar = m8230a("item.gun.type100.fire");

    /* JADX INFO: renamed from: As */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8543As = m8230a("item.gun.type100.reload");

    /* JADX INFO: renamed from: At */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8544At = m8230a("item.gun.type100.reload.empty");

    /* JADX INFO: renamed from: Au */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8545Au = m8230a("item.gun.bren.mk2.fire");

    /* JADX INFO: renamed from: Av */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8546Av = m8230a("item.gun.bren.mk2.pre");

    /* JADX INFO: renamed from: Aw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8547Aw = m8230a("item.gun.bren.mk2.reload");

    /* JADX INFO: renamed from: Ax */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8548Ax = m8230a("item.gun.type96.fire");

    /* JADX INFO: renamed from: Ay */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8549Ay = m8230a("item.gun.type96.pre");

    /* JADX INFO: renamed from: Az */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8550Az = m8230a("item.gun.type96.reload");

    /* JADX INFO: renamed from: AA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8551AA = m8230a("item.gun.type96.equip");

    /* JADX INFO: renamed from: AB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8552AB = m8230a("item.gun.type98.fire");

    /* JADX INFO: renamed from: AC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8553AC = m8230a("item.gun.type98.reload");

    /* JADX INFO: renamed from: AD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8554AD = m8230a("item.gun.leeenfieldmk1.fire");

    /* JADX INFO: renamed from: AE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8555AE = m8230a("item.gun.leeenfieldmk1.pre");

    /* JADX INFO: renamed from: AF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8556AF = m8230a("item.gun.webley.mk6.fire");

    /* JADX INFO: renamed from: AG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8557AG = m8230a("item.gun.webley.mk6.pre");

    /* JADX INFO: renamed from: AH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8558AH = m8230a("item.gun.webley.mk6.reload");

    /* JADX INFO: renamed from: AI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8559AI = m8230a("item.gun.nagant_m1895.fire");

    /* JADX INFO: renamed from: AJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8560AJ = m8230a("item.gun.nagant_m1895.pre");

    /* JADX INFO: renamed from: AK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8561AK = m8230a("item.gun.nagant_m1895.reload");

    /* JADX INFO: renamed from: AL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8562AL = m8230a("item.gun.stenmk2.fire");

    /* JADX INFO: renamed from: AM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8563AM = m8230a("item.gun.stenmk2.reload");

    /* JADX INFO: renamed from: AN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8564AN = m8230a("item.gun.stenmk2.pre");

    /* JADX INFO: renamed from: AO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8565AO = m8230a("item.gun.stenmk2.reload.empty");

    /* JADX INFO: renamed from: AP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8566AP = m8230a("item.gun.stenmk2.fire.suppressor");

    /* JADX INFO: renamed from: AQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8567AQ = m8230a("item.gun.stenmk2.pre.suppressor");

    /* JADX INFO: renamed from: AR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8568AR = m8230a("item.gun.delislecarbine.fire");

    /* JADX INFO: renamed from: AS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8569AS = m8230a("item.gun.delislecarbine.pre");

    /* JADX INFO: renamed from: AT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8570AT = m8230a("item.gun.delislecarbine.reload");

    /* JADX INFO: renamed from: AU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8571AU = m8230a("item.gun.vickersk.fire");

    /* JADX INFO: renamed from: AV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8572AV = m8230a("item.gun.vickersk.reload");

    /* JADX INFO: renamed from: AW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8573AW = m8230a("item.gun.carcano.fire");

    /* JADX INFO: renamed from: AX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8574AX = m8230a("item.gun.model1935.fire");

    /* JADX INFO: renamed from: AY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8575AY = m8230a("item.gun.model1935.reload");

    /* JADX INFO: renamed from: AZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8576AZ = m8230a("item.gun.model38.fire");

    /* JADX INFO: renamed from: Ba */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8577Ba = m8230a("item.gun.model38.pre");

    /* JADX INFO: renamed from: Bb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8578Bb = m8230a("item.gun.model38.reload");

    /* JADX INFO: renamed from: Bc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8579Bc = m8230a("item.gun.model38.equip");

    /* JADX INFO: renamed from: Bd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8580Bd = m8230a("item.gun.model1930.fire");

    /* JADX INFO: renamed from: Be */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8581Be = m8230a("item.gun.model1930.reload");

    /* JADX INFO: renamed from: Bf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8582Bf = m8230a("item.gun.model1930.reload.empty");

    /* JADX INFO: renamed from: Bg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8583Bg = m8230a("item.gun.fiatrevelli.fire");

    /* JADX INFO: renamed from: Bh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8584Bh = m8230a("item.gun.tromboncino.fire");

    /* JADX INFO: renamed from: Bi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8585Bi = m8230a("item.gun.glisenti.model.1910.fire");

    /* JADX INFO: renamed from: Bj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8586Bj = m8230a("item.gun.glisenti.model.1910.reload");

    /* JADX INFO: renamed from: Bk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8587Bk = m8230a("item.gun.glisenti.model.1910.reload.empty");

    /* JADX INFO: renamed from: Bl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8588Bl = m8230a("item.gun.lebel1886.fire");

    /* JADX INFO: renamed from: Bm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8589Bm = m8230a("item.gun.pistolet_automatique_modele_1935a.fire");

    /* JADX INFO: renamed from: Bn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8590Bn = m8230a("item.gun.pistolet_automatique_modele_1935a.reload");

    /* JADX INFO: renamed from: Bo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8591Bo = m8230a("item.gun.pistolet_automatique_modele_1935a.reload.empty");

    /* JADX INFO: renamed from: Bp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8592Bp = m8230a("item.gun.macmle1931.fire");

    /* JADX INFO: renamed from: Bq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8593Bq = m8230a("item.gun.macmle1931.reload");

    /* JADX INFO: renamed from: Br */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8594Br = m8230a("item.gun.macmle1931.pre");

    /* JADX INFO: renamed from: Bs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8595Bs = m8230a("item.gun.fusil1917.fire");

    /* JADX INFO: renamed from: Bt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8596Bt = m8230a("item.gun.fusil1917.reload");

    /* JADX INFO: renamed from: Bu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8597Bu = m8230a("item.gun.mas38.fire");

    /* JADX INFO: renamed from: Bv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8598Bv = m8230a("item.gun.mas38.reload");

    /* JADX INFO: renamed from: Bw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8599Bw = m8230a("item.gun.mas38.pre");

    /* JADX INFO: renamed from: Bx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8600Bx = m8230a("item.gun.batr.fire");

    /* JADX INFO: renamed from: By */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8601By = m8230a("item.gun.batr.reload");

    /* JADX INFO: renamed from: Bz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8602Bz = m8230a("item.gun.batr.pre");

    /* JADX INFO: renamed from: BA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8603BA = m8230a("item.gun.panzerbuchse39.fire");

    /* JADX INFO: renamed from: BB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8604BB = m8230a("item.gun.panzerbuchse39.reload");

    /* JADX INFO: renamed from: BC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8605BC = m8230a("item.gun.panzerbuchse39.pre");

    /* JADX INFO: renamed from: BD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8606BD = m8230a("item.gun.panzerbuchse39.equip");

    /* JADX INFO: renamed from: BE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8607BE = m8230a("item.gun.modele_1892_revolver.fire");

    /* JADX INFO: renamed from: BF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8608BF = m8230a("item.gun.modele_1892_revolver.pre");

    /* JADX INFO: renamed from: BG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8609BG = m8230a("item.gun.modele_1892_revolver.reload");

    /* JADX INFO: renamed from: BH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8610BH = m8230a("item.gun.m2flamethrower.fire");

    /* JADX INFO: renamed from: BI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8611BI = m8230a("item.gun.m2flamethrower.reload");

    /* JADX INFO: renamed from: BJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8612BJ = m8230a("item.gun.m2flamethrower.pre");

    /* JADX INFO: renamed from: BK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8613BK = m8230a("item.gun.m2flamethrower.post");

    /* JADX INFO: renamed from: BL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8614BL = m8230a("item.gun.m2flamethrower.last");

    /* JADX INFO: renamed from: BM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8615BM = m8230a("item.gun.m2flamethrower.ignite.start");

    /* JADX INFO: renamed from: BN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8616BN = m8230a("item.gun.m2flamethrower.ignite");

    /* JADX INFO: renamed from: BO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8617BO = m8230a("item.gun.m30.fire");

    /* JADX INFO: renamed from: BP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8618BP = m8230a("item.gun.m30.reload");

    /* JADX INFO: renamed from: BQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8619BQ = m8230a("item.gun.ak74.fire");

    /* JADX INFO: renamed from: BR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8620BR = m8230a("item.gun.ak74.pre");

    /* JADX INFO: renamed from: BS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8621BS = m8230a("item.gun.ak74.reload");

    /* JADX INFO: renamed from: BT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8622BT = m8230a("item.gun.ak74.reload.empty");

    /* JADX INFO: renamed from: BU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8623BU = m8230a("item.gun.m4a4.fire");

    /* JADX INFO: renamed from: BV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8624BV = m8230a("item.gun.m4a4.reload");

    /* JADX INFO: renamed from: BW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8625BW = m8230a("item.gun.m4a4.pre");

    /* JADX INFO: renamed from: BX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8626BX = m8230a("item.gun.lewisgun.fire");

    /* JADX INFO: renamed from: BY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8627BY = m8230a("item.gun.lewisgun.reload");

    /* JADX INFO: renamed from: BZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8628BZ = m8230a("item.gun.welrod.fire");

    /* JADX INFO: renamed from: Ca */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8629Ca = m8230a("item.gun.welrod.pre");

    /* JADX INFO: renamed from: Cb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8630Cb = m8230a("item.gun.welrod.reload");

    /* JADX INFO: renamed from: Cc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8631Cc = m8230a("item.gun.welrod.equip");

    /* JADX INFO: renamed from: Cd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8632Cd = m8230a("item.gun.browninghipower.fire");

    /* JADX INFO: renamed from: Ce */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8633Ce = m8230a("item.gun.browninghipower.reload");

    /* JADX INFO: renamed from: Cf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8634Cf = m8230a("item.gun.browninghipower.reload.empty");

    /* JADX INFO: renamed from: Cg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8635Cg = m8230a("item.gun.brownbess.fire");

    /* JADX INFO: renamed from: Ch */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8636Ch = m8230a("item.gun.brownbess.pre");

    /* JADX INFO: renamed from: Ci */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8637Ci = m8230a("item.gun.howell.fire");

    /* JADX INFO: renamed from: Cj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8638Cj = m8230a("item.gun.howell.reload");

    /* JADX INFO: renamed from: Ck */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8639Ck = m8230a("item.gun.howell.pre");

    /* JADX INFO: renamed from: Cl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8640Cl = m8230a("item.gun.kis.fire");

    /* JADX INFO: renamed from: Cm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8641Cm = m8230a("item.gun.kis.reload");

    /* JADX INFO: renamed from: Cn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8642Cn = m8230a("item.gun.kis.reload.empty");

    /* JADX INFO: renamed from: Co */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8643Co = m8230a("item.gun.mp.3008.fire");

    /* JADX INFO: renamed from: Cp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8644Cp = m8230a("item.gun.mp.3008.reload");

    /* JADX INFO: renamed from: Cq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8645Cq = m8230a("item.gun.mp.3008.reload.empty");

    /* JADX INFO: renamed from: Cr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8646Cr = m8230a("item.gun.winchester.1895.fire");

    /* JADX INFO: renamed from: Cs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8647Cs = m8230a("item.gun.winchester.1895.reload");

    /* JADX INFO: renamed from: Ct */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8648Ct = m8230a("item.gun.wz35.fire");

    /* JADX INFO: renamed from: Cu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8649Cu = m8230a("item.gun.wz35.reload");

    /* JADX INFO: renamed from: Cv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8650Cv = m8230a("item.gun.wz35.pre");

    /* JADX INFO: renamed from: Cw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8651Cw = m8230a("item.gun.flak38.fire");

    /* JADX INFO: renamed from: Cx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8652Cx = m8230a("item.gun.flak38.pre");

    /* JADX INFO: renamed from: Cy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8653Cy = m8230a("item.knife.equip");

    /* JADX INFO: renamed from: Cz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8654Cz = m8230a("item.knife.swing");

    /* JADX INFO: renamed from: CA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8655CA = m8230a("item.knife.trick.0");

    /* JADX INFO: renamed from: CB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8656CB = m8230a("item.shovel.swing");

    /* JADX INFO: renamed from: CC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8657CC = m8230a("item.sword.swing");

    /* JADX INFO: renamed from: CD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8658CD = m8230a("item.wrench.swing");

    /* JADX INFO: renamed from: CE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8659CE = m8230a("item.gun.shared.zoom.pistol.in");

    /* JADX INFO: renamed from: CF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8660CF = m8230a("item.gun.shared.zoom.pistol.out");

    /* JADX INFO: renamed from: CG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8661CG = m8230a("item.gun.shared.zoom.mg.in");

    /* JADX INFO: renamed from: CH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8662CH = m8230a("item.gun.shared.zoom.mg.out");

    /* JADX INFO: renamed from: CI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8663CI = m8230a("item.gun.shared.zoom.rifle.in");

    /* JADX INFO: renamed from: CJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8664CJ = m8230a("item.gun.shared.zoom.rifle.out");

    /* JADX INFO: renamed from: CK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8665CK = m8230a("item.gun.shared.zoom.smg.in");

    /* JADX INFO: renamed from: CL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8666CL = m8230a("item.gun.shared.zoom.smg.out");

    /* JADX INFO: renamed from: CM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8667CM = m8230a("item.gun.shared.lastround.smg");

    /* JADX INFO: renamed from: CN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8668CN = m8230a("item.gun.shared.lastround.lmg");

    /* JADX INFO: renamed from: CO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8669CO = m8230a("item.gun.shared.lastround.mg");

    /* JADX INFO: renamed from: CP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8670CP = m8230a("item.gun.shared.lastround.pistol");

    /* JADX INFO: renamed from: CQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8671CQ = m8230a("item.gun.shared.lastround.shotgun");

    /* JADX INFO: renamed from: CR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8672CR = m8230a("ambient.wildlife.birds.chirp");

    /* JADX INFO: renamed from: CS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8673CS = m8230a("ambient.wildlife.birds.crow.calls");

    /* JADX INFO: renamed from: CT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8674CT = m8230a("ambient.wildlife.cockerel.call");

    /* JADX INFO: renamed from: CU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8675CU = m8230a("ambient.wildlife.dog.bark.distant");

    /* JADX INFO: renamed from: CV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8676CV = m8230a("ambient.wildlife.birds.robin.cry");

    /* JADX INFO: renamed from: CW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8677CW = m8230a("ambient.wildlife.birds.raven.cry");

    /* JADX INFO: renamed from: CX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8678CX = m8230a("ambient.wildlife.birds.dove.call");

    /* JADX INFO: renamed from: CY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8679CY = m8230a("ambient.wildlife.birds.crow.calls.near");

    /* JADX INFO: renamed from: CZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8680CZ = m8230a("ambient.wildlife.birds.woodpecker");

    /* JADX INFO: renamed from: Da */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8681Da = m8230a("ambient.wildlife.birds.bluejay");

    /* JADX INFO: renamed from: Db */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8682Db = m8230a("ambient.wildlife.owl.call");

    /* JADX INFO: renamed from: Dc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8683Dc = m8230a("ambient.wildlife.owl.call.distant");

    /* JADX INFO: renamed from: Dd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8684Dd = m8230a("ambient.wildlife.owl.screech.distant");

    /* JADX INFO: renamed from: De */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8685De = m8230a("ambient.war.artillery.distant");

    /* JADX INFO: renamed from: Df */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8686Df = m8230a("ambient.war.artillery.far");

    /* JADX INFO: renamed from: Dg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8687Dg = m8230a("ambient.war.artillery.close");

    /* JADX INFO: renamed from: Dh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8688Dh = m8230a("ambient.war.artillery.katyusha");

    /* JADX INFO: renamed from: Di */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8689Di = m8230a("ambient.war.distant.tank.shot");

    /* JADX INFO: renamed from: Dj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8690Dj = m8230a("ambient.war.distant.tank");

    /* JADX INFO: renamed from: Dk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8691Dk = m8230a("ambient.war.distant.gunfight");

    /* JADX INFO: renamed from: Dl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8692Dl = m8230a("ambient.war.distant.gun");

    /* JADX INFO: renamed from: Dm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8693Dm = m8230a("ambient.war.distant.flak");

    /* JADX INFO: renamed from: Dn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8694Dn = m8230a("ambient.war.distant.artillery");

    /* JADX INFO: renamed from: Do */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8695Do = m8230a("ambient.war.distant.explosion");

    /* JADX INFO: renamed from: Dp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8696Dp = m8230a("ambient.weather.lightning.nose");

    /* JADX INFO: renamed from: Dq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8697Dq = m8230a("ambient.weather.lightning.stereo");

    /* JADX INFO: renamed from: Dr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8698Dr = m8230a("ambient.weather.lightning");

    /* JADX INFO: renamed from: Ds */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8699Ds = m8230a("ambient.lsp.mosque.call");

    /* JADX INFO: renamed from: Dt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8700Dt = m8230a("ambient.lsp.blade.creak");

    /* JADX INFO: renamed from: Du */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8701Du = m8230a("ambient.lsp.alarm.0");

    /* JADX INFO: renamed from: Dv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8702Dv = m8230a("ambient.lsp.alarm.1");

    /* JADX INFO: renamed from: Dw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8703Dw = m8230a("ambient.lsp.alarm.2");

    /* JADX INFO: renamed from: Dx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8704Dx = m8230a("ambient.lsp.alarm.3");

    /* JADX INFO: renamed from: Dy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8705Dy = m8230a("ambient.lsp.alarm.4");

    /* JADX INFO: renamed from: Dz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8706Dz = m8230a("ambient.lsp.alarm.5");

    /* JADX INFO: renamed from: DA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8707DA = m8230a("ambient.lsp.alarm.6");

    /* JADX INFO: renamed from: DB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8708DB = m8230a("ambient.lsp.alarm.7");

    /* JADX INFO: renamed from: DC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8709DC = m8230a("ambient.lsp.alarm.8");

    /* JADX INFO: renamed from: DD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8710DD = m8230a("ambient.lsp.alarm.9");

    /* JADX INFO: renamed from: DE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8711DE = m8230a("ambient.lsp.beach.wave");

    /* JADX INFO: renamed from: DF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8712DF = m8230a("ambient.lsp.radio.german");

    /* JADX INFO: renamed from: DG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8713DG = m8230a("ambient.lsp.radio.japan");

    /* JADX INFO: renamed from: DH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8714DH = m8230a("ambient.lsp.radio.music.jazz.0");

    /* JADX INFO: renamed from: DI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8715DI = m8230a("ambient.lsp.radio.music.jazz.1");

    /* JADX INFO: renamed from: DJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8716DJ = m8230a("ambient.lsp.radio.music.church.0");

    /* JADX INFO: renamed from: DK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8717DK = m8230a("ambient.lsp.radio.music.polish.0");

    /* JADX INFO: renamed from: DL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8718DL = m8230a("ambient.lsp.radio.music.polish.1");

    /* JADX INFO: renamed from: DM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8719DM = m8230a("ambient.lsp.radio.music.polish.2");

    /* JADX INFO: renamed from: DN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8720DN = m8230a("ambient.lsp.radio.music.arabic.0");

    /* JADX INFO: renamed from: DO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8721DO = m8230a("ambient.lsp.radio.music.arabic.1");

    /* JADX INFO: renamed from: DP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8722DP = m8230a("ambient.lsp.radio.music.french.0");

    /* JADX INFO: renamed from: DQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8723DQ = m8230a("ambient.lsp.radio.music.french.1");

    /* JADX INFO: renamed from: DR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8724DR = m8230a("ambient.lsp.radio.music.french.2");

    /* JADX INFO: renamed from: DS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8725DS = m8230a("ambient.lsp.radio.music.african.0");

    /* JADX INFO: renamed from: DT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8726DT = m8230a("ambient.lsp.radio.music.african.1");

    /* JADX INFO: renamed from: DU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8727DU = m8230a("ambient.lsp.radio.music.greek.0");

    /* JADX INFO: renamed from: DV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8728DV = m8230a("ambient.lsp.radio.music.greek.1");

    /* JADX INFO: renamed from: DW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8729DW = m8230a("ambient.lsp.radio.music.japanese.0");

    /* JADX INFO: renamed from: DX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8730DX = m8230a("ambient.lsp.radio.music.japanese.1");

    /* JADX INFO: renamed from: DY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8731DY = m8230a("ambient.lsp.radio.music.japanese.2");

    /* JADX INFO: renamed from: DZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8732DZ = m8230a("ambient.lsp.radio.music.italian.0");

    /* JADX INFO: renamed from: Ea */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8733Ea = m8230a("ambient.lsp.radio.music.italian.1");

    /* JADX INFO: renamed from: Eb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8734Eb = m8230a("ambient.lsp.radio.music.italian.2");

    /* JADX INFO: renamed from: Ec */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8735Ec = m8230a("ambient.lsp.radio.music.italian.3");

    /* JADX INFO: renamed from: Ed */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8736Ed = m8230a("ambient.lsp.machinery.0");

    /* JADX INFO: renamed from: Ee */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8737Ee = m8230a("ambient.lsp.machinery.1");

    /* JADX INFO: renamed from: Ef */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8738Ef = m8230a("ambient.lsp.machinery.2");

    /* JADX INFO: renamed from: Eg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8739Eg = m8230a("ambient.lsp.machinery.3");

    /* JADX INFO: renamed from: Eh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8740Eh = m8230a("ambient.lsp.machinery.4");

    /* JADX INFO: renamed from: Ei */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8741Ei = m8230a("ambient.lsp.machinery.function.0");

    /* JADX INFO: renamed from: Ej */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8742Ej = m8230a("ambient.lsp.machinery.function.1");

    /* JADX INFO: renamed from: Ek */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8743Ek = m8230a("ambient.lsp.machinery.function.2");

    /* JADX INFO: renamed from: El */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8744El = m8230a("ambient.lsp.machinery.function.3");

    /* JADX INFO: renamed from: Em */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8745Em = m8230a("ambient.lsp.machinery.function.4");

    /* JADX INFO: renamed from: En */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8746En = m8230a("ambient.lsp.machinery.function.5");

    /* JADX INFO: renamed from: Eo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8747Eo = m8230a("ambient.lsp.machinery.function.6");

    /* JADX INFO: renamed from: Ep */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8748Ep = m8230a("ambient.lsp.vehicle.tank.engine.idle");

    /* JADX INFO: renamed from: Eq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8749Eq = m8230a("ambient.lsp.vehicle.plane.engine.idle.distant");

    /* JADX INFO: renamed from: Er */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8750Er = m8230a("ambient.lsp.vehicle.truck.engine.idle");

    /* JADX INFO: renamed from: Es */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8751Es = m8230a("ambient.lsp.vehicle.boat.engine.idle");

    /* JADX INFO: renamed from: Et */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8752Et = m8230a("ambient.lsp.vehicle.uboat.engine.idle");

    /* JADX INFO: renamed from: Eu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8753Eu = m8230a("ambient.lsp.vehicle.plane.crash.crete");

    /* JADX INFO: renamed from: Ev */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8754Ev = m8230a("ambient.lsp.human.whistle");

    /* JADX INFO: renamed from: Ew */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8755Ew = m8230a("ambient.lsp.phone.ring");

    /* JADX INFO: renamed from: Ex */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8756Ex = m8230a("ambient.lsp.music.reichstag");

    /* JADX INFO: renamed from: Ey */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8757Ey = m8230a("ambient.lsp.church.bell0");

    /* JADX INFO: renamed from: Ez */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8758Ez = m8230a("ambient.lsp.church.bell0.far");

    /* JADX INFO: renamed from: EA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8759EA = m8230a("ambient.lsp.church.bell1");

    /* JADX INFO: renamed from: EB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8760EB = m8230a("ambient.lsp.church.bell1.far");

    /* JADX INFO: renamed from: EC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8761EC = m8230a("ambient.lsp.church.bell2");

    /* JADX INFO: renamed from: ED */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8762ED = m8230a("ambient.lsp.church.bell2.far");

    /* JADX INFO: renamed from: EE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8763EE = m8230a("ambient.lsp.docks.shipbell");

    /* JADX INFO: renamed from: EF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8764EF = m8230a("ambient.lsp.docks.horn");

    /* JADX INFO: renamed from: EG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8765EG = m8230a("ambient.lsp.thunder");

    /* JADX INFO: renamed from: EH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8766EH = m8230a("ambient.lsp.water.drip.heavy.0");

    /* JADX INFO: renamed from: EI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8767EI = m8230a("ambient.lsp.water.drip.heavy.1");

    /* JADX INFO: renamed from: EJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8768EJ = m8230a("ambient.lsp.water.drip.metal.0");

    /* JADX INFO: renamed from: EK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8769EK = m8230a("ambient.lsp.water.drip.metal.1");

    /* JADX INFO: renamed from: EL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8770EL = m8230a("ambient.lsp.industrial.metal.clanking");

    /* JADX INFO: renamed from: EM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8771EM = m8230a("ambient.lsp.industrial.metal.stress");

    /* JADX INFO: renamed from: EN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8772EN = m8230a("ambient.lsp.fire.small");

    /* JADX INFO: renamed from: EO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8773EO = m8230a("ambient.lsp.fire.large");

    /* JADX INFO: renamed from: EP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8774EP = m8230a("ambient.lsp.fire.metal");

    /* JADX INFO: renamed from: EQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8775EQ = m8230a("ambient.lsp.siren");

    /* JADX INFO: renamed from: ER */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8776ER = m8230a("ambient.lsp.siren.double");

    /* JADX INFO: renamed from: ES */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8777ES = m8230a("ambient.lsp.rubble");

    /* JADX INFO: renamed from: ET */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8778ET = m8230a("ambient.loop.crickets");

    /* JADX INFO: renamed from: EU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8779EU = m8230a("ambient.loop.crickets.desert");

    /* JADX INFO: renamed from: EV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8780EV = m8230a("ambient.loop.forest");

    /* JADX INFO: renamed from: EW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8781EW = m8230a("ambient.loop.interior.house");

    /* JADX INFO: renamed from: EX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8782EX = m8230a("ambient.loop.interior.bunker");

    /* JADX INFO: renamed from: EY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8783EY = m8230a("ambient.loop.interior.wind.howl");

    /* JADX INFO: renamed from: EZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8784EZ = m8230a("ambient.loop.rainstorm");

    /* JADX INFO: renamed from: Fa */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8785Fa = m8230a("ambient.loop.rainstorm.urban");

    /* JADX INFO: renamed from: Fb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8786Fb = m8230a("ambient.loop.interior.rainstorm.urban");

    /* JADX INFO: renamed from: Fc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8787Fc = m8230a("ambient.loop.war");

    /* JADX INFO: renamed from: Fd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8788Fd = m8230a("ambient.loop.wind");

    /* JADX INFO: renamed from: Fe */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8789Fe = m8230a("ambient.loop.wind.scary");

    /* JADX INFO: renamed from: Ff */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8790Ff = m8230a("ambient.loop.wind.cold");

    /* JADX INFO: renamed from: Fg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8791Fg = m8230a("ambient.loop.wind.blizzard");

    /* JADX INFO: renamed from: Fh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8792Fh = m8230a("ambient.loop.wind.blizzard.strong");

    /* JADX INFO: renamed from: Fi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8793Fi = m8230a("ambient.loop.wind.sandstorm");

    /* JADX INFO: renamed from: Fj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8794Fj = m8230a("ambient.loop.wind.sandstorm.foliage");

    /* JADX INFO: renamed from: Fk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8795Fk = m8230a("ambient.loop.wind.strong");

    /* JADX INFO: renamed from: Fl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8796Fl = m8230a("ambient.loop.urban");

    /* JADX INFO: renamed from: Fm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8797Fm = m8230a("ambient.explosion.grenade.nose");

    /* JADX INFO: renamed from: Fn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8798Fn = m8230a("ambient.explosion.grenade.nose.distant");

    /* JADX INFO: renamed from: Fo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8799Fo = m8230a("ambient.explosion.grenade.ambience");

    /* JADX INFO: renamed from: Fp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8800Fp = m8230a("ambient.explosion.grenade.ambience.distant");

    /* JADX INFO: renamed from: Fq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8801Fq = m8230a("ambient.explosion.grenade.ambience.indoors");

    /* JADX INFO: renamed from: Fr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8802Fr = m8230a("ambient.explosion.grenade.ambience.indoors.distant");

    /* JADX INFO: renamed from: Fs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8803Fs = m8230a("ambient.explosion.grenade.explode.close");

    /* JADX INFO: renamed from: Ft */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8804Ft = m8230a("ambient.explosion.grenade.explode.close.indoors");

    /* JADX INFO: renamed from: Fu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8805Fu = m8230a("ambient.explosion.grenade.explode.close.stereo");

    /* JADX INFO: renamed from: Fv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8806Fv = m8230a("ambient.explosion.grenade.explode.bass");

    /* JADX INFO: renamed from: Fw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8807Fw = m8230a("ambient.explosion.grenade.explode.distant");

    /* JADX INFO: renamed from: Fx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8808Fx = m8230a("ambient.explosion.grenade.explode.distant.indoors");

    /* JADX INFO: renamed from: Fy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8809Fy = m8230a("ambient.explosion.artillery.ambience");

    /* JADX INFO: renamed from: Fz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8810Fz = m8230a("ambient.explosion.artillery.ambience.distant");

    /* JADX INFO: renamed from: FA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8811FA = m8230a("ambient.explosion.debris");

    /* JADX INFO: renamed from: FB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8812FB = m8230a("ambient.explosion.debris.indoors");

    /* JADX INFO: renamed from: FC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8813FC = m8230a("ambient.explosion.debris.brick");

    /* JADX INFO: renamed from: FD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8814FD = m8230a("ambient.explosion.debris.rock");

    /* JADX INFO: renamed from: FE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8815FE = m8230a("ambient.explosion.debris.metal");

    /* JADX INFO: renamed from: FF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8816FF = m8230a("ambient.explosion.debris.glass");

    /* JADX INFO: renamed from: FG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8817FG = m8230a("ambient.explosion.debris.sandbag");

    /* JADX INFO: renamed from: FH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8818FH = m8230a("ambient.explosion.debris.wood");

    /* JADX INFO: renamed from: FI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8819FI = m8230a("ambient.explosion.debris.vehicle");

    /* JADX INFO: renamed from: FJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8820FJ = m8230a("team.us.bot.intro");

    /* JADX INFO: renamed from: FK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8821FK = m8230a("team.us.bot.go");

    /* JADX INFO: renamed from: FL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8822FL = m8230a("team.us.bot.grenade");

    /* JADX INFO: renamed from: FM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8823FM = m8230a("team.us.bot.hurt");

    /* JADX INFO: renamed from: FN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8824FN = m8230a("team.us.bot.reloading");

    /* JADX INFO: renamed from: FO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8825FO = m8230a("team.us.bot.spotted");

    /* JADX INFO: renamed from: FP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8826FP = m8230a("team.us.bot.taunt");

    /* JADX INFO: renamed from: FQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8827FQ = m8230a("team.ger.bot.intro");

    /* JADX INFO: renamed from: FR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8828FR = m8230a("team.ger.bot.go");

    /* JADX INFO: renamed from: FS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8829FS = m8230a("team.ger.bot.grenade");

    /* JADX INFO: renamed from: FT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8830FT = m8230a("team.ger.bot.hurt");

    /* JADX INFO: renamed from: FU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8831FU = m8230a("team.ger.bot.reloading");

    /* JADX INFO: renamed from: FV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8832FV = m8230a("team.ger.bot.spotted");

    /* JADX INFO: renamed from: FW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8833FW = m8230a("team.ger.bot.taunt");

    /* JADX INFO: renamed from: FX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8834FX = m8230a("team.jpn.bot.intro");

    /* JADX INFO: renamed from: FY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8835FY = m8230a("team.jpn.bot.go");

    /* JADX INFO: renamed from: FZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8836FZ = m8230a("team.jpn.bot.grenade");

    /* JADX INFO: renamed from: Ga */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8837Ga = m8230a("team.jpn.bot.hurt");

    /* JADX INFO: renamed from: Gb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8838Gb = m8230a("team.jpn.bot.reloading");

    /* JADX INFO: renamed from: Gc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8839Gc = m8230a("team.jpn.bot.spotted");

    /* JADX INFO: renamed from: Gd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8840Gd = m8230a("team.jpn.bot.taunt");

    /* JADX INFO: renamed from: Ge */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8841Ge = m8230a("team.jpn.banzai");

    /* JADX INFO: renamed from: Gf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8842Gf = m8230a("team.jpn.banzai.distant");

    /* JADX INFO: renamed from: Gg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8843Gg = m8230a("team.jpn.banzai.commander");

    /* JADX INFO: renamed from: Gh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8844Gh = m8230a("team.fr.bot.intro");

    /* JADX INFO: renamed from: Gi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8845Gi = m8230a("team.fr.bot.go");

    /* JADX INFO: renamed from: Gj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8846Gj = m8230a("team.fr.bot.grenade");

    /* JADX INFO: renamed from: Gk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8847Gk = m8230a("team.fr.bot.hurt");

    /* JADX INFO: renamed from: Gl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8848Gl = m8230a("team.fr.bot.reloading");

    /* JADX INFO: renamed from: Gm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8849Gm = m8230a("team.fr.bot.spotted");

    /* JADX INFO: renamed from: Gn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8850Gn = m8230a("team.fr.bot.taunt");

    /* JADX INFO: renamed from: Go */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8851Go = m8230a("team.gb.bot.intro");

    /* JADX INFO: renamed from: Gp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8852Gp = m8230a("team.gb.bot.go");

    /* JADX INFO: renamed from: Gq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8853Gq = m8230a("team.gb.bot.grenade");

    /* JADX INFO: renamed from: Gr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8854Gr = m8230a("team.gb.bot.hurt");

    /* JADX INFO: renamed from: Gs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8855Gs = m8230a("team.gb.bot.reloading");

    /* JADX INFO: renamed from: Gt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8856Gt = m8230a("team.gb.bot.spotted");

    /* JADX INFO: renamed from: Gu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8857Gu = m8230a("team.gb.bot.taunt");

    /* JADX INFO: renamed from: Gv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8858Gv = m8230a("team.gb.scot.bot.intro");

    /* JADX INFO: renamed from: Gw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8859Gw = m8230a("team.gb.scot.bot.go");

    /* JADX INFO: renamed from: Gx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8860Gx = m8230a("team.gb.scot.bot.grenade");

    /* JADX INFO: renamed from: Gy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8861Gy = m8230a("team.gb.scot.bot.hurt");

    /* JADX INFO: renamed from: Gz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8862Gz = m8230a("team.gb.scot.bot.reloading");

    /* JADX INFO: renamed from: GA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8863GA = m8230a("team.gb.scot.bot.spotted");

    /* JADX INFO: renamed from: GB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8864GB = m8230a("team.gb.scot.bot.taunt");

    /* JADX INFO: renamed from: GC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8865GC = m8230a("team.rus.bot.intro");

    /* JADX INFO: renamed from: GD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8866GD = m8230a("team.rus.bot.go");

    /* JADX INFO: renamed from: GE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8867GE = m8230a("team.rus.bot.grenade");

    /* JADX INFO: renamed from: GF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8868GF = m8230a("team.rus.bot.hurt");

    /* JADX INFO: renamed from: GG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8869GG = m8230a("team.rus.bot.reloading");

    /* JADX INFO: renamed from: GH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8870GH = m8230a("team.rus.bot.spotted");

    /* JADX INFO: renamed from: GI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8871GI = m8230a("team.rus.bot.taunt");

    /* JADX INFO: renamed from: GJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8872GJ = m8230a("team.shared.scream");

    /* JADX INFO: renamed from: GK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8873GK = m8230a("team.shared.scream.explosion");

    /* JADX INFO: renamed from: GL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8874GL = m8230a("team.shared.scream.wilhelm");

    /* JADX INFO: renamed from: GM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8875GM = m8230a("team.shared.warcry");

    /* JADX INFO: renamed from: GN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8876GN = m8230a("team.shared.warcry.distant");

    /* JADX INFO: renamed from: GO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8877GO = m8230a("team.shared.warcry.crowd");

    /* JADX INFO: renamed from: GP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8878GP = m8230a("team.shared.whistle");

    /* JADX INFO: renamed from: GQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8879GQ = m8230a("team.shared.ignite");

    /* JADX INFO: renamed from: GR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8880GR = m8230a("team.shared.cough");

    /* JADX INFO: renamed from: GS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8881GS = m8230a("team.shared.gasp");

    /* JADX INFO: renamed from: GT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8882GT = m8230a("team.shared.hurt");

    /* JADX INFO: renamed from: GU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8883GU = m8230a("team.shared.panic");

    /* JADX INFO: renamed from: GV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8884GV = m8230a("team.it.bot.intro");

    /* JADX INFO: renamed from: GW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8885GW = m8230a("team.it.bot.go");

    /* JADX INFO: renamed from: GX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8886GX = m8230a("team.it.bot.grenade");

    /* JADX INFO: renamed from: GY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8887GY = m8230a("team.it.bot.hurt");

    /* JADX INFO: renamed from: GZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8888GZ = m8230a("team.it.bot.reloading");

    /* JADX INFO: renamed from: Ha */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8889Ha = m8230a("team.it.bot.spotted");

    /* JADX INFO: renamed from: Hb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8890Hb = m8230a("team.it.bot.taunt");

    /* JADX INFO: renamed from: Hc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8891Hc = m8230a("team.pol.bot.intro");

    /* JADX INFO: renamed from: Hd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8892Hd = m8230a("team.pol.bot.go");

    /* JADX INFO: renamed from: He */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8893He = m8230a("team.pol.bot.grenade");

    /* JADX INFO: renamed from: Hf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8894Hf = m8230a("team.pol.bot.hurt");

    /* JADX INFO: renamed from: Hg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8895Hg = m8230a("team.pol.bot.reloading");

    /* JADX INFO: renamed from: Hh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8896Hh = m8230a("team.pol.bot.spotted");

    /* JADX INFO: renamed from: Hi */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8897Hi = m8230a("team.pol.bot.taunt");

    /* JADX INFO: renamed from: Hj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8898Hj = m8230a("match.memes.cheese");

    /* JADX INFO: renamed from: Hk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8899Hk = m8230a("match.memes.stefan");

    /* JADX INFO: renamed from: Hl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8900Hl = m8230a("match.memes.danke");

    /* JADX INFO: renamed from: Hm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8901Hm = m8230a("match.memes.sucka");

    /* JADX INFO: renamed from: Hn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8902Hn = m8230a("match.memes.everything");

    /* JADX INFO: renamed from: Ho */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8903Ho = m8230a("match.memes.who");

    /* JADX INFO: renamed from: Hp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8904Hp = m8230a("match.memes.howdareyou");

    /* JADX INFO: renamed from: Hq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8905Hq = m8230a("match.memes.whoru");

    /* JADX INFO: renamed from: Hr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8906Hr = m8230a("match.memes.hush");

    /* JADX INFO: renamed from: Hs */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8907Hs = m8230a("match.memes.notalent");

    /* JADX INFO: renamed from: Ht */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8908Ht = m8230a("match.memes.norespect");

    /* JADX INFO: renamed from: Hu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8909Hu = m8230a("match.memes.skillissue");

    /* JADX INFO: renamed from: Hv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8910Hv = m8230a("match.memes.monke");

    /* JADX INFO: renamed from: Hw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8911Hw = m8230a("match.memes.puff");

    /* JADX INFO: renamed from: Hx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8912Hx = m8230a("match.memes.badum");

    /* JADX INFO: renamed from: Hy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8913Hy = m8230a("match.memes.befehl");

    /* JADX INFO: renamed from: Hz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8914Hz = m8230a("match.memes.blade");

    /* JADX INFO: renamed from: HA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8915HA = m8230a("match.memes.bruh");

    /* JADX INFO: renamed from: HB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8916HB = m8230a("match.memes.chicken");

    /* JADX INFO: renamed from: HC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8917HC = m8230a("match.memes.chocolatecake");

    /* JADX INFO: renamed from: HD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8918HD = m8230a("match.memes.ciao");

    /* JADX INFO: renamed from: HE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8919HE = m8230a("match.memes.crickets");

    /* JADX INFO: renamed from: HF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8920HF = m8230a("match.memes.cupboard");

    /* JADX INFO: renamed from: HG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8921HG = m8230a("match.memes.damn");

    /* JADX INFO: renamed from: HH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8922HH = m8230a("match.memes.debile");

    /* JADX INFO: renamed from: HI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8923HI = m8230a("match.memes.depp");

    /* JADX INFO: renamed from: HJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8924HJ = m8230a("match.memes.eli");

    /* JADX INFO: renamed from: HK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8925HK = m8230a("match.memes.fart");

    /* JADX INFO: renamed from: HL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8926HL = m8230a("match.memes.fast");

    /* JADX INFO: renamed from: HM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8927HM = m8230a("match.memes.forknife");

    /* JADX INFO: renamed from: HN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8928HN = m8230a("match.memes.funny");

    /* JADX INFO: renamed from: HO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8929HO = m8230a("match.memes.gnome");

    /* JADX INFO: renamed from: HP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8930HP = m8230a("match.memes.haha");

    /* JADX INFO: renamed from: HQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8931HQ = m8230a("match.memes.hamster");

    /* JADX INFO: renamed from: HR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8932HR = m8230a("match.memes.hb");

    /* JADX INFO: renamed from: HS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8933HS = m8230a("match.memes.headshot");

    /* JADX INFO: renamed from: HT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8934HT = m8230a("match.memes.hia");

    /* JADX INFO: renamed from: HU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8935HU = m8230a("match.memes.hoho");

    /* JADX INFO: renamed from: HV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8936HV = m8230a("match.memes.honk");

    /* JADX INFO: renamed from: HW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8937HW = m8230a("match.memes.inception");

    /* JADX INFO: renamed from: HX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8938HX = m8230a("match.memes.jeopardy");

    /* JADX INFO: renamed from: HY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8939HY = m8230a("match.memes.kill");

    /* JADX INFO: renamed from: HZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8940HZ = m8230a("match.memes.lala");

    /* JADX INFO: renamed from: Ia */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8941Ia = m8230a("match.memes.leeroy");

    /* JADX INFO: renamed from: Ib */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8942Ib = m8230a("match.memes.lol");

    /* JADX INFO: renamed from: Ic */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8943Ic = m8230a("match.memes.lvlup");

    /* JADX INFO: renamed from: Id */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8944Id = m8230a("match.memes.meeting");

    /* JADX INFO: renamed from: Ie */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8945Ie = m8230a("match.memes.mew");

    /* JADX INFO: renamed from: If */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8946If = m8230a("match.memes.nein");

    /* JADX INFO: renamed from: Ig */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8947Ig = m8230a("match.memes.noice");

    /* JADX INFO: renamed from: Ih */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8948Ih = m8230a("match.memes.ppp");

    /* JADX INFO: renamed from: Ii */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8949Ii = m8230a("match.memes.quack");

    /* JADX INFO: renamed from: Ij */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8950Ij = m8230a("match.memes.raw");

    /* JADX INFO: renamed from: Ik */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8951Ik = m8230a("match.memes.sheee");

    /* JADX INFO: renamed from: Il */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8952Il = m8230a("match.memes.smooch");

    /* JADX INFO: renamed from: Im */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8953Im = m8230a("match.memes.splodged");

    /* JADX INFO: renamed from: In */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8954In = m8230a("match.memes.spongebub");

    /* JADX INFO: renamed from: Io */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8955Io = m8230a("match.memes.squeak");

    /* JADX INFO: renamed from: Ip */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8956Ip = m8230a("match.memes.sus");

    /* JADX INFO: renamed from: Iq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8957Iq = m8230a("match.memes.suspense");

    /* JADX INFO: renamed from: Ir */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8958Ir = m8230a("match.memes.weed");

    /* JADX INFO: renamed from: Is */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8959Is = m8230a("match.memes.woaw");

    /* JADX INFO: renamed from: It */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8960It = m8230a("match.memes.wow");

    /* JADX INFO: renamed from: Iu */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8961Iu = m8230a("match.memes.wrong");

    /* JADX INFO: renamed from: Iv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8962Iv = m8230a("match.memes.yay");

    /* JADX INFO: renamed from: Iw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8963Iw = m8230a("match.memes.yeehaw");

    /* JADX INFO: renamed from: Ix */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8964Ix = m8230a("match.memes.zonk");

    /* JADX INFO: renamed from: Iy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8965Iy = m8230a("match.memes.ayo");

    /* JADX INFO: renamed from: Iz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8966Iz = m8230a("match.memes.spoon");

    /* JADX INFO: renamed from: IA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8967IA = m8230a("match.memes.slap");

    /* JADX INFO: renamed from: IB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8968IB = m8230a("match.memes.no");

    /* JADX INFO: renamed from: IC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8969IC = m8230a("match.memes.pizza");

    /* JADX INFO: renamed from: ID */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8970ID = m8230a("match.memes.crackbone");

    /* JADX INFO: renamed from: IE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8971IE = m8230a("match.memes.himom");

    /* JADX INFO: renamed from: IF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8972IF = m8230a("match.memes.angry");

    /* JADX INFO: renamed from: IG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8973IG = m8230a("match.memes.cs4kids");

    /* JADX INFO: renamed from: IH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8974IH = m8230a("match.memes.lopez");

    /* JADX INFO: renamed from: II */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8975II = m8230a("match.memes.gman");

    /* JADX INFO: renamed from: IJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8976IJ = m8230a("match.memes.missed");

    /* JADX INFO: renamed from: IK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8977IK = m8230a("match.memes.fuc");

    /* JADX INFO: renamed from: IL */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8978IL = m8230a("match.memes.delicious");

    /* JADX INFO: renamed from: IM */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8979IM = m8230a("match.memes.fatass");

    /* JADX INFO: renamed from: IN */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8980IN = m8230a("match.memes.guy");

    /* JADX INFO: renamed from: IO */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8981IO = m8230a("match.memes.obamna");

    /* JADX INFO: renamed from: IP */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8982IP = m8230a("match.memes.wassup");

    /* JADX INFO: renamed from: IQ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8983IQ = m8230a("match.memes.quandale");

    /* JADX INFO: renamed from: IR */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8984IR = m8230a("match.memes.canny");

    /* JADX INFO: renamed from: IS */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8985IS = m8230a("match.memes.drink");

    /* JADX INFO: renamed from: IT */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8986IT = m8230a("match.memes.legitness");

    /* JADX INFO: renamed from: IU */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8987IU = m8230a("match.memes.milk");

    /* JADX INFO: renamed from: IV */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8988IV = m8230a("match.memes.mojo");

    /* JADX INFO: renamed from: IW */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8989IW = m8230a("match.memes.overthere");

    /* JADX INFO: renamed from: IX */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8990IX = m8230a("match.memes.scared");

    /* JADX INFO: renamed from: IY */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8991IY = m8230a("match.memes.scott");

    /* JADX INFO: renamed from: IZ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8992IZ = m8230a("match.memes.sheet");

    /* JADX INFO: renamed from: Ja */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8993Ja = m8230a("match.memes.ball");

    /* JADX INFO: renamed from: Jb */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8994Jb = m8230a("match.memes.comeagain");

    /* JADX INFO: renamed from: Jc */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8995Jc = m8230a("match.memes.onball");

    /* JADX INFO: renamed from: Jd */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8996Jd = m8230a("match.memes.shamwow");

    /* JADX INFO: renamed from: Je */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8997Je = m8230a("match.memes.snooping");

    /* JADX INFO: renamed from: Jf */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8998Jf = m8230a("match.memes.whatiswrong");

    /* JADX INFO: renamed from: Jg */
    public static final DeferredHolder<SoundEvent, SoundEvent> f8999Jg = m8230a("match.memes.wololo");

    /* JADX INFO: renamed from: Jh */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9000Jh = m8230a("match.memes.woohoo");

    /* JADX INFO: renamed from: Ji */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9001Ji = m8230a("match.memes.merkel");

    /* JADX INFO: renamed from: Jj */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9002Jj = m8230a("match.memes.balegdah");

    /* JADX INFO: renamed from: Jk */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9003Jk = m8230a("match.memes.whoasked");

    /* JADX INFO: renamed from: Jl */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9004Jl = m8230a("match.memes.survival");

    /* JADX INFO: renamed from: Jm */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9005Jm = m8230a("match.memes.toothpaste");

    /* JADX INFO: renamed from: Jn */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9006Jn = m8230a("match.memes.huh");

    /* JADX INFO: renamed from: Jo */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9007Jo = m8230a("match.memes.howto");

    /* JADX INFO: renamed from: Jp */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9008Jp = m8230a("match.memes.eyebrows");

    /* JADX INFO: renamed from: Jq */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9009Jq = m8230a("match.memes.squeaky");

    /* JADX INFO: renamed from: Jr */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9010Jr = m8230a("match.memes.wyd");

    /* JADX INFO: renamed from: Js */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9011Js = m8230a("match.memes.what");

    /* JADX INFO: renamed from: Jt */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9012Jt = m8230a("match.memes.gaben");

    /* JADX INFO: renamed from: Ju */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9013Ju = m8230a("match.memes.salami");

    /* JADX INFO: renamed from: Jv */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9014Jv = m8230a("match.memes.dayum");

    /* JADX INFO: renamed from: Jw */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9015Jw = m8230a("match.memes.wam");

    /* JADX INFO: renamed from: Jx */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9016Jx = m8230a("match.memes.eua");

    /* JADX INFO: renamed from: Jy */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9017Jy = m8230a("match.memes.augh");

    /* JADX INFO: renamed from: Jz */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9018Jz = m8230a("match.memes.kekeke");

    /* JADX INFO: renamed from: JA */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9019JA = m8230a("match.memes.wth");

    /* JADX INFO: renamed from: JB */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9020JB = m8230a("match.memes.omg");

    /* JADX INFO: renamed from: JC */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9021JC = m8230a("match.memes.seasamecake");

    /* JADX INFO: renamed from: JD */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9022JD = m8230a("match.memes.iaint");

    /* JADX INFO: renamed from: JE */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9023JE = m8230a("match.memes.dammit");

    /* JADX INFO: renamed from: JF */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9024JF = m8230a("match.memes.jockey");

    /* JADX INFO: renamed from: JG */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9025JG = m8230a("match.memes.nether");

    /* JADX INFO: renamed from: JH */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9026JH = m8230a("match.memes.rules");

    /* JADX INFO: renamed from: JI */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9027JI = m8230a("match.memes.ned");

    /* JADX INFO: renamed from: JJ */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9028JJ = m8230a("match.memes.mirrors");

    /* JADX INFO: renamed from: JK */
    public static final DeferredHolder<SoundEvent, SoundEvent> f9029JK = m8230a("match.memes.v8motor");

    static {
        f7912al.add(f8249uK);
        f7912al.add(f8250uL);
        f7912al.add(f8251uM);
        f7912al.add(f8252uN);
        f7912al.add(f8253uO);
        f7912al.add(f8254uP);
        f7910g.put("cheese", f8898Hj);
        f7910g.put("iaint", f9022JD);
        f7910g.put("seasamecake", f9021JC);
        f7910g.put("omg", f9020JB);
        f7910g.put("wth", f9019JA);
        f7910g.put("kekeke", f9018Jz);
        f7910g.put("augh", f9017Jy);
        f7910g.put("eua", f9016Jx);
        f7910g.put("stefan", f8899Hk);
        f7910g.put("danke", f8900Hl);
        f7910g.put("sucka", f8901Hm);
        f7910g.put("everything", f8902Hn);
        f7910g.put("who", f8903Ho);
        f7910g.put("howdareyou", f8904Hp);
        f7910g.put("whoru", f8905Hq);
        f7910g.put("hush", f8906Hr);
        f7910g.put("notalent", f8907Hs);
        f7910g.put("norespect", f8908Ht);
        f7910g.put("skillissue", f8909Hu);
        f7910g.put("monke", f8910Hv);
        f7910g.put("salami", f9013Ju);
        f7910g.put("dayum", f9014Jv);
        f7910g.put("wam", f9015Jw);
        f7910g.put("gaben", f9012Jt);
        f7910g.put("what", f9011Js);
        f7910g.put("survival", f9004Jl);
        f7910g.put("toothpaste", f9005Jm);
        f7910g.put("huh", f9006Jn);
        f7910g.put("howto", f9007Jo);
        f7910g.put("eyebrows", f9008Jp);
        f7910g.put("squeaky", f9009Jq);
        f7910g.put("wyd", f9010Jr);
        f7910g.put("whoasked", f9003Jk);
        f7910g.put("balegdah", f9002Jj);
        f7910g.put("ball", f8993Ja);
        f7910g.put("comeagain", f8994Jb);
        f7910g.put("onball", f8995Jc);
        f7910g.put("shamwow", f8996Jd);
        f7910g.put("snooping", f8997Je);
        f7910g.put("whatiswrong", f8998Jf);
        f7910g.put("wololo", f8999Jg);
        f7910g.put("woohoo", f9000Jh);
        f7910g.put("drink", f8985IS);
        f7910g.put("legitness", f8986IT);
        f7910g.put("milk", f8987IU);
        f7910g.put("mojo", f8988IV);
        f7910g.put("overthere", f8989IW);
        f7910g.put("scared", f8990IX);
        f7910g.put("scott", f8991IY);
        f7910g.put("sheet", f8992IZ);
        f7910g.put("badum", f8912Hx);
        f7910g.put("puff", f8911Hw);
        f7910g.put("befehl", f8913Hy);
        f7910g.put("blade", f8914Hz);
        f7910g.put("bruh", f8915HA);
        f7910g.put("chicken", f8916HB);
        f7910g.put("chocolatecake", f8917HC);
        f7910g.put("ciao", f8918HD);
        f7910g.put("crickets", f8919HE);
        f7910g.put("cupboard", f8920HF);
        f7910g.put("damn", f8921HG);
        f7910g.put("debile", f8922HH);
        f7910g.put("depp", f8923HI);
        f7910g.put("eli", f8924HJ);
        f7910g.put("fart", f8925HK);
        f7910g.put("fast", f8926HL);
        f7910g.put("forknife", f8927HM);
        f7910g.put("funny", f8928HN);
        f7910g.put("gnome", f8929HO);
        f7910g.put("haha", f8930HP);
        f7910g.put("hamster", f8931HQ);
        f7910g.put("hb", f8932HR);
        f7910g.put("headshot", f8933HS);
        f7910g.put("hia", f8934HT);
        f7910g.put("hoho", f8935HU);
        f7910g.put("honk", f8936HV);
        f7910g.put("inception", f8937HW);
        f7910g.put("jeopardy", f8938HX);
        f7910g.put("kill", f8939HY);
        f7910g.put("lala", f8940HZ);
        f7910g.put("leeroy", f8941Ia);
        f7910g.put("lol", f8942Ib);
        f7910g.put("lvlup", f8943Ic);
        f7910g.put("meeting", f8944Id);
        f7910g.put("mew", f8945Ie);
        f7910g.put("nein", f8946If);
        f7910g.put("noice", f8947Ig);
        f7910g.put("ppp", f8948Ih);
        f7910g.put("quack", f8949Ii);
        f7910g.put("raw", f8950Ij);
        f7910g.put("sheee", f8951Ik);
        f7910g.put("smooch", f8952Il);
        f7910g.put("splodged", f8953Im);
        f7910g.put("spongebob", f8954In);
        f7910g.put("squeak", f8955Io);
        f7910g.put("sus", f8956Ip);
        f7910g.put("suspense", f8957Iq);
        f7910g.put("weed", f8958Ir);
        f7910g.put("woaw", f8959Is);
        f7910g.put("wow", f8960It);
        f7910g.put("wrong", f8961Iu);
        f7910g.put("yay", f8962Iv);
        f7910g.put("yeehaw", f8963Iw);
        f7910g.put("zonk", f8964Ix);
        f7910g.put("ayo", f8965Iy);
        f7910g.put("spoon", f8966Iz);
        f7910g.put("slap", f8967IA);
        f7910g.put("no", f8968IB);
        f7910g.put("pizza", f8969IC);
        f7910g.put("crackbone", f8970ID);
        f7910g.put("himom", f8971IE);
        f7910g.put("angry", f8972IF);
        f7910g.put("cs4kids", f8973IG);
        f7910g.put("lopez", f8974IH);
        f7910g.put("gman", f8975II);
        f7910g.put("missed", f8976IJ);
        f7910g.put("fuc", f8977IK);
        f7910g.put("delicious", f8978IL);
        f7910g.put("fatass", f8979IM);
        f7910g.put("guy", f8980IN);
        f7910g.put("obamna", f8981IO);
        f7910g.put("wassup", f8982IP);
        f7910g.put("quandale", f8983IQ);
        f7910g.put("canny", f8984IR);
        f7910g.put("merkel", f9001Ji);
        f7910g.put("dammit", f9023JE);
        f7910g.put("jockey", f9024JF);
        f7910g.put("nether", f9025JG);
        f7910g.put("rules", f9026JH);
        f7910g.put("ned", f9027JI);
        f7910g.put("mirrors", f9028JJ);
        f7910g.put("v8motor", f9029JK);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static DeferredHolder<SoundEvent, SoundEvent> m8230a(@NotNull String str) {
        ResourceLocation resourceLocationM2378d = C0532jO.m2378d(str);
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderRegister = f7909i.register(resourceLocationM2378d.getPath(), () -> {
            return SoundEvent.createVariableRangeEvent(resourceLocationM2378d);
        });
        f7911h.put(resourceLocationM2378d.toString(), deferredHolderRegister);
        return deferredHolderRegister;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static SoundEvent m8231a(@NotNull String str) {
        ObjectIterator it = f7911h.values().iterator();
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
    public static String m8232e(@NotNull SoundEvent soundEvent) {
        ObjectIterator it = f7911h.entrySet().iterator();
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
