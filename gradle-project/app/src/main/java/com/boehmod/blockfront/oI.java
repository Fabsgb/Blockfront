package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ChatGraphic;
import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.cloud.common.player.PunishmentType;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMPlayerLeft;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.oF;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oI.class */
public abstract class oI<G extends oF<G, ?, ?>> {
    private static final int mQ = 2400;
    private static final int mR = 600;
    private static final int mS = 120;
    private static final double aB = 256.0d;

    @NotNull
    private static final MutableComponent r;

    @NotNull
    protected final G g;

    @NotNull
    private final com.boehmod.blockfront.common.player.c<?> c;
    static final /* synthetic */ boolean gd;

    @NotNull
    private final oQ a = new oQ();

    @NotNull
    private final List<oO> au = new ObjectArrayList();

    @NotNull
    private final Set<UUID> i = new ObjectOpenHashSet();

    @NotNull
    private final Set<UUID> j = Collections.unmodifiableSet(this.i);

    @NotNull
    private final Set<UUID> k = new ObjectOpenHashSet();

    @NotNull
    private final Set<UUID> l = Collections.unmodifiableSet(this.k);

    @Nullable
    protected oX e = null;

    public abstract boolean a(@NotNull Player player, @NotNull Block block);

    public abstract boolean b(@NotNull Player player, @NotNull Block block);

    public abstract boolean a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull Player player, @NotNull Block block, @NotNull BlockPos blockPos);

    @Nullable
    public abstract C0409pd a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable oP oPVar);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    protected abstract boolean mo784a(@NotNull ServerPlayer serverPlayer);

    public abstract void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull oO oOVar);

    public abstract void d(@NotNull ServerPlayer serverPlayer);

    public abstract void b(@NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar);

    public abstract void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set);

    public abstract void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid);

    public abstract boolean a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, @Nullable Entity entity);

    public abstract boolean a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource);

    public abstract boolean bn();

    static {
        gd = !oI.class.desiredAssertionStatus();
        r = Component.translatable("bf.message.admin.settings.reset");
    }

    public oI(@NotNull G g, @NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        this.g = g;
        this.c = cVar;
    }

    @NotNull
    protected com.boehmod.blockfront.common.player.c<?> a() {
        return this.c;
    }

    public void a(@Nonnull Set<UUID> set) {
        UUID uuidG = this.a.g();
        if (uuidG != null && !set.contains(uuidG)) {
            this.a.g(uuidG);
        }
        Iterator<oO> it = this.au.iterator();
        while (it.hasNext()) {
            it.next().onUpdate();
        }
        b(set);
    }

    private void b(@NotNull Set<UUID> set) {
        ServerPlayer serverPlayerA;
        UUID uuidQ;
        Object2IntOpenHashMap object2IntOpenHashMap = new Object2IntOpenHashMap();
        Object2IntOpenHashMap object2IntOpenHashMap2 = new Object2IntOpenHashMap();
        Iterator<UUID> it = this.k.iterator();
        while (it.hasNext()) {
            UUID uuidQ2 = this.c.b(it.next()).q();
            if (uuidQ2 != null) {
                object2IntOpenHashMap.mergeInt(uuidQ2, 1, Integer::sum);
            }
        }
        if (this.g.bb()) {
            for (UUID uuid : set) {
                if (!this.k.contains(uuid) && (serverPlayerA = oR.a(uuid)) != null && serverPlayerA.isSpectator() && (uuidQ = this.c.b(uuid).q()) != null) {
                    object2IntOpenHashMap2.mergeInt(uuidQ, 1, Integer::sum);
                }
            }
        }
        for (UUID uuid2 : set) {
            this.c.b(uuid2).b(object2IntOpenHashMap.getInt(uuid2), object2IntOpenHashMap2.getInt(uuid2));
        }
    }

    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull sV sVVar, int i) {
        C0514ta c0514taA;
        C0411pf c0411pfA;
        oO oOVarA = a(uuid);
        if (oOVarA == null || (c0411pfA = (c0514taA = oOVarA.a((oF<?, ?, ?>) this.g)).a(sVVar, i)) == null) {
            return false;
        }
        MutableComponent mutableComponentA = a(abstractC0264ju, uuid, serverPlayer, oOVarA, sVVar, c0411pfA);
        if (mutableComponentA != null) {
            C0582vo.a(new C0608wn((Component) mutableComponentA), serverPlayer);
            return false;
        }
        oM oMVarA = this.g.a(uuid);
        String key = C0529tp.i.getKey();
        String key2 = C0529tp.j.getKey();
        boolean z = oMVarA.a(key, -1) == -1;
        int iA = oMVarA.a(key, -1);
        int iA2 = oMVarA.a(key2, 0);
        sV sVVarA = iA >= 0 ? sV.a(iA) : null;
        C0411pf c0411pfA2 = sVVarA != null ? c0514taA.a(sVVarA, iA2) : null;
        oMVarA.m787a(key, sVVar.bN());
        oMVarA.m787a(key2, i);
        if (z || (a(serverPlayer, uuid, 4.0d) && !oR.c(serverPlayer) && (c0411pfA2 == null || !oR.a(serverPlayer, c0411pfA2)))) {
            oMVarA.m787a(C0529tp.k.getKey(), sVVar.bN());
            oR.a(serverLevel, serverPlayer, c0411pfA);
            oR.a((Level) serverLevel, serverPlayer.position(), (SoundEvent) C0624xc.pT.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
            MutableComponent mutableComponentWithStyle = Component.translatable(sVVar.al()).withStyle(ChatFormatting.GRAY);
            if (i > 0) {
                mutableComponentWithStyle = mutableComponentWithStyle.append(" ").append(Component.translatable("enchantment.level." + (i + 1)).withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID));
            }
            if (!z) {
                oR.c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.class", new Object[]{mutableComponentWithStyle}).withColor(ColorReferences.COLOR_WHITE));
                return true;
            }
            return true;
        }
        oR.c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.class.respawn", new Object[]{Component.translatable(sVVar.al()).withStyle(ChatFormatting.GRAY)}).withColor(ColorReferences.COLOR_WHITE));
        return true;
    }

    @Nullable
    public MutableComponent a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull UUID uuid, @NotNull ServerPlayer serverPlayer, @NotNull oO oOVar, @NotNull sV sVVar, @NotNull C0411pf c0411pf) {
        sV sVVarA = null;
        int iA = this.g.a(uuid).a(C0529tp.i.getKey(), -1);
        if (iA != -1) {
            sVVarA = sV.a(iA);
        }
        G g = this.g;
        if (g instanceof qO) {
            qO qOVar = (qO) g;
            if (qOVar.by()) {
                int iA2 = qOVar.a(sVVar);
                if ((oR.a((oF<?, ?, ?>) this.g, sVVar, oOVar) >= iA2 && iA2 > 0) && sVVar != sVVarA) {
                    return Component.translatable("bf.message.gamemode.class.error.full", new Object[]{Component.literal(String.valueOf(iA2)).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED);
                }
            }
        }
        if (abstractC0264ju.f() && !serverPlayer.isCreative()) {
            G g2 = this.g;
            if (((g2 instanceof qO) && ((qO) g2).bA()) && !sVVar.a(this.c, serverPlayer)) {
                return Component.translatable("bf.message.gamemode.class.error.rank", new Object[]{Component.literal(sVVar.a().getTitle()).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED);
            }
        }
        if (abstractC0264ju.f()) {
            G g3 = this.g;
            boolean z = (g3 instanceof qO) && ((qO) g3).bz();
            int expForClass = this.c.a((Player) serverPlayer).getExpForClass(sVVar.bN());
            int iBl = c0411pf.bl();
            if (z && expForClass < iBl) {
                return Component.translatable("bf.message.gamemode.class.error.exp", new Object[]{Component.literal(C0637xp.a(iBl)).withStyle(ChatFormatting.GRAY), Component.literal(C0637xp.a(expForClass)).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED);
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oS oSVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull oO oOVar) {
        UUID uuid = serverPlayer.getUUID();
        com.boehmod.blockfront.common.player.b bVarM305a = this.c.m305a((Player) serverPlayer);
        abstractC0264ju.a(uuid, (oF<?, ?, ?>) this.g);
        this.i.add(uuid);
        bVarM305a.dy();
        bVarM305a.dz();
        serverPlayer.tickCount = 0;
        serverPlayer.getInventory().clearContent();
        serverPlayer.setGameMode(GameType.ADVENTURE);
        this.a.h(uuid);
        oR.a(this.c, serverLevel, serverPlayer);
        this.g.f270a.a(abstractC0264ju, this.c, oSVar, serverLevel, serverPlayer);
        if (!mo784a(serverPlayer) && this.g.m750a() == oN.GAME) {
            serverPlayer.setGameMode(GameType.SPECTATOR);
            bVarM305a.X(true);
            bVarM305a.I(a(serverPlayer));
        } else {
            G g = this.g;
            if (g instanceof InterfaceC0463rd) {
                oR.m792a((oF<?, ?, ?>) this.g, uuid, C0529tp.g, ((InterfaceC0463rd) g).bw());
            }
        }
        a(abstractC0264ju, this.c, serverLevel, serverPlayer, uuid, oOVar);
        bVarM305a.a(abstractC0264ju, serverLevel, true);
    }

    public int a(@NotNull ServerPlayer serverPlayer) {
        return 120;
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer) {
        com.boehmod.blockfront.common.player.b bVarM305a = abstractC0264ju.m531a().m305a((Player) serverPlayer);
        UUID uuid = serverPlayer.getUUID();
        bVarM305a.dy();
        bVarM305a.dz();
        this.g.c(uuid);
        oX oXVarC = c();
        if (oXVarC != null) {
            oR.a(this.c, serverPlayer, oXVarC);
        }
        serverPlayer.getInventory().clearContent();
        oM oMVarA = this.g.a(uuid);
        oMVarA.m787a(C0529tp.i.getKey(), -1);
        if (oMVarA.a(C0529tp.h.getKey()) > 600 && abstractC0264ju.g()) {
            oR.a(abstractC0264ju, (oF<?, ?, ?>) this.g, uuid, C0529tp.d, 1);
        }
        this.g.m758a().n(uuid);
        oR.a(abstractC0264ju, this.c, (oF<?, ?, ?>) this.g, h(), serverPlayer);
        if (abstractC0264ju.g()) {
            abstractC0264ju.m529b().sendPacket(new PacketMMPlayerLeft(uuid, this.g.m757e()));
        }
        d(serverPlayer);
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull String str, @NotNull UUID uuid, boolean z, @NotNull iS iSVar, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar) {
        if (this.k.contains(uuid)) {
            a(serverPlayer, bVar);
            return;
        }
        oM oMVarA = this.g.a(uuid);
        serverPlayer.getFoodData().setFoodLevel(20);
        G g = this.g;
        if (g instanceof qV) {
            a(serverPlayer, oMVarA, (qV) g);
        }
        if (this.g.m750a() == oN.GAME) {
            int i = bVar.tc;
            bVar.tc = i + 1;
            if (i >= 2400) {
                bVar.tc = 0;
                String key = C0529tp.h.getKey();
                oMVarA.m787a(key, oMVarA.a(key) + 2400);
            }
        }
        if (this.g instanceof InterfaceC0463rd) {
            String key2 = C0529tp.g.getKey();
            int iA = oMVarA.a(key2);
            if (iA > 0) {
                oMVarA.m787a(key2, iA - 1);
            }
            if (iA < 120.0d) {
                Vec3 vec3Position = serverPlayer.position();
                if (serverPlayer.tickCount >= 20 && (serverPlayer.xOld != vec3Position.x || serverPlayer.zOld != vec3Position.z || serverPlayer.isCrouching() || vec3Position.y > serverPlayer.yOld)) {
                    oMVarA.m787a(key2, 0);
                }
            }
        }
        String key3 = C0529tp.y.getKey();
        int iA2 = oMVarA.a(key3);
        if (iA2 > 0) {
            oMVarA.m787a(key3, iA2 - 1);
        }
        if (this.g instanceof InterfaceC0466rg) {
            String key4 = C0529tp.z.getKey();
            int iA3 = oMVarA.a(key4);
            if (iA3 > 0) {
                oMVarA.m787a(key4, iA3 - 1);
            }
            String key5 = C0529tp.A.getKey();
            int iA4 = oMVarA.a(key5);
            if (iA4 > 0) {
                oMVarA.m787a(key5, iA4 - 1);
            }
        }
        if (!bVar.dl()) {
            a(abstractC0264ju, serverLevel, serverPlayer, bVar);
            if (this.g.bb() && serverPlayer.isSpectator()) {
                a(serverPlayer, bVar);
            } else if (!bVar.dk() && (bVar.q() != null || bVar.m() != null)) {
                bVar.p(null);
                bVar.f(null);
            }
        }
        b(serverPlayer, bVar);
        if (z) {
            a(serverPlayer, str, bVar, iSVar);
        }
    }

    private void a(@NotNull ServerPlayer serverPlayer, @NotNull String str, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar, @NotNull iS iSVar) {
        int i = iSVar.jP;
        iSVar.jP = i + 1;
        if (i < 40) {
            return;
        }
        iSVar.jP = 0;
        if (iSVar.hasActivePunishment(PunishmentType.BAN_MM) || iSVar.hasActivePunishment(PunishmentType.BAN_CLOUD)) {
            oR.a(ChatGraphic.ANTI_CHEAT, this.g.b().h(), (Component) Component.translatable("bf.cloud.notification.suspended", new Object[]{Component.literal(str).withStyle(ChatFormatting.GRAY), C0002a.a}).withStyle(ChatFormatting.RED));
            oR.b(serverPlayer, (Component) Component.translatable("bf.message.disconnect.punishment"));
        }
        bVar.ab(iSVar.hasActivePunishment(PunishmentType.MUTE));
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar) {
        if (!bVar.dk()) {
            serverPlayer.setInvisible(false);
            return;
        }
        serverPlayer.tickCount = 0;
        serverPlayer.setInvisible(true);
        if (bVar.cs() > 0) {
            if (this.g.f(serverPlayer)) {
                bVar.J(1);
                if (bVar.cs() == 20) {
                    oR.a(serverPlayer, (SoundEvent) C0624xc.pJ.get(), SoundSource.MUSIC, 2.0f);
                    return;
                }
                return;
            }
            return;
        }
        oR.a(abstractC0264ju, this.c, serverLevel, serverPlayer);
    }

    private void a(@NotNull ServerPlayer serverPlayer, @NotNull oM oMVar, @NotNull qV qVVar) {
        if (qVVar.i(serverPlayer)) {
            String key = C0529tp.r.getKey();
            int iA = oMVar.a(key);
            if (iA <= 0) {
                oMVar.m787a(key, qVVar.mo922a((Player) serverPlayer));
                serverPlayer.heal(qVVar.a((Player) serverPlayer));
            } else {
                oMVar.m787a(key, iA - 1);
            }
        }
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        oO oOVarA;
        oO oOVarA2 = a(uuid);
        if (oOVarA2 != null) {
            oOVarA2.a(C0529tp.L, oOVarA2.m790a(C0529tp.L, 0) + 1);
        }
        if (uuid2 != null && (oOVarA = a(uuid2)) != null) {
            oOVarA.a(C0529tp.D, oOVarA.m790a(C0529tp.D, 0) + 1);
        }
        b(abstractC0264ju, serverLevel, serverPlayer, uuid, serverPlayer2, uuid2, damageSource, set);
    }

    public int aX() {
        int iAX = 0;
        Iterator<oO> it = this.au.iterator();
        while (it.hasNext()) {
            iAX += it.next().aX();
        }
        return iAX;
    }

    public boolean f(@NotNull UUID uuid) {
        return this.i.contains(uuid);
    }

    public List<ItemEntity> a(@NotNull Player player, @NotNull List<ItemEntity> list) {
        return list;
    }

    public boolean a(@NotNull Player player, @NotNull ItemStack itemStack) {
        return false;
    }

    public boolean a(@NotNull Player player, @NotNull ItemEntity itemEntity, @NotNull ItemStack itemStack) {
        return true;
    }

    public boolean a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull Player player, @NotNull UUID uuid, @NotNull Block block, @NotNull BlockPos blockPos) {
        return (block instanceof DoorBlock) || (block instanceof ButtonBlock) || (block instanceof LeverBlock) || (block instanceof FenceGateBlock) || (block instanceof TrapDoorBlock) || (block instanceof C0294kx) || (block instanceof kO) || (block instanceof C0308lk);
    }

    @Nullable
    public oX c() {
        return this.e;
    }

    public void a(@NotNull oX oXVar) {
        this.e = oXVar;
    }

    public void b(@NotNull oO oOVar) {
        this.au.add(oOVar);
    }

    @Nullable
    public oO a(@NotNull UUID uuid) {
        for (oO oOVar : this.au) {
            if (oOVar.i(uuid)) {
                return oOVar;
            }
        }
        return null;
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        abstractC0264ju.m533a(uuid);
        this.i.remove(uuid);
        this.a.g(uuid);
        this.au.forEach(oOVar -> {
            oOVar.f(uuid);
        });
        oR.b(this.c, serverPlayer);
        oR.a(abstractC0264ju, this.c, serverLevel, serverPlayer);
        a(abstractC0264ju, serverPlayer);
        C0582vo.a(new C0609wo(null, false), serverPlayer);
        cq();
    }

    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        abstractC0264ju.a(uuid, (oF<?, ?, ?>) this.g);
        this.k.add(uuid);
        serverPlayer.tickCount = 0;
        serverPlayer.getInventory().clearContent();
        oR.a(this.c, serverLevel, serverPlayer);
        serverPlayer.setGameMode(GameType.SPECTATOR);
        serverPlayer.setInvisible(true);
        oX oXVarC = c();
        if (oXVarC != null) {
            oR.a(this.c, serverPlayer, oXVarC);
        }
    }

    public void c(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        abstractC0264ju.m533a(uuid);
        this.k.remove(uuid);
        this.c.m305a((Player) serverPlayer).p(null);
        this.g.c(uuid);
        serverPlayer.setCamera(serverPlayer);
        serverPlayer.setInvisible(false);
        oR.a(this.c, serverLevel, serverPlayer);
        oX oXVarC = c();
        if (oXVarC != null) {
            oR.a(this.c, serverPlayer, oXVarC);
        }
        C0582vo.a(new C0609wo(null, false), serverPlayer);
    }

    private void a(@NotNull ServerPlayer serverPlayer, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar) {
        ServerPlayer serverPlayerA;
        UUID uuid = serverPlayer.getUUID();
        boolean zContains = this.k.contains(uuid);
        serverPlayer.setInvisible(true);
        if (zContains && !serverPlayer.isSpectator()) {
            serverPlayer.setGameMode(GameType.SPECTATOR);
        }
        List<UUID> listA = a(uuid, zContains);
        UUID uuidQ = bVar.q();
        if ((uuidQ == null || !listA.contains(uuidQ)) && (uuidQ == null || !a(uuid, uuidQ, zContains))) {
            uuidQ = listA.isEmpty() ? null : (UUID) listA.getFirst();
            bVar.p(uuidQ);
        }
        if (uuidQ == null) {
            oX oXVarM = bVar.m();
            if (oXVarM == null) {
                bVar.f(new oX((Player) serverPlayer));
                return;
            } else {
                if (serverPlayer.distanceToSqr(oXVarM.c) > aB) {
                    oR.a(this.c, serverPlayer, oXVarM);
                    return;
                }
                return;
            }
        }
        bVar.f(null);
        if (zContains && (serverPlayerA = oR.a(uuidQ)) != null && serverPlayer.distanceToSqr(serverPlayerA) > aB) {
            oR.a(this.c, serverPlayer, new oX((Player) serverPlayerA));
        }
    }

    @NotNull
    private List<UUID> a(@NotNull UUID uuid, boolean z) {
        oU oUVarMo753a = this.g.mo753a();
        if (oUVarMo753a == oU.NONE) {
            return Collections.emptyList();
        }
        oO oOVarA = z ? null : a(uuid);
        boolean z2 = oUVarMo753a == oU.SAME_TEAM && oOVarA != null;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (UUID uuid2 : k()) {
            if (!uuid2.equals(uuid) && (!z2 || oOVarA.i(uuid2))) {
                if (oR.a(uuid2) != null) {
                    objectArrayList.add(uuid2);
                }
            }
        }
        objectArrayList.sort((v0, v1) -> {
            return v0.compareTo(v1);
        });
        return objectArrayList;
    }

    private boolean a(@NotNull UUID uuid, @NotNull UUID uuid2, boolean z) {
        oU oUVarMo753a = this.g.mo753a();
        if (oUVarMo753a == oU.NONE || !f(uuid2) || oR.a(uuid2) == null) {
            return false;
        }
        oO oOVarA = z ? null : a(uuid);
        if (oUVarMo753a == oU.SAME_TEAM && oOVarA != null) {
            return oOVarA.i(uuid2);
        }
        return true;
    }

    public void a(@NotNull ServerPlayer serverPlayer, int i) {
        UUID uuid = serverPlayer.getUUID();
        boolean zContains = this.k.contains(uuid);
        com.boehmod.blockfront.common.player.b bVarM305a = this.c.m305a((Player) serverPlayer);
        if (zContains || (serverPlayer.isSpectator() && this.g.bb())) {
            List<UUID> listA = a(uuid, zContains);
            if (listA.isEmpty()) {
                return;
            }
            UUID uuidQ = bVarM305a.q();
            bVarM305a.p(listA.get(Math.floorMod((uuidQ == null ? -1 : listA.indexOf(uuidQ)) + i, listA.size())));
        }
    }

    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer) {
        if (this.k.contains(serverPlayer.getUUID())) {
            this.g.a(abstractC0264ju, serverPlayer.serverLevel(), serverPlayer);
        }
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull Component component) {
        if (this.k.isEmpty()) {
            return;
        }
        ObjectListIterator it = new ObjectArrayList(this.k).iterator();
        while (it.hasNext()) {
            UUID uuid = (UUID) it.next();
            ServerPlayer serverPlayerA = oR.a(uuid);
            if (serverPlayerA == null) {
                this.k.remove(uuid);
            } else {
                c(abstractC0264ju, serverPlayerA.serverLevel(), serverPlayerA);
                oR.a(uuid, component);
            }
        }
    }

    private void cq() {
        MatchSettings matchSettingsM766a = this.g.m766a();
        if (matchSettingsM766a.isDefault()) {
            return;
        }
        Iterator<UUID> it = h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerA = oR.a(it.next());
            if (serverPlayerA != null && this.c.a((Player) serverPlayerA).j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN)) {
                return;
            }
        }
        matchSettingsM766a.reset();
        oR.a(j(), oR.iN, (Component) r);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m781a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oS oSVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull oO oOVar) {
        String scoreboardName = serverPlayer.getScoreboardName();
        C0263jt.log("Attempting to add player %s to team %s...", scoreboardName, oOVar.getName());
        if (oOVar.b(serverPlayer)) {
            C0263jt.log("Successfully added player %s to team %s!", scoreboardName, oOVar.getName());
            a(abstractC0264ju, oSVar, serverLevel, serverPlayer, oOVar);
            return true;
        }
        C0263jt.log("Failed to add player %s to team %s!", scoreboardName, oOVar.getName());
        return false;
    }

    @Nullable
    public oO b() {
        oO oOVarA = a(C0529tp.cZ);
        oO oOVarA2 = a(C0529tp.da);
        if (!gd && oOVarA2 == null) {
            throw new AssertionError();
        }
        if (!gd && oOVarA == null) {
            throw new AssertionError();
        }
        Set<UUID> setH = oOVarA2.h();
        Set<UUID> setH2 = oOVarA.h();
        return (setH.isEmpty() && setH2.isEmpty()) ? ThreadLocalRandom.current().nextBoolean() ? oOVarA2 : oOVarA : setH.size() < setH2.size() ? oOVarA2 : oOVarA;
    }

    @Nullable
    public oO a(@NotNull String str) {
        for (oO oOVar : this.au) {
            if (oOVar.getName().equalsIgnoreCase(str)) {
                return oOVar;
            }
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public G m782a() {
        return this.g;
    }

    @NotNull
    public List<oO> A() {
        return Collections.unmodifiableList(this.au);
    }

    @NotNull
    public Set<UUID> h() {
        return this.j;
    }

    @NotNull
    public Set<UUID> i() {
        return this.l;
    }

    public boolean g(@NotNull UUID uuid) {
        return this.k.contains(uuid);
    }

    @NotNull
    public Set<UUID> j() {
        if (this.k.isEmpty()) {
            return this.j;
        }
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet(this.i.size() + this.k.size());
        objectOpenHashSet.addAll(this.i);
        objectOpenHashSet.addAll(this.k);
        return objectOpenHashSet;
    }

    @NotNull
    public Set<UUID> a(@NotNull oO oOVar, @NotNull oT oTVar) {
        Set<UUID> setH = oOVar.h();
        if (oTVar == oT.PLAYERS_ONLY) {
            return setH;
        }
        if (this.k.isEmpty()) {
            return oTVar == oT.ALL ? setH : Collections.emptySet();
        }
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet(setH.size() + this.k.size());
        if (oTVar == oT.ALL) {
            objectOpenHashSet.addAll(setH);
        }
        for (UUID uuid : this.k) {
            UUID uuidQ = this.c.b(uuid).q();
            if (uuidQ != null && setH.contains(uuidQ)) {
                objectOpenHashSet.add(uuid);
            }
        }
        return objectOpenHashSet;
    }

    @NotNull
    public Set<UUID> k() {
        Set<UUID> setH = h();
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet(setH.size());
        for (UUID uuid : setH) {
            ServerPlayer serverPlayerA = oR.a(uuid);
            com.boehmod.blockfront.common.player.b bVarB = this.c.b(uuid);
            if (serverPlayerA != null && !oR.a((Player) serverPlayerA, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) bVarB)) {
                objectOpenHashSet.add(uuid);
            }
        }
        return objectOpenHashSet;
    }

    public void e(@NotNull UUID uuid) {
        G g = this.g;
        if ((g instanceof InterfaceC0463rd) && ((InterfaceC0463rd) g).k(uuid)) {
            oR.m792a((oF<?, ?, ?>) this.g, uuid, C0529tp.g, 0);
        }
    }

    public boolean a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, double d) {
        oO oOVarA = a(uuid);
        if (oOVarA == null) {
            return false;
        }
        Iterator<oX> it = oOVarA.B().iterator();
        while (it.hasNext()) {
            if (Mth.sqrt((float) serverPlayer.distanceToSqr(it.next().c)) <= d) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public oQ m783a() {
        return this.a;
    }

    @OverridingMethodsMustInvokeSuper
    public void bf() {
        this.a.bf();
        this.i.clear();
        this.k.clear();
        for (oO oOVar : this.au) {
            oOVar.cs();
            oOVar.cr();
        }
    }

    @OverridingMethodsMustInvokeSuper
    protected void h(@NotNull ByteBuf byteBuf) throws IOException {
        this.a.c(byteBuf);
        Iterator<oO> it = this.au.iterator();
        while (it.hasNext()) {
            it.next().i(byteBuf);
        }
        byteBuf.writeInt(this.k.size());
        Iterator<UUID> it2 = this.k.iterator();
        while (it2.hasNext()) {
            IPacket.writeUUID(byteBuf, it2.next());
        }
    }

    @OverridingMethodsMustInvokeSuper
    protected void g(@NotNull ByteBuf byteBuf) throws IOException {
        this.a.b(byteBuf);
        Iterator<oO> it = this.au.iterator();
        while (it.hasNext()) {
            it.next().j(byteBuf);
        }
        this.i.clear();
        Iterator<oO> it2 = this.au.iterator();
        while (it2.hasNext()) {
            this.i.addAll(it2.next().h());
        }
        this.k.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.k.add(IPacket.readUUID(byteBuf));
        }
    }

    public boolean a(@NotNull ServerPlayer serverPlayer, @NotNull DamageSource damageSource) {
        return false;
    }
}
