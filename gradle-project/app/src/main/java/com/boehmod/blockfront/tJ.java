package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tJ.class */
public class tJ extends tK {

    @NotNull
    public static final Component jA = Component.translatable("item.bf.cloud.disclaimer").withStyle(ChatFormatting.GRAY);

    public tJ(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        list.add(jA);
    }
}
