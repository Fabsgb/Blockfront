package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xK.class */
public class xK {

    @NotNull
    private static final Component kh = Component.translatable("bf.message.gamemode.afk.kick").withStyle(ChatFormatting.RED);

    @NotNull
    private static final Component ki = Component.translatable("bf.message.gamemode.afk.reset").withStyle(ChatFormatting.RED);
    private static final int ut = 1200;
    private static final int uu = 6000;
    private static final int uv = 5;
    private int uw = 0;

    @Nullable
    private Vec3 aN = null;
    private boolean jL = false;

    @NotNull
    private final xO a;

    public xK(@NotNull xO xOVar) {
        this.a = xOVar;
    }

    public void dL() {
        this.jL = true;
    }

    private void m(@NotNull ServerPlayer serverPlayer) {
        this.aN = null;
        if (this.uw == 0) {
            return;
        }
        if (this.uw >= 1200) {
            oR.c(serverPlayer, ki);
            serverPlayer.playNotifySound(SoundEvents.VAULT_DEACTIVATE, SoundSource.MASTER, 1.0f, 1.0f);
        }
        this.uw = 0;
    }

    private void b(@NotNull ServerPlayer serverPlayer, @NotNull oF<?, ?, ?> oFVar) {
        oR.a(oFVar, (Component) Component.translatable("bf.message.gamemode.afk.kick.all", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
        serverPlayer.connection.disconnect(kh);
    }

    private void n(@NotNull ServerPlayer serverPlayer) {
        oR.c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.afk.time", new Object[]{Component.literal(String.valueOf(this.uw / 1200)).withColor(ColorReferences.COLOR_WHITE), Component.literal(String.valueOf(5)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
        serverPlayer.playNotifySound(SoundEvents.VAULT_ACTIVATE, SoundSource.MASTER, 1.0f, 1.0f);
    }

    public void c(@NotNull ServerPlayer serverPlayer, @Nullable oF<?, ?, ?> oFVar) {
        if (oFVar == null) {
            this.uw = 0;
            return;
        }
        if (!oFVar.be()) {
            Vec3 vec3Position = serverPlayer.position();
            boolean z = false;
            if (this.aN != null) {
                z = this.aN.distanceTo(vec3Position) > 5.0d;
            }
            if ((this.a.dm() || this.a.a().du() || this.a.dk() || serverPlayer.isCreative() || serverPlayer.isSpectator() || serverPlayer.getVehicle() != null) ? false : true) {
                this.uw++;
            }
            if (this.uw >= 1200 && z && this.jL) {
                m(serverPlayer);
            } else if (this.uw < 1200 && this.jL) {
                m(serverPlayer);
            }
            if (this.uw > 0 && this.uw % 1200 == 0) {
                this.aN = new Vec3(vec3Position.x, vec3Position.y, vec3Position.z);
                n(serverPlayer);
            }
            if (this.uw >= uu) {
                b(serverPlayer, oFVar);
            }
            this.jL = false;
        }
    }
}
