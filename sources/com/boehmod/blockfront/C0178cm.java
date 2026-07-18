package com.boehmod.blockfront;

import com.boehmod.blockfront.C0171cj;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cm.class */
public class C0178cm extends AbstractC0179cn {

    /* JADX INFO: renamed from: dP */
    private static final int f1463dP = 16;

    /* JADX INFO: renamed from: dQ */
    private static final int f1464dQ = 128;

    /* JADX INFO: renamed from: p */
    @Nonnull
    public static final ObjectList<C0171cj.b> f1457p = new ObjectArrayList();

    /* JADX INFO: renamed from: q */
    @Nonnull
    public static final ObjectList<a> f1458q = new ObjectArrayList();

    /* JADX INFO: renamed from: aA */
    @Nonnull
    private static final ResourceLocation f1459aA = C0564jv.m2555d("textures/gui/overlay/bloodoverlay.png");

    /* JADX INFO: renamed from: aB */
    @Nonnull
    private static final ResourceLocation f1460aB = C0564jv.m2555d("textures/gui/overlay/tunnelvision.png");

    /* JADX INFO: renamed from: aC */
    @Nonnull
    private static final ResourceLocation f1461aC = C0564jv.m2555d("textures/misc/muzzleflash/whiteflash_big.png");

    /* JADX INFO: renamed from: aD */
    @Nonnull
    private static final ResourceLocation f1462aD = C0564jv.m2555d("textures/gui/overlay/damage.png");

    /* JADX INFO: renamed from: j */
    @Nonnull
    private static final Vec3 f1465j = new Vec3(94.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: a */
    private static void m1060a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull LocalPlayer localPlayer, int i, int i2, float f) {
        if (C0424hN.f2734o.m1996T()) {
            float f2 = -localPlayer.getViewYRot(f);
            ObjectListIterator it = f1458q.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                float fM1065a = 180.0f + aVar.m1065a(localPlayer, f) + f2;
                Vec3 vec3YRot = f1465j.yRot((float) Math.toRadians(-fM1065a));
                C0119bk.m444b(poseStack, guiGraphics, f1462aD, (float) (((double) (i / 2.0f)) + vec3YRot.x), (float) (((double) (i2 / 2.0f)) + vec3YRot.z), 16.0f, 128.0f, 90.0f + fM1065a, aVar.m1066g(f));
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m1061d(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        ObjectListIterator it = f1457p.iterator();
        while (it.hasNext()) {
            ((C0171cj.b) it.next()).m1032c(poseStack, guiGraphics, i, i2, f);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1062a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2, float f3, float f4) {
        if (C0424hN.f2742w.m1996T()) {
            C0119bk.m435a(poseStack, guiGraphics, f1459aA, 0, 0, i, i2, 0.0f, C1290xm.m7843e(C0054aY.f380bZ, C0054aY.f381ca, f4));
            if (f <= 8.0f) {
                C0119bk.m435a(poseStack, guiGraphics, f1459aA, 0, 0, i, i2, 0.0f, (0.5f - (0.1f * Mth.sin(f3 / 5.0f))) * (1.0f - f2));
            }
        }
        C0119bk.m435a(poseStack, guiGraphics, f1460aB, 0, 0, i, i2, 0.0f, C1290xm.m7843e(C0054aY.f382cb, C0054aY.f383cc, f4));
    }

    /* JADX INFO: renamed from: a */
    private void m1063a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        if (!C0424hN.f2758L.m1996T() || !minecraft.options.getCameraType().isFirstPerson()) {
            return;
        }
        int i3 = i / 2;
        int i4 = i2 / 2;
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        Item item = mainHandItem.getItem();
        if (item instanceof C1144ur) {
            C1108uH c1108uHM6329a = ((C1144ur) item).m6329a(mainHandItem);
            int i5 = C1144ur.f5994hR ? 0 : 1;
            int i6 = (i3 / 4) * i5;
            int i7 = (i4 / 4) * i5;
            if (!minecraft.getDebugOverlay().showDebugScreen()) {
                if (C1144ur.f5989rU <= 0) {
                    return;
                }
                if (C1144ur.f5994hR && c1108uHM6329a.f5823go != null) {
                    return;
                }
            }
            C0119bk.m445b(poseStack, guiGraphics, f1461aC, i3 + i6, i4 + i7, C0942rB.f5014pJ, C0942rB.f5014pJ, 0.0f, 0.5f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0179cn
    /* JADX INFO: renamed from: a */
    public void mo1027a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0622l c0622l) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        float fM366g = C0119bk.m366g();
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        float maxHealth = localPlayer.getMaxHealth();
        float health = localPlayer.getHealth();
        float f = health / maxHealth;
        float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
        m1060a(poseStackPose, guiGraphics, localPlayer, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        m1063a(minecraft, localPlayer, poseStackPose, guiGraphics, iGuiWidth, iGuiHeight);
        m1061d(poseStackPose, guiGraphics, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        m1062a(poseStackPose, guiGraphics, iGuiWidth, iGuiHeight, health, f, fM366g, gameTimeDeltaPartialTick);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.cm$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cm$a.class */
    public static class a {

        /* JADX INFO: renamed from: k */
        private final Vec3 f1466k;

        /* JADX INFO: renamed from: aD */
        private float f1467aD;

        /* JADX INFO: renamed from: aE */
        private float f1468aE;

        public a(float f, Vec3 vec3) {
            this.f1467aD = f;
            this.f1468aE = f;
            this.f1466k = vec3;
        }

        /* JADX INFO: renamed from: k */
        public boolean m1064k() {
            this.f1468aE = this.f1467aD;
            this.f1467aD -= 0.05f;
            return this.f1467aD + this.f1468aE <= 0.0f;
        }

        /* JADX INFO: renamed from: a */
        public float m1065a(LocalPlayer localPlayer, float f) {
            return C1290xm.m7854a(localPlayer.getPosition(f), this.f1466k);
        }

        /* JADX INFO: renamed from: g */
        public float m1066g(float f) {
            return C1290xm.m7843e(this.f1467aD, this.f1468aE, f);
        }
    }
}
