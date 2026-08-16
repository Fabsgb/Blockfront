package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sZ.class */
public final class C1020sZ extends AbstractC0866pe<C1018sX> {

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final C0837pB f5598d = new C0837pB(null, null, null, null, null, null, null, null).m3812a(new ItemStack((ItemLike) C1308xv.f7690v.get()));

    /* JADX INFO: renamed from: bI */
    @NotNull
    public final List<C0881pt> f5599bI;

    public C1020sZ(@NotNull C1018sX c1018sX, @NotNull AbstractC0184c<?> abstractC0184c) {
        super(c1018sX, abstractC0184c);
        this.f5599bI = new ObjectArrayList();
        m4228b(new C0872pk(c1018sX, C1062tN.f5782dk, Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES)), Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT)), 16));
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0887pz mo4260a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0873pl c0873pl) {
        ObjectSortedSet<UUID> objectSortedSetM4388a = C0875pn.m4388a((AbstractC0863pb<?, ?, ?>) this.f4730g, 3, C1062tN.f5748l, set);
        if (objectSortedSetM4388a.isEmpty()) {
            return new C0887pz(null, null);
        }
        return new C0887pz(null, Collections.singleton((UUID) objectSortedSetM4388a.getFirst()));
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    protected boolean mo4261b(@NotNull ServerPlayer serverPlayer) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public void mo4262a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C0872pk c0872pk) {
        C0875pn.m4402a(abstractC0184c, serverPlayer, m5735j());
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    public C0872pk mo4241b() {
        return m4242a(C1062tN.f5782dk);
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
    /* JADX INFO: renamed from: a */
    public boolean mo4265a(@NotNull ServerPlayer serverPlayer, @NotNull DamageSource damageSource) {
        UUID uuid = serverPlayer.getUUID();
        if (((C1018sX) this.f4730g).m5718a(uuid) != EnumC1082th.JESTER) {
            return false;
        }
        int color = EnumC1082th.JESTER.getColor();
        ServerPlayer entity = damageSource.getEntity();
        if (!(entity instanceof ServerPlayer)) {
            return false;
        }
        ServerPlayer serverPlayer2 = entity;
        C0875pn.m4419a((AbstractC0863pb<?, ?, ?>) this.f4730g, (Component) Component.empty(), (Component) Component.translatable("bf.message.gamemode.ttt.jester.death", new Object[]{Component.literal(serverPlayer2.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE)}).withColor(color));
        serverPlayer2.kill();
        ((C1018sX) this.f4730g).m5714a(uuid, EnumC1082th.INNOCENT);
        serverPlayer.setHealth(serverPlayer.getMaxHealth());
        C0875pn.m4409a(serverPlayer, (Component) Component.empty(), (Component) Component.empty());
        C0875pn.m4409a(serverPlayer, (Component) Component.empty(), (Component) Component.translatable("bf.message.gamemode.ttt.jester.death.direct").withColor(color));
        C0875pn.m4409a(serverPlayer, (Component) Component.empty(), (Component) Component.empty());
        C0875pn.m4406c(serverPlayer, EnumC1082th.INNOCENT.getTitle());
        C0875pn.m4409a(serverPlayer, (Component) Component.empty(), (Component) Component.empty());
        C0875pn.m4409a(serverPlayer, (Component) Component.empty(), EnumC1082th.INNOCENT.getDescription());
        C0875pn.m4409a(serverPlayer, (Component) Component.empty(), (Component) Component.empty());
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    public void mo4266b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @CheckForNull @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        String scoreboardName = serverPlayer.getScoreboardName();
        ItemStack mainHandItem = null;
        if (serverPlayer2 != null && uuid2 != null) {
            String scoreboardName2 = serverPlayer2.getScoreboardName();
            EnumC1082th enumC1082thM5718a = ((C1018sX) this.f4730g).m5718a(uuid);
            EnumC1082th enumC1082thM5718a2 = ((C1018sX) this.f4730g).m5718a(uuid2);
            if (enumC1082thM5718a.getTeam() == enumC1082thM5718a2.getTeam() && !scoreboardName2.equals(scoreboardName)) {
                C1169vO.m6643a(new C1230wW(80.0f), serverPlayer2);
            }
            if (enumC1082thM5718a == EnumC1082th.INNOCENT && enumC1082thM5718a2.getTeam() == EnumC1083ti.BAD) {
                C0875pn.m4363a(uuid, (SoundEvent) C1312xz.f8010qf.get(), SoundSource.MASTER);
            }
            Set<UUID> objectOpenHashSet = new ObjectOpenHashSet<>();
            int i = 0;
            if (enumC1082thM5718a == EnumC1082th.TRAITOR) {
                objectOpenHashSet = ((C1018sX) this.f4730g).m5717a(EnumC1082th.DETECTIVE, set);
                i = 1;
            } else if (enumC1082thM5718a == EnumC1082th.DETECTIVE) {
                objectOpenHashSet = ((C1018sX) this.f4730g).m5717a(EnumC1082th.TRAITOR, set);
                i = 2;
            } else if (enumC1082thM5718a == EnumC1082th.INNOCENT) {
                objectOpenHashSet = ((C1018sX) this.f4730g).m5717a(EnumC1082th.TRAITOR, set);
                i = 1;
            }
            if (i > 0) {
                MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.ttt.points.gain", new Object[]{Component.literal(String.valueOf(i)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.GRAY);
                for (UUID uuid3 : objectOpenHashSet) {
                    C0875pn.m4451a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4730g, uuid3, C1062tN.f5755s, i);
                    C0875pn.m4451a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4730g, uuid3, C1062tN.f5748l, i);
                    C0875pn.m4407b(uuid3, (Component) mutableComponentWithStyle);
                }
            }
            C0875pn.m4406c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.ttt.killed", new Object[]{Component.literal(scoreboardName2).withColor(ColorReferences.COLOR_WHITE), Component.literal(enumC1082thM5718a2.getKey()).withColor(TextColor.fromRgb(enumC1082thM5718a2.getColor()).getValue())}).withStyle(ChatFormatting.GRAY));
            C0872pk c0872pkA = m4229a(uuid2);
            mainHandItem = serverPlayer2.getMainHandItem();
            if (((C1018sX) this.f4730g).mo3996a() == EnumC0871pj.GAME && !scoreboardName2.equalsIgnoreCase(scoreboardName)) {
                c0872pkA.m4300a(C1062tN.f5748l, c0872pkA.m4302a(C1062tN.f5748l) + 1);
            }
        }
        ((C1018sX) this.f4730g).f5593ag.add(new C1017sW(scoreboardName, uuid, (mainHandItem == null || mainHandItem.isEmpty()) ? "" : mainHandItem.getDisplayName().getString(), serverPlayer.getX(), serverPlayer.getY() + 0.5d, serverPlayer.getZ(), 0.0f, 0.0f));
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public void mo4267a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        ServerPlayer serverPlayerM4399a;
        C0875pn.m4384a(abstractC0184c, serverLevel, serverPlayer);
        serverPlayer.setGameMode(GameType.SPECTATOR);
        C0881pt c0881pt = this.f4736e;
        if (!m4250k().isEmpty() && (serverPlayerM4399a = C0875pn.m4399a((UUID) C1267xG.m7151a(m4250k()))) != null) {
            c0881pt = new C0881pt((Player) serverPlayerM4399a);
        }
        C0875pn.m4402a(abstractC0184c, serverPlayer, c0881pt);
        C0875pn.m4395b(abstractC0184c, serverPlayer);
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4268a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        if (((C1018sX) this.f4730g).m5718a(player.getUUID()) == EnumC1082th.PENDING) {
            return false;
        }
        ServerPlayer entity2 = damageSource.getEntity();
        if (entity2 instanceof ServerPlayer) {
            if (((C1018sX) this.f4730g).m5718a(entity2.getUUID()) == EnumC1082th.JESTER) {
                return false;
            }
        }
        return ((C1018sX) this.f4730g).mo3996a() == EnumC0871pj.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4269a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4223a(@NotNull Player player, @NotNull ItemStack itemStack) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4224a(@NotNull Player player, @NotNull ItemEntity itemEntity, @NotNull ItemStack itemStack) {
        if (((C1018sX) this.f4730g).mo3996a() != EnumC0871pj.GAME) {
            return false;
        }
        UUID uuid = player.getUUID();
        Inventory inventory = player.getInventory();
        if (itemStack.getItem() instanceof C1117uP) {
            if (((ItemStack) inventory.items.getFirst()).isEmpty() || ((ItemStack) inventory.items.get(1)).isEmpty()) {
                C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5749m, 1);
                return true;
            }
            return false;
        }
        if (itemStack.getItem() instanceof InterfaceC1148uu) {
            if (((ItemStack) inventory.items.get(3)).isEmpty() || ((ItemStack) inventory.items.get(4)).isEmpty() || ((ItemStack) inventory.items.get(5)).isEmpty()) {
                C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5749m, 1);
                return true;
            }
            return false;
        }
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

    /* JADX INFO: renamed from: j */
    public C0881pt m5735j() {
        return (C0881pt) C1267xG.m7152a(this.f5599bI);
    }

    /* JADX INFO: renamed from: a */
    public void m5736a(@NotNull AbstractC0184c<?> abstractC0184c) {
        Iterator<UUID> it = m4245h().iterator();
        while (it.hasNext()) {
            C0875pn.m4401a(abstractC0184c, it.next(), m5735j());
        }
    }
}
