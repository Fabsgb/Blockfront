package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Iterator;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.ck, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ck.class */
public final class C0067ck extends AbstractC0070cn {
    private static final float dw = 3.2f;
    private static final float dx = 3.0f;
    private static final float dy = 4.0f;
    private static final ResourceLocation aw = C0265jv.d("textures/misc/hitmarker.png");
    private static final ResourceLocation ax = ResourceLocation.withDefaultNamespace("textures/misc/spyglass_scope.png");
    private static final ResourceLocation ay = C0265jv.d("textures/misc/sights/scope_bg.png");
    private static final ResourceLocation az = C0265jv.d("textures/misc/sights/scope_bg_blur.png");
    public static int r = 0;
    public static boolean aS = false;

    @Override // com.boehmod.blockfront.AbstractC0070cn
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0297l c0297l) {
        LocalPlayer localPlayer;
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.options.hideGui || (localPlayer = minecraft.player) == null) {
            return;
        }
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (mainHandItem.isEmpty()) {
            return;
        }
        float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
        if (mainHandItem.getItem() instanceof InterfaceC0538ty) {
            fV fVVar = (fV) c0297l.a();
            boolean zA = oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) fVVar.a(minecraft));
            if (!c0297l.m602a().ay() && !zA) {
                a(minecraft, fVVar, c0297l, mainHandItem, guiGraphics, gameTimeDeltaPartialTick, guiGraphics.guiWidth(), guiGraphics.guiHeight());
            }
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @NotNull ItemStack itemStack, @NotNull GuiGraphics guiGraphics, float f, int i, int i2) {
        PoseStack poseStackPose = guiGraphics.pose();
        int iGuiWidth = guiGraphics.guiWidth() / 2;
        int iGuiHeight = guiGraphics.guiHeight() / 2;
        poseStackPose.pushPose();
        boolean z = true;
        fT fTVarA = fVVar.a(minecraft);
        if (hN.h.T() && !C0558ur.hR) {
            Vec2 vec2A = C0634xm.a(C0027ay.f53a, C0027ay.b, f);
            poseStackPose.translate((-vec2A.y) * dw, 0.0f, 0.0f);
            poseStackPose.translate(0.0f, (-vec2A.x) * dw, 0.0f);
        }
        float fE = C0634xm.e(tD.ms, tD.mt, f);
        if (fTVarA.dk()) {
            z = false;
        }
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer != null && localPlayer.isUsingItem() && localPlayer.getUseItem().is(wY.y)) {
            z = false;
        }
        Item item = itemStack.getItem();
        if (item instanceof C0558ur) {
            C0558ur c0558ur = (C0558ur) item;
            if (C0558ur.hR && !hN.f151c.T()) {
                z = false;
            }
            uH uHVarM1208a = c0558ur.m1208a(itemStack);
            if (C0558ur.hR && minecraft.screen == null && uHVarM1208a.go != null) {
                a(guiGraphics, f, i, i2, poseStackPose, iGuiWidth, iGuiHeight, uHVarM1208a);
                z = false;
            }
            if (!uHVarM1208a.iz) {
                z = false;
            }
        }
        poseStackPose.pushPose();
        A a = c0297l.m585a().a(hN.f149a.q());
        if (hN.f150b.T() && z && minecraft.screen == null) {
            float fE2 = (hN.f.T() ? 0.0f : 3.0f * fE) + (C0634xm.e(aU.bz, aU.bA, f) * 4.0f);
            float f2 = iGuiWidth;
            float f3 = iGuiHeight;
            C0040bk.a(poseStackPose, guiGraphics, a, f2, f3, hN.f153a.N() * Mth.clamp(1.0f - (Mth.clamp(((C0634xm.e(aU.br, aU.bs, f) + C0634xm.e(aU.bp, aU.bq, f)) + C0634xm.e(aU.bx, aU.by, f)) + C0634xm.e(aU.bt, aU.bu, f), 0.0f, 1.0f) * 2.0f), 0.0f, 1.0f), hN.f152d.T(), hN.e.T(), fE2);
            if ((itemStack.getItem() instanceof tI) && minecraft.player != null) {
                C0040bk.a(minecraft, poseStackPose, guiGraphics, minecraft.player, iGuiWidth, iGuiHeight + (fE2 < 15.0f ? fE2 : 0.0f));
            }
        }
        if (r > 0) {
            poseStackPose.pushPose();
            C0040bk.c(poseStackPose, guiGraphics, aw, iGuiWidth, iGuiHeight, 17.0f, 17.0f, Math.min(0.75f * r, 1.0f), 1.0f, aS ? 13846343 : ColorReferences.COLOR_WHITE);
            poseStackPose.popPose();
        }
        poseStackPose.popPose();
        poseStackPose.popPose();
    }

    private static void a(@NotNull GuiGraphics guiGraphics, float f, int i, int i2, PoseStack poseStack, int i3, int i4, uH uHVar) {
        if (uHVar.go == null) {
            return;
        }
        int iMin = Math.min(i2, i);
        boolean z = iMin == i;
        poseStack.pushPose();
        float fClamp = Mth.clamp(C0634xm.e(aU.bB, aU.bD, f), -25.0f, 25.0f);
        float fClamp2 = Mth.clamp(C0634xm.e(aU.bC, aU.bE, f), -25.0f, 25.0f);
        Vector3f vector3fMul = hE.a(f).mul(2.0f);
        float f2 = i3 + fClamp2 + ((-6.0f) * vector3fMul.x);
        float f3 = i4 + fClamp + ((-6.0f) * vector3fMul.y);
        float f4 = ((-(fClamp + fClamp2)) * 0.2f) - vector3fMul.z;
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        Iterator<AbstractC0075cs> it = aU.k.iterator();
        while (it.hasNext()) {
            it.next().a(poseStack, guiGraphics, f);
        }
        poseStack.popPose();
        C0040bk.b(poseStack, guiGraphics, uHVar.go, f2, f3, iMin, iMin, f4);
        C0040bk.b(poseStack, guiGraphics, ax, f2, f3, iMin, iMin, f4, 1.0f);
        C0040bk.b(poseStack, guiGraphics, ay, f2, f3, iMin * 1.5f, iMin * 1.5f, f4, 1.0f);
        C0040bk.b(poseStack, guiGraphics, az, f2 + (fClamp2 * 6.0f), f3 + (fClamp * 6.0f), iMin * 3, iMin * 3, f4, 1.0f);
        if (z) {
            int i5 = (i2 - iMin) / 2;
            C0040bk.a(guiGraphics, 0, 0, i, i5, ColorReferences.COLOR_BLACK_SOLID);
            C0040bk.a(guiGraphics, 0, i5 + iMin, i, i5 + 1, ColorReferences.COLOR_BLACK_SOLID);
        } else {
            int i6 = (i - iMin) / 2;
            C0040bk.a(guiGraphics, 0, 0, i6 + 5, i2, ColorReferences.COLOR_BLACK_SOLID);
            C0040bk.a(guiGraphics, (i6 + iMin) - 5, 0, i6 + 10, i2, ColorReferences.COLOR_BLACK_SOLID);
        }
        poseStack.popPose();
    }
}
