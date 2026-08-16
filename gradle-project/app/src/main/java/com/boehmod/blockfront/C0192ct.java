package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ct */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ct.class */
public final class C0192ct extends AbstractC0195cw {

    /* JADX INFO: renamed from: dC */
    private static final float f1550dC = 3.2f;

    /* JADX INFO: renamed from: dD */
    private static final float f1551dD = 3.0f;

    /* JADX INFO: renamed from: dE */
    private static final float f1552dE = 4.0f;

    /* JADX INFO: renamed from: aw */
    private static final ResourceLocation f1546aw = C0532jO.m2378d("textures/misc/hitmarker.png");

    /* JADX INFO: renamed from: ax */
    private static final ResourceLocation f1547ax = ResourceLocation.withDefaultNamespace("textures/misc/spyglass_scope.png");

    /* JADX INFO: renamed from: ay */
    private static final ResourceLocation f1548ay = C0532jO.m2378d("textures/misc/sights/scope_bg.png");

    /* JADX INFO: renamed from: az */
    private static final ResourceLocation f1549az = C0532jO.m2378d("textures/misc/sights/scope_bg_blur.png");

    /* JADX INFO: renamed from: t */
    public static int f1553t = 0;

    /* JADX INFO: renamed from: aX */
    public static boolean f1554aX = false;

    @Override // com.boehmod.blockfront.AbstractC0195cw
    /* JADX INFO: renamed from: a */
    public void mo1214a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0623l c0623l) {
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
        if (mainHandItem.getItem() instanceof InterfaceC1071tW) {
            C0396gl c0396gl = (C0396gl) c0623l.m2855a();
            boolean zM4488a = C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) c0396gl.m1885a(minecraft));
            if (!c0623l.m2895a().m3074aJ() && !zM4488a) {
                m1222a(minecraft, c0396gl, c0623l, mainHandItem, guiGraphics, gameTimeDeltaPartialTick, guiGraphics.guiWidth(), guiGraphics.guiHeight());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1222a(@NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @NotNull ItemStack itemStack, @NotNull GuiGraphics guiGraphics, float f, int i, int i2) {
        PoseStack poseStackPose = guiGraphics.pose();
        int iGuiWidth = guiGraphics.guiWidth() / 2;
        int iGuiHeight = guiGraphics.guiHeight() / 2;
        poseStackPose.pushPose();
        boolean z = true;
        C0394gj c0394gjM1885a = c0396gl.m1885a(minecraft);
        if (C0495ie.f3028h.m2230U() && !C1117uP.f6063il) {
            Vec2 vec2M7173a = C1270xJ.m7173a(C0036aF.f314a, C0036aF.f315b, f);
            poseStackPose.translate((-vec2M7173a.y) * f1550dC, 0.0f, 0.0f);
            poseStackPose.translate(0.0f, (-vec2M7173a.x) * f1550dC, 0.0f);
        }
        float fM7170f = C1270xJ.m7170f(C1129ub.f6190nr, C1129ub.f6191ns, f);
        if (c0394gjM1885a.m1104dt()) {
            z = false;
        }
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer != null && localPlayer.isUsingItem() && localPlayer.getUseItem().is(C1308xv.f7693y)) {
            z = false;
        }
        Item item = itemStack.getItem();
        if (item instanceof C1117uP) {
            C1117uP c1117uP = (C1117uP) item;
            if (C1117uP.f6063il && !C0495ie.f3020c.m2230U()) {
                z = false;
            }
            C1188vh c1188vhM6296a = c1117uP.m6296a(itemStack);
            if (C1117uP.f6063il && minecraft.screen == null && c1188vhM6296a.f6462go != null) {
                m1223a(guiGraphics, f, i, i2, poseStackPose, iGuiWidth, iGuiHeight, c1188vhM6296a);
                z = false;
            }
            if (!c1188vhM6296a.f6461iT) {
                z = false;
            }
        }
        poseStackPose.pushPose();
        C0010G c0010gA = c0623l.m2867a().m2794a(C0495ie.f3018a.m2247u());
        if (C0495ie.f3019b.m2230U() && z && minecraft.screen == null) {
            float fM7170f2 = (C0495ie.f3023f.m2230U() ? 0.0f : 3.0f * fM7170f) + (C1270xJ.m7170f(C0112bc.f748bF, C0112bc.f749bG, f) * 4.0f);
            float f2 = iGuiWidth;
            float f3 = iGuiHeight;
            C0129bt.m637a(poseStackPose, guiGraphics, c0010gA, f2, f3, C0495ie.f3025a.m2223N() * Mth.clamp(1.0f - (Mth.clamp(((C1270xJ.m7170f(C0112bc.f739bx, C0112bc.f740by, f) + C1270xJ.m7170f(C0112bc.f737bv, C0112bc.f738bw, f)) + C1270xJ.m7170f(C0112bc.f746bD, C0112bc.f747bE, f)) + C1270xJ.m7170f(C0112bc.f741bz, C0112bc.f742bA, f), 0.0f, 1.0f) * 2.0f), 0.0f, 1.0f), C0495ie.f3021d.m2230U(), C0495ie.f3022e.m2230U(), fM7170f2);
            if ((itemStack.getItem() instanceof C1134ug) && minecraft.player != null) {
                C0129bt.m639a(minecraft, poseStackPose, guiGraphics, minecraft.player, iGuiWidth, iGuiHeight + (fM7170f2 < 15.0f ? fM7170f2 : 0.0f));
            }
        }
        if (f1553t > 0) {
            poseStackPose.pushPose();
            C0129bt.m550c(poseStackPose, guiGraphics, f1546aw, iGuiWidth, iGuiHeight, 17.0f, 17.0f, Math.min(0.75f * f1553t, 1.0f), 1.0f, f1554aX ? 13846343 : ColorReferences.COLOR_WHITE);
            poseStackPose.popPose();
        }
        poseStackPose.popPose();
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    private static void m1223a(@NotNull GuiGraphics guiGraphics, float f, int i, int i2, PoseStack poseStack, int i3, int i4, C1188vh c1188vh) {
        if (c1188vh.f6462go == null) {
            return;
        }
        int iMin = Math.min(i2, i);
        boolean z = iMin == i;
        poseStack.pushPose();
        float fClamp = Mth.clamp(C1270xJ.m7170f(C0112bc.f750bH, C0112bc.f752bJ, f), -25.0f, 25.0f);
        float fClamp2 = Mth.clamp(C1270xJ.m7170f(C0112bc.f751bI, C0112bc.f753bK, f), -25.0f, 25.0f);
        Vector3f vector3fMul = C0432hU.m1991a(f).mul(2.0f);
        float f2 = i3 + fClamp2 + ((-6.0f) * vector3fMul.x);
        float f3 = i4 + fClamp + ((-6.0f) * vector3fMul.y);
        float f4 = ((-(fClamp + fClamp2)) * 0.2f) - vector3fMul.z;
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        Iterator<AbstractC0138cB> it = C0112bc.f720l.iterator();
        while (it.hasNext()) {
            it.next().mo768a(poseStack, guiGraphics, f);
        }
        poseStack.popPose();
        C0129bt.m542b(poseStack, guiGraphics, c1188vh.f6462go, f2, f3, iMin, iMin, f4);
        C0129bt.m544b(poseStack, guiGraphics, f1547ax, f2, f3, iMin, iMin, f4, 1.0f);
        C0129bt.m544b(poseStack, guiGraphics, f1548ay, f2, f3, iMin * 1.5f, iMin * 1.5f, f4, 1.0f);
        C0129bt.m544b(poseStack, guiGraphics, f1549az, f2 + (fClamp2 * 6.0f), f3 + (fClamp * 6.0f), iMin * 3, iMin * 3, f4, 1.0f);
        if (z) {
            int i5 = (i2 - iMin) / 2;
            C0129bt.m515a(guiGraphics, 0, 0, i, i5, ColorReferences.COLOR_BLACK_SOLID);
            C0129bt.m515a(guiGraphics, 0, i5 + iMin, i, i5 + 1, ColorReferences.COLOR_BLACK_SOLID);
        } else {
            int i6 = (i - iMin) / 2;
            C0129bt.m515a(guiGraphics, 0, 0, i6 + 5, i2, ColorReferences.COLOR_BLACK_SOLID);
            C0129bt.m515a(guiGraphics, (i6 + iMin) - 5, 0, i6 + 10, i2, ColorReferences.COLOR_BLACK_SOLID);
        }
        poseStack.popPose();
    }
}
