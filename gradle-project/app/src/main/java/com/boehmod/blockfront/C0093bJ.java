package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendJoinGame;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyKick;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bJ.class */
public final class C0093bJ extends AbstractC0139cC {

    /* JADX INFO: renamed from: ao */
    private static final Component f624ao = Component.translatable("bf.dropdown.text.profile");

    /* JADX INFO: renamed from: ap */
    private static final Component f625ap = Component.translatable("bf.dropdown.text.game.join");

    /* JADX INFO: renamed from: aq */
    private static final Component f626aq = Component.translatable("bf.dropdown.text.game.join.tip");

    /* JADX INFO: renamed from: ar */
    private static final Component f627ar = Component.translatable("bf.dropdown.text.party.kick").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: d */
    @NotNull
    private final C0555jl f628d;

    /* JADX INFO: renamed from: dG */
    private final int f629dG;

    /* JADX INFO: renamed from: dH */
    private final int f630dH;

    public C0093bJ(@NotNull Screen screen, int i, int i2, @NotNull C0555jl c0555jl, boolean z, boolean z2) {
        super(screen, i, i2, 100, 15, Component.literal(c0555jl.getUsername()));
        this.f628d = c0555jl;
        MutableComponent mutableComponentLiteral = Component.literal(c0555jl.getUsername());
        m771a(f624ao, (Component) Component.translatable("bf.dropdown.text.profile.tip", new Object[]{mutableComponentLiteral}));
        if (z) {
            m771a(f625ap, f626aq);
            this.f629dG = this.f1017A.size();
        } else {
            this.f629dG = -1;
        }
        if (z2) {
            m771a(f627ar, (Component) Component.translatable("bf.dropdown.text.party.kick.tip", new Object[]{mutableComponentLiteral}));
            this.f630dH = this.f1017A.size();
        } else {
            this.f630dH = -1;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0139cC
    /* JADX INFO: renamed from: g */
    public void mo390g(int i) {
        if (i == 1) {
            this.f1058a.setScreen(new C0215dP(this.f1035c, this.f628d));
            return;
        }
        if (i == this.f629dG) {
            this.f1057f.m2885a().m2581b(this.f628d.getUsername());
            ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketFriendJoinGame(this.f628d.getUUID()));
        } else if (i == this.f630dH) {
            ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketPartyKick(this.f628d.getUUID()));
        }
    }
}
