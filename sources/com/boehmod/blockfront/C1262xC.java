package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xC.class */
public class C1262xC {

    /* JADX INFO: renamed from: us */
    private static final int f7450us = 400;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final ServerPlayer f7451d;

    /* JADX INFO: renamed from: a */
    @NotNull
    private a f7452a = a.IDLE;

    /* JADX INFO: renamed from: G */
    private long f7453G;

    /* JADX INFO: renamed from: e */
    @Nullable
    private ServerPlayer f7454e;

    /* JADX INFO: renamed from: com.boehmod.blockfront.xC$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xC$a.class */
    public enum a {
        IDLE,
        REQUESTED
    }

    public C1262xC(@NotNull ServerPlayer serverPlayer) {
        this.f7451d = serverPlayer;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public a m7748a() {
        return this.f7452a;
    }

    /* JADX INFO: renamed from: l */
    public void m7749l(@NotNull ServerPlayer serverPlayer) {
        MutableComponent mutableComponentWithStyle = Component.literal(this.f7451d.getScoreboardName()).withStyle(ChatFormatting.GRAY);
        if (this.f7452a != a.IDLE) {
            serverPlayer.sendSystemMessage(Component.translatable("bf.message.screenshot.request.error.already", new Object[]{mutableComponentWithStyle}));
            return;
        }
        this.f7452a = a.REQUESTED;
        this.f7453G = 400L;
        this.f7454e = serverPlayer;
        C1194vo.m6648a(new C0519jC(), this.f7451d);
        serverPlayer.sendSystemMessage(Component.translatable("bf.message.screenshot.request.sent", new Object[]{mutableComponentWithStyle}));
        C0562jt.log("[Screenshot] Requested screenshot from player '%s' for requesting player '%s'.", this.f7451d.getScoreboardName(), serverPlayer.getScoreboardName());
    }

    /* JADX INFO: renamed from: a */
    public void m7750a(byte[] bArr) {
        String scoreboardName = this.f7451d.getScoreboardName();
        C0562jt.log("[Screenshot] Received %d bytes of screenshot data from player '%s'.", Integer.valueOf(bArr.length), scoreboardName);
        if (this.f7452a != a.REQUESTED) {
            C0562jt.log("[Screenshot] Error! Received a screenshot from player '%s' when not expected. Stage: %s.", scoreboardName, this.f7452a.toString());
            return;
        }
        this.f7452a = a.IDLE;
        if (this.f7454e != null) {
            C0562jt.log("[Screenshot] Sending complete screenshot data from player '%s' to requesting player '%s'.", scoreboardName, this.f7454e.getScoreboardName());
            C1194vo.m6648a(new C0518jB(bArr), this.f7454e);
        }
    }

    public void onUpdate() {
        if (this.f7452a == a.IDLE) {
            return;
        }
        long j = this.f7453G;
        this.f7453G = j - 1;
        if (j < 0) {
            this.f7452a = a.IDLE;
            if (this.f7454e != null) {
                this.f7454e.sendSystemMessage(Component.translatable("bf.message.screenshot.request.error.timeout", new Object[]{Component.literal(this.f7451d.getScoreboardName()).withStyle(ChatFormatting.GRAY)}));
            }
        }
    }
}
