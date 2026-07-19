package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.clan.PacketClanResponse;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bw.class */
public final class C0052bw extends AbstractC0076ct {
    private static final Component K = Component.translatable("bf.message.accept").withStyle(ChatFormatting.GREEN);
    private static final Component L = Component.translatable("bf.message.accept.tip").withStyle(ChatFormatting.GREEN);
    private static final Component M = Component.translatable("bf.message.ignore").withStyle(ChatFormatting.RED);
    private static final Component N = Component.translatable("bf.message.ignore.tip").withStyle(ChatFormatting.RED);
    private static final Component O = Component.translatable("bf.screen.dropdown.clan.invite");

    @NotNull
    private final UUID a;

    public C0052bw(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull UUID uuid) {
        super(screen, i, i2, i3, i4, O);
        this.a = uuid;
        a(K, L);
        a(M, N);
    }

    @Override // com.boehmod.blockfront.AbstractC0076ct
    public void g(int i) {
        C0163g c0163g = (C0163g) this.e.b();
        switch (i) {
            case 1:
                c0163g.sendPacket(new PacketClanResponse(this.a, true));
                break;
            case 2:
                c0163g.sendPacket(new PacketClanResponse(this.a, false));
                break;
        }
        if (this.b.level == null) {
            this.b.setScreen(new C0094dk());
        }
    }
}
