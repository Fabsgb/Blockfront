package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendRequestAccept;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bz.class */
public final class C0134bz extends AbstractC0191ct {

    /* JADX INFO: renamed from: aj */
    private static final Component f979aj = Component.translatable("bf.message.accept").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: ak */
    private static final Component f980ak = Component.translatable("bf.message.accept.tip").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: al */
    private static final Component f981al = Component.translatable("bf.message.ignore").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: am */
    private static final Component f982am = Component.translatable("bf.message.ignore.tip").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: an */
    private static final Component f983an = Component.translatable("bf.dropdown.text.profile");

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0482iS f984c;

    public C0134bz(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull C0482iS c0482iS) {
        super(screen, i, i2, i3, i4, Component.translatable("bf.screen.dropdown.friend.accept", new Object[]{c0482iS.getUsername()}));
        this.f984c = c0482iS;
        m1174a(f979aj, f980ak);
        m1174a(f981al, f982am);
        m1174a(f983an, (Component) Component.translatable("bf.dropdown.text.profile.tip", new Object[]{Component.literal(c0482iS.getUsername())}));
    }

    @Override // com.boehmod.blockfront.AbstractC0191ct
    /* JADX INFO: renamed from: g */
    public void mo286g(int i) {
        C0357g c0357g = (C0357g) this.f1586e.m2667b();
        UUID uuid = this.f984c.getUUID();
        switch (i) {
            case 1:
                c0357g.sendPacket(new PacketFriendRequestAccept(uuid, true));
                break;
            case 2:
                c0357g.sendPacket(new PacketFriendRequestAccept(uuid, false));
                break;
            case 3:
                this.f1587b.setScreen(new C0203dE(this.f1556c, this.f984c));
                return;
        }
        if (this.f1587b.level == null) {
            this.f1587b.setScreen(new C0235dk());
        }
    }
}
