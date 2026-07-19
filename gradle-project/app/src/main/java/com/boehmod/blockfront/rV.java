package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.blockfront.InterfaceC0471rl;
import com.boehmod.blockfront.oF;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rV.class */
public final class rV extends oF<rV, rX, C0526tm<rV, rX>> implements qU, qV, qW, qZ {
    private static final Component jq = Component.translatable("bf.message.gamemode.infected.store.resupply").withStyle(ChatFormatting.GREEN);
    private static final Component jr = Component.translatable("bf.message.gamemode.infected.store.relocate").withStyle(ChatFormatting.YELLOW);
    private static final int pV = 6;
    public static final int pW = 5;
    public static final int pX = 30;
    public static final int pY = 60;

    @NotNull
    public final List<C0489sc> bo;

    @NotNull
    public final List<C0490sd> bp;

    @NotNull
    public final List<oX> bq;

    @NotNull
    public final List<C0408pc> br;

    @NotNull
    private final IntSet c;

    @NotNull
    private final C0272kb g;

    @Nullable
    public mY a;
    public int pZ;
    public int qa;
    public int qb;
    public int qc;
    public boolean gX;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public EnumC0487sa f297a;

    @NotNull
    private Collection<String> e() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator<C0489sc> it = this.bo.iterator();
        while (it.hasNext()) {
            objectArrayList.add(it.next().ai());
        }
        return objectArrayList;
    }

    @NotNull
    private Collection<String> f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C0490sd c0490sd : this.bp) {
            if (!objectArrayList.contains(c0490sd.getId())) {
                objectArrayList.add(c0490sd.getId());
            }
        }
        return objectArrayList;
    }

    public rV(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        super(abstractC0264ju, "inf", "Infected");
        this.bo = new ObjectArrayList();
        this.bp = new ObjectArrayList();
        this.bq = new ObjectArrayList();
        this.br = new ObjectArrayList();
        this.c = new IntOpenHashSet();
        this.g = new C0272kb().a("vendor", new C0272kb().a("add", new C0272kb((commandContext, strArr) -> {
            this.bq.add(new oX(((CommandSourceStack) commandContext.getSource()).source));
            lW.b(((CommandSourceStack) commandContext.getSource()).source, Component.literal("Successfully added new vendor spawn. (" + this.bq.size() + ")"));
        }).a(C0274kd.a)).a("clear", new C0272kb((commandContext2, strArr2) -> {
            this.bq.clear();
            lW.b(((CommandSourceStack) commandContext2.getSource()).source, Component.literal("Successfully cleared all vendor spawns. (" + this.bq.size() + ")"));
        }))).a("spawn", new C0272kb().a("add", new C0272kb((commandContext3, strArr3) -> {
            b().d(new oX(((CommandSourceStack) commandContext3.getSource()).source));
            lW.b(((CommandSourceStack) commandContext3.getSource()).source, Component.literal("Successfully added new random spawn. (" + b().aq().size() + ")"));
        }).a(C0274kd.a)).a("clear", new C0272kb((commandContext4, strArr4) -> {
            b().cJ();
            lW.b(((CommandSourceStack) commandContext4.getSource()).source, Component.literal("Successfully cleared all random spawns."));
        }))).a("doors", new C0272kb((commandContext5, strArr5) -> {
            for (C0490sd c0490sd : this.bp) {
                lW.b(((CommandSourceStack) commandContext5.getSource()).source, Component.literal(String.format("Door '%s':", c0490sd.getId())));
                int i = 0;
                List<String> listAt = c0490sd.at();
                if (!listAt.isEmpty()) {
                    Iterator<String> it = listAt.iterator();
                    while (it.hasNext()) {
                        int i2 = i;
                        i++;
                        lW.b(((CommandSourceStack) commandContext5.getSource()).source, Component.literal(String.format("- %s. Zone '%s'", Integer.valueOf(i2), it.next())));
                    }
                } else {
                    lW.b(((CommandSourceStack) commandContext5.getSource()).source, Component.literal("(Door has no zone triggers)"));
                }
            }
        })).a("door", new C0272kb().a("add", new C0272kb((commandContext6, strArr6) -> {
            Player player = ((CommandSourceStack) commandContext6.getSource()).source;
            Level level = player.level();
            String str = strArr6[0];
            String str2 = strArr6[1];
            try {
                int i = Integer.parseInt(str2);
                if (level.getBlockState(player.blockPosition()).getBlock() instanceof DoorBlock) {
                    lW.b(((CommandSourceStack) commandContext6.getSource()).source, Component.literal("Failed to create new door! (Invalid door position! No door block found.)"));
                } else {
                    this.bp.add(new C0490sd(player.blockPosition(), str, new ObjectArrayList(), i));
                    lW.b(((CommandSourceStack) commandContext6.getSource()).source, Component.literal("Created new zombie door '" + str + "' with cost '" + i + "'. (" + this.bp.size() + ")"));
                }
            } catch (NumberFormatException e) {
                lW.b(((CommandSourceStack) commandContext6.getSource()).source, Component.literal("Failed to create new door! (The door cost '" + str2 + "' is invalid)"));
            }
        }).a(C0274kd.a(new String[]{"door", "cost"})).a(C0274kd.a)).a("clear", new C0272kb((commandContext7, strArr7) -> {
            this.bp.clear();
            lW.b(((CommandSourceStack) commandContext7.getSource()).source, Component.literal("Successfully cleared all zombie doors. (" + this.bp.size() + ")"));
        }).a(C0274kd.a)).a("zone", new C0272kb().a("add", new C0272kb((commandContext8, strArr8) -> {
            String str = strArr8[0];
            String str2 = strArr8[1];
            List<C0490sd> listM1044a = m1044a(str);
            if (listM1044a.isEmpty()) {
                lW.b(((CommandSourceStack) commandContext8.getSource()).source, Component.literal("Failed to add zone '" + str2 + "' to door. (No doors for ID '" + str + "' exist)"));
            } else {
                listM1044a.forEach(c0490sd -> {
                    c0490sd.at().add(str2);
                });
                lW.b(((CommandSourceStack) commandContext8.getSource()).source, Component.literal("Successfully added zone '" + str2 + "' to " + listM1044a.size() + " doors."));
            }
        }).a(C0274kd.a(new String[]{"door", "zone"})).a((commandContext9, strArr9) -> {
            switch (strArr9.length) {
                case 0:
                    return f();
                case 1:
                    return e();
                default:
                    return List.of();
            }
        })).a("remove", new C0272kb((commandContext10, strArr10) -> {
            String str = strArr10[0];
            String str2 = strArr10[1];
            List<C0490sd> listM1044a = m1044a(str);
            if (listM1044a.isEmpty()) {
                lW.b(((CommandSourceStack) commandContext10.getSource()).source, Component.literal("Failed to remove zone '" + str2 + "' from door. (No doors for ID '" + str + "' exist)"));
            } else {
                listM1044a.forEach(c0490sd -> {
                    c0490sd.at().remove(str2);
                });
                lW.b(((CommandSourceStack) commandContext10.getSource()).source, Component.literal("Successfully removed zone '" + str2 + "' to " + listM1044a.size() + " doors."));
            }
        }).a(C0274kd.a(new String[]{"door", "zone"})).a((commandContext11, strArr11) -> {
            switch (strArr11.length) {
                case 0:
                    return f();
                case 1:
                    return e();
                default:
                    return List.of();
            }
        })).a("clear", new C0272kb((commandContext12, strArr12) -> {
            String str = strArr12[0];
            List<C0490sd> listM1044a = m1044a(str);
            if (listM1044a.isEmpty()) {
                lW.b(((CommandSourceStack) commandContext12.getSource()).source, Component.literal("Failed to clear zones from door. (No doors for ID '" + str + "' exist)"));
            } else {
                listM1044a.forEach(c0490sd -> {
                    c0490sd.at().clear();
                });
                lW.b(((CommandSourceStack) commandContext12.getSource()).source, Component.literal("Successfully cleared zones from " + listM1044a.size() + " doors."));
            }
        }).a(C0274kd.a(new String[]{"door"})).a((commandContext13, strArr13) -> {
            return strArr13.length == 0 ? f() : List.of();
        })))).a("zones", new C0272kb((commandContext14, strArr14) -> {
            Iterator<C0489sc> it = this.bo.iterator();
            while (it.hasNext()) {
                lW.b(((CommandSourceStack) commandContext14.getSource()).source, Component.literal(String.format("Zone '%s':", it.next().ai())));
            }
        })).a("zone", new C0272kb().a("add", new C0272kb((commandContext15, strArr15) -> {
            String str = strArr15[0];
            if (a(str).isPresent()) {
                lW.b(((CommandSourceStack) commandContext15.getSource()).source, Component.literal("Failed to create new zone! (The zone '" + str + "' already exists)"));
            } else {
                this.bo.add(new C0489sc(str));
                lW.b(((CommandSourceStack) commandContext15.getSource()).source, Component.literal("Successfully added a new zone '" + str + "'. (" + this.bo.size() + ")"));
            }
        }).a(C0274kd.a(new String[]{"name"}))).a("remove", new C0272kb((commandContext16, strArr16) -> {
            String str = strArr16[0];
            if (a(str).isEmpty()) {
                lW.b(((CommandSourceStack) commandContext16.getSource()).source, Component.literal("Failed to remove zone! (The zone '" + str + "' doesn't exists)"));
            } else {
                this.bo.removeIf(c0489sc -> {
                    return c0489sc.ai().equals(str);
                });
                lW.b(((CommandSourceStack) commandContext16.getSource()).source, Component.literal("Successfully removed zone '" + str + "'. (" + this.bo.size() + ")"));
            }
        }).a(C0274kd.a(new String[]{"name"})).a((commandContext17, strArr17) -> {
            return strArr17.length == 0 ? e() : List.of();
        })).a("edit", new C0272kb().a("spawn", new C0272kb().a("add", new C0272kb((commandContext18, strArr18) -> {
            Player player = ((CommandSourceStack) commandContext18.getSource()).source;
            String str = strArr18[0];
            Optional<C0489sc> optionalA = a(str);
            if (optionalA.isEmpty()) {
                lW.b(((CommandSourceStack) commandContext18.getSource()).source, Component.literal("Failed to add zombie spawn to zone! (The zone '" + str + "' doesn't exists)"));
                return;
            }
            C0489sc c0489sc = optionalA.get();
            c0489sc.as().add(new C0488sb(str, new oX(player)));
            lW.b(((CommandSourceStack) commandContext18.getSource()).source, Component.literal("Successfully added zombie spawn to zone '" + str + "'. (" + c0489sc.as().size() + ")"));
        }).a(C0274kd.a(new String[]{"zone"})).a(C0274kd.a).a((commandContext19, strArr19) -> {
            return strArr19.length == 0 ? e() : List.of();
        })).a("clear", new C0272kb((commandContext20, strArr20) -> {
            String str = strArr20[0];
            Optional<C0489sc> optionalA = a(str);
            if (optionalA.isEmpty()) {
                lW.b(((CommandSourceStack) commandContext20.getSource()).source, Component.literal("Failed to clear zombie spawns from zone! (The zone '" + str + "' doesn't exists)"));
                return;
            }
            C0489sc c0489sc = optionalA.get();
            c0489sc.as().clear();
            lW.b(((CommandSourceStack) commandContext20.getSource()).source, Component.literal("Successfully cleared zombie spawns from zone '" + str + "'. (" + c0489sc.as().size() + ")"));
        }).a(C0274kd.a(new String[]{"zone"})).a((commandContext21, strArr21) -> {
            return strArr21.length == 0 ? e() : List.of();
        })))).a("list", new C0272kb((commandContext22, strArr22) -> {
            lW.b(((CommandSourceStack) commandContext22.getSource()).source, Component.literal("All Zones:"));
            for (C0489sc c0489sc : this.bo) {
                lW.b(((CommandSourceStack) commandContext22.getSource()).source, Component.literal(String.format("- '%s' - (%d spawns)", c0489sc.ai(), Integer.valueOf(c0489sc.as().size()))));
            }
        })));
        this.a = null;
        this.pZ = 0;
        this.qa = 1;
        this.qb = 5;
        this.qc = 0;
        this.gX = false;
        this.f297a = EnumC0487sa.GENERIC;
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull mQ mQVar, @NotNull Set<UUID> set, @NotNull Set<UUID> set2) {
        set2.forEach(uuid -> {
            oR.a((AbstractC0264ju<?, ?, ?>) abstractC0264ju, this, uuid, C0529tp.l);
            oR.a(uuid, new sQ(Component.translatable("bf.message.gamemode.infected.popup.wave.survive").withStyle(ChatFormatting.DARK_RED), 40));
        });
        oR.c(mQVar.level(), mQVar.position());
        serverLevel.playSound((Player) null, mQVar, SoundEvents.WITHER_DEATH, SoundSource.AMBIENT, 10.0f, 0.5f);
        oR.a(this, (SoundEvent) this.f297a.getRoundEndSound().get(), SoundSource.MUSIC);
        oR.a((oF<?, ?, ?>) this, (Component) Component.translatable("bf.message.gamemode.infected.wave.complete", new Object[]{Component.literal(String.valueOf(this.qa)).withStyle(ChatFormatting.RED), Component.literal(String.valueOf(set2.size())).withStyle(ChatFormatting.RED)}).withStyle(ChatFormatting.DARK_RED), 80, "inf.wave");
        set.forEach(uuid2 -> {
            ServerPlayer serverPlayerA = oR.a(uuid2);
            if (l(uuid2)) {
                if (serverPlayerA != null) {
                    oR.a((AbstractC0264ju<?, ?, ?>) abstractC0264ju, this.f269b, serverLevel, serverPlayerA);
                    return;
                }
                return;
            }
            oR.a((AbstractC0264ju<?, ?, ?>) abstractC0264ju, this, uuid2, C0529tp.P);
        });
    }

    public void a(@NotNull ServerLevel serverLevel, @NotNull oX oXVar) {
        if (this.a != null) {
            this.a.discard();
            this.a = null;
        }
        this.a = ((EntityType) wX.kD.get()).create(serverLevel);
        if (this.a != null) {
            this.a.e(this);
            this.a.moveTo(oXVar.c, 0.0f, 0.0f);
            serverLevel.addFreshEntity(this.a);
        }
    }

    public void h(ServerLevel serverLevel) {
        EntityType entityType;
        oX oXVarI = i();
        serverLevel.getChunkAt(oXVarI.c());
        if (this.f297a == EnumC0487sa.DOGS) {
            entityType = (EntityType) wX.ld.get();
        } else {
            entityType = (EntityType) wX.lc.get();
            if (this.qa >= 5 && Math.random() < 0.2d) {
                entityType = (EntityType) wX.le.get();
            }
            if (this.qa >= 10 && Math.random() < 0.1d) {
                entityType = (EntityType) wX.lf.get();
            }
        }
        mQ mQVar = (mQ) entityType.create(serverLevel);
        if (mQVar != null) {
            mQVar.e(this);
            mQVar.moveTo(oXVarI.c, 0.0f, 0.0f);
            serverLevel.addFreshEntity(mQVar);
            a(mQVar, (Level) serverLevel);
            oR.c((Level) serverLevel, mQVar.position());
            this.c.add(mQVar.getId());
        }
        this.qc = this.c.size();
    }

    @NotNull
    public Optional<C0489sc> a(@NotNull String str) {
        for (C0489sc c0489sc : this.bo) {
            if (c0489sc.ai().equals(str)) {
                return Optional.of(c0489sc);
            }
        }
        return Optional.empty();
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List<C0490sd> m1044a(@NotNull String str) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C0490sd c0490sd : this.bp) {
            if (c0490sd.getId().equals(str)) {
                objectArrayList.add(c0490sd);
            }
        }
        return objectArrayList;
    }

    @NotNull
    private oX i() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C0489sc c0489sc : this.bo) {
            if (c0489sc.bK() && !c0489sc.as().isEmpty()) {
                objectArrayList.add(c0489sc);
            }
        }
        if (objectArrayList.isEmpty()) {
            throw new IllegalStateException("No active zombie zones with zombie spawns available");
        }
        return ((C0489sc) objectArrayList.get(threadLocalRandomCurrent.nextInt(objectArrayList.size()))).a().e();
    }

    private int bB() {
        int i = 0;
        Iterator<C0489sc> it = this.bo.iterator();
        while (it.hasNext()) {
            if (it.next().bK()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    public Set<UUID> a(@NotNull Set<UUID> set) {
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        for (UUID uuid : set) {
            if (!l(uuid)) {
                objectOpenHashSet.add(uuid);
            }
        }
        return objectOpenHashSet;
    }

    private boolean l(@NotNull UUID uuid) {
        com.boehmod.blockfront.common.player.b bVarB = this.f269b.b(uuid);
        ServerPlayer serverPlayerA = oR.a(uuid);
        return serverPlayerA == null ? bVarB.dk() : oR.a((Player) serverPlayerA, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) bVarB);
    }

    public boolean a(@NotNull ServerLevel serverLevel) {
        if (this.qb <= 0) {
            return false;
        }
        int i = this.pZ;
        this.pZ = i - 1;
        if (i <= 0) {
            this.pZ = bD();
            if (m1045a(serverLevel).size() < bC()) {
                int iBt = (int) (1.0f + (bt() * 0.2f));
                for (int i2 = 0; i2 < iBt && this.qb > 0; i2++) {
                    this.qb--;
                    h(serverLevel);
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private int bC() {
        return 60;
    }

    public void b(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.pZ = 0;
        this.qa++;
        this.c.clear();
        if (this.qa % 5 == 0) {
            this.f297a = EnumC0487sa.DOGS;
        } else {
            this.f297a = EnumC0487sa.GENERIC;
        }
        this.qb = (int) Math.min(150.0f, 5 * bt() * this.f297a.getCountMultiplier());
        this.f297a.getRoundCallable().a(this, (Level) serverLevel, this.qb, set);
        oR.a(this, (SoundEvent) this.f297a.getRoundStartSound().get(), SoundSource.MUSIC);
        if (Math.random() < 0.20000000298023224d) {
            oR.a(this, (SoundEvent) C0624xc.sN.get(), SoundSource.MASTER);
            oR.a(this, jq, 80, "inf.store");
            cK();
        } else if (Math.random() < 0.1d && this.gX) {
            oR.a(this, (SoundEvent) C0624xc.sM.get(), SoundSource.MASTER);
            oR.a(this, jr, 80, "inf.store");
            a(serverLevel, (oX) C0631xj.a(this.bq));
        }
    }

    private int bD() {
        return Math.max(5, 40 - (2 * this.qa)) / 20;
    }

    private float a(@NotNull mQ mQVar) {
        return Math.min(5.0f + (0.25f * bt()), mQVar.getMaxHealth());
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public IntSet m1045a(@NotNull ServerLevel serverLevel) {
        IntOpenHashSet intOpenHashSet = new IntOpenHashSet();
        IntIterator it = this.c.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            Entity entity = serverLevel.getEntity(iIntValue);
            if (entity != null && entity.isAlive()) {
                intOpenHashSet.add(iIntValue);
            }
        }
        return intOpenHashSet;
    }

    private boolean a(@NotNull Player player, int i) {
        for (UUID uuid : b().h()) {
            if (!player.getUUID().equals(uuid) && oR.a((oF<?, ?, ?>) this, uuid, C0529tp.R) == i) {
                return true;
            }
        }
        return false;
    }

    public int b(@NotNull Player player) {
        int i = 0;
        while (a(player, i)) {
            i++;
        }
        return i;
    }

    public void cK() {
        this.br.clear();
        while (this.br.size() < 6) {
            C0408pc c0408pc = (C0408pc) C0631xj.a(rZ.bt);
            if (!this.br.contains(c0408pc)) {
                this.br.add(c0408pc);
            }
        }
        if (this.a != null) {
            this.a.setItemInHand(InteractionHand.MAIN_HAND, ((C0408pc) this.br.getFirst()).a().copy());
        }
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    public rW a(@NotNull C0297l c0297l) {
        return new rW(c0297l, this, (fV) this.f269b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.oF
    @NotNull
    public rX a() {
        return new rX(this, this.f269b);
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0524tk<rV, rX> mo749a() {
        return new C0523tj(C0495si::new);
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    public Set<oF.a> mo1046f() {
        return EnumSet.of(oF.a.MAP_TYPE, oF.a.LOBBY);
    }

    @Override // com.boehmod.blockfront.oF
    public void g(@NotNull List<MutableComponent> list) {
        if (this.bo.isEmpty()) {
            list.add(Component.literal("Zones in game '" + this.bE + "' are missing."));
        }
        boolean z = false;
        Iterator<C0489sc> it = this.bo.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().as().isEmpty()) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            list.add(Component.literal("Game '" + this.bE + "' has no zombie spawns in any of its zones."));
        }
        if (a("main").isEmpty()) {
            list.add(Component.literal("A 'main' zone for game '" + this.bE + "' is missing. One is required."));
        }
        for (C0490sd c0490sd : this.bp) {
            if (c0490sd.at().isEmpty()) {
                list.add(Component.literal("Door '" + c0490sd.getId() + "' does not have any affiliated zones."));
            }
        }
        super.g(list);
    }

    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        this.f270a.b(abstractC0264ju, cVar, serverLevel);
    }

    @Override // com.boehmod.blockfront.oF
    protected boolean aZ() {
        return this.qa >= 5;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0272kb mo763a() {
        return super.mo763a().a(this.g);
    }

    @Override // com.boehmod.blockfront.qW
    public int bt() {
        return this.qa + (bB() - 1);
    }

    @Override // com.boehmod.blockfront.oF
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oS oSVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        oO oOVarA = ((rX) this.f268a).a(rX.cw);
        if (oOVarA == null) {
            C0263jt.log("No team available for player " + serverPlayer.getScoreboardName() + " to join.", new Object[0]);
            return false;
        }
        return ((rX) this.f268a).a(abstractC0264ju, oSVar, serverLevel, serverPlayer, oOVarA);
    }

    @Override // com.boehmod.blockfront.oF
    public void d(@Nullable Level level) {
        cK();
        this.gX = false;
        this.f297a = EnumC0487sa.GENERIC;
        this.bo.forEach((v0) -> {
            v0.cL();
        });
        this.bp.forEach((v0) -> {
            v0.cM();
        });
        if (level != null) {
            Iterator<C0490sd> it = this.bp.iterator();
            while (it.hasNext()) {
                it.next().a(level, false);
            }
        }
        this.pZ = 0;
        this.qa = 1;
        this.qb = 5;
        this.c.clear();
        this.a = null;
    }

    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull ByteBuf byteBuf, boolean z) throws IOException {
        super.a(byteBuf, z);
        IPacket.writeEnum(byteBuf, this.f297a);
        byteBuf.writeInt(this.qb);
        byteBuf.writeInt(this.qc);
        byteBuf.writeInt(this.qa);
        byteBuf.writeInt(this.bp.size());
        Iterator<C0490sd> it = this.bp.iterator();
        while (it.hasNext()) {
            it.next().c(byteBuf);
        }
        byteBuf.writeInt(this.bo.size());
        Iterator<C0489sc> it2 = this.bo.iterator();
        while (it2.hasNext()) {
            it2.next().c(byteBuf);
        }
        byteBuf.writeInt(this.br.size());
        for (C0408pc c0408pc : this.br) {
            IPacket.writeString(byteBuf, BuiltInRegistries.ITEM.getKey(c0408pc.a().getItem()).toString());
            byteBuf.writeInt(c0408pc.bk());
        }
    }

    @Override // com.boehmod.blockfront.oF
    public void g(@NotNull ByteBuf byteBuf) throws IOException {
        super.g(byteBuf);
        this.f297a = (EnumC0487sa) IPacket.readEnum(byteBuf, EnumC0487sa.class);
        this.qb = byteBuf.readInt();
        this.qc = byteBuf.readInt();
        this.qa = byteBuf.readInt();
        this.bp.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C0490sd c0490sd = new C0490sd();
            c0490sd.b(byteBuf);
            this.bp.add(c0490sd);
        }
        this.bo.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            C0489sc c0489sc = new C0489sc();
            c0489sc.b(byteBuf);
            this.bo.add(c0489sc);
        }
        this.br.clear();
        int i5 = byteBuf.readInt();
        for (int i6 = 0; i6 < i5; i6++) {
            this.br.add(new C0408pc(C0636xo.f(IPacket.readString(byteBuf)).get(), byteBuf.readInt()));
        }
    }

    @Override // com.boehmod.blockfront.oF
    public boolean f(@NotNull Player player) {
        return false;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean bb() {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public oU mo753a() {
        return oU.SAME_TEAM;
    }

    @Override // com.boehmod.blockfront.oF
    public int aW() {
        return 1;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean e(@NotNull Player player) {
        return false;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean bd() {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    public boolean bf() {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public CloudAchievement mo760a() {
        return CloudAchievements.ACH_MATCH_WIN_INF;
    }

    @Override // com.boehmod.blockfront.qW
    public void a(@NotNull mQ mQVar, @NotNull Level level) {
        this.f297a.getRoundCallable().a(this.f269b, this, mQVar, level);
        mQVar.setHealth(a(mQVar));
    }

    @Override // com.boehmod.blockfront.qW
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull mQ mQVar, @NotNull DamageSource damageSource) {
        Set<UUID> setH = ((rX) this.f268a).h();
        Set<UUID> setA = a(setH);
        Player entity = damageSource.getEntity();
        if (entity instanceof Player) {
            UUID uuid = entity.getUUID();
            oR.a(abstractC0264ju, this, uuid, C0529tp.l);
            if (damageSource instanceof lZ) {
                oR.a(abstractC0264ju, this, uuid, C0529tp.s, ((lZ) damageSource).ap() ? 20 : 10);
            } else {
                oR.a(abstractC0264ju, this, uuid, C0529tp.s, 35);
            }
        }
        if (mQVar instanceof mR) {
            oR.c(mQVar.level(), mQVar.position());
            serverLevel.addParticle(ParticleTypes.FLASH, mQVar.getX(), mQVar.getY(), mQVar.getZ(), 0.0d, 0.0d, 0.0d);
            serverLevel.playSound((Player) null, mQVar, SoundEvents.WITHER_DEATH, SoundSource.AMBIENT, 10.0f, 1.5f);
        }
        this.qc = m1045a(serverLevel).size();
        if (this.qc == 0 && this.qb <= 0) {
            a(abstractC0264ju, serverLevel, mQVar, setH, setA);
        }
    }

    @Override // com.boehmod.blockfront.qW
    public void a(@NotNull mQ mQVar, @NotNull Player player) {
    }

    @Override // com.boehmod.blockfront.qW
    public void a(@NotNull ServerLevel serverLevel, @NotNull mQ mQVar) {
        if (mQVar.getTarget() == null) {
            Predicate<LivingEntity> predicateA = mQVar.a(this.f269b);
            for (ServerPlayer serverPlayer : serverLevel.players()) {
                if (predicateA.test(serverPlayer)) {
                    mQVar.setTarget(serverPlayer);
                    return;
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.qW
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull mQ mQVar, @NotNull DamageSource damageSource, float f) {
        Player entity = damageSource.getEntity();
        if (entity instanceof Player) {
            UUID uuid = entity.getUUID();
            if (f < mQVar.getHealth()) {
                oR.a(abstractC0264ju, this, uuid, C0529tp.s, 2);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.boehmod.blockfront.qV
    public boolean i(@NotNull Player player) {
        return player.getHealth() < player.getMaxHealth();
    }

    @Override // com.boehmod.blockfront.qV
    public float a(@NotNull Player player) {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.qV
    /* JADX INFO: renamed from: a */
    public int mo922a(@NotNull Player player) {
        return 20;
    }

    @Override // com.boehmod.blockfront.qU
    public boolean a(@NotNull Player player, @NotNull C0408pc c0408pc) {
        return oR.a((oF<?, ?, ?>) this, player.getUUID(), C0529tp.s) >= c0408pc.bk();
    }

    @Override // com.boehmod.blockfront.qU
    public void a(@NotNull ServerPlayer serverPlayer, @NotNull C0408pc c0408pc) {
        Level level = serverPlayer.level();
        UUID uuid = serverPlayer.getUUID();
        if (!a((Player) serverPlayer, c0408pc)) {
            oR.c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.infected.store.buy.fail", new Object[]{Component.translatable(c0408pc.a().getDescriptionId()).withStyle(ChatFormatting.GRAY)}).withStyle(ChatFormatting.RED));
            return;
        }
        this.gX = true;
        Vec3 vec3Position = serverPlayer.position();
        float eyeHeight = serverPlayer.getEyeHeight();
        level.playSound((Player) null, vec3Position.x, vec3Position.y + ((double) eyeHeight), vec3Position.z, (SoundEvent) C0624xc.sL.get(), SoundSource.AMBIENT, 1.0f, 1.0f);
        ItemStack itemStackA = c0408pc.a();
        Item item = itemStackA.getItem();
        if (item instanceof C0558ur) {
            C0558ur c0558ur = (C0558ur) item;
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderS = c0558ur.m1221a(itemStackA).s();
            if (deferredHolderS != null) {
                level.playSound(serverPlayer, vec3Position.x, vec3Position.y + ((double) eyeHeight), vec3Position.z, (SoundEvent) deferredHolderS.get(), SoundSource.AMBIENT, 1.0f, 1.0f);
            }
            serverPlayer.getInventory().setItem(c0558ur.cv() ? 0 : 1, itemStackA.copy());
        }
        oR.b(this, uuid, C0529tp.s, c0408pc.bk());
        oR.c(serverPlayer, (Component) Component.translatable("bf.message.gamemode.infected.store.buy", new Object[]{Component.translatable(itemStackA.getDescriptionId()).withStyle(ChatFormatting.GRAY), Component.literal(String.valueOf(c0408pc.bk()))}).withStyle(ChatFormatting.GREEN));
    }

    @Override // com.boehmod.blockfront.qU
    @Nullable
    public C0408pc a(@NotNull Player player, @NotNull Item item) {
        for (C0408pc c0408pc : this.br) {
            if (c0408pc.a().getItem() == item) {
                return c0408pc;
            }
        }
        return null;
    }

    @Override // com.boehmod.blockfront.qZ
    /* JADX INFO: renamed from: bC, reason: collision with other method in class */
    public boolean mo1047bC() {
        return true;
    }

    @Override // com.boehmod.blockfront.oF
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0471rl mo752a() {
        return new InterfaceC0471rl.e(List.copyOf(((rX) this.f268a).aq()), List.copyOf(this.bp), List.copyOf(this.bo), List.copyOf(this.bq));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.oF
    public void a(@NotNull InterfaceC0471rl interfaceC0471rl) throws MatchException {
        if (interfaceC0471rl instanceof InterfaceC0471rl.e) {
            InterfaceC0471rl.e eVar = (InterfaceC0471rl.e) interfaceC0471rl;
            try {
                List<oX> listX = eVar.X();
                List<C0490sd> listY = eVar.Y();
                List<C0489sc> listZ = eVar.Z();
                List<oX> listAa = eVar.aa();
                ((rX) this.f268a).cJ();
                Iterator<oX> it = listX.iterator();
                while (it.hasNext()) {
                    ((rX) this.f268a).d(it.next());
                }
                this.bp.clear();
                this.bp.addAll(listY);
                this.bo.clear();
                this.bo.addAll(listZ);
                this.bq.clear();
                this.bq.addAll(listAa);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
    }
}
