package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.clan.PacketClanInvite;
import com.boehmod.blockfront.AbstractC0213dO;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dQ.class */
public final class C0215dQ extends AbstractC0213dO {

    /* JADX INFO: renamed from: gS */
    private static final Component f1780gS = Component.translatable("bf.message.prompt.clan.invite.title");

    /* JADX INFO: renamed from: gT */
    private static final Component f1781gT = Component.translatable("bf.message.prompt.clan.invite");

    public C0215dQ(@NotNull Screen screen) {
        super(screen, f1780gS);
        m1279a(16);
        m1277a(AbstractC0213dO.a.MINECRAFT_USERNAME);
        m1273a(f1781gT);
    }

    @Override // com.boehmod.blockfront.AbstractC0213dO
    /* JADX INFO: renamed from: U */
    public void mo888U() {
        ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketClanInvite(m1283o()));
        mo1276J();
    }
}
