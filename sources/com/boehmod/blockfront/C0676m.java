package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ChatGraphic;
import com.boehmod.bflib.common.ColorReferences;
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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/m.class */
public class C0676m {

    /* JADX INFO: renamed from: q */
    private static final Component f3713q;

    /* JADX INFO: renamed from: s */
    private static final int f3714s = 3;

    /* JADX INFO: renamed from: t */
    public static final int f3715t = 2;

    /* JADX INFO: renamed from: a */
    private static final double f3716a = 256.0d;

    /* JADX INFO: renamed from: y */
    static final /* synthetic */ boolean f3717y;

    static {
        f3717y = !C0676m.class.desiredAssertionStatus();
        f3713q = Component.translatable("bf.message.screenshot.request.error");
    }

    /* JADX INFO: renamed from: a */
    public static void m2938a(@NotNull C1176vV c1176vV, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0881pt c0881ptM6690k = c1176vV.m6690k();
        boolean z = c0881ptM6690k != null;
        C0394gj c0394gjM1885a = ((C0396gl) c0623lM2852b.m2855a()).m1885a(minecraft);
        if (!clientLevel.isClientSide() && !minecraft.hasSingleplayerServer()) {
            c0394gjM1885a.m1111aa(z);
        }
        if (z) {
            localPlayer.teleportTo(c0881ptM6690k.f4827c.x, c0881ptM6690k.f4827c.y, c0881ptM6690k.f4827c.z);
            if (localPlayer.getHealth() > 0.0f) {
                c0394gjM1885a.m1109e(c0881ptM6690k);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2939a(@NotNull C1220wM c1220wM, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        boolean zM6961do = c1220wM.m6961do();
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        try {
            if (zM6961do) {
                ByteBuf byteBufM6960a = c1220wM.m6960a();
                if (abstractC0863pbM2874a == null) {
                    String strM6962T = c1220wM.m6962T();
                    if (strM6962T == null) {
                        c1220wM.m6963dF();
                        return;
                    }
                    C1094tt c1094ttM6019a = C1094tt.m6019a(strM6962T);
                    if (c1094ttM6019a == null) {
                        c1220wM.m6963dF();
                        return;
                    }
                    try {
                        AbstractC0863pb<?, ?, ?> abstractC0863pbNewInstance = c1094ttM6019a.m6021b().getDeclaredConstructor(AbstractC0531jN.class).newInstance(c0623lM2852b);
                        abstractC0863pbNewInstance.mo4052g(byteBufM6960a);
                        c0623lM2852b.m2879a(minecraft, c0396gl, clientLevel, abstractC0863pbNewInstance);
                        AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623lM2852b.m2878a();
                        if (abstractC0864pcM2878a != null) {
                            abstractC0864pcM2878a.m4175b(byteBufM6960a);
                        }
                    } catch (IOException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        abstractC0863pbM2874a.mo4052g(byteBufM6960a);
                        AbstractC0864pc<?, ?> abstractC0864pcM2878a2 = c0623lM2852b.m2878a();
                        if (abstractC0864pcM2878a2 != null) {
                            abstractC0864pcM2878a2.m4175b(byteBufM6960a);
                        }
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            } else if (abstractC0863pbM2874a != null) {
                c0623lM2852b.m2879a(minecraft, c0396gl, clientLevel, (AbstractC0863pb<?, ?, ?>) null);
            }
            c1220wM.m6963dF();
        } catch (Throwable th) {
            c1220wM.m6963dF();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2940a(@NotNull C1222wO c1222wO, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0623lM2852b.m2874a() != null && (abstractC0864pcM2878a = c0623lM2852b.m2878a()) != null) {
            abstractC0864pcM2878a.m4171a(c0623lM2852b.m2886a(), c1222wO.m6970a());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2941a(@NotNull C1223wP c1223wP, @NotNull IPayloadContext iPayloadContext) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0623lM2852b.m2874a() == null) {
            return;
        }
        C1089to c1089to = new C1089to(c1223wP.m6973b(), c1223wP.m6974n(), c1223wP.m6975cc());
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623lM2852b.m2878a();
        if (abstractC0864pcM2878a != null) {
            abstractC0864pcM2878a.m4174a(c1089to);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2942a(@NotNull C1237wd c1237wd, @NotNull IPayloadContext iPayloadContext) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel == null) {
            return;
        }
        UUID uuid = c1237wd.m7023a().getUUID();
        for (AbstractClientPlayer abstractClientPlayer : clientLevel.players()) {
            if (abstractClientPlayer.getUUID().equals(uuid)) {
                abstractClientPlayer.refreshDimensions();
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2943a(@NotNull C1287xa c1287xa, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        ItemStack itemStackM7311o = c1287xa.m7311o();
        if (itemStackM7311o.isEmpty()) {
            return;
        }
        Item item = itemStackM7311o.getItem();
        if (item instanceof C1117uP) {
            C1117uP c1117uP = (C1117uP) item;
            int iM7313cG = c1287xa.m7313cG();
            if (iM7313cG == 0 || c1287xa.m7315dr() || localPlayer.getId() != iM7313cG) {
                C0623l c0623lM2852b = C0623l.m2852b();
                if (!f3717y && c0623lM2852b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0487iW.m2197a(minecraft, c0623lM2852b, (C0396gl) c0623lM2852b.m2855a(), localPlayer, clientLevel, itemStackM7311o, c1117uP, c1287xa.m7312h(), false, c1287xa.m7314dq(), c1287xa.m7316ds(), iM7313cG);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2944a(@NotNull C1215wH c1215wH, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (clientLevel == null || localPlayer == null || localPlayer.getId() == c1215wH.m6936aB()) {
            return;
        }
        for (C1115uN c1115uN : c1215wH.m6937aT()) {
            C0623l c0623lM2852b = C0623l.m2852b();
            if (!f3717y && c0623lM2852b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            LivingEntity entity = clientLevel.getEntity(c1115uN.m6248aB());
            if (entity instanceof LivingEntity) {
                C0054aX.m251a(minecraft, c0623lM2852b, clientLevel, clientLevel.getRandom(), threadLocalRandomCurrent, localPlayer, entity, c1115uN.m6255A(), c1115uN.m6254b(), c1115uN.m6250an());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2945a(@NotNull C1214wG c1214wG, @NotNull IPayloadContext iPayloadContext) {
        int iM6932cG;
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null || (iM6932cG = c1214wG.m6932cG()) == localPlayer.getId()) {
            return;
        }
        LivingEntity entity = clientLevel.getEntity(iM6932cG);
        if (entity != null || iM6932cG == 0) {
            C0623l c0623lM2852b = C0623l.m2852b();
            if (!f3717y && c0623lM2852b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            LivingEntity livingEntity = entity instanceof LivingEntity ? entity : null;
            RandomSource random = clientLevel.getRandom();
            List<C1114uM> listM6933aS = c1214wG.m6933aS();
            Iterator<C1114uM> it = listM6933aS.iterator();
            while (it.hasNext()) {
                C0054aX.m247a(minecraft, c0623lM2852b, clientLevel, random, localPlayer, livingEntity, it.next(), c1214wG.m6932cG());
            }
            if (!listM6933aS.isEmpty() && livingEntity != null) {
                C0054aX.m252a(minecraft, clientLevel, listM6933aS.get(listM6933aS.size() - 1), livingEntity.getEyePosition(), random);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2946a(@NotNull C1230wW c1230wW, @NotNull IPayloadContext iPayloadContext) {
        C0112bc.f733br = c1230wW.m7002ce();
        SoundManager soundManager = Minecraft.getInstance().getSoundManager();
        soundManager.stop();
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f8199tM.get(), 1.0f));
    }

    /* JADX INFO: renamed from: a */
    public static void m2947a(@NotNull C1254wu c1254wu, @NotNull IPayloadContext iPayloadContext) {
        Minecraft.getInstance().getSoundManager().play(new SimpleSoundInstance(((SoundEvent) c1254wu.m7093c().value()).getLocation(), c1254wu.m7094a(), c1254wu.m7095bV(), c1254wu.m7096bU(), SoundInstance.createUnseededRandom(), false, 0, SoundInstance.Attenuation.NONE, 0.0d, 0.0d, 0.0d, true));
    }

    /* JADX INFO: renamed from: a */
    public static void m2948a(@NotNull C1255wv c1255wv, @NotNull IPayloadContext iPayloadContext) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel != null) {
            Vec3 vec3M7103h = c1255wv.m7103h();
            clientLevel.playLocalSound(vec3M7103h.x, vec3M7103h.y, vec3M7103h.z, (SoundEvent) c1255wv.m7099c().value(), c1255wv.m7100a(), c1255wv.m7101bV(), c1255wv.m7102bU(), false);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2949a(@NotNull C1160vF c1160vF, @NotNull IPayloadContext iPayloadContext) {
        C0301ew.m1627a(Minecraft.getInstance(), c1160vF.m6611a(), c1160vF.m6612o(), c1160vF.m6613b(), true);
    }

    /* JADX INFO: renamed from: a */
    public static void m2950a(@NotNull C1177vW c1177vW, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0623lM2852b.m2874a() != null && (abstractC0864pcM2878a = c0623lM2852b.m2878a()) != null) {
            abstractC0864pcM2878a.m4191a(c1177vW.m6693aR(), c1177vW.m6694cA(), c1177vW.m6695aa(), c1177vW.m6696h(), c1177vW.m6697cB(), c1177vW.m6698L());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2951a(@NotNull C1238we c1238we, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0623lM2852b.m2874a() != null && (abstractC0864pcM2878a = c0623lM2852b.m2878a()) != null) {
            abstractC0864pcM2878a.m4172a(c1238we.m7026a());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2952a(@NotNull C1217wJ c1217wJ, @NotNull IPayloadContext iPayloadContext) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null || localPlayer.getId() == c1217wJ.m6943aB()) {
            return;
        }
        C0113bd.f766m.add(c1217wJ.m6944b());
    }

    /* JADX INFO: renamed from: a */
    public static void m2953a(@NotNull C1256ww c1256ww, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        LivingEntity entity = clientLevel.getEntity(c1256ww.m7106cC());
        if ((entity instanceof AbstractClientPlayer) || (entity instanceof C0756na)) {
            C0623l c0623lM2852b = C0623l.m2852b();
            if (!f3717y && c0623lM2852b == null) {
                throw new AssertionError("Mod manager is null!");
            }
            c0623lM2852b.m2871a().m66a(minecraft, clientLevel, localPlayer, entity, c1256ww.m7107a(), ThreadLocalRandom.current());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2954a(@NotNull C1213wF c1213wF, @NotNull IPayloadContext iPayloadContext) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel == null) {
            return;
        }
        clientLevel.setSkyFlashTime(c1213wF.m6929cF());
    }

    /* JADX INFO: renamed from: a */
    public static void m2955a(@NotNull C1242wi c1242wi, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0623lM2852b.m2874a() == null || (abstractC0864pcM2878a = c0623lM2852b.m2878a()) == null) {
            return;
        }
        List<C0839pD> listM4143z = abstractC0864pcM2878a.m4143z();
        if (listM4143z.size() >= 5) {
            listM4143z.removeFirst();
        }
        EnumC0960rS enumC0960rSM7046b = c1242wi.m7046b();
        if (enumC0960rSM7046b.isWaypoint()) {
            abstractC0864pcM2878a.m4144cB();
        }
        abstractC0864pcM2878a.m4145a(new C0839pD(c1242wi.m7043aG(), c1242wi.m7044cA(), c1242wi.m7045h(), enumC0960rSM7046b));
    }

    /* JADX INFO: renamed from: a */
    public static void m2956a(@NotNull C1174vT c1174vT, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        if (clientLevel == null) {
            return;
        }
        C0756na entity = clientLevel.getEntity(c1174vT.m6680cy());
        if ((!(entity instanceof C0756na) || C0495ie.f3052F.m2230U()) && (entity instanceof LivingEntity)) {
            LivingEntity livingEntity = (LivingEntity) entity;
            SoundManager soundManager = minecraft.getSoundManager();
            SoundEvent soundEvent = (SoundEvent) c1174vT.m6678b().value();
            LocalPlayer localPlayer = minecraft.player;
            boolean z = localPlayer != null && entity.distanceToSqr(localPlayer) >= f3716a;
            if (c1174vT.m6676db() && z) {
                Vec3 vec3Position = entity.position();
                AbstractSoundInstance c0470iF = new C0470iF(soundEvent, c1174vT.m6679a(), c1174vT.m6682bV(), c1174vT.m6681bU(), SoundInstance.createUnseededRandom(), vec3Position.x, vec3Position.y, vec3Position.z);
                if (entity instanceof C0756na) {
                    C0756na c0756na = entity;
                    if (c1174vT.m6674cZ()) {
                        c0756na.m3522bI();
                    }
                    c0756na.m3521b(c0470iF);
                }
                soundManager.play(c0470iF);
                return;
            }
            AbstractSoundInstance c0474iJ = new C0474iJ(livingEntity, soundEvent, c1174vT.m6679a(), c1174vT.m6681bU(), c1174vT.m6682bV(), c1174vT.m6675da());
            if (entity instanceof C0756na) {
                C0756na c0756na2 = entity;
                if (c1174vT.m6674cZ()) {
                    c0756na2.m3522bI();
                }
                c0756na2.m3521b(c0474iJ);
            }
            soundManager.play(c0474iJ);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2957a(@NotNull C1175vU c1175vU, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        if (clientLevel != null) {
            C0623l c0623lM2852b = C0623l.m2852b();
            if (!f3717y && c0623lM2852b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            C0693mQ.m3103a(minecraft, c0623lM2852b, clientLevel, c1175vU.m6686a(), c1175vU.m6687h());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2958a(@NotNull C1155vA c1155vA, @NotNull IPayloadContext iPayloadContext) {
        Player playerByUUID;
        EnumC0883pv enumC0883pvM6592b = c1155vA.m6592b();
        UUID uuidM6593b = c1155vA.m6593b();
        if (enumC0883pvM6592b.getWaypoint() == null) {
            return;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ((C0396gl) c0623lM2852b.m2855a()).m1152b(uuidM6593b).m1874b(enumC0883pvM6592b);
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        if (clientLevel != null && (playerByUUID = clientLevel.getPlayerByUUID(uuidM6593b)) != null) {
            Vec3 vec3Position = playerByUUID.position();
            SoundManager soundManager = minecraft.getSoundManager();
            Holder.Reference<SoundEvent> soundEvent = enumC0883pvM6592b.getSoundEvent();
            if (soundEvent != null) {
                soundManager.play(new SimpleSoundInstance((SoundEvent) soundEvent.value(), SoundSource.NEUTRAL, 12.0f, 2.0f, clientLevel.getRandom(), vec3Position.x, vec3Position.y, vec3Position.z));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2959a(@NotNull C1159vE c1159vE, @NotNull IPayloadContext iPayloadContext) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0623lM2852b.m2871a().m65s();
    }

    /* JADX INFO: renamed from: a */
    public static void m2960a(@NotNull C1219wL c1219wL, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7963pk.get(), 1.0f, 1.0f));
        Screen screen = minecraft.screen;
        if (screen instanceof AbstractC0153cQ) {
            ((AbstractC0153cQ) screen).m844b(c1219wL.m6957b());
        } else {
            minecraft.gui.getChat().addMessage(c1219wL.m6957b());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2961a(@NotNull C1156vB c1156vB, @NotNull IPayloadContext iPayloadContext) {
        ChatGraphic chatGraphicM6596a = c1156vB.m6596a();
        Component componentM6597n = c1156vB.m6597n();
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null) {
            return;
        }
        MutableComponent mutableComponentEmpty = Component.empty();
        mutableComponentEmpty.append(String.valueOf(chatGraphicM6596a.getCharacter())).withColor(ColorReferences.COLOR_WHITE);
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(Math.max(0, chatGraphicM6596a.getWidth())));
        ObjectList<String> objectListM2458a = C0544ja.m2458a(font, componentM6597n.getString(), (minecraft.gui.getChat().getWidth() - font.width(sb.toString())) - 5);
        int iMax = Math.max(chatGraphicM6596a.getHeight(), objectListM2458a.size());
        mutableComponentEmpty.append(String.valueOf('\n'));
        for (int i = 0; i < iMax; i++) {
            if (i > 0) {
                mutableComponentEmpty.append(String.valueOf('\n'));
            }
            mutableComponentEmpty.append(sb.toString());
            if (i < objectListM2458a.size()) {
                mutableComponentEmpty.append(Component.literal((String) objectListM2458a.get(i)).withStyle(componentM6597n.getStyle()));
            }
        }
        localPlayer.sendSystemMessage(mutableComponentEmpty);
    }

    /* JADX INFO: renamed from: a */
    public static void m2962a(@NotNull C1253wt c1253wt, @NotNull IPayloadContext iPayloadContext) {
        C0432hU.m1986a(c1253wt.m7090d());
    }

    /* JADX INFO: renamed from: a */
    public static void m2963a(@NotNull C1239wf c1239wf, @NotNull IPayloadContext iPayloadContext) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        C0432hU.m1989a(c1239wf.m7030c(), localPlayer, new Vec3(c1239wf.m7031b()), c1239wf.m7032bW());
    }

    /* JADX INFO: renamed from: a */
    public static void m2964a(@NotNull C1209wB c1209wB, @NotNull IPayloadContext iPayloadContext) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel == null) {
            return;
        }
        Entity entity = clientLevel.getEntity(c1209wB.m6914aB());
        if (entity instanceof AbstractC0750nU) {
            ((AbstractC0750nU) entity).m3477u(c1209wB.m6915aH());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2965a(@NotNull C1180vZ c1180vZ, @NotNull IPayloadContext iPayloadContext) {
        if (C0495ie.f3024g.m2230U()) {
            C0623l c0623lM2852b = C0623l.m2852b();
            if (!f3717y && c0623lM2852b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            SoundManager soundManager = Minecraft.getInstance().getSoundManager();
            if (c0623lM2852b.m2874a() == null) {
                return;
            }
            if (C0192ct.f1553t == 0) {
                for (int i = 0; i < 3; i++) {
                    soundManager.playDelayed(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7927oA.get(), 1.0f, 6.0f), 2);
                }
            }
            C0192ct.f1553t = 2;
            C0192ct.f1554aX = c1180vZ.m6707dc();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2966a(@NotNull C1167vM c1167vM, @NotNull IPayloadContext iPayloadContext) {
        C0111bb.f718j.add(c1167vM.m6639a());
    }

    /* JADX INFO: renamed from: a */
    public static void m2967a(@NotNull C1166vL c1166vL, @NotNull IPayloadContext iPayloadContext) {
        C0111bb.f719k.add(c1166vL.m6636a());
    }

    /* JADX INFO: renamed from: a */
    public static void m2968a(@NotNull C1165vK c1165vK, @NotNull IPayloadContext iPayloadContext) {
        C0194cv.f1565z.add(new C0194cv.a(c1165vK.m6633D(), c1165vK.m6632h()));
    }

    /* JADX INFO: renamed from: a */
    public static void m2969a(@NotNull C1216wI c1216wI, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        Vec3 eyePosition = localPlayer.getEyePosition();
        float fNextFloat = 0.9f + (ThreadLocalRandom.current().nextFloat() * 0.2f);
        for (int i = 0; i < 2; i++) {
            clientLevel.playLocalSound(eyePosition.x + 2.0d, eyePosition.y - 1.0d, eyePosition.z - 2.0d, (SoundEvent) C1312xz.f8242uD.get(), SoundSource.BLOCKS, 15.0f, fNextFloat, false);
            clientLevel.playLocalSound(eyePosition.x - 2.0d, eyePosition.y - 1.0d, eyePosition.z + 2.0d, (SoundEvent) C1312xz.f8242uD.get(), SoundSource.BLOCKS, 15.0f, fNextFloat, false);
        }
        C0116bg.f796ch = 1.0f;
        C0432hU.m1987a(C0435hX.f2786J, c1216wI.m6940dn() ? 0.4f : 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m2970a(@NotNull C0539jV c0539jV, @NotNull IPayloadContext iPayloadContext) {
        if (!C0495ie.f3066S.m2230U()) {
            C0530jM.log("[Screenshot] Received screenshot request from server, but the player has not accepted the rules! Ignoring...", new Object[0]);
            C0530jM.log("[Screenshot] More information can be found here: 'https://www.blockfrontmc.com/privacy'.", new Object[0]);
        } else if (C0529jL.m2332ae()) {
            C0530jM.log("[Screenshot] Received screenshot request from server! Initializing...", new Object[0]);
            C0530jM.log("[Screenshot] More information can be found here: 'https://www.blockfrontmc.com/privacy'.", new Object[0]);
            C0623l c0623lM2852b = C0623l.m2852b();
            if (!f3717y && c0623lM2852b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            ((C0994s) c0623lM2852b.m2852b()).m2407a().m6186l();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2971a(@NotNull C0538jU c0538jU, @NotNull IPayloadContext iPayloadContext) {
        Minecraft minecraft = Minecraft.getInstance();
        try {
            minecraft.setScreen(new C0151cO(NativeImage.read(new ByteBufInputStream(Unpooled.wrappedBuffer(c0538jU.m2411c())))));
        } catch (IOException e) {
            minecraft.gui.getChat().addMessage(f3713q);
            C0530jM.m2338a("Error while receiving screenshot.", e, new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2972a(C1240wg c1240wg, @NotNull IPayloadContext iPayloadContext) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c1240wg.m7035b().m2260a(c0623lM2852b.m2855a(), Minecraft.getInstance());
    }

    /* JADX INFO: renamed from: a */
    public static void m2973a(C1250wq c1250wq, @NotNull IPayloadContext iPayloadContext) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        C0680mD c0680mDM7081e = c1250wq.m7081e();
        if (c0680mDM7081e != null) {
            c0623lM2852b.m2895a().m3055a(minecraft, c0680mDM7081e, c1250wq.m7082p().orElse(null));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2974a(C1211wD c1211wD, @NotNull IPayloadContext iPayloadContext) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a != null) {
            c0623lM2852b.m2895a().m3053b(new C0691mO(abstractC0863pbM2874a, c1211wD.m6920p(), c1211wD.m6921dm()));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2975a(C1224wQ c1224wQ, IPayloadContext iPayloadContext) {
        try {
            C0623l c0623lM2852b = C0623l.m2852b();
            if (!f3717y && c0623lM2852b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
            if (abstractC0863pbM2874a == null) {
                return;
            }
            abstractC0863pbM2874a.m4065a().m5919b(c1224wQ.m6978a());
            AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623lM2852b.m2878a();
            if (abstractC0864pcM2878a != null) {
                abstractC0864pcM2878a.m4163P(abstractC0863pbM2874a.m4065a().m5912cr());
            }
            c1224wQ.m6979dF();
        } catch (Exception e) {
            C0530jM.logError("Failed to handle map vote info packet", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2976a(C1158vD c1158vD, @NotNull IPayloadContext iPayloadContext) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0623lM2852b.m2895a().m3052a(new C0689mM(c1158vD.m6603u(), c1158vD.m6604bQ(), c1158vD.m6605bR(), c1158vD.m6606bS()));
    }

    /* JADX INFO: renamed from: a */
    public static void m2977a(C1244wk c1244wk, @NotNull IPayloadContext iPayloadContext) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623lM2852b.m2878a();
        if (abstractC0864pcM2878a == null) {
            return;
        }
        abstractC0864pcM2878a.m4183a(new C1091tq(c1244wk.m7053o(), c1244wk.m7054p(), c1244wk.m7055h()));
    }

    /* JADX INFO: renamed from: a */
    public static void m2978a(C1246wm c1246wm, @NotNull IPayloadContext iPayloadContext) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3717y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623lM2852b.m2878a();
        if (abstractC0864pcM2878a == null) {
            return;
        }
        abstractC0864pcM2878a.m4186a(c1246wm.m7062p(), c1246wm.m7061b(), c1246wm.m7063h());
    }

    /* JADX INFO: renamed from: a */
    public static void m2979a(@NotNull C1212wE c1212wE, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null || (abstractC0863pbM2874a = c0623lM2852b.m2874a()) == null) {
            return;
        }
        AbstractC0858pW abstractC0858pWM6096a = abstractC0863pbM2874a.m4089a().m6096a(c1212wE.m6924n());
        if (!(abstractC0858pWM6096a instanceof C0969rb)) {
            return;
        }
        ((C0969rb) abstractC0858pWM6096a).m5406a(c1212wE.m6925cD(), c1212wE.m6926cE());
    }

    /* JADX INFO: renamed from: a */
    public static void m2980a(@NotNull C1235wb c1235wb, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null || (abstractC0863pbM2874a = c0623lM2852b.m2874a()) == null) {
            return;
        }
        Object objM6096a = abstractC0863pbM2874a.m4089a().m6096a(c1235wb.m7015n());
        if (objM6096a instanceof InterfaceC0921qg) {
            ((InterfaceC0921qg) objM6096a).mo5072g(Unpooled.wrappedBuffer(c1235wb.m7016e()));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2981a(@NotNull C1258wy c1258wy, @NotNull IPayloadContext iPayloadContext) {
        FriendlyByteBuf friendlyByteBuf = new FriendlyByteBuf(Unpooled.wrappedBuffer(c1258wy.m7118e()));
        int i = friendlyByteBuf.readInt();
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap(i);
        for (int i2 = 0; i2 < i; i2++) {
            object2ObjectOpenHashMap.put(friendlyByteBuf.readUtf(), (AbstractC0858pW) C0859pX.f4606d.decode(new FriendlyByteBuf(Unpooled.wrappedBuffer(friendlyByteBuf.readByteArray()))));
        }
        int i3 = friendlyByteBuf.readInt();
        Object2ObjectOpenHashMap object2ObjectOpenHashMap2 = new Object2ObjectOpenHashMap(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            object2ObjectOpenHashMap2.put(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()), friendlyByteBuf.readUtf());
        }
        C0782o.m3658a(object2ObjectOpenHashMap, object2ObjectOpenHashMap2);
    }
}
