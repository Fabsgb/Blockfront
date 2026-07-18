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

/* JADX INFO: renamed from: com.boehmod.blockfront.tu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tu.class */
public class C1094tu extends SpyglassItem implements InterfaceC1070tW, InterfaceC1098ty {
    public C1094tu(@NotNull Item.Properties properties) {
        super(properties);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        player.playSound((SoundEvent) C1280xc.f7775ty.get(), 1.0f, 1.0f);
        return ItemUtils.startUsingInstantly(level, player, interactionHand);
    }

    /* JADX INFO: renamed from: d */
    private void m6040d(@NotNull LivingEntity livingEntity) {
        livingEntity.playSound((SoundEvent) C1280xc.f7776tz.get(), 1.0f, 1.0f);
    }

    @NotNull
    public ItemStack finishUsingItem(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        m6040d(livingEntity);
        return itemStack;
    }

    public void releaseUsing(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity, int i) {
        m6040d(livingEntity);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.tu$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tu$a.class */
    public static final class a implements IClientItemExtensions {

        /* JADX INFO: renamed from: fL */
        @NotNull
        private static final ResourceLocation f5749fL = C0564jv.m2555d("textures/misc/binoculars_scope.png");

        @NotNull
        public ResourceLocation getScopeOverlayTexture(@NotNull ItemStack itemStack) {
            return f5749fL;
        }
    }
}
