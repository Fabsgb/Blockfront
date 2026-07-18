package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ChatGraphic;
import com.boehmod.bflib.cloud.common.GroupPermissions;
import com.boehmod.bflib.cloud.common.MatchSettings;
import com.boehmod.bflib.cloud.common.player.PunishmentType;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMPlayerLeft;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.oI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oI.class */
public abstract class AbstractC0790oI<G extends AbstractC0787oF<G, ?, ?>> {

    /* JADX INFO: renamed from: mQ */
    private static final int f4329mQ = 2400;

    /* JADX INFO: renamed from: mR */
    private static final int f4330mR = 600;

    /* JADX INFO: renamed from: mS */
    private static final int f4331mS = 120;

    /* JADX INFO: renamed from: aB */
    private static final double f4332aB = 256.0d;

    /* JADX INFO: renamed from: r */
    @NotNull
    private static final MutableComponent f4333r;

    /* JADX INFO: renamed from: g */
    @NotNull
    protected final G f4335g;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final AbstractC0183c<?> f4342c;

    /* JADX INFO: renamed from: gd */
    static final /* synthetic */ boolean f4343gd;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0798oQ f4334a = new C0798oQ();

    /* JADX INFO: renamed from: au */
    @NotNull
    private final List<C0796oO> f4336au = new ObjectArrayList();

    /* JADX INFO: renamed from: i */
    @NotNull
    private final Set<UUID> f4337i = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: j */
    @NotNull
    private final Set<UUID> f4338j = Collections.unmodifiableSet(this.f4337i);

    /* JADX INFO: renamed from: k */
    @NotNull
    private final Set<UUID> f4339k = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: l */
    @NotNull
    private final Set<UUID> f4340l = Collections.unmodifiableSet(this.f4339k);

    /* JADX INFO: renamed from: e */
    @Nullable
    protected C0805oX f4341e = null;

    /* JADX INFO: renamed from: a */
    public abstract boolean mo3821a(@NotNull Player player, @NotNull Block block);

    /* JADX INFO: renamed from: b */
    public abstract boolean mo3822b(@NotNull Player player, @NotNull Block block);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo3823a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull Player player, @NotNull Block block, @NotNull BlockPos blockPos);

    @Nullable
    /* JADX INFO: renamed from: a */
    public abstract C0864pd mo3824a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set, @Nullable C0797oP c0797oP);

    /* JADX INFO: renamed from: a */
    protected abstract boolean mo3825a(@NotNull ServerPlayer serverPlayer);

    /* JADX INFO: renamed from: a */
    public abstract void mo3826a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C0796oO c0796oO);

    /* JADX INFO: renamed from: d */
    public abstract void mo3827d(@NotNull ServerPlayer serverPlayer);

    /* JADX INFO: renamed from: b */
    public abstract void mo3828b(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b);

    /* JADX INFO: renamed from: b */
    public abstract void mo3830b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set);

    /* JADX INFO: renamed from: a */
    public abstract void mo3831a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo3832a(@NotNull Player player, @NotNull UUID uuid, @NotNull DamageSource damageSource, @Nullable Entity entity);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo3833a(@NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource);

    /* JADX INFO: renamed from: bn */
    public abstract boolean mo3834bn();

    static {
        f4343gd = !AbstractC0790oI.class.desiredAssertionStatus();
        f4333r = Component.translatable("bf.message.admin.settings.reset");
    }

    public AbstractC0790oI(@NotNull G g, @NotNull AbstractC0183c<?> abstractC0183c) {
        this.f4335g = g;
        this.f4342c = abstractC0183c;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected AbstractC0183c<?> m3771a() {
        return this.f4342c;
    }

    /* JADX INFO: renamed from: a */
    public void m3772a(@Nonnull Set<UUID> set) {
        UUID uuidM3906g = this.f4334a.m3906g();
        if (uuidM3906g != null && !set.contains(uuidM3906g)) {
            this.f4334a.m3909g(uuidM3906g);
        }
        Iterator<C0796oO> it = this.f4336au.iterator();
        while (it.hasNext()) {
            it.next().onUpdate();
        }
        m3773b(set);
    }

    /* JADX INFO: renamed from: b */
    private void m3773b(@NotNull Set<UUID> set) {
        ServerPlayer serverPlayerM3963a;
        UUID uuidM1099q;
        Object2IntOpenHashMap object2IntOpenHashMap = new Object2IntOpenHashMap();
        Object2IntOpenHashMap object2IntOpenHashMap2 = new Object2IntOpenHashMap();
        Iterator<UUID> it = this.f4339k.iterator();
        while (it.hasNext()) {
            UUID uuidM1099q2 = this.f4342c.m1135b(it.next()).m1099q();
            if (uuidM1099q2 != null) {
                object2IntOpenHashMap.mergeInt(uuidM1099q2, 1, Integer::sum);
            }
        }
        if (this.f4335g.mo3611bb()) {
            for (UUID uuid : set) {
                if (!this.f4339k.contains(uuid) && (serverPlayerM3963a = C0799oR.m3963a(uuid)) != null && serverPlayerM3963a.isSpectator() && (uuidM1099q = this.f4342c.m1135b(uuid).m1099q()) != null) {
                    object2IntOpenHashMap2.mergeInt(uuidM1099q, 1, Integer::sum);
                }
            }
        }
        for (UUID uuid2 : set) {
            this.f4342c.m1135b(uuid2).m1105b(object2IntOpenHashMap.getInt(uuid2), object2IntOpenHashMap2.getInt(uuid2));
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m3774a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull C1015sV c1015sV, int i) {
        C1074ta c1074taM3860a;
        C0866pf c0866pfM5981a;
        C0796oO c0796oOM3793a = m3793a(uuid);
        if (c0796oOM3793a == null || (c0866pfM5981a = (c1074taM3860a = c0796oOM3793a.m3860a((AbstractC0787oF<?, ?, ?>) this.f4335g)).m5981a(c1015sV, i)) == null) {
            return false;
        }
        MutableComponent mutableComponentM3775a = m3775a(abstractC0563ju, uuid, serverPlayer, c0796oOM3793a, c1015sV, c0866pfM5981a);
        if (mutableComponentM3775a != null) {
            C1194vo.m6648a(new C1246wn((Component) mutableComponentM3775a), serverPlayer);
            return false;
        }
        C0794oM c0794oMM3598a = this.f4335g.m3598a(uuid);
        String key = C1089tp.f5692i.getKey();
        String key2 = C1089tp.f5693j.getKey();
        boolean z = c0794oMM3598a.m3854a(key, -1) == -1;
        int iM3854a = c0794oMM3598a.m3854a(key, -1);
        int iM3854a2 = c0794oMM3598a.m3854a(key2, 0);
        C1015sV c1015sVM5528a = iM3854a >= 0 ? C1015sV.m5528a(iM3854a) : null;
        C0866pf c0866pfM5981a2 = c1015sVM5528a != null ? c1074taM3860a.m5981a(c1015sVM5528a, iM3854a2) : null;
        c0794oMM3598a.m3855a(key, c1015sV.m5523bN());
        c0794oMM3598a.m3855a(key2, i);
        if (z || (m3816a(serverPlayer, uuid, 4.0d) && !C0799oR.m4035c(serverPlayer) && (c0866pfM5981a2 == null || !C0799oR.m4036a(serverPlayer, c0866pfM5981a2)))) {
            c0794oMM3598a.m3855a(C1089tp.f5694k.getKey(), c1015sV.m5523bN());
            C0799oR.m4021a(serverLevel, serverPlayer, c0866pfM5981a);
            C0799oR.m3941a((Level) serverLevel, serverPlayer.position(), (SoundEvent) C1280xc.f7588pT.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
            MutableComponent mutableComponentWithStyle = Component.translatable(c1015sV.m5516al()).withStyle(ChatFormatting.GRAY);
            if (i > 0) {
                mutableComponentWithStyle = mutableComponentWithStyle.append(" ").append(Component.translatable("enchantment.level." + (i + 1)).withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID));
            }
            if (!z) {
                C0799oR.m3970c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.class", new Object[]{mutableComponentWithStyle}).withColor(ColorReferences.COLOR_WHITE));
                return true;
            }
            return true;
        }
        C0799oR.m3970c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.class.respawn", new Object[]{Component.translatable(c1015sV.m5516al()).withStyle(ChatFormatting.GRAY)}).withColor(ColorReferences.COLOR_WHITE));
        return true;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public MutableComponent m3775a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull UUID uuid, @NotNull ServerPlayer serverPlayer, @NotNull C0796oO c0796oO, @NotNull C1015sV c1015sV, @NotNull C0866pf c0866pf) {
        C1015sV c1015sVM5528a = null;
        int iM3854a = this.f4335g.m3598a(uuid).m3854a(C1089tp.f5692i.getKey(), -1);
        if (iM3854a != -1) {
            c1015sVM5528a = C1015sV.m5528a(iM3854a);
        }
        G g = this.f4335g;
        if (g instanceof InterfaceC0902qO) {
            InterfaceC0902qO interfaceC0902qO = (InterfaceC0902qO) g;
            if (interfaceC0902qO.mo4669by()) {
                int iMo4673a = interfaceC0902qO.mo4673a(c1015sV);
                if ((C0799oR.m4030a((AbstractC0787oF<?, ?, ?>) this.f4335g, c1015sV, c0796oO) >= iMo4673a && iMo4673a > 0) && c1015sV != c1015sVM5528a) {
                    return Component.translatable("bf.message.gamemode.class.error.full", new Object[]{Component.literal(String.valueOf(iMo4673a)).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED);
                }
            }
        }
        if (abstractC0563ju.mo2551f() && !serverPlayer.isCreative()) {
            G g2 = this.f4335g;
            if (((g2 instanceof InterfaceC0902qO) && ((InterfaceC0902qO) g2).mo4671bA()) && !c1015sV.m5525a(this.f4342c, serverPlayer)) {
                return Component.translatable("bf.message.gamemode.class.error.rank", new Object[]{Component.literal(c1015sV.m5524a().getTitle()).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED);
            }
        }
        if (abstractC0563ju.mo2551f()) {
            G g3 = this.f4335g;
            boolean z = (g3 instanceof InterfaceC0902qO) && ((InterfaceC0902qO) g3).mo4670bz();
            int expForClass = this.f4342c.m1133a((Player) serverPlayer).getExpForClass(c1015sV.m5523bN());
            int iM4333bl = c0866pf.m4333bl();
            if (z && expForClass < iM4333bl) {
                return Component.translatable("bf.message.gamemode.class.error.exp", new Object[]{Component.literal(C1293xp.m7912a(iM4333bl)).withStyle(ChatFormatting.GRAY), Component.literal(C1293xp.m7912a(expForClass)).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED);
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
    /* JADX INFO: renamed from: a */
    public void m3776a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull C0796oO c0796oO) {
        UUID uuid = serverPlayer.getUUID();
        AbstractC0182b abstractC0182bM1136a = this.f4342c.m1136a((Player) serverPlayer);
        abstractC0563ju.m2532a(uuid, (AbstractC0787oF<?, ?, ?>) this.f4335g);
        this.f4337i.add(uuid);
        abstractC0182bM1136a.m1116dy();
        abstractC0182bM1136a.m1122dz();
        serverPlayer.tickCount = 0;
        serverPlayer.getInventory().clearContent();
        serverPlayer.setGameMode(GameType.ADVENTURE);
        this.f4334a.m3910h(uuid);
        C0799oR.m3948a(this.f4342c, serverLevel, serverPlayer);
        this.f4335g.f4250a.m5996a(abstractC0563ju, this.f4342c, enumC0800oS, serverLevel, serverPlayer);
        if (!mo3825a(serverPlayer) && this.f4335g.m3587a() == EnumC0795oN.GAME) {
            serverPlayer.setGameMode(GameType.SPECTATOR);
            abstractC0182bM1136a.m1088X(true);
            abstractC0182bM1136a.m1096I(m3777a(serverPlayer));
        } else {
            G g = this.f4335g;
            if (g instanceof InterfaceC0970rd) {
                C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this.f4335g, uuid, C1089tp.f5690g, ((InterfaceC0970rd) g).mo5164bw());
            }
        }
        mo3826a(abstractC0563ju, this.f4342c, serverLevel, serverPlayer, uuid, c0796oO);
        abstractC0182bM1136a.m1081a(abstractC0563ju, serverLevel, true);
    }

    /* JADX INFO: renamed from: a */
    public int m3777a(@NotNull ServerPlayer serverPlayer) {
        return 120;
    }

    /* JADX INFO: renamed from: a */
    public void m3778a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerPlayer serverPlayer) {
        AbstractC0182b abstractC0182bM1136a = abstractC0563ju.m2528a().m1136a((Player) serverPlayer);
        UUID uuid = serverPlayer.getUUID();
        abstractC0182bM1136a.m1116dy();
        abstractC0182bM1136a.m1122dz();
        this.f4335g.m3601c(uuid);
        C0805oX c0805oXM3790c = m3790c();
        if (c0805oXM3790c != null) {
            C0799oR.m3966a(this.f4342c, serverPlayer, c0805oXM3790c);
        }
        serverPlayer.getInventory().clearContent();
        C0794oM c0794oMM3598a = this.f4335g.m3598a(uuid);
        c0794oMM3598a.m3855a(C1089tp.f5692i.getKey(), -1);
        if (c0794oMM3598a.m3853a(C1089tp.f5691h.getKey()) > 600 && abstractC0563ju.mo2552g()) {
            C0799oR.m4015a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4335g, uuid, C1089tp.f5687d, 1);
        }
        this.f4335g.m3629a().m6027n(uuid);
        C0799oR.m4024a(abstractC0563ju, this.f4342c, (AbstractC0787oF<?, ?, ?>) this.f4335g, m3809h(), serverPlayer);
        if (abstractC0563ju.mo2552g()) {
            abstractC0563ju.m2520b().sendPacket(new PacketMMPlayerLeft(uuid, this.f4335g.m3628e()));
        }
        mo3827d(serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    public void m3779a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull String str, @NotNull UUID uuid, boolean z, @NotNull C0482iS c0482iS, @NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b) {
        if (this.f4339k.contains(uuid)) {
            m3797a(serverPlayer, abstractC0182b);
            return;
        }
        C0794oM c0794oMM3598a = this.f4335g.m3598a(uuid);
        serverPlayer.getFoodData().setFoodLevel(20);
        G g = this.f4335g;
        if (g instanceof InterfaceC0909qV) {
            m3782a(serverPlayer, c0794oMM3598a, (InterfaceC0909qV) g);
        }
        if (this.f4335g.m3587a() == EnumC0795oN.GAME) {
            int i = abstractC0182b.f1490tc;
            abstractC0182b.f1490tc = i + 1;
            if (i >= 2400) {
                abstractC0182b.f1490tc = 0;
                String key = C1089tp.f5691h.getKey();
                c0794oMM3598a.m3855a(key, c0794oMM3598a.m3853a(key) + 2400);
            }
        }
        if (this.f4335g instanceof InterfaceC0970rd) {
            String key2 = C1089tp.f5690g.getKey();
            int iM3853a = c0794oMM3598a.m3853a(key2);
            if (iM3853a > 0) {
                c0794oMM3598a.m3855a(key2, iM3853a - 1);
            }
            if (iM3853a < 120.0d) {
                Vec3 vec3Position = serverPlayer.position();
                if (serverPlayer.tickCount >= 20 && (serverPlayer.xOld != vec3Position.x || serverPlayer.zOld != vec3Position.z || serverPlayer.isCrouching() || vec3Position.y > serverPlayer.yOld)) {
                    c0794oMM3598a.m3855a(key2, 0);
                }
            }
        }
        String key3 = C1089tp.f5708y.getKey();
        int iM3853a2 = c0794oMM3598a.m3853a(key3);
        if (iM3853a2 > 0) {
            c0794oMM3598a.m3855a(key3, iM3853a2 - 1);
        }
        if (this.f4335g instanceof InterfaceC0973rg) {
            String key4 = C1089tp.f5709z.getKey();
            int iM3853a3 = c0794oMM3598a.m3853a(key4);
            if (iM3853a3 > 0) {
                c0794oMM3598a.m3855a(key4, iM3853a3 - 1);
            }
            String key5 = C1089tp.f5710A.getKey();
            int iM3853a4 = c0794oMM3598a.m3853a(key5);
            if (iM3853a4 > 0) {
                c0794oMM3598a.m3855a(key5, iM3853a4 - 1);
            }
        }
        if (!abstractC0182b.m1089dl()) {
            m3781a(abstractC0563ju, serverLevel, serverPlayer, abstractC0182b);
            if (this.f4335g.mo3611bb() && serverPlayer.isSpectator()) {
                m3797a(serverPlayer, abstractC0182b);
            } else if (!abstractC0182b.m1087dk() && (abstractC0182b.m1099q() != null || abstractC0182b.m1101m() != null)) {
                abstractC0182b.m1100p(null);
                abstractC0182b.m1102f(null);
            }
        }
        mo3828b(serverPlayer, abstractC0182b);
        if (z) {
            m3780a(serverPlayer, str, abstractC0182b, c0482iS);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3780a(@NotNull ServerPlayer serverPlayer, @NotNull String str, @NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b, @NotNull C0482iS c0482iS) {
        int i = c0482iS.f2947jP;
        c0482iS.f2947jP = i + 1;
        if (i < 40) {
            return;
        }
        c0482iS.f2947jP = 0;
        if (c0482iS.hasActivePunishment(PunishmentType.BAN_MM) || c0482iS.hasActivePunishment(PunishmentType.BAN_CLOUD)) {
            C0799oR.m3967a(ChatGraphic.ANTI_CHEAT, this.f4335g.m3582b().m3809h(), (Component) Component.translatable("bf.cloud.notification.suspended", new Object[]{Component.literal(str).withStyle(ChatFormatting.GRAY), C0029a.f246a}).withStyle(ChatFormatting.RED));
            C0799oR.m3962b(serverPlayer, (Component) Component.translatable("bf.message.disconnect.punishment"));
        }
        abstractC0182b.m1114ab(c0482iS.hasActivePunishment(PunishmentType.MUTE));
    }

    /* JADX INFO: renamed from: a */
    private void m3781a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b) {
        if (!abstractC0182b.m1087dk()) {
            serverPlayer.setInvisible(false);
            return;
        }
        serverPlayer.tickCount = 0;
        serverPlayer.setInvisible(true);
        if (abstractC0182b.m1095cs() > 0) {
            if (this.f4335g.mo3609f(serverPlayer)) {
                abstractC0182b.m1097J(1);
                if (abstractC0182b.m1095cs() == 20) {
                    C0799oR.m3930a(serverPlayer, (SoundEvent) C1280xc.f7578pJ.get(), SoundSource.MUSIC, 2.0f);
                    return;
                }
                return;
            }
            return;
        }
        C0799oR.m4031a(abstractC0563ju, this.f4342c, serverLevel, serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    private void m3782a(@NotNull ServerPlayer serverPlayer, @NotNull C0794oM c0794oM, @NotNull InterfaceC0909qV interfaceC0909qV) {
        if (interfaceC0909qV.mo4686i(serverPlayer)) {
            String key = C1089tp.f5701r.getKey();
            int iM3853a = c0794oM.m3853a(key);
            if (iM3853a <= 0) {
                c0794oM.m3855a(key, interfaceC0909qV.mo4688a((Player) serverPlayer));
                serverPlayer.heal(interfaceC0909qV.mo4687a((Player) serverPlayer));
            } else {
                c0794oM.m3855a(key, iM3853a - 1);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3783a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @Nullable ServerPlayer serverPlayer2, @Nullable UUID uuid2, @NotNull DamageSource damageSource, @NotNull Set<UUID> set) {
        C0796oO c0796oOM3793a;
        C0796oO c0796oOM3793a2 = m3793a(uuid);
        if (c0796oOM3793a2 != null) {
            c0796oOM3793a2.m3864a(C1089tp.f5721L, c0796oOM3793a2.m3867a(C1089tp.f5721L, 0) + 1);
        }
        if (uuid2 != null && (c0796oOM3793a = m3793a(uuid2)) != null) {
            c0796oOM3793a.m3864a(C1089tp.f5713D, c0796oOM3793a.m3867a(C1089tp.f5713D, 0) + 1);
        }
        mo3830b(abstractC0563ju, serverLevel, serverPlayer, uuid, serverPlayer2, uuid2, damageSource, set);
    }

    /* JADX INFO: renamed from: aX */
    public int m3784aX() {
        int iM3882aX = 0;
        Iterator<C0796oO> it = this.f4336au.iterator();
        while (it.hasNext()) {
            iM3882aX += it.next().m3882aX();
        }
        return iM3882aX;
    }

    /* JADX INFO: renamed from: f */
    public boolean m3785f(@NotNull UUID uuid) {
        return this.f4337i.contains(uuid);
    }

    /* JADX INFO: renamed from: a */
    public List<ItemEntity> mo3786a(@NotNull Player player, @NotNull List<ItemEntity> list) {
        return list;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo3787a(@NotNull Player player, @NotNull ItemStack itemStack) {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo3788a(@NotNull Player player, @NotNull ItemEntity itemEntity, @NotNull ItemStack itemStack) {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo3789a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull Player player, @NotNull UUID uuid, @NotNull Block block, @NotNull BlockPos blockPos) {
        return (block instanceof DoorBlock) || (block instanceof ButtonBlock) || (block instanceof LeverBlock) || (block instanceof FenceGateBlock) || (block instanceof TrapDoorBlock) || (block instanceof C0619kx) || (block instanceof C0584kO) || (block instanceof C0659lk);
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C0805oX m3790c() {
        return this.f4341e;
    }

    /* JADX INFO: renamed from: a */
    public void m3791a(@NotNull C0805oX c0805oX) {
        this.f4341e = c0805oX;
    }

    /* JADX INFO: renamed from: b */
    public void m3792b(@NotNull C0796oO c0796oO) {
        this.f4336au.add(c0796oO);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0796oO m3793a(@NotNull UUID uuid) {
        for (C0796oO c0796oO : this.f4336au) {
            if (c0796oO.m3879i(uuid)) {
                return c0796oO;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m3794a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        abstractC0563ju.m2533a(uuid);
        this.f4337i.remove(uuid);
        this.f4334a.m3909g(uuid);
        this.f4336au.forEach(c0796oO -> {
            c0796oO.m3870f(uuid);
        });
        C0799oR.m3959b(this.f4342c, serverPlayer);
        C0799oR.m4031a(abstractC0563ju, this.f4342c, serverLevel, serverPlayer);
        m3778a(abstractC0563ju, serverPlayer);
        C1194vo.m6648a(new C1247wo(null, false), serverPlayer);
        m3803cq();
    }

    /* JADX INFO: renamed from: b */
    public void m3795b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        abstractC0563ju.m2532a(uuid, (AbstractC0787oF<?, ?, ?>) this.f4335g);
        this.f4339k.add(uuid);
        serverPlayer.tickCount = 0;
        serverPlayer.getInventory().clearContent();
        C0799oR.m3948a(this.f4342c, serverLevel, serverPlayer);
        serverPlayer.setGameMode(GameType.SPECTATOR);
        serverPlayer.setInvisible(true);
        C0805oX c0805oXM3790c = m3790c();
        if (c0805oXM3790c != null) {
            C0799oR.m3966a(this.f4342c, serverPlayer, c0805oXM3790c);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3796c(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        UUID uuid = serverPlayer.getUUID();
        abstractC0563ju.m2533a(uuid);
        this.f4339k.remove(uuid);
        this.f4342c.m1136a((Player) serverPlayer).m1100p(null);
        this.f4335g.m3601c(uuid);
        serverPlayer.setCamera(serverPlayer);
        serverPlayer.setInvisible(false);
        C0799oR.m3948a(this.f4342c, serverLevel, serverPlayer);
        C0805oX c0805oXM3790c = m3790c();
        if (c0805oXM3790c != null) {
            C0799oR.m3966a(this.f4342c, serverPlayer, c0805oXM3790c);
        }
        C1194vo.m6648a(new C1247wo(null, false), serverPlayer);
    }

    /* JADX INFO: renamed from: a */
    private void m3797a(@NotNull ServerPlayer serverPlayer, @NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b) {
        ServerPlayer serverPlayerM3963a;
        UUID uuid = serverPlayer.getUUID();
        boolean zContains = this.f4339k.contains(uuid);
        serverPlayer.setInvisible(true);
        if (zContains && !serverPlayer.isSpectator()) {
            serverPlayer.setGameMode(GameType.SPECTATOR);
        }
        List<UUID> listM3798a = m3798a(uuid, zContains);
        UUID uuidM1099q = abstractC0182b.m1099q();
        if ((uuidM1099q == null || !listM3798a.contains(uuidM1099q)) && (uuidM1099q == null || !m3799a(uuid, uuidM1099q, zContains))) {
            uuidM1099q = listM3798a.isEmpty() ? null : (UUID) listM3798a.getFirst();
            abstractC0182b.m1100p(uuidM1099q);
        }
        if (uuidM1099q == null) {
            C0805oX c0805oXM1101m = abstractC0182b.m1101m();
            if (c0805oXM1101m == null) {
                abstractC0182b.m1102f(new C0805oX((Player) serverPlayer));
                return;
            } else {
                if (serverPlayer.distanceToSqr(c0805oXM1101m.f4424c) > f4332aB) {
                    C0799oR.m3966a(this.f4342c, serverPlayer, c0805oXM1101m);
                    return;
                }
                return;
            }
        }
        abstractC0182b.m1102f(null);
        if (zContains && (serverPlayerM3963a = C0799oR.m3963a(uuidM1099q)) != null && serverPlayer.distanceToSqr(serverPlayerM3963a) > f4332aB) {
            C0799oR.m3966a(this.f4342c, serverPlayer, new C0805oX((Player) serverPlayerM3963a));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private List<UUID> m3798a(@NotNull UUID uuid, boolean z) {
        EnumC0802oU enumC0802oUMo3610a = this.f4335g.mo3610a();
        if (enumC0802oUMo3610a == EnumC0802oU.NONE) {
            return Collections.emptyList();
        }
        C0796oO c0796oOM3793a = z ? null : m3793a(uuid);
        boolean z2 = enumC0802oUMo3610a == EnumC0802oU.SAME_TEAM && c0796oOM3793a != null;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (UUID uuid2 : m3814k()) {
            if (!uuid2.equals(uuid) && (!z2 || c0796oOM3793a.m3879i(uuid2))) {
                if (C0799oR.m3963a(uuid2) != null) {
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
    private boolean m3799a(@NotNull UUID uuid, @NotNull UUID uuid2, boolean z) {
        EnumC0802oU enumC0802oUMo3610a = this.f4335g.mo3610a();
        if (enumC0802oUMo3610a == EnumC0802oU.NONE || !m3785f(uuid2) || C0799oR.m3963a(uuid2) == null) {
            return false;
        }
        C0796oO c0796oOM3793a = z ? null : m3793a(uuid);
        if (enumC0802oUMo3610a == EnumC0802oU.SAME_TEAM && c0796oOM3793a != null) {
            return c0796oOM3793a.m3879i(uuid2);
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m3800a(@NotNull ServerPlayer serverPlayer, int i) {
        UUID uuid = serverPlayer.getUUID();
        boolean zContains = this.f4339k.contains(uuid);
        AbstractC0182b abstractC0182bM1136a = this.f4342c.m1136a((Player) serverPlayer);
        if (zContains || (serverPlayer.isSpectator() && this.f4335g.mo3611bb())) {
            List<UUID> listM3798a = m3798a(uuid, zContains);
            if (listM3798a.isEmpty()) {
                return;
            }
            UUID uuidM1099q = abstractC0182bM1136a.m1099q();
            abstractC0182bM1136a.m1100p(listM3798a.get(Math.floorMod((uuidM1099q == null ? -1 : listM3798a.indexOf(uuidM1099q)) + i, listM3798a.size())));
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3801b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerPlayer serverPlayer) {
        if (this.f4339k.contains(serverPlayer.getUUID())) {
            this.f4335g.m3631a(abstractC0563ju, serverPlayer.serverLevel(), serverPlayer);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3802a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull Component component) {
        if (this.f4339k.isEmpty()) {
            return;
        }
        ObjectListIterator it = new ObjectArrayList(this.f4339k).iterator();
        while (it.hasNext()) {
            UUID uuid = (UUID) it.next();
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(uuid);
            if (serverPlayerM3963a == null) {
                this.f4339k.remove(uuid);
            } else {
                m3796c(abstractC0563ju, serverPlayerM3963a.serverLevel(), serverPlayerM3963a);
                C0799oR.m3961a(uuid, component);
            }
        }
    }

    /* JADX INFO: renamed from: cq */
    private void m3803cq() {
        MatchSettings matchSettingsM3652a = this.f4335g.m3652a();
        if (matchSettingsM3652a.isDefault()) {
            return;
        }
        Iterator<UUID> it = m3809h().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(it.next());
            if (serverPlayerM3963a != null && this.f4342c.m1133a((Player) serverPlayerM3963a).m2189j(GroupPermissions.PERMISSION_STAFF_INGAME_ADMIN)) {
                return;
            }
        }
        matchSettingsM3652a.reset();
        C0799oR.m3979a(m3812j(), C0799oR.f4381iN, (Component) f4333r);
    }

    /* JADX INFO: renamed from: a */
    public boolean m3804a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull C0796oO c0796oO) {
        String scoreboardName = serverPlayer.getScoreboardName();
        C0562jt.log("Attempting to add player %s to team %s...", scoreboardName, c0796oO.getName());
        if (c0796oO.m3868b(serverPlayer)) {
            C0562jt.log("Successfully added player %s to team %s!", scoreboardName, c0796oO.getName());
            m3776a(abstractC0563ju, enumC0800oS, serverLevel, serverPlayer, c0796oO);
            return true;
        }
        C0562jt.log("Failed to add player %s to team %s!", scoreboardName, c0796oO.getName());
        return false;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C0796oO mo3805b() {
        C0796oO c0796oOM3806a = m3806a(C1089tp.f5729cZ);
        C0796oO c0796oOM3806a2 = m3806a(C1089tp.f5730da);
        if (!f4343gd && c0796oOM3806a2 == null) {
            throw new AssertionError();
        }
        if (!f4343gd && c0796oOM3806a == null) {
            throw new AssertionError();
        }
        Set<UUID> setM3872h = c0796oOM3806a2.m3872h();
        Set<UUID> setM3872h2 = c0796oOM3806a.m3872h();
        return (setM3872h.isEmpty() && setM3872h2.isEmpty()) ? ThreadLocalRandom.current().nextBoolean() ? c0796oOM3806a2 : c0796oOM3806a : setM3872h.size() < setM3872h2.size() ? c0796oOM3806a2 : c0796oOM3806a;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0796oO m3806a(@NotNull String str) {
        for (C0796oO c0796oO : this.f4336au) {
            if (c0796oO.getName().equalsIgnoreCase(str)) {
                return c0796oO;
            }
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public G m3807a() {
        return this.f4335g;
    }

    @NotNull
    /* JADX INFO: renamed from: A */
    public List<C0796oO> m3808A() {
        return Collections.unmodifiableList(this.f4336au);
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Set<UUID> m3809h() {
        return this.f4338j;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public Set<UUID> m3810i() {
        return this.f4340l;
    }

    /* JADX INFO: renamed from: g */
    public boolean m3811g(@NotNull UUID uuid) {
        return this.f4339k.contains(uuid);
    }

    @NotNull
    /* JADX INFO: renamed from: j */
    public Set<UUID> m3812j() {
        if (this.f4339k.isEmpty()) {
            return this.f4338j;
        }
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet(this.f4337i.size() + this.f4339k.size());
        objectOpenHashSet.addAll(this.f4337i);
        objectOpenHashSet.addAll(this.f4339k);
        return objectOpenHashSet;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Set<UUID> m3813a(@NotNull C0796oO c0796oO, @NotNull EnumC0801oT enumC0801oT) {
        Set<UUID> setM3872h = c0796oO.m3872h();
        if (enumC0801oT == EnumC0801oT.PLAYERS_ONLY) {
            return setM3872h;
        }
        if (this.f4339k.isEmpty()) {
            return enumC0801oT == EnumC0801oT.ALL ? setM3872h : Collections.emptySet();
        }
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet(setM3872h.size() + this.f4339k.size());
        if (enumC0801oT == EnumC0801oT.ALL) {
            objectOpenHashSet.addAll(setM3872h);
        }
        for (UUID uuid : this.f4339k) {
            UUID uuidM1099q = this.f4342c.m1135b(uuid).m1099q();
            if (uuidM1099q != null && setM3872h.contains(uuidM1099q)) {
                objectOpenHashSet.add(uuid);
            }
        }
        return objectOpenHashSet;
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public Set<UUID> m3814k() {
        Set<UUID> setM3809h = m3809h();
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet(setM3809h.size());
        for (UUID uuid : setM3809h) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(uuid);
            AbstractC0182b abstractC0182bM1135b = this.f4342c.m1135b(uuid);
            if (serverPlayerM3963a != null && !C0799oR.m4052a((Player) serverPlayerM3963a, (AbstractC0182b<?, ?, ?, ?>) abstractC0182bM1135b)) {
                objectOpenHashSet.add(uuid);
            }
        }
        return objectOpenHashSet;
    }

    /* JADX INFO: renamed from: e */
    public void m3815e(@NotNull UUID uuid) {
        G g = this.f4335g;
        if ((g instanceof InterfaceC0970rd) && ((InterfaceC0970rd) g).mo5166k(uuid)) {
            C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this.f4335g, uuid, C1089tp.f5690g, 0);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m3816a(@NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, double d) {
        C0796oO c0796oOM3793a = m3793a(uuid);
        if (c0796oOM3793a == null) {
            return false;
        }
        Iterator<C0805oX> it = c0796oOM3793a.m3873B().iterator();
        while (it.hasNext()) {
            if (Mth.sqrt((float) serverPlayer.distanceToSqr(it.next().f4424c)) <= d) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0798oQ m3817a() {
        return this.f4334a;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: bf */
    public void mo3818bf() {
        this.f4334a.m3908bf();
        this.f4337i.clear();
        this.f4339k.clear();
        for (C0796oO c0796oO : this.f4336au) {
            c0796oO.m3871cs();
            c0796oO.m3861cr();
        }
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: h */
    protected void m3819h(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4334a.m3913c(byteBuf);
        Iterator<C0796oO> it = this.f4336au.iterator();
        while (it.hasNext()) {
            it.next().m3886i(byteBuf);
        }
        byteBuf.writeInt(this.f4339k.size());
        Iterator<UUID> it2 = this.f4339k.iterator();
        while (it2.hasNext()) {
            IPacket.writeUUID(byteBuf, it2.next());
        }
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: g */
    protected void m3820g(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4334a.m3912b(byteBuf);
        Iterator<C0796oO> it = this.f4336au.iterator();
        while (it.hasNext()) {
            it.next().m3887j(byteBuf);
        }
        this.f4337i.clear();
        Iterator<C0796oO> it2 = this.f4336au.iterator();
        while (it2.hasNext()) {
            this.f4337i.addAll(it2.next().m3872h());
        }
        this.f4339k.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f4339k.add(IPacket.readUUID(byteBuf));
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean mo3829a(@NotNull ServerPlayer serverPlayer, @NotNull DamageSource damageSource) {
        return false;
    }
}
