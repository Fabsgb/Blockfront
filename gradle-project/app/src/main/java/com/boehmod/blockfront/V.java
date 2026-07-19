package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendJoinGame;
import de.jcm.discordgamesdk.DiscordEventAdapter;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/V.class */
public class V extends DiscordEventAdapter {

    @NotNull
    private final C0297l c;

    public V(@NotNull C0297l c0297l) {
        this.c = c0297l;
    }

    @Override // de.jcm.discordgamesdk.DiscordEventAdapter
    public void onActivityJoin(String str) {
        C0263jt.log("Received activity join attempt request (Secret: " + str + ")", new Object[0]);
        try {
            UUID uuidFromString = UUID.fromString(str);
            C0263jt.log("Attempting to join match of " + String.valueOf(uuidFromString), new Object[0]);
            this.c.m596a().b(((fV) this.c.a()).mo306a(uuidFromString).getUsername());
            ((C0163g) this.c.b()).sendPacket(new PacketFriendJoinGame(uuidFromString));
        } catch (IllegalArgumentException e) {
            C0263jt.a("Failed to join match from secret.", e, new Object[0]);
        }
    }
}
