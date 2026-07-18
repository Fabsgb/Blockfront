package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.clan.PacketClanResponse;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bw.class */
public final class C0131bw extends AbstractC0191ct {

    /* JADX INFO: renamed from: K */
    private static final Component f949K = Component.translatable("bf.message.accept").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: L */
    private static final Component f950L = Component.translatable("bf.message.accept.tip").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: M */
    private static final Component f951M = Component.translatable("bf.message.ignore").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: N */
    private static final Component f952N = Component.translatable("bf.message.ignore.tip").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: O */
    private static final Component f953O = Component.translatable("bf.screen.dropdown.clan.invite");

    /* JADX INFO: renamed from: a */
    @NotNull
    private final UUID f954a;

    public C0131bw(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull UUID uuid) {
        super(screen, i, i2, i3, i4, f953O);
        this.f954a = uuid;
        m1174a(f949K, f950L);
        m1174a(f951M, f952N);
    }

    @Override // com.boehmod.blockfront.AbstractC0191ct
    /* JADX INFO: renamed from: g */
    public void mo286g(int i) {
        C0357g c0357g = (C0357g) this.f1586e.m2667b();
        switch (i) {
            case 1:
                c0357g.sendPacket(new PacketClanResponse(this.f954a, true));
                break;
            case 2:
                c0357g.sendPacket(new PacketClanResponse(this.f954a, false));
                break;
        }
        if (this.f1587b.level == null) {
            this.f1587b.setScreen(new C0235dk());
        }
    }
}
