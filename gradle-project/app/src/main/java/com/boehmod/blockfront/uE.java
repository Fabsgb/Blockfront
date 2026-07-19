package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.c;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uE.class */
public class uE<H extends com.boehmod.blockfront.common.player.c<?>> extends uA<ServerLevel, LivingEntity, H, AbstractC0264ju<H, ?, ?>> {

    @Nullable
    private ServerLevel b;

    @Override // com.boehmod.blockfront.uA
    public /* bridge */ /* synthetic */ void a(@NotNull AbstractC0264ju abstractC0264ju, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list) {
        a(abstractC0264ju, (ServerLevel) level, livingEntity, (List<C0555uo>) list);
    }

    @Override // com.boehmod.blockfront.uA
    public /* bridge */ /* synthetic */ void a(@NotNull AbstractC0264ju abstractC0264ju, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        a(abstractC0264ju, (ServerLevel) level, livingEntity, (List<C0556up>) list, randomSource, random, j, j2, i);
    }

    public uE(@NotNull H h, @NotNull uI uIVar) {
        super(h, uIVar);
    }

    public static void a(@NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @Nullable oF<?, ?, ?> oFVar, @NotNull List<C0555uo> list) {
        C0603wi c0603wi = new C0603wi(livingEntity.getId(), list);
        if (oFVar != null) {
            C0582vo.a(c0603wi, oFVar);
        } else {
            C0582vo.b(c0603wi);
        }
        Iterator<C0555uo> it = list.iterator();
        while (it.hasNext()) {
            C0404oz.a((Level) serverLevel, it.next(), livingEntity);
        }
    }

    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull LivingEntity livingEntity, @Nullable oF<?, ?, ?> oFVar, @NotNull List<C0556up> list) {
        nD nDVarA;
        C0605wk c0605wk = new C0605wk(livingEntity.getId(), list);
        ItemStack itemInHand = livingEntity.getItemInHand(InteractionHand.MAIN_HAND);
        Entity vehicle = livingEntity.getVehicle();
        if ((vehicle instanceof AbstractC0376ny) && (nDVarA = ((AbstractC0376ny) vehicle).a((Entity) livingEntity)) != null) {
            for (nN<?> nNVar : nDVarA.m715b()) {
                if (nNVar instanceof nL) {
                    nL nLVar = (nL) nNVar;
                    if (nLVar.m724a() == nM.BULLET) {
                        itemInHand = new ItemStack(nLVar.c());
                    }
                }
            }
        }
        if (oFVar != null) {
            C0582vo.a(c0605wk, oFVar);
        } else {
            C0582vo.b(c0605wk);
        }
        Iterator<C0556up> it = list.iterator();
        while (it.hasNext() && !a(abstractC0264ju, cVar, level, livingEntity, it.next(), itemInHand)) {
        }
    }

    private static boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull C0556up c0556up, @NotNull ItemStack itemStack) {
        LivingEntity entity = level.getEntity(c0556up.al());
        if (entity == null || !entity.isAlive()) {
            return true;
        }
        if (entity instanceof LivingEntity) {
            C0404oz.a(abstractC0264ju, cVar, level, livingEntity, itemStack, entity, c0556up);
            return false;
        }
        if (entity instanceof mA) {
            ((mA) entity).c(livingEntity);
            return false;
        }
        return false;
    }

    @Override // com.boehmod.blockfront.uA
    public void a(@NotNull LivingEntity livingEntity, @NotNull C0558ur c0558ur, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        if (livingEntity instanceof InterfaceC0346mv) {
            InterfaceC0346mv interfaceC0346mv = (InterfaceC0346mv) livingEntity;
            if (randomSource.nextFloat() >= c0558ur.bw()) {
                return;
            }
            oF<?, ?, ?> oFVarA = interfaceC0346mv.a();
            C0607wm c0607wm = new C0607wm(livingEntity.getId(), new C0166gc((Holder<Item>) c0558ur.builtInRegistryHolder(), vec3, vec32, c0558ur.ca()));
            if (oFVarA != null) {
                C0582vo.a(c0607wm, oFVarA);
            } else {
                C0582vo.b(c0607wm);
            }
            a(new U(vec3.add(0.0d, 0.10000000149011612d, 0.0d), vec32.add(0.0d, 0.10000000149011612d, 0.0d), 200, true, -838669));
        }
    }

    public void a(@NotNull AbstractC0264ju<H, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @NotNull List<C0556up> list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        if (livingEntity instanceof InterfaceC0346mv) {
            a((AbstractC0264ju<?, ?, ?>) abstractC0264ju, (com.boehmod.blockfront.common.player.c<?>) this.f304e, (Level) serverLevel, livingEntity, ((InterfaceC0346mv) livingEntity).a(), list);
        }
    }

    public void a(@NotNull AbstractC0264ju<H, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @NotNull List<C0555uo> list) {
        if (livingEntity instanceof InterfaceC0346mv) {
            a(serverLevel, livingEntity, ((InterfaceC0346mv) livingEntity).a(), list);
        }
    }

    @Override // com.boehmod.blockfront.uA
    public Vec3 a(@NotNull LivingEntity livingEntity, @NotNull RandomSource randomSource, @NotNull uS uSVar, int i, long j) {
        float fBm = 0.0f;
        Item item = livingEntity.getItemInHand(InteractionHand.MAIN_HAND).getItem();
        if (item instanceof C0558ur) {
            fBm = ((C0558ur) item).a().bm();
        }
        Vec2 vec2 = new Vec2(livingEntity.getXRot(), livingEntity.getYRot());
        uV uVVarM1178a = uSVar.m1178a();
        if (uVVarM1178a != null) {
            return a(vec2, uVVarM1178a, i, j, fBm, 0.0f);
        }
        return a(vec2, randomSource, fBm, 0.0f);
    }

    @Override // com.boehmod.blockfront.uA
    @NotNull
    public Vec3 a(@NotNull LivingEntity livingEntity, @NotNull C0558ur c0558ur) {
        return c0558ur.A().zRot(((livingEntity.getXRot() + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-livingEntity.getYRot()) * 0.017453292f) - 1.5707964f);
    }

    @Override // com.boehmod.blockfront.uA
    public void a(@NotNull U u) {
    }

    @Override // com.boehmod.blockfront.uA
    public void a(@NotNull T t) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.uA
    @NotNull
    public InterfaceC0625xd a(@NotNull AbstractC0264ju<H, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel) {
        if (this.b == null) {
            throw new IllegalStateException("No level set for ServerBulletSpawner - call spawnBullet first");
        }
        return new C0627xf(this.b, (int) serverLevel.getGameTime());
    }

    @Override // com.boehmod.blockfront.uA
    public void a(@NotNull AbstractC0264ju<H, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull LivingEntity livingEntity, @NotNull C0558ur c0558ur, long j, long j2, int i) {
        this.b = serverLevel;
        try {
            super.a(abstractC0264ju, serverLevel, randomSource, random, livingEntity, c0558ur, j, j2, i);
            this.b = null;
        } catch (Throwable th) {
            this.b = null;
            throw th;
        }
    }
}
