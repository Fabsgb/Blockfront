package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rE.class */
public final class rE extends oI<rB> {
    private static final Component jd;
    static final /* synthetic */ boolean gQ;

    static {
        gQ = !rE.class.desiredAssertionStatus();
        jd = Component.translatable("bf.popup.message.cpoint.defended").withStyle(ChatFormatting.GOLD);
    }

    public rE(@NotNull rB rBVar, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        super(rBVar, cVar);
        Style styleWithColor = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES));
        Style styleWithColor2 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT));
        Style styleWithColor3 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS));
        Style styleWithColor4 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS_CHAT));
        b(new oO(rBVar, C0529tp.cZ, styleWithColor, styleWithColor2, 8));
        b(new oO(rBVar, C0529tp.da, styleWithColor3, styleWithColor4, 8));
    }

    @Override // com.boehmod.blockfront.oI
    @Nullable
    public C0409pd a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable oP oPVar) {
        oO oOVarA = a(C0529tp.da);
        oO oOVarA2 = a(C0529tp.cZ);
        if (!gQ && oOVarA == null) {
            throw new AssertionError();
        }
        if (!gQ && oOVarA2 == null) {
            throw new AssertionError();
        }
        int iA = oOVarA.a(C0529tp.l);
        if (iA >= 500) {
            return new C0409pd(oOVarA, null);
        }
        int iA2 = oOVarA2.a(C0529tp.l);
        if (iA2 >= 500) {
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
    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @CheckForNull @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        oO oOVarA;
        if (serverPlayer2 != null && uuid2 != null && (oOVarA = a(uuid2)) != null && ((rB) this.g).a() == oN.GAME && !serverPlayer2.equals(serverPlayer)) {
            oR.a(abstractC0264ju, (oF<?, ?, ?>) this.g, uuid2, C0529tp.l);
            for (rC rCVar : ((rB) this.g).O()) {
                if (rCVar.a((Entity) serverPlayer, ((rB) this.g).a(rCVar)) && oOVarA.equals(rCVar.d())) {
                    oR.a(serverPlayer2, new sQ(jd, 40));
                    oR.a(abstractC0264ju, (oF<?, ?, ?>) this.g, uuid2, C0529tp.l, 2);
                }
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
        if (oOVarA.m789a((oF<?, ?, ?>) this.g) != null) {
            oR.a(cVar, serverPlayer, oOVarA.m789a((oF<?, ?, ?>) this.g));
        }
        oR.f(serverPlayer);
        oR.a(serverLevel, serverPlayer, (oF<?, ?, ?>) this.g, oOVarA);
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        if (entity instanceof Player) {
            UUID uuid2 = ((Player) entity).getUUID();
            if (uuid.equals(uuid2)) {
                return damageSource.is(DamageTypeTags.IS_EXPLOSION) || damageSource.is(DamageTypeTags.IS_FIRE);
            }
            oO oOVarA = a(uuid);
            return oOVarA == null || !oOVarA.h().contains(uuid2);
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
