package com.boehmod.blockfront;

import com.mojang.authlib.GameProfile;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.da */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/da.class */
public final class C0226da extends AbstractC0225dZ {

    /* JADX INFO: renamed from: dm */
    private static final Component f1806dm = Component.translatable("bf.message.prompt.ingame.punish.title");

    /* JADX INFO: renamed from: dn */
    private static final Component f1807dn = Component.translatable("bf.message.prompt.ingame.punish");

    /* JADX INFO: renamed from: do */
    private static final Component f1808do = Component.translatable("bf.screen.staff");

    public C0226da(@NotNull Screen screen) {
        super(screen, f1806dm);
        m1328a(AbstractC0225dZ.a.MINECRAFT_UUID);
        m1328a(AbstractC0225dZ.a.MINECRAFT_USERNAME);
        m1324a(f1807dn);
        mo783a(true);
    }

    @Override // com.boehmod.blockfront.AbstractC0225dZ
    /* JADX INFO: renamed from: Y */
    public void mo942Y() {
        UUID uuidFromString = null;
        String strS = m1333s();
        if (strS.contains("-")) {
            try {
                uuidFromString = UUID.fromString(strS);
            } catch (IllegalArgumentException e) {
                C0530jM.m2338a("Failed to parse UUID from input: " + strS, e, new Object[0]);
            }
        }
        if (uuidFromString == null && this.f1058a.player != null) {
            Iterator it = this.f1058a.player.connection.getListedOnlinePlayers().iterator();
            while (it.hasNext()) {
                GameProfile profile = ((PlayerInfo) it.next()).getProfile();
                if (profile.getName().equalsIgnoreCase(strS)) {
                    uuidFromString = profile.getId();
                    break;
                }
            }
        }
        if (uuidFromString != null) {
            this.f1058a.setScreen(new C0286eh(f1808do, uuidFromString));
        } else {
            C0530jM.logError("Failed to find player with input: " + strS + " (Is the player online?)", new Object[0]);
            m1327N();
        }
    }
}
