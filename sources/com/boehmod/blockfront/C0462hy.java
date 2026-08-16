package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC1140um;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.mutable.MutableInt;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;

/* JADX INFO: renamed from: com.boehmod.blockfront.hy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hy.class */
public class C0462hy<T extends AbstractC1140um<T>> extends AbstractC0412hA<T> {

    /* JADX INFO: renamed from: cT */
    private static final ResourceLocation f2883cT = C0532jO.m2378d("textures/misc/gun/overheat.png");

    public C0462hy(@NotNull C0450hm<T> c0450hm) {
        super(c0450hm);
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public void mo1953a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1954a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1955a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull GeoBone geoBone, @NotNull T t, @NotNull ItemStack itemStack, @NotNull ResourceLocation resourceLocation, @NotNull ItemDisplayContext itemDisplayContext, @NotNull VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        ClientLevel clientLevel;
        if (itemDisplayContext == ItemDisplayContext.GUI || itemDisplayContext == ItemDisplayContext.GROUND || !(itemStack.getItem() instanceof C1117uP) || (InterfaceC1274xN.m7246a(geoBone) & InterfaceC1274xN.f6856vY) == 0 || (clientLevel = minecraft.level) == null) {
            return false;
        }
        float fM6263a = C1117uP.m6263a(itemStack, (Level) clientLevel);
        if (fM6263a < 0.1f) {
            return false;
        }
        m2096a(poseStack, multiBufferSource, geoBone, f, i2, fM6263a);
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1956a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull ItemStack itemStack, @NotNull MutableInt mutableInt, @Nullable C1188vh c1188vh, @NotNull ItemDisplayContext itemDisplayContext, @NotNull C0394gj c0394gj) {
        return false;
    }

    /* JADX INFO: renamed from: a */
    private void m2096a(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull GeoBone geoBone, float f, int i, float f2) {
        int iColorFromFloat = FastColor.ARGB32.colorFromFloat(Mth.clamp((f2 - 0.1f) * 1.1111112f * 2.5f, 0.0f, 1.0f), 1.0f, 1.0f, 1.0f);
        RenderType renderTypeText = RenderType.text(f2883cT);
        this.f2661a.m2072a(poseStack, geoBone, renderTypeText, multiBufferSource, multiBufferSource.getBuffer(renderTypeText), false, f, 15728880, i, iColorFromFloat);
    }
}
