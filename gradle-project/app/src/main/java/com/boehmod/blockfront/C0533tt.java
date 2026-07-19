package com.boehmod.blockfront;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tt.class */
public class C0533tt extends tK implements tW {
    public C0533tt(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand interactionHand) {
        C0360ni c0360niCreate;
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        level.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5f, 0.4f / ((ThreadLocalRandom.current().nextFloat() * 0.4f) + 0.8f));
        boolean zIsClientSide = level.isClientSide();
        if (!zIsClientSide && (c0360niCreate = ((EntityType) wX.kT.get()).create(level)) != null) {
            c0360niCreate.setPos(player.getX(), player.getEyeY(), player.getZ());
            c0360niCreate.setItem(itemInHand);
            c0360niCreate.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 1.5f, 1.0f);
            level.addFreshEntity(c0360niCreate);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess(itemInHand, zIsClientSide);
    }
}
