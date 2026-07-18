package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.rR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rR.class */
public final class C0958rR extends AbstractC0790oI<C0955rO> {

    /* JADX INFO: renamed from: jn */
    private static final Component f5068jn = Component.translatable("bf.message.gamemode.gungame.degrade").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: jo */
    private static final Component f5069jo = Component.translatable("bf.message.gamemode.gungame.upgrade").withStyle(ChatFormatting.GREEN).withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: jp */
    private static final Component f5070jp = Component.translatable("bf.message.gamemode.gungame.knife").withStyle(ChatFormatting.YELLOW).withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: z */
    @Nullable
    public UUID f5071z;

    public C0958rR(@NotNull C0955rO c0955rO, @NotNull AbstractC0183c<?> abstractC0183c) {
        super(c0955rO, abstractC0183c);
        this.f5071z = null;
        Style styleWithColor = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES));
        Style styleWithColor2 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT));
        Style styleWithColor3 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS));
        Style styleWithColor4 = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_AXIS_CHAT));
        m3792b(new C0796oO(c0955rO, C1089tp.f5729cZ, styleWithColor, styleWithColor2, 8));
        m3792b(new C0796oO(c0955rO, C1089tp.f5730da, styleWithColor3, styleWithColor4, 8));
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0864pd mo3824a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0797oP c0797oP) {
        if (this.f5071z != null) {
            return new C0864pd(null, Collections.singleton(this.f5071z));
        }
        if (c0797oP != null && !c0797oP.m3897P()) {
            return null;
        }
        ObjectSortedSet<UUID> objectSortedSetM3952a = C0799oR.m3952a((AbstractC0787oF<?, ?, ?>) this.f4335g, 5, C1089tp.f5695l, set);
        if (objectSortedSetM3952a.isEmpty()) {
            return new C0864pd(null, null);
        }
        return new C0864pd(null, Collections.singleton((UUID) objectSortedSetM3952a.getFirst()));
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
        m5242g(serverPlayer);
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
        if (serverPlayer2 != null && uuid2 != null && m3793a(uuid2) != null && ((C0955rO) this.f4335g).mo3560a() == EnumC0795oN.GAME && !serverPlayer2.equals(serverPlayer)) {
            C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4335g, uuid2, C1089tp.f5712C);
            C0799oR.m3943a(serverPlayer2, new C1010sQ(f5069jo, 60));
            serverPlayer2.playSound(SoundEvents.PLAYER_LEVELUP, 2.5f, 1.0f);
            serverPlayer2.playSound(SoundEvents.PLAYER_LEVELUP, 2.5f, 1.0f);
            m5242g(serverPlayer2);
        }
        if (((C0955rO) this.f4335g).mo3560a() == EnumC0795oN.GAME) {
            boolean z = false;
            Entity entity = damageSource.getEntity();
            if (serverPlayer2 != null && !serverPlayer2.getMainHandItem().isEmpty() && (serverPlayer2.getMainHandItem().getItem() instanceof C1056tI)) {
                z = true;
            }
            if (entity == null || entity.equals(serverPlayer) || z) {
                int iM4009a = C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this.f4335g, uuid, C1089tp.f5712C) - 1;
                if (iM4009a < 0) {
                    iM4009a = 0;
                }
                C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this.f4335g, uuid, C1089tp.f5712C, iM4009a);
                C0799oR.m3943a(serverPlayer, new C1010sQ(f5068jn, 60));
                serverPlayer.playSound(SoundEvents.WITHER_DEATH, 2.5f, 1.0f);
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
        C0799oR.m3966a(abstractC0183c, serverPlayer, c0796oOA.m3863a((AbstractC0787oF<?, ?, ?>) this.f4335g));
        C0799oR.m4026f(serverPlayer);
        m5242g(serverPlayer);
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

    /* JADX INFO: renamed from: g */
    public void m5242g(@NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        int iM4009a = C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this.f4335g, uuid, C1089tp.f5712C);
        if (iM4009a > ((C0955rO) this.f4335g).f5052bm.size()) {
            if (this.f5071z == null) {
                this.f5071z = uuid;
                return;
            }
            return;
        }
        serverPlayer.getInventory().clearContent();
        if (iM4009a < ((C0955rO) this.f4335g).f5052bm.size()) {
            C1144ur c1144urM5228a = ((C0955rO) this.f4335g).m5228a(iM4009a);
            if (c1144urM5228a != null) {
                serverPlayer.getInventory().setItem(0, new ItemStack(c1144urM5228a));
            }
        } else {
            C0799oR.m3943a(serverPlayer, new C1010sQ(f5070jp, 80));
        }
        serverPlayer.getInventory().setItem(2, new ItemStack((ItemLike) C1231wY.f7174as.get()));
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

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: bf */
    public void mo3818bf() {
        super.mo3818bf();
        this.f5071z = null;
    }
}
