package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC1140um;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
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
import software.bernie.geckolib.cache.object.GeoCube;

/* JADX INFO: renamed from: com.boehmod.blockfront.hx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hx.class */
public class C0461hx<T extends AbstractC1140um<T>> extends AbstractC0412hA<T> {

    /* JADX INFO: renamed from: cS */
    @NotNull
    private static final ResourceLocation f2879cS = C0532jO.m2378d("textures/misc/muzzleflash/whiteflash.png");

    /* JADX INFO: renamed from: R */
    @NotNull
    public static final List<ResourceLocation> f2880R = new ObjectArrayList();

    /* JADX INFO: renamed from: S */
    @NotNull
    public static final List<C0036aF.a> f2881S = new ObjectArrayList();

    /* JADX INFO: renamed from: cI */
    boolean f2882cI;

    static {
        for (int i = 0; i <= 3; i++) {
            f2880R.add(C0532jO.m2378d("textures/misc/muzzleflash/flash" + i + ".png"));
        }
    }

    public C0461hx(C0450hm<T> c0450hm) {
        super(c0450hm);
        this.f2882cI = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public void mo1953a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0412hA
    /* JADX INFO: renamed from: a */
    public boolean mo1954a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        if (itemDisplayContext == ItemDisplayContext.GUI || itemDisplayContext == ItemDisplayContext.GROUND || (InterfaceC1274xN.m7246a(geoBone) & 4096) == 0 || z || !(t instanceof C1117uP)) {
            return false;
        }
        C1117uP c1117uP = (C1117uP) t;
        Vector3f vector3fPosition = ((GeoCube) geoBone.getCubes().getFirst()).quads()[0].vertices()[0].position();
        boolean zFirstPerson = itemDisplayContext.firstPerson();
        float fM6359bB = c1117uP.m6359bB();
        if (!zFirstPerson) {
            RenderSystem.enableDepthTest();
        }
        poseStack.pushPose();
        poseStack.translate(vector3fPosition.x, vector3fPosition.y, vector3fPosition.z);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, -0.1f);
        if (this.f2882cI) {
            C0129bt.m544b(poseStack, guiGraphics, f2880R.get(C0113bd.f768bZ), 0.0f, 0.0f, fM6359bB, fM6359bB, 0.0f, f);
        }
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0f));
        poseStack.translate(0.0f, 0.0f, 0.2f);
        if (zFirstPerson) {
            Iterator<C0036aF.a> it = f2881S.iterator();
            while (it.hasNext()) {
                it.next().mo204a(poseStack, guiGraphics, f, f3, f2, fM6359bB);
            }
        }
        if (this.f2882cI) {
            poseStack.translate(0.0f, 0.0f, -0.1f);
            C0129bt.m544b(poseStack, guiGraphics, f2880R.get(C0113bd.f768bZ), 0.0f, 0.0f, fM6359bB, fM6359bB, 0.0f, f);
            if (zFirstPerson) {
                poseStack.translate(0.0f, 0.0f, -0.1f);
                C0129bt.m544b(poseStack, guiGraphics, f2879cS, 0.0f, 0.0f, 4.0f * fM6359bB, 4.0f * fM6359bB, 0.0f, 0.5f * f);
            }
        }
        poseStack.popPose();
        poseStack.popPose();
        RenderSystem.disableDepthTest();
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
        boolean zM6278g;
        if (itemDisplayContext.firstPerson()) {
            zM6278g = C1117uP.f6058ua > 0;
        } else {
            zM6278g = C1117uP.m6278g(itemStack);
        }
        this.f2882cI = minecraft.getDebugOverlay().showDebugScreen() || (C0495ie.f3059L.m2230U() && zM6278g);
        if (((!C1117uP.f6063il || (c1188vh != null && c1188vh.f6462go == null)) && this.f2882cI) || minecraft.getDebugOverlay().showDebugScreen()) {
            mutableInt.setValue(15728880);
            return false;
        }
        return false;
    }
}
