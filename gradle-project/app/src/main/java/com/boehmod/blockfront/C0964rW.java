package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.rW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rW.class */
public final class C0964rW extends AbstractC0866pe<C0962rU> {

    /* JADX INFO: renamed from: cF */
    @NotNull
    static final String f5358cF = "Recruits";

    /* JADX INFO: renamed from: rH */
    private static final int f5359rH = 16;

    public C0964rW(@NotNull C0962rU c0962rU, @NotNull AbstractC0184c<?> abstractC0184c) {
        super(c0962rU, abstractC0184c);
        m4228b(new C0872pk(c0962rU, f5358cF, Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES)), Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT)), 16));
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0887pz mo4260a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0873pl c0873pl) {
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    protected boolean mo4261b(@NotNull ServerPlayer serverPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public void mo4262a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C0872pk c0872pk) {
        C0881pt c0881ptC = m4226c();
        if (c0881ptC != null) {
            C0875pn.m4402a(abstractC0184c, serverPlayer, c0881ptC);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: d */
    public void mo4263d(@NotNull ServerPlayer serverPlayer) {
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    public void mo4264b(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b) {
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    public void mo4266b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @CheckForNull @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public void mo4267a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        C0875pn.m4384a(abstractC0184c, serverLevel, serverPlayer);
        C0875pn.m4402a(abstractC0184c, serverPlayer, m4226c());
        C0875pn.m4360i(serverPlayer.getUUID());
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4268a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4269a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource) {
        if (livingEntity instanceof C0701mY) {
            ServerPlayer entity = damageSource.getEntity();
            if (!(entity instanceof ServerPlayer)) {
                return false;
            }
            ServerPlayer serverPlayer = entity;
            if (Math.random() < 0.1d && !serverPlayer.getMainHandItem().isEmpty() && (serverPlayer.getMainHandItem().getItem() instanceof C1117uP)) {
                C0875pn.m4364a(serverPlayer, (SoundEvent) C1312xz.f8048qR.get(), SoundSource.NEUTRAL);
                return false;
            }
            return false;
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    @Nullable
    /* JADX INFO: renamed from: a */
    public List<ItemEntity> mo4222a(@NotNull Player player, @NotNull List<ItemEntity> list) {
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4223a(@NotNull Player player, @NotNull ItemStack itemStack) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4224a(@NotNull Player player, @NotNull ItemEntity itemEntity, @NotNull ItemStack itemStack) {
        UUID uuid = player.getUUID();
        Inventory inventory = player.getInventory();
        Item item = itemStack.getItem();
        if (item instanceof C1117uP) {
            if (((C1117uP) item).m6364cE()) {
                if (((ItemStack) inventory.items.getFirst()).isEmpty()) {
                    C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5749m, 1);
                    return true;
                }
                return false;
            }
            if (((ItemStack) inventory.items.get(1)).isEmpty()) {
                C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5749m, 1);
                return true;
            }
            return false;
        }
        if (itemStack.getItem() instanceof InterfaceC1148uu) {
            if (((ItemStack) inventory.items.get(3)).isEmpty() || ((ItemStack) inventory.items.get(4)).isEmpty() || ((ItemStack) inventory.items.get(5)).isEmpty()) {
                C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5749m, 1);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4257a(@NotNull Player player, @NotNull Block block) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    public boolean mo4258b(@NotNull Player player, @NotNull Block block) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4259a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull Player player, @NotNull Block block, @NotNull BlockPos blockPos) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: bx */
    public boolean mo4270bx() {
        return true;
    }
}
