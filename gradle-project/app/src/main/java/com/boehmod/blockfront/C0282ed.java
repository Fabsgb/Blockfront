package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.clan.PacketClanCreate;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ed */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ed.class */
public final class C0282ed extends AbstractC0225dZ {

    /* JADX INFO: renamed from: hc */
    private static final Component f2225hc = Component.translatable("bf.message.prompt.clan.create.title");

    /* JADX INFO: renamed from: hd */
    private static final Component f2226hd = Component.translatable("bf.message.prompt.clan.create");

    public C0282ed(@NotNull Screen screen) {
        super(screen, f2225hc);
        m1329a(16);
        m1328a(AbstractC0225dZ.a.COMMON);
        m1324a(f2226hd);
    }

    @Override // com.boehmod.blockfront.AbstractC0225dZ
    /* JADX INFO: renamed from: Y */
    public void mo942Y() {
        ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketClanCreate(m1333s()));
        m1327N();
    }
}
