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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cF.class */
public class cF extends C0081cy {
    private static final Component cC = Component.translatable("bf.screen.screenshot");
    private static final ResourceLocation aW = C0265jv.d("screenshot");
    private final NativeImage a;

    public cF(@NotNull NativeImage nativeImage) {
        super(cC);
        TextureManager textureManager = this.b.getTextureManager();
        this.a = nativeImage;
        textureManager.release(aW);
        textureManager.register(aW, new DynamicTexture(nativeImage));
    }

    @Override // com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        int i3;
        int i4;
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int width = this.a.getWidth();
        int height = this.a.getHeight();
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
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, 0, 0.75f);
        C0040bk.a(poseStackPose, guiGraphics, f6 - 1.0f, f7 - 1.0f, f4 + 2.0f, f5 + 2.0f, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(poseStackPose, guiGraphics, aW, f6, f7, f4, f5);
        C0040bk.c(poseStackPose, this.font, guiGraphics, cC, i5, (i6 - (f5 / 2.0f)) - 15.0f);
    }

    public void onClose() {
        super.onClose();
        this.b.getTextureManager().release(aW);
    }
}
