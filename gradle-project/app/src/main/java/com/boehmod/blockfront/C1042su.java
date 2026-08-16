package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.su */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/su.class */
public final class C1042su extends AbstractC0866pe<C1040ss> {

    /* JADX INFO: renamed from: se */
    private static final int f5677se = 5;

    /* JADX INFO: renamed from: sf */
    private static final int f5678sf = 600;

    /* JADX INFO: renamed from: sg */
    private static final int f5679sg = 6;

    /* JADX INFO: renamed from: cG */
    @NotNull
    public static final String f5680cG = "Survivors";

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final C0837pB f5681b = new C0837pB(null, new ItemStack((ItemLike) C1308xv.f7822mL.get()), new ItemStack((ItemLike) C1308xv.f7739as.get()), null, null, null, null, null);

    /* JADX INFO: renamed from: bz */
    @NotNull
    private final List<C0881pt> f5682bz;

    /* JADX INFO: renamed from: q */
    @NotNull
    private final Set<UUID> f5683q;

    public C1042su(@NotNull C1040ss c1040ss, @NotNull AbstractC0184c<?> abstractC0184c) {
        super(c1040ss, abstractC0184c);
        this.f5682bz = new ObjectArrayList();
        this.f5683q = new ObjectOpenHashSet();
        m4228b(new C0872pk(c1040ss, f5680cG, Style.EMPTY.withColor(TextColor.fromRgb(7101608)), Style.EMPTY.withColor(TextColor.fromRgb(14407935)), 6));
    }

    @NotNull
    /* JADX INFO: renamed from: as */
    public List<C0881pt> m5841as() {
        return Collections.unmodifiableList(this.f5682bz);
    }

    /* JADX INFO: renamed from: d */
    public void m5842d(C0881pt c0881pt) {
        this.f5682bz.add(c0881pt);
    }

    /* JADX INFO: renamed from: cV */
    public void m5843cV() {
        this.f5682bz.clear();
    }

    /* JADX INFO: renamed from: a */
    private void m5844a(Level level, C0995sA c0995sA, UUID uuid, String str, Set<UUID> set) {
        if (C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5755s) >= c0995sA.m5590bz()) {
            MutableComponent mutableComponentWithStyle = Component.literal(str).withStyle(ChatFormatting.GRAY);
            C0875pn.m4455b((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5755s, c0995sA.m5590bz());
            C0875pn.m4436a((AbstractC0863pb<?, ?, ?>) this.f4730g, (Component) Component.translatable("bf.message.gamemode.infected.door.open", new Object[]{mutableComponentWithStyle}).withStyle(ChatFormatting.DARK_RED), 80, "inf.door");
            for (C1047sz c1047sz : ((C1040ss) this.f4730g).f5658bv) {
                String strM5857ap = c1047sz.m5857ap();
                if (c0995sA.m5587av().contains(strM5857ap) && !c1047sz.m5855bU()) {
                    C0875pn.m4436a((AbstractC0863pb<?, ?, ?>) this.f4730g, (Component) Component.translatable("bf.message.gamemode.infected.zone.discover", new Object[]{mutableComponentWithStyle, Component.literal(strM5857ap).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.DARK_RED), 80, "inf.zone");
                    c1047sz.m5856R(true);
                }
            }
            c0995sA.m5586a(level, true);
            String id = c0995sA.getId();
            for (C0995sA c0995sA2 : ((C1040ss) this.f4730g).f5659bw) {
                if (c0995sA2.getId().equals(id)) {
                    c0995sA2.m5586a(level, true);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0887pz mo4260a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0873pl c0873pl) {
        if (((C1040ss) this.f4730g).f5666sb >= 30) {
            return new C0887pz(null, set);
        }
        if (set.isEmpty() || ((C1040ss) this.f4730g).m5793a(set).isEmpty()) {
            return new C0887pz(null, null);
        }
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    protected boolean mo4261b(@NotNull ServerPlayer serverPlayer) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public void mo4262a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C0872pk c0872pk) {
        C0881pt c0881pt = (C0881pt) C1267xG.m7152a(this.f5682bz);
        C0875pn.m4457a(serverLevel, serverPlayer, f5681b);
        C0875pn.m4402a(abstractC0184c, serverPlayer, c0881pt);
        C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5780R, ((C1040ss) this.f4730g).m5802b((Player) serverPlayer));
        if (((C1040ss) this.f4730g).f5666sb >= 5 && !this.f5683q.contains(uuid)) {
            C0875pn.m4406c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.infected.reimbursed", new Object[]{Component.literal("$600").withStyle(ChatFormatting.GREEN), Component.literal(String.valueOf(5)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.DARK_RED));
            C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5755s, 600);
        }
        this.f5683q.add(uuid);
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4225a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull Player player, @NotNull UUID uuid, @NotNull Block block, @NotNull BlockPos blockPos) {
        if (C0875pn.m4488a(player, (AbstractC0183b<?, ?, ?, ?>) abstractC0184c.m1153a(player))) {
            return false;
        }
        String scoreboardName = player.getScoreboardName();
        if (block instanceof DoorBlock) {
            Set<UUID> setH = m4245h();
            for (C0995sA c0995sA : ((C1040ss) this.f4730g).f5659bw) {
                if (c0995sA.m5591a(blockPos) && !c0995sA.m5589bV()) {
                    m5844a(level, c0995sA, uuid, scoreboardName, setH);
                }
            }
        }
        return super.mo4225a(abstractC0184c, level, player, uuid, block, blockPos);
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    public C0872pk mo4241b() {
        return m4242a(f5680cG);
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: d */
    public void mo4263d(@NotNull ServerPlayer serverPlayer) {
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    public void mo4264b(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b) {
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
        serverLevel.playSound((Player) null, serverPlayer, SoundEvents.WITHER_HURT, SoundSource.AMBIENT, 10.0f, 0.5f);
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public void mo4267a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        C0875pn.m4384a(abstractC0184c, serverLevel, serverPlayer);
        C0875pn.m4457a(serverLevel, serverPlayer, f5681b);
        C0875pn.m4402a(abstractC0184c, serverPlayer, (C0881pt) C1267xG.m7152a(this.f5682bz));
        C0875pn.m4462f(serverPlayer);
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4268a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        return !(entity instanceof Player);
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4269a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource) {
        return !(livingEntity instanceof C0776nu);
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
