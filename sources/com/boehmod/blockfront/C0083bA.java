package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendJoinGame;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyKick;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bA.class */
public final class C0083bA extends AbstractC0191ct {

    /* JADX INFO: renamed from: ao */
    private static final Component f555ao = Component.translatable("bf.dropdown.text.profile");

    /* JADX INFO: renamed from: ap */
    private static final Component f556ap = Component.translatable("bf.dropdown.text.game.join");

    /* JADX INFO: renamed from: aq */
    private static final Component f557aq = Component.translatable("bf.dropdown.text.game.join.tip");

    /* JADX INFO: renamed from: ar */
    private static final Component f558ar = Component.translatable("bf.dropdown.text.party.kick").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: d */
    @NotNull
    private final C0482iS f559d;

    /* JADX INFO: renamed from: cO */
    private final int f560cO;

    /* JADX INFO: renamed from: cP */
    private final int f561cP;

    public C0083bA(@NotNull Screen screen, int i, int i2, @NotNull C0482iS c0482iS, boolean z, boolean z2) {
        super(screen, i, i2, 100, 15, Component.literal(c0482iS.getUsername()));
        this.f559d = c0482iS;
        MutableComponent mutableComponentLiteral = Component.literal(c0482iS.getUsername());
        m1174a(f555ao, (Component) Component.translatable("bf.dropdown.text.profile.tip", new Object[]{mutableComponentLiteral}));
        if (z) {
            m1174a(f556ap, f557aq);
            this.f560cO = this.f1537r.size();
        } else {
            this.f560cO = -1;
        }
        if (z2) {
            m1174a(f558ar, (Component) Component.translatable("bf.dropdown.text.party.kick.tip", new Object[]{mutableComponentLiteral}));
            this.f561cP = this.f1537r.size();
        } else {
            this.f561cP = -1;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0191ct
    /* JADX INFO: renamed from: g */
    public void mo286g(int i) {
        if (i == 1) {
            this.f1587b.setScreen(new C0203dE(this.f1556c, this.f559d));
            return;
        }
        if (i != this.f560cO) {
            if (i == this.f561cP) {
                ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketPartyKick(this.f559d.getUUID()));
            }
        } else {
            ClientLevel clientLevel = this.f1587b.level;
            if (clientLevel != null) {
                this.f1586e.m2669b(this.f1587b, clientLevel);
            }
            this.f1586e.m2699a().m2592b(this.f559d.getUsername());
            ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketFriendJoinGame(this.f559d.getUUID()));
        }
    }
}
