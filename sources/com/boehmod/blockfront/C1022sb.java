package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sb.class */
public final class C1022sb extends AbstractC0866pe<C0966rY> {

    /* JADX INFO: renamed from: jq */
    private static final Component f5607jq;

    /* JADX INFO: renamed from: hk */
    static final /* synthetic */ boolean f5608hk;

    static {
        f5608hk = !C1022sb.class.desiredAssertionStatus();
        f5607jq = Component.translatable("bf.popup.message.cpoint.defended").withStyle(ChatFormatting.GOLD);
    }

    public C1022sb(@NotNull C0966rY c0966rY, @NotNull AbstractC0184c<?> abstractC0184c) {
        super(c0966rY, abstractC0184c);
        Style styleWithColor = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES));
        Style styleWithColor2 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT));
        Style styleWithColor3 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS));
        Style styleWithColor4 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS_CHAT));
        m4228b(new C0872pk(c0966rY, C1062tN.f5782dk, styleWithColor, styleWithColor2, 8));
        m4228b(new C0872pk(c0966rY, C1062tN.f5783dl, styleWithColor3, styleWithColor4, 8));
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0887pz mo4260a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0873pl c0873pl) {
        C0872pk c0872pkA = m4242a(C1062tN.f5783dl);
        C0872pk c0872pkA2 = m4242a(C1062tN.f5782dk);
        if (!f5608hk && c0872pkA == null) {
            throw new AssertionError();
        }
        if (!f5608hk && c0872pkA2 == null) {
            throw new AssertionError();
        }
        int iM4302a = c0872pkA.m4302a(C1062tN.f5748l);
        if (iM4302a >= 500) {
            return new C0887pz(c0872pkA, null);
        }
        int iM4302a2 = c0872pkA2.m4302a(C1062tN.f5748l);
        if (iM4302a2 >= 500) {
            return new C0887pz(c0872pkA2, null);
        }
        if (c0873pl == null || c0873pl.m4333R()) {
            return iM4302a > iM4302a2 ? new C0887pz(c0872pkA, null) : new C0887pz(c0872pkA2, null);
        }
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
        C0875pn.m4402a(abstractC0184c, serverPlayer, c0872pk.m4299a((AbstractC0863pb<?, ?, ?>) this.f4730g));
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
        C0872pk c0872pkA;
        if (serverPlayer2 != null && uuid2 != null && (c0872pkA = m4229a(uuid2)) != null && ((C0966rY) this.f4730g).mo3996a() == EnumC0871pj.GAME && !serverPlayer2.equals(serverPlayer)) {
            C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4730g, uuid2, C1062tN.f5748l);
            for (C0967rZ c0967rZ : ((C0966rY) this.f4730g).mo5353Q()) {
                if (c0967rZ.m4535a((Entity) serverPlayer, ((C0966rY) this.f4730g).mo5358a(c0967rZ)) && c0872pkA.equals(c0967rZ.m4533d())) {
                    C0875pn.m4379a(serverPlayer2, new C1088tn(f5607jq, 40));
                    C0875pn.m4451a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4730g, uuid2, C1062tN.f5748l, 2);
                }
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
        if (c0872pkA.m4299a((AbstractC0863pb<?, ?, ?>) this.f4730g) != null) {
            C0875pn.m4402a(abstractC0184c, serverPlayer, c0872pkA.m4299a((AbstractC0863pb<?, ?, ?>) this.f4730g));
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
