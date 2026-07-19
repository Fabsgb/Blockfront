package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.mm.PacketMMPlayerSuspicious;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jI.class */
public class jI {

    @NotNull
    private static final Component ic = Component.translatable("bf.message.gamemode.suspicious.kick").withStyle(ChatFormatting.RED);
    private static final int kc = 200;
    private static final int kd = 20;
    private static final int ke = 20;
    private boolean dB = false;
    private int kf = 0;
    private int kg = 0;

    public void be() {
        this.kf++;
    }

    public boolean ah() {
        return this.dB;
    }

    public void z(boolean z) {
        this.dB = z;
    }

    public void a(@NotNull xw xwVar, @NotNull ServerPlayer serverPlayer) {
        this.kg++;
        if (this.kg >= 200) {
            this.kg = 0;
            this.kf = 0;
        }
        if (this.kf >= 20) {
            C0263jt.log("Player " + serverPlayer.getName().getString() + " has been logged as suspicious for firing " + this.kf + " suspicious shots in the last 10 seconds.", new Object[0]);
            if (iM.di) {
                ((xu) xwVar.b()).sendPacket(new PacketMMPlayerSuspicious(serverPlayer.getUUID(), "Player " + serverPlayer.getName().getString() + " has been logged as suspicious for firing " + this.kf + " suspicious shots in the last 10 seconds."));
            }
            if (iM.dh) {
                serverPlayer.connection.disconnect(ic);
            }
        }
    }
}
