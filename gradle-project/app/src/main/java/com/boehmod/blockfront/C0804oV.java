package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.oV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oV.class */
public final class C0804oV {

    /* JADX INFO: renamed from: ol */
    private static final int f4348ol = 3;

    /* JADX INFO: renamed from: aN */
    private static final double f4349aN = 0.25d;

    /* JADX INFO: renamed from: kZ */
    private static final float f4350kZ = 4.0f;

    /* JADX INFO: renamed from: a */
    public static void m3690a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull LivingEntity livingEntity, @Nullable ItemStack itemStack, @NotNull LivingEntity livingEntity2, @NotNull C1115uN c1115uN) {
        if (itemStack != null) {
            Item item = itemStack.getItem();
            if (item instanceof C1117uP) {
                C1117uP c1117uP = (C1117uP) item;
                if (C0875pn.m4487a(abstractC0531jN, abstractC0184c, livingEntity, livingEntity2)) {
                    float fM6249bA = c1115uN.m6249bA();
                    C0724mv c0724mv = new C0724mv(level, livingEntity, itemStack, c1115uN.m6250an(), fM6249bA > 0.0f, c1115uN.m6251cy(), c1115uN.m6252cz());
                    FloatFloatPair floatFloatPairM6768c = c1117uP.m6369a().m6768c(livingEntity.distanceTo(livingEntity2));
                    float fRightFloat = (c0724mv.m3338az() ? floatFloatPairM6768c.rightFloat() : floatFloatPairM6768c.leftFloat()) - fM6249bA;
                    if (livingEntity instanceof C0756na) {
                        fRightFloat /= 5.0f;
                    }
                    if (fRightFloat <= 0.0f) {
                        return;
                    }
                    if (livingEntity2 instanceof Player) {
                        Player player = (Player) livingEntity2;
                        UUID uuid = player.getUUID();
                        if (abstractC0184c.m1153a(player).m1104dt() || player.getHealth() <= 0.0f || !player.isAlive()) {
                            return;
                        }
                        Object objMo2354a = abstractC0531jN.mo2354a(uuid);
                        if (objMo2354a instanceof InterfaceC0981rn) {
                            fRightFloat *= ((InterfaceC0981rn) objMo2354a).mo5552aY();
                        }
                    }
                    if (fRightFloat > 0.0f) {
                        livingEntity2.hurtTime = 0;
                        livingEntity2.invulnerableTime = 0;
                        if (livingEntity2.hurt(c0724mv, fRightFloat)) {
                            livingEntity2.setDeltaMovement(0.0d, 0.0d, 0.0d);
                            if (c1115uN.m6253cA()) {
                                m3691a(abstractC0184c, level, livingEntity, itemStack, livingEntity2);
                            }
                            m3693a(level, livingEntity2.getBoundingBox().inflate(4.0d), C1305xs.f7538S.get());
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3691a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull ItemStack itemStack, @NotNull LivingEntity livingEntity2) {
        C1119uR item = livingEntity2.getItemBySlot(EquipmentSlot.CHEST).getItem();
        if ((item instanceof C1119uR) && item.m6407cM() && (livingEntity2 instanceof ServerPlayer)) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity2;
            AbstractC0183b abstractC0183bM1153a = abstractC0184c.m1153a((Player) serverPlayer);
            if (livingEntity2.getHealth() <= 0.0f) {
                abstractC0183bM1153a.m1094b().m1087b(level, serverPlayer);
            } else {
                abstractC0183bM1153a.m1094b().m1084a(serverPlayer, livingEntity, itemStack);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3692a(@NotNull Level level, @NotNull C1114uM c1114uM, @Nullable LivingEntity livingEntity) {
        BlockPos blockPosM6243a = c1114uM.m6243a();
        BlockState blockState = level.getBlockState(blockPosM6243a);
        C1126uY c1126uYM6426a = C1292xf.m7328a(level, blockState, blockPosM6243a).m6426a();
        if (c1126uYM6426a != null) {
            Vec3 vec3M6245A = c1114uM.m6245A();
            switch ((int) SwitchBootstraps.enumSwitch(MethodHandles.lookup(), "enumSwitch", MethodType.methodType(Integer.TYPE, C0191cs.b.a.class, Integer.TYPE), "BLOOD", "DIRT").dynamicInvoker().invoke(c1126uYM6426a.m6450a(), 0) /* invoke-custom */) {
                case 0:
                    m3694a(level, vec3M6245A, 4.0f);
                    break;
                case 1:
                    m3695b(level, vec3M6245A, 4.0f);
                    break;
            }
        }
        if (level instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel) level;
            InterfaceC0650la block = blockState.getBlock();
            if (block instanceof InterfaceC0650la) {
                block.mo2931a(serverLevel, blockPosM6243a, blockState, livingEntity);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3693a(@NotNull Level level, @NotNull AABB aabb, @NotNull DataComponentType<Integer> dataComponentType) {
        Iterator it = level.getEntitiesOfClass(LivingEntity.class, aabb).iterator();
        while (it.hasNext()) {
            ItemStack mainHandItem = ((LivingEntity) it.next()).getMainHandItem();
            if (mainHandItem.getItem() instanceof AbstractC1140um) {
                int iIntValue = ((Integer) mainHandItem.getOrDefault(dataComponentType, 0)).intValue();
                if (level.random.nextDouble() < 0.25d / ((double) (iIntValue + 1))) {
                    mainHandItem.set(dataComponentType, Integer.valueOf(Math.min(iIntValue + 1, 3)));
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3694a(@NotNull Level level, @NotNull Vec3 vec3, float f) {
        C0805oW.m3696a(level, vec3, f, C1305xs.f7538S.get(), 0.25d);
    }

    /* JADX INFO: renamed from: b */
    public static void m3695b(@NotNull Level level, @NotNull Vec3 vec3, float f) {
        C0805oW.m3696a(level, vec3, f, C1305xs.f7539T.get(), 0.25d);
    }
}
