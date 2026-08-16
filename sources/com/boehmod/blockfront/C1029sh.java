package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sh.class */
public final class C1029sh extends AbstractC0866pe<C1027sf> {

    /* JADX INFO: renamed from: rP */
    private static final int f5621rP = 5;

    /* JADX INFO: renamed from: rQ */
    private static final int f5622rQ = 10;

    /* JADX INFO: renamed from: bs */
    @NotNull
    private final List<C0881pt> f5623bs;

    public C1029sh(@NotNull C1027sf c1027sf, @NotNull AbstractC0184c<?> abstractC0184c) {
        super(c1027sf, abstractC0184c);
        this.f5623bs = new ObjectArrayList();
        m4228b(new C0872pk(c1027sf, C1062tN.f5782dk, Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES)), Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT)), 10));
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0887pz mo4260a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0873pl c0873pl) {
        for (UUID uuid : set) {
            if (C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5766D) >= 30) {
                return new C0887pz(null, Collections.singleton(uuid));
            }
        }
        if (c0873pl != null && !c0873pl.m4333R()) {
            return null;
        }
        ObjectSortedSet<UUID> objectSortedSetM4388a = C0875pn.m4388a((AbstractC0863pb<?, ?, ?>) this.f4730g, 5, C1062tN.f5766D, set);
        if (objectSortedSetM4388a.isEmpty()) {
            return new C0887pz(null, null);
        }
        return new C0887pz(null, Collections.singleton((UUID) objectSortedSetM4388a.getFirst()));
    }

    @NotNull
    /* JADX INFO: renamed from: as */
    public List<C0881pt> m5754as() {
        return Collections.unmodifiableList(this.f5623bs);
    }

    /* JADX INFO: renamed from: d */
    public void m5755d(@NotNull C0881pt c0881pt) {
        this.f5623bs.add(c0881pt);
    }

    /* JADX INFO: renamed from: cV */
    public void m5756cV() {
        this.f5623bs.clear();
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: b */
    protected boolean mo4261b(@NotNull ServerPlayer serverPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public void mo4262a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C0872pk c0872pk) {
        C0875pn.m4402a(abstractC0184c, serverPlayer, m5757a(serverLevel));
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
    /* JADX INFO: renamed from: b */
    public void mo4266b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        if (serverPlayer2 == null || uuid2 == null || ((C1027sf) this.f4730g).mo3996a() != EnumC0871pj.GAME) {
            return;
        }
        C0872pk c0872pkA = m4229a(uuid2);
        if (c0872pkA != null && !serverPlayer2.getScoreboardName().equalsIgnoreCase(serverPlayer.getScoreboardName())) {
            c0872pkA.m4300a(C1062tN.f5748l, c0872pkA.m4302a(C1062tN.f5748l) + 1);
        }
        Iterator it = serverPlayer2.getInventory().items.iterator();
        while (it.hasNext()) {
            C0875pn.m4468b((ItemStack) it.next());
        }
        serverPlayer2.setHealth(serverPlayer2.getHealth() + 5.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public void mo4267a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        C0875pn.m4384a(abstractC0184c, serverLevel, serverPlayer);
        C0872pk c0872pkA = m4229a(uuid);
        C0875pn.m4402a(abstractC0184c, serverPlayer, m5757a(serverLevel));
        C0875pn.m4462f(serverPlayer);
        if (c0872pkA != null) {
            C0875pn.m4474a(serverLevel, serverPlayer, (AbstractC0863pb<?, ?, ?>) this.f4730g, c0872pkA);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0866pe
    /* JADX INFO: renamed from: a */
    public boolean mo4268a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        return !(entity instanceof Player) || !player.getScoreboardName().equalsIgnoreCase(((Player) entity).getScoreboardName()) || damageSource.is(DamageTypeTags.IS_EXPLOSION) || damageSource.is(DamageTypeTags.IS_FIRE);
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

    /* JADX INFO: renamed from: a */
    public C0881pt m5757a(@NotNull ServerLevel serverLevel) {
        C0881pt c0881ptMo3849d = null;
        int i = 50;
        ObjectArrayList<C0881pt> objectArrayList = new ObjectArrayList(this.f5623bs);
        Collections.shuffle(objectArrayList);
        while (c0881ptMo3849d == null) {
            for (C0881pt c0881pt : objectArrayList) {
                if (c0881pt.m4582a((Level) serverLevel, i) == null) {
                    c0881ptMo3849d = c0881pt.mo3849d();
                }
            }
            if (c0881ptMo3849d == null) {
                if (i > 0) {
                    i -= 5;
                } else {
                    c0881ptMo3849d = (C0881pt) objectArrayList.get(serverLevel.getRandom().nextInt(objectArrayList.size()));
                }
            }
        }
        return c0881ptMo3849d;
    }

    /* JADX INFO: renamed from: a */
    public C0881pt m5758a(Random random) {
        return this.f5623bs.get(random.nextInt(this.f5623bs.size()));
    }

    /* JADX INFO: renamed from: a */
    public void m5759a(@NotNull AbstractC0184c<?> abstractC0184c) {
        Set<UUID> setH = m4245h();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Iterator<UUID> it = setH.iterator();
        while (it.hasNext()) {
            C0875pn.m4401a(abstractC0184c, it.next(), m5758a(threadLocalRandomCurrent));
        }
    }
}
