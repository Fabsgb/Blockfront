package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import java.util.Collections;
import java.util.Iterator;
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
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sC.class */
public final class C0996sC extends AbstractC0790oI<C0994sA> {

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final C0866pf f5269d = new C0866pf(null, null, null, null, null, null, null, null).m4327a(new ItemStack((ItemLike) C1231wY.f7125v.get()));

    /* JADX INFO: renamed from: bB */
    @NotNull
    public final List<C0805oX> f5270bB;

    public C0996sC(@NotNull C0994sA c0994sA, @NotNull AbstractC0183c<?> abstractC0183c) {
        super(c0994sA, abstractC0183c);
        this.f5270bB = new ObjectArrayList();
        m3792b(new C0796oO(c0994sA, C1089tp.f5729cZ, Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES)), Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT)), 16));
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0864pd mo3824a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0797oP c0797oP) {
        ObjectSortedSet<UUID> objectSortedSetM3952a = C0799oR.m3952a((AbstractC0787oF<?, ?, ?>) this.f4335g, 3, C1089tp.f5695l, set);
        if (objectSortedSetM3952a.isEmpty()) {
            return new C0864pd(null, null);
        }
        return new C0864pd(null, Collections.singleton((UUID) objectSortedSetM3952a.getFirst()));
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    protected boolean mo3825a(@NotNull ServerPlayer serverPlayer) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public void mo3826a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C0796oO c0796oO) {
        C0799oR.m3966a(abstractC0183c, serverPlayer, m5457j());
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: b */
    public C0796oO mo3805b() {
        return m3806a(C1089tp.f5729cZ);
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
    /* JADX INFO: renamed from: a */
    public boolean mo3829a(@NotNull ServerPlayer serverPlayer, @NotNull DamageSource damageSource) {
        UUID uuid = serverPlayer.getUUID();
        if (((C0994sA) this.f4335g).m5440a(uuid) != EnumC1004sK.JESTER) {
            return false;
        }
        int color = EnumC1004sK.JESTER.getColor();
        ServerPlayer entity = damageSource.getEntity();
        if (!(entity instanceof ServerPlayer)) {
            return false;
        }
        ServerPlayer serverPlayer2 = entity;
        C0799oR.m3983a((AbstractC0787oF<?, ?, ?>) this.f4335g, (Component) Component.empty(), (Component) Component.translatable("bf.message.gamemode.ttt.jester.death", new Object[]{Component.literal(serverPlayer2.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}).withColor(color));
        serverPlayer2.kill();
        ((C0994sA) this.f4335g).m5436a(uuid, EnumC1004sK.INNOCENT);
        serverPlayer.setHealth(serverPlayer.getMaxHealth());
        C0799oR.m3973a(serverPlayer, (Component) Component.empty(), (Component) Component.empty());
        C0799oR.m3973a(serverPlayer, (Component) Component.empty(), (Component) Component.translatable("bf.message.gamemode.ttt.jester.death.direct").withColor(color));
        C0799oR.m3973a(serverPlayer, (Component) Component.empty(), (Component) Component.empty());
        C0799oR.m3970c(serverPlayer, EnumC1004sK.INNOCENT.getTitle());
        C0799oR.m3973a(serverPlayer, (Component) Component.empty(), (Component) Component.empty());
        C0799oR.m3973a(serverPlayer, (Component) Component.empty(), EnumC1004sK.INNOCENT.getDescription());
        C0799oR.m3973a(serverPlayer, (Component) Component.empty(), (Component) Component.empty());
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: b */
    public void mo3830b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @CheckForNull @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        String scoreboardName = serverPlayer.getScoreboardName();
        ItemStack mainHandItem = null;
        if (serverPlayer2 != null && uuid2 != null) {
            String scoreboardName2 = serverPlayer2.getScoreboardName();
            EnumC1004sK enumC1004sKM5440a = ((C0994sA) this.f4335g).m5440a(uuid);
            EnumC1004sK enumC1004sKM5440a2 = ((C0994sA) this.f4335g).m5440a(uuid2);
            if (enumC1004sKM5440a.getTeam() == enumC1004sKM5440a2.getTeam() && !scoreboardName2.equals(scoreboardName)) {
                C1194vo.m6648a(new C1257wy(80.0f), serverPlayer2);
            }
            if (enumC1004sKM5440a == EnumC1004sK.INNOCENT && enumC1004sKM5440a2.getTeam() == EnumC1005sL.BAD) {
                C0799oR.m3927a(uuid, (SoundEvent) C1280xc.f7598qd.get(), SoundSource.MASTER);
            }
            Set<UUID> objectOpenHashSet = new ObjectOpenHashSet<>();
            int i = 0;
            if (enumC1004sKM5440a == EnumC1004sK.TRAITOR) {
                objectOpenHashSet = ((C0994sA) this.f4335g).m5439a(EnumC1004sK.DETECTIVE, set);
                i = 1;
            } else if (enumC1004sKM5440a == EnumC1004sK.DETECTIVE) {
                objectOpenHashSet = ((C0994sA) this.f4335g).m5439a(EnumC1004sK.TRAITOR, set);
                i = 2;
            } else if (enumC1004sKM5440a == EnumC1004sK.INNOCENT) {
                objectOpenHashSet = ((C0994sA) this.f4335g).m5439a(EnumC1004sK.TRAITOR, set);
                i = 1;
            }
            if (i > 0) {
                MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.ttt.points.gain", new Object[]{Component.literal(String.valueOf(i)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GRAY);
                for (UUID uuid3 : objectOpenHashSet) {
                    C0799oR.m4015a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4335g, uuid3, C1089tp.f5702s, i);
                    C0799oR.m4015a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4335g, uuid3, C1089tp.f5695l, i);
                    C0799oR.m3971b(uuid3, (Component) mutableComponentWithStyle);
                }
            }
            C0799oR.m3970c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.ttt.killed", new Object[]{Component.literal(scoreboardName2).withColor(ColorReferences.COLOR_WHITE), Component.literal(enumC1004sKM5440a2.getKey()).withColor(TextColor.fromRgb(enumC1004sKM5440a2.getColor()).getValue())}).withStyle(ChatFormatting.GRAY));
            C0796oO c0796oOA = m3793a(uuid2);
            mainHandItem = serverPlayer2.getMainHandItem();
            if (((C0994sA) this.f4335g).mo3560a() == EnumC0795oN.GAME && !scoreboardName2.equalsIgnoreCase(scoreboardName)) {
                c0796oOA.m3864a(C1089tp.f5695l, c0796oOA.m3866a(C1089tp.f5695l) + 1);
            }
        }
        ((C0994sA) this.f4335g).f5264X.add(new C1046sz(scoreboardName, uuid, (mainHandItem == null || mainHandItem.isEmpty()) ? "" : mainHandItem.getDisplayName().getString(), serverPlayer.getX(), serverPlayer.getY() + 0.5d, serverPlayer.getZ(), 0.0f, 0.0f));
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public void mo3831a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        ServerPlayer serverPlayerM3963a;
        C0799oR.m3948a(abstractC0183c, serverLevel, serverPlayer);
        serverPlayer.setGameMode(GameType.SPECTATOR);
        C0805oX c0805oX = this.f4341e;
        if (!m3814k().isEmpty() && (serverPlayerM3963a = C0799oR.m3963a((UUID) C1287xj.m7827a(m3814k()))) != null) {
            c0805oX = new C0805oX((Player) serverPlayerM3963a);
        }
        C0799oR.m3966a(abstractC0183c, serverPlayer, c0805oX);
        C0799oR.m3959b(abstractC0183c, serverPlayer);
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3832a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        if (((C0994sA) this.f4335g).m5440a(player.getUUID()) == EnumC1004sK.PENDING) {
            return false;
        }
        ServerPlayer entity2 = damageSource.getEntity();
        if (entity2 instanceof ServerPlayer) {
            if (((C0994sA) this.f4335g).m5440a(entity2.getUUID()) == EnumC1004sK.JESTER) {
                return false;
            }
        }
        return ((C0994sA) this.f4335g).mo3560a() == EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3833a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3787a(@NotNull Player player, @NotNull ItemStack itemStack) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3788a(@NotNull Player player, @NotNull ItemEntity itemEntity, @NotNull ItemStack itemStack) {
        if (((C0994sA) this.f4335g).mo3560a() != EnumC0795oN.GAME) {
            return false;
        }
        UUID uuid = player.getUUID();
        Inventory inventory = player.getInventory();
        if (itemStack.getItem() instanceof C1144ur) {
            if (((ItemStack) inventory.items.getFirst()).isEmpty() || ((ItemStack) inventory.items.get(1)).isEmpty()) {
                C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this.f4335g, uuid, C1089tp.f5696m, 1);
                return true;
            }
            return false;
        }
        if (itemStack.getItem() instanceof InterfaceC1070tW) {
            if (((ItemStack) inventory.items.get(3)).isEmpty() || ((ItemStack) inventory.items.get(4)).isEmpty() || ((ItemStack) inventory.items.get(5)).isEmpty()) {
                C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this.f4335g, uuid, C1089tp.f5696m, 1);
                return true;
            }
            return false;
        }
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

    /* JADX INFO: renamed from: j */
    public C0805oX m5457j() {
        return (C0805oX) C1287xj.m7828a(this.f5270bB);
    }

    /* JADX INFO: renamed from: a */
    public void m5458a(@NotNull AbstractC0183c<?> abstractC0183c) {
        Iterator<UUID> it = m3809h().iterator();
        while (it.hasNext()) {
            C0799oR.m3965a(abstractC0183c, it.next(), m5457j());
        }
    }
}
