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
import org.joml.Vector3d;
import software.bernie.geckolib.cache.object.GeoBone;

/* JADX INFO: renamed from: com.boehmod.blockfront.hg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hg.class */
public class C0197hg<T extends tO<T>> extends AbstractC0201hk<T> {
    public C0197hg(gW<T> gWVar) {
        super(gWVar);
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
        if (itemDisplayContext.firstPerson()) {
            int iA = InterfaceC0638xq.a(geoBone);
            if ((iA & InterfaceC0638xq.tR) == 0 || !(itemStack.getItem() instanceof C0558ur)) {
                return;
            }
            Vector3d rotationVector = geoBone.getRotationVector();
            Vector3d positionVector = geoBone.getPositionVector();
            if ((iA & InterfaceC0638xq.tS) != 0) {
                C0027ay.af = 0.0f;
                C0027ay.ag = 0.0f;
                C0027ay.ah = 0.0f;
            }
            C0027ay.af += (float) (rotationVector.x * 0.10000000149011612d * ((double) f2));
            C0027ay.ag += (float) (rotationVector.y * 0.10000000149011612d * ((double) f2));
            C0027ay.ah += (float) (rotationVector.z * 0.10000000149011612d * ((double) f2));
            C0027ay.af += (float) ((-positionVector.y) * 12.0d * ((double) f2));
            positionVector.mul(f2);
            rotationVector.mul(f2);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
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
