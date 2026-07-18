package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC1062tO;
import com.boehmod.blockfront.C0080ay;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.hh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hh.class */
public class C0444hh<T extends AbstractC1062tO<T>> extends AbstractC0447hk<T> {

    /* JADX INFO: renamed from: cS */
    @NotNull
    private static final ResourceLocation f2827cS = C0564jv.m2555d("textures/misc/muzzleflash/whiteflash.png");

    /* JADX INFO: renamed from: O */
    @NotNull
    public static final List<ResourceLocation> f2828O = new ObjectArrayList();

    /* JADX INFO: renamed from: P */
    @NotNull
    public static final List<C0080ay.a> f2829P = new ObjectArrayList();

    /* JADX INFO: renamed from: cz */
    boolean f2830cz;

    static {
        for (int i = 0; i <= 3; i++) {
            f2828O.add(C0564jv.m2555d("textures/misc/muzzleflash/flash" + i + ".png"));
        }
    }

    public C0444hh(C0380gW<T> c0380gW) {
        super(c0380gW);
        this.f2830cz = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0447hk
    /* JADX INFO: renamed from: a */
    public void mo1838a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0447hk
    /* JADX INFO: renamed from: a */
    public boolean mo1839a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        if (itemDisplayContext == ItemDisplayContext.GUI || itemDisplayContext == ItemDisplayContext.GROUND || (InterfaceC1294xq.m7919a(geoBone) & 4096) == 0 || z || !(t instanceof C1144ur)) {
            return false;
        }
        C1144ur c1144ur = (C1144ur) t;
        Vector3f vector3fPosition = ((GeoCube) geoBone.getCubes().getFirst()).quads()[0].vertices()[0].position();
        boolean zFirstPerson = itemDisplayContext.firstPerson();
        float fM6384bv = c1144ur.m6384bv();
        if (!zFirstPerson) {
            RenderSystem.enableDepthTest();
        }
        poseStack.pushPose();
        poseStack.translate(vector3fPosition.x, vector3fPosition.y, vector3fPosition.z);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, -0.1f);
        if (this.f2830cz) {
            C0119bk.m444b(poseStack, guiGraphics, f2828O.get(C0051aV.f354bj), 0.0f, 0.0f, fM6384bv, fM6384bv, 0.0f, f);
        }
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0f));
        poseStack.translate(0.0f, 0.0f, 0.2f);
        if (zFirstPerson) {
            Iterator<C0080ay.a> it = f2829P.iterator();
            while (it.hasNext()) {
                it.next().mo277a(poseStack, guiGraphics, f, f3, f2, fM6384bv);
            }
        }
        if (this.f2830cz) {
            poseStack.translate(0.0f, 0.0f, -0.1f);
            C0119bk.m444b(poseStack, guiGraphics, f2828O.get(C0051aV.f354bj), 0.0f, 0.0f, fM6384bv, fM6384bv, 0.0f, f);
            if (zFirstPerson) {
                poseStack.translate(0.0f, 0.0f, -0.1f);
                C0119bk.m444b(poseStack, guiGraphics, f2827cS, 0.0f, 0.0f, 4.0f * fM6384bv, 4.0f * fM6384bv, 0.0f, 0.5f * f);
            }
        }
        poseStack.popPose();
        poseStack.popPose();
        RenderSystem.disableDepthTest();
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
        this.f2830cz = minecraft.getDebugOverlay().showDebugScreen() || (C0424hN.f2758L.m1996T() && (itemDisplayContext.firstPerson() ? C1144ur.f5989rU > 0 : C1144ur.m6313g(itemStack)));
        if (((!C1144ur.f5994hR || (c1108uH != null && c1108uH.f5823go == null)) && this.f2830cz) || minecraft.getDebugOverlay().showDebugScreen()) {
            mutableInt.setValue(15728880);
            return false;
        }
        return false;
    }
}
