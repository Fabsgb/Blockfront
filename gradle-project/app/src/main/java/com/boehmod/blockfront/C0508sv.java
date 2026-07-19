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

/* JADX INFO: renamed from: com.boehmod.blockfront.sv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sv.class */
public final class C0508sv extends oI<C0506st> {
    static final /* synthetic */ boolean hf;

    static {
        hf = !C0508sv.class.desiredAssertionStatus();
    }

    public C0508sv(@NotNull C0506st c0506st, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        super(c0506st, cVar);
        Style styleWithColor = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES));
        Style styleWithColor2 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT));
        Style styleWithColor3 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS));
        Style styleWithColor4 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS_CHAT));
        b(new oO(c0506st, C0529tp.cZ, styleWithColor, styleWithColor2, 8));
        b(new oO(c0506st, C0529tp.da, styleWithColor3, styleWithColor4, 8));
    }

    @Override // com.boehmod.blockfront.oI
    @Nullable
    public C0409pd a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable oP oPVar) {
        oO oOVarA = a(C0529tp.da);
        oO oOVarA2 = a(C0529tp.cZ);
        if (!hf && oOVarA == null) {
            throw new AssertionError();
        }
        if (!hf && oOVarA2 == null) {
            throw new AssertionError();
        }
        int iA = oOVarA.a(C0529tp.l);
        if (iA >= 50) {
            return new C0409pd(oOVarA, null);
        }
        int iA2 = oOVarA2.a(C0529tp.l);
        if (iA2 >= 50) {
            return new C0409pd(oOVarA2, null);
        }
        if (oPVar == null || oPVar.P()) {
            return iA > iA2 ? new C0409pd(oOVarA, null) : new C0409pd(oOVarA2, null);
        }
        return null;
    }

    @Override // com.boehmod.blockfront.oI
    /* JADX INFO: renamed from: a */
    protected boolean mo784a(@NotNull ServerPlayer serverPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.oI
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull oO oOVar) {
        oR.a(cVar, serverPlayer, oOVar.m789a((oF<?, ?, ?>) this.g));
    }

    @Override // com.boehmod.blockfront.oI
    public void d(@NotNull ServerPlayer serverPlayer) {
    }

    @Override // com.boehmod.blockfront.oI
    public void b(@NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar) {
    }

    @Override // com.boehmod.blockfront.oI
    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @CheckForNull @Nullable ServerPlayer serverPlayer2, @CheckForNull @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        if (serverPlayer2 == null || uuid2 == null) {
            return;
        }
        for (ItemStack itemStack : serverPlayer2.getInventory().items) {
            if (!itemStack.isEmpty()) {
                oR.b(itemStack);
            }
        }
        if (((C0506st) this.g).a() != oN.GAME || serverPlayer.equals(serverPlayer2)) {
            return;
        }
        oO oOVarA = a(uuid2);
        if (oOVarA != null) {
            oOVarA.a(C0529tp.l, oOVarA.a(C0529tp.l) + 1);
        }
        oR.a(abstractC0264ju, (oF<?, ?, ?>) this.g, uuid2, C0529tp.l);
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
        oR.a(serverLevel, serverPlayer, (oF<?, ?, ?>) this.g, oOVarA);
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
}
