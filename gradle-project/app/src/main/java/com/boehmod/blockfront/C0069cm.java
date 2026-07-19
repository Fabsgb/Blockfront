package com.boehmod.blockfront;

import com.boehmod.blockfront.C0066cj;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cm.class */
public class C0069cm extends AbstractC0070cn {
    private static final int dP = 16;
    private static final int dQ = 128;

    @Nonnull
    public static final ObjectList<C0066cj.b> p = new ObjectArrayList();

    @Nonnull
    public static final ObjectList<a> q = new ObjectArrayList();

    @Nonnull
    private static final ResourceLocation aA = C0265jv.d("textures/gui/overlay/bloodoverlay.png");

    @Nonnull
    private static final ResourceLocation aB = C0265jv.d("textures/gui/overlay/tunnelvision.png");

    @Nonnull
    private static final ResourceLocation aC = C0265jv.d("textures/misc/muzzleflash/whiteflash_big.png");

    @Nonnull
    private static final ResourceLocation aD = C0265jv.d("textures/gui/overlay/damage.png");

    @Nonnull
    private static final Vec3 j = new Vec3(94.0d, 0.0d, 0.0d);

    private static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull LocalPlayer localPlayer, int i, int i2, float f) {
        if (hN.o.T()) {
            float f2 = -localPlayer.getViewYRot(f);
            ObjectListIterator it = q.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                float fA = 180.0f + aVar.a(localPlayer, f) + f2;
                Vec3 vec3YRot = j.yRot((float) Math.toRadians(-fA));
                C0040bk.b(poseStack, guiGraphics, aD, (float) (((double) (i / 2.0f)) + vec3YRot.x), (float) (((double) (i2 / 2.0f)) + vec3YRot.z), 16.0f, 128.0f, 90.0f + fA, aVar.g(f));
            }
        }
    }

    private void d(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        ObjectListIterator it = p.iterator();
        while (it.hasNext()) {
            ((C0066cj.b) it.next()).c(poseStack, guiGraphics, i, i2, f);
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2, float f3, float f4) {
        if (hN.w.T()) {
            C0040bk.a(poseStack, guiGraphics, aA, 0, 0, i, i2, 0.0f, C0634xm.e(aY.bZ, aY.ca, f4));
            if (f <= 8.0f) {
                C0040bk.a(poseStack, guiGraphics, aA, 0, 0, i, i2, 0.0f, (0.5f - (0.1f * Mth.sin(f3 / 5.0f))) * (1.0f - f2));
            }
        }
        C0040bk.a(poseStack, guiGraphics, aB, 0, 0, i, i2, 0.0f, C0634xm.e(aY.cb, aY.cc, f4));
    }

    private void a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        if (!hN.L.T() || !minecraft.options.getCameraType().isFirstPerson()) {
            return;
        }
        int i3 = i / 2;
        int i4 = i2 / 2;
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        Item item = mainHandItem.getItem();
        if (item instanceof C0558ur) {
            uH uHVarM1208a = ((C0558ur) item).m1208a(mainHandItem);
            int i5 = C0558ur.hR ? 0 : 1;
            int i6 = (i3 / 4) * i5;
            int i7 = (i4 / 4) * i5;
            if (!minecraft.getDebugOverlay().showDebugScreen()) {
                if (C0558ur.rU <= 0) {
                    return;
                }
                if (C0558ur.hR && uHVarM1208a.go != null) {
                    return;
                }
            }
            C0040bk.b(poseStack, guiGraphics, aC, i3 + i6, i4 + i7, rB.pJ, rB.pJ, 0.0f, 0.5f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0070cn
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0297l c0297l) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        float fG = C0040bk.g();
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        float maxHealth = localPlayer.getMaxHealth();
        float health = localPlayer.getHealth();
        float f = health / maxHealth;
        float gameTimeDeltaPartialTick = deltaTracker.getGameTimeDeltaPartialTick(true);
        a(poseStackPose, guiGraphics, localPlayer, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        a(minecraft, localPlayer, poseStackPose, guiGraphics, iGuiWidth, iGuiHeight);
        d(poseStackPose, guiGraphics, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        a(poseStackPose, guiGraphics, iGuiWidth, iGuiHeight, health, f, fG, gameTimeDeltaPartialTick);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.cm$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cm$a.class */
    public static class a {
        private final Vec3 k;
        private float aD;
        private float aE;

        public a(float f, Vec3 vec3) {
            this.aD = f;
            this.aE = f;
            this.k = vec3;
        }

        public boolean k() {
            this.aE = this.aD;
            this.aD -= 0.05f;
            return this.aD + this.aE <= 0.0f;
        }

        public float a(LocalPlayer localPlayer, float f) {
            return C0634xm.a(localPlayer.getPosition(f), this.k);
        }

        public float g(float f) {
            return C0634xm.e(this.aD, this.aE, f);
        }
    }
}
