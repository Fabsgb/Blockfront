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

/* JADX INFO: renamed from: com.boehmod.blockfront.xK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xK.class */
public class C1270xK {

    /* JADX INFO: renamed from: kh */
    @NotNull
    private static final Component f7458kh = Component.translatable("bf.message.gamemode.afk.kick").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: ki */
    @NotNull
    private static final Component f7459ki = Component.translatable("bf.message.gamemode.afk.reset").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: ut */
    private static final int f7460ut = 1200;

    /* JADX INFO: renamed from: uu */
    private static final int f7461uu = 6000;

    /* JADX INFO: renamed from: uv */
    private static final int f7462uv = 5;

    /* JADX INFO: renamed from: uw */
    private int f7463uw = 0;

    /* JADX INFO: renamed from: aN */
    @Nullable
    private Vec3 f7464aN = null;

    /* JADX INFO: renamed from: jL */
    private boolean f7465jL = false;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1274xO f7466a;

    public C1270xK(@NotNull C1274xO c1274xO) {
        this.f7466a = c1274xO;
    }

    /* JADX INFO: renamed from: dL */
    public void m7760dL() {
        this.f7465jL = true;
    }

    /* JADX INFO: renamed from: m */
    private void m7761m(@NotNull ServerPlayer serverPlayer) {
        this.f7464aN = null;
        if (this.f7463uw == 0) {
            return;
        }
        if (this.f7463uw >= 1200) {
            C0799oR.m3970c(serverPlayer, f7459ki);
            serverPlayer.playNotifySound(SoundEvents.VAULT_DEACTIVATE, SoundSource.MASTER, 1.0f, 1.0f);
        }
        this.f7463uw = 0;
    }

    /* JADX INFO: renamed from: b */
    private void m7762b(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        C0799oR.m3981a(abstractC0787oF, (Component) Component.translatable("bf.message.gamemode.afk.kick.all", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
        serverPlayer.connection.disconnect(f7458kh);
    }

    /* JADX INFO: renamed from: n */
    private void m7763n(@NotNull ServerPlayer serverPlayer) {
        C0799oR.m3970c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.afk.time", new Object[]{Component.literal(String.valueOf(this.f7463uw / 1200)).withColor(ColorReferences.COLOR_WHITE), Component.literal(String.valueOf(5)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
        serverPlayer.playNotifySound(SoundEvents.VAULT_ACTIVATE, SoundSource.MASTER, 1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: c */
    public void m7764c(@NotNull ServerPlayer serverPlayer, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        if (abstractC0787oF == null) {
            this.f7463uw = 0;
            return;
        }
        if (!abstractC0787oF.m3626be()) {
            Vec3 vec3Position = serverPlayer.position();
            boolean z = false;
            if (this.f7464aN != null) {
                z = this.f7464aN.distanceTo(vec3Position) > 5.0d;
            }
            if ((this.f7466a.m1093dm() || this.f7466a.m7782a().m7775du() || this.f7466a.m1087dk() || serverPlayer.isCreative() || serverPlayer.isSpectator() || serverPlayer.getVehicle() != null) ? false : true) {
                this.f7463uw++;
            }
            if (this.f7463uw >= 1200 && z && this.f7465jL) {
                m7761m(serverPlayer);
            } else if (this.f7463uw < 1200 && this.f7465jL) {
                m7761m(serverPlayer);
            }
            if (this.f7463uw > 0 && this.f7463uw % 1200 == 0) {
                this.f7464aN = new Vec3(vec3Position.x, vec3Position.y, vec3Position.z);
                m7763n(serverPlayer);
            }
            if (this.f7463uw >= f7461uu) {
                m7762b(serverPlayer, abstractC0787oF);
            }
            this.f7465jL = false;
        }
    }
}
