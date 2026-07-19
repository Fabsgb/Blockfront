package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendRequestAccept;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bz.class */
public final class C0055bz extends AbstractC0076ct {
    private static final Component aj = Component.translatable("bf.message.accept").withStyle(ChatFormatting.GREEN);
    private static final Component ak = Component.translatable("bf.message.accept.tip").withStyle(ChatFormatting.GREEN);
    private static final Component al = Component.translatable("bf.message.ignore").withStyle(ChatFormatting.RED);
    private static final Component am = Component.translatable("bf.message.ignore.tip").withStyle(ChatFormatting.RED);
    private static final Component an = Component.translatable("bf.dropdown.text.profile");

    @NotNull
    private final iS c;

    public C0055bz(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull iS iSVar) {
        super(screen, i, i2, i3, i4, Component.translatable("bf.screen.dropdown.friend.accept", new Object[]{iSVar.getUsername()}));
        this.c = iSVar;
        a(aj, ak);
        a(al, am);
        a(an, (Component) Component.translatable("bf.dropdown.text.profile.tip", new Object[]{Component.literal(iSVar.getUsername())}));
    }

    @Override // com.boehmod.blockfront.AbstractC0076ct
    public void g(int i) {
        C0163g c0163g = (C0163g) this.e.b();
        UUID uuid = this.c.getUUID();
        switch (i) {
            case 1:
                c0163g.sendPacket(new PacketFriendRequestAccept(uuid, true));
                break;
            case 2:
                c0163g.sendPacket(new PacketFriendRequestAccept(uuid, false));
                break;
            case 3:
                this.b.setScreen(new dE(this.c, this.c));
                return;
        }
        if (this.b.level == null) {
            this.b.setScreen(new C0094dk());
        }
    }
}
