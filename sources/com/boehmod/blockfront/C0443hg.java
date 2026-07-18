package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC1062tO;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.hg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hg.class */
public class C0443hg<T extends AbstractC1062tO<T>> extends AbstractC0447hk<T> {
    public C0443hg(C0380gW<T> c0380gW) {
        super(c0380gW);
    }

    @Override // com.boehmod.blockfront.AbstractC0447hk
    /* JADX INFO: renamed from: a */
    public void mo1838a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
        if (itemDisplayContext.firstPerson()) {
            int iM7919a = InterfaceC1294xq.m7919a(geoBone);
            if ((iM7919a & InterfaceC1294xq.f8656tR) == 0 || !(itemStack.getItem() instanceof C1144ur)) {
                return;
            }
            Vector3d rotationVector = geoBone.getRotationVector();
            Vector3d positionVector = geoBone.getPositionVector();
            if ((iM7919a & InterfaceC1294xq.f8657tS) != 0) {
                C0080ay.f495af = 0.0f;
                C0080ay.f496ag = 0.0f;
                C0080ay.f497ah = 0.0f;
            }
            C0080ay.f495af += (float) (rotationVector.x * 0.10000000149011612d * ((double) f2));
            C0080ay.f496ag += (float) (rotationVector.y * 0.10000000149011612d * ((double) f2));
            C0080ay.f497ah += (float) (rotationVector.z * 0.10000000149011612d * ((double) f2));
            C0080ay.f495af += (float) ((-positionVector.y) * 12.0d * ((double) f2));
            positionVector.mul(f2);
            rotationVector.mul(f2);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0447hk
    /* JADX INFO: renamed from: a */
    public boolean mo1839a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0447hk
    /* JADX INFO: renamed from: a */
    public boolean mo1840a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull GeoBone geoBone, @NotNull T t, @NotNull ItemStack itemStack, @NotNull ResourceLocation resourceLocation, @NotNull ItemDisplayContext itemDisplayContext, @NotNull VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0447hk
    /* JADX INFO: renamed from: a */
    public boolean mo1841a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull ItemStack itemStack, @NotNull MutableInt mutableInt, @Nullable C1108uH c1108uH, @NotNull ItemDisplayContext itemDisplayContext, @NotNull C0324fT c0324fT) {
        return false;
    }
}
