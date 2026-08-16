package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.IOException;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ss */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ss.class */
public final class C1040ss extends AbstractC0863pb<C1040ss, C1042su, C1058tJ<C1040ss, C1042su>> implements InterfaceC0985rr, InterfaceC0986rs, InterfaceC0987rt, InterfaceC0990rw {

    /* JADX INFO: renamed from: jD */
    private static final Component f5652jD = Component.translatable("bf.message.gamemode.infected.store.resupply").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: jE */
    private static final Component f5653jE = Component.translatable("bf.message.gamemode.infected.store.relocate").withStyle(ChatFormatting.YELLOW);

    /* JADX INFO: renamed from: rW */
    private static final int f5654rW = 6;

    /* JADX INFO: renamed from: rX */
    public static final int f5655rX = 5;

    /* JADX INFO: renamed from: rY */
    public static final int f5656rY = 30;

    /* JADX INFO: renamed from: rZ */
    public static final int f5657rZ = 60;

    /* JADX INFO: renamed from: bv */
    @NotNull
    public final List<C1047sz> f5658bv;

    /* JADX INFO: renamed from: bw */
    @NotNull
    public final List<C0995sA> f5659bw;

    /* JADX INFO: renamed from: bx */
    @NotNull
    public final List<C0881pt> f5660bx;

    /* JADX INFO: renamed from: by */
    @NotNull
    public final List<C0886py> f5661by;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final IntSet f5662e;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final C0620kx f5663g;

    /* JADX INFO: renamed from: a */
    @Nullable
    public C0776nu f5664a;

    /* JADX INFO: renamed from: sa */
    public int f5665sa;

    /* JADX INFO: renamed from: sb */
    public int f5666sb;

    /* JADX INFO: renamed from: sc */
    public int f5667sc;

    /* JADX INFO: renamed from: sd */
    public int f5668sd;

    /* JADX INFO: renamed from: hr */
    public boolean f5669hr;

    /* JADX INFO: renamed from: a */
    @NotNull
    public EnumC1045sx f5670a;

    @NotNull
    /* JADX INFO: renamed from: e */
    private Collection<String> m5784e() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator<C1047sz> it = this.f5658bv.iterator();
        while (it.hasNext()) {
            objectArrayList.add(it.next().m5857ap());
        }
        return objectArrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    private Collection<String> m5785f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C0995sA c0995sA : this.f5659bw) {
            if (!objectArrayList.contains(c0995sA.getId())) {
                objectArrayList.add(c0995sA.getId());
            }
        }
        return objectArrayList;
    }

    public C1040ss(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        super(abstractC0531jN, "inf", "Infected");
        this.f5658bv = new ObjectArrayList();
        this.f5659bw = new ObjectArrayList();
        this.f5660bx = new ObjectArrayList();
        this.f5661by = new ObjectArrayList();
        this.f5662e = new IntOpenHashSet();
        this.f5663g = new C0620kx().m2840a("vendor", new C0620kx().m2840a("add", new C0620kx((commandContext, strArr) -> {
            this.f5660bx.add(new C0881pt(((CommandSourceStack) commandContext.getSource()).source));
            C0721ms.m3329b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Successfully added new vendor spawn. (" + this.f5660bx.size() + ")"));
        }).m2836a(C0622kz.f3554a)).m2840a("clear", new C0620kx((commandContext2, strArr2) -> {
            this.f5660bx.clear();
            C0721ms.m3329b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Successfully cleared all vendor spawns. (" + this.f5660bx.size() + ")"));
        }))).m2840a("spawn", new C0620kx().m2840a("add", new C0620kx((commandContext3, strArr3) -> {
            m4018b().m5842d(new C0881pt(((CommandSourceStack) commandContext3.getSource()).source));
            C0721ms.m3329b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal("Successfully added new random spawn. (" + m4018b().m5841as().size() + ")"));
        }).m2836a(C0622kz.f3554a)).m2840a("clear", new C0620kx((commandContext4, strArr4) -> {
            m4018b().m5843cV();
            C0721ms.m3329b(((CommandSourceStack) commandContext4.getSource()).source, Component.literal("Successfully cleared all random spawns."));
        }))).m2840a("doors", new C0620kx((commandContext5, strArr5) -> {
            for (C0995sA c0995sA : this.f5659bw) {
                C0721ms.m3329b(((CommandSourceStack) commandContext5.getSource()).source, Component.literal(String.format("Door '%s':", c0995sA.getId())));
                int i = 0;
                List<String> listM5587av = c0995sA.m5587av();
                if (!listM5587av.isEmpty()) {
                    Iterator<String> it = listM5587av.iterator();
                    while (it.hasNext()) {
                        int i2 = i;
                        i++;
                        C0721ms.m3329b(((CommandSourceStack) commandContext5.getSource()).source, Component.literal(String.format("- %s. Zone '%s'", Integer.valueOf(i2), it.next())));
                    }
                } else {
                    C0721ms.m3329b(((CommandSourceStack) commandContext5.getSource()).source, Component.literal("(Door has no zone triggers)"));
                }
            }
        })).m2840a("door", new C0620kx().m2840a("add", new C0620kx((commandContext6, strArr6) -> {
            Player player = ((CommandSourceStack) commandContext6.getSource()).source;
            Level level = player.level();
            String str = strArr6[0];
            String str2 = strArr6[1];
            try {
                int i = Integer.parseInt(str2);
                if (level.getBlockState(player.blockPosition()).getBlock() instanceof DoorBlock) {
                    C0721ms.m3329b(((CommandSourceStack) commandContext6.getSource()).source, Component.literal("Failed to create new door! (Invalid door position! No door block found.)"));
                } else {
                    this.f5659bw.add(new C0995sA(player.blockPosition(), str, new ObjectArrayList(), i));
                    C0721ms.m3329b(((CommandSourceStack) commandContext6.getSource()).source, Component.literal("Created new zombie door '" + str + "' with cost '" + i + "'. (" + this.f5659bw.size() + ")"));
                }
            } catch (NumberFormatException e) {
                C0721ms.m3329b(((CommandSourceStack) commandContext6.getSource()).source, Component.literal("Failed to create new door! (The door cost '" + str2 + "' is invalid)"));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"door", "cost"})).m2836a(C0622kz.f3554a)).m2840a("clear", new C0620kx((commandContext7, strArr7) -> {
            this.f5659bw.clear();
            C0721ms.m3329b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Successfully cleared all zombie doors. (" + this.f5659bw.size() + ")"));
        }).m2836a(C0622kz.f3554a)).m2840a("zone", new C0620kx().m2840a("add", new C0620kx((commandContext8, strArr8) -> {
            String str = strArr8[0];
            String str2 = strArr8[1];
            List<C0995sA> listM5790a = m5790a(str);
            if (listM5790a.isEmpty()) {
                C0721ms.m3329b(((CommandSourceStack) commandContext8.getSource()).source, Component.literal("Failed to add zone '" + str2 + "' to door. (No doors for ID '" + str + "' exist)"));
            } else {
                listM5790a.forEach(c0995sA -> {
                    c0995sA.m5587av().add(str2);
                });
                C0721ms.m3329b(((CommandSourceStack) commandContext8.getSource()).source, Component.literal("Successfully added zone '" + str2 + "' to " + listM5790a.size() + " doors."));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"door", "zone"})).m2842a((commandContext9, strArr9) -> {
            switch (strArr9.length) {
                case 0:
                    return m5785f();
                case 1:
                    return m5784e();
                default:
                    return List.of();
            }
        })).m2840a("remove", new C0620kx((commandContext10, strArr10) -> {
            String str = strArr10[0];
            String str2 = strArr10[1];
            List<C0995sA> listM5790a = m5790a(str);
            if (listM5790a.isEmpty()) {
                C0721ms.m3329b(((CommandSourceStack) commandContext10.getSource()).source, Component.literal("Failed to remove zone '" + str2 + "' from door. (No doors for ID '" + str + "' exist)"));
            } else {
                listM5790a.forEach(c0995sA -> {
                    c0995sA.m5587av().remove(str2);
                });
                C0721ms.m3329b(((CommandSourceStack) commandContext10.getSource()).source, Component.literal("Successfully removed zone '" + str2 + "' to " + listM5790a.size() + " doors."));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"door", "zone"})).m2842a((commandContext11, strArr11) -> {
            switch (strArr11.length) {
                case 0:
                    return m5785f();
                case 1:
                    return m5784e();
                default:
                    return List.of();
            }
        })).m2840a("clear", new C0620kx((commandContext12, strArr12) -> {
            String str = strArr12[0];
            List<C0995sA> listM5790a = m5790a(str);
            if (listM5790a.isEmpty()) {
                C0721ms.m3329b(((CommandSourceStack) commandContext12.getSource()).source, Component.literal("Failed to clear zones from door. (No doors for ID '" + str + "' exist)"));
            } else {
                listM5790a.forEach(c0995sA -> {
                    c0995sA.m5587av().clear();
                });
                C0721ms.m3329b(((CommandSourceStack) commandContext12.getSource()).source, Component.literal("Successfully cleared zones from " + listM5790a.size() + " doors."));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"door"})).m2842a((commandContext13, strArr13) -> {
            return strArr13.length == 0 ? m5785f() : List.of();
        })))).m2840a("zones", new C0620kx((commandContext14, strArr14) -> {
            Iterator<C1047sz> it = this.f5658bv.iterator();
            while (it.hasNext()) {
                C0721ms.m3329b(((CommandSourceStack) commandContext14.getSource()).source, Component.literal(String.format("Zone '%s':", it.next().m5857ap())));
            }
        })).m2840a("zone", new C0620kx().m2840a("add", new C0620kx((commandContext15, strArr15) -> {
            String str = strArr15[0];
            if (m5789a(str).isPresent()) {
                C0721ms.m3329b(((CommandSourceStack) commandContext15.getSource()).source, Component.literal("Failed to create new zone! (The zone '" + str + "' already exists)"));
            } else {
                this.f5658bv.add(new C1047sz(str));
                C0721ms.m3329b(((CommandSourceStack) commandContext15.getSource()).source, Component.literal("Successfully added a new zone '" + str + "'. (" + this.f5658bv.size() + ")"));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"name"}))).m2840a("remove", new C0620kx((commandContext16, strArr16) -> {
            String str = strArr16[0];
            if (m5789a(str).isEmpty()) {
                C0721ms.m3329b(((CommandSourceStack) commandContext16.getSource()).source, Component.literal("Failed to remove zone! (The zone '" + str + "' doesn't exists)"));
            } else {
                this.f5658bv.removeIf(c1047sz -> {
                    return c1047sz.m5857ap().equals(str);
                });
                C0721ms.m3329b(((CommandSourceStack) commandContext16.getSource()).source, Component.literal("Successfully removed zone '" + str + "'. (" + this.f5658bv.size() + ")"));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"name"})).m2842a((commandContext17, strArr17) -> {
            return strArr17.length == 0 ? m5784e() : List.of();
        })).m2840a("edit", new C0620kx().m2840a("spawn", new C0620kx().m2840a("add", new C0620kx((commandContext18, strArr18) -> {
            Player player = ((CommandSourceStack) commandContext18.getSource()).source;
            String str = strArr18[0];
            Optional<C1047sz> optionalM5789a = m5789a(str);
            if (optionalM5789a.isEmpty()) {
                C0721ms.m3329b(((CommandSourceStack) commandContext18.getSource()).source, Component.literal("Failed to add zombie spawn to zone! (The zone '" + str + "' doesn't exists)"));
                return;
            }
            C1047sz c1047sz = optionalM5789a.get();
            c1047sz.m5858au().add(new C1046sy(str, new C0881pt(player)));
            C0721ms.m3329b(((CommandSourceStack) commandContext18.getSource()).source, Component.literal("Successfully added zombie spawn to zone '" + str + "'. (" + c1047sz.m5858au().size() + ")"));
        }).m2836a(C0622kz.m2847a(new String[]{"zone"})).m2836a(C0622kz.f3554a).m2842a((commandContext19, strArr19) -> {
            return strArr19.length == 0 ? m5784e() : List.of();
        })).m2840a("clear", new C0620kx((commandContext20, strArr20) -> {
            String str = strArr20[0];
            Optional<C1047sz> optionalM5789a = m5789a(str);
            if (optionalM5789a.isEmpty()) {
                C0721ms.m3329b(((CommandSourceStack) commandContext20.getSource()).source, Component.literal("Failed to clear zombie spawns from zone! (The zone '" + str + "' doesn't exists)"));
                return;
            }
            C1047sz c1047sz = optionalM5789a.get();
            c1047sz.m5858au().clear();
            C0721ms.m3329b(((CommandSourceStack) commandContext20.getSource()).source, Component.literal("Successfully cleared zombie spawns from zone '" + str + "'. (" + c1047sz.m5858au().size() + ")"));
        }).m2836a(C0622kz.m2847a(new String[]{"zone"})).m2842a((commandContext21, strArr21) -> {
            return strArr21.length == 0 ? m5784e() : List.of();
        })))).m2840a("list", new C0620kx((commandContext22, strArr22) -> {
            C0721ms.m3329b(((CommandSourceStack) commandContext22.getSource()).source, Component.literal("All Zones:"));
            for (C1047sz c1047sz : this.f5658bv) {
                C0721ms.m3329b(((CommandSourceStack) commandContext22.getSource()).source, Component.literal(String.format("- '%s' - (%d spawns)", c1047sz.m5857ap(), Integer.valueOf(c1047sz.m5858au().size()))));
            }
        })));
        this.f5664a = null;
        this.f5665sa = 0;
        this.f5666sb = 1;
        this.f5667sc = 5;
        this.f5668sd = 0;
        this.f5669hr = false;
        this.f5670a = EnumC1045sx.GENERIC;
    }

    /* JADX INFO: renamed from: a */
    private void m5786a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull C0768nm c0768nm, @NotNull Set<UUID> set, @NotNull Set<UUID> set2) {
        set2.forEach(uuid -> {
            C0875pn.m4450a((AbstractC0531jN<?, ?, ?>) abstractC0531jN, this, uuid, C1062tN.f5748l);
            C0875pn.m4380a(uuid, new C1088tn(Component.translatable("bf.message.gamemode.infected.popup.wave.survive").withStyle(ChatFormatting.DARK_RED), 40));
        });
        C0875pn.m4353c(c0768nm.level(), c0768nm.position());
        serverLevel.playSound((Player) null, c0768nm, SoundEvents.WITHER_DEATH, SoundSource.AMBIENT, 10.0f, 0.5f);
        C0875pn.m4370a(this, (SoundEvent) this.f5670a.getRoundEndSound().get(), SoundSource.MUSIC);
        C0875pn.m4436a((AbstractC0863pb<?, ?, ?>) this, (Component) Component.translatable("bf.message.gamemode.infected.wave.complete", new Object[]{Component.literal(String.valueOf(this.f5666sb)).withStyle(ChatFormatting.RED), Component.literal(String.valueOf(set2.size())).withStyle(ChatFormatting.RED)}).withStyle(ChatFormatting.DARK_RED), 80, "inf.wave");
        set.forEach(uuid2 -> {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(uuid2);
            if (m5794l(uuid2)) {
                if (serverPlayerM4399a != null) {
                    C0875pn.m4467a((AbstractC0531jN<?, ?, ?>) abstractC0531jN, this.f4643b, serverLevel, serverPlayerM4399a);
                    return;
                }
                return;
            }
            C0875pn.m4450a((AbstractC0531jN<?, ?, ?>) abstractC0531jN, this, uuid2, C1062tN.f5778P);
        });
    }

    /* JADX INFO: renamed from: a */
    public void m5787a(@NotNull ServerLevel serverLevel, @NotNull C0881pt c0881pt) {
        if (this.f5664a != null) {
            this.f5664a.discard();
            this.f5664a = null;
        }
        this.f5664a = ((EntityType) C1307xu.f7596kD.get()).create(serverLevel);
        if (this.f5664a != null) {
            this.f5664a.mo3117e(this);
            this.f5664a.moveTo(c0881pt.f4827c, 0.0f, 0.0f);
            serverLevel.addFreshEntity(this.f5664a);
        }
    }

    /* JADX INFO: renamed from: h */
    public void m5788h(ServerLevel serverLevel) {
        EntityType entityType;
        C0881pt c0881ptM5791i = m5791i();
        serverLevel.getChunkAt(c0881ptM5791i.m4587c());
        if (this.f5670a == EnumC1045sx.DOGS) {
            entityType = (EntityType) C1307xu.f7626ld.get();
        } else {
            entityType = (EntityType) C1307xu.f7625lc.get();
            if (this.f5666sb >= 5 && Math.random() < 0.2d) {
                entityType = (EntityType) C1307xu.f7627le.get();
            }
            if (this.f5666sb >= 10 && Math.random() < 0.1d) {
                entityType = (EntityType) C1307xu.f7628lf.get();
            }
        }
        C0768nm c0768nm = (C0768nm) entityType.create(serverLevel);
        if (c0768nm != null) {
            c0768nm.mo3117e(this);
            c0768nm.moveTo(c0881ptM5791i.f4827c, 0.0f, 0.0f);
            serverLevel.addFreshEntity(c0768nm);
            mo5560a(c0768nm, (Level) serverLevel);
            C0875pn.m4353c((Level) serverLevel, c0768nm.position());
            this.f5662e.add(c0768nm.getId());
        }
        this.f5668sd = this.f5662e.size();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Optional<C1047sz> m5789a(@NotNull String str) {
        for (C1047sz c1047sz : this.f5658bv) {
            if (c1047sz.m5857ap().equals(str)) {
                return Optional.of(c1047sz);
            }
        }
        return Optional.empty();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<C0995sA> m5790a(@NotNull String str) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C0995sA c0995sA : this.f5659bw) {
            if (c0995sA.getId().equals(str)) {
                objectArrayList.add(c0995sA);
            }
        }
        return objectArrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    private C0881pt m5791i() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C1047sz c1047sz : this.f5658bv) {
            if (c1047sz.m5855bU() && !c1047sz.m5858au().isEmpty()) {
                objectArrayList.add(c1047sz);
            }
        }
        if (objectArrayList.isEmpty()) {
            throw new IllegalStateException("No active zombie zones with zombie spawns available");
        }
        return ((C1047sz) objectArrayList.get(threadLocalRandomCurrent.nextInt(objectArrayList.size()))).m5854a().m5849e();
    }

    /* JADX INFO: renamed from: bQ */
    private int m5792bQ() {
        int i = 0;
        Iterator<C1047sz> it = this.f5658bv.iterator();
        while (it.hasNext()) {
            if (it.next().m5855bU()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Set<UUID> m5793a(@NotNull Set<UUID> set) {
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        for (UUID uuid : set) {
            if (!m5794l(uuid)) {
                objectOpenHashSet.add(uuid);
            }
        }
        return objectOpenHashSet;
    }

    /* JADX INFO: renamed from: l */
    private boolean m5794l(@NotNull UUID uuid) {
        AbstractC0183b abstractC0183bM1152b = this.f4643b.m1152b(uuid);
        ServerPlayer serverPlayerM4399a = C0875pn.m4399a(uuid);
        return serverPlayerM4399a == null ? abstractC0183bM1152b.m1104dt() : C0875pn.m4488a((Player) serverPlayerM4399a, (AbstractC0183b<?, ?, ?, ?>) abstractC0183bM1152b);
    }

    /* JADX INFO: renamed from: a */
    public boolean m5795a(@NotNull ServerLevel serverLevel) {
        if (this.f5667sc <= 0) {
            return false;
        }
        int i = this.f5665sa;
        this.f5665sa = i - 1;
        if (i <= 0) {
            this.f5665sa = m5798bS();
            if (m5800a(serverLevel).size() < m5796bR()) {
                int iMo5565bI = (int) (1.0f + (mo5565bI() * 0.2f));
                for (int i2 = 0; i2 < iMo5565bI && this.f5667sc > 0; i2++) {
                    this.f5667sc--;
                    m5788h(serverLevel);
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: bR */
    private int m5796bR() {
        return 60;
    }

    /* JADX INFO: renamed from: b */
    public void m5797b(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f5665sa = 0;
        this.f5666sb++;
        this.f5662e.clear();
        if (this.f5666sb % 5 == 0) {
            this.f5670a = EnumC1045sx.DOGS;
        } else {
            this.f5670a = EnumC1045sx.GENERIC;
        }
        this.f5667sc = (int) Math.min(150.0f, 5 * mo5565bI() * this.f5670a.getCountMultiplier());
        this.f5670a.getRoundCallable().mo5845a(this, (Level) serverLevel, this.f5667sc, set);
        C0875pn.m4370a(this, (SoundEvent) this.f5670a.getRoundStartSound().get(), SoundSource.MUSIC);
        if (Math.random() < 0.20000000298023224d) {
            C0875pn.m4370a(this, (SoundEvent) C1312xz.f8149sO.get(), SoundSource.MASTER);
            C0875pn.m4436a(this, f5652jD, 80, "inf.store");
            m5803cW();
        } else if (Math.random() < 0.1d && this.f5669hr) {
            C0875pn.m4370a(this, (SoundEvent) C1312xz.f8148sN.get(), SoundSource.MASTER);
            C0875pn.m4436a(this, f5653jE, 80, "inf.store");
            m5787a(serverLevel, (C0881pt) C1267xG.m7152a(this.f5660bx));
        }
    }

    /* JADX INFO: renamed from: bS */
    private int m5798bS() {
        return Math.max(5, 40 - (2 * this.f5666sb)) / 20;
    }

    /* JADX INFO: renamed from: a */
    private float m5799a(@NotNull C0768nm c0768nm) {
        return Math.min(5.0f + (0.25f * mo5565bI()), c0768nm.getMaxHealth());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public IntSet m5800a(@NotNull ServerLevel serverLevel) {
        IntOpenHashSet intOpenHashSet = new IntOpenHashSet();
        IntIterator it = this.f5662e.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            Entity entity = serverLevel.getEntity(iIntValue);
            if (entity != null && entity.isAlive()) {
                intOpenHashSet.add(iIntValue);
            }
        }
        return intOpenHashSet;
    }

    /* JADX INFO: renamed from: a */
    private boolean m5801a(@NotNull Player player, int i) {
        for (UUID uuid : m4018b().m4245h()) {
            if (!player.getUUID().equals(uuid) && C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this, uuid, C1062tN.f5780R) == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public int m5802b(@NotNull Player player) {
        int i = 0;
        while (m5801a(player, i)) {
            i++;
        }
        return i;
    }

    /* JADX INFO: renamed from: cW */
    public void m5803cW() {
        this.f5661by.clear();
        while (this.f5661by.size() < 6) {
            C0886py c0886py = (C0886py) C1267xG.m7152a(C1044sw.f5688bA);
            if (!this.f5661by.contains(c0886py)) {
                this.f5661by.add(c0886py);
            }
        }
        if (this.f5664a != null) {
            this.f5664a.setItemInHand(InteractionHand.MAIN_HAND, ((C0886py) this.f5661by.getFirst()).m4636c().copy());
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1041st mo3995a(@NotNull C0623l c0623l) {
        return new C1041st(c0623l, this, (C0396gl) this.f4643b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1042su mo3996a() {
        return new C1042su(this, this.f4643b);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1056tH<C1040ss, C1042su> mo3999a() {
        return new C1055tG(C1000sF::new);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: f */
    public Set<AbstractC0863pb.a> mo4085f() {
        return EnumSet.of(AbstractC0863pb.a.MAP_TYPE, AbstractC0863pb.a.LOBBY);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: h */
    public void mo4083h(@NotNull List<MutableComponent> list) {
        if (this.f5658bv.isEmpty()) {
            list.add(Component.literal("Zones in game '" + this.f4630bN + "' are missing."));
        }
        boolean z = false;
        Iterator<C1047sz> it = this.f5658bv.iterator();
        while (it.hasNext()) {
            if (!it.next().m5858au().isEmpty()) {
                z = true;
                break;
            }
        }
        if (!z) {
            list.add(Component.literal("Game '" + this.f4630bN + "' has no zombie spawns in any of its zones."));
        }
        if (m5789a("main").isEmpty()) {
            list.add(Component.literal("A 'main' zone for game '" + this.f4630bN + "' is missing. One is required."));
        }
        for (C0995sA c0995sA : this.f5659bw) {
            if (c0995sA.m5587av().isEmpty()) {
                list.add(Component.literal("Door '" + c0995sA.getId() + "' does not have any affiliated zones."));
            }
        }
        super.mo4083h(list);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4006a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f4644a.m5875b(abstractC0531jN, abstractC0184c, serverLevel);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bj */
    protected boolean mo4011bj() {
        return this.f5666sb >= 5;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx mo4082a() {
        return super.mo4082a().m2835a(this.f5663g);
    }

    @Override // com.boehmod.blockfront.InterfaceC0987rt
    /* JADX INFO: renamed from: bI */
    public int mo5565bI() {
        return this.f5666sb + (m5792bQ() - 1);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public boolean mo4033a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull EnumC0876po enumC0876po, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0872pk c0872pkA = ((C1042su) this.f4642a).m4242a(C1042su.f5680cG);
        if (c0872pkA == null) {
            C0530jM.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C1042su) this.f4642a).m4212a(abstractC0531jN, enumC0876po, serverLevel, serverPlayer, c0872pkA);
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: d */
    public void mo4041d(@Nullable Level level) {
        m5803cW();
        this.f5669hr = false;
        this.f5670a = EnumC1045sx.GENERIC;
        this.f5658bv.forEach((v0) -> {
            v0.m5853cX();
        });
        this.f5659bw.forEach((v0) -> {
            v0.m5585cY();
        });
        if (level != null) {
            Iterator<C0995sA> it = this.f5659bw.iterator();
            while (it.hasNext()) {
                it.next().m5586a(level, false);
            }
        }
        this.f5665sa = 0;
        this.f5666sb = 1;
        this.f5667sc = 5;
        this.f5662e.clear();
        this.f5664a = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4050a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.mo4050a(byteBuf, z);
        IPacket.writeEnum(byteBuf, this.f5670a);
        byteBuf.writeInt(this.f5667sc);
        byteBuf.writeInt(this.f5668sd);
        byteBuf.writeInt(this.f5666sb);
        byteBuf.writeInt(this.f5659bw.size());
        Iterator<C0995sA> it = this.f5659bw.iterator();
        while (it.hasNext()) {
            it.next().m5593c(byteBuf);
        }
        byteBuf.writeInt(this.f5658bv.size());
        Iterator<C1047sz> it2 = this.f5658bv.iterator();
        while (it2.hasNext()) {
            it2.next().m5852c(byteBuf);
        }
        byteBuf.writeInt(this.f5661by.size());
        for (C0886py c0886py : this.f5661by) {
            IPacket.writeString(byteBuf, BuiltInRegistries.ITEM.getKey(c0886py.m4636c().getItem()).toString());
            byteBuf.writeInt(c0886py.m4637bz());
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: g */
    public void mo4052g(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo4052g(byteBuf);
        this.f5670a = (EnumC1045sx) IPacket.readEnum(byteBuf, EnumC1045sx.class);
        this.f5667sc = byteBuf.readInt();
        this.f5668sd = byteBuf.readInt();
        this.f5666sb = byteBuf.readInt();
        this.f5659bw.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C0995sA c0995sA = new C0995sA();
            c0995sA.m5592b(byteBuf);
            this.f5659bw.add(c0995sA);
        }
        this.f5658bv.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            C1047sz c1047sz = new C1047sz();
            c1047sz.m5851b(byteBuf);
            this.f5658bv.add(c1047sz);
        }
        this.f5661by.clear();
        int i5 = byteBuf.readInt();
        for (int i6 = 0; i6 < i5; i6++) {
            this.f5661by.add(new C0886py(C1272xL.m7220f(IPacket.readString(byteBuf)).get(), byteBuf.readInt()));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: f */
    public boolean mo4045f(@NotNull Player player) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bl */
    public boolean mo4047bl() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0878pq mo4046a() {
        return EnumC0878pq.SAME_TEAM;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bl */
    public int mo4053bl() {
        return 1;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: e */
    public boolean mo4044e(@NotNull Player player) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bn */
    public boolean mo4057bn() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: bp */
    public boolean mo4071bp() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public CloudAchievement mo4072a() {
        return CloudAchievements.ACH_MATCH_WIN_INF;
    }

    @Override // com.boehmod.blockfront.InterfaceC0987rt
    /* JADX INFO: renamed from: a */
    public void mo5560a(@NotNull C0768nm c0768nm, @NotNull Level level) {
        this.f5670a.getRoundCallable().mo5846a(this.f4643b, this, c0768nm, level);
        c0768nm.setHealth(m5799a(c0768nm));
    }

    @Override // com.boehmod.blockfront.InterfaceC0987rt
    /* JADX INFO: renamed from: a */
    public void mo5561a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull C0768nm c0768nm, @NotNull DamageSource damageSource) {
        Set<UUID> setH = ((C1042su) this.f4642a).m4245h();
        Set<UUID> setM5793a = m5793a(setH);
        Player entity = damageSource.getEntity();
        if (entity instanceof Player) {
            UUID uuid = entity.getUUID();
            C0875pn.m4450a(abstractC0531jN, this, uuid, C1062tN.f5748l);
            if (damageSource instanceof C0724mv) {
                C0875pn.m4451a(abstractC0531jN, this, uuid, C1062tN.f5755s, ((C0724mv) damageSource).m3338az() ? 20 : 10);
            } else {
                C0875pn.m4451a(abstractC0531jN, this, uuid, C1062tN.f5755s, 35);
            }
        }
        if (c0768nm instanceof C0769nn) {
            C0875pn.m4353c(c0768nm.level(), c0768nm.position());
            serverLevel.addParticle(ParticleTypes.FLASH, c0768nm.getX(), c0768nm.getY(), c0768nm.getZ(), 0.0d, 0.0d, 0.0d);
            serverLevel.playSound((Player) null, c0768nm, SoundEvents.WITHER_DEATH, SoundSource.AMBIENT, 10.0f, 1.5f);
        }
        this.f5668sd = m5800a(serverLevel).size();
        if (this.f5668sd == 0 && this.f5667sc <= 0) {
            m5786a(abstractC0531jN, serverLevel, c0768nm, setH, setM5793a);
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0987rt
    /* JADX INFO: renamed from: a */
    public void mo5562a(@NotNull C0768nm c0768nm, @NotNull Player player) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0987rt
    /* JADX INFO: renamed from: a */
    public void mo5563a(@NotNull ServerLevel serverLevel, @NotNull C0768nm c0768nm) {
        if (c0768nm.getTarget() == null) {
            Predicate<LivingEntity> predicateM3633a = c0768nm.m3633a(this.f4643b);
            for (ServerPlayer serverPlayer : serverLevel.players()) {
                if (predicateM3633a.test(serverPlayer)) {
                    c0768nm.setTarget(serverPlayer);
                    return;
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0987rt
    /* JADX INFO: renamed from: a */
    public boolean mo5564a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull C0768nm c0768nm, @NotNull DamageSource damageSource, float f) {
        Player entity = damageSource.getEntity();
        if (entity instanceof Player) {
            UUID uuid = entity.getUUID();
            if (f < c0768nm.getHealth()) {
                C0875pn.m4451a(abstractC0531jN, this, uuid, C1062tN.f5755s, 2);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0986rs
    /* JADX INFO: renamed from: i */
    public boolean mo5301i(@NotNull Player player) {
        return player.getHealth() < player.getMaxHealth();
    }

    @Override // com.boehmod.blockfront.InterfaceC0986rs
    /* JADX INFO: renamed from: a */
    public float mo5302a(@NotNull Player player) {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0986rs
    /* JADX INFO: renamed from: a */
    public int mo5303a(@NotNull Player player) {
        return 20;
    }

    @Override // com.boehmod.blockfront.InterfaceC0985rr
    /* JADX INFO: renamed from: a */
    public boolean mo5557a(@NotNull Player player, @NotNull C0886py c0886py) {
        return C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this, player.getUUID(), C1062tN.f5755s) >= c0886py.m4637bz();
    }

    @Override // com.boehmod.blockfront.InterfaceC0985rr
    /* JADX INFO: renamed from: a */
    public void mo5558a(@NotNull ServerPlayer serverPlayer, @NotNull C0886py c0886py) {
        Level level = serverPlayer.level();
        UUID uuid = serverPlayer.getUUID();
        if (!mo5557a((Player) serverPlayer, c0886py)) {
            C0875pn.m4406c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.infected.store.buy.fail", new Object[]{Component.translatable(c0886py.m4636c().getDescriptionId()).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED));
            return;
        }
        this.f5669hr = true;
        Vec3 vec3Position = serverPlayer.position();
        float eyeHeight = serverPlayer.getEyeHeight();
        level.playSound((Player) null, vec3Position.x, vec3Position.y + ((double) eyeHeight), vec3Position.z, (SoundEvent) C1312xz.f8147sM.get(), SoundSource.AMBIENT, 1.0f, 1.0f);
        ItemStack itemStackM4636c = c0886py.m4636c();
        Item item = itemStackM4636c.getItem();
        if (item instanceof C1117uP) {
            C1117uP c1117uP = (C1117uP) item;
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6808s = c1117uP.m6384a(itemStackM4636c).m6808s();
            if (deferredHolderM6808s != null) {
                level.playSound(serverPlayer, vec3Position.x, vec3Position.y + ((double) eyeHeight), vec3Position.z, (SoundEvent) deferredHolderM6808s.get(), SoundSource.AMBIENT, 1.0f, 1.0f);
            }
            serverPlayer.getInventory().setItem(c1117uP.m6364cE() ? 0 : 1, itemStackM4636c.copy());
        }
        C0875pn.m4455b(this, uuid, C1062tN.f5755s, c0886py.m4637bz());
        C0875pn.m4406c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.infected.store.buy", new Object[]{Component.translatable(itemStackM4636c.getDescriptionId()).withStyle(ChatFormatting.GRAY), Component.literal(String.valueOf(c0886py.m4637bz()))}).withStyle(ChatFormatting.GREEN));
    }

    @Override // com.boehmod.blockfront.InterfaceC0985rr
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0886py mo5559a(@NotNull Player player, @NotNull Item item) {
        for (C0886py c0886py : this.f5661by) {
            if (c0886py.m4636c().getItem() == item) {
                return c0886py;
            }
        }
        return null;
    }

    @Override // com.boehmod.blockfront.InterfaceC0990rw
    /* JADX INFO: renamed from: bM */
    public boolean mo5348bM() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0863pb
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0950rI mo4042a() {
        return new InterfaceC0950rI.e(List.copyOf(((C1042su) this.f4642a).m5841as()), List.copyOf(this.f5659bw), List.copyOf(this.f5658bv), List.copyOf(this.f5660bx));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0863pb
    /* JADX INFO: renamed from: a */
    public void mo4043a(@NotNull InterfaceC0950rI interfaceC0950rI) throws MatchException {
        if (interfaceC0950rI instanceof InterfaceC0950rI.e) {
            InterfaceC0950rI.e eVar = (InterfaceC0950rI.e) interfaceC0950rI;
            try {
                List<C0881pt> listM5243Z = eVar.m5243Z();
                List<C0995sA> listM5244aa = eVar.m5244aa();
                List<C1047sz> listM5245ab = eVar.m5245ab();
                List<C0881pt> listM5246ac = eVar.m5246ac();
                ((C1042su) this.f4642a).m5843cV();
                Iterator<C0881pt> it = listM5243Z.iterator();
                while (it.hasNext()) {
                    ((C1042su) this.f4642a).m5842d(it.next());
                }
                this.f5659bw.clear();
                this.f5659bw.addAll(listM5244aa);
                this.f5658bv.clear();
                this.f5658bv.addAll(listM5245ab);
                this.f5660bx.clear();
                this.f5660bx.addAll(listM5246ac);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
