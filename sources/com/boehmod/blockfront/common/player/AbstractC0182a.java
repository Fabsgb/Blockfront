package com.boehmod.blockfront.common.player;

import com.boehmod.blockfront.C0875pn;
import com.boehmod.blockfront.C1169vO;
import com.boehmod.blockfront.C1174vT;
import com.boehmod.blockfront.C1175vU;
import com.boehmod.blockfront.C1312xz;
import com.boehmod.blockfront.EnumC0862pa;
import com.boehmod.blockfront.common.player.AbstractC0183b;
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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/common/player/a.class */
public abstract class AbstractC0182a<P extends AbstractC0183b<?, ?, ?, ?>> {

    /* JADX INFO: renamed from: uZ */
    private static final int f1391uZ = 60;

    /* JADX INFO: renamed from: fo */
    protected boolean f1392fo = false;

    /* JADX INFO: renamed from: va */
    private int f1393va = 60;

    /* JADX INFO: renamed from: u */
    @NotNull
    private ItemStack f1394u = ItemStack.EMPTY;

    /* JADX INFO: renamed from: vb */
    private int f1395vb = -1;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final P f1396b;

    public AbstractC0182a(@NotNull P p) {
        this.f1396b = p;
    }

    /* JADX INFO: renamed from: a */
    public void m1084a(@NotNull ServerPlayer serverPlayer, @NotNull LivingEntity livingEntity, @NotNull ItemStack itemStack) {
        if (this.f1392fo) {
            return;
        }
        m1088X(true);
        this.f1393va = 60;
        this.f1394u = itemStack.copy();
        this.f1395vb = livingEntity.getId();
        int id = serverPlayer.getId();
        C1169vO.m6644b(new C1174vT(C1312xz.f8616BN, SoundSource.PLAYERS, id, 1.0f, 1.5f));
        C1169vO.m6644b(new C1174vT(C1312xz.f8615BM, SoundSource.PLAYERS, id, 1.0f, 1.5f));
        C1169vO.m6644b(new C1174vT(C1312xz.f8879GQ, SoundSource.PLAYERS, id, 1.0f, 1.0f));
    }

    /* JADX INFO: renamed from: dG */
    private void m1085dG() {
        m1088X(false);
        this.f1393va = 60;
        this.f1394u = ItemStack.EMPTY;
        this.f1395vb = -1;
    }

    /* JADX INFO: renamed from: a */
    public void m1086a(@NotNull Level level, @NotNull ServerPlayer serverPlayer) {
        if (C0875pn.m4488a((Player) serverPlayer, (AbstractC0183b<?, ?, ?, ?>) this.f1396b)) {
            m1085dG();
            return;
        }
        if (this.f1392fo) {
            serverPlayer.swing(level.random.nextFloat() < 0.5f ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
        }
        if (this.f1392fo) {
            int i = this.f1393va;
            this.f1393va = i - 1;
            if (i > 0) {
                return;
            }
            m1087b(level, serverPlayer);
            m1085dG();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1087b(@NotNull Level level, @NotNull ServerPlayer serverPlayer) {
        Entity entity = this.f1395vb == -1 ? null : level.getEntity(this.f1395vb);
        Vec3 vec3Position = serverPlayer.position();
        Explosion explosionM4490a = C0875pn.m4490a(level, entity, vec3Position, this.f1394u, 5.5f);
        serverPlayer.getInventory().clearContent();
        explosionM4490a.explode();
        explosionM4490a.finalizeExplosion(true);
        explosionM4490a.clearToBlow();
        C1169vO.m6644b(new C1175vU(EnumC0862pa.GENERIC, vec3Position));
    }

    /* JADX INFO: renamed from: X */
    public void m1088X(boolean z) {
        if (this.f1392fo != z) {
            this.f1392fo = z;
            this.f1396b.m1101dH();
        }
    }

    /* JADX INFO: renamed from: aV */
    public boolean m1089aV() {
        return this.f1392fo;
    }

    /* JADX INFO: renamed from: b */
    public void m1090b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f1392fo);
    }

    /* JADX INFO: renamed from: e */
    public void m1091e(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f1392fo = friendlyByteBuf.readBoolean();
    }
}
