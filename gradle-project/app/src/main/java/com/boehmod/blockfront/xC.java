package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xC.class */
public class xC {
    private static final int us = 400;

    @NotNull
    private final ServerPlayer d;

    @NotNull
    private a a = a.IDLE;
    private long G;

    @Nullable
    private ServerPlayer e;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xC$a.class */
    public enum a {
        IDLE,
        REQUESTED
    }

    public xC(@NotNull ServerPlayer serverPlayer) {
        this.d = serverPlayer;
    }

    @NotNull
    public a a() {
        return this.a;
    }

    public void l(@NotNull ServerPlayer serverPlayer) {
        MutableComponent mutableComponentWithStyle = Component.literal(this.d.getScoreboardName()).withStyle(ChatFormatting.GRAY);
        if (this.a != a.IDLE) {
            serverPlayer.sendSystemMessage(Component.translatable("bf.message.screenshot.request.error.already", new Object[]{mutableComponentWithStyle}));
            return;
        }
        this.a = a.REQUESTED;
        this.G = 400L;
        this.e = serverPlayer;
        C0582vo.a(new jC(), this.d);
        serverPlayer.sendSystemMessage(Component.translatable("bf.message.screenshot.request.sent", new Object[]{mutableComponentWithStyle}));
        C0263jt.log("[Screenshot] Requested screenshot from player '%s' for requesting player '%s'.", this.d.getScoreboardName(), serverPlayer.getScoreboardName());
    }

    public void a(byte[] bArr) {
        String scoreboardName = this.d.getScoreboardName();
        C0263jt.log("[Screenshot] Received %d bytes of screenshot data from player '%s'.", Integer.valueOf(bArr.length), scoreboardName);
        if (this.a != a.REQUESTED) {
            C0263jt.log("[Screenshot] Error! Received a screenshot from player '%s' when not expected. Stage: %s.", scoreboardName, this.a.toString());
            return;
        }
        this.a = a.IDLE;
        if (this.e != null) {
            C0263jt.log("[Screenshot] Sending complete screenshot data from player '%s' to requesting player '%s'.", scoreboardName, this.e.getScoreboardName());
            C0582vo.a(new jB(bArr), this.e);
        }
    }

    public void onUpdate() {
        if (this.a == a.IDLE) {
            return;
        }
        long j = this.G;
        this.G = j - 1;
        if (j < 0) {
            this.a = a.IDLE;
            if (this.e != null) {
                this.e.sendSystemMessage(Component.translatable("bf.message.screenshot.request.error.timeout", new Object[]{Component.literal(this.d.getScoreboardName()).withStyle(ChatFormatting.GRAY)}));
            }
        }
    }
}
