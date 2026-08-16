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

/* JADX INFO: renamed from: com.boehmod.blockfront.yi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/yi.class */
public class C1322yi {

    /* JADX INFO: renamed from: ku */
    @NotNull
    private static final Component f9042ku = Component.translatable("bf.message.gamemode.afk.kick").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: kv */
    @NotNull
    private static final Component f9043kv = Component.translatable("bf.message.gamemode.afk.reset").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: wx */
    private static final int f9044wx = 1200;

    /* JADX INFO: renamed from: wy */
    private static final int f9045wy = 6000;

    /* JADX INFO: renamed from: wz */
    private static final int f9046wz = 5;

    /* JADX INFO: renamed from: wA */
    private int f9047wA = 0;

    /* JADX INFO: renamed from: aO */
    @Nullable
    private Vec3 f9048aO = null;

    /* JADX INFO: renamed from: kb */
    private boolean f9049kb = false;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C1326ym f9050b;

    public C1322yi(@NotNull C1326ym c1326ym) {
        this.f9050b = c1326ym;
    }

    /* JADX INFO: renamed from: dV */
    public void m8276dV() {
        this.f9049kb = true;
    }

    /* JADX INFO: renamed from: m */
    private void m8277m(@NotNull ServerPlayer serverPlayer) {
        this.f9048aO = null;
        if (this.f9047wA == 0) {
            return;
        }
        if (this.f9047wA >= 1200) {
            C0875pn.m4406c(serverPlayer, f9043kv);
            serverPlayer.playNotifySound(SoundEvents.VAULT_DEACTIVATE, SoundSource.MASTER, 1.0f, 1.0f);
        }
        this.f9047wA = 0;
    }

    /* JADX INFO: renamed from: b */
    private void m8278b(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        C0875pn.m4417a(abstractC0863pb, (Component) Component.translatable("bf.message.gamemode.afk.kick.all", new Object[]{Component.literal(serverPlayer.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
        serverPlayer.connection.disconnect(f9042ku);
    }

    /* JADX INFO: renamed from: n */
    private void m8279n(@NotNull ServerPlayer serverPlayer) {
        C0875pn.m4406c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.afk.time", new Object[]{Component.literal(String.valueOf(this.f9047wA / 1200)).withColor(ColorReferences.COLOR_WHITE), Component.literal(String.valueOf(5)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
        serverPlayer.playNotifySound(SoundEvents.VAULT_ACTIVATE, SoundSource.MASTER, 1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: c */
    public void m8280c(@NotNull ServerPlayer serverPlayer, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        if (abstractC0863pb == null) {
            this.f9047wA = 0;
            return;
        }
        if (!abstractC0863pb.m4062bo()) {
            Vec3 vec3Position = serverPlayer.position();
            boolean z = false;
            if (this.f9048aO != null) {
                z = this.f9048aO.distanceTo(vec3Position) > 5.0d;
            }
            if ((this.f9050b.m1110dv() || this.f9050b.m8298a().m8291dD() || this.f9050b.m1104dt() || serverPlayer.isCreative() || serverPlayer.isSpectator() || serverPlayer.getVehicle() != null) ? false : true) {
                this.f9047wA++;
            }
            if (this.f9047wA >= 1200 && z && this.f9049kb) {
                m8277m(serverPlayer);
            } else if (this.f9047wA < 1200 && this.f9049kb) {
                m8277m(serverPlayer);
            }
            if (this.f9047wA > 0 && this.f9047wA % 1200 == 0) {
                this.f9048aO = new Vec3(vec3Position.x, vec3Position.y, vec3Position.z);
                m8279n(serverPlayer);
            }
            if (this.f9047wA >= f9045wy) {
                m8278b(serverPlayer, abstractC0863pb);
            }
            this.f9049kb = false;
        }
    }
}
