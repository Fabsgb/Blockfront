package com.boehmod.blockfront.common.player;

import com.boehmod.blockfront.C0582vo;
import com.boehmod.blockfront.C0587vt;
import com.boehmod.blockfront.C0588vu;
import com.boehmod.blockfront.C0624xc;
import com.boehmod.blockfront.common.player.b;
import com.boehmod.blockfront.oE;
import com.boehmod.blockfront.oR;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/common/player/a.class */
public abstract class a<P extends b<?, ?, ?, ?>> {
    private static final int sV = 60;
    protected boolean eU = false;
    private int sW = 60;

    @NotNull
    private ItemStack s = ItemStack.EMPTY;
    private int sX = -1;

    @NotNull
    private final P b;

    public a(@NotNull P p) {
        this.b = p;
    }

    public void a(@NotNull ServerPlayer serverPlayer, @NotNull LivingEntity livingEntity, @NotNull ItemStack itemStack) {
        if (this.eU) {
            return;
        }
        W(true);
        this.sW = 60;
        this.s = itemStack.copy();
        this.sX = livingEntity.getId();
        int id = serverPlayer.getId();
        C0582vo.b(new C0587vt(C0624xc.BK, SoundSource.PLAYERS, id, 1.0f, 1.5f));
        C0582vo.b(new C0587vt(C0624xc.BJ, SoundSource.PLAYERS, id, 1.0f, 1.5f));
        C0582vo.b(new C0587vt(C0624xc.GM, SoundSource.PLAYERS, id, 1.0f, 1.0f));
    }

    private void dw() {
        W(false);
        this.sW = 60;
        this.s = ItemStack.EMPTY;
        this.sX = -1;
    }

    public void a(@NotNull Level level, @NotNull ServerPlayer serverPlayer) {
        if (oR.a((Player) serverPlayer, (b<?, ?, ?, ?>) this.b)) {
            dw();
            return;
        }
        if (this.eU) {
            serverPlayer.swing(level.random.nextFloat() < 0.5f ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
        }
        if (this.eU) {
            int i = this.sW;
            this.sW = i - 1;
            if (i > 0) {
                return;
            }
            b(level, serverPlayer);
            dw();
        }
    }

    public void b(@NotNull Level level, @NotNull ServerPlayer serverPlayer) {
        Entity entity = this.sX == -1 ? null : level.getEntity(this.sX);
        Vec3 vec3Position = serverPlayer.position();
        Explosion explosionA = oR.a(level, entity, vec3Position, this.s, 5.5f);
        serverPlayer.getInventory().clearContent();
        explosionA.explode();
        explosionA.finalizeExplosion(true);
        explosionA.clearToBlow();
        C0582vo.b(new C0588vu(oE.GENERIC, vec3Position));
    }

    public void W(boolean z) {
        if (this.eU != z) {
            this.eU = z;
            this.b.dx();
        }
    }

    public boolean aL() {
        return this.eU;
    }

    public void b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.eU);
    }

    public void e(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.eU = friendlyByteBuf.readBoolean();
    }
}
