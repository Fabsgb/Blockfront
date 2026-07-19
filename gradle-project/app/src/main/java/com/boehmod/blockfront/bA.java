package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendJoinGame;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyKick;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bA.class */
public final class bA extends AbstractC0076ct {
    private static final Component ao = Component.translatable("bf.dropdown.text.profile");
    private static final Component ap = Component.translatable("bf.dropdown.text.game.join");
    private static final Component aq = Component.translatable("bf.dropdown.text.game.join.tip");
    private static final Component ar = Component.translatable("bf.dropdown.text.party.kick").withStyle(ChatFormatting.RED);

    @NotNull
    private final iS d;
    private final int cO;
    private final int cP;

    public bA(@NotNull Screen screen, int i, int i2, @NotNull iS iSVar, boolean z, boolean z2) {
        super(screen, i, i2, 100, 15, Component.literal(iSVar.getUsername()));
        this.d = iSVar;
        MutableComponent mutableComponentLiteral = Component.literal(iSVar.getUsername());
        a(ao, (Component) Component.translatable("bf.dropdown.text.profile.tip", new Object[]{mutableComponentLiteral}));
        if (z) {
            a(ap, aq);
            this.cO = this.r.size();
        } else {
            this.cO = -1;
        }
        if (z2) {
            a(ar, (Component) Component.translatable("bf.dropdown.text.party.kick.tip", new Object[]{mutableComponentLiteral}));
            this.cP = this.r.size();
        } else {
            this.cP = -1;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0076ct
    public void g(int i) {
        if (i == 1) {
            this.b.setScreen(new dE(this.c, this.d));
            return;
        }
        if (i != this.cO) {
            if (i == this.cP) {
                ((C0163g) this.e.b()).sendPacket(new PacketPartyKick(this.d.getUUID()));
            }
        } else {
            ClientLevel clientLevel = this.b.level;
            if (clientLevel != null) {
                this.e.b(this.b, clientLevel);
            }
            this.e.m596a().b(this.d.getUsername());
            ((C0163g) this.e.b()).sendPacket(new PacketFriendJoinGame(this.d.getUUID()));
        }
    }
}
