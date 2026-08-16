package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import javax.annotation.Nonnull;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cv.class */
public class C0194cv extends AbstractC0195cw {

    /* JADX INFO: renamed from: eP */
    private static final int f1570eP = 16;

    /* JADX INFO: renamed from: eQ */
    private static final int f1571eQ = 128;

    /* JADX INFO: renamed from: y */
    @Nonnull
    public static final ObjectList<C0191cs.b> f1564y = new ObjectArrayList();

    /* JADX INFO: renamed from: z */
    @Nonnull
    public static final ObjectList<a> f1565z = new ObjectArrayList();

    /* JADX INFO: renamed from: aA */
    @Nonnull
    private static final ResourceLocation f1566aA = C0532jO.m2378d("textures/gui/overlay/bloodoverlay.png");

    /* JADX INFO: renamed from: aB */
    @Nonnull
    private static final ResourceLocation f1567aB = C0532jO.m2378d("textures/gui/overlay/tunnelvision.png");

    /* JADX INFO: renamed from: aC */
    @Nonnull
    private static final ResourceLocation f1568aC = C0532jO.m2378d("textures/misc/muzzleflash/whiteflash_big.png");

    /* JADX INFO: renamed from: aD */
    @Nonnull
    private static final ResourceLocation f1569aD = C0532jO.m2378d("textures/gui/overlay/damage.png");

    /* JADX INFO: renamed from: j */
    @Nonnull
    private static final Vec3 f1572j = new Vec3(94.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: a */
    private static void m1225a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull LocalPlayer localPlayer, int i, int i2, float f) {
        if (C0495ie.f3035o.m2230U()) {
            float f2 = -localPlayer.getViewYRot(f);
            ObjectListIterator it = f1565z.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                float fM1230a = 180.0f + aVar.m1230a(localPlayer, f) + f2;
                Vec3 vec3YRot = f1572j.yRot((float) Math.toRadians(-fM1230a));
                C0129bt.m544b(poseStack, guiGraphics, f1569aD, (float) (((double) (i / 2.0f)) + vec3YRot.x), (float) (((double) (i2 / 2.0f)) + vec3YRot.z), 16.0f, 128.0f, 90.0f + fM1230a, aVar.m1231g(f));
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m1226d(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        ObjectListIterator it = f1564y.iterator();
        while (it.hasNext()) {
            ((C0191cs.b) it.next()).m1220c(poseStack, guiGraphics, i, i2, f);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1227a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2, float f3, float f4) {
        if (C0495ie.f3043w.m2230U()) {
            C0129bt.m535a(poseStack, guiGraphics, f1566aA, 0, 0, i, i2, 0.0f, C1270xJ.m7170f(C0116bg.f794cf, C0116bg.f795cg, f4));
            if (f <= 8.0f) {
                C0129bt.m535a(poseStack, guiGraphics, f1566aA, 0, 0, i, i2, 0.0f, (0.5f - (0.1f * Mth.sin(f3 / 5.0f))) * (1.0f - f2));
            }
        }
        C0129bt.m535a(poseStack, guiGraphics, f1567aB, 0, 0, i, i2, 0.0f, C1270xJ.m7170f(C0116bg.f796ch, C0116bg.f797ci, f4));
    }

    /* JADX INFO: renamed from: a */
    private void m1228a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        if (!C0495ie.f3059L.m2230U() || !minecraft.options.getCameraType().isFirstPerson()) {
            return;
        }
        int i3 = i / 2;
        int i4 = i2 / 2;
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        Item item = mainHandItem.getItem();
        if (item instanceof C1117uP) {
            C1188vh c1188vhM6296a = ((C1117uP) item).m6296a(mainHandItem);
            int i5 = C1117uP.f6063il ? 0 : 1;
            int i6 = (i3 / 4) * i5;
            int i7 = (i4 / 4) * i5;
            if (!minecraft.getDebugOverlay().showDebugScreen()) {
                if (C1117uP.f6058ua <= 0) {
                    return;
                }
                if (C1117uP.f6063il && c1188vhM6296a.f6462go != null) {
                    return;
                }
            }
            C0129bt.m545b(poseStack, guiGraphics, f1568aC, i3 + i6, i4 + i7, C0966rY.f5366rI, C0966rY.f5366rI, 0.0f, 0.5f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0195cw
    /* JADX INFO: renamed from: a */
    public void mo1214a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0623l c0623l) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        float fM466g = C0129bt.m466g();
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        float maxHealth = localPlayer.getMaxHealth();
        float health = localPlayer.getHealth();
        float f = health / maxHealth;
        float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
        m1225a(poseStackPose, guiGraphics, localPlayer, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        m1228a(minecraft, localPlayer, poseStackPose, guiGraphics, iGuiWidth, iGuiHeight);
        m1226d(poseStackPose, guiGraphics, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        m1227a(poseStackPose, guiGraphics, iGuiWidth, iGuiHeight, health, f, fM466g, gameTimeDeltaPartialTick);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.cv$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cv$a.class */
    public static class a {

        /* JADX INFO: renamed from: k */
        private final Vec3 f1573k;

        /* JADX INFO: renamed from: aI */
        private float f1574aI;

        /* JADX INFO: renamed from: aJ */
        private float f1575aJ;

        public a(float f, Vec3 vec3) {
            this.f1574aI = f;
            this.f1575aJ = f;
            this.f1573k = vec3;
        }

        /* JADX INFO: renamed from: l */
        public boolean m1229l() {
            this.f1575aJ = this.f1574aI;
            this.f1574aI -= 0.05f;
            return this.f1574aI + this.f1575aJ <= 0.0f;
        }

        /* JADX INFO: renamed from: a */
        public float m1230a(LocalPlayer localPlayer, float f) {
            return C1270xJ.m7181b(localPlayer.getPosition(f), this.f1573k);
        }

        /* JADX INFO: renamed from: g */
        public float m1231g(float f) {
            return C1270xJ.m7170f(this.f1574aI, this.f1575aJ, f);
        }
    }
}
