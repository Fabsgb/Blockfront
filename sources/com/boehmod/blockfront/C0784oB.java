package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import java.util.UUID;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oB.class */
public final class C0784oB {

    /* JADX INFO: renamed from: fZ */
    static final /* synthetic */ boolean f4329fZ;

    static {
        f4329fZ = !C0784oB.class.desiredAssertionStatus();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m3664a(@NotNull LivingIncomingDamageEvent livingIncomingDamageEvent) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4329fZ && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        Entity entity = livingIncomingDamageEvent.getEntity();
        if (entity.level().isClientSide) {
            return;
        }
        DamageSource source = livingIncomingDamageEvent.getSource();
        Entity entity2 = source.getEntity();
        if (entity2 != null) {
            Entity vehicle = entity2.getVehicle();
            if (vehicle instanceof AbstractC0750nU) {
                C0755nZ c0755nZM3472a = ((AbstractC0750nU) vehicle).m3472a(entity2);
                boolean z = true;
                if (c0755nZM3472a != null) {
                    if (!source.is(DamageTypeTags.IS_EXPLOSION) && (c0755nZM3472a.f4184fJ || c0755nZM3472a.f4185fK)) {
                        z = false;
                    }
                    for (AbstractC0818oj<?> abstractC0818oj : c0755nZM3472a.m3514c()) {
                        if ((abstractC0818oj instanceof C0816oh) && ((C0816oh) abstractC0818oj).m3763a() == EnumC0817oi.BULLET) {
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
            if (vehicle2 instanceof AbstractC0750nU) {
                AbstractC0750nU abstractC0750nU = (AbstractC0750nU) vehicle2;
                if (livingIncomingDamageEvent.getAmount() < Float.MAX_VALUE && abstractC0750nU.m3450k(entity)) {
                    livingIncomingDamageEvent.setCanceled(true);
                    return;
                }
            }
        }
        if (entity instanceof Player) {
            Player player = (Player) entity;
            UUID uuid = player.getUUID();
            AbstractC0183b abstractC0183bM1153a = abstractC0184cM2351a.m1153a(player);
            if (!source.is(DamageTypeTags.IS_EXPLOSION) && abstractC0183bM1153a.m1094b().m1089aV()) {
                livingIncomingDamageEvent.setCanceled(true);
                return;
            }
            if (abstractC0183bM1153a.m1104dt()) {
                livingIncomingDamageEvent.setCanceled(true);
                return;
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
            if (abstractC0863pbMo2354a != 0) {
                AbstractC0866pe abstractC0866peM4018b = abstractC0863pbMo2354a.m4018b();
                if ((abstractC0863pbMo2354a instanceof InterfaceC0942rA) && C0875pn.m4445a(abstractC0863pbMo2354a, uuid, C1062tN.f5743g) > 0) {
                    livingIncomingDamageEvent.setCanceled(true);
                    return;
                }
                Player entity3 = source.getEntity();
                if (!abstractC0866peM4018b.mo4268a(player, uuid, source, (Entity) entity3)) {
                    livingIncomingDamageEvent.setCanceled(true);
                    return;
                } else if (entity3 instanceof Player) {
                    Player player2 = entity3;
                    UUID uuid2 = player2.getUUID();
                    if ((abstractC0863pbMo2354a instanceof InterfaceC0942rA) && ((InterfaceC0942rA) abstractC0863pbMo2354a).mo5176j(uuid2)) {
                        C0875pn.m4447a(abstractC0863pbMo2354a, player2.getUUID(), C1062tN.f5743g, 0);
                    }
                }
            }
        }
        if (entity2 instanceof Player) {
            Player player3 = (Player) entity2;
            UUID uuid3 = player3.getUUID();
            AbstractC0183b abstractC0183bM1153a2 = abstractC0184cM2351a.m1153a(player3);
            if (abstractC0183bM1153a2.m1094b().m1089aV()) {
                livingIncomingDamageEvent.setCanceled(true);
                return;
            }
            if ((player3.tickCount <= 20 || abstractC0183bM1153a2.m1104dt() || player3.equals(livingIncomingDamageEvent.getEntity())) && !source.is(DamageTypeTags.IS_EXPLOSION) && !source.is(DamageTypeTags.IS_FIRE)) {
                livingIncomingDamageEvent.setCanceled(true);
                return;
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a2 = abstractC0531jNM179a.mo2354a(uuid3);
            if (abstractC0863pbMo2354a2 != 0) {
                if (!abstractC0863pbMo2354a2.m4018b().mo4269a((LivingEntity) entity, source)) {
                    livingIncomingDamageEvent.setCanceled(true);
                    return;
                }
                if (entity instanceof C0756na) {
                    C0756na c0756na = (C0756na) entity;
                    if ((abstractC0863pbMo2354a2 instanceof InterfaceC0976ri) && !((InterfaceC0976ri) abstractC0863pbMo2354a2).mo5338a(c0756na, source)) {
                        livingIncomingDamageEvent.setCanceled(true);
                        return;
                    }
                }
                if ((entity instanceof C0768nm) && (abstractC0863pbMo2354a2 instanceof InterfaceC0987rt) && !((InterfaceC0987rt) abstractC0863pbMo2354a2).mo5564a(abstractC0531jNM179a, (C0768nm) entity, source, livingIncomingDamageEvent.getAmount())) {
                    livingIncomingDamageEvent.setCanceled(true);
                }
            }
        }
    }
}
