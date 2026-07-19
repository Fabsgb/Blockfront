package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rz.class */
public final class C0485rz extends oI<C0483rx> {

    @NotNull
    static final String cv = "Recruits";
    private static final int pI = 16;

    public C0485rz(@NotNull C0483rx c0483rx, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        super(c0483rx, cVar);
        b(new oO(c0483rx, cv, Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES)), Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT)), 16));
    }

    @Override // com.boehmod.blockfront.oI
    @Nullable
    public C0409pd a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable oP oPVar) {
        return null;
    }

    @Override // com.boehmod.blockfront.oI
    /* JADX INFO: renamed from: a */
    protected boolean mo784a(@NotNull ServerPlayer serverPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.oI
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull oO oOVar) {
        oX oXVarC = c();
        if (oXVarC != null) {
            oR.a(cVar, serverPlayer, oXVarC);
        }
    }

    @Override // com.boehmod.blockfront.oI
    public void d(@NotNull ServerPlayer serverPlayer) {
    }

    @Override // com.boehmod.blockfront.oI
    public void b(@NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar) {
    }

    @Override // com.boehmod.blockfront.oI
    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @CheckForNull @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.oI
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        oR.a(cVar, serverLevel, serverPlayer);
        oR.a(cVar, serverPlayer, c());
        oR.i(serverPlayer.getUUID());
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        return false;
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource) {
        if (livingEntity instanceof mC) {
            ServerPlayer entity = damageSource.getEntity();
            if (!(entity instanceof ServerPlayer)) {
                return false;
            }
            ServerPlayer serverPlayer = entity;
            if (Math.random() < 0.1d && !serverPlayer.getMainHandItem().isEmpty() && (serverPlayer.getMainHandItem().getItem() instanceof C0558ur)) {
                oR.a(serverPlayer, (SoundEvent) C0624xc.qP.get(), SoundSource.NEUTRAL);
                return false;
            }
            return false;
        }
        return true;
    }

    @Override // com.boehmod.blockfront.oI
    @Nullable
    public List<ItemEntity> a(@NotNull Player player, @NotNull List<ItemEntity> list) {
        return null;
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull Player player, @NotNull ItemStack itemStack) {
        return false;
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull Player player, @NotNull ItemEntity itemEntity, @NotNull ItemStack itemStack) {
        UUID uuid = player.getUUID();
        Inventory inventory = player.getInventory();
        Item item = itemStack.getItem();
        if (item instanceof C0558ur) {
            if (((C0558ur) item).cv()) {
                if (((ItemStack) inventory.items.getFirst()).isEmpty()) {
                    oR.m792a((oF<?, ?, ?>) this.g, uuid, C0529tp.m, 1);
                    return true;
                }
                return false;
            }
            if (((ItemStack) inventory.items.get(1)).isEmpty()) {
                oR.m792a((oF<?, ?, ?>) this.g, uuid, C0529tp.m, 1);
                return true;
            }
            return false;
        }
        if (itemStack.getItem() instanceof tW) {
            if (((ItemStack) inventory.items.get(3)).isEmpty() || ((ItemStack) inventory.items.get(4)).isEmpty() || ((ItemStack) inventory.items.get(5)).isEmpty()) {
                oR.m792a((oF<?, ?, ?>) this.g, uuid, C0529tp.m, 1);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull Player player, @NotNull Block block) {
        return false;
    }

    @Override // com.boehmod.blockfront.oI
    public boolean b(@NotNull Player player, @NotNull Block block) {
        return false;
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull Player player, @NotNull Block block, @NotNull BlockPos blockPos) {
        return true;
    }

    @Override // com.boehmod.blockfront.oI
    public boolean bn() {
        return true;
    }
}
