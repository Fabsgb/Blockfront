package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ChatGraphic;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0178cm;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.m */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/m.class */
public class C0675m {

    /* JADX INFO: renamed from: q */
    private static final Component f3602q;

    /* JADX INFO: renamed from: q */
    private static final int f3603q = 3;

    /* JADX INFO: renamed from: r */
    public static final int f3604r = 2;

    /* JADX INFO: renamed from: a */
    private static final double f3605a = 256.0d;

    /* JADX INFO: renamed from: x */
    static final /* synthetic */ boolean f3606x;

    static {
        f3606x = !C0675m.class.desiredAssertionStatus();
        f3602q = Component.translatable("bf.message.screenshot.request.error");
    }

    /* JADX INFO: renamed from: a */
    public static void m2926a(@NotNull C1202vw c1202vw, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0805oX c0805oXM6697k = c1202vw.m6697k();
        boolean z = c0805oXM6697k != null;
        C0324fT c0324fTM1675a = ((C0326fV) c0622lM2667b.m2670a()).m1675a(minecraft);
        if (!clientLevel.isClientSide() && !minecraft.hasSingleplayerServer()) {
            c0324fTM1675a.m1094Z(z);
        }
        if (z) {
            localPlayer.teleportTo(c0805oXM6697k.f4424c.x, c0805oXM6697k.f4424c.y, c0805oXM6697k.f4424c.z);
            if (localPlayer.getHealth() > 0.0f) {
                c0324fTM1675a.m1092e(c0805oXM6697k);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2927a(@NotNull C1247wo c1247wo, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        boolean zM7693df = c1247wo.m7693df();
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        try {
            if (zM7693df) {
                ByteBuf byteBufM7692a = c1247wo.m7692a();
                if (abstractC0787oFM2688a == null) {
                    String strM7694M = c1247wo.m7694M();
                    if (strM7694M == null) {
                        return;
                    }
                    C1016sW c1016sWM5531a = C1016sW.m5531a(strM7694M);
                    if (c1016sWM5531a == null) {
                        c1247wo.m7695dv();
                        return;
                    }
                    try {
                        AbstractC0787oF<?, ?, ?> abstractC0787oFNewInstance = c1016sWM5531a.m5533b().getDeclaredConstructor(AbstractC0563ju.class).newInstance(c0622lM2667b);
                        abstractC0787oFNewInstance.mo3616g(byteBufM7692a);
                        c0622lM2667b.m2693a(minecraft, c0326fV, clientLevel, abstractC0787oFNewInstance);
                        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622lM2667b.m2692a();
                        if (abstractC0788oGM2692a != null) {
                            abstractC0788oGM2692a.m3739b(byteBufM7692a);
                        }
                    } catch (IOException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        abstractC0787oFM2688a.mo3616g(byteBufM7692a);
                        AbstractC0788oG<?, ?> abstractC0788oGM2692a2 = c0622lM2667b.m2692a();
                        if (abstractC0788oGM2692a2 != null) {
                            abstractC0788oGM2692a2.m3739b(byteBufM7692a);
                        }
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            } else if (abstractC0787oFM2688a != null) {
                c0622lM2667b.m2693a(minecraft, c0326fV, clientLevel, (AbstractC0787oF<?, ?, ?>) null);
            }
            c1247wo.m7695dv();
        } finally {
            c1247wo.m7695dv();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2928a(@NotNull C1249wq c1249wq, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0788oG<?, ?> abstractC0788oGM2692a;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0622lM2667b.m2688a() != null && (abstractC0788oGM2692a = c0622lM2667b.m2692a()) != null) {
            abstractC0788oGM2692a.m3735a(c0622lM2667b.m2700a(), c1249wq.m7702a());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2929a(@NotNull C1250wr c1250wr, @NotNull IPayloadContext iPayloadContext) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0622lM2667b.m2688a() == null) {
            return;
        }
        C1011sR c1011sR = new C1011sR(c1250wr.m7705b(), c1250wr.m7706l(), c1250wr.m7707bW());
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622lM2667b.m2692a();
        if (abstractC0788oGM2692a != null) {
            abstractC0788oGM2692a.m3738a(c1011sR);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2930a(@NotNull C1158vE c1158vE, @NotNull IPayloadContext iPayloadContext) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel == null) {
            return;
        }
        UUID uuid = c1158vE.m6500a().getUUID();
        for (AbstractClientPlayer abstractClientPlayer : clientLevel.players()) {
            if (abstractClientPlayer.getUUID().equals(uuid)) {
                abstractClientPlayer.refreshDimensions();
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2931a(@NotNull C1209wC c1209wC, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null) {
            return;
        }
        ItemStack mainHandItem = c1209wC.f6349jm ? localPlayer.getMainHandItem() : localPlayer.getOffhandItem();
        if (mainHandItem.isEmpty()) {
            return;
        }
        Item item = mainHandItem.getItem();
        if (item instanceof C1144ur) {
            ((C1144ur) item).m6366b(minecraft, mainHandItem);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2932a(@NotNull C1210wD c1210wD, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        ItemStack itemStackM6723m = c1210wD.m6723m();
        if (itemStackM6723m.isEmpty()) {
            return;
        }
        Item item = itemStackM6723m.getItem();
        if (item instanceof C1144ur) {
            C1144ur c1144ur = (C1144ur) item;
            int iM6725cq = c1210wD.m6725cq();
            if (iM6725cq == 0 || c1210wD.m6727di() || localPlayer.getId() != iM6725cq) {
                C0622l c0622lM2667b = C0622l.m2667b();
                if (!f3606x && c0622lM2667b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0467iD.m2105a(minecraft, c0622lM2667b, (C0326fV) c0622lM2667b.m2670a(), localPlayer, clientLevel, itemStackM6723m, c1144ur, c1210wD.m6724h(), false, c1210wD.m6726dh(), c1210wD.m6728dj(), iM6725cq);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2933a(@NotNull C1243wk c1243wk, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (clientLevel == null || localPlayer == null || localPlayer.getId() == c1243wk.m7678al()) {
            return;
        }
        for (C1142up c1142up : c1243wk.m7679aN()) {
            C0622l c0622lM2667b = C0622l.m2667b();
            if (!f3606x && c0622lM2667b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            LivingEntity entity = clientLevel.getEntity(c1142up.m6284al());
            if (entity instanceof LivingEntity) {
                C0045aP.m209a(minecraft, c0622lM2667b, clientLevel, clientLevel.getRandom(), threadLocalRandomCurrent, localPlayer, entity, c1142up.m6291z(), c1142up.m6290b(), c1142up.m6286co());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2934a(@NotNull C1241wi c1241wi, @NotNull IPayloadContext iPayloadContext) {
        int iM7663cq;
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null || (iM7663cq = c1241wi.m7663cq()) == localPlayer.getId()) {
            return;
        }
        LivingEntity entity = clientLevel.getEntity(iM7663cq);
        if (entity != null || iM7663cq == 0) {
            C0622l c0622lM2667b = C0622l.m2667b();
            if (!f3606x && c0622lM2667b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            LivingEntity livingEntity = entity instanceof LivingEntity ? entity : null;
            RandomSource random = clientLevel.getRandom();
            List<C1141uo> listM7664aL = c1241wi.m7664aL();
            Iterator<C1141uo> it = listM7664aL.iterator();
            while (it.hasNext()) {
                C0045aP.m205a(minecraft, c0622lM2667b, clientLevel, random, localPlayer, livingEntity, it.next(), c1241wi.m7663cq());
            }
            if (!listM7664aL.isEmpty() && livingEntity != null) {
                C0045aP.m210a(minecraft, clientLevel, listM7664aL.get(listM7664aL.size() - 1), livingEntity.getEyePosition(), random);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2935a(@NotNull C1257wy c1257wy, @NotNull IPayloadContext iPayloadContext) {
        C0050aU.f319bl = c1257wy.m7734bY();
        SoundManager soundManager = Minecraft.getInstance().getSoundManager();
        soundManager.stop();
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7788tL.get(), 1.0f));
    }

    /* JADX INFO: renamed from: a */
    public static void m2936a(@NotNull C1174vU c1174vU, @NotNull IPayloadContext iPayloadContext) {
        Minecraft.getInstance().getSoundManager().play(new SimpleSoundInstance(((SoundEvent) c1174vU.m6567c().value()).getLocation(), c1174vU.m6568a(), c1174vU.m6569bP(), c1174vU.m6570bO(), SoundInstance.createUnseededRandom(), false, 0, SoundInstance.Attenuation.NONE, 0.0d, 0.0d, 0.0d, true));
    }

    /* JADX INFO: renamed from: a */
    public static void m2937a(@NotNull C1175vV c1175vV, @NotNull IPayloadContext iPayloadContext) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel != null) {
            Vec3 vec3M6577h = c1175vV.m6577h();
            clientLevel.playLocalSound(vec3M6577h.x, vec3M6577h.y, vec3M6577h.z, (SoundEvent) c1175vV.m6573c().value(), c1175vV.m6574a(), c1175vV.m6575bP(), c1175vV.m6576bO(), false);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2938a(@NotNull C1185vf c1185vf, @NotNull IPayloadContext iPayloadContext) {
        C0287ej.m1511a(Minecraft.getInstance(), c1185vf.m6616a(), c1185vf.m6617o(), c1185vf.m6618b(), true);
    }

    /* JADX INFO: renamed from: a */
    public static void m2939a(@NotNull C1203vx c1203vx, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0788oG<?, ?> abstractC0788oGM2692a;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0622lM2667b.m2688a() != null && (abstractC0788oGM2692a = c0622lM2667b.m2692a()) != null) {
            abstractC0788oGM2692a.m3755a(c1203vx.m6700aK(), c1203vx.m6701ck(), c1203vx.m6702T(), c1203vx.m6703h(), c1203vx.m6704cl(), c1203vx.m6705H());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2940a(@NotNull C1159vF c1159vF, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0788oG<?, ?> abstractC0788oGM2692a;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0622lM2667b.m2688a() != null && (abstractC0788oGM2692a = c0622lM2667b.m2692a()) != null) {
            abstractC0788oGM2692a.m3736a(c1159vF.m6503a());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2941a(@NotNull C1245wm c1245wm, @NotNull IPayloadContext iPayloadContext) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null || localPlayer.getId() == c1245wm.m7685al()) {
            return;
        }
        C0051aV.f352l.add(c1245wm.m7686b());
    }

    /* JADX INFO: renamed from: a */
    public static void m2942a(@NotNull C1176vW c1176vW, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        LivingEntity entity = clientLevel.getEntity(c1176vW.m6580cm());
        if ((entity instanceof AbstractClientPlayer) || (entity instanceof C0680mE)) {
            C0622l c0622lM2667b = C0622l.m2667b();
            if (!f3606x && c0622lM2667b == null) {
                throw new AssertionError("Mod manager is null!");
            }
            c0622lM2667b.m2685a().m34a(minecraft, clientLevel, localPlayer, entity, c1176vW.m6581a(), ThreadLocalRandom.current());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2943a(@NotNull C1239wg c1239wg, @NotNull IPayloadContext iPayloadContext) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel == null) {
            return;
        }
        clientLevel.setSkyFlashTime(c1239wg.m7657cp());
    }

    /* JADX INFO: renamed from: a */
    public static void m2944a(@NotNull C1163vJ c1163vJ, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0788oG<?, ?> abstractC0788oGM2692a;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0622lM2667b.m2688a() == null || (abstractC0788oGM2692a = c0622lM2667b.m2692a()) == null) {
            return;
        }
        List<C0868ph> listM3707x = abstractC0788oGM2692a.m3707x();
        if (listM3707x.size() >= 5) {
            listM3707x.removeFirst();
        }
        EnumC0988rv enumC0988rvM6523b = c1163vJ.m6523b();
        if (enumC0988rvM6523b.isWaypoint()) {
            abstractC0788oGM2692a.m3708cp();
        }
        abstractC0788oGM2692a.m3709a(new C0868ph(c1163vJ.m6520az(), c1163vJ.m6521ck(), c1163vJ.m6522h(), enumC0988rvM6523b));
    }

    /* JADX INFO: renamed from: a */
    public static void m2945a(@NotNull C1199vt c1199vt, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        if (clientLevel == null) {
            return;
        }
        C0680mE entity = clientLevel.getEntity(c1199vt.m6685ci());
        if ((!(entity instanceof C0680mE) || C0424hN.f2751F.m1996T()) && (entity instanceof LivingEntity)) {
            LivingEntity livingEntity = (LivingEntity) entity;
            SoundManager soundManager = minecraft.getSoundManager();
            SoundEvent soundEvent = (SoundEvent) c1199vt.m6683b().value();
            LocalPlayer localPlayer = minecraft.player;
            boolean z = localPlayer != null && entity.distanceToSqr(localPlayer) >= f3605a;
            if (c1199vt.m6681cS() && z) {
                Vec3 vec3Position = entity.position();
                AbstractSoundInstance c0504io = new C0504io(soundEvent, c1199vt.m6684a(), c1199vt.m6687bP(), c1199vt.m6686bO(), SoundInstance.createUnseededRandom(), vec3Position.x, vec3Position.y, vec3Position.z);
                if (entity instanceof C0680mE) {
                    C0680mE c0680mE = entity;
                    if (c1199vt.m6679cQ()) {
                        c0680mE.m3014bx();
                    }
                    c0680mE.m3013b(c0504io);
                }
                soundManager.play(c0504io);
                return;
            }
            AbstractSoundInstance c0508is = new C0508is(livingEntity, soundEvent, c1199vt.m6684a(), c1199vt.m6686bO(), c1199vt.m6687bP(), c1199vt.m6680cR());
            if (entity instanceof C0680mE) {
                C0680mE c0680mE2 = entity;
                if (c1199vt.m6679cQ()) {
                    c0680mE2.m3014bx();
                }
                c0680mE2.m3013b(c0508is);
            }
            soundManager.play(c0508is);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2946a(@NotNull C1200vu c1200vu, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        if (clientLevel != null) {
            C0622l c0622lM2667b = C0622l.m2667b();
            if (!f3606x && c0622lM2667b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            C0722mu.m3269a(minecraft, c0622lM2667b, clientLevel, c1200vu.m6691a(), c1200vu.m6692h());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2947a(@NotNull C1180va c1180va, @NotNull IPayloadContext iPayloadContext) {
        Player playerByUUID;
        EnumC0807oZ enumC0807oZM6597b = c1180va.m6597b();
        UUID uuidM6598b = c1180va.m6598b();
        if (enumC0807oZM6597b.getWaypoint() == null) {
            return;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ((C0326fV) c0622lM2667b.m2670a()).m1135b(uuidM6598b).m1664b(enumC0807oZM6597b);
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        if (clientLevel != null && (playerByUUID = clientLevel.getPlayerByUUID(uuidM6598b)) != null) {
            Vec3 vec3Position = playerByUUID.position();
            SoundManager soundManager = minecraft.getSoundManager();
            Holder.Reference<SoundEvent> soundEvent = enumC0807oZM6597b.getSoundEvent();
            if (soundEvent != null) {
                soundManager.play(new SimpleSoundInstance((SoundEvent) soundEvent.value(), SoundSource.NEUTRAL, 12.0f, 2.0f, clientLevel.getRandom(), vec3Position.x, vec3Position.y, vec3Position.z));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2948a(@NotNull C1184ve c1184ve, @NotNull IPayloadContext iPayloadContext) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0622lM2667b.m2685a().m33p();
    }

    /* JADX INFO: renamed from: a */
    public static void m2949a(@NotNull C1246wn c1246wn, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7551pi.get(), 1.0f, 1.0f));
        Screen screen = minecraft.screen;
        if (screen instanceof AbstractC0143cH) {
            ((AbstractC0143cH) screen).m790b(c1246wn.m7689b());
        } else {
            minecraft.gui.getChat().addMessage(c1246wn.m7689b());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2950a(@NotNull C1181vb c1181vb, @NotNull IPayloadContext iPayloadContext) {
        ChatGraphic chatGraphicM6601a = c1181vb.m6601a();
        Component componentM6602n = c1181vb.m6602n();
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null) {
            return;
        }
        MutableComponent mutableComponentEmpty = Component.empty();
        mutableComponentEmpty.append(String.valueOf(chatGraphicM6601a.getCharacter())).withColor(ColorReferences.COLOR_WHITE);
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(Math.max(0, chatGraphicM6601a.getWidth())));
        ObjectList<String> objectListM2131a = C0471iH.m2131a(font, componentM6602n.getString(), (minecraft.gui.getChat().getWidth() - font.width(sb.toString())) - 5);
        int iMax = Math.max(chatGraphicM6601a.getHeight(), objectListM2131a.size());
        mutableComponentEmpty.append(String.valueOf('\n'));
        for (int i = 0; i < iMax; i++) {
            if (i > 0) {
                mutableComponentEmpty.append(String.valueOf('\n'));
            }
            mutableComponentEmpty.append(sb.toString());
            if (i < objectListM2131a.size()) {
                mutableComponentEmpty.append(Component.literal((String) objectListM2131a.get(i)).withStyle(componentM6602n.getStyle()));
            }
        }
        localPlayer.sendSystemMessage(mutableComponentEmpty);
    }

    /* JADX INFO: renamed from: a */
    public static void m2951a(@NotNull C1173vT c1173vT, @NotNull IPayloadContext iPayloadContext) {
        C0415hE.m1960a(c1173vT.m6564c());
    }

    /* JADX INFO: renamed from: a */
    public static void m2952a(@NotNull C1160vG c1160vG, @NotNull IPayloadContext iPayloadContext) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        C0415hE.m1963a(c1160vG.m6507b(), localPlayer, new Vec3(c1160vG.m6508d()), c1160vG.m6509bQ());
    }

    /* JADX INFO: renamed from: a */
    public static void m2953a(@NotNull C1235wc c1235wc, @NotNull IPayloadContext iPayloadContext) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel == null) {
            return;
        }
        Entity entity = clientLevel.getEntity(c1235wc.m7642al());
        if (entity instanceof AbstractC0779ny) {
            ((AbstractC0779ny) entity).m3540u(c1235wc.m7643aA());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2954a(@NotNull C1154vA c1154vA, @NotNull IPayloadContext iPayloadContext) {
        if (C0424hN.f2723g.m1996T()) {
            C0622l c0622lM2667b = C0622l.m2667b();
            if (!f3606x && c0622lM2667b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            SoundManager soundManager = Minecraft.getInstance().getSoundManager();
            if (c0622lM2667b.m2688a() == null) {
                return;
            }
            if (C0172ck.f1429r == 0) {
                for (int i = 0; i < 3; i++) {
                    soundManager.playDelayed(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7515oy.get(), 1.0f, 6.0f), 2);
                }
            }
            C0172ck.f1429r = 2;
            C0172ck.f1430aS = c1154vA.m6487cT();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2955a(@NotNull C1192vm c1192vm, @NotNull IPayloadContext iPayloadContext) {
        C0049aT.f304i.add(c1192vm.m6644a());
    }

    /* JADX INFO: renamed from: a */
    public static void m2956a(@NotNull C1191vl c1191vl, @NotNull IPayloadContext iPayloadContext) {
        C0049aT.f305j.add(c1191vl.m6641a());
    }

    /* JADX INFO: renamed from: a */
    public static void m2957a(@NotNull C1190vk c1190vk, @NotNull IPayloadContext iPayloadContext) {
        C0178cm.f1458q.add(new C0178cm.a(c1190vk.m6638D(), c1190vk.m6637h()));
    }

    /* JADX INFO: renamed from: a */
    public static void m2958a(@NotNull C1244wl c1244wl, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        Vec3 eyePosition = localPlayer.getEyePosition();
        float fNextFloat = 0.9f + (ThreadLocalRandom.current().nextFloat() * 0.2f);
        for (int i = 0; i < 2; i++) {
            clientLevel.playLocalSound(eyePosition.x + 2.0d, eyePosition.y - 1.0d, eyePosition.z - 2.0d, (SoundEvent) C1280xc.f7829uA.get(), SoundSource.BLOCKS, 15.0f, fNextFloat, false);
            clientLevel.playLocalSound(eyePosition.x - 2.0d, eyePosition.y - 1.0d, eyePosition.z + 2.0d, (SoundEvent) C1280xc.f7829uA.get(), SoundSource.BLOCKS, 15.0f, fNextFloat, false);
        }
        C0054aY.f382cb = 1.0f;
        C0415hE.m1961a(C0418hH.f2693J, c1244wl.m7682de() ? 0.5f : 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m2959a(@NotNull C0519jC c0519jC, @NotNull IPayloadContext iPayloadContext) {
        if (!C0424hN.f2765S.m1996T()) {
            C0562jt.log("[Screenshot] Received screenshot request from server, but the player has not accepted the rules! Ignoring...", new Object[0]);
            C0562jt.log("[Screenshot] More information can be found here: 'https://www.blockfrontmc.com/privacy'.", new Object[0]);
        } else if (C0561js.m2512ab()) {
            C0562jt.log("[Screenshot] Received screenshot request from server! Initializing...", new Object[0]);
            C0562jt.log("[Screenshot] More information can be found here: 'https://www.blockfrontmc.com/privacy'.", new Object[0]);
            C0622l c0622lM2667b = C0622l.m2667b();
            if (!f3606x && c0622lM2667b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            ((C0940r) c0622lM2667b.m2667b()).m2582a().m5822j();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2960a(@NotNull C0518jB c0518jB, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        try {
            minecraft.setScreen(new C0141cF(NativeImage.read(new ByteBufInputStream(Unpooled.wrappedBuffer(c0518jB.m2277c())))));
        } catch (IOException e) {
            minecraft.gui.getChat().addMessage(f3602q);
            C0562jt.m2516a("Error while receiving screenshot.", e, new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2961a(C1161vH c1161vH, @NotNull IPayloadContext iPayloadContext) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c1161vH.m6512b().m2026a(c0622lM2667b.m2670a(), Minecraft.getInstance());
    }

    /* JADX INFO: renamed from: a */
    public static void m2962a(C1170vQ c1170vQ, @NotNull IPayloadContext iPayloadContext) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        C0709mh c0709mhM6555e = c1170vQ.m6555e();
        if (c0709mhM6555e != null) {
            c0622lM2667b.m2709a().m3224a(minecraft, c0709mhM6555e, c1170vQ.m6556p().orElse(null));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2963a(C1237we c1237we, @NotNull IPayloadContext iPayloadContext) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        if (abstractC0787oFM2688a != null) {
            c0622lM2667b.m2709a().m3222b(new C0720ms(abstractC0787oFM2688a, c1237we.m7648p(), c1237we.m7649dd()));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2964a(C1251ws c1251ws, IPayloadContext iPayloadContext) {
        try {
            C0622l c0622lM2667b = C0622l.m2667b();
            if (!f3606x && c0622lM2667b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
            if (abstractC0787oFM2688a == null) {
                return;
            }
            abstractC0787oFM2688a.m3629a().m6033b(c1251ws.m7710a());
            AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622lM2667b.m2692a();
            if (abstractC0788oGM2692a != null) {
                abstractC0788oGM2692a.m3727O(abstractC0787oFM2688a.m3629a().m6026ch());
            }
            c1251ws.m7711dv();
        } catch (Exception e) {
            C0562jt.logError("Failed to handle map vote info packet", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2965a(C1183vd c1183vd, @NotNull IPayloadContext iPayloadContext) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0622lM2667b.m2709a().m3221a(new C0718mq(c1183vd.m6608q(), c1183vd.m6609bK(), c1183vd.m6610bL(), c1183vd.m6611bM()));
    }

    /* JADX INFO: renamed from: a */
    public static void m2966a(C1165vL c1165vL, @NotNull IPayloadContext iPayloadContext) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622lM2667b.m2692a();
        if (abstractC0788oGM2692a == null) {
            return;
        }
        abstractC0788oGM2692a.m3747a(new C1013sT(c1165vL.m6530o(), c1165vL.m6531p(), c1165vL.m6532h()));
    }

    /* JADX INFO: renamed from: a */
    public static void m2967a(C1167vN c1167vN, @NotNull IPayloadContext iPayloadContext) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f3606x && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622lM2667b.m2692a();
        if (abstractC0788oGM2692a == null) {
            return;
        }
        abstractC0788oGM2692a.m3750a(c1167vN.m6539p(), c1167vN.m6538b(), c1167vN.m6540h());
    }

    /* JADX INFO: renamed from: a */
    public static void m2968a(@NotNull C1238wf c1238wf, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null || (abstractC0787oFM2688a = c0622lM2667b.m2688a()) == null) {
            return;
        }
        AbstractC0835pA abstractC0835pAM5608a = abstractC0787oFM2688a.m3653a().m5608a(c1238wf.m7652n());
        if (!(abstractC0835pAM5608a instanceof C0892qE)) {
            return;
        }
        ((C0892qE) abstractC0835pAM5608a).m4511a(c1238wf.m7653cn(), c1238wf.m7654co());
    }

    /* JADX INFO: renamed from: a */
    public static void m2969a(@NotNull C1156vC c1156vC, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null || (abstractC0787oFM2688a = c0622lM2667b.m2688a()) == null) {
            return;
        }
        Object objM5608a = abstractC0787oFM2688a.m3653a().m5608a(c1156vC.m6492n());
        if (objM5608a instanceof InterfaceC0845pK) {
            ((InterfaceC0845pK) objM5608a).mo4278g(Unpooled.wrappedBuffer(c1156vC.m6493e()));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2970a(@NotNull C1178vY c1178vY, @NotNull IPayloadContext iPayloadContext) {
        FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(Unpooled.wrappedBuffer(c1178vY.m6592e()));
        int i = friendlyByteBuf.readInt();
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap(i);
        for (int i2 = 0; i2 < i; i2++) {
            object2ObjectOpenHashMap.put(friendlyByteBuf.readUtf(), (AbstractC0835pA) C0836pB.f4477d.decode(new FriendlyByteBuf(Unpooled.wrappedBuffer(friendlyByteBuf.readByteArray()))));
        }
        int i3 = friendlyByteBuf.readInt();
        Object2ObjectOpenHashMap object2ObjectOpenHashMap2 = new Object2ObjectOpenHashMap(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            object2ObjectOpenHashMap2.put(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readUtf());
        }
        C0781o.m3542a(object2ObjectOpenHashMap, object2ObjectOpenHashMap2);
    }
}
