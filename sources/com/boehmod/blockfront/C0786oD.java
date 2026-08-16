package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
import com.boehmod.blockfront.common.player.C0186e;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oD.class */
public final class C0786oD {

    /* JADX INFO: renamed from: gb */
    static final /* synthetic */ boolean f4331gb;

    static {
        f4331gb = !C0786oD.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3668a(@NotNull LivingDamageEvent.Pre pre) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a;
        C0872pk c0872pkM3553a;
        C0872pk c0872pkM4229a;
        Entity entity = pre.getEntity();
        DamageContainer container = pre.getContainer();
        DamageSource source = container.getSource();
        C0756na entity2 = source.getEntity();
        float originalDamage = container.getOriginalDamage();
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4331gb && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        if (entity2 != null) {
            Entity vehicle = entity.getVehicle();
            if (vehicle instanceof AbstractC0750nU) {
                AbstractC0750nU abstractC0750nU = (AbstractC0750nU) vehicle;
                if (originalDamage < Float.MAX_VALUE && abstractC0750nU.m3450k(entity)) {
                    container.setNewDamage(0.0f);
                    return;
                }
            }
        }
        if (source.is(DamageTypeTags.IS_FALL) && ((LivingEntity) entity).tickCount < 20) {
            container.setNewDamage(0.0f);
            return;
        }
        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) entity;
            Vec3 sourcePosition = source.getSourcePosition();
            if (sourcePosition != null) {
                C1169vO.m6643a(new C1165vK(sourcePosition, Math.min(1.0f, originalDamage / 5.0f)), serverPlayer);
            }
            if (source instanceof C0724mv) {
                C1169vO.m6643a(new C1216wI(entity2 instanceof C0756na), serverPlayer);
            }
        }
        if (entity2 instanceof C0756na) {
            C0872pk c0872pkM3553a2 = entity2.m3553a();
            if (entity instanceof Player) {
                Player player = (Player) entity;
                AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a2 = abstractC0531jNM179a.mo2354a(player.getUUID());
                if (abstractC0863pbMo2354a2 != null && (c0872pkM4229a = abstractC0863pbMo2354a2.m4018b().m4229a(player.getUUID())) != null && c0872pkM4229a.equals(c0872pkM3553a2)) {
                    container.setNewDamage(0.0f);
                    return;
                }
            } else if ((entity instanceof C0756na) && (c0872pkM3553a = ((C0756na) entity).m3553a()) != null && c0872pkM3553a.equals(c0872pkM3553a2)) {
                container.setNewDamage(0.0f);
                return;
            }
        }
        if (entity2 instanceof Player) {
            ServerPlayer serverPlayer2 = (Player) entity2;
            UUID uuid = serverPlayer2.getUUID();
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a3 = abstractC0531jNM179a.mo2354a(uuid);
            if (abstractC0863pbMo2354a3 != null && (source instanceof C0724mv)) {
                container.setNewDamage(originalDamage * abstractC0863pbMo2354a3.m4020aL());
            }
            float newDamage = container.getNewDamage();
            if (entity instanceof Player) {
                Player player2 = (Player) entity;
                if (newDamage > 0.0f) {
                    abstractC0184cM2351a.m1153a(player2).m1132a(uuid, newDamage);
                }
            }
            if (newDamage > 0.0f) {
                C0804oV.m3694a(entity.level(), entity.position(), 1.5f);
            }
            if (serverPlayer2 instanceof ServerPlayer) {
                ServerPlayer serverPlayer3 = serverPlayer2;
                if (abstractC0184cM2351a.m1153a((Player) serverPlayer2).m1134a(entity.getId(), entity.level().getGameTime())) {
                    C1169vO.m6643a(new C1180vZ(false), serverPlayer3);
                }
            }
        }
        if (C0549jf.f3275dx && (entity instanceof ServerPlayer)) {
            ServerPlayer serverPlayer4 = (ServerPlayer) entity;
            float newDamage2 = container.getNewDamage();
            if (newDamage2 > 0.0f && newDamage2 < serverPlayer4.getHealth() && (abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(serverPlayer4.getUUID())) != null && abstractC0184cM2351a.m1153a((Player) serverPlayer4).m1135e(serverPlayer4.level().getGameTime())) {
                C0186e.m1162a(serverPlayer4, abstractC0863pbMo2354a);
            }
        }
    }
}
