package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendJoinGame;
import de.jcm.discordgamesdk.DiscordEventAdapter;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.V */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/V.class */
public class C0024V extends DiscordEventAdapter {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0622l f226c;

    public C0024V(@NotNull C0622l c0622l) {
        this.f226c = c0622l;
    }

    @Override // de.jcm.discordgamesdk.DiscordEventAdapter
    public void onActivityJoin(String str) {
        C0562jt.log("Received activity join attempt request (Secret: " + str + ")", new Object[0]);
        try {
            UUID uuidFromString = UUID.fromString(str);
            C0562jt.log("Attempting to join match of " + String.valueOf(uuidFromString), new Object[0]);
            this.f226c.m2699a().m2592b(((C0326fV) this.f226c.m2670a()).mo1137a(uuidFromString).getUsername());
            ((C0357g) this.f226c.m2667b()).sendPacket(new PacketFriendJoinGame(uuidFromString));
        } catch (IllegalArgumentException e) {
            C0562jt.m2516a("Failed to join match from secret.", e, new Object[0]);
        }
    }
}
