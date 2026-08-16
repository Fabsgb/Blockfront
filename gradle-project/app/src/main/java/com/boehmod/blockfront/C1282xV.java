package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.cloud.connection.ModConnection;
import java.util.Iterator;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xV.class */
public final class C1282xV extends AbstractC0535jR {

    /* JADX INFO: renamed from: wo */
    private static final int f6895wo = 30;

    /* JADX INFO: renamed from: wp */
    private static final int f6896wp = 10;

    /* JADX INFO: renamed from: wq */
    private static final int f6897wq = 12000;

    /* JADX INFO: renamed from: wr */
    private static final int f6898wr = 40;

    /* JADX INFO: renamed from: ws */
    private static final int f6899ws = 160;

    /* JADX INFO: renamed from: jY */
    private final boolean f6900jY;

    /* JADX INFO: renamed from: wt */
    private int f6901wt;

    /* JADX INFO: renamed from: wu */
    private int f6902wu;

    /* JADX INFO: renamed from: wv */
    private int f6903wv;

    public C1282xV(@NotNull String str, boolean z) {
        super(str);
        this.f6901wt = -1;
        this.f6902wu = 0;
        this.f6903wv = -1;
        this.f6900jY = z;
        if (z) {
            C0530jM.log("[Update] Automatic server updates are enabled.", new Object[0]);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0535jR
    public void onUpdate() {
        super.onUpdate();
        if (this.f6900jY && m2382ah()) {
            switch (m2387a()) {
                case IDLE:
                    if (this.f6903wv < 0) {
                        this.f6903wv = 40 + ((int) (Math.random() * 160.0d));
                        C0530jM.log("[Update] New version '%s' found, downloading in %d seconds...", m2383w(), Integer.valueOf(this.f6903wv / 20));
                    } else {
                        int i = this.f6903wv - 1;
                        this.f6903wv = i;
                        if (i <= 0) {
                            m2392bn();
                        }
                    }
                    break;
                case FAILED:
                    this.f6901wt = -1;
                    int i2 = this.f6902wu + 1;
                    this.f6902wu = i2;
                    if (i2 >= f6897wq) {
                        this.f6902wu = 0;
                        C0530jM.log("[Update] Retrying the update download...", new Object[0]);
                        m2392bn();
                    }
                    break;
                case READY:
                    m7293dU();
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: dU */
    private void m7293dU() {
        int i;
        if (this.f6901wt < 0) {
            this.f6901wt = ModConnection.CONNECT_TIME_MAX_TICKS;
            C0530jM.log("[Update] Update '%s' staged, rebooting in %d seconds...", m2383w(), 30);
            m7294d((Component) Component.literal("A new update (").append(Component.literal(m2383w()).withStyle(ChatFormatting.YELLOW)).append(Component.literal(") is available! Please download the new update. This server will reboot in ")).append(Component.literal(String.valueOf(30)).withStyle(ChatFormatting.YELLOW)).append(Component.literal(" seconds.")).withColor(ColorReferences.COLOR_THEME_RED));
            return;
        }
        this.f6901wt--;
        if (this.f6901wt <= 0) {
            C0530jM.log("[Update] Rebooting to install update '%s'.", m2383w());
            m2394bp();
        } else if (this.f6901wt % 20 == 0 && (i = this.f6901wt / 20) <= 10) {
            m7294d((Component) Component.literal("Server rebooting in ").append(Component.literal(String.valueOf(i)).withStyle(ChatFormatting.YELLOW)).append(Component.literal(" seconds...")).withColor(ColorReferences.COLOR_THEME_RED));
        }
    }

    /* JADX INFO: renamed from: d */
    private void m7294d(@NotNull Component component) {
        MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
        if (minecraftServerM2335a == null) {
            return;
        }
        Iterator it = minecraftServerM2335a.getPlayerList().getPlayers().iterator();
        while (it.hasNext()) {
            ((ServerPlayer) it.next()).sendSystemMessage(component);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0535jR
    /* JADX INFO: renamed from: g */
    protected void mo2396g() {
        MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
        if (minecraftServerM2335a != null) {
            minecraftServerM2335a.halt(false);
        }
    }
}
