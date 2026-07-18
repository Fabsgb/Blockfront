package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rX.class */
public final class C0964rX extends AbstractC0790oI<C0962rV> {

    /* JADX INFO: renamed from: qd */
    private static final int f5100qd = 5;

    /* JADX INFO: renamed from: qe */
    private static final int f5101qe = 600;

    /* JADX INFO: renamed from: qf */
    private static final int f5102qf = 6;

    /* JADX INFO: renamed from: cw */
    @NotNull
    public static final String f5103cw = "Survivors";

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final C0866pf f5104b = new C0866pf(null, new ItemStack((ItemLike) C1231wY.f7257mL.get()), new ItemStack((ItemLike) C1231wY.f7174as.get()), null, null, null, null, null);

    /* JADX INFO: renamed from: bs */
    @NotNull
    private final List<C0805oX> f5105bs;

    /* JADX INFO: renamed from: p */
    @NotNull
    private final Set<UUID> f5106p;

    public C0964rX(@NotNull C0962rV c0962rV, @NotNull AbstractC0183c<?> abstractC0183c) {
        super(c0962rV, abstractC0183c);
        this.f5105bs = new ObjectArrayList();
        this.f5106p = new ObjectOpenHashSet();
        m3792b(new C0796oO(c0962rV, f5103cw, Style.EMPTY.withColor(TextColor.fromRgb(7101608)), Style.EMPTY.withColor(TextColor.fromRgb(14407935)), 6));
    }

    @NotNull
    /* JADX INFO: renamed from: aq */
    public List<C0805oX> m5304aq() {
        return Collections.unmodifiableList(this.f5105bs);
    }

    /* JADX INFO: renamed from: d */
    public void m5305d(C0805oX c0805oX) {
        this.f5105bs.add(c0805oX);
    }

    /* JADX INFO: renamed from: cJ */
    public void m5306cJ() {
        this.f5105bs.clear();
    }

    /* JADX INFO: renamed from: a */
    private void m5307a(Level level, C1023sd c1023sd, UUID uuid, String str, Set<UUID> set) {
        if (C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this.f4335g, uuid, C1089tp.f5702s) >= c1023sd.m5705bk()) {
            MutableComponent mutableComponentWithStyle = Component.literal(str).withStyle(ChatFormatting.GRAY);
            C0799oR.m4019b((AbstractC0787oF<?, ?, ?>) this.f4335g, uuid, C1089tp.f5702s, c1023sd.m5705bk());
            C0799oR.m4000a((AbstractC0787oF<?, ?, ?>) this.f4335g, (Component) Component.translatable("bf.message.gamemode.infected.door.open", new Object[]{mutableComponentWithStyle}).withStyle(ChatFormatting.DARK_RED), 80, "inf.door");
            for (C1022sc c1022sc : ((C0962rV) this.f4335g).f5081bo) {
                String strM5694ai = c1022sc.m5694ai();
                if (c1023sd.m5702at().contains(strM5694ai) && !c1022sc.m5692bK()) {
                    C0799oR.m4000a((AbstractC0787oF<?, ?, ?>) this.f4335g, (Component) Component.translatable("bf.message.gamemode.infected.zone.discover", new Object[]{mutableComponentWithStyle, Component.literal(strM5694ai).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.DARK_RED), 80, "inf.zone");
                    c1022sc.m5693Q(true);
                }
            }
            c1023sd.m5701a(level, true);
            String id = c1023sd.getId();
            for (C1023sd c1023sd2 : ((C0962rV) this.f4335g).f5082bp) {
                if (c1023sd2.getId().equals(id)) {
                    c1023sd2.m5701a(level, true);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0864pd mo3824a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0797oP c0797oP) {
        if (((C0962rV) this.f4335g).f5089qa >= 30) {
            return new C0864pd(null, set);
        }
        if (set.isEmpty() || ((C0962rV) this.f4335g).m5256a(set).isEmpty()) {
            return new C0864pd(null, null);
        }
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    protected boolean mo3825a(@NotNull ServerPlayer serverPlayer) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public void mo3826a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C0796oO c0796oO) {
        C0805oX c0805oX = (C0805oX) C1287xj.m7828a(this.f5105bs);
        C0799oR.m4021a(serverLevel, serverPlayer, f5104b);
        C0799oR.m3966a(abstractC0183c, serverPlayer, c0805oX);
        C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this.f4335g, uuid, C1089tp.f5727R, ((C0962rV) this.f4335g).m5265b((Player) serverPlayer));
        if (((C0962rV) this.f4335g).f5089qa >= 5 && !this.f5106p.contains(uuid)) {
            C0799oR.m3970c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.infected.reimbursed", new Object[]{Component.literal("$600").withStyle(ChatFormatting.GREEN), Component.literal(String.valueOf(5)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.DARK_RED));
            C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this.f4335g, uuid, C1089tp.f5702s, 600);
        }
        this.f5106p.add(uuid);
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3789a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull Player player, @NotNull UUID uuid, @NotNull Block block, @NotNull BlockPos blockPos) {
        if (C0799oR.m4052a(player, (AbstractC0182b<?, ?, ?, ?>) abstractC0183c.m1136a(player))) {
            return false;
        }
        String scoreboardName = player.getScoreboardName();
        if (block instanceof DoorBlock) {
            Set<UUID> setH = m3809h();
            for (C1023sd c1023sd : ((C0962rV) this.f4335g).f5082bp) {
                if (c1023sd.m5706a(blockPos) && !c1023sd.m5704bL()) {
                    m5307a(level, c1023sd, uuid, scoreboardName, setH);
                }
            }
        }
        return super.mo3789a(abstractC0183c, level, player, uuid, block, blockPos);
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: b */
    public C0796oO mo3805b() {
        return m3806a(f5103cw);
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: d */
    public void mo3827d(@NotNull ServerPlayer serverPlayer) {
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: b */
    public void mo3828b(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b) {
        if (abstractC0182b.m1087dk()) {
            if (serverPlayer.isSpectator()) {
                abstractC0182b.m1088X(false);
            } else if (abstractC0182b.m1095cs() > 1) {
                abstractC0182b.m1097J(1);
            } else {
                C0799oR.m3948a(m3771a(), serverPlayer.serverLevel(), serverPlayer);
                serverPlayer.setGameMode(GameType.SPECTATOR);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: b */
    public void mo3830b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @CheckForNull @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        serverLevel.playSound((Player) null, serverPlayer, SoundEvents.WITHER_HURT, SoundSource.AMBIENT, 10.0f, 0.5f);
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public void mo3831a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        C0799oR.m3948a(abstractC0183c, serverLevel, serverPlayer);
        C0799oR.m4021a(serverLevel, serverPlayer, f5104b);
        C0799oR.m3966a(abstractC0183c, serverPlayer, (C0805oX) C1287xj.m7828a(this.f5105bs));
        C0799oR.m4026f(serverPlayer);
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3832a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        return !(entity instanceof Player);
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3833a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource) {
        return !(livingEntity instanceof C0700mY);
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
