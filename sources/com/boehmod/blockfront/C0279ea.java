package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendRequest;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ea */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ea.class */
public final class C0279ea extends AbstractC0225dZ {

    /* JADX INFO: renamed from: gV */
    private static final Component f2218gV = Component.translatable("bf.message.prompt.friend.add.title");

    /* JADX INFO: renamed from: gW */
    private static final Component f2219gW = Component.translatable("bf.message.prompt.friend.add.par1");

    /* JADX INFO: renamed from: gX */
    private static final Component f2220gX = Component.translatable("bf.message.prompt.friend.add.par2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC);

    public C0279ea(@NotNull Screen screen) {
        super(screen, f2218gV);
        m1329a(16);
        mo783a(false);
        m1328a(AbstractC0225dZ.a.MINECRAFT_USERNAME);
        m1325a(f2219gW, Component.empty(), f2220gX);
    }

    @Override // com.boehmod.blockfront.AbstractC0225dZ
    /* JADX INFO: renamed from: Y */
    public void mo942Y() {
        ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketFriendRequest(m1333s()));
        m1327N();
    }
}
