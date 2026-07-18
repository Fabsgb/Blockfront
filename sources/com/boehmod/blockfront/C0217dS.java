package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.clan.PacketClanCreate;
import com.boehmod.blockfront.AbstractC0213dO;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dS.class */
public final class C0217dS extends AbstractC0213dO {

    /* JADX INFO: renamed from: gW */
    private static final Component f1784gW = Component.translatable("bf.message.prompt.clan.create.title");

    /* JADX INFO: renamed from: gX */
    private static final Component f1785gX = Component.translatable("bf.message.prompt.clan.create");

    public C0217dS(@NotNull Screen screen) {
        super(screen, f1784gW);
        m1279a(16);
        m1277a(AbstractC0213dO.a.COMMON);
        m1273a(f1785gX);
    }

    @Override // com.boehmod.blockfront.AbstractC0213dO
    /* JADX INFO: renamed from: U */
    public void mo888U() {
        ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketClanCreate(m1283o()));
        mo1276J();
    }
}
