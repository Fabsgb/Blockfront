package com.boehmod.blockfront.common.player;

import com.boehmod.blockfront.C0799oR;
import com.boehmod.blockfront.C1194vo;
import com.boehmod.blockfront.C1199vt;
import com.boehmod.blockfront.C1200vu;
import com.boehmod.blockfront.C1280xc;
import com.boehmod.blockfront.EnumC0786oE;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.common.player.a */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/a.class */
public abstract class AbstractC0181a<P extends AbstractC0182b<?, ?, ?, ?>> {

    /* JADX INFO: renamed from: sV */
    private static final int f1469sV = 60;

    /* JADX INFO: renamed from: eU */
    protected boolean f1470eU = false;

    /* JADX INFO: renamed from: sW */
    private int f1471sW = 60;

    /* JADX INFO: renamed from: s */
    @NotNull
    private ItemStack f1472s = ItemStack.EMPTY;

    /* JADX INFO: renamed from: sX */
    private int f1473sX = -1;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final P f1474b;

    public AbstractC0181a(@NotNull P p) {
        this.f1474b = p;
    }

    /* JADX INFO: renamed from: a */
    public void m1067a(@NotNull ServerPlayer serverPlayer, @NotNull LivingEntity livingEntity, @NotNull ItemStack itemStack) {
        if (this.f1470eU) {
            return;
        }
        m1071W(true);
        this.f1471sW = 60;
        this.f1472s = itemStack.copy();
        this.f1473sX = livingEntity.getId();
        int id = serverPlayer.getId();
        C1194vo.m6649b(new C1199vt(C1280xc.f8203BK, SoundSource.PLAYERS, id, 1.0f, 1.5f));
        C1194vo.m6649b(new C1199vt(C1280xc.f8202BJ, SoundSource.PLAYERS, id, 1.0f, 1.5f));
        C1194vo.m6649b(new C1199vt(C1280xc.f8465GM, SoundSource.PLAYERS, id, 1.0f, 1.0f));
    }

    /* JADX INFO: renamed from: dw */
    private void m1068dw() {
        m1071W(false);
        this.f1471sW = 60;
        this.f1472s = ItemStack.EMPTY;
        this.f1473sX = -1;
    }

    /* JADX INFO: renamed from: a */
    public void m1069a(@NotNull Level level, @NotNull ServerPlayer serverPlayer) {
        if (C0799oR.m4052a((Player) serverPlayer, (AbstractC0182b<?, ?, ?, ?>) this.f1474b)) {
            m1068dw();
            return;
        }
        if (this.f1470eU) {
            serverPlayer.swing(level.random.nextFloat() < 0.5f ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
        }
        if (this.f1470eU) {
            int i = this.f1471sW;
            this.f1471sW = i - 1;
            if (i > 0) {
                return;
            }
            m1070b(level, serverPlayer);
            m1068dw();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1070b(@NotNull Level level, @NotNull ServerPlayer serverPlayer) {
        Entity entity = this.f1473sX == -1 ? null : level.getEntity(this.f1473sX);
        Vec3 vec3Position = serverPlayer.position();
        Explosion explosionM4054a = C0799oR.m4054a(level, entity, vec3Position, this.f1472s, 5.5f);
        serverPlayer.getInventory().clearContent();
        explosionM4054a.explode();
        explosionM4054a.finalizeExplosion(true);
        explosionM4054a.clearToBlow();
        C1194vo.m6649b(new C1200vu(EnumC0786oE.GENERIC, vec3Position));
    }

    /* JADX INFO: renamed from: W */
    public void m1071W(boolean z) {
        if (this.f1470eU != z) {
            this.f1470eU = z;
            this.f1474b.m1084dx();
        }
    }

    /* JADX INFO: renamed from: aL */
    public boolean m1072aL() {
        return this.f1470eU;
    }

    /* JADX INFO: renamed from: b */
    public void m1073b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f1470eU);
    }

    /* JADX INFO: renamed from: e */
    public void m1074e(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f1470eU = friendlyByteBuf.readBoolean();
    }
}
