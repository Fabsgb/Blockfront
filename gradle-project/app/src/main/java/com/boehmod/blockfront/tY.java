package com.boehmod.blockfront;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tY.class */
public final class tY extends AbstractC0542ub {
    private static final int rN = 60;
    private static final ResourceLocation gh = C0265jv.d("textures/gui/game/troubletown/detective.png");

    public tY(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull Level level, @NotNull Player player, @NotNull AbstractC0542ub abstractC0542ub, @NotNull ItemStack itemStack) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub, com.boehmod.blockfront.tC
    public int bU() {
        return 60;
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub, com.boehmod.blockfront.tC
    @NotNull
    public String as() {
        return "bf.message.magnifying.glass.inspecting";
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub, com.boehmod.blockfront.tC
    public int getColor() {
        return sK.DETECTIVE.getColor();
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub, com.boehmod.blockfront.tC
    @NotNull
    public ResourceLocation getIcon() {
        return gh;
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub
    public int bW() {
        return 16;
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub
    @NotNull
    public SoundEvent x() {
        return SoundEvents.BOOK_PAGE_TURN;
    }
}
