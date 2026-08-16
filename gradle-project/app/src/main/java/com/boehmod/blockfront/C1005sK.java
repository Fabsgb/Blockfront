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
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sK.class */
public final class C1005sK extends AbstractC0866pe<C1001sG> {
    public C1005sK(@NotNull C1001sG c1001sG, @NotNull AbstractC0184c<?> abstractC0184c) {
        super(c1001sG, abstractC0184c);
        Style styleWithColor = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES));
        Style styleWithColor2 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT));
        Style styleWithColor3 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS));
        Style styleWithColor4 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS_CHAT));
        m4228b(new C0872pk(c1001sG, C1062tN.f5782dk, styleWithColor, styleWithColor2, 8));
        m4228b(new C0872pk(c1001sG, C1062tN.f5783dl, styleWithColor3, styleWithColor4, 8));
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0887pz mo4260a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0873pl c0873pl) {
        return ((C1001sG) this.f4730g).m5636a();
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    protected boolean mo4261b(@NotNull ServerPlayer serverPlayer) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public void mo4262a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C0872pk c0872pk) {
        C0875pn.m4402a(abstractC0184c, serverPlayer, c0872pk.m4299a((AbstractC0863pb<?, ?, ?>) this.f4730g));
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: d */
    public void mo4263d(@NotNull ServerPlayer serverPlayer) {
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    public void mo4264b(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b) {
        ((C1001sG) this.f4730g).m5630h(serverPlayer);
        if (abstractC0183b.m1104dt()) {
            if (serverPlayer.isSpectator()) {
                abstractC0183b.m1105Y(false);
            } else if (abstractC0183b.m1112cI() > 1) {
                abstractC0183b.m1114K(1);
            } else {
                C0875pn.m4384a(m4207a(), serverPlayer.serverLevel(), serverPlayer);
                serverPlayer.setGameMode(GameType.SPECTATOR);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    public void mo4266b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @CheckForNull @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        if (serverPlayer2 != null && uuid2 != null && m4229a(uuid2) != null && ((C1001sG) this.f4730g).mo3996a() == EnumC0871pj.GAME && !serverPlayer2.equals(serverPlayer)) {
            C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4730g, uuid2, C1062tN.f5748l);
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
        C0881pt c0881ptM4299a = c0872pkA.m4299a((AbstractC0863pb<?, ?, ?>) this.f4730g);
        if (c0881ptM4299a != null) {
            C0875pn.m4402a(abstractC0184c, serverPlayer, c0881ptM4299a);
        }
        C0875pn.m4462f(serverPlayer);
        C0875pn.m4474a(serverLevel, serverPlayer, (AbstractC0863pb<?, ?, ?>) this.f4730g, c0872pkA);
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4268a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        if (entity instanceof Player) {
            UUID uuid2 = ((Player) entity).getUUID();
            if (uuid.equals(uuid2)) {
                return damageSource.is(DamageTypeTags.IS_EXPLOSION) || damageSource.is(DamageTypeTags.IS_FIRE);
            }
            C0872pk c0872pkA = m4229a(uuid);
            return c0872pkA == null || !c0872pkA.m4308h().contains(uuid2);
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4269a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource) {
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
