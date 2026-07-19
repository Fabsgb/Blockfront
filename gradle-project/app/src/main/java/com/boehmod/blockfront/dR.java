package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.clan.PacketClanKick;
import com.boehmod.blockfront.dO;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dR.class */
public final class dR extends dO {
    private static final Component gU = Component.translatable("bf.message.prompt.clan.kick.title");
    private static final Component gV = Component.translatable("bf.message.prompt.clan.kick");

    public dR(@NotNull Screen screen) {
        super(screen, gU);
        a(16);
        a(dO.a.MINECRAFT_USERNAME);
        a(gV);
    }

    @Override // com.boehmod.blockfront.dO
    public void U() {
        ((C0163g) this.e.b()).sendPacket(new PacketClanKick(o()));
        J();
    }
}
