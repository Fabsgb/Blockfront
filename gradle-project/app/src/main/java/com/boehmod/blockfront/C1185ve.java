package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ve */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ve.class */
public class C1185ve<H extends AbstractC0184c<?>> extends AbstractC1181va<ServerLevel, LivingEntity, H, AbstractC0531jN<H, ?, ?>> {

    /* JADX INFO: renamed from: c */
    @Nullable
    private ServerLevel f6442c;

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo6718a(@NotNull AbstractC0531jN abstractC0531jN, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list) {
        m6754a(abstractC0531jN, (ServerLevel) level, livingEntity, (List<C1114uM>) list);
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo6717a(@NotNull AbstractC0531jN abstractC0531jN, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        m6753a(abstractC0531jN, (ServerLevel) level, livingEntity, (List<C1115uN>) list, randomSource, random, j, j2, i);
    }

    public C1185ve(@NotNull H h, @NotNull C1189vi c1189vi) {
        super(h, c1189vi);
    }

    /* JADX INFO: renamed from: a */
    public static void m6749a(@NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull List<C1114uM> list) {
        C1214wG c1214wG = new C1214wG(livingEntity.getId(), list);
        if (abstractC0863pb != null) {
            C1169vO.m6646a(c1214wG, abstractC0863pb);
        } else {
            C1169vO.m6644b(c1214wG);
        }
        Iterator<C1114uM> it = list.iterator();
        while (it.hasNext()) {
            C0804oV.m3692a((Level) serverLevel, it.next(), livingEntity);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m6750a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull List<C1120uS> list) {
        for (C1120uS c1120uS : list) {
            if (!c1120uS.m6412aI().isEmpty()) {
                m6749a(serverLevel, livingEntity, abstractC0863pb, c1120uS.m6412aI());
            }
            if (!c1120uS.m6411aH().isEmpty()) {
                m6751a(abstractC0531jN, abstractC0184c, (Level) serverLevel, livingEntity, abstractC0863pb, c1120uS.m6411aH());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m6751a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull LivingEntity livingEntity, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull List<C1115uN> list) {
        C0755nZ c0755nZM3472a;
        ItemStack itemInHand = livingEntity.getItemInHand(InteractionHand.MAIN_HAND);
        Entity vehicle = livingEntity.getVehicle();
        if ((vehicle instanceof AbstractC0750nU) && (c0755nZM3472a = ((AbstractC0750nU) vehicle).m3472a((Entity) livingEntity)) != null) {
            for (AbstractC0818oj<?> abstractC0818oj : c0755nZM3472a.m3514c()) {
                if (abstractC0818oj instanceof C0816oh) {
                    C0816oh c0816oh = (C0816oh) abstractC0818oj;
                    if (c0816oh.m3763a() == EnumC0817oi.BULLET) {
                        itemInHand = new ItemStack(c0816oh.m3764c());
                    }
                }
            }
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(list.size());
        for (C1115uN c1115uN : list) {
            Entity entity = level.getEntity(c1115uN.m6248aB());
            if (entity != null && entity.isAlive()) {
                objectArrayList.add(c1115uN);
            }
        }
        if (objectArrayList.isEmpty()) {
            return;
        }
        C1215wH c1215wH = new C1215wH(livingEntity.getId(), objectArrayList);
        if (abstractC0863pb != null) {
            C1169vO.m6646a(c1215wH, abstractC0863pb);
        } else {
            C1169vO.m6644b(c1215wH);
        }
        Iterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            m6752a(abstractC0531jN, abstractC0184c, level, livingEntity, (C1115uN) it.next(), itemInHand);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m6752a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull C1115uN c1115uN, @NotNull ItemStack itemStack) {
        LivingEntity entity = level.getEntity(c1115uN.m6248aB());
        if (entity == null || !entity.isAlive()) {
            return;
        }
        if (entity instanceof LivingEntity) {
            C0804oV.m3690a(abstractC0531jN, abstractC0184c, level, livingEntity, itemStack, entity, c1115uN);
        } else if (entity instanceof AbstractC0699mW) {
            ((AbstractC0699mW) entity).m3130c(livingEntity);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public void mo6716a(@NotNull LivingEntity livingEntity, @NotNull C1117uP c1117uP, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull Vec3 vec4) {
        if (livingEntity instanceof InterfaceC0694mR) {
            InterfaceC0694mR interfaceC0694mR = (InterfaceC0694mR) livingEntity;
            if (randomSource.nextFloat() >= c1117uP.m6375bC()) {
                return;
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo3116a = interfaceC0694mR.mo3116a();
            C1217wJ c1217wJ = new C1217wJ(livingEntity.getId(), new C0403gs((Holder<Item>) c1117uP.builtInRegistryHolder(), vec3, vec4, c1117uP.m6374cp()));
            if (abstractC0863pbMo3116a != null) {
                C1169vO.m6646a(c1217wJ, abstractC0863pbMo3116a);
            } else {
                C1169vO.m6644b(c1217wJ);
            }
            mo6735a(new C0057aa(vec3.add(0.0d, 0.10000000149011612d, 0.0d), vec4.add(0.0d, 0.10000000149011612d, 0.0d), 200, true, -838669));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6753a(@NotNull AbstractC0531jN<H, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @NotNull List<C1115uN> list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        if (livingEntity instanceof InterfaceC0694mR) {
            m6751a((AbstractC0531jN<?, ?, ?>) abstractC0531jN, (AbstractC0184c<?>) this.f6436e, (Level) serverLevel, livingEntity, ((InterfaceC0694mR) livingEntity).mo3116a(), list);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6754a(@NotNull AbstractC0531jN<H, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @NotNull List<C1114uM> list) {
        if (livingEntity instanceof InterfaceC0694mR) {
            m6749a(serverLevel, livingEntity, ((InterfaceC0694mR) livingEntity).mo3116a(), list);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public Vec3 mo6719a(@NotNull LivingEntity livingEntity, @NotNull RandomSource randomSource, @NotNull C1199vs c1199vs, int i, long j) {
        float fM6477bs = 0.0f;
        Item item = livingEntity.getItemInHand(InteractionHand.MAIN_HAND).getItem();
        if (item instanceof C1117uP) {
            fM6477bs = ((C1117uP) item).m6294a().m6477bs();
        }
        Vec2 vec2 = new Vec2(livingEntity.getXRot(), livingEntity.getYRot());
        C1202vv c1202vvM6879a = c1199vs.m6879a();
        if (c1202vvM6879a != null) {
            return m6720a(vec2, c1202vvM6879a, i, j, fM6477bs, 0.0f);
        }
        return m6721a(vec2, randomSource, fM6477bs, 0.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec3 mo6715a(@NotNull LivingEntity livingEntity, @NotNull C1117uP c1117uP) {
        return c1117uP.m6287B().zRot(((livingEntity.getXRot() + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-livingEntity.getYRot()) * 0.017453292f) - 1.5707964f);
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public void mo6735a(@NotNull C0057aa c0057aa) {
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a */
    public void mo6736a(@NotNull C0029Z c0029z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC1181va
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceC1261xA mo6737a(@NotNull AbstractC0531jN<H, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel) {
        if (this.f6442c == null) {
            throw new IllegalStateException("No level set for ServerBulletSpawner - call spawnBullet first");
        }
        return new C1263xC(this.f6442c, (int) serverLevel.getGameTime());
    }

    @Override // com.boehmod.blockfront.AbstractC1181va
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo6713a(@NotNull AbstractC0531jN<H, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull LivingEntity livingEntity, @NotNull C1117uP c1117uP, @NotNull C1199vs c1199vs, long j, long j2, int i) {
        this.f6442c = serverLevel;
        try {
            super.mo6713a(abstractC0531jN, serverLevel, randomSource, random, livingEntity, c1117uP, c1199vs, j, j2, i);
        } finally {
            this.f6442c = null;
        }
    }
}
