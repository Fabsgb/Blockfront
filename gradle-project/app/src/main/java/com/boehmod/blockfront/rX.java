package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rX.class */
public final class rX extends oI<rV> {
    private static final int qd = 5;
    private static final int qe = 600;
    private static final int qf = 6;

    @NotNull
    public static final String cw = "Survivors";

    @NotNull
    public static final C0411pf b = new C0411pf(null, new ItemStack((ItemLike) wY.mL.get()), new ItemStack((ItemLike) wY.as.get()), null, null, null, null, null);

    @NotNull
    private final List<oX> bs;

    @NotNull
    private final Set<UUID> p;

    public rX(@NotNull rV rVVar, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        super(rVVar, cVar);
        this.bs = new ObjectArrayList();
        this.p = new ObjectOpenHashSet();
        b(new oO(rVVar, cw, Style.EMPTY.withColor(TextColor.fromRgb(7101608)), Style.EMPTY.withColor(TextColor.fromRgb(14407935)), 6));
    }

    @NotNull
    public List<oX> aq() {
        return Collections.unmodifiableList(this.bs);
    }

    public void d(oX oXVar) {
        this.bs.add(oXVar);
    }

    public void cJ() {
        this.bs.clear();
    }

    private void a(Level level, C0490sd c0490sd, UUID uuid, String str, Set<UUID> set) {
        if (oR.a((oF<?, ?, ?>) this.g, uuid, C0529tp.s) >= c0490sd.bk()) {
            MutableComponent mutableComponentWithStyle = Component.literal(str).withStyle(ChatFormatting.GRAY);
            oR.b((oF<?, ?, ?>) this.g, uuid, C0529tp.s, c0490sd.bk());
            oR.a((oF<?, ?, ?>) this.g, (Component) Component.translatable("bf.message.gamemode.infected.door.open", new Object[]{mutableComponentWithStyle}).withStyle(ChatFormatting.DARK_RED), 80, "inf.door");
            for (C0489sc c0489sc : ((rV) this.g).bo) {
                String strAi = c0489sc.ai();
                if (c0490sd.at().contains(strAi) && !c0489sc.bK()) {
                    oR.a((oF<?, ?, ?>) this.g, (Component) Component.translatable("bf.message.gamemode.infected.zone.discover", new Object[]{mutableComponentWithStyle, Component.literal(strAi).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.DARK_RED), 80, "inf.zone");
                    c0489sc.Q(true);
                }
            }
            c0490sd.a(level, true);
            String id = c0490sd.getId();
            for (C0490sd c0490sd2 : ((rV) this.g).bp) {
                if (c0490sd2.getId().equals(id)) {
                    c0490sd2.a(level, true);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.oI
    @Nullable
    public C0409pd a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable oP oPVar) {
        if (((rV) this.g).qa >= 30) {
            return new C0409pd(null, set);
        }
        if (set.isEmpty() || ((rV) this.g).a(set).isEmpty()) {
            return new C0409pd(null, null);
        }
        return null;
    }

    @Override // com.boehmod.blockfront.oI
    /* JADX INFO: renamed from: a */
    protected boolean mo784a(@NotNull ServerPlayer serverPlayer) {
        return false;
    }

    @Override // com.boehmod.blockfront.oI
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull oO oOVar) {
        oX oXVar = (oX) C0631xj.a(this.bs);
        oR.a(serverLevel, serverPlayer, b);
        oR.a(cVar, serverPlayer, oXVar);
        oR.m792a((oF<?, ?, ?>) this.g, uuid, C0529tp.R, ((rV) this.g).b((Player) serverPlayer));
        if (((rV) this.g).qa >= 5 && !this.p.contains(uuid)) {
            oR.c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.infected.reimbursed", new Object[]{Component.literal("$600").withStyle(ChatFormatting.GREEN), Component.literal(String.valueOf(5)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.DARK_RED));
            oR.m792a((oF<?, ?, ?>) this.g, uuid, C0529tp.s, 600);
        }
        this.p.add(uuid);
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull Player player, @NotNull UUID uuid, @NotNull Block block, @NotNull BlockPos blockPos) {
        if (oR.a(player, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) cVar.m305a(player))) {
            return false;
        }
        String scoreboardName = player.getScoreboardName();
        if (block instanceof DoorBlock) {
            Set<UUID> setH = h();
            for (C0490sd c0490sd : ((rV) this.g).bp) {
                if (c0490sd.a(blockPos) && !c0490sd.bL()) {
                    a(level, c0490sd, uuid, scoreboardName, setH);
                }
            }
        }
        return super.a(cVar, level, player, uuid, block, blockPos);
    }

    @Override // com.boehmod.blockfront.oI
    public oO b() {
        return a(cw);
    }

    @Override // com.boehmod.blockfront.oI
    public void d(@NotNull ServerPlayer serverPlayer) {
    }

    @Override // com.boehmod.blockfront.oI
    public void b(@NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar) {
        if (bVar.dk()) {
            if (serverPlayer.isSpectator()) {
                bVar.X(false);
            } else if (bVar.cs() > 1) {
                bVar.J(1);
            } else {
                oR.a(a(), serverPlayer.serverLevel(), serverPlayer);
                serverPlayer.setGameMode(GameType.SPECTATOR);
            }
        }
    }

    @Override // com.boehmod.blockfront.oI
    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @CheckForNull @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        serverLevel.playSound((Player) null, serverPlayer, SoundEvents.WITHER_HURT, SoundSource.AMBIENT, 10.0f, 0.5f);
    }

    @Override // com.boehmod.blockfront.oI
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        oR.a(cVar, serverLevel, serverPlayer);
        oR.a(serverLevel, serverPlayer, b);
        oR.a(cVar, serverPlayer, (oX) C0631xj.a(this.bs));
        oR.f(serverPlayer);
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        return !(entity instanceof Player);
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource) {
        return !(livingEntity instanceof mY);
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
