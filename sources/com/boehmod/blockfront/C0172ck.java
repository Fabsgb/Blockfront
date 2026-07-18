package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0182b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ck */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ck.class */
public final class C0172ck extends AbstractC0179cn {

    /* JADX INFO: renamed from: dw */
    private static final float f1426dw = 3.2f;

    /* JADX INFO: renamed from: dx */
    private static final float f1427dx = 3.0f;

    /* JADX INFO: renamed from: dy */
    private static final float f1428dy = 4.0f;

    /* JADX INFO: renamed from: aw */
    private static final ResourceLocation f1422aw = C0564jv.m2555d("textures/misc/hitmarker.png");

    /* JADX INFO: renamed from: ax */
    private static final ResourceLocation f1423ax = ResourceLocation.withDefaultNamespace("textures/misc/spyglass_scope.png");

    /* JADX INFO: renamed from: ay */
    private static final ResourceLocation f1424ay = C0564jv.m2555d("textures/misc/sights/scope_bg.png");

    /* JADX INFO: renamed from: az */
    private static final ResourceLocation f1425az = C0564jv.m2555d("textures/misc/sights/scope_bg_blur.png");

    /* JADX INFO: renamed from: r */
    public static int f1429r = 0;

    /* JADX INFO: renamed from: aS */
    public static boolean f1430aS = false;

    @Override // com.boehmod.blockfront.AbstractC0179cn
    /* JADX INFO: renamed from: a */
    public void mo1027a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0622l c0622l) {
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
        if (mainHandItem.getItem() instanceof InterfaceC1098ty) {
            C0326fV c0326fV = (C0326fV) c0622l.m2670a();
            boolean zM4052a = C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) c0326fV.m1675a(minecraft));
            if (!c0622l.m2709a().m3241ay() && !zM4052a) {
                m1034a(minecraft, c0326fV, c0622l, mainHandItem, guiGraphics, gameTimeDeltaPartialTick, guiGraphics.guiWidth(), guiGraphics.guiHeight());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1034a(@NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0622l c0622l, @NotNull ItemStack itemStack, @NotNull GuiGraphics guiGraphics, float f, int i, int i2) {
        PoseStack poseStackPose = guiGraphics.pose();
        int iGuiWidth = guiGraphics.guiWidth() / 2;
        int iGuiHeight = guiGraphics.guiHeight() / 2;
        poseStackPose.pushPose();
        boolean z = true;
        C0324fT c0324fTM1675a = c0326fV.m1675a(minecraft);
        if (C0424hN.f2727h.m1996T() && !C1144ur.f5994hR) {
            Vec2 vec2M7846a = C1290xm.m7846a(C0080ay.f492a, C0080ay.f493b, f);
            poseStackPose.translate((-vec2M7846a.y) * f1426dw, 0.0f, 0.0f);
            poseStackPose.translate(0.0f, (-vec2M7846a.x) * f1426dw, 0.0f);
        }
        float fM7843e = C1290xm.m7843e(C1051tD.f5551ms, C1051tD.f5552mt, f);
        if (c0324fTM1675a.m1087dk()) {
            z = false;
        }
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer != null && localPlayer.isUsingItem() && localPlayer.getUseItem().is(C1231wY.f7128y)) {
            z = false;
        }
        Item item = itemStack.getItem();
        if (item instanceof C1144ur) {
            C1144ur c1144ur = (C1144ur) item;
            if (C1144ur.f5994hR && !C0424hN.f2719c.m1996T()) {
                z = false;
            }
            C1108uH c1108uHM6329a = c1144ur.m6329a(itemStack);
            if (C1144ur.f5994hR && minecraft.screen == null && c1108uHM6329a.f5823go != null) {
                m1035a(guiGraphics, f, i, i2, poseStackPose, iGuiWidth, iGuiHeight, c1108uHM6329a);
                z = false;
            }
            if (!c1108uHM6329a.f5822iz) {
                z = false;
            }
        }
        poseStackPose.pushPose();
        C0003A c0003aA = c0622l.m2681a().m2435a(C0424hN.f2717a.m2013q());
        if (C0424hN.f2718b.m1996T() && z && minecraft.screen == null) {
            float fM7843e2 = (C0424hN.f2722f.m1996T() ? 0.0f : 3.0f * fM7843e) + (C1290xm.m7843e(C0050aU.f334bz, C0050aU.f335bA, f) * 4.0f);
            float f2 = iGuiWidth;
            float f3 = iGuiHeight;
            C0119bk.m534a(poseStackPose, guiGraphics, c0003aA, f2, f3, C0424hN.f2724a.m1992N() * Mth.clamp(1.0f - (Mth.clamp(((C1290xm.m7843e(C0050aU.f325br, C0050aU.f326bs, f) + C1290xm.m7843e(C0050aU.f323bp, C0050aU.f324bq, f)) + C1290xm.m7843e(C0050aU.f332bx, C0050aU.f333by, f)) + C1290xm.m7843e(C0050aU.f327bt, C0050aU.f328bu, f), 0.0f, 1.0f) * 2.0f), 0.0f, 1.0f), C0424hN.f2720d.m1996T(), C0424hN.f2721e.m1996T(), fM7843e2);
            if ((itemStack.getItem() instanceof C1056tI) && minecraft.player != null) {
                C0119bk.m536a(minecraft, poseStackPose, guiGraphics, minecraft.player, iGuiWidth, iGuiHeight + (fM7843e2 < 15.0f ? fM7843e2 : 0.0f));
            }
        }
        if (f1429r > 0) {
            poseStackPose.pushPose();
            C0119bk.m450c(poseStackPose, guiGraphics, f1422aw, iGuiWidth, iGuiHeight, 17.0f, 17.0f, Math.min(0.75f * f1429r, 1.0f), 1.0f, f1430aS ? 13846343 : ColorReferences.COLOR_WHITE);
            poseStackPose.popPose();
        }
        poseStackPose.popPose();
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    private static void m1035a(@NotNull GuiGraphics guiGraphics, float f, int i, int i2, PoseStack poseStack, int i3, int i4, C1108uH c1108uH) {
        if (c1108uH.f5823go == null) {
            return;
        }
        int iMin = Math.min(i2, i);
        boolean z = iMin == i;
        poseStack.pushPose();
        float fClamp = Mth.clamp(C1290xm.m7843e(C0050aU.f336bB, C0050aU.f338bD, f), -25.0f, 25.0f);
        float fClamp2 = Mth.clamp(C1290xm.m7843e(C0050aU.f337bC, C0050aU.f339bE, f), -25.0f, 25.0f);
        Vector3f vector3fMul = C0415hE.m1964a(f).mul(2.0f);
        float f2 = i3 + fClamp2 + ((-6.0f) * vector3fMul.x);
        float f3 = i4 + fClamp + ((-6.0f) * vector3fMul.y);
        float f4 = ((-(fClamp + fClamp2)) * 0.2f) - vector3fMul.z;
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        Iterator<AbstractC0190cs> it = C0050aU.f306k.iterator();
        while (it.hasNext()) {
            it.next().mo1171a(poseStack, guiGraphics, f);
        }
        poseStack.popPose();
        C0119bk.m442b(poseStack, guiGraphics, c1108uH.f5823go, f2, f3, iMin, iMin, f4);
        C0119bk.m444b(poseStack, guiGraphics, f1423ax, f2, f3, iMin, iMin, f4, 1.0f);
        C0119bk.m444b(poseStack, guiGraphics, f1424ay, f2, f3, iMin * 1.5f, iMin * 1.5f, f4, 1.0f);
        C0119bk.m444b(poseStack, guiGraphics, f1425az, f2 + (fClamp2 * 6.0f), f3 + (fClamp * 6.0f), iMin * 3, iMin * 3, f4, 1.0f);
        if (z) {
            int i5 = (i2 - iMin) / 2;
            C0119bk.m415a(guiGraphics, 0, 0, i, i5, ColorReferences.COLOR_BLACK_SOLID);
            C0119bk.m415a(guiGraphics, 0, i5 + iMin, i, i5 + 1, ColorReferences.COLOR_BLACK_SOLID);
        } else {
            int i6 = (i - iMin) / 2;
            C0119bk.m415a(guiGraphics, 0, 0, i6 + 5, i2, ColorReferences.COLOR_BLACK_SOLID);
            C0119bk.m415a(guiGraphics, (i6 + iMin) - 5, 0, i6 + 10, i2, ColorReferences.COLOR_BLACK_SOLID);
        }
        poseStack.popPose();
    }
}
