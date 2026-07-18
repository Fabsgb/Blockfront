package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC1062tO;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.mutable.MutableInt;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2f;
import org.joml.Vector3f;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.cache.object.GeoCube;

/* JADX INFO: renamed from: com.boehmod.blockfront.hc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hc.class */
public class C0439hc<T extends AbstractC1062tO<T>> extends AbstractC0447hk<T> {

    /* JADX INFO: renamed from: M */
    @NotNull
    private static final List<C0382gY> f2825M = new ObjectArrayList();

    /* JADX INFO: renamed from: N */
    @NotNull
    private static final List<C0381gX> f2826N = new ObjectArrayList();

    public C0439hc(@NotNull C0380gW<T> c0380gW) {
        super(c0380gW);
    }

    /* JADX INFO: renamed from: aO */
    public static void m2052aO() {
        f2825M.removeIf((v0) -> {
            return v0.m1835S();
        });
        f2826N.removeIf((v0) -> {
            return v0.m1833S();
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m2053a(@NotNull Random random, @NotNull String str, boolean z) {
        C0382gY c0382gY = new C0382gY(new Vector2f(1.0f, (-1.0f) + ((-0.2f) * random.nextFloat())), str, z);
        c0382gY.m1835S();
        f2825M.add(c0382gY);
        if (C0424hN.f2761O.m1996T()) {
            C0381gX c0381gX = new C0381gX(random, z);
            c0381gX.m1833S();
            f2826N.add(c0381gX);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0447hk
    /* JADX INFO: renamed from: a */
    public void mo1838a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0447hk
    /* JADX INFO: renamed from: a */
    public boolean mo1839a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        if (!itemDisplayContext.firstPerson() || (InterfaceC1294xq.m7919a(geoBone) & 32) == 0 || z) {
            return false;
        }
        Vector3f vector3fPosition = ((GeoCube) geoBone.getCubes().getFirst()).quads()[0].vertices()[0].position();
        poseStack.pushPose();
        poseStack.translate(vector3fPosition.x, vector3fPosition.y, vector3fPosition.z);
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0f));
        Iterator<C0382gY> it = f2825M.iterator();
        while (it.hasNext()) {
            it.next().m1837c(poseStack, guiGraphics, f3);
        }
        Iterator<C0381gX> it2 = f2826N.iterator();
        while (it2.hasNext()) {
            it2.next().m1834a(poseStack, guiGraphics, f, f3);
        }
        poseStack.popPose();
        return true;
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
