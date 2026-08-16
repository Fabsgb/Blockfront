package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendRequestAccept;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bI.class */
public final class C0092bI extends AbstractC0139cC {

    /* JADX INFO: renamed from: aj */
    private static final Component f618aj = Component.translatable("bf.message.accept").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: ak */
    private static final Component f619ak = Component.translatable("bf.message.accept.tip").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: al */
    private static final Component f620al = Component.translatable("bf.message.ignore").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: am */
    private static final Component f621am = Component.translatable("bf.message.ignore.tip").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: an */
    private static final Component f622an = Component.translatable("bf.dropdown.text.profile");

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0555jl f623c;

    public C0092bI(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull C0555jl c0555jl) {
        super(screen, i, i2, i3, i4, Component.translatable("bf.screen.dropdown.friend.accept", new Object[]{c0555jl.getUsername()}));
        this.f623c = c0555jl;
        m771a(f618aj, f619ak);
        m771a(f620al, f621am);
        m771a(f622an, (Component) Component.translatable("bf.dropdown.text.profile.tip", new Object[]{Component.literal(c0555jl.getUsername())}));
    }

    @Override // com.boehmod.blockfront.AbstractC0139cC
    /* JADX INFO: renamed from: g */
    public void mo390g(int i) {
        C0358g c0358g = (C0358g) this.f1057f.m2852b();
        UUID uuid = this.f623c.getUUID();
        switch (i) {
            case 1:
                c0358g.sendPacket(new PacketFriendRequestAccept(uuid, true));
                break;
            case 2:
                c0358g.sendPacket(new PacketFriendRequestAccept(uuid, false));
                break;
            case 3:
                this.f1058a.setScreen(new C0215dP(this.f1035c, this.f623c));
                return;
        }
        if (this.f1058a.level == null) {
            this.f1058a.setScreen(new C0245dt());
        }
    }
}
