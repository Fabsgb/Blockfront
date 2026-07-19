package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rK.class */
public final class rK extends oI<rI> {
    private static final int pO = 5;
    private static final int pP = 10;

    @NotNull
    private final List<oX> bl;

    public rK(@NotNull rI rIVar, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        super(rIVar, cVar);
        this.bl = new ObjectArrayList();
        b(new oO(rIVar, C0529tp.cZ, Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES)), Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES_CHAT)), 10));
    }

    @Override // com.boehmod.blockfront.oI
    @Nullable
    public C0409pd a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable oP oPVar) {
        for (UUID uuid : set) {
            if (oR.a((oF<?, ?, ?>) this.g, uuid, C0529tp.D) >= 30) {
                return new C0409pd(null, Collections.singleton(uuid));
            }
        }
        if (oPVar != null && !oPVar.P()) {
            return null;
        }
        ObjectSortedSet<UUID> objectSortedSetA = oR.a((oF<?, ?, ?>) this.g, 5, C0529tp.D, set);
        if (objectSortedSetA.isEmpty()) {
            return new C0409pd(null, null);
        }
        return new C0409pd(null, Collections.singleton((UUID) objectSortedSetA.getFirst()));
    }

    @NotNull
    public List<oX> aq() {
        return Collections.unmodifiableList(this.bl);
    }

    public void d(@NotNull oX oXVar) {
        this.bl.add(oXVar);
    }

    public void cJ() {
        this.bl.clear();
    }

    @Override // com.boehmod.blockfront.oI
    /* JADX INFO: renamed from: a */
    protected boolean mo784a(@NotNull ServerPlayer serverPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.oI
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull oO oOVar) {
        oR.a(cVar, serverPlayer, a(serverLevel));
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
    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        if (serverPlayer2 == null || uuid2 == null || ((rI) this.g).a() != oN.GAME) {
            return;
        }
        oO oOVarA = a(uuid2);
        if (oOVarA != null && !serverPlayer2.getScoreboardName().equalsIgnoreCase(serverPlayer.getScoreboardName())) {
            oOVarA.a(C0529tp.l, oOVarA.a(C0529tp.l) + 1);
        }
        Iterator it = serverPlayer2.getInventory().items.iterator();
        while (it.hasNext()) {
            oR.b((ItemStack) it.next());
        }
        serverPlayer2.setHealth(serverPlayer2.getHealth() + 5.0f);
    }

    @Override // com.boehmod.blockfront.oI
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        oR.a(cVar, serverLevel, serverPlayer);
        oO oOVarA = a(uuid);
        oR.a(cVar, serverPlayer, a(serverLevel));
        oR.f(serverPlayer);
        if (oOVarA != null) {
            oR.a(serverLevel, serverPlayer, (oF<?, ?, ?>) this.g, oOVarA);
        }
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, Entity entity) {
        return !(entity instanceof Player) || !player.getScoreboardName().equalsIgnoreCase(((Player) entity).getScoreboardName()) || damageSource.is(DamageTypeTags.IS_EXPLOSION) || damageSource.is(DamageTypeTags.IS_FIRE);
    }

    @Override // com.boehmod.blockfront.oI
    public boolean a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource) {
        return true;
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

    public oX a(@NotNull ServerLevel serverLevel) {
        oX oXVarD = null;
        int i = 50;
        ObjectArrayList<oX> objectArrayList = new ObjectArrayList(this.bl);
        Collections.shuffle(objectArrayList);
        while (oXVarD == null) {
            for (oX oXVar : objectArrayList) {
                if (oXVar.m806a((Level) serverLevel, i) == null) {
                    oXVarD = oXVar.d();
                }
            }
            if (oXVarD == null) {
                if (i > 0) {
                    i -= 5;
                } else {
                    oXVarD = (oX) objectArrayList.get(serverLevel.getRandom().nextInt(objectArrayList.size()));
                }
            }
        }
        return oXVarD;
    }

    public oX a(Random random) {
        return this.bl.get(random.nextInt(this.bl.size()));
    }

    public void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        Set<UUID> setH = h();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Iterator<UUID> it = setH.iterator();
        while (it.hasNext()) {
            oR.a(cVar, it.next(), a(threadLocalRandomCurrent));
        }
    }
}
