package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sC.class */
public final class sC extends oI<sA> {

    @NotNull
    public static final C0411pf d = new C0411pf(null, null, null, null, null, null, null, null).a(new ItemStack((ItemLike) wY.v.get()));

    @NotNull
    public final List<oX> bB;

    public sC(@NotNull sA sAVar, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        super(sAVar, cVar);
        this.bB = new ObjectArrayList();
        b(new oO(sAVar, C0529tp.cZ, Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES)), Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT)), 16));
    }

    @Override // com.boehmod.blockfront.oI
    @NotNull
    public C0409pd a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable oP oPVar) {
        ObjectSortedSet<UUID> objectSortedSetA = oR.a((oF<?, ?, ?>) this.g, 3, C0529tp.l, set);
        if (objectSortedSetA.isEmpty()) {
            return new C0409pd(null, null);
        }
        return new C0409pd(null, Collections.singleton((UUID) objectSortedSetA.getFirst()));
    }

    @Override // com.boehmod.blockfront.oI
    /* JADX INFO: renamed from: a */
    protected boolean mo784a(@NotNull ServerPlayer serverPlayer) {
        return false;
    }

    @Override // com.boehmod.blockfront.oI
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull oO oOVar) {
        oR.a(cVar, serverPlayer, j());
    }

    @Override // com.boehmod.blockfront.oI
    public oO b() {
        return a(C0529tp.cZ);
    }

    @Override // com.boehmod.blockfront.oI
    public void d(@NotNull ServerPlayer serverPlayer) {
    }

    @Override // com.boehmod.blockfront.oI
    public void b(@NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar) {
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull ServerPlayer serverPlayer, @NotNull DamageSource damageSource) {
        UUID uuid = serverPlayer.getUUID();
        if (((sA) this.g).a(uuid) != sK.JESTER) {
            return false;
        }
        int color = sK.JESTER.getColor();
        ServerPlayer entity = damageSource.getEntity();
        if (!(entity instanceof ServerPlayer)) {
            return false;
        }
        ServerPlayer serverPlayer2 = entity;
        oR.a((oF<?, ?, ?>) this.g, (Component) Component.empty(), (Component) Component.translatable("bf.message.gamemode.ttt.jester.death", new Object[]{Component.literal(serverPlayer2.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}).withColor(color));
        serverPlayer2.kill();
        ((sA) this.g).a(uuid, sK.INNOCENT);
        serverPlayer.setHealth(serverPlayer.getMaxHealth());
        oR.a(serverPlayer, (Component) Component.empty(), (Component) Component.empty());
        oR.a(serverPlayer, (Component) Component.empty(), (Component) Component.translatable("bf.message.gamemode.ttt.jester.death.direct").withColor(color));
        oR.a(serverPlayer, (Component) Component.empty(), (Component) Component.empty());
        oR.c(serverPlayer, sK.INNOCENT.getTitle());
        oR.a(serverPlayer, (Component) Component.empty(), (Component) Component.empty());
        oR.a(serverPlayer, (Component) Component.empty(), sK.INNOCENT.getDescription());
        oR.a(serverPlayer, (Component) Component.empty(), (Component) Component.empty());
        return true;
    }

    @Override // com.boehmod.blockfront.oI
    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @CheckForNull @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        String scoreboardName = serverPlayer.getScoreboardName();
        ItemStack mainHandItem = null;
        if (serverPlayer2 != null && uuid2 != null) {
            String scoreboardName2 = serverPlayer2.getScoreboardName();
            sK sKVarA = ((sA) this.g).a(uuid);
            sK sKVarA2 = ((sA) this.g).a(uuid2);
            if (sKVarA.getTeam() == sKVarA2.getTeam() && !scoreboardName2.equals(scoreboardName)) {
                C0582vo.a(new C0619wy(80.0f), serverPlayer2);
            }
            if (sKVarA == sK.INNOCENT && sKVarA2.getTeam() == sL.BAD) {
                oR.a(uuid, (SoundEvent) C0624xc.qd.get(), SoundSource.MASTER);
            }
            Set<UUID> objectOpenHashSet = new ObjectOpenHashSet<>();
            int i = 0;
            if (sKVarA == sK.TRAITOR) {
                objectOpenHashSet = ((sA) this.g).a(sK.DETECTIVE, set);
                i = 1;
            } else if (sKVarA == sK.DETECTIVE) {
                objectOpenHashSet = ((sA) this.g).a(sK.TRAITOR, set);
                i = 2;
            } else if (sKVarA == sK.INNOCENT) {
                objectOpenHashSet = ((sA) this.g).a(sK.TRAITOR, set);
                i = 1;
            }
            if (i > 0) {
                MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.ttt.points.gain", new Object[]{Component.literal(String.valueOf(i)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GRAY);
                for (UUID uuid3 : objectOpenHashSet) {
                    oR.a(abstractC0264ju, (oF<?, ?, ?>) this.g, uuid3, C0529tp.s, i);
                    oR.a(abstractC0264ju, (oF<?, ?, ?>) this.g, uuid3, C0529tp.l, i);
                    oR.b(uuid3, (Component) mutableComponentWithStyle);
                }
            }
            oR.c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.ttt.killed", new Object[]{Component.literal(scoreboardName2).withColor(ColorReferences.COLOR_WHITE), Component.literal(sKVarA2.getKey()).withColor(TextColor.fromRgb(sKVarA2.getColor()).getValue())}).withStyle(ChatFormatting.GRAY));
            oO oOVarA = a(uuid2);
            mainHandItem = serverPlayer2.getMainHandItem();
            if (((sA) this.g).a() == oN.GAME && !scoreboardName2.equalsIgnoreCase(scoreboardName)) {
                oOVarA.a(C0529tp.l, oOVarA.a(C0529tp.l) + 1);
            }
        }
        ((sA) this.g).X.add(new C0512sz(scoreboardName, uuid, (mainHandItem == null || mainHandItem.isEmpty()) ? "" : mainHandItem.getDisplayName().getString(), serverPlayer.getX(), serverPlayer.getY() + 0.5d, serverPlayer.getZ(), 0.0f, 0.0f));
    }

    @Override // com.boehmod.blockfront.oI
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        ServerPlayer serverPlayerA;
        oR.a(cVar, serverLevel, serverPlayer);
        serverPlayer.setGameMode(GameType.SPECTATOR);
        oX oXVar = this.e;
        if (!k().isEmpty() && (serverPlayerA = oR.a((UUID) C0631xj.a(k()))) != null) {
            oXVar = new oX((Player) serverPlayerA);
        }
        oR.a(cVar, serverPlayer, oXVar);
        oR.b(cVar, serverPlayer);
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        if (((sA) this.g).a(player.getUUID()) == sK.PENDING) {
            return false;
        }
        ServerPlayer entity2 = damageSource.getEntity();
        if (entity2 instanceof ServerPlayer) {
            if (((sA) this.g).a(entity2.getUUID()) == sK.JESTER) {
                return false;
            }
        }
        return ((sA) this.g).a() == oN.GAME;
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource) {
        return true;
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull Player player, @NotNull ItemStack itemStack) {
        return true;
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull Player player, @NotNull ItemEntity itemEntity, @NotNull ItemStack itemStack) {
        if (((sA) this.g).a() != oN.GAME) {
            return false;
        }
        UUID uuid = player.getUUID();
        Inventory inventory = player.getInventory();
        if (itemStack.getItem() instanceof C0558ur) {
            if (((ItemStack) inventory.items.getFirst()).isEmpty() || ((ItemStack) inventory.items.get(1)).isEmpty()) {
                oR.m792a((oF<?, ?, ?>) this.g, uuid, C0529tp.m, 1);
                return true;
            }
            return false;
        }
        if (itemStack.getItem() instanceof tW) {
            if (((ItemStack) inventory.items.get(3)).isEmpty() || ((ItemStack) inventory.items.get(4)).isEmpty() || ((ItemStack) inventory.items.get(5)).isEmpty()) {
                oR.m792a((oF<?, ?, ?>) this.g, uuid, C0529tp.m, 1);
                return true;
            }
            return false;
        }
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

    public oX j() {
        return (oX) C0631xj.a(this.bB);
    }

    public void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        Iterator<UUID> it = h().iterator();
        while (it.hasNext()) {
            oR.a(cVar, it.next(), j());
        }
    }
}
