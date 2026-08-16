package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cO.class */
public class C0151cO extends C0144cH {

    /* JADX INFO: renamed from: cE */
    private static final Component f1178cE = Component.translatable("bf.screen.screenshot");

    /* JADX INFO: renamed from: aU */
    private static final ResourceLocation f1179aU = C0532jO.m2378d("screenshot");

    /* JADX INFO: renamed from: a */
    private final NativeImage f1180a;

    public C0151cO(@NotNull NativeImage nativeImage) {
        super(f1178cE);
        TextureManager textureManager = this.f1058a.getTextureManager();
        this.f1180a = nativeImage;
        textureManager.release(f1179aU);
        textureManager.register(f1179aU, new DynamicTexture(nativeImage));
    }

    @Override // com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        int i3;
        int i4;
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int width = this.f1180a.getWidth();
        int height = this.f1180a.getHeight();
        float f2 = (this.width - 20.0f) / width;
        float f3 = (this.height - 20.0f) / height;
        if (height * f2 > this.height - 20) {
            i3 = (int) (height * f3);
            i4 = (int) (width * f3);
        } else {
            i3 = (int) (height * f2);
            i4 = (int) (width * f2);
        }
        int i5 = this.width / 2;
        int i6 = this.height / 2;
        float f4 = i4 / 1.25f;
        float f5 = i3 / 1.25f;
        float f6 = i5 - (f4 / 2.0f);
        float f7 = i6 - (f5 / 2.0f);
        C0129bt.m517a(guiGraphics, 0, 0, this.width, this.height, 0, 0.75f);
        C0129bt.m514a(poseStackPose, guiGraphics, f6 - 1.0f, f7 - 1.0f, f4 + 2.0f, f5 + 2.0f, ColorReferences.COLOR_BLACK_SOLID);
        C0129bt.m530a(poseStackPose, guiGraphics, f1179aU, f6, f7, f4, f5);
        C0129bt.m482c(poseStackPose, this.font, guiGraphics, f1178cE, i5, (i6 - (f5 / 2.0f)) - 15.0f);
    }

    public void onClose() {
        super.onClose();
        this.f1058a.getTextureManager().release(f1179aU);
    }
}
