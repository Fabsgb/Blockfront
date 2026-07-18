package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.connection.Connection;
import com.boehmod.bflib.cloud.packet.PacketRegistry;
import com.boehmod.bflib.cloud.packet.common.PacketChatMessageFromCloud;
import com.boehmod.bflib.cloud.packet.common.PacketClientMessagePopup;
import com.boehmod.bflib.cloud.packet.common.PacketClientSound;
import com.boehmod.bflib.cloud.packet.common.PacketDailyReward;
import com.boehmod.bflib.cloud.packet.common.PacketNotificationFromCloud;
import com.boehmod.bflib.cloud.packet.common.PacketScreenshotRequest;
import com.boehmod.bflib.cloud.packet.common.PacketScreenshotResponse;
import com.boehmod.bflib.cloud.packet.common.PacketTriggerNewRank;
import com.boehmod.bflib.cloud.packet.common.discord.PacketDiscordLinkResponse;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryCaseResults;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemAdded;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemRemoved;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMJoinServer;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMSearchCloudCanceled;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyJoined;
import com.boehmod.bflib.cloud.packet.common.patreon.PacketPatreonLinkResponse;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedChallenges;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedClanData;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedCloudData;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedFriends;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedRecentMatches;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.cloud.connection.ModConnection;
import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.ints.IntListIterator;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.i */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/i.class */
public class C0463i {

    /* JADX INFO: renamed from: d */
    private static final Component f2872d;

    /* JADX INFO: renamed from: e */
    private static final Component f2873e;

    /* JADX INFO: renamed from: f */
    private static final Component f2874f;

    /* JADX INFO: renamed from: g */
    private static final Component f2875g;

    /* JADX INFO: renamed from: h */
    private static final Component f2876h;

    /* JADX INFO: renamed from: i */
    private static final Component f2877i;

    /* JADX INFO: renamed from: j */
    private static final Component f2878j;

    /* JADX INFO: renamed from: a */
    private static final float f2879a = 0.8f;

    /* JADX INFO: renamed from: t */
    static final /* synthetic */ boolean f2880t;

    static {
        f2880t = !C0463i.class.desiredAssertionStatus();
        f2872d = Component.translatable("bf.message.okay");
        f2873e = Component.translatable("bf.cloud.popup.discord.button");
        f2874f = Component.translatable("bf.cloud.popup.discord.button.tip", new Object[]{C0029a.f246a});
        f2875g = Component.literal("#verify").withStyle(C0565jw.f3202c);
        f2876h = Component.literal("/verify").withStyle(C0565jw.f3202c);
        f2877i = Component.translatable("bf.cloud.popup.discord.title");
        f2878j = Component.translatable("bf.cloud.popup.discord.message", new Object[]{f2875g, f2876h}).withColor(ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: b */
    static void m2071b() {
        C0562jt.log("[Cloud] Registering client-side cloud packet handlers...", new Object[0]);
        PacketRegistry.registerPacketHandler(PacketNotificationFromCloud.class, (v0, v1) -> {
            m2087a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketChatMessageFromCloud.class, (v0, v1) -> {
            m2077a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketClientSound.class, (v0, v1) -> {
            m2090a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketTriggerNewRank.class, (v0, v1) -> {
            m2091a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketClientMessagePopup.class, (v0, v1) -> {
            m2086a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketDailyReward.class, (v0, v1) -> {
            m2092a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketScreenshotRequest.class, (v0, v1) -> {
            m2088a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketInventoryCaseResults.class, (v0, v1) -> {
            m2085a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketInventoryItemAdded.class, (v0, v1) -> {
            m2072a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketInventoryItemRemoved.class, (v0, v1) -> {
            m2073a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedFriends.class, (v0, v1) -> {
            m2083a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedCloudData.class, (v0, v1) -> {
            m2084a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedChallenges.class, (v0, v1) -> {
            m2075a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedClanData.class, (v0, v1) -> {
            m2074a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedRecentMatches.class, (v0, v1) -> {
            m2076a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketPartyJoined.class, (v0, v1) -> {
            m2078a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketMMJoinServer.class, (v0, v1) -> {
            m2079a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketMMSearchCloudCanceled.class, (v0, v1) -> {
            m2082a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketDiscordLinkResponse.class, (v0, v1) -> {
            m2080a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketPatreonLinkResponse.class, (v0, v1) -> {
            m2081a(v0, v1);
        }, ModConnection.class);
        C0562jt.log("[Cloud] Finished registering client-side cloud packet handlers.", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public static void m2072a(@NotNull PacketInventoryItemAdded packetInventoryItemAdded, @NotNull Connection<?> connection) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2880t && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0482iS c0482iSM1676a = ((C0326fV) c0622lM2667b.m2670a()).m1676a(Minecraft.getInstance());
        Iterator<CloudItemStack> it = packetInventoryItemAdded.stacks().iterator();
        while (it.hasNext()) {
            c0482iSM1676a.getInventory().addItemStackLocal(it.next());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2073a(@NotNull PacketInventoryItemRemoved packetInventoryItemRemoved, @NotNull Connection<?> connection) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2880t && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0477iN inventory = ((C0326fV) c0622lM2667b.m2670a()).m1676a(Minecraft.getInstance()).getInventory();
        ObjectIterator it = packetInventoryItemRemoved.uuids().iterator();
        while (it.hasNext()) {
            inventory.removeItemStackLocal((UUID) it.next());
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2074a(@NotNull PacketRequestedClanData packetRequestedClanData, @NotNull Connection<?> connection) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2880t && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ((C0326fV) c0622lM2667b.m2670a()).m1134a(packetRequestedClanData.uuid(), packetRequestedClanData.clanData());
    }

    /* JADX INFO: renamed from: a */
    private static void m2075a(@NotNull PacketRequestedChallenges packetRequestedChallenges, @NotNull Connection<?> connection) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2880t && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ((C0326fV) c0622lM2667b.m2670a()).m1676a(Minecraft.getInstance()).setChallenges(packetRequestedChallenges.challenges());
    }

    /* JADX INFO: renamed from: a */
    private static void m2076a(@NotNull PacketRequestedRecentMatches packetRequestedRecentMatches, @NotNull Connection<?> connection) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2880t && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ((C0326fV) c0622lM2667b.m2670a()).mo1137a(packetRequestedRecentMatches.player()).m2200b(packetRequestedRecentMatches.matches());
    }

    /* JADX INFO: renamed from: a */
    public static void m2077a(@NotNull PacketChatMessageFromCloud packetChatMessageFromCloud, @NotNull Connection<?> connection) {
        MutableComponent mutableComponentFromJson = Component.Serializer.fromJson(packetChatMessageFromCloud.message(), RegistryAccess.EMPTY);
        if (mutableComponentFromJson == null) {
            return;
        }
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2880t && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (localPlayer != null && c0622lM2667b.m2688a() != null) {
            localPlayer.sendSystemMessage(mutableComponentFromJson);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2078a(@NotNull PacketPartyJoined packetPartyJoined, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) {
            minecraft.setScreen(new C0235dk());
        } else {
            minecraft.setScreen((Screen) null);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2079a(@NotNull PacketMMJoinServer packetMMJoinServer, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2880t && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0622lM2667b.m2699a().m2591a(minecraft, c0622lM2667b, packetMMJoinServer.address());
    }

    /* JADX INFO: renamed from: a */
    public static void m2080a(@NotNull PacketDiscordLinkResponse packetDiscordLinkResponse, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.screen instanceof C0234dj) {
            minecraft.keyboardHandler.setClipboard(packetDiscordLinkResponse.auth());
            C0622l.m2668a(f2877i, f2878j, PopupType.DISCORD_LINK, new C0121bm(f2872d, null, button -> {
                minecraft.setScreen(new C0235dk());
            }), new C0121bm(f2873e, f2874f, button2 -> {
                C0234dj.m1186b(minecraft, C0560jr.f3182aB);
            }));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2081a(@NotNull PacketPatreonLinkResponse packetPatreonLinkResponse, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        C0234dj.m1186b(minecraft, packetPatreonLinkResponse.oauthUrl());
        C0287ej.m1507a(minecraft, (Component) Component.translatable("bf.message.patreon.browser.opened"));
    }

    /* JADX INFO: renamed from: a */
    public static void m2082a(@NotNull PacketMMSearchCloudCanceled packetMMSearchCloudCanceled, @NotNull Connection<?> connection) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2880t && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0622lM2667b.m2699a().m2598a(false);
    }

    /* JADX INFO: renamed from: a */
    public static void m2083a(@NotNull PacketRequestedFriends packetRequestedFriends, @NotNull Connection<?> connection) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2880t && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0622lM2667b.m2676a().m4461a(packetRequestedFriends.friends(), packetRequestedFriends.requests(), packetRequestedFriends.clanRequests());
    }

    /* JADX INFO: renamed from: a */
    public static void m2084a(@NotNull PacketRequestedCloudData packetRequestedCloudData, @NotNull Connection<?> connection) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2880t && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        ((C0357g) c0622lM2667b.m2667b()).f2443i = packetRequestedCloudData.getUsersOnline();
        C0424hN.f2715c.clear();
        C0424hN.f2715c.putAll(packetRequestedCloudData.getGamePlayerCount());
        C0424hN.f2714b.clear();
        C0424hN.f2713a.clear();
        C0424hN.f2772f = packetRequestedCloudData.getScoreboardResetTime();
        C0424hN.f2714b.putAll(packetRequestedCloudData.getClanScores());
        C0424hN.f2713a.putAll(packetRequestedCloudData.getPlayerScores());
        Screen screen = minecraft.screen;
        if (screen instanceof AbstractC0250dz) {
            ((AbstractC0250dz) screen).m1418ae();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2085a(@NotNull PacketInventoryCaseResults packetInventoryCaseResults, @NotNull Connection<?> connection) {
        Screen screen = Minecraft.getInstance().screen;
        if (screen instanceof C0241dq) {
            C0241dq c0241dq = (C0241dq) screen;
            ObjectArrayList objectArrayList = new ObjectArrayList();
            IntListIterator it = packetInventoryCaseResults.results().iterator();
            while (it.hasNext()) {
                objectArrayList.add(new CloudItemStack(UUID.randomUUID(), ((Integer) it.next()).intValue()));
            }
            c0241dq.m1406a((ObjectList<CloudItemStack>) objectArrayList);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2086a(@NotNull PacketClientMessagePopup packetClientMessagePopup, @NotNull Connection<?> connection) {
        Component componentFromJson = Component.Serializer.fromJson(packetClientMessagePopup.title(), RegistryAccess.EMPTY);
        Component componentFromJson2 = Component.Serializer.fromJson(packetClientMessagePopup.message(), RegistryAccess.EMPTY);
        if (componentFromJson == null || componentFromJson2 == null) {
            C0562jt.log("Failed to parse popup message: " + packetClientMessagePopup.title() + " | " + packetClientMessagePopup.message(), new Object[0]);
            return;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b != null) {
            c0622lM2667b.m2707a(componentFromJson, componentFromJson2, packetClientMessagePopup.type());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2087a(@NotNull PacketNotificationFromCloud packetNotificationFromCloud, @NotNull Connection<?> connection) {
        if (C0424hN.m1999a(packetNotificationFromCloud.type())) {
            String strMessage = packetNotificationFromCloud.message();
            MutableComponent mutableComponentFromJson = Component.Serializer.fromJson(strMessage, RegistryAccess.EMPTY);
            if (mutableComponentFromJson == null) {
                C0562jt.log("Failed to parse notification message from cloud! %s", strMessage);
            } else {
                C0287ej.m1510a(Minecraft.getInstance(), (Component) Component.literal("BlockFront Cloud"), (Component) mutableComponentFromJson, true);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2088a(@NotNull PacketScreenshotRequest packetScreenshotRequest, @NotNull Connection<?> connection) {
        if (!C0424hN.f2765S.m1996T()) {
            C0562jt.log("[Screenshot] Received cloud screenshot request, but the player has not accepted the rules! Ignoring...", new Object[0]);
            C0562jt.log("[Screenshot] More information can be found here: 'https://www.blockfrontmc.com/privacy'.", new Object[0]);
        } else if (RenderSystem.isOnRenderThread()) {
            m2089a(packetScreenshotRequest.requestId(), connection);
        } else {
            RenderSystem.recordRenderCall(() -> {
                m2089a(packetScreenshotRequest.requestId(), (Connection<?>) connection);
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static void m2089a(@NotNull UUID uuid, @NotNull Connection<?> connection) {
        try {
            connection.sendPacket(new PacketScreenshotResponse(uuid, C1047t.m5825a(f2879a)));
        } catch (IOException e) {
            C0562jt.m2516a("[Screenshot] Failed to capture cloud screenshot.", e, new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2090a(@NotNull PacketClientSound packetClientSound, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        SoundEvent soundEventM7799a = C1280xc.m7799a(packetClientSound.sound());
        if (soundEventM7799a != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(soundEventM7799a, 1.0f, 1.0f));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2091a(@NotNull PacketTriggerNewRank packetTriggerNewRank, @NotNull Connection<?> connection) {
        C0197cz.f1595aX = true;
    }

    /* JADX INFO: renamed from: a */
    public static void m2092a(@NotNull PacketDailyReward packetDailyReward, @NotNull Connection<?> connection) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2880t && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0622lM2667b.m2705a(packetDailyReward);
    }
}
