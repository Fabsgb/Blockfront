package com.boehmod.blockfront;

import com.boehmod.blockfront.C0066cj;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.oz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oz.class */
public final class C0404oz {
    private static final int mn = 3;
    private static final double aA = 0.25d;
    private static final float kg = 4.0f;

    public static void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull LivingEntity livingEntity, @Nullable ItemStack itemStack, @NotNull LivingEntity livingEntity2, @NotNull C0556up c0556up) {
        if (itemStack != null) {
            Item item = itemStack.getItem();
            if (item instanceof C0558ur) {
                C0558ur c0558ur = (C0558ur) item;
                if (oR.a(abstractC0264ju, cVar, livingEntity, livingEntity2)) {
                    float fBu = c0556up.bu();
                    lZ lZVar = new lZ(level, livingEntity, itemStack, c0556up.co(), fBu > 0.0f, c0556up.cp(), c0556up.cq());
                    FloatFloatPair floatFloatPairC = c0558ur.m1216a().c(livingEntity.distanceTo(livingEntity2));
                    float fRightFloat = (lZVar.ap() ? floatFloatPairC.rightFloat() : floatFloatPairC.leftFloat()) - fBu;
                    if (livingEntity instanceof mE) {
                        fRightFloat /= 5.0f;
                    }
                    if (fRightFloat <= 0.0f) {
                        return;
                    }
                    if (livingEntity2 instanceof Player) {
                        Player player = (Player) livingEntity2;
                        UUID uuid = player.getUUID();
                        if (cVar.m305a(player).dk() || player.getHealth() <= 0.0f || !player.isAlive()) {
                            return;
                        }
                        Object objMo604a = abstractC0264ju.mo604a(uuid);
                        if (objMo604a instanceof qQ) {
                            fRightFloat *= ((qQ) objMo604a).aS();
                        }
                    }
                    if (fRightFloat > 0.0f) {
                        livingEntity2.hurtTime = 0;
                        livingEntity2.invulnerableTime = 0;
                        if (livingEntity2.hurt(lZVar, fRightFloat)) {
                            livingEntity2.setDeltaMovement(0.0d, 0.0d, 0.0d);
                            if (c0556up.cr()) {
                                a(cVar, level, livingEntity, itemStack, livingEntity2);
                            }
                            a(level, livingEntity2.getBoundingBox().inflate(4.0d), wV.Q.get());
                        }
                    }
                }
            }
        }
    }

    private static void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull ItemStack itemStack, @NotNull LivingEntity livingEntity2) {
        C0560ut item = livingEntity2.getItemBySlot(EquipmentSlot.CHEST).getItem();
        if ((item instanceof C0560ut) && item.cD() && (livingEntity2 instanceof ServerPlayer)) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity2;
            com.boehmod.blockfront.common.player.b bVarM305a = cVar.m305a((Player) serverPlayer);
            if (livingEntity2.getHealth() <= 0.0f) {
                bVarM305a.b().b(level, serverPlayer);
            } else {
                bVarM305a.b().a(serverPlayer, livingEntity, itemStack);
            }
        }
    }

    public static void a(@NotNull Level level, @NotNull C0555uo c0555uo, @Nullable LivingEntity livingEntity) {
        BlockPos blockPosA = c0555uo.a();
        BlockState blockState = level.getBlockState(blockPosA);
        C0565uy c0565uyM1232a = wI.a(level, blockState, blockPosA).m1232a();
        if (c0565uyM1232a != null) {
            Vec3 vec3Z = c0555uo.z();
            switch ((int) SwitchBootstraps.enumSwitch(MethodHandles.lookup(), "enumSwitch", MethodType.methodType(Integer.TYPE, C0066cj.b.a.class, Integer.TYPE), "BLOOD", "DIRT").dynamicInvoker().invoke(c0565uyM1232a.a(), 0) /* invoke-custom */) {
                case 0:
                    a(level, vec3Z, 4.0f);
                    break;
                case 1:
                    b(level, vec3Z, 4.0f);
                    break;
            }
        }
        if (level instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel) level;
            kE block = blockState.getBlock();
            if (block instanceof kE) {
                block.a(serverLevel, blockPosA, blockState, livingEntity);
            }
        }
    }

    private static void a(@NotNull Level level, @NotNull AABB aabb, @NotNull DataComponentType<Integer> dataComponentType) {
        Iterator it = level.getEntitiesOfClass(LivingEntity.class, aabb).iterator();
        while (it.hasNext()) {
            ItemStack mainHandItem = ((LivingEntity) it.next()).getMainHandItem();
            if (mainHandItem.getItem() instanceof tO) {
                int iIntValue = ((Integer) mainHandItem.getOrDefault(dataComponentType, 0)).intValue();
                if (level.random.nextDouble() < 0.25d / ((double) (iIntValue + 1))) {
                    mainHandItem.set(dataComponentType, Integer.valueOf(Math.min(iIntValue + 1, 3)));
                }
            }
        }
    }

    public static void a(@NotNull Level level, @NotNull Vec3 vec3, float f) {
        oA.a(level, vec3, f, wV.Q.get(), 0.25d);
    }

    public static void b(@NotNull Level level, @NotNull Vec3 vec3, float f) {
        oA.a(level, vec3, f, wV.R.get(), 0.25d);
    }
}
