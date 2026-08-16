package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xZ.class */
public class C1286xZ {

    /* JADX INFO: renamed from: ww */
    private static final int f6911ww = 400;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final ServerPlayer f6912e;

    /* JADX INFO: renamed from: a */
    @NotNull
    private a f6913a = a.IDLE;

    /* JADX INFO: renamed from: ab */
    private long f6914ab;

    /* JADX INFO: renamed from: f */
    @Nullable
    private ServerPlayer f6915f;

    /* JADX INFO: renamed from: com.boehmod.blockfront.xZ$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xZ$a.class */
    public enum a {
        IDLE,
        REQUESTED
    }

    public C1286xZ(@NotNull ServerPlayer serverPlayer) {
        this.f6912e = serverPlayer;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public a m7306a() {
        return this.f6913a;
    }

    /* JADX INFO: renamed from: l */
    public void m7307l(@NotNull ServerPlayer serverPlayer) {
        MutableComponent mutableComponentWithStyle = Component.literal(this.f6912e.getScoreboardName()).withStyle(ChatFormatting.GRAY);
        if (this.f6913a != a.IDLE) {
            serverPlayer.sendSystemMessage(Component.translatable("bf.message.screenshot.request.error.already", new Object[]{mutableComponentWithStyle}));
            return;
        }
        this.f6913a = a.REQUESTED;
        this.f6914ab = 400L;
        this.f6915f = serverPlayer;
        C1169vO.m6643a(new C0539jV(), this.f6912e);
        serverPlayer.sendSystemMessage(Component.translatable("bf.message.screenshot.request.sent", new Object[]{mutableComponentWithStyle}));
        C0530jM.log("[Screenshot] Requested screenshot from player '%s' for requesting player '%s'.", this.f6912e.getScoreboardName(), serverPlayer.getScoreboardName());
    }

    /* JADX INFO: renamed from: a */
    public void m7308a(byte[] bArr) {
        String scoreboardName = this.f6912e.getScoreboardName();
        C0530jM.log("[Screenshot] Received %d bytes of screenshot data from player '%s'.", Integer.valueOf(bArr.length), scoreboardName);
        if (this.f6913a != a.REQUESTED) {
            C0530jM.log("[Screenshot] Error! Received a screenshot from player '%s' when not expected. Stage: %s.", scoreboardName, this.f6913a.toString());
            return;
        }
        this.f6913a = a.IDLE;
        if (this.f6915f != null) {
            C0530jM.log("[Screenshot] Sending complete screenshot data from player '%s' to requesting player '%s'.", scoreboardName, this.f6915f.getScoreboardName());
            C1169vO.m6643a(new C0538jU(bArr), this.f6915f);
        }
    }

    public void onUpdate() {
        if (this.f6913a == a.IDLE) {
            return;
        }
        long j = this.f6914ab;
        this.f6914ab = j - 1;
        if (j < 0) {
            this.f6913a = a.IDLE;
            if (this.f6915f != null) {
                this.f6915f.sendSystemMessage(Component.translatable("bf.message.screenshot.request.error.timeout", new Object[]{Component.literal(this.f6912e.getScoreboardName()).withStyle(ChatFormatting.GRAY)}));
            }
        }
    }
}
