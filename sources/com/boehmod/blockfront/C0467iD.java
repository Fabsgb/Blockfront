package com.boehmod.blockfront;

import com.boehmod.blockfront.C0080ay;
import foundry.veil.api.client.render.light.data.PointLightData;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
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
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iD.class */
public class C0467iD {

    /* JADX INFO: renamed from: gR */
    private static final float f2883gR = 12.0f;

    /* JADX INFO: renamed from: gS */
    private static final float f2884gS = 8.0f;

    /* JADX INFO: renamed from: gT */
    private static final float f2885gT = 96.0f;

    /* JADX INFO: renamed from: gU */
    private static final float f2886gU = 2.0f;

    /* JADX INFO: renamed from: gV */
    private static final float f2887gV = 1.0f;

    /* JADX INFO: renamed from: gW */
    private static final float f2888gW = 0.0f;

    /* JADX INFO: renamed from: gX */
    private static final float f2889gX = 16.0f;

    /* JADX INFO: renamed from: jG */
    private static final int f2890jG = 2;

    /* JADX INFO: renamed from: jH */
    private static final int f2891jH = 2;

    /* JADX INFO: renamed from: jI */
    private static final int f2892jI = 6;

    /* JADX INFO: renamed from: gY */
    private static final float f2893gY = 0.2f;

    /* JADX INFO: renamed from: gZ */
    private static final float f2894gZ = 0.25f;

    /* JADX INFO: renamed from: ha */
    private static final float f2895ha = 0.02f;

    /* JADX INFO: renamed from: jJ */
    private static final int f2896jJ = 2;

    /* JADX INFO: renamed from: hb */
    private static final float f2897hb = 0.5f;

    /* JADX INFO: renamed from: hc */
    private static final float f2898hc = 0.99f;

    /* JADX INFO: renamed from: hd */
    private static final float f2899hd = 0.02f;

    /* JADX INFO: renamed from: v */
    @NotNull
    private static final Vec3 f2900v = new Vec3(1.75d, -0.20000000298023224d, 0.0d);

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final Int2ObjectMap<a> f2901b = new Int2ObjectOpenHashMap();

    /* JADX INFO: renamed from: he */
    private static final float f2902he = 12.0f;

    /* JADX INFO: renamed from: hf */
    private static final float f2903hf = 32.0f;

    /* JADX INFO: renamed from: a */
    private static boolean m2102a(int i, long j, @NotNull C1113uM c1113uM) {
        if (!c1113uM.m6139cJ()) {
            return true;
        }
        a aVar = (a) f2901b.get(i);
        int iM6141ce = c1113uM.m6141ce();
        if (aVar == null || j - aVar.f2905h > iM6141ce) {
            f2901b.put(i, new a(j, true));
            return true;
        }
        boolean z = aVar.f2906dc;
        aVar.f2906dc = !z;
        aVar.f2905h = j;
        return !z;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.iD$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iD$a.class */
    private static final class a {

        /* JADX INFO: renamed from: h */
        long f2905h;

        /* JADX INFO: renamed from: dc */
        boolean f2906dc;

        a(long j, boolean z) {
            this.f2905h = j;
            this.f2906dc = z;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2103a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull C1144ur c1144ur, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull ItemStack itemStack) {
        AbstractC0788oG<?, ?> abstractC0788oGM2692a;
        C1144ur.m6302b(itemStack, C1144ur.m6301a(itemStack) - c1144ur.m6376bY());
        if (Minecraft.useFancyGraphics()) {
            switch (c1144ur.m6413au()) {
                case "default":
                    C0444hh.f2829P.add(new C0080ay.c(random, 4));
                    break;
                case "fire":
                    C0444hh.f2829P.add(new C0080ay.b(4, random));
                    break;
            }
        }
        m2105a(minecraft, c0622l, c0326fV, localPlayer, clientLevel, itemStack, c1144ur, localPlayer.getEyePosition(), true, C1144ur.m6301a(itemStack) <= 0, false, 0);
        C1119uS c1119uSM6347a = c1144ur.m6347a();
        if (c1119uSM6347a.m6224a() == EnumC1121uU.ENTITY) {
            C1194vo.m6653c(new C1201vv());
        } else {
            minecraft.crosshairPickEntity = null;
            RandomSource randomSource = clientLevel.random;
            int gameTime = (int) clientLevel.getGameTime();
            long jNextLong = randomSource.nextLong();
            int iM6225ch = c1119uSM6347a.m6225ch();
            for (int i = 0; i < iM6225ch; i++) {
                c0622l.m2687a(minecraft, c0326fV, c1144ur.m6394a()).mo6062a(c0622l, clientLevel, RandomSource.create(jNextLong + ((long) i)), random, localPlayer, c1144ur, gameTime, jNextLong + ((long) i), i);
            }
        }
        C0111bc.m335a(c1144ur.m6417a());
        C1144ur.f5991rW = 40;
        if (C0324fT.m1673b(localPlayer) && (abstractC0788oGM2692a = c0622l.m2692a()) != null) {
            float fM6415bx = c1144ur.m6415bx();
            switch (c1144ur.m6416a()) {
                case ANY:
                    abstractC0788oGM2692a.m3680l(fM6415bx);
                    break;
                case BIPOD_ONLY:
                    abstractC0788oGM2692a.m3680l(fM6415bx * C0050aU.f330bv);
                    break;
                case NO_BIPOD_ONLY:
                    abstractC0788oGM2692a.m3680l(fM6415bx * (1.0f - C0050aU.f330bv));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2104a(@Nullable C0324fT c0324fT, @NotNull C1118uR c1118uR, @NotNull Vec3 vec3, @Nullable Entity entity, boolean z, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, int i, float f) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6153r;
        C0498ii c0498ii;
        if ((z || f >= 0.02f) && (deferredHolderM6153r = c1118uR.m6153r()) != null) {
            SoundEvent soundEvent = (SoundEvent) deferredHolderM6153r.get();
            if (z) {
                c0498ii = new C0498ii(soundEvent, SoundSource.MASTER, SoundInstance.Attenuation.NONE, f, f2898hc + (0.02f * randomSource.nextFloat()), randomSource, 0.0d, 0.0d, 0.0d);
            } else {
                c0498ii = new C0498ii(soundEvent, SoundSource.PLAYERS, SoundInstance.Attenuation.LINEAR, f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
            }
            if (c0324fT != null) {
                C0498ii c0498iiM1667a = c0324fT.m1667a();
                if (c0498iiM1667a != null) {
                    c0498iiM1667a.m2239aS();
                }
                c0324fT.m1668a(c0498ii);
            }
            if (entity instanceof C0680mE) {
                C0680mE c0680mE = (C0680mE) entity;
                C0498ii c0498iiM3009a = c0680mE.m3009a();
                if (c0498iiM3009a != null) {
                    if (c0498iiM3009a instanceof C0498ii) {
                        c0498iiM3009a.m2239aS();
                    } else {
                        soundManager.stop(c0498iiM3009a);
                    }
                }
                c0680mE.m3010a((AbstractSoundInstance) c0498ii);
            }
            m2115a(soundManager, c0498ii, z, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2105a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull ItemStack itemStack, @NotNull C1144ur c1144ur, @NotNull Vec3 vec3, boolean z, boolean z2, boolean z3, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6159u;
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
            C1113uM c1113uMM6398a = c1144ur.m6398a();
            if (clientLevel.getBrightness(LightLayer.SKY, BlockPos.containing(vec3)) * clientLevel.getSkyDarken(1.0f) <= 12.0f && m2102a(localPlayer2.getId(), clientLevel.getGameTime(), c1113uMM6398a)) {
                Vec3 vec3Add = vec3.add(new Vec3(1.5d, 0.0d, 0.0d).zRot((entity != null ? entity.getXRot() : localPlayer.getXRot()) * 0.017453292f).yRot((-((entity != null ? entity.getYHeadRot() : localPlayer.getYHeadRot()) + 90.0f)) * 0.017453292f));
                float fNextFloat = randomSourceCreate.nextFloat();
                int color = c1113uMM6398a.getColor();
                boolean z4 = C0476iM.f2924dl;
                C0384ga.m1842a(new PointLightData().setOcclusionEnabled(z4).setPosition(vec3Add.x, vec3Add.y, vec3Add.z).setBrightness(c1113uMM6398a.m6136bG() * fNextFloat).setRadius(c1113uMM6398a.m6134bF()).setColor(color), 1);
                C0384ga.m1842a(new PointLightData().setOcclusionEnabled(z4).setPosition(vec3Add.x, vec3Add.y, vec3Add.z).setBrightness(c1113uMM6398a.m6132bE() * fNextFloat).setRadius(c1113uMM6398a.m6130bD()).setColor(color), 1);
            }
            if (!z3 && c1144ur.m6411cA()) {
                m2106a(minecraft, c0622l, localPlayer, clientLevel, (Entity) entity);
            }
            if (entity != null) {
                vec3 = vec3.add(f2900v.zRot(((entity.getXRot() + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-(entity.getYHeadRot() + 15.0f)) * 0.017453292f) - 1.5707964f));
            }
            C0324fT c0324fTM1675a = null;
            if (entity instanceof Player) {
                c0324fTM1675a = (C0324fT) c0326fV.m1133a((Player) entity);
                c0324fTM1675a.f1492oi = 1.0f;
                c0324fTM1675a.m1645l(20);
            } else if (z) {
                c0324fTM1675a = c0326fV.m1675a(minecraft);
                c0324fTM1675a.f1492oi = 1.0f;
                c0324fTM1675a.m1645l(20);
            }
            C0490ia c0490iaM2683a = c0622l.m2683a();
            C1118uR c1118uRM6408a = c1144ur.m6408a(itemStack);
            float fDistanceTo = (float) vec3.distanceTo(localPlayer.getEyePosition());
            int iM7864c = z ? 0 : C1290xm.m7864c(fDistanceTo);
            float fM7862h = z ? 1.0f : 2.0f * C1290xm.m7862h(0.0f, 16.0f, fDistanceTo) * 0.25f;
            float fMin = 12.0f * Math.min(0.8f, C1290xm.m7862h(8.0f, f2885gT, fDistanceTo));
            boolean zM3916a = C0799oR.m3916a((Level) clientLevel, (int) vec3.x, (int) vec3.z, Mth.floor(((float) vec3.y) + 1.0f));
            boolean z5 = false;
            if (z) {
                zM3916a = c0490iaM2683a.m2234O() <= 0.4f;
                z5 = c0490iaM2683a.m2235P() >= 0.5f;
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6195O = c1118uRM6408a.m6195O();
                if (deferredHolderM6195O != null) {
                    minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6195O.get(), 1.0f, 1.0f));
                }
            }
            if (c1144ur.m6412cB()) {
                m2107a(minecraft, c0324fTM1675a, c1118uRM6408a, localPlayer, vec3, z, soundManager, randomSourceCreate, entity, fM7862h, fMin, iM7864c, zM3916a, z5);
            }
            m2104a(c0324fTM1675a, c1118uRM6408a, vec3, (Entity) entity, z, soundManager, randomSourceCreate, iM7864c, fM7862h);
            if (z2 && ((z || fM7862h >= 0.02f) && (deferredHolderM6159u = c1118uRM6408a.m6159u()) != null)) {
                SoundEvent soundEvent = (SoundEvent) deferredHolderM6159u.get();
                if (z) {
                    simpleSoundInstance = SimpleSoundInstance.forUI(soundEvent, 1.0f, 1.0f);
                } else {
                    simpleSoundInstance = new SimpleSoundInstance(soundEvent, SoundSource.PLAYERS, fM7862h, 1.0f, randomSourceCreate, vec3.x, vec3.y, vec3.z);
                }
                soundManager.playDelayed(simpleSoundInstance, 1);
            }
            if (entity != null && !z && fDistanceTo <= f2903hf) {
                c1144ur.m6381a(c1118uRM6408a, minecraft, clientLevel, entity.getEyePosition(), entity.getYRot());
            }
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6195O2 = c1118uRM6408a.m6195O();
            if (entity != null && deferredHolderM6195O2 != null && !z && fM7862h >= 0.02f) {
                Vec3 eyePosition = entity.getEyePosition();
                clientLevel.playLocalSound(eyePosition.x, eyePosition.y, eyePosition.z, (SoundEvent) deferredHolderM6195O2.get(), SoundSource.PLAYERS, fM7862h, 1.0f, false);
            }
            Entity vehicle = localPlayer.getVehicle();
            if (vehicle instanceof AbstractC0779ny) {
                AbstractC0779ny abstractC0779ny = (AbstractC0779ny) vehicle;
                if (z || (entity != null && vehicle.hasPassenger(entity))) {
                    C0732nD c0732nDM3535a = abstractC0779ny.m3535a((Entity) (z ? localPlayer : entity));
                    if (c0732nDM3535a != null && c0732nDM3535a.f3936fp) {
                        float fNextFloat2 = 0.8f + (0.4f * randomSourceCreate.nextFloat());
                        soundManager.playDelayed(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7969xk.get(), fNextFloat2, 0.2f), 8);
                        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6180G = c1118uRM6408a.m6180G();
                        if (deferredHolderM6180G != null) {
                            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6180G.get(), fNextFloat2, fM7862h));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2106a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @Nullable Entity entity) {
        Vec3 eyePosition = entity != null ? entity.getEyePosition() : localPlayer.getEyePosition();
        float yHeadRot = entity != null ? entity.getYHeadRot() : localPlayer.getYHeadRot();
        float xRot = entity != null ? entity.getXRot() : localPlayer.getXRot();
        for (int i = 0; i < 6; i++) {
            Vec3 vec3Add = eyePosition.add(new Vec3(1.4f + (0.85f * i), 0.0d, 0.0d).zRot(((xRot + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-yHeadRot) * 0.017453292f) - 1.5707964f));
            C0470iG.m2126a(minecraft, c0622l, clientLevel, (SimpleParticleType) C1232wZ.f7301nC.get(), vec3Add.x, vec3Add.y, vec3Add.z, 0.0d, 0.0d, 0.0d);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2107a(@Nonnull Minecraft minecraft, @Nullable C0324fT c0324fT, @NotNull C1118uR c1118uR, @NotNull LocalPlayer localPlayer, @NotNull Vec3 vec3, boolean z, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, @Nullable Entity entity, float f, float f2, int i, boolean z2, boolean z3) {
        int iMax;
        m2110a(entity, c0324fT, c1118uR, vec3, soundManager, randomSource, f, f2, i, z, z2, z3);
        m2111a(c1118uR, vec3, z, soundManager, randomSource, f, f2, i);
        m2109a(soundManager, randomSource, vec3, z, f, i);
        if (z) {
            m2108a(soundManager, c1118uR, randomSource);
        }
        if (entity != null && !z) {
            m2114a(minecraft, c1118uR, localPlayer, vec3, soundManager, randomSource, entity, f2, i);
        } else {
            m2112a(c1118uR, soundManager, f, z, i);
            m2113a(c1118uR, soundManager, randomSource, f, z, i);
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6183I = c1118uR.m6183I();
        if (!z && deferredHolderM6183I != null && (iMax = Math.max(0, i - 1)) > 0) {
            m2115a(soundManager, new SimpleSoundInstance((SoundEvent) deferredHolderM6183I.get(), SoundSource.PLAYERS, f2, 0.95f + (0.05f * randomSource.nextFloat()), randomSource, vec3.x, vec3.y, vec3.z), false, iMax);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2108a(@NotNull SoundManager soundManager, @NotNull C1118uR c1118uR, @NotNull RandomSource randomSource) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6191M = c1118uR.m6191M();
        if (deferredHolderM6191M == null) {
            return;
        }
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6191M.get(), 0.9f + (0.2f * randomSource.nextFloat()), 0.25f));
    }

    /* JADX INFO: renamed from: a */
    private static void m2109a(@NotNull SoundManager soundManager, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, boolean z, float f, int i) {
        if (z) {
            for (int i2 = 0; i2 < 2; i2++) {
                m2115a(soundManager, SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7864vj.get(), 1.0f, 1.0f), true, 0);
            }
            return;
        }
        if (f >= 0.02f) {
            float fNextFloat = 0.9f + (0.1f * randomSource.nextFloat());
            for (int i3 = 0; i3 < 2; i3++) {
                m2115a(soundManager, new SimpleSoundInstance((SoundEvent) C1280xc.f7863vi.get(), SoundSource.PLAYERS, f * 2.5f, fNextFloat, randomSource, vec3.x, vec3.y, vec3.z), false, i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2110a(@Nullable Entity entity, @Nullable C0324fT c0324fT, @NotNull C1118uR c1118uR, @NotNull Vec3 vec3, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, float f, float f2, int i, boolean z, boolean z2, boolean z3) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6172B;
        float fNextInt = 0.85f + (0.03f * randomSource.nextInt(5));
        if (!z && f2 > 0.0f) {
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6173C = z2 ? c1118uR.m6173C() : c1118uR.m6170A();
            if (deferredHolderM6173C != null) {
                m2115a(soundManager, new SimpleSoundInstance((SoundEvent) deferredHolderM6173C.get(), SoundSource.PLAYERS, f2, fNextInt, randomSource, vec3.x, vec3.y, vec3.z), false, i);
            }
            if (!z2 && (deferredHolderM6172B = c1118uR.m6172B()) != null) {
                SimpleSoundInstance simpleSoundInstanceForUI = SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6172B.get(), 1.0f, f2 / 12.0f);
                if (c0324fT != null) {
                    SimpleSoundInstance simpleSoundInstanceM1671b = c0324fT.m1671b();
                    if (simpleSoundInstanceM1671b != null) {
                        C0053aX.m219a(new C0432hV(i, simpleSoundInstanceM1671b));
                    }
                    c0324fT.m1672b(simpleSoundInstanceForUI);
                }
                m2115a(soundManager, simpleSoundInstanceForUI, false, i);
            }
        }
        if (f > 0.02f || z) {
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6182H = z2 ? z ? z3 ? c1118uR.m6182H() : c1118uR.m6180G() : c1118uR.m6179F() : z ? c1118uR.m6177E() : c1118uR.m6175D();
            if (deferredHolderM6182H != null) {
                SimpleSoundInstance simpleSoundInstance = new SimpleSoundInstance((SoundEvent) deferredHolderM6182H.get(), SoundSource.PLAYERS, f, fNextInt, randomSource, vec3.x, vec3.y, vec3.z);
                if (c0324fT != null) {
                    SimpleSoundInstance simpleSoundInstanceM1669a = c0324fT.m1669a();
                    if (simpleSoundInstanceM1669a != null) {
                        C0053aX.m219a(new C0432hV(i, simpleSoundInstanceM1669a));
                    }
                    c0324fT.m1670a(simpleSoundInstance);
                }
                if (entity instanceof C0680mE) {
                    C0680mE c0680mE = (C0680mE) entity;
                    SimpleSoundInstance simpleSoundInstanceM3011a = c0680mE.m3011a();
                    if (simpleSoundInstanceM3011a != null) {
                        C0053aX.m219a(new C0432hV(i, simpleSoundInstanceM3011a));
                    }
                    c0680mE.m3012a(simpleSoundInstance);
                }
                m2115a(soundManager, simpleSoundInstance, z, i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2111a(@NotNull C1118uR c1118uR, @NotNull Vec3 vec3, boolean z, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, float f, float f2, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6168z;
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6166y;
        if (z && (deferredHolderM6166y = c1118uR.m6166y()) != null) {
            SoundEvent soundEvent = (SoundEvent) deferredHolderM6166y.get();
            for (int i2 = 0; i2 < 2; i2++) {
                m2115a(soundManager, SimpleSoundInstance.forUI(soundEvent, 1.0f, f), true, i);
            }
        }
        if (!z && f2 > 0.0f && (deferredHolderM6168z = c1118uR.m6168z()) != null) {
            m2115a(soundManager, new SimpleSoundInstance((SoundEvent) deferredHolderM6168z.get(), SoundSource.PLAYERS, f2, 1.0f, randomSource, vec3.x, vec3.y, vec3.z), false, i);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2112a(@NotNull C1118uR c1118uR, @NotNull SoundManager soundManager, float f, boolean z, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6185J;
        if (f > 0.0f && (deferredHolderM6185J = c1118uR.m6185J()) != null) {
            m2115a(soundManager, SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6185J.get(), 1.0f, f), z, i);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2113a(@NotNull C1118uR c1118uR, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, float f, boolean z, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6193N;
        if (f > 0.0f && (deferredHolderM6193N = c1118uR.m6193N()) != null) {
            m2115a(soundManager, SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6193N.get(), 0.9f + (0.2f * randomSource.nextFloat()), f), z, i);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2114a(@Nonnull Minecraft minecraft, @NotNull C1118uR c1118uR, @NotNull LocalPlayer localPlayer, @NotNull Vec3 vec3, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, @NotNull Entity entity, float f, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6189L;
        if (Minecraft.useFancyGraphics() && localPlayer.hasLineOfSight(entity) && (deferredHolderM6189L = c1118uR.m6189L()) != null) {
            m2115a(soundManager, new SimpleSoundInstance((SoundEvent) deferredHolderM6189L.get(), SoundSource.PLAYERS, f * C0799oR.m4048a(entity, minecraft.gameRenderer.getMainCamera()), 1.0f, randomSource, vec3.x, vec3.y, vec3.z), false, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2115a(@NotNull SoundManager soundManager, @NotNull AbstractSoundInstance abstractSoundInstance, boolean z, int i) {
        if (z || i <= 0) {
            soundManager.play(abstractSoundInstance);
        } else {
            soundManager.playDelayed(abstractSoundInstance, i);
        }
    }
}
