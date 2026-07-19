package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.ue, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ue.class */
public class C0545ue extends tK implements tW {
    private static final float mN = 6.0f;
    static final /* synthetic */ boolean hI;

    static {
        hI = !C0545ue.class.desiredAssertionStatus();
    }

    public C0545ue(String str, Item.Properties properties) {
        super(str, properties);
    }

    private static void a(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity) {
        Vec3 vec3Position = entity.position();
        itemStack.shrink(1);
        Explosion explosionA = oR.a(level, entity, vec3Position, itemStack, 6.0f);
        explosionA.explode();
        explosionA.finalizeExplosion(true);
        explosionA.clearToBlow();
        C0582vo.b(new C0588vu(oE.GENERIC, vec3Position));
    }

    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        super.inventoryTick(itemStack, level, entity, i, z);
        if (!entity.isAlive() || level.isClientSide()) {
            return;
        }
        if (entity instanceof Player) {
            Player player = (Player) entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!hI && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (oR.a(player, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) abstractC0264juM166a.m531a().m305a(player))) {
                return;
            }
        }
        boolean zBooleanValue = ((Boolean) itemStack.getOrDefault(wV.O, false)).booleanValue();
        int iIntValue = ((Integer) itemStack.getOrDefault(wV.P, 0)).intValue();
        if (zBooleanValue) {
            if (iIntValue > 0) {
                itemStack.set(wV.P, Integer.valueOf(iIntValue - 1));
            }
            if (iIntValue == 0) {
                a(itemStack, level, entity);
            }
        }
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (((Boolean) itemInHand.getOrDefault(wV.O, false)).booleanValue()) {
            return InteractionResultHolder.fail(itemInHand);
        }
        if (!itemInHand.isEmpty() && (itemInHand.getItem() instanceof C0545ue)) {
            itemInHand.set(wV.P, 43);
            itemInHand.set(wV.O, true);
            player.playSound((SoundEvent) C0624xc.tF.get());
        }
        return InteractionResultHolder.consume(itemInHand);
    }
}
