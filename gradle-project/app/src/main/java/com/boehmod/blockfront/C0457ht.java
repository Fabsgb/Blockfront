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
import org.joml.Vector3f;
import software.bernie.geckolib.cache.object.GeoBone;

/* JADX INFO: renamed from: com.boehmod.blockfront.ht */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ht.class */
public class C0457ht<T extends AbstractC1140um<T>> extends AbstractC0412hA<T> {
    public C0457ht(C0450hm<T> c0450hm) {
        super(c0450hm);
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public void mo1953a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1954a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        float fM6265c;
        boolean z2;
        int iM7246a = InterfaceC1274xN.m7246a(geoBone);
        if ((iM7246a & 192) == 0 || !(t instanceof C1117uP)) {
            return false;
        }
        C1117uP c1117uP = (C1117uP) t;
        if (!c1117uP.m6377cG() || c1117uP.m6380cI()) {
            return false;
        }
        int iM6402cq = c1117uP.m6283a(itemStack).m6402cq();
        if (itemDisplayContext.firstPerson()) {
            fM6265c = C0486iV.m2179aw();
        } else {
            fM6265c = C1117uP.m6265c(itemStack);
        }
        float f4 = fM6265c;
        float f5 = 1.0f - (f4 / iM6402cq);
        if ((iM7246a & 64) != 0) {
            Vector3f vector3fM6376a = c1117uP.m6376a();
            poseStack.translate(vector3fM6376a.x * f5, vector3fM6376a.y * f5, vector3fM6376a.z * f5);
        }
        if ((iM7246a & 128) != 0) {
            try {
                int i4 = Integer.parseInt(geoBone.getName().replace("bullet", ""));
                if (c1117uP.m6379cH()) {
                    z2 = ((float) i4) > f4 - 1.0f;
                } else {
                    z2 = ((float) i4) < ((float) iM6402cq) - f4;
                }
                if (z2) {
                    return true;
                }
                return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
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
