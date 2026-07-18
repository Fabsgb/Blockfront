package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.uE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uE.class */
public class C1105uE<H extends AbstractC0183c<?>> extends AbstractC1101uA<ServerLevel, LivingEntity, H, AbstractC0563ju<H, ?, ?>> {

    /* JADX INFO: renamed from: b */
    @Nullable
    private ServerLevel f5803b;

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo6067a(@NotNull AbstractC0563ju abstractC0563ju, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list) {
        m6101a(abstractC0563ju, (ServerLevel) level, livingEntity, (List<C1141uo>) list);
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo6066a(@NotNull AbstractC0563ju abstractC0563ju, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull List list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        m6100a(abstractC0563ju, (ServerLevel) level, livingEntity, (List<C1142up>) list, randomSource, random, j, j2, i);
    }

    public C1105uE(@NotNull H h, @NotNull C1109uI c1109uI) {
        super(h, c1109uI);
    }

    /* JADX INFO: renamed from: a */
    public static void m6097a(@NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull List<C1141uo> list) {
        C1241wi c1241wi = new C1241wi(livingEntity.getId(), list);
        if (abstractC0787oF != null) {
            C1194vo.m6651a(c1241wi, abstractC0787oF);
        } else {
            C1194vo.m6649b(c1241wi);
        }
        Iterator<C1141uo> it = list.iterator();
        while (it.hasNext()) {
            C0833oz.m4204a((Level) serverLevel, it.next(), livingEntity);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m6098a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull LivingEntity livingEntity, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull List<C1142up> list) {
        C0732nD c0732nDM3535a;
        C1243wk c1243wk = new C1243wk(livingEntity.getId(), list);
        ItemStack itemInHand = livingEntity.getItemInHand(InteractionHand.MAIN_HAND);
        Entity vehicle = livingEntity.getVehicle();
        if ((vehicle instanceof AbstractC0779ny) && (c0732nDM3535a = ((AbstractC0779ny) vehicle).m3535a((Entity) livingEntity)) != null) {
            for (AbstractC0742nN<?> abstractC0742nN : c0732nDM3535a.m3327b()) {
                if (abstractC0742nN instanceof C0740nL) {
                    C0740nL c0740nL = (C0740nL) abstractC0742nN;
                    if (c0740nL.m3391a() == EnumC0741nM.BULLET) {
                        itemInHand = new ItemStack(c0740nL.m3392c());
                    }
                }
            }
        }
        if (abstractC0787oF != null) {
            C1194vo.m6651a(c1243wk, abstractC0787oF);
        } else {
            C1194vo.m6649b(c1243wk);
        }
        Iterator<C1142up> it = list.iterator();
        while (it.hasNext() && !m6099a(abstractC0563ju, abstractC0183c, level, livingEntity, it.next(), itemInHand)) {
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m6099a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull C1142up c1142up, @NotNull ItemStack itemStack) {
        LivingEntity entity = level.getEntity(c1142up.m6284al());
        if (entity == null || !entity.isAlive()) {
            return true;
        }
        if (entity instanceof LivingEntity) {
            C0833oz.m4202a(abstractC0563ju, abstractC0183c, level, livingEntity, itemStack, entity, c1142up);
            return false;
        }
        if (entity instanceof AbstractC0676mA) {
            ((AbstractC0676mA) entity).m2979c(livingEntity);
            return false;
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public void mo6065a(@NotNull LivingEntity livingEntity, @NotNull C1144ur c1144ur, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        if (livingEntity instanceof InterfaceC0723mv) {
            InterfaceC0723mv interfaceC0723mv = (InterfaceC0723mv) livingEntity;
            if (randomSource.nextFloat() >= c1144ur.m6400bw()) {
                return;
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo3281a = interfaceC0723mv.mo3281a();
            C1245wm c1245wm = new C1245wm(livingEntity.getId(), new C0386gc((Holder<Item>) c1144ur.builtInRegistryHolder(), vec3, vec32, c1144ur.m6399ca()));
            if (abstractC0787oFMo3281a != null) {
                C1194vo.m6651a(c1245wm, abstractC0787oFMo3281a);
            } else {
                C1194vo.m6649b(c1245wm);
            }
            mo6083a(new C0023U(vec3.add(0.0d, 0.10000000149011612d, 0.0d), vec32.add(0.0d, 0.10000000149011612d, 0.0d), 200, true, -838669));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6100a(@NotNull AbstractC0563ju<H, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @NotNull List<C1142up> list, @NotNull RandomSource randomSource, @NotNull Random random, long j, long j2, int i) {
        if (livingEntity instanceof InterfaceC0723mv) {
            m6098a((AbstractC0563ju<?, ?, ?>) abstractC0563ju, (AbstractC0183c<?>) this.f5795e, (Level) serverLevel, livingEntity, ((InterfaceC0723mv) livingEntity).mo3281a(), list);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6101a(@NotNull AbstractC0563ju<H, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, @NotNull List<C1141uo> list) {
        if (livingEntity instanceof InterfaceC0723mv) {
            m6097a(serverLevel, livingEntity, ((InterfaceC0723mv) livingEntity).mo3281a(), list);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public Vec3 mo6068a(@NotNull LivingEntity livingEntity, @NotNull RandomSource randomSource, @NotNull C1119uS c1119uS, int i, long j) {
        float fM5841bm = 0.0f;
        Item item = livingEntity.getItemInHand(InteractionHand.MAIN_HAND).getItem();
        if (item instanceof C1144ur) {
            fM5841bm = ((C1144ur) item).m6327a().m5841bm();
        }
        Vec2 vec2 = new Vec2(livingEntity.getXRot(), livingEntity.getYRot());
        C1122uV c1122uVM6226a = c1119uS.m6226a();
        if (c1122uVM6226a != null) {
            return m6069a(vec2, c1122uVM6226a, i, j, fM5841bm, 0.0f);
        }
        return m6070a(vec2, randomSource, fM5841bm, 0.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec3 mo6064a(@NotNull LivingEntity livingEntity, @NotNull C1144ur c1144ur) {
        return c1144ur.m6321A().zRot(((livingEntity.getXRot() + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-livingEntity.getYRot()) * 0.017453292f) - 1.5707964f);
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public void mo6083a(@NotNull C0023U c0023u) {
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a */
    public void mo6084a(@NotNull C0022T c0022t) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC1101uA
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceC1281xd mo6085a(@NotNull AbstractC0563ju<H, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel) {
        if (this.f5803b == null) {
            throw new IllegalStateException("No level set for ServerBulletSpawner - call spawnBullet first");
        }
        return new C1283xf(this.f5803b, (int) serverLevel.getGameTime());
    }

    @Override // com.boehmod.blockfront.AbstractC1101uA
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo6062a(@NotNull AbstractC0563ju<H, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull LivingEntity livingEntity, @NotNull C1144ur c1144ur, long j, long j2, int i) {
        this.f5803b = serverLevel;
        try {
            super.mo6062a(abstractC0563ju, serverLevel, randomSource, random, livingEntity, c1144ur, j, j2, i);
            this.f5803b = null;
        } catch (Throwable th) {
            this.f5803b = null;
            throw th;
        }
    }
}
