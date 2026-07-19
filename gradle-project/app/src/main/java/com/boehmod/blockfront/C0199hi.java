package com.boehmod.blockfront;

import com.boehmod.blockfront.tO;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.mutable.MutableInt;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;

/* JADX INFO: renamed from: com.boehmod.blockfront.hi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hi.class */
public class C0199hi<T extends tO<T>> extends AbstractC0201hk<T> {
    private static final ResourceLocation cT = C0265jv.d("textures/misc/gun/overheat.png");

    public C0199hi(@NotNull gW<T> gWVar) {
        super(gWVar);
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull GeoBone geoBone, @NotNull T t, @NotNull ItemStack itemStack, @NotNull ResourceLocation resourceLocation, @NotNull ItemDisplayContext itemDisplayContext, @NotNull VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        if (itemDisplayContext == ItemDisplayContext.GUI || itemDisplayContext == ItemDisplayContext.GROUND || !(itemStack.getItem() instanceof C0558ur) || (InterfaceC0638xq.a(geoBone) & InterfaceC0638xq.tU) == 0) {
            return false;
        }
        float fM1199c = C0558ur.m1199c(itemStack);
        if (fM1199c < 0.1f) {
            return false;
        }
        a(poseStack, multiBufferSource, geoBone, f, i2, fM1199c);
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull ItemStack itemStack, @NotNull MutableInt mutableInt, @Nullable uH uHVar, @NotNull ItemDisplayContext itemDisplayContext, @NotNull fT fTVar) {
        return false;
    }

    private void a(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull GeoBone geoBone, float f, int i, float f2) {
        int iColorFromFloat = FastColor.ARGB32.colorFromFloat(Mth.clamp((f2 - 0.1f) * 1.1111112f * 2.5f, 0.0f, 1.0f), 1.0f, 1.0f, 1.0f);
        RenderType renderTypeText = RenderType.text(cT);
        this.a.a(poseStack, geoBone, renderTypeText, multiBufferSource, multiBufferSource.getBuffer(renderTypeText), false, f, 15728880, i, iColorFromFloat);
    }
}
