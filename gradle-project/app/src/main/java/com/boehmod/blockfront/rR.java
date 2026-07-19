package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rR.class */
public final class rR extends oI<rO> {
    private static final Component jn = Component.translatable("bf.message.gamemode.gungame.degrade").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD);
    private static final Component jo = Component.translatable("bf.message.gamemode.gungame.upgrade").withStyle(ChatFormatting.GREEN).withStyle(ChatFormatting.BOLD);
    private static final Component jp = Component.translatable("bf.message.gamemode.gungame.knife").withStyle(ChatFormatting.YELLOW).withStyle(ChatFormatting.BOLD);

    @Nullable
    public UUID z;

    public rR(@NotNull rO rOVar, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        super(rOVar, cVar);
        this.z = null;
        Style styleWithColor = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES));
        Style styleWithColor2 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT));
        Style styleWithColor3 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS));
        Style styleWithColor4 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS_CHAT));
        b(new oO(rOVar, C0529tp.cZ, styleWithColor, styleWithColor2, 8));
        b(new oO(rOVar, C0529tp.da, styleWithColor3, styleWithColor4, 8));
    }

    @Override // com.boehmod.blockfront.oI
    @Nullable
    public C0409pd a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable oP oPVar) {
        if (this.z != null) {
            return new C0409pd(null, Collections.singleton(this.z));
        }
        if (oPVar != null && !oPVar.P()) {
            return null;
        }
        ObjectSortedSet<UUID> objectSortedSetA = oR.a((oF<?, ?, ?>) this.g, 5, C0529tp.l, set);
        if (objectSortedSetA.isEmpty()) {
            return new C0409pd(null, null);
        }
        return new C0409pd(null, Collections.singleton((UUID) objectSortedSetA.getFirst()));
    }

    @Override // com.boehmod.blockfront.oI
    /* JADX INFO: renamed from: a */
    protected boolean mo784a(@NotNull ServerPlayer serverPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.oI
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull oO oOVar) {
        oR.a(cVar, serverPlayer, oOVar.m789a((oF<?, ?, ?>) this.g));
        g(serverPlayer);
    }

    @Override // com.boehmod.blockfront.oI
    public void d(@NotNull ServerPlayer serverPlayer) {
    }

    @Override // com.boehmod.blockfront.oI
    public void b(@NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar) {
    }

    @Override // com.boehmod.blockfront.oI
    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @CheckForNull @Nullable ServerPlayer serverPlayer2, @CheckForNull @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        if (serverPlayer2 != null && uuid2 != null && a(uuid2) != null && ((rO) this.g).a() == oN.GAME && !serverPlayer2.equals(serverPlayer)) {
            oR.a(abstractC0264ju, (oF<?, ?, ?>) this.g, uuid2, C0529tp.C);
            oR.a(serverPlayer2, new sQ(jo, 60));
            serverPlayer2.playSound(SoundEvents.PLAYER_LEVELUP, 2.5f, 1.0f);
            serverPlayer2.playSound(SoundEvents.PLAYER_LEVELUP, 2.5f, 1.0f);
            g(serverPlayer2);
        }
        if (((rO) this.g).a() == oN.GAME) {
            boolean z = false;
            Entity entity = damageSource.getEntity();
            if (serverPlayer2 != null && !serverPlayer2.getMainHandItem().isEmpty() && (serverPlayer2.getMainHandItem().getItem() instanceof tI)) {
                z = true;
            }
            if (entity == null || entity.equals(serverPlayer) || z) {
                int iA = oR.a((oF<?, ?, ?>) this.g, uuid, C0529tp.C) - 1;
                if (iA < 0) {
                    iA = 0;
                }
                oR.m792a((oF<?, ?, ?>) this.g, uuid, C0529tp.C, iA);
                oR.a(serverPlayer, new sQ(jn, 60));
                serverPlayer.playSound(SoundEvents.WITHER_DEATH, 2.5f, 1.0f);
            }
        }
    }

    @Override // com.boehmod.blockfront.oI
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        oR.a(cVar, serverLevel, serverPlayer);
        oO oOVarA = a(uuid);
        if (oOVarA == null) {
            return;
        }
        oR.a(cVar, serverPlayer, oOVarA.m789a((oF<?, ?, ?>) this.g));
        oR.f(serverPlayer);
        g(serverPlayer);
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        if (entity instanceof Player) {
            Player player2 = (Player) entity;
            UUID uuid2 = player2.getUUID();
            if (player.getScoreboardName().equalsIgnoreCase(player2.getScoreboardName())) {
                return damageSource.is(DamageTypeTags.IS_EXPLOSION) || damageSource.is(DamageTypeTags.IS_FIRE);
            }
            oO oOVarA = a(uuid);
            oO oOVarA2 = a(uuid2);
            return oOVarA == null || oOVarA2 == null || !oOVarA.getName().equalsIgnoreCase(oOVarA2.getName());
        }
        return true;
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource) {
        return true;
    }

    public void g(@NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        int iA = oR.a((oF<?, ?, ?>) this.g, uuid, C0529tp.C);
        if (iA > ((rO) this.g).bm.size()) {
            if (this.z == null) {
                this.z = uuid;
                return;
            }
            return;
        }
        serverPlayer.getInventory().clearContent();
        if (iA < ((rO) this.g).bm.size()) {
            C0558ur c0558urA = ((rO) this.g).a(iA);
            if (c0558urA != null) {
                serverPlayer.getInventory().setItem(0, new ItemStack(c0558urA));
            }
        } else {
            oR.a(serverPlayer, new sQ(jp, 80));
        }
        serverPlayer.getInventory().setItem(2, new ItemStack((ItemLike) wY.as.get()));
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

    @Override // com.boehmod.blockfront.oI
    public void bf() {
        super.bf();
        this.z = null;
    }
}
