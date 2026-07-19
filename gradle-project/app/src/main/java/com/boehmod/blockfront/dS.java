package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.clan.PacketClanCreate;
import com.boehmod.blockfront.dO;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dS.class */
public final class dS extends dO {
    private static final Component gW = Component.translatable("bf.message.prompt.clan.create.title");
    private static final Component gX = Component.translatable("bf.message.prompt.clan.create");

    public dS(@NotNull Screen screen) {
        super(screen, gW);
        a(16);
        a(dO.a.COMMON);
        a(gX);
    }

    @Override // com.boehmod.blockfront.dO
    public void U() {
        ((C0163g) this.e.b()).sendPacket(new PacketClanCreate(o()));
        J();
    }
}
