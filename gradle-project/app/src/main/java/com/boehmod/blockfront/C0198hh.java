package com.boehmod.blockfront;

import com.boehmod.blockfront.C0027ay;
import com.boehmod.blockfront.tO;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.hh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hh.class */
public class C0198hh<T extends tO<T>> extends AbstractC0201hk<T> {

    @NotNull
    private static final ResourceLocation cS = C0265jv.d("textures/misc/muzzleflash/whiteflash.png");

    @NotNull
    public static final List<ResourceLocation> O = new ObjectArrayList();

    @NotNull
    public static final List<C0027ay.a> P = new ObjectArrayList();
    boolean cz;

    static {
        for (int i = 0; i <= 3; i++) {
            O.add(C0265jv.d("textures/misc/muzzleflash/flash" + i + ".png"));
        }
    }

    public C0198hh(gW<T> gWVar) {
        super(gWVar);
        this.cz = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        if (itemDisplayContext == ItemDisplayContext.GUI || itemDisplayContext == ItemDisplayContext.GROUND || (InterfaceC0638xq.a(geoBone) & 4096) == 0 || z || !(t instanceof C0558ur)) {
            return false;
        }
        C0558ur c0558ur = (C0558ur) t;
        Vector3f vector3fPosition = ((GeoCube) geoBone.getCubes().getFirst()).quads()[0].vertices()[0].position();
        boolean zFirstPerson = itemDisplayContext.firstPerson();
        float fBv = c0558ur.bv();
        if (!zFirstPerson) {
            RenderSystem.enableDepthTest();
        }
        poseStack.pushPose();
        poseStack.translate(vector3fPosition.x, vector3fPosition.y, vector3fPosition.z);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, -0.1f);
        if (this.cz) {
            C0040bk.b(poseStack, guiGraphics, O.get(aV.bj), 0.0f, 0.0f, fBv, fBv, 0.0f, f);
        }
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0f));
        poseStack.translate(0.0f, 0.0f, 0.2f);
        if (zFirstPerson) {
            Iterator<C0027ay.a> it = P.iterator();
            while (it.hasNext()) {
                it.next().a(poseStack, guiGraphics, f, f3, f2, fBv);
            }
        }
        if (this.cz) {
            poseStack.translate(0.0f, 0.0f, -0.1f);
            C0040bk.b(poseStack, guiGraphics, O.get(aV.bj), 0.0f, 0.0f, fBv, fBv, 0.0f, f);
            if (zFirstPerson) {
                poseStack.translate(0.0f, 0.0f, -0.1f);
                C0040bk.b(poseStack, guiGraphics, cS, 0.0f, 0.0f, 4.0f * fBv, 4.0f * fBv, 0.0f, 0.5f * f);
            }
        }
        poseStack.popPose();
        poseStack.popPose();
        RenderSystem.disableDepthTest();
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull GeoBone geoBone, @NotNull T t, @NotNull ItemStack itemStack, @NotNull ResourceLocation resourceLocation, @NotNull ItemDisplayContext itemDisplayContext, @NotNull VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull ItemStack itemStack, @NotNull MutableInt mutableInt, @Nullable uH uHVar, @NotNull ItemDisplayContext itemDisplayContext, @NotNull fT fTVar) {
        this.cz = minecraft.getDebugOverlay().showDebugScreen() || (hN.L.T() && (itemDisplayContext.firstPerson() ? C0558ur.rU > 0 : C0558ur.m1204g(itemStack)));
        if (((!C0558ur.hR || (uHVar != null && uHVar.go == null)) && this.cz) || minecraft.getDebugOverlay().showDebugScreen()) {
            mutableInt.setValue(15728880);
            return false;
        }
        return false;
    }
}
