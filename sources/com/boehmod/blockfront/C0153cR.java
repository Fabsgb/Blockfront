package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0213dO;
import com.mojang.authlib.GameProfile;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cR.class */
public final class C0153cR extends AbstractC0213dO {

    /* JADX INFO: renamed from: dk */
    private static final Component f1235dk = Component.translatable("bf.message.prompt.ingame.punish.title");

    /* JADX INFO: renamed from: dl */
    private static final Component f1236dl = Component.translatable("bf.message.prompt.ingame.punish");

    /* JADX INFO: renamed from: dm */
    private static final Component f1237dm = Component.translatable("bf.screen.staff");

    public C0153cR(@NotNull Screen screen) {
        super(screen, f1235dk);
        m1277a(AbstractC0213dO.a.MINECRAFT_UUID);
        m1277a(AbstractC0213dO.a.MINECRAFT_USERNAME);
        m1273a(f1236dl);
        m1278a(true);
    }

    @Override // com.boehmod.blockfront.AbstractC0213dO
    /* JADX INFO: renamed from: U */
    public void mo888U() {
        UUID uuidFromString = null;
        String strO = m1283o();
        if (strO.contains("-")) {
            try {
                uuidFromString = UUID.fromString(strO);
            } catch (IllegalArgumentException e) {
                C0562jt.m2516a("Failed to parse UUID from input: " + strO, e, new Object[0]);
            }
        }
        if (uuidFromString == null && this.f1587b.player != null) {
            Iterator it = this.f1587b.player.connection.getListedOnlinePlayers().iterator();
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
            this.f1587b.setScreen(new C0221dW(f1237dm, uuidFromString));
        } else {
            C0562jt.logError("Failed to find player with input: " + strO + " (Is the player online?)", new Object[0]);
            mo1276J();
        }
    }
}
