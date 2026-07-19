package com.boehmod.blockfront;

import com.boehmod.blockfront.dO;
import com.mojang.authlib.GameProfile;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cR.class */
public final class cR extends dO {
    private static final Component dk = Component.translatable("bf.message.prompt.ingame.punish.title");
    private static final Component dl = Component.translatable("bf.message.prompt.ingame.punish");
    private static final Component dm = Component.translatable("bf.screen.staff");

    public cR(@NotNull Screen screen) {
        super(screen, dk);
        a(dO.a.MINECRAFT_UUID);
        a(dO.a.MINECRAFT_USERNAME);
        a(dl);
        a(true);
    }

    @Override // com.boehmod.blockfront.dO
    public void U() {
        UUID uuidFromString = null;
        String strO = o();
        if (strO.contains("-")) {
            try {
                uuidFromString = UUID.fromString(strO);
            } catch (IllegalArgumentException e) {
                C0263jt.a("Failed to parse UUID from input: " + strO, e, new Object[0]);
            }
        }
        if (uuidFromString == null && this.b.player != null) {
            Iterator it = this.b.player.connection.getListedOnlinePlayers().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GameProfile profile = ((PlayerInfo) it.next()).getProfile();
                if (profile.getName().equalsIgnoreCase(strO)) {
                    uuidFromString = profile.getId();
                    break;
                }
            }
        }
        if (uuidFromString != null) {
            this.b.setScreen(new dW(dm, uuidFromString));
        } else {
            C0263jt.logError("Failed to find player with input: " + strO + " (Is the player online?)", new Object[0]);
            J();
        }
    }
}
