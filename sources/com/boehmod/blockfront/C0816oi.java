package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.blockfront.C1176vW;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import com.boehmod.blockfront.common.player.C0185e;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.oi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oi.class */
public final class C0816oi {

    /* JADX INFO: renamed from: p */
    private static final UUID f4441p;

    /* JADX INFO: renamed from: ke */
    private static final float f4442ke = 20.0f;

    /* JADX INFO: renamed from: kf */
    private static final float f4443kf = 8.0f;

    /* JADX INFO: renamed from: fI */
    static final /* synthetic */ boolean f4444fI;

    static {
        f4444fI = !C0816oi.class.desiredAssertionStatus();
        f4441p = UUID.fromString("b8a1b294-3a53-4f78-98ee-2b75e6e41f44");
    }

    /* JADX INFO: renamed from: a */
    public static void m4182a(@NotNull LivingDeathEvent livingDeathEvent) {
        C1136uj c1136ujM7778a;
        ServerPlayer entity = livingDeathEvent.getEntity();
        DamageSource source = livingDeathEvent.getSource();
        Level level = entity.level();
        if (level instanceof ServerLevel) {
            Level level2 = (ServerLevel) level;
            ServerPlayer entity2 = source.getEntity();
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f4444fI && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0183c<?> abstractC0183cM2528a = abstractC0563juM168a.m2528a();
            if (entity2 instanceof ServerPlayer) {
                C1194vo.m6648a(new C1154vA(true), entity2);
            }
            if (source instanceof C0702ma) {
                for (ServerPlayer serverPlayer : level2.players()) {
                    if (serverPlayer instanceof ServerPlayer) {
                        C1194vo.m6648a(new C1200vu(EnumC0786oE.GORE_EXPLOSION, entity.getEyePosition()), serverPlayer);
                    }
                }
            }
            if (source instanceof C0703mb) {
                ItemStack itemStackM3150a = ((C0703mb) source).m3150a();
                if (!itemStackM3150a.isEmpty()) {
                    Item item = itemStackM3150a.getItem();
                    if ((item instanceof C1144ur) && ((C1144ur) item).m6393R().equals(C1110uJ.f5844gA)) {
                        for (ServerPlayer serverPlayer2 : level2.players()) {
                            if (serverPlayer2 instanceof ServerPlayer) {
                                C1194vo.m6648a(new C1200vu(EnumC0786oE.GORE_EXPLOSION, entity.getEyePosition()), serverPlayer2);
                            }
                        }
                    }
                }
            }
            if (entity instanceof ServerPlayer) {
                ServerPlayer serverPlayer3 = entity;
                UUID uuid = serverPlayer3.getUUID();
                Inventory inventory = serverPlayer3.getInventory();
                AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
                AbstractC0182b abstractC0182bM1136a = abstractC0183cM2528a.m1136a((Player) serverPlayer3);
                if (abstractC0787oFMo2531a != null) {
                    AbstractC0790oI abstractC0790oIM3582b = abstractC0787oFMo2531a.m3582b();
                    if (abstractC0790oIM3582b.mo3829a(serverPlayer3, source)) {
                        livingDeathEvent.setCanceled(true);
                        return;
                    }
                    if (C0476iM.f2925dm) {
                        C0185e.m1146a(serverPlayer3, abstractC0787oFMo2531a, source);
                    }
                    C0799oR.m3948a(abstractC0183cM2528a, (ServerLevel) level2, serverPlayer3);
                    abstractC0182bM1136a.m1088X(true);
                    abstractC0182bM1136a.m1096I(abstractC0790oIM3582b.m3777a(serverPlayer3));
                    Set<UUID> setM3809h = abstractC0790oIM3582b.m3809h();
                    abstractC0787oFMo2531a.m3630a().m3843a(abstractC0563juM168a, livingDeathEvent, setM3809h);
                    switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), ServerPlayer.class, C0680mE.class, C0692mQ.class).dynamicInvoker().invoke(entity2, 0) /* invoke-custom */) {
                        case -1:
                        default:
                            abstractC0790oIM3582b.m3783a(abstractC0563juM168a, (ServerLevel) level2, serverPlayer3, uuid, (ServerPlayer) null, (UUID) null, source, setM3809h);
                            break;
                        case 0:
                            ServerPlayer serverPlayer4 = entity2;
                            UUID uuid2 = serverPlayer4.getUUID();
                            if (abstractC0563juM168a.m2536a(uuid, uuid2)) {
                                abstractC0790oIM3582b.m3783a(abstractC0563juM168a, (ServerLevel) level2, serverPlayer3, uuid, serverPlayer4, uuid2, source, setM3809h);
                                if (abstractC0787oFMo2531a instanceof InterfaceC0912qY) {
                                    abstractC0787oFMo2531a.m3648a().m4418a(abstractC0183cM2528a, uuid, uuid2, abstractC0787oFMo2531a);
                                }
                                if (uuid.equals(f4441p)) {
                                    C0799oR.m4025a(abstractC0563juM168a, uuid2, CloudAchievements.ACH_USER_SHOT_THE_SHERIFF);
                                }
                            }
                            break;
                        case 1:
                            C0680mE c0680mE = (C0680mE) entity2;
                            if (c0680mE.m3008a() != null) {
                                AttributeSupplier.Builder builderA = c0680mE.m3008a();
                                if (builderA instanceof InterfaceC0899qL) {
                                    ((InterfaceC0899qL) builderA).mo4659a(c0680mE, (Player) serverPlayer3);
                                }
                            }
                            break;
                        case 2:
                            C0692mQ c0692mQ = (C0692mQ) entity2;
                            AttributeSupplier.Builder builderA2 = c0692mQ.m3115a();
                            if (builderA2 instanceof InterfaceC0910qW) {
                                ((InterfaceC0910qW) builderA2).mo4691a(c0692mQ, (Player) serverPlayer3);
                            }
                            break;
                    }
                    if (abstractC0182bM1136a.m1087dk()) {
                        C1273xN c1273xNM7786a = ((C1274xO) abstractC0182bM1136a).m7786a();
                        if (C0476iM.f2922dj && c1273xNM7786a.m7777J() && (c1136ujM7778a = c1273xNM7786a.m7778a()) != null) {
                            int iM7779a = c1273xNM7786a.m7779a(level2.getGameTime());
                            c1273xNM7786a.m7780e();
                            c1136ujM7778a.m6266a(serverPlayer3.getMainHandItem(), level2, serverPlayer3, iM7779a);
                        }
                        BlockPos blockPosBlockPosition = serverPlayer3.blockPosition();
                        ObjectArrayList objectArrayList = (ObjectArrayList) inventory.items.stream().filter(itemStack -> {
                            return !itemStack.isEmpty();
                        }).map(itemStack2 -> {
                            return new ItemEntity(serverPlayer3.level(), blockPosBlockPosition.getX(), blockPosBlockPosition.getY(), blockPosBlockPosition.getZ(), itemStack2.copy());
                        }).collect(Collectors.toCollection(ObjectArrayList::new));
                        inventory.clearContent();
                        entity.setHealth(entity.getMaxHealth());
                        livingDeathEvent.setCanceled(true);
                        if (!NeoForge.EVENT_BUS.post(new LivingDropsEvent(serverPlayer3, source, objectArrayList, false)).isCanceled()) {
                            Objects.requireNonNull(level2);
                            objectArrayList.forEach((v1) -> {
                                r1.addFreshEntity(v1);
                            });
                        }
                    }
                }
                abstractC0182bM1136a.m1116dy();
                abstractC0182bM1136a.m1122dz();
            }
            m4183a(source, entity);
            if (entity instanceof C0727mz) {
                C0727mz c0727mz = (C0727mz) entity;
                if (c0727mz.mo3281a() != null) {
                    AbstractC0787oF<?, ?, ?> abstractC0787oFMo3281a = c0727mz.mo3281a();
                    abstractC0787oFMo3281a.m3630a().m3843a(abstractC0563juM168a, livingDeathEvent, abstractC0787oFMo3281a.m3582b().m3809h());
                }
            }
            if (entity instanceof C0680mE) {
                C0680mE c0680mE2 = (C0680mE) entity;
                AttributeSupplier.Builder builderA3 = c0680mE2.m3008a();
                if (builderA3 instanceof InterfaceC0899qL) {
                    ((InterfaceC0899qL) builderA3).mo4658a(abstractC0563juM168a, level2, c0680mE2, source);
                }
            }
            if (entity instanceof C0692mQ) {
                C0692mQ c0692mQ2 = (C0692mQ) entity;
                AttributeSupplier.Builder builderA4 = c0692mQ2.m3115a();
                if (builderA4 instanceof InterfaceC0910qW) {
                    ((InterfaceC0910qW) builderA4).mo4690a(abstractC0563juM168a, (ServerLevel) level2, c0692mQ2, source);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m4183a(@NotNull DamageSource damageSource, @NotNull LivingEntity livingEntity) {
        Vec3 sourcePosition = damageSource.getSourcePosition();
        if (sourcePosition == null) {
            sourcePosition = livingEntity.getEyePosition();
        }
        boolean zIs = damageSource.is(DamageTypeTags.IS_EXPLOSION);
        boolean zIs2 = damageSource.is(DamageTypeTags.IS_FIRE);
        float f = zIs ? 7.0f : 3.0f;
        Vec3 vec3Subtract = livingEntity.getEyePosition().subtract(sourcePosition.x, sourcePosition.y, sourcePosition.z);
        float fDistanceTo = (float) livingEntity.getEyePosition().distanceTo(sourcePosition);
        boolean z = zIs && fDistanceTo <= 6.0f;
        ItemStack weaponItem = damageSource.getWeaponItem();
        if (weaponItem != null) {
            Item item = weaponItem.getItem();
            if ((item instanceof C1144ur) && ((C1144ur) item).m6393R().equals(C1110uJ.f5844gA)) {
                z = true;
            }
        }
        if (weaponItem != null && weaponItem.getItem() == C1231wY.f7176au.get()) {
            z = true;
        }
        Vector3f vector3fMul = vec3Subtract.normalize().toVector3f().mul(f);
        if (zIs && fDistanceTo <= 8.0f) {
            vector3fMul.add(0.0f, 20.0f * (1.0f - (fDistanceTo / 8.0f)), 0.0f);
        }
        C1194vo.m6649b(new C1176vW(livingEntity.getId(), new C1176vW.a(zIs2, z, zIs, vector3fMul)));
    }
}
