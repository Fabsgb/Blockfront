package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.util.Iterator;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xy.class */
public final class C1302xy extends AbstractC0567jy {

    /* JADX INFO: renamed from: uk */
    private static final int f8696uk = 30;

    /* JADX INFO: renamed from: ul */
    private static final int f8697ul = 10;

    /* JADX INFO: renamed from: um */
    private static final int f8698um = 12000;

    /* JADX INFO: renamed from: un */
    private static final int f8699un = 40;

    /* JADX INFO: renamed from: uo */
    private static final int f8700uo = 160;

    /* JADX INFO: renamed from: jI */
    private final boolean f8701jI;

    /* JADX INFO: renamed from: up */
    private int f8702up;

    /* JADX INFO: renamed from: uq */
    private int f8703uq;

    /* JADX INFO: renamed from: ur */
    private int f8704ur;

    public C1302xy(@NotNull String str, boolean z) {
        super(str);
        this.f8702up = -1;
        this.f8703uq = 0;
        this.f8704ur = -1;
        this.f8701jI = z;
        if (z) {
            C0562jt.log("[Update] Automatic server updates are enabled.", new Object[0]);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0567jy
    public void onUpdate() {
        super.onUpdate();
        if (this.f8701jI && m2558ad()) {
            switch (m2562a()) {
                case IDLE:
                    if (this.f8704ur < 0) {
                        this.f8704ur = 40 + ((int) (Math.random() * 160.0d));
                        C0562jt.log("[Update] New version '%s' found, downloading in %d seconds...", m2559s(), Integer.valueOf(this.f8704ur / 20));
                    } else {
                        int i = this.f8704ur - 1;
                        this.f8704ur = i;
                        if (i <= 0) {
                            m2568bb();
                        }
                    }
                    break;
                case FAILED:
                    this.f8702up = -1;
                    int i2 = this.f8703uq + 1;
                    this.f8703uq = i2;
                    if (i2 >= f8698um) {
                        this.f8703uq = 0;
                        C0562jt.log("[Update] Retrying the update download...", new Object[0]);
                        m2568bb();
                    }
                    break;
                case READY:
                    m7965dK();
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: dK */
    private void m7965dK() {
        int i;
        if (this.f8702up < 0) {
            this.f8702up = 600;
            C0562jt.log("[Update] Update '%s' staged, rebooting in %d seconds...", m2559s(), 30);
            m7966d(Component.literal("A new update (").append(Component.literal(m2559s()).withStyle(ChatFormatting.YELLOW)).append(Component.literal(") is available! Please download the new update. This server will reboot in ")).append(Component.literal(String.valueOf(30)).withStyle(ChatFormatting.YELLOW)).append(Component.literal(" seconds.")).withColor(ColorReferences.COLOR_THEME_RED));
            return;
        }
        this.f8702up--;
        if (this.f8702up <= 0) {
            C0562jt.log("[Update] Rebooting to install update '%s'.", m2559s());
            m2570bd();
        } else if (this.f8702up % 20 == 0 && (i = this.f8702up / 20) <= 10) {
            m7966d(Component.literal("Server rebooting in ").append(Component.literal(String.valueOf(i)).withStyle(ChatFormatting.YELLOW)).append(Component.literal(" seconds...")).withColor(ColorReferences.COLOR_THEME_RED));
        }
    }

    /* JADX INFO: renamed from: d */
    private void m7966d(@NotNull Component component) {
        MinecraftServer minecraftServerM2514a = C0561js.m2514a();
        if (minecraftServerM2514a == null) {
            return;
        }
        Iterator it = minecraftServerM2514a.getPlayerList().getPlayers().iterator();
        while (it.hasNext()) {
            ((ServerPlayer) it.next()).sendSystemMessage(component);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0567jy
    /* JADX INFO: renamed from: g */
    protected void mo2572g() {
        MinecraftServer minecraftServerM2514a = C0561js.m2514a();
        if (minecraftServerM2514a != null) {
            minecraftServerM2514a.halt(false);
        }
    }
}
