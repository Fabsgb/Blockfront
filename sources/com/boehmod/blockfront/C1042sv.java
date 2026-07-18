package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sv.class */
public final class C1042sv extends AbstractC0790oI<C1040st> {

    /* JADX INFO: renamed from: hf */
    static final /* synthetic */ boolean f5532hf;

    static {
        f5532hf = !C1042sv.class.desiredAssertionStatus();
    }

    public C1042sv(@NotNull C1040st c1040st, @NotNull AbstractC0183c<?> abstractC0183c) {
        super(c1040st, abstractC0183c);
        Style styleWithColor = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES));
        Style styleWithColor2 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT));
        Style styleWithColor3 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS));
        Style styleWithColor4 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS_CHAT));
        m3792b(new C0796oO(c1040st, C1089tp.f5729cZ, styleWithColor, styleWithColor2, 8));
        m3792b(new C0796oO(c1040st, C1089tp.f5730da, styleWithColor3, styleWithColor4, 8));
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0864pd mo3824a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0797oP c0797oP) {
        C0796oO c0796oOA = m3806a(C1089tp.f5730da);
        C0796oO c0796oOA2 = m3806a(C1089tp.f5729cZ);
        if (!f5532hf && c0796oOA == null) {
            throw new AssertionError();
        }
        if (!f5532hf && c0796oOA2 == null) {
            throw new AssertionError();
        }
        int iM3866a = c0796oOA.m3866a(C1089tp.f5695l);
        if (iM3866a >= 50) {
            return new C0864pd(c0796oOA, null);
        }
        int iM3866a2 = c0796oOA2.m3866a(C1089tp.f5695l);
        if (iM3866a2 >= 50) {
            return new C0864pd(c0796oOA2, null);
        }
        if (c0797oP == null || c0797oP.m3897P()) {
            return iM3866a > iM3866a2 ? new C0864pd(c0796oOA, null) : new C0864pd(c0796oOA2, null);
        }
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    protected boolean mo3825a(@NotNull ServerPlayer serverPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public void mo3826a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C0796oO c0796oO) {
        C0799oR.m3966a(abstractC0183c, serverPlayer, c0796oO.m3863a((AbstractC0787oF<?, ?, ?>) this.f4335g));
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: d */
    public void mo3827d(@NotNull ServerPlayer serverPlayer) {
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: b */
    public void mo3828b(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b) {
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: b */
    public void mo3830b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @CheckForNull @Nullable ServerPlayer serverPlayer2, @CheckForNull @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        if (serverPlayer2 == null || uuid2 == null) {
            return;
        }
        for (ItemStack itemStack : serverPlayer2.getInventory().items) {
            if (!itemStack.isEmpty()) {
                C0799oR.m4032b(itemStack);
            }
        }
        if (((C1040st) this.f4335g).mo3560a() != EnumC0795oN.GAME || serverPlayer.equals(serverPlayer2)) {
            return;
        }
        C0796oO c0796oOA = m3793a(uuid2);
        if (c0796oOA != null) {
            c0796oOA.m3864a(C1089tp.f5695l, c0796oOA.m3866a(C1089tp.f5695l) + 1);
        }
        C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4335g, uuid2, C1089tp.f5695l);
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public void mo3831a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        C0799oR.m3948a(abstractC0183c, serverLevel, serverPlayer);
        C0796oO c0796oOA = m3793a(uuid);
        if (c0796oOA == null) {
            return;
        }
        C0799oR.m3966a(abstractC0183c, serverPlayer, c0796oOA.m3863a((AbstractC0787oF<?, ?, ?>) this.f4335g));
        C0799oR.m4026f(serverPlayer);
        C0799oR.m4038a(serverLevel, serverPlayer, (AbstractC0787oF<?, ?, ?>) this.f4335g, c0796oOA);
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3832a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        if (entity instanceof Player) {
            Player player2 = (Player) entity;
            UUID uuid2 = player2.getUUID();
            if (player.getScoreboardName().equalsIgnoreCase(player2.getScoreboardName())) {
                return damageSource.is(DamageTypeTags.IS_EXPLOSION) || damageSource.is(DamageTypeTags.IS_FIRE);
            }
            C0796oO c0796oOA = m3793a(uuid);
            C0796oO c0796oOA2 = m3793a(uuid2);
            return c0796oOA == null || c0796oOA2 == null || !c0796oOA.getName().equalsIgnoreCase(c0796oOA2.getName());
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3833a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    @Nullable
    /* JADX INFO: renamed from: a */
    public List<ItemEntity> mo3786a(@NotNull Player player, @NotNull List<ItemEntity> list) {
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3787a(@NotNull Player player, @NotNull ItemStack itemStack) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3788a(@NotNull Player player, @NotNull ItemEntity itemEntity, @NotNull ItemStack itemStack) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3821a(@NotNull Player player, @NotNull Block block) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: b */
    public boolean mo3822b(@NotNull Player player, @NotNull Block block) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3823a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull Player player, @NotNull Block block, @NotNull BlockPos blockPos) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: bn */
    public boolean mo3834bn() {
        return true;
    }
}
