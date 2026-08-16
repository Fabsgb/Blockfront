package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.uC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uC.class */
public class C1104uC extends C1136ui implements InterfaceC1148uu {

    /* JADX INFO: renamed from: nM */
    private static final float f6011nM = 6.0f;

    /* JADX INFO: renamed from: ic */
    static final /* synthetic */ boolean f6012ic;

    static {
        f6012ic = !C1104uC.class.desiredAssertionStatus();
    }

    public C1104uC(String str, Item.Properties properties) {
        super(str, properties);
    }

    /* JADX INFO: renamed from: a */
    private static void m6201a(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity) {
        Vec3 vec3Position = entity.position();
        itemStack.shrink(1);
        Explosion explosionM4490a = C0875pn.m4490a(level, entity, vec3Position, itemStack, 6.0f);
        explosionM4490a.explode();
        explosionM4490a.finalizeExplosion(true);
        explosionM4490a.clearToBlow();
        C1169vO.m6644b(new C1175vU(EnumC0862pa.GENERIC, vec3Position));
    }

    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        super.inventoryTick(itemStack, level, entity, i, z);
        if (!entity.isAlive() || level.isClientSide()) {
            return;
        }
        if (entity instanceof Player) {
            Player player = (Player) entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f6012ic && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (C0875pn.m4488a(player, (AbstractC0183b<?, ?, ?, ?>) abstractC0531jNM179a.m2351a().m1153a(player))) {
                return;
            }
        }
        boolean zBooleanValue = ((Boolean) itemStack.getOrDefault(C1305xs.f7536Q, false)).booleanValue();
        int iIntValue = ((Integer) itemStack.getOrDefault(C1305xs.f7537R, 0)).intValue();
        if (zBooleanValue) {
            if (iIntValue > 0) {
                itemStack.set(C1305xs.f7537R, Integer.valueOf(iIntValue - 1));
            }
            if (iIntValue == 0) {
                m6201a(itemStack, level, entity);
            }
        }
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (((Boolean) itemInHand.getOrDefault(C1305xs.f7536Q, false)).booleanValue()) {
            return InteractionResultHolder.fail(itemInHand);
        }
        if (!itemInHand.isEmpty() && (itemInHand.getItem() instanceof C1104uC)) {
            itemInHand.set(C1305xs.f7537R, 43);
            itemInHand.set(C1305xs.f7536Q, true);
            player.playSound((SoundEvent) C1312xz.f8193tG.get());
        }
        return InteractionResultHolder.consume(itemInHand);
    }
}
