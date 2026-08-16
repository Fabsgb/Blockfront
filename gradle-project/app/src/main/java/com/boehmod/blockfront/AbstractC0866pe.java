package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ChatGraphic;
import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.cloud.common.player.PunishmentType;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMPlayerLeft;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.pe */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pe.class */
public abstract class AbstractC0866pe<G extends AbstractC0863pb<G, ?, ?>> {

    /* JADX INFO: renamed from: oO */
    private static final int f4724oO = 2400;

    /* JADX INFO: renamed from: oP */
    private static final int f4725oP = 600;

    /* JADX INFO: renamed from: oQ */
    private static final int f4726oQ = 120;

    /* JADX INFO: renamed from: aO */
    private static final double f4727aO = 256.0d;

    /* JADX INFO: renamed from: r */
    @NotNull
    private static final MutableComponent f4728r;

    /* JADX INFO: renamed from: g */
    @NotNull
    protected final G f4730g;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final AbstractC0184c<?> f4737c;

    /* JADX INFO: renamed from: gx */
    static final /* synthetic */ boolean f4738gx;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0874pm f4729a = new C0874pm();

    /* JADX INFO: renamed from: aB */
    @NotNull
    private final List<C0872pk> f4731aB = new ObjectArrayList();

    /* JADX INFO: renamed from: j */
    @NotNull
    private final Set<UUID> f4732j = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: k */
    @NotNull
    private final Set<UUID> f4733k = Collections.unmodifiableSet(this.f4732j);

    /* JADX INFO: renamed from: l */
    @NotNull
    private final Set<UUID> f4734l = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: m */
    @NotNull
    private final Set<UUID> f4735m = Collections.unmodifiableSet(this.f4734l);

    /* JADX INFO: renamed from: e */
    @Nullable
    protected C0881pt f4736e = null;

    /* JADX INFO: renamed from: a */
    public abstract boolean mo4257a(@NotNull Player player, @NotNull Block block);

    /* JADX INFO: renamed from: b */
    public abstract boolean mo4258b(@NotNull Player player, @NotNull Block block);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo4259a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull Player player, @NotNull Block block, @NotNull BlockPos blockPos);

    @Nullable
    /* JADX INFO: renamed from: a */
    public abstract C0887pz mo4260a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0873pl c0873pl);

    /* JADX INFO: renamed from: b */
    protected abstract boolean mo4261b(@NotNull ServerPlayer serverPlayer);

    /* JADX INFO: renamed from: a */
    public abstract void mo4262a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C0872pk c0872pk);

    /* JADX INFO: renamed from: d */
    public abstract void mo4263d(@NotNull ServerPlayer serverPlayer);

    /* JADX INFO: renamed from: b */
    public abstract void mo4264b(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b);

    /* JADX INFO: renamed from: b */
    public abstract void mo4266b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set);

    /* JADX INFO: renamed from: a */
    public abstract void mo4267a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo4268a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, @Nullable Entity entity);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo4269a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource);

    /* JADX INFO: renamed from: bx */
    public abstract boolean mo4270bx();

    static {
        f4738gx = !AbstractC0866pe.class.desiredAssertionStatus();
        f4728r = Component.translatable("bf.message.admin.settings.reset");
    }

    public AbstractC0866pe(@NotNull G g, @NotNull AbstractC0184c<?> abstractC0184c) {
        this.f4730g = g;
        this.f4737c = abstractC0184c;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected AbstractC0184c<?> m4207a() {
        return this.f4737c;
    }

    /* JADX INFO: renamed from: a */
    public void m4208a(@Nonnull Set<UUID> set) {
        UUID uuidM4342g = this.f4729a.m4342g();
        if (uuidM4342g != null && !set.contains(uuidM4342g)) {
            this.f4729a.m4345g(uuidM4342g);
        }
        Iterator<C0872pk> it = this.f4731aB.iterator();
        while (it.hasNext()) {
            it.next().onUpdate();
        }
        m4209b(set);
    }

    /* JADX INFO: renamed from: b */
    private void m4209b(@NotNull Set<UUID> set) {
        ServerPlayer serverPlayerM4399a;
        UUID uuidM1116r;
        Object2IntOpenHashMap object2IntOpenHashMap = new Object2IntOpenHashMap();
        Object2IntOpenHashMap object2IntOpenHashMap2 = new Object2IntOpenHashMap();
        Iterator<UUID> it = this.f4734l.iterator();
        while (it.hasNext()) {
            UUID uuidM1116r2 = this.f4737c.m1152b(it.next()).m1116r();
            if (uuidM1116r2 != null) {
                object2IntOpenHashMap.mergeInt(uuidM1116r2, 1, Integer::sum);
            }
        }
        if (this.f4730g.mo4047bl()) {
            for (UUID uuid : set) {
                if (!this.f4734l.contains(uuid) && (serverPlayerM4399a = C0875pn.m4399a(uuid)) != null && serverPlayerM4399a.isSpectator() && (uuidM1116r = this.f4737c.m1152b(uuid).m1116r()) != null) {
                    object2IntOpenHashMap2.mergeInt(uuidM1116r, 1, Integer::sum);
                }
            }
        }
        for (UUID uuid2 : set) {
            this.f4737c.m1152b(uuid2).m1122b(object2IntOpenHashMap.getInt(uuid2), object2IntOpenHashMap2.getInt(uuid2));
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m4210a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C1093ts c1093ts, int i) {
        C1098tx c1098txM4296a;
        C0837pB c0837pBM6184a;
        C0872pk c0872pkM4229a = m4229a(uuid);
        if (c0872pkM4229a == null || (c0837pBM6184a = (c1098txM4296a = c0872pkM4229a.m4296a((AbstractC0863pb<?, ?, ?>) this.f4730g)).m6184a(c1093ts, i)) == null) {
            return false;
        }
        MutableComponent mutableComponentM4211a = m4211a(abstractC0531jN, uuid, serverPlayer, c0872pkM4229a, c1093ts, c0837pBM6184a);
        if (mutableComponentM4211a != null) {
            C1169vO.m6643a(new C1219wL((Component) mutableComponentM4211a), serverPlayer);
            return false;
        }
        C0870pi c0870piM4034a = this.f4730g.m4034a(uuid);
        String key = C1062tN.f5745i.getKey();
        String key2 = C1062tN.f5746j.getKey();
        boolean z = c0870piM4034a.m4290a(key, -1) == -1;
        int iM4290a = c0870piM4034a.m4290a(key, -1);
        int iM4290a2 = c0870piM4034a.m4290a(key2, 0);
        C1093ts c1093tsM6016a = iM4290a >= 0 ? C1093ts.m6016a(iM4290a) : null;
        C0837pB c0837pBM6184a2 = c1093tsM6016a != null ? c1098txM4296a.m6184a(c1093tsM6016a, iM4290a2) : null;
        c0870piM4034a.m4291a(key, c1093ts.m6011cc());
        c0870piM4034a.m4291a(key2, i);
        if (z || (m4252a(serverPlayer, uuid, 4.0d) && !C0875pn.m4471d(serverPlayer) && (c0837pBM6184a2 == null || !C0875pn.m4472a(serverPlayer, c0837pBM6184a2)))) {
            c0870piM4034a.m4291a(C1062tN.f5747k.getKey(), c1093ts.m6011cc());
            C0875pn.m4457a(serverLevel, serverPlayer, c0837pBM6184a);
            C0875pn.m4377a((Level) serverLevel, serverPlayer.position(), (SoundEvent) C1312xz.f8000pV.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
            MutableComponent mutableComponentWithStyle = Component.translatable(c1093ts.m6004as()).withStyle(ChatFormatting.GRAY);
            if (i > 0) {
                mutableComponentWithStyle = mutableComponentWithStyle.append(" ").append(Component.translatable("enchantment.level." + (i + 1)).withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID));
            }
            if (!z) {
                C0875pn.m4406c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.class", new Object[]{mutableComponentWithStyle}).withColor(ColorReferences.COLOR_WHITE));
                return true;
            }
            return true;
        }
        C0875pn.m4406c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.class.respawn", new Object[]{Component.translatable(c1093ts.m6004as()).withStyle(ChatFormatting.GRAY)}).withColor(ColorReferences.COLOR_WHITE));
        return true;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public MutableComponent m4211a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull UUID uuid, @NotNull ServerPlayer serverPlayer, @NotNull C0872pk c0872pk, @NotNull C1093ts c1093ts, @NotNull C0837pB c0837pB) {
        C1093ts c1093tsM6016a = null;
        int iM4290a = this.f4730g.m4034a(uuid).m4290a(C1062tN.f5745i.getKey(), -1);
        if (iM4290a != -1) {
            c1093tsM6016a = C1093ts.m6016a(iM4290a);
        }
        G g = this.f4730g;
        if (g instanceof InterfaceC0979rl) {
            InterfaceC0979rl interfaceC0979rl = (InterfaceC0979rl) g;
            if (interfaceC0979rl.mo5343bI()) {
                int iMo5347a = interfaceC0979rl.mo5347a(c1093ts);
                if ((C0875pn.m4466a((AbstractC0863pb<?, ?, ?>) this.f4730g, c1093ts, c0872pk) >= iMo5347a && iMo5347a > 0) && c1093ts != c1093tsM6016a) {
                    return Component.translatable("bf.message.gamemode.class.error.full", new Object[]{Component.literal(String.valueOf(iMo5347a)).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED);
                }
            }
        }
        if (abstractC0531jN.mo2374f() && !serverPlayer.isCreative()) {
            G g2 = this.f4730g;
            if (((g2 instanceof InterfaceC0979rl) && ((InterfaceC0979rl) g2).mo5345bK()) && !c1093ts.m6013a(this.f4737c, serverPlayer)) {
                return Component.translatable("bf.message.gamemode.class.error.rank", new Object[]{Component.literal(c1093ts.m6012a().getTitle()).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED);
            }
        }
        if (abstractC0531jN.mo2374f()) {
            G g3 = this.f4730g;
            boolean z = (g3 instanceof InterfaceC0979rl) && ((InterfaceC0979rl) g3).mo5344bJ();
            int expForClass = this.f4737c.m1150a((Player) serverPlayer).getExpForClass(c1093ts.m6011cc());
            int iM3818bA = c0837pB.m3818bA();
            if (z && expForClass < iM3818bA) {
                return Component.translatable("bf.message.gamemode.class.error.exp", new Object[]{Component.literal(C1273xM.m7239b(iM3818bA)).withStyle(ChatFormatting.GRAY), Component.literal(C1273xM.m7239b(expForClass)).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED);
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    public void m4212a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull EnumC0876po enumC0876po, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull C0872pk c0872pk) {
        UUID uuid = serverPlayer.getUUID();
        AbstractC0183b abstractC0183bM1153a = this.f4737c.m1153a((Player) serverPlayer);
        abstractC0531jN.m2355a(uuid, (AbstractC0863pb<?, ?, ?>) this.f4730g);
        this.f4732j.add(uuid);
        abstractC0183bM1153a.m1133dI();
        abstractC0183bM1153a.m1139dJ();
        serverPlayer.tickCount = 0;
        serverPlayer.getInventory().clearContent();
        serverPlayer.setGameMode(GameType.ADVENTURE);
        this.f4729a.m4346h(uuid);
        C0875pn.m4384a(this.f4737c, serverLevel, serverPlayer);
        this.f4730g.f4644a.m5876a(abstractC0531jN, this.f4737c, enumC0876po, serverLevel, serverPlayer);
        if (!mo4261b(serverPlayer) && this.f4730g.m4023a() == EnumC0871pj.GAME) {
            serverPlayer.setGameMode(GameType.SPECTATOR);
            abstractC0183bM1153a.m1105Y(true);
            abstractC0183bM1153a.m1113J(m4213a(serverPlayer));
        } else {
            G g = this.f4730g;
            if (g instanceof InterfaceC0942rA) {
                C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5743g, ((InterfaceC0942rA) g).mo5175bL());
            }
        }
        mo4262a(abstractC0531jN, this.f4737c, serverLevel, serverPlayer, uuid, c0872pk);
        abstractC0183bM1153a.m1098a(abstractC0531jN, serverLevel, true);
    }

    /* JADX INFO: renamed from: a */
    public int m4213a(@NotNull ServerPlayer serverPlayer) {
        return 120;
    }

    /* JADX INFO: renamed from: a */
    public void m4214a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerPlayer serverPlayer) {
        AbstractC0183b abstractC0183bM1153a = abstractC0531jN.m2351a().m1153a((Player) serverPlayer);
        UUID uuid = serverPlayer.getUUID();
        abstractC0183bM1153a.m1133dI();
        abstractC0183bM1153a.m1139dJ();
        this.f4730g.m4037c(uuid);
        C0881pt c0881ptM4226c = m4226c();
        if (c0881ptM4226c != null) {
            C0875pn.m4402a(this.f4737c, serverPlayer, c0881ptM4226c);
        }
        serverPlayer.getInventory().clearContent();
        C0870pi c0870piM4034a = this.f4730g.m4034a(uuid);
        c0870piM4034a.m4291a(C1062tN.f5745i.getKey(), -1);
        if (c0870piM4034a.m4289a(C1062tN.f5744h.getKey()) > 600 && abstractC0531jN.mo2375g()) {
            C0875pn.m4451a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5740d, 1);
        }
        this.f4730g.m4065a().m5913n(uuid);
        C0875pn.m4460a(abstractC0531jN, this.f4737c, (AbstractC0863pb<?, ?, ?>) this.f4730g, m4245h(), serverPlayer);
        if (abstractC0531jN.mo2375g()) {
            abstractC0531jN.m2342b().sendPacket(new PacketMMPlayerLeft(uuid, this.f4730g.m4064e()));
        }
        mo4263d(serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    public void m4215a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull String str, @NotNull UUID uuid, boolean z, @NotNull C0555jl c0555jl, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b) {
        if (this.f4734l.contains(uuid)) {
            m4233a(serverPlayer, abstractC0183b);
            return;
        }
        C0870pi c0870piM4034a = this.f4730g.m4034a(uuid);
        serverPlayer.getFoodData().setFoodLevel(20);
        G g = this.f4730g;
        if (g instanceof InterfaceC0986rs) {
            m4218a(serverPlayer, c0870piM4034a, (InterfaceC0986rs) g);
        }
        if (this.f4730g.m4023a() == EnumC0871pj.GAME) {
            int i = abstractC0183b.f1412vg;
            abstractC0183b.f1412vg = i + 1;
            if (i >= 2400) {
                abstractC0183b.f1412vg = 0;
                String key = C1062tN.f5744h.getKey();
                c0870piM4034a.m4291a(key, c0870piM4034a.m4289a(key) + 2400);
            }
        }
        if (this.f4730g instanceof InterfaceC0942rA) {
            String key2 = C1062tN.f5743g.getKey();
            int iM4289a = c0870piM4034a.m4289a(key2);
            if (iM4289a > 0) {
                c0870piM4034a.m4291a(key2, iM4289a - 1);
            }
            if (iM4289a < 120.0d) {
                Vec3 vec3Position = serverPlayer.position();
                if (serverPlayer.tickCount >= 20 && (serverPlayer.xOld != vec3Position.x || serverPlayer.zOld != vec3Position.z || serverPlayer.isCrouching() || vec3Position.y > serverPlayer.yOld)) {
                    c0870piM4034a.m4291a(key2, 0);
                }
            }
        }
        String key3 = C1062tN.f5761y.getKey();
        int iM4289a2 = c0870piM4034a.m4289a(key3);
        if (iM4289a2 > 0) {
            c0870piM4034a.m4291a(key3, iM4289a2 - 1);
        }
        if (this.f4730g instanceof InterfaceC0945rD) {
            String key4 = C1062tN.f5762z.getKey();
            int iM4289a3 = c0870piM4034a.m4289a(key4);
            if (iM4289a3 > 0) {
                c0870piM4034a.m4291a(key4, iM4289a3 - 1);
            }
            String key5 = C1062tN.f5763A.getKey();
            int iM4289a4 = c0870piM4034a.m4289a(key5);
            if (iM4289a4 > 0) {
                c0870piM4034a.m4291a(key5, iM4289a4 - 1);
            }
        }
        if (!abstractC0183b.m1106du()) {
            m4217a(abstractC0531jN, serverLevel, serverPlayer, abstractC0183b);
            if (this.f4730g.mo4047bl() && serverPlayer.isSpectator()) {
                m4233a(serverPlayer, abstractC0183b);
            } else if (!abstractC0183b.m1104dt() && (abstractC0183b.m1116r() != null || abstractC0183b.m1118m() != null)) {
                abstractC0183b.m1117p(null);
                abstractC0183b.m1119f((C0881pt) null);
            }
        }
        mo4264b(serverPlayer, abstractC0183b);
        if (z) {
            m4216a(serverPlayer, str, abstractC0183b, c0555jl);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4216a(@NotNull ServerPlayer serverPlayer, @NotNull String str, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b, @NotNull C0555jl c0555jl) {
        int i = c0555jl.f3298lw;
        c0555jl.f3298lw = i + 1;
        if (i < 40) {
            return;
        }
        c0555jl.f3298lw = 0;
        if (c0555jl.hasActivePunishment(PunishmentType.BAN_MM) || c0555jl.hasActivePunishment(PunishmentType.BAN_CLOUD)) {
            C0875pn.m4403a(ChatGraphic.ANTI_CHEAT, this.f4730g.m4018b().m4245h(), (Component) Component.translatable("bf.cloud.notification.suspended", new Object[]{Component.literal(str).withStyle(ChatFormatting.GRAY), C0030a.f263a}).withStyle(ChatFormatting.RED));
            C0875pn.m4398b(serverPlayer, (Component) Component.translatable("bf.message.disconnect.punishment"));
        }
        abstractC0183b.m1131ac(c0555jl.hasActivePunishment(PunishmentType.MUTE));
    }

    /* JADX INFO: renamed from: a */
    private void m4217a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b) {
        if (!abstractC0183b.m1104dt()) {
            serverPlayer.setInvisible(false);
            return;
        }
        serverPlayer.tickCount = 0;
        serverPlayer.setInvisible(true);
        if (abstractC0183b.m1112cI() > 0) {
            if (this.f4730g.mo4045f(serverPlayer)) {
                abstractC0183b.m1114K(1);
                if (abstractC0183b.m1112cI() == 20) {
                    C0875pn.m4366a(serverPlayer, (SoundEvent) C1312xz.f7990pL.get(), SoundSource.MUSIC, 2.0f);
                    return;
                }
                return;
            }
            return;
        }
        C0875pn.m4467a(abstractC0531jN, this.f4737c, serverLevel, serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    private void m4218a(@NotNull ServerPlayer serverPlayer, @NotNull C0870pi c0870pi, @NotNull InterfaceC0986rs interfaceC0986rs) {
        if (interfaceC0986rs.mo5301i(serverPlayer)) {
            String key = C1062tN.f5754r.getKey();
            int iM4289a = c0870pi.m4289a(key);
            if (iM4289a <= 0) {
                c0870pi.m4291a(key, interfaceC0986rs.mo5303a((Player) serverPlayer));
                serverPlayer.heal(interfaceC0986rs.mo5302a((Player) serverPlayer));
            } else {
                c0870pi.m4291a(key, iM4289a - 1);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4219a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        C0872pk c0872pkM4229a;
        C0872pk c0872pkM4229a2 = m4229a(uuid);
        if (c0872pkM4229a2 != null) {
            c0872pkM4229a2.m4300a(C1062tN.f5774L, c0872pkM4229a2.m4303a(C1062tN.f5774L, 0) + 1);
        }
        if (uuid2 != null && (c0872pkM4229a = m4229a(uuid2)) != null) {
            c0872pkM4229a.m4300a(C1062tN.f5766D, c0872pkM4229a.m4303a(C1062tN.f5766D, 0) + 1);
        }
        mo4266b(abstractC0531jN, serverLevel, serverPlayer, uuid, serverPlayer2, uuid2, damageSource, set);
    }

    /* JADX INFO: renamed from: bm */
    public int m4220bm() {
        int iM4318bm = 0;
        Iterator<C0872pk> it = this.f4731aB.iterator();
        while (it.hasNext()) {
            iM4318bm += it.next().m4318bm();
        }
        return iM4318bm;
    }

    /* JADX INFO: renamed from: f */
    public boolean m4221f(@NotNull UUID uuid) {
        return this.f4732j.contains(uuid);
    }

    /* JADX INFO: renamed from: a */
    public List<ItemEntity> mo4222a(@NotNull Player player, @NotNull List<ItemEntity> list) {
        return list;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo4223a(@NotNull Player player, @NotNull ItemStack itemStack) {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo4224a(@NotNull Player player, @NotNull ItemEntity itemEntity, @NotNull ItemStack itemStack) {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo4225a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull Player player, @NotNull UUID uuid, @NotNull Block block, @NotNull BlockPos blockPos) {
        return (block instanceof DoorBlock) || (block instanceof ButtonBlock) || (block instanceof LeverBlock) || (block instanceof FenceGateBlock) || (block instanceof TrapDoorBlock) || (block instanceof C0590kT) || (block instanceof C0660lk) || (block instanceof C0630lG);
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C0881pt m4226c() {
        return this.f4736e;
    }

    /* JADX INFO: renamed from: a */
    public void m4227a(@NotNull C0881pt c0881pt) {
        this.f4736e = c0881pt;
    }

    /* JADX INFO: renamed from: b */
    public void m4228b(@NotNull C0872pk c0872pk) {
        this.f4731aB.add(c0872pk);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0872pk m4229a(@NotNull UUID uuid) {
        for (C0872pk c0872pk : this.f4731aB) {
            if (c0872pk.m4315i(uuid)) {
                return c0872pk;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m4230a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        abstractC0531jN.m2356a(uuid);
        this.f4732j.remove(uuid);
        this.f4729a.m4345g(uuid);
        this.f4731aB.forEach(c0872pk -> {
            c0872pk.m4306f(uuid);
        });
        C0875pn.m4395b(this.f4737c, serverPlayer);
        C0875pn.m4467a(abstractC0531jN, this.f4737c, serverLevel, serverPlayer);
        m4214a(abstractC0531jN, serverPlayer);
        C1169vO.m6643a(new C1220wM(null, false), serverPlayer);
        m4239cC();
    }

    /* JADX INFO: renamed from: b */
    public void m4231b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        abstractC0531jN.m2355a(uuid, (AbstractC0863pb<?, ?, ?>) this.f4730g);
        this.f4734l.add(uuid);
        serverPlayer.tickCount = 0;
        serverPlayer.getInventory().clearContent();
        C0875pn.m4384a(this.f4737c, serverLevel, serverPlayer);
        serverPlayer.setGameMode(GameType.SPECTATOR);
        serverPlayer.setInvisible(true);
        C0881pt c0881ptM4226c = m4226c();
        if (c0881ptM4226c != null) {
            C0875pn.m4402a(this.f4737c, serverPlayer, c0881ptM4226c);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m4232c(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        abstractC0531jN.m2356a(uuid);
        this.f4734l.remove(uuid);
        this.f4737c.m1153a((Player) serverPlayer).m1117p(null);
        this.f4730g.m4037c(uuid);
        serverPlayer.setCamera(serverPlayer);
        serverPlayer.setInvisible(false);
        C0875pn.m4384a(this.f4737c, serverLevel, serverPlayer);
        C0881pt c0881ptM4226c = m4226c();
        if (c0881ptM4226c != null) {
            C0875pn.m4402a(this.f4737c, serverPlayer, c0881ptM4226c);
        }
        C1169vO.m6643a(new C1220wM(null, false), serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    private void m4233a(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b) {
        ServerPlayer serverPlayerM4399a;
        UUID uuid = serverPlayer.getUUID();
        boolean zContains = this.f4734l.contains(uuid);
        serverPlayer.setInvisible(true);
        if (zContains && !serverPlayer.isSpectator()) {
            serverPlayer.setGameMode(GameType.SPECTATOR);
        }
        List<UUID> listM4234a = m4234a(uuid, zContains);
        UUID uuidM1116r = abstractC0183b.m1116r();
        if ((uuidM1116r == null || !listM4234a.contains(uuidM1116r)) && (uuidM1116r == null || !m4235a(uuid, uuidM1116r, zContains))) {
            uuidM1116r = listM4234a.isEmpty() ? null : (UUID) listM4234a.getFirst();
            abstractC0183b.m1117p(uuidM1116r);
        }
        if (uuidM1116r == null) {
            C0881pt c0881ptM1118m = abstractC0183b.m1118m();
            if (c0881ptM1118m == null) {
                abstractC0183b.m1119f(new C0881pt((Player) serverPlayer));
                return;
            } else {
                if (serverPlayer.distanceToSqr(c0881ptM1118m.f4827c) > f4727aO) {
                    C0875pn.m4402a(this.f4737c, serverPlayer, c0881ptM1118m);
                    return;
                }
                return;
            }
        }
        abstractC0183b.m1119f((C0881pt) null);
        if (zContains && (serverPlayerM4399a = C0875pn.m4399a(uuidM1116r)) != null && serverPlayer.distanceToSqr(serverPlayerM4399a) > f4727aO) {
            C0875pn.m4402a(this.f4737c, serverPlayer, new C0881pt((Player) serverPlayerM4399a));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private List<UUID> m4234a(@NotNull UUID uuid, boolean z) {
        EnumC0878pq enumC0878pqMo4046a = this.f4730g.mo4046a();
        if (enumC0878pqMo4046a == EnumC0878pq.NONE) {
            return Collections.emptyList();
        }
        C0872pk c0872pkM4229a = z ? null : m4229a(uuid);
        boolean z2 = enumC0878pqMo4046a == EnumC0878pq.SAME_TEAM && c0872pkM4229a != null;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (UUID uuid2 : m4250k()) {
            if (!uuid2.equals(uuid) && (!z2 || c0872pkM4229a.m4315i(uuid2))) {
                if (C0875pn.m4399a(uuid2) != null) {
                    objectArrayList.add(uuid2);
                }
            }
        }
        objectArrayList.sort((v0, v1) -> {
            return v0.compareTo(v1);
        });
        return objectArrayList;
    }

    /* JADX INFO: renamed from: a */
    private boolean m4235a(@NotNull UUID uuid, @NotNull UUID uuid2, boolean z) {
        EnumC0878pq enumC0878pqMo4046a = this.f4730g.mo4046a();
        if (enumC0878pqMo4046a == EnumC0878pq.NONE || !m4221f(uuid2) || C0875pn.m4399a(uuid2) == null) {
            return false;
        }
        C0872pk c0872pkM4229a = z ? null : m4229a(uuid);
        if (enumC0878pqMo4046a == EnumC0878pq.SAME_TEAM && c0872pkM4229a != null) {
            return c0872pkM4229a.m4315i(uuid2);
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m4236a(@NotNull ServerPlayer serverPlayer, int i) {
        UUID uuid = serverPlayer.getUUID();
        boolean zContains = this.f4734l.contains(uuid);
        AbstractC0183b abstractC0183bM1153a = this.f4737c.m1153a((Player) serverPlayer);
        if (zContains || (serverPlayer.isSpectator() && this.f4730g.mo4047bl())) {
            List<UUID> listM4234a = m4234a(uuid, zContains);
            if (listM4234a.isEmpty()) {
                return;
            }
            UUID uuidM1116r = abstractC0183bM1153a.m1116r();
            abstractC0183bM1153a.m1117p(listM4234a.get(Math.floorMod((uuidM1116r == null ? -1 : listM4234a.indexOf(uuidM1116r)) + i, listM4234a.size())));
        }
    }

    /* JADX INFO: renamed from: b */
    public void m4237b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerPlayer serverPlayer) {
        if (this.f4734l.contains(serverPlayer.getUUID())) {
            this.f4730g.m4067a(abstractC0531jN, serverPlayer.serverLevel(), serverPlayer);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4238a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull Component component) {
        if (this.f4734l.isEmpty()) {
            return;
        }
        ObjectListIterator it = new ObjectArrayList(this.f4734l).iterator();
        while (it.hasNext()) {
            UUID uuid = (UUID) it.next();
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(uuid);
            if (serverPlayerM4399a == null) {
                this.f4734l.remove(uuid);
            } else {
                m4232c(abstractC0531jN, serverPlayerM4399a.serverLevel(), serverPlayerM4399a);
                C0875pn.m4397a(uuid, component);
            }
        }
    }

    /* JADX INFO: renamed from: cC */
    private void m4239cC() {
        MatchSettings matchSettingsM4088a = this.f4730g.m4088a();
        if (matchSettingsM4088a.isDefault()) {
            return;
        }
        Iterator<UUID> it = m4245h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(it.next());
            if (serverPlayerM4399a != null && this.f4737c.m1150a((Player) serverPlayerM4399a).m2516l(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN)) {
                return;
            }
        }
        matchSettingsM4088a.reset();
        C0875pn.m4415a(m4248j(), C0875pn.f4777iZ, (Component) f4728r);
    }

    /* JADX INFO: renamed from: a */
    public boolean m4240a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull EnumC0876po enumC0876po, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull C0872pk c0872pk) {
        String scoreboardName = serverPlayer.getScoreboardName();
        C0530jM.log("Attempting to add player %s to team %s...", scoreboardName, c0872pk.getName());
        if (c0872pk.m4304c(serverPlayer)) {
            C0530jM.log("Successfully added player %s to team %s!", scoreboardName, c0872pk.getName());
            m4212a(abstractC0531jN, enumC0876po, serverLevel, serverPlayer, c0872pk);
            return true;
        }
        C0530jM.log("Failed to add player %s to team %s!", scoreboardName, c0872pk.getName());
        return false;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C0872pk mo4241b() {
        C0872pk c0872pkM4242a = m4242a(C1062tN.f5782dk);
        C0872pk c0872pkM4242a2 = m4242a(C1062tN.f5783dl);
        if (!f4738gx && c0872pkM4242a2 == null) {
            throw new AssertionError();
        }
        if (!f4738gx && c0872pkM4242a == null) {
            throw new AssertionError();
        }
        Set<UUID> setM4308h = c0872pkM4242a2.m4308h();
        Set<UUID> setM4308h2 = c0872pkM4242a.m4308h();
        if (setM4308h.isEmpty() && setM4308h2.isEmpty()) {
            return ThreadLocalRandom.current().nextBoolean() ? c0872pkM4242a2 : c0872pkM4242a;
        }
        return setM4308h.size() < setM4308h2.size() ? c0872pkM4242a2 : c0872pkM4242a;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0872pk m4242a(@NotNull String str) {
        for (C0872pk c0872pk : this.f4731aB) {
            if (c0872pk.getName().equalsIgnoreCase(str)) {
                return c0872pk;
            }
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public G m4243a() {
        return this.f4730g;
    }

    @NotNull
    /* JADX INFO: renamed from: C */
    public List<C0872pk> m4244C() {
        return Collections.unmodifiableList(this.f4731aB);
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Set<UUID> m4245h() {
        return this.f4733k;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public Set<UUID> m4246i() {
        return this.f4735m;
    }

    /* JADX INFO: renamed from: g */
    public boolean m4247g(@NotNull UUID uuid) {
        return this.f4734l.contains(uuid);
    }

    @NotNull
    /* JADX INFO: renamed from: j */
    public Set<UUID> m4248j() {
        if (this.f4734l.isEmpty()) {
            return this.f4733k;
        }
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet(this.f4732j.size() + this.f4734l.size());
        objectOpenHashSet.addAll(this.f4732j);
        objectOpenHashSet.addAll(this.f4734l);
        return objectOpenHashSet;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Set<UUID> m4249a(@NotNull C0872pk c0872pk, @NotNull EnumC0877pp enumC0877pp) {
        Set<UUID> setM4308h = c0872pk.m4308h();
        if (enumC0877pp == EnumC0877pp.PLAYERS_ONLY) {
            return setM4308h;
        }
        if (this.f4734l.isEmpty()) {
            return enumC0877pp == EnumC0877pp.ALL ? setM4308h : Collections.emptySet();
        }
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet(setM4308h.size() + this.f4734l.size());
        if (enumC0877pp == EnumC0877pp.ALL) {
            objectOpenHashSet.addAll(setM4308h);
        }
        for (UUID uuid : this.f4734l) {
            UUID uuidM1116r = this.f4737c.m1152b(uuid).m1116r();
            if (uuidM1116r != null && setM4308h.contains(uuidM1116r)) {
                objectOpenHashSet.add(uuid);
            }
        }
        return objectOpenHashSet;
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public Set<UUID> m4250k() {
        Set<UUID> setM4245h = m4245h();
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet(setM4245h.size());
        for (UUID uuid : setM4245h) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(uuid);
            AbstractC0183b abstractC0183bM1152b = this.f4737c.m1152b(uuid);
            if (serverPlayerM4399a != null && !C0875pn.m4488a((Player) serverPlayerM4399a, (AbstractC0183b<?, ?, ?, ?>) abstractC0183bM1152b)) {
                objectOpenHashSet.add(uuid);
            }
        }
        return objectOpenHashSet;
    }

    /* JADX INFO: renamed from: e */
    public void m4251e(@NotNull UUID uuid) {
        G g = this.f4730g;
        if ((g instanceof InterfaceC0942rA) && ((InterfaceC0942rA) g).mo5177k(uuid)) {
            C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this.f4730g, uuid, C1062tN.f5743g, 0);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m4252a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, double d) {
        C0872pk c0872pkM4229a = m4229a(uuid);
        if (c0872pkM4229a == null) {
            return false;
        }
        Iterator<C0881pt> it = c0872pkM4229a.m4309D().iterator();
        while (it.hasNext()) {
            if (Mth.sqrt((float) serverPlayer.distanceToSqr(it.next().f4827c)) <= d) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0874pm m4253a() {
        return this.f4729a;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: bd */
    public void mo4254bd() {
        this.f4729a.m4344bd();
        this.f4732j.clear();
        this.f4734l.clear();
        for (C0872pk c0872pk : this.f4731aB) {
            c0872pk.m4307cE();
            c0872pk.m4297cD();
        }
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: h */
    protected void m4255h(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4729a.m4349c(byteBuf);
        Iterator<C0872pk> it = this.f4731aB.iterator();
        while (it.hasNext()) {
            it.next().m4322i(byteBuf);
        }
        byteBuf.writeInt(this.f4734l.size());
        Iterator<UUID> it2 = this.f4734l.iterator();
        while (it2.hasNext()) {
            IPacket.writeUUID(byteBuf, it2.next());
        }
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: g */
    protected void m4256g(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4729a.m4348b(byteBuf);
        Iterator<C0872pk> it = this.f4731aB.iterator();
        while (it.hasNext()) {
            it.next().m4323j(byteBuf);
        }
        this.f4732j.clear();
        Iterator<C0872pk> it2 = this.f4731aB.iterator();
        while (it2.hasNext()) {
            this.f4732j.addAll(it2.next().m4308h());
        }
        this.f4734l.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f4734l.add(IPacket.readUUID(byteBuf));
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean mo4265a(@NotNull ServerPlayer serverPlayer, @NotNull DamageSource damageSource) {
        return false;
    }
}
