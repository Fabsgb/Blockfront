package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.util.Iterator;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xy.class */
public final class xy extends AbstractC0268jy {
    private static final int uk = 30;
    private static final int ul = 10;
    private static final int um = 12000;
    private static final int un = 40;
    private static final int uo = 160;
    private final boolean jI;
    private int up;
    private int uq;
    private int ur;

    public xy(@NotNull String str, boolean z) {
        super(str);
        this.up = -1;
        this.uq = 0;
        this.ur = -1;
        this.jI = z;
        if (z) {
            C0263jt.log("[Update] Automatic server updates are enabled.", new Object[0]);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0268jy
    public void onUpdate() {
        super.onUpdate();
        if (this.jI && ad()) {
            switch (a()) {
                case IDLE:
                    if (this.ur < 0) {
                        this.ur = 40 + ((int) (Math.random() * 160.0d));
                        C0263jt.log("[Update] New version '%s' found, downloading in %d seconds...", s(), Integer.valueOf(this.ur / 20));
                    } else {
                        int i = this.ur - 1;
                        this.ur = i;
                        if (i <= 0) {
                            bb();
                        }
                    }
                    break;
                case FAILED:
                    this.up = -1;
                    int i2 = this.uq + 1;
                    this.uq = i2;
                    if (i2 >= um) {
                        this.uq = 0;
                        C0263jt.log("[Update] Retrying the update download...", new Object[0]);
                        bb();
                    }
                    break;
                case READY:
                    dK();
                    break;
            }
        }
    }

    private void dK() {
        int i;
        if (this.up < 0) {
            this.up = 600;
            C0263jt.log("[Update] Update '%s' staged, rebooting in %d seconds...", s(), 30);
            d(Component.literal("A new update (").append(Component.literal(s()).withStyle(ChatFormatting.YELLOW)).append(Component.literal(") is available! Please download the new update. This server will reboot in ")).append(Component.literal(String.valueOf(30)).withStyle(ChatFormatting.YELLOW)).append(Component.literal(" seconds.")).withColor(ColorReferences.COLOR_THEME_RED));
            return;
        }
        this.up--;
        if (this.up <= 0) {
            C0263jt.log("[Update] Rebooting to install update '%s'.", s());
            bd();
        } else if (this.up % 20 == 0 && (i = this.up / 20) <= 10) {
            d(Component.literal("Server rebooting in ").append(Component.literal(String.valueOf(i)).withStyle(ChatFormatting.YELLOW)).append(Component.literal(" seconds...")).withColor(ColorReferences.COLOR_THEME_RED));
        }
    }

    private void d(@NotNull Component component) {
        MinecraftServer minecraftServerA = C0262js.a();
        if (minecraftServerA == null) {
            return;
        }
        Iterator it = minecraftServerA.getPlayerList().getPlayers().iterator();
        while (it.hasNext()) {
            ((ServerPlayer) it.next()).sendSystemMessage(component);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0268jy
    protected void g() {
        MinecraftServer minecraftServerA = C0262js.a();
        if (minecraftServerA != null) {
            minecraftServerA.halt(false);
        }
    }
}
