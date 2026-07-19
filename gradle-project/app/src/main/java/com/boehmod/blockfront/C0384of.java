package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.UUID;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.of, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/of.class */
public final class C0384of {
    static final /* synthetic */ boolean fF;

    static {
        fF = !C0384of.class.desiredAssertionStatus();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(@NotNull LivingIncomingDamageEvent livingIncomingDamageEvent) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fF && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
        Entity entity = livingIncomingDamageEvent.getEntity();
        if (entity.level().isClientSide) {
            return;
        }
        DamageSource source = livingIncomingDamageEvent.getSource();
        Entity entity2 = source.getEntity();
        if (entity2 != null) {
            Entity vehicle = entity2.getVehicle();
            if (vehicle instanceof AbstractC0376ny) {
                nD nDVarA = ((AbstractC0376ny) vehicle).a(entity2);
                boolean z = true;
                if (nDVarA != null) {
                    if (!source.is(DamageTypeTags.IS_EXPLOSION) && (nDVarA.fp || nDVarA.fq)) {
                        z = false;
                    }
                    Iterator<nN<?>> it = nDVarA.m715b().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        nN<?> next = it.next();
                        if ((next instanceof nL) && ((nL) next).m724a() == nM.BULLET) {
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
            if (vehicle2 instanceof AbstractC0376ny) {
                AbstractC0376ny abstractC0376ny = (AbstractC0376ny) vehicle2;
                if (livingIncomingDamageEvent.getAmount() < Float.MAX_VALUE && abstractC0376ny.k(entity)) {
                    livingIncomingDamageEvent.setCanceled(true);
                    return;
                }
            }
        }
        if (entity instanceof Player) {
            Player player = (Player) entity;
            UUID uuid = player.getUUID();
            com.boehmod.blockfront.common.player.b bVarM305a = cVarM531a.m305a(player);
            if (!source.is(DamageTypeTags.IS_EXPLOSION) && bVarM305a.b().aL()) {
                livingIncomingDamageEvent.setCanceled(true);
                return;
            }
            if (bVarM305a.dk()) {
                livingIncomingDamageEvent.setCanceled(true);
                return;
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
            if (oFVarMo604a != 0) {
                oI oIVarB = oFVarMo604a.b();
                if ((oFVarMo604a instanceof InterfaceC0463rd) && oR.a(oFVarMo604a, uuid, C0529tp.g) > 0) {
                    livingIncomingDamageEvent.setCanceled(true);
                    return;
                }
                Player entity3 = source.getEntity();
                if (!oIVarB.a(player, uuid, source, (Entity) entity3)) {
                    livingIncomingDamageEvent.setCanceled(true);
                    return;
                } else if (entity3 instanceof Player) {
                    Player player2 = entity3;
                    UUID uuid2 = player2.getUUID();
                    if ((oFVarMo604a instanceof InterfaceC0463rd) && ((InterfaceC0463rd) oFVarMo604a).j(uuid2)) {
                        oR.m792a(oFVarMo604a, player2.getUUID(), C0529tp.g, 0);
                    }
                }
            }
        }
        if (entity2 instanceof Player) {
            Player player3 = (Player) entity2;
            UUID uuid3 = player3.getUUID();
            com.boehmod.blockfront.common.player.b bVarM305a2 = cVarM531a.m305a(player3);
            if (bVarM305a2.b().aL()) {
                livingIncomingDamageEvent.setCanceled(true);
                return;
            }
            if ((player3.tickCount <= 20 || bVarM305a2.dk() || player3.equals(livingIncomingDamageEvent.getEntity())) && !source.is(DamageTypeTags.IS_EXPLOSION) && !source.is(DamageTypeTags.IS_FIRE)) {
                livingIncomingDamageEvent.setCanceled(true);
                return;
            }
            oF<?, ?, ?> oFVarMo604a2 = abstractC0264juM166a.mo604a(uuid3);
            if (oFVarMo604a2 != 0) {
                if (!oFVarMo604a2.b().a((LivingEntity) entity, source)) {
                    livingIncomingDamageEvent.setCanceled(true);
                    return;
                }
                if (entity instanceof mE) {
                    mE mEVar = (mE) entity;
                    if ((oFVarMo604a2 instanceof qL) && !((qL) oFVarMo604a2).a(mEVar, source)) {
                        livingIncomingDamageEvent.setCanceled(true);
                        return;
                    }
                }
                if ((entity instanceof mQ) && (oFVarMo604a2 instanceof qW) && !((qW) oFVarMo604a2).a(abstractC0264juM166a, (mQ) entity, source, livingIncomingDamageEvent.getAmount())) {
                    livingIncomingDamageEvent.setCanceled(true);
                }
            }
        }
    }
}
