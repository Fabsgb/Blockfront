package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.clan.PacketClanKick;
import com.boehmod.blockfront.AbstractC0213dO;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dR.class */
public final class C0216dR extends AbstractC0213dO {

    /* JADX INFO: renamed from: gU */
    private static final Component f1782gU = Component.translatable("bf.message.prompt.clan.kick.title");

    /* JADX INFO: renamed from: gV */
    private static final Component f1783gV = Component.translatable("bf.message.prompt.clan.kick");

    public C0216dR(@NotNull Screen screen) {
        super(screen, f1782gU);
        m1279a(16);
        m1277a(AbstractC0213dO.a.MINECRAFT_USERNAME);
        m1273a(f1783gV);
    }

    @Override // com.boehmod.blockfront.AbstractC0213dO
    /* JADX INFO: renamed from: U */
    public void mo888U() {
        ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketClanKick(m1283o()));
        mo1276J();
    }
}
