package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.oh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oh.class */
public final class C0386oh {
    static final /* synthetic */ boolean fH;

    static {
        fH = !C0386oh.class.desiredAssertionStatus();
    }

    public static void a(@NotNull LivingDamageEvent.Pre pre) {
        oF<?, ?, ?> oFVarMo604a;
        oO oOVarM671a;
        oO oOVarA;
        Entity entity = pre.getEntity();
        DamageContainer container = pre.getContainer();
        DamageSource source = container.getSource();
        mE entity2 = source.getEntity();
        float originalDamage = container.getOriginalDamage();
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fH && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
        if (entity2 != null) {
            Entity vehicle = entity.getVehicle();
            if (vehicle instanceof AbstractC0376ny) {
                AbstractC0376ny abstractC0376ny = (AbstractC0376ny) vehicle;
                if (originalDamage < Float.MAX_VALUE && abstractC0376ny.k(entity)) {
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
                C0582vo.a(new C0578vk(sourcePosition, Math.min(1.0f, originalDamage / 5.0f)), serverPlayer);
            }
            if (source instanceof lZ) {
                C0582vo.a(new C0606wl(entity2 instanceof mE), serverPlayer);
            }
        }
        if (entity2 instanceof mE) {
            oO oOVarM671a2 = entity2.m671a();
            if (entity instanceof Player) {
                Player player = (Player) entity;
                oF<?, ?, ?> oFVarMo604a2 = abstractC0264juM166a.mo604a(player.getUUID());
                if (oFVarMo604a2 != null && (oOVarA = oFVarMo604a2.b().a(player.getUUID())) != null && oOVarA.equals(oOVarM671a2)) {
                    container.setNewDamage(0.0f);
                    return;
                }
            } else if ((entity instanceof mE) && (oOVarM671a = ((mE) entity).m671a()) != null && oOVarM671a.equals(oOVarM671a2)) {
                container.setNewDamage(0.0f);
                return;
            }
        }
        if (entity2 instanceof Player) {
            ServerPlayer serverPlayer2 = (Player) entity2;
            UUID uuid = serverPlayer2.getUUID();
            oF<?, ?, ?> oFVarMo604a3 = abstractC0264juM166a.mo604a(uuid);
            if (oFVarMo604a3 != null && (source instanceof lZ)) {
                container.setNewDamage(originalDamage * oFVarMo604a3.aF());
            }
            float newDamage = container.getNewDamage();
            if (entity instanceof Player) {
                Player player2 = (Player) entity;
                if (newDamage > 0.0f) {
                    cVarM531a.m305a(player2).a(uuid, newDamage);
                }
            }
            if (newDamage > 0.0f) {
                C0404oz.a(entity.level(), entity.position(), 1.5f);
            }
            if (serverPlayer2 instanceof ServerPlayer) {
                ServerPlayer serverPlayer3 = serverPlayer2;
                if (cVarM531a.m305a((Player) serverPlayer2).a(entity.getId(), entity.level().getGameTime())) {
                    C0582vo.a(new vA(false), serverPlayer3);
                }
            }
        }
        if (iM.dm && (entity instanceof ServerPlayer)) {
            ServerPlayer serverPlayer4 = (ServerPlayer) entity;
            float newDamage2 = container.getNewDamage();
            if (newDamage2 > 0.0f && newDamage2 < serverPlayer4.getHealth() && (oFVarMo604a = abstractC0264juM166a.mo604a(serverPlayer4.getUUID())) != null && cVarM531a.m305a((Player) serverPlayer4).a(serverPlayer4.level().getGameTime())) {
                com.boehmod.blockfront.common.player.e.a(serverPlayer4, oFVarMo604a);
            }
        }
    }
}
