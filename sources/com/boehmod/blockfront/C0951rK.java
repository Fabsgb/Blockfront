package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.rK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rK.class */
public final class C0951rK extends AbstractC0790oI<C0949rI> {

    /* JADX INFO: renamed from: pO */
    private static final int f5044pO = 5;

    /* JADX INFO: renamed from: pP */
    private static final int f5045pP = 10;

    /* JADX INFO: renamed from: bl */
    @NotNull
    private final List<C0805oX> f5046bl;

    public C0951rK(@NotNull C0949rI c0949rI, @NotNull AbstractC0183c<?> abstractC0183c) {
        super(c0949rI, abstractC0183c);
        this.f5046bl = new ObjectArrayList();
        m3792b(new C0796oO(c0949rI, C1089tp.f5729cZ, Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES)), Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT)), 10));
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0864pd mo3824a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0797oP c0797oP) {
        for (UUID uuid : set) {
            if (C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this.f4335g, uuid, C1089tp.f5713D) >= 30) {
                return new C0864pd(null, Collections.singleton(uuid));
            }
        }
        if (c0797oP != null && !c0797oP.m3897P()) {
            return null;
        }
        ObjectSortedSet<UUID> objectSortedSetM3952a = C0799oR.m3952a((AbstractC0787oF<?, ?, ?>) this.f4335g, 5, C1089tp.f5713D, set);
        if (objectSortedSetM3952a.isEmpty()) {
            return new C0864pd(null, null);
        }
        return new C0864pd(null, Collections.singleton((UUID) objectSortedSetM3952a.getFirst()));
    }

    @NotNull
    /* JADX INFO: renamed from: aq */
    public List<C0805oX> m5216aq() {
        return Collections.unmodifiableList(this.f5046bl);
    }

    /* JADX INFO: renamed from: d */
    public void m5217d(@NotNull C0805oX c0805oX) {
        this.f5046bl.add(c0805oX);
    }

    /* JADX INFO: renamed from: cJ */
    public void m5218cJ() {
        this.f5046bl.clear();
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    protected boolean mo3825a(@NotNull ServerPlayer serverPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public void mo3826a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C0796oO c0796oO) {
        C0799oR.m3966a(abstractC0183c, serverPlayer, m5219a(serverLevel));
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
    /* JADX INFO: renamed from: b */
    public void mo3830b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        if (serverPlayer2 == null || uuid2 == null || ((C0949rI) this.f4335g).mo3560a() != EnumC0795oN.GAME) {
            return;
        }
        C0796oO c0796oOA = m3793a(uuid2);
        if (c0796oOA != null && !serverPlayer2.getScoreboardName().equalsIgnoreCase(serverPlayer.getScoreboardName())) {
            c0796oOA.m3864a(C1089tp.f5695l, c0796oOA.m3866a(C1089tp.f5695l) + 1);
        }
        Iterator it = serverPlayer2.getInventory().items.iterator();
        while (it.hasNext()) {
            C0799oR.m4032b((ItemStack) it.next());
        }
        serverPlayer2.setHealth(serverPlayer2.getHealth() + 5.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public void mo3831a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        C0799oR.m3948a(abstractC0183c, serverLevel, serverPlayer);
        C0796oO c0796oOA = m3793a(uuid);
        C0799oR.m3966a(abstractC0183c, serverPlayer, m5219a(serverLevel));
        C0799oR.m4026f(serverPlayer);
        if (c0796oOA != null) {
            C0799oR.m4038a(serverLevel, serverPlayer, (AbstractC0787oF<?, ?, ?>) this.f4335g, c0796oOA);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0790oI
    /* JADX INFO: renamed from: a */
    public boolean mo3832a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        return !(entity instanceof Player) || !player.getScoreboardName().equalsIgnoreCase(((Player) entity).getScoreboardName()) || damageSource.is(DamageTypeTags.IS_EXPLOSION) || damageSource.is(DamageTypeTags.IS_FIRE);
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

    /* JADX INFO: renamed from: a */
    public C0805oX m5219a(@NotNull ServerLevel serverLevel) {
        C0805oX c0805oXMo4124d = null;
        int i = 50;
        ObjectArrayList<C0805oX> objectArrayList = new ObjectArrayList(this.f5046bl);
        Collections.shuffle(objectArrayList);
        while (c0805oXMo4124d == null) {
            for (C0805oX c0805oX : objectArrayList) {
                if (c0805oX.m4145a((Level) serverLevel, i) == null) {
                    c0805oXMo4124d = c0805oX.mo4124d();
                }
            }
            if (c0805oXMo4124d == null) {
                if (i > 0) {
                    i -= 5;
                } else {
                    c0805oXMo4124d = (C0805oX) objectArrayList.get(serverLevel.getRandom().nextInt(objectArrayList.size()));
                }
            }
        }
        return c0805oXMo4124d;
    }

    /* JADX INFO: renamed from: a */
    public C0805oX m5220a(Random random) {
        return this.f5046bl.get(random.nextInt(this.f5046bl.size()));
    }

    /* JADX INFO: renamed from: a */
    public void m5221a(@NotNull AbstractC0183c<?> abstractC0183c) {
        Set<UUID> setH = m3809h();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Iterator<UUID> it = setH.iterator();
        while (it.hasNext()) {
            C0799oR.m3965a(abstractC0183c, it.next(), m5220a(threadLocalRandomCurrent));
        }
    }
}
