package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.of */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/of.class */
public final class C0813of {

    /* JADX INFO: renamed from: fF */
    static final /* synthetic */ boolean f4438fF;

    static {
        f4438fF = !C0813of.class.desiredAssertionStatus();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m4177a(@NotNull LivingIncomingDamageEvent livingIncomingDamageEvent) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4438fF && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        Entity entity = livingIncomingDamageEvent.getEntity();
        if (entity.level().isClientSide) {
            return;
        }
        DamageSource source = livingIncomingDamageEvent.getSource();
        Entity entity2 = source.getEntity();
        if (entity2 != null) {
            Entity vehicle = entity2.getVehicle();
            if (vehicle instanceof AbstractC0779ny) {
                C0732nD c0732nDM3535a = ((AbstractC0779ny) vehicle).m3535a(entity2);
                boolean z = true;
                if (c0732nDM3535a != null) {
                    if (!source.is(DamageTypeTags.IS_EXPLOSION) && (c0732nDM3535a.f3936fp || c0732nDM3535a.f3937fq)) {
                        z = false;
                    }
                    Iterator<AbstractC0742nN<?>> it = c0732nDM3535a.m3327b().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        AbstractC0742nN<?> next = it.next();
                        if ((next instanceof C0740nL) && ((C0740nL) next).m3391a() == EnumC0741nM.BULLET) {
                            z = true;
                            break;
                        }
                    }
                }
                if (!z) {
                    livingIncomingDamageEvent.setCanceled(true);
                    return;
                }
            }
        }
        if (entity2 != null) {
            Entity vehicle2 = entity.getVehicle();
            if (vehicle2 instanceof AbstractC0779ny) {
                AbstractC0779ny abstractC0779ny = (AbstractC0779ny) vehicle2;
                if (livingIncomingDamageEvent.getAmount() < Float.MAX_VALUE && abstractC0779ny.m3513k(entity)) {
                    livingIncomingDamageEvent.setCanceled(true);
                    return;
                }
            }
        }
        if (entity instanceof Player) {
            Player player = (Player) entity;
            UUID uuid = player.getUUID();
            AbstractC0182b abstractC0182bM1136a = abstractC0183cM2528a.m1136a(player);
            if (!source.is(DamageTypeTags.IS_EXPLOSION) && abstractC0182bM1136a.m1077b().m1072aL()) {
                livingIncomingDamageEvent.setCanceled(true);
                return;
            }
            if (abstractC0182bM1136a.m1087dk()) {
                livingIncomingDamageEvent.setCanceled(true);
                return;
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
            if (abstractC0787oFMo2531a != 0) {
                AbstractC0790oI abstractC0790oIM3582b = abstractC0787oFMo2531a.m3582b();
                if ((abstractC0787oFMo2531a instanceof InterfaceC0970rd) && C0799oR.m4009a(abstractC0787oFMo2531a, uuid, C1089tp.f5690g) > 0) {
                    livingIncomingDamageEvent.setCanceled(true);
                    return;
                }
                Player entity3 = source.getEntity();
                if (!abstractC0790oIM3582b.mo3832a(player, uuid, source, (Entity) entity3)) {
                    livingIncomingDamageEvent.setCanceled(true);
                    return;
                } else if (entity3 instanceof Player) {
                    Player player2 = entity3;
                    UUID uuid2 = player2.getUUID();
                    if ((abstractC0787oFMo2531a instanceof InterfaceC0970rd) && ((InterfaceC0970rd) abstractC0787oFMo2531a).mo5165j(uuid2)) {
                        C0799oR.m4011a(abstractC0787oFMo2531a, player2.getUUID(), C1089tp.f5690g, 0);
                    }
                }
            }
        }
        if (entity2 instanceof Player) {
            Player player3 = (Player) entity2;
            UUID uuid3 = player3.getUUID();
            AbstractC0182b abstractC0182bM1136a2 = abstractC0183cM2528a.m1136a(player3);
            if (abstractC0182bM1136a2.m1077b().m1072aL()) {
                livingIncomingDamageEvent.setCanceled(true);
                return;
            }
            if ((player3.tickCount <= 20 || abstractC0182bM1136a2.m1087dk() || player3.equals(livingIncomingDamageEvent.getEntity())) && !source.is(DamageTypeTags.IS_EXPLOSION) && !source.is(DamageTypeTags.IS_FIRE)) {
                livingIncomingDamageEvent.setCanceled(true);
                return;
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a2 = abstractC0563juM168a.mo2531a(uuid3);
            if (abstractC0787oFMo2531a2 != 0) {
                if (!abstractC0787oFMo2531a2.m3582b().mo3833a((LivingEntity) entity, source)) {
                    livingIncomingDamageEvent.setCanceled(true);
                    return;
                }
                if (entity instanceof C0680mE) {
                    C0680mE c0680mE = (C0680mE) entity;
                    if ((abstractC0787oFMo2531a2 instanceof InterfaceC0899qL) && !((InterfaceC0899qL) abstractC0787oFMo2531a2).mo4662a(c0680mE, source)) {
                        livingIncomingDamageEvent.setCanceled(true);
                        return;
                    }
                }
                if ((entity instanceof C0692mQ) && (abstractC0787oFMo2531a2 instanceof InterfaceC0910qW) && !((InterfaceC0910qW) abstractC0787oFMo2531a2).mo4693a(abstractC0563juM168a, (C0692mQ) entity, source, livingIncomingDamageEvent.getAmount())) {
                    livingIncomingDamageEvent.setCanceled(true);
                }
            }
        }
    }
}
