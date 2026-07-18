package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ProgressionValues;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.oL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oL.class */
public class C0793oL<G extends AbstractC0787oF<G, ?, ?>> {

    /* JADX INFO: renamed from: mT */
    private static final int f4348mT = 45;

    /* JADX INFO: renamed from: mU */
    private static final int f4349mU = 5;

    /* JADX INFO: renamed from: mV */
    private static final int f4350mV = 40;

    /* JADX INFO: renamed from: mW */
    private static final int f4351mW = 40;

    /* JADX INFO: renamed from: mX */
    public static final int f4352mX = 32;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final G f4353h;

    public C0793oL(@NotNull G g) {
        this.f4353h = g;
    }

    /* JADX INFO: renamed from: a */
    public void m3843a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull LivingDeathEvent livingDeathEvent, @NotNull Set<UUID> set) {
        ServerPlayer entity = livingDeathEvent.getEntity();
        DamageSource source = livingDeathEvent.getSource();
        ServerPlayer entity2 = source.getEntity();
        AbstractC0183c<?> abstractC0183cM2528a = abstractC0563ju.m2528a();
        G g = this.f4353h;
        if ((g instanceof InterfaceC0913qZ) && ((InterfaceC0913qZ) g).mo4698bC()) {
            m3848a(abstractC0563ju, abstractC0183cM2528a, entity, source, true, true);
        }
        if (this.f4353h.m3587a() != EnumC0795oN.GAME) {
            return;
        }
        if (entity instanceof ServerPlayer) {
            m3844a(abstractC0563ju, abstractC0183cM2528a, entity, (Entity) entity2, set);
        }
        if (entity2 instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity2;
            m3846a(abstractC0563ju, abstractC0183cM2528a, source, serverPlayer, serverPlayer.getUUID(), entity, set);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3844a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerPlayer serverPlayer, @Nullable Entity entity, @NotNull Set<UUID> set) {
        UUID uuid = serverPlayer.getUUID();
        C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5721L);
        C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5723N);
        if (this.f4353h instanceof InterfaceC0967ra) {
            m3845a(abstractC0563ju, entity, serverPlayer, uuid, set);
        }
        C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5714E, 0);
        C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5719J, 0);
        C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5717H, 0);
        abstractC0183c.m1136a((Player) serverPlayer).m1086d(Calendar.getInstance().getTime().getTime());
    }

    /* JADX INFO: renamed from: a */
    private void m3845a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @Nullable Entity entity, @NotNull ServerPlayer serverPlayer, UUID uuid, @NotNull Set<UUID> set) {
        int iM4009a = C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5714E);
        if (iM4009a < 5) {
            return;
        }
        C0799oR.m3934a((AbstractC0787oF<?, ?, ?>) this.f4353h, (SoundEvent) C1280xc.f7609qo.get(), SoundSource.MUSIC);
        C0799oR.m4025a(abstractC0563ju, uuid, CloudAchievements.ACH_USER_LOSE_STREAK);
        MutableComponent mutableComponentWithStyle = Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.WHITE);
        MutableComponent mutableComponentWithStyle2 = Component.literal(String.valueOf(iM4009a)).withStyle(ChatFormatting.WHITE);
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = (ServerPlayer) entity;
            if (serverPlayer2.equals(serverPlayer)) {
                C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) this.f4353h, (Component) Component.translatable("bf.message.gamemode.combat.streak.ended.self", new Object[]{mutableComponentWithStyle, mutableComponentWithStyle2}).withStyle(ChatFormatting.RED));
                C0799oR.m4025a(abstractC0563ju, uuid, CloudAchievements.ACH_USER_END_STREAK_SELF);
                return;
            } else {
                C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) this.f4353h, (Component) Component.translatable("bf.message.gamemode.combat.streak.ended", new Object[]{Component.literal(serverPlayer2.getScoreboardName()).withStyle(ChatFormatting.WHITE), mutableComponentWithStyle, mutableComponentWithStyle2}).withStyle(ChatFormatting.RED));
                C0799oR.m4025a(abstractC0563ju, serverPlayer2.getUUID(), CloudAchievements.ACH_USER_END_STREAK);
                return;
            }
        }
        C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) this.f4353h, (Component) Component.translatable("bf.message.gamemode.combat.streak.ended.other", new Object[]{mutableComponentWithStyle, mutableComponentWithStyle2}).withStyle(ChatFormatting.RED));
    }

    /* JADX INFO: renamed from: a */
    private void m3846a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull DamageSource damageSource, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull LivingEntity livingEntity, @NotNull Set<UUID> set) {
        ItemStack mainHandItem;
        Objects.requireNonNull(livingEntity);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), ServerPlayer.class, C0680mE.class, C0692mQ.class).dynamicInvoker().invoke(livingEntity, 0) /* invoke-custom */) {
            case 0:
                ServerPlayer serverPlayer2 = (ServerPlayer) livingEntity;
                if (!serverPlayer2.equals(serverPlayer)) {
                    AbstractC0182b abstractC0182bM1136a = abstractC0183c.m1136a((Player) serverPlayer);
                    if (damageSource instanceof C0703mb) {
                        mainHandItem = ((C0703mb) damageSource).m3150a();
                    } else {
                        mainHandItem = serverPlayer.getMainHandItem();
                    }
                    C0799oR.m4016a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5713D, 1, mainHandItem);
                    if (!abstractC0182bM1136a.m1087dk()) {
                        m3847a(abstractC0563ju, serverPlayer2, serverPlayer, uuid, set);
                    }
                    C0799oR.m4011a((AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5723N, 0);
                    ItemStack mainHandItem2 = serverPlayer.getMainHandItem();
                    boolean z = mainHandItem2.getItem() instanceof C1056tI;
                    boolean z2 = !(damageSource instanceof C0703mb) || ((C0703mb) damageSource).m3150a().equals(mainHandItem2);
                    if (C0799oR.m4046a(livingEntity, (LivingEntity) serverPlayer, 45.0f) && z && z2) {
                        C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5724O);
                    }
                    if (damageSource.is(DamageTypeTags.IS_FIRE)) {
                        C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5720K);
                    }
                    this.f4353h.m3650a(abstractC0563ju, serverPlayer, uuid);
                    double dSqrt = Mth.sqrt(livingEntity.distanceTo(serverPlayer));
                    if (dSqrt >= 40.0d) {
                        C0799oR.m3943a(serverPlayer, new C1010sQ(Component.translatable("bf.popup.message.longshot", new Object[]{((int) dSqrt) + "m"}).withStyle(ChatFormatting.YELLOW), 40));
                        C0799oR.m4015a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5695l, 3);
                    }
                }
                break;
            case 1:
                C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5718I);
                C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5719J);
                break;
            case 2:
                C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5716G);
                C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5717H);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3847a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerPlayer serverPlayer, @NotNull ServerPlayer serverPlayer2, @NotNull UUID uuid, @NotNull Set<UUID> set) {
        int iM4009a;
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder;
        C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5714E);
        if ((this.f4353h instanceof InterfaceC0967ra) && (iM4009a = C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5714E)) != 0 && iM4009a % 5 == 0) {
            switch (iM4009a) {
                case 5:
                    deferredHolder = C1280xc.f7611qq;
                    break;
                case 10:
                    deferredHolder = C1280xc.f7612qr;
                    break;
                case 15:
                    deferredHolder = C1280xc.f7613qs;
                    break;
                case 20:
                    deferredHolder = C1280xc.f7614qt;
                    break;
                case ProgressionValues.EXP_PER_INFECTED_ROUNDS_WON /* 25 */:
                    deferredHolder = C1280xc.f7615qu;
                    break;
                case 30:
                    deferredHolder = C1280xc.f7616qv;
                    break;
                default:
                    deferredHolder = C1280xc.f7617qw;
                    break;
            }
            C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) this.f4353h, (Component) Component.translatable("bf.message.gamemode.combat.streak.increased", new Object[]{Component.literal(serverPlayer2.getScoreboardName()).withStyle(ChatFormatting.WHITE), Component.literal(C1293xp.m7912a(iM4009a)).withStyle(ChatFormatting.WHITE), Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.WHITE)}).withStyle(ChatFormatting.RED));
            C0799oR.m3934a((AbstractC0787oF<?, ?, ?>) this.f4353h, (SoundEvent) deferredHolder.get(), SoundSource.MUSIC);
            C0799oR.m4015a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5695l, iM4009a);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3848a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource, boolean z, boolean z2) {
        AbstractC0790oI abstractC0790oIM3582b = this.f4353h.m3582b();
        C0876pp c0876pp = new C0876pp();
        MutableComponent mutableComponentLiteral = Component.literal(livingEntity.getScoreboardName());
        MutableComponent mutableComponentWithStyle = null;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        boolean zM2907ap = false;
        boolean zM2908aq = false;
        boolean zM2910as = false;
        boolean zM2909ar = false;
        int iDistanceTo = 0;
        ItemStack itemStackM3150a = null;
        ServerPlayer entity = damageSource.getEntity();
        if (entity instanceof LivingEntity) {
            ServerPlayer serverPlayer = (LivingEntity) entity;
            itemStackM3150a = serverPlayer.getMainHandItem();
            mutableComponentWithStyle = Component.literal(serverPlayer.getScoreboardName());
            if (serverPlayer instanceof ServerPlayer) {
                UUID uuid = serverPlayer.getUUID();
                C0796oO c0796oOM3793a = abstractC0790oIM3582b.m3793a(uuid);
                if (c0796oOM3793a != null) {
                    mutableComponentWithStyle.setStyle(c0796oOM3793a.m3876a());
                }
                if ((this.f4353h instanceof InterfaceC0912qY) && (livingEntity instanceof ServerPlayer)) {
                    if (this.f4353h.m3648a().m4417b(((ServerPlayer) livingEntity).getUUID(), uuid)) {
                        objectArrayList.add(new C0878pr("dominating"));
                    }
                }
                c0876pp.m4434l(uuid);
            } else if (serverPlayer instanceof C0680mE) {
                C0680mE c0680mE = (C0680mE) serverPlayer;
                if (c0680mE.m3046a() != null) {
                    mutableComponentWithStyle.setStyle(c0680mE.m3046a().m3876a());
                }
            }
        }
        if (damageSource instanceof C0648lZ) {
            C0648lZ c0648lZ = (C0648lZ) damageSource;
            zM2907ap = c0648lZ.m2907ap();
            zM2908aq = c0648lZ.m2908aq();
            zM2909ar = c0648lZ.m2909ar();
            itemStackM3150a = c0648lZ.m3150a();
            zM2910as = c0648lZ.m2910as();
            if (entity instanceof ServerPlayer) {
                ServerPlayer serverPlayer2 = entity;
                if (livingEntity instanceof ServerPlayer) {
                    UUID uuid2 = serverPlayer2.getUUID();
                    if (zM2907ap) {
                        C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid2, C1089tp.f5698o);
                    }
                    if (zM2909ar) {
                        C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid2, C1089tp.f5699p);
                    }
                }
            }
        } else if (damageSource instanceof C0703mb) {
            itemStackM3150a = ((C0703mb) damageSource).m3150a();
        }
        if (livingEntity instanceof ServerPlayer) {
            UUID uuid3 = ((ServerPlayer) livingEntity).getUUID();
            C0796oO c0796oOM3793a2 = abstractC0790oIM3582b.m3793a(uuid3);
            if (c0796oOM3793a2 != null) {
                mutableComponentLiteral.setStyle(c0796oOM3793a2.m3876a());
            }
            c0876pp.m4433k(uuid3);
        }
        if (livingEntity instanceof C0680mE) {
            C0680mE c0680mE2 = (C0680mE) livingEntity;
            if (c0680mE2.m3046a() != null) {
                mutableComponentLiteral.setStyle(c0680mE2.m3046a().m3876a());
            }
        }
        if (z2 && mutableComponentWithStyle != null && (entity instanceof ServerPlayer)) {
            ServerPlayer serverPlayer3 = entity;
            if (livingEntity instanceof ServerPlayer) {
                C0799oR.m3945a((ServerPlayer) livingEntity, new C1011sR(serverPlayer3.getUUID(), itemStackM3150a, serverPlayer3.getHealth()));
            }
        }
        if (mutableComponentWithStyle == null) {
            mutableComponentWithStyle = Component.literal("World").withStyle(ChatFormatting.GRAY);
        }
        c0876pp.m4426a(new C0882pv(mutableComponentWithStyle));
        m3849a(abstractC0563ju, abstractC0183c, livingEntity, c0876pp, (Entity) entity);
        if (itemStackM3150a != null && !itemStackM3150a.isEmpty()) {
            c0876pp.m4426a(new C0879ps(itemStackM3150a));
        }
        if (zM2909ar) {
            objectArrayList.add(new C0878pr("noscope"));
        }
        if (zM2908aq) {
            objectArrayList.add(new C0878pr("wallbang"));
        }
        if (zM2910as) {
            if (zM2907ap) {
                objectArrayList.add(new C0878pr("collateral_headshot"));
            } else {
                objectArrayList.add(new C0878pr("collateral"));
            }
        }
        if (zM2907ap) {
            objectArrayList.add(new C0878pr("headshot"));
        }
        if (damageSource.is(DamageTypeTags.IS_FIRE)) {
            objectArrayList.add(new C0878pr("fire"));
        }
        if (!objectArrayList.isEmpty()) {
            Objects.requireNonNull(c0876pp);
            objectArrayList.forEach(c0876pp::m4426a);
        } else if (itemStackM3150a == null || itemStackM3150a.isEmpty()) {
            c0876pp.m4426a(new C0878pr("generic"));
        }
        c0876pp.m4426a(new C0882pv(mutableComponentLiteral));
        ServerPlayer entity2 = damageSource.getEntity();
        if (entity2 instanceof ServerPlayer) {
            ServerPlayer serverPlayer4 = entity2;
            if (itemStackM3150a != null && (itemStackM3150a.getItem() instanceof C1144ur)) {
                iDistanceTo = (int) serverPlayer4.distanceTo(livingEntity);
            }
        }
        if (iDistanceTo >= 32) {
            c0876pp.m4426a(new C0880pt(Component.literal(" " + C1293xp.m7912a(iDistanceTo) + "m").withStyle(ChatFormatting.YELLOW)));
        }
        if (z) {
            C0799oR.m3946a((AbstractC0790oI<?>) abstractC0790oIM3582b, c0876pp);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3849a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull LivingEntity livingEntity, @NotNull C0876pp c0876pp, @Nullable Entity entity) {
        UUID uuid;
        ServerPlayer serverPlayerM3963a;
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            UUID uuid2 = serverPlayer.getUUID();
            Object2FloatOpenHashMap object2FloatOpenHashMap = new Object2FloatOpenHashMap(abstractC0183c.m1136a((Player) serverPlayer).m1123t());
            object2FloatOpenHashMap.remove(uuid2);
            if (entity != null) {
                object2FloatOpenHashMap.remove(entity.getUUID());
            }
            if (object2FloatOpenHashMap.isEmpty()) {
                m3850a(abstractC0563ju, abstractC0183c, c0876pp, entity);
                return;
            }
            ObjectArrayList objectArrayList = new ObjectArrayList(object2FloatOpenHashMap.entrySet());
            objectArrayList.sort(Map.Entry.comparingByValue());
            if (objectArrayList.isEmpty() || (serverPlayerM3963a = C0799oR.m3963a((uuid = (UUID) ((Map.Entry) objectArrayList.getFirst()).getKey()))) == null) {
                return;
            }
            Style styleWithColor = Style.EMPTY.withColor(ChatFormatting.GRAY);
            C0796oO c0796oOM3793a = this.f4353h.m3582b().m3793a(uuid);
            if (c0796oOM3793a != null) {
                styleWithColor = c0796oOM3793a.m3876a();
            }
            MutableComponent mutableComponentWithColor = Component.literal(" +").withColor(ColorReferences.COLOR_WHITE);
            MutableComponent mutableComponentWithStyle = Component.literal(serverPlayerM3963a.getScoreboardName()).withStyle(styleWithColor);
            c0876pp.m4426a(new C0880pt(mutableComponentWithColor));
            c0876pp.m4426a(new C0882pv(mutableComponentWithStyle));
            if (this.f4353h.m3587a() == EnumC0795oN.GAME) {
                C0799oR.m4014a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuid, C1089tp.f5722M);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3850a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull C0876pp c0876pp, @Nullable Entity entity) {
        UUID uuidM1121a;
        ServerPlayer serverPlayerM3963a;
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) entity;
            if (this.f4353h.mo3562aS() <= 0 || (uuidM1121a = abstractC0183c.m1136a((Player) serverPlayer).m1121a(serverPlayer.level().getGameTime())) == null || uuidM1121a.equals(serverPlayer.getUUID()) || (serverPlayerM3963a = C0799oR.m3963a(uuidM1121a)) == null) {
                return;
            }
            Style styleWithColor = Style.EMPTY.withColor(ChatFormatting.GRAY);
            C0796oO c0796oOM3793a = this.f4353h.m3582b().m3793a(uuidM1121a);
            if (c0796oOM3793a != null) {
                styleWithColor = c0796oOM3793a.m3876a();
            }
            MutableComponent mutableComponentWithColor = Component.literal(" +").withColor(ColorReferences.COLOR_WHITE);
            MutableComponent mutableComponentWithStyle = Component.literal(serverPlayerM3963a.getScoreboardName()).withStyle(styleWithColor);
            c0876pp.m4426a(new C0880pt(mutableComponentWithColor));
            c0876pp.m4426a(new C0882pv(mutableComponentWithStyle));
            if (this.f4353h.m3587a() == EnumC0795oN.GAME) {
                C1015sV c1015sVM5529b = C1015sV.m5529b("medic");
                C0799oR.m4017a(abstractC0563ju, (AbstractC0787oF<?, ?, ?>) this.f4353h, uuidM1121a, C1089tp.f5722M, 1, (ItemStack) null, c1015sVM5529b != null ? c1015sVM5529b.m5523bN() : -1);
            }
        }
    }
}
