package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uh.class */
public class C1135uh extends C1136ui {

    /* JADX INFO: renamed from: jN */
    @NotNull
    public static final Component f6238jN = Component.translatable("item.bf.cloud.disclaimer").withStyle(ChatFormatting.GRAY);

    public C1135uh(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        list.add(f6238jN);
    }
}
