package com.boehmod.blockfront;

import com.boehmod.blockfront.C0027ay;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iD.class */
public class iD {
    private static final float gR = 12.0f;
    private static final float gS = 8.0f;
    private static final float gT = 96.0f;
    private static final float gU = 2.0f;
    private static final float gV = 1.0f;
    private static final float gW = 0.0f;
    private static final float gX = 16.0f;
    private static final int jG = 2;
    private static final int jH = 2;
    private static final int jI = 6;
    private static final float gY = 0.2f;
    private static final float gZ = 0.25f;
    private static final float ha = 0.02f;
    private static final int jJ = 2;
    private static final float hb = 0.5f;
    private static final float hc = 0.99f;
    private static final float hd = 0.02f;

    @NotNull
    private static final Vec3 v = new Vec3(1.75d, -0.20000000298023224d, 0.0d);

    @NotNull
    private static final Int2ObjectMap<a> b = new Int2ObjectOpenHashMap();
    private static final float he = 12.0f;
    private static final float hf = 32.0f;

    private static boolean a(int i, long j, @NotNull uM uMVar) {
        if (!uMVar.cJ()) {
            return true;
        }
        a aVar = (a) b.get(i);
        int iCe = uMVar.ce();
        if (aVar == null || j - aVar.h > iCe) {
            b.put(i, new a(j, true));
            return true;
        }
        boolean z = aVar.dc;
        aVar.dc = !z;
        aVar.h = j;
        return !z;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iD$a.class */
    private static final class a {
        long h;
        boolean dc;

        a(long j, boolean z) {
            this.h = j;
            this.dc = z;
        }
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull C0558ur c0558ur, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull ItemStack itemStack) {
        oG<?, ?> oGVarM593a;
        C0558ur.b(itemStack, C0558ur.a(itemStack) - c0558ur.bY());
        if (Minecraft.useFancyGraphics()) {
            switch (c0558ur.au()) {
                case "default":
                    C0198hh.P.add(new C0027ay.c(random, 4));
                    break;
                case "fire":
                    C0198hh.P.add(new C0027ay.b(4, random));
                    break;
            }
        }
        a(minecraft, c0297l, fVVar, localPlayer, clientLevel, itemStack, c0558ur, localPlayer.getEyePosition(), true, C0558ur.a(itemStack) <= 0, false, 0);
        uS uSVarM1210a = c0558ur.m1210a();
        if (uSVarM1210a.m1177a() == uU.ENTITY) {
            C0582vo.c(new C0589vv());
        } else {
            minecraft.crosshairPickEntity = null;
            RandomSource randomSource = clientLevel.random;
            int gameTime = (int) clientLevel.getGameTime();
            long jNextLong = randomSource.nextLong();
            int iCh = uSVarM1210a.ch();
            for (int i = 0; i < iCh; i++) {
                c0297l.a(minecraft, fVVar, c0558ur.m1216a()).a(c0297l, clientLevel, RandomSource.create(jNextLong + ((long) i)), random, localPlayer, c0558ur, gameTime, jNextLong + ((long) i), i);
            }
        }
        C0032bc.a(c0558ur.m1224a());
        C0558ur.rW = 40;
        if (fT.b(localPlayer) && (oGVarM593a = c0297l.m593a()) != null) {
            float fBx = c0558ur.bx();
            switch (c0558ur.m1223a()) {
                case ANY:
                    oGVarM593a.l(fBx);
                    break;
                case BIPOD_ONLY:
                    oGVarM593a.l(fBx * aU.bv);
                    break;
                case NO_BIPOD_ONLY:
                    oGVarM593a.l(fBx * (1.0f - aU.bv));
                    break;
            }
        }
    }

    private static void a(@Nullable fT fTVar, @NotNull uR uRVar, @NotNull Vec3 vec3, @Nullable Entity entity, boolean z, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, int i, float f) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderR;
        C0225ii c0225ii;
        if ((z || f >= 0.02f) && (deferredHolderR = uRVar.r()) != null) {
            SoundEvent soundEvent = (SoundEvent) deferredHolderR.get();
            if (z) {
                c0225ii = new C0225ii(soundEvent, SoundSource.MASTER, SoundInstance.Attenuation.NONE, f, hc + (0.02f * randomSource.nextFloat()), randomSource, 0.0d, 0.0d, 0.0d);
            } else {
                c0225ii = new C0225ii(soundEvent, SoundSource.PLAYERS, SoundInstance.Attenuation.LINEAR, f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
            }
            if (fTVar != null) {
                C0225ii c0225iiM402a = fTVar.m402a();
                if (c0225iiM402a != null) {
                    c0225iiM402a.aS();
                }
                fTVar.a(c0225ii);
            }
            if (entity instanceof mE) {
                mE mEVar = (mE) entity;
                C0225ii c0225iiM668a = mEVar.m668a();
                if (c0225iiM668a != null) {
                    if (c0225iiM668a instanceof C0225ii) {
                        c0225iiM668a.aS();
                    } else {
                        soundManager.stop(c0225iiM668a);
                    }
                }
                mEVar.a((AbstractSoundInstance) c0225ii);
            }
            a(soundManager, c0225ii, z, i);
        }
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull ItemStack itemStack, @NotNull C0558ur c0558ur, @NotNull Vec3 vec3, boolean z, boolean z2, boolean z3, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderU;
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
            uM uMVarM1218a = c0558ur.m1218a();
            if (clientLevel.getBrightness(LightLayer.SKY, BlockPos.containing(vec3)) * clientLevel.getSkyDarken(1.0f) <= 12.0f && a(localPlayer2.getId(), clientLevel.getGameTime(), uMVarM1218a)) {
                Vec3 vec3Add = vec3.add(new Vec3(1.5d, 0.0d, 0.0d).zRot((entity != null ? entity.getXRot() : localPlayer.getXRot()) * 0.017453292f).yRot((-((entity != null ? entity.getYHeadRot() : localPlayer.getYHeadRot()) + 90.0f)) * 0.017453292f));
                float fNextFloat = randomSourceCreate.nextFloat();
                int color = uMVarM1218a.getColor();
                boolean z4 = iM.dl;
                C0164ga.a(new PointLightData().setOcclusionEnabled(z4).setPosition(vec3Add.x, vec3Add.y, vec3Add.z).setBrightness(uMVarM1218a.bG() * fNextFloat).setRadius(uMVarM1218a.bF()).setColor(color), 1);
                C0164ga.a(new PointLightData().setOcclusionEnabled(z4).setPosition(vec3Add.x, vec3Add.y, vec3Add.z).setBrightness(uMVarM1218a.bE() * fNextFloat).setRadius(uMVarM1218a.bD()).setColor(color), 1);
            }
            if (!z3 && c0558ur.cA()) {
                a(minecraft, c0297l, localPlayer, clientLevel, (Entity) entity);
            }
            if (entity != null) {
                vec3 = vec3.add(v.zRot(((entity.getXRot() + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-(entity.getYHeadRot() + 15.0f)) * 0.017453292f) - 1.5707964f));
            }
            fT fTVarA = null;
            if (entity instanceof Player) {
                fTVarA = (fT) fVVar.a((Player) entity);
                fTVarA.oi = 1.0f;
                fTVarA.l(20);
            } else if (z) {
                fTVarA = fVVar.a(minecraft);
                fTVarA.oi = 1.0f;
                fTVarA.l(20);
            }
            C0218ia c0218iaM587a = c0297l.m587a();
            uR uRVarM1221a = c0558ur.m1221a(itemStack);
            float fDistanceTo = (float) vec3.distanceTo(localPlayer.getEyePosition());
            int iC = z ? 0 : C0634xm.c(fDistanceTo);
            float fH = z ? 1.0f : 2.0f * C0634xm.h(0.0f, 16.0f, fDistanceTo) * 0.25f;
            float fMin = 12.0f * Math.min(0.8f, C0634xm.h(8.0f, gT, fDistanceTo));
            boolean zA = oR.a((Level) clientLevel, (int) vec3.x, (int) vec3.z, Mth.floor(((float) vec3.y) + 1.0f));
            boolean z5 = false;
            if (z) {
                zA = c0218iaM587a.O() <= 0.4f;
                z5 = c0218iaM587a.P() >= 0.5f;
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderO = uRVarM1221a.O();
                if (deferredHolderO != null) {
                    minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderO.get(), 1.0f, 1.0f));
                }
            }
            if (c0558ur.cB()) {
                a(minecraft, fTVarA, uRVarM1221a, localPlayer, vec3, z, soundManager, randomSourceCreate, entity, fH, fMin, iC, zA, z5);
            }
            a(fTVarA, uRVarM1221a, vec3, (Entity) entity, z, soundManager, randomSourceCreate, iC, fH);
            if (z2 && ((z || fH >= 0.02f) && (deferredHolderU = uRVarM1221a.u()) != null)) {
                SoundEvent soundEvent = (SoundEvent) deferredHolderU.get();
                if (z) {
                    simpleSoundInstance = SimpleSoundInstance.forUI(soundEvent, 1.0f, 1.0f);
                } else {
                    simpleSoundInstance = new SimpleSoundInstance(soundEvent, SoundSource.PLAYERS, fH, 1.0f, randomSourceCreate, vec3.x, vec3.y, vec3.z);
                }
                soundManager.playDelayed(simpleSoundInstance, 1);
            }
            if (entity != null && !z && fDistanceTo <= hf) {
                c0558ur.a(uRVarM1221a, minecraft, clientLevel, entity.getEyePosition(), entity.getYRot());
            }
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderO2 = uRVarM1221a.O();
            if (entity != null && deferredHolderO2 != null && !z && fH >= 0.02f) {
                Vec3 eyePosition = entity.getEyePosition();
                clientLevel.playLocalSound(eyePosition.x, eyePosition.y, eyePosition.z, (SoundEvent) deferredHolderO2.get(), SoundSource.PLAYERS, fH, 1.0f, false);
            }
            Entity vehicle = localPlayer.getVehicle();
            if (vehicle instanceof AbstractC0376ny) {
                AbstractC0376ny abstractC0376ny = (AbstractC0376ny) vehicle;
                if (z || (entity != null && vehicle.hasPassenger(entity))) {
                    nD nDVarA = abstractC0376ny.a((Entity) (z ? localPlayer : entity));
                    if (nDVarA != null && nDVarA.fp) {
                        float fNextFloat2 = 0.8f + (0.4f * randomSourceCreate.nextFloat());
                        soundManager.playDelayed(SimpleSoundInstance.forUI((SoundEvent) C0624xc.xk.get(), fNextFloat2, 0.2f), 8);
                        DeferredHolder<SoundEvent, SoundEvent> deferredHolderG = uRVarM1221a.G();
                        if (deferredHolderG != null) {
                            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderG.get(), fNextFloat2, fH));
                        }
                    }
                }
            }
        }
    }

    private static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @Nullable Entity entity) {
        Vec3 eyePosition = entity != null ? entity.getEyePosition() : localPlayer.getEyePosition();
        float yHeadRot = entity != null ? entity.getYHeadRot() : localPlayer.getYHeadRot();
        float xRot = entity != null ? entity.getXRot() : localPlayer.getXRot();
        for (int i = 0; i < 6; i++) {
            Vec3 vec3Add = eyePosition.add(new Vec3(1.4f + (0.85f * i), 0.0d, 0.0d).zRot(((xRot + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-yHeadRot) * 0.017453292f) - 1.5707964f));
            iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) wZ.nC.get(), vec3Add.x, vec3Add.y, vec3Add.z, 0.0d, 0.0d, 0.0d);
        }
    }

    public static void a(@Nonnull Minecraft minecraft, @Nullable fT fTVar, @NotNull uR uRVar, @NotNull LocalPlayer localPlayer, @NotNull Vec3 vec3, boolean z, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, @Nullable Entity entity, float f, float f2, int i, boolean z2, boolean z3) {
        int iMax;
        a(entity, fTVar, uRVar, vec3, soundManager, randomSource, f, f2, i, z, z2, z3);
        a(uRVar, vec3, z, soundManager, randomSource, f, f2, i);
        a(soundManager, randomSource, vec3, z, f, i);
        if (z) {
            a(soundManager, uRVar, randomSource);
        }
        if (entity != null && !z) {
            a(minecraft, uRVar, localPlayer, vec3, soundManager, randomSource, entity, f2, i);
        } else {
            a(uRVar, soundManager, f, z, i);
            a(uRVar, soundManager, randomSource, f, z, i);
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderI = uRVar.I();
        if (!z && deferredHolderI != null && (iMax = Math.max(0, i - 1)) > 0) {
            a(soundManager, new SimpleSoundInstance((SoundEvent) deferredHolderI.get(), SoundSource.PLAYERS, f2, 0.95f + (0.05f * randomSource.nextFloat()), randomSource, vec3.x, vec3.y, vec3.z), false, iMax);
        }
    }

    private static void a(@NotNull SoundManager soundManager, @NotNull uR uRVar, @NotNull RandomSource randomSource) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM = uRVar.M();
        if (deferredHolderM == null) {
            return;
        }
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM.get(), 0.9f + (0.2f * randomSource.nextFloat()), 0.25f));
    }

    private static void a(@NotNull SoundManager soundManager, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, boolean z, float f, int i) {
        if (z) {
            for (int i2 = 0; i2 < 2; i2++) {
                a(soundManager, SimpleSoundInstance.forUI((SoundEvent) C0624xc.vj.get(), 1.0f, 1.0f), true, 0);
            }
            return;
        }
        if (f >= 0.02f) {
            float fNextFloat = 0.9f + (0.1f * randomSource.nextFloat());
            for (int i3 = 0; i3 < 2; i3++) {
                a(soundManager, new SimpleSoundInstance((SoundEvent) C0624xc.vi.get(), SoundSource.PLAYERS, f * 2.5f, fNextFloat, randomSource, vec3.x, vec3.y, vec3.z), false, i);
            }
        }
    }

    private static void a(@Nullable Entity entity, @Nullable fT fTVar, @NotNull uR uRVar, @NotNull Vec3 vec3, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, float f, float f2, int i, boolean z, boolean z2, boolean z3) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderB;
        float fNextInt = 0.85f + (0.03f * randomSource.nextInt(5));
        if (!z && f2 > 0.0f) {
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderC = z2 ? uRVar.C() : uRVar.A();
            if (deferredHolderC != null) {
                a(soundManager, new SimpleSoundInstance((SoundEvent) deferredHolderC.get(), SoundSource.PLAYERS, f2, fNextInt, randomSource, vec3.x, vec3.y, vec3.z), false, i);
            }
            if (!z2 && (deferredHolderB = uRVar.B()) != null) {
                SimpleSoundInstance simpleSoundInstanceForUI = SimpleSoundInstance.forUI((SoundEvent) deferredHolderB.get(), 1.0f, f2 / 12.0f);
                if (fTVar != null) {
                    SimpleSoundInstance simpleSoundInstanceB = fTVar.b();
                    if (simpleSoundInstanceB != null) {
                        aX.a(new hV(i, simpleSoundInstanceB));
                    }
                    fTVar.b(simpleSoundInstanceForUI);
                }
                a(soundManager, simpleSoundInstanceForUI, false, i);
            }
        }
        if (f > 0.02f || z) {
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderH = z2 ? z ? z3 ? uRVar.H() : uRVar.G() : uRVar.F() : z ? uRVar.E() : uRVar.D();
            if (deferredHolderH != null) {
                SimpleSoundInstance simpleSoundInstance = new SimpleSoundInstance((SoundEvent) deferredHolderH.get(), SoundSource.PLAYERS, f, fNextInt, randomSource, vec3.x, vec3.y, vec3.z);
                if (fTVar != null) {
                    SimpleSoundInstance simpleSoundInstanceM403a = fTVar.m403a();
                    if (simpleSoundInstanceM403a != null) {
                        aX.a(new hV(i, simpleSoundInstanceM403a));
                    }
                    fTVar.a(simpleSoundInstance);
                }
                if (entity instanceof mE) {
                    mE mEVar = (mE) entity;
                    SimpleSoundInstance simpleSoundInstanceM669a = mEVar.m669a();
                    if (simpleSoundInstanceM669a != null) {
                        aX.a(new hV(i, simpleSoundInstanceM669a));
                    }
                    mEVar.a(simpleSoundInstance);
                }
                a(soundManager, simpleSoundInstance, z, i);
            }
        }
    }

    private static void a(@NotNull uR uRVar, @NotNull Vec3 vec3, boolean z, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, float f, float f2, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderZ;
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderY;
        if (z && (deferredHolderY = uRVar.y()) != null) {
            SoundEvent soundEvent = (SoundEvent) deferredHolderY.get();
            for (int i2 = 0; i2 < 2; i2++) {
                a(soundManager, SimpleSoundInstance.forUI(soundEvent, 1.0f, f), true, i);
            }
        }
        if (!z && f2 > 0.0f && (deferredHolderZ = uRVar.z()) != null) {
            a(soundManager, new SimpleSoundInstance((SoundEvent) deferredHolderZ.get(), SoundSource.PLAYERS, f2, 1.0f, randomSource, vec3.x, vec3.y, vec3.z), false, i);
        }
    }

    private static void a(@NotNull uR uRVar, @NotNull SoundManager soundManager, float f, boolean z, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderJ;
        if (f > 0.0f && (deferredHolderJ = uRVar.J()) != null) {
            a(soundManager, SimpleSoundInstance.forUI((SoundEvent) deferredHolderJ.get(), 1.0f, f), z, i);
        }
    }

    private static void a(@NotNull uR uRVar, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, float f, boolean z, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderN;
        if (f > 0.0f && (deferredHolderN = uRVar.N()) != null) {
            a(soundManager, SimpleSoundInstance.forUI((SoundEvent) deferredHolderN.get(), 0.9f + (0.2f * randomSource.nextFloat()), f), z, i);
        }
    }

    private static void a(@Nonnull Minecraft minecraft, @NotNull uR uRVar, @NotNull LocalPlayer localPlayer, @NotNull Vec3 vec3, @NotNull SoundManager soundManager, @NotNull RandomSource randomSource, @NotNull Entity entity, float f, int i) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderL;
        if (Minecraft.useFancyGraphics() && localPlayer.hasLineOfSight(entity) && (deferredHolderL = uRVar.L()) != null) {
            a(soundManager, new SimpleSoundInstance((SoundEvent) deferredHolderL.get(), SoundSource.PLAYERS, f * oR.a(entity, minecraft.gameRenderer.getMainCamera()), 1.0f, randomSource, vec3.x, vec3.y, vec3.z), false, i);
        }
    }

    public static void a(@NotNull SoundManager soundManager, @NotNull AbstractSoundInstance abstractSoundInstance, boolean z, int i) {
        if (z || i <= 0) {
            soundManager.play(abstractSoundInstance);
        } else {
            soundManager.playDelayed(abstractSoundInstance, i);
        }
    }
}
