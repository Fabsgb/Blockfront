package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
import com.boehmod.blockfront.common.player.C0185e;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.oh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oh.class */
public final class C0815oh {

    /* JADX INFO: renamed from: fH */
    static final /* synthetic */ boolean f4440fH;

    static {
        f4440fH = !C0815oh.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m4181a(@NotNull LivingDamageEvent.Pre pre) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a;
        C0796oO c0796oOM3046a;
        C0796oO c0796oOM3793a;
        Entity entity = pre.getEntity();
        DamageContainer container = pre.getContainer();
        DamageSource source = container.getSource();
        C0680mE entity2 = source.getEntity();
        float originalDamage = container.getOriginalDamage();
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4440fH && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        if (entity2 != null) {
            Entity vehicle = entity.getVehicle();
            if (vehicle instanceof AbstractC0779ny) {
                AbstractC0779ny abstractC0779ny = (AbstractC0779ny) vehicle;
                if (originalDamage < Float.MAX_VALUE && abstractC0779ny.m3513k(entity)) {
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
                C1194vo.m6648a(new C1190vk(sourcePosition, Math.min(1.0f, originalDamage / 5.0f)), serverPlayer);
            }
            if (source instanceof C0648lZ) {
                C1194vo.m6648a(new C1244wl(entity2 instanceof C0680mE), serverPlayer);
            }
        }
        if (entity2 instanceof C0680mE) {
            C0796oO c0796oOM3046a2 = entity2.m3046a();
            if (entity instanceof Player) {
                Player player = (Player) entity;
                AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a2 = abstractC0563juM168a.mo2531a(player.getUUID());
                if (abstractC0787oFMo2531a2 != null && (c0796oOM3793a = abstractC0787oFMo2531a2.m3582b().m3793a(player.getUUID())) != null && c0796oOM3793a.equals(c0796oOM3046a2)) {
                    container.setNewDamage(0.0f);
                    return;
                }
            } else if ((entity instanceof C0680mE) && (c0796oOM3046a = ((C0680mE) entity).m3046a()) != null && c0796oOM3046a.equals(c0796oOM3046a2)) {
                container.setNewDamage(0.0f);
                return;
            }
        }
        if (entity2 instanceof Player) {
            ServerPlayer serverPlayer2 = (Player) entity2;
            UUID uuid = serverPlayer2.getUUID();
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a3 = abstractC0563juM168a.mo2531a(uuid);
            if (abstractC0787oFMo2531a3 != null && (source instanceof C0648lZ)) {
                container.setNewDamage(originalDamage * abstractC0787oFMo2531a3.m3584aF());
            }
            float newDamage = container.getNewDamage();
            if (entity instanceof Player) {
                Player player2 = (Player) entity;
                if (newDamage > 0.0f) {
                    abstractC0183cM2528a.m1136a(player2).m1115a(uuid, newDamage);
                }
            }
            if (newDamage > 0.0f) {
                C0833oz.m4206a(entity.level(), entity.position(), 1.5f);
            }
            if (serverPlayer2 instanceof ServerPlayer) {
                ServerPlayer serverPlayer3 = serverPlayer2;
                if (abstractC0183cM2528a.m1136a((Player) serverPlayer2).m1117a(entity.getId(), entity.level().getGameTime())) {
                    C1194vo.m6648a(new C1154vA(false), serverPlayer3);
                }
            }
        }
        if (C0476iM.f2925dm && (entity instanceof ServerPlayer)) {
            ServerPlayer serverPlayer4 = (ServerPlayer) entity;
            float newDamage2 = container.getNewDamage();
            if (newDamage2 > 0.0f && newDamage2 < serverPlayer4.getHealth() && (abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(serverPlayer4.getUUID())) != null && abstractC0183cM2528a.m1136a((Player) serverPlayer4).m1118a(serverPlayer4.level().getGameTime())) {
                C0185e.m1145a(serverPlayer4, abstractC0787oFMo2531a);
            }
        }
    }
}
