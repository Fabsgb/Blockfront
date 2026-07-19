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
import org.joml.Vector3f;
import software.bernie.geckolib.cache.object.GeoBone;

/* JADX INFO: renamed from: com.boehmod.blockfront.hd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hd.class */
public class C0194hd<T extends tO<T>> extends AbstractC0201hk<T> {
    public C0194hd(gW<T> gWVar) {
        super(gWVar);
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        int iA = InterfaceC0638xq.a(geoBone);
        if ((iA & 192) == 0 || !(t instanceof C0558ur)) {
            return false;
        }
        C0558ur c0558ur = (C0558ur) t;
        if (!c0558ur.cx() || c0558ur.cz()) {
            return false;
        }
        int iCb = c0558ur.m1206a(itemStack).cb();
        float fA = C0558ur.a(itemStack);
        float f4 = 1.0f - (fA / iCb);
        if ((iA & 64) != 0) {
            Vector3f vector3fM1219c = c0558ur.m1219c();
            poseStack.translate(vector3fM1219c.x * f4, vector3fM1219c.y * f4, vector3fM1219c.z * f4);
        }
        if ((iA & 128) != 0) {
            try {
                int i4 = Integer.parseInt(geoBone.getName().replace("bullet", ""));
                if (c0558ur.cy() ? ((float) i4) > fA - 1.0f : ((float) i4) < ((float) iCb) - fA) {
                    return true;
                }
                return false;
            } catch (NumberFormatException e) {
                return false;
            }
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
