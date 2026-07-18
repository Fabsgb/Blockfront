package com.boehmod.blockfront;

import com.boehmod.blockfront.C0119bk;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sS.class */
public abstract class AbstractC1012sS {

    /* JADX INFO: renamed from: fo */
    @NotNull
    public static final ResourceLocation f5299fo = C0564jv.m2555d("textures/gui/effects/fade.png");

    /* JADX INFO: renamed from: ri */
    public static final int f5300ri = 128;

    /* JADX INFO: renamed from: B */
    private final UUID f5301B;

    /* JADX INFO: renamed from: C */
    private final UUID f5302C;

    /* JADX INFO: renamed from: rj */
    private int f5303rj;

    /* JADX INFO: renamed from: c */
    private Vec3 f5304c;

    /* JADX INFO: renamed from: hj */
    private boolean f5305hj = false;

    @NotNull
    public abstract ResourceLocation getIcon();

    /* JADX INFO: renamed from: bL */
    public abstract int mo5488bL();

    /* JADX INFO: renamed from: bM */
    public abstract int mo5489bM();

    /* JADX INFO: renamed from: a */
    public abstract int mo5490a(@NotNull AbstractC0788oG<?, ?> abstractC0788oG, float f);

    /* JADX INFO: renamed from: cU */
    protected abstract void mo5492cU();

    public AbstractC1012sS(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        this.f5301B = uuid;
        this.f5302C = uuid2;
        this.f5304c = vec3;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public UUID m5481h() {
        return this.f5301B;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public UUID m5482i() {
        return this.f5302C;
    }

    /* JADX INFO: renamed from: o */
    public void m5483o(@NotNull Vec3 vec3) {
        this.f5304c = vec3;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Vec3 m5484c() {
        return this.f5304c;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo5485a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull AbstractC0788oG<?, ?> abstractC0788oG) {
        int i = this.f5303rj;
        this.f5303rj = i + 1;
        return i < mo5488bL();
    }

    /* JADX INFO: renamed from: a */
    public void m5486a(@NotNull AbstractC0788oG<?, ?> abstractC0788oG, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f) {
    }

    /* JADX INFO: renamed from: a */
    public void m5487a(@NotNull AbstractC0788oG<?, ?> abstractC0788oG, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, int i, int i2, float f) {
        Vec3 vec3M5484c = m5484c();
        int iMo5489bM = mo5489bM();
        int i3 = iMo5489bM + 128;
        C0119bk.f fVarM544a = C0119bk.m544a(vec3M5484c, camera, i, i2, 32, f);
        poseStack.pushPose();
        poseStack.translate(fVarM544a.m589h(), fVarM544a.m590i(), 0.0f);
        C0119bk.m445b(poseStack, guiGraphics, f5299fo, 0, 0, i3, i3, 1.0f, mo5490a(abstractC0788oG, f));
        C0119bk.m439b(poseStack, guiGraphics, getIcon(), 0, 0, iMo5489bM);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: cT */
    public void m5491cT() {
        if (this.f5305hj) {
            return;
        }
        this.f5305hj = true;
        mo5492cU();
    }

    /* JADX INFO: renamed from: bR */
    public boolean m5493bR() {
        return this.f5305hj;
    }
}
