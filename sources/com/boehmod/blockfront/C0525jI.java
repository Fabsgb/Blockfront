package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMPlayerSuspicious;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jI.class */
public class C0525jI {

    /* JADX INFO: renamed from: ic */
    @NotNull
    private static final Component f3104ic = Component.translatable("bf.message.gamemode.suspicious.kick").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: kc */
    private static final int f3105kc = 200;

    /* JADX INFO: renamed from: kd */
    private static final int f3106kd = 20;

    /* JADX INFO: renamed from: ke */
    private static final int f3108ke = 20;

    /* JADX INFO: renamed from: dB */
    private boolean f3107dB = false;

    /* JADX INFO: renamed from: kf */
    private int f3109kf = 0;

    /* JADX INFO: renamed from: kg */
    private int f3110kg = 0;

    /* JADX INFO: renamed from: be */
    public void m2322be() {
        this.f3109kf++;
    }

    /* JADX INFO: renamed from: ah */
    public boolean m2323ah() {
        return this.f3107dB;
    }

    /* JADX INFO: renamed from: z */
    public void m2324z(boolean z) {
        this.f3107dB = z;
    }

    /* JADX INFO: renamed from: a */
    public void m2325a(@NotNull C1300xw c1300xw, @NotNull ServerPlayer serverPlayer) {
        this.f3110kg++;
        if (this.f3110kg >= 200) {
            this.f3110kg = 0;
            this.f3109kf = 0;
        }
        if (this.f3109kf >= 20) {
            C0562jt.log("Player " + serverPlayer.getName().getString() + " has been logged as suspicious for firing " + this.f3109kf + " suspicious shots in the last 10 seconds.", new Object[0]);
            if (C0476iM.f2921di) {
                ((C1298xu) c1300xw.m7961b()).sendPacket(new PacketMMPlayerSuspicious(serverPlayer.getUUID(), "Player " + serverPlayer.getName().getString() + " has been logged as suspicious for firing " + this.f3109kf + " suspicious shots in the last 10 seconds."));
            }
            if (C0476iM.f2920dh) {
                serverPlayer.connection.disconnect(f3104ic);
            }
        }
    }
}
