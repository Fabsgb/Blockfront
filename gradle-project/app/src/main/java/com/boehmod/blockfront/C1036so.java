package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.so */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/so.class */
public final class C1036so extends AbstractC0866pe<C1033sl> {

    /* JADX INFO: renamed from: jA */
    private static final Component f5645jA = Component.translatable("bf.message.gamemode.gungame.degrade").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: jB */
    private static final Component f5646jB = Component.translatable("bf.message.gamemode.gungame.upgrade").withStyle(ChatFormatting.GREEN).withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: jC */
    private static final Component f5647jC = Component.translatable("bf.message.gamemode.gungame.knife").withStyle(ChatFormatting.YELLOW).withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: z */
    @Nullable
    public UUID f5648z;

    public C1036so(@NotNull C1033sl c1033sl, @NotNull AbstractC0184c<?> abstractC0184c) {
        super(c1033sl, abstractC0184c);
        this.f5648z = null;
        Style styleWithColor = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES));
        Style styleWithColor2 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT));
        Style styleWithColor3 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS));
        Style styleWithColor4 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS_CHAT));
        m4228b(new C0872pk(c1033sl, C1062tN.f5782dk, styleWithColor, styleWithColor2, 8));
        m4228b(new C0872pk(c1033sl, C1062tN.f5783dl, styleWithColor3, styleWithColor4, 8));
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0887pz mo4260a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0873pl c0873pl) {
        if (this.f5648z != null) {
            return new C0887pz(null, Collections.singleton(this.f5648z));
        }
        if (c0873pl != null && !c0873pl.m4333R()) {
            return null;
        }
        ObjectSortedSet<UUID> objectSortedSetM4388a = C0875pn.m4388a((AbstractC0863pb<?, ?, ?>) this.f4730g, 5, C1062tN.f5748l, set);
        if (objectSortedSetM4388a.isEmpty()) {
            return new C0887pz(null, null);
        }
        return new C0887pz(null, Collections.singleton((UUID) objectSortedSetM4388a.getFirst()));
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    protected boolean mo4261b(@NotNull ServerPlayer serverPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public void mo4262a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C0872pk c0872pk) {
        C0875pn.m4402a(abstractC0184c, serverPlayer, c0872pk.m4299a((AbstractC0863pb<?, ?, ?>) this.f4730g));
        m5779g(serverPlayer);
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
    public void mo4266b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @CheckForNull @Nullable ServerPlayer serverPlayer2, @CheckForNull @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        if (serverPlayer2 != null && uuid2 != null && m4229a(uuid2) != null && ((C1033sl) this.f4730g).mo3996a() == EnumC0871pj.GAME && !serverPlayer2.equals(serverPlayer)) {
            C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4730g, uuid2, C1062tN.f5765C);
            C0875pn.m4379a(serverPlayer2, new C1088tn(f5646jB, 60));
            serverPlayer2.playSound(SoundEvents.PLAYER_LEVELUP, 2.5f, 1.0f);
            serverPlayer2.playSound(SoundEvents.PLAYER_LEVELUP, 2.5f, 1.0f);
            m5779g(serverPlayer2);
        }
        if (((C1033sl) this.f4730g).mo3996a() == EnumC0871pj.GAME) {
            boolean z = false;
            Entity entity = damageSource.getEntity();
            if (serverPlayer2 != null && !serverPlayer2.getMainHandItem().isEmpty() && (serverPlayer2.getMainHandItem().getItem() instanceof C1134ug)) {
                z = true;
            }
            if (entity == null || entity.equals(serverPlayer) || z) {
                int iM4445a = C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5765C) - 1;
                if (iM4445a < 0) {
                    iM4445a = 0;
                }
                C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5765C, iM4445a);
                C0875pn.m4379a(serverPlayer, new C1088tn(f5645jA, 60));
                serverPlayer.playSound(SoundEvents.WITHER_DEATH, 2.5f, 1.0f);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public void mo4267a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        C0875pn.m4384a(abstractC0184c, serverLevel, serverPlayer);
        C0872pk c0872pkA = m4229a(uuid);
        if (c0872pkA == null) {
            return;
        }
        C0875pn.m4402a(abstractC0184c, serverPlayer, c0872pkA.m4299a((AbstractC0863pb<?, ?, ?>) this.f4730g));
        C0875pn.m4462f(serverPlayer);
        m5779g(serverPlayer);
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4268a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        if (entity instanceof Player) {
            Player player2 = (Player) entity;
            UUID uuid2 = player2.getUUID();
            if (player.getScoreboardName().equalsIgnoreCase(player2.getScoreboardName())) {
                return damageSource.is(DamageTypeTags.IS_EXPLOSION) || damageSource.is(DamageTypeTags.IS_FIRE);
            }
            C0872pk c0872pkA = m4229a(uuid);
            C0872pk c0872pkA2 = m4229a(uuid2);
            return c0872pkA == null || c0872pkA2 == null || !c0872pkA.getName().equalsIgnoreCase(c0872pkA2.getName());
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4269a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource) {
        return true;
    }

    /* JADX INFO: renamed from: g */
    public void m5779g(@NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        int iM4445a = C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5765C);
        if (iM4445a > ((C1033sl) this.f4730g).f5629bt.size()) {
            if (this.f5648z == null) {
                this.f5648z = uuid;
                return;
            }
            return;
        }
        serverPlayer.getInventory().clearContent();
        if (iM4445a < ((C1033sl) this.f4730g).f5629bt.size()) {
            C1117uP c1117uPM5765a = ((C1033sl) this.f4730g).m5765a(iM4445a);
            if (c1117uPM5765a != null) {
                serverPlayer.getInventory().setItem(0, new ItemStack(c1117uPM5765a));
            }
        } else {
            C0875pn.m4379a(serverPlayer, new C1088tn(f5647jC, 80));
        }
        serverPlayer.getInventory().setItem(2, new ItemStack((ItemLike) C1308xv.f7739as.get()));
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

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: bd */
    public void mo4254bd() {
        super.mo4254bd();
        this.f5648z = null;
    }
}
