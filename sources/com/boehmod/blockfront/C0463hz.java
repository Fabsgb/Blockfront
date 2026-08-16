package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC1140um;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.hz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hz.class */
public class C0463hz<T extends AbstractC1140um<T>> extends AbstractC0412hA<T> {
    public C0463hz(C0450hm<T> c0450hm) {
        super(c0450hm);
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public void mo1953a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1954a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        return ((InterfaceC1274xN.m7246a(geoBone) & InterfaceC1274xN.f6857vZ) == 0 || C1117uP.m6261d(itemStack)) ? false : true;
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1955a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull GeoBone geoBone, @NotNull T t, @NotNull ItemStack itemStack, @NotNull ResourceLocation resourceLocation, @NotNull ItemDisplayContext itemDisplayContext, @NotNull VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1956a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull ItemStack itemStack, @NotNull MutableInt mutableInt, @Nullable C1188vh c1188vh, @NotNull ItemDisplayContext itemDisplayContext, @NotNull C0394gj c0394gj) {
        if (!itemDisplayContext.firstPerson()) {
            return false;
        }
        if (c0394gj.m1104dt() || (C1117uP.f6063il && c1188vh != null && c1188vh.f6458iS && c1188vh.f6462go != null)) {
            poseStack.translate(0.0f, -100.0f, 0.0f);
            return false;
        }
        return false;
    }
}
