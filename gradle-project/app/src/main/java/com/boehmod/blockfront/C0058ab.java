package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendJoinGame;
import de.jcm.discordgamesdk.DiscordEventAdapter;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ab */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ab.class */
public class C0058ab extends DiscordEventAdapter {

    /* JADX INFO: renamed from: d */
    @NotNull
    private final C0623l f410d;

    public C0058ab(@NotNull C0623l c0623l) {
        this.f410d = c0623l;
    }

    @Override // de.jcm.discordgamesdk.DiscordEventAdapter
    public void onActivityJoin(String str) {
        C0530jM.log("Received activity join attempt request (Secret: " + str + ")", new Object[0]);
        try {
            UUID uuidFromString = UUID.fromString(str);
            C0530jM.log("Attempting to join match of " + String.valueOf(uuidFromString), new Object[0]);
            this.f410d.m2885a().m2581b(((C0396gl) this.f410d.m2855a()).mo1154a(uuidFromString).getUsername());
            ((C0358g) this.f410d.m2852b()).sendPacket(new PacketFriendJoinGame(uuidFromString));
        } catch (IllegalArgumentException e) {
            C0530jM.m2338a("Failed to join match from secret.", e, new Object[0]);
        }
    }
}
