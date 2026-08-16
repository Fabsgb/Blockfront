package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tp.class */
public abstract class AbstractC1090tp {

    /* JADX INFO: renamed from: fn */
    @NotNull
    public static final ResourceLocation f5863fn = C0532jO.m2378d("textures/gui/effects/fade.png");

    /* JADX INFO: renamed from: tj */
    public static final int f5864tj = 128;

    /* JADX INFO: renamed from: B */
    private final UUID f5865B;

    /* JADX INFO: renamed from: C */
    private final UUID f5866C;

    /* JADX INFO: renamed from: tk */
    private int f5867tk;

    /* JADX INFO: renamed from: c */
    private Vec3 f5868c;

    /* JADX INFO: renamed from: hD */
    private boolean f5869hD = false;

    @NotNull
    public abstract ResourceLocation getIcon();

    /* JADX INFO: renamed from: ca */
    public abstract int mo5976ca();

    /* JADX INFO: renamed from: cb */
    public abstract int mo5977cb();

    /* JADX INFO: renamed from: a */
    public abstract int mo5978a(@NotNull AbstractC0864pc<?, ?> abstractC0864pc, float f);

    /* JADX INFO: renamed from: dg */
    protected abstract void mo5980dg();

    public AbstractC1090tp(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        this.f5865B = uuid;
        this.f5866C = uuid2;
        this.f5868c = vec3;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public UUID m5969h() {
        return this.f5865B;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public UUID m5970i() {
        return this.f5866C;
    }

    /* JADX INFO: renamed from: o */
    public void m5971o(@NotNull Vec3 vec3) {
        this.f5868c = vec3;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Vec3 m5972c() {
        return this.f5868c;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo5973a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0864pc<?, ?> abstractC0864pc) {
        int i = this.f5867tk;
        this.f5867tk = i + 1;
        return i < mo5976ca();
    }

    /* JADX INFO: renamed from: a */
    public void m5974a(@NotNull AbstractC0864pc<?, ?> abstractC0864pc, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f) {
    }

    /* JADX INFO: renamed from: a */
    public void m5975a(@NotNull AbstractC0864pc<?, ?> abstractC0864pc, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, int i, int i2, float f) {
        Vec3 vec3M5972c = m5972c();
        int iMo5977cb = mo5977cb();
        int i3 = iMo5977cb + 128;
        C0129bt.f fVarM647a = C0129bt.m647a(vec3M5972c, camera, i, i2, 32, f);
        poseStack.pushPose();
        poseStack.translate(fVarM647a.m694h(), fVarM647a.m695i(), 0.0f);
        C0129bt.m545b(poseStack, guiGraphics, f5863fn, 0, 0, i3, i3, 1.0f, mo5978a(abstractC0864pc, f));
        C0129bt.m539b(poseStack, guiGraphics, getIcon(), 0, 0, iMo5977cb);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: df */
    public void m5979df() {
        if (this.f5869hD) {
            return;
        }
        this.f5869hD = true;
        mo5980dg();
    }

    /* JADX INFO: renamed from: cb */
    public boolean m5981cb() {
        return this.f5869hD;
    }
}
