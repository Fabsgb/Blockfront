package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.clan.PacketClanResponse;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bF.class */
public final class C0089bF extends AbstractC0139cC {

    /* JADX INFO: renamed from: K */
    private static final Component f588K = Component.translatable("bf.message.accept").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: L */
    private static final Component f589L = Component.translatable("bf.message.accept.tip").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: M */
    private static final Component f590M = Component.translatable("bf.message.ignore").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: N */
    private static final Component f591N = Component.translatable("bf.message.ignore.tip").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: O */
    private static final Component f592O = Component.translatable("bf.screen.dropdown.clan.invite");

    /* JADX INFO: renamed from: a */
    @NotNull
    private final UUID f593a;

    public C0089bF(@NotNull Screen screen, int i, int i2, int i3, int i4, @NotNull UUID uuid) {
        super(screen, i, i2, i3, i4, f592O);
        this.f593a = uuid;
        m771a(f588K, f589L);
        m771a(f590M, f591N);
    }

    @Override // com.boehmod.blockfront.AbstractC0139cC
    /* JADX INFO: renamed from: g */
    public void mo390g(int i) {
        C0358g c0358g = (C0358g) this.f1057f.m2852b();
        switch (i) {
            case 1:
                c0358g.sendPacket(new PacketClanResponse(this.f593a, true));
                break;
            case 2:
                c0358g.sendPacket(new PacketClanResponse(this.f593a, false));
                break;
        }
        if (this.f1058a.level == null) {
            this.f1058a.setScreen(new C0245dt());
        }
    }
}
