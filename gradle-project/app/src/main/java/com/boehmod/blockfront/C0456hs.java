package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC1140um;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.hs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hs.class */
public class C0456hs<T extends AbstractC1140um<T>> extends AbstractC0412hA<T> {

    /* JADX INFO: renamed from: P */
    @NotNull
    private static final List<C0452ho> f2877P = new ObjectArrayList();

    /* JADX INFO: renamed from: Q */
    @NotNull
    private static final List<C0451hn> f2878Q = new ObjectArrayList();

    public C0456hs(@NotNull C0450hm<T> c0450hm) {
        super(c0450hm);
    }

    /* JADX INFO: renamed from: aU */
    public static void m2094aU() {
        f2877P.removeIf((v0) -> {
            return v0.m2091T();
        });
        f2878Q.removeIf((v0) -> {
            return v0.m2089T();
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m2095a(@NotNull Random random, @NotNull String str, boolean z) {
        C0452ho c0452ho = new C0452ho(new Vector2f(1.0f, (-1.0f) + ((-0.2f) * random.nextFloat())), str, z);
        c0452ho.m2091T();
        f2877P.add(c0452ho);
        if (C0495ie.f3062O.m2230U()) {
            C0451hn c0451hn = new C0451hn(random, z);
            c0451hn.m2089T();
            f2878Q.add(c0451hn);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public void mo1953a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1954a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        if (!itemDisplayContext.firstPerson() || (InterfaceC1274xN.m7246a(geoBone) & 32) == 0 || z) {
            return false;
        }
        Vector3f vector3fPosition = ((GeoCube) geoBone.getCubes().getFirst()).quads()[0].vertices()[0].position();
        poseStack.pushPose();
        poseStack.translate(vector3fPosition.x, vector3fPosition.y, vector3fPosition.z);
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0f));
        Iterator<C0452ho> it = f2877P.iterator();
        while (it.hasNext()) {
            it.next().m2093c(poseStack, guiGraphics, f3);
        }
        Iterator<C0451hn> it2 = f2878Q.iterator();
        while (it2.hasNext()) {
            it2.next().m2090a(poseStack, guiGraphics, f, f3);
        }
        poseStack.popPose();
        return true;
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
