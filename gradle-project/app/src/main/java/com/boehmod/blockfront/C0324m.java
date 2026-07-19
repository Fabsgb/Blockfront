package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ChatGraphic;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0069cm;
import com.mojang.blaze3d.platform.NativeImage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.Holder;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/m.class */
public class C0324m {
    private static final Component q;

    /* JADX INFO: renamed from: q, reason: collision with other field name */
    private static final int f235q = 3;
    public static final int r = 2;
    private static final double a = 256.0d;
    static final /* synthetic */ boolean x;

    static {
        x = !C0324m.class.desiredAssertionStatus();
        q = Component.translatable("bf.message.screenshot.request.error");
    }

    public static void a(@NotNull C0590vw c0590vw, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oX oXVarK = c0590vw.k();
        boolean z = oXVarK != null;
        fT fTVarA = ((fV) c0297lB.a()).a(minecraft);
        if (!clientLevel.isClientSide() && !minecraft.hasSingleplayerServer()) {
            fTVarA.Z(z);
        }
        if (z) {
            localPlayer.teleportTo(oXVarK.c.x, oXVarK.c.y, oXVarK.c.z);
            if (localPlayer.getHealth() > 0.0f) {
                fTVarA.e(oXVarK);
            }
        }
    }

    public static void a(@NotNull C0609wo c0609wo, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        boolean zDf = c0609wo.df();
        fV fVVar = (fV) c0297lB.a();
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        try {
            if (zDf) {
                ByteBuf byteBufA = c0609wo.a();
                if (oFVarM591a == null) {
                    String strM = c0609wo.M();
                    if (strM == null) {
                        return;
                    }
                    sW sWVarA = sW.a(strM);
                    if (sWVarA == null) {
                        c0609wo.dv();
                        return;
                    }
                    try {
                        oF<?, ?, ?> oFVarNewInstance = sWVarA.b().getDeclaredConstructor(AbstractC0264ju.class).newInstance(c0297lB);
                        oFVarNewInstance.g(byteBufA);
                        c0297lB.a(minecraft, fVVar, clientLevel, oFVarNewInstance);
                        oG<?, ?> oGVarM593a = c0297lB.m593a();
                        if (oGVarM593a != null) {
                            oGVarM593a.b(byteBufA);
                        }
                    } catch (IOException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        oFVarM591a.g(byteBufA);
                        oG<?, ?> oGVarM593a2 = c0297lB.m593a();
                        if (oGVarM593a2 != null) {
                            oGVarM593a2.b(byteBufA);
                        }
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            } else if (oFVarM591a != null) {
                c0297lB.a(minecraft, fVVar, clientLevel, (oF<?, ?, ?>) null);
            }
            c0609wo.dv();
        } finally {
            c0609wo.dv();
        }
    }

    public static void a(@NotNull C0611wq c0611wq, @NotNull IPayloadContext iPayloadContext) {
        oG<?, ?> oGVarM593a;
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0297lB.m591a() != null && (oGVarM593a = c0297lB.m593a()) != null) {
            oGVarM593a.a(c0297lB.m597a(), c0611wq.a());
        }
    }

    public static void a(@NotNull C0612wr c0612wr, @NotNull IPayloadContext iPayloadContext) {
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0297lB.m591a() == null) {
            return;
        }
        sR sRVar = new sR(c0612wr.b(), c0612wr.l(), c0612wr.bW());
        oG<?, ?> oGVarM593a = c0297lB.m593a();
        if (oGVarM593a != null) {
            oGVarM593a.a(sRVar);
        }
    }

    public static void a(@NotNull vE vEVar, @NotNull IPayloadContext iPayloadContext) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel == null) {
            return;
        }
        UUID uuid = vEVar.a().getUUID();
        for (AbstractClientPlayer abstractClientPlayer : clientLevel.players()) {
            if (abstractClientPlayer.getUUID().equals(uuid)) {
                abstractClientPlayer.refreshDimensions();
                return;
            }
        }
    }

    public static void a(@NotNull wC wCVar, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null) {
            return;
        }
        ItemStack mainHandItem = wCVar.jm ? localPlayer.getMainHandItem() : localPlayer.getOffhandItem();
        if (mainHandItem.isEmpty()) {
            return;
        }
        Item item = mainHandItem.getItem();
        if (item instanceof C0558ur) {
            ((C0558ur) item).b(minecraft, mainHandItem);
        }
    }

    public static void a(@NotNull wD wDVar, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        ItemStack itemStackM = wDVar.m();
        if (itemStackM.isEmpty()) {
            return;
        }
        Item item = itemStackM.getItem();
        if (item instanceof C0558ur) {
            C0558ur c0558ur = (C0558ur) item;
            int iCq = wDVar.cq();
            if (iCq == 0 || wDVar.di() || localPlayer.getId() != iCq) {
                C0297l c0297lB = C0297l.b();
                if (!x && c0297lB == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                iD.a(minecraft, c0297lB, (fV) c0297lB.a(), localPlayer, clientLevel, itemStackM, c0558ur, wDVar.h(), false, wDVar.dh(), wDVar.dj(), iCq);
            }
        }
    }

    public static void a(@NotNull C0605wk c0605wk, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (clientLevel == null || localPlayer == null || localPlayer.getId() == c0605wk.al()) {
            return;
        }
        for (C0556up c0556up : c0605wk.aN()) {
            C0297l c0297lB = C0297l.b();
            if (!x && c0297lB == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            LivingEntity entity = clientLevel.getEntity(c0556up.al());
            if (entity instanceof LivingEntity) {
                aP.a(minecraft, c0297lB, clientLevel, clientLevel.getRandom(), threadLocalRandomCurrent, localPlayer, entity, c0556up.z(), c0556up.b(), c0556up.co());
            }
        }
    }

    public static void a(@NotNull C0603wi c0603wi, @NotNull IPayloadContext iPayloadContext) {
        int iCq;
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null || (iCq = c0603wi.cq()) == localPlayer.getId()) {
            return;
        }
        LivingEntity entity = clientLevel.getEntity(iCq);
        if (entity != null || iCq == 0) {
            C0297l c0297lB = C0297l.b();
            if (!x && c0297lB == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            LivingEntity livingEntity = entity instanceof LivingEntity ? entity : null;
            RandomSource random = clientLevel.getRandom();
            List<C0555uo> listAL = c0603wi.aL();
            Iterator<C0555uo> it = listAL.iterator();
            while (it.hasNext()) {
                aP.a(minecraft, c0297lB, clientLevel, random, localPlayer, livingEntity, it.next(), c0603wi.cq());
            }
            if (!listAL.isEmpty() && livingEntity != null) {
                aP.a(minecraft, clientLevel, listAL.get(listAL.size() - 1), livingEntity.getEyePosition(), random);
            }
        }
    }

    public static void a(@NotNull C0619wy c0619wy, @NotNull IPayloadContext iPayloadContext) {
        aU.bl = c0619wy.bY();
        SoundManager soundManager = Minecraft.getInstance().getSoundManager();
        soundManager.stop();
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.tL.get(), 1.0f));
    }

    public static void a(@NotNull vU vUVar, @NotNull IPayloadContext iPayloadContext) {
        Minecraft.getInstance().getSoundManager().play(new SimpleSoundInstance(((SoundEvent) vUVar.c().value()).getLocation(), vUVar.a(), vUVar.bP(), vUVar.bO(), SoundInstance.createUnseededRandom(), false, 0, SoundInstance.Attenuation.NONE, 0.0d, 0.0d, 0.0d, true));
    }

    public static void a(@NotNull vV vVVar, @NotNull IPayloadContext iPayloadContext) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel != null) {
            Vec3 vec3H = vVVar.h();
            clientLevel.playLocalSound(vec3H.x, vec3H.y, vec3H.z, (SoundEvent) vVVar.c().value(), vVVar.a(), vVVar.bP(), vVVar.bO(), false);
        }
    }

    public static void a(@NotNull C0573vf c0573vf, @NotNull IPayloadContext iPayloadContext) {
        C0119ej.a(Minecraft.getInstance(), c0573vf.a(), c0573vf.o(), c0573vf.b(), true);
    }

    public static void a(@NotNull C0591vx c0591vx, @NotNull IPayloadContext iPayloadContext) {
        oG<?, ?> oGVarM593a;
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0297lB.m591a() != null && (oGVarM593a = c0297lB.m593a()) != null) {
            oGVarM593a.a(c0591vx.aK(), c0591vx.ck(), c0591vx.T(), c0591vx.h(), c0591vx.cl(), c0591vx.H());
        }
    }

    public static void a(@NotNull vF vFVar, @NotNull IPayloadContext iPayloadContext) {
        oG<?, ?> oGVarM593a;
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0297lB.m591a() != null && (oGVarM593a = c0297lB.m593a()) != null) {
            oGVarM593a.a(vFVar.a());
        }
    }

    public static void a(@NotNull C0607wm c0607wm, @NotNull IPayloadContext iPayloadContext) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null || localPlayer.getId() == c0607wm.al()) {
            return;
        }
        aV.l.add(c0607wm.b());
    }

    public static void a(@NotNull vW vWVar, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        LivingEntity entity = clientLevel.getEntity(vWVar.cm());
        if ((entity instanceof AbstractClientPlayer) || (entity instanceof mE)) {
            C0297l c0297lB = C0297l.b();
            if (!x && c0297lB == null) {
                throw new AssertionError("Mod manager is null!");
            }
            c0297lB.m589a().a(minecraft, clientLevel, localPlayer, entity, vWVar.a(), ThreadLocalRandom.current());
        }
    }

    public static void a(@NotNull C0601wg c0601wg, @NotNull IPayloadContext iPayloadContext) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel == null) {
            return;
        }
        clientLevel.setSkyFlashTime(c0601wg.cp());
    }

    public static void a(@NotNull vJ vJVar, @NotNull IPayloadContext iPayloadContext) {
        oG<?, ?> oGVarM593a;
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0297lB.m591a() == null || (oGVarM593a = c0297lB.m593a()) == null) {
            return;
        }
        List<C0413ph> listX = oGVarM593a.x();
        if (listX.size() >= 5) {
            listX.removeFirst();
        }
        EnumC0481rv enumC0481rvB = vJVar.b();
        if (enumC0481rvB.isWaypoint()) {
            oGVarM593a.cp();
        }
        oGVarM593a.a(new C0413ph(vJVar.az(), vJVar.ck(), vJVar.h(), enumC0481rvB));
    }

    public static void a(@NotNull C0587vt c0587vt, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        if (clientLevel == null) {
            return;
        }
        mE entity = clientLevel.getEntity(c0587vt.ci());
        if ((!(entity instanceof mE) || hN.F.T()) && (entity instanceof LivingEntity)) {
            LivingEntity livingEntity = (LivingEntity) entity;
            SoundManager soundManager = minecraft.getSoundManager();
            SoundEvent soundEvent = (SoundEvent) c0587vt.b().value();
            LocalPlayer localPlayer = minecraft.player;
            boolean z = localPlayer != null && entity.distanceToSqr(localPlayer) >= a;
            if (c0587vt.cS() && z) {
                Vec3 vec3Position = entity.position();
                AbstractSoundInstance c0231io = new C0231io(soundEvent, c0587vt.a(), c0587vt.bP(), c0587vt.bO(), SoundInstance.createUnseededRandom(), vec3Position.x, vec3Position.y, vec3Position.z);
                if (entity instanceof mE) {
                    mE mEVar = entity;
                    if (c0587vt.cQ()) {
                        mEVar.bx();
                    }
                    mEVar.b(c0231io);
                }
                soundManager.play(c0231io);
                return;
            }
            AbstractSoundInstance c0235is = new C0235is(livingEntity, soundEvent, c0587vt.a(), c0587vt.bO(), c0587vt.bP(), c0587vt.cR());
            if (entity instanceof mE) {
                mE mEVar2 = entity;
                if (c0587vt.cQ()) {
                    mEVar2.bx();
                }
                mEVar2.b(c0235is);
            }
            soundManager.play(c0235is);
        }
    }

    public static void a(@NotNull C0588vu c0588vu, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        if (clientLevel != null) {
            C0297l c0297lB = C0297l.b();
            if (!x && c0297lB == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            C0345mu.a(minecraft, c0297lB, clientLevel, c0588vu.a(), c0588vu.h());
        }
    }

    public static void a(@NotNull C0568va c0568va, @NotNull IPayloadContext iPayloadContext) {
        Player playerByUUID;
        oZ oZVarB = c0568va.b();
        UUID uuidM1267b = c0568va.m1267b();
        if (oZVarB.getWaypoint() == null) {
            return;
        }
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ((fV) c0297lB.a()).b(uuidM1267b).b(oZVarB);
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        if (clientLevel != null && (playerByUUID = clientLevel.getPlayerByUUID(uuidM1267b)) != null) {
            Vec3 vec3Position = playerByUUID.position();
            SoundManager soundManager = minecraft.getSoundManager();
            Holder.Reference<SoundEvent> soundEvent = oZVarB.getSoundEvent();
            if (soundEvent != null) {
                soundManager.play(new SimpleSoundInstance((SoundEvent) soundEvent.value(), SoundSource.NEUTRAL, 12.0f, 2.0f, clientLevel.getRandom(), vec3Position.x, vec3Position.y, vec3Position.z));
            }
        }
    }

    public static void a(@NotNull C0572ve c0572ve, @NotNull IPayloadContext iPayloadContext) {
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0297lB.m589a().p();
    }

    public static void a(@NotNull C0608wn c0608wn, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pi.get(), 1.0f, 1.0f));
        Screen screen = minecraft.screen;
        if (screen instanceof cH) {
            ((cH) screen).b(c0608wn.b());
        } else {
            minecraft.gui.getChat().addMessage(c0608wn.b());
        }
    }

    public static void a(@NotNull C0569vb c0569vb, @NotNull IPayloadContext iPayloadContext) {
        ChatGraphic chatGraphicA = c0569vb.a();
        Component componentN = c0569vb.n();
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null) {
            return;
        }
        MutableComponent mutableComponentEmpty = Component.empty();
        mutableComponentEmpty.append(String.valueOf(chatGraphicA.getCharacter())).withColor(ColorReferences.COLOR_WHITE);
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(Math.max(0, chatGraphicA.getWidth())));
        ObjectList<String> objectListA = iH.a(font, componentN.getString(), (minecraft.gui.getChat().getWidth() - font.width(sb.toString())) - 5);
        int iMax = Math.max(chatGraphicA.getHeight(), objectListA.size());
        mutableComponentEmpty.append(String.valueOf('\n'));
        for (int i = 0; i < iMax; i++) {
            if (i > 0) {
                mutableComponentEmpty.append(String.valueOf('\n'));
            }
            mutableComponentEmpty.append(sb.toString());
            if (i < objectListA.size()) {
                mutableComponentEmpty.append(Component.literal((String) objectListA.get(i)).withStyle(componentN.getStyle()));
            }
        }
        localPlayer.sendSystemMessage(mutableComponentEmpty);
    }

    public static void a(@NotNull vT vTVar, @NotNull IPayloadContext iPayloadContext) {
        hE.a(vTVar.c());
    }

    public static void a(@NotNull vG vGVar, @NotNull IPayloadContext iPayloadContext) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        hE.a(vGVar.b(), localPlayer, new Vec3(vGVar.d()), vGVar.bQ());
    }

    public static void a(@NotNull C0597wc c0597wc, @NotNull IPayloadContext iPayloadContext) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel == null) {
            return;
        }
        Entity entity = clientLevel.getEntity(c0597wc.al());
        if (entity instanceof AbstractC0376ny) {
            ((AbstractC0376ny) entity).u(c0597wc.aA());
        }
    }

    public static void a(@NotNull vA vAVar, @NotNull IPayloadContext iPayloadContext) {
        if (hN.g.T()) {
            C0297l c0297lB = C0297l.b();
            if (!x && c0297lB == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            SoundManager soundManager = Minecraft.getInstance().getSoundManager();
            if (c0297lB.m591a() == null) {
                return;
            }
            if (C0067ck.r == 0) {
                for (int i = 0; i < 3; i++) {
                    soundManager.playDelayed(SimpleSoundInstance.forUI((SoundEvent) C0624xc.oy.get(), 1.0f, 6.0f), 2);
                }
            }
            C0067ck.r = 2;
            C0067ck.aS = vAVar.cT();
        }
    }

    public static void a(@NotNull C0580vm c0580vm, @NotNull IPayloadContext iPayloadContext) {
        aT.i.add(c0580vm.a());
    }

    public static void a(@NotNull C0579vl c0579vl, @NotNull IPayloadContext iPayloadContext) {
        aT.j.add(c0579vl.a());
    }

    public static void a(@NotNull C0578vk c0578vk, @NotNull IPayloadContext iPayloadContext) {
        C0069cm.q.add(new C0069cm.a(c0578vk.D(), c0578vk.h()));
    }

    public static void a(@NotNull C0606wl c0606wl, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        Vec3 eyePosition = localPlayer.getEyePosition();
        float fNextFloat = 0.9f + (ThreadLocalRandom.current().nextFloat() * 0.2f);
        for (int i = 0; i < 2; i++) {
            clientLevel.playLocalSound(eyePosition.x + 2.0d, eyePosition.y - 1.0d, eyePosition.z - 2.0d, (SoundEvent) C0624xc.uA.get(), SoundSource.BLOCKS, 15.0f, fNextFloat, false);
            clientLevel.playLocalSound(eyePosition.x - 2.0d, eyePosition.y - 1.0d, eyePosition.z + 2.0d, (SoundEvent) C0624xc.uA.get(), SoundSource.BLOCKS, 15.0f, fNextFloat, false);
        }
        aY.cb = 1.0f;
        hE.a(hH.J, c0606wl.de() ? 0.5f : 1.0f);
    }

    public static void a(@NotNull jC jCVar, @NotNull IPayloadContext iPayloadContext) {
        if (!hN.S.T()) {
            C0263jt.log("[Screenshot] Received screenshot request from server, but the player has not accepted the rules! Ignoring...", new Object[0]);
            C0263jt.log("[Screenshot] More information can be found here: 'https://www.blockfrontmc.com/privacy'.", new Object[0]);
        } else if (C0262js.ab()) {
            C0263jt.log("[Screenshot] Received screenshot request from server! Initializing...", new Object[0]);
            C0263jt.log("[Screenshot] More information can be found here: 'https://www.blockfrontmc.com/privacy'.", new Object[0]);
            C0297l c0297lB = C0297l.b();
            if (!x && c0297lB == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            ((C0459r) c0297lB.b()).a().j();
        }
    }

    public static void a(@NotNull jB jBVar, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        try {
            minecraft.setScreen(new cF(NativeImage.read(new ByteBufInputStream(Unpooled.wrappedBuffer(jBVar.c())))));
        } catch (IOException e) {
            minecraft.gui.getChat().addMessage(q);
            C0263jt.a("Error while receiving screenshot.", e, new Object[0]);
        }
    }

    public static void a(vH vHVar, @NotNull IPayloadContext iPayloadContext) {
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        vHVar.b().a(c0297lB.a(), Minecraft.getInstance());
    }

    public static void a(vQ vQVar, @NotNull IPayloadContext iPayloadContext) {
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        C0332mh c0332mhE = vQVar.e();
        if (c0332mhE != null) {
            c0297lB.m602a().a(minecraft, c0332mhE, vQVar.p().orElse(null));
        }
    }

    public static void a(C0599we c0599we, @NotNull IPayloadContext iPayloadContext) {
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        if (oFVarM591a != null) {
            c0297lB.m602a().b(new C0343ms(oFVarM591a, c0599we.p(), c0599we.dd()));
        }
    }

    public static void a(C0613ws c0613ws, IPayloadContext iPayloadContext) {
        try {
            C0297l c0297lB = C0297l.b();
            if (!x && c0297lB == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
            if (oFVarM591a == null) {
                return;
            }
            oFVarM591a.m758a().b(c0613ws.a());
            oG<?, ?> oGVarM593a = c0297lB.m593a();
            if (oGVarM593a != null) {
                oGVarM593a.O(oFVarM591a.m758a().ch());
            }
            c0613ws.dv();
        } catch (Exception e) {
            C0263jt.logError("Failed to handle map vote info packet", e);
        }
    }

    public static void a(C0571vd c0571vd, @NotNull IPayloadContext iPayloadContext) {
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0297lB.m602a().a(new C0341mq(c0571vd.q(), c0571vd.bK(), c0571vd.bL(), c0571vd.bM()));
    }

    public static void a(vL vLVar, @NotNull IPayloadContext iPayloadContext) {
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oG<?, ?> oGVarM593a = c0297lB.m593a();
        if (oGVarM593a == null) {
            return;
        }
        oGVarM593a.a(new sT(vLVar.o(), vLVar.p(), vLVar.h()));
    }

    public static void a(vN vNVar, @NotNull IPayloadContext iPayloadContext) {
        C0297l c0297lB = C0297l.b();
        if (!x && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oG<?, ?> oGVarM593a = c0297lB.m593a();
        if (oGVarM593a == null) {
            return;
        }
        oGVarM593a.a(vNVar.p(), vNVar.b(), vNVar.h());
    }

    public static void a(@NotNull C0600wf c0600wf, @NotNull IPayloadContext iPayloadContext) {
        oF<?, ?, ?> oFVarM591a;
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null || (oFVarM591a = c0297lB.m591a()) == null) {
            return;
        }
        pA pAVarA = oFVarM591a.m767a().a(c0600wf.n());
        if (!(pAVarA instanceof qE)) {
            return;
        }
        ((qE) pAVarA).a(c0600wf.cn(), c0600wf.co());
    }

    public static void a(@NotNull vC vCVar, @NotNull IPayloadContext iPayloadContext) {
        oF<?, ?, ?> oFVarM591a;
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null || (oFVarM591a = c0297lB.m591a()) == null) {
            return;
        }
        Object objA = oFVarM591a.m767a().a(vCVar.n());
        if (objA instanceof pK) {
            ((pK) objA).g(Unpooled.wrappedBuffer(vCVar.e()));
        }
    }

    public static void a(@NotNull vY vYVar, @NotNull IPayloadContext iPayloadContext) {
        FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(Unpooled.wrappedBuffer(vYVar.e()));
        int i = friendlyByteBuf.readInt();
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap(i);
        for (int i2 = 0; i2 < i; i2++) {
            object2ObjectOpenHashMap.put(friendlyByteBuf.readUtf(), (pA) pB.d.decode(new FriendlyByteBuf(Unpooled.wrappedBuffer(friendlyByteBuf.readByteArray()))));
        }
        int i3 = friendlyByteBuf.readInt();
        Object2ObjectOpenHashMap object2ObjectOpenHashMap2 = new Object2ObjectOpenHashMap(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            object2ObjectOpenHashMap2.put(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readUtf());
        }
        C0378o.a(object2ObjectOpenHashMap, object2ObjectOpenHashMap2);
    }
}
