package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import com.boehmod.blockfront.common.player.C0186e;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.oE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oE.class */
public final class C0787oE {

    /* JADX INFO: renamed from: p */
    private static final UUID f4332p;

    /* JADX INFO: renamed from: kX */
    private static final float f4333kX = 20.0f;

    /* JADX INFO: renamed from: kY */
    private static final float f4334kY = 8.0f;

    /* JADX INFO: renamed from: gc */
    static final /* synthetic */ boolean f4335gc;

    static {
        f4335gc = !C0787oE.class.desiredAssertionStatus();
        f4332p = UUID.fromString("b8a1b294-3a53-4f78-98ee-2b75e6e41f44");
    }

    /* JADX INFO: renamed from: a */
    public static void m3669a(@NotNull LivingDeathEvent livingDeathEvent) {
        C1109uH c1109uHM8294a;
        ServerPlayer entity = livingDeathEvent.getEntity();
        DamageSource source = livingDeathEvent.getSource();
        Level level = entity.level();
        if (level instanceof ServerLevel) {
            Level level2 = (ServerLevel) level;
            ServerPlayer entity2 = source.getEntity();
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4335gc && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            AbstractC0184c<?> abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
            if (entity2 instanceof ServerPlayer) {
                C1169vO.m6643a(new C1180vZ(true), entity2);
            }
            if (source instanceof C0725mw) {
                for (ServerPlayer serverPlayer : level2.players()) {
                    if (serverPlayer instanceof ServerPlayer) {
                        C1169vO.m6643a(new C1175vU(EnumC0862pa.GORE_EXPLOSION, entity.getEyePosition()), serverPlayer);
                    }
                }
            }
            if (source instanceof C0726mx) {
                ItemStack itemStackM3343c = ((C0726mx) source).m3343c();
                if (!itemStackM3343c.isEmpty()) {
                    Item item = itemStackM3343c.getItem();
                    if ((item instanceof C1117uP) && ((C1117uP) item).m6368S().equals(C1190vj.f6483gA)) {
                        for (ServerPlayer serverPlayer2 : level2.players()) {
                            if (serverPlayer2 instanceof ServerPlayer) {
                                C1169vO.m6643a(new C1175vU(EnumC0862pa.GORE_EXPLOSION, entity.getEyePosition()), serverPlayer2);
                            }
                        }
                    }
                }
            }
            if (entity instanceof ServerPlayer) {
                ServerPlayer serverPlayer3 = entity;
                UUID uuid = serverPlayer3.getUUID();
                Inventory inventory = serverPlayer3.getInventory();
                AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
                AbstractC0183b abstractC0183bM1153a = abstractC0184cM2351a.m1153a((Player) serverPlayer3);
                if (abstractC0863pbMo2354a != null) {
                    AbstractC0866pe abstractC0866peM4018b = abstractC0863pbMo2354a.m4018b();
                    if (abstractC0866peM4018b.mo4265a(serverPlayer3, source)) {
                        livingDeathEvent.setCanceled(true);
                        return;
                    }
                    if (C0549jf.f3275dx) {
                        C0186e.m1163a(serverPlayer3, abstractC0863pbMo2354a, source);
                    }
                    C0875pn.m4384a(abstractC0184cM2351a, (ServerLevel) level2, serverPlayer3);
                    abstractC0183bM1153a.m1105Y(true);
                    abstractC0183bM1153a.m1113J(abstractC0866peM4018b.m4213a(serverPlayer3));
                    Set<UUID> setM4245h = abstractC0866peM4018b.m4245h();
                    abstractC0863pbMo2354a.m4066a().m4279a(abstractC0531jNM179a, livingDeathEvent);
                    if ((source instanceof C0725mw) && ((C0725mw) source).m3342aD() && entity2 == serverPlayer3) {
                        C0875pn.m4461a(abstractC0531jNM179a, uuid, CloudAchievements.ACH_USER_OVERCOOK);
                    }
                    switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), ServerPlayer.class, C0756na.class, C0768nm.class).dynamicInvoker().invoke(entity2, 0) /* invoke-custom */) {
                        case -1:
                        default:
                            abstractC0866peM4018b.m4219a(abstractC0531jNM179a, (ServerLevel) level2, serverPlayer3, uuid, (ServerPlayer) null, (UUID) null, source, setM4245h);
                            break;
                        case 0:
                            ServerPlayer serverPlayer4 = entity2;
                            UUID uuid2 = serverPlayer4.getUUID();
                            if (abstractC0531jNM179a.m2359a(uuid, uuid2)) {
                                abstractC0866peM4018b.m4219a(abstractC0531jNM179a, (ServerLevel) level2, serverPlayer3, uuid, serverPlayer4, uuid2, source, setM4245h);
                                if (abstractC0863pbMo2354a instanceof InterfaceC0989rv) {
                                    abstractC0863pbMo2354a.m4084a().m3906a(abstractC0184cM2351a, uuid, uuid2, abstractC0863pbMo2354a);
                                }
                                if (uuid.equals(f4332p)) {
                                    C0875pn.m4461a(abstractC0531jNM179a, uuid2, CloudAchievements.ACH_USER_SHOT_THE_SHERIFF);
                                }
                                ItemStack weaponItem = source.getWeaponItem();
                                if (weaponItem != null && (weaponItem.getItem() instanceof C1134ug) && m3670a(serverPlayer4)) {
                                    C0875pn.m4461a(abstractC0531jNM179a, uuid2, CloudAchievements.ACH_USER_BAYONET_DRY);
                                }
                            }
                            break;
                        case 1:
                            C0756na c0756na = (C0756na) entity2;
                            if (c0756na.m3516a() != null) {
                                AttributeSupplier.Builder builderA = c0756na.m3516a();
                                if (builderA instanceof InterfaceC0976ri) {
                                    ((InterfaceC0976ri) builderA).mo5335a(c0756na, (Player) serverPlayer3);
                                }
                            }
                            abstractC0866peM4018b.m4219a(abstractC0531jNM179a, (ServerLevel) level2, serverPlayer3, uuid, (ServerPlayer) null, (UUID) null, source, setM4245h);
                            break;
                        case 2:
                            C0768nm c0768nm = (C0768nm) entity2;
                            AttributeSupplier.Builder builderA2 = c0768nm.m3622a();
                            if (builderA2 instanceof InterfaceC0987rt) {
                                ((InterfaceC0987rt) builderA2).mo5562a(c0768nm, (Player) serverPlayer3);
                            }
                            break;
                    }
                    if (abstractC0183bM1153a.m1104dt()) {
                        C1325yl c1325ylM8302a = ((C1326ym) abstractC0183bM1153a).m8302a();
                        if (C0549jf.f3272du && c1325ylM8302a.m8293K() && (c1109uHM8294a = c1325ylM8302a.m8294a()) != null) {
                            int iM8295b = c1325ylM8302a.m8295b(level2.getGameTime());
                            c1325ylM8302a.m8296e();
                            c1109uHM8294a.m6229a(serverPlayer3.getMainHandItem(), level2, serverPlayer3, iM8295b);
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
                abstractC0183bM1153a.m1133dI();
                abstractC0183bM1153a.m1139dJ();
            }
            m3671a(source, entity);
            if (entity instanceof C0698mV) {
                C0698mV c0698mV = (C0698mV) entity;
                if (c0698mV.mo3116a() != null) {
                    AbstractC0863pb<?, ?, ?> abstractC0863pbMo3116a = c0698mV.mo3116a();
                    abstractC0863pbMo3116a.m4018b().m4245h();
                    abstractC0863pbMo3116a.m4066a().m4279a(abstractC0531jNM179a, livingDeathEvent);
                }
            }
            if (entity instanceof C0756na) {
                C0756na c0756na2 = (C0756na) entity;
                AttributeSupplier.Builder builderA3 = c0756na2.m3516a();
                if (builderA3 instanceof InterfaceC0976ri) {
                    ((InterfaceC0976ri) builderA3).mo5334a(abstractC0531jNM179a, level2, c0756na2, source);
                }
            }
            if (entity instanceof C0768nm) {
                C0768nm c0768nm2 = (C0768nm) entity;
                AttributeSupplier.Builder builderA4 = c0768nm2.m3622a();
                if (builderA4 instanceof InterfaceC0987rt) {
                    ((InterfaceC0987rt) builderA4).mo5561a(abstractC0531jNM179a, (ServerLevel) level2, c0768nm2, source);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3670a(@NotNull ServerPlayer serverPlayer) {
        boolean z = false;
        for (ItemStack itemStack : serverPlayer.getInventory().items) {
            if (!itemStack.isEmpty() && (itemStack.getItem() instanceof C1117uP)) {
                z = true;
                if (C1117uP.m6268d(itemStack) > 0 || C1117uP.m6265c(itemStack) > 0) {
                    return false;
                }
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    private static void m3671a(@NotNull DamageSource damageSource, @NotNull LivingEntity livingEntity) {
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
            if ((item instanceof C1117uP) && ((C1117uP) item).m6368S().equals(C1190vj.f6483gA)) {
                z = true;
            }
        }
        if (weaponItem != null && weaponItem.getItem() == C1308xv.f7741au.get()) {
            z = true;
        }
        Vector3f vector3fMul = vec3Subtract.normalize().toVector3f().mul(f);
        if (zIs && fDistanceTo <= 8.0f) {
            vector3fMul.add(0.0f, 20.0f * (1.0f - (fDistanceTo / 8.0f)), 0.0f);
        }
        C1169vO.m6644b(new C1256ww(livingEntity.getId(), new C1256ww.a(zIs2, z, zIs, vector3fMul)));
    }
}
