package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.blockfront.vW;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.oi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oi.class */
public final class C0387oi {
    private static final UUID p;
    private static final float ke = 20.0f;
    private static final float kf = 8.0f;
    static final /* synthetic */ boolean fI;

    static {
        fI = !C0387oi.class.desiredAssertionStatus();
        p = UUID.fromString("b8a1b294-3a53-4f78-98ee-2b75e6e41f44");
    }

    public static void a(@NotNull LivingDeathEvent livingDeathEvent) {
        C0550uj c0550ujA;
        ServerPlayer entity = livingDeathEvent.getEntity();
        DamageSource source = livingDeathEvent.getSource();
        Level level = entity.level();
        if (level instanceof ServerLevel) {
            Level level2 = (ServerLevel) level;
            ServerPlayer entity2 = source.getEntity();
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!fI && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            com.boehmod.blockfront.common.player.c<?> cVarM531a = abstractC0264juM166a.m531a();
            if (entity2 instanceof ServerPlayer) {
                C0582vo.a(new vA(true), entity2);
            }
            if (source instanceof C0325ma) {
                for (ServerPlayer serverPlayer : level2.players()) {
                    if (serverPlayer instanceof ServerPlayer) {
                        C0582vo.a(new C0588vu(oE.GORE_EXPLOSION, entity.getEyePosition()), serverPlayer);
                    }
                }
            }
            if (source instanceof C0326mb) {
                ItemStack itemStackA = ((C0326mb) source).a();
                if (!itemStackA.isEmpty()) {
                    Item item = itemStackA.getItem();
                    if ((item instanceof C0558ur) && ((C0558ur) item).R().equals(uJ.gA)) {
                        for (ServerPlayer serverPlayer2 : level2.players()) {
                            if (serverPlayer2 instanceof ServerPlayer) {
                                C0582vo.a(new C0588vu(oE.GORE_EXPLOSION, entity.getEyePosition()), serverPlayer2);
                            }
                        }
                    }
                }
            }
            if (entity instanceof ServerPlayer) {
                ServerPlayer serverPlayer3 = entity;
                UUID uuid = serverPlayer3.getUUID();
                Inventory inventory = serverPlayer3.getInventory();
                oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
                com.boehmod.blockfront.common.player.b bVarM305a = cVarM531a.m305a((Player) serverPlayer3);
                if (oFVarMo604a != null) {
                    oI oIVarB = oFVarMo604a.b();
                    if (oIVarB.a(serverPlayer3, source)) {
                        livingDeathEvent.setCanceled(true);
                        return;
                    }
                    if (iM.dm) {
                        com.boehmod.blockfront.common.player.e.a(serverPlayer3, oFVarMo604a, source);
                    }
                    oR.a(cVarM531a, (ServerLevel) level2, serverPlayer3);
                    bVarM305a.X(true);
                    bVarM305a.I(oIVarB.a(serverPlayer3));
                    Set<UUID> setH = oIVarB.h();
                    oFVarMo604a.m759a().a(abstractC0264juM166a, livingDeathEvent, setH);
                    switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), ServerPlayer.class, mE.class, mQ.class).dynamicInvoker().invoke(entity2, 0) /* invoke-custom */) {
                        case -1:
                        default:
                            oIVarB.a(abstractC0264juM166a, (ServerLevel) level2, serverPlayer3, uuid, (ServerPlayer) null, (UUID) null, source, setH);
                            break;
                        case 0:
                            ServerPlayer serverPlayer4 = entity2;
                            UUID uuid2 = serverPlayer4.getUUID();
                            if (abstractC0264juM166a.a(uuid, uuid2)) {
                                oIVarB.a(abstractC0264juM166a, (ServerLevel) level2, serverPlayer3, uuid, serverPlayer4, uuid2, source, setH);
                                if (oFVarMo604a instanceof qY) {
                                    oFVarMo604a.m764a().a(cVarM531a, uuid, uuid2, oFVarMo604a);
                                }
                                if (uuid.equals(p)) {
                                    oR.a(abstractC0264juM166a, uuid2, CloudAchievements.ACH_USER_SHOT_THE_SHERIFF);
                                }
                            }
                            break;
                        case 1:
                            mE mEVar = (mE) entity2;
                            if (mEVar.a() != null) {
                                AttributeSupplier.Builder builderA = mEVar.a();
                                if (builderA instanceof qL) {
                                    ((qL) builderA).a(mEVar, (Player) serverPlayer3);
                                }
                            }
                            break;
                        case 2:
                            mQ mQVar = (mQ) entity2;
                            AttributeSupplier.Builder builderA2 = mQVar.a();
                            if (builderA2 instanceof qW) {
                                ((qW) builderA2).a(mQVar, (Player) serverPlayer3);
                            }
                            break;
                    }
                    if (bVarM305a.dk()) {
                        xN xNVarM1677a = ((xO) bVarM305a).m1677a();
                        if (iM.dj && xNVarM1677a.J() && (c0550ujA = xNVarM1677a.a()) != null) {
                            int iA = xNVarM1677a.a(level2.getGameTime());
                            xNVarM1677a.e();
                            c0550ujA.a(serverPlayer3.getMainHandItem(), level2, serverPlayer3, iA);
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
                bVarM305a.dy();
                bVarM305a.dz();
            }
            a(source, entity);
            if (entity instanceof C0350mz) {
                C0350mz c0350mz = (C0350mz) entity;
                if (c0350mz.a() != null) {
                    oF<?, ?, ?> oFVarA = c0350mz.a();
                    oFVarA.m759a().a(abstractC0264juM166a, livingDeathEvent, oFVarA.b().h());
                }
            }
            if (entity instanceof mE) {
                mE mEVar2 = (mE) entity;
                AttributeSupplier.Builder builderA3 = mEVar2.a();
                if (builderA3 instanceof qL) {
                    ((qL) builderA3).a(abstractC0264juM166a, level2, mEVar2, source);
                }
            }
            if (entity instanceof mQ) {
                mQ mQVar2 = (mQ) entity;
                AttributeSupplier.Builder builderA4 = mQVar2.a();
                if (builderA4 instanceof qW) {
                    ((qW) builderA4).a(abstractC0264juM166a, (ServerLevel) level2, mQVar2, source);
                }
            }
        }
    }

    private static void a(@NotNull DamageSource damageSource, @NotNull LivingEntity livingEntity) {
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
            if ((item instanceof C0558ur) && ((C0558ur) item).R().equals(uJ.gA)) {
                z = true;
            }
        }
        if (weaponItem != null && weaponItem.getItem() == wY.au.get()) {
            z = true;
        }
        Vector3f vector3fMul = vec3Subtract.normalize().toVector3f().mul(f);
        if (zIs && fDistanceTo <= 8.0f) {
            vector3fMul.add(0.0f, 20.0f * (1.0f - (fDistanceTo / 8.0f)), 0.0f);
        }
        C0582vo.b(new vW(livingEntity.getId(), new vW.a(zIs2, z, zIs, vector3fMul)));
    }
}
