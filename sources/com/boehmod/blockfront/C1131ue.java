package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ue */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ue.class */
public class C1131ue extends C1058tK implements InterfaceC1070tW {

    /* JADX INFO: renamed from: mN */
    private static final float f5945mN = 6.0f;

    /* JADX INFO: renamed from: hI */
    static final /* synthetic */ boolean f5946hI;

    static {
        f5946hI = !C1131ue.class.desiredAssertionStatus();
    }

    public C1131ue(String str, Item.Properties properties) {
        super(str, properties);
    }

    /* JADX INFO: renamed from: a */
    private static void m6248a(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity) {
        Vec3 vec3Position = entity.position();
        itemStack.shrink(1);
        Explosion explosionM4054a = C0799oR.m4054a(level, entity, vec3Position, itemStack, 6.0f);
        explosionM4054a.explode();
        explosionM4054a.finalizeExplosion(true);
        explosionM4054a.clearToBlow();
        C1194vo.m6649b(new C1200vu(EnumC0786oE.GENERIC, vec3Position));
    }

    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        super.inventoryTick(itemStack, level, entity, i, z);
        if (!entity.isAlive() || level.isClientSide()) {
            return;
        }
        if (entity instanceof Player) {
            Player player = (Player) entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f5946hI && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (C0799oR.m4052a(player, (AbstractC0182b<?, ?, ?, ?>) abstractC0563juM168a.m2528a().m1136a(player))) {
                return;
            }
        }
        boolean zBooleanValue = ((Boolean) itemStack.getOrDefault(C1228wV.f6971O, false)).booleanValue();
        int iIntValue = ((Integer) itemStack.getOrDefault(C1228wV.f6972P, 0)).intValue();
        if (zBooleanValue) {
            if (iIntValue > 0) {
                itemStack.set(C1228wV.f6972P, Integer.valueOf(iIntValue - 1));
            }
            if (iIntValue == 0) {
                m6248a(itemStack, level, entity);
            }
        }
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (((Boolean) itemInHand.getOrDefault(C1228wV.f6971O, false)).booleanValue()) {
            return InteractionResultHolder.fail(itemInHand);
        }
        if (!itemInHand.isEmpty() && (itemInHand.getItem() instanceof C1131ue)) {
            itemInHand.set(C1228wV.f6972P, 43);
            itemInHand.set(C1228wV.f6971O, true);
            player.playSound((SoundEvent) C1280xc.f7782tF.get());
        }
        return InteractionResultHolder.consume(itemInHand);
    }
}
