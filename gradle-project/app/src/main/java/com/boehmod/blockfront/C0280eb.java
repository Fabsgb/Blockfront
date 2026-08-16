package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.clan.PacketClanInvite;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eb.class */
public final class C0280eb extends AbstractC0225dZ {

    /* JADX INFO: renamed from: gY */
    private static final Component f2221gY = Component.translatable("bf.message.prompt.clan.invite.title");

    /* JADX INFO: renamed from: gZ */
    private static final Component f2222gZ = Component.translatable("bf.message.prompt.clan.invite");

    public C0280eb(@NotNull Screen screen) {
        super(screen, f2221gY);
        m1329a(16);
        m1328a(AbstractC0225dZ.a.MINECRAFT_USERNAME);
        m1324a(f2222gZ);
    }

    @Override // com.boehmod.blockfront.AbstractC0225dZ
    /* JADX INFO: renamed from: Y */
    public void mo942Y() {
        ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketClanInvite(m1333s()));
        m1327N();
    }
}
