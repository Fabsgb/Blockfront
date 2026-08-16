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
import org.joml.Vector3d;
import software.bernie.geckolib.cache.object.GeoBone;

/* JADX INFO: renamed from: com.boehmod.blockfront.hw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hw.class */
public class C0460hw<T extends AbstractC1140um<T>> extends AbstractC0412hA<T> {
    public C0460hw(C0450hm<T> c0450hm) {
        super(c0450hm);
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public void mo1953a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
        if (itemDisplayContext.firstPerson()) {
            int iM7246a = InterfaceC1274xN.m7246a(geoBone);
            if ((iM7246a & 1024) == 0 || !(itemStack.getItem() instanceof C1117uP)) {
                return;
            }
            Vector3d rotationVector = geoBone.getRotationVector();
            Vector3d positionVector = geoBone.getPositionVector();
            if ((iM7246a & InterfaceC1274xN.f6854vW) != 0) {
                C0036aF.f317ak = 0.0f;
                C0036aF.f318al = 0.0f;
                C0036aF.f319am = 0.0f;
            }
            C0036aF.f317ak += (float) (rotationVector.x * 0.10000000149011612d * ((double) f2));
            C0036aF.f318al += (float) (rotationVector.y * 0.10000000149011612d * ((double) f2));
            C0036aF.f319am += (float) (rotationVector.z * 0.10000000149011612d * ((double) f2));
            C0036aF.f317ak += (float) ((-positionVector.y) * 12.0d * ((double) f2));
            positionVector.mul(f2);
            rotationVector.mul(f2);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1954a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1955a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull GeoBone geoBone, @NotNull T t, @NotNull ItemStack itemStack, @NotNull ResourceLocation resourceLocation, @NotNull ItemDisplayContext itemDisplayContext, @NotNull VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1956a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull ItemStack itemStack, @NotNull MutableInt mutableInt, @Nullable C1188vh c1188vh, @NotNull ItemDisplayContext itemDisplayContext, @NotNull C0394gj c0394gj) {
        return false;
    }
}
