package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ProgressionValues;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.oF;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.util.Calendar;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oL.class */
public class oL<G extends oF<G, ?, ?>> {
    private static final int mT = 45;
    private static final int mU = 5;
    private static final int mV = 40;
    private static final int mW = 40;
    public static final int mX = 32;

    @NotNull
    private final G h;

    public oL(@NotNull G g) {
        this.h = g;
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull LivingDeathEvent livingDeathEvent, @NotNull Set<UUID> set) {
        ServerPlayer entity = livingDeathEvent.getEntity();
        DamageSource source = livingDeathEvent.getSource();
        ServerPlayer entity2 = source.getEntity();
        com.boehmod.blockfront.common.player.c<?> cVarM531a = abstractC0264ju.m531a();
        G g = this.h;
        if ((g instanceof qZ) && ((qZ) g).mo1047bC()) {
            a(abstractC0264ju, cVarM531a, entity, source, true, true);
        }
        if (this.h.m750a() != oN.GAME) {
            return;
        }
        if (entity instanceof ServerPlayer) {
            a(abstractC0264ju, cVarM531a, entity, (Entity) entity2, set);
        }
        if (entity2 instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity2;
            a(abstractC0264ju, cVarM531a, source, serverPlayer, serverPlayer.getUUID(), entity, set);
        }
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerPlayer serverPlayer, @Nullable Entity entity, @NotNull Set<UUID> set) {
        UUID uuid = serverPlayer.getUUID();
        oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid, C0529tp.L);
        oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid, C0529tp.N);
        if (this.h instanceof InterfaceC0460ra) {
            a(abstractC0264ju, entity, serverPlayer, uuid, set);
        }
        oR.m792a((oF<?, ?, ?>) this.h, uuid, C0529tp.E, 0);
        oR.m792a((oF<?, ?, ?>) this.h, uuid, C0529tp.J, 0);
        oR.m792a((oF<?, ?, ?>) this.h, uuid, C0529tp.H, 0);
        cVar.m305a((Player) serverPlayer).d(Calendar.getInstance().getTime().getTime());
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @Nullable Entity entity, @NotNull ServerPlayer serverPlayer, UUID uuid, @NotNull Set<UUID> set) {
        int iA = oR.a((oF<?, ?, ?>) this.h, uuid, C0529tp.E);
        if (iA < 5) {
            return;
        }
        oR.a((oF<?, ?, ?>) this.h, (SoundEvent) C0624xc.qo.get(), SoundSource.MUSIC);
        oR.a(abstractC0264ju, uuid, CloudAchievements.ACH_USER_LOSE_STREAK);
        MutableComponent mutableComponentWithStyle = Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.WHITE);
        MutableComponent mutableComponentWithStyle2 = Component.literal(String.valueOf(iA)).withStyle(ChatFormatting.WHITE);
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = (ServerPlayer) entity;
            if (serverPlayer2.equals(serverPlayer)) {
                oR.a((oF<?, ?, ?>) this.h, (Component) Component.translatable("bf.message.gamemode.combat.streak.ended.self", new Object[]{mutableComponentWithStyle, mutableComponentWithStyle2}).withStyle(ChatFormatting.RED));
                oR.a(abstractC0264ju, uuid, CloudAchievements.ACH_USER_END_STREAK_SELF);
                return;
            } else {
                oR.a((oF<?, ?, ?>) this.h, (Component) Component.translatable("bf.message.gamemode.combat.streak.ended", new Object[]{Component.literal(serverPlayer2.getScoreboardName()).withStyle(ChatFormatting.WHITE), mutableComponentWithStyle, mutableComponentWithStyle2}).withStyle(ChatFormatting.RED));
                oR.a(abstractC0264ju, serverPlayer2.getUUID(), CloudAchievements.ACH_USER_END_STREAK);
                return;
            }
        }
        oR.a((oF<?, ?, ?>) this.h, (Component) Component.translatable("bf.message.gamemode.combat.streak.ended.other", new Object[]{mutableComponentWithStyle, mutableComponentWithStyle2}).withStyle(ChatFormatting.RED));
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull DamageSource damageSource, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull LivingEntity livingEntity, @NotNull Set<UUID> set) {
        ItemStack mainHandItem;
        Objects.requireNonNull(livingEntity);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), ServerPlayer.class, mE.class, mQ.class).dynamicInvoker().invoke(livingEntity, 0) /* invoke-custom */) {
            case 0:
                ServerPlayer serverPlayer2 = (ServerPlayer) livingEntity;
                if (!serverPlayer2.equals(serverPlayer)) {
                    com.boehmod.blockfront.common.player.b bVarM305a = cVar.m305a((Player) serverPlayer);
                    if (damageSource instanceof C0326mb) {
                        mainHandItem = ((C0326mb) damageSource).a();
                    } else {
                        mainHandItem = serverPlayer.getMainHandItem();
                    }
                    oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid, C0529tp.D, 1, mainHandItem);
                    if (!bVarM305a.dk()) {
                        a(abstractC0264ju, serverPlayer2, serverPlayer, uuid, set);
                    }
                    oR.m792a((oF<?, ?, ?>) this.h, uuid, C0529tp.N, 0);
                    ItemStack mainHandItem2 = serverPlayer.getMainHandItem();
                    boolean z = mainHandItem2.getItem() instanceof tI;
                    boolean z2 = !(damageSource instanceof C0326mb) || ((C0326mb) damageSource).a().equals(mainHandItem2);
                    if (oR.a(livingEntity, (LivingEntity) serverPlayer, 45.0f) && z && z2) {
                        oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid, C0529tp.O);
                    }
                    if (damageSource.is(DamageTypeTags.IS_FIRE)) {
                        oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid, C0529tp.K);
                    }
                    this.h.a(abstractC0264ju, serverPlayer, uuid);
                    double dSqrt = Mth.sqrt(livingEntity.distanceTo(serverPlayer));
                    if (dSqrt >= 40.0d) {
                        oR.a(serverPlayer, new sQ(Component.translatable("bf.popup.message.longshot", new Object[]{((int) dSqrt) + "m"}).withStyle(ChatFormatting.YELLOW), 40));
                        oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid, C0529tp.l, 3);
                    }
                }
                break;
            case 1:
                oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid, C0529tp.I);
                oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid, C0529tp.J);
                break;
            case 2:
                oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid, C0529tp.G);
                oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid, C0529tp.H);
                break;
        }
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer, @NotNull ServerPlayer serverPlayer2, @NotNull UUID uuid, @NotNull Set<UUID> set) {
        int iA;
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder;
        oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid, C0529tp.E);
        if ((this.h instanceof InterfaceC0460ra) && (iA = oR.a((oF<?, ?, ?>) this.h, uuid, C0529tp.E)) != 0 && iA % 5 == 0) {
            switch (iA) {
                case 5:
                    deferredHolder = C0624xc.qq;
                    break;
                case 10:
                    deferredHolder = C0624xc.qr;
                    break;
                case 15:
                    deferredHolder = C0624xc.qs;
                    break;
                case 20:
                    deferredHolder = C0624xc.qt;
                    break;
                case ProgressionValues.EXP_PER_INFECTED_ROUNDS_WON /* 25 */:
                    deferredHolder = C0624xc.qu;
                    break;
                case 30:
                    deferredHolder = C0624xc.qv;
                    break;
                default:
                    deferredHolder = C0624xc.qw;
                    break;
            }
            oR.a((oF<?, ?, ?>) this.h, (Component) Component.translatable("bf.message.gamemode.combat.streak.increased", new Object[]{Component.literal(serverPlayer2.getScoreboardName()).withStyle(ChatFormatting.WHITE), Component.literal(C0637xp.a(iA)).withStyle(ChatFormatting.WHITE), Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.WHITE)}).withStyle(ChatFormatting.RED));
            oR.a((oF<?, ?, ?>) this.h, (SoundEvent) deferredHolder.get(), SoundSource.MUSIC);
            oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid, C0529tp.l, iA);
        }
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource, boolean z, boolean z2) {
        oI oIVarB = this.h.b();
        C0421pp c0421pp = new C0421pp();
        MutableComponent mutableComponentLiteral = Component.literal(livingEntity.getScoreboardName());
        MutableComponent mutableComponentWithStyle = null;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        boolean zAp = false;
        boolean zAq = false;
        boolean zAs = false;
        boolean zAr = false;
        int iDistanceTo = 0;
        ItemStack itemStackA = null;
        ServerPlayer entity = damageSource.getEntity();
        if (entity instanceof LivingEntity) {
            ServerPlayer serverPlayer = (LivingEntity) entity;
            itemStackA = serverPlayer.getMainHandItem();
            mutableComponentWithStyle = Component.literal(serverPlayer.getScoreboardName());
            if (serverPlayer instanceof ServerPlayer) {
                UUID uuid = serverPlayer.getUUID();
                oO oOVarA = oIVarB.a(uuid);
                if (oOVarA != null) {
                    mutableComponentWithStyle.setStyle(oOVarA.a());
                }
                if ((this.h instanceof qY) && (livingEntity instanceof ServerPlayer)) {
                    if (this.h.m764a().b(((ServerPlayer) livingEntity).getUUID(), uuid)) {
                        objectArrayList.add(new C0423pr("dominating"));
                    }
                }
                c0421pp.l(uuid);
            } else if (serverPlayer instanceof mE) {
                mE mEVar = (mE) serverPlayer;
                if (mEVar.m671a() != null) {
                    mutableComponentWithStyle.setStyle(mEVar.m671a().a());
                }
            }
        }
        if (damageSource instanceof lZ) {
            lZ lZVar = (lZ) damageSource;
            zAp = lZVar.ap();
            zAq = lZVar.aq();
            zAr = lZVar.ar();
            itemStackA = lZVar.a();
            zAs = lZVar.as();
            if (entity instanceof ServerPlayer) {
                ServerPlayer serverPlayer2 = entity;
                if (livingEntity instanceof ServerPlayer) {
                    UUID uuid2 = serverPlayer2.getUUID();
                    if (zAp) {
                        oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid2, C0529tp.o);
                    }
                    if (zAr) {
                        oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid2, C0529tp.p);
                    }
                }
            }
        } else if (damageSource instanceof C0326mb) {
            itemStackA = ((C0326mb) damageSource).a();
        }
        if (livingEntity instanceof ServerPlayer) {
            UUID uuid3 = ((ServerPlayer) livingEntity).getUUID();
            oO oOVarA2 = oIVarB.a(uuid3);
            if (oOVarA2 != null) {
                mutableComponentLiteral.setStyle(oOVarA2.a());
            }
            c0421pp.k(uuid3);
        }
        if (livingEntity instanceof mE) {
            mE mEVar2 = (mE) livingEntity;
            if (mEVar2.m671a() != null) {
                mutableComponentLiteral.setStyle(mEVar2.m671a().a());
            }
        }
        if (z2 && mutableComponentWithStyle != null && (entity instanceof ServerPlayer)) {
            ServerPlayer serverPlayer3 = entity;
            if (livingEntity instanceof ServerPlayer) {
                oR.a((ServerPlayer) livingEntity, new sR(serverPlayer3.getUUID(), itemStackA, serverPlayer3.getHealth()));
            }
        }
        if (mutableComponentWithStyle == null) {
            mutableComponentWithStyle = Component.literal("World").withStyle(ChatFormatting.GRAY);
        }
        c0421pp.a(new C0427pv(mutableComponentWithStyle));
        a(abstractC0264ju, cVar, livingEntity, c0421pp, (Entity) entity);
        if (itemStackA != null && !itemStackA.isEmpty()) {
            c0421pp.a(new C0424ps(itemStackA));
        }
        if (zAr) {
            objectArrayList.add(new C0423pr("noscope"));
        }
        if (zAq) {
            objectArrayList.add(new C0423pr("wallbang"));
        }
        if (zAs) {
            if (zAp) {
                objectArrayList.add(new C0423pr("collateral_headshot"));
            } else {
                objectArrayList.add(new C0423pr("collateral"));
            }
        }
        if (zAp) {
            objectArrayList.add(new C0423pr("headshot"));
        }
        if (damageSource.is(DamageTypeTags.IS_FIRE)) {
            objectArrayList.add(new C0423pr("fire"));
        }
        if (!objectArrayList.isEmpty()) {
            Objects.requireNonNull(c0421pp);
            objectArrayList.forEach(c0421pp::a);
        } else if (itemStackA == null || itemStackA.isEmpty()) {
            c0421pp.a(new C0423pr("generic"));
        }
        c0421pp.a(new C0427pv(mutableComponentLiteral));
        ServerPlayer entity2 = damageSource.getEntity();
        if (entity2 instanceof ServerPlayer) {
            ServerPlayer serverPlayer4 = entity2;
            if (itemStackA != null && (itemStackA.getItem() instanceof C0558ur)) {
                iDistanceTo = (int) serverPlayer4.distanceTo(livingEntity);
            }
        }
        if (iDistanceTo >= 32) {
            c0421pp.a(new C0425pt(Component.literal(" " + C0637xp.a(iDistanceTo) + "m").withStyle(ChatFormatting.YELLOW)));
        }
        if (z) {
            oR.a((oI<?>) oIVarB, c0421pp);
        }
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull LivingEntity livingEntity, @NotNull C0421pp c0421pp, @Nullable Entity entity) {
        UUID uuid;
        ServerPlayer serverPlayerA;
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            UUID uuid2 = serverPlayer.getUUID();
            Object2FloatOpenHashMap object2FloatOpenHashMap = new Object2FloatOpenHashMap(cVar.m305a((Player) serverPlayer).t());
            object2FloatOpenHashMap.remove(uuid2);
            if (entity != null) {
                object2FloatOpenHashMap.remove(entity.getUUID());
            }
            if (object2FloatOpenHashMap.isEmpty()) {
                a(abstractC0264ju, cVar, c0421pp, entity);
                return;
            }
            ObjectArrayList objectArrayList = new ObjectArrayList(object2FloatOpenHashMap.entrySet());
            objectArrayList.sort(Map.Entry.comparingByValue());
            if (objectArrayList.isEmpty() || (serverPlayerA = oR.a((uuid = (UUID) ((Map.Entry) objectArrayList.getFirst()).getKey()))) == null) {
                return;
            }
            Style styleWithColor = Style.EMPTY.withColor(ChatFormatting.GRAY);
            oO oOVarA = this.h.b().a(uuid);
            if (oOVarA != null) {
                styleWithColor = oOVarA.a();
            }
            MutableComponent mutableComponentWithColor = Component.literal(" +").withColor(ColorReferences.COLOR_WHITE);
            MutableComponent mutableComponentWithStyle = Component.literal(serverPlayerA.getScoreboardName()).withStyle(styleWithColor);
            c0421pp.a(new C0425pt(mutableComponentWithColor));
            c0421pp.a(new C0427pv(mutableComponentWithStyle));
            if (this.h.m750a() == oN.GAME) {
                oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuid, C0529tp.M);
            }
        }
    }

    private void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull C0421pp c0421pp, @Nullable Entity entity) {
        UUID uuidM302a;
        ServerPlayer serverPlayerA;
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) entity;
            if (this.h.aS() <= 0 || (uuidM302a = cVar.m305a((Player) serverPlayer).m302a(serverPlayer.level().getGameTime())) == null || uuidM302a.equals(serverPlayer.getUUID()) || (serverPlayerA = oR.a(uuidM302a)) == null) {
                return;
            }
            Style styleWithColor = Style.EMPTY.withColor(ChatFormatting.GRAY);
            oO oOVarA = this.h.b().a(uuidM302a);
            if (oOVarA != null) {
                styleWithColor = oOVarA.a();
            }
            MutableComponent mutableComponentWithColor = Component.literal(" +").withColor(ColorReferences.COLOR_WHITE);
            MutableComponent mutableComponentWithStyle = Component.literal(serverPlayerA.getScoreboardName()).withStyle(styleWithColor);
            c0421pp.a(new C0425pt(mutableComponentWithColor));
            c0421pp.a(new C0427pv(mutableComponentWithStyle));
            if (this.h.m750a() == oN.GAME) {
                sV sVVarB = sV.b("medic");
                oR.a(abstractC0264ju, (oF<?, ?, ?>) this.h, uuidM302a, C0529tp.M, 1, (ItemStack) null, sVVarB != null ? sVVarB.bN() : -1);
            }
        }
    }
}
