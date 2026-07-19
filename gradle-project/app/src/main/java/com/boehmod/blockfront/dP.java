package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendRequest;
import com.boehmod.blockfront.dO;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dP.class */
public final class dP extends dO {
    private static final Component gP = Component.translatable("bf.message.prompt.friend.add.title");
    private static final Component gQ = Component.translatable("bf.message.prompt.friend.add.par1");
    private static final Component gR = Component.translatable("bf.message.prompt.friend.add.par2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC);

    public dP(@NotNull Screen screen) {
        super(screen, gP);
        a(16);
        a(false);
        a(dO.a.MINECRAFT_USERNAME);
        a(gQ, Component.empty(), gR);
    }

    @Override // com.boehmod.blockfront.dO
    public void U() {
        ((C0163g) this.e.b()).sendPacket(new PacketFriendRequest(o()));
        J();
    }
}
