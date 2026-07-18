package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.rE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rE.class */
public final class C0945rE extends AbstractC0790oI<C0942rB> {

    /* JADX INFO: renamed from: jd */
    private static final Component f5031jd;

    /* JADX INFO: renamed from: gQ */
    static final /* synthetic */ boolean f5032gQ;

    static {
        f5032gQ = !C0945rE.class.desiredAssertionStatus();
        f5031jd = Component.translatable("bf.popup.message.cpoint.defended").withStyle(ChatFormatting.GOLD);
    }

    public C0945rE(@NotNull C0942rB c0942rB, @NotNull AbstractC0183c<?> abstractC0183c) {
        super(c0942rB, abstractC0183c);
        Style styleWithColor = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES));
        Style styleWithColor2 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT));
        Style styleWithColor3 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS));
        Style styleWithColor4 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS_CHAT));
        m3792b(new C0796oO(c0942rB, C1089tp.f5729cZ, styleWithColor, styleWithColor2, 8));
        m3792b(new C0796oO(c0942rB, C1089tp.f5730da, styleWithColor3, styleWithColor4, 8));
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0864pd mo3824a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0797oP c0797oP) {
        C0796oO c0796oOA = m3806a(C1089tp.f5730da);
        C0796oO c0796oOA2 = m3806a(C1089tp.f5729cZ);
        if (!f5032gQ && c0796oOA == null) {
            throw new AssertionError();
        }
        if (!f5032gQ && c0796oOA2 == null) {
            throw new AssertionError();
        }
        int iM3866a = c0796oOA.m3866a(C1089tp.f5695l);
        if (iM3866a >= 500) {
            return new C0864pd(c0796oOA, null);
        }
        int iM3866a2 = c0796oOA2.m3866a(C1089tp.f5695l);
        if (iM3866a2 >= 500) {
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
    public void mo3830b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @CheckForNull @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        C0796oO c0796oOA;
        if (serverPlayer2 != null && uuid2 != null && (c0796oOA = m3793a(uuid2)) != null && ((C0942rB) this.f4335g).mo3560a() == EnumC0795oN.GAME && !serverPlayer2.equals(serverPlayer)) {
            C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4335g, uuid2, C1089tp.f5695l);
            for (C0943rC c0943rC : ((C0942rB) this.f4335g).mo4668O()) {
                if (c0943rC.m4099a((Entity) serverPlayer, ((C0942rB) this.f4335g).mo4666a(c0943rC)) && c0796oOA.equals(c0943rC.m4097d())) {
                    C0799oR.m3943a(serverPlayer2, new C1010sQ(f5031jd, 40));
                    C0799oR.m4015a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4335g, uuid2, C1089tp.f5695l, 2);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public void mo3831a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        C0799oR.m3948a(abstractC0183c, serverLevel, serverPlayer);
        C0796oO c0796oOA = m3793a(uuid);
        if (c0796oOA == null) {
            return;
        }
        if (c0796oOA.m3863a((AbstractC0787oF<?, ?, ?>) this.f4335g) != null) {
            C0799oR.m3966a(abstractC0183c, serverPlayer, c0796oOA.m3863a((AbstractC0787oF<?, ?, ?>) this.f4335g));
        }
        C0799oR.m4026f(serverPlayer);
        C0799oR.m4038a(serverLevel, serverPlayer, (AbstractC0787oF<?, ?, ?>) this.f4335g, c0796oOA);
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3832a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        if (entity instanceof Player) {
            UUID uuid2 = ((Player) entity).getUUID();
            if (uuid.equals(uuid2)) {
                return damageSource.is(DamageTypeTags.IS_EXPLOSION) || damageSource.is(DamageTypeTags.IS_FIRE);
            }
            C0796oO c0796oOA = m3793a(uuid);
            return c0796oOA == null || !c0796oOA.m3872h().contains(uuid2);
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
