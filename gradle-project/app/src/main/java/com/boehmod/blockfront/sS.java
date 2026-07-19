package com.boehmod.blockfront;

import com.boehmod.blockfront.C0040bk;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sS.class */
public abstract class sS {

    @NotNull
    public static final ResourceLocation fo = C0265jv.d("textures/gui/effects/fade.png");
    public static final int ri = 128;
    private final UUID B;
    private final UUID C;
    private int rj;
    private Vec3 c;
    private boolean hj = false;

    @NotNull
    public abstract ResourceLocation getIcon();

    public abstract int bL();

    public abstract int bM();

    public abstract int a(@NotNull oG<?, ?> oGVar, float f);

    protected abstract void cU();

    public sS(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        this.B = uuid;
        this.C = uuid2;
        this.c = vec3;
    }

    @NotNull
    public UUID h() {
        return this.B;
    }

    @NotNull
    public UUID i() {
        return this.C;
    }

    public void o(@NotNull Vec3 vec3) {
        this.c = vec3;
    }

    @NotNull
    public Vec3 c() {
        return this.c;
    }

    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull oG<?, ?> oGVar) {
        int i = this.rj;
        this.rj = i + 1;
        return i < bL();
    }

    public void a(@NotNull oG<?, ?> oGVar, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f) {
    }

    public void a(@NotNull oG<?, ?> oGVar, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, int i, int i2, float f) {
        Vec3 vec3C = c();
        int iBM = bM();
        int i3 = iBM + 128;
        C0040bk.f fVarA = C0040bk.a(vec3C, camera, i, i2, 32, f);
        poseStack.pushPose();
        poseStack.translate(fVarA.h(), fVarA.i(), 0.0f);
        C0040bk.b(poseStack, guiGraphics, fo, 0, 0, i3, i3, 1.0f, a(oGVar, f));
        C0040bk.b(poseStack, guiGraphics, getIcon(), 0, 0, iBM);
        poseStack.popPose();
    }

    public void cT() {
        if (this.hj) {
            return;
        }
        this.hj = true;
        cU();
    }

    public boolean bR() {
        return this.hj;
    }
}
