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
import org.joml.Vector3f;
import software.bernie.geckolib.cache.object.GeoBone;

/* JADX INFO: renamed from: com.boehmod.blockfront.hd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hd.class */
public class C0440hd<T extends AbstractC1062tO<T>> extends AbstractC0447hk<T> {
    public C0440hd(C0380gW<T> c0380gW) {
        super(c0380gW);
    }

    @Override // com.boehmod.blockfront.AbstractC0447hk
    /* JADX INFO: renamed from: a */
    public void mo1838a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0447hk
    /* JADX INFO: renamed from: a */
    public boolean mo1839a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        int iM7919a = InterfaceC1294xq.m7919a(geoBone);
        if ((iM7919a & 192) == 0 || !(t instanceof C1144ur)) {
            return false;
        }
        C1144ur c1144ur = (C1144ur) t;
        if (!c1144ur.m6402cx() || c1144ur.m6405cz()) {
            return false;
        }
        int iM6424cb = c1144ur.m6318a(itemStack).m6424cb();
        float fM6301a = C1144ur.m6301a(itemStack);
        float f4 = 1.0f - (fM6301a / iM6424cb);
        if ((iM7919a & 64) != 0) {
            Vector3f vector3fM6401c = c1144ur.m6401c();
            poseStack.translate(vector3fM6401c.x * f4, vector3fM6401c.y * f4, vector3fM6401c.z * f4);
        }
        if ((iM7919a & 128) != 0) {
            try {
                int i4 = Integer.parseInt(geoBone.getName().replace("bullet", ""));
                if (c1144ur.m6404cy() ? ((float) i4) > fM6301a - 1.0f : ((float) i4) < ((float) iM6424cb) - fM6301a) {
                    return true;
                }
                return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
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
