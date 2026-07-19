package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.Nullable;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bU.class */
public abstract class bU<G extends oF<G, P, ?>, P extends oI<G>> extends bV<G, P> {

    @Nullable
    private ResourceLocation T = null;

    public void a(@Nullable ResourceLocation resourceLocation) {
        this.T = resourceLocation;
    }

    @Override // com.boehmod.blockfront.bV, com.boehmod.blockfront.AbstractC0063cg
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.a(guiGraphics, poseStack, font, i, i2, f);
        if (this.T == null) {
            return;
        }
        C0040bk.a(poseStack, guiGraphics, this.T, i + 3, i2 + 2, 11, 11);
    }

    @Override // com.boehmod.blockfront.bV
    protected void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2) {
        super.a(guiGraphics, poseStack, font, i + (this.T != null ? 7 : 0), i2);
    }

    @Override // com.boehmod.blockfront.bV, com.boehmod.blockfront.AbstractC0063cg
    public int a(@NotNull Font font) {
        return super.a(font) + (this.T != null ? 12 : 0);
    }
}
