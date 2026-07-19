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
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMJoinServer;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMSearchCloudCanceled;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/i.class */
public class C0217i {
    private static final Component d;
    private static final Component e;
    private static final Component f;
    private static final Component g;
    private static final Component h;
    private static final Component i;
    private static final Component j;
    private static final float a = 0.8f;
    static final /* synthetic */ boolean t;

    static {
        t = !C0217i.class.desiredAssertionStatus();
        d = Component.translatable("bf.message.okay");
        e = Component.translatable("bf.cloud.popup.discord.button");
        f = Component.translatable("bf.cloud.popup.discord.button.tip", new Object[]{C0002a.a});
        g = Component.literal("#verify").withStyle(C0266jw.c);
        h = Component.literal("/verify").withStyle(C0266jw.c);
        i = Component.translatable("bf.cloud.popup.discord.title");
        j = Component.translatable("bf.cloud.popup.discord.message", new Object[]{g, h}).withColor(ColorReferences.COLOR_WHITE);
    }

    static void b() {
        C0263jt.log("[Cloud] Registering client-side cloud packet handlers...", new Object[0]);
        PacketRegistry.registerPacketHandler(PacketNotificationFromCloud.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketChatMessageFromCloud.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketClientSound.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketTriggerNewRank.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketClientMessagePopup.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketDailyReward.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketScreenshotRequest.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketInventoryCaseResults.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketInventoryItemAdded.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketInventoryItemRemoved.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedFriends.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedCloudData.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedChallenges.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedClanData.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedRecentMatches.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketPartyJoined.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketMMJoinServer.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketMMSearchCloudCanceled.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketDiscordLinkResponse.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketPatreonLinkResponse.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        C0263jt.log("[Cloud] Finished registering client-side cloud packet handlers.", new Object[0]);
    }

    public static void a(@NotNull PacketInventoryItemAdded packetInventoryItemAdded, @NotNull Connection<?> connection) {
        C0297l c0297lB = C0297l.b();
        if (!t && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        iS iSVarM404a = ((fV) c0297lB.a()).m404a(Minecraft.getInstance());
        Iterator<CloudItemStack> it = packetInventoryItemAdded.stacks().iterator();
        while (it.hasNext()) {
            iSVarM404a.getInventory().addItemStackLocal(it.next());
        }
    }

    public static void a(@NotNull PacketInventoryItemRemoved packetInventoryItemRemoved, @NotNull Connection<?> connection) {
        C0297l c0297lB = C0297l.b();
        if (!t && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        iN inventory = ((fV) c0297lB.a()).m404a(Minecraft.getInstance()).getInventory();
        ObjectIterator it = packetInventoryItemRemoved.uuids().iterator();
        while (it.hasNext()) {
            inventory.removeItemStackLocal((UUID) it.next());
        }
    }

    private static void a(@NotNull PacketRequestedClanData packetRequestedClanData, @NotNull Connection<?> connection) {
        C0297l c0297lB = C0297l.b();
        if (!t && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ((fV) c0297lB.a()).a(packetRequestedClanData.uuid(), packetRequestedClanData.clanData());
    }

    private static void a(@NotNull PacketRequestedChallenges packetRequestedChallenges, @NotNull Connection<?> connection) {
        C0297l c0297lB = C0297l.b();
        if (!t && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ((fV) c0297lB.a()).m404a(Minecraft.getInstance()).setChallenges(packetRequestedChallenges.challenges());
    }

    private static void a(@NotNull PacketRequestedRecentMatches packetRequestedRecentMatches, @NotNull Connection<?> connection) {
        C0297l c0297lB = C0297l.b();
        if (!t && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ((fV) c0297lB.a()).mo306a(packetRequestedRecentMatches.player()).b(packetRequestedRecentMatches.matches());
    }

    public static void a(@NotNull PacketChatMessageFromCloud packetChatMessageFromCloud, @NotNull Connection<?> connection) {
        MutableComponent mutableComponentFromJson = Component.Serializer.fromJson(packetChatMessageFromCloud.message(), RegistryAccess.EMPTY);
        if (mutableComponentFromJson == null) {
            return;
        }
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        C0297l c0297lB = C0297l.b();
        if (!t && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (localPlayer != null && c0297lB.m591a() != null) {
            localPlayer.sendSystemMessage(mutableComponentFromJson);
        }
    }

    public static void a(@NotNull PacketPartyJoined packetPartyJoined, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) {
            minecraft.setScreen(new C0094dk());
        } else {
            minecraft.setScreen((Screen) null);
        }
    }

    public static void a(@NotNull PacketMMJoinServer packetMMJoinServer, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        C0297l c0297lB = C0297l.b();
        if (!t && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0297lB.m596a().a(minecraft, c0297lB, packetMMJoinServer.address());
    }

    public static void a(@NotNull PacketDiscordLinkResponse packetDiscordLinkResponse, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.screen instanceof C0093dj) {
            minecraft.keyboardHandler.setClipboard(packetDiscordLinkResponse.auth());
            C0297l.a(i, j, PopupType.DISCORD_LINK, new C0042bm(d, null, button -> {
                minecraft.setScreen(new C0094dk());
            }), new C0042bm(e, f, button2 -> {
                C0093dj.b(minecraft, C0261jr.aB);
            }));
        }
    }

    public static void a(@NotNull PacketPatreonLinkResponse packetPatreonLinkResponse, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        C0093dj.b(minecraft, packetPatreonLinkResponse.oauthUrl());
        C0119ej.a(minecraft, (Component) Component.translatable("bf.message.patreon.browser.opened"));
    }

    public static void a(@NotNull PacketMMSearchCloudCanceled packetMMSearchCloudCanceled, @NotNull Connection<?> connection) {
        C0297l c0297lB = C0297l.b();
        if (!t && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0297lB.m596a().a(false);
    }

    public static void a(@NotNull PacketRequestedFriends packetRequestedFriends, @NotNull Connection<?> connection) {
        C0297l c0297lB = C0297l.b();
        if (!t && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0297lB.m582a().a(packetRequestedFriends.friends(), packetRequestedFriends.requests(), packetRequestedFriends.clanRequests());
    }

    public static void a(@NotNull PacketRequestedCloudData packetRequestedCloudData, @NotNull Connection<?> connection) {
        C0297l c0297lB = C0297l.b();
        if (!t && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        ((C0163g) c0297lB.b()).i = packetRequestedCloudData.getUsersOnline();
        hN.c.clear();
        hN.c.putAll(packetRequestedCloudData.getGamePlayerCount());
        hN.b.clear();
        hN.a.clear();
        hN.f161f = packetRequestedCloudData.getScoreboardResetTime();
        hN.b.putAll(packetRequestedCloudData.getClanScores());
        hN.a.putAll(packetRequestedCloudData.getPlayerScores());
        Screen screen = minecraft.screen;
        if (screen instanceof AbstractC0108dz) {
            ((AbstractC0108dz) screen).ae();
        }
    }

    public static void a(@NotNull PacketInventoryCaseResults packetInventoryCaseResults, @NotNull Connection<?> connection) {
        Screen screen = Minecraft.getInstance().screen;
        if (screen instanceof C0099dq) {
            C0099dq c0099dq = (C0099dq) screen;
            ObjectArrayList objectArrayList = new ObjectArrayList();
            IntListIterator it = packetInventoryCaseResults.results().iterator();
            while (it.hasNext()) {
                objectArrayList.add(new CloudItemStack(UUID.randomUUID(), ((Integer) it.next()).intValue()));
            }
            c0099dq.a((ObjectList<CloudItemStack>) objectArrayList);
        }
    }

    public static void a(@NotNull PacketClientMessagePopup packetClientMessagePopup, @NotNull Connection<?> connection) {
        Component componentFromJson = Component.Serializer.fromJson(packetClientMessagePopup.title(), RegistryAccess.EMPTY);
        Component componentFromJson2 = Component.Serializer.fromJson(packetClientMessagePopup.message(), RegistryAccess.EMPTY);
        if (componentFromJson == null || componentFromJson2 == null) {
            C0263jt.log("Failed to parse popup message: " + packetClientMessagePopup.title() + " | " + packetClientMessagePopup.message(), new Object[0]);
            return;
        }
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null) {
            c0297lB.a(componentFromJson, componentFromJson2, packetClientMessagePopup.type());
        }
    }

    public static void a(@NotNull PacketNotificationFromCloud packetNotificationFromCloud, @NotNull Connection<?> connection) {
        if (hN.a(packetNotificationFromCloud.type())) {
            String strMessage = packetNotificationFromCloud.message();
            MutableComponent mutableComponentFromJson = Component.Serializer.fromJson(strMessage, RegistryAccess.EMPTY);
            if (mutableComponentFromJson == null) {
                C0263jt.log("Failed to parse notification message from cloud! %s", strMessage);
            } else {
                C0119ej.a(Minecraft.getInstance(), (Component) Component.literal("BlockFront Cloud"), (Component) mutableComponentFromJson, true);
            }
        }
    }

    public static void a(@NotNull PacketScreenshotRequest packetScreenshotRequest, @NotNull Connection<?> connection) {
        if (!hN.S.T()) {
            C0263jt.log("[Screenshot] Received cloud screenshot request, but the player has not accepted the rules! Ignoring...", new Object[0]);
            C0263jt.log("[Screenshot] More information can be found here: 'https://www.blockfrontmc.com/privacy'.", new Object[0]);
        } else if (RenderSystem.isOnRenderThread()) {
            a(packetScreenshotRequest.requestId(), connection);
        } else {
            RenderSystem.recordRenderCall(() -> {
                a(packetScreenshotRequest.requestId(), (Connection<?>) connection);
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NotNull UUID uuid, @NotNull Connection<?> connection) {
        try {
            connection.sendPacket(new PacketScreenshotResponse(uuid, C0513t.a(a)));
        } catch (IOException e2) {
            C0263jt.a("[Screenshot] Failed to capture cloud screenshot.", e2, new Object[0]);
        }
    }

    public static void a(@NotNull PacketClientSound packetClientSound, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        SoundEvent soundEventM1684a = C0624xc.m1684a(packetClientSound.sound());
        if (soundEventM1684a != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(soundEventM1684a, 1.0f, 1.0f));
        }
    }

    public static void a(@NotNull PacketTriggerNewRank packetTriggerNewRank, @NotNull Connection<?> connection) {
        C0082cz.aX = true;
    }

    public static void a(@NotNull PacketDailyReward packetDailyReward, @NotNull Connection<?> connection) {
        C0297l c0297lB = C0297l.b();
        if (!t && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0297lB.a(packetDailyReward);
    }
}
