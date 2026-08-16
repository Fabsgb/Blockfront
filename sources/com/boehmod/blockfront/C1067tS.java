package com.boehmod.blockfront;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.SpyglassItem;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tS.class */
public class C1067tS extends SpyglassItem implements InterfaceC1071tW, InterfaceC1148uu {
    public C1067tS(@NotNull Item.Properties properties) {
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        player.playSound((SoundEvent) C1312xz.f8186tz.get(), 1.0f, 1.0f);
        return ItemUtils.startUsingInstantly(level, player, interactionHand);
    }

    /* JADX INFO: renamed from: d */
    private void m5926d(@NotNull LivingEntity livingEntity) {
        livingEntity.playSound((SoundEvent) C1312xz.f8187tA.get(), 1.0f, 1.0f);
    }

    @NotNull
    public ItemStack finishUsingItem(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        m5926d(livingEntity);
        return itemStack;
    }

    public void releaseUsing(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity, int i) {
        m5926d(livingEntity);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.tS$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tS$a.class */
    public static final class a implements IClientItemExtensions {

        /* JADX INFO: renamed from: fK */
        @NotNull
        private static final ResourceLocation f5802fK = C0532jO.m2378d("textures/misc/binoculars_scope.png");

        @NotNull
        public ResourceLocation getScopeOverlayTexture(@NotNull ItemStack itemStack) {
            return f5802fK;
        }
    }
}
