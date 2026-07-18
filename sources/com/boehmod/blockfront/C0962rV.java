package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.InterfaceC0978rl;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.rV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rV.class */
public final class C0962rV extends AbstractC0787oF<C0962rV, C0964rX, C1086tm<C0962rV, C0964rX>> implements InterfaceC0908qU, InterfaceC0909qV, InterfaceC0910qW, InterfaceC0913qZ {

    /* JADX INFO: renamed from: jq */
    private static final Component f5075jq = Component.translatable("bf.message.gamemode.infected.store.resupply").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: jr */
    private static final Component f5076jr = Component.translatable("bf.message.gamemode.infected.store.relocate").withStyle(ChatFormatting.YELLOW);

    /* JADX INFO: renamed from: pV */
    private static final int f5077pV = 6;

    /* JADX INFO: renamed from: pW */
    public static final int f5078pW = 5;

    /* JADX INFO: renamed from: pX */
    public static final int f5079pX = 30;

    /* JADX INFO: renamed from: pY */
    public static final int f5080pY = 60;

    /* JADX INFO: renamed from: bo */
    @NotNull
    public final List<C1022sc> f5081bo;

    /* JADX INFO: renamed from: bp */
    @NotNull
    public final List<C1023sd> f5082bp;

    /* JADX INFO: renamed from: bq */
    @NotNull
    public final List<C0805oX> f5083bq;

    /* JADX INFO: renamed from: br */
    @NotNull
    public final List<C0863pc> f5084br;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final IntSet f5085c;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final C0597kb f5086g;

    /* JADX INFO: renamed from: a */
    @Nullable
    public C0700mY f5087a;

    /* JADX INFO: renamed from: pZ */
    public int f5088pZ;

    /* JADX INFO: renamed from: qa */
    public int f5089qa;

    /* JADX INFO: renamed from: qb */
    public int f5090qb;

    /* JADX INFO: renamed from: qc */
    public int f5091qc;

    /* JADX INFO: renamed from: gX */
    public boolean f5092gX;

    /* JADX INFO: renamed from: a */
    @NotNull
    public EnumC1020sa f5093a;

    @NotNull
    /* JADX INFO: renamed from: e */
    private Collection<String> m5247e() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator<C1022sc> it = this.f5081bo.iterator();
        while (it.hasNext()) {
            objectArrayList.add(it.next().m5694ai());
        }
        return objectArrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    private Collection<String> m5248f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C1023sd c1023sd : this.f5082bp) {
            if (!objectArrayList.contains(c1023sd.getId())) {
                objectArrayList.add(c1023sd.getId());
            }
        }
        return objectArrayList;
    }

    public C0962rV(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        super(abstractC0563ju, "inf", "Infected");
        this.f5081bo = new ObjectArrayList();
        this.f5082bp = new ObjectArrayList();
        this.f5083bq = new ObjectArrayList();
        this.f5084br = new ObjectArrayList();
        this.f5085c = new IntOpenHashSet();
        this.f5086g = new C0597kb().m2628a("vendor", new C0597kb().m2628a("add", new C0597kb((commandContext, strArr) -> {
            this.f5083bq.add(new C0805oX(((CommandSourceStack) commandContext.getSource()).source));
            C0645lW.m2898b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Successfully added new vendor spawn. (" + this.f5083bq.size() + ")"));
        }).m2624a(C0599kd.f3307a)).m2628a("clear", new C0597kb((commandContext2, strArr2) -> {
            this.f5083bq.clear();
            C0645lW.m2898b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Successfully cleared all vendor spawns. (" + this.f5083bq.size() + ")"));
        }))).m2628a("spawn", new C0597kb().m2628a("add", new C0597kb((commandContext3, strArr3) -> {
            m3582b().m5305d(new C0805oX(((CommandSourceStack) commandContext3.getSource()).source));
            C0645lW.m2898b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal("Successfully added new random spawn. (" + m3582b().m5304aq().size() + ")"));
        }).m2624a(C0599kd.f3307a)).m2628a("clear", new C0597kb((commandContext4, strArr4) -> {
            m3582b().m5306cJ();
            C0645lW.m2898b(((CommandSourceStack) commandContext4.getSource()).source, Component.literal("Successfully cleared all random spawns."));
        }))).m2628a("doors", new C0597kb((commandContext5, strArr5) -> {
            for (C1023sd c1023sd : this.f5082bp) {
                C0645lW.m2898b(((CommandSourceStack) commandContext5.getSource()).source, Component.literal(String.format("Door '%s':", c1023sd.getId())));
                int i = 0;
                List<String> listM5702at = c1023sd.m5702at();
                if (!listM5702at.isEmpty()) {
                    Iterator<String> it = listM5702at.iterator();
                    while (it.hasNext()) {
                        int i2 = i;
                        i++;
                        C0645lW.m2898b(((CommandSourceStack) commandContext5.getSource()).source, Component.literal(String.format("- %s. Zone '%s'", Integer.valueOf(i2), it.next())));
                    }
                } else {
                    C0645lW.m2898b(((CommandSourceStack) commandContext5.getSource()).source, Component.literal("(Door has no zone triggers)"));
                }
            }
        })).m2628a("door", new C0597kb().m2628a("add", new C0597kb((commandContext6, strArr6) -> {
            Player player = ((CommandSourceStack) commandContext6.getSource()).source;
            Level level = player.level();
            String str = strArr6[0];
            String str2 = strArr6[1];
            try {
                int i = Integer.parseInt(str2);
                if (level.getBlockState(player.blockPosition()).getBlock() instanceof DoorBlock) {
                    C0645lW.m2898b(((CommandSourceStack) commandContext6.getSource()).source, Component.literal("Failed to create new door! (Invalid door position! No door block found.)"));
                } else {
                    this.f5082bp.add(new C1023sd(player.blockPosition(), str, new ObjectArrayList(), i));
                    C0645lW.m2898b(((CommandSourceStack) commandContext6.getSource()).source, Component.literal("Created new zombie door '" + str + "' with cost '" + i + "'. (" + this.f5082bp.size() + ")"));
                }
            } catch (NumberFormatException e) {
                C0645lW.m2898b(((CommandSourceStack) commandContext6.getSource()).source, Component.literal("Failed to create new door! (The door cost '" + str2 + "' is invalid)"));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"door", "cost"})).m2624a(C0599kd.f3307a)).m2628a("clear", new C0597kb((commandContext7, strArr7) -> {
            this.f5082bp.clear();
            C0645lW.m2898b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Successfully cleared all zombie doors. (" + this.f5082bp.size() + ")"));
        }).m2624a(C0599kd.f3307a)).m2628a("zone", new C0597kb().m2628a("add", new C0597kb((commandContext8, strArr8) -> {
            String str = strArr8[0];
            String str2 = strArr8[1];
            List<C1023sd> listM5253a = m5253a(str);
            if (listM5253a.isEmpty()) {
                C0645lW.m2898b(((CommandSourceStack) commandContext8.getSource()).source, Component.literal("Failed to add zone '" + str2 + "' to door. (No doors for ID '" + str + "' exist)"));
            } else {
                listM5253a.forEach(c1023sd -> {
                    c1023sd.m5702at().add(str2);
                });
                C0645lW.m2898b(((CommandSourceStack) commandContext8.getSource()).source, Component.literal("Successfully added zone '" + str2 + "' to " + listM5253a.size() + " doors."));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"door", "zone"})).m2630a((commandContext9, strArr9) -> {
            switch (strArr9.length) {
                case 0:
                    return m5248f();
                case 1:
                    return m5247e();
                default:
                    return List.of();
            }
        })).m2628a("remove", new C0597kb((commandContext10, strArr10) -> {
            String str = strArr10[0];
            String str2 = strArr10[1];
            List<C1023sd> listM5253a = m5253a(str);
            if (listM5253a.isEmpty()) {
                C0645lW.m2898b(((CommandSourceStack) commandContext10.getSource()).source, Component.literal("Failed to remove zone '" + str2 + "' from door. (No doors for ID '" + str + "' exist)"));
            } else {
                listM5253a.forEach(c1023sd -> {
                    c1023sd.m5702at().remove(str2);
                });
                C0645lW.m2898b(((CommandSourceStack) commandContext10.getSource()).source, Component.literal("Successfully removed zone '" + str2 + "' to " + listM5253a.size() + " doors."));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"door", "zone"})).m2630a((commandContext11, strArr11) -> {
            switch (strArr11.length) {
                case 0:
                    return m5248f();
                case 1:
                    return m5247e();
                default:
                    return List.of();
            }
        })).m2628a("clear", new C0597kb((commandContext12, strArr12) -> {
            String str = strArr12[0];
            List<C1023sd> listM5253a = m5253a(str);
            if (listM5253a.isEmpty()) {
                C0645lW.m2898b(((CommandSourceStack) commandContext12.getSource()).source, Component.literal("Failed to clear zones from door. (No doors for ID '" + str + "' exist)"));
            } else {
                listM5253a.forEach(c1023sd -> {
                    c1023sd.m5702at().clear();
                });
                C0645lW.m2898b(((CommandSourceStack) commandContext12.getSource()).source, Component.literal("Successfully cleared zones from " + listM5253a.size() + " doors."));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"door"})).m2630a((commandContext13, strArr13) -> {
            return strArr13.length == 0 ? m5248f() : List.of();
        })))).m2628a("zones", new C0597kb((commandContext14, strArr14) -> {
            Iterator<C1022sc> it = this.f5081bo.iterator();
            while (it.hasNext()) {
                C0645lW.m2898b(((CommandSourceStack) commandContext14.getSource()).source, Component.literal(String.format("Zone '%s':", it.next().m5694ai())));
            }
        })).m2628a("zone", new C0597kb().m2628a("add", new C0597kb((commandContext15, strArr15) -> {
            String str = strArr15[0];
            if (m5252a(str).isPresent()) {
                C0645lW.m2898b(((CommandSourceStack) commandContext15.getSource()).source, Component.literal("Failed to create new zone! (The zone '" + str + "' already exists)"));
            } else {
                this.f5081bo.add(new C1022sc(str));
                C0645lW.m2898b(((CommandSourceStack) commandContext15.getSource()).source, Component.literal("Successfully added a new zone '" + str + "'. (" + this.f5081bo.size() + ")"));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"name"}))).m2628a("remove", new C0597kb((commandContext16, strArr16) -> {
            String str = strArr16[0];
            if (m5252a(str).isEmpty()) {
                C0645lW.m2898b(((CommandSourceStack) commandContext16.getSource()).source, Component.literal("Failed to remove zone! (The zone '" + str + "' doesn't exists)"));
            } else {
                this.f5081bo.removeIf(c1022sc -> {
                    return c1022sc.m5694ai().equals(str);
                });
                C0645lW.m2898b(((CommandSourceStack) commandContext16.getSource()).source, Component.literal("Successfully removed zone '" + str + "'. (" + this.f5081bo.size() + ")"));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"name"})).m2630a((commandContext17, strArr17) -> {
            return strArr17.length == 0 ? m5247e() : List.of();
        })).m2628a("edit", new C0597kb().m2628a("spawn", new C0597kb().m2628a("add", new C0597kb((commandContext18, strArr18) -> {
            Player player = ((CommandSourceStack) commandContext18.getSource()).source;
            String str = strArr18[0];
            Optional<C1022sc> optionalM5252a = m5252a(str);
            if (optionalM5252a.isEmpty()) {
                C0645lW.m2898b(((CommandSourceStack) commandContext18.getSource()).source, Component.literal("Failed to add zombie spawn to zone! (The zone '" + str + "' doesn't exists)"));
                return;
            }
            C1022sc c1022sc = optionalM5252a.get();
            c1022sc.m5695as().add(new C1021sb(str, new C0805oX(player)));
            C0645lW.m2898b(((CommandSourceStack) commandContext18.getSource()).source, Component.literal("Successfully added zombie spawn to zone '" + str + "'. (" + c1022sc.m5695as().size() + ")"));
        }).m2624a(C0599kd.m2635a(new String[]{"zone"})).m2624a(C0599kd.f3307a).m2630a((commandContext19, strArr19) -> {
            return strArr19.length == 0 ? m5247e() : List.of();
        })).m2628a("clear", new C0597kb((commandContext20, strArr20) -> {
            String str = strArr20[0];
            Optional<C1022sc> optionalM5252a = m5252a(str);
            if (optionalM5252a.isEmpty()) {
                C0645lW.m2898b(((CommandSourceStack) commandContext20.getSource()).source, Component.literal("Failed to clear zombie spawns from zone! (The zone '" + str + "' doesn't exists)"));
                return;
            }
            C1022sc c1022sc = optionalM5252a.get();
            c1022sc.m5695as().clear();
            C0645lW.m2898b(((CommandSourceStack) commandContext20.getSource()).source, Component.literal("Successfully cleared zombie spawns from zone '" + str + "'. (" + c1022sc.m5695as().size() + ")"));
        }).m2624a(C0599kd.m2635a(new String[]{"zone"})).m2630a((commandContext21, strArr21) -> {
            return strArr21.length == 0 ? m5247e() : List.of();
        })))).m2628a("list", new C0597kb((commandContext22, strArr22) -> {
            C0645lW.m2898b(((CommandSourceStack) commandContext22.getSource()).source, Component.literal("All Zones:"));
            for (C1022sc c1022sc : this.f5081bo) {
                C0645lW.m2898b(((CommandSourceStack) commandContext22.getSource()).source, Component.literal(String.format("- '%s' - (%d spawns)", c1022sc.m5694ai(), Integer.valueOf(c1022sc.m5695as().size()))));
            }
        })));
        this.f5087a = null;
        this.f5088pZ = 0;
        this.f5089qa = 1;
        this.f5090qb = 5;
        this.f5091qc = 0;
        this.f5092gX = false;
        this.f5093a = EnumC1020sa.GENERIC;
    }

    /* JADX INFO: renamed from: a */
    private void m5249a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull C0692mQ c0692mQ, @NotNull Set<UUID> set, @NotNull Set<UUID> set2) {
        set2.forEach(uuid -> {
            C0799oR.m4014a((AbstractC0563ju<?, ?, ?>) abstractC0563ju, this, uuid, C1089tp.f5695l);
            C0799oR.m3944a(uuid, new C1010sQ(Component.translatable("bf.message.gamemode.infected.popup.wave.survive").withStyle(ChatFormatting.DARK_RED), 40));
        });
        C0799oR.m3917c(c0692mQ.level(), c0692mQ.position());
        serverLevel.playSound((Player) null, c0692mQ, SoundEvents.WITHER_DEATH, SoundSource.AMBIENT, 10.0f, 0.5f);
        C0799oR.m3934a(this, (SoundEvent) this.f5093a.getRoundEndSound().get(), SoundSource.MUSIC);
        C0799oR.m4000a((AbstractC0787oF<?, ?, ?>) this, (Component) Component.translatable("bf.message.gamemode.infected.wave.complete", new Object[]{Component.literal(String.valueOf(this.f5089qa)).withStyle(ChatFormatting.RED), Component.literal(String.valueOf(set2.size())).withStyle(ChatFormatting.RED)}).withStyle(ChatFormatting.DARK_RED), 80, "inf.wave");
        set.forEach(uuid2 -> {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(uuid2);
            if (m5257l(uuid2)) {
                if (serverPlayerM3963a != null) {
                    C0799oR.m4031a((AbstractC0563ju<?, ?, ?>) abstractC0563ju, this.f4249b, serverLevel, serverPlayerM3963a);
                    return;
                }
                return;
            }
            C0799oR.m4014a((AbstractC0563ju<?, ?, ?>) abstractC0563ju, this, uuid2, C1089tp.f5725P);
        });
    }

    /* JADX INFO: renamed from: a */
    public void m5250a(@NotNull ServerLevel serverLevel, @NotNull C0805oX c0805oX) {
        if (this.f5087a != null) {
            this.f5087a.discard();
            this.f5087a = null;
        }
        this.f5087a = ((EntityType) C1230wX.f7031kD.get()).create(serverLevel);
        if (this.f5087a != null) {
            this.f5087a.mo3282e(this);
            this.f5087a.moveTo(c0805oX.f4424c, 0.0f, 0.0f);
            serverLevel.addFreshEntity(this.f5087a);
        }
    }

    /* JADX INFO: renamed from: h */
    public void m5251h(ServerLevel serverLevel) {
        EntityType entityType;
        C0805oX c0805oXM5254i = m5254i();
        serverLevel.getChunkAt(c0805oXM5254i.m4150c());
        if (this.f5093a == EnumC1020sa.DOGS) {
            entityType = (EntityType) C1230wX.f7061ld.get();
        } else {
            entityType = (EntityType) C1230wX.f7060lc.get();
            if (this.f5089qa >= 5 && Math.random() < 0.2d) {
                entityType = (EntityType) C1230wX.f7062le.get();
            }
            if (this.f5089qa >= 10 && Math.random() < 0.1d) {
                entityType = (EntityType) C1230wX.f7063lf.get();
            }
        }
        C0692mQ c0692mQ = (C0692mQ) entityType.create(serverLevel);
        if (c0692mQ != null) {
            c0692mQ.mo3282e(this);
            c0692mQ.moveTo(c0805oXM5254i.f4424c, 0.0f, 0.0f);
            serverLevel.addFreshEntity(c0692mQ);
            mo4689a(c0692mQ, (Level) serverLevel);
            C0799oR.m3917c((Level) serverLevel, c0692mQ.position());
            this.f5085c.add(c0692mQ.getId());
        }
        this.f5091qc = this.f5085c.size();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Optional<C1022sc> m5252a(@NotNull String str) {
        for (C1022sc c1022sc : this.f5081bo) {
            if (c1022sc.m5694ai().equals(str)) {
                return Optional.of(c1022sc);
            }
        }
        return Optional.empty();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<C1023sd> m5253a(@NotNull String str) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C1023sd c1023sd : this.f5082bp) {
            if (c1023sd.getId().equals(str)) {
                objectArrayList.add(c1023sd);
            }
        }
        return objectArrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    private C0805oX m5254i() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C1022sc c1022sc : this.f5081bo) {
            if (c1022sc.m5692bK() && !c1022sc.m5695as().isEmpty()) {
                objectArrayList.add(c1022sc);
            }
        }
        if (objectArrayList.isEmpty()) {
            throw new IllegalStateException("No active zombie zones with zombie spawns available");
        }
        return ((C1022sc) objectArrayList.get(threadLocalRandomCurrent.nextInt(objectArrayList.size()))).m5691a().m5686e();
    }

    /* JADX INFO: renamed from: bB */
    private int m5255bB() {
        int i = 0;
        Iterator<C1022sc> it = this.f5081bo.iterator();
        while (it.hasNext()) {
            if (it.next().m5692bK()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Set<UUID> m5256a(@NotNull Set<UUID> set) {
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        for (UUID uuid : set) {
            if (!m5257l(uuid)) {
                objectOpenHashSet.add(uuid);
            }
        }
        return objectOpenHashSet;
    }

    /* JADX INFO: renamed from: l */
    private boolean m5257l(@NotNull UUID uuid) {
        AbstractC0182b abstractC0182bM1135b = this.f4249b.m1135b(uuid);
        ServerPlayer serverPlayerM3963a = C0799oR.m3963a(uuid);
        return serverPlayerM3963a == null ? abstractC0182bM1135b.m1087dk() : C0799oR.m4052a((Player) serverPlayerM3963a, (AbstractC0182b<?, ?, ?, ?>) abstractC0182bM1135b);
    }

    /* JADX INFO: renamed from: a */
    public boolean m5258a(@NotNull ServerLevel serverLevel) {
        if (this.f5090qb <= 0) {
            return false;
        }
        int i = this.f5088pZ;
        this.f5088pZ = i - 1;
        if (i <= 0) {
            this.f5088pZ = m5261bD();
            if (m5263a(serverLevel).size() < m5259bC()) {
                int iMo4694bt = (int) (1.0f + (mo4694bt() * 0.2f));
                for (int i2 = 0; i2 < iMo4694bt && this.f5090qb > 0; i2++) {
                    this.f5090qb--;
                    m5251h(serverLevel);
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: bC */
    private int m5259bC() {
        return 60;
    }

    /* JADX INFO: renamed from: b */
    public void m5260b(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f5088pZ = 0;
        this.f5089qa++;
        this.f5085c.clear();
        if (this.f5089qa % 5 == 0) {
            this.f5093a = EnumC1020sa.DOGS;
        } else {
            this.f5093a = EnumC1020sa.GENERIC;
        }
        this.f5090qb = (int) Math.min(150.0f, 5 * mo4694bt() * this.f5093a.getCountMultiplier());
        this.f5093a.getRoundCallable().mo5682a(this, (Level) serverLevel, this.f5090qb, set);
        C0799oR.m3934a(this, (SoundEvent) this.f5093a.getRoundStartSound().get(), SoundSource.MUSIC);
        if (Math.random() < 0.20000000298023224d) {
            C0799oR.m3934a(this, (SoundEvent) C1280xc.f7738sN.get(), SoundSource.MASTER);
            C0799oR.m4000a(this, f5075jq, 80, "inf.store");
            m5266cK();
        } else if (Math.random() < 0.1d && this.f5092gX) {
            C0799oR.m3934a(this, (SoundEvent) C1280xc.f7737sM.get(), SoundSource.MASTER);
            C0799oR.m4000a(this, f5076jr, 80, "inf.store");
            m5250a(serverLevel, (C0805oX) C1287xj.m7828a(this.f5083bq));
        }
    }

    /* JADX INFO: renamed from: bD */
    private int m5261bD() {
        return Math.max(5, 40 - (2 * this.f5089qa)) / 20;
    }

    /* JADX INFO: renamed from: a */
    private float m5262a(@NotNull C0692mQ c0692mQ) {
        return Math.min(5.0f + (0.25f * mo4694bt()), c0692mQ.getMaxHealth());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public IntSet m5263a(@NotNull ServerLevel serverLevel) {
        IntOpenHashSet intOpenHashSet = new IntOpenHashSet();
        IntIterator it = this.f5085c.iterator();
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
    private boolean m5264a(@NotNull Player player, int i) {
        for (UUID uuid : m3582b().m3809h()) {
            if (!player.getUUID().equals(uuid) && C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this, uuid, C1089tp.f5727R) == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public int m5265b(@NotNull Player player) {
        int i = 0;
        while (m5264a(player, i)) {
            i++;
        }
        return i;
    }

    /* JADX INFO: renamed from: cK */
    public void m5266cK() {
        this.f5084br.clear();
        while (this.f5084br.size() < 6) {
            C0863pc c0863pc = (C0863pc) C1287xj.m7828a(C0966rZ.f5111bt);
            if (!this.f5084br.contains(c0863pc)) {
                this.f5084br.add(c0863pc);
            }
        }
        if (this.f5087a != null) {
            this.f5087a.setItemInHand(InteractionHand.MAIN_HAND, ((C0863pc) this.f5084br.getFirst()).m4311a().copy());
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0963rW mo3559a(@NotNull C0622l c0622l) {
        return new C0963rW(c0622l, this, (C0326fV) this.f4249b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0964rX mo3560a() {
        return new C0964rX(this, this.f4249b);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1084tk<C0962rV, C0964rX> mo3563a() {
        return new C1083tj(C1029si::new);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: f */
    public Set<AbstractC0787oF.a> mo3649f() {
        return EnumSet.of(AbstractC0787oF.a.MAP_TYPE, AbstractC0787oF.a.LOBBY);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: g */
    public void mo3647g(@NotNull List<MutableComponent> list) {
        if (this.f5081bo.isEmpty()) {
            list.add(Component.literal("Zones in game '" + this.f4236bE + "' are missing."));
        }
        boolean z = false;
        Iterator<C1022sc> it = this.f5081bo.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().m5695as().isEmpty()) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            list.add(Component.literal("Game '" + this.f4236bE + "' has no zombie spawns in any of its zones."));
        }
        if (m5252a("main").isEmpty()) {
            list.add(Component.literal("A 'main' zone for game '" + this.f4236bE + "' is missing. One is required."));
        }
        for (C1023sd c1023sd : this.f5082bp) {
            if (c1023sd.m5702at().isEmpty()) {
                list.add(Component.literal("Door '" + c1023sd.getId() + "' does not have any affiliated zones."));
            }
        }
        super.mo3647g(list);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3570a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f4250a.m5995b(abstractC0563ju, abstractC0183c, serverLevel);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: aZ */
    protected boolean mo3575aZ() {
        return this.f5089qa >= 5;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb mo3646a() {
        return super.mo3646a().m2623a(this.f5086g);
    }

    @Override // com.boehmod.blockfront.InterfaceC0910qW
    /* JADX INFO: renamed from: bt */
    public int mo4694bt() {
        return this.f5089qa + (m5255bB() - 1);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public boolean mo3597a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        C0796oO c0796oOA = ((C0964rX) this.f4248a).m3806a(C0964rX.f5103cw);
        if (c0796oOA == null) {
            C0562jt.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((C0964rX) this.f4248a).m3776a(abstractC0563ju, enumC0800oS, serverLevel, serverPlayer, c0796oOA);
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: d */
    public void mo3605d(@Nullable Level level) {
        m5266cK();
        this.f5092gX = false;
        this.f5093a = EnumC1020sa.GENERIC;
        this.f5081bo.forEach((v0) -> {
            v0.m5690cL();
        });
        this.f5082bp.forEach((v0) -> {
            v0.m5700cM();
        });
        if (level != null) {
            Iterator<C1023sd> it = this.f5082bp.iterator();
            while (it.hasNext()) {
                it.next().m5701a(level, false);
            }
        }
        this.f5088pZ = 0;
        this.f5089qa = 1;
        this.f5090qb = 5;
        this.f5085c.clear();
        this.f5087a = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3614a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.mo3614a(byteBuf, z);
        IPacket.writeEnum(byteBuf, this.f5093a);
        byteBuf.writeInt(this.f5090qb);
        byteBuf.writeInt(this.f5091qc);
        byteBuf.writeInt(this.f5089qa);
        byteBuf.writeInt(this.f5082bp.size());
        Iterator<C1023sd> it = this.f5082bp.iterator();
        while (it.hasNext()) {
            it.next().m5708c(byteBuf);
        }
        byteBuf.writeInt(this.f5081bo.size());
        Iterator<C1022sc> it2 = this.f5081bo.iterator();
        while (it2.hasNext()) {
            it2.next().m5689c(byteBuf);
        }
        byteBuf.writeInt(this.f5084br.size());
        for (C0863pc c0863pc : this.f5084br) {
            IPacket.writeString(byteBuf, BuiltInRegistries.ITEM.getKey(c0863pc.m4311a().getItem()).toString());
            byteBuf.writeInt(c0863pc.m4312bk());
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: g */
    public void mo3616g(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo3616g(byteBuf);
        this.f5093a = (EnumC1020sa) IPacket.readEnum(byteBuf, EnumC1020sa.class);
        this.f5090qb = byteBuf.readInt();
        this.f5091qc = byteBuf.readInt();
        this.f5089qa = byteBuf.readInt();
        this.f5082bp.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C1023sd c1023sd = new C1023sd();
            c1023sd.m5707b(byteBuf);
            this.f5082bp.add(c1023sd);
        }
        this.f5081bo.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            C1022sc c1022sc = new C1022sc();
            c1022sc.m5688b(byteBuf);
            this.f5081bo.add(c1022sc);
        }
        this.f5084br.clear();
        int i5 = byteBuf.readInt();
        for (int i6 = 0; i6 < i5; i6++) {
            this.f5084br.add(new C0863pc(C1292xo.m7893f(IPacket.readString(byteBuf)).get(), byteBuf.readInt()));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: f */
    public boolean mo3609f(@NotNull Player player) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: bb */
    public boolean mo3611bb() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0802oU mo3610a() {
        return EnumC0802oU.SAME_TEAM;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: aW */
    public int mo3617aW() {
        return 1;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: e */
    public boolean mo3608e(@NotNull Player player) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: bd */
    public boolean mo3621bd() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: bf */
    public boolean mo3635bf() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public CloudAchievement mo3636a() {
        return CloudAchievements.ACH_MATCH_WIN_INF;
    }

    @Override // com.boehmod.blockfront.InterfaceC0910qW
    /* JADX INFO: renamed from: a */
    public void mo4689a(@NotNull C0692mQ c0692mQ, @NotNull Level level) {
        this.f5093a.getRoundCallable().mo5683a(this.f4249b, this, c0692mQ, level);
        c0692mQ.setHealth(m5262a(c0692mQ));
    }

    @Override // com.boehmod.blockfront.InterfaceC0910qW
    /* JADX INFO: renamed from: a */
    public void mo4690a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull C0692mQ c0692mQ, @NotNull DamageSource damageSource) {
        Set<UUID> setH = ((C0964rX) this.f4248a).m3809h();
        Set<UUID> setM5256a = m5256a(setH);
        Player entity = damageSource.getEntity();
        if (entity instanceof Player) {
            UUID uuid = entity.getUUID();
            C0799oR.m4014a(abstractC0563ju, this, uuid, C1089tp.f5695l);
            if (damageSource instanceof C0648lZ) {
                C0799oR.m4015a(abstractC0563ju, this, uuid, C1089tp.f5702s, ((C0648lZ) damageSource).m2907ap() ? 20 : 10);
            } else {
                C0799oR.m4015a(abstractC0563ju, this, uuid, C1089tp.f5702s, 35);
            }
        }
        if (c0692mQ instanceof C0693mR) {
            C0799oR.m3917c(c0692mQ.level(), c0692mQ.position());
            serverLevel.addParticle(ParticleTypes.FLASH, c0692mQ.getX(), c0692mQ.getY(), c0692mQ.getZ(), 0.0d, 0.0d, 0.0d);
            serverLevel.playSound((Player) null, c0692mQ, SoundEvents.WITHER_DEATH, SoundSource.AMBIENT, 10.0f, 1.5f);
        }
        this.f5091qc = m5263a(serverLevel).size();
        if (this.f5091qc == 0 && this.f5090qb <= 0) {
            m5249a(abstractC0563ju, serverLevel, c0692mQ, setH, setM5256a);
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0910qW
    /* JADX INFO: renamed from: a */
    public void mo4691a(@NotNull C0692mQ c0692mQ, @NotNull Player player) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0910qW
    /* JADX INFO: renamed from: a */
    public void mo4692a(@NotNull ServerLevel serverLevel, @NotNull C0692mQ c0692mQ) {
        if (c0692mQ.getTarget() == null) {
            Predicate<LivingEntity> predicateM3126a = c0692mQ.m3126a(this.f4249b);
            for (ServerPlayer serverPlayer : serverLevel.players()) {
                if (predicateM3126a.test(serverPlayer)) {
                    c0692mQ.setTarget(serverPlayer);
                    return;
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0910qW
    /* JADX INFO: renamed from: a */
    public boolean mo4693a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull C0692mQ c0692mQ, @NotNull DamageSource damageSource, float f) {
        Player entity = damageSource.getEntity();
        if (entity instanceof Player) {
            UUID uuid = entity.getUUID();
            if (f < c0692mQ.getHealth()) {
                C0799oR.m4015a(abstractC0563ju, this, uuid, C1089tp.f5702s, 2);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.boehmod.blockfront.InterfaceC0909qV
    /* JADX INFO: renamed from: i */
    public boolean mo4686i(@NotNull Player player) {
        return player.getHealth() < player.getMaxHealth();
    }

    @Override // com.boehmod.blockfront.InterfaceC0909qV
    /* JADX INFO: renamed from: a */
    public float mo4687a(@NotNull Player player) {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0909qV
    /* JADX INFO: renamed from: a */
    public int mo4688a(@NotNull Player player) {
        return 20;
    }

    @Override // com.boehmod.blockfront.InterfaceC0908qU
    /* JADX INFO: renamed from: a */
    public boolean mo4683a(@NotNull Player player, @NotNull C0863pc c0863pc) {
        return C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this, player.getUUID(), C1089tp.f5702s) >= c0863pc.m4312bk();
    }

    @Override // com.boehmod.blockfront.InterfaceC0908qU
    /* JADX INFO: renamed from: a */
    public void mo4684a(@NotNull ServerPlayer serverPlayer, @NotNull C0863pc c0863pc) {
        Level level = serverPlayer.level();
        UUID uuid = serverPlayer.getUUID();
        if (!mo4683a((Player) serverPlayer, c0863pc)) {
            C0799oR.m3970c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.infected.store.buy.fail", new Object[]{Component.translatable(c0863pc.m4311a().getDescriptionId()).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED));
            return;
        }
        this.f5092gX = true;
        Vec3 vec3Position = serverPlayer.position();
        float eyeHeight = serverPlayer.getEyeHeight();
        level.playSound((Player) null, vec3Position.x, vec3Position.y + ((double) eyeHeight), vec3Position.z, (SoundEvent) C1280xc.f7736sL.get(), SoundSource.AMBIENT, 1.0f, 1.0f);
        ItemStack itemStackM4311a = c0863pc.m4311a();
        Item item = itemStackM4311a.getItem();
        if (item instanceof C1144ur) {
            C1144ur c1144ur = (C1144ur) item;
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6155s = c1144ur.m6408a(itemStackM4311a).m6155s();
            if (deferredHolderM6155s != null) {
                level.playSound(serverPlayer, vec3Position.x, vec3Position.y + ((double) eyeHeight), vec3Position.z, (SoundEvent) deferredHolderM6155s.get(), SoundSource.AMBIENT, 1.0f, 1.0f);
            }
            serverPlayer.getInventory().setItem(c1144ur.m6389cv() ? 0 : 1, itemStackM4311a.copy());
        }
        C0799oR.m4019b(this, uuid, C1089tp.f5702s, c0863pc.m4312bk());
        C0799oR.m3970c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.infected.store.buy", new Object[]{Component.translatable(itemStackM4311a.getDescriptionId()).withStyle(ChatFormatting.GRAY), Component.literal(String.valueOf(c0863pc.m4312bk()))}).withStyle(ChatFormatting.GREEN));
    }

    @Override // com.boehmod.blockfront.InterfaceC0908qU
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0863pc mo4685a(@NotNull Player player, @NotNull Item item) {
        for (C0863pc c0863pc : this.f5084br) {
            if (c0863pc.m4311a().getItem() == item) {
                return c0863pc;
            }
        }
        return null;
    }

    @Override // com.boehmod.blockfront.InterfaceC0913qZ
    /* JADX INFO: renamed from: bC */
    public boolean mo4698bC() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0978rl mo3606a() {
        return new InterfaceC0978rl.e(List.copyOf(((C0964rX) this.f4248a).m5304aq()), List.copyOf(this.f5082bp), List.copyOf(this.f5081bo), List.copyOf(this.f5083bq));
    }

    @Override // com.boehmod.blockfront.AbstractC0787oF
    /* JADX INFO: renamed from: a */
    public void mo3607a(@NotNull InterfaceC0978rl interfaceC0978rl) throws MatchException {
        if (interfaceC0978rl instanceof InterfaceC0978rl.e) {
            InterfaceC0978rl.e eVar = (InterfaceC0978rl.e) interfaceC0978rl;
            try {
                List<C0805oX> listM5367X = eVar.m5367X();
                List<C1023sd> listM5368Y = eVar.m5368Y();
                List<C1022sc> listM5369Z = eVar.m5369Z();
                List<C0805oX> listM5370aa = eVar.m5370aa();
                ((C0964rX) this.f4248a).m5306cJ();
                Iterator<C0805oX> it = listM5367X.iterator();
                while (it.hasNext()) {
                    ((C0964rX) this.f4248a).m5305d(it.next());
                }
                this.f5082bp.clear();
                this.f5082bp.addAll(listM5368Y);
                this.f5081bo.clear();
                this.f5081bo.addAll(listM5369Z);
                this.f5083bq.clear();
                this.f5083bq.addAll(listM5370aa);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
