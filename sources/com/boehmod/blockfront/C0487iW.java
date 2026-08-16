package com.boehmod.blockfront;

import foundry.veil.api.client.render.light.data.PointLightData;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iW.class */
public class C0487iW {

    /* JADX INFO: renamed from: hn */
    private static final float f2972hn = 12.0f;

    /* JADX INFO: renamed from: ho */
    private static final float f2973ho = 8.0f;

    /* JADX INFO: renamed from: hp */
    private static final float f2974hp = 96.0f;

    /* JADX INFO: renamed from: hq */
    private static final float f2975hq = 2.0f;

    /* JADX INFO: renamed from: hr */
    private static final float f2976hr = 1.0f;

    /* JADX INFO: renamed from: hs */
    private static final float f2977hs = 0.0f;

    /* JADX INFO: renamed from: ht */
    private static final float f2978ht = 16.0f;

    /* JADX INFO: renamed from: lm */
    private static final int f2979lm = 3;

    /* JADX INFO: renamed from: ln */
    private static final int f2980ln = 2;

    /* JADX INFO: renamed from: lo */
    private static final int f2981lo = 6;

    /* JADX INFO: renamed from: hu */
    private static final float f2982hu = 0.2f;

    /* JADX INFO: renamed from: hv */
    private static final float f2983hv = 0.25f;

    /* JADX INFO: renamed from: hw */
    private static final float f2984hw = 0.02f;

    /* JADX INFO: renamed from: lp */
    private static final int f2985lp = 2;

    /* JADX INFO: renamed from: hx */
    private static final float f2986hx = 0.5f;

    /* JADX INFO: renamed from: hy */
    private static final float f2987hy = 0.99f;

    /* JADX INFO: renamed from: hz */
    private static final float f2988hz = 0.02f;

    /* JADX INFO: renamed from: v */
    @NotNull
    private static final Vec3 f2989v = new Vec3(1.75d, -0.20000000298023224d, 0.0d);

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final Int2ObjectMap<a> f2990c = new Int2ObjectOpenHashMap();

    /* JADX INFO: renamed from: hA */
    private static final float f2991hA = 12.0f;

    /* JADX INFO: renamed from: hB */
    private static final float f2992hB = 32.0f;

    /* JADX INFO: renamed from: a */
    private static boolean m2194a(int i, long j, @NotNull C1193vm c1193vm) {
        if (!c1193vm.m6792cS()) {
            return true;
        }
        a aVar = (a) f2990c.get(i);
        int iM6794cu = c1193vm.m6794cu();
        if (aVar == null || j - aVar.f2994m > iM6794cu) {
            f2990c.put(i, new a(j, true));
            return true;
        }
        boolean z = aVar.f2995dm;
        aVar.f2995dm = !z;
        aVar.f2994m = j;
        return !z;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.iW$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iW$a.class */
    private static final class a {

        /* JADX INFO: renamed from: m */
        long f2994m;

        /* JADX INFO: renamed from: dm */
        boolean f2995dm;

        a(long j, boolean z) {
            this.f2994m = j;
            this.f2995dm = z;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2195a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull C1117uP c1117uP, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull ItemStack itemStack) {
        List objectArrayList;
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        C0486iV.m2177a(c1117uP);
        if (Minecraft.useFancyGraphics()) {
            switch (c1117uP.m6391aB()) {
                case "default":
                    C0461hx.f2881S.add(new C0036aF.c(random, 4));
                    break;
                case "fire":
                    C0461hx.f2881S.add(new C0036aF.b(4, random));
                    break;
            }
        }
        m2197a(minecraft, c0623l, c0396gl, localPlayer, clientLevel, itemStack, c1117uP, localPlayer.getEyePosition(), true, !C0486iV.m2180Z(), false, 0);
        C1199vs c1199vsM6317b = c1117uP.m6317b();
        long gameTime = clientLevel.getGameTime();
        if (c1199vsM6317b.m6877a() == EnumC1201vu.ENTITY) {
            objectArrayList = List.of();
        } else {
            minecraft.crosshairPickEntity = null;
            long jM6413a = C1121uT.m6413a(localPlayer.getUUID(), gameTime);
            int iM6878cx = c1199vsM6317b.m6878cx();
            objectArrayList = new ObjectArrayList(iM6878cx);
            for (int i = 0; i < iM6878cx; i++) {
                RandomSource randomSourceCreate = RandomSource.create(jM6413a + ((long) i));
                C1183vc c1183vcM2873a = c0623l.m2873a(minecraft, c0396gl, c1117uP.m6369a());
                c1183vcM2873a.mo6713a(c0623l, clientLevel, randomSourceCreate, random, localPlayer, c1117uP, c1199vsM6317b, gameTime, jM6413a + ((long) i), i);
                objectArrayList.add(new C1120uS(i, List.copyOf(c1183vcM2873a.m6710aO()), List.copyOf(c1183vcM2873a.m6709aN())));
            }
        }
        C1169vO.m6648c(new C1218wK(localPlayer.getEyePosition(), new Vec2(localPlayer.getXRot(), localPlayer.getYRot()), C1129ub.f6190nr, C0120bk.f806cn, gameTime, objectArrayList));
        C0120bk.m428a(c1117uP.m6395a());
        C1117uP.f6060uc = 40;
        if (C0394gj.m1883b(localPlayer) && (abstractC0864pcM2878a = c0623l.m2878a()) != null) {
            float fM6393bD = c1117uP.m6393bD();
            switch (c1117uP.m6394a()) {
                case ANY:
                    abstractC0864pcM2878a.m4116k(fM6393bD);
                    break;
                case BIPOD_ONLY:
                    abstractC0864pcM2878a.m4116k(fM6393bD * C0112bc.f744bB);
                    break;
                case NO_BIPOD_ONLY:
                    abstractC0864pcM2878a.m4116k(fM6393bD * (1.0f - C0112bc.f744bB));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2196a(@Nullable C0394gj c0394gj, @NotNull C1198vr c1198vr, @NotNull Vec3 vec3, @Nullable Entity entity, boolean z, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, int i, float f) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6806r;
        C0516iz c0516iz;
        if ((z || f >= 0.02f) && (deferredHolderM6806r = c1198vr.m6806r()) != null) {
            SoundEvent soundEvent = (SoundEvent) deferredHolderM6806r.get();
            if (z) {
                c0516iz = new C0516iz(soundEvent, SoundSource.MASTER, SoundInstance.Attenuation.NONE, f, f2987hy + (0.02f * randomSource.nextFloat()), randomSource, 0.0d, 0.0d, 0.0d);
            } else {
                c0516iz = new C0516iz(soundEvent, SoundSource.PLAYERS, SoundInstance.Attenuation.LINEAR, f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
            }
            if (c0394gj != null) {
                C0516iz c0516izM1877a = c0394gj.m1877a();
                if (c0516izM1877a != null) {
                    c0516izM1877a.m2294ba();
                }
                c0394gj.m1878a(c0516iz);
            }
            if (entity instanceof C0756na) {
                C0756na c0756na = (C0756na) entity;
                C0516iz c0516izM3517a = c0756na.m3517a();
                if (c0516izM3517a != null) {
                    if (c0516izM3517a instanceof C0516iz) {
                        c0516izM3517a.m2294ba();
                    } else {
                        soundManager.stop(c0516izM3517a);
                    }
                }
                c0756na.m3518a((AbstractSoundInstance) c0516iz);
            }
            m2207a(soundManager, c0516iz, z, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2197a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull ItemStack itemStack, @NotNull C1117uP c1117uP, @NotNull Vec3 vec3, boolean z, boolean z2, boolean z3, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6812u;
        SimpleSoundInstance simpleSoundInstance;
        SoundManager soundManager = minecraft.getSoundManager();
        RandomSource randomSourceCreate = RandomSource.create();
        LocalPlayer entity = clientLevel.getEntity(i);
        if (entity != null || z) {
            if (z && !minecraft.options.getCameraType().isFirstPerson()) {
                z = false;
                entity = minecraft.player;
            }
            LocalPlayer localPlayer2 = entity != null ? entity : localPlayer;
            C1193vm c1193vmM6373a = c1117uP.m6373a();
            if (clientLevel.getBrightness(LightLayer.SKY, BlockPos.containing(vec3)) * clientLevel.getSkyDarken(1.0f) <= 12.0f && m2194a(localPlayer2.getId(), clientLevel.getGameTime(), c1193vmM6373a)) {
                Vec3 vec3Add = vec3.add(new Vec3(1.5d, 0.0d, 0.0d).zRot((entity != null ? entity.getXRot() : localPlayer.getXRot()) * 0.017453292f).yRot((-((entity != null ? entity.getYHeadRot() : localPlayer.getYHeadRot()) + 90.0f)) * 0.017453292f));
                float fNextFloat = randomSourceCreate.nextFloat();
                int color = c1193vmM6373a.getColor();
                boolean z4 = C0549jf.f3274dw;
                C0401gq.m1906a(new PointLightData().setOcclusionEnabled(z4).setPosition(vec3Add.x, vec3Add.y, vec3Add.z).setBrightness(c1193vmM6373a.m6789bM() * fNextFloat).setRadius(c1193vmM6373a.m6787bL()).setColor(color), 1);
                C0401gq.m1906a(new PointLightData().setOcclusionEnabled(z4).setPosition(vec3Add.x, vec3Add.y, vec3Add.z).setBrightness(c1193vmM6373a.m6785bK() * fNextFloat).setRadius(c1193vmM6373a.m6783bJ()).setColor(color), 1);
            }
            if (!z3 && c1117uP.m6389cJ()) {
                m2198a(minecraft, c0623l, localPlayer, clientLevel, (Entity) entity);
            }
            if (entity != null) {
                vec3 = vec3.add(f2989v.zRot(((entity.getXRot() + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-(entity.getYHeadRot() + 15.0f)) * 0.017453292f) - 1.5707964f));
            }
            C0394gj c0394gjM1885a = null;
            if (entity instanceof Player) {
                c0394gjM1885a = (C0394gj) c0396gl.m1150a((Player) entity);
                c0394gjM1885a.f1414pg = 1.0f;
                c0394gjM1885a.m1855l(20);
            } else if (z) {
                c0394gjM1885a = c0396gl.m1885a(minecraft);
                c0394gjM1885a.f1414pg = 1.0f;
                c0394gjM1885a.m1855l(20);
            }
            C0508ir c0508irM2869a = c0623l.m2869a();
            C1198vr c1198vrM6384a = c1117uP.m6384a(itemStack);
            float fDistanceTo = (float) vec3.distanceTo(localPlayer.getEyePosition());
            int iM7191d = z ? 0 : C1270xJ.m7191d(fDistanceTo);
            float fM7189i = z ? 1.0f : 2.0f * C1270xJ.m7189i(0.0f, 16.0f, fDistanceTo) * 0.25f;
            float fMin = 12.0f * Math.min(0.8f, C1270xJ.m7189i(8.0f, f2974hp, fDistanceTo));
            boolean zM4352a = C0875pn.m4352a((Level) clientLevel, (int) vec3.x, (int) vec3.z, Mth.floor(((float) vec3.y) + 1.0f));
            boolean z5 = false;
            if (z) {
                zM4352a = c0508irM2869a.m2289O() <= 0.4f;
                z5 = c0508irM2869a.m2290P() >= 0.5f;
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6848O = c1198vrM6384a.m6848O();
                if (deferredHolderM6848O != null) {
                    minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6848O.get(), 1.0f, 1.0f));
                }
            }
            if (c1117uP.m6390cK()) {
                m2199a(minecraft, c0394gjM1885a, c1198vrM6384a, localPlayer, vec3, z, soundManager, randomSourceCreate, entity, fM7189i, fMin, iM7191d, zM4352a, z5);
            }
            m2196a(c0394gjM1885a, c1198vrM6384a, vec3, (Entity) entity, z, soundManager, randomSourceCreate, iM7191d, fM7189i);
            if (z2 && ((z || fM7189i >= 0.02f) && (deferredHolderM6812u = c1198vrM6384a.m6812u()) != null)) {
                SoundEvent soundEvent = (SoundEvent) deferredHolderM6812u.get();
                if (z) {
                    simpleSoundInstance = SimpleSoundInstance.forUI(soundEvent, 1.0f, 1.0f);
                } else {
                    simpleSoundInstance = new SimpleSoundInstance(soundEvent, SoundSource.PLAYERS, fM7189i, 1.0f, randomSourceCreate, vec3.x, vec3.y, vec3.z);
                }
                soundManager.playDelayed(simpleSoundInstance, 1);
            }
            if (entity != null && !z && fDistanceTo <= f2992hB) {
                c1117uP.m6355a(c1198vrM6384a, minecraft, clientLevel, entity.getEyePosition(), entity.getYRot());
            }
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6848O2 = c1198vrM6384a.m6848O();
            if (entity != null && deferredHolderM6848O2 != null && !z && fM7189i >= 0.02f) {
                Vec3 eyePosition = entity.getEyePosition();
                clientLevel.playLocalSound(eyePosition.x, eyePosition.y, eyePosition.z, (SoundEvent) deferredHolderM6848O2.get(), SoundSource.PLAYERS, fM7189i, 1.0f, false);
            }
            Entity vehicle = localPlayer.getVehicle();
            if (vehicle instanceof AbstractC0750nU) {
                AbstractC0750nU abstractC0750nU = (AbstractC0750nU) vehicle;
                if (z || (entity != null && vehicle.hasPassenger(entity))) {
                    C0755nZ c0755nZM3472a = abstractC0750nU.m3472a((Entity) (z ? localPlayer : entity));
                    if (c0755nZM3472a != null && c0755nZM3472a.f4184fJ) {
                        float fNextFloat2 = 0.8f + (0.4f * randomSourceCreate.nextFloat());
                        soundManager.playDelayed(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f8382xn.get(), fNextFloat2, 0.2f), 8);
                        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6833G = c1198vrM6384a.m6833G();
                        if (deferredHolderM6833G != null) {
                            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6833G.get(), fNextFloat2, fM7189i));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2198a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @Nullable Entity entity) {
        Vec3 eyePosition = entity != null ? entity.getEyePosition() : localPlayer.getEyePosition();
        float yHeadRot = entity != null ? entity.getYHeadRot() : localPlayer.getYHeadRot();
        float xRot = entity != null ? entity.getXRot() : localPlayer.getXRot();
        for (int i = 0; i < 6; i++) {
            Vec3 vec3Add = eyePosition.add(new Vec3(1.4f + (0.85f * i), 0.0d, 0.0d).zRot(((xRot + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-yHeadRot) * 0.017453292f) - 1.5707964f));
            C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7866nC.get(), vec3Add.x, vec3Add.y, vec3Add.z, 0.0d, 0.0d, 0.0d);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2199a(@Nonnull Minecraft minecraft, @Nullable C0394gj c0394gj, @NotNull C1198vr c1198vr, @NotNull LocalPlayer localPlayer, @NotNull Vec3 vec3, boolean z, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, @Nullable Entity entity, float f, float f2, int i, boolean z2, boolean z3) {
        int iMax;
        m2202a(entity, c0394gj, c1198vr, vec3, soundManager, randomSource, f, f2, i, z, z2, z3);
        m2203a(c1198vr, vec3, z, soundManager, randomSource, f, f2, i);
        m2201a(soundManager, randomSource, vec3, z, f, i);
        if (z) {
            m2200a(soundManager, c1198vr, randomSource);
        }
        if (entity != null && !z) {
            m2206a(minecraft, c1198vr, localPlayer, vec3, soundManager, randomSource, entity, f2, i);
        } else {
            m2204a(c1198vr, soundManager, f, z, i);
            m2205a(c1198vr, soundManager, randomSource, f, z, i);
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6836I = c1198vr.m6836I();
        if (!z && deferredHolderM6836I != null && (iMax = Math.max(0, i - 1)) > 0) {
            m2207a(soundManager, new SimpleSoundInstance((SoundEvent) deferredHolderM6836I.get(), SoundSource.PLAYERS, f2, 0.95f + (0.05f * randomSource.nextFloat()), randomSource, vec3.x, vec3.y, vec3.z), false, iMax);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2200a(@NotNull SoundManager soundManager, @NotNull C1198vr c1198vr, @NotNull RandomSource randomSource) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6844M = c1198vr.m6844M();
        if (deferredHolderM6844M == null) {
            return;
        }
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6844M.get(), 0.9f + (0.2f * randomSource.nextFloat()), 0.25f));
    }

    /* JADX INFO: renamed from: a */
    private static void m2201a(@NotNull SoundManager soundManager, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, boolean z, float f, int i) {
        if (z) {
            for (int i2 = 0; i2 < 3; i2++) {
                m2207a(soundManager, SimpleSoundInstance.forUI((SoundEvent) C1312xz.f8277vm.get(), 1.0f, 1.0f), true, 0);
            }
            return;
        }
        if (f >= 0.02f) {
            float fNextFloat = 0.9f + (0.1f * randomSource.nextFloat());
            for (int i3 = 0; i3 < 2; i3++) {
                m2207a(soundManager, new SimpleSoundInstance((SoundEvent) C1312xz.f8276vl.get(), SoundSource.PLAYERS, f * 2.5f, fNextFloat, randomSource, vec3.x, vec3.y, vec3.z), false, i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2202a(@Nullable Entity entity, @Nullable C0394gj c0394gj, @NotNull C1198vr c1198vr, @NotNull Vec3 vec3, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, float f, float f2, int i, boolean z, boolean z2, boolean z3) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6830E;
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6825B;
        float fNextInt = 0.85f + (0.03f * randomSource.nextInt(5));
        if (!z && f2 > 0.0f) {
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6826C = z2 ? c1198vr.m6826C() : c1198vr.m6823A();
            if (deferredHolderM6826C != null) {
                m2207a(soundManager, new SimpleSoundInstance((SoundEvent) deferredHolderM6826C.get(), SoundSource.PLAYERS, f2, fNextInt, randomSource, vec3.x, vec3.y, vec3.z), false, i);
            }
            if (!z2 && (deferredHolderM6825B = c1198vr.m6825B()) != null) {
                SimpleSoundInstance simpleSoundInstanceForUI = SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6825B.get(), 1.0f, f2 / 12.0f);
                if (c0394gj != null) {
                    SimpleSoundInstance simpleSoundInstanceM1881b = c0394gj.m1881b();
                    if (simpleSoundInstanceM1881b != null) {
                        C0115bf.m422a(new C0503im(i, simpleSoundInstanceM1881b));
                    }
                    c0394gj.m1882b(simpleSoundInstanceForUI);
                }
                m2207a(soundManager, simpleSoundInstanceForUI, false, i);
            }
        }
        if (f > 0.02f || z) {
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6835H = z3 ? c1198vr.m6835H() : c1198vr.m6833G();
            if (z2) {
                deferredHolderM6830E = z ? deferredHolderM6835H : c1198vr.m6832F();
            } else {
                deferredHolderM6830E = z ? c1198vr.m6830E() : c1198vr.m6828D();
            }
            DeferredHolder<SoundEvent, SoundEvent> deferredHolder = deferredHolderM6830E;
            if (deferredHolder != null) {
                SimpleSoundInstance simpleSoundInstance = new SimpleSoundInstance((SoundEvent) deferredHolder.get(), SoundSource.PLAYERS, f, fNextInt, randomSource, vec3.x, vec3.y, vec3.z);
                if (c0394gj != null) {
                    SimpleSoundInstance simpleSoundInstanceM1879a = c0394gj.m1879a();
                    if (simpleSoundInstanceM1879a != null) {
                        C0115bf.m422a(new C0503im(i, simpleSoundInstanceM1879a));
                    }
                    c0394gj.m1880a(simpleSoundInstance);
                }
                if (entity instanceof C0756na) {
                    C0756na c0756na = (C0756na) entity;
                    SimpleSoundInstance simpleSoundInstanceM3519a = c0756na.m3519a();
                    if (simpleSoundInstanceM3519a != null) {
                        C0115bf.m422a(new C0503im(i, simpleSoundInstanceM3519a));
                    }
                    c0756na.m3520a(simpleSoundInstance);
                }
                m2207a(soundManager, simpleSoundInstance, z, i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2203a(@NotNull C1198vr c1198vr, @NotNull Vec3 vec3, boolean z, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, float f, float f2, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6821z;
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6819y;
        if (z && (deferredHolderM6819y = c1198vr.m6819y()) != null) {
            SoundEvent soundEvent = (SoundEvent) deferredHolderM6819y.get();
            for (int i2 = 0; i2 < 2; i2++) {
                m2207a(soundManager, SimpleSoundInstance.forUI(soundEvent, 1.0f, f), true, i);
            }
        }
        if (!z && f2 > 0.0f && (deferredHolderM6821z = c1198vr.m6821z()) != null) {
            m2207a(soundManager, new SimpleSoundInstance((SoundEvent) deferredHolderM6821z.get(), SoundSource.PLAYERS, f2, 1.0f, randomSource, vec3.x, vec3.y, vec3.z), false, i);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2204a(@NotNull C1198vr c1198vr, @NotNull SoundManager soundManager, float f, boolean z, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6838J;
        if (f > 0.0f && (deferredHolderM6838J = c1198vr.m6838J()) != null) {
            m2207a(soundManager, SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6838J.get(), 1.0f, f), z, i);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2205a(@NotNull C1198vr c1198vr, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, float f, boolean z, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6846N;
        if (f > 0.0f && (deferredHolderM6846N = c1198vr.m6846N()) != null) {
            m2207a(soundManager, SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6846N.get(), 0.95f + (0.1f * randomSource.nextFloat()), f), z, i);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2206a(@Nonnull Minecraft minecraft, @NotNull C1198vr c1198vr, @NotNull LocalPlayer localPlayer, @NotNull Vec3 vec3, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, @NotNull Entity entity, float f, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6842L;
        if (Minecraft.useFancyGraphics() && localPlayer.hasLineOfSight(entity) && (deferredHolderM6842L = c1198vr.m6842L()) != null) {
            m2207a(soundManager, new SimpleSoundInstance((SoundEvent) deferredHolderM6842L.get(), SoundSource.PLAYERS, f * C0875pn.m4484a(entity, minecraft.gameRenderer.getMainCamera()), 1.0f, randomSource, vec3.x, vec3.y, vec3.z), false, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2207a(@NotNull SoundManager soundManager, @NotNull AbstractSoundInstance abstractSoundInstance, boolean z, int i) {
        if (z || i <= 0) {
            soundManager.play(abstractSoundInstance);
        } else {
            soundManager.playDelayed(abstractSoundInstance, i);
        }
    }
}
