package com.boehmod.blockfront;

import com.boehmod.blockfront.tO;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.mutable.MutableInt;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;

/* JADX INFO: renamed from: com.boehmod.blockfront.hf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hf.class */
public class C0196hf<T extends tO<T>> extends AbstractC0201hk<T> {
    public C0196hf(gW<T> gWVar) {
        super(gWVar);
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        if ((InterfaceC0638xq.a(geoBone) & InterfaceC0638xq.tQ) != 0 && !z && (itemStack.getItem() instanceof C0558ur)) {
            String str = "mag_type_" + C0558ur.b(itemStack);
            String name = geoBone.getName();
            if (name.startsWith(str)) {
                return (name.length() == str.length() || name.charAt(str.length()) == '_') ? false : true;
            }
            return true;
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull GeoBone geoBone, @NotNull T t, @NotNull ItemStack itemStack, @NotNull ResourceLocation resourceLocation, @NotNull ItemDisplayContext itemDisplayContext, @NotNull VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull ItemStack itemStack, @NotNull MutableInt mutableInt, @Nullable uH uHVar, @NotNull ItemDisplayContext itemDisplayContext, @NotNull fT fTVar) {
        return false;
    }
}
