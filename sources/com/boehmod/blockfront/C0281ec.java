package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.clan.PacketClanKick;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ec */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ec.class */
public final class C0281ec extends AbstractC0225dZ {

    /* JADX INFO: renamed from: ha */
    private static final Component f2223ha = Component.translatable("bf.message.prompt.clan.kick.title");

    /* JADX INFO: renamed from: hb */
    private static final Component f2224hb = Component.translatable("bf.message.prompt.clan.kick");

    public C0281ec(@NotNull Screen screen) {
        super(screen, f2223ha);
        m1329a(16);
        m1328a(AbstractC0225dZ.a.MINECRAFT_USERNAME);
        m1324a(f2224hb);
    }

    @Override // com.boehmod.blockfront.AbstractC0225dZ
    /* JADX INFO: renamed from: Y */
    public void mo942Y() {
        ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketClanKick(m1333s()));
        m1327N();
    }
}
