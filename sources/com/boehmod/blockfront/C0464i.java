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
import com.boehmod.bflib.cloud.packet.common.news.PacketNewsArticleResponse;
import com.boehmod.bflib.cloud.packet.common.news.PacketNewsImageResponse;
import com.boehmod.bflib.cloud.packet.common.news.PacketNewsListResponse;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMJoinServer;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMSearchCloudCanceled;
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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/i.class */
public class C0464i {

    /* JADX INFO: renamed from: d */
    private static final Component f2884d;

    /* JADX INFO: renamed from: e */
    private static final Component f2885e;

    /* JADX INFO: renamed from: f */
    private static final Component f2886f;

    /* JADX INFO: renamed from: g */
    private static final Component f2887g;

    /* JADX INFO: renamed from: h */
    private static final Component f2888h;

    /* JADX INFO: renamed from: i */
    private static final Component f2889i;

    /* JADX INFO: renamed from: j */
    private static final Component f2890j;

    /* JADX INFO: renamed from: a */
    private static final float f2891a = 0.8f;

    /* JADX INFO: renamed from: u */
    static final /* synthetic */ boolean f2892u;

    static {
        f2892u = !C0464i.class.desiredAssertionStatus();
        f2884d = Component.translatable("bf.message.okay");
        f2885e = Component.translatable("bf.cloud.popup.discord.button");
        f2886f = Component.translatable("bf.cloud.popup.discord.button.tip", new Object[]{C0030a.f263a});
        f2887g = Component.literal("#verify").withStyle(C0533jP.f3186c);
        f2888h = Component.literal("/verify").withStyle(C0533jP.f3186c);
        f2889i = Component.translatable("bf.cloud.popup.discord.title");
        f2890j = Component.translatable("bf.cloud.popup.discord.message", new Object[]{f2887g, f2888h}).withColor(ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: b */
    static void m2097b() {
        C0530jM.log("[Cloud] Registering client-side cloud packet handlers...", new Object[0]);
        PacketRegistry.registerPacketHandler(PacketNotificationFromCloud.class, (v0, v1) -> {
            m2116a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketChatMessageFromCloud.class, (v0, v1) -> {
            m2103a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketClientSound.class, (v0, v1) -> {
            m2119a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketTriggerNewRank.class, (v0, v1) -> {
            m2120a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketClientMessagePopup.class, (v0, v1) -> {
            m2115a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketDailyReward.class, (v0, v1) -> {
            m2121a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketScreenshotRequest.class, (v0, v1) -> {
            m2117a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketInventoryCaseResults.class, (v0, v1) -> {
            m2114a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketInventoryItemAdded.class, (v0, v1) -> {
            m2098a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketInventoryItemRemoved.class, (v0, v1) -> {
            m2099a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedFriends.class, (v0, v1) -> {
            m2112a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedCloudData.class, (v0, v1) -> {
            m2113a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedChallenges.class, (v0, v1) -> {
            m2101a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedClanData.class, (v0, v1) -> {
            m2100a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedRecentMatches.class, (v0, v1) -> {
            m2102a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketPartyJoined.class, (v0, v1) -> {
            m2104a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketMMJoinServer.class, (v0, v1) -> {
            m2105a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketMMSearchCloudCanceled.class, (v0, v1) -> {
            m2111a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketDiscordLinkResponse.class, (v0, v1) -> {
            m2109a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketNewsListResponse.class, (v0, v1) -> {
            m2106a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketNewsImageResponse.class, (v0, v1) -> {
            m2107a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketNewsArticleResponse.class, (v0, v1) -> {
            m2108a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketPatreonLinkResponse.class, (v0, v1) -> {
            m2110a(v0, v1);
        }, ModConnection.class);
        C0530jM.log("[Cloud] Finished registering client-side cloud packet handlers.", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public static void m2098a(@NotNull PacketInventoryItemAdded packetInventoryItemAdded, @NotNull Connection<?> connection) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2892u && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0555jl c0555jlM1886a = ((C0396gl) c0623lM2852b.m2855a()).m1886a(Minecraft.getInstance());
        Iterator<CloudItemStack> it = packetInventoryItemAdded.stacks().iterator();
        while (it.hasNext()) {
            c0555jlM1886a.getInventory().addItemStackLocal(it.next());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2099a(@NotNull PacketInventoryItemRemoved packetInventoryItemRemoved, @NotNull Connection<?> connection) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2892u && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0550jg inventory = ((C0396gl) c0623lM2852b.m2855a()).m1886a(Minecraft.getInstance()).getInventory();
        ObjectIterator it = packetInventoryItemRemoved.uuids().iterator();
        while (it.hasNext()) {
            inventory.removeItemStackLocal((UUID) it.next());
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2100a(@NotNull PacketRequestedClanData packetRequestedClanData, @NotNull Connection<?> connection) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2892u && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ((C0396gl) c0623lM2852b.m2855a()).m1151a(packetRequestedClanData.uuid(), packetRequestedClanData.clanData());
    }

    /* JADX INFO: renamed from: a */
    private static void m2101a(@NotNull PacketRequestedChallenges packetRequestedChallenges, @NotNull Connection<?> connection) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2892u && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ((C0396gl) c0623lM2852b.m2855a()).m1886a(Minecraft.getInstance()).setChallenges(packetRequestedChallenges.challenges());
    }

    /* JADX INFO: renamed from: a */
    private static void m2102a(@NotNull PacketRequestedRecentMatches packetRequestedRecentMatches, @NotNull Connection<?> connection) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2892u && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ((C0396gl) c0623lM2852b.m2855a()).mo1154a(packetRequestedRecentMatches.player()).m2527b(packetRequestedRecentMatches.matches());
    }

    /* JADX INFO: renamed from: a */
    public static void m2103a(@NotNull PacketChatMessageFromCloud packetChatMessageFromCloud, @NotNull Connection<?> connection) {
        MutableComponent mutableComponentFromJson = Component.Serializer.fromJson(packetChatMessageFromCloud.message(), RegistryAccess.EMPTY);
        if (mutableComponentFromJson == null) {
            return;
        }
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2892u && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (localPlayer != null && c0623lM2852b.m2874a() != null) {
            localPlayer.sendSystemMessage(mutableComponentFromJson);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2104a(@NotNull PacketPartyJoined packetPartyJoined, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) {
            minecraft.setScreen(new C0245dt());
        } else {
            minecraft.setScreen((Screen) null);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2105a(@NotNull PacketMMJoinServer packetMMJoinServer, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2892u && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0623lM2852b.m2885a().m2580a(minecraft, c0623lM2852b, packetMMJoinServer.address());
    }

    /* JADX INFO: renamed from: a */
    public static void m2106a(@NotNull PacketNewsListResponse packetNewsListResponse, @NotNull Connection<?> connection) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2892u && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft.getInstance().execute(() -> {
            c0623lM2852b.m2863a().m1537e(packetNewsListResponse.articles());
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m2107a(@NotNull PacketNewsImageResponse packetNewsImageResponse, @NotNull Connection<?> connection) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2892u && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.execute(() -> {
            c0623lM2852b.m2863a().m1539a(minecraft, packetNewsImageResponse.m4id(), packetNewsImageResponse.imageData());
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m2108a(@NotNull PacketNewsArticleResponse packetNewsArticleResponse, @NotNull Connection<?> connection) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2892u && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft.getInstance().execute(() -> {
            c0623lM2852b.m2863a().m1538a(packetNewsArticleResponse.m2id(), packetNewsArticleResponse.body());
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m2109a(@NotNull PacketDiscordLinkResponse packetDiscordLinkResponse, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        Screen screen = minecraft.screen;
        if ((screen instanceof C0244ds) || (screen instanceof AbstractC0141cE)) {
            minecraft.keyboardHandler.setClipboard(packetDiscordLinkResponse.auth());
            Screen c0245dt = screen instanceof AbstractC0141cE ? screen : new C0245dt();
            C0623l.m2853a(f2889i, f2890j, PopupType.DISCORD_LINK, new C0131bv(f2884d, null, button -> {
                minecraft.setScreen(c0245dt);
            }), new C0131bv(f2885e, f2886f, button2 -> {
                C0244ds.m784b(minecraft, C0528jK.f3165aH);
            }));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2110a(@NotNull PacketPatreonLinkResponse packetPatreonLinkResponse, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        C0244ds.m784b(minecraft, packetPatreonLinkResponse.oauthUrl());
        C0301ew.m1623a(minecraft, (Component) Component.translatable("bf.message.patreon.browser.opened"));
    }

    /* JADX INFO: renamed from: a */
    public static void m2111a(@NotNull PacketMMSearchCloudCanceled packetMMSearchCloudCanceled, @NotNull Connection<?> connection) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2892u && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0623lM2852b.m2885a().m2587a(false);
    }

    /* JADX INFO: renamed from: a */
    public static void m2112a(@NotNull PacketRequestedFriends packetRequestedFriends, @NotNull Connection<?> connection) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2892u && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0623lM2852b.m2861a().m4644a(packetRequestedFriends.friends(), packetRequestedFriends.requests(), packetRequestedFriends.clanRequests());
    }

    /* JADX INFO: renamed from: a */
    public static void m2113a(@NotNull PacketRequestedCloudData packetRequestedCloudData, @NotNull Connection<?> connection) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2892u && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        Minecraft minecraft = Minecraft.getInstance();
        ((C0358g) c0623lM2852b.m2852b()).f2495j = packetRequestedCloudData.getUsersOnline();
        C0495ie.f3016c.clear();
        C0495ie.f3016c.putAll(packetRequestedCloudData.getGamePlayerCount());
        C0495ie.f3015b.clear();
        C0495ie.f3014a.clear();
        C0495ie.f3074k = packetRequestedCloudData.getScoreboardResetTime();
        C0495ie.f3015b.putAll(packetRequestedCloudData.getClanScores());
        C0495ie.f3014a.putAll(packetRequestedCloudData.getPlayerScores());
        Screen screen = minecraft.screen;
        if (screen instanceof AbstractC0210dK) {
            ((AbstractC0210dK) screen).m1250aj();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2114a(@NotNull PacketInventoryCaseResults packetInventoryCaseResults, @NotNull Connection<?> connection) {
        Screen screen = Minecraft.getInstance().screen;
        if (screen instanceof C0251dz) {
            C0251dz c0251dz = (C0251dz) screen;
            ObjectArrayList objectArrayList = new ObjectArrayList();
            IntListIterator it = packetInventoryCaseResults.results().iterator();
            while (it.hasNext()) {
                objectArrayList.add(new CloudItemStack(UUID.randomUUID(), ((Integer) it.next()).intValue()));
            }
            c0251dz.m1435a((ObjectList<CloudItemStack>) objectArrayList);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2115a(@NotNull PacketClientMessagePopup packetClientMessagePopup, @NotNull Connection<?> connection) {
        Component componentFromJson = Component.Serializer.fromJson(packetClientMessagePopup.title(), RegistryAccess.EMPTY);
        Component componentFromJson2 = Component.Serializer.fromJson(packetClientMessagePopup.message(), RegistryAccess.EMPTY);
        if (componentFromJson == null || componentFromJson2 == null) {
            C0530jM.log("Failed to parse popup message: " + packetClientMessagePopup.title() + " | " + packetClientMessagePopup.message(), new Object[0]);
            return;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b != null) {
            c0623lM2852b.m2893a(componentFromJson, componentFromJson2, packetClientMessagePopup.type());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2116a(@NotNull PacketNotificationFromCloud packetNotificationFromCloud, @NotNull Connection<?> connection) {
        if (C0495ie.m2233a(packetNotificationFromCloud.type())) {
            String strMessage = packetNotificationFromCloud.message();
            MutableComponent mutableComponentFromJson = Component.Serializer.fromJson(strMessage, RegistryAccess.EMPTY);
            if (mutableComponentFromJson == null) {
                C0530jM.log("Failed to parse notification message from cloud! %s", strMessage);
            } else {
                C0301ew.m1626a(Minecraft.getInstance(), (Component) Component.literal("BlockFront Cloud"), (Component) mutableComponentFromJson, true);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2117a(@NotNull PacketScreenshotRequest packetScreenshotRequest, @NotNull Connection<?> connection) {
        if (!C0495ie.f3066S.m2230U()) {
            C0530jM.log("[Screenshot] Received cloud screenshot request, but the player has not accepted the rules! Ignoring...", new Object[0]);
            C0530jM.log("[Screenshot] More information can be found here: 'https://www.blockfrontmc.com/privacy'.", new Object[0]);
        } else if (RenderSystem.isOnRenderThread()) {
            m2118a(packetScreenshotRequest.requestId(), connection);
        } else {
            RenderSystem.recordRenderCall(() -> {
                m2118a(packetScreenshotRequest.requestId(), (Connection<?>) connection);
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static void m2118a(@NotNull UUID uuid, @NotNull Connection<?> connection) {
        try {
            connection.sendPacket(new PacketScreenshotResponse(uuid, C1101u.m6189a(f2891a)));
        } catch (IOException e) {
            C0530jM.m2338a("[Screenshot] Failed to capture cloud screenshot.", e, new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2119a(@NotNull PacketClientSound packetClientSound, @NotNull Connection<?> connection) {
        Minecraft minecraft = Minecraft.getInstance();
        SoundEvent soundEventM8231a = C1312xz.m8231a(packetClientSound.sound());
        if (soundEventM8231a != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(soundEventM8231a, 1.0f, 1.0f));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2120a(@NotNull PacketTriggerNewRank packetTriggerNewRank, @NotNull Connection<?> connection) {
        C0145cI.f1066bb = true;
    }

    /* JADX INFO: renamed from: a */
    public static void m2121a(@NotNull PacketDailyReward packetDailyReward, @NotNull Connection<?> connection) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2892u && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        c0623lM2852b.m2891a(packetDailyReward);
    }
}
