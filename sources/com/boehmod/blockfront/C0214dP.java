package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendRequest;
import com.boehmod.blockfront.AbstractC0213dO;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dP.class */
public final class C0214dP extends AbstractC0213dO {

    /* JADX INFO: renamed from: gP */
    private static final Component f1777gP = Component.translatable("bf.message.prompt.friend.add.title");

    /* JADX INFO: renamed from: gQ */
    private static final Component f1778gQ = Component.translatable("bf.message.prompt.friend.add.par1");

    /* JADX INFO: renamed from: gR */
    private static final Component f1779gR = Component.translatable("bf.message.prompt.friend.add.par2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC);

    public C0214dP(@NotNull Screen screen) {
        super(screen, f1777gP);
        m1279a(16);
        m1278a(false);
        m1277a(AbstractC0213dO.a.MINECRAFT_USERNAME);
        m1274a(f1778gQ, Component.empty(), f1779gR);
    }

    @Override // com.boehmod.blockfront.AbstractC0213dO
    /* JADX INFO: renamed from: U */
    public void mo888U() {
        ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketFriendRequest(m1283o()));
        mo1276J();
    }
}
