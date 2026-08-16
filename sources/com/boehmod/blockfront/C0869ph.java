package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ProgressionValues;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.util.Calendar;
import java.util.Map;
import java.util.Objects;
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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ph */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ph.class */
public class C0869ph<G extends AbstractC0863pb<G, ?, ?>> {

    /* JADX INFO: renamed from: oR */
    private static final int f4743oR = 45;

    /* JADX INFO: renamed from: oS */
    private static final int f4744oS = 5;

    /* JADX INFO: renamed from: oT */
    private static final int f4745oT = 40;

    /* JADX INFO: renamed from: oU */
    private static final int f4746oU = 40;

    /* JADX INFO: renamed from: oV */
    public static final int f4747oV = 32;

    /* JADX INFO: renamed from: oW */
    public static final int f4748oW = 1;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final G f4749h;

    public C0869ph(@NotNull G g) {
        this.f4749h = g;
    }

    /* JADX INFO: renamed from: a */
    public void m4279a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull LivingDeathEvent livingDeathEvent) {
        ServerPlayer entity = livingDeathEvent.getEntity();
        DamageSource source = livingDeathEvent.getSource();
        ServerPlayer entity2 = source.getEntity();
        AbstractC0184c<?> abstractC0184cM2351a = abstractC0531jN.m2351a();
        G g = this.f4749h;
        if ((g instanceof InterfaceC0990rw) && ((InterfaceC0990rw) g).mo5348bM()) {
            m4284a(abstractC0531jN, abstractC0184cM2351a, (LivingEntity) entity, source, true, true);
        }
        if (this.f4749h.m4023a() != EnumC0871pj.GAME) {
            return;
        }
        if (entity instanceof ServerPlayer) {
            m4280a(abstractC0531jN, abstractC0184cM2351a, entity, (Entity) entity2);
        }
        if (entity2 instanceof ServerPlayer) {
            ServerPlayer serverPlayer = entity2;
            m4282a(abstractC0531jN, abstractC0184cM2351a, source, serverPlayer, serverPlayer.getUUID(), (LivingEntity) entity);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4280a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerPlayer serverPlayer, @Nullable Entity entity) {
        UUID uuid = serverPlayer.getUUID();
        C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5774L);
        C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5776N);
        if (this.f4749h instanceof InterfaceC0991rx) {
            m4281a(abstractC0531jN, entity, serverPlayer, uuid);
        }
        C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5767E, 0);
        C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5772J, 0);
        C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5770H, 0);
        abstractC0184c.m1153a((Player) serverPlayer).m1103e(Calendar.getInstance().getTime().getTime());
    }

    /* JADX INFO: renamed from: a */
    private void m4281a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @Nullable Entity entity, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid) {
        int iM4445a = C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5767E);
        if (iM4445a < 5) {
            return;
        }
        C0875pn.m4370a((AbstractC0863pb<?, ?, ?>) this.f4749h, (SoundEvent) C1312xz.f8021qq.get(), SoundSource.MUSIC);
        C0875pn.m4461a(abstractC0531jN, uuid, CloudAchievements.ACH_USER_LOSE_STREAK);
        MutableComponent mutableComponentWithStyle = Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.WHITE);
        MutableComponent mutableComponentWithStyle2 = Component.literal(String.valueOf(iM4445a)).withStyle(ChatFormatting.WHITE);
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = (ServerPlayer) entity;
            if (serverPlayer2.equals(serverPlayer)) {
                C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) this.f4749h, (Component) Component.translatable("bf.message.gamemode.combat.streak.ended.self", new Object[]{mutableComponentWithStyle, mutableComponentWithStyle2}).withStyle(ChatFormatting.RED));
                C0875pn.m4461a(abstractC0531jN, uuid, CloudAchievements.ACH_USER_END_STREAK_SELF);
                return;
            } else {
                C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) this.f4749h, (Component) Component.translatable("bf.message.gamemode.combat.streak.ended", new Object[]{Component.literal(serverPlayer2.getScoreboardName()).withStyle(ChatFormatting.WHITE), mutableComponentWithStyle, mutableComponentWithStyle2}).withStyle(ChatFormatting.RED));
                C0875pn.m4461a(abstractC0531jN, serverPlayer2.getUUID(), CloudAchievements.ACH_USER_END_STREAK);
                return;
            }
        }
        C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) this.f4749h, (Component) Component.translatable("bf.message.gamemode.combat.streak.ended.other", new Object[]{mutableComponentWithStyle, mutableComponentWithStyle2}).withStyle(ChatFormatting.RED));
    }

    /* JADX INFO: renamed from: a */
    private void m4282a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull DamageSource damageSource, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid, @NotNull LivingEntity livingEntity) {
        ItemStack mainHandItem;
        Objects.requireNonNull(livingEntity);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), ServerPlayer.class, C0756na.class, C0768nm.class).dynamicInvoker().invoke(livingEntity, 0) /* invoke-custom */) {
            case 0:
                ServerPlayer serverPlayer2 = (ServerPlayer) livingEntity;
                if (!serverPlayer2.equals(serverPlayer)) {
                    AbstractC0183b abstractC0183bM1153a = abstractC0184c.m1153a((Player) serverPlayer);
                    if (damageSource instanceof C0726mx) {
                        mainHandItem = ((C0726mx) damageSource).m3343c();
                    } else {
                        mainHandItem = serverPlayer.getMainHandItem();
                    }
                    C0875pn.m4452a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5766D, 1, mainHandItem);
                    if (!abstractC0183bM1153a.m1104dt()) {
                        m4283a(abstractC0531jN, serverPlayer2, serverPlayer, uuid);
                    }
                    C0875pn.m4447a((AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5776N, 0);
                    ItemStack mainHandItem2 = serverPlayer.getMainHandItem();
                    boolean z = mainHandItem2.getItem() instanceof C1134ug;
                    boolean z2 = !(damageSource instanceof C0726mx) || ((C0726mx) damageSource).m3343c().equals(mainHandItem2);
                    if (C0875pn.m4482a(livingEntity, (LivingEntity) serverPlayer, 45.0f) && z && z2) {
                        C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5777O);
                    }
                    if (damageSource.is(DamageTypeTags.IS_FIRE)) {
                        C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5773K);
                    }
                    this.f4749h.m4086a(abstractC0531jN, serverPlayer, uuid);
                    double dDistanceTo = livingEntity.distanceTo(serverPlayer);
                    if ((damageSource instanceof C0724mv) && dDistanceTo >= 40.0d) {
                        C0875pn.m4379a(serverPlayer, new C1088tn(Component.translatable("bf.popup.message.longshot", new Object[]{((int) dDistanceTo) + "m"}).withStyle(ChatFormatting.YELLOW), 40));
                        C0875pn.m4451a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5748l, 1);
                        break;
                    }
                }
                break;
            case 1:
                C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5771I);
                C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5772J);
                break;
            case 2:
                C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5769G);
                C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5770H);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4283a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerPlayer serverPlayer, @NotNull ServerPlayer serverPlayer2, @NotNull UUID uuid) {
        int iM4445a;
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder;
        C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5767E);
        if ((this.f4749h instanceof InterfaceC0991rx) && (iM4445a = C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5767E)) != 0 && iM4445a % 5 == 0) {
            switch (iM4445a) {
                case 5:
                    deferredHolder = C1312xz.f8023qs;
                    break;
                case 10:
                    deferredHolder = C1312xz.f8024qt;
                    break;
                case 15:
                    deferredHolder = C1312xz.f8025qu;
                    break;
                case 20:
                    deferredHolder = C1312xz.f8026qv;
                    break;
                case ProgressionValues.EXP_PER_INFECTED_ROUNDS_WON /* 25 */:
                    deferredHolder = C1312xz.f8027qw;
                    break;
                case 30:
                    deferredHolder = C1312xz.f8028qx;
                    break;
                default:
                    deferredHolder = C1312xz.f8029qy;
                    break;
            }
            C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) this.f4749h, (Component) Component.translatable("bf.message.gamemode.combat.streak.increased", new Object[]{Component.literal(serverPlayer2.getScoreboardName()).withStyle(ChatFormatting.WHITE), Component.literal(C1273xM.m7239b(iM4445a)).withStyle(ChatFormatting.WHITE), Component.literal(serverPlayer.getScoreboardName()).withStyle(ChatFormatting.WHITE)}).withStyle(ChatFormatting.RED));
            C0875pn.m4370a((AbstractC0863pb<?, ?, ?>) this.f4749h, (SoundEvent) deferredHolder.get(), SoundSource.MUSIC);
            C0875pn.m4451a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5748l, iM4445a);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4284a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull LivingEntity livingEntity, @NotNull DamageSource damageSource, boolean z, boolean z2) {
        AbstractC0866pe abstractC0866peM4018b = this.f4749h.m4018b();
        C0847pL c0847pL = new C0847pL();
        MutableComponent mutableComponentLiteral = Component.literal(livingEntity.getScoreboardName());
        MutableComponent mutableComponentWithStyle = null;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        boolean zM3338az = false;
        boolean zM3339aA = false;
        boolean zM3341aC = false;
        boolean zM3340aB = false;
        int iDistanceTo = 0;
        ItemStack itemStackM3343c = null;
        ServerPlayer entity = damageSource.getEntity();
        if (entity instanceof LivingEntity) {
            ServerPlayer serverPlayer = (LivingEntity) entity;
            itemStackM3343c = serverPlayer.getMainHandItem();
            mutableComponentWithStyle = Component.literal(serverPlayer.getScoreboardName());
            if (serverPlayer instanceof ServerPlayer) {
                UUID uuid = serverPlayer.getUUID();
                C0872pk c0872pkM4229a = abstractC0866peM4018b.m4229a(uuid);
                if (c0872pkM4229a != null) {
                    mutableComponentWithStyle.setStyle(c0872pkM4229a.m4312a());
                }
                if ((this.f4749h instanceof InterfaceC0989rv) && (livingEntity instanceof ServerPlayer)) {
                    if (this.f4749h.m4084a().m3905b(((ServerPlayer) livingEntity).getUUID(), uuid)) {
                        objectArrayList.add(new C0849pN("dominating"));
                    }
                }
                c0847pL.m3922l(uuid);
            } else if (serverPlayer instanceof C0756na) {
                C0756na c0756na = (C0756na) serverPlayer;
                if (c0756na.m3553a() != null) {
                    mutableComponentWithStyle.setStyle(c0756na.m3553a().m4312a());
                }
            }
        }
        if (damageSource instanceof C0724mv) {
            C0724mv c0724mv = (C0724mv) damageSource;
            zM3338az = c0724mv.m3338az();
            zM3339aA = c0724mv.m3339aA();
            zM3340aB = c0724mv.m3340aB();
            itemStackM3343c = c0724mv.m3343c();
            zM3341aC = c0724mv.m3341aC();
            if (entity instanceof ServerPlayer) {
                ServerPlayer serverPlayer2 = entity;
                if ((livingEntity instanceof ServerPlayer) && this.f4749h.m4023a() == EnumC0871pj.GAME) {
                    UUID uuid2 = serverPlayer2.getUUID();
                    if (zM3338az) {
                        C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid2, C1062tN.f5751o);
                    }
                    if (zM3340aB) {
                        C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid2, C1062tN.f5752p);
                    }
                }
            }
        } else if (damageSource instanceof C0726mx) {
            itemStackM3343c = ((C0726mx) damageSource).m3343c();
        }
        if (livingEntity instanceof ServerPlayer) {
            UUID uuid3 = ((ServerPlayer) livingEntity).getUUID();
            C0872pk c0872pkM4229a2 = abstractC0866peM4018b.m4229a(uuid3);
            if (c0872pkM4229a2 != null) {
                mutableComponentLiteral.setStyle(c0872pkM4229a2.m4312a());
            }
            c0847pL.m3921k(uuid3);
        }
        if (livingEntity instanceof C0756na) {
            C0756na c0756na2 = (C0756na) livingEntity;
            if (c0756na2.m3553a() != null) {
                mutableComponentLiteral.setStyle(c0756na2.m3553a().m4312a());
            }
        }
        if (z2 && mutableComponentWithStyle != null && (entity instanceof ServerPlayer)) {
            ServerPlayer serverPlayer3 = entity;
            if (livingEntity instanceof ServerPlayer) {
                C0875pn.m4381a((ServerPlayer) livingEntity, new C1089to(serverPlayer3.getUUID(), itemStackM3343c, serverPlayer3.getHealth()));
            }
        }
        if (mutableComponentWithStyle == null) {
            mutableComponentWithStyle = Component.literal("World").withStyle(ChatFormatting.GRAY);
        }
        c0847pL.m3914a(new C0853pR(mutableComponentWithStyle));
        m4285a(abstractC0531jN, abstractC0184c, livingEntity, c0847pL, entity);
        if (itemStackM3343c != null && !itemStackM3343c.isEmpty()) {
            c0847pL.m3914a(new C0850pO(itemStackM3343c));
        }
        if (zM3340aB) {
            objectArrayList.add(new C0849pN("noscope"));
        }
        if (zM3339aA) {
            objectArrayList.add(new C0849pN("wallbang"));
        }
        if (zM3341aC) {
            if (zM3338az) {
                objectArrayList.add(new C0849pN("collateral_headshot"));
            } else {
                objectArrayList.add(new C0849pN("collateral"));
            }
        }
        if (zM3338az) {
            objectArrayList.add(new C0849pN("headshot"));
        }
        if (damageSource.is(DamageTypeTags.IS_FIRE)) {
            objectArrayList.add(new C0849pN("fire"));
        }
        if (!objectArrayList.isEmpty()) {
            Objects.requireNonNull(c0847pL);
            objectArrayList.forEach(c0847pL::m3914a);
        } else if (itemStackM3343c == null || itemStackM3343c.isEmpty()) {
            c0847pL.m3914a(new C0849pN("generic"));
        }
        c0847pL.m3914a(new C0853pR(mutableComponentLiteral));
        ServerPlayer entity2 = damageSource.getEntity();
        if (entity2 instanceof ServerPlayer) {
            ServerPlayer serverPlayer4 = entity2;
            if (itemStackM3343c != null && (itemStackM3343c.getItem() instanceof C1117uP)) {
                iDistanceTo = (int) serverPlayer4.distanceTo(livingEntity);
            }
        }
        if (iDistanceTo >= 32) {
            c0847pL.m3914a(new C0851pP(Component.literal(" " + C1273xM.m7239b(iDistanceTo) + "m").withStyle(ChatFormatting.YELLOW)));
        }
        if (z) {
            C0875pn.m4382a((AbstractC0866pe<?>) abstractC0866peM4018b, c0847pL);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4285a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull LivingEntity livingEntity, @NotNull C0847pL c0847pL, @Nullable Entity entity) {
        UUID uuid;
        ServerPlayer serverPlayerM4399a;
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            UUID uuid2 = serverPlayer.getUUID();
            Object2FloatOpenHashMap object2FloatOpenHashMap = new Object2FloatOpenHashMap(abstractC0184c.m1153a((Player) serverPlayer).m1140t());
            object2FloatOpenHashMap.remove(uuid2);
            if (entity != null) {
                object2FloatOpenHashMap.remove(entity.getUUID());
            }
            if (object2FloatOpenHashMap.isEmpty()) {
                m4286a(abstractC0531jN, abstractC0184c, c0847pL, entity);
                return;
            }
            ObjectArrayList objectArrayList = new ObjectArrayList(object2FloatOpenHashMap.entrySet());
            objectArrayList.sort(Map.Entry.comparingByValue());
            if (objectArrayList.isEmpty() || (serverPlayerM4399a = C0875pn.m4399a((uuid = (UUID) ((Map.Entry) objectArrayList.getFirst()).getKey()))) == null) {
                return;
            }
            Style styleWithColor = Style.EMPTY.withColor(ChatFormatting.GRAY);
            C0872pk c0872pkM4229a = this.f4749h.m4018b().m4229a(uuid);
            if (c0872pkM4229a != null) {
                styleWithColor = c0872pkM4229a.m4312a();
            }
            MutableComponent mutableComponentWithColor = Component.literal(" +").withColor(ColorReferences.COLOR_WHITE);
            MutableComponent mutableComponentWithStyle = Component.literal(serverPlayerM4399a.getScoreboardName()).withStyle(styleWithColor);
            c0847pL.m3914a(new C0851pP(mutableComponentWithColor));
            c0847pL.m3914a(new C0853pR(mutableComponentWithStyle));
            if (this.f4749h.m4023a() == EnumC0871pj.GAME) {
                C0875pn.m4450a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuid, C1062tN.f5775M);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4286a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull C0847pL c0847pL, @Nullable Entity entity) {
        UUID uuidM1138a;
        ServerPlayer serverPlayerM4399a;
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) entity;
            if (this.f4749h.mo3998bh() <= 0 || (uuidM1138a = abstractC0184c.m1153a((Player) serverPlayer).m1138a(serverPlayer.level().getGameTime())) == null || uuidM1138a.equals(serverPlayer.getUUID()) || (serverPlayerM4399a = C0875pn.m4399a(uuidM1138a)) == null) {
                return;
            }
            Style styleWithColor = Style.EMPTY.withColor(ChatFormatting.GRAY);
            C0872pk c0872pkM4229a = this.f4749h.m4018b().m4229a(uuidM1138a);
            if (c0872pkM4229a != null) {
                styleWithColor = c0872pkM4229a.m4312a();
            }
            MutableComponent mutableComponentWithColor = Component.literal(" +").withColor(ColorReferences.COLOR_WHITE);
            MutableComponent mutableComponentWithStyle = Component.literal(serverPlayerM4399a.getScoreboardName()).withStyle(styleWithColor);
            c0847pL.m3914a(new C0851pP(mutableComponentWithColor));
            c0847pL.m3914a(new C0853pR(mutableComponentWithStyle));
            if (this.f4749h.m4023a() == EnumC0871pj.GAME) {
                C1093ts c1093tsM6017b = C1093ts.m6017b("medic");
                C0875pn.m4453a(abstractC0531jN, (AbstractC0863pb<?, ?, ?>) this.f4749h, uuidM1138a, C1062tN.f5775M, 1, (ItemStack) null, c1093tsM6017b != null ? c1093tsM6017b.m6011cc() : -1);
            }
        }
    }
}
