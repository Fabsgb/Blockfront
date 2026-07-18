package com.boehmod.blockfront;

import com.boehmod.blockfront.C0171cj;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import it.unimi.dsi.fastutil.floats.FloatFloatPair;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.util.Iterator;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oz.class */
public final class C0833oz {

    /* JADX INFO: renamed from: mn */
    private static final int f4457mn = 3;

    /* JADX INFO: renamed from: aA */
    private static final double f4458aA = 0.25d;

    /* JADX INFO: renamed from: kg */
    private static final float f4459kg = 4.0f;

    /* JADX INFO: renamed from: a */
    public static void m4202a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull LivingEntity livingEntity, @Nullable ItemStack itemStack, @NotNull LivingEntity livingEntity2, @NotNull C1142up c1142up) {
        if (itemStack != null) {
            Item item = itemStack.getItem();
            if (item instanceof C1144ur) {
                C1144ur c1144ur = (C1144ur) item;
                if (C0799oR.m4051a(abstractC0563ju, abstractC0183c, livingEntity, livingEntity2)) {
                    float fM6285bu = c1142up.m6285bu();
                    C0648lZ c0648lZ = new C0648lZ(level, livingEntity, itemStack, c1142up.m6286co(), fM6285bu > 0.0f, c1142up.m6287cp(), c1142up.m6288cq());
                    FloatFloatPair floatFloatPairM6115c = c1144ur.m6394a().m6115c(livingEntity.distanceTo(livingEntity2));
                    float fRightFloat = (c0648lZ.m2907ap() ? floatFloatPairM6115c.rightFloat() : floatFloatPairM6115c.leftFloat()) - fM6285bu;
                    if (livingEntity instanceof C0680mE) {
                        fRightFloat /= 5.0f;
                    }
                    if (fRightFloat <= 0.0f) {
                        return;
                    }
                    if (livingEntity2 instanceof Player) {
                        Player player = (Player) livingEntity2;
                        UUID uuid = player.getUUID();
                        if (abstractC0183c.m1136a(player).m1087dk() || player.getHealth() <= 0.0f || !player.isAlive()) {
                            return;
                        }
                        Object objMo2531a = abstractC0563ju.mo2531a(uuid);
                        if (objMo2531a instanceof InterfaceC0904qQ) {
                            fRightFloat *= ((InterfaceC0904qQ) objMo2531a).mo4677aS();
                        }
                    }
                    if (fRightFloat > 0.0f) {
                        livingEntity2.hurtTime = 0;
                        livingEntity2.invulnerableTime = 0;
                        if (livingEntity2.hurt(c0648lZ, fRightFloat)) {
                            livingEntity2.setDeltaMovement(0.0d, 0.0d, 0.0d);
                            if (c1142up.m6289cr()) {
                                m4203a(abstractC0183c, level, livingEntity, itemStack, livingEntity2);
                            }
                            m4205a(level, livingEntity2.getBoundingBox().inflate(4.0d), C1228wV.f6973Q.get());
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m4203a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull ItemStack itemStack, @NotNull LivingEntity livingEntity2) {
        C1146ut item = livingEntity2.getItemBySlot(EquipmentSlot.CHEST).getItem();
        if ((item instanceof C1146ut) && item.m6429cD() && (livingEntity2 instanceof ServerPlayer)) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity2;
            AbstractC0182b abstractC0182bM1136a = abstractC0183c.m1136a((Player) serverPlayer);
            if (livingEntity2.getHealth() <= 0.0f) {
                abstractC0182bM1136a.m1077b().m1070b(level, serverPlayer);
            } else {
                abstractC0182bM1136a.m1077b().m1067a(serverPlayer, livingEntity, itemStack);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4204a(@NotNull Level level, @NotNull C1141uo c1141uo, @Nullable LivingEntity livingEntity) {
        BlockPos blockPosM6279a = c1141uo.m6279a();
        BlockState blockState = level.getBlockState(blockPosM6279a);
        C1151uy c1151uyM6440a = C1215wI.m6740a(level, blockState, blockPosM6279a).m6440a();
        if (c1151uyM6440a != null) {
            Vec3 vec3M6281z = c1141uo.m6281z();
            switch ((int) SwitchBootstraps.enumSwitch(MethodHandles.lookup(), "enumSwitch", MethodType.methodType(Integer.TYPE, C0171cj.b.a.class, Integer.TYPE), "BLOOD", "DIRT").dynamicInvoker().invoke(c1151uyM6440a.m6462a(), 0) /* invoke-custom */) {
                case 0:
                    m4206a(level, vec3M6281z, 4.0f);
                    break;
                case 1:
                    m4207b(level, vec3M6281z, 4.0f);
                    break;
            }
        }
        if (level instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel) level;
            InterfaceC0574kE block = blockState.getBlock();
            if (block instanceof InterfaceC0574kE) {
                block.mo2603a(serverLevel, blockPosM6279a, blockState, livingEntity);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m4205a(@NotNull Level level, @NotNull AABB aabb, @NotNull DataComponentType<Integer> dataComponentType) {
        Iterator it = level.getEntitiesOfClass(LivingEntity.class, aabb).iterator();
        while (it.hasNext()) {
            ItemStack mainHandItem = ((LivingEntity) it.next()).getMainHandItem();
            if (mainHandItem.getItem() instanceof AbstractC1062tO) {
                int iIntValue = ((Integer) mainHandItem.getOrDefault(dataComponentType, 0)).intValue();
                if (level.random.nextDouble() < 0.25d / ((double) (iIntValue + 1))) {
                    mainHandItem.set(dataComponentType, Integer.valueOf(Math.min(iIntValue + 1, 3)));
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4206a(@NotNull Level level, @NotNull Vec3 vec3, float f) {
        C0782oA.m3548a(level, vec3, f, C1228wV.f6973Q.get(), 0.25d);
    }

    /* JADX INFO: renamed from: b */
    public static void m4207b(@NotNull Level level, @NotNull Vec3 vec3, float f) {
        C0782oA.m3548a(level, vec3, f, C1228wV.f6974R.get(), 0.25d);
    }
}
