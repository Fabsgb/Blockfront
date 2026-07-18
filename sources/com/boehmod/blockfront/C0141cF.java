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

/* JADX INFO: renamed from: com.boehmod.blockfront.cF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cF.class */
public class C0141cF extends C0196cy {

    /* JADX INFO: renamed from: cC */
    private static final Component f1088cC = Component.translatable("bf.screen.screenshot");

    /* JADX INFO: renamed from: aW */
    private static final ResourceLocation f1089aW = C0564jv.m2555d("screenshot");

    /* JADX INFO: renamed from: a */
    private final NativeImage f1090a;

    public C0141cF(@NotNull NativeImage nativeImage) {
        super(f1088cC);
        TextureManager textureManager = this.f1587b.getTextureManager();
        this.f1090a = nativeImage;
        textureManager.release(f1089aW);
        textureManager.register(f1089aW, new DynamicTexture(nativeImage));
    }

    @Override // com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        int i3;
        int i4;
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int width = this.f1090a.getWidth();
        int height = this.f1090a.getHeight();
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
        C0119bk.m417a(guiGraphics, 0, 0, this.width, this.height, 0, 0.75f);
        C0119bk.m414a(poseStackPose, guiGraphics, f6 - 1.0f, f7 - 1.0f, f4 + 2.0f, f5 + 2.0f, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m430a(poseStackPose, guiGraphics, f1089aW, f6, f7, f4, f5);
        C0119bk.m382c(poseStackPose, this.font, guiGraphics, f1088cC, i5, (i6 - (f5 / 2.0f)) - 15.0f);
    }

    public void onClose() {
        super.onClose();
        this.f1587b.getTextureManager().release(f1089aW);
    }
}
